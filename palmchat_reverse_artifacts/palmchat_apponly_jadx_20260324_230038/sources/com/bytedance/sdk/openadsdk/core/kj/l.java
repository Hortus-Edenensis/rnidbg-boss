package com.bytedance.sdk.openadsdk.core.kj;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l extends com.bytedance.sdk.openadsdk.my.fx.nr.fx {
    private iz u;

    public l(bc bcVar) {
        if (bcVar == null) {
            return;
        }
        this.u = bcVar.hm();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.fx
    public String a() {
        iz izVar = this.u;
        if (izVar == null) {
            return null;
        }
        return izVar.t();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.fx
    public String b() {
        iz izVar = this.u;
        return izVar == null ? "" : izVar.n();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.fx
    public String fx() {
        iz izVar = this.u;
        return izVar == null ? "" : izVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.fx
    public String iz() {
        iz izVar = this.u;
        if (izVar == null) {
            return null;
        }
        return izVar.nr();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.fx
    public String n() {
        iz izVar = this.u;
        if (izVar == null) {
            return null;
        }
        return izVar.jk();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.fx
    public String nr() {
        iz izVar = this.u;
        return izVar == null ? "" : izVar.pn();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.fx
    public Map<String, String> pn() {
        iz izVar = this.u;
        if (izVar == null) {
            return null;
        }
        return izVar.u();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.fx
    public String u() {
        iz izVar = this.u;
        return izVar == null ? "" : izVar.s();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.fx
    public String x() {
        iz izVar = this.u;
        if (izVar == null) {
            return null;
        }
        return izVar.a();
    }
}
