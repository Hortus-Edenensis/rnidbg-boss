package com.zm.fissionsdk;

import com.igexin.push.core.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZWWV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f16754a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c < 'a' || c > 'f') {
            return 0;
        }
        return c - 'W';
    }

    public static String b(byte b) {
        return b(a(b));
    }

    public static byte[] a(byte b) {
        return new byte[]{b};
    }

    public static String b(int i) {
        return b(a(i));
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static String b(byte[] bArr) {
        return bArr == null ? "" : b(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr) {
        return bArr == null ? b.m : a(bArr, 0, bArr.length);
    }

    public static String b(byte[] bArr, int i, int i2) {
        char[] cArr = new char[i2 * 2];
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            byte b = bArr[i4];
            int i5 = i3 + 1;
            char[] cArr2 = f16754a;
            cArr[i3] = cArr2[(b >>> 4) & 15];
            i3 += 2;
            cArr[i5] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = length * 2;
        for (int i2 = 0; i2 < i; i2 += 2) {
            bArr[i2 / 2] = (byte) ((a(str.charAt(i2)) << 4) | a(str.charAt(i2 + 1)));
        }
        return bArr;
    }

    public static String a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        byte[] bArr2 = new byte[16];
        sb.append("\n0x");
        sb.append(b(i));
        int i3 = i;
        int i4 = 0;
        while (i3 < i + i2) {
            if (i4 == 16) {
                sb.append(" ");
                for (int i5 = 0; i5 < 16; i5++) {
                    byte b = bArr2[i5];
                    if (b > 32 && b < 126) {
                        sb.append(new String(bArr2, i5, 1));
                    } else {
                        sb.append(".");
                    }
                }
                sb.append("\n0x");
                sb.append(b(i3));
                i4 = 0;
            }
            byte b2 = bArr[i3];
            sb.append(" ");
            char[] cArr = f16754a;
            sb.append(cArr[(b2 >>> 4) & 15]);
            sb.append(cArr[b2 & 15]);
            bArr2[i4] = b2;
            i3++;
            i4++;
        }
        if (i4 != 16) {
            int i6 = ((16 - i4) * 3) + 1;
            for (int i7 = 0; i7 < i6; i7++) {
                sb.append(" ");
            }
            for (int i8 = 0; i8 < i4; i8++) {
                byte b3 = bArr2[i8];
                if (b3 > 32 && b3 < 126) {
                    sb.append(new String(bArr2, i8, 1));
                } else {
                    sb.append(".");
                }
            }
        }
        return sb.toString();
    }
}
