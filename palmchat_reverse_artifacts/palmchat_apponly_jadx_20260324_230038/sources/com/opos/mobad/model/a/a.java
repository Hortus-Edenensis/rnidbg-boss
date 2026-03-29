package com.opos.mobad.model.a;

import com.opos.mobad.b.a.ab;
import com.opos.mobad.b.a.ac;
import com.opos.mobad.b.a.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.CustomInfoData;
import com.opos.mobad.model.data.InteractiveData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.e.g;
import com.opos.mobad.model.e.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class a extends com.opos.mobad.model.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected g f9037a;
    protected final boolean b;
    protected com.opos.mobad.model.c.c c;
    private com.opos.mobad.b d;
    private String e;
    private com.opos.mobad.model.e.i f;
    private com.opos.mobad.model.c.d g;
    private AdData h;
    private Set<String> i;
    private Set<com.opos.mobad.model.c.e> j;
    private Set<com.opos.mobad.model.c.e> k;

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.model.c.c cVar, boolean z, g gVar, g.a aVar) {
        super(aVar);
        this.i = new HashSet();
        this.d = bVar;
        this.e = str;
        this.c = cVar;
        this.b = z;
        this.f9037a = gVar;
        this.f = new com.opos.mobad.model.e.e(bVar.b());
    }

    public abstract void a(com.opos.mobad.model.c.c cVar);

    public abstract void b(ac acVar);

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!a(this.f9037a)) {
            this.f9037a.b(this.d);
        }
        d(this.h);
    }

    @Override // com.opos.mobad.model.e.a
    public void b() {
        if (j() != 3) {
            return;
        }
        this.f9037a.a(this.d);
    }

    public void c() {
        AdData adData;
        if (j() != 6 || (adData = this.h) == null) {
            return;
        }
        a(adData.f());
    }

    public boolean d() {
        StringBuilder sb = new StringBuilder();
        sb.append("resource size:");
        Set<com.opos.mobad.model.c.e> set = this.j;
        sb.append(set == null ? 0 : set.size());
        com.opos.cmn.an.f.a.b("ALoader", sb.toString());
        Set<com.opos.mobad.model.c.e> set2 = this.j;
        return set2 == null || set2.size() <= 0;
    }

    @Override // com.opos.mobad.model.e.a
    public void e() {
        a(this.c);
    }

    private AdData a(com.opos.mobad.model.c.c cVar, com.opos.mobad.model.c.d dVar, boolean z, i iVar, Set<com.opos.mobad.model.c.e> set, Set<com.opos.mobad.model.c.e> set2) {
        List<ac> list;
        ac acVar;
        int i;
        int i2;
        CustomInfoData customInfoData;
        a aVar = this;
        boolean z2 = z;
        try {
            if (dVar == null) {
                return new AdData(10001, "net response is null.");
            }
            if (dVar.f() != 0) {
                return new AdData(dVar.f(), dVar.g(), dVar.l(), dVar.m());
            }
            List<com.opos.mobad.b.a.b> listH = dVar.h();
            if (listH != null && listH.size() > 0) {
                if (dVar.i() <= System.currentTimeMillis()) {
                    return new AdData(10003, com.opos.mobad.ad.a.a(10003), dVar.l(), dVar.m());
                }
                ArrayList arrayList = new ArrayList();
                int iMax = Math.max(1, dVar.e());
                CustomInfoData customInfoData2 = new CustomInfoData(dVar.q());
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i5 < listH.size() && i4 < iMax) {
                    com.opos.mobad.b.a.b bVar = listH.get(i5);
                    if (bVar == null || (list = bVar.F) == null || list.size() <= 0 || (acVar = list.get(i3)) == null) {
                        i = i4;
                    } else {
                        i = i4;
                        if (a(cVar.e(), bVar, acVar, false, iVar)) {
                            aVar.i.add(acVar.aW);
                            iVar.a(acVar, bVar.I);
                            iVar.a(acVar, bVar.al);
                            iVar.a(acVar, bVar.ak);
                            MaterialFileData materialFileDataA = b.a(aVar.d, bVar, set, z2, iVar);
                            MaterialFileData materialFileDataA2 = b.a(aVar.d, bVar.al, set, z2, iVar);
                            MaterialFileData materialFileDataA3 = b.a(aVar.d, bVar.ak, set, z2, iVar);
                            i2 = i5;
                            customInfoData = customInfoData2;
                            AdItemData adItemData = new AdItemData(bVar, b.a(aVar.d, acVar, set, set2, z, iVar), materialFileDataA, dVar.k(), dVar.i(), dVar.j(), cVar.a(), customInfoData, cVar.e(), cVar.i(), dVar.r(), dVar.s(), "");
                            adItemData.b(materialFileDataA2);
                            adItemData.c(materialFileDataA3);
                            if (dVar.a()) {
                                adItemData.N();
                            }
                            arrayList.add(adItemData);
                            i++;
                            i5 = i2 + 1;
                            aVar = this;
                            z2 = z;
                            i4 = i;
                            customInfoData2 = customInfoData;
                            i3 = 0;
                        }
                    }
                    i2 = i5;
                    customInfoData = customInfoData2;
                    i5 = i2 + 1;
                    aVar = this;
                    z2 = z;
                    i4 = i;
                    customInfoData2 = customInfoData;
                    i3 = 0;
                }
                if (arrayList.size() <= 0) {
                    return new AdData(10004, "adItemList is null.", dVar.l(), dVar.m());
                }
                AdData adData = new AdData(dVar.f(), dVar.g(), dVar.l(), dVar.m());
                adData.a(dVar.i());
                adData.a(dVar.o());
                adData.d(dVar.n());
                adData.a(arrayList);
                adData.b(10000);
                adData.a("ok.");
                return adData;
            }
            return new AdData(10002, "response ad list is null.", dVar.l(), dVar.m());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ALoader", "filterAdResponseToAdDataWithMaterial() fail", e);
            return new AdData(-1, "Unknown error. ");
        }
    }

    private static boolean c(ac acVar) {
        ac.i iVar = acVar.T;
        ac.i iVar2 = ac.i.DOWNLOAD;
        return iVar == iVar2 || acVar.aw == iVar2 || acVar.ax == iVar2 || acVar.aK == iVar2 || acVar.aL == iVar2;
    }

    @Override // com.opos.mobad.model.e.a
    public void a() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.j == null || a.this.j.size() <= 0) {
                    com.opos.cmn.an.f.a.b("ALoader", "resource available");
                    a.this.f9037a.d();
                    a.this.f();
                    return;
                }
                boolean zA = (a.this.j == null || a.this.j.size() <= 0) ? true : a.this.f.a(a.this.j, a.this.f9037a, new CustomInfoData(a.this.g.q()));
                a.this.f9037a.d();
                if (zA) {
                    a.this.f();
                    return;
                }
                AdData adData = new AdData(10011, "download material failed", a.this.h.g(), a.this.h.c());
                a aVar = a.this;
                aVar.f9037a.a(aVar.d, adData.d());
                a.this.c(adData);
            }
        });
    }

    public final void a(final com.opos.mobad.model.c.d dVar) {
        this.f9037a.b();
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        final AdData adDataA = a(this.c, dVar, !this.b, this.f9037a, hashSet, hashSet2);
        this.f9037a.c();
        com.opos.cmn.an.f.a.b("ALoader", "onLoadResult() adData=", adDataA);
        if (adDataA == null || adDataA.d() != 10000) {
            this.f9037a.a(this.d, adDataA != null ? adDataA.d() : -1);
            b(adDataA);
        } else {
            a(new Callable<Boolean>() { // from class: com.opos.mobad.model.a.a.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() throws Exception {
                    a.this.j = hashSet;
                    a.this.k = hashSet2;
                    a.this.h = adDataA;
                    a.this.g = dVar;
                    return Boolean.TRUE;
                }
            }, adDataA);
            if (j() == 8) {
                this.f9037a.a(this.d);
            }
        }
    }

    private void a(MaterialData materialData) {
        List<String> list;
        InteractiveData interactiveDataAd = materialData.ad();
        if (interactiveDataAd == null || (list = interactiveDataAd.e) == null || list.isEmpty()) {
            return;
        }
        o.a(this.d.b(), list);
    }

    private void a(List<AdItemData> list) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("ALoader", "prepareWebIfNeed() adItemDataList=", list);
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdItemData> it = list.iterator();
        while (it.hasNext()) {
            List<MaterialData> listI = it.next().i();
            if (listI != null && listI.size() > 0 && (materialData = listI.get(0)) != null) {
                o.a(this.d.b(), materialData.i, materialData.h);
                a(materialData);
            }
        }
    }

    public void a(final boolean z) {
        final List<com.opos.mobad.b.a.b> listH;
        com.opos.cmn.an.f.a.b("ALoader", this + ",cache:" + z);
        com.opos.mobad.model.c.d dVar = this.g;
        if (dVar != null && (listH = dVar.h()) != null && listH.size() > 0 && this.g.b() > 0) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.a.4
                @Override // java.lang.Runnable
                public void run() {
                    ac acVar;
                    com.opos.cmn.an.f.a.b("ALoader", "cache list");
                    ArrayList arrayList = new ArrayList();
                    for (com.opos.mobad.b.a.b bVar : listH) {
                        List<ac> list = bVar.F;
                        if (list != null && list.size() > 0 && (acVar = bVar.F.get(0)) != null && (!z || !a.this.i.contains(acVar.aW))) {
                            a aVar = a.this;
                            if (aVar.a(aVar.c.e(), bVar, acVar, true, null)) {
                                arrayList.add(bVar);
                                if (arrayList.size() >= a.this.g.b()) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    a.this.d.k().a(a.this.d, a.this.e, a.this.g, arrayList, a.this.c.e(), a.this.b);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.opos.mobad.b.a.b bVar, ac acVar, boolean z, i iVar) {
        if (!b.a(this.d.b(), acVar, iVar, com.opos.mobad.model.utils.d.a(bVar))) {
            return false;
        }
        if (!a(acVar)) {
            if (iVar != null) {
                iVar.b(acVar);
            }
            return false;
        }
        if (b.b(acVar) && !com.opos.mobad.cmn.func.b.i.a(this.d.b())) {
            if (iVar != null) {
                iVar.c(acVar);
            }
            return false;
        }
        if (!b.a(acVar)) {
            List<ab> list = acVar.X;
            if (list != null && list.size() > 0) {
                return true;
            }
            List<ab> list2 = acVar.U;
            if (list2 != null && list2.size() > 0) {
                return true;
            }
            List<ab> list3 = acVar.bc;
            if (list3 != null && list3.size() > 0) {
                return true;
            }
            if (iVar != null) {
                iVar.b(acVar);
            }
            return false;
        }
        List<ab> list4 = acVar.as;
        if (list4 == null || list4.size() <= 0) {
            if (iVar != null) {
                iVar.d(acVar);
            }
            return false;
        }
        if ((i == 3 || i == 6) && bVar.R != null && b.d.PLAY_CACHE.a() != bVar.R.a()) {
            if (iVar != null) {
                iVar.f(acVar);
            }
            return false;
        }
        if (b.a(this.d, bVar, list4)) {
            return true;
        }
        if (iVar != null) {
            iVar.e(acVar);
        }
        if (!z) {
            b(acVar);
        }
        return z;
    }

    public static boolean a(ac acVar) {
        String str;
        ac.d dVar;
        ac.d dVar2;
        if (!c(acVar) || (dVar = acVar.az) != (dVar2 = ac.d.DOWNLOADER)) {
            str = "is not downloader mat";
        } else {
            if (dVar != dVar2) {
                com.opos.cmn.an.f.a.b("ALoader", "is invalid downloader mat");
                return false;
            }
            str = "is downloader mat";
        }
        com.opos.cmn.an.f.a.b("ALoader", str);
        return true;
    }

    private boolean a(final g gVar) {
        Set<com.opos.mobad.model.c.e> set = this.k;
        if (set == null || set.size() <= 0) {
            return false;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.f.a(a.this.k, null);
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.e();
                    gVar.b(a.this.d);
                }
            }
        });
        return true;
    }
}
