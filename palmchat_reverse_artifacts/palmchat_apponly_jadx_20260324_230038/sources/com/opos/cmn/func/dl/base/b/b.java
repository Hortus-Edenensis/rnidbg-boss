package com.opos.cmn.func.dl.base.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f7971a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(final Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f7971a.post(new Runnable() { // from class: com.opos.cmn.func.dl.base.b.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        com.opos.cmn.an.f.a.c("DelegateMain", "uncaughtException", th);
                    }
                }
            });
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("DelegateMain", "uncaughtException", th);
        }
    }
}
