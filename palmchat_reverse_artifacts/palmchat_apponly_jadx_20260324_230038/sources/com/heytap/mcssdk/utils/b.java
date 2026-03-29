package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import com.heytap.msp.push.encrypt.AESEncrypt;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f6355a = null;
    public static final String b = "Y29tLm5lYXJtZS5tY3M=";
    public static String c = "";

    private static String a() {
        if (TextUtils.isEmpty(c)) {
            c = new String(com.heytap.mcssdk.a.a.b(b));
        }
        byte[] bArrA = a(a(c));
        return bArrA != null ? new String(bArrA, Charset.forName("UTF-8")) : "";
    }

    public static String b(String str) {
        boolean z;
        String strDecrypt = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            strDecrypt = c.a(str, a());
            d.b("sdkDecrypt desDecrypt des data " + strDecrypt);
            z = true;
        } catch (Exception e) {
            d.b("sdkDecrypt DES excepiton " + e.toString());
            z = false;
        }
        if (TextUtils.isEmpty(strDecrypt) ? false : z) {
            return strDecrypt;
        }
        try {
            strDecrypt = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            f6355a = EncryptUtils.AES_ENCRYPT_ALGORITHM;
            e.c().a(f6355a);
            d.b("sdkDecrypt desDecrypt aes data " + strDecrypt);
            return strDecrypt;
        } catch (Exception e2) {
            d.b("sdkDecrypt AES excepiton " + e2.toString());
            return strDecrypt;
        }
    }

    public static String c(String str) {
        boolean z;
        String strA = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            strA = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            d.b("sdkDecrypt aesDecrypt aes data " + strA);
            z = true;
        } catch (Exception e) {
            d.b("sdkDecrypt AES excepiton " + e.toString());
            z = false;
        }
        if (TextUtils.isEmpty(strA) ? false : z) {
            return strA;
        }
        try {
            strA = c.a(str, a());
            f6355a = "DES";
            e.c().a(f6355a);
            d.b("sdkDecrypt aesDecrypt des data " + strA);
            return strA;
        } catch (Exception e2) {
            d.b("sdkDecrypt DES excepiton " + e2.toString());
            return strA;
        }
    }

    public static String d(String str) {
        d.b("sdkDecrypt start data " + str);
        if (TextUtils.isEmpty(f6355a)) {
            f6355a = e.c().b();
        }
        if ("DES".equals(f6355a)) {
            d.b("sdkDecrypt start DES");
            return b(str);
        }
        d.b("sdkDecrypt start AES");
        return c(str);
    }

    public static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i = 0; i < length; i += 2) {
            byte b2 = bArr[i];
            int i2 = i + 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b2;
        }
        return bArr;
    }
}
