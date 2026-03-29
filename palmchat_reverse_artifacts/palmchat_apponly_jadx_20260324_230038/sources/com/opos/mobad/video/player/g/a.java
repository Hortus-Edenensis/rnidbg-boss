package com.opos.mobad.video.player.g;

import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c.b f10358a;

    @Override // com.opos.mobad.ad.c.a
    public void a() {
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void b(AdItemData adItemData, String str) {
        c.b bVar = this.f10358a;
        if (bVar != null) {
            bVar.b(adItemData, str);
        }
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void c(AdItemData adItemData, String str) {
        c.b bVar = this.f10358a;
        if (bVar != null) {
            bVar.c(adItemData, str);
        }
    }

    @Override // com.opos.mobad.video.player.g.e
    public void a(c.b bVar) {
        this.f10358a = bVar;
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void a(AdItemData adItemData, String str) {
        c.b bVar = this.f10358a;
        if (bVar != null) {
            bVar.a(adItemData, str);
        }
    }
}
