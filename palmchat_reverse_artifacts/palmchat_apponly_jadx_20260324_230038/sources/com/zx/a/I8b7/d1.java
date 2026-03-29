package com.zx.a.I8b7;

import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bt;
import com.zx.a.I8b7.l2;
import com.zx.a.I8b7.q1;
import com.zx.module.annotation.Java2C;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.SecretKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SecretKey f16788a;
    public static byte[] b;
    public static final SecureRandom c = new SecureRandom();

    @Java2C.Method2C
    public static native synchronized String a();

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b() throws Exception {
        JSONArray jSONArray;
        String strA = l2.a.f16824a.f16823a.a(25);
        if (TextUtils.isEmpty(strA)) {
            jSONArray = null;
        } else {
            try {
                JSONArray jSONArray2 = new JSONArray(strA);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray2.length(); i++) {
                    try {
                        arrayList.add(jSONArray2.getString(i));
                    } catch (JSONException unused) {
                    }
                }
                Collections.sort(arrayList, new d2());
                jSONArray = new JSONArray();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    try {
                        String str = (String) arrayList.get(i2);
                        if (w3.b(str) != null) {
                            jSONArray.put(str);
                        }
                    } catch (Exception unused2) {
                        r2.b("iaps data error");
                    }
                }
                if (TextUtils.equals(l2.a.f16824a.f16823a.a(26), jSONArray.toString())) {
                }
            } catch (JSONException unused3) {
            }
        }
        if (jSONArray == null) {
            r2.a("laps 和上次一样本次不上报");
            return;
        }
        q1.a aVar = new q1.a();
        HashMap<String, String> mapB = i0.b(a());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        q1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/app/depAnalysis");
        aVarA.b = "POST";
        x0 x0VarB = x0.b("application/json; charset=utf-8");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("lid", m3.a(m3.h));
        jSONObject2.put(bt.af, m3.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put(com.alipay.sdk.m.x.d.D, i0.d());
        jSONObject.put("deviceInfo", i0.b());
        jSONObject.put("apps", new String(Base64.encode(p.a(jSONArray.toString(), f16788a, "UDID_ENC_AUTHTAG"), 2), StandardCharsets.UTF_8));
        aVarA.d = s1.a(x0VarB, new String(Base64.encode(p.a(jSONObject.toString(), f16788a, "UDID_ENC_AUTHTAG"), 2), StandardCharsets.UTF_8));
        aVarA.e = "request postIAPS api";
        o2 o2Var = i0.f16810a;
        q1 q1Var = new q1(aVar);
        o2Var.getClass();
        t1 t1VarA = new i1(o2Var, q1Var).a();
        if (t1VarA.b == 200) {
            l2 l2Var = l2.a.f16824a;
            u3 u3Var = l2Var.f16823a;
            String string = jSONArray.toString();
            u3Var.getClass();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            l2Var.f16823a.a(26, string, true);
            return;
        }
        throw new RuntimeException("response errCode: " + t1VarA.a("Udid-Error-Code") + ", errMsg: " + t1VarA.a("Udid-Error-Message"));
    }
}
