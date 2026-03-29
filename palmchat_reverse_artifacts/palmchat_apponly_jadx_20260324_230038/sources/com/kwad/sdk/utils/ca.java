package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ca extends Handler {
    private WeakReference<a> bgJ;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Message message);
    }

    public ca(a aVar) {
        this.bgJ = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        a aVar;
        try {
            WeakReference<a> weakReference = this.bgJ;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            } else {
                aVar.a(message);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        super.handleMessage(message);
    }
}
