package defpackage;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class qx1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f20347a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseBooleanArray f20348a = new SparseBooleanArray();
        public boolean b;

        public b a(int i) {
            vh.g(!this.b);
            this.f20348a.append(i, true);
            return this;
        }

        public b b(qx1 qx1Var) {
            for (int i = 0; i < qx1Var.d(); i++) {
                a(qx1Var.c(i));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i : iArr) {
                a(i);
            }
            return this;
        }

        public b d(int i, boolean z) {
            return z ? a(i) : this;
        }

        public qx1 e() {
            vh.g(!this.b);
            this.b = true;
            return new qx1(this.f20348a);
        }
    }

    public boolean a(int i) {
        return this.f20347a.get(i);
    }

    public boolean b(int... iArr) {
        for (int i : iArr) {
            if (a(i)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i) {
        vh.c(i, 0, d());
        return this.f20347a.keyAt(i);
    }

    public int d() {
        return this.f20347a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qx1)) {
            return false;
        }
        qx1 qx1Var = (qx1) obj;
        if (g86.f17680a >= 24) {
            return this.f20347a.equals(qx1Var.f20347a);
        }
        if (d() != qx1Var.d()) {
            return false;
        }
        for (int i = 0; i < d(); i++) {
            if (c(i) != qx1Var.c(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (g86.f17680a >= 24) {
            return this.f20347a.hashCode();
        }
        int iD = d();
        for (int i = 0; i < d(); i++) {
            iD = (iD * 31) + c(i);
        }
        return iD;
    }

    public qx1(SparseBooleanArray sparseBooleanArray) {
        this.f20347a = sparseBooleanArray;
    }
}
