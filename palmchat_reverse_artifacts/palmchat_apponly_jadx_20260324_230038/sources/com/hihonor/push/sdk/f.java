package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6446a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ l c;

    public f(l lVar, HonorPushCallback honorPushCallback, boolean z) {
        this.c = lVar;
        this.f6446a = honorPushCallback;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.c.d;
        sVar.a(new m(sVar, this.b), this.f6446a);
    }
}
