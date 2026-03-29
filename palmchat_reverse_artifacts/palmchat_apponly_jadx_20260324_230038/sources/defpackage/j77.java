package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class j77<TResult> implements ho1<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s64<TResult> f18341a;
    public Executor b;
    public final Object c = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f18342a;

        public a(Task task) {
            this.f18342a = task;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (j77.this.c) {
                if (j77.this.f18341a != null) {
                    j77.this.f18341a.onComplete(this.f18342a);
                }
            }
        }
    }

    public j77(Executor executor, s64<TResult> s64Var) {
        this.f18341a = s64Var;
        this.b = executor;
    }

    @Override // defpackage.ho1
    public final void onComplete(Task<TResult> task) {
        this.b.execute(new a(task));
    }
}
