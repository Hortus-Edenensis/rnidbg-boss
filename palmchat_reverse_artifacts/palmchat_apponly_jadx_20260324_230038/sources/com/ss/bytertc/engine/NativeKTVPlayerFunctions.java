package com.ss.bytertc.engine;

import com.ss.bytertc.ktv.IKTVPlayerEventHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NativeKTVPlayerFunctions {
    public static native void nativePauseMusic(long j, String str);

    public static native void nativePlayMusic(long j, String str, int i, int i2);

    public static native void nativeReleaseKTVPlayerEventHandler(long j);

    public static native void nativeResumeMusic(long j, String str);

    public static native void nativeSeekMusic(long j, String str, int i);

    public static native void nativeSetMusicPitch(long j, String str, int i);

    public static native void nativeSetMusicVolume(long j, String str, int i);

    public static native long nativeSetPlayerEventHandler(long j, IKTVPlayerEventHandler iKTVPlayerEventHandler);

    public static native void nativeStopMusic(long j, String str);

    public static native void nativeSwitchAudioTrackType(long j, String str);
}
