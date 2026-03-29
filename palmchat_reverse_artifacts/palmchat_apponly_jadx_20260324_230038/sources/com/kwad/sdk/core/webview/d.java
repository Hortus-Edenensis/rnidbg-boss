package com.kwad.sdk.core.webview;

import com.kwad.sdk.core.webview.a.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    private long aRW;
    private boolean aRX;

    public static void d(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), aVar.pF());
        }
    }

    public final void a(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.pF());
        }
        if (aVar != null) {
            this.aRW = System.currentTimeMillis();
        }
    }

    public final void b(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.l(aVar.getAdTemplate(), System.currentTimeMillis() - this.aRW);
        }
    }

    public final void c(c.a aVar) {
        if (aVar == null || this.aRX) {
            return;
        }
        this.aRX = true;
        long jCurrentTimeMillis = 0;
        if (this.aRW > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.aRW;
            this.aRW = -1L;
        }
        com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.pF(), jCurrentTimeMillis);
    }
}
