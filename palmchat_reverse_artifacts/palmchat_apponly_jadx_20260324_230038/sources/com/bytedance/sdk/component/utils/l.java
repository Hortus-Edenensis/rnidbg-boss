package com.bytedance.sdk.component.utils;

import com.huawei.openalliance.ad.constant.bh;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.analytics.pro.dn;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l {
    private static final byte[] b;
    private static final byte[] fx;
    private static final byte[] iz;
    private static final byte[] nr;
    private static final byte[] pn;
    private static final byte[] u;
    private static final int x;

    static {
        byte[] bArr = {-1, -40, -1};
        u = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, dn.k, 10, 26, 10};
        nr = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        fx = bArr3;
        byte[] bArrU = u("BM");
        b = bArrU;
        pn = u("GIF87a");
        iz = u("GIF89a");
        x = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(bArrU.length), 6))).intValue();
    }

    private static boolean b(byte[] bArr) {
        return (bArr.length >= 6 && u(bArr, pn)) || u(bArr, iz);
    }

    private static boolean fx(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = nr;
        return length >= bArr2.length && u(bArr, bArr2);
    }

    private static boolean iz(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = fx;
        return length >= bArr2.length && u(bArr, bArr2);
    }

    private static boolean nr(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = u;
        return length >= bArr2.length && u(bArr, bArr2);
    }

    private static boolean pn(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = b;
        return length >= bArr2.length && u(bArr, bArr2);
    }

    public static int u() {
        return x;
    }

    public static final String u(byte[] bArr) {
        return nr(bArr) ? "jpeg" : fx(bArr) ? "png" : b(bArr) ? bh.V : pn(bArr) ? "bmp" : iz(bArr) ? "ico" : AdnName.OTHER;
    }

    private static boolean u(byte[] bArr, byte[] bArr2) {
        return u(bArr, bArr2, 0);
    }

    private static boolean u(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] u(String str) {
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }
}
