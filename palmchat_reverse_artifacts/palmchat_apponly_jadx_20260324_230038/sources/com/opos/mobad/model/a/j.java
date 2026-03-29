package com.opos.mobad.model.a;

import androidx.media3.common.C;
import com.opos.cmn.i.n;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.g;
import com.opos.mobad.model.e.h;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class j extends com.opos.mobad.model.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f9050a;
    private m b;
    private com.opos.mobad.model.e.g c;
    private com.opos.mobad.model.c.c d;
    private int e;
    private int f;
    private AdData g;
    private AdData h;
    private CountDownLatch i;
    private CountDownLatch j;
    private n k;
    private boolean l;
    private com.opos.mobad.model.e.f m;
    private com.opos.mobad.b n;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h.a f9055a;

        public a(h.a aVar) {
            this.f9055a = aVar;
        }

        @Override // com.opos.mobad.model.e.g.a
        public void a(AdData adData) {
            h.a aVar = this.f9055a;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.model.e.g.a
        public void b(AdData adData) {
            h.a aVar = this.f9055a;
            if (aVar != null) {
                aVar.a(adData);
            }
        }

        @Override // com.opos.mobad.model.e.g.a
        public void c(AdData adData) {
            h.a aVar = this.f9055a;
            if (aVar != null) {
                aVar.b(adData);
            }
        }

        @Override // com.opos.mobad.model.e.g.a
        public void d(AdData adData) {
            h.a aVar = this.f9055a;
            if (aVar != null) {
                aVar.c(adData);
            }
        }
    }

    public j(com.opos.mobad.b bVar, String str, String str2, com.opos.mobad.model.c.c cVar, boolean z, com.opos.mobad.model.b.c cVar2, int i, int i2, h.a aVar) {
        super(new a(aVar));
        this.i = new CountDownLatch(2);
        this.j = new CountDownLatch(2);
        this.l = false;
        this.n = bVar;
        this.d = cVar;
        this.m = new com.opos.mobad.model.e.f(str, str2);
        this.e = i;
        this.f = Math.max(i2, 0);
        this.k = new n(com.opos.mobad.service.c.a(), new Runnable() { // from class: com.opos.mobad.model.a.j.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("mLoader", "total timeout");
                j.this.l = true;
                j.this.l();
            }
        });
        this.f9050a = new c(bVar, str, str2, cVar, z, new g.a() { // from class: com.opos.mobad.model.a.j.2
            @Override // com.opos.mobad.model.e.g.a
            public void a(AdData adData) {
                j.this.h = adData;
                j.this.i.countDown();
                com.opos.cmn.an.f.a.b("mLoader", "cache loaded");
                j.this.j.countDown();
                j.this.j.countDown();
            }

            @Override // com.opos.mobad.model.e.g.a
            public void b(AdData adData) {
                j.this.i.countDown();
                com.opos.cmn.an.f.a.b("mLoader", "cache load fail");
                j.this.h = adData;
                j.this.j.countDown();
            }

            @Override // com.opos.mobad.model.e.g.a
            public void c(AdData adData) {
                if (j.this.c == j.this.f9050a) {
                    j.this.k.a();
                    j.this.d(adData);
                }
            }

            @Override // com.opos.mobad.model.e.g.a
            public void d(AdData adData) {
                if (j.this.c == j.this.f9050a) {
                    j.this.k.a();
                    j.this.c(adData);
                }
            }
        });
        this.b = new m(bVar, str, str2, cVar, z, new g.a() { // from class: com.opos.mobad.model.a.j.3
            @Override // com.opos.mobad.model.e.g.a
            public void a(AdData adData) {
                com.opos.cmn.an.f.a.b("mLoader", "sync loaded");
                j.this.g = adData;
                j.this.i.countDown();
                j.this.j.countDown();
                j.this.j.countDown();
            }

            @Override // com.opos.mobad.model.e.g.a
            public void b(AdData adData) {
                com.opos.cmn.an.f.a.b("mLoader", "sync load fail");
                j.this.g = adData;
                j.this.i.countDown();
                j.this.j.countDown();
            }

            @Override // com.opos.mobad.model.e.g.a
            public void c(AdData adData) {
                if (j.this.c == j.this.b) {
                    j.this.k.a();
                    j.this.d(adData);
                }
            }

            @Override // com.opos.mobad.model.e.g.a
            public void d(AdData adData) {
                com.opos.mobad.model.e.f fVar;
                int i3;
                if (j.this.c == j.this.b) {
                    j.this.k.a();
                    if (j.this.l || !j.this.m()) {
                        if (j.this.l) {
                            fVar = j.this.m;
                            i3 = 4;
                        } else {
                            fVar = j.this.m;
                            i3 = 3;
                        }
                        fVar.c(i3);
                        j.this.c(adData);
                    }
                }
            }
        }, cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        if (j() != 5 || this.f9050a.j() != 3) {
            return false;
        }
        com.opos.cmn.an.f.a.b("mLoader", "change to cache");
        this.m.c(2);
        k();
        return true;
    }

    public int a(AdData adData) {
        if (adData == null || adData.f().size() <= 0 || adData.f().get(0) == null) {
            return 0;
        }
        return adData.f().get(0).ac();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.opos.cmn.an.f.a.b("mLoader", "select sync");
        if (!e(this.g)) {
            com.opos.cmn.an.f.a.c("mLoader", "select fail");
        } else {
            this.c = this.b;
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.opos.cmn.an.f.a.b("mLoader", "select cache");
        if (!e(this.h)) {
            com.opos.cmn.an.f.a.c("mLoader", "select fail");
        } else {
            this.c = this.f9050a;
            h();
        }
    }

    private void k() {
        c cVar = this.f9050a;
        this.c = cVar;
        cVar.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.opos.mobad.model.e.f fVar;
        int i;
        if (j() == 5) {
            i = 3;
            if (this.f9050a.j() == 3 && this.f9050a.d()) {
                com.opos.cmn.an.f.a.b("mLoader", "timeout to use cache");
                k();
                fVar = this.m;
                i = 2;
            } else {
                fVar = this.m;
            }
        } else {
            fVar = this.m;
            i = 4;
        }
        fVar.b(i);
    }

    @Override // com.opos.mobad.model.e.a
    public void c(AdData adData) {
        com.opos.cmn.an.f.a.b("mLoader", "onLoadResourceFail");
        this.m.a(this.n, adData.d(), adData.e(), this.c == this.f9050a, this.d.i(), this.d.k(), this.d.j());
        super.c(adData);
        i();
    }

    @Override // com.opos.mobad.model.e.a
    public void e() {
        if (this.e >= 30) {
            this.k.a(r0 - 30);
        }
        com.opos.cmn.an.f.a.b("mLoader", "request:", Integer.valueOf(this.f), "total:", Integer.valueOf(this.e));
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.a.j.4
            @Override // java.lang.Runnable
            public void run() {
                boolean zAwait;
                com.opos.mobad.model.e.f fVar;
                int i;
                j jVar;
                AdData adData;
                j.this.f9050a.g();
                j.this.b.g();
                try {
                    zAwait = j.this.i.await(j.this.f <= j.this.e ? j.this.f : j.this.e, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    com.opos.cmn.an.f.a.c("mLoader", "request await", e);
                    zAwait = false;
                }
                com.opos.cmn.an.f.a.b("mLoader", "request priority timeout:", Boolean.valueOf(zAwait));
                boolean zC = j.this.c();
                if (zC) {
                    return;
                }
                try {
                    zC = j.this.j.await(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    com.opos.cmn.an.f.a.c("mLoader", "total await", e2);
                }
                com.opos.cmn.an.f.a.b("mLoader", "request timeout:", Boolean.valueOf(zC));
                j jVar2 = j.this;
                if (zC) {
                    i = 3;
                    if (jVar2.b.j() == 3) {
                        j.this.m.a(1);
                        j.this.d();
                        return;
                    } else {
                        if (j.this.f9050a.j() == 3) {
                            j.this.m.a(2);
                            j.this.f();
                            return;
                        }
                        fVar = j.this.m;
                    }
                } else {
                    fVar = jVar2.m;
                    i = 4;
                }
                fVar.a(i);
                if (j.this.g != null) {
                    jVar = j.this;
                    adData = jVar.g;
                } else if (j.this.h != null) {
                    jVar = j.this;
                    adData = jVar.h;
                } else {
                    jVar = j.this;
                    adData = null;
                }
                jVar.b(adData);
                j.this.i();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (this.b.j() == 3 && this.f9050a.j() == 3) {
            com.opos.cmn.an.f.a.b("mLoader", "bid between sync and cache");
            if (a(this.g) >= a(this.h)) {
                this.m.d(1);
                d();
                return true;
            }
            this.m.d(2);
            f();
            return true;
        }
        if (this.b.j() == 3) {
            this.m.a(1);
            d();
            return true;
        }
        if (this.f9050a.j() != 3) {
            this.m.d(4);
            return false;
        }
        this.m.a(2);
        f();
        return true;
    }

    @Override // com.opos.mobad.model.e.a
    public void a() {
        com.opos.mobad.model.e.g gVar = this.c;
        if (gVar != null) {
            gVar.h();
        } else {
            com.opos.cmn.an.f.a.b("mLoader", "load with target null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a0  */
    @Override // com.opos.mobad.model.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        com.opos.mobad.model.e.g gVar;
        com.opos.mobad.model.a.a aVar;
        this.k.a();
        if (j() == 6 && ((gVar = this.c) == (aVar = this.b) || gVar == (aVar = this.f9050a))) {
            aVar.c();
        }
        if (j() == 6 || j() == 7) {
            com.opos.mobad.model.e.g gVar2 = this.c;
            m mVar = this.b;
            if (gVar2 == mVar) {
                if ((this.f9050a.j() == 3 && this.f9050a.d()) || this.f9050a.j() == 6) {
                    this.f9050a.a(false);
                }
            } else if (gVar2 == this.f9050a) {
                if (mVar.j() != 7) {
                    if (this.b.j() == 3 || this.b.j() == 6) {
                        this.b.a(false);
                    } else {
                        this.f9050a.a(true);
                    }
                }
            }
            this.b.a(true);
        } else if (this.f9050a.j() != 3 && this.f9050a.j() != 6) {
            if (this.b.j() != 3 && this.b.j() != 6) {
                this.f9050a.f();
            }
        }
        c cVar = this.f9050a;
        if (cVar != null) {
            cVar.i();
        }
        m mVar2 = this.b;
        if (mVar2 != null) {
            mVar2.i();
        }
    }

    @Override // com.opos.mobad.model.e.a
    public void d(AdData adData) {
        String str;
        int iAc;
        com.opos.cmn.an.f.a.b("mLoader", "onLoadResourceSucc");
        if (adData == null || adData.f().size() <= 0 || adData.f().get(0) == null) {
            str = "";
            iAc = 0;
        } else {
            AdItemData adItemData = adData.f().get(0);
            String strC = adItemData.c();
            iAc = adItemData.ac();
            str = strC;
        }
        this.m.a(this.n, str, this.c == this.f9050a, this.d.i(), iAc, this.d.k(), this.d.j());
        super.d(adData);
        i();
    }

    @Override // com.opos.mobad.model.e.a
    public boolean b(AdData adData) {
        com.opos.cmn.an.f.a.b("mLoader", "onLoadFail");
        if (adData == null) {
            adData = new AdData(-1, "Unknown error. ");
        }
        this.m.a(this.n, adData.d(), adData.e(), this.c == this.f9050a, this.d.i(), this.d.k(), this.d.j());
        return super.b(adData);
    }
}
