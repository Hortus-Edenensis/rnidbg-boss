package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class tb7<TResult> implements ho1<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w64 f20955a;
    public Executor b;
    public final Object c = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f20956a;

        public a(Task task) {
            this.f20956a = task;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (tb7.this.c) {
                if (tb7.this.f20955a != null) {
                    tb7.this.f20955a.onFailure(this.f20956a.d());
                }
            }
        }
    }

    public tb7(Executor executor, w64 w64Var) {
        this.f20955a = w64Var;
        this.b = executor;
    }

    @Override // defpackage.ho1
    public final void onComplete(Task<TResult> task) {
        if (task.h() || task.f()) {
            return;
        }
        this.b.execute(new a(task));
    }
}
