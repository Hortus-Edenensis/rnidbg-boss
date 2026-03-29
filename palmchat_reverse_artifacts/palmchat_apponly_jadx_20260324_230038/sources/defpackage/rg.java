package defpackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import j$.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class rg {
    public static final rg e = new rg();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f20462a = Executors.newSingleThreadExecutor();
    public final ExecutorService b = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    public final Handler c;
    public final Executor d;

    public rg() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.c = handler;
        Objects.requireNonNull(handler);
        this.d = new bl0(handler);
    }

    public static void a(@NonNull Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            b().execute(runnable);
        }
    }

    public static Executor b() {
        return e.d;
    }

    public static ExecutorService c() {
        return e.b;
    }
}
