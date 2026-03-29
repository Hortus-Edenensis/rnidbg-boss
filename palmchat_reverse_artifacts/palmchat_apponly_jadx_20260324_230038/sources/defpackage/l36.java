package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.zenmen.palmchat.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class l36 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f18898a = new Handler(Looper.getMainLooper());

    public static Context a() {
        return c.b();
    }

    public static Resources b() {
        return a().getResources();
    }

    public static View c(int i) {
        return View.inflate(a(), i, null);
    }

    public static void d(Runnable runnable) {
        if (runnable != null) {
            f18898a.post(runnable);
        }
    }
}
