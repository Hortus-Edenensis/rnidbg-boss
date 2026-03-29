package com.bykv.vk.component.ttvideo.player;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("PLAYER")
public abstract class LoadControl extends NativeObject {
    @CalledByNative
    public abstract int onCodecStackSelected(int i);

    @CalledByNative
    public abstract int onFilterStackSelected(int i);

    @CalledByNative
    public abstract int onTrackSelected(int i);

    @CalledByNative
    public abstract boolean shouldStartPlayback(long j, float f, boolean z);
}
