package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.h.a.a.b;
import com.kwad.components.ad.interstitial.report.InterstitialReportInfo;
import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class cw {
    @InvokeBy(invokerClass = gu.class, methodId = "registerHolder")
    public static void Je() {
        gu.Jf().put(com.kwad.components.ad.interstitial.c.a.class, new gi());
        gu.Jf().put(com.kwad.components.ad.interstitial.c.b.class, new gl());
        gu.Jf().put(com.kwad.components.ad.interstitial.d.a.class, new gj());
        gu.Jf().put(b.a.class, new lu());
        gu.Jf().put(InterstitialReportInfo.class, new gn());
        gu.Jf().put(InterstitialRealTimeInfo.class, new gm());
    }
}
