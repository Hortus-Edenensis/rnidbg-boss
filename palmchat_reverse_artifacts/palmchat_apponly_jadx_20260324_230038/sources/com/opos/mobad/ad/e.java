package com.opos.mobad.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface e {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        double getLatitude();

        double getLongitude();
    }

    boolean alist();

    String getAndroidId();

    String getDevImei();

    a getLocation();

    String getMacAddress();

    int getMinorsMode();

    int getMinorsModeAgeRange();

    int getMinorsModeEnable();

    boolean isCanUseAndroidId();

    boolean isCanUseLocation();

    boolean isCanUsePhoneState();

    boolean isCanUseWifiState();

    boolean isCanUseWriteExternal();
}
