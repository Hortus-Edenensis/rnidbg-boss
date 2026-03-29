package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class an {
    public static int a(int i) {
        int iE = wm.c().e();
        int iA = wm.c().a();
        int i2 = iE * i;
        return iA == 0 ? i : i2 % iA == 0 ? i2 / iA : (i2 / iA) + 1;
    }

    public static int b(int i) {
        int iF = wm.c().f();
        int iB = wm.c().b();
        int i2 = iF * i;
        return iB == 0 ? i : i2 % iB == 0 ? i2 / iB : (i2 / iB) + 1;
    }
}
