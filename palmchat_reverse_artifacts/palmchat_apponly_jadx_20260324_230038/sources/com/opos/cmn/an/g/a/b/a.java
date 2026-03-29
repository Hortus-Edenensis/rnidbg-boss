package com.opos.cmn.an.g.a.b;

import android.content.Context;
import com.opos.cmn.an.g.b;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Long, com.opos.cmn.an.g.a.a.b> f7779a = new ConcurrentHashMap();

    @Override // com.opos.cmn.an.g.b
    public g a(Context context, long j, f fVar) throws Exception {
        if (context == null || fVar == null) {
            return null;
        }
        com.opos.cmn.an.g.a.a.b bVar = new com.opos.cmn.an.g.a.a.b(context, fVar);
        this.f7779a.put(Long.valueOf(j), bVar);
        return bVar.a();
    }

    @Override // com.opos.cmn.an.g.b
    public void a(long j) throws Exception {
        Map<Long, com.opos.cmn.an.g.a.a.b> map = this.f7779a;
        if (map == null || !map.containsKey(Long.valueOf(j))) {
            return;
        }
        com.opos.cmn.an.g.a.a.b bVar = this.f7779a.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.b();
        }
        this.f7779a.remove(Long.valueOf(j));
    }
}
