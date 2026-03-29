package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements c {
    private HashMap<String, n> aQx = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.aQx.put(str, nVar);
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n fi(String str) {
        if (this.aQx.containsKey(str)) {
            return this.aQx.get(str);
        }
        return null;
    }
}
