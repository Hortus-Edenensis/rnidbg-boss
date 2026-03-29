package com.baidu.b.b;

import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class b implements Comparator {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(a aVar, a aVar2) {
        long jB = aVar.b() - aVar2.b();
        return jB != 0 ? jB > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
    }
}
