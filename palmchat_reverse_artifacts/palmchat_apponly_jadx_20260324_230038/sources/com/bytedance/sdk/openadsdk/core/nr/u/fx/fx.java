package com.bytedance.sdk.openadsdk.core.nr.u.fx;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.s.b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EmptyView f5346a;
    private String iz;
    private Double n;
    u pn;
    private Map<String, Object> x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        boolean u();
    }

    public fx() {
    }

    public void u(u uVar) {
        this.pn = uVar;
    }

    public fx(bc bcVar, Context context) {
        this.u = bcVar;
        this.nr = context;
        this.x = new HashMap();
    }

    public void u(String str) {
        this.iz = str;
    }

    public void u(EmptyView emptyView) {
        this.f5346a = emptyView;
    }

    public void u(Map<String, Object> map) {
        Map<String, Object> map2 = this.x;
        if (map2 == null) {
            this.x = map;
        } else {
            map2.putAll(map);
        }
    }

    public void u(Double d) {
        this.n = d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nr.u.fx.nr, com.bytedance.sdk.openadsdk.core.nr.u.u
    public int u(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.nr.u.fx fxVar) {
        u uVar;
        if (!dw.nr().ms() || (uVar = this.pn) == null || uVar.u()) {
            return 0;
        }
        EmptyView emptyView = this.f5346a;
        if (emptyView == null) {
            this.x.put("show_send_type", 1);
            b.u(this.u, this.iz, this.x, this.n);
        } else {
            emptyView.u("checkWhenClicked");
        }
        return 0;
    }
}
