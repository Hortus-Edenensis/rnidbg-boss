package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class ym5 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SearchBox */
    public static class a<T> extends sm5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sm5 f22232a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sm5 sm5Var, sm5 sm5Var2) {
            super(sm5Var);
            this.f22232a = sm5Var2;
        }

        @Override // defpackage.o54
        public void onCompleted() {
            this.f22232a.onCompleted();
        }

        @Override // defpackage.o54
        public void onError(Throwable th) {
            this.f22232a.onError(th);
        }

        @Override // defpackage.o54
        public void onNext(T t) {
            this.f22232a.onNext(t);
        }
    }

    public static <T> sm5<T> a(sm5<? super T> sm5Var) {
        return new a(sm5Var, sm5Var);
    }
}
