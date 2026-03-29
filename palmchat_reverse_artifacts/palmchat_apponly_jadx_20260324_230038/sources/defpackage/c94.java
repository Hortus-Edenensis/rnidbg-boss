package defpackage;

import defpackage.n54;
import rx.internal.producers.SingleDelayedProducer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class c94<T> implements n54.b<Boolean, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s42<? super T, Boolean> f1927a;
    public final boolean b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends sm5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1928a;
        public boolean b;
        public final /* synthetic */ SingleDelayedProducer c;
        public final /* synthetic */ sm5 d;

        public a(SingleDelayedProducer singleDelayedProducer, sm5 sm5Var) {
            this.c = singleDelayedProducer;
            this.d = sm5Var;
        }

        @Override // defpackage.o54
        public void onCompleted() {
            if (this.b) {
                return;
            }
            this.b = true;
            if (this.f1928a) {
                this.c.setValue(Boolean.FALSE);
            } else {
                this.c.setValue(Boolean.valueOf(c94.this.b));
            }
        }

        @Override // defpackage.o54
        public void onError(Throwable th) {
            if (this.b) {
                kz4.g(th);
            } else {
                this.b = true;
                this.d.onError(th);
            }
        }

        @Override // defpackage.o54
        public void onNext(T t) {
            if (this.b) {
                return;
            }
            this.f1928a = true;
            try {
                if (c94.this.f1927a.call(t).booleanValue()) {
                    this.b = true;
                    this.c.setValue(Boolean.valueOf(true ^ c94.this.b));
                    unsubscribe();
                }
            } catch (Throwable th) {
                yn1.f(th, this, t);
            }
        }
    }

    public c94(s42<? super T, Boolean> s42Var, boolean z) {
        this.f1927a = s42Var;
        this.b = z;
    }

    @Override // defpackage.s42
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public sm5<? super T> call(sm5<? super Boolean> sm5Var) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(sm5Var);
        a aVar = new a(singleDelayedProducer, sm5Var);
        sm5Var.add(aVar);
        sm5Var.setProducer(singleDelayedProducer);
        return aVar;
    }
}
