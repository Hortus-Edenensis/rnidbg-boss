package com.kwad.components.ad.j;

import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d implements h.a {
    private static volatile d Mo;

    private d() {
    }

    public static d nR() {
        if (Mo == null) {
            synchronized (d.class) {
                if (Mo == null) {
                    Mo = new d();
                }
            }
        }
        return Mo;
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i) {
        SceneImpl scene;
        if (!(fVar instanceof com.kwad.components.core.request.a) || i == e.aJc.errorCode || (scene = fVar.getScene()) == null) {
            return;
        }
        com.kwad.components.core.o.a.tz().c(scene.getPosId(), i == e.aIX.errorCode ? 21001 : i == e.aJb.errorCode ? 21003 : (i <= 0 || i >= 1000) ? 21004 : 21002);
    }

    public final void init() {
        h.Js().a(this);
    }
}
