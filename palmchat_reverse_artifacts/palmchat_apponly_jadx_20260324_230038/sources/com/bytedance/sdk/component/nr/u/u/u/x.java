package com.bytedance.sdk.component.nr.u.u.u;

import com.bytedance.sdk.component.fx.nr.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends com.bytedance.sdk.component.nr.u.b {
    q u;

    public x(q qVar) {
        this.u = qVar;
    }

    @Override // com.bytedance.sdk.component.nr.u.b
    public void nr(int i) {
        if (i < 5) {
            this.u.bg().nr(5);
        } else {
            this.u.bg().nr(i);
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.b
    public void u(int i) {
        this.u.bg().u(i);
    }
}
