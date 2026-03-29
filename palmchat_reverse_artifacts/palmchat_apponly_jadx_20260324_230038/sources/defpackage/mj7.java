package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mj7 {
    public static final d<f, Runnable> f = new a();
    public static final d<Message, Runnable> g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f19252a;
    public volatile Handler d;
    public final Queue<f> b = new ConcurrentLinkedQueue();
    public final Queue<Message> c = new ConcurrentLinkedQueue();
    public final Object e = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements d<f, Runnable> {
        @Override // mj7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(f fVar, Runnable runnable) {
            Message message;
            Message message2;
            return runnable == null ? fVar == null || (message2 = fVar.f19255a) == null || message2.getCallback() == null : (fVar == null || (message = fVar.f19255a) == null || !runnable.equals(message.getCallback())) ? false : true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements d<Message, Runnable> {
        @Override // mj7.d
        public boolean a(Message message, Runnable runnable) {
            return runnable == null ? message == null || message.getCallback() == null : message != null && runnable.equals(message.getCallback());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        public void a() {
            while (!mj7.this.b.isEmpty()) {
                f fVar = (f) mj7.this.b.poll();
                if (mj7.this.d != null) {
                    try {
                        mj7.this.d.sendMessageAtTime(fVar.f19255a, fVar.b);
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        public void b() {
            while (!mj7.this.c.isEmpty()) {
                if (mj7.this.d != null) {
                    try {
                        mj7.this.d.sendMessageAtFrontOfQueue((Message) mj7.this.c.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d<A, B> {
        boolean a(A a2, B b);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile int f19254a;
        public volatile boolean b;

        public e(String str) {
            super(str);
            this.f19254a = 0;
            this.b = false;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (mj7.this.e) {
                mj7.this.d = new Handler();
            }
            mj7.this.d.post(mj7.this.new c());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th) {
                    try {
                        u77.e();
                        if (this.f19254a < 5) {
                            n37.a();
                            n37.b("NPTH_CATCH", th);
                        } else if (!this.b) {
                            this.b = true;
                            n37.a();
                            n37.b("NPTH_ERR_MAX", new RuntimeException());
                        }
                        this.f19254a++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Message f19255a;
        public long b;

        public f(Message message, long j) {
            this.f19255a = message;
            this.b = j;
        }
    }

    public mj7(String str) {
        this.f19252a = new e(str);
    }

    public static <L, O> boolean g(Collection<L> collection, O o, d<? super L, O> dVar) {
        boolean z = false;
        if (collection != null && !collection.isEmpty() && dVar != null) {
            try {
                Iterator<L> it = collection.iterator();
                while (it.hasNext()) {
                    if (dVar.a(it.next(), o)) {
                        it.remove();
                        z = true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    public Handler a() {
        return this.d;
    }

    public final boolean d(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return k(message, SystemClock.uptimeMillis() + j);
    }

    public final boolean e(Runnable runnable) {
        return d(m(runnable), 0L);
    }

    public final boolean f(Runnable runnable, long j) {
        return d(m(runnable), j);
    }

    public void i() {
        this.f19252a.start();
    }

    public final void j(Runnable runnable) {
        if (!this.b.isEmpty() || !this.c.isEmpty()) {
            g(this.b, runnable, f);
            g(this.c, runnable, g);
        }
        if (this.d != null) {
            this.d.removeCallbacks(runnable);
        }
    }

    public final boolean k(Message message, long j) {
        if (this.d == null) {
            synchronized (this.e) {
                if (this.d == null) {
                    this.b.add(new f(message, j));
                    return true;
                }
            }
        }
        try {
            return this.d.sendMessageAtTime(message, j);
        } catch (Throwable unused) {
            return true;
        }
    }

    public HandlerThread l() {
        return this.f19252a;
    }

    public final Message m(Runnable runnable) {
        return Message.obtain(this.d, runnable);
    }
}
