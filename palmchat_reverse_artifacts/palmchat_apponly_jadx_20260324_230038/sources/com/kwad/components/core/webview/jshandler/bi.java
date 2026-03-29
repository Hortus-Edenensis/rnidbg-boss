package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class bi implements com.kwad.sdk.core.webview.c.a {
    private final a aiv;
    private com.kwad.sdk.core.webview.c.c qm;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void sw();
    }

    public bi(a aVar) {
        this.aiv = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.qm = cVar;
        a aVar = this.aiv;
        if (aVar != null) {
            aVar.sw();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "unregisterBackClickListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qm = null;
    }
}
