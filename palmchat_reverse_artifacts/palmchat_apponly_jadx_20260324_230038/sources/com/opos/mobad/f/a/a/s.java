package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.c.a.d;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class s<T extends com.opos.mobad.ad.b, P> extends h<T> implements q<T, P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HashMap<Integer, List<P>> f8823a;

    public s(String str, int i, com.opos.mobad.f.a.c.a aVar, List<d.a> list, d.a aVar2, long j, com.opos.mobad.f.a.b.c<T> cVar, b.a aVar3) {
        super(str, i, aVar, list, aVar2, j, cVar, aVar3);
        this.f8823a = new HashMap<>();
    }

    @Override // com.opos.mobad.f.a.a.q
    public List<P> g() {
        return this.f8823a.remove(Integer.valueOf(j()));
    }

    @Override // com.opos.mobad.f.a.a.h
    public boolean g(int i) {
        return this.f8823a.containsKey(Integer.valueOf(i));
    }
}
