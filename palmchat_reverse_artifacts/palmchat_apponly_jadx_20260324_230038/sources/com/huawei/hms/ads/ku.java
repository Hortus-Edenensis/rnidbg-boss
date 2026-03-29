package com.huawei.hms.ads;

import com.alipay.sdk.m.x.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public enum ku {
    BACK(d.u),
    FORWARD("forward"),
    SAVE_PAGE("savePage"),
    REFRESH(d.w),
    ADD_TO("addTo"),
    FIND_IN_PAGE("findInPage"),
    TRANSLATE("translate"),
    OPEN_IN_BROWSER("openInBrowser"),
    NONE("none");

    private String L;

    ku(String str) {
        this.L = str;
    }

    public String Code() {
        return this.L;
    }
}
