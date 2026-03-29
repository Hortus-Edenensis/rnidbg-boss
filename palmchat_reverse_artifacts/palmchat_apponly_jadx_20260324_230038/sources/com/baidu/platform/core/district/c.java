package com.baidu.platform.core.district;

import com.wifi.ad.core.config.DeviceInfoUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c extends com.baidu.platform.base.c {
    public c(String str) {
        b(str);
    }

    private void b(String str) {
        this.d.a("qt", "ext");
        this.d.a("num", "1000");
        this.d.a("l", "10");
        this.d.a("ie", "utf-8");
        this.d.a("oue", "1");
        this.d.a("res", "api");
        this.d.a("fromproduct", "android_map_sdk");
        this.d.a(DeviceInfoUtil.UID_TAG, str);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.p();
    }
}
