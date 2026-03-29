package com.opos.mobad.cmn.func.adhandler;

import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c implements c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c.b f8673a;
    private com.opos.mobad.b b;
    private e c;

    public c(com.opos.mobad.b bVar, e eVar, c.b bVar2) {
        this.b = bVar;
        this.c = eVar;
        this.f8673a = bVar2;
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void a(AdItemData adItemData, String str) {
        com.opos.cmn.an.f.a.b("DownloaderPkgInstallListenerWrapper", "notifyInstallCompletedEvent pkgName = " + str);
        c.b bVar = this.f8673a;
        if (bVar != null) {
            bVar.a(adItemData, str);
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.a(200, "");
        }
        this.b.l().c(str);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void b(AdItemData adItemData, String str) {
        c.b bVar = this.f8673a;
        if (bVar != null) {
            bVar.b(adItemData, str);
        }
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void c(AdItemData adItemData, String str) {
        c.b bVar = this.f8673a;
        if (bVar != null) {
            bVar.c(adItemData, str);
        }
    }
}
