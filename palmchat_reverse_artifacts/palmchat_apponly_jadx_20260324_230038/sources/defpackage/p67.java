package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class p67 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f19951a = System.currentTimeMillis();
    public static long b = System.currentTimeMillis();

    public static boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - f19951a < 3600000) {
            return false;
        }
        f19951a = jCurrentTimeMillis;
        return true;
    }

    public static boolean b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - b < 20000) {
            return false;
        }
        b = jCurrentTimeMillis;
        return true;
    }
}
