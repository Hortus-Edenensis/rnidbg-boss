package com.kwad.components.offline.api.adInnerEc;

import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.core.adInnerEc.IAdInnerEcExternalModule;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IAdInnerEcOfflineCompo extends IOfflineCompo<IAdInnerEcOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.AdInnerEcOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adInnerEc";

    /* JADX INFO: compiled from: SearchBox */
    public enum AdInnerEcState {
        READY,
        SO_FAIL
    }

    IAdInnerEcExternalModule getAdInnerEcExternalModule();

    AdInnerEcState getState();
}
