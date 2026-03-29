package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class l50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f18906a;

    public static boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - f18906a;
        if (j < 500 && j > 0) {
            return true;
        }
        f18906a = jCurrentTimeMillis;
        return false;
    }
}
