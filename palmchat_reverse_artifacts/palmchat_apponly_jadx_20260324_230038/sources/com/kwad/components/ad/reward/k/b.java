package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b implements com.kwad.sdk.core.webview.c.a {
    private a AU;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        ki();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "callButtonImpressionWhenFinish";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.AU = null;
    }

    public void ki() {
    }
}
