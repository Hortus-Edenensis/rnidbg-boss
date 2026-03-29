package defpackage;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public final class a92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f1178a = new a();
    public static long b = -1;
    public static int c = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f1179a = 1440;
        public static int b = 1;

        public a() {
        }
    }

    public static boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (b == -1) {
            b = jCurrentTimeMillis;
        }
        if ((Math.abs(jCurrentTimeMillis - b) / 1000) / 60 > a.f1179a) {
            b = jCurrentTimeMillis;
            c = 0;
        }
        return c + 1 <= a.b;
    }

    public static a b(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject == null) {
            return aVar;
        }
        int iOptInt = jSONObject.optInt("frequency_time", a.f1179a);
        if (iOptInt < 0) {
            iOptInt = a.f1179a;
        }
        a.f1179a = iOptInt;
        int iOptInt2 = jSONObject.optInt("frequency_pv", a.b);
        if (iOptInt2 < 0) {
            iOptInt2 = a.b;
        }
        a.b = iOptInt2;
        return aVar;
    }

    public static void c(String str) {
        f1178a = new a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f1178a = b(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(String str) {
        f1178a = new a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f1178a = b(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
