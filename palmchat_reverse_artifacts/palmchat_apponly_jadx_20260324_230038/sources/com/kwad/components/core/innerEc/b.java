package com.kwad.components.core.innerEc;

import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b extends com.kwad.sdk.core.network.d {
    public b(String str, String str2) {
        g gVarKH = g.KH();
        gVarKH.eL(str);
        gVarKH.eN(str2);
        putBody("userInfo", gVarKH);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.CG();
    }
}
