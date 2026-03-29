package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class cu {
    @InvokeBy(invokerClass = gu.class, methodId = "registerHolder")
    public static void Je() {
        gu.Jf().put(FeedPageInfo.class, new en());
        gu.Jf().put(FeedPageInfo.a.class, new hj());
        gu.Jf().put(FeedErrorInfo.class, new ek());
        gu.Jf().put(FeedWebViewInfo.class, new ep());
    }
}
