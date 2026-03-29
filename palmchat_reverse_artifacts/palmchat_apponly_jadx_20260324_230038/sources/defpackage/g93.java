package defpackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class g93<T> {
    public static Executor e = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<y83<T>> f17682a;
    public final Set<y83<Throwable>> b;
    public final Handler c;

    @Nullable
    public volatile e93<T> d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends FutureTask<e93<T>> {
        public a(Callable<e93<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                g93.this.k(get());
            } catch (InterruptedException | ExecutionException e) {
                g93.this.k(new e93(e));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g93(Callable<e93<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        e93<T> e93Var = this.d;
        if (e93Var == null) {
            return;
        }
        if (e93Var.b() != null) {
            h(e93Var.b());
        } else {
            f(e93Var.a());
        }
    }

    public synchronized g93<T> c(y83<Throwable> y83Var) {
        e93<T> e93Var = this.d;
        if (e93Var != null && e93Var.a() != null) {
            y83Var.onResult(e93Var.a());
        }
        this.b.add(y83Var);
        return this;
    }

    public synchronized g93<T> d(y83<T> y83Var) {
        e93<T> e93Var = this.d;
        if (e93Var != null && e93Var.b() != null) {
            y83Var.onResult(e93Var.b());
        }
        this.f17682a.add(y83Var);
        return this;
    }

    public final synchronized void f(Throwable th) {
        ArrayList arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            m63.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((y83) it.next()).onResult(th);
        }
    }

    public final void g() {
        this.c.post(new Runnable() { // from class: f93
            @Override // java.lang.Runnable
            public final void run() {
                this.f17480a.e();
            }
        });
    }

    public final synchronized void h(T t) {
        Iterator it = new ArrayList(this.f17682a).iterator();
        while (it.hasNext()) {
            ((y83) it.next()).onResult(t);
        }
    }

    public synchronized g93<T> i(y83<Throwable> y83Var) {
        this.b.remove(y83Var);
        return this;
    }

    public synchronized g93<T> j(y83<T> y83Var) {
        this.f17682a.remove(y83Var);
        return this;
    }

    public final void k(@Nullable e93<T> e93Var) {
        if (this.d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.d = e93Var;
        g();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g93(Callable<e93<T>> callable, boolean z) {
        this.f17682a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        if (!z) {
            e.execute(new a(callable));
            return;
        }
        try {
            k(callable.call());
        } catch (Throwable th) {
            k(new e93<>(th));
        }
    }
}
