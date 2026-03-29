package com.opos.mobad.model;

import android.content.Context;
import android.os.SystemClock;
import com.opos.mobad.model.a.e;
import com.opos.mobad.model.a.f;
import com.opos.mobad.model.b.c;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.h;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.model.utils.g;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f9058a = -1;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;
    public static int e = 3;
    private static volatile b f;
    private final e g;
    private volatile h i;
    private c j;
    private AtomicBoolean k = new AtomicBoolean(false);
    private com.opos.mobad.model.utils.b h = new com.opos.mobad.model.utils.b();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, AdHelper.AdHelperData adHelperData);

        void a(int i, String str, AdData adData);
    }

    private b(Context context) {
        f fVar = new f(context);
        this.j = fVar;
        this.i = new com.opos.mobad.model.a.h(fVar);
        this.g = e.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(long j, int i) {
        long jMax = Math.max(SystemClock.elapsedRealtime() - j, 0L);
        long j2 = i;
        if (j2 > jMax) {
            return (int) Math.max((j2 - jMax) - 100, 0L);
        }
        return 0;
    }

    public void b() {
        this.k.compareAndSet(true, false);
    }

    private int a(com.opos.mobad.b bVar, int i) {
        switch (i) {
            case 1:
                return bVar.n().f();
            case 2:
                return bVar.n().g();
            case 3:
            case 6:
                return bVar.n().h();
            case 4:
                return bVar.n().j();
            case 5:
                return bVar.n().i();
            default:
                return 0;
        }
    }

    public static b a(Context context) {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new b(context);
                }
            }
        }
        return f;
    }

    private FutureTask<Integer> a(com.opos.mobad.b bVar, String str, int i) {
        if (i == 5) {
            return null;
        }
        return bVar.j().a(bVar.b(), str, i);
    }

    public void a() {
        this.k.compareAndSet(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, int i, String str2, AdData adData, int i2, a aVar) {
        int i3;
        String strA;
        if (adData != null && adData.g() > 0) {
            int iG = adData.g() * 1000;
            this.h.a(str, iG);
            com.opos.cmn.an.f.a.b("MobModel", "handleTaskResult() requestInterval=", Integer.valueOf(iG));
        }
        if (10000 != i || adData == null) {
            if (aVar != null) {
                aVar.a(i, str2, adData);
            }
            Object[] objArr = new Object[4];
            objArr[0] = "handleTaskResult() code=";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = "msg=";
            if (str2 == null) {
                str2 = "";
            }
            objArr[3] = str2;
            com.opos.cmn.an.f.a.a("MobModel", objArr);
            return;
        }
        AdHelper.AdHelperData adHelperDataA = AdHelper.a(adData);
        if (adHelperDataA != null) {
            int iC = adData.c();
            adHelperDataA.f9107a.a(i2);
            if (aVar != null) {
                aVar.a(iC, adHelperDataA);
                return;
            }
            return;
        }
        if (g.a(context, adData)) {
            i3 = 10401;
            strA = com.opos.mobad.ad.a.a(10401);
        } else {
            i3 = -1;
            strA = "ad data is null";
        }
        if (aVar != null) {
            aVar.a(i3, strA, adData);
        }
    }

    public void a(com.opos.mobad.b bVar, String str, int i, String str2, int i2, a aVar) {
        a(bVar, str, i, str2, i2, aVar, (List<String>) null);
    }

    public void a(com.opos.mobad.b bVar, String str, int i, String str2, int i2, a aVar, int i3) {
        a(bVar, str, i, str2, i2, aVar, i3, -1, (List<String>) null);
    }

    public void a(final com.opos.mobad.b bVar, final String str, final int i, String str2, final int i2, final a aVar, int i3, int i4, List<String> list) {
        com.opos.cmn.an.f.a.b("MobModel", "fetchAd");
        if (a(str, aVar)) {
            this.h.a(str);
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.opos.cmn.an.f.a.b("MobModel", "fetchAd start:", Long.valueOf(jElapsedRealtime));
            final FutureTask<Integer> futureTaskA = a(bVar, str, i);
            a(bVar, str, i, str2, i2, new com.opos.mobad.model.d.a() { // from class: com.opos.mobad.model.b.3
                @Override // com.opos.mobad.model.d.a
                public void a(int i5, String str3, AdData adData, Object... objArr) {
                    int iIntValue;
                    FutureTask futureTask = futureTaskA;
                    if (futureTask != null) {
                        try {
                            iIntValue = ((Integer) futureTask.get(b.this.a(jElapsedRealtime, i2), TimeUnit.MILLISECONDS)).intValue();
                        } catch (Exception e2) {
                            int iA = bVar.j().a(i);
                            com.opos.cmn.an.f.a.c("MobModel", "check future fail", e2);
                            iIntValue = iA;
                        }
                    } else {
                        iIntValue = 1;
                    }
                    b.this.a(bVar.b(), str, i5, str3, adData, iIntValue, aVar);
                }
            }, i3, i4, list);
        }
    }

    public void a(com.opos.mobad.b bVar, String str, int i, String str2, int i2, a aVar, int i3, List<String> list) {
        a(bVar, str, i, str2, i2, aVar, i3, -1, list);
    }

    public void a(final com.opos.mobad.b bVar, final String str, final int i, String str2, final int i2, final a aVar, List<String> list) {
        com.opos.cmn.an.f.a.b("MobModel", "fetchAd");
        if (a(str, aVar)) {
            this.h.a(str);
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.opos.cmn.an.f.a.b("MobModel", "fetchAd start:", Long.valueOf(jElapsedRealtime));
            final FutureTask<Integer> futureTaskA = a(bVar, str, i);
            a(bVar, str, i, str2, i2, new com.opos.mobad.model.d.a() { // from class: com.opos.mobad.model.b.1
                @Override // com.opos.mobad.model.d.a
                public void a(int i3, String str3, AdData adData, Object... objArr) {
                    int iIntValue;
                    FutureTask futureTask = futureTaskA;
                    if (futureTask != null) {
                        try {
                            iIntValue = ((Integer) futureTask.get(b.this.a(jElapsedRealtime, i2), TimeUnit.MILLISECONDS)).intValue();
                        } catch (Exception e2) {
                            int iA = bVar.j().a(i);
                            com.opos.cmn.an.f.a.c("MobModel", "check future fail", e2);
                            iIntValue = iA;
                        }
                    } else {
                        iIntValue = 1;
                    }
                    b.this.a(bVar.b(), str, i3, str3, adData, iIntValue, aVar);
                }
            }, list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.opos.mobad.b bVar, String str, int i, String str2, int i2, final com.opos.mobad.model.d.a aVar, int i3, int i4, List<String> list) {
        int i5;
        com.opos.mobad.model.c.c cVarA = com.opos.mobad.cmn.func.b.g.a(bVar, str, i, str2, list);
        if (i3 == b || i3 == c) {
            cVarA.a(i3 == c ? 2 : 1);
            i5 = i4;
            i = 0;
        } else {
            i5 = i4;
        }
        cVarA.f(i5);
        int iA = a(bVar, i);
        h hVar = this.i;
        if (hVar != null && this.k.get()) {
            hVar.a(bVar, str, str2, cVarA, i, i2, iA, new h.a() { // from class: com.opos.mobad.model.b.4
                @Override // com.opos.mobad.model.e.h.a
                public void a() {
                }

                @Override // com.opos.mobad.model.e.h.a
                public void b(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.e.h.a
                public void c(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.e.h.a
                public void a(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }
            }).g();
        } else {
            AdData adData = new AdData(-1, "load but destroy");
            aVar.a(adData.d(), adData.e(), adData, new Object[0]);
        }
    }

    private void a(com.opos.mobad.b bVar, String str, int i, String str2, int i2, final com.opos.mobad.model.d.a aVar, List<String> list) {
        com.opos.mobad.model.c.c cVarA = com.opos.mobad.cmn.func.b.g.a(bVar, str, i, str2, list);
        int iA = a(bVar, i);
        com.opos.cmn.an.f.a.b("MobModel", "fetchAd with sync timeout:", Integer.valueOf(iA));
        h hVar = this.i;
        if (hVar != null && this.k.get()) {
            hVar.a(bVar, str, str2, cVarA, true, i2, iA, new h.a() { // from class: com.opos.mobad.model.b.5
                @Override // com.opos.mobad.model.e.h.a
                public void a() {
                }

                @Override // com.opos.mobad.model.e.h.a
                public void b(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.e.h.a
                public void c(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.e.h.a
                public void a(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }
            }).g();
        } else {
            AdData adData = new AdData(-1, "load but destroy");
            aVar.a(adData.d(), adData.e(), adData, new Object[0]);
        }
    }

    public void a(com.opos.mobad.b bVar, String str, a aVar) {
        a(bVar, str, aVar, false);
    }

    public void a(final com.opos.mobad.b bVar, final String str, final a aVar, boolean z) {
        com.opos.cmn.an.f.a.b("MobModel", "fetchFallbackAd");
        if (com.opos.mobad.cmn.func.b.g.d()) {
            com.opos.mobad.model.c.c cVarA = com.opos.mobad.cmn.func.b.g.a(bVar, str, 5, com.opos.cmn.i.f.a(), (List<String>) null, true);
            com.opos.mobad.model.d.a aVar2 = new com.opos.mobad.model.d.a() { // from class: com.opos.mobad.model.b.2
                @Override // com.opos.mobad.model.d.a
                public void a(int i, String str2, AdData adData, Object... objArr) {
                    b.this.a(bVar.b(), str, i, str2, adData, 1, aVar);
                }
            };
            if (!this.k.get()) {
                AdData adData = new AdData(-1, "load but destroy");
                aVar2.a(adData.d(), adData.e(), adData, new Object[0]);
            } else {
                try {
                    this.g.a(bVar, this.j, str, cVarA, aVar2, z);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("MobModel", "fetchFallbackAd", e2);
                }
            }
        }
    }

    private boolean a(String str, a aVar) {
        int i;
        if (!com.opos.mobad.cmn.func.b.g.d()) {
            i = 11005;
        } else {
            if (this.h.b(str)) {
                return true;
            }
            i = 11003;
        }
        aVar.a(i, com.opos.mobad.ad.a.a(i), null);
        return false;
    }

    public byte[] a(com.opos.mobad.b bVar, com.opos.mobad.model.c.c cVar) {
        if (cVar == null) {
            return null;
        }
        return this.j.a(bVar, cVar);
    }
}
