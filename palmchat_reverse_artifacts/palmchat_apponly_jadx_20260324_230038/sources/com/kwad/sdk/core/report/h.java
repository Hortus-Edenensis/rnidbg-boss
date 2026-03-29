package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public class h extends com.kwad.sdk.core.response.a.a {
    public int aLn;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static h cn(AdTemplate adTemplate) {
        h hVar = new h();
        hVar.creativeId = com.kwad.sdk.core.response.b.e.eB(adTemplate);
        hVar.llsid = com.kwad.sdk.core.response.b.e.eo(adTemplate);
        int iEF = com.kwad.sdk.core.response.b.e.eF(adTemplate);
        hVar.score = iEF;
        hVar.aLn = iEF > 0 ? 1 : 0;
        return hVar;
    }

    public final String Km() {
        return toJson().toString();
    }
}
