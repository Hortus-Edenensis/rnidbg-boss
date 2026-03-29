package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.ad.annotations.DataKeep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class JsbCallBackData<T> {
    private String callBackName;
    private boolean complete;
    private T data;

    public JsbCallBackData(T t, boolean z, String str) {
        this.complete = z;
        this.data = t;
        this.callBackName = str;
    }

    public boolean Code() {
        return this.complete;
    }

    public String I() {
        return this.callBackName;
    }

    public T V() {
        return this.data;
    }
}
