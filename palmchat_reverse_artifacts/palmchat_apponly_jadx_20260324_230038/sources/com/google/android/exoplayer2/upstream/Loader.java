package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import defpackage.g86;
import defpackage.hz5;
import defpackage.q43;
import defpackage.vh;
import defpackage.y53;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class Loader implements q43 {
    public static final c d = g(false, -9223372036854775807L);
    public static final c e = g(true, -9223372036854775807L);
    public static final c f;
    public static final c g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f6007a;

    @Nullable
    public d<? extends e> b;

    @Nullable
    public IOException c;

    /* JADX INFO: compiled from: SearchBox */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b<T extends e> {
        void e(T t, long j, long j2, boolean z);

        void f(T t, long j, long j2);

        c j(T t, long j, long j2, IOException iOException, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6008a;
        public final long b;

        public boolean c() {
            int i = this.f6008a;
            return i == 0 || i == 1;
        }

        public c(int i, long j) {
            this.f6008a = i;
            this.b = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public final class d<T extends e> extends Handler implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6009a;
        public final T b;
        public final long c;

        @Nullable
        public b<T> d;

        @Nullable
        public IOException e;
        public int f;

        @Nullable
        public Thread g;
        public boolean h;
        public volatile boolean i;

        public d(Looper looper, T t, b<T> bVar, int i, long j) {
            super(looper);
            this.b = t;
            this.d = bVar;
            this.f6009a = i;
            this.c = j;
        }

        public void a(boolean z) {
            this.i = z;
            this.e = null;
            if (hasMessages(0)) {
                this.h = true;
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.h = true;
                    this.b.cancelLoad();
                    Thread thread = this.g;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z) {
                c();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((b) vh.e(this.d)).e(this.b, jElapsedRealtime, jElapsedRealtime - this.c, true);
                this.d = null;
            }
        }

        public final void b() {
            this.e = null;
            Loader.this.f6007a.execute((Runnable) vh.e(Loader.this.b));
        }

        public final void c() {
            Loader.this.b = null;
        }

        public final long d() {
            return Math.min((this.f - 1) * 1000, 5000);
        }

        public void e(int i) throws IOException {
            IOException iOException = this.e;
            if (iOException != null && this.f > i) {
                throw iOException;
            }
        }

        public void f(long j) {
            vh.g(Loader.this.b == null);
            Loader.this.b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.i) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                b();
                return;
            }
            if (i == 3) {
                throw ((Error) message.obj);
            }
            c();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.c;
            b bVar = (b) vh.e(this.d);
            if (this.h) {
                bVar.e(this.b, jElapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    bVar.f(this.b, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    y53.d("LoadTask", "Unexpected exception handling load completed", e);
                    Loader.this.c = new UnexpectedLoaderException(e);
                    return;
                }
            }
            if (i2 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.e = iOException;
            int i3 = this.f + 1;
            this.f = i3;
            c cVarJ = bVar.j(this.b, jElapsedRealtime, j, iOException, i3);
            if (cVarJ.f6008a == 3) {
                Loader.this.c = this.e;
            } else if (cVarJ.f6008a != 2) {
                if (cVarJ.f6008a == 1) {
                    this.f = 1;
                }
                f(cVarJ.b != -9223372036854775807L ? cVarJ.b : d());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                synchronized (this) {
                    z = !this.h;
                    this.g = Thread.currentThread();
                }
                if (z) {
                    hz5.a("load:" + this.b.getClass().getSimpleName());
                    try {
                        this.b.load();
                        hz5.c();
                    } catch (Throwable th) {
                        hz5.c();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.g = null;
                    Thread.interrupted();
                }
                if (this.i) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e) {
                if (this.i) {
                    return;
                }
                obtainMessage(2, e).sendToTarget();
            } catch (Error e2) {
                if (!this.i) {
                    y53.d("LoadTask", "Unexpected error loading stream", e2);
                    obtainMessage(3, e2).sendToTarget();
                }
                throw e2;
            } catch (Exception e3) {
                if (this.i) {
                    return;
                }
                y53.d("LoadTask", "Unexpected exception loading stream", e3);
                obtainMessage(2, new UnexpectedLoaderException(e3)).sendToTarget();
            } catch (OutOfMemoryError e4) {
                if (this.i) {
                    return;
                }
                y53.d("LoadTask", "OutOfMemory error loading stream", e4);
                obtainMessage(2, new UnexpectedLoaderException(e4)).sendToTarget();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void cancelLoad();

        void load() throws IOException;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void onLoaderReleased();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f6010a;

        public g(f fVar) {
            this.f6010a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6010a.onLoaderReleased();
        }
    }

    static {
        long j = -9223372036854775807L;
        f = new c(2, j);
        g = new c(3, j);
    }

    public Loader(String str) {
        this.f6007a = g86.I0("ExoPlayer:Loader:" + str);
    }

    public static c g(boolean z, long j) {
        return new c(z ? 1 : 0, j);
    }

    public void e() {
        ((d) vh.i(this.b)).a(false);
    }

    public void f() {
        this.c = null;
    }

    public boolean h() {
        return this.c != null;
    }

    public boolean i() {
        return this.b != null;
    }

    public void j(int i) throws IOException {
        IOException iOException = this.c;
        if (iOException != null) {
            throw iOException;
        }
        d<? extends e> dVar = this.b;
        if (dVar != null) {
            if (i == Integer.MIN_VALUE) {
                i = dVar.f6009a;
            }
            dVar.e(i);
        }
    }

    public void k() {
        l(null);
    }

    public void l(@Nullable f fVar) {
        d<? extends e> dVar = this.b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.f6007a.execute(new g(fVar));
        }
        this.f6007a.shutdown();
    }

    public <T extends e> long m(T t, b<T> bVar, int i) {
        Looper looper = (Looper) vh.i(Looper.myLooper());
        this.c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new d(looper, t, bVar, i, jElapsedRealtime).f(0L);
        return jElapsedRealtime;
    }

    @Override // defpackage.q43
    public void maybeThrowError() throws IOException {
        j(Integer.MIN_VALUE);
    }
}
