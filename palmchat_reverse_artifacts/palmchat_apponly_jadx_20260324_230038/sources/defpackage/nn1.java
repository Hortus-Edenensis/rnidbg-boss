package defpackage;

import defpackage.x25;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class nn1 extends x25 implements z25 {
    public static final int d;
    public static final c e;
    public static final b f;
    public final ThreadFactory b;
    public final AtomicReference<b> c = new AtomicReference<>(f);

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends x25.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bn5 f19560a;
        public final hk0 b;
        public final bn5 c;
        public final c d;

        /* JADX INFO: renamed from: nn1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1252a implements b5 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b5 f19561a;

            public C1252a(b5 b5Var) {
                this.f19561a = b5Var;
            }

            @Override // defpackage.b5
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f19561a.call();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements b5 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b5 f19562a;

            public b(b5 b5Var) {
                this.f19562a = b5Var;
            }

            @Override // defpackage.b5
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f19562a.call();
            }
        }

        public a(c cVar) {
            bn5 bn5Var = new bn5();
            this.f19560a = bn5Var;
            hk0 hk0Var = new hk0();
            this.b = hk0Var;
            this.c = new bn5(bn5Var, hk0Var);
            this.d = cVar;
        }

        @Override // x25.a
        public zm5 a(b5 b5Var) {
            return isUnsubscribed() ? cn5.c() : this.d.i(new C1252a(b5Var), 0L, null, this.f19560a);
        }

        @Override // x25.a
        public zm5 b(b5 b5Var, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? cn5.c() : this.d.h(new b(b5Var), j, timeUnit, this.b);
        }

        @Override // defpackage.zm5
        public boolean isUnsubscribed() {
            return this.c.isUnsubscribed();
        }

        @Override // defpackage.zm5
        public void unsubscribe() {
            this.c.unsubscribe();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19563a;
        public final c[] b;
        public long c;

        public b(ThreadFactory threadFactory, int i) {
            this.f19563a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f19563a;
            if (i == 0) {
                return nn1.e;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % ((long) i))];
        }

        public void b() {
            for (c cVar : this.b) {
                cVar.unsubscribe();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends xx3 {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int iIntValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iIntValue <= 0 || iIntValue > iAvailableProcessors) {
            iIntValue = iAvailableProcessors;
        }
        d = iIntValue;
        c cVar = new c(RxThreadFactory.NONE);
        e = cVar;
        cVar.unsubscribe();
        f = new b(null, 0);
    }

    public nn1(ThreadFactory threadFactory) {
        this.b = threadFactory;
        d();
    }

    @Override // defpackage.x25
    public x25.a a() {
        return new a(this.c.get().a());
    }

    public zm5 c(b5 b5Var) {
        return this.c.get().a().g(b5Var, -1L, TimeUnit.NANOSECONDS);
    }

    public void d() {
        b bVar = new b(this.b, d);
        if (g23.a(this.c, f, bVar)) {
            return;
        }
        bVar.b();
    }

    @Override // defpackage.z25
    public void shutdown() {
        b bVar;
        b bVar2;
        do {
            bVar = this.c.get();
            bVar2 = f;
            if (bVar == bVar2) {
                return;
            }
        } while (!g23.a(this.c, bVar, bVar2));
        bVar.b();
    }
}
