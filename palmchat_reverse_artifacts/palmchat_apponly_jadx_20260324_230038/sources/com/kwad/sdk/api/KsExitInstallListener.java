package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsAdSdkApi
@Keep
public interface KsExitInstallListener {
    @KsAdSdkApi
    @Keep
    void onDialogClose();

    @KsAdSdkApi
    @Keep
    void onInstallClick();
}
