package com.zenmen.media.camera;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NativeWrap {
    public static final int ENotifyNetBadCondition = 12;
    public static final int ENotifyOpenStart = 7;
    public static final int ENotifyOpenSucess = 5;
    public static final int ENotifyPictureTaken = 80;
    public static final int ENotifyReconn_OpenStart = 8;
    public static final int ENotifyReconn_OpenSucess = 9;
    public static final int ENotifyReconn_SokcetConnectFailed = 10;
    public static final int ENotifyReconn_StreamConnectFailed = 11;
    public static final int ENotifyRecord_DISPLAY_WXH = 20;
    public static final int ENotifyRecord_FILEFINSH_OK = 13;
    public static final int ENotifyRecord_FILEOPEN_FAIL = 15;
    public static final int ENotifyRecord_FILEOPEN_OK = 14;
    public static final int ENotifyRecord_START = 16;
    public static final int ENotifyServerIP = 6;
    public static final int ENotifySokcetConnectFailed = 2;
    public static final int ENotifyStreamConnectFailed = 3;
    public static final int ENotifyTransferError = 4;
    public static final int ENotifyUrlParseError = 1;
    private static long m_startPTS;
    private static String sdkVersion;
    private OnMediaNotifyEventListener mMediaNotifyEventListener;
    private OnMediaNotifyLogListener mMediaNotifyLogListener;
    private long mNativePara = 0;
    public long nativeObject = 0;
    private EventHandler mEventHandler = new EventHandler(this, Looper.myLooper());

    /* JADX INFO: compiled from: SearchBox */
    public enum CameraSinkParamID {
        CameraSinkParamID_Camera_SWAPED
    }

    /* JADX INFO: compiled from: SearchBox */
    public class EventHandler extends Handler {
        public EventHandler(NativeWrap nativeWrap, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (NativeWrap.this.mMediaNotifyEventListener != null) {
                NativeWrap.this.mMediaNotifyEventListener.onMediaNotify(message.what, message.arg1, message.arg2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMediaNotifyEventListener {
        void onMediaNotify(int i, int i2, int i3);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMediaNotifyLogListener {
        void onMediaNotifyLog(int i, Object obj, Object obj2);
    }

    static {
        try {
            System.loadLibrary("osal");
            System.loadLibrary("AACEnc");
            System.loadLibrary("AACDec");
            System.loadLibrary("H264Enc");
            System.loadLibrary("H264Dec");
            System.loadLibrary("MediaCodecJDec");
            System.loadLibrary("zmmediaplayer");
            System.loadLibrary("Camerasink");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        m_startPTS = 0L;
        sdkVersion = "1.0.0.1";
    }

    public NativeWrap() {
        nativeSetup(this);
    }

    public static String GetSDKVersion() {
        return sdkVersion;
    }

    private native void nativeClose(long j);

    private native void nativeGenerateGLRenderNative(long j, Object obj);

    private native void nativeGetLastPicture(long j, int[] iArr, int i);

    private native void nativeGetPicture(long j, int[] iArr, int i);

    private native void nativeHandleRawData(long j, byte[] bArr, int i, int i2);

    private native void nativeRelease(long j);

    private native void nativeResetRecord(long j);

    private native int nativeSendAudioConfig(long j, byte[] bArr, int i);

    private native void nativeSendAudioPacket(long j, byte[] bArr, int i, long j2);

    private native int nativeSendAudioRawData(long j, byte[] bArr, int i, long j2);

    private native int nativeSendPictureRawData(long j, byte[] bArr, int i, int i2);

    private native int nativeSendVideoConfig(long j, byte[] bArr, int i, int i2);

    private native int nativeSendVideoPacket(long j, byte[] bArr, int i, long j2, int i2);

    private native int nativeSendVideoRawData(long j, byte[] bArr, int i, long j2, int i2);

    private native void nativeSetAudioInfo(long j, int i, int i2, int i3);

    private native void nativeSetDstWidthHeight(long j, int i, int i2);

    private native void nativeSetFpsBitrate(long j, int i, int i2, int i3);

    private native void nativeSetPicNum(long j, int i);

    private native int nativeSetSinkFilePath(long j, String str, int i);

    private native void nativeSetSrcWidthHeight(long j, int i, int i2);

    private native void nativeSetVideoCodecType(long j, int i);

    private native void nativeSetcolorFormat(long j, int i);

    private native void nativeSetup(Object obj);

    private native int nativeStart(long j, boolean z, int i);

    private native void nativeStop(long j);

    private native void nativeVideoEncoderInit(long j);

    private static void postEventFromNative(Object obj, int i, int i2, int i3, int i4, int i5) {
        EventHandler eventHandler;
        NativeWrap nativeWrap = (NativeWrap) obj;
        if (nativeWrap == null || (eventHandler = nativeWrap.mEventHandler) == null) {
            return;
        }
        nativeWrap.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, null));
    }

    private static void postLogFromNative(Object obj, int i, Object obj2, Object obj3) {
        NativeWrap nativeWrap = (NativeWrap) obj;
        if (nativeWrap == null) {
            return;
        }
        nativeWrap.handleLogMessage(i, obj2, obj3);
    }

    public int CreateOpenGL(long j, int i, int i2) {
        return nativeCreateOpenGLNative(j, i, i2);
    }

    public void DrawNative(long j) {
        nativeDrawNative(j);
    }

    public void GenerateGLRender(Object obj) {
        nativeGenerateGLRenderNative(this.mNativePara, obj);
    }

    public void GetLastPicture(int[] iArr, int i) {
        nativeGetLastPicture(this.mNativePara, iArr, i);
    }

    public void GetPicture(int[] iArr, int i) {
        nativeGetPicture(this.mNativePara, iArr, i);
    }

    public void SetPicNum(int i) {
        nativeSetPicNum(this.mNativePara, i);
    }

    public void close() {
        nativeClose(this.mNativePara);
        this.mNativePara = 0L;
    }

    public void handleLogMessage(int i, Object obj, Object obj2) {
        OnMediaNotifyLogListener onMediaNotifyLogListener = this.mMediaNotifyLogListener;
        if (onMediaNotifyLogListener != null) {
            onMediaNotifyLogListener.onMediaNotifyLog(i, obj, obj2);
        }
    }

    public void handleRawData(byte[] bArr, int i, int i2) {
        nativeHandleRawData(this.mNativePara, bArr, i, i2);
    }

    public native int nativeCreateOpenGLNative(long j, int i, int i2);

    public native void nativeDrawNative(long j);

    public native int nativesetParam(long j, int i, Object obj);

    public void release() {
        synchronized (this) {
            nativeRelease(this.mNativePara);
            this.mNativePara = 0L;
        }
    }

    public void sendAudioConfig(byte[] bArr, int i) {
        nativeSendAudioConfig(this.mNativePara, bArr, i);
    }

    public void sendAudioPacket(byte[] bArr, int i, long j) {
        nativeSendAudioPacket(this.mNativePara, bArr, i, j);
    }

    public void sendAudioRawData(byte[] bArr, int i, long j) {
        nativeSendAudioRawData(this.mNativePara, bArr, i, j);
    }

    public void sendPictureRawData(byte[] bArr, int i, int i2) {
        nativeSendPictureRawData(this.mNativePara, bArr, i, i2);
    }

    public void sendVideoConfig(byte[] bArr, int i, int i2) {
        nativeSendVideoConfig(this.mNativePara, bArr, i, i2);
    }

    public void sendVideoPacket(byte[] bArr, int i, long j, int i2) {
        nativeSendVideoPacket(this.mNativePara, bArr, i, j, i2);
    }

    public void sendVideoRawData(byte[] bArr, int i, long j, int i2) {
        nativeSendVideoRawData(this.mNativePara, bArr, i, j, i2);
    }

    public void setAudioInfo(int i, int i2, int i3) {
        nativeSetAudioInfo(this.mNativePara, i, i2, i3);
    }

    public void setColorFormat(int i) {
        nativeSetcolorFormat(this.mNativePara, i);
    }

    public void setDstVideoWidthHeight(int i, int i2) {
        nativeSetDstWidthHeight(this.mNativePara, i, i2);
    }

    public void setOnMediaNotifyEventListener(OnMediaNotifyEventListener onMediaNotifyEventListener) {
        this.mMediaNotifyEventListener = onMediaNotifyEventListener;
    }

    public void setOnMediaNotifyLogListener(OnMediaNotifyLogListener onMediaNotifyLogListener) {
        this.mMediaNotifyLogListener = onMediaNotifyLogListener;
    }

    public int setParam(CameraSinkParamID cameraSinkParamID, Object obj) {
        return nativesetParam(this.mNativePara, cameraSinkParamID.ordinal(), obj);
    }

    public void setSinkFilePath(String str, int i) {
        nativeSetSinkFilePath(this.mNativePara, str, i);
    }

    public void setSrcVideoWidthHeight(int i, int i2) {
        nativeSetSrcWidthHeight(this.mNativePara, i, i2);
    }

    public void setVideoFpsBitrate(int i, int i2, int i3) {
        nativeSetFpsBitrate(this.mNativePara, i, i2, i3);
    }

    public int start(boolean z, int i) {
        return nativeStart(this.mNativePara, z, i);
    }

    public void stop() {
        nativeStop(this.mNativePara);
    }

    public void videoEncoderInit() {
        nativeVideoEncoderInit(this.mNativePara);
    }
}
