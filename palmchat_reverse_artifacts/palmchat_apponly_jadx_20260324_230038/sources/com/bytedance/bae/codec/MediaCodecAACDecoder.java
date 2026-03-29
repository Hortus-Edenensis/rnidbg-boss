package com.bytedance.bae.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.base.RXLogging;
import com.oplus.tblplayer.misc.IMediaFormat;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MediaCodecAACDecoder {
    private static final int MAX_WAITING_TIME = 300;
    private static final String TAG = "MediaCodecAACDecoder";
    private byte[] mAsc;
    private MediaCodec.BufferInfo mBufferInfo;

    @Nullable
    private byte[] mDecodedData;
    private ByteBuffer[] mInputBuffers;
    private ByteBuffer[] mOutputBuffers;
    private MediaFormat mOutputFormat;
    private String mMimeType = "audio/mp4a-latm";
    private int mSampleRate = 44100;
    private int mChannels = 1;
    private int mProfile = 2;
    private int mHasADTS = 0;
    private long input_ts = 0;
    private long output_ts = 0;
    private MediaCodec mAACDecoder = null;

    @CalledByNative
    public MediaCodecAACDecoder() {
        RXLogging.e(TAG, "MediaCodecAAC Decoder Created");
    }

    @Nullable
    private void genAsc() {
        int i;
        int i2 = this.mProfile;
        int i3 = 4;
        if (i2 == 2) {
            this.mAsc = new byte[2];
        } else {
            this.mAsc = new byte[4];
        }
        int i4 = this.mSampleRate;
        if (48000 == i4) {
            i3 = 3;
            i = 6;
        } else if (44100 == i4) {
            i = 7;
        } else if (32000 == i4) {
            i3 = 5;
            i = 8;
        } else {
            i3 = 0;
            i = 0;
        }
        int i5 = this.mChannels;
        int i6 = 1 == i5 ? 1 : 2 == i5 ? 2 : 0;
        byte b = (byte) i2;
        if (2 == i2) {
            byte[] bArr = this.mAsc;
            bArr[0] = (byte) ((b << 3) | (i3 >> 1));
            bArr[1] = (byte) ((i3 << 7) | (i6 << 3));
        } else {
            if (5 == i2) {
                byte[] bArr2 = this.mAsc;
                bArr2[0] = (byte) ((b << 3) | (i >> 1));
                bArr2[1] = (byte) ((i << 7) | (i6 << 3) | (i3 >> 1));
                bArr2[2] = (byte) ((i3 << 7) | 8);
                bArr2[3] = 0;
                return;
            }
            if (29 == i2) {
                byte[] bArr3 = this.mAsc;
                bArr3[0] = (byte) ((b << 3) | (i >> 1));
                bArr3[1] = (byte) ((i << 7) | 8 | (i3 >> 1));
                bArr3[2] = (byte) ((i3 << 7) | 8);
                bArr3[3] = 0;
            }
        }
    }

    @CalledByNative
    public void closeDecoder() {
        try {
            MediaCodec mediaCodec = this.mAACDecoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mAACDecoder.release();
                this.mAACDecoder = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "close AAC decoder failed");
        }
    }

    @CalledByNative
    public boolean configAndStartDecoder() {
        try {
            MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannels);
            mediaFormatCreateAudioFormat.setInteger(IMediaFormat.KEY_AAC_PROFILE, this.mProfile);
            mediaFormatCreateAudioFormat.setInteger(IMediaFormat.KEY_IS_ADTS, this.mHasADTS);
            mediaFormatCreateAudioFormat.setInteger(IMediaFormat.KEY_AAC_MAX_OUTPUT_CHANNEL_COUNT, this.mChannels);
            genAsc();
            mediaFormatCreateAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(this.mAsc));
            this.mAACDecoder.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 0);
            this.mAACDecoder.start();
            this.mBufferInfo = new MediaCodec.BufferInfo();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            closeDecoder();
            RXLogging.e(TAG, "Config and Start Decoder Error");
            return false;
        }
    }

    @CalledByNative
    public boolean decodeProcess(byte[] bArr) {
        try {
            MediaCodec mediaCodec = this.mAACDecoder;
            if (mediaCodec == null) {
                return false;
            }
            this.mDecodedData = null;
            int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(300L);
            if (iDequeueInputBuffer >= 0) {
                ByteBuffer inputBuffer = this.mAACDecoder.getInputBuffer(iDequeueInputBuffer);
                inputBuffer.clear();
                inputBuffer.put(bArr);
                this.mAACDecoder.queueInputBuffer(iDequeueInputBuffer, 0, bArr.length, (this.input_ts * 1000000) / ((long) this.mSampleRate), 0);
            }
            int iDequeueOutputBuffer = this.mAACDecoder.dequeueOutputBuffer(this.mBufferInfo, 0L);
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            int i = bufferInfo.size;
            if (i > 0 && iDequeueOutputBuffer >= 0) {
                this.output_ts = (bufferInfo.presentationTimeUs * ((long) this.mSampleRate)) / 1000000;
                ByteBuffer outputBuffer = this.mAACDecoder.getOutputBuffer(iDequeueOutputBuffer);
                byte[] bArr2 = new byte[i];
                this.mDecodedData = bArr2;
                MediaCodec.BufferInfo bufferInfo2 = this.mBufferInfo;
                outputBuffer.get(bArr2, bufferInfo2.offset, bufferInfo2.size);
                outputBuffer.clear();
                this.mOutputFormat = this.mAACDecoder.getOutputFormat(iDequeueOutputBuffer);
                this.mAACDecoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "AAC Decoder Decode failed");
            return false;
        }
    }

    @Nullable
    @CalledByNative
    public byte[] getDecodedData() {
        return this.mDecodedData;
    }

    @CalledByNative
    public int getOutputChannels() {
        return this.mOutputFormat.getInteger("channel-count");
    }

    @CalledByNative
    public int getOutputSampleRate() {
        return this.mOutputFormat.getInteger("sample-rate");
    }

    @CalledByNative
    public long getOutputTs() {
        return this.output_ts;
    }

    @CalledByNative
    public boolean openEncoder() {
        try {
            MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(this.mMimeType);
            this.mAACDecoder = mediaCodecCreateDecoderByType;
            return mediaCodecCreateDecoderByType != null;
        } catch (Exception e) {
            e.printStackTrace();
            this.mAACDecoder = null;
            RXLogging.e(TAG, "Open AAC Decoder failed");
            return false;
        }
    }

    @CalledByNative
    public void setADTSValue(int i) {
        this.mHasADTS = i;
    }

    @CalledByNative
    public void setChannelsValue(int i) {
        this.mChannels = i;
    }

    @CalledByNative
    public void setInputTs(long j) {
        this.input_ts = j;
    }

    @CalledByNative
    public void setProfileValue(String str) {
        if (str.equals("he_aac")) {
            this.mProfile = 5;
        } else if (str.equals("he_aac_v2")) {
            this.mProfile = 29;
        } else {
            this.mProfile = 2;
        }
    }

    @CalledByNative
    public void setSampeRateValue(int i) {
        this.mSampleRate = i;
    }
}
