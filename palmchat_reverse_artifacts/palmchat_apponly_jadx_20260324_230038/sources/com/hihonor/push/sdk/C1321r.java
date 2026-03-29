package com.hihonor.push.sdk;

import java.util.List;

/* JADX INFO: renamed from: com.hihonor.push.sdk.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class C1321r implements k0<List<HonorPushDataMsg>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f6470a;
    public final /* synthetic */ s b;

    public C1321r(s sVar, HonorPushCallback honorPushCallback) {
        this.b = sVar;
        this.f6470a = honorPushCallback;
    }

    @Override // com.hihonor.push.sdk.k0
    public void a(a1 a1Var) {
        if (!a1Var.e()) {
            s.a(this.b, this.f6470a, -1, a1Var.b().toString());
            return;
        }
        s sVar = this.b;
        HonorPushCallback honorPushCallback = this.f6470a;
        Object objC = a1Var.c();
        sVar.getClass();
        b1.a(new t(sVar, honorPushCallback, objC));
    }
}
