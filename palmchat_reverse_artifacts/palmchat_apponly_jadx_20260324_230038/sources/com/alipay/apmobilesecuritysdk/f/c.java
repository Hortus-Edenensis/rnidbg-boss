package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f2567a;

    public c(b bVar) {
        this.f2567a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Process.setThreadPriority(0);
            while (!this.f2567a.c.isEmpty()) {
                Runnable runnable = (Runnable) this.f2567a.c.get(0);
                this.f2567a.c.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            b.b(this.f2567a);
            throw th;
        }
        b.b(this.f2567a);
    }
}
