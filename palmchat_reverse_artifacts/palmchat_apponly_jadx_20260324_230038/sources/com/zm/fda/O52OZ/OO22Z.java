package com.zm.fda.O52OZ;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16627a = "AES/CBC/PKCS5Padding";
    public static final String b = "AES/CBC/NoPadding";
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'A' && c2 <= 'F') {
            return c2 - '7';
        }
        if (c2 < 'a' || c2 > 'f') {
            return 0;
        }
        return c2 - 'W';
    }

    public static String b(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return str;
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str4.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return a(cipher.doFinal(b(str).getBytes()));
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static String a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return str;
        }
        byte[] bArrA = a(str);
        if (bArrA != null && bArrA.length % 16 == 0) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str4.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance(str2);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(bArrA)).trim();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String b(String str) {
        int length = str.length() % 16;
        for (int i = 0; i < 16 - length; i++) {
            str = str + ' ';
        }
        return str;
    }

    public static String a(byte[] bArr) {
        return bArr == null ? "" : a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i, int i2) {
        char[] cArr = new char[i2 * 2];
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            byte b2 = bArr[i4];
            int i5 = i3 + 1;
            char[] cArr2 = c;
            cArr[i3] = cArr2[(b2 >>> 4) & 15];
            i3 += 2;
            cArr[i5] = cArr2[b2 & 15];
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
}
