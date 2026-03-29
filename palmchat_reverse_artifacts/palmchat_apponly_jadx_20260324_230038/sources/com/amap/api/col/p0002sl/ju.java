package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ju extends mp {
    public static int a(mo moVar, byte b, byte b2, short s, byte b3, int i) {
        moVar.b(5);
        a(moVar, i);
        a(moVar, s);
        c(moVar, b3);
        b(moVar, b2);
        a(moVar, b);
        return a(moVar);
    }

    private static void b(mo moVar, byte b) {
        moVar.a(1, b);
    }

    private static void c(mo moVar, byte b) {
        moVar.a(3, b);
    }

    private static void a(mo moVar, byte b) {
        moVar.a(0, b);
    }

    private static void a(mo moVar, short s) {
        moVar.a(2, s);
    }

    private static void a(mo moVar, int i) {
        moVar.b(4, i);
    }

    private static int a(mo moVar) {
        return moVar.b();
    }
}
