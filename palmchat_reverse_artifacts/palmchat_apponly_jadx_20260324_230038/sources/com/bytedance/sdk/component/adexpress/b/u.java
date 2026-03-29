package com.bytedance.sdk.component.adexpress.b;

import com.umeng.analytics.pro.dn;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static final byte[] u = {-119, 80, 78, 71, dn.k, 10, 26, 10};
    private static final byte[] nr = {97, 99, 84, 76};

    public static boolean u(byte[] bArr) {
        try {
            if (!u(bArr, u)) {
                return false;
            }
            int i = 8;
            while (i >= 0) {
                if (i + 12 > bArr.length) {
                    break;
                }
                int iU = u(bArr, i);
                int i2 = i + 4;
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i2, bArr2, 0, 4);
                int i3 = i2 + 4;
                if (Arrays.equals(bArr2, nr)) {
                    return true;
                }
                i = i3 + iU + 4;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean u(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int u(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }
}
