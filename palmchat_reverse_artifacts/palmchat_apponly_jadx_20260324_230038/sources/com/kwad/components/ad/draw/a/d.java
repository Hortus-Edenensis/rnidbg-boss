package com.kwad.components.ad.draw.a;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@KsJson
public class d extends com.kwad.sdk.commercial.c.a {
    public long dy;
    public int materialType;
    public String materialUrl;
    public int status;

    public static d aM() {
        return new d();
    }

    public final d h(long j) {
        this.dy = j;
        return this;
    }

    public final d q(String str) {
        this.materialUrl = str;
        return this;
    }

    public final d y(int i) {
        this.status = i;
        return this;
    }

    public final d z(int i) {
        this.materialType = i;
        return this;
    }
}
