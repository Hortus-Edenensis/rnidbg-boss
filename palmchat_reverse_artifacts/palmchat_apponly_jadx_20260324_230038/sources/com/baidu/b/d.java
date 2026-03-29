package com.baidu.b;

import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class d implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3335a;

    public d(c cVar) {
        this.f3335a = cVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        int i = bVar2.b - bVar.b;
        if (i == 0) {
            boolean z = bVar.d;
            if (z && bVar2.d) {
                return 0;
            }
            if (z) {
                return -1;
            }
            if (bVar2.d) {
                return 1;
            }
        }
        return i;
    }
}
