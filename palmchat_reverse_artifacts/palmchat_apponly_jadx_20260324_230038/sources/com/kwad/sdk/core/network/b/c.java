package com.kwad.sdk.core.network.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static b JO() {
        h hVar = (h) ServiceProvider.get(h.class);
        return (hVar == null || !hVar.Do()) ? new a() : new d();
    }
}
