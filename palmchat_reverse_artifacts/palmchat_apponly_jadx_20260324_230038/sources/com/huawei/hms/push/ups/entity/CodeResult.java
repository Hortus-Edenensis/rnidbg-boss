package com.huawei.hms.push.ups.entity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class CodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6843a;
    private String b;

    public CodeResult() {
    }

    public String getReason() {
        return this.b;
    }

    public int getReturnCode() {
        return this.f6843a;
    }

    public void setReason(String str) {
        this.b = str;
    }

    public void setReturnCode(int i) {
        this.f6843a = i;
    }

    public CodeResult(int i) {
        this.f6843a = i;
    }

    public CodeResult(int i, String str) {
        this.f6843a = i;
        this.b = str;
    }
}
