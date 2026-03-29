package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class rh extends Handler {
    protected WeakReference<u> u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Message message);
    }

    public rh(u uVar) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (uVar != null) {
            this.u = new WeakReference<>(uVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        u uVar;
        WeakReference<u> weakReference = this.u;
        if (weakReference == null || (uVar = weakReference.get()) == null || message == null) {
            return;
        }
        uVar.u(message);
    }

    public rh(Looper looper, u uVar) {
        super(looper);
        if (uVar != null) {
            this.u = new WeakReference<>(uVar);
        }
    }
}
