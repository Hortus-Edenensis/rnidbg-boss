package com.opos.mobad.video.player.g;

import com.opos.mobad.ad.g;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.data.AdItemData;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements g, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f10359a;
    private boolean b = false;
    private boolean c = false;

    public b(e eVar) {
        this.f10359a = eVar;
    }

    @Override // com.opos.mobad.ad.c.a
    public void a() {
        e eVar = this.f10359a;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.opos.mobad.j.d.a
    public void b() {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.b();
    }

    @Override // com.opos.mobad.j.d.a
    public void c() {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.c();
    }

    @Override // com.opos.mobad.cmn.func.a.a.b
    public void d() {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        if (this.c) {
            com.opos.cmn.an.f.a.b("AbsRewardVideoProxyListenerDecorator", "has ad close");
        } else {
            this.c = true;
            eVar.d();
        }
    }

    @Override // com.opos.mobad.video.player.g.e
    public void e() {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.e();
    }

    @Override // com.opos.mobad.j.a.InterfaceC0748a
    public void g_() {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.g_();
    }

    @Override // com.opos.mobad.ad.m.b
    public void onAdClick(long j) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.onAdClick(j);
    }

    @Override // com.opos.mobad.ad.m.b
    public void onAdShow(String str) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.onAdShow(str);
    }

    @Override // com.opos.mobad.ad.k
    public void onReward(Object... objArr) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.onReward(objArr);
    }

    @Override // com.opos.mobad.cmn.func.a.a.b
    public void a(int i, String str) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.a(i, str);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void b(AdItemData adItemData, String str) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.b(adItemData, str);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void c(AdItemData adItemData, String str) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.c(adItemData, str);
    }

    @Override // com.opos.mobad.j.d.a
    public void a(long j) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        if (this.b) {
            com.opos.cmn.an.f.a.b("AbsRewardVideoProxyListenerDecorator", "has process close");
        } else {
            this.b = true;
            eVar.a(j);
        }
    }

    @Override // com.opos.mobad.video.player.g.e
    public void a(c.b bVar) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.a(bVar);
    }

    @Override // com.opos.mobad.video.player.g.e
    public void a(com.opos.mobad.l.c cVar) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.a(cVar);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void a(AdItemData adItemData, String str) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.a(adItemData, str);
    }

    @Override // com.opos.mobad.j.d.a
    public void a(String str) {
        e eVar = this.f10359a;
        if (eVar == null) {
            return;
        }
        eVar.a(str);
    }

    @Override // com.opos.mobad.ad.g
    public void a(Map<String, String> map) {
        e eVar = this.f10359a;
        if (eVar instanceof g) {
            ((g) eVar).a(map);
        }
    }
}
