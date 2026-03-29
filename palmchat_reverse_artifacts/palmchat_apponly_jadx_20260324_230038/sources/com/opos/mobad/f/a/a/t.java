package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.ad.j;
import com.opos.mobad.c.a.d;
import defpackage.ch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class t<T extends com.opos.mobad.ad.b, P extends com.opos.mobad.ad.j> extends i<T> implements q<T, P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HashMap<Integer, List<P>> f8824a;
    final u d;

    public t(String str, int i, com.opos.mobad.f.a.c.a aVar, List<d.a> list, d.a aVar2, long j, int i2, com.opos.mobad.f.a.b.a<T> aVar3, b.a aVar4) {
        super(str, i, aVar, list, aVar2, j, i2, aVar3, aVar4);
        this.f8824a = new HashMap<>();
        this.d = new u(list);
    }

    private HashMap<Integer, List<P>> a(Map<Integer, List<P>> map, List<String> list) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        HashMap map2 = new HashMap(map);
        ch.d dVar = (HashMap<Integer, List<P>>) new HashMap();
        for (Map.Entry entry : map2.entrySet()) {
            Integer num = (Integer) entry.getKey();
            if (b(num.intValue(), list)) {
                dVar.put(num, entry.getValue());
            }
        }
        return dVar;
    }

    @Override // com.opos.mobad.f.a.a.i
    public d.a b(List<String> list) {
        HashMap<Integer, List<P>> mapA = a(this.f8824a, list);
        if (mapA == null || mapA.size() <= 0) {
            return null;
        }
        return this.d.a(mapA);
    }

    @Override // com.opos.mobad.f.a.a.i
    public boolean f(int i) {
        return this.f8824a.containsKey(Integer.valueOf(i));
    }

    @Override // com.opos.mobad.f.a.a.q
    public List<P> g() {
        return this.f8824a.remove(Integer.valueOf(j()));
    }
}
