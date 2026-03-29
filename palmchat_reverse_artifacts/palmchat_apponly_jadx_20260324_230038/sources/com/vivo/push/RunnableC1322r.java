package com.vivo.push;

import com.vivo.push.m;

/* JADX INFO: renamed from: com.vivo.push.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class RunnableC1322r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11258a;
    final /* synthetic */ m b;

    public RunnableC1322r(m mVar, String str) {
        this.b = mVar;
        this.f11258a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.a aVarB = this.b.b(this.f11258a);
        if (aVarB != null) {
            aVarB.a(1003, new Object[0]);
        }
    }
}
