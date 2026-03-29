package defpackage;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ui6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler.Callback f21220a;
    public final b b;
    public Lock c;

    @VisibleForTesting
    public final a d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public a f21221a;

        @Nullable
        public a b;

        @NonNull
        public final Runnable c;

        @NonNull
        public final c d;

        @NonNull
        public Lock e;

        public a(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.c = runnable;
            this.e = lock;
            this.d = new c(new WeakReference(runnable), new WeakReference(this));
        }

        public void a(@NonNull a aVar) {
            this.e.lock();
            try {
                a aVar2 = this.f21221a;
                if (aVar2 != null) {
                    aVar2.b = aVar;
                }
                aVar.f21221a = aVar2;
                this.f21221a = aVar;
                aVar.b = this;
            } finally {
                this.e.unlock();
            }
        }

        public c b() {
            this.e.lock();
            try {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.f21221a = this.f21221a;
                }
                a aVar2 = this.f21221a;
                if (aVar2 != null) {
                    aVar2.b = aVar;
                }
                this.b = null;
                this.f21221a = null;
                this.e.unlock();
                return this.d;
            } catch (Throwable th) {
                this.e.unlock();
                throw th;
            }
        }

        @Nullable
        public c c(Runnable runnable) {
            this.e.lock();
            try {
                for (a aVar = this.f21221a; aVar != null; aVar = aVar.f21221a) {
                    if (aVar.c == runnable) {
                        return aVar.b();
                    }
                }
                this.e.unlock();
                return null;
            } finally {
                this.e.unlock();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Handler.Callback> f21222a = null;

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Handler.Callback callback;
            WeakReference<Handler.Callback> weakReference = this.f21222a;
            if (weakReference == null || (callback = weakReference.get()) == null) {
                return;
            }
            callback.handleMessage(message);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Runnable> f21223a;
        public final WeakReference<a> b;

        public c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.f21223a = weakReference;
            this.b = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f21223a.get();
            a aVar = this.b.get();
            if (aVar != null) {
                aVar.b();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public ui6() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.c = reentrantLock;
        this.d = new a(reentrantLock, null);
        this.f21220a = null;
        this.b = new b();
    }

    public final boolean a(@NonNull Runnable runnable) {
        return this.b.post(e(runnable));
    }

    public final boolean b(Runnable runnable, long j) {
        return this.b.postDelayed(e(runnable), j);
    }

    public final void c(Runnable runnable) {
        c cVarC = this.d.c(runnable);
        if (cVarC != null) {
            this.b.removeCallbacks(cVarC);
        }
    }

    public final void d(Object obj) {
        this.b.removeCallbacksAndMessages(obj);
    }

    public final c e(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.c, runnable);
        this.d.a(aVar);
        return aVar.d;
    }
}
