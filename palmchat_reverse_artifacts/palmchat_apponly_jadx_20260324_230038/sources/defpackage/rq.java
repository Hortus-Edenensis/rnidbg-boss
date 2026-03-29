package defpackage;

import android.annotation.SuppressLint;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class rq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20534a = "BaseKeyUtil";

    public static int a(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static boolean b(int i) {
        return i >= 16;
    }

    public static boolean c(int i, byte[] bArr) {
        return b(i) & d(bArr);
    }

    public static boolean d(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static byte[] e(String str, String str2, String str3, String str4, int i, boolean z) {
        return g(str, str2, str3, oh2.b(str4), i, z);
    }

    public static byte[] f(String str, String str2, String str3, byte[] bArr, int i, int i2, boolean z) {
        byte[] bArrB = oh2.b(str);
        byte[] bArrB2 = oh2.b(str2);
        byte[] bArrB3 = oh2.b(str3);
        int iA = a(bArrB.length, bArrB2.length, bArrB3.length);
        if (!c(iA, bArr)) {
            throw new IllegalArgumentException("key length must be more than 128bit.");
        }
        char[] cArr = new char[iA];
        for (int i3 = 0; i3 < iA; i3++) {
            cArr[i3] = (char) ((bArrB[i3] ^ bArrB2[i3]) ^ bArrB3[i3]);
        }
        if (z) {
            g17.d(f20534a, "exportRootKey: sha256");
            return ma4.c(cArr, bArr, i, i2 * 8);
        }
        g17.d(f20534a, "exportRootKey: sha1");
        return ma4.b(cArr, bArr, i, i2 * 8);
    }

    @SuppressLint({"NewApi"})
    public static byte[] g(String str, String str2, String str3, byte[] bArr, int i, boolean z) {
        return f(str, str2, str3, bArr, 10000, i, z);
    }

    @SuppressLint({"NewApi"})
    public static byte[] h(String str, String str2, String str3, byte[] bArr, boolean z) {
        return g(str, str2, str3, bArr, 16, z);
    }
}
