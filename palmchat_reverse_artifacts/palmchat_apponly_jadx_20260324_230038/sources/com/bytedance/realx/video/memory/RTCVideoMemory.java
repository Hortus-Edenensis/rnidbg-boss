package com.bytedance.realx.video.memory;

import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.base.RefCounted;
import com.bytedance.realx.video.RXVideoMemoryType;
import com.bytedance.realx.video.RXVideoRotation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class RTCVideoMemory implements RefCounted {
    private Runnable releaseCallback = null;
    RefObject refCounted = new RefObject(new Runnable() { // from class: qr4
        @Override // java.lang.Runnable
        public final void run() {
            this.f20309a.lambda$new$0();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        Runnable runnable = this.releaseCallback;
        if (runnable != null) {
            runnable.run();
        }
    }

    @CalledByNative
    public abstract int getHeight();

    @CalledByNative
    public abstract RXVideoMemoryType getMemoryType();

    @CalledByNative
    public abstract RXVideoRotation getRotation();

    @CalledByNative
    public abstract int getWidth();

    public synchronized boolean hasReleaseCallback() {
        return this.releaseCallback != null;
    }

    @Override // com.bytedance.realx.base.RefCounted
    @CalledByNative
    public synchronized void release() {
        this.refCounted.release();
    }

    @Override // com.bytedance.realx.base.RefCounted
    @CalledByNative
    public synchronized void retain() {
        this.refCounted.retain();
    }

    public synchronized void setReleaseCallback(Runnable runnable) {
        this.releaseCallback = runnable;
    }
}
