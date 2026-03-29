package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class m12<V> extends k12<V> implements r33<V> {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a<V> extends m12<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r33<V> f19122a;

        public a(r33<V> r33Var) {
            this.f19122a = (r33) dm4.o(r33Var);
        }

        @Override // defpackage.p12
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final r33<V> delegate() {
            return this.f19122a;
        }
    }

    @Override // defpackage.r33
    public void addListener(Runnable runnable, Executor executor) {
        b().addListener(runnable, executor);
    }

    /* JADX INFO: renamed from: o */
    public abstract r33<? extends V> b();
}
