package com.lantern.auth.server;

import com.lantern.auth.core.BLHexDump;
import com.lantern.auth.core.BLLog;
import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WkSecretKey {
    public static String decryptAES(String str, String str2, String str3) {
        if (str != null && str.length() != 0) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(BLHexDump.hexStringToByteArray(str)));
            } catch (Exception e) {
                BLLog.e(e);
            }
        }
        return "";
    }

    public static String encryptAES(String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str2 != null && str2.length() != 0 && str3 != null && str3.length() != 0) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return BLHexDump.toHexString(cipher.doFinal(padString(str).getBytes()));
            } catch (Exception e) {
                BLLog.e(e);
            }
        }
        return str;
    }

    private static String padString(String str) {
        int length = str.length() % 16;
        for (int i = 0; i < 16 - length; i++) {
            str = str + ' ';
        }
        return str;
    }

    private static byte[] padString(byte[] bArr) {
        if (bArr.length % 16 == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[((bArr.length / 16) + 1) * 16];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static byte[] decryptAES(byte[] bArr, String str, String str2) {
        if (bArr != null && bArr.length != 0) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                BLLog.e(e);
                return "".getBytes();
            }
        }
        return "".getBytes();
    }

    public static byte[] encryptAES(byte[] bArr, String str, String str2) {
        byte[] bArrDoFinal;
        if (bArr != null && bArr.length != 0) {
            if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes());
                SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
                try {
                    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                    synchronized (WkSecretKey.class) {
                        bArrDoFinal = cipher.doFinal(padString(bArr));
                    }
                    return bArrDoFinal;
                } catch (Exception e) {
                    BLLog.e(e);
                }
            }
            return bArr;
        }
        return "".getBytes();
    }
}
