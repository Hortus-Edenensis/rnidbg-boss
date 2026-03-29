package com.zx.a.I8b7;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class s1 {
    public static s1 a(x0 x0Var, String str) {
        Charset.forName("UTF-8");
        if (x0Var != null && x0Var.a() == null) {
            Charset.forName("UTF-8");
            x0Var = x0.b(x0Var + "; charset=utf-8");
        }
        return a(x0Var, str.getBytes(StandardCharsets.UTF_8));
    }

    public static s1 a(x0 x0Var, byte[] bArr) {
        int length = bArr.length;
        long length2 = bArr.length;
        long j = 0;
        long j2 = length;
        if ((j | j2) >= 0 && j <= length2 && length2 - j >= j2) {
            return new r1(x0Var, length, bArr, 0);
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
