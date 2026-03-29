package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class go6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17764a = xn1.h().e().c();
    public static String b = b(xn1.h().k(), 0);
    public static String c = b(xn1.h().k(), 1);
    public static String d = b(xn1.h().k(), 2);

    public static fo6 a() {
        fo6 fo6Var = new fo6();
        fo6Var.f17569a = f17764a;
        fo6Var.b = b;
        fo6Var.c = c;
        fo6Var.d = d;
        return fo6Var;
    }

    public static String b(String str, int i) {
        return i != 0 ? i != 1 ? i != 2 ? "" : str.substring(32) : str.substring(16, 32) : str.substring(0, 16);
    }
}
