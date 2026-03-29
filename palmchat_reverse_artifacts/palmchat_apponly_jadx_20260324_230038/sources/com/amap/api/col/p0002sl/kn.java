package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class kn extends kk {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public kn() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0002sl.kk
    /* JADX INFO: renamed from: a */
    public final kk clone() {
        kn knVar = new kn(this.h);
        knVar.a(this);
        knVar.j = this.j;
        knVar.k = this.k;
        knVar.l = this.l;
        knVar.m = this.m;
        knVar.n = this.n;
        return knVar;
    }

    @Override // com.amap.api.col.p0002sl.kk
    public final String toString() {
        return "AmapCellLte{tac=" + this.j + ", ci=" + this.k + ", pci=" + this.l + ", earfcn=" + this.m + ", timingAdvance=" + this.n + ", mcc='" + this.f2944a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }

    public kn(boolean z) {
        super(z, true);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }
}
