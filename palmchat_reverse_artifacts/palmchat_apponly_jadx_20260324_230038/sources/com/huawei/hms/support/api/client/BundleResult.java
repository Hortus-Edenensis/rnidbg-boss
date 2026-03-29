package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class BundleResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6856a;
    private Bundle b;

    public BundleResult(int i, Bundle bundle) {
        this.f6856a = i;
        this.b = bundle;
    }

    public int getResultCode() {
        return this.f6856a;
    }

    public Bundle getRspBody() {
        return this.b;
    }

    public void setResultCode(int i) {
        this.f6856a = i;
    }

    public void setRspBody(Bundle bundle) {
        this.b = bundle;
    }
}
