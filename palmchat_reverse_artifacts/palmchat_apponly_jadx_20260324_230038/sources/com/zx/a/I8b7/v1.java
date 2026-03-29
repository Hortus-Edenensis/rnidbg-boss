package com.zx.a.I8b7;

import com.zx.a.I8b7.q1;
import com.zx.module.annotation.Java2C;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SecretKey f16873a;
    public static byte[] b;
    public static final SecureRandom c = new SecureRandom();

    @Java2C.Method2C
    public static native synchronized String a();

    @Java2C.Method2C
    private static native String a(String str, String str2) throws Exception;

    public static void b(String str, String str2) throws Exception {
        q1.a aVar = new q1.a();
        HashMap<String, String> mapB = i0.b(a());
        aVar.c.clear();
        aVar.c.putAll(mapB);
        q1.a aVarA = aVar.a("https://zxid-m.mobileservice.cn/sdk/uaid/reportAuthToken");
        aVarA.b = "POST";
        aVarA.d = s1.a(x0.b("application/json; charset=utf-8"), a(str, str2));
        aVarA.e = "SAIDCodeRequest get api";
        o2 o2Var = i0.f16810a;
        q1 q1Var = new q1(aVar);
        o2Var.getClass();
        new i1(o2Var, q1Var).a();
    }
}
