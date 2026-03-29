package com.lantern.core.network;

import com.lantern.core.business.ParamHelper;
import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NESecretKey {
    public static byte[] decryptAES(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            String aesKey = ParamHelper.getAesKey();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ParamHelper.getAesIv().getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static byte[] encryptAES(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            String aesKey = ParamHelper.getAesKey();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ParamHelper.getAesIv().getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey.getBytes(), EncryptUtils.AES_ENCRYPT_ALGORITHM);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
