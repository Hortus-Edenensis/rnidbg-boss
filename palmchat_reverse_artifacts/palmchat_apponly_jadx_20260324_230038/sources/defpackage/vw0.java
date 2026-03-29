package defpackage;

import androidx.annotation.Nullable;
import defpackage.w9;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class vw0 implements w9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21541a;
    public final int b;

    @Nullable
    public final byte[] c;
    public int d;
    public int e;
    public int f;
    public v9[] g;

    public vw0(boolean z, int i) {
        this(z, i, 0);
    }

    @Override // defpackage.w9
    public synchronized void a(v9 v9Var) {
        v9[] v9VarArr = this.g;
        int i = this.f;
        this.f = i + 1;
        v9VarArr[i] = v9Var;
        this.e--;
        notifyAll();
    }

    @Override // defpackage.w9
    public synchronized v9 allocate() {
        v9 v9Var;
        this.e++;
        int i = this.f;
        if (i > 0) {
            v9[] v9VarArr = this.g;
            int i2 = i - 1;
            this.f = i2;
            v9Var = (v9) vh.e(v9VarArr[i2]);
            this.g[this.f] = null;
        } else {
            v9Var = new v9(new byte[this.b], 0);
            int i3 = this.e;
            v9[] v9VarArr2 = this.g;
            if (i3 > v9VarArr2.length) {
                this.g = (v9[]) Arrays.copyOf(v9VarArr2, v9VarArr2.length * 2);
            }
        }
        return v9Var;
    }

    @Override // defpackage.w9
    public synchronized void b(@Nullable w9.a aVar) {
        while (aVar != null) {
            v9[] v9VarArr = this.g;
            int i = this.f;
            this.f = i + 1;
            v9VarArr[i] = aVar.getAllocation();
            this.e--;
            aVar = aVar.next();
        }
        notifyAll();
    }

    public synchronized int c() {
        return this.e * this.b;
    }

    public synchronized void d() {
        if (this.f21541a) {
            e(0);
        }
    }

    public synchronized void e(int i) {
        boolean z = i < this.d;
        this.d = i;
        if (z) {
            trim();
        }
    }

    @Override // defpackage.w9
    public int getIndividualAllocationLength() {
        return this.b;
    }

    @Override // defpackage.w9
    public synchronized void trim() {
        int i = 0;
        int iMax = Math.max(0, g86.l(this.d, this.b) - this.e);
        int i2 = this.f;
        if (iMax >= i2) {
            return;
        }
        if (this.c != null) {
            int i3 = i2 - 1;
            while (i <= i3) {
                v9 v9Var = (v9) vh.e(this.g[i]);
                if (v9Var.f21383a == this.c) {
                    i++;
                } else {
                    v9 v9Var2 = (v9) vh.e(this.g[i3]);
                    if (v9Var2.f21383a != this.c) {
                        i3--;
                    } else {
                        v9[] v9VarArr = this.g;
                        v9VarArr[i] = v9Var2;
                        v9VarArr[i3] = v9Var;
                        i3--;
                        i++;
                    }
                }
            }
            iMax = Math.max(iMax, i);
            if (iMax >= this.f) {
                return;
            }
        }
        Arrays.fill(this.g, iMax, this.f, (Object) null);
        this.f = iMax;
    }

    public vw0(boolean z, int i, int i2) {
        vh.a(i > 0);
        vh.a(i2 >= 0);
        this.f21541a = z;
        this.b = i;
        this.f = i2;
        this.g = new v9[i2 + 100];
        if (i2 <= 0) {
            this.c = null;
            return;
        }
        this.c = new byte[i2 * i];
        for (int i3 = 0; i3 < i2; i3++) {
            this.g[i3] = new v9(this.c, i3 * i);
        }
    }
}
