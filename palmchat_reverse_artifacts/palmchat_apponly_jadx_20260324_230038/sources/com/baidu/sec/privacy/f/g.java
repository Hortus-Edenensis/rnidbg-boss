package com.baidu.sec.privacy.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g {
    public static String a(String str, String str2) {
        try {
            Class clsA = com.baidu.sec.privacy.b.b.a(com.baidu.sec.privacy.b.b.a()).a(g.class.getClassLoader(), "android.os.SystemProperties");
            return clsA == null ? str2 : (String) clsA.getMethod("get", String.class).invoke(clsA, str);
        } catch (Throwable th) {
            c.a(th);
            return str2;
        }
    }
}
