package com.bytedance.adsdk.u.u.nr;

import android.text.TextUtils;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends pn {
    private static ThreadLocal<byte[]> nr = new ThreadLocal<>();

    public u(iz izVar) {
        super(izVar);
    }

    public static byte[] u() {
        byte[] bArr = nr.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        nr.set(bArr2);
        return bArr2;
    }

    public short a_() throws IOException {
        byte[] bArrU = u();
        u(bArrU, 0, 2);
        return (short) (((bArrU[0] & UByte.MAX_VALUE) << 8) | (bArrU[1] & UByte.MAX_VALUE));
    }

    public int b_() throws IOException {
        byte[] bArrU = u();
        u(bArrU, 0, 4);
        return ((bArrU[3] & UByte.MAX_VALUE) << 24) | (bArrU[0] & UByte.MAX_VALUE) | ((bArrU[1] & UByte.MAX_VALUE) << 8) | ((bArrU[2] & UByte.MAX_VALUE) << 16);
    }

    public int nr() throws IOException {
        byte[] bArrU = u();
        u(bArrU, 0, 4);
        return ((bArrU[0] & UByte.MAX_VALUE) << 24) | (bArrU[3] & UByte.MAX_VALUE) | ((bArrU[2] & UByte.MAX_VALUE) << 8) | ((bArrU[1] & UByte.MAX_VALUE) << 16);
    }

    public boolean u(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int iB_ = b_();
        for (int i = 0; i < 4; i++) {
            if (((iB_ >> (i * 8)) & 255) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
