package defpackage;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class vu6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<Integer, Pair<Long, ?>> f21534a;
    public static ExecutorService b = Executors.newFixedThreadPool(16);

    /* JADX INFO: compiled from: SearchBox */
    public interface a<T, R> {
        R a(T t);
    }

    public static Context a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public static Pair<Boolean, ?> b(int i, TimeUnit timeUnit, long j) {
        ConcurrentHashMap<Integer, Pair<Long, ?>> concurrentHashMap = f21534a;
        if (concurrentHashMap == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Pair<Long, ?> pair = concurrentHashMap.get(Integer.valueOf(i));
        if (pair == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Long l = (Long) pair.first;
        return (l == null || SystemClock.elapsedRealtime() - l.longValue() > TimeUnit.MILLISECONDS.convert(j, timeUnit)) ? new Pair<>(Boolean.FALSE, null) : new Pair<>(Boolean.TRUE, pair.second);
    }

    public static <T> T c(int i, long j, TimeUnit timeUnit, a<Object, Boolean> aVar, Callable<T> callable, boolean z, long j2, TimeUnit timeUnit2, ru6 ru6Var, boolean z2) {
        T tCall;
        try {
            Pair<Boolean, ?> pairB = b(i, timeUnit, j);
            if (((Boolean) pairB.first).booleanValue() && aVar.a(pairB.second).booleanValue()) {
                w97.h("getC", i + " got " + pairB.second);
                return (T) pairB.second;
            }
            if (z2 && qh7.Z()) {
                xt6.g(ru6Var, "biz", "ch_get_main", "" + i);
                w97.h("getC", i + " skip");
                tCall = null;
            } else {
                tCall = z ? b.submit(callable).get(j2, timeUnit2) : callable.call();
                d(i, tCall);
            }
            w97.h("getC", i + " new " + tCall);
            return tCall;
        } catch (Throwable th) {
            w97.c("CDT", "ch_get_e|" + i, th);
            xt6.c(ru6Var, "biz", "ch_get_e|" + i, th);
            w97.h("getC", i + " err");
            return null;
        }
    }

    public static synchronized void d(int i, Object obj) {
        if (f21534a == null) {
            f21534a = new ConcurrentHashMap<>();
        }
        f21534a.put(Integer.valueOf(i), new Pair<>(Long.valueOf(SystemClock.elapsedRealtime()), obj));
    }
}
