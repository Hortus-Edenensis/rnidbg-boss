package com.qq.gdt.action.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10516a;
    private String b;

    public f() {
        this.f10516a = -1;
        this.b = "Unknown message";
    }

    public int a() {
        return this.f10516a;
    }

    public String b() {
        return this.b;
    }

    public f(int i, String str) {
        this.f10516a = i;
        this.b = str;
    }

    public f a(int i) {
        this.f10516a = i;
        return this;
    }

    public f a(String str) {
        this.b = str;
        return this;
    }
}
