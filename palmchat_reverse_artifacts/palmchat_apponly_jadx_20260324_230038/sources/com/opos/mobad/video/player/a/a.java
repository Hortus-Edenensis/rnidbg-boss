package com.opos.mobad.video.player.a;

import com.opos.mobad.ad.g;
import com.opos.mobad.l.b;
import com.opos.mobad.l.c;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends com.opos.mobad.video.player.g.a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.mobad.l.a f10268a;
    private final b b;
    private boolean c = false;

    public a(com.opos.mobad.l.a aVar, b bVar) {
        this.f10268a = aVar;
        this.b = bVar;
    }

    @Override // com.opos.mobad.video.player.g.a, com.opos.mobad.ad.c.a
    public void a() {
        com.opos.cmn.an.f.a.b("ad_show", "onInstantExit()");
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.f();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onInstantExit()", e);
            }
        }
    }

    @Override // com.opos.mobad.j.d.a
    public void b() {
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.d();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onProcessStart fail", e);
            }
        }
    }

    @Override // com.opos.mobad.j.d.a
    public void c() {
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.e();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onProcessComplete fail", e);
            }
        }
    }

    @Override // com.opos.mobad.cmn.func.a.a.b
    public void d() {
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.c();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onClose fail", e);
            }
        }
    }

    @Override // com.opos.mobad.video.player.g.e
    public void e() {
        this.c = true;
    }

    @Override // com.opos.mobad.j.a.InterfaceC0748a
    public void g_() {
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.b();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onRenderSuccess fail", e);
            }
        }
    }

    @Override // com.opos.mobad.ad.m.b
    public void onAdClick(long j) {
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.a(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onAdClick fail", e);
            }
        }
    }

    @Override // com.opos.mobad.ad.m.b
    public void onAdShow(String str) {
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.a(str, this.b);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onAdShow fail", e);
            }
        }
    }

    @Override // com.opos.mobad.ad.k
    public void onReward(Object... objArr) {
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onReward fail", e);
            }
        }
    }

    @Override // com.opos.mobad.cmn.func.a.a.b
    public void a(int i, String str) {
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.a(i, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onShowFailed fail", e);
            }
        }
    }

    @Override // com.opos.mobad.j.d.a
    public void a(long j) {
        com.opos.cmn.an.f.a.b("ad_show", "onProcessClose currentPos=", Long.valueOf(j));
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.a(j, this.c ? false : true);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onProcessClose fail", e);
            }
        }
    }

    @Override // com.opos.mobad.video.player.g.e
    public void a(c cVar) {
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.a(cVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "getFallbackAd fail", e);
            }
        }
    }

    @Override // com.opos.mobad.j.d.a
    public void a(String str) {
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.a(str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onProcessError fail", e);
            }
        }
    }

    @Override // com.opos.mobad.ad.g
    public void a(Map<String, String> map) {
        com.opos.cmn.an.f.a.b("ad_show", "onDlClick info=", map);
        com.opos.mobad.l.a aVar = this.f10268a;
        if (aVar != null) {
            try {
                aVar.a(map);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onDlClick fail", e);
            }
        }
    }
}
