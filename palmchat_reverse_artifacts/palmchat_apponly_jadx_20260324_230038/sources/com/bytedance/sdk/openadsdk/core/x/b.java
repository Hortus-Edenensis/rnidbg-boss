package com.bytedance.sdk.openadsdk.core.x;

import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static b pn = new b();
    private volatile com.bytedance.sdk.component.u b;
    private int fx;
    private int nr;
    private bc u;

    private String fx() {
        bc bcVar = this.u;
        return bcVar != null ? com.bytedance.sdk.component.utils.u.u(bcVar.et()).toString() : "";
    }

    private boolean nr() {
        this.b = LogAdapter.u;
        return this.b != null;
    }

    public static b u() {
        return pn;
    }

    public b u(bc bcVar) {
        if (nr()) {
            this.u = bcVar;
        }
        return this;
    }

    public b nr(int i) {
        if (nr()) {
            this.fx = i;
        }
        return this;
    }

    public b u(int i) {
        if (nr()) {
            this.nr = i;
        }
        return this;
    }

    public void u(Thread thread, Throwable th) {
        String str;
        if (nr()) {
            if (thread != null) {
                str = thread.getName() + "-" + thread.getId();
            } else {
                str = "";
            }
            this.b.u(str, "-------fatal----------");
            this.b.u(str, "last show rit:" + this.fx);
            this.b.u(str, "last show adtype:" + this.nr);
            this.b.u(str, fx());
            this.b.u(str, th);
            this.b.u(str, "-------finish----------");
            LogAdapter.u.u().u();
        }
    }
}
