package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class ju implements zm5 {
    public static final b5 b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<b5> f18498a;

    public ju() {
        this.f18498a = new AtomicReference<>();
    }

    public static ju a() {
        return new ju();
    }

    public static ju b(b5 b5Var) {
        return new ju(b5Var);
    }

    @Override // defpackage.zm5
    public boolean isUnsubscribed() {
        return this.f18498a.get() == b;
    }

    @Override // defpackage.zm5
    public void unsubscribe() {
        b5 andSet;
        b5 b5Var = this.f18498a.get();
        b5 b5Var2 = b;
        if (b5Var == b5Var2 || (andSet = this.f18498a.getAndSet(b5Var2)) == null || andSet == b5Var2) {
            return;
        }
        andSet.call();
    }

    public ju(b5 b5Var) {
        this.f18498a = new AtomicReference<>(b5Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements b5 {
        @Override // defpackage.b5
        public void call() {
        }
    }
}
