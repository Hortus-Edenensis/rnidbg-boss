package com.bytedance.sdk.component.nr.u.u.u;

import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.nr.u.a;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements a.u {
    bq.u u;

    public pn(bq.u uVar) {
        this.u = uVar;
    }

    @Override // com.bytedance.sdk.component.nr.u.a.u
    public s u() {
        return new n(this.u.u());
    }

    @Override // com.bytedance.sdk.component.nr.u.a.u
    public my u(s sVar) throws IOException {
        return new a(this.u.u(this.u.u().iz().u(sVar.nr().u()).u()));
    }
}
