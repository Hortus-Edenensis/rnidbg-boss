package com.zm.fissionsdk.api.interfaces;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IFissionRuntime {
    String getAndroidId();

    int getCarrier();

    int getDeviceType();

    String getImei();

    double getLatitude();

    double getLongitude();

    String getMac();

    int getNetworkType();

    String getOAid();

    String getUid();

    boolean isLogin();

    void toLogin(IFissionLoginListener iFissionLoginListener);
}
