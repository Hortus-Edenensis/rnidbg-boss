package com.opos.mobad.model.e;

import android.content.Context;
import com.opos.cmn.func.a.a.d;
import com.opos.mobad.d.a.a;
import com.opos.mobad.i.a;
import com.opos.mobad.model.data.CustomInfoData;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9099a;
    private com.opos.mobad.model.b.d b;

    public e(Context context) {
        this.f9099a = context;
        this.b = new com.opos.mobad.model.b.a.b(context);
    }

    private com.opos.mobad.i.a a(com.opos.mobad.model.c.e eVar) {
        try {
            return new a.C0747a().a(new d.a().a("GET").b(eVar.a()).a()).b(eVar.b()).c(eVar.c()).a(0).a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FetchMaterialTask", "", (Throwable) e);
            return null;
        }
    }

    private com.opos.mobad.model.c.f b(Set<com.opos.mobad.model.c.e> set) {
        com.opos.mobad.model.c.f fVar = null;
        if (set == null || set.size() <= 0) {
            return null;
        }
        ConcurrentHashMap<String, com.opos.mobad.i.a> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            for (com.opos.mobad.model.c.e eVar : set) {
                if (eVar != null && !com.opos.cmn.an.d.b.a(eVar.a())) {
                    concurrentHashMap.put(com.opos.cmn.d.c.a(eVar.a()), a(eVar));
                }
            }
            if (concurrentHashMap.size() <= 0) {
                return null;
            }
            com.opos.mobad.model.c.f fVar2 = new com.opos.mobad.model.c.f();
            try {
                fVar2.a(concurrentHashMap);
                return fVar2;
            } catch (Exception e) {
                fVar = fVar2;
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
        }
        com.opos.cmn.an.f.a.a("FetchMaterialTask", "", (Throwable) e);
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, m mVar) {
        if (mVar == null) {
            return;
        }
        int i2 = 1;
        if (i != 0) {
            if (i == 1) {
                mVar.a(str, 2);
                return;
            }
            i2 = 3;
            if (i != 2 && i != 3) {
                return;
            }
        }
        mVar.a(str, i2);
    }

    private boolean a(com.opos.mobad.model.c.f fVar, com.opos.mobad.model.c.g gVar, m mVar) {
        com.opos.cmn.func.a.a.d dVar;
        com.opos.cmn.func.a.a.d dVar2;
        if (fVar == null || gVar == null) {
            return false;
        }
        try {
            ConcurrentHashMap<String, com.opos.mobad.i.a> concurrentHashMapA = fVar.a();
            ConcurrentHashMap<String, com.opos.mobad.i.b> concurrentHashMapA2 = gVar.a();
            if (concurrentHashMapA == null || concurrentHashMapA.size() <= 0 || concurrentHashMapA2 == null || concurrentHashMapA2.size() <= 0) {
                return false;
            }
            int i = 0;
            for (String str : concurrentHashMapA.keySet()) {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    com.opos.mobad.i.a aVar = concurrentHashMapA.get(str);
                    com.opos.mobad.i.b bVar = concurrentHashMapA2.get(str);
                    if (bVar == null || !bVar.f8930a) {
                        if (mVar != null && aVar != null && (dVar = aVar.f8924a) != null) {
                            mVar.a(dVar.b, 3);
                        }
                        com.opos.cmn.an.f.a.c("FetchMaterialTask", "downloadResponse fail=", bVar);
                    } else {
                        if (mVar != null && aVar != null && (dVar2 = aVar.f8924a) != null) {
                            mVar.a(dVar2.b, 1);
                        }
                        i++;
                    }
                }
            }
            return concurrentHashMapA.size() == i;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FetchMaterialTask", "", (Throwable) e);
            return false;
        }
    }

    public boolean a(Set<com.opos.mobad.model.c.e> set) {
        return a(set, null);
    }

    @Override // com.opos.mobad.model.e.i
    public boolean a(Set<com.opos.mobad.model.c.e> set, m mVar) {
        return a(set, mVar, (CustomInfoData) null);
    }

    @Override // com.opos.mobad.model.e.i
    public boolean a(Set<com.opos.mobad.model.c.e> set, m mVar, CustomInfoData customInfoData) {
        if (set == null || set.size() <= 0) {
            return false;
        }
        if (customInfoData != null) {
            try {
                boolean z = true;
                if (customInfoData.a() == 1 || customInfoData.a() == 2) {
                    if (customInfoData.a() != 1) {
                        z = false;
                    }
                    return a(set, mVar, z);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("FetchMaterialTask", "fetchMaterial", (Throwable) e);
                return false;
            }
        }
        com.opos.mobad.model.c.f fVarB = b(set);
        if (fVarB != null) {
            return a(fVarB, this.b.a(fVarB), mVar);
        }
        return false;
    }

    private boolean a(Set<com.opos.mobad.model.c.e> set, final m mVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (com.opos.mobad.model.c.e eVar : set) {
            if (!hashSet.contains(eVar.a())) {
                hashSet.add(eVar.a());
                arrayList.add(new a.b(eVar.a(), z ? eVar.b() : ""));
            }
        }
        if (hashSet.size() <= 0) {
            return true;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.opos.mobad.downloader.f.a().a(arrayList, new a.InterfaceC0733a() { // from class: com.opos.mobad.model.e.e.1
            @Override // com.opos.mobad.d.a.a.InterfaceC0733a
            public void a() {
                countDownLatch.countDown();
            }

            @Override // com.opos.mobad.d.a.a.InterfaceC0733a
            public void a(String str) {
            }

            @Override // com.opos.mobad.d.a.a.InterfaceC0733a
            public void a(String str, int i) {
                com.opos.cmn.an.f.a.b("FetchMaterialTask", "load:" + str + "," + i);
                if (i == 1 || i == 0) {
                    atomicInteger.incrementAndGet();
                }
                e.this.a(str, i, mVar);
            }
        });
        try {
            countDownLatch.await(30L, TimeUnit.SECONDS);
            return atomicInteger.get() == hashSet.size();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("FetchMaterialTask", "fetch" + e);
            return false;
        }
    }
}
