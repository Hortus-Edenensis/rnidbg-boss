package com.qq.gdt.action.g.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10520a;
    private int b;

    public b(int i, int i2) {
        this.f10520a = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "abandon" : "ignore" : "fail" : "success" : "pending";
        this.b = i2;
    }

    public String a() {
        return this.f10520a;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        return "EventStatusCount{status=" + this.f10520a + ", count=" + this.b + '}';
    }
}
