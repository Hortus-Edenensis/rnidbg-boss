package defpackage;

import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.internal.util.InternalObservableUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class n54<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<T> f19442a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a<T> extends c5<sm5<? super T>> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b<R, T> extends s42<sm5<? super R>, sm5<? super T>> {
    }

    public n54(a<T> aVar) {
        this.f19442a = aVar;
    }

    public static <T> n54<T> a(a<T> aVar) {
        return new n54<>(kz4.e(aVar));
    }

    public static <T> n54<T> b(r42<n54<T>> r42Var) {
        return a(new m74(r42Var));
    }

    public static <T> n54<T> e(Throwable th) {
        return a(new q74(th));
    }

    public static <T> n54<T> f(T t) {
        return j25.y(t);
    }

    public static <T> zm5 t(sm5<? super T> sm5Var, n54<T> n54Var) {
        if (sm5Var == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (n54Var.f19442a == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        sm5Var.onStart();
        if (!(sm5Var instanceof y15)) {
            sm5Var = new y15(sm5Var);
        }
        try {
            kz4.l(n54Var, n54Var.f19442a).call(sm5Var);
            return kz4.k(sm5Var);
        } catch (Throwable th) {
            yn1.d(th);
            if (sm5Var.isUnsubscribed()) {
                kz4.g(kz4.i(th));
            } else {
                try {
                    sm5Var.onError(kz4.i(th));
                } catch (Throwable th2) {
                    yn1.d(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    kz4.i(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
            return cn5.c();
        }
    }

    public static n54<Long> v(long j, TimeUnit timeUnit) {
        return w(j, timeUnit, b35.a());
    }

    public static n54<Long> w(long j, TimeUnit timeUnit, x25 x25Var) {
        return a(new r74(j, timeUnit, x25Var));
    }

    public final n54<T> c(b5 b5Var) {
        return (n54<T>) g(new d94(b5Var));
    }

    public final n54<T> d(b5 b5Var) {
        return a(new n74(this, new g5(j5.a(), j5.b(b5Var), b5Var)));
    }

    public final <R> n54<R> g(b<? extends R, ? super T> bVar) {
        return a(new o74(this.f19442a, bVar));
    }

    public final <R> n54<R> h(s42<? super T, ? extends R> s42Var) {
        return a(new p74(this, s42Var));
    }

    public final n54<T> i(x25 x25Var) {
        return j(x25Var, rz4.f20629a);
    }

    public final n54<T> j(x25 x25Var, int i) {
        return k(x25Var, false, i);
    }

    public final n54<T> k(x25 x25Var, boolean z, int i) {
        return this instanceof j25 ? ((j25) this).A(x25Var) : (n54<T>) g(new e94(x25Var, z, i));
    }

    public final im0<T> l() {
        return f94.z(this);
    }

    public final im0<T> m(int i) {
        return f94.A(this, i);
    }

    public final im0<T> n(int i, long j, TimeUnit timeUnit, x25 x25Var) {
        if (i >= 0) {
            return f94.C(this, j, timeUnit, x25Var, i);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final im0<T> o(long j, TimeUnit timeUnit, x25 x25Var) {
        return f94.B(this, j, timeUnit, x25Var);
    }

    public final zm5 p() {
        return s(new i5(j5.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, j5.a()));
    }

    public final zm5 q(c5<? super T> c5Var, c5<Throwable> c5Var2) {
        if (c5Var == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (c5Var2 != null) {
            return s(new i5(c5Var, c5Var2, j5.a()));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final zm5 r(o54<? super T> o54Var) {
        if (o54Var instanceof sm5) {
            return s((sm5) o54Var);
        }
        if (o54Var != null) {
            return s(new p54(o54Var));
        }
        throw new NullPointerException("observer is null");
    }

    public final zm5 s(sm5<? super T> sm5Var) {
        return t(sm5Var, this);
    }

    public final n54<T> u(x25 x25Var) {
        return this instanceof j25 ? ((j25) this).A(x25Var) : a(new g94(this, x25Var));
    }

    public final zm5 x(sm5<? super T> sm5Var) {
        try {
            sm5Var.onStart();
            kz4.l(this, this.f19442a).call(sm5Var);
            return kz4.k(sm5Var);
        } catch (Throwable th) {
            yn1.d(th);
            try {
                sm5Var.onError(kz4.i(th));
                return cn5.c();
            } catch (Throwable th2) {
                yn1.d(th2);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                kz4.i(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }
}
