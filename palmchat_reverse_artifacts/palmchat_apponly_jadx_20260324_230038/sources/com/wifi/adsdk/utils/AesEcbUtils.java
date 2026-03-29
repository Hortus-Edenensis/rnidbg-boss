package com.wifi.adsdk.utils;

import android.util.Base64;
import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AesEcbUtils {
    private static final String AES_ECB_MODE = "AES/ECB/PKCS5Padding";
    private static final String AES_KEY = "VwNizLJJCOEqGmyq";

    public static String decrypt(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(AES_KEY.getBytes("UTF-8"), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(Base64.decode(str, 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encrypt(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(AES_KEY.getBytes("UTF-8"), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 2);
        } catch (Exception unused) {
            return null;
        }
    }
}
