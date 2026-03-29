package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6451a;
    public final /* synthetic */ l b;

    public h(l lVar, HonorPushCallback honorPushCallback) {
        this.b = lVar;
        this.f6451a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.b.d;
        sVar.a(new o(sVar), this.f6451a);
    }
}
