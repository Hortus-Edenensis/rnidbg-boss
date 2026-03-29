package com.bytedance.sdk.openadsdk.core.component.reward.business.nr;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private int nr;
    private String u;

    public boolean fx() {
        return !TextUtils.isEmpty(this.u);
    }

    public int nr() {
        return this.nr;
    }

    public String u() {
        return this.u;
    }

    public void u(String str) {
        this.u = str;
    }

    public void u(int i) {
        this.nr = i;
    }
}
