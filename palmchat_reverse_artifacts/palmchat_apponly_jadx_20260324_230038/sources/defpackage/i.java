package defpackage;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class i {
    public static i a(j jVar) {
        return oz6.g(jVar);
    }

    public static i c() {
        return oz6.f();
    }

    public static void e(Context context) {
        Log.i("AGConnectInstance", "AGConnectInstance#initialize");
        oz6.j(context);
    }

    public abstract Context b();

    public abstract j d();
}
