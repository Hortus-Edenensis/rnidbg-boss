package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bu5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static gp2 f1824a;

    public static void a(gp2 gp2Var) {
        f1824a = gp2Var;
    }

    public static boolean b() {
        gp2 gp2Var = f1824a;
        if (gp2Var != null) {
            return gp2Var.isOpen();
        }
        return false;
    }

    public static void c() {
        gp2 gp2Var = f1824a;
        if (gp2Var != null) {
            gp2Var.a();
        }
    }
}
