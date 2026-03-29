package org.apache.cordova.jssdk;

import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class AESUtil {
    private static final String CipherMode = "AES/CBC/ZeroBytePadding";

    public static String byte2hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    private static SecretKeySpec createKey(String str) {
        byte[] bytes;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bytes = stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bytes = null;
        }
        return new SecretKeySpec(bytes, EncryptUtils.AES_ENCRYPT_ALGORITHM);
    }

    public static byte[] decrypt(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpecCreateKey = createKey(str);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(2, secretKeySpecCreateKey);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptAES(String str, String str2, String str3) {
        if (str != null && str.length() != 0) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes());
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
                Cipher cipher = Cipher.getInstance(CipherMode);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(hex2byte(str)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static byte[] encrypt(byte[] bArr, String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes());
            SecretKeySpec secretKeySpecCreateKey = createKey(str);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(1, secretKeySpecCreateKey, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return byte2hex(cipher.doFinal(padString(str).getBytes()));
        } catch (Exception unused) {
            return "";
        }
    }

    private static byte[] hex2byte(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Integer.parseInt(lowerCase.substring(i2, i2 + 2), 16) & 255);
        }
        return bArr;
    }

    private static String padString(String str) {
        try {
            int length = str.getBytes("utf-8").length % 16;
            for (int i = 0; i < 16 - length; i++) {
                str = str + ' ';
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String decrypt(String str, String str2) {
        byte[] bArrHex2byte;
        try {
            bArrHex2byte = hex2byte(str);
        } catch (Exception e) {
            e.printStackTrace();
            bArrHex2byte = null;
        }
        byte[] bArrDecrypt = decrypt(bArrHex2byte, str2);
        if (bArrDecrypt == null) {
            return null;
        }
        try {
            return new String(bArrDecrypt, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str, String str2, String str3) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            bytes = null;
        }
        return byte2hex(encrypt(bytes, str2, str3));
    }
}
