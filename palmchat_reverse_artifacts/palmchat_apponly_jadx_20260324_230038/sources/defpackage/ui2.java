package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.api.JCoreManager;
import com.oplus.tblplayer.monitor.ErrorCode;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ui2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<String, Integer> f21218a;
    public static final LinkedHashMap<String, Integer> b;
    public static final LinkedHashMap<String, Integer> c;
    public static final LinkedHashMap<String, Integer> d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static int j;
    public static String k;
    public static int l;

    static {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        f21218a = linkedHashMap;
        Integer numValueOf = Integer.valueOf(ErrorCode.REASON_DS_HTTP_OPEN);
        linkedHashMap.put("s.jpush.cn", numValueOf);
        linkedHashMap.put("sis.jpush.io", numValueOf);
        linkedHashMap.put("easytomessage.com", numValueOf);
        LinkedHashMap<String, Integer> linkedHashMap2 = new LinkedHashMap<>();
        b = linkedHashMap2;
        try {
            String str = new String(Base64.decode("MTIzLjE5Ni4xMTguMjM=", 2));
            String str2 = new String(Base64.decode("MTAzLjIyOS4yMTUuNjA=", 2));
            String str3 = new String(Base64.decode("MTE3LjEyMS40OS4xMDA=", 2));
            linkedHashMap2.put(str, numValueOf);
            linkedHashMap2.put(str2, numValueOf);
            linkedHashMap2.put(str3, numValueOf);
        } catch (Throwable unused) {
        }
        c = new LinkedHashMap<>();
        d = new LinkedHashMap<>();
        e = "";
        f = "";
        g = "";
        h = "";
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            k63.l("HostConfig", "conn info was empty");
            return;
        }
        k63.a("HostConfig", "get conn info=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("srv");
            k63.a("HostConfig", "save srvHost:" + strOptString);
            if (!TextUtils.isEmpty(strOptString)) {
                lg5.h(context, zz2.M().a0(strOptString));
            }
            String strOptString2 = jSONObject.optString("conn");
            k63.a("HostConfig", "save connHost:" + strOptString2);
            if (TextUtils.isEmpty(strOptString2)) {
                return;
            }
            lg5.h(context, zz2.L().a0(strOptString2));
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        if (JCoreManager.isTestEnv() && !TextUtils.isEmpty(e)) {
            return e;
        }
        String str = (String) lg5.f(context, zz2.L());
        return !TextUtils.isEmpty(str) ? str : "im64.jpush.cn";
    }

    public static String c(Context context) {
        if (JCoreManager.isTestEnv() && !TextUtils.isEmpty(f)) {
            return f;
        }
        String str = (String) lg5.f(context, zz2.M());
        return !TextUtils.isEmpty(str) ? str : "_im64._tcp.jpush.cn";
    }

    public static LinkedHashMap<String, Integer> d() {
        if (JCoreManager.isTestEnv()) {
            LinkedHashMap<String, Integer> linkedHashMap = c;
            if (!linkedHashMap.isEmpty()) {
                return linkedHashMap;
            }
        }
        return f21218a;
    }

    public static LinkedHashMap<String, Integer> e() {
        if (JCoreManager.isTestEnv()) {
            LinkedHashMap<String, Integer> linkedHashMap = d;
            if (!linkedHashMap.isEmpty()) {
                return linkedHashMap;
            }
        }
        return b;
    }

    public static String f() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(g)) ? "_psis._udp.jpush.cn" : g;
    }

    public static String g() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(h)) ? "" : h;
    }
}
