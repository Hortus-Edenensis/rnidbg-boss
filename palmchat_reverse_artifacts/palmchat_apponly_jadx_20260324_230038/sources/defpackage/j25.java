package defpackage;

import com.huawei.hms.ads.ex;
import defpackage.n54;
import defpackage.x25;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class j25<T> extends n54<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", ex.V)).booleanValue();
    public final T b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements s42<b5, zm5> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ nn1 f18306a;

        public a(nn1 nn1Var) {
            this.f18306a = nn1Var;
        }

        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public zm5 call(b5 b5Var) {
            return this.f18306a.c(b5Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements s42<b5, zm5> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x25 f18307a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements b5 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b5 f18308a;
            public final /* synthetic */ x25.a b;

            public a(b5 b5Var, x25.a aVar) {
                this.f18308a = b5Var;
                this.b = aVar;
            }

            @Override // defpackage.b5
            public void call() {
                try {
                    this.f18308a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(x25 x25Var) {
            this.f18307a = x25Var;
        }

        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public zm5 call(b5 b5Var) {
            x25.a aVarA = this.f18307a.a();
            aVarA.a(new a(b5Var, aVarA));
            return aVarA;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<T> implements n54.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f18309a;

        public c(T t) {
            this.f18309a = t;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(sm5<? super T> sm5Var) {
            sm5Var.setProducer(j25.z(sm5Var, this.f18309a));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d<T> implements n54.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f18310a;
        public final s42<b5, zm5> b;

        public d(T t, s42<b5, zm5> s42Var) {
            this.f18310a = t;
            this.b = s42Var;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(sm5<? super T> sm5Var) {
            sm5Var.setProducer(new e(sm5Var, this.f18310a, this.b));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e<T> extends AtomicBoolean implements kn4, b5 {
        private static final long serialVersionUID = -2466317989629281651L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sm5<? super T> f18311a;
        public final T b;
        public final s42<b5, zm5> c;

        public e(sm5<? super T> sm5Var, T t, s42<b5, zm5> s42Var) {
            this.f18311a = sm5Var;
            this.b = t;
            this.c = s42Var;
        }

        @Override // defpackage.b5
        public void call() {
            sm5<? super T> sm5Var = this.f18311a;
            if (sm5Var.isUnsubscribed()) {
                return;
            }
            T t = this.b;
            try {
                sm5Var.onNext(t);
                if (sm5Var.isUnsubscribed()) {
                    return;
                }
                sm5Var.onCompleted();
            } catch (Throwable th) {
                yn1.f(th, sm5Var, t);
            }
        }

        @Override // defpackage.kn4
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            if (j == 0 || !compareAndSet(false, true)) {
                return;
            }
            this.f18311a.add(this.c.call(this));
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.b + ", " + get() + "]";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f<T> implements kn4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sm5<? super T> f18312a;
        public final T b;
        public boolean c;

        public f(sm5<? super T> sm5Var, T t) {
            this.f18312a = sm5Var;
            this.b = t;
        }

        @Override // defpackage.kn4
        public void request(long j) {
            if (this.c) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException("n >= required but it was " + j);
            }
            if (j == 0) {
                return;
            }
            this.c = true;
            sm5<? super T> sm5Var = this.f18312a;
            if (sm5Var.isUnsubscribed()) {
                return;
            }
            T t = this.b;
            try {
                sm5Var.onNext(t);
                if (sm5Var.isUnsubscribed()) {
                    return;
                }
                sm5Var.onCompleted();
            } catch (Throwable th) {
                yn1.f(th, sm5Var, t);
            }
        }
    }

    public j25(T t) {
        super(kz4.e(new c(t)));
        this.b = t;
    }

    public static <T> j25<T> y(T t) {
        return new j25<>(t);
    }

    public static <T> kn4 z(sm5<? super T> sm5Var, T t) {
        return c ? new SingleProducer(sm5Var, t) : new f(sm5Var, t);
    }

    public n54<T> A(x25 x25Var) {
        return n54.a(new d(this.b, x25Var instanceof nn1 ? new a((nn1) x25Var) : new b(x25Var)));
    }
}
