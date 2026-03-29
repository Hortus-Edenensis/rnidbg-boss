package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6449a;
    public final /* synthetic */ l b;

    public g(l lVar, HonorPushCallback honorPushCallback) {
        this.b = lVar;
        this.f6449a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.b.d;
        sVar.a(new n(sVar), this.f6449a);
    }
}
