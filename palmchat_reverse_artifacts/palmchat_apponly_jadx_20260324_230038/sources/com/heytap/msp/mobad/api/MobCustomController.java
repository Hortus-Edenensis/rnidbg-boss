package com.heytap.msp.mobad.api;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class MobCustomController {

    /* JADX INFO: compiled from: SearchBox */
    public interface LocationProvider {
        double getLatitude();

        double getLongitude();
    }

    public boolean alist() {
        return true;
    }

    public String getAndroidId() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public LocationProvider getLocation() {
        return null;
    }

    public String getMacAddress() {
        return null;
    }

    public int getMinorsMode() {
        return 0;
    }

    public int getMinorsModeAgeRange() {
        return 0;
    }

    public int getMinorsModeEnable() {
        return 0;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }
}
