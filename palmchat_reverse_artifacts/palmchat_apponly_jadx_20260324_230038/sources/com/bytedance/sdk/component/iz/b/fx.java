package com.bytedance.sdk.component.iz.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.iz.sx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends u {
    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "generate_key";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        if (TextUtils.isEmpty(fxVar.getMemoryCacheKey())) {
            sx sxVarPn = fxVar.l().pn();
            fxVar.nr(sxVarPn.u(fxVar));
            fxVar.u(sxVarPn.nr(fxVar));
        }
        fxVar.u(new x());
    }
}
