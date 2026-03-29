package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class mt5 {
    public static final mt5 d = new mt5();
    public final ExecutorService b = rv6.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f19366a = new a();
    public final Executor c = rv6.b();

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static ExecutorService a() {
        return d.b;
    }

    public static Executor b() {
        return d.c;
    }
}
