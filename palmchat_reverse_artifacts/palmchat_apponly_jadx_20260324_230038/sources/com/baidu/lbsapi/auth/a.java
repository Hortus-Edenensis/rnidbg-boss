package com.baidu.lbsapi.auth;

import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        if (bArr == null || bArr.length <= 0 || bArr2 == null || bArr2.length <= 0 || bArr3 == null || bArr3.length <= 0) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, EncryptUtils.AES_ENCRYPT_ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
        return cipher.doFinal(bArr3);
    }
}
