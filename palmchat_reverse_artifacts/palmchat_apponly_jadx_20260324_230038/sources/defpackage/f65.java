package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class f65 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17466a;
    public String b;
    public String c;
    public boolean d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public boolean j;
    public String k;
    public String l;

    public static String a() {
        f65 f65VarE = e();
        return (f65VarE == null || TextUtils.isEmpty(f65VarE.b)) ? AppContext.getContext().getString(R.string.about_competence) : f65VarE.b;
    }

    public static String b() {
        f65 f65VarE = e();
        return tj2.A((f65VarE == null || TextUtils.isEmpty(f65VarE.c)) ? tj2.e() : f65VarE.c);
    }

    public static String c() {
        f65 f65VarE = e();
        return (f65VarE == null || TextUtils.isEmpty(f65VarE.k)) ? "隐私政策（简明版）" : f65VarE.k;
    }

    public static String d() {
        f65 f65VarE = e();
        return tj2.A((f65VarE == null || TextUtils.isEmpty(f65VarE.l)) ? tj2.b() : f65VarE.l);
    }

    public static f65 e() {
        JSONObject jSONObjectA = ts0.o().A();
        LogUtil.i("ServicePerceptionConfig", "getConfig " + jSONObjectA);
        if (jSONObjectA == null) {
            return null;
        }
        f65 f65Var = new f65();
        f65Var.f17466a = jSONObjectA.optBoolean("competence", false);
        f65Var.b = jSONObjectA.optString("competence_txt");
        f65Var.c = jSONObjectA.optString("competence_url");
        f65Var.d = jSONObjectA.optBoolean("Expresslist", false);
        f65Var.e = jSONObjectA.optString("Expresslist_txt");
        f65Var.f = jSONObjectA.optString("Expresslist_url");
        f65Var.g = jSONObjectA.optBoolean("Sharedlist", false);
        f65Var.h = jSONObjectA.optString("Sharedlist_txt");
        f65Var.i = jSONObjectA.optString("Sharedlist_url");
        f65Var.j = jSONObjectA.optBoolean("PrivacyConciseversion", false);
        f65Var.k = jSONObjectA.optString("PrivacyConciseversion_txt");
        f65Var.l = jSONObjectA.optString("PrivacyConciseversion_url");
        return f65Var;
    }

    public static String f() {
        f65 f65VarE = e();
        return (f65VarE == null || TextUtils.isEmpty(f65VarE.e)) ? AppContext.getContext().getString(R.string.about_expresslist) : f65VarE.e;
    }

    public static String g() {
        f65 f65VarE = e();
        return tj2.A((f65VarE == null || TextUtils.isEmpty(f65VarE.f)) ? tj2.g() : f65VarE.f);
    }

    public static String h() {
        f65 f65VarE = e();
        return (f65VarE == null || TextUtils.isEmpty(f65VarE.h)) ? AppContext.getContext().getString(R.string.about_sharedlist) : f65VarE.h;
    }

    public static String i() {
        f65 f65VarE = e();
        return tj2.A((f65VarE == null || TextUtils.isEmpty(f65VarE.i)) ? tj2.v() : f65VarE.i);
    }

    public static boolean j(boolean z) {
        f65 f65VarE;
        if (!z || (f65VarE = e()) == null) {
            return false;
        }
        return f65VarE.f17466a;
    }

    public static boolean k() {
        f65 f65VarE = e();
        if (f65VarE != null) {
            return f65VarE.j;
        }
        return false;
    }

    public static boolean l(boolean z) {
        f65 f65VarE;
        if (!z || (f65VarE = e()) == null) {
            return false;
        }
        return f65VarE.d;
    }

    public static boolean m(boolean z) {
        f65 f65VarE;
        if (!z || (f65VarE = e()) == null) {
            return false;
        }
        return f65VarE.g;
    }
}
