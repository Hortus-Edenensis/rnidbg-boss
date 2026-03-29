package com.qq.gdt.action.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10470a;
    private int b;

    public c(int i, int i2) {
        this.f10470a = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "abandon" : "ignore" : "fail" : "success" : "pending";
        this.b = i2;
    }

    public String a() {
        return this.f10470a;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        return "ActionStatusCount{status=" + this.f10470a + ", count=" + this.b + '}';
    }
}
