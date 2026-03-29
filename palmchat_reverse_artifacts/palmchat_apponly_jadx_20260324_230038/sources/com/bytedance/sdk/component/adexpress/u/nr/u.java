package com.bytedance.sdk.component.adexpress.u.nr;

import android.webkit.WebResourceResponse;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private int nr = -1;
    private WebResourceResponse u;

    public int getType() {
        return this.nr;
    }

    public WebResourceResponse u() {
        return this.u;
    }

    public void u(WebResourceResponse webResourceResponse) {
        this.u = webResourceResponse;
    }

    public void u(int i) {
        this.nr = i;
    }
}
