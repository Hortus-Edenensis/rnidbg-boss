package com.kuaishou.weapon.p0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7405a = "AES/CBC/NoPadding";
    public static final int b = 16;
    public static final String c = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";
    private static final String d = "AES/CBC/PKCS5Padding";
    private static final String e = "AES";
    private static final String f = "AES/CBC/PKCS7Padding";

    public static byte[] a(String str, String str2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(String str, String str2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|50|3|(4:5|(2:8|6)|69|9)(2:10|(1:12))|13|(12:63|14|58|15|56|16|(1:18)|70|19|20|52|21)|(5:22|(1:24)(1:71)|62|28|45)|25|67|26|60|27|62|28|45|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(28:0|2|50|3|(4:5|(2:8|6)|69|9)(2:10|(1:12))|13|63|14|58|15|56|16|(1:18)|70|19|20|52|21|(5:22|(1:24)(1:71)|62|28|45)|25|67|26|60|27|62|28|45|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(String str, String str2, byte[] bArr) {
        CipherInputStream cipherInputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        byte[] bArr2;
        try {
            String str3 = new String(bArr);
            if (str3.length() < 16) {
                int length = str3.length();
                StringBuilder sb = new StringBuilder(str3);
                for (int i = 0; i < 16 - length; i++) {
                    sb.append("0");
                }
                str3 = sb.toString();
            } else if (str3.length() > 16) {
                str3 = str3.substring(0, 16);
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        byte[] bArr3 = new byte[16];
                        for (int i2 = 0; i2 < 16; i2++) {
                            bArr3[i2] = 0;
                        }
                        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                        cipherInputStream = new CipherInputStream(fileInputStream, cipher);
                        try {
                            bArr2 = new byte[1024];
                        } catch (Throwable unused) {
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (cipherInputStream != null) {
                            }
                            return 0;
                        }
                    } catch (Throwable unused4) {
                        cipherInputStream = null;
                    }
                } catch (Throwable unused5) {
                    cipherInputStream = null;
                }
            } catch (Throwable unused6) {
                cipherInputStream = null;
                fileInputStream = null;
            }
            while (true) {
                int i3 = cipherInputStream.read(bArr2);
                if (i3 == -1) {
                    break;
                }
                fileOutputStream.write(bArr2, 0, i3);
                cipherInputStream.close();
                return 0;
            }
            cipherInputStream.close();
            fileOutputStream.close();
            fileInputStream.close();
            cipherInputStream.close();
            return 0;
        } catch (Throwable unused7) {
            return -1;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            if (z) {
                byte[] bArr4 = new byte[bArr2.length - 16];
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                bArr2 = bArr4;
            }
            return cipher.doFinal(bArr2);
        } catch (Throwable th) {
            System.out.println(th.getMessage());
            return null;
        }
    }
}
