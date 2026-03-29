package com.wifi.adsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdVivoDevice extends LxAdAbsDevice {
    public static final String PROP_VERSION = "ro.vivo.os.build.display.id";
    private static final int sVersion = LxAdDeviceHelper.getVersion(PROP_VERSION, "Funtouch OS");

    public LxAdVivoDevice(Context context) {
        super(context);
    }

    private Intent getGeneralPermissionIntent() {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.PurviewTabActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        return null;
    }

    public static boolean isVivoDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("vivo") || Build.MODEL.contains("vivo");
    }

    @Override // com.wifi.adsdk.utils.LxAdAbsDevice
    public boolean ensureIntent(Intent intent) {
        return super.ensureIntent(intent);
    }

    @Override // com.wifi.adsdk.utils.LxAdAbsDevice
    public Intent getAppDetailIntent() {
        return super.getAppDetailIntent();
    }

    @Override // com.wifi.adsdk.utils.LxAdIDevice
    public int getDeviceType() {
        return 4;
    }

    @Override // com.wifi.adsdk.utils.LxAdIDevice
    public Intent getPermissionActivity(int i) {
        Intent generalPermissionIntent = i != 6 ? null : getGeneralPermissionIntent();
        if (generalPermissionIntent == null || !ensureIntent(generalPermissionIntent)) {
            return null;
        }
        return generalPermissionIntent;
    }

    @Override // com.wifi.adsdk.utils.LxAdIDevice
    public int getVersion() {
        return sVersion;
    }

    @Override // com.wifi.adsdk.utils.LxAdIDevice
    public boolean hasBackGround() {
        return false;
    }
}
