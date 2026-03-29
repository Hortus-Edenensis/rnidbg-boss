package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class mg5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Long f19214a;
    public static volatile Long b;

    public static long a(Context context) {
        if (f19214a != null && b != null) {
            return f19214a.longValue() - b.longValue();
        }
        long jLongValue = ((Long) lg5.c(context, zz2.G())).longValue();
        long jLongValue2 = ((Long) lg5.c(context, zz2.J())).longValue();
        if (jLongValue == 0 || jLongValue2 == 0) {
            return 0L;
        }
        f19214a = Long.valueOf(jLongValue2);
        b = Long.valueOf(jLongValue);
        return jLongValue2 - jLongValue;
    }

    public static long b(Context context) {
        return c(context, System.currentTimeMillis());
    }

    public static long c(Context context, long j) {
        return (j + a(context)) / 1000;
    }

    public static boolean d(Context context) {
        if (((Long) lg5.c(context, zz2.K())).longValue() <= 0) {
            k63.j("SpHelper", "isValidRegistered uid <= 0");
            return false;
        }
        if (!TextUtils.isEmpty((String) lg5.c(context, zz2.I()))) {
            return true;
        }
        k63.j("SpHelper", "isValidRegistered regId is empty");
        return false;
    }

    public static void e(Context context, long j) {
        if (j > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            f19214a = Long.valueOf(j);
            b = Long.valueOf(jCurrentTimeMillis);
            lg5.h(context, zz2.J().a0(Long.valueOf(j)), zz2.G().a0(Long.valueOf(jCurrentTimeMillis)));
        }
    }
}
