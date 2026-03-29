package com.bytedance.sdk.component.iz.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements a {
    private com.bytedance.sdk.component.iz.x nr;
    private byte[] u;

    public nr(byte[] bArr, com.bytedance.sdk.component.iz.x xVar) {
        this.u = bArr;
        this.nr = xVar;
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "image_type";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        a pnVar;
        int iPn = fxVar.pn();
        fxVar.u(this.u.length);
        if (iPn == 2) {
            pnVar = com.bytedance.sdk.component.iz.fx.fx.u.u(this.u) ? new pn(this.u, this.nr) : this.nr == null ? new t() : new n(1001, "not image format", null);
        } else if (iPn != 3) {
            boolean zNr = com.bytedance.sdk.component.iz.fx.fx.u.nr(this.u);
            if (zNr) {
                byte[] bArr = this.u;
                pnVar = new mv(bArr, bArr, this.nr, zNr);
            } else if (com.bytedance.sdk.component.iz.fx.fx.u.u(this.u)) {
                pnVar = new pn(this.u, this.nr);
            } else {
                byte[] bArr2 = this.u;
                pnVar = new mv(bArr2, bArr2, this.nr, zNr);
            }
        } else {
            byte[] bArr3 = this.u;
            pnVar = new mv(bArr3, bArr3, this.nr, com.bytedance.sdk.component.iz.fx.fx.u.nr(bArr3));
        }
        fxVar.u(pnVar);
    }
}
