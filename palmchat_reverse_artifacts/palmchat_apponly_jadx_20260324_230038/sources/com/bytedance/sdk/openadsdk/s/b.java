package com.bytedance.sdk.openadsdk.s;

import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum b {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G(NetworkUtil.NETWORK_CLASS_5G),
    TYPE_WIFI("wifi"),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");

    private String n;

    b(String str) {
        this.n = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.n;
    }
}
