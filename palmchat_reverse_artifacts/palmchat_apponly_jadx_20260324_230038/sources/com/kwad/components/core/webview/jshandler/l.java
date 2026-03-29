package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.ksad.json.annotation.KsJson;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class l implements com.kwad.sdk.core.webview.c.a {

    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String data;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        aVar.data = UUID.randomUUID().toString();
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return Constant.MAP_KEY_UUID;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
