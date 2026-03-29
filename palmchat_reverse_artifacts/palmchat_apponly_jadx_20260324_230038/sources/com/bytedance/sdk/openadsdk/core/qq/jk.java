package com.bytedance.sdk.openadsdk.core.qq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class jk implements com.bytedance.sdk.component.n.u.u.nr {
    com.bytedance.sdk.component.a.nr.fx u;

    public jk(com.bytedance.sdk.component.a.nr.fx fxVar) {
        this.u = fxVar;
    }

    @Override // com.bytedance.sdk.component.n.u.u.nr
    public void u(String str) {
        com.bytedance.sdk.component.a.nr.fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(str);
        }
    }

    @Override // com.bytedance.sdk.component.n.u.u.nr
    public void u(String str, String str2) {
        com.bytedance.sdk.component.a.nr.fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.nr(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.n.u.u.nr
    public com.bytedance.sdk.component.n.u.u.pn u() {
        com.bytedance.sdk.component.a.nr.fx fxVar = this.u;
        if (fxVar == null) {
            return null;
        }
        return new t(fxVar.u());
    }
}
