package com.huawei.openalliance.ad.inter;

import com.huawei.hms.ads.InformationController;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.inter.listeners.ExtensionActionListener;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public interface IHiAd {
    void enableSharePd(boolean z);

    void enableUserInfo(boolean z);

    int getAppActivateStyle();

    IAppDownloadManager getAppDownloadManager();

    ExtensionActionListener getExtensionActionListener();

    RequestOptions getRequestConfiguration();

    void informReady();

    void initGrs(String str);

    void initGrs(String str, String str2);

    void initLog(boolean z, int i);

    void initLog(boolean z, int i, String str);

    boolean isAppAutoOpenForbidden();

    boolean isAppInstalledNotify();

    boolean isEnableUserInfo();

    boolean isNewProcess();

    Boolean isOpenWebPageByBrowser();

    void onBackground();

    void onForeground();

    void reportSetVideoConfigMedia(AdContentData adContentData, boolean z, boolean z2, int i);

    void sendBiddingInfo(Map<String, Object> map, AdContentData adContentData, String str, boolean z);

    void setAppActivateStyle(int i);

    void setAppAutoOpenForbidden(boolean z);

    void setAppDownloadListener(AppDownloadListener appDownloadListener);

    void setAppInstalledNotify(boolean z);

    void setAppMuted(boolean z);

    void setAppVolume(float f);

    void setApplicationCode(String str);

    void setBrand(int i);

    void setConsent(String str);

    void setCountryCode(String str);

    void setExtensionActionListener(ExtensionActionListener extensionActionListener);

    void setInfoController(InformationController informationController);

    void setMultiMediaPlayingManager(IMultiMediaPlayingManager iMultiMediaPlayingManager);

    void setOpenWebPageByBrowser(boolean z);

    void setReportUrlListener(ReportUrlListener reportUrlListener);

    void setRequestConfiguration(RequestOptions requestOptions);
}
