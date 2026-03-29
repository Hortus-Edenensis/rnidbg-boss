package com.lantern.auth.pb;

import com.lantern.auth.core.BLCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PBRequestBean {
    public BLCallback callback;
    public String pid;
    public byte[] reqByte;
    public String url;

    public PBRequestBean(BLCallback bLCallback, String str, byte[] bArr, String str2) {
        this.callback = bLCallback;
        this.pid = str;
        this.reqByte = bArr;
        this.url = str2;
    }
}
