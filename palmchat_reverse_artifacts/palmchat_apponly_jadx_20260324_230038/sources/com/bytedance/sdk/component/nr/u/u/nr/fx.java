package com.bytedance.sdk.component.nr.u.u.nr;

import android.text.TextUtils;
import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends l {
    public b l;

    public fx(l.u uVar) {
        super(uVar);
        this.l = new b();
    }

    @Override // com.bytedance.sdk.component.nr.u.l
    public com.bytedance.sdk.component.nr.u.b u() {
        return this.l;
    }

    @Override // com.bytedance.sdk.component.nr.u.l
    public com.bytedance.sdk.component.nr.u.nr u(s sVar) {
        sVar.u(this);
        if (sVar.nr() == null || sVar.nr().u() == null || TextUtils.isEmpty(sVar.nr().u().toString())) {
            return null;
        }
        return new u(sVar, this.l);
    }
}
