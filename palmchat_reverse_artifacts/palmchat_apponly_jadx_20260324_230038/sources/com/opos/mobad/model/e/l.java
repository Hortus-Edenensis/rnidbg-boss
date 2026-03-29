package com.opos.mobad.model.e;

import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f9103a = new StringBuilder();

    public l a(String str, int i) {
        this.f9103a.append(str);
        this.f9103a.append(":");
        this.f9103a.append(i);
        this.f9103a.append(x.aQ);
        return this;
    }

    public l a(String str, String str2) {
        this.f9103a.append(str);
        this.f9103a.append(":");
        this.f9103a.append(str2);
        this.f9103a.append(x.aQ);
        return this;
    }

    public String a() {
        return this.f9103a.toString();
    }
}
