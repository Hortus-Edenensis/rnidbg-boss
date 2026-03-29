package com.ss.bytertc.engine;

import com.ss.bytertc.engine.handler.RTCAudioFileFrameObserver;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NativeAudioMixingManagerFunctions {
    public static native void nativeDisableAudioMixingFrame(long j, int i);

    public static native void nativeEnableAudioMixingFrame(long j, int i, int i2);

    public static native int nativeGetAudioMixingCurrentPosition(long j, int i);

    public static native int nativeGetAudioMixingDuration(long j, int i);

    public static native int nativeGetAudioMixingPlaybackDuration(long j, int i);

    public static native int nativeGetAudioTrackCount(long j, int i);

    public static native void nativePauseAllAudioMixing(long j);

    public static native void nativePauseAudioMixing(long j, int i);

    public static native void nativePreloadAudioMixing(long j, int i, String str);

    public static native int nativePushAudioMixingFrame(long j, int i, byte[] bArr, int i2, int i3, int i4);

    public static native void nativeResumeAllAudioMixing(long j);

    public static native void nativeResumeAudioMixing(long j, int i);

    public static native void nativeSelectAudioTrack(long j, int i, int i2);

    public static native void nativeSetAllAudioMixingVolume(long j, int i, int i2);

    public static native void nativeSetAudioFileFrameObserver(long j, long j2, RTCAudioFileFrameObserver rTCAudioFileFrameObserver);

    public static native void nativeSetAudioMixingDualMonoMode(long j, int i, int i2);

    public static native void nativeSetAudioMixingLoudness(long j, int i, float f);

    public static native void nativeSetAudioMixingPitch(long j, int i, int i2);

    public static native int nativeSetAudioMixingPlaybackSpeed(long j, int i, int i2);

    public static native void nativeSetAudioMixingPosition(long j, int i, int i2);

    public static native void nativeSetAudioMixingProgressInterval(long j, int i, long j2);

    public static native void nativeSetAudioMixingVolume(long j, int i, int i2, int i3);

    public static native void nativeStartAudioMixing(long j, int i, String str, int i2, int i3, int i4, long j2, boolean z);

    public static native void nativeStopAllAudioMixing(long j);

    public static native void nativeStopAudioMixing(long j, int i);

    public static native void nativeUnloadAudioMixing(long j, int i);
}
