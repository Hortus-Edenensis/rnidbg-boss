package com.opos.mobad.video.player.e.a;

import android.os.SystemClock;
import android.view.View;
import com.opos.mobad.d.c.c;
import com.opos.mobad.d.e.a;
import com.opos.mobad.j.e;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.template.d.f;
import com.opos.mobad.video.player.e.d;
import com.opos.mobad.video.player.f.b;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends com.opos.mobad.video.player.e.a {
    private com.opos.mobad.d.e.a p;
    private b q;
    private boolean r;
    private boolean s;
    private long t;
    private long u;

    public a(d dVar) {
        super(dVar);
        this.r = false;
        this.s = false;
        this.u = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.opos.mobad.video.player.f.a.b bVar) {
        if (this.r) {
            e eVar = this.c;
            if (eVar == null || !eVar.d()) {
                com.opos.cmn.an.f.a.b("RewardVideoAdShowController", "onLoadErrorInner()", "rsData=", bVar);
                c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.a.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ((com.opos.mobad.video.player.e.a) a.this).k.i("EXT_PARAM_KEY_GAME_DES", "加载失败");
                        if (((com.opos.mobad.video.player.e.a) a.this).j != null) {
                            com.opos.mobad.video.player.g.d.a(((com.opos.mobad.video.player.e.a) a.this).j.f10325a, ((com.opos.mobad.video.player.e.a) a.this).k);
                            com.opos.mobad.video.player.g.d.e(((com.opos.mobad.video.player.e.a) a.this).j.f10325a);
                        }
                        a.this.a(bVar);
                    }
                });
            }
        }
    }

    private void d(AdItemData adItemData, MaterialData materialData) {
        com.opos.mobad.video.player.e.b bVar = this.j;
        if (bVar != null && bVar.f10325a != null) {
            com.opos.mobad.video.player.g.d.f(bVar.b);
            c(adItemData, materialData);
            this.j.f10325a.a(this);
            this.k.i("EXT_PARAM_KEY_GAME_LOADING", String.valueOf(0));
            this.k.i("EXT_PARAM_KEY_GAME_DES", "正在开启试玩");
            com.opos.mobad.video.player.g.d.a(this.j.f10325a, this.k);
            com.opos.mobad.video.player.g.d.e(this.j.f10325a);
        }
        if (this.q == null) {
            b.a aVar = new b.a();
            aVar.f10355a = ((com.opos.mobad.video.player.e.a) this).g;
            aVar.b = ((com.opos.mobad.video.player.e.a) this).f;
            if (adItemData != null) {
                aVar.c = adItemData.g();
                aVar.d = adItemData.Q();
            }
            this.q = new b(aVar);
        }
        b.c cVar = new b.c();
        cVar.f10356a = adItemData;
        cVar.b = materialData;
        cVar.c = new b.InterfaceC0818b() { // from class: com.opos.mobad.video.player.e.a.a.1
            @Override // com.opos.mobad.video.player.f.b.InterfaceC0818b
            public void a(com.opos.mobad.video.player.f.a.a aVar2) {
                if (aVar2 == null || a.this.l()) {
                    return;
                }
                a.this.d(aVar2.f10345a, aVar2.b);
            }

            @Override // com.opos.mobad.video.player.f.b.InterfaceC0818b
            public void b(com.opos.mobad.video.player.f.a.a aVar2) {
                if (aVar2 == null || a.this.l()) {
                    return;
                }
                a.this.a(aVar2.f10345a, aVar2.b);
            }

            @Override // com.opos.mobad.video.player.f.b.InterfaceC0818b
            public void a(com.opos.mobad.video.player.f.a.b bVar2) {
                a.this.c(bVar2);
                a.this.u = SystemClock.elapsedRealtime() - a.this.t;
            }
        };
        this.q.a(cVar);
        this.r = true;
    }

    private boolean v() {
        com.opos.mobad.video.player.e.b bVar = this.j;
        if (bVar != null) {
            return com.opos.mobad.video.player.g.d.d(bVar.f10325a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.opos.cmn.an.f.a.b("RewardVideoAdShowController", "fallbackToEndPage()");
        if (this.j == null || l() || o()) {
            return;
        }
        com.opos.mobad.video.player.g.d.f(this.j.f10325a);
        com.opos.mobad.video.player.g.d.b(this.j.f10325a);
        com.opos.mobad.video.player.g.d.f(this.j.b);
        com.opos.mobad.video.player.g.d.b(this.j.b);
        b bVar = this.q;
        if (bVar != null) {
            bVar.d();
        }
        com.opos.mobad.d.e.a aVar = this.p;
        if (aVar != null) {
            aVar.a((a.InterfaceC0735a) null);
        }
        com.opos.mobad.template.a aVarN = n();
        if (aVarN == null) {
            com.opos.cmn.an.f.a.b("RewardVideoAdShowController", "fallbackToEndPage() but endpageTemplate is empty");
            return;
        }
        this.c.h();
        q();
        com.opos.mobad.video.player.g.d.a(aVarN, m());
        com.opos.mobad.video.player.g.d.e(aVarN);
        p();
    }

    @Override // com.opos.mobad.video.player.e.a, com.opos.mobad.j.f
    public void b() {
        super.b();
        try {
            b bVar = this.q;
            if (bVar != null) {
                bVar.e();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RewardVideoAdShowController", "destroy() fail", e);
        }
        try {
            com.opos.mobad.d.e.a aVar = this.p;
            if (aVar != null) {
                aVar.a((a.InterfaceC0735a) null);
                this.p.removeAllViews();
                this.p = null;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("RewardVideoAdShowController", "destroy() fail", e2);
        }
    }

    @Override // com.opos.mobad.video.player.e.a
    public void k() {
        boolean zA = com.opos.mobad.model.utils.e.a(this.h, this.i);
        com.opos.cmn.an.f.a.b("RewardVideoAdShowController", "showEndPage()", "isTrialGame=", Boolean.valueOf(zA));
        if (zA) {
            w();
        } else {
            super.k();
        }
    }

    @Override // com.opos.mobad.video.player.e.a
    public f m() {
        MaterialFileData materialFileData;
        if (!com.opos.mobad.model.utils.e.a(this.h, this.i)) {
            return this.k;
        }
        f fVar = this.k;
        c(this.h, this.i);
        MaterialData materialData = this.i;
        if (materialData != null && materialData.R() == null) {
            fVar.l(this.i.f());
            fVar.k(this.i.g());
            fVar.j(com.opos.mobad.model.a.a(t(), this.h, this.i, this.l));
            List<MaterialFileData> listE = this.i.e();
            if (listE != null && !listE.isEmpty()) {
                for (MaterialFileData materialFileData2 : listE) {
                    if (materialFileData2 != null) {
                        fVar.b(materialFileData2.a(), materialFileData2.b());
                    }
                }
            }
            List<MaterialFileData> listH = this.i.h();
            if (listH != null && !listH.isEmpty() && (materialFileData = listH.get(0)) != null) {
                this.k.h(materialFileData.a(), materialFileData.b());
            }
        }
        return fVar;
    }

    @Override // com.opos.mobad.video.player.e.a
    public void r() {
        if (this.m || this.n) {
            com.opos.cmn.an.f.a.b("RewardVideoAdShowController", "startAdTemplate() but ad has completed or has stopped.");
            return;
        }
        b bVar = this.q;
        if (bVar != null) {
            bVar.b();
        }
        super.r();
    }

    @Override // com.opos.mobad.video.player.e.a
    public void s() {
        b bVar = this.q;
        if (bVar != null) {
            bVar.c();
        }
        super.s();
    }

    @Override // com.opos.mobad.video.player.e.a
    public void b(View view, int[] iArr, boolean z) {
        b bVar = this.q;
        if (bVar != null) {
            bVar.d();
        }
        super.b(view, iArr, z);
    }

    @Override // com.opos.mobad.video.player.e.a
    public void c(int[] iArr) {
        if (v()) {
            d(iArr);
        } else {
            super.c(iArr);
        }
    }

    @Override // com.opos.mobad.j.f
    public void a(View view, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.r) {
            map.put("trialGameLoadCost", String.valueOf(this.u));
        }
        super.a(view, map);
    }

    @Override // com.opos.mobad.video.player.e.a
    public void b(AdItemData adItemData, MaterialData materialData) {
        this.t = SystemClock.elapsedRealtime();
        this.r = false;
        this.s = false;
        boolean zA = com.opos.mobad.model.utils.e.a(adItemData, materialData);
        com.opos.cmn.an.f.a.b("RewardVideoAdShowController", "doShowInner()", "isTrialGame=", Boolean.valueOf(zA));
        if (!zA) {
            super.b(adItemData, materialData);
            return;
        }
        try {
            d(adItemData, materialData);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RewardVideoAdShowController", "doShowInner() fail", e);
            a(new com.opos.mobad.video.player.f.a.b(10418, com.opos.mobad.ad.a.a(10418) + e.getMessage()));
        }
    }

    @Override // com.opos.mobad.video.player.e.a, com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void a(View view, int[] iArr, boolean z) {
        com.opos.cmn.an.f.a.b("RewardVideoAdShowController", "onSoundClick()", "before preSoundOn=", Boolean.valueOf(z));
        b bVar = this.q;
        if (bVar != null) {
            z = !bVar.a();
        }
        com.opos.cmn.an.f.a.b("RewardVideoAdShowController", "onSoundClick()", "after preSoundOn=", Boolean.valueOf(z));
        super.a(view, iArr, z);
        b bVar2 = this.q;
        if (bVar2 != null) {
            bVar2.a(!z);
        }
    }

    private void b(com.opos.mobad.video.player.f.a.b bVar) {
        int i;
        String str;
        Map<String, String> map = new HashMap<>();
        b bVar2 = this.q;
        if (bVar2 != null) {
            map = bVar2.f();
        }
        if (bVar != null) {
            i = bVar.f10346a;
            str = bVar.b;
        } else {
            i = -1;
            str = "Unknown error. ";
        }
        map.put("errCode", String.valueOf(i));
        map.put(WifiNestConst.OtherConst.KEY_MSG, str);
        b(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.video.player.f.a.b bVar) {
        e eVar = this.c;
        if (eVar == null || !eVar.d()) {
            c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.w();
                }
            }, 500L);
            b(bVar);
        }
    }

    @Override // com.opos.mobad.video.player.e.a, com.opos.mobad.template.a.InterfaceC0778a
    public void a(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.r) {
            map.put("trialGameLoadCost", String.valueOf(this.u));
        }
        super.a(map);
    }

    @Override // com.opos.mobad.video.player.e.a
    public void a(boolean z) {
        super.a(z);
        b bVar = this.q;
        if (bVar != null) {
            bVar.a(z);
        }
    }
}
