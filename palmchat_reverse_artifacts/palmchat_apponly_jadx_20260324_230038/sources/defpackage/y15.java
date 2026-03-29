package defpackage;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class y15<T> extends sm5<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sm5<? super T> f22096a;
    public boolean b;

    public y15(sm5<? super T> sm5Var) {
        super(sm5Var);
        this.f22096a = sm5Var;
    }

    public void a(Throwable th) {
        nz4.c().b().a(th);
        try {
            this.f22096a.onError(th);
            try {
                unsubscribe();
            } catch (Throwable th2) {
                kz4.g(th2);
                throw new OnErrorFailedException(th2);
            }
        } catch (OnErrorNotImplementedException e) {
            try {
                unsubscribe();
                throw e;
            } catch (Throwable th3) {
                kz4.g(th3);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            kz4.g(th4);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                kz4.g(th5);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th5)));
            }
        }
    }

    @Override // defpackage.o54
    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (this.b) {
            return;
        }
        this.b = true;
        try {
            this.f22096a.onCompleted();
            try {
                unsubscribe();
            } finally {
            }
        } catch (Throwable th) {
            try {
                yn1.d(th);
                kz4.g(th);
                throw new OnCompletedFailedException(th.getMessage(), th);
            } catch (Throwable th2) {
                try {
                    unsubscribe();
                    throw th2;
                } finally {
                }
            }
        }
    }

    @Override // defpackage.o54
    public void onError(Throwable th) {
        yn1.d(th);
        if (this.b) {
            return;
        }
        this.b = true;
        a(th);
    }

    @Override // defpackage.o54
    public void onNext(T t) {
        try {
            if (this.b) {
                return;
            }
            this.f22096a.onNext(t);
        } catch (Throwable th) {
            yn1.e(th, this);
        }
    }
}
