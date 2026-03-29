package com.bytedance.sdk.openadsdk.core.qq;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class l implements com.bytedance.sdk.component.n.u.u.iz {
    com.bytedance.sdk.component.a.nr.pn u;

    public l(com.bytedance.sdk.component.a.nr.pn pnVar) {
        this.u = pnVar;
    }

    @Override // com.bytedance.sdk.component.n.u.u.iz
    public void nr(String str) {
        com.bytedance.sdk.component.a.nr.pn pnVar = this.u;
        if (pnVar != null) {
            pnVar.fx(str);
        }
    }

    @Override // com.bytedance.sdk.component.n.u.u.iz
    public void u(String str) {
        com.bytedance.sdk.component.a.nr.pn pnVar = this.u;
        if (pnVar != null) {
            pnVar.u(str);
        }
    }

    @Override // com.bytedance.sdk.component.n.u.u.iz
    public void u(String str, byte[] bArr) {
        com.bytedance.sdk.component.a.nr.pn pnVar = this.u;
        if (pnVar != null) {
            pnVar.u(str, bArr);
        }
    }

    @Override // com.bytedance.sdk.component.n.u.u.iz
    public void u(String str, String str2) {
        com.bytedance.sdk.component.a.nr.pn pnVar = this.u;
        if (pnVar != null) {
            pnVar.nr(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.n.u.u.iz
    public com.bytedance.sdk.component.n.u.u.pn u() {
        com.bytedance.sdk.component.a.nr.pn pnVar = this.u;
        if (pnVar == null) {
            return null;
        }
        return new t(pnVar.u());
    }

    @Override // com.bytedance.sdk.component.n.u.u.iz
    public void u(final com.bytedance.sdk.component.n.u.u.fx fxVar) {
        com.bytedance.sdk.component.a.nr.pn pnVar = this.u;
        if (pnVar != null) {
            pnVar.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.qq.l.1
                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                    if (fxVar != null) {
                        fxVar.u(new iz(bVar), new x(nrVar));
                    }
                }

                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                    if (fxVar != null) {
                        fxVar.u(new iz(bVar), iOException);
                    }
                }
            });
        }
    }
}
