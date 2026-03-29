package com.bytedance.realx.video.memory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class RXVideoMemory implements RXVideoMemoryInterface {
    protected long nativeHandle;
    RefObject refCounted = new RefObject(new Runnable() { // from class: fs4
        @Override // java.lang.Runnable
        public final void run() {
            this.f17592a.lambda$new$0();
        }
    });

    public RXVideoMemory(long j) {
        this.nativeHandle = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        long j = this.nativeHandle;
        if (j != 0) {
            nativeReleaseVideoMemory(j);
            this.nativeHandle = 0L;
        }
    }

    private static native void nativeReleaseVideoMemory(long j);

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    public boolean isNullPointer() {
        return this.nativeHandle == 0;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface, com.bytedance.realx.base.RefCounted
    public synchronized void release() {
        this.refCounted.release();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface, com.bytedance.realx.base.RefCounted
    public synchronized void retain() {
        this.refCounted.retain();
    }
}
