package com.tencent.matrix.trace.listeners;

import androidx.annotation.CallSuper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class LooperObserver {
    private boolean isDispatchBegin = false;

    @CallSuper
    public void dispatchBegin(long j, long j2, long j3) {
        this.isDispatchBegin = true;
    }

    @CallSuper
    public void dispatchEnd(long j, long j2, long j3, long j4, long j5, boolean z) {
        this.isDispatchBegin = false;
    }

    public boolean isDispatchBegin() {
        return this.isDispatchBegin;
    }

    public void doFrame(String str, long j, long j2, boolean z, long j3, long j4, long j5, long j6) {
    }
}
