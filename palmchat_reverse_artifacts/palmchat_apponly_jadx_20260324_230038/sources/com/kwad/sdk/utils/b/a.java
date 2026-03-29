package com.kwad.sdk.utils.b;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public class a extends com.kwad.sdk.commercial.c.a {
    public int bhQ = -1;
    public int bhR = -1;
    public int bhS = -1;

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return "KvOperationRecord{putCount=" + this.bhQ + ", getFailedCount=" + this.bhR + ", getSuccessCount=" + this.bhS + '}';
    }
}
