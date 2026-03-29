package defpackage;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import defpackage.z17;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class p87 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f19962a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static Context d;

    public static String a(int i, String str) {
        HashMap<String, String> mapA;
        if (!f19962a) {
            Log.e("IDHelper", "1001");
            return "";
        }
        if (!c) {
            mapA = v87.a(i);
        } else {
            if (!d()) {
                return "";
            }
            mapA = b(i);
        }
        return mapA.get(str) == null ? "" : mapA.get(str);
    }

    public static HashMap<String, String> b(int i) {
        int iA = lx6.a(i);
        if (iA == 10000) {
            return z17.a.f22322a.a(d, lx6.l(i));
        }
        throw new RuntimeException(iA + "");
    }

    public static boolean c() {
        if (!f19962a) {
            Log.e("IDHelper", "1001");
            return false;
        }
        if (c) {
            return b;
        }
        if (!v87.f21382a) {
            Log.e("IDHelper", "1001");
        }
        return v87.b || v87.c;
    }

    public static boolean d() {
        String str;
        if (!b) {
            str = "1002";
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return true;
            }
            str = "1003";
        }
        Log.e("IDHelper", str);
        return false;
    }
}
