package com.qq.gdt.action.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10477a;

    public a(String str, Throwable th) {
        super(str, th);
        this.f10477a = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f10477a;
    }
}
