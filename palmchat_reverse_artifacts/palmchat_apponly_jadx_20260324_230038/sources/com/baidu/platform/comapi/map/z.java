package com.baidu.platform.comapi.map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4219a;
    private int b;
    private int c;
    private int d;

    public static int c(int i) {
        return ((i & 16711680) >> 16) | ((-16777216) & i) | ((i & 255) << 16) | (65280 & i);
    }

    public z a(int i) {
        this.f4219a = i;
        return this;
    }

    public z b(int i) {
        this.b = i;
        return this;
    }

    public int d() {
        return this.b;
    }

    public String toString() {
        return "Style: color:" + Integer.toHexString(this.f4219a) + " width:" + this.b + " fillcolor:" + Integer.toHexString(this.c);
    }

    public int a() {
        return this.f4219a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }
}
