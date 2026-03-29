package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class su6 {
    public static Context g;
    public static su6 h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20849a;
    public String b;
    public long c;
    public String d;
    public String e;
    public boolean f = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public static String a() {
            String packageName;
            try {
                packageName = su6.g.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                w97.d(th);
                packageName = "";
            }
            return (packageName + "0000000000000000000000000000").substring(0, 24);
        }

        public static String b(String str, String str2, boolean z) {
            if (su6.g == null) {
                return null;
            }
            String string = su6.g.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z) {
                string = ta7.a(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    w97.f("mspl", "tid_str: pref failed");
                }
            }
            w97.f("mspl", "tid_str: from local");
            return string;
        }

        public static void c(String str, String str2, String str3, boolean z) {
            if (su6.g == null) {
                return;
            }
            SharedPreferences sharedPreferences = su6.g.getSharedPreferences(str, 0);
            if (z) {
                String strA = a();
                String strC = ta7.c(strA, str3, str3);
                if (TextUtils.isEmpty(strC)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, strA);
                }
                str3 = strC;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static void d(String str, String str2) {
            if (su6.g == null) {
                return;
            }
            su6.g.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }
    }

    public static synchronized su6 a(Context context) {
        if (h == null) {
            h = new su6();
        }
        if (g == null) {
            h.e(context);
        }
        return h;
    }

    public void b(String str, String str2) {
        w97.f("mspl", "tid_str: save");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f20849a = str;
        this.b = str2;
        this.c = System.currentTimeMillis();
        l();
        m();
    }

    public final boolean c(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    public String d() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public final void e(Context context) {
        if (context != null) {
            g = context.getApplicationContext();
        }
        if (this.f) {
            return;
        }
        this.f = true;
        j();
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.f20849a;
    }

    public final String i() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j() {
        String strOptString;
        String strOptString2;
        String strOptString3;
        String str;
        String strB;
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        String strOptString4 = null;
        try {
            strB = a.b("alipay_tid_storage", "tidinfo", true);
        } catch (Exception e) {
            e = e;
            strOptString = null;
            strOptString2 = null;
        }
        if (!TextUtils.isEmpty(strB)) {
            JSONObject jSONObject = new JSONObject(strB);
            strOptString = jSONObject.optString("tid", "");
            try {
                strOptString2 = jSONObject.optString("client_key", "");
                try {
                    lValueOf = Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
                    strOptString3 = jSONObject.optString("vimei", "");
                } catch (Exception e2) {
                    e = e2;
                    strOptString3 = null;
                }
            } catch (Exception e3) {
                e = e3;
                strOptString2 = null;
                strOptString3 = strOptString2;
            }
            try {
                strOptString4 = jSONObject.optString("vimsi", "");
            } catch (Exception e4) {
                e = e4;
                w97.d(e);
            }
            str = strOptString4;
            strOptString4 = strOptString;
            w97.f("mspl", "tid_str: load");
            if (c(strOptString4, strOptString2, strOptString3, str)) {
                k();
                return;
            }
            this.f20849a = strOptString4;
            this.b = strOptString2;
            this.c = lValueOf.longValue();
            this.d = strOptString3;
            this.e = str;
            return;
        }
        str = null;
        strOptString2 = null;
        strOptString3 = null;
        w97.f("mspl", "tid_str: load");
        if (c(strOptString4, strOptString2, strOptString3, str)) {
        }
        strOptString3 = strOptString2;
        w97.d(e);
        str = strOptString4;
        strOptString4 = strOptString;
        w97.f("mspl", "tid_str: load");
        if (c(strOptString4, strOptString2, strOptString3, str)) {
        }
    }

    public final void k() {
        this.f20849a = "";
        this.b = d();
        this.c = System.currentTimeMillis();
        this.d = i();
        this.e = i();
        a.d("alipay_tid_storage", "tidinfo");
    }

    public final void l() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f20849a);
            jSONObject.put("client_key", this.b);
            jSONObject.put("timestamp", this.c);
            jSONObject.put("vimei", this.d);
            jSONObject.put("vimsi", this.e);
            a.c("alipay_tid_storage", "tidinfo", jSONObject.toString(), true);
        } catch (Exception e) {
            w97.d(e);
        }
    }

    public final void m() {
    }
}
