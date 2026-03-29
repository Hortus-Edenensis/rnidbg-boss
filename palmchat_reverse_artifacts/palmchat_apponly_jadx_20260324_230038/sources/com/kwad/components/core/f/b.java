package com.kwad.components.core.f;

import android.content.Context;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements e {
    @Override // com.kwad.sdk.core.a.e
    public final String av(String str) {
        return d.av(str);
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return e.class;
    }

    @Override // com.kwad.sdk.core.a.e
    public final String getResponseData(String str) {
        return d.getResponseData(str);
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return -200;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
