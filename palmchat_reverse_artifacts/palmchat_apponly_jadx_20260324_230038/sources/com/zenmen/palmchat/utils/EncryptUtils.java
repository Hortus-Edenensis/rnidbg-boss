package com.zenmen.palmchat.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.ad.constant.x;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bx4;
import defpackage.mh2;
import defpackage.nl0;
import defpackage.ql2;
import defpackage.st3;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jivesoftware.smack.util.Base64;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class EncryptUtils {
    public static final String AES_CKEY_ENCRYPT_ALGORITHM = "AES/ECB/PKCS5Padding";
    public static final String AES_ENCRYPT_ALGORITHM = "AES";
    public static final String AES_SKEY_ENCRYPT_ALGORITHM = "AES/CBC/PKCS5Padding";
    public static final int CIPHER_METHOD_AES_APPKEY_DECRYPT = 7;
    public static final int CIPHER_METHOD_AES_APPKEY_ENCRYPT = 6;
    public static final int CIPHER_METHOD_AES_CKEY_DECRYPT = 3;
    public static final int CIPHER_METHOD_AES_CKEY_ENCRYPT = 2;
    public static final int CIPHER_METHOD_AES_SKEY_DECRYPT = 5;
    public static final int CIPHER_METHOD_AES_SKEY_ENCRYPT = 4;
    public static final int CIPHER_METHOD_RSA_ENCRYPT = 1;
    public static final int CKEY_TYPE = 1;
    private static final IvParameterSpec IV;
    public static final String RSA_ENCRYPT_ALGORITHM = "RSA";
    public static final int RSA_KEY_TYPE = 3;
    public static final int RSA_SOURCE_BYTE_LENGTH = 117;
    public static final int SKEY_TYPE = 2;
    public static final String TAG = "EncryptUtils";

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements ql2 {
        @Override // defpackage.ql2
        public Pair<byte[], byte[]> h() {
            return AppContext.getSecretKey();
        }

        @Override // defpackage.ql2
        public void i(String str, String str2) {
            AppContext.setSecretKey(str, str2);
        }

        @Override // defpackage.ql2
        public String j(String str) {
            return EncryptUtils.generateResToken(str);
        }

        @Override // defpackage.ql2
        public String k() {
            return EncryptUtils.getAppLogKey();
        }

        @Override // defpackage.ql2
        public String l(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return new String(EncryptUtils.cipherWithType(mh2.a(str.toCharArray()), 7, nl0.k()), StandardCharsets.UTF_8);
            } catch (Throwable th) {
                th.printStackTrace();
                return str;
            }
        }

        @Override // defpackage.ql2
        public String m(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return mh2.e(EncryptUtils.cipherWithType(str.getBytes(StandardCharsets.UTF_8), 6, nl0.k()));
            } catch (Throwable th) {
                th.printStackTrace();
                return str;
            }
        }

        @Override // defpackage.ql2
        public String n() {
            return EncryptUtils.generateMessageToken();
        }

        @Override // defpackage.ql2
        public boolean o() {
            return EncryptUtils.skeyAvailable();
        }

        @Override // defpackage.ql2
        public String p() {
            return EncryptUtils.getAppLogIv();
        }

        @Override // defpackage.ql2
        public byte[] q(byte[] bArr, boolean z) {
            return z ? EncryptUtils.cipherWithType(bArr, 4, nl0.k()) : EncryptUtils.cipherWithType(bArr, 5, nl0.k());
        }

        @Override // defpackage.ql2
        public String r(String str) {
            return EncryptUtils.generateMessageToken(str);
        }
    }

    static {
        st3.e(true);
        IV = new IvParameterSpec("0102030405060708".getBytes());
    }

    public static final native byte[] cipherWithHashKey(JSONObject jSONObject, int i, boolean z);

    public static final native byte[] cipherWithType(byte[] bArr, int i, boolean z);

    public static String createAESKey() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            sb.append(Character.valueOf((char) (random.nextInt(26) + 97)));
        }
        return sb.toString();
    }

    public static final native void createCKey();

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            return decrypt(bArr, bArr2, bArr3, "AES/CBC/PKCS5Padding");
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e4) {
            e4.printStackTrace();
            return null;
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e6) {
            e6.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static byte[] decryptAes(byte[] bArr, String str) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, getKey(str), IV);
        return cipher.doFinal(bArr);
    }

    public static String decryptString(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return new String(cipherWithType(mh2.a(str.toCharArray()), 7, nl0.k()));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String digestString(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(x.dW);
            messageDigest.update(str.getBytes("UTF-8"));
            return Base64.encodeBytes(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            return encrypt(bArr, bArr2, bArr3, "AES/CBC/PKCS5Padding");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidAlgorithmParameterException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e5) {
            e5.printStackTrace();
            return null;
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e7) {
            e7.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e8) {
            e8.printStackTrace();
            return null;
        }
    }

    public static byte[] encryptAes(byte[] bArr, String str) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, getKey(str), IV);
        return cipher.doFinal(bArr);
    }

    public static String encryptString(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return mh2.e(cipherWithType(str.getBytes(), 6, nl0.k()));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String genTokenFromInput(String str, boolean z) {
        byte[] bArrCipherWithType;
        try {
            bArrCipherWithType = cipherWithType(str.getBytes(), 4, nl0.k());
        } catch (Exception e) {
            e.printStackTrace();
            bArrCipherWithType = null;
        }
        return bArrCipherWithType != null ? z ? new String(android.util.Base64.encode(bArrCipherWithType, 2), StandardCharsets.UTF_8) : Base64.encodeBytes(bArrCipherWithType) : "";
    }

    public static String generateMessageToken() {
        return generateMessageToken(false);
    }

    public static String generateResToken(String str) {
        if (!skeyAvailable()) {
            LogUtil.d(TAG, "param null");
            return "";
        }
        String strP = AccountUtils.p(AppContext.getContext());
        String string = Long.toString(System.currentTimeMillis());
        if (TextUtils.isEmpty(str) || strP == null) {
            LogUtil.d(TAG, "param null");
            return "";
        }
        return genTokenFromInput(str + "_" + strP + "_" + string, false);
    }

    public static final native String getAppKey();

    public static final native String getAppLogIv();

    public static final native String getAppLogKey();

    public static final native String getAppSec();

    public static final native String getCkVersion();

    public static final native byte[] getEncryptedCKey(boolean z);

    private static Key getKey(String str) throws Exception {
        return new SecretKeySpec(str.getBytes(), AES_ENCRYPT_ALGORITHM);
    }

    public static final native void setLxData(JSONObject jSONObject);

    public static final native boolean skeyAvailable();

    public static String generateMessageToken(boolean z) {
        if (!skeyAvailable()) {
            return "";
        }
        String strP = AccountUtils.p(AppContext.getContext());
        String string = Long.toString(System.currentTimeMillis());
        if (strP != null && string != null) {
            bx4.a(strP, "generateMessageToken");
            String str = strP + "_" + string;
            String strGenTokenFromInput = genTokenFromInput(str, z);
            return !bx4.c(strGenTokenFromInput, strP, z) ? genTokenFromInput(str, z) : strGenTokenFromInput;
        }
        return "";
    }

    public static byte[] decryptAes(byte[] bArr) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, getKey("HETOthwaOjxCBOzv"), new IvParameterSpec("GpTlDKHTZHXcUzKV".getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Key keyGeneratePrivate;
        if (str.startsWith(AES_ENCRYPT_ALGORITHM)) {
            keyGeneratePrivate = new SecretKeySpec(bArr, AES_ENCRYPT_ALGORITHM);
        } else {
            keyGeneratePrivate = str.startsWith(RSA_ENCRYPT_ALGORITHM) ? KeyFactory.getInstance(RSA_ENCRYPT_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(bArr)) : null;
        }
        Cipher cipher = Cipher.getInstance(str);
        if (bArr2 == null) {
            cipher.init(2, keyGeneratePrivate);
        } else {
            cipher.init(2, keyGeneratePrivate, new IvParameterSpec(bArr2));
        }
        return cipher.doFinal(bArr3);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        Key keyGeneratePublic;
        if (str.startsWith(AES_ENCRYPT_ALGORITHM)) {
            keyGeneratePublic = new SecretKeySpec(bArr, AES_ENCRYPT_ALGORITHM);
        } else {
            keyGeneratePublic = str.startsWith(RSA_ENCRYPT_ALGORITHM) ? KeyFactory.getInstance(RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(bArr)) : null;
        }
        Cipher cipher = Cipher.getInstance(str);
        if (bArr2 == null) {
            cipher.init(1, keyGeneratePublic);
        } else {
            cipher.init(1, keyGeneratePublic, new IvParameterSpec(bArr2));
        }
        if (str.startsWith(RSA_ENCRYPT_ALGORITHM) && bArr3.length > 117) {
            int length = bArr3.length / 117;
            int i = length * 117;
            int length2 = bArr3.length - i;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i2 = 0; i2 < length; i2++) {
                byteArrayOutputStream.write(cipher.doFinal(bArr3, i2 * 117, 117));
            }
            if (length2 > 0) {
                byteArrayOutputStream.write(cipher.doFinal(bArr3, i, length2));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        }
        return cipher.doFinal(bArr3);
    }

    public static String generateMessageToken(String str) {
        if (!skeyAvailable()) {
            LogUtil.d(TAG, "param null");
            return "";
        }
        return genTokenFromInput(str + "_" + Long.toString(System.currentTimeMillis()), false);
    }
}
