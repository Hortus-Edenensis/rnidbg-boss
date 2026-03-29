package com.kwad.components.core.webview.jshandler.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.kwad.components.core.webview.jshandler.e {

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jshandler.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class C0564a extends com.kwad.sdk.core.response.a.a {
        public String aiE;
    }

    @Override // com.kwad.components.core.webview.jshandler.e
    public final String be(String str) {
        try {
            C0564a c0564a = new C0564a();
            c0564a.parseJson(new JSONObject(str));
            return c0564a.aiE;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.e, com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "checkAppInstalled";
    }
}
