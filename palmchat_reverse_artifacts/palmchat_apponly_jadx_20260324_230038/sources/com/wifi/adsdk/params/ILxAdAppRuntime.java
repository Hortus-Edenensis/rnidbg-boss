package com.wifi.adsdk.params;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ILxAdAppRuntime {
    boolean alist();

    int getAge();

    String getAndroidId();

    String getChanId();

    String getDeviceId();

    int getGender();

    String getImei();

    List<String> getInstallPkgs();

    String getLatitude();

    String getLongitude();

    String getMac();

    String getOaId();

    int getOpenSdkVer();

    String getUa();

    String getUid();

    int getWxApiVer();

    boolean isCanUseAndroidId();

    boolean isCanUseMacAddress();

    boolean isCanUsePhoneState();

    boolean isCanUseWifiState();

    boolean isCanUseWriteExternal();
}
