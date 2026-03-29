package com.opos.mobad.video.player.h.b;

import android.app.Activity;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.template.a;
import com.opos.mobad.template.h.v;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {
    private static volatile c b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.mobad.d.a f10376a = new com.opos.mobad.downloader.a();

    private c() {
    }

    public com.opos.mobad.template.a a(Activity activity, MaterialData materialData, a.InterfaceC0778a interfaceC0778a) {
        v vVarB = a(materialData) ? v.b(activity, this.f10376a, -10009) : v.a(activity, this.f10376a, -10010);
        vVarB.a(interfaceC0778a);
        return vVarB;
    }

    public static c a() {
        c cVar = b;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = b;
        if (cVar2 != null) {
            return cVar2;
        }
        c cVar3 = new c();
        b = cVar3;
        return cVar3;
    }

    private boolean a(MaterialData materialData) {
        if (materialData == null) {
            return false;
        }
        int iB = materialData.b();
        com.opos.cmn.an.f.a.b("LoadingTemplateFactory", "isPortrait()", "templateId=", Integer.valueOf(iB));
        return iB == 2158;
    }
}
