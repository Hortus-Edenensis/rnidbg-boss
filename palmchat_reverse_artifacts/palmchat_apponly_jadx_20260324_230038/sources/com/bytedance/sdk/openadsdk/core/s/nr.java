package com.bytedance.sdk.openadsdk.core.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bytedance.sdk.openadsdk.core.rh.nr {
    private static nr u;

    private nr() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public String nr() {
        return "AdEventCollector";
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public String u(String str) {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public void u(String str, String str2) {
    }

    public static synchronized nr u() {
        if (u == null) {
            u = new nr();
        }
        return u;
    }
}
