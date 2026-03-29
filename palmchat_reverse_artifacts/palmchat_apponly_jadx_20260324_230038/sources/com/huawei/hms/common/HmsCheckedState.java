package com.huawei.hms.common;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public enum HmsCheckedState {
    UNCHECKED(0),
    NOT_NEED_UPDATE(1),
    NEED_UPDATE(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6674a;

    HmsCheckedState(int i) {
        this.f6674a = i;
    }

    public int getState() {
        return this.f6674a;
    }
}
