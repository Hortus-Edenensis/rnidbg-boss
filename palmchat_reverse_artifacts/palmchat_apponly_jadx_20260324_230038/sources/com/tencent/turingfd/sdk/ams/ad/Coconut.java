package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Coconut {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10681a;
    public int b;
    public long c;
    public String d;
    public int e;
    public int f;

    public Coconut(int i, int i2, long j, String str, int i3, int i4) {
        this.f10681a = i;
        this.b = i2;
        this.c = j;
        this.d = str;
        this.e = i3;
        this.f = i4;
    }

    public static Coconut a(int i) {
        return new Coconut(i, 100, -1L, "", -1, -2);
    }

    public String toString() {
        return this.f10681a + "_" + this.b + "_" + this.c + "_" + this.e + "_" + this.d + "_" + this.f;
    }

    public static Coconut a(int i, int i2) {
        return new Coconut(i, 200, -1L, "", -1, i2);
    }
}
