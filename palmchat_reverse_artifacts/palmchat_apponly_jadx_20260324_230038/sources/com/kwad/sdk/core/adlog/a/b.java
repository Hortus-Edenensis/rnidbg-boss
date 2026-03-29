package com.kwad.sdk.core.adlog.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    private final c aBY;
    private final List<com.kwad.sdk.core.adlog.a.a> aBZ;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private static final b aCb = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b Gp() {
        return a.aCb;
    }

    @Nullable
    private synchronized com.kwad.sdk.core.adlog.a.a Gr() {
        if (ap.L(this.aBZ)) {
            return null;
        }
        return this.aBZ.remove(0);
    }

    private boolean Gt() {
        c cVar = this.aBY;
        return cVar == null || !cVar.aCc;
    }

    private boolean Gu() {
        c cVar = this.aBY;
        return cVar != null && cVar.aCg;
    }

    private static boolean d(com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        int i = aVar.aAV;
        return i == 1 || i == 2;
    }

    public final void Gq() {
        try {
            if (Gt() || ap.L(this.aBZ)) {
                return;
            }
            bw.runOnUiThread(new bg() { // from class: com.kwad.sdk.core.adlog.a.b.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.sdk.core.adlog.b.Gm();
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Nullable
    public final com.kwad.sdk.core.adlog.a.a Gs() {
        com.kwad.sdk.core.adlog.a.a aVarGr = Gr();
        if (aVarGr == null) {
            return null;
        }
        com.kwad.sdk.core.adlog.b.a.d(aVarGr, this.aBY, this.aBZ.size());
        long jCurrentTimeMillis = System.currentTimeMillis() - aVarGr.aBV;
        c cVar = this.aBY;
        if (!(jCurrentTimeMillis > cVar.aCe * 1000)) {
            aVarGr.retryCount++;
            com.kwad.sdk.core.adlog.b.a.a(aVarGr, cVar, this.aBZ.size(), jCurrentTimeMillis);
            com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache success：" + aVarGr);
            return aVarGr;
        }
        com.kwad.sdk.core.adlog.b.a.b(aVarGr, cVar, this.aBZ.size(), jCurrentTimeMillis);
        com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache fail expired cacheTime: " + jCurrentTimeMillis + ", adLogCache：" + aVarGr);
        return null;
    }

    public final void a(@Nullable com.kwad.sdk.core.adlog.a.a aVar, String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar2, int i, String str2) {
        try {
            if (Gt()) {
                return;
            }
            if (!Gu() || d(aVar2)) {
                if (aVar == null) {
                    if (aVar2 != null) {
                        a.C0601a c0601a = aVar2.GA() == null ? new a.C0601a() : aVar2.GA();
                        c0601a.aBs = 1;
                        aVar2.a(c0601a);
                        aa.putValue(jSONObject, "clientExtData", aVar2.PJ.toJson().toString());
                    }
                    aVar = com.kwad.sdk.core.adlog.a.a.Go().dz(str).j(jSONObject).c(aVar2).as(System.currentTimeMillis());
                }
                aVar.dc(i).dA(str2);
                com.kwad.sdk.core.adlog.b.a.a(aVar, this.aBY, this.aBZ.size());
                int i2 = aVar.retryCount;
                c cVar = this.aBY;
                if (i2 >= cVar.aCd) {
                    com.kwad.sdk.core.adlog.b.a.c(aVar, cVar, this.aBZ.size());
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache fail limit retryCount: " + aVar.retryCount + ", log: " + aVar);
                    return;
                }
                if (this.aBZ.size() >= this.aBY.aCf) {
                    com.kwad.sdk.core.adlog.a.a aVarGr = Gr();
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache limit size: " + this.aBZ.size() + ", remove log：" + aVarGr);
                    com.kwad.sdk.core.adlog.b.a.e(aVarGr, this.aBY, this.aBZ.size());
                }
                a(aVar);
                com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache success size: " + this.aBZ.size() + ", log: " + aVar);
                com.kwad.sdk.core.adlog.b.a.b(aVar, this.aBY, this.aBZ.size());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private b() {
        this.aBZ = new CopyOnWriteArrayList();
        this.aBY = (c) aa.b(((h) ServiceProvider.get(h.class)).DG(), new com.kwad.sdk.core.c<c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            private static c Gv() {
                return new c();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ com.kwad.sdk.core.b FU() {
                return Gv();
            }
        });
    }

    private synchronized void a(com.kwad.sdk.core.adlog.a.a aVar) {
        this.aBZ.add(aVar);
    }
}
