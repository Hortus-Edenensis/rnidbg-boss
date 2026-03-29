package com.wifi.adsdk.utils;

import android.util.Base64;
import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WkSecretKey {
    public static String decryptAES(String str, String str2, String str3) {
        if (str != null && str.length() != 0) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(BLHexDump.hexStringToByteArray(str)));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String ecbDecrypt(String str, String str2) throws Exception {
        if (str2 == null) {
            return null;
        }
        try {
            if (str2.length() != 16) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(Base64.decode(str, 0)), "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String ecbEncrypt(String str, String str2) throws Exception {
        if (str2 == null || str2.length() != 16) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), EncryptUtils.AES_ENCRYPT_ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secretKeySpec);
        return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
    }

    public static String encryptAES(String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return str;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return BLHexDump.toHexString(cipher.doFinal(padString(str).getBytes()));
        } catch (Exception unused) {
            return str;
        }
    }

    private static byte[] padBytes(byte[] bArr) {
        if (bArr.length % 16 == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[((bArr.length / 16) + 1) * 16];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static String padString(String str) {
        int length = str.length() % 16;
        for (int i = 0; i < 16 - length; i++) {
            str = str + ' ';
        }
        return str;
    }

    public static byte[] decryptAES(byte[] bArr, String str, String str2) {
        if (bArr != null && bArr.length != 0) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static byte[] encryptAES(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return bArr;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes());
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(padBytes(bArr));
        } catch (Exception unused) {
            return bArr;
        }
    }
}
