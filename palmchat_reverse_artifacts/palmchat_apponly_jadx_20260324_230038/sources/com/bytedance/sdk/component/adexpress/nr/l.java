package com.bytedance.sdk.component.adexpress.nr;

import com.bytedance.sdk.component.adexpress.nr.jk;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l implements jk.u {
    private AtomicBoolean b = new AtomicBoolean(false);
    private a fx;
    private List<jk> nr;
    k u;

    public l(List<jk> list, a aVar) {
        this.nr = list;
        this.fx = aVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk.u
    public boolean fx() {
        return this.b.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk.u
    public boolean nr(jk jkVar) {
        int iIndexOf = this.nr.indexOf(jkVar);
        return iIndexOf < this.nr.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk.u
    public void u() {
        this.fx.iz();
        Iterator<jk> it = this.nr.iterator();
        while (it.hasNext() && !it.next().u(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk.u
    public k nr() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk.u
    public void u(jk jkVar) {
        int iIndexOf = this.nr.indexOf(jkVar);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.nr.size()) {
                return;
            }
        } while (!this.nr.get(iIndexOf).u(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk.u
    public void u(k kVar) {
        this.u = kVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.jk.u
    public void u(boolean z) {
        this.b.getAndSet(z);
    }
}
