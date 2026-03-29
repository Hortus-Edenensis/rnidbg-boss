package com.qq.gdt.action.j;

import android.util.Base64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l {
    private static String a(String str) {
        try {
            return u.c(r.b(Base64.decode(str, 2)));
        } catch (Throwable th) {
            o.b("rsa decrypt exception", th);
            return null;
        }
    }

    public static boolean a(String str, String str2) {
        if (v.a(str) || v.a(str2)) {
            return false;
        }
        String strA = a(str);
        boolean zEquals = str2.equals(strA);
        o.a("VerifySign result: " + zEquals + ", expect = " + str2 + ", decrypted = " + strA, new Object[0]);
        return zEquals;
    }

    public static byte[] a(byte[] bArr) {
        try {
            return r.a(bArr);
        } catch (Throwable th) {
            o.b("Exception while encrypt plainBytes", th);
            return null;
        }
    }
}
