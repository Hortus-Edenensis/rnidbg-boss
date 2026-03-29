package com.zx.a.I8b7;

import android.text.TextUtils;
import android.util.Base64;
import com.zx.a.I8b7.l2;
import com.zx.a.I8b7.q1;
import com.zx.module.annotation.Java2C;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SecretKey f16822a;
    public static byte[] b;
    public static final SecureRandom c = new SecureRandom();

    @Java2C.Method2C
    public static native synchronized String a();

    @Java2C.Method2C
    private static native String b() throws Exception;

    public static void c() throws Exception {
        q1.a aVar = new q1.a();
        HashMap<String, String> mapB = i0.b(a());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        q1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/config/init");
        aVarA.b = "POST";
        aVarA.d = s1.a(x0.b("application/json; charset=utf-8"), b());
        aVarA.e = "request config api";
        o2 o2Var = i0.f16810a;
        q1 q1Var = new q1(aVar);
        o2Var.getClass();
        t1 t1VarA = new i1(o2Var, q1Var).a();
        if (t1VarA.b != 200) {
            throw new RuntimeException("response errCode: " + t1VarA.a("Udid-Error-Code") + ", errMsg: " + t1VarA.a("Udid-Error-Message"));
        }
        JSONObject jSONObject = new JSONObject(p.a(Base64.decode(new JSONObject(t1VarA.e.b()).getString("data"), 2), f16822a, "UDID_ENC_AUTHTAG"));
        String string = jSONObject.getString("configVersion");
        l2 l2Var = l2.a.f16824a;
        l2Var.f16823a.getClass();
        if (!TextUtils.equals(string, m3.o)) {
            m3.o = string;
            l2Var.f16823a.a(4, string, false);
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("fieldConfig");
        u3 u3Var = l2Var.f16823a;
        String string2 = jSONObject2.toString();
        u3Var.getClass();
        if (!TextUtils.equals(string2, m3.x)) {
            m3.x = string2;
            l2Var.f16823a.a(11, string2, true);
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("reportConfig");
        u3 u3Var2 = l2Var.f16823a;
        String string3 = jSONObject3.toString();
        u3Var2.getClass();
        if (!TextUtils.equals(string3, m3.y)) {
            m3.y = string3;
            l2Var.f16823a.a(12, string3, true);
        }
        JSONObject jSONObject4 = jSONObject.getJSONObject("cryptoConfig");
        u3 u3Var3 = l2Var.f16823a;
        String string4 = jSONObject4.toString();
        u3Var3.getClass();
        if (!TextUtils.equals(string4, m3.z)) {
            m3.z = string4;
            l2Var.f16823a.a(15, string4, true);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("appConfig");
        if (jSONObjectOptJSONObject != null) {
            r2.a("处理 appConfig ");
            try {
                JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("list");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    r2.b("appConfig list is empty");
                } else {
                    int length = jSONArray.length();
                    int i = jSONObjectOptJSONObject.getInt("type");
                    if (i == 1) {
                        for (int i2 = 0; i2 < length; i2++) {
                            jSONArray.put(i2, p.a(Base64.decode(jSONArray.getString(i2), 2), f16822a, "UDID_ENC_AUTHTAG"));
                        }
                    } else if (i == 3) {
                        SecretKey secretKeyA = p.a(b, m3.a(m3.h));
                        for (int i3 = 0; i3 < length; i3++) {
                            jSONArray.put(i3, new String(p.a("AES/CBC/PKCS7Padding", secretKeyA, new IvParameterSpec("UDID_ENC_AUTHTAG".getBytes(StandardCharsets.UTF_8)), Base64.decode(jSONArray.getString(i3), 2)), StandardCharsets.UTF_8));
                        }
                    }
                    l2 l2Var2 = l2.a.f16824a;
                    u3 u3Var4 = l2Var2.f16823a;
                    String string5 = jSONObjectOptJSONObject.toString();
                    u3Var4.getClass();
                    if (!TextUtils.equals(string5, m3.A)) {
                        m3.A = string5;
                        l2Var2.f16823a.a(21, string5, true);
                    }
                }
            } catch (Exception e) {
                r2.a(e);
            }
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("commonConfig");
        if (jSONObjectOptJSONObject2 != null) {
            l2 l2Var3 = l2.a.f16824a;
            u3 u3Var5 = l2Var3.f16823a;
            String string6 = jSONObjectOptJSONObject2.toString();
            u3Var5.getClass();
            if (!TextUtils.equals(string6, m3.B)) {
                m3.B = string6;
                l2Var3.f16823a.a(22, string6, true);
            }
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("invokeConfig");
        if (jSONObjectOptJSONObject3 != null) {
            l2 l2Var4 = l2.a.f16824a;
            u3 u3Var6 = l2Var4.f16823a;
            String string7 = jSONObjectOptJSONObject3.toString();
            synchronized (u3Var6) {
                if (!TextUtils.equals(string7, m3.C)) {
                    m3.C = string7;
                    m3.c();
                    l2Var4.f16823a.a(19, m3.C, true);
                }
            }
        }
        if (m3.p) {
            return;
        }
        l2 l2Var5 = l2.a.f16824a;
        l2Var5.f16823a.getClass();
        if (true != m3.p) {
            m3.p = true;
            l2Var5.f16823a.a(6, m3.p + "", false);
        }
    }
}
