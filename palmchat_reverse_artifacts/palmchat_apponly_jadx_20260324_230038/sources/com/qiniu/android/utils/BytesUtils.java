package com.qiniu.android.utils;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BytesUtils {
    public static byte[] subBytes(byte[] bArr, int i, int i2) throws IOException {
        if (i2 + i > bArr.length) {
            throw new IOException("copy bytes out of range");
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
