package com.zm.adxsdk.protocol.api.interfaces;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IWfRuntime {
    String getAndroidId();

    List<String> getAppList();

    String getBssid();

    int getCarrier();

    String getDHid();

    int getDeviceType();

    int getGeoType();

    String getImei();

    String getIp();

    double getLatitude();

    double getLongitude();

    String getMac();

    int getNetworkType();

    String getOAid();

    String getSSid();

    String getUhid();

    String getUid();

    String getUserAgent();

    boolean isHttps();

    boolean isLogin();

    void toLogin(Object obj);
}
