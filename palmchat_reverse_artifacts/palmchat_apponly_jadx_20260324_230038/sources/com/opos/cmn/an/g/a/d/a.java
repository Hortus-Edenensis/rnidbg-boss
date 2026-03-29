package com.opos.cmn.an.g.a.d;

import android.content.Context;
import com.opos.cmn.an.g.a.a.b;
import com.opos.cmn.an.g.c;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Long, b> f7780a = new ConcurrentHashMap();

    @Override // com.opos.cmn.an.g.c
    public g a(Context context, long j, f fVar) throws Exception {
        if (context == null || fVar == null) {
            return null;
        }
        b bVar = new b(context, fVar);
        this.f7780a.put(Long.valueOf(j), bVar);
        return bVar.a();
    }

    @Override // com.opos.cmn.an.g.c
    public void a(long j) throws Exception {
        Map<Long, b> map = this.f7780a;
        if (map == null || !map.containsKey(Long.valueOf(j))) {
            return;
        }
        b bVar = this.f7780a.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.b();
        }
        this.f7780a.remove(Long.valueOf(j));
    }
}
