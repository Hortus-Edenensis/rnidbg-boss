package defpackage;

import defpackage.df7;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class rt5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static df7 f20569a = new df7();

    public static <TResult> TResult a(Task<TResult> task) throws ExecutionException, InterruptedException {
        df7.c("await must not be called on the UI thread");
        if (task.g()) {
            return (TResult) df7.b(task);
        }
        df7.b bVar = new df7.b();
        task.c(bVar).b(bVar);
        bVar.f17042a.await();
        return (TResult) df7.b(task);
    }

    public static <TResult> Task<TResult> b(Callable<TResult> callable) {
        return f20569a.a(mt5.a(), callable);
    }
}
