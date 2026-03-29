package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class iq extends it {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f2915a;
    private boolean b;

    public iq() {
        this.f2915a = new StringBuilder();
        this.b = true;
    }

    @Override // com.amap.api.col.p0002sl.it
    public final byte[] a(byte[] bArr) {
        byte[] bArrA = ge.a(this.f2915a.toString());
        this.d = bArrA;
        this.b = true;
        StringBuilder sb = this.f2915a;
        sb.delete(0, sb.length());
        return bArrA;
    }

    @Override // com.amap.api.col.p0002sl.it
    public final void b(byte[] bArr) {
        String strA = ge.a(bArr);
        if (this.b) {
            this.b = false;
        } else {
            this.f2915a.append(",");
        }
        StringBuilder sb = this.f2915a;
        sb.append("{\"log\":\"");
        sb.append(strA);
        sb.append("\"}");
    }

    public iq(it itVar) {
        super(itVar);
        this.f2915a = new StringBuilder();
        this.b = true;
    }
}
