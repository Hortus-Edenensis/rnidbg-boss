package com.zenmen.media.roomchat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VideoCallGroupChattingNativeSDK {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static VideoCallGroupChattingNativeSDK f11967a;

    static {
        System.loadLibrary("RenderEngine");
        f11967a = null;
    }

    public native int nativeInit(int i);

    public native int nativeProvideCameraFrame(long j, byte[] bArr, int i, int i2, int i3, boolean z, long j2);

    public native int nativeUninit();

    public native int nativeUpdateVideoSurface(long j, Object obj);
}
