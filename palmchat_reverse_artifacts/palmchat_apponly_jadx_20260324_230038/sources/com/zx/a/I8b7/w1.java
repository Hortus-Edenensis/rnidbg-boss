package com.zx.a.I8b7;

import android.util.Base64;
import com.zx.a.I8b7.q1;
import com.zx.module.annotation.Java2C;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.crypto.SecretKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SecretKey f16877a;
    public static byte[] b;
    public static final SecureRandom c = new SecureRandom();

    @Java2C.Method2C
    public static native synchronized String a();

    @Java2C.Method2C
    private static native String a(JSONObject jSONObject, String str, String str2, String str3) throws Exception;

    public static String b(JSONObject jSONObject, String str, String str2, String str3) throws Exception {
        q1.a aVar = new q1.a();
        HashMap<String, String> mapB = i0.b(a());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        q1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/uaid/get");
        aVarA.b = "POST";
        aVarA.d = s1.a(x0.b("application/json; charset=utf-8"), a(jSONObject, str, str2, str3));
        aVarA.e = "said get api";
        o2 o2Var = i0.f16810a;
        q1 q1Var = new q1(aVar);
        o2Var.getClass();
        t1 t1VarA = new i1(o2Var, q1Var).a();
        if (t1VarA.b == 200) {
            return new JSONObject(p.a(Base64.decode(new JSONObject(t1VarA.e.b()).getString("data"), 2), f16877a, "UDID_ENC_AUTHTAG")).getString("uaid");
        }
        throw new RuntimeException("response errCode: " + t1VarA.a("Udid-Error-Code") + ", errMsg: " + t1VarA.a("Udid-Error-Message"));
    }
}
