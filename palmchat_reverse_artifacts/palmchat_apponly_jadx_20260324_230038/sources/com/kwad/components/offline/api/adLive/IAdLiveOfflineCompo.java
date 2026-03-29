package com.kwad.components.offline.api.adLive;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IAdLiveOfflineCompo extends IOfflineCompo<IAdLiveOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.AdLiveOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adLive";

    /* JADX INFO: compiled from: SearchBox */
    public enum AdLiveState {
        READY,
        SO_FAIL
    }

    IAdLiveEndRequest getAdLiveEndRequest(String str);

    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j, int i);

    AdLiveState getState();

    IAdLiveOfflineView getView(Context context, int i);
}
