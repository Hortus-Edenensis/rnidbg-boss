package defpackage;

import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class f96<K, A> extends sq<K, A> {
    public final A i;

    public f96(i93<A> i93Var) {
        this(i93Var, null);
    }

    @Override // defpackage.sq
    public float c() {
        return 1.0f;
    }

    @Override // defpackage.sq
    public A h() {
        i93<A> i93Var = this.e;
        A a2 = this.i;
        return i93Var.b(0.0f, 0.0f, a2, a2, f(), f(), f());
    }

    @Override // defpackage.sq
    public A i(h03<K> h03Var, float f) {
        return h();
    }

    @Override // defpackage.sq
    public void k() {
        if (this.e != null) {
            super.k();
        }
    }

    @Override // defpackage.sq
    public void m(float f) {
        this.d = f;
    }

    public f96(i93<A> i93Var, @Nullable A a2) {
        super(Collections.emptyList());
        n(i93Var);
        this.i = a2;
    }
}
