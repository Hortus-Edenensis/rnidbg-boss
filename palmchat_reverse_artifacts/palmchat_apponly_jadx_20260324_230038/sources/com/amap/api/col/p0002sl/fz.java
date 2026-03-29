package com.amap.api.col.p0002sl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fz {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return ge.e(c(str));
    }

    public static String b(String str) {
        return ge.f(d(str));
    }

    private static byte[] c(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            ha.a(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] d(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] e(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(ge.c("ETUQ1"));
        messageDigest.update(ge.a(str));
        return messageDigest.digest();
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            ha.a(th, "MD5", "gmb");
            return null;
        }
    }

    public static String a(byte[] bArr) {
        return ge.e(a(bArr, ge.c("ETUQ1")));
    }
}
