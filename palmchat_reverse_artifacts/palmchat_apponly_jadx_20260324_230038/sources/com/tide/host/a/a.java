package com.tide.host.a;

import com.zenmen.palmchat.utils.EncryptUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class a {
    public static String a(String str) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            byte[] bytes = "v3fg2ZP3FVpRIVP2".getBytes(charset);
            byte[] bytes2 = "hOeLgloSBKDSN619".getBytes(charset);
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, EncryptUtils.AES_ENCRYPT_ALGORITHM);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(bArr), StandardCharsets.UTF_8).trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            byte[] bytes = "v3fg2ZP3FVpRIVP2".getBytes(charset);
            byte[] bytes2 = "hOeLgloSBKDSN619".getBytes(charset);
            byte[] bytes3 = str.getBytes(charset);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, EncryptUtils.AES_ENCRYPT_ALGORITHM);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            int blockSize = cipher.getBlockSize();
            int length = bytes3.length + (blockSize - (bytes3.length % blockSize));
            byte[] bArr = new byte[length];
            System.arraycopy(bytes3, 0, bArr, 0, bytes3.length);
            for (int length2 = bytes3.length; length2 < length; length2++) {
                bArr[length2] = 32;
            }
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            StringBuilder sb = new StringBuilder(bArrDoFinal.length * 2);
            for (byte b : bArrDoFinal) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
