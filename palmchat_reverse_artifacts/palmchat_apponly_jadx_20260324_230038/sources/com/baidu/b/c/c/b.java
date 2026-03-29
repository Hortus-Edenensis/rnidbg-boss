package com.baidu.b.c.c;

import java.math.BigInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f3329a;
    private static byte[] b;

    public static byte[] a() {
        byte[] bArr = f3329a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f3328a).modPow(new BigInteger(a.b), new BigInteger(a.e)).toByteArray();
        f3329a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.c).modPow(new BigInteger(a.d), new BigInteger(a.e)).toByteArray();
        b = byteArray;
        return byteArray;
    }
}
