package com.opos.mobad.ad.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8527a;
    public String b;

    public q(int i, String str) {
        this.f8527a = i;
        this.b = str;
    }

    public void a(int i) {
        this.f8527a = i;
    }

    public String toString() {
        return "NativeAdError{code=" + this.f8527a + ", msg='" + this.b + "'}";
    }

    public void a(String str) {
        this.b = str;
    }
}
