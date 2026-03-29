package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class kc extends mp {
    public static int a(mo moVar, int i) {
        moVar.b(1);
        b(moVar, i);
        return a(moVar);
    }

    private static void b(mo moVar, int i) {
        moVar.b(0, i);
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
