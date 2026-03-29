package com.bytedance.sdk.component.t.pn.u.u;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements com.bytedance.sdk.component.t.pn.u.u {
    @Override // com.bytedance.sdk.component.t.pn.u.u
    public Object u(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return ' ';
        }
        return Character.valueOf(str.charAt(0));
    }
}
