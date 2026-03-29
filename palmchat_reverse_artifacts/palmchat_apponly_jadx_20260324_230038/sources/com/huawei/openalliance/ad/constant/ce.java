package com.huawei.openalliance.ad.constant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@com.huawei.openalliance.ad.annotations.b
public enum ce {
    HTTP("http://"),
    HTTPS("https://"),
    FILE("file://"),
    CONTENT("content://"),
    ASSET("asset://"),
    RES("res://");

    String S;

    ce(String str) {
        this.S = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }
}
