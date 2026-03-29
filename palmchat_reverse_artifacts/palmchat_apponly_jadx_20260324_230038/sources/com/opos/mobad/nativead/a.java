package com.opos.mobad.nativead;

import android.view.View;
import com.opos.mobad.cmn.func.adhandler.a;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements com.opos.mobad.model.d.a {
    private static final String h = com.opos.cmn.an.b.b.a("b3Bwb191bmlvbl90b2tlbj0=");
    private static Map<String, Long> j = new ConcurrentHashMap();
    private static Map<String, Long> k = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.opos.mobad.b f9118a;
    protected String b;
    protected boolean c;
    protected com.opos.mobad.cmn.func.adhandler.a f;
    protected a.c g;
    private long i = com.igexin.push.config.c.j;
    protected long d = 0;
    protected long e = 0;

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.cmn.func.adhandler.f fVar) {
        this.f9118a = bVar;
        this.b = str;
        this.f = new com.opos.mobad.cmn.func.adhandler.a(bVar, str, aVar, fVar);
        a.c cVarA = g.a(bVar.b(), (View) null);
        this.g = cVarA;
        this.f.a(cVarA);
    }

    public int a(int i) {
        return 0;
    }

    public String b(int i) {
        return i != 10008 ? i != 11001 ? i != 11003 ? i != 11005 ? "" : "ads must display on android version after19" : "you request ad too often." : "ad has destroyed." : "ad has showed, please reload ad";
    }

    public void a(View view, AdItemData adItemData, boolean z, Map<String, String> map) {
        if (adItemData != null) {
            try {
                MaterialData materialData = adItemData.i().get(0);
                if (materialData != null) {
                    this.f.a(adItemData);
                    com.opos.mobad.cmn.func.b.e.a(this.f9118a, view, this.b, adItemData, materialData, z, map);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterBaseAd", "", (Throwable) e);
            }
        }
    }

    public void a(AdItemData adItemData) {
        if (adItemData != null) {
            try {
                MaterialData materialData = adItemData.i().get(0);
                if (materialData == null || materialData.l() == null || materialData.l().size() <= 0) {
                    return;
                }
                com.opos.mobad.service.e.c.a(this.f9118a.b(), materialData.l());
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterBaseAd", "", (Throwable) e);
            }
        }
    }
}
