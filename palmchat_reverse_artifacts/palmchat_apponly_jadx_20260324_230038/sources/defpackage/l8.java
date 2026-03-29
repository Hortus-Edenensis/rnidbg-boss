package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, SecretKey> f18926a = new HashMap();

    public static SecretKey a(String str) {
        g17.d("GCMKS", "load key");
        SecretKey secretKeyGenerateKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key instanceof SecretKey) {
                secretKeyGenerateKey = (SecretKey) key;
            } else {
                g17.d("GCMKS", "generate key");
                KeyGenerator keyGenerator = KeyGenerator.getInstance(EncryptUtils.AES_ENCRYPT_ALGORITHM, "AndroidKeyStore");
                xy6.a();
                keyGenerator.init(wy6.a(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                secretKeyGenerateKey = keyGenerator.generateKey();
            }
        } catch (IOException e) {
            g17.c("GCMKS", "IOException : " + e.getMessage());
        } catch (InvalidAlgorithmParameterException e2) {
            g17.c("GCMKS", "InvalidAlgorithmParameterException : " + e2.getMessage());
        } catch (KeyStoreException e3) {
            g17.c("GCMKS", "KeyStoreException : " + e3.getMessage());
        } catch (NoSuchAlgorithmException e4) {
            g17.c("GCMKS", "NoSuchAlgorithmException : " + e4.getMessage());
        } catch (NoSuchProviderException e5) {
            g17.c("GCMKS", "NoSuchProviderException : " + e5.getMessage());
        } catch (UnrecoverableKeyException e6) {
            g17.c("GCMKS", "UnrecoverableKeyException : " + e6.getMessage());
        } catch (CertificateException e7) {
            g17.c("GCMKS", "CertificateException : " + e7.getMessage());
        } catch (Exception e8) {
            g17.c("GCMKS", "Exception: " + e8.getMessage());
        }
        f18926a.put(str, secretKeyGenerateKey);
        return secretKeyGenerateKey;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static SecretKey c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f18926a.get(str) == null) {
            a(str);
        }
        return f18926a.get(str);
    }

    public static String d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            g17.c("GCMKS", "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(e(str, oh2.b(str2)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            g17.c("GCMKS", "decrypt: UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    public static byte[] e(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            g17.c("GCMKS", "alias or encrypt content is null");
            return bArr2;
        }
        if (!b()) {
            g17.c("GCMKS", "sdk version is too low");
            return bArr2;
        }
        if (bArr.length > 12) {
            return f(c(str), bArr);
        }
        g17.c("GCMKS", "Decrypt source data is invalid.");
        return bArr2;
    }

    public static byte[] f(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            g17.c("GCMKS", "Decrypt secret key is null");
            return bArr2;
        }
        if (bArr == null) {
            g17.c("GCMKS", "content is null");
            return bArr2;
        }
        if (!b()) {
            g17.c("GCMKS", "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 12) {
            g17.c("GCMKS", "Decrypt source data is invalid.");
            return bArr2;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 12);
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, secretKey, new GCMParameterSpec(128, bArrCopyOf));
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        } catch (InvalidAlgorithmParameterException e) {
            g17.c("GCMKS", "InvalidAlgorithmParameterException : " + e.getMessage());
            return bArr2;
        } catch (InvalidKeyException e2) {
            g17.c("GCMKS", "InvalidKeyException : " + e2.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e3) {
            g17.c("GCMKS", "NoSuchAlgorithmException : " + e3.getMessage());
            return bArr2;
        } catch (BadPaddingException e4) {
            g17.c("GCMKS", "BadPaddingException : " + e4.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e5) {
            g17.c("GCMKS", "IllegalBlockSizeException : " + e5.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e6) {
            g17.c("GCMKS", "NoSuchPaddingException : " + e6.getMessage());
            return bArr2;
        } catch (Exception e7) {
            g17.c("GCMKS", "Exception: " + e7.getMessage());
            return bArr2;
        }
    }

    public static String g(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            g17.c("GCMKS", "alias or encrypt content is null");
            return "";
        }
        try {
            return oh2.a(h(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            g17.c("GCMKS", "encrypt: UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    public static byte[] h(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            g17.c("GCMKS", "alias or encrypt content is null");
            return bArr2;
        }
        if (b()) {
            return i(c(str), bArr);
        }
        g17.c("GCMKS", "sdk version is too low");
        return bArr2;
    }

    public static byte[] i(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            g17.c("GCMKS", "content is null");
            return bArr2;
        }
        if (secretKey == null) {
            g17.c("GCMKS", "secret key is null");
            return bArr2;
        }
        if (!b()) {
            g17.c("GCMKS", "sdk version is too low");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKey);
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] iv = cipher.getIV();
            if (iv != null && iv.length == 12) {
                byte[] bArrCopyOf = Arrays.copyOf(iv, iv.length + bArrDoFinal.length);
                System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv.length, bArrDoFinal.length);
                return bArrCopyOf;
            }
            g17.c("GCMKS", "IV is invalid.");
            return bArr2;
        } catch (InvalidKeyException e) {
            g17.c("GCMKS", "InvalidKeyException : " + e.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e2) {
            g17.c("GCMKS", "NoSuchAlgorithmException : " + e2.getMessage());
            return bArr2;
        } catch (BadPaddingException e3) {
            g17.c("GCMKS", "BadPaddingException : " + e3.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e4) {
            g17.c("GCMKS", "IllegalBlockSizeException : " + e4.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e5) {
            g17.c("GCMKS", "NoSuchPaddingException : " + e5.getMessage());
            return bArr2;
        } catch (Exception e6) {
            g17.c("GCMKS", "Exception: " + e6.getMessage());
            return bArr2;
        }
    }
}
