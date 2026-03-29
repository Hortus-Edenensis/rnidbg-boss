package defpackage;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class df7 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ it5 f17041a;
        public final /* synthetic */ Callable b;

        public a(it5 it5Var, Callable callable) {
            this.f17041a = it5Var;
            this.b = callable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f17041a.c(this.b.call());
            } catch (Exception e) {
                this.f17041a.b(e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b<TResult> implements w64, s74<TResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f17042a = new CountDownLatch(1);

        @Override // defpackage.w64
        public final void onFailure(Exception exc) {
            this.f17042a.countDown();
        }

        @Override // defpackage.s74
        public final void onSuccess(TResult tresult) {
            this.f17042a.countDown();
        }
    }

    public static <TResult> TResult b(Task<TResult> task) throws ExecutionException {
        if (task.h()) {
            return task.e();
        }
        throw new ExecutionException(task.d());
    }

    public static void c(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public final <TResult> Task<TResult> a(Executor executor, Callable<TResult> callable) {
        it5 it5Var = new it5();
        try {
            executor.execute(new a(it5Var, callable));
        } catch (Exception e) {
            it5Var.b(e);
        }
        return it5Var.a();
    }
}
