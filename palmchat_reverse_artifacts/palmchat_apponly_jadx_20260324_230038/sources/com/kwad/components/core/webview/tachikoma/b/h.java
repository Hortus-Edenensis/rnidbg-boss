package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h extends w {
    private a aku;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(h hVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int akv;
    }

    public final void a(a aVar) {
        this.aku = aVar;
    }

    public final void bc(boolean z) {
        int i = z ? 1 : 2;
        b bVar = new b();
        bVar.akv = i;
        b(bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getPlayEndType";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        this.aku = null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        a aVar = this.aku;
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
