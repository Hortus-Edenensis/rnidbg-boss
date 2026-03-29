package com.bytedance.sdk.openadsdk.core.nr.u.u;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.l.fx.pn;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.sdk.openadsdk.core.nr.u.u {
    nr pn = new nr();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.nr.u.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0278u {
        void u(View view, int i);
    }

    public void b(boolean z) {
        this.pn.nr(z);
    }

    public void fx(boolean z) {
        this.pn.fx(z);
    }

    public void nr(boolean z) {
        this.pn.b(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.u.u
    public int u(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.nr.u.fx fxVar) {
        return 0;
    }

    public void b() {
        if (this.pn.b()) {
            com.bytedance.sdk.openadsdk.dw.u.nr.u.u uVarPn = this.pn.pn();
            if (!jp.fx(this.u) || uVarPn == null) {
                return;
            }
            uVarPn.nr();
        }
    }

    public void fx() {
        if (this.pn.nr() && this.pn.b()) {
            com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarIz = this.pn.iz();
            if (fxVarIz instanceof pn) {
                ((pn) fxVarIz).iz(true);
            }
        }
    }

    public void nr(int i) {
        if (this.pn.b()) {
            this.pn.u(i);
        }
    }

    public void u(int i) {
        this.pn.nr(i);
    }

    public void u(Map<String, Object> map) {
        this.pn.u(map);
    }

    public nr nr() {
        return this.pn;
    }

    public void u(String str) {
        this.pn.u(str);
    }

    public void u(boolean z) {
        this.pn.u(z);
    }

    public void u(bc bcVar) {
        this.u = bcVar;
        this.pn.u(bcVar);
    }

    public void u(Context context) {
        this.nr = context;
        this.pn.u(context);
    }

    public void u(com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar) {
        this.pn.u(fxVar);
    }

    public com.bytedance.sdk.openadsdk.core.l.nr.fx u() {
        return this.pn.iz();
    }

    public void u(Object obj) {
        this.pn.u(obj);
    }

    public void u(com.bytedance.sdk.openadsdk.dw.u.nr.u.u uVar) {
        this.pn.u(uVar);
    }

    public void u(InterfaceC0278u interfaceC0278u) {
        this.pn.u(interfaceC0278u);
    }

    public void u(long j) {
        this.pn.u(j);
    }

    public void u(com.bytedance.sdk.openadsdk.core.video.nr.nr nrVar) {
        this.pn.u(nrVar);
    }
}
