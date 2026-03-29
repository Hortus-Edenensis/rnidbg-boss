package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsAdSdkApi
@Keep
public interface KsAppDownloadListener {
    @KsAdSdkApi
    @Keep
    void onDownloadFailed();

    @KsAdSdkApi
    @Keep
    void onDownloadFinished();

    @KsAdSdkApi
    @Keep
    void onDownloadStarted();

    @KsAdSdkApi
    @Keep
    void onIdle();

    @KsAdSdkApi
    @Keep
    void onInstalled();

    @KsAdSdkApi
    @Keep
    void onProgressUpdate(int i);
}
