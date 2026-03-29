package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6477a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public u(s sVar, HonorPushCallback honorPushCallback, int i, String str) {
        this.f6477a = honorPushCallback;
        this.b = i;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f6477a;
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(this.b, this.c);
        }
    }
}
