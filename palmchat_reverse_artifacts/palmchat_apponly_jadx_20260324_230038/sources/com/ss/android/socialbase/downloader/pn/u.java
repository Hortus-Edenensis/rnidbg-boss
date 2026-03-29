package com.ss.android.socialbase.downloader.pn;

import android.os.Process;
import com.lantern.auth.app.FunDC;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.iz.my;
import com.ss.android.socialbase.downloader.jk.iz;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u implements nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.iz.u f10626a;
    private final int fx;
    private com.ss.android.socialbase.downloader.iz.u iz;
    private com.ss.android.socialbase.downloader.iz.u jk;
    private volatile Future k;
    private volatile boolean l;
    private volatile boolean mv;
    private int my;
    private com.ss.android.socialbase.downloader.iz.u n;
    private final int nr;
    private volatile Throwable s;
    private com.ss.android.socialbase.downloader.iz.u t;
    private final InputStream u;
    private com.ss.android.socialbase.downloader.iz.u x;
    private final Object b = new Object();
    private final Object pn = new Object();
    private final Runnable o = new Runnable() { // from class: com.ss.android.socialbase.downloader.pn.u.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.iz.u uVarB;
            Process.setThreadPriority(10);
            do {
                try {
                    uVarB = u.this.b();
                    uVarB.fx = u.this.u.read(uVarB.u);
                    u.this.fx(uVarB);
                } catch (Throwable th) {
                    try {
                        u.this.s = th;
                        synchronized (u.this.pn) {
                            u.this.mv = true;
                            u.this.pn.notify();
                            iz.u(u.this.u);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (u.this.pn) {
                            u.this.mv = true;
                            u.this.pn.notify();
                            iz.u(u.this.u);
                            throw th2;
                        }
                    }
                }
            } while (uVarB.fx != -1);
            synchronized (u.this.pn) {
                u.this.mv = true;
                u.this.pn.notify();
            }
            iz.u(u.this.u);
        }
    };

    public u(InputStream inputStream, int i, int i2) throws Throwable {
        this.u = inputStream;
        this.nr = i;
        if (i2 <= 0) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.fx = i2;
        fx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.iz.u b() throws my, InterruptedException {
        int i;
        com.ss.android.socialbase.downloader.iz.u uVar = this.n;
        if (uVar != null) {
            if (this.l) {
                throw new my("");
            }
            this.n = uVar.b;
            uVar.b = null;
            return uVar;
        }
        synchronized (this.b) {
            if (this.l) {
                throw new my("");
            }
            com.ss.android.socialbase.downloader.iz.u uVar2 = this.iz;
            if (uVar2 == null && (i = this.my) < this.fx) {
                this.my = i + 1;
                return new com.ss.android.socialbase.downloader.iz.u(this.nr);
            }
            while (uVar2 == null) {
                this.b.wait();
                if (this.l) {
                    throw new my("");
                }
                uVar2 = this.iz;
            }
            this.n = uVar2.b;
            this.x = null;
            this.iz = null;
            uVar2.b = null;
            return uVar2;
        }
    }

    private void iz() throws BaseException {
        Throwable th = this.s;
        if (th != null) {
            if (th instanceof my) {
                throw new BaseException(FunDC.ID_AUTH_1068, "async reader closed!");
            }
            iz.u(th, "async_read");
        }
        throw new BaseException(FunDC.ID_AUTH_1069, "async reader terminated!");
    }

    private com.ss.android.socialbase.downloader.iz.u pn() throws InterruptedException, BaseException {
        com.ss.android.socialbase.downloader.iz.u uVar;
        com.ss.android.socialbase.downloader.iz.u uVar2 = this.t;
        if (uVar2 != null) {
            this.t = uVar2.b;
            uVar2.b = null;
            return uVar2;
        }
        synchronized (this.pn) {
            uVar = this.f10626a;
            if (uVar == null) {
                do {
                    if (this.mv) {
                        iz();
                    }
                    this.pn.wait();
                    uVar = this.f10626a;
                } while (uVar == null);
            }
            this.t = uVar.b;
            this.jk = null;
            this.f10626a = null;
            uVar.b = null;
        }
        return uVar;
    }

    private void fx() throws Throwable {
        this.k = com.ss.android.socialbase.downloader.downloader.fx.o().submit(this.o);
    }

    @Override // com.ss.android.socialbase.downloader.pn.nr
    public void nr() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        Future future = this.k;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(com.ss.android.socialbase.downloader.iz.u uVar) {
        synchronized (this.pn) {
            com.ss.android.socialbase.downloader.iz.u uVar2 = this.jk;
            if (uVar2 == null) {
                this.jk = uVar;
                this.f10626a = uVar;
                this.pn.notify();
            } else {
                uVar2.b = uVar;
                this.jk = uVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.pn.nr
    public com.ss.android.socialbase.downloader.iz.u u() throws InterruptedException, BaseException {
        return pn();
    }

    @Override // com.ss.android.socialbase.downloader.pn.nr
    public void u(com.ss.android.socialbase.downloader.iz.u uVar) {
        nr(uVar);
    }

    private void nr(com.ss.android.socialbase.downloader.iz.u uVar) {
        synchronized (this.b) {
            com.ss.android.socialbase.downloader.iz.u uVar2 = this.x;
            if (uVar2 == null) {
                this.x = uVar;
                this.iz = uVar;
                this.b.notify();
            } else {
                uVar2.b = uVar;
                this.x = uVar;
            }
        }
    }
}
