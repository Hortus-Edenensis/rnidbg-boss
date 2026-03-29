package com.vivo.push.g;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f11239a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ l e;

    public m(l lVar, int i, List list, List list2, String str) {
        this.e = lVar;
        this.f11239a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.e;
        ((aa) lVar).b.onDelTags(((com.vivo.push.s) lVar).f11282a, this.f11239a, this.b, this.c, this.d);
    }
}
