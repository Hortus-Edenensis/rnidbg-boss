package com.bytedance.pangle.res.u;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static int nr(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        u(inputStream);
        u(bArr);
        int i3 = 0;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
        }
        u(i, i + i2, bArr.length);
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static <T> T u(T t) {
        t.getClass();
        return t;
    }

    public static void u(InputStream inputStream, byte[] bArr) throws IOException {
        u(inputStream, bArr, 0, bArr.length);
    }

    public static void u(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int iNr = nr(inputStream, bArr, i, i2);
        if (iNr == i2) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + iNr + " bytes; " + i2 + " bytes expected");
    }

    public static void u(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(i2);
            sb.append(i3);
            throw new IndexOutOfBoundsException(sb.toString());
        }
    }
}
