package com.bytedance.sdk.component.jk.nr;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.rh;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends rh implements fx {
    private final HandlerThread nr;

    public nr(HandlerThread handlerThread, rh.u uVar) {
        super(handlerThread.getLooper(), uVar);
        this.nr = handlerThread;
    }

    public void nr() {
        HandlerThread handlerThread = this.nr;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    @Override // com.bytedance.sdk.component.jk.nr.fx
    public void u() {
        removeCallbacksAndMessages(null);
        WeakReference<rh.u> weakReference = this.u;
        if (weakReference != null) {
            weakReference.clear();
            this.u = null;
        }
    }

    public void u(rh.u uVar) {
        this.u = new WeakReference<>(uVar);
    }
}
