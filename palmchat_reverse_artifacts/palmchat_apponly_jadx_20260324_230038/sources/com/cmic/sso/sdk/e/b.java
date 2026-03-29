package com.cmic.sso.sdk.e;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.openalliance.ad.constant.x;
import com.zenmen.palmchat.utils.EncryptUtils;
import defpackage.wy6;
import defpackage.xy6;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f5517a;

    public static boolean a(Context context, boolean z) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.getKey("CMCC_SDK_V1", null) != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            return a(context);
        }
        return false;
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bArrB = b(context);
        if (bArrB != null) {
            return a.b(bArrB, str, f5517a);
        }
        a();
        return null;
    }

    private static String c() {
        return k.b("AES_IV", "");
    }

    private static synchronized byte[] b(Context context) {
        Cipher cipher;
        byte[] bArrDoFinal;
        Cipher cipher2;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (!a(context, false)) {
                return null;
            }
            String strB = b();
            if (TextUtils.isEmpty(strB)) {
                bArrDoFinal = q.a();
                f5517a = q.a();
                Key key = keyStore.getKey("CMCC_SDK_V1", null);
                if (key instanceof SecretKey) {
                    c.b("KeystoreUtil", "随机生成aes秘钥");
                    cipher2 = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    cipher2.init(1, key, new IvParameterSpec(f5517a));
                } else {
                    if (!(key instanceof PrivateKey)) {
                        return null;
                    }
                    PublicKey publicKey = keyStore.getCertificate("CMCC_SDK_V1").getPublicKey();
                    Cipher cipher3 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                    c.b("KeystoreUtil", "生成rsa密");
                    cipher3.init(1, publicKey);
                    cipher2 = cipher3;
                }
                String strEncodeToString = Base64.encodeToString(cipher2.doFinal(bArrDoFinal), 0);
                String strEncodeToString2 = Base64.encodeToString(f5517a, 0);
                HashMap map = new HashMap();
                map.put("AES_IV", strEncodeToString2);
                map.put("AES_KEY", strEncodeToString);
                k.a(map);
            } else {
                f5517a = Base64.decode(c(), 0);
                byte[] bArrDecode = Base64.decode(strB, 0);
                Key key2 = keyStore.getKey("CMCC_SDK_V1", null);
                if (key2 == null) {
                    return null;
                }
                if (key2 instanceof SecretKey) {
                    cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                    cipher.init(2, key2, new IvParameterSpec(f5517a));
                    c.b("KeystoreUtil", "使用aes");
                } else {
                    if (!(key2 instanceof PrivateKey)) {
                        return null;
                    }
                    cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                    cipher.init(2, key2);
                    c.b("KeystoreUtil", "使用rsa");
                }
                bArrDoFinal = cipher.doFinal(bArrDecode);
                StringBuilder sb = new StringBuilder();
                sb.append("是否解密出秘钥：");
                sb.append(TextUtils.isEmpty(Base64.encodeToString(bArrDoFinal, 0)) ? false : true);
                c.b("KeystoreUtil", sb.toString());
            }
            return bArrDoFinal;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance(EncryptUtils.AES_ENCRYPT_ALGORITHM, "AndroidKeyStore");
                xy6.a();
                keyGenerator.init(wy6.a("CMCC_SDK_V1", 3).setDigests(x.dW, "SHA-512").setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).setKeySize(256).build());
                Thread.sleep(1000L);
                keyGenerator.generateKey();
                return true;
            } catch (Exception e) {
                c.a("KeystoreUtil", e.getMessage());
                return false;
            }
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(1, 30);
        try {
            KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(context).setAlias("CMCC_SDK_V1").setSubject(new X500Principal("CN=CMCC_SDK_V1")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM, "AndroidKeyStore");
            keyPairGenerator.initialize(keyPairGeneratorSpecBuild);
            Thread.sleep(1000L);
            keyPairGenerator.generateKeyPair();
            return true;
        } catch (Exception e2) {
            c.a("KeystoreUtil", e2.getMessage());
            return false;
        }
    }

    public static String a(Context context, String str) {
        a();
        byte[] bArrB = b(context);
        if (bArrB != null) {
            return a.a(bArrB, str, f5517a);
        }
        a();
        return null;
    }

    public static void a() {
        k.a("AES_KEY");
    }

    private static String b() {
        return k.b("AES_KEY", "");
    }
}
