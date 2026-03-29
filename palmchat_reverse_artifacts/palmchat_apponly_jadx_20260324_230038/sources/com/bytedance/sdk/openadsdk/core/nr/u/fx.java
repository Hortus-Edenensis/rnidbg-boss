package com.bytedance.sdk.openadsdk.core.nr.u;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private View b;
    private jk fx;
    private volatile int pn;
    private final com.bytedance.sdk.openadsdk.core.nr.b x;
    private List<u> u = new ArrayList();
    private Map<String, Object> nr = new HashMap();
    private volatile int iz = 0;

    public fx(com.bytedance.sdk.openadsdk.core.nr.b bVar) {
        this.x = bVar;
    }

    private void nr() {
        this.pn = 0;
        this.iz = 0;
    }

    public void u(View view) {
        this.b = view;
    }

    public void u(u uVar) {
        this.u.add(uVar);
    }

    public void u(jk jkVar) {
        this.fx = jkVar;
        Iterator<u> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().u(this.fx);
        }
    }

    public void u() {
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.x.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(false);
        nr();
        u(0);
    }

    private void u(int i) {
        int size = this.u.size();
        while (i < size) {
            int i2 = i + 1;
            this.pn = i2;
            u uVar = this.u.get(i);
            uVar.u(this.b);
            this.iz = uVar.u(this.nr, this);
            if (this.iz != 0) {
                if (this.iz == 2) {
                    ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.x.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(this.nr, this);
                    return;
                }
                return;
            }
            i = i2;
        }
    }

    public <T extends u> T u(Class<T> cls) {
        return (T) this.x.u(cls);
    }
}
