package defpackage;

import android.text.TextUtils;
import com.lantern.auth.app.WkConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class n44 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f19436a;

    static {
        HashMap map = new HashMap();
        f19436a = map;
        map.put("00500103", j());
        map.put("00500102", j());
        map.put("getOauthKey", c());
        map.put("getOauthCode", c());
        map.put("00200102", c());
        map.put("00200105", c());
        map.put("00600001", k());
        map.put("00600002", k());
        map.put("00600003", k());
        map.put("00600005", k());
        map.put("00600006", k());
        map.put("00600007", k());
        map.put("00600008", k());
        map.put("00600009", k());
    }

    public static String a() {
        return "https://open-ams.y5kfpt.com";
    }

    public static String b() {
        return m() ? WkConstants.ServerConsts.HOST_NAME_PB_TEST : "https://open-oauth.y5kfpt.com";
    }

    public static String c() {
        return b() + "/lx-oauth/fn.se";
    }

    public static String d() {
        return a() + "/lx-ams/auth/native";
    }

    public static String e() {
        return m() ? "https://appcenter2.lx-qa.com/#/gameauth" : "https://appcenter.cdn.lianxinapp.com/#/gameauth";
    }

    public static String f() {
        return "http://static.cdn.lianxinapp.com/icon/dsuXXUSCCnpOEy2u0nMZ7B0M1a1defxpGbjmfTqd.png";
    }

    public static String g() {
        return a() + "/lx-ams/auth";
    }

    public static String h(String str) {
        return m() ? WkConstants.ServerConsts.HOST_NAME_PB_TEST : str;
    }

    public static final String i() {
        return m() ? WkConstants.ServerConsts.HOST_NAME_PB_TEST : "https://open-real.y5kfpt.com";
    }

    public static final String j() {
        return i() + "/real/fn.se";
    }

    public static final String k() {
        return h("https://open-square.y5kfpt.com") + "/square/se.do";
    }

    public static String l(String str) {
        String str2 = f19436a.get(str);
        return TextUtils.isEmpty(str2) ? c() : str2;
    }

    public static boolean m() {
        String strC = nl0.c();
        strC.hashCode();
        switch (strC) {
            case "debug2":
            case "debug3":
            case "dev":
            case "debug":
                return true;
            default:
                return false;
        }
    }
}
