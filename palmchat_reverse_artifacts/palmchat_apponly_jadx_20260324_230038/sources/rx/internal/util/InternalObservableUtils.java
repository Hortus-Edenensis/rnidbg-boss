package rx.internal.util;

import defpackage.c5;
import defpackage.c94;
import defpackage.d5;
import defpackage.im0;
import defpackage.l86;
import defpackage.n54;
import defpackage.r42;
import defpackage.s42;
import defpackage.t42;
import defpackage.x25;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public enum InternalObservableUtils {
    ;

    public static final h LONG_COUNTER = new t42<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        @Override // defpackage.t42
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new t42<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        @Override // defpackage.t42
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    };
    public static final q TO_ARRAY = new s42<List<? extends n54<?>>, n54<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n54<?>[] call(List<? extends n54<?>> list) {
            return (n54[]) list.toArray(new n54[list.size()]);
        }
    };
    static final o RETURNS_VOID = new o();
    public static final g COUNTER = new t42<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        @Override // defpackage.t42
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    static final e ERROR_EXTRACTOR = new e();
    public static final c5<Throwable> ERROR_NOT_IMPLEMENTED = new c5<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final n54.b<Boolean, Object> IS_EMPTY = new c94(l86.a(), true);

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<T, R> implements t42<R, T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d5<R, ? super T> f20608a;

        public a(d5<R, ? super T> d5Var) {
            this.f20608a = d5Var;
        }

        @Override // defpackage.t42
        public R a(R r, T t) {
            this.f20608a.a(r, t);
            return r;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements s42<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f20609a;

        public b(Object obj) {
            this.f20609a = obj;
        }

        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(Object obj) {
            Object obj2 = this.f20609a;
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d implements s42<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<?> f20610a;

        public d(Class<?> cls) {
            this.f20610a = cls;
        }

        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.f20610a.isInstance(obj));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e implements s42<Notification<?>, Throwable> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Throwable call(Notification<?> notification) {
            return notification.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i implements s42<n54<? extends Notification<?>>, n54<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s42<? super n54<? extends Void>, ? extends n54<?>> f20611a;

        public i(s42<? super n54<? extends Void>, ? extends n54<?>> s42Var) {
            this.f20611a = s42Var;
        }

        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n54<?> call(n54<? extends Notification<?>> n54Var) {
            return this.f20611a.call(n54Var.h(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class j<T> implements r42<im0<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n54<T> f20612a;
        public final int b;

        public j(n54<T> n54Var, int i) {
            this.f20612a = n54Var;
            this.b = i;
        }

        @Override // defpackage.r42, java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public im0<T> call() {
            return this.f20612a.m(this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class k<T> implements r42<im0<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TimeUnit f20613a;
        public final n54<T> b;
        public final long c;
        public final x25 d;

        public k(n54<T> n54Var, long j, TimeUnit timeUnit, x25 x25Var) {
            this.f20613a = timeUnit;
            this.b = n54Var;
            this.c = j;
            this.d = x25Var;
        }

        @Override // defpackage.r42, java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public im0<T> call() {
            return this.b.o(this.c, this.f20613a, this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class l<T> implements r42<im0<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n54<T> f20614a;

        public l(n54<T> n54Var) {
            this.f20614a = n54Var;
        }

        @Override // defpackage.r42, java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public im0<T> call() {
            return this.f20614a.l();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class m<T> implements r42<im0<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f20615a;
        public final TimeUnit b;
        public final x25 c;
        public final int d;
        public final n54<T> e;

        public m(n54<T> n54Var, int i, long j, TimeUnit timeUnit, x25 x25Var) {
            this.f20615a = j;
            this.b = timeUnit;
            this.c = x25Var;
            this.d = i;
            this.e = n54Var;
        }

        @Override // defpackage.r42, java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public im0<T> call() {
            return this.e.n(this.d, this.f20615a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class n implements s42<n54<? extends Notification<?>>, n54<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s42<? super n54<? extends Throwable>, ? extends n54<?>> f20616a;

        public n(s42<? super n54<? extends Throwable>, ? extends n54<?>> s42Var) {
            this.f20616a = s42Var;
        }

        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n54<?> call(n54<? extends Notification<?>> n54Var) {
            return this.f20616a.call(n54Var.h(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class o implements s42<Object, Void> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(Object obj) {
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class p<T, R> implements s42<n54<T>, n54<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s42<? super n54<T>, ? extends n54<R>> f20617a;
        public final x25 b;

        public p(s42<? super n54<T>, ? extends n54<R>> s42Var, x25 x25Var) {
            this.f20617a = s42Var;
            this.b = x25Var;
        }

        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n54<R> call(n54<T> n54Var) {
            return this.f20617a.call(n54Var).i(this.b);
        }
    }

    public static <T, R> t42<R, T, R> createCollectorCaller(d5<R, ? super T> d5Var) {
        return new a(d5Var);
    }

    public static s42<n54<? extends Notification<?>>, n54<?>> createRepeatDematerializer(s42<? super n54<? extends Void>, ? extends n54<?>> s42Var) {
        return new i(s42Var);
    }

    public static <T, R> s42<n54<T>, n54<R>> createReplaySelectorAndObserveOn(s42<? super n54<T>, ? extends n54<R>> s42Var, x25 x25Var) {
        return new p(s42Var, x25Var);
    }

    public static <T> r42<im0<T>> createReplaySupplier(n54<T> n54Var) {
        return new l(n54Var);
    }

    public static s42<n54<? extends Notification<?>>, n54<?>> createRetryDematerializer(s42<? super n54<? extends Throwable>, ? extends n54<?>> s42Var) {
        return new n(s42Var);
    }

    public static s42<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static s42<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> r42<im0<T>> createReplaySupplier(n54<T> n54Var, int i2) {
        return new j(n54Var, i2);
    }

    public static <T> r42<im0<T>> createReplaySupplier(n54<T> n54Var, long j2, TimeUnit timeUnit, x25 x25Var) {
        return new k(n54Var, j2, timeUnit, x25Var);
    }

    public static <T> r42<im0<T>> createReplaySupplier(n54<T> n54Var, int i2, long j2, TimeUnit timeUnit, x25 x25Var) {
        return new m(n54Var, i2, j2, timeUnit, x25Var);
    }
}
