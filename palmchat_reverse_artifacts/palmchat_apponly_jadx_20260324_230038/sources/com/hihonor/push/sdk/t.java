package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6475a;
    public final /* synthetic */ Object b;

    public t(s sVar, HonorPushCallback honorPushCallback, Object obj) {
        this.f6475a = honorPushCallback;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f6475a;
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(this.b);
        }
    }
}
