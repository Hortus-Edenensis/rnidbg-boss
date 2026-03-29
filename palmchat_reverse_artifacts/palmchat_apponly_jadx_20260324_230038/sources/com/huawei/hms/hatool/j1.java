package com.huawei.hms.hatool;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class j1 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6770a;
    private String b;

    public j1(String str, String str2) {
        this.f6770a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        w0.b(this.f6770a, this.b);
    }
}
