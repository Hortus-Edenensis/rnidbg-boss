package com.ss.bytertc.engine;

import android.content.Context;
import com.bytedance.realx.video.EglBase;
import com.ss.bytertc.engine.handler.RTCVideoEventHandler;
import com.ss.bytertc.engine.video.VideoFrame;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NativeRTCVideoFunctionsEx {
    public static native long nativeCreateRTCVideoEx(Context context, String str, RTCVideoEventHandler rTCVideoEventHandler, String str2, EglBase.Context context2);

    public static native void nativeDestroyRTCVideoEx(long j);

    public static native int nativePushExternalVideoFrame(long j, int i, VideoFrame videoFrame);

    public static native int nativeSetAudioContentType(long j, int i, boolean z, boolean z2, boolean z3);

    public static native int nativeSetAudioEncodeConfig(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public static native int nativeSetAudioSourceVolume(long j, int i, int i2);

    public static native int nativeSetCaptureVolume(long j, int i);

    public static native int nativeSetLocalStreamPriority(long j, int i, int i2);

    public static native int nativeSetRemoteAudioPlaybackVolume(long j, String str, String str2, int i, int i2);

    public static native int nativeSetScreenCaptureVolume(long j, int i);

    public static native int nativeSetVideoCaptureConfig(long j, int i, InternalVideoCaptureConfig internalVideoCaptureConfig);

    public static native int nativeSetVideoSource(long j, int i, int i2, int i3);

    public static native int nativeStartVideoCapture(long j, int i, String str);

    public static native int nativeStopVideoCapture(long j, int i);
}
