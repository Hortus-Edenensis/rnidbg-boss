package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ko extends kk {
    public int j;
    public int k;
    public int l;
    public int m;

    public ko() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0002sl.kk
    /* JADX INFO: renamed from: a */
    public final kk clone() {
        ko koVar = new ko(this.h, this.i);
        koVar.a(this);
        koVar.j = this.j;
        koVar.k = this.k;
        koVar.l = this.l;
        koVar.m = this.m;
        return koVar;
    }

    @Override // com.amap.api.col.p0002sl.kk
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", uarfcn=" + this.m + ", mcc='" + this.f2944a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }

    public ko(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }
}
