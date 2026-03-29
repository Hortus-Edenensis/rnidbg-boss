package com.bytedance.sdk.component.nr.u.u.u;

import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.bytedance.sdk.component.nr.u.nr {
    com.bytedance.sdk.component.fx.nr.pn u;

    public b(com.bytedance.sdk.component.fx.nr.pn pnVar) {
        this.u = pnVar;
    }

    @Override // com.bytedance.sdk.component.nr.u.nr
    public boolean b() {
        return this.u.b();
    }

    @Override // com.bytedance.sdk.component.nr.u.nr
    public void fx() {
        this.u.fx();
    }

    @Override // com.bytedance.sdk.component.nr.u.nr
    public my nr() throws IOException {
        return new a(this.u.nr());
    }

    /* JADX INFO: renamed from: pn, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.nr.u.nr clone() {
        return new b(this.u.pn());
    }

    @Override // com.bytedance.sdk.component.nr.u.nr
    public s u() {
        return new n(this.u.u());
    }

    @Override // com.bytedance.sdk.component.nr.u.nr
    public void u(final com.bytedance.sdk.component.nr.u.fx fxVar) {
        this.u.u(new com.bytedance.sdk.component.fx.nr.iz() { // from class: com.bytedance.sdk.component.nr.u.u.u.b.1
            @Override // com.bytedance.sdk.component.fx.nr.iz
            public void u(com.bytedance.sdk.component.fx.nr.pn pnVar, IOException iOException) {
                fxVar.onFailure(new b(pnVar), iOException);
            }

            @Override // com.bytedance.sdk.component.fx.nr.iz
            public void u(com.bytedance.sdk.component.fx.nr.pn pnVar, h hVar) throws IOException {
                fxVar.onResponse(new b(pnVar), new a(hVar));
            }
        });
    }
}
