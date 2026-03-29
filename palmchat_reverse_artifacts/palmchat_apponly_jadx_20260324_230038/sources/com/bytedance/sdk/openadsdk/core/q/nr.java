package com.bytedance.sdk.openadsdk.core.q;

import com.bytedance.sdk.openadsdk.core.q.u;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr<T, F extends u> {
    protected F fx;
    protected T nr;
    protected final List<pn<?>> u = new CopyOnWriteArrayList();

    public final F getContext() {
        return this.fx;
    }

    public final void nr(pn<?> pnVar) {
        if (pnVar != null) {
            this.u.remove(pnVar);
        }
    }

    public final void u(pn<?> pnVar) {
        if (pnVar != null) {
            this.u.add(pnVar);
        }
    }
}
