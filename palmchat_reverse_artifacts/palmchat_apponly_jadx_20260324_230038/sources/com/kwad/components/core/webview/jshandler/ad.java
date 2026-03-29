package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ad implements com.kwad.sdk.core.webview.c.a {
    private a agV;
    private final com.kwad.sdk.core.webview.b ags;
    private Handler iK = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void cJ();
    }

    public ad(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.ags = bVar;
        this.agV = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.iK.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.iK.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ad.this.agV.cJ();
            }
        });
        cVar.a(null);
    }
}
