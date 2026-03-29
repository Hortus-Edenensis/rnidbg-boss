package com.qq.gdt.action.e;

import android.text.TextUtils;
import com.qq.gdt.action.j.o;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class f {
    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String strA = e.a(a(str.getBytes(str2)));
                if (!TextUtils.isEmpty(strA) && strA.length() == 32) {
                    return strA;
                }
                o.c("md5 error");
                return null;
            } catch (Throwable th) {
                o.b("md5", th);
            }
        }
        return null;
    }

    private static byte[] a(String str, byte[] bArr) {
        try {
            return MessageDigest.getInstance(str).digest(bArr);
        } catch (Throwable th) {
            o.b("digest", th);
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            byte[] bArrA = a("md5", bArr);
            if (bArrA != null && bArrA.length == 16) {
                return bArrA;
            }
            o.c("md5 error");
        }
        return null;
    }
}
