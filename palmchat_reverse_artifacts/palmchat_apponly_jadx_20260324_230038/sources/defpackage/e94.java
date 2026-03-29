package defpackage;

import defpackage.n54;
import defpackage.x25;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class e94<T> implements n54.b<T, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x25 f17240a;
    public final boolean b;
    public final int c;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<T> extends sm5<T> implements b5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sm5<? super T> f17241a;
        public final x25.a b;
        public final boolean c;
        public final Queue<Object> d;
        public final int e;
        public volatile boolean f;
        public final AtomicLong g = new AtomicLong();
        public final AtomicLong h = new AtomicLong();
        public Throwable i;
        public long j;

        /* JADX INFO: renamed from: e94$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1187a implements kn4 {
            public C1187a() {
            }

            @Override // defpackage.kn4
            public void request(long j) {
                if (j > 0) {
                    so.b(a.this.g, j);
                    a.this.c();
                }
            }
        }

        public a(x25 x25Var, sm5<? super T> sm5Var, boolean z, int i) {
            this.f17241a = sm5Var;
            this.b = x25Var.a();
            this.c = z;
            i = i <= 0 ? rz4.f20629a : i;
            this.e = i - (i >> 2);
            if (s46.b()) {
                this.d = new lh5(i);
            } else {
                this.d = new sh5(i);
            }
            request(i);
        }

        public boolean a(boolean z, boolean z2, sm5<? super T> sm5Var, Queue<Object> queue) {
            if (sm5Var.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.c) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.i;
                try {
                    if (th != null) {
                        sm5Var.onError(th);
                    } else {
                        sm5Var.onCompleted();
                    }
                    return false;
                } finally {
                }
            }
            Throwable th2 = this.i;
            if (th2 != null) {
                queue.clear();
                try {
                    sm5Var.onError(th2);
                    return true;
                } finally {
                }
            }
            if (!z2) {
                return false;
            }
            try {
                sm5Var.onCompleted();
                return true;
            } finally {
            }
        }

        public void b() {
            sm5<? super T> sm5Var = this.f17241a;
            sm5Var.setProducer(new C1187a());
            sm5Var.add(this.b);
            sm5Var.add(this);
        }

        public void c() {
            if (this.h.getAndIncrement() == 0) {
                this.b.a(this);
            }
        }

        @Override // defpackage.b5
        public void call() {
            long j = this.j;
            Queue<Object> queue = this.d;
            sm5<? super T> sm5Var = this.f17241a;
            long jAddAndGet = 1;
            do {
                long jC = this.g.get();
                while (jC != j) {
                    boolean z = this.f;
                    Object objPoll = queue.poll();
                    boolean z2 = objPoll == null;
                    if (a(z, z2, sm5Var, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    sm5Var.onNext((Object) z24.d(objPoll));
                    j++;
                    if (j == this.e) {
                        jC = so.c(this.g, j);
                        request(j);
                        j = 0;
                    }
                }
                if (jC == j && a(this.f, queue.isEmpty(), sm5Var, queue)) {
                    return;
                }
                this.j = j;
                jAddAndGet = this.h.addAndGet(-jAddAndGet);
            } while (jAddAndGet != 0);
        }

        @Override // defpackage.o54
        public void onCompleted() {
            if (isUnsubscribed() || this.f) {
                return;
            }
            this.f = true;
            c();
        }

        @Override // defpackage.o54
        public void onError(Throwable th) {
            if (isUnsubscribed() || this.f) {
                kz4.g(th);
                return;
            }
            this.i = th;
            this.f = true;
            c();
        }

        @Override // defpackage.o54
        public void onNext(T t) {
            if (isUnsubscribed() || this.f) {
                return;
            }
            if (this.d.offer(z24.g(t))) {
                c();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public e94(x25 x25Var, boolean z, int i) {
        this.f17240a = x25Var;
        this.b = z;
        this.c = i <= 0 ? rz4.f20629a : i;
    }

    @Override // defpackage.s42
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public sm5<? super T> call(sm5<? super T> sm5Var) {
        a aVar = new a(this.f17240a, sm5Var, this.b, this.c);
        aVar.b();
        return aVar;
    }
}
