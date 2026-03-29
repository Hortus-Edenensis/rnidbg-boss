package com.qq.e.comm.constants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10430a;

    LoginType(int i) {
        this.f10430a = i;
        ordinal();
    }

    public int getValue() {
        return this.f10430a;
    }
}
