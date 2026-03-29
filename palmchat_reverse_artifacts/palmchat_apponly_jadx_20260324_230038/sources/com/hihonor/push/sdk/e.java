package com.hihonor.push.sdk;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f6444a;
    public final /* synthetic */ l b;

    public e(l lVar, v vVar) {
        this.b = lVar;
        this.f6444a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.b) {
            return;
        }
        this.b.b = true;
        this.b.getClass();
        this.b.f6459a = new WeakReference<>(this.f6444a.f6479a);
        this.b.c = this.f6444a.b;
        this.b.d = new s(this.f6444a.f6479a);
        if (this.b.c) {
            l lVar = this.b;
            lVar.a(new f(lVar, null, true), (HonorPushCallback<?>) null);
        }
    }
}
