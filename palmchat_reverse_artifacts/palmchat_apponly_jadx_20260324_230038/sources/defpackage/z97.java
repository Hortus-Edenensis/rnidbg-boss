package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class z97 {
    public static boolean a(long j) {
        if (nj7.c(2)) {
            return true;
        }
        if (nj7.c(1024)) {
            return false;
        }
        return (nz6.s() == -1 || j - nz6.s() <= x97.o().getLaunchCrashInterval()) && !(x97.s() && x97.v() == 0);
    }
}
