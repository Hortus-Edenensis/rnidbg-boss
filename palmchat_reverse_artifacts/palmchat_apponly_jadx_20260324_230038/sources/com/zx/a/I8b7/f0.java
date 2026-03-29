package com.zx.a.I8b7;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.gdt.action.ActionUtils;
import com.umeng.analytics.pro.bt;
import com.zx.a.I8b7.l2;
import com.zx.a.I8b7.q1;
import com.zx.module.annotation.Java2C;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.crypto.SecretKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SecretKey f16792a;
    public static byte[] b;
    public static final SecureRandom c = new SecureRandom();

    @Java2C.Method2C
    public static native synchronized String a();

    public static void b() throws Exception {
        String string;
        q1.a aVar = new q1.a();
        HashMap<String, String> mapB = i0.b(a());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        q1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/module/getCoreModule");
        aVarA.b = "POST";
        x0 x0VarB = x0.b("application/json; charset=utf-8");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("lid", m3.a(m3.h));
        jSONObject2.put(bt.af, m3.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put(com.alipay.sdk.m.x.d.D, i0.d());
        jSONObject.put("deviceInfo", i0.b());
        aVarA.d = s1.a(x0VarB, new String(Base64.encode(p.a(jSONObject.toString(), f16792a, "UDID_ENC_AUTHTAG"), 2), StandardCharsets.UTF_8));
        aVarA.e = "request getCoreModule api";
        o2 o2Var = i0.f16810a;
        q1 q1Var = new q1(aVar);
        o2Var.getClass();
        t1 t1VarA = new i1(o2Var, q1Var).a();
        if (t1VarA.b != 200) {
            throw new RuntimeException("response errCode: " + t1VarA.a("Udid-Error-Code") + ", errMsg: " + t1VarA.a("Udid-Error-Message"));
        }
        JSONObject jSONObject3 = new JSONObject(p.a(Base64.decode(new JSONObject(t1VarA.e.b()).getString("data"), 2), f16792a, "UDID_ENC_AUTHTAG"));
        if (!jSONObject3.getBoolean("enable")) {
            u3 u3Var = l2.a.f16824a.f16823a;
            if (u3Var.b == null) {
                u3Var.b = u3Var.d();
            }
            try {
                SQLiteDatabase sQLiteDatabase = u3Var.b;
                StringBuilder sb = new StringBuilder();
                sb.append("key in(");
                sb.append("17,18");
                sb.append(")");
                sQLiteDatabase.delete("zx_table", sb.toString(), null);
                m3.F = null;
                r2.a("clearCoreModule success");
            } catch (Exception e) {
                StringBuilder sbA = f3.a("clearCoreModule error:");
                sbA.append(e.getMessage());
                r2.b(sbA.toString());
            }
            r2.a("coreModule enable is false");
            return;
        }
        JSONObject jSONObject4 = jSONObject3.getJSONObject(bt.e);
        jSONObject4.getString("version");
        String string2 = jSONObject4.getString("checksum");
        byte[] bArrDecode = Base64.decode(jSONObject4.getString("data"), 0);
        if (!TextUtils.equals(string2, p.a("SHA256", bArrDecode))) {
            throw new IOException("zx checksum1 exception");
        }
        r2.a("verify checksum finished");
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("mainVersion", m3.b);
        jSONObject5.put("coreVersion", m3.d);
        jSONObject5.put("checksum", string2);
        l2.a.f16824a.f16823a.getClass();
        String string3 = jSONObject5.getString("coreVersion");
        try {
            string = m3.F.getString("coreVersion");
        } catch (Exception unused) {
            string = "";
        }
        if (!TextUtils.isEmpty(string3) && !TextUtils.equals(string3, string)) {
            u3 u3Var2 = l2.a.f16824a.f16823a;
            if (u3Var2.b == null) {
                u3Var2.b = u3Var2.d();
            }
            try {
                String str = new String(Base64.encode(p.b("AES/CBC/PKCS5Padding", m3.v, m3.w, bArrDecode), 0), StandardCharsets.UTF_8);
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", (Integer) 17);
                contentValues.put(ActionUtils.PAYMENT_AMOUNT, str);
                r2.a("replace resultId = " + u3Var2.b.replace("zx_table", null, contentValues));
            } catch (Exception e2) {
                r2.b("ZXID updateDBValue valueID:17,value:" + bArrDecode + ",error:" + e2.toString());
            }
            l2.a.f16824a.f16823a.a(18, jSONObject5.toString(), true);
            m3.F = jSONObject5;
        }
        r2.a("decrypt and checksum finished");
    }
}
