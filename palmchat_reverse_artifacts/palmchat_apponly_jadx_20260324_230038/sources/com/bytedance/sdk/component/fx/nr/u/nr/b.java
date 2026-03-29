package com.bytedance.sdk.component.fx.nr.u.nr;

import com.bytedance.sdk.component.fx.nr.ja;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private final Set<ja> u = new LinkedHashSet();

    public synchronized boolean fx(ja jaVar) {
        return this.u.contains(jaVar);
    }

    public synchronized void nr(ja jaVar) {
        this.u.remove(jaVar);
    }

    public synchronized void u(ja jaVar) {
        this.u.add(jaVar);
    }
}
