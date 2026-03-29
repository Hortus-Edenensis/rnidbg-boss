package com.bytedance.sdk.component.nr.u.u.nr;

import com.bytedance.sdk.component.nr.u.a;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements a.u {
    int fx = 0;
    s nr;
    List<a> u;

    public nr(List<a> list, s sVar) {
        this.u = list;
        this.nr = sVar;
    }

    @Override // com.bytedance.sdk.component.nr.u.a.u
    public s u() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.nr.u.a.u
    public my u(s sVar) throws IOException {
        this.nr = sVar;
        int i = this.fx + 1;
        this.fx = i;
        return this.u.get(i).u(this);
    }
}
