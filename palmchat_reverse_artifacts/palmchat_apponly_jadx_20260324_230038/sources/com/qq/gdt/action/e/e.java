package com.qq.gdt.action.e;

import com.qq.gdt.action.j.o;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f10489a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        try {
            char[] cArr = new char[length << 1];
            int i = 0;
            for (byte b : bArr) {
                int i2 = i + 1;
                char[] cArr2 = f10489a;
                cArr[i] = cArr2[(b >>> 4) & 15];
                i = i2 + 1;
                cArr[i2] = cArr2[b & 15];
            }
            return new String(cArr);
        } catch (Throwable th) {
            o.b("bytes2HexString", th);
            return null;
        }
    }
}
