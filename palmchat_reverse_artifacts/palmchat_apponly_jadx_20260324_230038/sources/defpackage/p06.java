package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class p06 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19911a;
    public final tv4[] b;
    public final or1[] c;
    public final f0 d;

    @Nullable
    public final Object e;

    public p06(tv4[] tv4VarArr, or1[] or1VarArr, f0 f0Var, @Nullable Object obj) {
        this.b = tv4VarArr;
        this.c = (or1[]) or1VarArr.clone();
        this.d = f0Var;
        this.e = obj;
        this.f19911a = tv4VarArr.length;
    }

    public boolean a(@Nullable p06 p06Var) {
        if (p06Var == null || p06Var.c.length != this.c.length) {
            return false;
        }
        for (int i = 0; i < this.c.length; i++) {
            if (!b(p06Var, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(@Nullable p06 p06Var, int i) {
        return p06Var != null && g86.c(this.b[i], p06Var.b[i]) && g86.c(this.c[i], p06Var.c[i]);
    }

    public boolean c(int i) {
        return this.b[i] != null;
    }
}
