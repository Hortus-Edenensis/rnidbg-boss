package defpackage;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ng4 {
    public static volatile ng4 d;
    public static final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19508a;
    public gt5 b = new a();
    public long c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends gt5 {
        public a() {
        }

        @Override // defpackage.gt5
        public void a(Message message) {
            k63.a("PeriodWorker", "time is up, next period=" + (tt5.u().v() * 1000));
            ng4 ng4Var = ng4.this;
            ng4Var.e(ng4Var.f19508a);
        }
    }

    public static ng4 c() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new ng4();
                }
            }
        }
        return d;
    }

    public void d(Context context) {
        this.f19508a = context;
        nt5.b().e(8000, tt5.u().t() * 1000, this.b);
    }

    public final void e(Context context) {
        k63.a("PeriodWorker", "periodTask...");
        h(context);
        wv2.e(context, false, 0L);
        zd1.e().b(context, 19, 0, "periodTask");
        qv2.a(context, "periodtask", null);
    }

    public void f() {
        this.c = SystemClock.elapsedRealtime();
        h9.a(this.f19508a);
        nt5.b().e(8000, tt5.u().t() * 1000, this.b);
    }

    public void g(Context context, boolean z) {
        k63.g("PeriodWorker", "PeriodWorker resume");
        if (this.c > 0 && SystemClock.elapsedRealtime() > this.c + ((long) ((tt5.u().t() + 5) * 1000))) {
            k63.g("PeriodWorker", "schedule time is expired, execute now");
            d(context);
            e(context);
        } else if (!z) {
            k63.a("PeriodWorker", "need not change period task");
        } else {
            d(context);
            h(context);
        }
    }

    public final void h(Context context) {
        this.c = SystemClock.elapsedRealtime();
        if (((Boolean) lg5.c(context, zz2.k())).booleanValue()) {
            h9.a(context);
        } else {
            h9.b(context);
        }
    }
}
