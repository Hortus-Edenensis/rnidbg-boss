package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class jv extends mp {
    public static int a(mo moVar, byte b, int i) {
        moVar.b(2);
        a(moVar, i);
        a(moVar, b);
        return a(moVar);
    }

    private static void a(mo moVar, byte b) {
        moVar.a(0, b);
    }

    private static void a(mo moVar, int i) {
        moVar.b(1, i);
    }

    public static int a(mo moVar, byte[] bArr) {
        moVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            moVar.a(bArr[length]);
        }
        return moVar.a();
    }

    private static int a(mo moVar) {
        return moVar.b();
    }
}
