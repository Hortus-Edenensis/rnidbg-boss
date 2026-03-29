package com.baidu.b.a;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g[] f3296a = {new h(8, 0), new j(0, 1), new j(1, 1), new h(7, 1)};

    public byte[] a(byte[] bArr) {
        f fVar = new f();
        byte[] bArrA = c.a(bArr, bArr.length + ((this.f3296a.length + 1) * f.f3298a));
        c.a(bArrA, fVar.a(), bArr.length);
        int i = 0;
        while (true) {
            g[] gVarArr = this.f3296a;
            if (i >= gVarArr.length) {
                return Arrays.copyOf(fVar.a(), f.f3298a);
            }
            g gVar = gVarArr[i];
            i++;
            int length = bArr.length + (f.f3298a * i);
            fVar.a(gVar.a(bArrA, 0, length), gVar.a(), gVar.b(), gVar.c());
            c.a(bArrA, fVar.a(), length);
        }
    }
}
