package com.kwad.sdk.commercial.e;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public class c extends com.kwad.sdk.commercial.c.a {
    public String aAH;
    public String aAI;

    public static c FM() {
        return new c();
    }

    public final c db(String str) {
        this.aAH = str;
        return this;
    }

    public final c dc(String str) {
        this.aAI = str;
        return this;
    }
}
