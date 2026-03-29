package com.lantern.auth.openapi;

import com.lantern.auth.stub.WkSDKReq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WkSDKParams extends WkSDKReq {
    public String mAppIcon;
    public String mAppName;
    public String mScope;

    public WkSDKParams(String str) {
        super(str);
        this.mAppName = "";
        this.mAppIcon = "";
    }
}
