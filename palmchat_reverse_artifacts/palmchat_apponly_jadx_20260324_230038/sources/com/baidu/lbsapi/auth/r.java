package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static KeyPair f3382a;

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && f3382a != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, f3382a.getPrivate());
                return c.a(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8.name());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String b() {
        PublicKey publicKey;
        KeyPair keyPair = f3382a;
        if (keyPair == null || (publicKey = keyPair.getPublic()) == null) {
            return null;
        }
        try {
            return c.a(publicKey.getEncoded(), StandardCharsets.UTF_8.name());
        } catch (Exception unused) {
            return null;
        }
    }

    public static KeyPair a() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM);
            keyPairGenerator.initialize(2048, new SecureRandom());
            if (f3382a == null) {
                f3382a = keyPairGenerator.generateKeyPair();
            }
            return f3382a;
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str) {
        if (!TextUtils.isEmpty(str) && f3382a != null) {
            try {
                byte[] bArrA = c.a(str.getBytes(StandardCharsets.UTF_8));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, f3382a.getPrivate());
                return cipher.doFinal(bArrA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
