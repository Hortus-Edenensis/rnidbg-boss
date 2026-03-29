package cn.fly.verify;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bi f2102a;
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final CopyOnWriteArrayList<bh> c = new CopyOnWriteArrayList<>();

    private bi() {
    }

    public static bi a() {
        if (f2102a == null) {
            synchronized (ej.class) {
                if (f2102a == null) {
                    f2102a = new bi();
                }
            }
        }
        return f2102a;
    }

    private long c() {
        return ((Integer) fz.a(by.a(dx.a("003IbhPhg"), 300), 300)).intValue() * 1000;
    }

    public void b() {
        if (this.b.compareAndSet(false, true)) {
            a(new bf(), 0);
            a(new bg(), 0);
            a(new bj(), 0);
            a(new bk(), 0);
            a(new bp(), 0);
            bl blVar = new bl();
            blVar.a(true);
            a(blVar, 0);
            a(new bm(), 0);
            a(new bo(), 0);
            a(new bn(), 0);
            a(new br(), 0);
            a(new bs(), 0);
            a(new bt(), 0);
            ek.c.execute(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        bq bqVarA;
        long jC;
        if (this.c.size() <= 0) {
            bqVarA = bq.a();
            jC = c();
        } else if (by.d() && Cdo.i()) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (bh bhVar : this.c) {
                    if (jCurrentTimeMillis >= bhVar.j()) {
                        bhVar.h();
                    }
                }
            } catch (Throwable unused) {
            }
            bqVarA = bq.a();
            jC = c();
        } else {
            bqVarA = bq.a();
            jC = 60000;
        }
        bqVarA.d(jC, this);
    }

    public <T extends bh> void a(T t, int i) {
        if (i != 1) {
            if (i != 3) {
                this.c.add(t);
                return;
            } else {
                this.c.add(0, t);
                return;
            }
        }
        for (bh bhVar : this.c) {
            if (t.k() == bhVar.k()) {
                this.c.set(this.c.indexOf(bhVar), t);
            } else {
                this.c.add(t);
            }
        }
    }

    public void a(bh bhVar, long j, int i) {
        if (j == 0 && (i == 0 || i == 3)) {
            bhVar.h();
        } else {
            bq.a().a(j, bhVar, i);
        }
    }
}
