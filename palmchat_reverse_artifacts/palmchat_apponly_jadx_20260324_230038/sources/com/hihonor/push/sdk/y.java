package com.hihonor.push.sdk;

import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6485a;
    public final /* synthetic */ z.a b;

    public y(z.a aVar, int i) {
        this.b = aVar;
        this.f6485a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(HonorPushErrorEnum.fromCode(this.f6485a));
    }
}
