package com.vivo.push.g;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class ac implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f11233a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ ab e;

    public ac(ab abVar, int i, List list, List list2, String str) {
        this.e = abVar;
        this.f11233a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ab abVar = this.e;
        ((aa) abVar).b.onSetTags(((com.vivo.push.s) abVar).f11282a, this.f11233a, this.b, this.c, this.d);
    }
}
