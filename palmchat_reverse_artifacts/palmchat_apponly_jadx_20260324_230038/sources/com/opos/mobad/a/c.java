package com.opos.mobad.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.d.e.a;
import com.opos.mobad.j.f;
import com.opos.mobad.model.utils.AdHelper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c extends f implements b {
    private Context f;
    private Activity g;
    private com.opos.mobad.ui.feedback.a h;
    private AdHelper.a i;
    private boolean j;
    private com.opos.mobad.ad.privacy.b k;
    private boolean l;
    private boolean m;
    private a n;
    private com.opos.mobad.a.a.b o;
    private boolean p;
    private boolean q;
    private com.opos.mobad.b r;
    private a.InterfaceC0735a s;
    private a.c t;

    public c(Activity activity, com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, com.opos.mobad.ui.feedback.a aVar2, com.opos.mobad.ad.privacy.b bVar2, c.b bVar3, a aVar3, com.opos.mobad.a.a.b bVar4) {
        super(bVar.c(), str, aVar, bVar3, aVar3);
        this.j = false;
        this.l = false;
        this.m = false;
        this.p = false;
        this.q = false;
        this.s = new a.InterfaceC0735a() { // from class: com.opos.mobad.a.c.2
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                a aVar4;
                int i;
                if (c.this.p) {
                    return;
                }
                if (z) {
                    if (!c.this.m) {
                        com.opos.cmn.an.f.a.b("InterBannerPresenter", "visible banner exp suc");
                        c cVar = c.this;
                        cVar.a(cVar.o.c(), (Map<String, String>) null);
                        c.this.p = true;
                        return;
                    }
                    if (c.this.n == null) {
                        return;
                    }
                    com.opos.cmn.an.f.a.b("InterBannerPresenter", "visible banner exp fail");
                    aVar4 = c.this.n;
                    i = 10214;
                } else {
                    if (c.this.n == null) {
                        return;
                    }
                    com.opos.cmn.an.f.a.b("InterBannerPresenter", "invisible banner exp fail");
                    aVar4 = c.this.n;
                    i = 10213;
                }
                aVar4.a(i, com.opos.mobad.ad.a.a(i));
            }
        };
        this.t = new a.c() { // from class: com.opos.mobad.a.c.3
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                com.opos.cmn.an.f.a.b("InterBannerPresenter", "visible banner expFocus suc " + c.this.q + ", " + c.this.m);
                if (c.this.q || c.this.m) {
                    return;
                }
                HashMap map = new HashMap();
                map.put("isVisibleRect", String.valueOf(z));
                map.put("isAttached", String.valueOf(z2));
                c cVar = c.this;
                cVar.a(cVar.o.c(), map);
                c.this.q = true;
            }
        };
        this.r = bVar;
        this.g = activity;
        this.f = activity.getApplicationContext();
        this.k = bVar2;
        this.h = aVar2;
        aVar2.a(new com.opos.mobad.ui.feedback.b() { // from class: com.opos.mobad.a.c.1
            @Override // com.opos.mobad.ui.feedback.b
            public void a(int i) {
                ((f) c.this).f8949a.b(i);
                c.this.j = i == com.opos.mobad.ui.feedback.a.a.TAG_BLOCK_CONTENT.a() || i == com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_COMPLAINT.a();
                c.this.o.a(com.opos.mobad.model.a.a(c.this.f, c.this.r, c.this.i, c.this.l, c.this.j, c.this.o.e()));
                if (c.this.j) {
                    return;
                }
                c cVar = c.this;
                cVar.e(cVar.a(), null);
            }

            @Override // com.opos.mobad.ui.feedback.b
            public void a(boolean z) {
                if (z) {
                    c.this.j = false;
                    c.this.o.a(com.opos.mobad.model.a.a(c.this.f, c.this.r, c.this.i, c.this.l, c.this.j, c.this.o.e()));
                }
            }
        });
        this.n = aVar3;
        this.o = bVar4;
    }

    public View a() {
        com.opos.mobad.a.a.b bVar = this.o;
        if (bVar == null) {
            return null;
        }
        return bVar.c();
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void e(View view, int[] iArr) {
        if (this.m) {
            return;
        }
        super.e(view, iArr);
    }

    @Override // com.opos.mobad.j.f
    public void b() {
        this.m = true;
        this.g = null;
        this.p = false;
        com.opos.mobad.a.a.b bVar = this.o;
        if (bVar != null) {
            bVar.d();
        }
        com.opos.mobad.ad.privacy.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a();
        }
        super.b();
    }

    public void c() {
        com.opos.mobad.a.a.b bVar;
        if (this.m || (bVar = this.o) == null) {
            return;
        }
        this.l = true;
        bVar.a(com.opos.mobad.model.a.a(this.f, this.r, this.i, true, this.j, bVar.e()));
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void d(View view, int[] iArr) {
        if (this.m) {
            return;
        }
        this.k.a(this.g, 2, com.opos.mobad.cmn.func.b.a(this.i.c), null);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(View view, int[] iArr) {
        if (this.m) {
            return;
        }
        this.h.a(view);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void b(View view, int[] iArr) {
        if (this.m) {
            return;
        }
        this.k.a(this.g, 0, com.opos.mobad.cmn.func.b.a(this.i.c), null);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void c(View view, int[] iArr) {
        if (this.m) {
            return;
        }
        this.k.a(this.g, 1, com.opos.mobad.cmn.func.b.a(this.i.c), null);
    }

    public void a(AdHelper.a aVar, com.opos.mobad.template.a aVar2, String str) {
        if (aVar2 == null || aVar == null) {
            com.opos.cmn.an.f.a.b("InterBannerPresenter", "render fail null data or template = " + aVar2);
            a(1);
            return;
        }
        this.i = aVar;
        a(aVar.c, aVar.d, aVar2.e(), str);
        this.j = aVar.d.W();
        this.o.a(aVar2);
        this.o.a(this);
        com.opos.cmn.an.f.a.b("InterBannerPresenter", "show:" + aVar);
        com.opos.mobad.a.a.b bVar = this.o;
        bVar.a(com.opos.mobad.model.a.a(this.f, this.r, aVar, this.l, this.j, bVar.e()));
        if (this.o.c() instanceof com.opos.mobad.d.e.a) {
            com.opos.mobad.d.e.a aVar3 = (com.opos.mobad.d.e.a) this.o.c();
            aVar3.a(this.s);
            aVar3.a(this.t, aVar3);
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(Map<String, String> map) {
    }

    @Override // com.opos.mobad.a.b
    public void a(boolean z) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.a(z);
        }
    }
}
