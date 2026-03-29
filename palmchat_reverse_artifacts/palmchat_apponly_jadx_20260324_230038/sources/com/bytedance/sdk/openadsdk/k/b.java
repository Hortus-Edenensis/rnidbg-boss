package com.bytedance.sdk.openadsdk.k;

import android.text.TextUtils;
import com.bytedance.embedapplog.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private pn.u nr;
    private String u;

    public b(pn.u uVar) {
        this.nr = uVar;
        if (uVar == null || TextUtils.isEmpty(uVar.u) || TextUtils.equals("00000000-0000-0000-0000-000000000000", uVar.u)) {
            this.u = "error";
        }
    }

    public String getType() {
        return this.u;
    }

    public pn.u u() {
        return this.nr;
    }

    public b(String str) {
        this.u = str;
    }
}
