package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fy4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f17623a;

    public static long a(Context context, long j) {
        long j2 = b(context).getLong("next_rid", j);
        if (j2 == j) {
            return j2;
        }
        long jD = d(j2);
        b(context).edit().putLong("next_rid", jD).apply();
        return jD;
    }

    public static SharedPreferences b(Context context) {
        if (f17623a == null) {
            c(context);
        }
        return f17623a;
    }

    public static void c(Context context) {
        f17623a = context.getSharedPreferences("cn.jpush.preferences.support.rid", 0);
    }

    public static long d(long j) {
        return (j + (j % 2 == 0 ? 1L : 2L)) % 32767;
    }

    public static synchronized long e(Context context) {
        long jA;
        jA = a(context, -1L);
        if (jA == -1) {
            jA = d(Math.abs(new Random().nextInt(32767)));
            b(context).edit().putLong("next_rid", jA).apply();
        }
        return jA;
    }
}
