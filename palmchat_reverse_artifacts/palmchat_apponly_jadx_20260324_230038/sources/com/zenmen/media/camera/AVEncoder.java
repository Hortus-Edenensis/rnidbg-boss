package com.zenmen.media.camera;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Environment;
import android.util.Log;
import android.view.Surface;
import com.oplus.tblplayer.misc.IMediaFormat;
import defpackage.ed6;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@SuppressLint({"NewApi"})
public class AVEncoder {
    private static String TAG = "AVEncoder";
    private NativeWrap mNative;
    int m_abitrate;
    int m_channel;
    int m_color;
    int m_framerate;
    int m_height;
    int m_samplerate;
    int m_vbitrate;
    int m_width;
    private MediaCodec mediaCodec = null;
    int m_limit = 0;
    int m_videoCount = 0;
    int mFinalOrientation = 0;
    FileOutputStream mf = null;
    private byte[] m_inputAudio = null;
    byte[] packet = new byte[7];
    boolean m_Config = false;
    boolean bAVCMultiSliceDev = false;
    boolean dumpfile = false;
    boolean m_bStarted = false;

    public AVEncoder(NativeWrap nativeWrap) {
        this.mNative = nativeWrap;
    }

    private void addADTStoPacket(int i) {
        byte[] bArr = this.packet;
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) 80;
        bArr[3] = (byte) (128 + (i >> 11));
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }

    public void audioEncodeInit() {
        try {
            this.mediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString(IMediaFormat.KEY_MIME, "audio/mp4a-latm");
            mediaFormat.setInteger(IMediaFormat.KEY_AAC_PROFILE, 2);
            mediaFormat.setInteger("channel-count", this.m_channel);
            mediaFormat.setInteger("sample-rate", this.m_samplerate);
            mediaFormat.setInteger("bitrate", this.m_abitrate);
            this.mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"NewApi"})
    public void close() {
        try {
            MediaCodec mediaCodec = this.mediaCodec;
            if (mediaCodec != null) {
                if (this.m_bStarted) {
                    mediaCodec.stop();
                }
                this.mediaCodec.release();
                this.mediaCodec = null;
            }
            FileOutputStream fileOutputStream = this.mf;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.mf = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0074 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:13:0x0065, B:14:0x006a, B:16:0x0074, B:19:0x0079, B:26:0x008b, B:32:0x00bc, B:27:0x0098, B:29:0x009c, B:31:0x00b4), top: B:39:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:13:0x0065, B:14:0x006a, B:16:0x0074, B:19:0x0079, B:26:0x008b, B:32:0x00bc, B:27:0x0098, B:29:0x009c, B:31:0x00b4), top: B:39:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009c A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:13:0x0065, B:14:0x006a, B:16:0x0074, B:19:0x0079, B:26:0x008b, B:32:0x00bc, B:27:0x0098, B:29:0x009c, B:31:0x00b4), top: B:39:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:13:0x0065, B:14:0x006a, B:16:0x0074, B:19:0x0079, B:26:0x008b, B:32:0x00bc, B:27:0x0098, B:29:0x009c, B:31:0x00b4), top: B:39:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int feedDataToAudioEncoder(byte[] bArr, long j) {
        int i;
        MediaCodec.BufferInfo bufferInfo;
        int iDequeueOutputBuffer;
        ByteBuffer byteBuffer;
        int i2;
        int i3;
        int i4 = 0;
        try {
            ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = this.mediaCodec.getOutputBuffers();
            int iDequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(-1L);
            if (iDequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer2 = inputBuffers[iDequeueInputBuffer];
                byteBuffer2.clear();
                try {
                    if (this.m_limit == 0) {
                        int iLimit = byteBuffer2.limit();
                        this.m_limit = iLimit;
                        if (bArr.length > iLimit) {
                            byte[] bArr2 = new byte[iLimit];
                            this.m_inputAudio = bArr2;
                            System.arraycopy(bArr, 0, bArr2, 0, iLimit);
                            byteBuffer2.put(this.m_inputAudio);
                            this.mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, this.m_limit, j * 1000, 0);
                            i = this.m_limit;
                            bufferInfo = new MediaCodec.BufferInfo();
                            while (true) {
                                iDequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                                if (iDequeueOutputBuffer >= 0 && (byteBuffer = outputBuffers[iDequeueOutputBuffer]) != null) {
                                    i2 = bufferInfo.size;
                                    byte[] bArr3 = new byte[i2];
                                    byteBuffer.get(bArr3);
                                    i3 = bufferInfo.flags;
                                    if (i3 != 0 || i3 == 1) {
                                        if (this.dumpfile) {
                                            addADTStoPacket(i2 + 7);
                                            this.mf.write(this.packet);
                                            this.mf.write(bArr3);
                                            this.mf.flush();
                                        }
                                        if (i2 <= 0) {
                                            this.mNative.sendAudioPacket(bArr3, i2, bufferInfo.presentationTimeUs / 1000);
                                        }
                                    } else if (i3 == 2) {
                                        Log.e(TAG, "set audio config ");
                                        this.mNative.sendAudioConfig(bArr3, i2);
                                    }
                                    this.mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                }
                                return i;
                            }
                        }
                        byteBuffer2.put(bArr);
                        this.mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, bArr.length, j * 1000, 0);
                    } else {
                        byteBuffer2.put(bArr);
                        this.mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, bArr.length, j * 1000, 0);
                    }
                    bufferInfo = new MediaCodec.BufferInfo();
                    while (true) {
                        iDequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                        if (iDequeueOutputBuffer >= 0) {
                            return i;
                        }
                        i2 = bufferInfo.size;
                        byte[] bArr32 = new byte[i2];
                        byteBuffer.get(bArr32);
                        i3 = bufferInfo.flags;
                        if (i3 != 0) {
                            if (this.dumpfile) {
                            }
                            if (i2 <= 0) {
                            }
                        }
                        this.mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    }
                } catch (Throwable th) {
                    th = th;
                    i4 = i;
                }
                i = 0;
            } else {
                i = 0;
                bufferInfo = new MediaCodec.BufferInfo();
                while (true) {
                    iDequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                    if (iDequeueOutputBuffer >= 0) {
                    }
                    this.mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        Log.e(TAG, " -- exception happen! --");
        th.printStackTrace();
        return i4;
    }

    @SuppressLint({"NewApi"})
    public int feedDataToVideoEncoder(byte[] bArr, long j) {
        ByteBuffer byteBuffer;
        byte[] bArr2;
        try {
            ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = this.mediaCodec.getOutputBuffers();
            int iDequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(1000L);
            this.m_videoCount++;
            if (iDequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer2 = inputBuffers[iDequeueInputBuffer];
                byteBuffer2.clear();
                byteBuffer2.put(bArr);
                this.mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, bArr.length, j * 1000, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            while (true) {
                int iDequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                if (iDequeueOutputBuffer < 0 || (byteBuffer = outputBuffers[iDequeueOutputBuffer]) == null) {
                    break;
                }
                int i = bufferInfo.size;
                byte[] bArr3 = new byte[i];
                byteBuffer.get(bArr3);
                int i2 = bufferInfo.flags;
                if (i2 == 2) {
                    this.m_Config = true;
                    Log.e(TAG, "set video config ");
                    if (this.bAVCMultiSliceDev) {
                        int i3 = this.mFinalOrientation;
                        if (i3 == 0 || i3 == 180) {
                            this.mNative.sendVideoConfig(bArr3, i, 90);
                        } else {
                            this.mNative.sendVideoConfig(bArr3, i, 0);
                        }
                    } else {
                        this.mNative.sendVideoConfig(bArr3, i, this.mFinalOrientation);
                    }
                } else {
                    if (i2 == 1 || (i2 & 1) == 1) {
                        bArr2 = bArr3;
                        if (i > 0) {
                            this.mNative.sendVideoPacket(bArr2, bufferInfo.size, bufferInfo.presentationTimeUs / 1000, 1);
                        }
                    } else if (i > 0) {
                        bArr2 = bArr3;
                        this.mNative.sendVideoPacket(bArr3, bufferInfo.size, bufferInfo.presentationTimeUs / 1000, 0);
                    }
                    if (!this.dumpfile && i > 0) {
                        try {
                            this.mf.write(bArr2);
                            this.mf.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    this.mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                }
                bArr2 = bArr3;
                if (!this.dumpfile) {
                }
                this.mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    public boolean initMC(boolean z) {
        int i;
        int i2;
        int i3;
        try {
            this.mNative.setColorFormat(this.m_color);
            this.mNative.setDstVideoWidthHeight(this.m_width, this.m_height);
            this.mediaCodec = MediaCodec.createEncoderByType("video/avc");
            int i4 = this.mFinalOrientation;
            if (i4 == 90 || i4 == 270) {
                i = this.m_width;
                i2 = this.m_height;
            } else {
                i2 = this.m_width;
                i = this.m_height;
            }
            boolean zD = ed6.d();
            this.bAVCMultiSliceDev = zD;
            if (zD && ((i3 = this.mFinalOrientation) == 0 || i3 == 180)) {
                i2 = this.m_height;
                i = this.m_width;
            }
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i);
            mediaFormatCreateVideoFormat.setInteger("bitrate", this.m_vbitrate);
            mediaFormatCreateVideoFormat.setInteger(IMediaFormat.KEY_FRAME_RATE, this.m_framerate);
            int i5 = this.m_color;
            if (i5 > 0) {
                mediaFormatCreateVideoFormat.setInteger(IMediaFormat.KEY_COLOR_FORMAT, i5);
            }
            mediaFormatCreateVideoFormat.setInteger(IMediaFormat.KEY_I_FRAME_INTERVAL, 1);
            if (!z) {
                mediaFormatCreateVideoFormat.setInteger(IMediaFormat.KEY_PROFILE, 8);
                mediaFormatCreateVideoFormat.setInteger("level", 2048);
            }
            this.mediaCodec.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            try {
                int integer = mediaFormatCreateVideoFormat.getInteger("bitrate");
                int integer2 = mediaFormatCreateVideoFormat.getInteger(IMediaFormat.KEY_PROFILE);
                int integer3 = mediaFormatCreateVideoFormat.getInteger(IMediaFormat.KEY_FRAME_RATE);
                Log.e(TAG, "video encoder key params: kBitrate = " + integer + " kProfile = " + integer2 + " kFrameRate " + integer3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } catch (Exception e2) {
            Log.e(TAG, " parameter error !");
            e2.printStackTrace();
            return false;
        }
    }

    public void setAudioParameter(int i, int i2, int i3) {
        this.m_samplerate = i;
        this.m_channel = i2;
        this.m_abitrate = i3;
        try {
            if (this.dumpfile) {
                File file = new File(Environment.getExternalStorageDirectory(), "a2");
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                this.mf = new FileOutputStream(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVideoInfo(int i, int i2, int i3, int i4) {
        this.m_width = i;
        this.m_height = i2;
        this.m_framerate = i3;
        this.m_vbitrate = i4;
        try {
            if (this.dumpfile) {
                File file = new File(Environment.getExternalStorageDirectory(), "h2");
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                this.mf = new FileOutputStream(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean start() {
        try {
            this.mediaCodec.start();
            this.m_bStarted = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean videoEncodeInit(int i, int i2) {
        this.m_color = i;
        this.mFinalOrientation = i2;
        Log.e(TAG, " m_color = " + this.m_color + " w = " + this.m_width + " h = " + this.m_height);
        boolean zInitMC = initMC(false);
        return !zInitMC ? initMC(true) : zInitMC;
    }
}
