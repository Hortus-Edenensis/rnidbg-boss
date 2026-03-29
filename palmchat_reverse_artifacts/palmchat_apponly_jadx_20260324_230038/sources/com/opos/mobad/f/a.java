package com.opos.mobad.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import com.opos.mobad.ad.a.a;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.d.e;
import com.opos.mobad.ad.e.j;
import com.opos.mobad.ad.e.m;
import com.opos.mobad.ad.e.o;
import com.opos.mobad.ad.e.s;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.l;
import com.opos.mobad.f.b.g;
import com.opos.mobad.f.b.i;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.n;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c.a f8789a = new c.a(true, "");
    private AtomicBoolean c = new AtomicBoolean(false);
    private boolean d = false;
    private b b = new b();
    private com.opos.mobad.ad.privacy.a e = a();

    private com.opos.mobad.ad.b b(com.opos.mobad.f.b.a aVar) {
        com.opos.cmn.an.f.a.a("AdBaseFactory", "createDefaultAd() posId=", aVar.f8888a);
        ArrayList arrayList = new ArrayList();
        d.a aVarA = a(aVar.f8888a);
        return a(aVar, aVarA, new d(new com.opos.mobad.f.a.e.b(aVar.b), arrayList, aVarA, 0L, this.b));
    }

    private boolean e() {
        if (this.f8789a.f8521a || !com.opos.cmn.a.a.a()) {
            return com.opos.mobad.c.b.a().b();
        }
        com.opos.cmn.an.f.a.a("AdBaseFactory", "isEnable() check result fail: msg=", this.f8789a.b);
        return false;
    }

    public com.opos.mobad.ad.a.b a(Activity activity, String str, com.opos.mobad.ad.a.c cVar) {
        return (com.opos.mobad.ad.a.b) a(new com.opos.mobad.f.b.b(activity, str, com.opos.mobad.c.b.a().i(), true, cVar));
    }

    public boolean c() {
        return this.b.a();
    }

    public void d() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
    }

    public com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar) {
        List<d.a> list;
        d.b bVarA = e() ? com.opos.mobad.c.b.a().a(aVar.f8888a, true) : null;
        if (bVarA == null || (list = bVarA.f8586a) == null || list.size() <= 0) {
            return b(aVar);
        }
        com.opos.mobad.f.b.a bVar = aVar instanceof com.opos.mobad.f.b.b ? new com.opos.mobad.f.b.b((Activity) ((com.opos.mobad.f.b.b) aVar).d, aVar.f8888a, aVar.b, false, (com.opos.mobad.ad.a.c) ((com.opos.mobad.f.b.b) aVar).e) : aVar;
        if (bVarA.e == 1) {
            return a(bVar, bVarA.f8586a, bVarA.b, bVarA.c, bVarA.d);
        }
        List<d.a> list2 = bVarA.f8586a;
        return a(bVar, list2, a(list2, aVar.f8888a, bVarA.c), bVarA.d, bVarA.e);
    }

    public c.a b() {
        return this.f8789a;
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar, d.a aVar2, com.opos.mobad.ad.c cVar) {
        if (aVar instanceof com.opos.mobad.f.b.b) {
            com.opos.mobad.f.b.b bVar = (com.opos.mobad.f.b.b) aVar;
            Point pointD = com.opos.mobad.c.b.a().d(bVar.f8888a);
            a.C0715a c0715a = new a.C0715a();
            if (pointD != null) {
                c0715a.a(pointD.x);
                c0715a.b(pointD.y);
            }
            return cVar.a((Activity) bVar.d, bVar.f8888a, aVar2.g, bVar.c, c0715a.a(), (com.opos.mobad.ad.a.c) bVar.e);
        }
        if (aVar instanceof com.opos.mobad.f.b.d) {
            com.opos.mobad.f.b.d dVar = (com.opos.mobad.f.b.d) aVar;
            return cVar.a((Activity) dVar.d, dVar.f8888a, aVar2.g, com.opos.mobad.c.b.a().a(dVar.f8888a) == com.opos.mobad.c.a.d.b, (com.opos.mobad.ad.d.d) dVar.e);
        }
        if (aVar instanceof com.opos.mobad.f.b.c) {
            com.opos.mobad.f.b.c cVar2 = (com.opos.mobad.f.b.c) aVar;
            return cVar.a((Activity) cVar2.d, cVar2.f8888a, aVar2.g, a(cVar2), (com.opos.mobad.ad.d.b) cVar2.e);
        }
        if (aVar instanceof com.opos.mobad.f.b.e) {
            com.opos.mobad.f.b.e eVar = (com.opos.mobad.f.b.e) aVar;
            return cVar.a(eVar.c, eVar.f8888a, aVar2.g, aVar2.j, aVar2.i, (j) eVar.d, this.e);
        }
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            return cVar.a(gVar.c, gVar.e, gVar.f8888a, aVar2.g, (o) gVar.d);
        }
        if (aVar instanceof i) {
            i iVar = (i) aVar;
            return cVar.a(iVar.d, iVar.f8888a, aVar2.g, com.opos.mobad.c.b.a().a(iVar.f8888a) == com.opos.mobad.c.a.d.b, (com.opos.mobad.ad.f.b) iVar.e);
        }
        if (!(aVar instanceof com.opos.mobad.f.b.j)) {
            com.opos.cmn.an.f.a.b("AdBaseFactory", "createAdFromAdCreator() fail adParams=", aVar);
            return null;
        }
        com.opos.mobad.f.b.j jVar = (com.opos.mobad.f.b.j) aVar;
        f fVar = new f();
        com.opos.mobad.ad.g.b bVarA = cVar.a((Activity) jVar.d, jVar.f8888a, aVar2.g, jVar.c, (com.opos.mobad.ad.g.c) jVar.e);
        fVar.a(bVarA);
        return bVarA;
    }

    public com.opos.mobad.ad.g.b b(Activity activity, String str, com.opos.mobad.ad.g.c cVar, com.opos.mobad.ad.g.f fVar) {
        a(activity);
        return new l(activity, str, fVar, cVar, this.b);
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar, List<d.a> list, d.a aVar2, long j, int i) {
        com.opos.cmn.an.f.a.a("AdBaseFactory", "createAdSSp() posId=", aVar.f8888a, "channelList=", list, "mainChannel=", aVar2, "dispatch=", Integer.valueOf(i));
        return a(aVar, a(aVar.f8888a, list.get(0)), new d(new com.opos.mobad.f.a.e.c(i, aVar.b), list, aVar2, j, this.b));
    }

    private d.a b(String str, d.a aVar) {
        return new d.a(d.a.f8585a, str, 100, 30000L, aVar.i, aVar.j);
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar, List<d.a> list, d.a aVar2, long j, long j2) {
        d.a aVarA = a(aVar.f8888a, list, aVar2, j);
        com.opos.cmn.an.f.a.a("AdBaseFactory", "createAdDelegator() posId=", aVar.f8888a, "channelEntityList=", list, "reserveChannelEntity=", aVarA);
        return a(aVar, b(aVar.f8888a, list.get(0)), new d(new com.opos.mobad.f.a.e.b(aVar.b), list, aVarA, j2, this.b));
    }

    public com.opos.mobad.ad.d.a a(Activity activity, String str, com.opos.mobad.ad.d.e eVar, com.opos.mobad.ad.d.b bVar) {
        e.b bVar2 = e.b.NORMAL;
        if (eVar != null) {
            bVar2 = eVar.c;
        }
        return (com.opos.mobad.ad.d.a) a((com.opos.mobad.f.b.a) new com.opos.mobad.f.b.c(activity, str, com.opos.mobad.c.b.a().n(), bVar2, bVar));
    }

    public com.opos.mobad.ad.d.c a(Activity activity, String str, com.opos.mobad.ad.d.d dVar) {
        return (com.opos.mobad.ad.d.c) a(new com.opos.mobad.f.b.d(activity, str, com.opos.mobad.c.b.a().p(), dVar));
    }

    private com.opos.mobad.ad.d.e a(com.opos.mobad.f.b.c cVar) {
        return new e.a().a(com.opos.mobad.c.b.a().a(cVar.f8888a) == com.opos.mobad.c.a.d.b).b(com.opos.mobad.c.b.a().e(cVar.f8888a)).a(cVar.c).a();
    }

    public com.opos.mobad.ad.e.c a(Context context, String str, int i, m mVar) {
        com.opos.mobad.ad.c cVarB;
        b bVar = this.b;
        if (bVar == null || (cVarB = bVar.b(d.a.f8585a)) == null) {
            return null;
        }
        if (cVarB instanceof n) {
            return ((n) cVarB).a(context, str, str, i, mVar);
        }
        if (cVarB instanceof com.opos.mobad.f.a.d.b) {
            return ((com.opos.mobad.f.a.d.b) cVarB).a(context, str, str, i, mVar);
        }
        return null;
    }

    public com.opos.mobad.ad.e.c a(Context context, String str, com.opos.mobad.ad.e.f fVar) {
        com.opos.mobad.ad.c cVarB;
        b bVar = this.b;
        if (bVar == null || (cVarB = bVar.b(d.a.f8585a)) == null) {
            return null;
        }
        return cVarB.a(context, str, str, fVar);
    }

    public com.opos.mobad.ad.e.g a(Context context, String str, j jVar) {
        return (com.opos.mobad.ad.e.g) a(new com.opos.mobad.f.b.e(context, str, com.opos.mobad.c.b.a().s(), jVar));
    }

    public com.opos.mobad.ad.e.n a(Context context, String str, s sVar, o oVar) {
        return (com.opos.mobad.ad.e.n) a(new g(context, str, com.opos.mobad.c.b.a().u(), sVar, oVar));
    }

    public com.opos.mobad.ad.f.a a(Context context, String str, com.opos.mobad.ad.f.b bVar) {
        return (com.opos.mobad.ad.f.a) a(new i(context, str, com.opos.mobad.c.b.a().q(), bVar));
    }

    public com.opos.mobad.ad.g.a a(Context context, String str, com.opos.mobad.ad.g.c cVar, com.opos.mobad.ad.g.f fVar) {
        a(context);
        return new com.opos.mobad.f.a.c(context, str, fVar, cVar, this.b);
    }

    public com.opos.mobad.ad.g.b a(Activity activity, String str, com.opos.mobad.ad.g.c cVar, com.opos.mobad.ad.g.f fVar) {
        a(activity);
        return new l(activity, str, fVar, cVar, this.b);
    }

    public static com.opos.mobad.ad.privacy.a a() {
        return new com.opos.mobad.cmn.a.c(new com.opos.mobad.o());
    }

    private d.a a(String str) {
        return new d.a(d.a.f8585a, str, 100, 30000L, 0, 0);
    }

    private d.a a(String str, d.a aVar) {
        return new d.a(d.a.f8585a, str, 100, 30000L, aVar.i, aVar.j);
    }

    private d.a a(String str, List<d.a> list, d.a aVar, long j) {
        boolean z;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        loop0: while (true) {
            for (d.a aVar2 : list) {
                i2 = aVar2.i;
                i3 = aVar2.j;
                int i4 = aVar2.k;
                i += i4;
                z2 = z2 || d.a.f8585a == aVar2.f;
                z = z || (aVar != null && aVar.f == aVar2.f && i4 > 0);
            }
        }
        if (!z2 && i < 100) {
            list.add(new d.a(d.a.f8585a, str, 100 - i, j, i2, i3));
            z2 = true;
        }
        if (!z && aVar != null) {
            return aVar;
        }
        if (z2) {
            return null;
        }
        return new d.a(d.a.f8585a, str, 100, j, i2, i3);
    }

    private d.a a(List<d.a> list, String str, long j) {
        List<d.a> arrayList = list == null ? new ArrayList<>() : list;
        d.a aVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (d.a aVar2 : arrayList) {
            if (d.a.f8585a == aVar2.f) {
                aVar = aVar2;
            }
            i2 = aVar2.i;
            i3 = aVar2.j;
            i += aVar2.k;
        }
        if (aVar != null) {
            return aVar;
        }
        d.a aVar3 = new d.a(d.a.f8585a, str, Math.max(0, 100 - i), j, i2, i3);
        arrayList.add(aVar3);
        return aVar3;
    }

    public String a(String str, int i) {
        String str2;
        b bVar = this.b;
        if (bVar == null) {
            str2 = "not init error";
        } else {
            com.opos.mobad.ad.c cVarB = bVar.b(d.a.f8585a);
            if (cVarB != null) {
                return cVarB.a(str, i);
            }
            str2 = "get token but null adCreator";
        }
        com.opos.cmn.an.f.a.a("AdBaseFactory", str2);
        return null;
    }

    public void a(Context context) {
        this.b.a(context.getApplicationContext(), com.opos.mobad.c.b.a(), this.d);
    }

    public void a(Context context, Integer num, com.opos.mobad.ad.c cVar) {
        c.a aVarA = this.b.a(context, num, cVar);
        if (!aVarA.f8521a) {
            this.f8789a = aVarA;
        }
        com.opos.cmn.an.f.a.b("AdBaseFactory", "checkAndAddCreator() key=", num, "adCreator=", cVar);
    }

    public void a(final Context context, final boolean z) {
        this.d = z;
        com.opos.mobad.c.b.a().a(new d.InterfaceC0721d() { // from class: com.opos.mobad.f.a.1
            @Override // com.opos.mobad.c.a.d.InterfaceC0721d
            public void a(boolean z2) {
                a.this.b.a(context, com.opos.mobad.c.b.a(), z);
                final com.opos.mobad.c.a.a aVarM = com.opos.mobad.c.b.a().m();
                if (!aVarM.a() || z2) {
                    return;
                }
                com.opos.cmn.an.f.a.a("AdBaseFactory", "refresh bottom ad start");
                final com.opos.mobad.b bVarB = com.opos.mobad.d.a().b(context);
                final String strB = aVarM.b();
                if (TextUtils.isEmpty(strB)) {
                    com.opos.cmn.an.f.a.a("AdBaseFactory", "BottomReqAdPosId is empty.");
                } else {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.opos.mobad.o.d.b(context, "fallbackAdPosId", strB);
                            com.opos.mobad.model.b.a(context).a(bVarB, strB, new b.a() { // from class: com.opos.mobad.f.a.1.1.1
                                @Override // com.opos.mobad.model.b.a
                                public void a(int i, AdHelper.AdHelperData adHelperData) {
                                    com.opos.cmn.an.f.a.a("AdBaseFactory", "refresh bottom ad success");
                                }

                                @Override // com.opos.mobad.model.b.a
                                public void a(int i, String str, AdData adData) {
                                    com.opos.cmn.an.f.a.a("AdBaseFactory", "refresh bottom ad failed, code=", Integer.valueOf(i), "msg=", str);
                                }
                            }, aVarM.a());
                        }
                    });
                }
            }
        });
        this.b.a(context, com.opos.mobad.c.b.a(), z);
    }
}
