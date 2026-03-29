package com.lantern.core.business;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface IPubParams {
    List<String> getAdvancedPresetEventList();

    String getAesIv();

    String getAesKey();

    String getAndroidId();

    String getAppId();

    String getAraCode();

    String getBssid();

    long getBuketId();

    String getChanId();

    String getConfigPid();

    String getConfigUrl();

    String getDHID();

    String getEventPid();

    long getExpId();

    long getGroupId();

    String getIMEI();

    String getInstEventUrl();

    int getIpv6Config();

    int getKv();

    String getLanguage();

    String getLati();

    String getLongi();

    String getMac();

    String getMapSp();

    String getNetModel();

    String getOfflineEventUrl();

    String getOid();

    String getOnceEventUrl();

    String getOrigChanId();

    String getPid();

    List<String> getPresetEventList();

    String getProcessId();

    String getProcessName();

    String getSN();

    String getSR();

    String getSessionId();

    String getSsid();

    long getTs();

    String getUHID();

    String getUserToken();

    int getVerCode();

    String getVerName();

    long getVersionNun();

    String getWifiEventUrl();

    boolean isForceground();

    boolean isUseLimit();

    boolean openDbError();
}
