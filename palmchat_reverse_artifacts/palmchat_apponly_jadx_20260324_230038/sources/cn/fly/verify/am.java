package cn.fly.verify;

import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f2071a;
    public static ExecutorService b = Executors.newSingleThreadExecutor();

    public static String a() {
        if (TextUtils.isEmpty(f2071a)) {
            f2071a = bx.a(new be());
        }
        return f2071a;
    }
}
