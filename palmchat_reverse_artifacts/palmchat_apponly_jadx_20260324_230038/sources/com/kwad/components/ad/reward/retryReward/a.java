package com.kwad.components.ad.reward.retryReward;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.manager.RewardRetryTaskManager;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class a {
    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initModeImplForInvoker")
    public static void register() {
        try {
            if (bx.aC(l.DP().getApiVersion(), BuildConfig.VERSION_NAME)) {
                com.kwad.sdk.service.c.a(RewardRetryTaskManager.class, RewardRetryTaskManagerImpl.class);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
