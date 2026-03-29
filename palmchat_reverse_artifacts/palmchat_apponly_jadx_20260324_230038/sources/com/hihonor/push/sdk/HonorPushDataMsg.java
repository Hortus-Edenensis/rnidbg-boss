package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class HonorPushDataMsg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6437a = 1;
    public int b = 0;
    public long c;
    public String d;

    public String getData() {
        return this.d;
    }

    public long getMsgId() {
        return this.c;
    }

    public int getType() {
        return this.b;
    }

    public int getVersion() {
        return this.f6437a;
    }

    public void setData(String str) {
        this.d = str;
    }

    public void setMsgId(long j) {
        this.c = j;
    }

    public void setType(int i) {
        this.b = i;
    }

    public void setVersion(int i) {
        this.f6437a = i;
    }
}
