package com.opos.mobad.model.a;

import android.content.Context;
import com.opos.mobad.b.a.ac;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class k implements com.opos.mobad.model.b.e<com.opos.mobad.b.a.b> {
    @Override // com.opos.mobad.model.b.e
    public void a(com.opos.mobad.b bVar, com.opos.mobad.b.a.b bVar2, int i) {
        Context applicationContext;
        if (bVar == null || (applicationContext = bVar.b().getApplicationContext()) == null || !com.opos.cmn.an.h.c.a.e(bVar.b())) {
            return;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        b.a(bVar, bVar2, (Set<com.opos.mobad.model.c.e>) hashSet, false, (com.opos.mobad.model.e.m) null);
        b.a(bVar, bVar2.al, (Set<com.opos.mobad.model.c.e>) hashSet, false, (com.opos.mobad.model.e.m) null);
        b.a(bVar, bVar2.ak, (Set<com.opos.mobad.model.c.e>) hashSet, false, (com.opos.mobad.model.e.m) null);
        List<ac> list = bVar2.F;
        if (list != null && list.size() >= 0 && bVar2.F.get(0) != null) {
            b.a(bVar, bVar2.F.get(0), hashSet, hashSet2, false, null);
            ac acVar = bVar2.F.get(0);
            if (i == 5 && b.a(acVar)) {
                com.opos.mobad.model.utils.g.a(applicationContext, acVar);
            }
        }
        com.opos.cmn.an.f.a.b("resLoader", "fm:" + hashSet.size() + ",om:" + hashSet2.size());
        if (hashSet.size() > 0) {
            com.opos.cmn.an.f.a.b("resLoader", "resource result:" + new com.opos.mobad.model.e.e(applicationContext).a(hashSet, null));
        }
    }
}
