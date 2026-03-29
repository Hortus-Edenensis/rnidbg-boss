package com.ss.android.downloadlib.x;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s extends Handler {
    WeakReference<u> u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Message message);
    }

    public s(Looper looper, u uVar) {
        super(looper);
        this.u = new WeakReference<>(uVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        u uVar = this.u.get();
        if (uVar == null || message == null) {
            return;
        }
        uVar.u(message);
    }
}
