package com.amap.api.col.p0002sl;

import com.umeng.analytics.pro.dn;
import com.zenmen.palmchat.utils.EncryptUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f3033a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final byte[] b;
    private static final IvParameterSpec c;

    static {
        byte[] bArr = {0, 1, 1, 2, 3, 5, 8, dn.k, 8, 7, 6, 5, 4, 3, 2, 1};
        b = bArr;
        c = new IvParameterSpec(bArr);
    }

    public static byte[] a(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, EncryptUtils.AES_ENCRYPT_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(ge.c()));
            return cipher.doFinal(bArr3);
        } catch (Throwable th) {
            nl.a(th, "Encrypt", "decryptRsponse length = ".concat(String.valueOf(bArr != null ? bArr.length : 0)));
            return null;
        }
    }
}
