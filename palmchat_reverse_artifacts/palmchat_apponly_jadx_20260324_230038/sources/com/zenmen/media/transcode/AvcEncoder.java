package com.zenmen.media.transcode;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.ss.android.ttvecamera.TECameraSettings;
import defpackage.ed6;
import defpackage.g13;
import defpackage.pu1;
import defpackage.x86;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"NewApi"})
public class AvcEncoder implements Runnable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int AVC_BITRATE = 2018;
    private static final String TAG = "MeidaCodec";
    private static int UNKNOWN_COLORFORMAT = -1;
    private static int m_suppotedColorFormat = -1;
    private static MediaCodec mediaCodec = null;
    public byte[] configbyte;
    int m_framerate;
    int m_height;
    ByteBuffer m_sharedInputbuffer;
    ByteBuffer m_sharedOutputbuffer;
    int m_width;
    private static int yuvqueuesize = 10;
    public static ArrayBlockingQueue<MediaDataStruct> YUVQueue = new ArrayBlockingQueue<>(yuvqueuesize);
    public static ArrayBlockingQueue<MediaDataStruct> outputQueue = new ArrayBlockingQueue<>(20);
    private static int minMediaCodecAPILevel = 16;
    private int TIMEOUT_USEC = 10000;
    boolean m_isdumpfile = false;
    int videoTrackIndex = -1;
    long m_currentPresentTime = 0;
    String mp4Dumppath = "/sdcard/mp4Encoded.mp4";
    private boolean bFatalError = false;
    public boolean isRuning = false;
    int count = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class ColorFormatSelectPolicy {
        private String[] reverseColorDevices;

        private boolean isReverseColorDevice() {
            boolean z = false;
            for (String str : this.reverseColorDevices) {
                if (str.equals(x86.b() + " " + x86.c())) {
                    z = true;
                }
            }
            return z;
        }

        public List<Integer> get(boolean z) {
            if (!z) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(2135033992);
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList();
            if (isReverseColorDevice()) {
                arrayList2.add(21);
                arrayList2.add(20);
                arrayList2.add(19);
                return arrayList2;
            }
            arrayList2.add(19);
            arrayList2.add(20);
            arrayList2.add(21);
            return arrayList2;
        }

        private ColorFormatSelectPolicy() {
            this.reverseColorDevices = new String[]{"HUAWEI H60-L01 4.4.2", "HUAWEI GRA-UL10 5.0.1"};
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class MediaDataStruct {
        public byte[] data;
        public int isKey;
        public long pts;

        public MediaDataStruct() {
        }
    }

    private void NV21ToNV12(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3;
        if (bArr == null || bArr2 == null) {
            return;
        }
        int i4 = i * i2;
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        for (int i5 = 0; i5 < i4; i5++) {
            bArr2[i5] = bArr[i5];
        }
        int i6 = 0;
        while (true) {
            i3 = i4 / 2;
            if (i6 >= i3) {
                break;
            }
            int i7 = i4 + i6;
            bArr2[i7 - 1] = bArr[i7];
            i6 += 2;
        }
        for (int i8 = 0; i8 < i3; i8 += 2) {
            int i9 = i4 + i8;
            bArr2[i9] = bArr[i9 - 1];
        }
    }

    private void NV21ToYUV420P(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr == null || bArr2 == null) {
            return;
        }
        int i3 = i * i2;
        int i4 = 0;
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i5] = bArr[i5];
        }
        while (true) {
            int i6 = i3 / 4;
            if (i4 >= i6) {
                return;
            }
            int i7 = i4 * 2;
            bArr2[i6 + i3 + i4] = bArr[i7 + i3];
            bArr2[i3 + i4] = bArr[i7 + 1 + i3];
            i4++;
        }
    }

    @SuppressLint({"NewApi"})
    private void StopEncoder() {
        MediaCodec mediaCodec2 = mediaCodec;
        if (mediaCodec2 != null) {
            try {
                mediaCodec2.stop();
                mediaCodec.release();
                mediaCodec = null;
                outputQueue.clear();
                YUVQueue.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] colorFormatExchange(byte[] bArr, int i, int i2) {
        int i3 = m_suppotedColorFormat;
        if (i3 == 19) {
            byte[] bArr2 = new byte[((i * i2) * 3) / 2];
            NV21ToYUV420P(bArr, bArr2, i, i2);
            return bArr2;
        }
        if (i3 != 21) {
            return null;
        }
        byte[] bArr3 = new byte[((i * i2) * 3) / 2];
        NV21ToNV12(bArr, bArr3, i, i2);
        return bArr3;
    }

    private long computePresentationTime(long j) {
        return ((j * 1000000) / ((long) this.m_framerate)) + 132;
    }

    private static int initMediaCodec(int i, int i2, int i3, int i4) {
        MediaCodec mediaCodec2 = mediaCodec;
        if (mediaCodec2 != null) {
            mediaCodec2.release();
            mediaCodec = null;
        }
        m_suppotedColorFormat = UNKNOWN_COLORFORMAT;
        int i5 = 0;
        List<Integer> list = new ColorFormatSelectPolicy().get(false);
        boolean z = false;
        while (i5 < list.size()) {
            int iIntValue = list.get(i5).intValue();
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
            mediaFormatCreateVideoFormat.setInteger(IMediaFormat.KEY_COLOR_FORMAT, iIntValue);
            mediaFormatCreateVideoFormat.setInteger("bitrate", i3 * 1000);
            mediaFormatCreateVideoFormat.setInteger(IMediaFormat.KEY_FRAME_RATE, i4);
            mediaFormatCreateVideoFormat.setInteger(IMediaFormat.KEY_I_FRAME_INTERVAL, 1);
            mediaFormatCreateVideoFormat.setInteger(IMediaFormat.KEY_PROFILE, 8);
            mediaFormatCreateVideoFormat.setInteger("level", 2048);
            mediaFormatCreateVideoFormat.setInteger(IMediaFormat.KEY_BITRATE_MODE, 1);
            try {
                MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("video/avc");
                mediaCodec = mediaCodecCreateEncoderByType;
                mediaCodecCreateEncoderByType.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            } catch (IOException e) {
                e = e;
            } catch (IllegalArgumentException e2) {
                e = e2;
            } catch (NullPointerException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
            if (z) {
                m_suppotedColorFormat = iIntValue;
            } else {
                int integer = mediaCodec.getInputFormat().getInteger(IMediaFormat.KEY_COLOR_FORMAT);
                m_suppotedColorFormat = integer;
                int i6 = -1;
                if (integer == 2135033992) {
                    try {
                        list = new ColorFormatSelectPolicy().get(true);
                        z = true;
                    } catch (IOException e5) {
                        e = e5;
                        i5 = -1;
                        z = true;
                        e.printStackTrace();
                        i6 = i5;
                    } catch (IllegalArgumentException e6) {
                        e = e6;
                        i5 = -1;
                        z = true;
                        e.printStackTrace();
                        i6 = i5;
                    } catch (NullPointerException e7) {
                        e = e7;
                        i5 = -1;
                        z = true;
                        e.printStackTrace();
                        i6 = i5;
                    } catch (Exception e8) {
                        e = e8;
                        i5 = -1;
                        z = true;
                        e.printStackTrace();
                        i6 = i5;
                    }
                    i5 = i6 + 1;
                } else if (ed6.a() != -1) {
                    m_suppotedColorFormat = ed6.a();
                }
            }
            return m_suppotedColorFormat;
        }
        return m_suppotedColorFormat;
    }

    public static int isMediaCodecSupported(int i) {
        if (Build.VERSION.SDK_INT < i) {
            return -1;
        }
        return initMediaCodec(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, TECameraSettings.FPS_480, 307200, 15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putOutputData(byte[] bArr, int i, long j, int i2) {
        if (outputQueue.size() >= 20) {
            outputQueue.poll();
        }
        MediaDataStruct mediaDataStruct = new MediaDataStruct();
        mediaDataStruct.data = (byte[]) bArr.clone();
        mediaDataStruct.pts = j / 1000;
        mediaDataStruct.isKey = i2;
        outputQueue.add(mediaDataStruct);
    }

    private int putYUVData(byte[] bArr, int i, long j) {
        if (YUVQueue.size() >= yuvqueuesize) {
            return -1;
        }
        MediaDataStruct mediaDataStruct = new MediaDataStruct();
        byte[] bArr2 = new byte[i];
        mediaDataStruct.data = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i);
        mediaDataStruct.pts = j * 1000;
        YUVQueue.add(mediaDataStruct);
        return 0;
    }

    public void StartEncoderThread() {
        if (this.isRuning || mediaCodec == null) {
            return;
        }
        new g13(new Runnable() { // from class: com.zenmen.media.transcode.AvcEncoder.1
            @Override // java.lang.Runnable
            @SuppressLint({"NewApi"})
            public void run() {
                MediaDataStruct mediaDataStructPoll;
                AvcEncoder.this.isRuning = true;
                long j = 0;
                byte[] bArr = null;
                while (AvcEncoder.this.isRuning) {
                    if (bArr == null && AvcEncoder.YUVQueue.size() > 0 && (mediaDataStructPoll = AvcEncoder.YUVQueue.poll()) != null) {
                        bArr = mediaDataStructPoll.data;
                        j = mediaDataStructPoll.pts;
                    }
                    long j2 = j;
                    byte[] bArr2 = bArr;
                    if (bArr2 != null) {
                        try {
                            int iDequeueInputBuffer = AvcEncoder.mediaCodec.dequeueInputBuffer(AvcEncoder.this.TIMEOUT_USEC);
                            if (iDequeueInputBuffer >= 0) {
                                ByteBuffer inputBuffer = AvcEncoder.mediaCodec.getInputBuffer(iDequeueInputBuffer);
                                inputBuffer.clear();
                                inputBuffer.put(bArr2);
                                AvcEncoder.mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, bArr2.length, j2, 0);
                                bArr2 = null;
                            }
                            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                            int iDequeueOutputBuffer = AvcEncoder.mediaCodec.dequeueOutputBuffer(bufferInfo, AvcEncoder.this.TIMEOUT_USEC);
                            while (iDequeueOutputBuffer >= 0) {
                                ByteBuffer outputBuffer = AvcEncoder.mediaCodec.getOutputBuffer(iDequeueOutputBuffer);
                                int i = bufferInfo.size;
                                byte[] bArr3 = new byte[i];
                                outputBuffer.get(bArr3);
                                int i2 = bufferInfo.flags;
                                if (i2 == 2) {
                                    AvcEncoder avcEncoder = AvcEncoder.this;
                                    avcEncoder.configbyte = new byte[bufferInfo.size];
                                    avcEncoder.configbyte = bArr3;
                                    avcEncoder.putOutputData(bArr3, i, 0L, 2);
                                } else if (i2 == 1 || (i2 & 1) == 1) {
                                    AvcEncoder.this.putOutputData(bArr3, i, bufferInfo.presentationTimeUs, 1);
                                } else {
                                    AvcEncoder.this.putOutputData(bArr3, i, bufferInfo.presentationTimeUs, 0);
                                }
                                AvcEncoder.mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                iDequeueOutputBuffer = AvcEncoder.mediaCodec.dequeueOutputBuffer(bufferInfo, AvcEncoder.this.TIMEOUT_USEC);
                            }
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                            AvcEncoder.this.bFatalError = true;
                            AvcEncoder.this.isRuning = false;
                            Log.e(AvcEncoder.TAG, "MediaCodec fatal error and exist the thread");
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else {
                        try {
                            Thread.sleep(20L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    bArr = bArr2;
                    j = j2;
                }
            }
        }).start();
    }

    public void StopThread() {
        this.isRuning = false;
        try {
            StopEncoder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getClassName() throws Throwable {
        FileWriter fileWriter;
        Throwable th;
        Exception e;
        try {
            fileWriter = new FileWriter("/sdcard/palmchat/cc.txt");
            try {
                try {
                    fileWriter.write(getClass().getName().replace('.', '/'));
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                pu1.u(fileWriter);
                throw th;
            }
        } catch (Exception e3) {
            fileWriter = null;
            e = e3;
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
            pu1.u(fileWriter);
            throw th;
        }
        pu1.u(fileWriter);
    }

    public int getColorFormat() {
        return m_suppotedColorFormat;
    }

    public byte[] getOutputData(int[] iArr, long[] jArr, int[] iArr2) {
        if (outputQueue.size() <= 0) {
            return null;
        }
        MediaDataStruct mediaDataStructPoll = outputQueue.poll();
        byte[] bArr = mediaDataStructPoll.data;
        iArr[0] = bArr.length;
        jArr[0] = mediaDataStructPoll.pts;
        iArr2[0] = mediaDataStructPoll.isKey;
        return bArr;
    }

    @SuppressLint({"NewApi"})
    public int init(int i, int i2, int i3, int i4) {
        this.m_width = i;
        this.m_height = i2;
        this.m_framerate = i3;
        if (Build.VERSION.SDK_INT < minMediaCodecAPILevel || ed6.e() || initMediaCodec(this.m_width, this.m_height, i4, this.m_framerate) == -1 || m_suppotedColorFormat == UNKNOWN_COLORFORMAT || mediaCodec == null) {
            return -1;
        }
        Log.i("AvcEncoder", "Init MediaCodec");
        try {
            mediaCodec.start();
            this.m_sharedInputbuffer = ByteBuffer.allocateDirect(((this.m_width * this.m_height) * 3) / 2);
            this.m_sharedOutputbuffer = ByteBuffer.allocateDirect(((this.m_width * this.m_height) * 3) / 2);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean isBufferRemained() {
        return outputQueue.size() > 0 || YUVQueue.size() > 0;
    }

    public int setInputData(byte[] bArr, int i, long j) {
        if (this.bFatalError) {
            return -2;
        }
        return putYUVData(bArr, i, j);
    }

    public boolean setParam(int i, int i2) {
        if (i != AVC_BITRATE) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("video-bitrate", i2);
        mediaCodec.setParameters(bundle);
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
    }
}
