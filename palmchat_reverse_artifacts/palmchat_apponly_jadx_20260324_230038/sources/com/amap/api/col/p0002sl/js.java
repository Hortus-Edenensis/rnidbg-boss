package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class js extends mp {
    public static int a(mo moVar, int i, byte b, int i2, int i3) {
        moVar.b(4);
        c(moVar, i3);
        b(moVar, i2);
        a(moVar, i);
        a(moVar, b);
        return a(moVar);
    }

    private static void b(mo moVar, int i) {
        moVar.b(2, i);
    }

    private static void c(mo moVar, int i) {
        moVar.b(3, i);
    }

    public static int b(mo moVar, int[] iArr) {
        moVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            moVar.a(iArr[length]);
        }
        return moVar.a();
    }

    private static void a(mo moVar, int i) {
        moVar.b(0, i);
    }

    private static void a(mo moVar, byte b) {
        moVar.a(1, b);
    }

    public static int a(mo moVar, int[] iArr) {
        moVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            moVar.a(iArr[length]);
        }
        return moVar.a();
    }

    private static int a(mo moVar) {
        return moVar.b();
    }
}
