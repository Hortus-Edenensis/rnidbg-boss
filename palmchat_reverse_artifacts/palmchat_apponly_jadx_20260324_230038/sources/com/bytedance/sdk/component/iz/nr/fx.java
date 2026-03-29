package com.bytedance.sdk.component.iz.nr;

import com.bytedance.sdk.component.iz.bq;
import com.bytedance.sdk.component.iz.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements iz {
    private bq b;
    private boolean fx;
    private boolean nr;
    private String u;

    public fx(String str, boolean z, boolean z2, bq bqVar) {
        this.u = str;
        this.nr = z;
        this.fx = z2;
        this.b = bqVar;
    }

    @Override // com.bytedance.sdk.component.iz.iz
    public bq b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.iz.iz
    public boolean fx() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.iz.iz
    public boolean nr() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.iz.iz
    public String u() {
        return this.u;
    }
}
