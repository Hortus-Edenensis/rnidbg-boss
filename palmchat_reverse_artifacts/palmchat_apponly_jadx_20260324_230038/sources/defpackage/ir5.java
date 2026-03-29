package defpackage;

import android.os.SystemClock;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ir5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f18244a = 0;
    public static long b = 0;
    public static boolean c = false;
    public static SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");

    public static String a() {
        try {
            return d.format(Long.valueOf(b()));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static long b() {
        return c(false);
    }

    public static long c(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (f() && z) ? (b + SystemClock.elapsedRealtime()) - f18244a : jCurrentTimeMillis;
    }

    public static long d(long j) {
        try {
            return d.parse(d.format(Long.valueOf(j))).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return j;
        }
    }

    public static long e(long j) {
        return b() - j;
    }

    public static boolean f() {
        return c;
    }

    public static void g(long j) {
        b = j;
        f18244a = SystemClock.elapsedRealtime();
        c = true;
    }
}
