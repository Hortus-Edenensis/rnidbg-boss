package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class km extends kk {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public km() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0002sl.kk
    /* JADX INFO: renamed from: a */
    public final kk clone() {
        km kmVar = new km(this.h, this.i);
        kmVar.a(this);
        kmVar.j = this.j;
        kmVar.k = this.k;
        kmVar.l = this.l;
        kmVar.m = this.m;
        kmVar.n = this.n;
        kmVar.o = this.o;
        return kmVar;
    }

    @Override // com.amap.api.col.p0002sl.kk
    public final String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + ", mcc='" + this.f2944a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }

    public km(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }
}
