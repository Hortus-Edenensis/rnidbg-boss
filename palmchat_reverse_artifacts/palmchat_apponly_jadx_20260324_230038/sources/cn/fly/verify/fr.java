package cn.fly.verify;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fr {
    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArrA = a(fileInputStream);
                eg.a(fileInputStream);
                if (bArrA == null) {
                    return null;
                }
                return c(bArrA);
            } catch (Throwable th) {
                th = th;
                try {
                    en.a().b(th);
                    eg.a(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    eg.a(fileInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static String b(String str) {
        byte[] bArrC;
        if (str == null || (bArrC = c(str)) == null) {
            return null;
        }
        return c(bArrC);
    }

    public static String c(String str, String str2) throws Throwable {
        String strEncode = TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, str2);
        return TextUtils.isEmpty(strEncode) ? strEncode : strEncode.replace("+", "%20");
    }

    public static String d(String str, String str2) {
        try {
            String strEncodeToString = Base64.encodeToString(a(str2, str), 0);
            return strEncodeToString.contains("\n") ? strEncodeToString.replace("\n", "") : strEncodeToString;
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    public static byte[] e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return c(bArr, 0, bArr.length);
    }

    public static String f(byte[] bArr) throws Throwable {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 56)) & UByte.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 48)) & UByte.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 40)) & UByte.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 32)) & UByte.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 24)) & UByte.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 16)) & UByte.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 8)) & UByte.MAX_VALUE)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) value) & UByte.MAX_VALUE)));
        while (sb.charAt(0) == '0') {
            sb = sb.deleteCharAt(0);
        }
        return sb.toString().toLowerCase();
    }

    public static String a(String str, byte[] bArr) throws Throwable {
        if (str == null || bArr == null) {
            return null;
        }
        return new String(b(str.getBytes("UTF-8"), bArr), "UTF-8").trim();
    }

    public static String b(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            cArr2[i] = cArr[(b >>> 4) & 15];
            int i2 = i + 1;
            cArr2[i2] = cArr[b & 15];
            i = i2 + 1;
        }
        return new String(cArr2);
    }

    public static String d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return b(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return stringBuffer.toString();
        }
        while (i < i2) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
            i++;
        }
        return stringBuffer.toString();
    }

    public static String b(byte[] bArr, int i, int i2) {
        byte[] bArrC;
        if (bArr == null || (bArrC = c(bArr, i, i2)) == null) {
            return null;
        }
        return c(bArrC);
    }

    public static String c(byte[] bArr, byte[] bArr2) throws Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, ec.b("003(dkfgdi"));
        Cipher cipherB = b(ec.b("003Cdkfgdi") + ec.b("003kYfgfj") + ec.b("008Feh;kQfkhbfjdihifk") + ec.b("006c=cbcbch-d%dd"), ec.b("002Behfj"));
        cipherB.init(2, secretKeySpec);
        return new String(cipherB.doFinal(bArr2), "UTF-8").trim();
    }

    public static void a(String str, InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (str == null) {
            return;
        }
        a(str.getBytes("UTF-8"), inputStream, outputStream);
    }

    public static Cipher b(String str, String str2) throws Throwable {
        Cipher cipher = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                Provider provider = Security.getProvider(str2);
                if (provider != null) {
                    cipher = Cipher.getInstance(str, provider);
                }
            } catch (Throwable unused) {
            }
        }
        return cipher == null ? Cipher.getInstance(str, str2) : cipher;
    }

    public static byte[] c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return e(str.getBytes("utf-8"));
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    public static void a(byte[] bArr, InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (bArr == null || inputStream == null || outputStream == null) {
            return;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, ec.b("003Adkfgdi"));
        Cipher cipherB = b(ec.b("003Odkfgdi") + ec.b("003kDfgfj") + ec.b("0081eh)k2fkhbfjdihifk") + ec.b("006cOcbcbch dFdd"), ec.b("002Lehfj"));
        cipherB.init(2, secretKeySpec);
        CipherInputStream cipherInputStream = null;
        try {
            CipherInputStream cipherInputStream2 = new CipherInputStream(inputStream, cipherB);
            try {
                byte[] bArr3 = new byte[1024];
                while (true) {
                    int i = cipherInputStream2.read(bArr3);
                    if (i == -1) {
                        outputStream.flush();
                        eg.a(cipherInputStream2);
                        return;
                    }
                    outputStream.write(bArr3, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                cipherInputStream = cipherInputStream2;
                eg.a(cipherInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, ec.b("0036dkfgdi"));
        Cipher cipherB = b(ec.b("003Ndkfgdi") + ec.b("003k?fgfj") + ec.b("005>eh[kSdgdcfk") + ec.b("006cPcbcbchZdKdd"), ec.b("0027ehfj"));
        cipherB.init(2, secretKeySpec);
        byte[] bArr4 = new byte[cipherB.getOutputSize(bArr2.length)];
        cipherB.doFinal(bArr4, cipherB.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public static byte[] c(byte[] bArr, int i, int i2) {
        ByteArrayInputStream byteArrayInputStream;
        byte[] bArrA = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                bArrA = a(byteArrayInputStream);
                eg.a(byteArrayInputStream);
            } catch (Throwable th) {
                th = th;
                try {
                    en.a().b(th);
                    eg.a(byteArrayInputStream);
                } catch (Throwable th2) {
                    eg.a(byteArrayInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
        }
        return bArrA;
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance(ec.b("003+gbejgh"));
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, i);
            }
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    public static byte[] a(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(str.getBytes("utf-8"));
    }

    public static byte[] a(String str, String str2) throws Throwable {
        if (str == null || str2 == null) {
            return null;
        }
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        return a(bArr, str2);
    }

    public static byte[] a(byte[] bArr) throws Throwable {
        MessageDigest messageDigest = MessageDigest.getInstance(ec.b("005Kdieidkgjge"));
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static byte[] a(byte[] bArr, String str) throws Throwable {
        if (bArr == null || str == null) {
            return null;
        }
        return a(bArr, str.getBytes("UTF-8"));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Throwable {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, ec.b("003Udkfgdi"));
        Cipher cipherB = b(ec.b("003Ndkfgdi") + ec.b("003k7fgfj") + ec.b("008Xeh3kRfkhbfjdihifk") + ec.b("006c cbcbch]d1dd"), ec.b("002Dehfj"));
        cipherB.init(1, secretKeySpec);
        byte[] bArr3 = new byte[cipherB.getOutputSize(bArr2.length)];
        cipherB.doFinal(bArr3, cipherB.update(bArr2, 0, bArr2.length, bArr3, 0));
        return bArr3;
    }
}
