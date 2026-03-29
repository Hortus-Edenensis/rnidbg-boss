package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class g8 {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e) {
            g17.c("CBC", "get encryptword exception : " + e.getMessage());
            return "";
        }
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e) {
                g17.c("CBC", "mix exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static byte[] c(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g17.c("CBC", "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            g17.c("CBC", "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            g17.c("CBC", "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            g17.c("CBC", "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            g17.c("CBC", "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        try {
            return m(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e) {
            g17.c("CBC", " cbc encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e) {
            g17.c("CBC", "getIv exception : " + e.getMessage());
            return "";
        }
    }

    public static String f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g17.c("CBC", "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            g17.c("CBC", "decrypt 1 key is null");
            return "";
        }
        byte[] bArrB = oh2.b(str2);
        if (bArrB.length >= 16) {
            return g(str, bArrB);
        }
        g17.c("CBC", "decrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    public static String g(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            g17.c("CBC", "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            g17.c("CBC", "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g17.c("CBC", "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        String strE = e(str);
        String strA = a(str);
        if (TextUtils.isEmpty(strE)) {
            g17.c("CBC", "decrypt 2 iv is null");
            return "";
        }
        if (!TextUtils.isEmpty(strA)) {
            return h(strA, bArr, oh2.b(strE));
        }
        g17.c("CBC", "decrypt 2 encrypt content is null");
        return "";
    }

    public static String h(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g17.c("CBC", "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            g17.c("CBC", "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g17.c("CBC", "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            g17.c("CBC", "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            g17.c("CBC", "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        try {
            return new String(i(oh2.b(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            g17.c("CBC", " cbc decrypt data error" + e.getMessage());
            return "";
        }
    }

    public static byte[] i(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            g17.c("CBC", "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            g17.c("CBC", "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            g17.c("CBC", "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            g17.c("CBC", "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            g17.c("CBC", "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            g17.c("CBC", "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, EncryptUtils.AES_ENCRYPT_ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e) {
            g17.c("CBC", "NullPointerException: " + e.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e2) {
            g17.c("CBC", "InvalidAlgorithmParameterException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e3) {
            g17.c("CBC", "InvalidKeyException: " + e3.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e4) {
            g17.c("CBC", "NoSuchAlgorithmException: " + e4.getMessage());
            return new byte[0];
        } catch (BadPaddingException e5) {
            g17.c("CBC", "BadPaddingException: " + e5.getMessage());
            g17.c("CBC", "key is not right");
            return new byte[0];
        } catch (IllegalBlockSizeException e6) {
            g17.c("CBC", "IllegalBlockSizeException: " + e6.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e7) {
            g17.c("CBC", "NoSuchPaddingException: " + e7.getMessage());
            return new byte[0];
        }
    }

    public static String j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g17.c("CBC", "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            g17.c("CBC", "encrypt 1 key is null");
            return "";
        }
        byte[] bArrB = oh2.b(str2);
        if (bArrB.length >= 16) {
            return k(str, bArrB);
        }
        g17.c("CBC", "encrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    public static String k(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            g17.c("CBC", "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            g17.c("CBC", "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g17.c("CBC", "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        byte[] bArrC = pm1.c(16);
        byte[] bArrC2 = c(str, bArr, bArrC);
        return (bArrC2 == null || bArrC2.length == 0) ? "" : b(oh2.a(bArrC), oh2.a(bArrC2));
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        byte[] bArrC = pm1.c(16);
        return d(bArrC, m(bArr, bArr2, bArrC));
    }

    public static byte[] m(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            g17.c("CBC", "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            g17.c("CBC", "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            g17.c("CBC", "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            g17.c("CBC", "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            g17.c("CBC", "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            g17.c("CBC", "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, EncryptUtils.AES_ENCRYPT_ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e) {
            g17.c("CBC", "NullPointerException: " + e.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e2) {
            g17.c("CBC", "InvalidAlgorithmParameterException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e3) {
            g17.c("CBC", "InvalidKeyException: " + e3.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e4) {
            g17.c("CBC", "NoSuchAlgorithmException: " + e4.getMessage());
            return new byte[0];
        } catch (BadPaddingException e5) {
            g17.c("CBC", "BadPaddingException: " + e5.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e6) {
            g17.c("CBC", "IllegalBlockSizeException: " + e6.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e7) {
            g17.c("CBC", "NoSuchPaddingException: " + e7.getMessage());
            return new byte[0];
        }
    }
}
