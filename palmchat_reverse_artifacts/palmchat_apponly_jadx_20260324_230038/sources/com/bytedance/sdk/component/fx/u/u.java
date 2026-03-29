package com.bytedance.sdk.component.fx.u;

import android.support.v4.media.session.PlaybackStateCompat;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends bq {
    private static final long b;
    private static final long nr;
    static u u;
    private u iz;
    private boolean pn;
    private long x;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.fx.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0218u extends com.bytedance.sdk.component.jk.b.fx {
        public C0218u() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.e_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                try {
                } catch (InterruptedException unused) {
                    continue;
                } catch (Throwable unused2) {
                    return;
                }
                synchronized (u.class) {
                    u uVarB = u.b();
                    if (uVarB != null) {
                        if (uVarB == u.u) {
                            u.u = null;
                            return;
                        }
                        continue;
                    }
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        nr = millis;
        b = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static u b() throws InterruptedException {
        u uVar = u.iz;
        if (uVar == null) {
            long jNanoTime = System.nanoTime();
            u.class.wait(nr);
            if (u.iz != null || System.nanoTime() - jNanoTime < b) {
                return null;
            }
            return u;
        }
        long jNr = uVar.nr(System.nanoTime());
        if (jNr > 0) {
            long j = jNr / 1000000;
            u.class.wait(j, (int) (jNr - (1000000 * j)));
            return null;
        }
        u.iz = uVar.iz;
        uVar.iz = null;
        return uVar;
    }

    public final boolean nr() {
        if (!this.pn) {
            return false;
        }
        this.pn = false;
        return u(this);
    }

    public final void u() {
        if (this.pn) {
            return;
        }
        long jF_ = f_();
        boolean zFx = fx();
        if (jF_ != 0 || zFx) {
            this.pn = true;
            u(this, jF_, zFx);
        }
    }

    private long nr(long j) {
        return this.x - j;
    }

    public IOException nr(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(WkAdConfigModel.TAG_TIMEOUT);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized void u(u uVar, long j, boolean z) {
        if (u == null) {
            u = new u();
            C0218u c0218u = new C0218u();
            c0218u.setName("csj_watch_dog");
            try {
                c0218u.start();
            } catch (Throwable unused) {
            }
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            uVar.x = Math.min(j, uVar.g_() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            uVar.x = j + jNanoTime;
        } else if (z) {
            uVar.x = uVar.g_();
        } else {
            throw new AssertionError();
        }
        long jNr = uVar.nr(jNanoTime);
        u uVar2 = u;
        while (true) {
            u uVar3 = uVar2.iz;
            if (uVar3 == null || jNr < uVar3.nr(jNanoTime)) {
                break;
            } else {
                uVar2 = uVar2.iz;
            }
        }
        uVar.iz = uVar2.iz;
        uVar2.iz = uVar;
        if (uVar2 == u) {
            u.class.notify();
        }
    }

    public void e_() {
    }

    private static synchronized boolean u(u uVar) {
        u uVar2 = u;
        while (uVar2 != null) {
            u uVar3 = uVar2.iz;
            if (uVar3 == uVar) {
                uVar2.iz = uVar.iz;
                uVar.iz = null;
                return false;
            }
            uVar2 = uVar3;
        }
        return true;
    }

    public final sx u(final sx sxVar) {
        return new sx() { // from class: com.bytedance.sdk.component.fx.u.u.1
            @Override // com.bytedance.sdk.component.fx.u.sx
            public void a_(fx fxVar, long j) throws IOException {
                try {
                    dw.u(fxVar.nr, 0L, j);
                    while (true) {
                        long j2 = 0;
                        if (j <= 0) {
                            return;
                        }
                        k kVar = fxVar.u;
                        while (true) {
                            if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                                break;
                            }
                            j2 += (long) (kVar.fx - kVar.nr);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            kVar = kVar.iz;
                        }
                        u.this.u();
                        try {
                            try {
                                sxVar.a_(fxVar, j2);
                                j -= j2;
                                u.this.u(true);
                            } catch (IOException e) {
                                throw u.this.u(e);
                            }
                        } catch (Throwable th) {
                            u.this.u(false);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    throw new IOException(e2);
                }
            }

            @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                u.this.u();
                try {
                    try {
                        sxVar.close();
                        u.this.u(true);
                    } catch (IOException e) {
                        throw u.this.u(e);
                    }
                } catch (Throwable th) {
                    u.this.u(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
            public void flush() throws IOException {
                u.this.u();
                try {
                    try {
                        sxVar.flush();
                        u.this.u(true);
                    } catch (IOException e) {
                        throw u.this.u(e);
                    }
                } catch (Throwable th) {
                    u.this.u(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sxVar + ")";
            }

            @Override // com.bytedance.sdk.component.fx.u.sx
            public bq u() {
                return u.this;
            }
        };
    }

    public final bg u(final bg bgVar) {
        return new bg() { // from class: com.bytedance.sdk.component.fx.u.u.2
            @Override // com.bytedance.sdk.component.fx.u.bg, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                u.this.u();
                try {
                    try {
                        bgVar.close();
                        u.this.u(true);
                    } catch (IOException e) {
                        throw u.this.u(e);
                    }
                } catch (Throwable th) {
                    u.this.u(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + bgVar + ")";
            }

            @Override // com.bytedance.sdk.component.fx.u.bg
            public long u(fx fxVar, long j) throws IOException {
                u.this.u();
                try {
                    try {
                        long jU = bgVar.u(fxVar, j);
                        u.this.u(true);
                        return jU;
                    } catch (IOException e) {
                        throw u.this.u(e);
                    }
                } catch (Throwable th) {
                    u.this.u(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.fx.u.bg
            public bq u() {
                return u.this;
            }
        };
    }

    public final void u(boolean z) throws IOException {
        if (nr() && z) {
            throw nr((IOException) null);
        }
    }

    public final IOException u(IOException iOException) throws IOException {
        return !nr() ? iOException : nr(iOException);
    }
}
