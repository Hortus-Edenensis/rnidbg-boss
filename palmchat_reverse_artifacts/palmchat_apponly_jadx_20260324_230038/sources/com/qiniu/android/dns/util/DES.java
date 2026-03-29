package com.qiniu.android.dns.util;

import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DES {
    public static String decrypt(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str2.getBytes())));
            return new String(cipher.doFinal(Hex.decodeHex(str.toCharArray())), Charset.defaultCharset());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str2.getBytes())));
            return Hex.encodeHexString(cipher.doFinal(str.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
