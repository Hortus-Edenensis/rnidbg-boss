package defpackage;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u77 {
    public static volatile u77 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tt6 f21156a;

    public u77(Context context) {
        this.f21156a = new tt6(context);
    }

    public static u77 a(Context context) {
        if (b == null) {
            synchronized (u77.class) {
                if (b == null) {
                    b = new u77(context);
                }
            }
        }
        return b;
    }

    public static JSONArray b() {
        return new JSONArray();
    }

    public static JSONObject c(long j) {
        return new JSONObject();
    }

    public static void e() {
        if (b == null || b.f21156a == null) {
            return;
        }
        b.f21156a.m();
    }

    public static void f() {
        if (b == null || b.f21156a == null) {
            return;
        }
        b.f21156a.u();
    }

    public static void g() {
        if (b == null || b.f21156a == null) {
            return;
        }
        b.f21156a.t();
    }

    public void d() {
        this.f21156a.d();
    }
}
