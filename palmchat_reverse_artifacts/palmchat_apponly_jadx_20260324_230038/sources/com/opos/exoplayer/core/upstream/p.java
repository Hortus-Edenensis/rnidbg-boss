package com.opos.exoplayer.core.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.util.x;
import com.opos.exoplayer.core.util.y;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f8385a;
    private e<? extends b> b;
    private IOException c;

    /* JADX INFO: compiled from: SearchBox */
    public interface a<T extends b> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        boolean b();

        void c();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void g();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends com.opos.exoplayer.core.util.c {
        public d(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }

        @Override // com.opos.exoplayer.core.util.c
        public String a() {
            return "UnexpectedLoaderException";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public final class e<T extends b> extends Handler implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8386a;
        private final T c;
        private final a<T> d;
        private final long e;
        private IOException f;
        private int g;
        private volatile Thread h;
        private volatile boolean i;

        public e(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.c = t;
            this.d = aVar;
            this.f8386a = i;
            this.e = j;
        }

        private void a() {
            this.f = null;
            p.this.f8385a.execute(p.this.b);
        }

        private void b() {
            p.this.b = null;
        }

        private long c() {
            return Math.min((this.g - 1) * 1000, 5000);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.i) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                a();
                return;
            }
            if (i == 4) {
                throw ((Error) message.obj);
            }
            b();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.e;
            if (this.c.b()) {
                this.d.a((b) this.c, jElapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                this.d.a((b) this.c, jElapsedRealtime, j, false);
                return;
            }
            if (i2 == 2) {
                try {
                    this.d.a(this.c, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    com.opos.cmn.an.f.a.d("LoadTask", "Unexpected exception handling load completed", e);
                    p.this.c = new d(e);
                    return;
                }
            }
            if (i2 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f = iOException;
            int iA = this.d.a(this.c, jElapsedRealtime, j, iOException);
            if (iA == 3) {
                p.this.c = this.f;
            } else if (iA != 2) {
                this.g = iA != 1 ? 1 + this.g : 1;
                a(c());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Object e;
            try {
                this.h = Thread.currentThread();
                if (!this.c.b()) {
                    x.a("load:" + this.c.getClass().getSimpleName());
                    try {
                        this.c.c();
                        x.a();
                    } catch (Throwable th) {
                        x.a();
                        throw th;
                    }
                }
                if (this.i) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e2) {
                e = e2;
                if (this.i) {
                    return;
                }
                obtainMessage(3, e).sendToTarget();
            } catch (OutOfMemoryError e3) {
                com.opos.cmn.an.f.a.d("LoadTask", "OutOfMemory error loading stream", e3);
                if (this.i) {
                    return;
                }
                e = new d(e3);
                obtainMessage(3, e).sendToTarget();
            } catch (Error e4) {
                com.opos.cmn.an.f.a.d("LoadTask", "Unexpected error loading stream", e4);
                if (!this.i) {
                    obtainMessage(4, e4).sendToTarget();
                }
                throw e4;
            } catch (InterruptedException unused) {
                com.opos.exoplayer.core.util.a.b(this.c.b());
                if (this.i) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (Exception e5) {
                com.opos.cmn.an.f.a.d("LoadTask", "Unexpected exception loading stream", e5);
                if (this.i) {
                    return;
                }
                e = new d(e5);
                obtainMessage(3, e).sendToTarget();
            }
        }

        public void a(int i) throws IOException {
            IOException iOException = this.f;
            if (iOException != null && this.g > i) {
                throw iOException;
            }
        }

        public void a(long j) {
            com.opos.exoplayer.core.util.a.b(p.this.b == null);
            p.this.b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                a();
            }
        }

        public void a(boolean z) {
            this.i = z;
            this.f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.c.a();
                if (this.h != null) {
                    this.h.interrupt();
                }
            }
            if (z) {
                b();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.d.a((b) this.c, jElapsedRealtime, jElapsedRealtime - this.e, true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f8387a;

        public f(c cVar) {
            this.f8387a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8387a.g();
        }
    }

    public p(String str) {
        this.f8385a = y.a(str);
    }

    public <T extends b> long a(T t, a<T> aVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        com.opos.exoplayer.core.util.a.b(looperMyLooper != null);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new e(looperMyLooper, t, aVar, i, jElapsedRealtime).a(0L);
        return jElapsedRealtime;
    }

    public void b() {
        this.b.a(false);
    }

    public void a(int i) throws IOException {
        IOException iOException = this.c;
        if (iOException != null) {
            throw iOException;
        }
        e<? extends b> eVar = this.b;
        if (eVar != null) {
            if (i == Integer.MIN_VALUE) {
                i = eVar.f8386a;
            }
            eVar.a(i);
        }
    }

    public void a(@Nullable c cVar) {
        e<? extends b> eVar = this.b;
        if (eVar != null) {
            eVar.a(true);
        }
        if (cVar != null) {
            this.f8385a.execute(new f(cVar));
        }
        this.f8385a.shutdown();
    }

    public boolean a() {
        return this.b != null;
    }
}
