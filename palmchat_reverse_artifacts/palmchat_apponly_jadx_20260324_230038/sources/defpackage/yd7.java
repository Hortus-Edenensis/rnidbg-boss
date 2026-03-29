package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class yd7<TResult> implements ho1<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s74<TResult> f22181a;
    public Executor b;
    public final Object c = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f22182a;

        public a(Task task) {
            this.f22182a = task;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (yd7.this.c) {
                if (yd7.this.f22181a != null) {
                    yd7.this.f22181a.onSuccess(this.f22182a.e());
                }
            }
        }
    }

    public yd7(Executor executor, s74<TResult> s74Var) {
        this.f22181a = s74Var;
        this.b = executor;
    }

    @Override // defpackage.ho1
    public final void onComplete(Task<TResult> task) {
        if (!task.h() || task.f()) {
            return;
        }
        this.b.execute(new a(task));
    }
}
