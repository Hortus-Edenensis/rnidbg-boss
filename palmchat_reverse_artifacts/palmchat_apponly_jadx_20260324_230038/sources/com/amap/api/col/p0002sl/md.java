package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.fs;
import com.igexin.push.core.b;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class md {
    private static volatile boolean i = false;
    private static boolean j = true;
    private static int k = 1000;
    private static int l = 200;
    private static boolean m = false;
    private static int n = 20;
    private static int o = 0;
    private static volatile int p = 0;
    private static boolean q = true;
    private static boolean r = false;
    private static int s = -1;
    private static long t;
    private static ArrayList<String> u = new ArrayList<>();
    private static ArrayList<String> v = new ArrayList<>();
    private static volatile boolean w = false;
    private static boolean x = true;
    private static long y = 300000;
    private static boolean z = false;
    private static double A = 0.618d;
    private static boolean B = true;
    private static int C = 80;
    private static int D = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static long f2997a = 3600000;
    private static boolean E = false;
    private static boolean F = true;
    private static boolean G = false;
    public static volatile long b = 0;
    static boolean c = false;
    private static boolean H = true;
    private static long I = -1;
    private static boolean J = true;
    private static int K = 1;
    private static boolean L = false;
    private static int M = 5;
    private static boolean N = false;
    private static String O = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
    private static long P = 0;
    public static boolean d = false;
    public static boolean e = false;
    public static int f = 20480;
    public static int g = 10800000;
    public static boolean h = false;

    public static void a(final Context context) {
        if (i) {
            return;
        }
        i = true;
        fs.a(context, me.c(), me.d(), new fs.a() { // from class: com.amap.api.col.2sl.md.1
            @Override // com.amap.api.col.2sl.fs.a
            public final void a(fs.b bVar) {
                md.a(context, bVar);
            }
        });
    }

    public static int b() {
        return l;
    }

    public static int c() {
        if (p < 0) {
            p = 0;
        }
        return p;
    }

    public static long d() {
        return y;
    }

    public static boolean e() {
        return x;
    }

    public static boolean f() {
        return z;
    }

    public static double g() {
        return A;
    }

    public static boolean h() {
        return B;
    }

    public static int i() {
        return C;
    }

    public static int j() {
        return D;
    }

    public static boolean k() {
        return F;
    }

    public static boolean l() {
        return G;
    }

    public static boolean m() {
        return c;
    }

    public static boolean n() {
        return H;
    }

    public static long o() {
        return I;
    }

    public static boolean p() {
        return N;
    }

    public static boolean q() {
        return L;
    }

    public static String r() {
        return ge.c(O);
    }

    public static boolean s() {
        return J && K > 0;
    }

    public static int t() {
        return K;
    }

    public static long u() {
        return P;
    }

    private static void b(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("197");
            if (jSONObject2 != null) {
                boolean zA = fs.a(jSONObject2.optString("able"), false);
                ml.a(editor, "197a", zA);
                if (zA) {
                    ml.a(editor, "197dv", jSONObject2.optString("sv", ""));
                    ml.a(editor, "197tv", jSONObject2.optString("tv", ""));
                } else {
                    ml.a(editor, "197dv", "");
                    ml.a(editor, "197tv", "");
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("13J");
            if (jSONObjectOptJSONObject != null) {
                boolean zA = fs.a(jSONObjectOptJSONObject.optString("able"), true);
                B = zA;
                if (zA) {
                    C = jSONObjectOptJSONObject.optInt("c", C);
                    D = jSONObjectOptJSONObject.optInt("t", D);
                }
                ml.a(editor, "13J_able", B);
                ml.a(editor, "13J_c", C);
                ml.a(editor, "13J_t", D);
            }
        } catch (Throwable th) {
            me.a(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    private static void e(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean zA = fs.a(jSONObject.optString("re"), false);
            c = zA;
            ml.a(editor, "fr", zA);
        } catch (Throwable th) {
            me.a(th, "AuthUtil", "checkReLocationAble");
        }
    }

    private static void f(JSONObject jSONObject, SharedPreferences.Editor editor) {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("15O");
            if (jSONObjectOptJSONObject != null) {
                if (fs.a(jSONObjectOptJSONObject.optString("able"), false) && ((jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("fl")) == null || jSONArrayOptJSONArray.length() <= 0 || jSONArrayOptJSONArray.toString().contains(Build.MANUFACTURER))) {
                    I = jSONObjectOptJSONObject.optInt("iv", 30) * 1000;
                } else {
                    I = -1L;
                }
                ml.a(editor, "awsi", I);
            }
        } catch (Throwable unused) {
        }
    }

    private static void g(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean zA = fs.a(jSONObject2.optString("able"), false);
                d = zA;
                ml.a(editor, "17ya", zA);
                boolean zA2 = fs.a(jSONObject2.optString("mup"), false);
                e = zA2;
                ml.a(editor, "17ym", zA2);
                int iOptInt = jSONObject2.optInt("max", 20);
                if (iOptInt > 0) {
                    ml.a(editor, "17yx", iOptInt);
                    f = iOptInt * 1024;
                }
                int iOptInt2 = jSONObject2.optInt("inv", 3);
                if (iOptInt2 > 0) {
                    ml.a(editor, "17yi", iOptInt2);
                    g = iOptInt2 * 60 * 60 * 1000;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void h(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("15U");
            if (jSONObjectOptJSONObject != null) {
                boolean zA = fs.a(jSONObjectOptJSONObject.optString("able"), true);
                int iOptInt = jSONObjectOptJSONObject.optInt("yn", K);
                P = jSONObjectOptJSONObject.optLong("sysTime", P);
                ml.a(editor, "15ua", zA);
                ml.a(editor, "15un", iOptInt);
                ml.a(editor, "15ust", P);
            }
        } catch (Throwable unused) {
        }
    }

    private static void i(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int i2;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("17J");
            if (jSONObjectOptJSONObject != null) {
                boolean zA = fs.a(jSONObjectOptJSONObject.optString("able"), false);
                L = zA;
                ml.a(editor, "ok9", zA);
                if (zA) {
                    String strOptString = jSONObjectOptJSONObject.optString("auth");
                    String strOptString2 = jSONObjectOptJSONObject.optString("ht");
                    O = strOptString2;
                    ml.a(editor, "ok11", strOptString2);
                    fs.a(strOptString, false);
                    N = fs.a(jSONObjectOptJSONObject.optString("nr"), false);
                    String strOptString3 = jSONObjectOptJSONObject.optString("tm");
                    if (TextUtils.isEmpty(strOptString3) || (i2 = Integer.parseInt(strOptString3)) <= 0 || i2 >= 20) {
                        return;
                    }
                    M = i2;
                    ml.a(editor, "ok10", i2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        return j;
    }

    private static void c(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("1A6");
            if (jSONObject2 != null) {
                boolean zA = fs.a(jSONObject2.optString("ic"), false);
                ml.a(editor, "1A6", zA);
                h = zA;
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(fs.b bVar, SharedPreferences.Editor editor) {
        try {
            fs.b.a aVar = bVar.g;
            if (aVar != null) {
                boolean z2 = aVar.f2794a;
                j = z2;
                ml.a(editor, "exception", z2);
                JSONObject jSONObject = aVar.c;
                if (jSONObject != null) {
                    k = jSONObject.optInt("fn", k);
                    int iOptInt = jSONObject.optInt("mpn", l);
                    l = iOptInt;
                    if (iOptInt > 500) {
                        l = 500;
                    }
                    if (l < 30) {
                        l = 30;
                    }
                    m = fs.a(jSONObject.optString("igu"), false);
                    n = jSONObject.optInt("ms", n);
                    p = jSONObject.optInt("rot", 0);
                    o = jSONObject.optInt("pms", 0);
                }
                ij.a(k, m, n, o);
                il.a(m, o);
                ml.a(editor, "fn", k);
                ml.a(editor, "mpn", l);
                ml.a(editor, "igu", m);
                ml.a(editor, "ms", n);
                ml.a(editor, "rot", p);
                ml.a(editor, "pms", o);
            }
        } catch (Throwable th) {
            me.a(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    public static void c(Context context) {
        try {
            gd gdVarC = me.c();
            gdVarC.a(j);
            hd.a(context, gdVarC);
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context) {
        if (w) {
            return;
        }
        w = true;
        try {
            j = ml.a(context, "pref", "exception", j);
            c(context);
        } catch (Throwable th) {
            me.a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            k = ml.a(context, "pref", "fn", k);
            l = ml.a(context, "pref", "mpn", l);
            m = ml.a(context, "pref", "igu", m);
            n = ml.a(context, "pref", "ms", n);
            p = ml.a(context, "pref", "rot", 0);
            int iA = ml.a(context, "pref", "pms", 0);
            o = iA;
            ij.a(k, m, n, iA);
            il.a(m, o);
        } catch (Throwable th2) {
            me.a(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            x = ml.a(context, "pref", b.ac, x);
            y = ml.a(context, "pref", "ct", y);
            z = ml.a(context, "pref", "11G_fa", z);
            double dDoubleValue = Double.valueOf(ml.a(context, "pref", "11G_ms", String.valueOf(A))).doubleValue();
            A = dDoubleValue;
            A = Math.max(0.2d, dDoubleValue);
        } catch (Throwable th3) {
            me.a(th3, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            c = ml.a(context, "pref", "fr", c);
        } catch (Throwable th4) {
            me.a(th4, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            H = ml.a(context, "pref", "asw", H);
        } catch (Throwable th5) {
            me.a(th5, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            I = ml.a(context, "pref", "awsi", I);
        } catch (Throwable th6) {
            me.a(th6, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            J = ml.a(context, "pref", "15ua", J);
            K = ml.a(context, "pref", "15un", K);
            P = ml.a(context, "pref", "15ust", P);
        } catch (Throwable th7) {
            me.a(th7, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            L = ml.a(context, "pref", "ok9", L);
            M = ml.a(context, "pref", "ok10", M);
            O = ml.a(context, "pref", "ok11", O);
        } catch (Throwable th8) {
            me.a(th8, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            d = ml.a(context, "pref", "17ya", false);
            e = ml.a(context, "pref", "17ym", false);
            g = ml.a(context, "pref", "17yi", 2) * 60 * 60 * 1000;
            f = ml.a(context, "pref", "17yx", 100) * 1024;
        } catch (Throwable th9) {
            me.a(th9, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            b = mm.b();
            f2997a = ml.a(context, "pref", "13S_at", f2997a);
            F = ml.a(context, "pref", "13S_nla", F);
            B = ml.a(context, "pref", "13J_able", B);
            C = ml.a(context, "pref", "13J_c", C);
            D = ml.a(context, "pref", "13J_t", D);
        } catch (Throwable th10) {
            me.a(th10, "AuthUtil", "loadLastAbleState p10");
        }
        fs.b(context);
        try {
            String strA = ml.a(context, "pref", "13S_mlpl", (String) null);
            if (!TextUtils.isEmpty(strA)) {
                G = a(context, new JSONArray(ge.c(strA)));
            }
        } catch (Throwable th11) {
            me.a(th11, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean zA = ml.a(context, "pref", "197a", false);
            String strA2 = ml.a(context, "pref", "197dv", "");
            String strA3 = ml.a(context, "pref", "197tv", "");
            if (zA && me.f2999a.equals(strA2)) {
                for (String str : me.b) {
                    if (str.equals(strA3)) {
                        me.f2999a = strA3;
                    }
                }
            }
        } catch (Throwable th12) {
            me.a(th12, "AuthUtil", "loadLastAbleState p12");
        }
        try {
            h = ml.a(context, "pref", "1A6", h);
        } catch (Throwable th13) {
            me.a(th13, "AuthUtil", "loadSdkEnableConfig p13");
        }
    }

    private static void a(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("11G");
            if (jSONObjectOptJSONObject != null) {
                boolean zA = fs.a(jSONObjectOptJSONObject.optString("able"), true);
                x = zA;
                if (zA) {
                    y = jSONObjectOptJSONObject.optInt("c", 300) * 1000;
                }
                z = fs.a(jSONObjectOptJSONObject.optString("fa"), false);
                A = Math.min(1.0d, Math.max(0.2d, jSONObjectOptJSONObject.optDouble("ms", 0.618d)));
                ml.a(editor, b.ac, x);
                ml.a(editor, "ct", y);
                ml.a(editor, "11G_fa", z);
                ml.a(editor, "11G_ms", String.valueOf(A));
            }
        } catch (Throwable th) {
            me.a(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    public static boolean a(Context context, fs.b bVar) {
        SharedPreferences.Editor editorA;
        try {
            editorA = ml.a(context, "pref");
        } catch (Throwable unused) {
            editorA = null;
        }
        try {
            a(bVar, editorA);
            c(context);
            JSONObject jSONObject = bVar.f;
            if (jSONObject == null) {
                if (editorA != null) {
                    try {
                        ml.a(editorA);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            }
            a(context, jSONObject, editorA);
            a(jSONObject, editorA);
            d(jSONObject, editorA);
            f(jSONObject, editorA);
            h(jSONObject, editorA);
            g(jSONObject, editorA);
            i(jSONObject, editorA);
            b(jSONObject, editorA);
            c(jSONObject, editorA);
            if (editorA != null) {
                try {
                    ml.a(editorA);
                } catch (Throwable unused3) {
                }
            }
            return true;
        } catch (Throwable unused4) {
            if (editorA == null) {
                return false;
            }
            try {
                ml.a(editorA);
                return false;
            } catch (Throwable unused5) {
                return false;
            }
        }
    }

    public static boolean a(long j2) {
        if (!x) {
            return false;
        }
        long jA = mm.a() - j2;
        long j3 = y;
        return j3 < 0 || jA < j3;
    }

    private static void a(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("13S");
            if (jSONObjectOptJSONObject != null) {
                try {
                    long jOptInt = jSONObjectOptJSONObject.optInt(t.u, 123) * 60 * 1000;
                    f2997a = jOptInt;
                    ml.a(editor, "13S_at", jOptInt);
                } catch (Throwable th) {
                    me.a(th, "AuthUtil", "requestSdkAuthInterval");
                }
                e(jSONObjectOptJSONObject, editor);
                try {
                    boolean zA = fs.a(jSONObjectOptJSONObject.optString("nla"), true);
                    F = zA;
                    ml.a(editor, "13S_nla", zA);
                } catch (Throwable unused) {
                }
                try {
                    boolean zA2 = fs.a(jSONObjectOptJSONObject.optString("asw"), true);
                    H = zA2;
                    ml.a(editor, "asw", zA2);
                } catch (Throwable unused2) {
                }
                try {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("mlpl");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0 && context != null) {
                        ml.a(editor, "13S_mlpl", ge.b(jSONArrayOptJSONArray.toString()));
                        G = a(context, jSONArrayOptJSONArray);
                    } else {
                        G = false;
                        ml.a(editor, "13S_mlpl");
                    }
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th2) {
            me.a(th2, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static boolean a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && context != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (mm.b(context, jSONArray.getString(i2))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
