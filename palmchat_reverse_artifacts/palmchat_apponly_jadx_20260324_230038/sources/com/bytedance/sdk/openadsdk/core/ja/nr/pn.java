package com.bytedance.sdk.openadsdk.core.ja.nr;

import android.os.Handler;
import android.util.Log;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.n;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5285a;
    private final int b;
    private final Callable<T> fx;
    private volatile boolean iz;
    private volatile boolean jk;
    private final Runnable l;
    private volatile Thread n;
    private int nr;
    private final long pn;
    private volatile boolean t;
    private final Handler u;
    private final nr<T> x;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr<T> {
        boolean u(Exception exc);

        boolean u(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u<T> {
        private nr<T> nr;
        private final Callable<T> u;
        private int fx = 5;
        private long b = 0;
        private long pn = 1000;

        public u(Callable<T> callable) {
            this.u = callable;
        }

        public u<T> u(int i) {
            this.fx = i;
            return this;
        }

        public u<T> u(long j) {
            this.b = j;
            return this;
        }

        public pn<T> u() {
            return new pn<>(this);
        }

        public u(Callable<T> callable, nr<T> nrVar) {
            this.u = callable;
            this.nr = nrVar;
        }
    }

    public static /* synthetic */ int pn(pn pnVar) {
        int i = pnVar.nr;
        pnVar.nr = i + 1;
        return i;
    }

    public static boolean u(int i) {
        return i >= 500 || i == 429;
    }

    private pn(u<T> uVar) {
        this.u = jk.fx();
        this.nr = 0;
        this.iz = false;
        this.f5285a = 0L;
        this.jk = false;
        this.t = false;
        this.l = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ja.nr.pn.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (pn.this.nr < pn.this.b && !pn.this.t) {
                        if (n.o().ja()) {
                            pn.this.fx();
                            return;
                        }
                        long jIz = pn.this.iz();
                        pn.pn(pn.this);
                        pn.this.fx.call();
                        pn.this.u.postDelayed(pn.this.l, jIz);
                    }
                } catch (Exception unused) {
                }
            }
        };
        this.fx = ((u) uVar).u;
        this.x = ((u) uVar).nr;
        this.b = ((u) uVar).fx;
        this.pn = ((u) uVar).b;
        this.f5285a = ((u) uVar).pn;
    }

    private void b() {
        if (this.iz) {
            return;
        }
        this.nr++;
        pn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long iz() {
        return (long) ((this.f5285a * Math.pow(2.0d, this.nr)) + this.pn);
    }

    private void pn() {
        try {
            Thread.sleep(iz());
        } catch (InterruptedException unused) {
            this.iz = true;
        }
    }

    public void fx() {
        this.u.removeCallbacks(this.l);
        this.nr = 0;
        this.jk = false;
        this.t = true;
    }

    public void nr() {
        this.u.removeCallbacks(this.l);
        if (this.nr >= this.b || this.jk) {
            return;
        }
        if (n.o().ja()) {
            fx();
            return;
        }
        long jIz = iz();
        this.jk = true;
        this.u.postDelayed(this.l, jIz);
    }

    public T u() throws Exception {
        this.n = Thread.currentThread();
        this.nr = 0;
        T tCall = null;
        while (this.nr < this.b && !this.iz) {
            try {
            } catch (Exception e) {
                nr<T> nrVar = this.x;
                if (nrVar != null && nrVar.u(e)) {
                    b();
                } else {
                    Log.getStackTraceString(e);
                    throw e;
                }
            }
            if (n.o().ja()) {
                this.iz = true;
                break;
            }
            tCall = this.fx.call();
            nr<T> nrVar2 = this.x;
            if (nrVar2 == null || !nrVar2.u(tCall)) {
                break;
            }
            b();
        }
        return tCall;
    }

    public static boolean u(Throwable th) {
        String message;
        if ((th instanceof UnknownHostException) || (th instanceof SSLException) || (th instanceof InterruptedIOException) || (th instanceof EOFException) || (th instanceof SocketException)) {
            return true;
        }
        if (!(th instanceof IOException) || (message = th.getMessage()) == null) {
            return false;
        }
        String lowerCase = message.toLowerCase();
        return lowerCase.contains("canceled") || lowerCase.contains(WkAdConfigModel.TAG_TIMEOUT) || lowerCase.contains("etimedout") || lowerCase.contains("enetunreach") || lowerCase.contains("econnreset") || lowerCase.contains("connection abort") || lowerCase.contains("software caused connection abort");
    }
}
