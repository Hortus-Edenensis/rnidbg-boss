package com.baidu.b.b;

import com.baidu.b.b.e;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class f implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e.c f3318a;

    public f(e.c cVar) {
        this.f3318a = cVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(e.c.a aVar, e.c.a aVar2) {
        return aVar.f3314a - aVar2.f3314a;
    }
}
