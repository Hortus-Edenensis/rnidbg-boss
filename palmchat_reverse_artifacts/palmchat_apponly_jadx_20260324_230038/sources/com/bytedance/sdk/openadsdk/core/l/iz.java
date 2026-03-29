package com.bytedance.sdk.openadsdk.core.l;

import com.bytedance.sdk.openadsdk.core.dw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements b {
    private fx nr;
    private List<b> u = new ArrayList();

    public iz() {
        fx fxVar = new fx(dw.nr().dj());
        this.nr = fxVar;
        this.u.add(new pn(fxVar));
        this.u.add(new x(this.nr));
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b
    public boolean nr(com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar) {
        Iterator<b> it = this.u.iterator();
        while (it.hasNext()) {
            if (it.next().nr(uVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b
    public boolean u(com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar) {
        Iterator<b> it = this.u.iterator();
        while (it.hasNext()) {
            if (it.next().u(uVar)) {
                return true;
            }
        }
        return false;
    }
}
