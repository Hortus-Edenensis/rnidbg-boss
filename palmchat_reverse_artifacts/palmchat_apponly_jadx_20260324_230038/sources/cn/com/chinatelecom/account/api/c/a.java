package cn.com.chinatelecom.account.api.c;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static Executor b = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f2041a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        b.execute(runnable);
    }
}
