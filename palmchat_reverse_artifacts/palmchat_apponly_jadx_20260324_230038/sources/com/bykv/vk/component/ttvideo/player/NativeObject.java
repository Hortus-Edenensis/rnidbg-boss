package com.bykv.vk.component.ttvideo.player;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("PLAYER")
public class NativeObject {
    protected long mNativeObj = 0;

    @CalledByNative
    private long getNativeObj() {
        return this.mNativeObj;
    }

    private native void nativeRelease(long j);

    public synchronized void release() {
        long j = this.mNativeObj;
        if (j != 0) {
            nativeRelease(j);
            this.mNativeObj = 0L;
        }
    }

    public void setNativeObj(long j) {
        this.mNativeObj = j;
    }

    public void finalize() throws Throwable {
    }
}
