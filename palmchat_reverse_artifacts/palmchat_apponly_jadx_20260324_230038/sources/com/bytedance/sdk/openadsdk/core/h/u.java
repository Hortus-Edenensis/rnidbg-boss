package com.bytedance.sdk.openadsdk.core.h;

import com.bytedance.sdk.openadsdk.core.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    Boolean u = null;
    Boolean nr = null;
    Boolean fx = null;

    public boolean fx() {
        if (this.fx == null) {
            com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
            this.fx = Boolean.valueOf(bVarSx == null || bVarSx.u());
        }
        return this.fx.booleanValue();
    }

    public boolean nr() {
        if (this.nr == null) {
            com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
            this.nr = Boolean.valueOf(bVarSx == null || bVarSx.b());
        }
        return this.nr.booleanValue();
    }

    public boolean u() {
        if (this.u == null) {
            com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
            this.u = Boolean.valueOf(bVarSx == null || bVarSx.fx());
        }
        return this.u.booleanValue();
    }
}
