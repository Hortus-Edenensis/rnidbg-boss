package com.bytedance.sdk.openadsdk.core.c;

import com.bytedance.sdk.openadsdk.core.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.openadsdk.s.u {
    private com.bytedance.sdk.openadsdk.s.b pn() {
        String strIz = com.bytedance.sdk.openadsdk.core.n.u.iz();
        strIz.hashCode();
        switch (strIz) {
            case "2g":
                return com.bytedance.sdk.openadsdk.s.b.TYPE_2G;
            case "3g":
                return com.bytedance.sdk.openadsdk.s.b.TYPE_3G;
            case "4g":
                return com.bytedance.sdk.openadsdk.s.b.TYPE_4G;
            case "5g":
                return com.bytedance.sdk.openadsdk.s.b.TYPE_5G;
            case "wifi":
                return com.bytedance.sdk.openadsdk.s.b.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.s.b.TYPE_UNKNOWN;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.s.u
    public com.bytedance.sdk.openadsdk.s.b b() {
        return pn();
    }

    @Override // com.bytedance.sdk.openadsdk.s.u
    public boolean fx() {
        return super.fx();
    }

    @Override // com.bytedance.sdk.openadsdk.s.u
    public boolean nr() {
        return n.o().pn();
    }
}
