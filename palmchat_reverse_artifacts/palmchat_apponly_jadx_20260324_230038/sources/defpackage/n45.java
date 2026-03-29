package defpackage;

import android.util.Base64;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class n45 {
    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z) throws Exception {
        if (str == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(g(str, "UTF-8"), EncryptUtils.AES_ENCRYPT_ALGORITHM);
        IvParameterSpec ivParameterSpecL = l(str2.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z ? 1 : 2, secretKeySpec, ivParameterSpecL);
        return cipher.doFinal(bArr);
    }

    public static String b(byte[] bArr, long j) throws Exception {
        return f(bArr, o(j), o(~j));
    }

    public static String c(String str) {
        try {
            return new String(d(str, "DFA84B10B7ACDD25", "DFA84B10B7ACDD25"));
        } catch (Exception unused) {
            k63.l("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    public static byte[] d(String str, String str2, String str3) throws Exception {
        return a(Base64.decode(str, 2), str2, str3, false);
    }

    public static String e(String str) {
        try {
            return f(str.getBytes(), "DFA84B10B7ACDD25", "DFA84B10B7ACDD25");
        } catch (Exception unused) {
            k63.l("", "Unexpected - failed to AES encrypt.");
            return "";
        }
    }

    public static String f(byte[] bArr, String str, String str2) throws Exception {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    public static byte[] g(String str, String str2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }

    public static String h(long j) {
        long j2;
        long j3;
        switch ((int) (j % 10)) {
            case 1:
                j2 = 5 * j;
                j3 = j % 88;
                break;
            case 2:
                j2 = 23 * j;
                j3 = j % 15;
                break;
            case 3:
                j2 = 3 * j;
                j3 = j % 73;
                break;
            case 4:
                j2 = 13 * j;
                j3 = j % 96;
                break;
            case 5:
                j2 = 17 * j;
                j3 = j % 49;
                break;
            case 6:
                j2 = 7 * j;
                j3 = j % 68;
                break;
            case 7:
                j2 = 31 * j;
                j3 = j % 39;
                break;
            case 8:
                j2 = 29 * j;
                j3 = j % 41;
                break;
            case 9:
                j2 = 37 * j;
                j3 = j % 91;
                break;
            default:
                j2 = 8 * j;
                j3 = j % 74;
                break;
        }
        return nl5.g("JCKP" + (j2 + j3));
    }

    public static int i() {
        return Math.abs(new SecureRandom().nextInt()) & 16777215;
    }

    public static <T> T j(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws Exception {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static RSAPublicKey k(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static IvParameterSpec l(byte[] bArr) {
        try {
            return (IvParameterSpec) j(IvParameterSpec.class, new Object[]{bArr}, new Class[]{byte[].class});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized byte[] m(String str, RSAPublicKey rSAPublicKey) throws Exception {
        Cipher cipher;
        cipher = Cipher.getInstance(sw0.b);
        cipher.init(1, rSAPublicKey);
        return cipher.doFinal(str.getBytes());
    }

    public static String n(String str, String str2) throws Exception {
        return new String(Base64.encode(m(str, k(str2)), 2), "UTF-8");
    }

    public static String o(long j) {
        return String.format(Locale.ENGLISH, "%016d", Long.valueOf(j % 1000000000000000L));
    }
}
