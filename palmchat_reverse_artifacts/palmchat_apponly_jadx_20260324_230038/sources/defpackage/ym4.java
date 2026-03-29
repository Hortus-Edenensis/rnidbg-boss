package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ym4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22231a;
    public String b;
    public String c;
    public String d;

    public static String a(String str) {
        return (str == null || !str.startsWith("http://")) ? str : str.replace("http://", "https://");
    }

    public static ym4 b() {
        JSONObject jSONObjectV = ts0.o().v();
        LogUtil.i("PrivacyController_PrivacyConfig", "getConfig " + jSONObjectV);
        if (jSONObjectV == null) {
            return null;
        }
        ym4 ym4Var = new ym4();
        ym4Var.b = a(jSONObjectV.optString("url1", null));
        ym4Var.f22231a = jSONObjectV.optInt("ver", 0);
        ym4Var.c = a(jSONObjectV.optString("url2", null));
        ym4Var.d = jSONObjectV.optString("teenagerPrivacyUrl", null);
        return ym4Var;
    }

    public static String c() {
        String string;
        String strA = tj2.A(tj2.n());
        ym4 ym4VarB = b();
        if (ym4VarB == null) {
            Uri.Builder builderBuildUpon = Uri.parse(strA).buildUpon();
            builderBuildUpon.appendQueryParameter("version", String.valueOf(2));
            string = builderBuildUpon.build().toString();
        } else if (TextUtils.isEmpty(ym4VarB.b)) {
            Uri.Builder builderBuildUpon2 = Uri.parse(strA).buildUpon();
            builderBuildUpon2.appendQueryParameter("version", String.valueOf(ym4VarB.f22231a));
            string = builderBuildUpon2.build().toString();
        } else {
            string = ym4VarB.b;
        }
        LogUtil.i("PrivacyController_PrivacyConfig", "getLicenseUrl " + string);
        return string;
    }

    public static int d(boolean z) {
        ym4 ym4VarB = b();
        int iMax = ym4VarB != null ? ym4VarB.f22231a : 0;
        if (z) {
            iMax = Math.max(iMax, 2);
        }
        LogUtil.i("PrivacyController_PrivacyConfig", "getPrivacyConfigVersion " + iMax);
        return iMax;
    }

    public static String e() {
        String string;
        String strA = tj2.A(tj2.p());
        ym4 ym4VarB = b();
        if (ym4VarB == null) {
            Uri.Builder builderBuildUpon = Uri.parse(strA).buildUpon();
            builderBuildUpon.appendQueryParameter("version", String.valueOf(2));
            string = builderBuildUpon.build().toString();
        } else if (TextUtils.isEmpty(ym4VarB.c)) {
            Uri.Builder builderBuildUpon2 = Uri.parse(strA).buildUpon();
            builderBuildUpon2.appendQueryParameter("version", String.valueOf(ym4VarB.f22231a));
            string = builderBuildUpon2.build().toString();
        } else {
            string = ym4VarB.c;
        }
        LogUtil.i("PrivacyController_PrivacyConfig", "getPrivacyUrl " + string);
        return string;
    }

    public static String f() {
        String string;
        String strA = tj2.A(tj2.D());
        ym4 ym4VarB = b();
        if (ym4VarB == null) {
            Uri.Builder builderBuildUpon = Uri.parse(strA).buildUpon();
            builderBuildUpon.appendQueryParameter("version", String.valueOf(2));
            string = builderBuildUpon.build().toString();
        } else if (TextUtils.isEmpty(ym4VarB.d)) {
            Uri.Builder builderBuildUpon2 = Uri.parse(strA).buildUpon();
            builderBuildUpon2.appendQueryParameter("version", String.valueOf(ym4VarB.f22231a));
            string = builderBuildUpon2.build().toString();
        } else {
            string = ym4VarB.d;
        }
        LogUtil.i("PrivacyController_PrivacyConfig", "getTeenagerPrivacyUrl " + string);
        return string;
    }
}
