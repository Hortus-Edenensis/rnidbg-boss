package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private int GJ;
    private com.kwad.sdk.core.webview.c.c agg;

    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int loadType;
    }

    public h(int i) {
        this.GJ = i;
    }

    private void bw(int i) {
        if (this.agg == null) {
            return;
        }
        a aVar = new a();
        aVar.loadType = i;
        this.agg.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.agg = cVar;
        bw(this.GJ);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getLoadInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agg = null;
    }
}
