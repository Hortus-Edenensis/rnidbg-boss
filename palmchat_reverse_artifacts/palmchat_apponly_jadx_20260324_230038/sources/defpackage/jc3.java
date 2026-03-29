package defpackage;

import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface jc3 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements jc3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Looper f18380a;

        public a(Looper looper) {
            this.f18380a = looper;
        }

        @Override // defpackage.jc3
        public boolean a() {
            return this.f18380a == Looper.myLooper();
        }

        @Override // defpackage.jc3
        public wk4 b(an1 an1Var) {
            return new kg2(an1Var, this.f18380a, 10);
        }
    }

    boolean a();

    wk4 b(an1 an1Var);
}
