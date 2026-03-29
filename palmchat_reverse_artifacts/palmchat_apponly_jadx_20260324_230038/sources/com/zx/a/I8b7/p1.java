package com.zx.a.I8b7;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.analytics.pro.bt;
import com.zx.a.I8b7.l2;
import com.zx.a.I8b7.q1;
import com.zx.a.I8b7.v3;
import com.zx.a.I8b7.y;
import com.zx.module.annotation.Java2C;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import javax.crypto.SecretKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f16842a = "";
    public static SecretKey c;
    public static byte[] d;
    public static LinkedList<String> b = new LinkedList<>();
    public static final SecureRandom e = new SecureRandom();

    public static HashMap<String, String> a() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(m3.x) ? new JSONObject(m3.x) : new JSONObject();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("lv1");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("lv2");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return new HashMap<>();
        }
        if (jSONObjectOptJSONObject == null) {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String string = jSONArrayOptJSONArray.getString(i);
                if ("99".equals(string)) {
                    map.put(string, u0.a());
                } else {
                    map.put(string, w3.a(string));
                }
            }
            return map;
        }
        HashMap<String, String> map2 = new HashMap<>();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            String string2 = jSONArrayOptJSONArray.getString(i2);
            String strA = "99".equals(string2) ? u0.a() : w3.a(string2);
            if (!TextUtils.isEmpty(strA) && jSONObjectOptJSONObject.has(string2)) {
                string2.getClass();
                switch (string2) {
                    case "48":
                    case "49":
                    case "98":
                        String[] strArrSplit = strA.split("#");
                        HashMap map3 = new HashMap();
                        for (String str : strArrSplit) {
                            String str2 = str.split(",")[0];
                            map3.put(str2, str.substring(str2.length() + 1));
                        }
                        JSONObject jSONObject2 = jSONObjectOptJSONObject.getJSONObject(string2);
                        Iterator<String> itKeys = jSONObject2.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            try {
                                String str3 = string2 + "." + next;
                                String str4 = (String) map3.get(p.a(jSONObject2.getString(next), true));
                                map2.put(str3, str4);
                                if (!TextUtils.isEmpty(str4)) {
                                    b.add(str3);
                                }
                            } catch (Throwable th) {
                                r2.a(th);
                            }
                        }
                        break;
                }
            }
            map2.put(string2, strA);
        }
        return map2;
    }

    @Java2C.Method2C
    private static native void a(JSONObject jSONObject) throws Throwable;

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            return !TextUtils.isEmpty(m3.D) ? new JSONObject(m3.D) : jSONObject;
        } catch (JSONException e2) {
            StringBuilder sbA = f3.a("ZXID buildOldLv1 error:");
            sbA.append(e2.getMessage());
            r2.b(sbA.toString());
            return jSONObject;
        }
    }

    @Java2C.Method2C
    private static native void b(JSONObject jSONObject) throws Throwable;

    @Java2C.Method2C
    public static native synchronized String c();

    public static JSONObject c(JSONArray jSONArray, HashMap<String, String> map, JSONObject jSONObject) {
        StringBuffer stringBuffer = new StringBuffer();
        JSONObject jSONObject2 = new JSONObject();
        StringBuffer stringBuffer2 = new StringBuffer();
        JSONObject jSONObjectB = b();
        int i = 0;
        while (true) {
            String str = "";
            if (i >= jSONArray.length()) {
                break;
            }
            try {
                String string = jSONArray.getString(i);
                String str2 = map.get(string);
                if (str2 == null) {
                    str2 = "";
                }
                String strA = a(string, str2, jSONObject);
                if (strA != null) {
                    str = strA;
                }
                jSONObject2.put(string, str);
                stringBuffer.append(str2);
                stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                stringBuffer2.append(a(string, jSONObjectB));
                stringBuffer2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            } catch (JSONException e2) {
                StringBuilder sbA = f3.a("ZXID handleType3 error:");
                sbA.append(e2.getMessage());
                r2.b(sbA.toString());
            }
            i++;
        }
        for (String str3 : b) {
            try {
                String str4 = map.get(str3);
                if (str4 == null) {
                    str4 = "";
                }
                String strA2 = a(str3, str4, jSONObject);
                if (strA2 == null) {
                    strA2 = "";
                }
                jSONObject2.put(str3, strA2);
                stringBuffer.append(str4);
                stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                stringBuffer2.append(a(str3, jSONObjectB));
                stringBuffer2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            } catch (JSONException e3) {
                StringBuilder sbA2 = f3.a("ZXID handleType3 childIndex error:");
                sbA2.append(e3.getMessage());
                r2.b(sbA2.toString());
            }
        }
        return !TextUtils.equals(p.a(stringBuffer.toString(), "SHA256"), p.a(stringBuffer2.toString(), "SHA256")) ? jSONObject2 : new JSONObject();
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            b.clear();
            HashMap<String, String> mapA = a();
            m3.E = new JSONObject(mapA).toString();
            JSONObject jSONObject2 = !TextUtils.isEmpty(m3.y) ? new JSONObject(m3.y) : new JSONObject();
            JSONObject jSONObject3 = !TextUtils.isEmpty(m3.z) ? new JSONObject(m3.z) : new JSONObject();
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject4 = jSONObject2.getJSONObject(next);
                int i = jSONObject4.getInt("type");
                JSONArray jSONArray = jSONObject4.getJSONArray("list");
                if (i == 1) {
                    jSONObject.put(next, a(jSONArray, mapA, jSONObject3));
                } else if (i == 2) {
                    jSONObject.put(next, b(jSONArray, mapA, jSONObject3));
                } else if (i == 3) {
                    jSONObject.put(next, c(jSONArray, mapA, jSONObject3));
                }
            }
        } catch (Throwable th) {
            StringBuilder sbA = f3.a("ZXID 获取data参数异常:");
            sbA.append(th.getMessage());
            r2.b(sbA.toString());
        }
        return jSONObject;
    }

    @Java2C.Method2C
    private static native String e();

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f() throws Exception {
        JSONObject jSONObject;
        String strA;
        JSONArray jSONArrayOptJSONArray;
        if (c0.a()) {
            return;
        }
        q1.a aVar = new q1.a();
        HashMap<String, String> mapB = i0.b(c());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        q1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/channel/report");
        aVarA.b = "POST";
        x0 x0VarB = x0.b("application/json; charset=utf-8");
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("syncId", m3.n);
        jSONObject3.put("lid", m3.a(m3.h));
        jSONObject3.put(bt.af, m3.i);
        jSONObject2.put("ctx", jSONObject3);
        jSONObject2.put(com.alipay.sdk.m.x.d.D, i0.d());
        jSONObject2.put("deviceInfo", i0.b());
        y yVar = y.b.f16887a;
        yVar.getClass();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("list", yVar.f16885a);
        } catch (Exception e2) {
            r2.a(e2);
        }
        jSONObject2.put(com.umeng.analytics.pro.f.ax, jSONObject4);
        y yVar2 = y.b.f16887a;
        yVar2.getClass();
        JSONObject jSONObject5 = new JSONObject();
        try {
            jSONObject5.put("list", yVar2.b);
        } catch (Exception e3) {
            r2.a(e3);
        }
        if (jSONObject5.length() > 0 && (jSONArrayOptJSONArray = jSONObject5.optJSONArray("list")) != null && jSONArrayOptJSONArray.length() > 0) {
            jSONObject2.put(NotificationCompat.CATEGORY_ERROR, jSONObject5);
        }
        try {
            strA = l2.a.f16824a.f16823a.a(322);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(strA)) {
            jSONObject = new JSONObject(strA);
            if (jSONObject.length() <= 0) {
                jSONObject = null;
            }
        }
        jSONObject2.put("auth", jSONObject);
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("ood", w3.a("62"));
        b(jSONObject6);
        if (m3.k != null && m3.k.length() > 0) {
            jSONObject6.put("reqBZ", m3.k);
        }
        a(jSONObject6);
        jSONObject2.put("extensionInfo", jSONObject6);
        JSONObject jSONObject7 = new JSONObject();
        try {
            jSONObject7.put("data", d());
            jSONObject7.put("unauthorizedFields", new JSONArray());
        } catch (Throwable th) {
            StringBuilder sbA = f3.a("ZXID getReportData error:");
            sbA.append(th.getMessage());
            r2.b(sbA.toString());
        }
        jSONObject2.put("reportData", jSONObject7);
        aVarA.d = s1.a(x0VarB, new String(Base64.encode(p.a(jSONObject2.toString(), c, "UDID_ENC_AUTHTAG"), 2), StandardCharsets.UTF_8));
        aVarA.e = "request zxid api";
        o2 o2Var = i0.f16810a;
        q1 q1Var = new q1(aVar);
        o2Var.getClass();
        t1 t1VarA = new i1(o2Var, q1Var).a();
        if (t1VarA.b != 200) {
            throw new RuntimeException("response errCode: " + t1VarA.a("Udid-Error-Code") + ", errMsg: " + t1VarA.a("Udid-Error-Message"));
        }
        l2 l2Var = l2.a.f16824a;
        u3 u3Var = l2Var.f16823a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        u3Var.getClass();
        if (jCurrentTimeMillis != m3.u) {
            m3.u = jCurrentTimeMillis;
            l2Var.f16823a.a(8, m3.u + "", false);
            r2.a("lastRequestTime had changed refresh:" + m3.u);
        }
        if (!TextUtils.isEmpty(f16842a)) {
            u3 u3Var2 = l2Var.f16823a;
            String str = f16842a;
            u3Var2.getClass();
            if (!TextUtils.equals(str, m3.m)) {
                m3.m = str;
                l2Var.f16823a.a(28, str, true);
                r2.a("lastReportExtListMD5 had changed refresh:" + m3.m);
            }
            f16842a = "";
        }
        y yVar3 = y.b.f16887a;
        yVar3.getClass();
        yVar3.a(new a0(yVar3));
        yVar3.a(new b0(yVar3));
        l2Var.f16823a.getClass();
        l2Var.f16823a.a(322, "", true);
        l2Var.f16823a.getClass();
        m3.k = new JSONArray();
        l2Var.f16823a.a(63, m3.k.toString(), true);
        v3.f.f16875a.e.execute(new k1());
        JSONObject jSONObject8 = new JSONObject(t1VarA.e.b());
        l2Var.f16823a.d(jSONObject8.getInt("syncId"));
        JSONObject jSONObject9 = new JSONObject(p.a(Base64.decode(jSONObject8.getString("data"), 2), c, "UDID_ENC_AUTHTAG"));
        String string = jSONObject9.getString(bt.af);
        l2Var.f16823a.getClass();
        if (!TextUtils.equals(string, m3.i)) {
            m3.i = string;
            l2Var.f16823a.a(1, string, true);
            r2.a("zid had changed refresh:" + string);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject9.optJSONObject("aids");
        JSONObject jSONObjectOptJSONObject2 = jSONObject9.optJSONObject("aidsExt");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
        }
        if (!TextUtils.isEmpty(m3.f) && jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject2.put(m3.f, jSONObjectOptJSONObject);
        }
        JSONObject jSONObject10 = new JSONObject();
        jSONObject10.put("tags", jSONObject9.optJSONArray("tags"));
        jSONObject10.put("aids", jSONObjectOptJSONObject2);
        if (jSONObject9.has("openid")) {
            jSONObject10.put("openid", jSONObject9.optString("openid"));
        } else {
            jSONObject10.put("openid", "OPENID_CLOSED");
        }
        jSONObject10.put(CmcdConfiguration.KEY_OBJECT_TYPE, jSONObject9.optInt(CmcdConfiguration.KEY_OBJECT_TYPE));
        JSONObject jSONObject11 = new JSONObject();
        if (jSONObject9.has("zxc1")) {
            jSONObject11.put("zxc1", jSONObject9.getString("zxc1"));
        }
        if (jSONObject9.has("zxc2")) {
            jSONObject11.put("zxc2", true);
        }
        if (jSONObject9.has("zxc3")) {
            jSONObject11.put("zxc3", true);
        }
        l2Var.f16823a.getClass();
        String string2 = jSONObject11.toString();
        m3.l = string2;
        l2Var.f16823a.a(30, string2, true);
        r2.a("zxc had changed refresh:" + m3.l);
        l2Var.f16823a.getClass();
        String string3 = jSONObject10.toString();
        if (!TextUtils.isEmpty(string3)) {
            m3.j = string3;
            l2Var.f16823a.a(16, string3, true);
            r2.a("ext had changed refresh:" + jSONObject10);
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject8.optJSONArray("cmds");
        u3 u3Var3 = l2Var.f16823a;
        String str2 = m3.E;
        u3Var3.getClass();
        if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, m3.D)) {
            m3.D = str2;
            l2Var.f16823a.a(13, str2, true);
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject9.optJSONArray("iaps");
        try {
            JSONArray jSONArray = new JSONArray();
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray3.length(); i++) {
                    jSONArray.put(p.a(Base64.decode(jSONArrayOptJSONArray3.getString(i), 2), c, "UDID_ENC_AUTHTAG"));
                }
            }
            l2 l2Var2 = l2.a.f16824a;
            l2Var2.f16823a.getClass();
            l2Var2.f16823a.a(25, jSONArray.toString(), true);
        } catch (Throwable unused2) {
        }
        if (jSONArrayOptJSONArray2 != null) {
            try {
                if (jSONArrayOptJSONArray2.length() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    switch (jSONArrayOptJSONArray2.getInt(i2)) {
                        case 1:
                            r2.a("cmd 1 REQUEST_CONFIG ");
                            v3.f.f16875a.d.execute(new l1());
                            break;
                        case 2:
                            l2.a.f16824a.f16823a.d(0);
                            break;
                        case 3:
                            v3.f.f16875a.d.execute(new m1());
                            break;
                        case 4:
                            v3.f.f16875a.d.execute(new n1());
                            break;
                        case 5:
                            v3.f.f16875a.d.execute(new o1());
                            break;
                        case 6:
                            v3.f.f16875a.d.execute(new f());
                            break;
                        case 7:
                            v3.f.f16875a.d.execute(new g());
                            break;
                        case 8:
                            v3.f.f16875a.d.execute(new h());
                            break;
                        case 9:
                            v3.f.f16875a.d.execute(new i());
                            break;
                    }
                }
            } catch (Throwable th2) {
                r2.a(th2);
            }
        }
    }

    public static JSONObject b(JSONArray jSONArray, HashMap<String, String> map, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObjectB = b();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                String str = map.get(string);
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                if (!TextUtils.equals(a(string, jSONObjectB), str)) {
                    String strA = a(string, str, jSONObject);
                    if (strA != null) {
                        str2 = strA;
                    }
                    jSONObject2.put(string, str2);
                }
            } catch (JSONException e2) {
                StringBuilder sbA = f3.a("ZXID handleType2 error:");
                sbA.append(e2.getMessage());
                r2.b(sbA.toString());
            }
        }
        return jSONObject2;
    }

    public static JSONObject a(JSONArray jSONArray, HashMap<String, String> map, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                String strA = a(string, map.get(string), jSONObject);
                if (strA == null) {
                    strA = "";
                }
                jSONObject2.put(string, strA);
            } catch (JSONException e2) {
                StringBuilder sbA = f3.a("ZXID handleType1 error:");
                sbA.append(e2.getMessage());
                r2.b(sbA.toString());
            }
        }
        return jSONObject2;
    }

    public static String a(String str, String str2, JSONObject jSONObject) {
        String strA;
        if (jSONObject == null || !jSONObject.has(str) || TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            int i = jSONObject.getInt(str);
            if (i == 1) {
                return new String(Base64.encode(p.a(str2, c, "UDID_ENC_AUTHTAG"), 2), StandardCharsets.UTF_8);
            }
            if (i == 2) {
                strA = p.a(p.a(str2, "MD5").substring(0, 20), "MD5");
            } else {
                if (i != 3) {
                    return str2;
                }
                String strA2 = p.a(str2, "MD5");
                StringBuilder sb = new StringBuilder();
                sb.append(strA2.substring(0, 20));
                PackageManager packageManager = w3.f16879a;
                sb.append(Build.MODEL);
                strA = p.a(sb.toString(), "MD5");
            }
            return strA;
        } catch (Exception e2) {
            r2.b("加密脱敏失败:" + str + ",error:" + e2);
            return null;
        }
    }

    public static String a(String str, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0 || jSONObject.isNull(str)) ? "" : jSONObject.optString(str);
    }
}
