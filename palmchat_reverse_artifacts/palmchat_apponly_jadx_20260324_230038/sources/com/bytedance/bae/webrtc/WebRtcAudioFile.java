package com.bytedance.bae.webrtc;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.igexin.assist.util.AssistUtils;
import com.kuaishou.weapon.p0.t;
import com.oplus.tblplayer.misc.IMediaFormat;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.Vector;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class WebRtcAudioFile {
    private static final int MAX_DECODER_RETRY_COUNT = 100;
    private static final String TAG = "WebRtcAudioRecordFile";
    private boolean eoInputStream;
    private boolean eoOutputStream;

    @Nullable
    private byte[] mDecodedData;

    @Nullable
    private MediaExtractor mExtractor;
    private long mFileLength;
    private ByteBuffer[] mInputBuffers;

    @Nullable
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private int mRetryCount;
    private Vector<Integer> mTrackIds;

    @Nullable
    private MediaFormat mUsedTrackFormat;
    private int mUsedTrackIdx;
    private HttpURLConnection oc;
    private int mSampleRate = 0;
    private int mChannels = 0;

    @CalledByNative
    public WebRtcAudioFile() {
        RXLogging.e(TAG, "AudioMix WebRtcAudioFile");
    }

    private boolean checkInfoChange() {
        try {
            MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
            int integer = outputFormat.getInteger("sample-rate");
            int integer2 = outputFormat.getInteger("channel-count");
            boolean z = (this.mSampleRate == integer && this.mChannels == integer2) ? false : true;
            this.mSampleRate = integer;
            this.mChannels = integer2;
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when checking file's new format");
            return false;
        }
    }

    private boolean checkUrlEncoded(String str) {
        try {
            return !TextUtils.equals(str, URLDecoder.decode(str, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when releasing audio file stream");
            return false;
        }
    }

    private String encodeUrl(String str) {
        RXLogging.e(TAG, "encodedUrl");
        try {
            URL url = new URL(str);
            return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private boolean isAvailableOnlineURL(String str) {
        boolean z;
        RXLogging.e(TAG, "isAvailableOnlineURL");
        this.oc = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                this.oc = httpURLConnection;
                httpURLConnection.setUseCaches(false);
                this.oc.setConnectTimeout(4000);
                RXLogging.e(TAG, "connect done....");
                int responseCode = this.oc.getResponseCode();
                if (200 == responseCode) {
                    z = true;
                } else {
                    RXLogging.e(TAG, "url is not available, error:" + responseCode);
                    z = false;
                }
                InputStream inputStream = this.oc.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection2 = this.oc;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                RXLogging.e(TAG, "++Error when test online url: " + e.getMessage());
                HttpURLConnection httpURLConnection3 = this.oc;
                if (httpURLConnection3 == null) {
                    return false;
                }
                httpURLConnection3.disconnect();
                return false;
            }
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection4 = this.oc;
            if (httpURLConnection4 != null) {
                httpURLConnection4.disconnect();
            }
            throw th;
        }
    }

    @CalledByNative
    public void disConnectURL() {
        RXLogging.e(TAG, "disConnectURL");
        HttpURLConnection httpURLConnection = this.oc;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @CalledByNative
    public int getAudioTrackCount() {
        Vector<Integer> vector = this.mTrackIds;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    @CalledByNative
    public int getChannelCount() {
        return this.mChannels;
    }

    @CalledByNative
    public long getCurrentFilePosition() {
        try {
            return this.mExtractor.getSampleTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when getCurrentFilePosition");
            return 0L;
        }
    }

    @Nullable
    @CalledByNative
    public byte[] getDecodedData() {
        return this.mDecodedData;
    }

    @CalledByNative
    public long getFileLength() {
        return this.mFileLength / 1000;
    }

    @CalledByNative
    public int getSampleRate() {
        return this.mSampleRate;
    }

    @CalledByNative
    public int getUsedTrackIdx() {
        return this.mUsedTrackIdx;
    }

    @CalledByNative
    public boolean init(String str, int i) {
        try {
            RXLogging.i(TAG, "Try to decode audio file : " + str);
            this.mTrackIds = new Vector<>();
            if (URLUtil.isNetworkUrl(str)) {
                if (!checkUrlEncoded(str)) {
                    str = encodeUrl(str);
                }
                if (str == null || !isAvailableOnlineURL(str)) {
                    return false;
                }
            }
            this.mRetryCount = 0;
            this.mExtractor = new MediaExtractor();
            Context applicationContext = ContextUtils.getApplicationContext();
            if (str.startsWith("/assets/") && applicationContext != null) {
                AssetFileDescriptor assetFileDescriptorOpenFd = applicationContext.getAssets().openFd(str.substring(8));
                this.mExtractor.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
            } else if (!str.startsWith("content://") || applicationContext == null) {
                this.mExtractor.setDataSource(str);
            } else {
                this.mExtractor.setDataSource(applicationContext.getContentResolver().openFileDescriptor(Uri.parse(str), t.k).getFileDescriptor());
            }
            int trackCount = this.mExtractor.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                this.mExtractor.unselectTrack(i2);
            }
            if (i + 1 > trackCount) {
                RXLogging.e(TAG, "useTrack > trackCount");
                return false;
            }
            this.mChannels = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < trackCount; i4++) {
                MediaFormat trackFormat = this.mExtractor.getTrackFormat(i4);
                String string = trackFormat.getString(IMediaFormat.KEY_MIME);
                if (string.contains("audio/")) {
                    if (i == i3) {
                        this.mExtractor.selectTrack(i4);
                        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(string);
                        this.mMediaCodec = mediaCodecCreateDecoderByType;
                        mediaCodecCreateDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                        this.mUsedTrackFormat = trackFormat;
                        this.mUsedTrackIdx = i3;
                    }
                    i3++;
                    this.mTrackIds.addElement(new Integer(i4));
                    int integer = trackFormat.getInteger("channel-count");
                    if (integer > this.mChannels) {
                        this.mChannels = integer;
                    }
                }
            }
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec == null) {
                RXLogging.e(TAG, "mMediaCodec is null");
                return false;
            }
            mediaCodec.start();
            this.mSampleRate = this.mUsedTrackFormat.getInteger("sample-rate");
            this.mFileLength = this.mUsedTrackFormat.getLong(IMediaFormat.KEY_DURATION);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when creating audio file decode, error:" + e.getMessage());
            RXLogging.e(TAG, "stack track: " + Log.getStackTraceString(e));
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0112 A[Catch: Exception -> 0x0159, TryCatch #0 {Exception -> 0x0159, blocks: (B:3:0x0004, B:5:0x0008, B:8:0x000e, B:10:0x0016, B:12:0x001c, B:14:0x002a, B:16:0x002f, B:18:0x003f, B:19:0x0041, B:20:0x004d, B:22:0x0051, B:28:0x0068, B:30:0x006c, B:32:0x0072, B:33:0x0074, B:37:0x0089, B:38:0x0094, B:40:0x0099, B:41:0x00be, B:44:0x00d6, B:43:0x00c4, B:45:0x00dd, B:47:0x00e6, B:49:0x00f2, B:51:0x00fe, B:53:0x0108, B:55:0x0112, B:56:0x0147, B:57:0x0151, B:58:0x0156), top: B:64:0x0004 }] */
    @CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean readAudioData() {
        MediaCodec mediaCodec;
        int iDequeueInputBuffer;
        int i;
        try {
            mediaCodec = this.mMediaCodec;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mediaCodec != null && this.mExtractor != null) {
            if (!this.eoInputStream && (iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L)) >= 0) {
                int sampleData = this.mExtractor.readSampleData(this.mMediaCodec.getInputBuffer(iDequeueInputBuffer), 0);
                if (sampleData <= 0) {
                    this.eoInputStream = true;
                    i = 0;
                } else {
                    i = sampleData;
                }
                long sampleTime = this.mExtractor.getSampleTime();
                int sampleFlags = this.mExtractor.getSampleFlags();
                if (this.eoInputStream) {
                    sampleFlags |= 4;
                }
                this.mMediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, i, sampleTime, sampleFlags);
                this.mExtractor.advance();
            }
            if (!this.eoOutputStream) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int iDequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                this.mDecodedData = null;
                if (iDequeueOutputBuffer == -3 || iDequeueOutputBuffer == -2) {
                    this.mDecodedData = new byte[0];
                } else if (iDequeueOutputBuffer != -1) {
                    this.mRetryCount = 0;
                    if (iDequeueOutputBuffer >= 0) {
                        if ((bufferInfo.flags & 4) == 4) {
                            this.eoOutputStream = true;
                        }
                        ByteBuffer outputBuffer = this.mMediaCodec.getOutputBuffer(iDequeueOutputBuffer);
                        int integer = this.mUsedTrackFormat.getInteger("channel-count");
                        int i2 = this.mChannels;
                        if (integer != i2 && i2 == 2) {
                            this.mDecodedData = new byte[outputBuffer.limit() * 2];
                            for (int i3 = 0; i3 < bufferInfo.size / 2; i3++) {
                                int i4 = i3 * 4;
                                this.mDecodedData[i4] = outputBuffer.get();
                                byte[] bArr = this.mDecodedData;
                                bArr[i4 + 2] = bArr[i4];
                                int i5 = i4 + 1;
                                bArr[i5] = outputBuffer.get();
                                byte[] bArr2 = this.mDecodedData;
                                bArr2[i4 + 3] = bArr2[i5];
                            }
                            outputBuffer.clear();
                        } else if (integer == i2) {
                            byte[] bArr3 = new byte[outputBuffer.limit()];
                            this.mDecodedData = bArr3;
                            outputBuffer.get(bArr3, bufferInfo.offset, bufferInfo.size);
                            outputBuffer.clear();
                        }
                        this.mMediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    }
                } else {
                    int i6 = this.mRetryCount + 1;
                    this.mRetryCount = i6;
                    if (i6 >= 100) {
                        String str = Build.BRAND;
                        if (!str.toLowerCase().contains(AssistUtils.BRAND_MZ)) {
                            String str2 = Build.MANUFACTURER;
                            if (str2.toLowerCase().contains(AssistUtils.BRAND_MZ) || str.toLowerCase().contains("vivo") || str2.toLowerCase().contains("vivo")) {
                                RXLogging.e(TAG, "EAGAIN count=" + this.mRetryCount + " presentationTimeUs=" + bufferInfo.presentationTimeUs + " totalUs=" + this.mFileLength + " Force EOS");
                                this.eoOutputStream = true;
                                this.mRetryCount = 0;
                            }
                        }
                    }
                    this.mDecodedData = new byte[0];
                    Thread.sleep(3L);
                }
            }
            return this.eoOutputStream;
        }
        return this.eoInputStream;
    }

    @CalledByNative
    public void selectTrack(int i) {
        try {
            Vector<Integer> vector = this.mTrackIds;
            if (vector == null || i + 1 > vector.size() || this.mUsedTrackIdx == i) {
                return;
            }
            MediaExtractor mediaExtractor = this.mExtractor;
            if (mediaExtractor != null && this.mMediaCodec != null) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(this.mTrackIds.get(i).intValue());
                if (this.mSampleRate != trackFormat.getInteger("sample-rate")) {
                    RXLogging.e(TAG, "mSampleRate = " + this.mSampleRate + ", used_SampleRate = " + trackFormat.getInteger("sample-rate"));
                    return;
                }
                long sampleTime = this.mExtractor.getSampleTime();
                RXLogging.e(TAG, "++current_postion = " + sampleTime);
                this.mExtractor.unselectTrack(this.mTrackIds.get(this.mUsedTrackIdx).intValue());
                this.mMediaCodec.stop();
                trackFormat.getString(IMediaFormat.KEY_MIME);
                this.mExtractor.selectTrack(this.mTrackIds.get(i).intValue());
                this.mExtractor.seekTo(sampleTime, 2);
                this.mMediaCodec.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                this.mMediaCodec.start();
                this.mUsedTrackFormat = trackFormat;
                this.mUsedTrackIdx = i;
                return;
            }
            RXLogging.e(TAG, "mExtractor or mMediaCodec is null, mExtractor = " + this.mExtractor + ", mMediaCodec = " + this.mMediaCodec);
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when selectTrack");
        }
    }

    @CalledByNative
    public void setCurrentFilePosition(long j) {
        if (this.eoOutputStream) {
            try {
                this.mMediaCodec.flush();
            } catch (Exception e) {
                e.printStackTrace();
                RXLogging.e(TAG, "Error when setCurrentFilePosition, mMediaCodec.flush");
            }
        }
        try {
            this.mExtractor.seekTo(j * 1000, 2);
            this.eoInputStream = false;
            this.eoOutputStream = false;
        } catch (Exception e2) {
            e2.printStackTrace();
            RXLogging.e(TAG, "Error when setCurrentFilePosition, mExtractor.seekTo");
        }
    }

    @CalledByNative
    public void uninit() {
        try {
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            }
            MediaExtractor mediaExtractor = this.mExtractor;
            if (mediaExtractor != null) {
                mediaExtractor.release();
                this.mExtractor = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when releasing audio file stream" + e.getMessage());
        }
        this.eoOutputStream = false;
        this.eoInputStream = false;
    }
}
