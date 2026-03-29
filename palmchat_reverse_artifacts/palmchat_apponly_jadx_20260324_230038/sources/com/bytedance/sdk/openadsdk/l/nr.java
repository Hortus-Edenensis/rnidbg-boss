package com.bytedance.sdk.openadsdk.l;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private Map<String, String> fx;
    private String nr;
    private Uri u;

    public nr(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest != null) {
            this.u = webResourceRequest.getUrl();
            this.nr = webResourceRequest.getMethod();
            this.fx = webResourceRequest.getRequestHeaders();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.u = Uri.parse(str);
        this.nr = "GET";
    }

    public Map<String, String> fx() {
        return this.fx;
    }

    public String nr() {
        return this.nr;
    }

    public Uri u() {
        return this.u;
    }
}
