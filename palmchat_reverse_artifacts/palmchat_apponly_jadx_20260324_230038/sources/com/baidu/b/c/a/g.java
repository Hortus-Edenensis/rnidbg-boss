package com.baidu.b.c.a;

import com.umeng.analytics.pro.dn;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile byte[] f3324a;

    public static byte[] a() throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (f3324a == null) {
            synchronized (g.class) {
                if (f3324a == null) {
                    byte[] bArr = new byte[16];
                    System.arraycopy(com.baidu.b.c.c.b.b(), 0, bArr, 0, 16);
                    c cVar = new c();
                    cVar.a(2, bArr, bArr);
                    f3324a = cVar.a(new byte[]{-71, -100, -115, 26, 39, -124, dn.l, dn.l, -31, -46, -56, 1, 25, -127, -99, -107, -54, 51, 46, dn.l, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});
                }
            }
        }
        return f3324a;
    }
}
