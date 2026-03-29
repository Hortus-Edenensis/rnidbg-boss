package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class kl extends kk {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public kl() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    @Override // com.amap.api.col.p0002sl.kk
    /* JADX INFO: renamed from: a */
    public final kk clone() {
        kl klVar = new kl(this.h, this.i);
        klVar.a(this);
        klVar.j = this.j;
        klVar.k = this.k;
        klVar.l = this.l;
        klVar.m = this.m;
        klVar.n = this.n;
        return klVar;
    }

    @Override // com.amap.api.col.p0002sl.kk
    public final String toString() {
        return "AmapCellCdma{sid=" + this.j + ", nid=" + this.k + ", bid=" + this.l + ", latitude=" + this.m + ", longitude=" + this.n + ", mcc='" + this.f2944a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }

    public kl(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }
}
