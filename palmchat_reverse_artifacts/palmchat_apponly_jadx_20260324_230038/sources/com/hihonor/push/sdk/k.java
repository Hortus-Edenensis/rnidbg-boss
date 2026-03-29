package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6458a;
    public final /* synthetic */ l b;

    public k(l lVar, HonorPushCallback honorPushCallback) {
        this.b = lVar;
        this.f6458a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.b.d;
        HonorPushCallback honorPushCallback = this.f6458a;
        sVar.getClass();
        if (honorPushCallback == null) {
            return;
        }
        a1 a1VarA = b.a(new p0(sVar.f6472a));
        C1321r c1321r = new C1321r(sVar, honorPushCallback);
        a1VarA.getClass();
        a1VarA.a(new t0(o0.c.f6465a, c1321r));
    }
}
