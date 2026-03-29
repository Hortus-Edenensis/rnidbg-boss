package com.bytedance.sdk.component.fx.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class k {
    boolean b;
    int fx;
    k iz;
    int nr;
    boolean pn;
    final byte[] u;
    k x;

    public k() {
        this.u = new byte[8192];
        this.pn = true;
        this.b = false;
    }

    public final void fx() {
        k kVar = this.x;
        if (kVar == this) {
            throw new IllegalStateException();
        }
        if (kVar.pn) {
            int i = this.fx - this.nr;
            if (i > (8192 - kVar.fx) + (kVar.b ? 0 : kVar.nr)) {
                return;
            }
            u(kVar, i);
            nr();
            my.u(this);
        }
    }

    public final k nr() {
        k kVar = this.iz;
        k kVar2 = kVar != this ? kVar : null;
        k kVar3 = this.x;
        if (kVar3 != null) {
            kVar3.iz = kVar;
        }
        k kVar4 = this.iz;
        if (kVar4 != null) {
            kVar4.x = kVar3;
        }
        this.iz = null;
        this.x = null;
        return kVar2;
    }

    public final k u() {
        this.b = true;
        return new k(this.u, this.nr, this.fx, true, false);
    }

    public final k u(k kVar) {
        kVar.x = this;
        kVar.iz = this.iz;
        this.iz.x = kVar;
        this.iz = kVar;
        return kVar;
    }

    public k(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.u = bArr;
        this.nr = i;
        this.fx = i2;
        this.b = z;
        this.pn = z2;
    }

    public final k u(int i) {
        k kVarU;
        if (i > 0 && i <= this.fx - this.nr) {
            if (i >= 1024) {
                kVarU = u();
            } else {
                kVarU = my.u();
                System.arraycopy(this.u, this.nr, kVarU.u, 0, i);
            }
            kVarU.fx = kVarU.nr + i;
            this.nr += i;
            this.x.u(kVarU);
            return kVarU;
        }
        throw new IllegalArgumentException();
    }

    public final void u(k kVar, int i) {
        if (kVar.pn) {
            int i2 = kVar.fx;
            if (i2 + i > 8192) {
                if (!kVar.b) {
                    int i3 = kVar.nr;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = kVar.u;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        kVar.fx -= kVar.nr;
                        kVar.nr = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.u, this.nr, kVar.u, kVar.fx, i);
            kVar.fx += i;
            this.nr += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
