package com.amap.api.col.p0002sl;

import android.net.wifi.WifiInfo;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class lr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WifiInfo f2977a;
    private String b;
    private String c;
    private int d = -1;

    public lr(WifiInfo wifiInfo) {
        this.f2977a = wifiInfo;
    }

    public final String a() {
        if (this.c == null) {
            this.c = lp.a(this.f2977a);
        }
        return this.c;
    }

    public final String b() {
        if (this.b == null) {
            this.b = lp.b(this.f2977a);
        }
        return this.b;
    }

    public final int c() {
        if (this.d == -1) {
            this.d = lp.c(this.f2977a);
        }
        return this.d;
    }

    public final boolean d() {
        return (this.f2977a == null || TextUtils.isEmpty(b()) || !mm.a(a())) ? false : true;
    }
}
