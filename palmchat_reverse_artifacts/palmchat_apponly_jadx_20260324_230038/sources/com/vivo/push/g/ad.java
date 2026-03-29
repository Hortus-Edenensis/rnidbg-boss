package com.vivo.push.g;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class ad implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f11234a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ ab e;

    public ad(ab abVar, int i, List list, List list2, String str) {
        this.e = abVar;
        this.f11234a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ab abVar = this.e;
        ((aa) abVar).b.onSetAlias(((com.vivo.push.s) abVar).f11282a, this.f11234a, this.b, this.c, this.d);
    }
}
