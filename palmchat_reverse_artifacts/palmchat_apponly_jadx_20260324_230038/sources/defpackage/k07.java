package defpackage;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class k07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f18547a = -1;

    public static synchronized boolean a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - f18547a < 3000) {
            return true;
        }
        f18547a = jElapsedRealtime;
        return false;
    }
}
