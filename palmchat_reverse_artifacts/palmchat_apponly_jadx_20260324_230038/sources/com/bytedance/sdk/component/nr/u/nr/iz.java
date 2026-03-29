package com.bytedance.sdk.component.nr.u.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class iz {
    boolean b;
    int fx;
    iz iz;
    int nr;
    boolean pn;
    final byte[] u;
    iz x;

    public iz() {
        this.u = new byte[8192];
        this.pn = true;
        this.b = false;
    }

    public final iz nr() {
        iz izVar = this.iz;
        iz izVar2 = izVar != this ? izVar : null;
        iz izVar3 = this.x;
        if (izVar3 != null) {
            izVar3.iz = izVar;
        }
        iz izVar4 = this.iz;
        if (izVar4 != null) {
            izVar4.x = izVar3;
        }
        this.iz = null;
        this.x = null;
        return izVar2;
    }

    public final iz u() {
        this.b = true;
        return new iz(this.u, this.nr, this.fx, true, false);
    }

    public final iz u(iz izVar) {
        izVar.x = this;
        izVar.iz = this.iz;
        this.iz.x = izVar;
        this.iz = izVar;
        return izVar;
    }

    public iz(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.u = bArr;
        this.nr = i;
        this.fx = i2;
        this.b = z;
        this.pn = z2;
    }
}
