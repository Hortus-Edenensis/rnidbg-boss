package com.opos.mobad.g;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.opos.mobad.ad.d.e;
import com.opos.mobad.ad.g;
import com.opos.mobad.l.a;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.utils.AdHelper;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8913a;
    private com.opos.mobad.video.player.d b;
    private AdHelper.AdHelperData c;
    private com.opos.mobad.video.player.b.c d;
    private com.opos.mobad.l.b e;
    private com.opos.mobad.j.a f;
    private int g;
    private Bundle h;
    private final a.AbstractBinderC0751a i = new a.AbstractBinderC0751a() { // from class: com.opos.mobad.g.e.1
        @Override // com.opos.mobad.l.a
        public void a() {
        }

        @Override // com.opos.mobad.l.a
        public void b() {
            if (e.this.d != null) {
                e.this.d.g_();
            }
        }

        @Override // com.opos.mobad.l.a
        public void c() {
            e.this.e = null;
            if (e.this.d != null) {
                e.this.d.d();
            }
        }

        @Override // com.opos.mobad.l.a
        public void f() throws RemoteException {
            if (e.this.d instanceof com.opos.mobad.ad.c.a) {
                ((com.opos.mobad.ad.c.a) e.this.d).a();
            }
        }

        @Override // com.opos.mobad.l.a
        public void a(int i, String str) {
            if (e.this.d != null) {
                e.this.d.a(i, str);
            }
        }

        @Override // com.opos.mobad.l.a
        public void a(long j) {
            if (e.this.d != null) {
                e.this.d.onAdClick(j);
            }
        }

        @Override // com.opos.mobad.l.a
        public void a(long j, boolean z) throws RemoteException {
            e.this.e = null;
        }

        @Override // com.opos.mobad.l.a
        public void a(com.opos.mobad.l.c cVar) throws RemoteException {
        }

        @Override // com.opos.mobad.l.a
        public void a(String str) {
            if (e.this.d != null) {
                e.this.d.a(-1, str);
            }
        }

        @Override // com.opos.mobad.l.a
        public void a(String str, com.opos.mobad.l.b bVar) {
            e.this.e = bVar;
            if (e.this.d != null) {
                e.this.d.onAdShow(str);
            }
        }

        @Override // com.opos.mobad.l.a
        public void a(Map map) throws RemoteException {
            if (e.this.d instanceof g) {
                ((g) e.this.d).a(map);
            }
        }

        @Override // com.opos.mobad.l.a
        public void d() {
        }

        @Override // com.opos.mobad.l.a
        public void e() {
        }
    };

    public e(com.opos.mobad.b bVar, String str, com.opos.mobad.video.player.d dVar, com.opos.mobad.cmn.func.adhandler.a aVar, com.opos.mobad.video.player.b.c cVar, AdHelper.AdHelperData adHelperData, int i, Bundle bundle) {
        com.opos.mobad.j.a aVar2 = new com.opos.mobad.j.a(bVar, str, aVar, null, cVar);
        this.f = aVar2;
        this.b = dVar;
        this.d = cVar;
        this.f8913a = str;
        this.c = adHelperData;
        this.g = i;
        this.h = bundle;
        AdItemData adItemData = adHelperData.c;
        MaterialData materialData = adHelperData.d;
        aVar2.a(adItemData, materialData, materialData.b(), 0);
    }

    private int b() {
        Bundle bundle = this.h;
        return (bundle == null || bundle.getInt("interstitial_scene") != e.b.INSTANT_EXIT.ordinal()) ? 2 : 4;
    }

    @Override // com.opos.mobad.g.a
    public void a() {
        com.opos.mobad.l.b bVar = this.e;
        if (bVar != null) {
            try {
                bVar.a();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("InterstitialStarter", "close fail", e);
            }
        }
        com.opos.mobad.j.a aVar = this.f;
        if (aVar != null) {
            aVar.c();
        }
        this.e = null;
    }

    @Override // com.opos.mobad.g.a
    public boolean a(Activity activity, String str) {
        com.opos.mobad.j.a aVar;
        int i;
        if (activity == null) {
            com.opos.cmn.an.f.a.b("InterstitialStarter", "null activity");
            aVar = this.f;
            i = -1;
        } else {
            AdHelper.AdHelperData adHelperData = this.c;
            if (adHelperData == null || adHelperData.c == null) {
                com.opos.cmn.an.f.a.b("InterstitialStarter", "null data");
                aVar = this.f;
                i = 10006;
            } else {
                if (System.currentTimeMillis() <= this.c.c.u()) {
                    this.e = null;
                    if (!this.b.a(activity, this.c, this.g, b(), this.i)) {
                        return false;
                    }
                    com.opos.cmn.an.f.a.b("InterstitialStarter", "do show as activity");
                    return true;
                }
                com.opos.cmn.an.f.a.b("InterstitialStarter", "exp time");
                aVar = this.f;
                i = 10003;
            }
        }
        aVar.a(i, str);
        return false;
    }
}
