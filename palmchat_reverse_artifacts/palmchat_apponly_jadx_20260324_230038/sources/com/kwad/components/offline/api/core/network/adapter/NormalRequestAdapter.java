package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.sdk.core.network.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class NormalRequestAdapter<R extends IOfflineCompoRequest> implements n {
    public abstract R getOfflineCompoRequest();
}
