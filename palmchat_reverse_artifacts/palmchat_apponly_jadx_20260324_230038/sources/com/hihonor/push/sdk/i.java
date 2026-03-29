package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6454a;
    public final /* synthetic */ l b;

    public i(l lVar, HonorPushCallback honorPushCallback) {
        this.b = lVar;
        this.f6454a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.b.d;
        sVar.a(new p(sVar), this.f6454a);
    }
}
