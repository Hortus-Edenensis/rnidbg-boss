package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class cz {
    @InvokeBy(invokerClass = gu.class, methodId = "registerHolder")
    public static void Je() {
        gu.Jf().put(SplashWebMonitorInfo.class, new kz());
        gu.Jf().put(SplashMonitorInfo.class, new ks());
        gu.Jf().put(com.kwad.components.ad.splashscreen.local.a.class, new kr());
        gu.Jf().put(SplashPreloadManager.PreLoadItem.class, new jd());
        gu.Jf().put(SplashSkipViewModel.class, new kw());
    }
}
