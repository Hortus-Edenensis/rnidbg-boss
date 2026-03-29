package com.bytedance.adsdk.nr.nr.nr.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class o implements com.bytedance.adsdk.nr.nr.nr.u {
    protected com.bytedance.adsdk.nr.nr.b.fx fx;
    protected com.bytedance.adsdk.nr.nr.nr.u nr;
    protected com.bytedance.adsdk.nr.nr.nr.u u;

    public o(com.bytedance.adsdk.nr.nr.b.fx fxVar) {
        this.fx = fxVar;
    }

    public void nr(com.bytedance.adsdk.nr.nr.nr.u uVar) {
        this.nr = uVar;
    }

    public String toString() {
        return nr();
    }

    public void u(com.bytedance.adsdk.nr.nr.nr.u uVar) {
        this.u = uVar;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public String nr() {
        return this.u.nr() + this.fx.u() + this.nr.nr();
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public com.bytedance.adsdk.nr.nr.b.pn u() {
        return com.bytedance.adsdk.nr.nr.b.iz.OPERATOR_RESULT;
    }
}
