package com.kwad.components.offline.api.explore;

import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.explore.model.AdParams;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface ExploreOfflineCompo extends IOfflineCompo<ExploreOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.explore.ExploreOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.explore";

    void reportKsAllianceAdLoad(AdParams adParams);

    void reportKsAllianceAdShow(AdParams adParams);
}
