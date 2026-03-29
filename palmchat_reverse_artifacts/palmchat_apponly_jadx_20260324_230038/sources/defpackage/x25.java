package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class x25 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f21863a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a implements zm5 {
        public abstract zm5 a(b5 b5Var);

        public abstract zm5 b(b5 b5Var, long j, TimeUnit timeUnit);
    }

    public abstract a a();

    public long b() {
        return System.currentTimeMillis();
    }
}
