package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class sb7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f20707a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f20708a;

        public a(Handler handler) {
            this.f20708a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f20708a.post(runnable);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final co6 f20709a;
        public final do6 b;

        public b(co6 co6Var, do6 do6Var) {
            this.f20709a = co6Var;
            this.b = do6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            do6 do6Var;
            co6 co6Var = this.f20709a;
            if (co6Var == null || co6Var.m() || (do6Var = this.b) == null) {
                return;
            }
            if (do6Var.d()) {
                this.f20709a.c(this.b.c());
            } else {
                this.f20709a.b(this.b.b());
            }
        }
    }

    public sb7(Handler handler) {
        this.f20707a = new a(handler);
    }

    public void a(co6 co6Var, do6 do6Var) {
        this.f20707a.execute(new b(co6Var, do6Var));
    }

    public void b(co6 co6Var, Exception exc) {
        this.f20707a.execute(new b(co6Var, do6.a(exc)));
    }
}
