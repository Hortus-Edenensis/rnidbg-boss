package com.baidu.mapsdkplatform.comapi.commonutils.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3964a;
    private int b;
    private int c;

    public a(int i, int i2, int i3) {
        this.f3964a = i;
        this.b = i2;
        this.c = i3;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        return "DownloadThreadInfo{id=" + this.f3964a + ", start=" + this.b + ", end=" + this.c + '}';
    }

    public void a(int i) {
        this.c = i;
    }
}
