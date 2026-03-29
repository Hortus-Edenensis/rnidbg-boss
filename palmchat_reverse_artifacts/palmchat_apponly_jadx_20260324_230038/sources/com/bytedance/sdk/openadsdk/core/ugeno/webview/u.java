package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import com.bytedance.adsdk.ugeno.nr.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends fx<PageWebView> {
    private String u;

    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        ((PageWebView) this.pn).setMeta(com.bytedance.sdk.openadsdk.core.u.u(jk()));
        ((PageWebView) this.pn).nr(jk());
        ((PageWebView) this.pn).setUGenContext(this.f5034a);
        ((PageWebView) this.pn).u();
        ((PageWebView) this.pn).u(this.u);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public PageWebView u() {
        return new PageWebView(this.nr);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        if (str.equals("src")) {
            this.u = str2;
        }
    }
}
