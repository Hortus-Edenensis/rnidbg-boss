package com.kwad.components.core.webview.tachikoma;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private a aiM;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void eO();
    }

    public b(a aVar) {
        this.aiM = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.aiM;
        if (aVar != null) {
            aVar.eO();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
