package com.zenmen.media.player;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import defpackage.g13;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ZMMediaPlayer implements IMediaPlayer {
    public static final int EContextNoFitWindow = 64;
    public static final int EContextNoLoop = 32;
    public static final int EContextUnMute = 16;
    public static final int EDECODER_DEFAULT = 0;
    public static final int EDECODER_SOFT = 1;
    public static final int MAX_SAMPLE_NUM = 1024;
    public static final int MEDIASTATUS_PAUSED = 3;
    public static final int MEDIASTATUS_PLAYING = 2;
    public static final int MEDIASTATUS_PREPARED = 5;
    public static final int MEDIASTATUS_STARTING = 1;
    public static final int MEDIASTATUS_STOPPED = 4;
    public static final int MEDIA_AUDIOFORMAT_CHANGED = 12;
    public static final int MEDIA_BUFFERING_DONE = 17;
    public static final int MEDIA_BUFFERING_START = 16;
    public static final int MEDIA_CACHE_COMPLETED = 23;
    public static final int MEDIA_CLOSE = 5;
    public static final int MEDIA_COMPLETE = 3;
    public static final int MEDIA_CONNECT_DONE = 19;
    public static final int MEDIA_CONTEXT_ARRIVED = 154;
    public static final int MEDIA_CONTEXT_EOS = 153;
    public static final int MEDIA_CONTEXT_ERROR = 160;
    public static final int MEDIA_CONTEXT_FIRSTFRAME = 151;
    public static final int MEDIA_CONTEXT_START = 150;
    public static final int MEDIA_CONTEXT_STOP = 152;
    public static final int MEDIA_DNS_DONE = 18;
    public static final int MEDIA_EXCEPTION = 6;
    public static final int MEDIA_HTTP_HEADER_RECEIVED = 20;
    public static final int MEDIA_NOP = 0;
    public static final int MEDIA_PAUSE = 4;
    public static final int MEDIA_PLAY = 2;
    public static final int MEDIA_PREFETCH_COMPLETED = 22;
    public static final int MEDIA_PREPARE = 1;
    public static final int MEDIA_SEEK_COMPLETED = 11;
    public static final int MEDIA_START_FIRST_FRAME = 25;
    public static final int MEDIA_START_OPEN = 24;
    public static final int MEDIA_START_RECEIVE_DATA = 21;
    public static final int MEDIA_UPDATE_DURATION = 7;
    public static final int MEDIA_VIDEOFORMAT_CHANGED = 13;
    private static final int MIN_HARDWARE_VOLUME = -990;
    public static final int MIN_SAMPLE_NUM = 256;
    public static final int OPEN_BUFFER = 1;
    public static final int OPEN_DEFAULT = 0;
    public static final int OPEN_PRE_LOADED = 4;
    public static final int OPEN_PRE_LOADING = 2;
    private static final float PERCENT = 0.01f;
    public static final int SEEK_CORRECT = 1;
    public static final int SEEK_FAST = 0;
    private static final String TAG = "ZMMediaPlayer";
    public static final int VIDEOCORN_LeftBottom = 2;
    public static final int VIDEOCORN_LeftTop = 1;
    public static final int VIDEOCORN_RightBottom = 8;
    public static final int VIDEOCORN_RightTop = 4;
    public static final int VIDEO_QUALITY_SWITCH_FAILED = 52;
    public static final int VIDEO_QUALITY_SWITCH_START = 50;
    public static final int VIDEO_QUALITY_SWITCH_SUCCESS = 51;
    public static final int ZMNotifyDebug = 3;
    public static final int ZMNotifyError = 1;
    public static final int ZMNotifyInfo = 0;
    public static final int ZMNotifyValue = 4;
    public static final int ZMNotifyWarning = 2;
    private static boolean mNativeLoaded = true;
    private static ZMMediaPlayer sZMMediaPlayer = null;
    private static String sdkVersion = "1.0.0.1";
    private EventHandler mEventHandler;
    private OnMediaPlayerNotifyEventListener mMediaPlayerNotifyEventListener;
    private OnMediaPlayerNotifyLogListener mMediaPlayerNotifyLogListener;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceView mSurfaceView;
    private boolean mPlayerReleased = false;
    private long mNativePlayerPara = 0;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mViewWidth = 0;
    private int mViewHeight = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class ErrorID {
        public static final int TTKErrAbort = -39;
        public static final int TTKErrAccessDenied = -21;
        public static final int TTKErrAlreadyExists = -11;
        public static final int TTKErrArgument = -6;
        public static final int TTKErrBadDescriptor = -38;
        public static final int TTKErrBadDriver = -27;
        public static final int TTKErrBadHandle = -8;
        public static final int TTKErrBadLibraryEntryPoint = -37;
        public static final int TTKErrBadName = -28;
        public static final int TTKErrBadPower = -42;
        public static final int TTKErrCancel = -3;
        public static final int TTKErrCommsBreak = -48;
        public static final int TTKErrCommsFrame = -30;
        public static final int TTKErrCommsLineFail = -29;
        public static final int TTKErrCommsOverrun = -31;
        public static final int TTKErrCommsParity = -32;
        public static final int TTKErrCompletion = -17;
        public static final int TTKErrCorrupt = -20;
        public static final int TTKErrCouldNotConnect = -34;
        public static final int TTKErrCouldNotDisconnect = -35;
        public static final int TTKErrDNSFailed = -73;
        public static final int TTKErrDied = -13;
        public static final int TTKErrDirFull = -43;
        public static final int TTKErrDisMounted = -24;
        public static final int TTKErrDisconnected = -36;
        public static final int TTKErrDiskFull = -26;
        public static final int TTKErrDivideByZero = -41;
        public static final int TTKErrEof = -25;
        public static final int TTKErrExtensionNotSupported = -47;
        public static final int TTKErrFilParseOutofRange = -60;
        public static final int TTKErrFileNotSupport = -58;
        public static final int TTKErrFileParserException = -56;
        public static final int TTKErrFileReadTimeout = -57;
        public static final int TTKErrFormatChanged = -70;
        public static final int TTKErrFormatIsDTS = -53;
        public static final int TTKErrFormatIsMP3 = -52;
        public static final int TTKErrGeneral = -2;
        public static final int TTKErrHandshakeFailed = -71;
        public static final int TTKErrHardwareNotAvailable = -44;
        public static final int TTKErrInUse = -14;
        public static final int TTKErrLocked = -22;
        public static final int TTKErrNeedWait = -63;
        public static final int TTKErrNetWorkAbnormallDisconneted = -64;
        public static final int TTKErrNoMemory = -4;
        public static final int TTKErrNoSecureTime = -49;
        public static final int TTKErrNone = 0;
        public static final int TTKErrNotFound = -1;
        public static final int TTKErrNotReady = -18;
        public static final int TTKErrNotSupported = -5;
        public static final int TTKErrOnLineFormatNotSupport = -55;
        public static final int TTKErrOperationInterrupted = -50;
        public static final int TTKErrOverflow = -9;
        public static final int TTKErrPathNotFound = -12;
        public static final int TTKErrPermissionDenied = -46;
        public static final int TTKErrSendConnPacketFailed = -72;
        public static final int TTKErrServerBusy = -16;
        public static final int TTKErrServerDataError = -66;
        public static final int TTKErrServerStreamEOF = -65;
        public static final int TTKErrServerTerminated = -15;
        public static final int TTKErrSessionClosed = -45;
        public static final int TTKErrStartAudioUnitFailed = -51;
        public static final int TTKErrSyncEofInComplete = -62;
        public static final int TTKErrSyncReadErr = -61;
        public static final int TTKErrTimedOut = -33;
        public static final int TTKErrTooBig = -40;
        public static final int TTKErrTotalLossOfPrecision = -7;
        public static final int TTKErrUnderflow = -10;
        public static final int TTKErrUnknown = -19;
        public static final int TTKErrUrlInValid = -54;
        public static final int TTKErrVFPNotSupport = -59;
        public static final int TTKErrWrite = -23;

        public ErrorID() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class EventHandler extends Handler {
        public EventHandler(ZMMediaPlayer zMMediaPlayer, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (ZMMediaPlayer.this.mMediaPlayerNotifyEventListener != null) {
                ZMMediaPlayer.this.mMediaPlayerNotifyEventListener.onMediaPlayerNotify(message.what, message.arg1, message.arg2, message.obj);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMediaPlayerNotifyEventListener {
        void onMediaPlayerNotify(int i, int i2, int i3, Object obj);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMediaPlayerNotifyLogListener {
        void onMediaPlayerNotifyLog(int i, Object obj, Object obj2);
    }

    static {
        try {
            System.loadLibrary("osal");
            System.loadLibrary("AACDec");
            System.loadLibrary("H264Dec");
            System.loadLibrary("MediaCodecJDec");
            System.loadLibrary("zmmediaplayer");
        } catch (UnsatisfiedLinkError e) {
            mNativeLoaded = false;
            e.printStackTrace();
        }
    }

    public ZMMediaPlayer(byte[] bArr, String str) throws Exception {
        if (!mNativeLoaded) {
            throw new Exception("Native libs not loaded");
        }
        this.mEventHandler = new EventHandler(this, Looper.myLooper());
        nativeSetup(this, bArr, ZMAudioTrack.maxOutputSamplerate(), str);
    }

    public static String GetSdkVersion() {
        return sdkVersion;
    }

    private void handleLogMessage(int i, Object obj, Object obj2) {
        OnMediaPlayerNotifyLogListener onMediaPlayerNotifyLogListener = this.mMediaPlayerNotifyLogListener;
        if (onMediaPlayerNotifyLogListener != null) {
            onMediaPlayerNotifyLogListener.onMediaPlayerNotifyLog(i, obj, obj2);
        }
    }

    private native int nativeBufferBandPercent(long j);

    private native int nativeBufferBandWidth(long j);

    private native int nativeBufferedPercent(long j);

    private native int nativeBufferedSize(long j);

    private native void nativeCongfigProxyServer(long j, String str, int i, String str2, boolean z);

    private static native void nativeCongfigProxyServerByDomain(String str, int i, String str2, boolean z);

    private native int nativeDuration(long j);

    private native int nativeGetCurFreq(long j, short[] sArr, int i);

    private native int nativeGetCurFreqAndWave(long j, short[] sArr, short[] sArr2, int i);

    private native int nativeGetCurWave(long j, short[] sArr, int i);

    private native int nativeGetPosition(long j);

    private native int nativeGetStatus(long j);

    private native int nativeGetVideoHeight(long j, int i);

    private native int nativeGetVideoWidth(long j, int i);

    private native boolean nativeIsMute(long j);

    private native void nativePause(long j, boolean z);

    private native int nativePlay(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeRelease(long j);

    private native void nativeResume(long j, boolean z);

    private native void nativeSetAudioEffectLowDelay(long j, boolean z);

    private native void nativeSetCacheFilePath(long j, String str);

    private native int nativeSetDataSourceAsync(long j, String str, int i);

    private native int nativeSetDataSourceSync(long j, String str, int i);

    private native void nativeSetDecoderType(long j, int i);

    private native void nativeSetHostMetadata(String str);

    private native int nativeSetImageViewInfo(long j, int i, int i2, int i3, Object obj);

    private native int nativeSetMute(long j, boolean z);

    private native void nativeSetPlayRange(long j, int i, int i2);

    private native boolean nativeSetPlaySpeed(long j, float f);

    private native int nativeSetPosition(long j, int i, int i2);

    private native void nativeSetRenderMode(long j, int i);

    private native int nativeSetSurface(long j, Object obj);

    private native int nativeSetVideoFileUrl(long j, String str, int i);

    private native int nativeSetVideoProp(long j, int i, int i2, int i3);

    private native int nativeSetVideoViewInfo(long j, int i, int i2, int i3, Object obj);

    private native void nativeSetVolume(long j, int i, int i2);

    private native void nativeSetup(Object obj, byte[] bArr, int i, String str);

    private native int nativeSize(long j);

    private native int nativeStop(long j);

    private native int nativeStopVideoView(long j, int i);

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        EventHandler eventHandler;
        ZMMediaPlayer zMMediaPlayer = (ZMMediaPlayer) obj;
        if (zMMediaPlayer == null || (eventHandler = zMMediaPlayer.mEventHandler) == null) {
            return;
        }
        zMMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj2));
    }

    private static void postLogFromNative(Object obj, int i, Object obj2, Object obj3) {
        ZMMediaPlayer zMMediaPlayer = (ZMMediaPlayer) obj;
        if (zMMediaPlayer == null) {
            return;
        }
        zMMediaPlayer.handleLogMessage(i, obj2, obj3);
    }

    private int setDataSource(String str, int i, boolean z) {
        return z ? nativeSetDataSourceSync(this.mNativePlayerPara, str, i) : nativeSetDataSourceAsync(this.mNativePlayerPara, str, i);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int GetVideoHeight(int i) {
        return nativeGetVideoHeight(this.mNativePlayerPara, i);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int GetVideoWidth(int i) {
        return nativeGetVideoWidth(this.mNativePlayerPara, i);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public boolean IsMute() {
        return nativeIsMute(this.mNativePlayerPara);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void SetHostMetadata(String str) {
        nativeSetHostMetadata(str);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void SetImageViewInfo(int i, int i2, int i3, Bitmap bitmap) {
        nativeSetImageViewInfo(this.mNativePlayerPara, i, i2, i3, bitmap);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int SetMute(boolean z) {
        return nativeSetMute(this.mNativePlayerPara, z);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public boolean SetPlaySpeed(float f) {
        return nativeSetPlaySpeed(this.mNativePlayerPara, f);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void SetRenderMode(int i) {
        nativeSetRenderMode(this.mNativePlayerPara, i);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int SetVideoFileUrl(String str, int i) {
        return nativeSetVideoFileUrl(this.mNativePlayerPara, str, i);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void SetVideoProp(int i, int i2, int i3) {
        nativeSetVideoProp(this.mNativePlayerPara, i, i2, i3);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void SetVideoViewInfo(int i, int i2, int i3, Surface surface) {
        nativeSetVideoViewInfo(this.mNativePlayerPara, i, i2, i3, surface);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void StopVideoView(int i) {
        nativeStopVideoView(this.mNativePlayerPara, i);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int bufferedBandPercent() {
        return nativeBufferBandPercent(this.mNativePlayerPara);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int bufferedBandWidth() {
        return nativeBufferBandWidth(this.mNativePlayerPara);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int bufferedPercent() {
        return nativeBufferedPercent(this.mNativePlayerPara);
    }

    public int bufferedSize() {
        return nativeBufferedSize(this.mNativePlayerPara);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int duration() {
        return nativeDuration(this.mNativePlayerPara);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public float getBufferPercent() {
        return nativeBufferedPercent(this.mNativePlayerPara) * 0.01f;
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int getBufferSize() {
        return nativeBufferedSize(this.mNativePlayerPara);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int getCurFreq(short[] sArr, int i) {
        int iNativeGetCurFreq;
        synchronized (this) {
            iNativeGetCurFreq = !this.mPlayerReleased ? nativeGetCurFreq(this.mNativePlayerPara, sArr, i) : -1;
        }
        return iNativeGetCurFreq;
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int getCurFreqAndWave(short[] sArr, short[] sArr2, int i) {
        int iNativeGetCurFreqAndWave;
        synchronized (this) {
            iNativeGetCurFreqAndWave = !this.mPlayerReleased ? nativeGetCurFreqAndWave(this.mNativePlayerPara, sArr, sArr2, i) : -1;
        }
        return iNativeGetCurFreqAndWave;
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int getCurWave(short[] sArr, int i) {
        int iNativeGetCurWave;
        synchronized (this) {
            iNativeGetCurWave = !this.mPlayerReleased ? nativeGetCurWave(this.mNativePlayerPara, sArr, i) : -1;
        }
        return iNativeGetCurWave;
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int getFileSize() {
        return nativeSize(this.mNativePlayerPara);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int getPosition() {
        return nativeGetPosition(this.mNativePlayerPara);
    }

    public int getStatus() {
        return nativeGetStatus(this.mNativePlayerPara);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void pause(boolean z) {
        nativePause(this.mNativePlayerPara, z);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int play() {
        return nativePlay(this.mNativePlayerPara);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void release() {
        try {
            new g13(new Runnable() { // from class: com.zenmen.media.player.ZMMediaPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    ZMMediaPlayer zMMediaPlayer = ZMMediaPlayer.this;
                    zMMediaPlayer.nativeRelease(zMMediaPlayer.mNativePlayerPara);
                }
            }).start();
            Thread.sleep(50L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mPlayerReleased = true;
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void resume(boolean z) {
        nativeResume(this.mNativePlayerPara, z);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setAudioEffectLowDelay(boolean z) {
        nativeSetAudioEffectLowDelay(this.mNativePlayerPara, z);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setCacheFilePath(String str) {
        nativeSetCacheFilePath(this.mNativePlayerPara, str);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setChannelBalance(float f) {
        setVolume(1.0f - f, f + 1.0f);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setDataSourceAsync(String str, int i) {
        if (setDataSource(str, i, false) != 0) {
            throw new IllegalStateException("can not setDataSourceAsync !");
        }
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setDecoderType(int i) {
        nativeSetDecoderType(this.mNativePlayerPara, i);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setHostAddr(String str) {
        nativeSetHostMetadata(str);
    }

    public void setOnMediaPlayerNotifyEventListener(OnMediaPlayerNotifyEventListener onMediaPlayerNotifyEventListener) {
        this.mMediaPlayerNotifyEventListener = onMediaPlayerNotifyEventListener;
    }

    public void setOnMediaPlayerNotifyLogListener(OnMediaPlayerNotifyLogListener onMediaPlayerNotifyLogListener) {
        this.mMediaPlayerNotifyLogListener = onMediaPlayerNotifyLogListener;
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setPlayRange(int i, int i2) {
        nativeSetPlayRange(this.mNativePlayerPara, i, i2);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public int setPosition(int i, int i2) {
        return nativeSetPosition(this.mNativePlayerPara, i, i2);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setProxyServerConfig(String str, int i, String str2, boolean z) {
        nativeCongfigProxyServer(this.mNativePlayerPara, str, i, str2, z);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setProxyServerConfigByDomain(String str, int i, String str2, boolean z) {
        nativeCongfigProxyServerByDomain(str, i, str2, z);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        if (surface == null) {
            this.mSurface = null;
            nativeSetSurface(this.mNativePlayerPara, null);
        } else {
            this.mSurface = surface;
            nativeSetSurface(this.mNativePlayerPara, surface);
        }
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setView(SurfaceView surfaceView) {
        if (surfaceView == null) {
            this.mSurface = null;
            this.mSurfaceView = null;
            this.mSurfaceHolder = null;
            nativeSetSurface(this.mNativePlayerPara, null);
            return;
        }
        this.mSurfaceView = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.mSurfaceHolder = holder;
        if (holder != null) {
            this.mSurface = holder.getSurface();
        } else {
            this.mSurface = null;
        }
        nativeSetSurface(this.mNativePlayerPara, this.mSurface);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setViewSize(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setVolume(float f, float f2) {
        long j = this.mNativePlayerPara;
        nativeSetVolume(j, (int) ((1.0f - f) * (-990.0f)), (int) ((1.0f - f2) * (-990.0f)));
    }

    public int size() {
        return nativeSize(this.mNativePlayerPara);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void stop() {
        if (nativeStop(this.mNativePlayerPara) != 0) {
            throw new IllegalStateException("can not be stopped!");
        }
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public boolean videoSizeChanged(int i, int i2) {
        SurfaceView surfaceView;
        if (i == 0 || i2 == 0 || ((this.mWidth == i && this.mHeight == i2) || (surfaceView = this.mSurfaceView) == null)) {
            return false;
        }
        this.mWidth = i;
        this.mHeight = i2;
        ViewGroup.LayoutParams layoutParams = surfaceView.getLayoutParams();
        int i3 = this.mViewWidth;
        int i4 = this.mViewHeight;
        Log.e(TAG, "LayoutParams: nMaxOutW " + i3 + " nMaxOutH " + i4);
        int i5 = this.mHeight;
        int i6 = i3 * i5;
        int i7 = this.mWidth;
        if (i6 > i7 * i4) {
            i3 = (i7 * i4) / i5;
        } else {
            i4 = (i5 * i3) / i7;
        }
        Log.e(TAG, "LayoutParams: w: " + i3 + " h: " + i4);
        if (layoutParams.width != i3 && layoutParams.height != i4) {
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.mSurfaceView.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    public int setDataSource(String str, int i) {
        return setDataSource(str, i, true);
    }

    @Override // com.zenmen.media.player.IMediaPlayer
    public void setActiveNetWorkType(int i) {
    }
}
