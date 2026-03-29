package com.opos.mobad.service.g;

import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f9244a = new StringBuilder();

    public int a() {
        return this.f9244a.length();
    }

    public String b() {
        return this.f9244a.toString();
    }

    public d a(String str, String str2) {
        if (this.f9244a.length() > 0) {
            this.f9244a.append(x.aQ);
        }
        this.f9244a.append(str);
        this.f9244a.append(":");
        this.f9244a.append(str2);
        return this;
    }
}
