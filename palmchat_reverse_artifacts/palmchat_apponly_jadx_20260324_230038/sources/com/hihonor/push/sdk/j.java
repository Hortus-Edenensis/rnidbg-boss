package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6457a;
    public final /* synthetic */ l b;

    public j(l lVar, HonorPushCallback honorPushCallback) {
        this.b = lVar;
        this.f6457a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.b.d;
        sVar.a(new q(sVar), this.f6457a);
    }
}
