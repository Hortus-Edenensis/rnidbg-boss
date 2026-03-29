package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class po6 extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Runnable> f20060a;
    public final SparseArray<b> b;
    public Handler c;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f20061a;
        public final long b;

        public b(@NonNull Runnable runnable, long j) {
            this.f20061a = runnable;
            this.b = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final po6 f20062a = new po6();
    }

    public po6() {
        super("OplusTrack-thread");
        this.f20060a = new ArrayList();
        this.b = new SparseArray<>();
        start();
    }

    public static po6 b() {
        return c.f20062a;
    }

    public static void d(Runnable runnable) {
        b().h(runnable);
    }

    public static /* synthetic */ String f() {
        return "onLooperPrepared, but looper is null";
    }

    public synchronized void c(int i, @NonNull Runnable runnable, long j) {
        Handler handler = this.c;
        if (handler != null) {
            handler.postDelayed(runnable, j);
        } else {
            this.b.put(i, new b(runnable, j));
        }
    }

    public synchronized boolean e(int i) {
        Handler handler = this.c;
        if (handler != null) {
            return handler.hasMessages(i);
        }
        return this.b.get(i) != null;
    }

    public synchronized void g(int i) {
        Handler handler = this.c;
        if (handler != null) {
            handler.removeMessages(i);
        } else {
            this.b.remove(i);
        }
    }

    public synchronized void h(Runnable runnable) {
        Handler handler = this.c;
        if (handler != null) {
            handler.post(runnable);
        } else {
            this.f20060a.add(runnable);
        }
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        Looper looper = getLooper();
        if (looper == null) {
            n87.a("WorkThread", new la7() { // from class: oo6
                @Override // defpackage.la7
                public final Object get() {
                    return po6.f();
                }
            });
            return;
        }
        synchronized (this) {
            this.c = new Handler(looper);
            Iterator<Runnable> it = this.f20060a.iterator();
            while (it.hasNext()) {
                this.c.post(it.next());
            }
            this.f20060a.clear();
            for (int i = 0; i < this.b.size(); i++) {
                b bVarValueAt = this.b.valueAt(i);
                this.c.postDelayed(bVarValueAt.f20061a, bVarValueAt.b);
            }
            this.b.clear();
        }
    }
}
