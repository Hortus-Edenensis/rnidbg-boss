package defpackage;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import defpackage.tz6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class v87 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f21382a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static Context d;

    public static HashMap<String, String> a(int i) {
        int iA = lx6.a(i);
        if (iA != 10000) {
            throw new RuntimeException(iA + "");
        }
        List<String> listL = lx6.l(i);
        if (b()) {
            return tz6.b.f21101a.a(d, listL);
        }
        HashMap<String, String> map = new HashMap<>();
        for (String str : (ArrayList) listL) {
            map.put(str, str == "OUID_STATUS" ? "FALSE" : "");
        }
        return map;
    }

    public static boolean b() {
        String str;
        if (!f21382a) {
            str = "1001";
        } else if (!b && !c) {
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
