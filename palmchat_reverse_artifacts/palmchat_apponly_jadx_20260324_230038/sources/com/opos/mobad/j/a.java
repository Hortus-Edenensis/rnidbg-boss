package com.opos.mobad.j;

import android.os.SystemClock;
import android.view.View;
import com.opos.mobad.ad.m;
import com.opos.mobad.cmn.func.a.a;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f8933a;
    private String b;
    private com.opos.mobad.cmn.func.adhandler.a c;
    private c.b d;
    private InterfaceC0748a e;
    private boolean f;
    private AdItemData g;
    private MaterialData h;
    private boolean i;
    private View k;
    private long l;
    private int m;
    private boolean n;
    private int o;
    private Map<String, String> q;
    private boolean j = false;
    private int p = 0;

    /* JADX INFO: renamed from: com.opos.mobad.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0748a extends m.b, a.b {
        void g_();
    }

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, c.b bVar2, InterfaceC0748a interfaceC0748a) {
        this.f8933a = bVar;
        this.b = str;
        this.c = aVar;
        this.d = bVar2;
        this.e = interfaceC0748a;
    }

    private void d() {
        if (this.h != null) {
            com.opos.mobad.service.e.c.a(this.f8933a.b(), this.h.m());
        } else {
            com.opos.cmn.an.f.a.c("AdPresenter", "close with null data");
        }
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.j.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f || a.this.e == null) {
                    return;
                }
                a.this.e.d();
            }
        });
    }

    public void c() {
        this.k = null;
        com.opos.mobad.cmn.service.pkginstall.c.a(this.f8933a.b()).a(this.d);
        this.f = true;
        com.opos.mobad.cmn.func.adhandler.a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        this.c = null;
    }

    public void a() {
        if (this.f) {
            return;
        }
        b.a(this.f8933a, this.g, this.m);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.j.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    a.this.e.g_();
                }
            }
        });
    }

    public void b() {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.j.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f || a.this.e == null) {
                    return;
                }
                a.this.e.d();
            }
        });
    }

    public void c(int i) {
        if (this.f) {
            return;
        }
        com.opos.mobad.b bVar = this.f8933a;
        String str = this.b;
        AdItemData adItemData = this.g;
        b.a(bVar, str, adItemData, this.m, "5", i, adItemData.a());
    }

    public void a(int i) {
        this.p = i;
    }

    public void b(int i) {
        if (this.f) {
            return;
        }
        com.opos.mobad.cmn.func.b.e.a(this.f8933a, this.b, this.g, this.h, i);
    }

    public void a(final int i, String str) {
        if (this.f) {
            return;
        }
        b.a(this.f8933a, this.b, this.g, this.m, "4", i, str);
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.j.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    a.this.e.a(-1, "render fail code:" + i);
                }
            }
        });
    }

    public void b(View view, Map<String, String> map) {
        if (this.f || this.j) {
            return;
        }
        b.b(this.f8933a, this.b, this.p, this.g, this.h, this.m, SystemClock.elapsedRealtime(), view, map);
        this.j = true;
    }

    public void a(View view, int i, boolean z) {
        if (this.f || this.f8933a == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("AdPresenter", "onViewMockEventIntercept->view:" + (view != null ? view.getClass().getName() : " unknown") + ";clickMockEvent:" + i + ";disAllowClick:" + z);
        this.k = null;
        b.a(this.f8933a.b(), this.b, String.valueOf(this.m), i, z);
        d();
    }

    public void b(boolean z, int[] iArr, long j) {
        if (this.f) {
            return;
        }
        this.k = null;
        HashMap map = new HashMap();
        map.put("progress", String.valueOf(j));
        b.b(this.f8933a, this.b, this.g, this.h, z, iArr, map);
        d();
    }

    public void a(View view, Map<String, String> map) {
        Runnable runnable;
        if (this.f) {
            runnable = new Runnable() { // from class: com.opos.mobad.j.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.a(10214, com.opos.mobad.ad.a.a(10214));
                    }
                }
            };
        } else if (this.i) {
            runnable = new Runnable() { // from class: com.opos.mobad.j.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.a(10215, com.opos.mobad.ad.a.a(10215));
                    }
                }
            };
        } else {
            this.q = map;
            this.k = view;
            this.i = true;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.l = jElapsedRealtime;
            b.a(this.f8933a, this.b, this.p, this.g, this.h, this.m, jElapsedRealtime, view, map);
            runnable = new Runnable() { // from class: com.opos.mobad.j.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.onAdShow(a.this.g.P());
                    }
                }
            };
        }
        com.opos.mobad.service.c.a(runnable);
    }

    public void a(View view, int[] iArr, com.opos.mobad.cmn.func.b.a aVar, final long j) {
        if (this.f) {
            return;
        }
        boolean zA = a(this.g.s(), SystemClock.elapsedRealtime());
        com.opos.mobad.cmn.func.adhandler.a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.a(this.g, zA, iArr, this.k, aVar, view, this.d, Integer.valueOf(this.o), Integer.valueOf(this.m), Boolean.valueOf(this.n), Long.valueOf(j), this.q);
            if (!this.n) {
                this.n = true;
            }
        }
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.j.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    a.this.e.onAdClick(j);
                }
            }
        });
    }

    public void a(AdItemData adItemData, MaterialData materialData, int i, int i2) {
        this.k = null;
        this.p = 0;
        this.g = adItemData;
        this.h = materialData;
        this.i = false;
        this.m = i;
        this.o = i2;
        this.q = null;
        com.opos.mobad.cmn.func.adhandler.a aVar = this.c;
        if (aVar != null) {
            aVar.b(adItemData);
            aVar.a(this.g);
        }
        this.n = false;
    }

    public void a(boolean z, int[] iArr, long j) {
        if (this.f) {
            return;
        }
        this.k = null;
        HashMap map = new HashMap();
        map.put("progress", String.valueOf(j));
        b.a(this.f8933a, this.b, this.g, this.h, z, iArr, map);
        d();
    }

    private boolean a(int i, long j) {
        boolean z = false;
        try {
            long j2 = this.l;
            if (j2 < j && j - j2 <= i * 60 * 1000) {
                z = true;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdPresenter", "", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("AdPresenter", "isValidClick=" + z);
        return z;
    }
}
