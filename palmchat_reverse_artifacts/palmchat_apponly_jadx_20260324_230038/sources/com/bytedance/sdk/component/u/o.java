package com.bytedance.sdk.component.u;

import com.bytedance.component.sdk.annotation.AnyThread;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.u.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class o {
    static c u;
    private final jk b;
    private final com.bytedance.sdk.component.mv.fx fx;
    private volatile boolean iz;
    private final u nr;
    private final List<s> pn;

    public o(jk jkVar) {
        c cVar;
        ArrayList arrayList = new ArrayList();
        this.pn = arrayList;
        this.iz = false;
        this.b = jkVar;
        dw dwVarU = (!jkVar.n || (cVar = u) == null) ? null : cVar.u(jkVar.t);
        if (jkVar.u != null) {
            u uVar = jkVar.nr;
            if (uVar == null) {
                this.nr = new kj();
            } else {
                this.nr = uVar;
            }
        } else {
            this.nr = jkVar.nr;
        }
        this.nr.u(jkVar.fx());
        this.nr.u(jkVar, dwVarU);
        this.fx = jkVar.u;
        arrayList.add(jkVar.jk);
        a.u(jkVar.iz);
        qq.u(jkVar.x);
    }

    private void nr() {
        if (this.iz) {
            a.u(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    public static jk u(com.bytedance.sdk.component.mv.fx fxVar) {
        return new jk(fxVar);
    }

    @AnyThread
    public <T> void u(String str, T t) {
        nr();
        this.nr.u(str, t);
    }

    public o u(String str, pn<?, ?> pnVar) {
        return u(str, (String) null, pnVar);
    }

    @UiThread
    public o u(String str, String str2, pn<?, ?> pnVar) {
        nr();
        this.nr.iz.u(str, pnVar);
        return this;
    }

    public o u(String str, b.nr nrVar) {
        return u(str, (String) null, nrVar);
    }

    @UiThread
    public o u(String str, String str2, b.nr nrVar) {
        nr();
        this.nr.iz.u(str, nrVar);
        return this;
    }

    public boolean u(String str) {
        x xVar;
        u uVar = this.nr;
        if (uVar == null || (xVar = uVar.iz) == null) {
            return false;
        }
        return xVar.u(str);
    }

    public void u() {
        if (this.iz) {
            return;
        }
        this.nr.fx();
        this.iz = true;
        Iterator<s> it = this.pn.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
