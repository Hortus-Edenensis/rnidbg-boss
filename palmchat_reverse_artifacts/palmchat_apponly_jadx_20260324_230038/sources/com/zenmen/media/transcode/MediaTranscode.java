package com.zenmen.media.transcode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.zenmen.media.extractor.ZMMediaExtractor;
import defpackage.lg2;
import defpackage.pu1;
import java.io.FileInputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class MediaTranscode implements IMediaTranscode {
    private static final int MAX_VIDEO_HEIGHT = 2160;
    private static final int MAX_VIDEO_WIDTH = 3840;
    private static final String MP4_FTYP = "ftyp";
    private static final String MP4_MAJOR_BRAND_QT = "qt";
    private static final String TAG = "ZMM MediaTranscode";
    private static boolean mNativeLoaded = true;
    boolean isReleased = false;
    private CodecFormatCheckListener mCodecFormatCheckListener;
    private Handler mHander;
    private long mNativeTranscodePara;
    private long mTimeEnd;
    private long mTimeStart;
    private ITranscodeNotify mTransItf;
    private HandlerThread mWorkingThread;
    private MediaTranscodePassThrough mediaTranscodePassThrough;

    /* JADX INFO: compiled from: SearchBox */
    public class NativeEvent {
        public static final int MSG_NONE = 0;
        public static final int MSG_TRANSCODE_FAILURE = 206;
        public static final int MSG_TRANSCODE_FILE_OPEN = 200;
        public static final int MSG_TRANSCODE_FINISH = 203;
        public static final int MSG_TRANSCODE_PERCENT = 205;
        public static final int MSG_TRANSCODE_START = 201;
        public static final int MSG_TRANSCODE_STOP = 202;
        public static final int MSG_TRANSCODE_UNSURPPORT = 210;
        public static final int MSG_TRANSCODE_W_H = 204;

        public NativeEvent() {
        }
    }

    static {
        try {
            System.loadLibrary("osal");
            System.loadLibrary("AACEnc");
            System.loadLibrary("H264Enc");
            System.loadLibrary("H264Dec");
            System.loadLibrary("AACDec");
            System.loadLibrary("MediaCodecJDec");
            System.loadLibrary("zmmediaplayer");
            System.loadLibrary("MediaTransCode");
        } catch (Exception e) {
            mNativeLoaded = false;
            e.printStackTrace();
        }
    }

    public MediaTranscode(boolean z) {
        this.mediaTranscodePassThrough = null;
        if (mNativeLoaded) {
            nativeTranscodeSetup(this);
            if (z) {
                tryEnableHWDecoder();
            }
            HandlerThread handlerThreadA = lg2.a("MediaTransCode_work_thread");
            this.mWorkingThread = handlerThreadA;
            handlerThreadA.start();
            this.mHander = new Handler(this.mWorkingThread.getLooper()) { // from class: com.zenmen.media.transcode.MediaTranscode.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    MediaTranscode mediaTranscode = MediaTranscode.this;
                    if (mediaTranscode.isReleased) {
                        Log.e("VideoProcessor", "transcode has released :" + message.what);
                        return;
                    }
                    int i = message.what;
                    if (i == 200) {
                        if (mediaTranscode.mCodecFormatCheckListener != null) {
                            MediaTranscode.this.mCodecFormatCheckListener.onCodecFormatSupport(true);
                            return;
                        }
                        return;
                    }
                    if (i == 201) {
                        mediaTranscode.mTimeStart = System.currentTimeMillis();
                        return;
                    }
                    if (i == 203) {
                        mediaTranscode.mTimeEnd = System.currentTimeMillis();
                        Log.e(MediaTranscode.TAG, "transcode costs : " + ((MediaTranscode.this.mTimeEnd - MediaTranscode.this.mTimeStart) / 1000) + " s");
                        if (MediaTranscode.this.mTransItf != null) {
                            MediaTranscode.this.mTransItf.onTranscodeFinish((MediaTranscode.this.mTimeEnd - MediaTranscode.this.mTimeStart) / 1000);
                            return;
                        }
                        return;
                    }
                    if (i == 210) {
                        if (mediaTranscode.mCodecFormatCheckListener != null) {
                            MediaTranscode.this.mCodecFormatCheckListener.onCodecFormatSupport(false);
                        }
                        Log.e(MediaTranscode.TAG, "MSG_TRANSCODE_UNSURPPORT");
                    } else {
                        if (i != 205) {
                            if (i != 206) {
                                return;
                            }
                            if (mediaTranscode.mTransItf != null) {
                                MediaTranscode.this.mTransItf.onTranscodeFailure(message.arg1);
                            }
                            Log.e(MediaTranscode.TAG, "MSG_TRANSCODE_FAILURE");
                            return;
                        }
                        Log.e(MediaTranscode.TAG, "transcode process :" + message.arg1);
                        if (MediaTranscode.this.mTransItf != null) {
                            MediaTranscode.this.mTransItf.onTranscodePercent(message.arg1);
                        }
                    }
                }
            };
            if (z) {
                MediaTranscodePassThrough mediaTranscodePassThrough = new MediaTranscodePassThrough();
                this.mediaTranscodePassThrough = mediaTranscodePassThrough;
                mediaTranscodePassThrough.setHandler(this.mHander);
            }
        }
    }

    public static int getVideoCodec(String str) {
        if (!mNativeLoaded) {
            return -1;
        }
        ZMMediaExtractor zMMediaExtractor = new ZMMediaExtractor(str);
        if (zMMediaExtractor.g() != 0) {
            return 0;
        }
        int iE = zMMediaExtractor.e();
        zMMediaExtractor.a();
        return iE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean isQuickTimeFormat(String str) throws Throwable {
        FileInputStream fileInputStream;
        boolean z = false;
        if (!mNativeLoaded) {
            return false;
        }
        ?? r1 = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused) {
        }
        try {
            byte[] bArr = new byte[4];
            byte[] bArr2 = new byte[2];
            fileInputStream.skip(4L);
            fileInputStream.read(bArr, 0, 4);
            fileInputStream.read(bArr2, 0, 2);
            if (Arrays.equals(bArr, MP4_FTYP.getBytes())) {
                if (Arrays.equals(bArr2, MP4_MAJOR_BRAND_QT.getBytes())) {
                    z = true;
                }
            }
            pu1.u(fileInputStream);
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            Log.w(TAG, "Warning: error on handling the MetaDataRetriever");
            pu1.u(fileInputStream2);
        } catch (Throwable th2) {
            th = th2;
            r1 = fileInputStream;
            pu1.u(r1);
            throw th;
        }
        StringBuilder sb = new StringBuilder();
        r1 = "Is QuickTime : ";
        sb.append("Is QuickTime : ");
        sb.append(z ? "yes" : "no");
        Log.i(TAG, sb.toString());
        return z;
    }

    public static int isSupportedMediaFile(String str) {
        int i;
        int i2;
        int i3;
        if (!mNativeLoaded) {
            return -3;
        }
        int i4 = -1;
        if (isQuickTimeFormat(str)) {
            return -1;
        }
        int videoCodec = 0;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            Log.i(TAG, "video width = " + strExtractMetadata + " height = " + strExtractMetadata2);
            mediaMetadataRetriever.release();
            i = Integer.parseInt(strExtractMetadata);
            try {
                i2 = Integer.parseInt(strExtractMetadata2);
                i3 = i * i2 > 8294400 ? -2 : 0;
            } catch (NumberFormatException unused) {
                Log.w(TAG, "Warning: convert the string to int failed");
                i2 = 0;
                i3 = -1;
            } catch (Exception unused2) {
                Log.w(TAG, "Warning: error on handling the MetaDataRetriever");
                i2 = 0;
                i3 = -1;
            }
        } catch (NumberFormatException unused3) {
            i = 0;
        } catch (Exception unused4) {
            i = 0;
        }
        if (i3 == 0 && (videoCodec = getVideoCodec(str)) != 2 && videoCodec != 1) {
            i3 = -1;
        }
        if (i3 != 0 || videoCodec != 1 || (Build.VERSION.SDK_INT >= 24 && searchMCDecoderByMime("video/hevc"))) {
            i4 = i3;
        }
        Log.i(TAG, "Support Resolution:" + i + "x" + i2 + ", codec: " + videoCodec + "? return  code:" + i4);
        return i4;
    }

    private native void nativeGetPicture(long j, Object obj);

    private native void nativeGetPictureAtTime(long j, Object obj, long j2);

    private native long nativeGetSrcDuration(long j);

    private native int nativeGetVideoHeight(long j);

    private native int nativeGetVideoWidth(long j);

    private native void nativeSetBlendPicture(long j, Object obj);

    private native void nativeTranscodeEnableHWDec(long j);

    private native int nativeTranscodeGetPercent(long j);

    private native void nativeTranscodeRelease(long j);

    private native int nativeTranscodeSetDstUrl(long j, String str, int i);

    private native int nativeTranscodeSetFileProp(long j, int i, int i2);

    private native int nativeTranscodeSetSrcUrl(long j, String str, int i);

    private native int nativeTranscodeSetTimeRange(long j, long j2, long j3);

    private native int nativeTranscodeSetVideoPropo(long j, int i, int i2, int i3);

    private native void nativeTranscodeSetup(Object obj);

    private native int nativeTranscodeStart(long j, boolean z);

    private native void nativeTranscodeStop(long j);

    private static void postEventFromNative(Object obj, int i, int i2, int i3, int i4, int i5) {
        MediaTranscode mediaTranscode = (MediaTranscode) obj;
        if (mediaTranscode == null) {
            return;
        }
        Handler handler = mediaTranscode.mHander;
        if (handler != null) {
            mediaTranscode.mHander.sendMessage(handler.obtainMessage(i, i2, i3, null));
        }
        Log.e(TAG, "postEventFromNative: aMsg " + i + " aArg1 " + i2 + " aArg2 " + i3 + " aArg3 " + i4 + " aArg4 " + i5);
    }

    @TargetApi(16)
    private static boolean searchMCDecoderByMime(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void tryEnableHWDecoder() {
        if (mNativeLoaded && Build.VERSION.SDK_INT >= 24) {
            nativeTranscodeEnableHWDec(this.mNativeTranscodePara);
        }
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public void getBitmap(Bitmap bitmap) {
        if (mNativeLoaded) {
            MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
            if (mediaTranscodePassThrough != null) {
                mediaTranscodePassThrough.getBitmap(bitmap);
            }
            nativeGetPicture(this.mNativeTranscodePara, bitmap);
        }
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public void getFrameAtTime(Bitmap bitmap, long j) {
        if (mNativeLoaded) {
            MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
            if (mediaTranscodePassThrough != null) {
                mediaTranscodePassThrough.getFrameAtTime(bitmap, j);
            }
            nativeGetPictureAtTime(this.mNativeTranscodePara, bitmap, j);
        }
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int getPercent() {
        if (!mNativeLoaded) {
            return -1;
        }
        MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
        return mediaTranscodePassThrough != null ? mediaTranscodePassThrough.getPercent() : nativeTranscodeGetPercent(this.mNativeTranscodePara);
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public long getSrcDuration() {
        if (!mNativeLoaded) {
            return -1L;
        }
        MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
        if (mediaTranscodePassThrough != null) {
            mediaTranscodePassThrough.getSrcDuration();
        }
        return nativeGetSrcDuration(this.mNativeTranscodePara);
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int getVideoHeight() {
        if (!mNativeLoaded) {
            return -1;
        }
        MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
        return mediaTranscodePassThrough != null ? mediaTranscodePassThrough.getVideoHeight() : nativeGetVideoHeight(this.mNativeTranscodePara);
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int getVideoWidth() {
        if (!mNativeLoaded) {
            return -1;
        }
        MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
        return mediaTranscodePassThrough != null ? mediaTranscodePassThrough.getVideoWidth() : nativeGetVideoWidth(this.mNativeTranscodePara);
    }

    public void release() {
        if (mNativeLoaded) {
            synchronized (this) {
                this.isReleased = true;
                nativeTranscodeRelease(this.mNativeTranscodePara);
                this.mNativeTranscodePara = 0L;
                try {
                    HandlerThread handlerThread = this.mWorkingThread;
                    if (handlerThread != null) {
                        handlerThread.quit();
                    }
                    this.mWorkingThread = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.mediaTranscodePassThrough != null) {
                    this.mediaTranscodePassThrough = null;
                }
            }
        }
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public void setBlendPic(Bitmap bitmap) {
        if (mNativeLoaded && this.mediaTranscodePassThrough == null) {
            nativeSetBlendPicture(this.mNativeTranscodePara, bitmap);
        }
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int setDstUrl(String str, int i) {
        if (!mNativeLoaded) {
            return -1;
        }
        MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
        return mediaTranscodePassThrough != null ? mediaTranscodePassThrough.setDstUrl(str, i) : nativeTranscodeSetDstUrl(this.mNativeTranscodePara, str, i);
    }

    public int setFileProp(int i, int i2) {
        if (!mNativeLoaded) {
            return -1;
        }
        if (this.mediaTranscodePassThrough != null) {
            return 0;
        }
        return nativeTranscodeSetFileProp(this.mNativeTranscodePara, i, i2);
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int setSrcUrl(String str, CodecFormatCheckListener codecFormatCheckListener, int i) {
        if (!mNativeLoaded) {
            return -1;
        }
        this.mCodecFormatCheckListener = codecFormatCheckListener;
        MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
        if (mediaTranscodePassThrough != null) {
            int srcUrl = mediaTranscodePassThrough.setSrcUrl(str, codecFormatCheckListener, i);
            if (srcUrl == 5010) {
                Log.i(TAG, "Mode : pass-through tiny video ");
                return srcUrl;
            }
            this.mediaTranscodePassThrough = null;
            Log.i(TAG, "Mode : non pass-through normal video ");
        }
        return nativeTranscodeSetSrcUrl(this.mNativeTranscodePara, str, i);
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int setTimeRange(long j, long j2) {
        if (!mNativeLoaded) {
            return -1;
        }
        MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
        if (mediaTranscodePassThrough != null) {
            mediaTranscodePassThrough.setTimeRange(j, j2);
        }
        return nativeTranscodeSetTimeRange(this.mNativeTranscodePara, j, j2);
    }

    public void setTransItf(ITranscodeNotify iTranscodeNotify) {
        if (mNativeLoaded) {
            this.mTransItf = iTranscodeNotify;
        }
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int setVideoPropo(int i, int i2, int i3) {
        if (!mNativeLoaded) {
            return -1;
        }
        MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
        if (mediaTranscodePassThrough != null) {
            mediaTranscodePassThrough.setVideoPropo(i, i2, i3);
        }
        return nativeTranscodeSetVideoPropo(this.mNativeTranscodePara, i, i2, i3);
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public int start(boolean z) {
        if (!mNativeLoaded) {
            return -1;
        }
        MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
        return mediaTranscodePassThrough != null ? mediaTranscodePassThrough.start(z) : nativeTranscodeStart(this.mNativeTranscodePara, z);
    }

    @Override // com.zenmen.media.transcode.IMediaTranscode
    public void stop() {
        if (mNativeLoaded) {
            MediaTranscodePassThrough mediaTranscodePassThrough = this.mediaTranscodePassThrough;
            if (mediaTranscodePassThrough == null) {
                nativeTranscodeStop(this.mNativeTranscodePara);
            } else {
                mediaTranscodePassThrough.setHandler(null);
                this.mediaTranscodePassThrough.stop();
            }
        }
    }

    private static void postLogFromNative(Object obj, int i, Object obj2, Object obj3) {
    }
}
