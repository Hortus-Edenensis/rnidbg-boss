package com.wifi.adsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdOppoDevice extends LxAdAbsDevice {
    public static final int OPPO_VERSION_10 = 100;
    public static final int OPPO_VERSION_20 = 200;
    public static final int OPPO_VERSION_21 = 210;
    public static final String PROP_VERSION = "ro.build.version.opporom";
    private static final int sVersion = LxAdDeviceHelper.getVersion(PROP_VERSION, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
    private static final String sManufacture = Build.MANUFACTURER.toLowerCase();

    public LxAdOppoDevice(Context context) {
        super(context);
    }

    private Intent getAutoStartIntent() {
        Intent intent = new Intent();
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupManagerActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.startup.StartupAppListActivity");
        return intent;
    }

    private Intent getBackroundProtectedIntent() {
        Intent intent = new Intent();
        intent.setClassName("com.oppo.purebackground", "com.oppo.purebackground.Purebackground_AddTrust_Activity");
        if (ensureIntent(intent)) {
            return intent;
        }
        intent.setClassName("com.color.safecenter", "com.color.purebackground.PureBackgroundSettingActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.purebackground", "com.oppo.purebackground.PurebackgroundTopActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        return null;
    }

    private Intent getGeneralPermissionIntent() {
        Intent intent = new Intent();
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionSettingsActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        return null;
    }

    public static boolean isOppoDevice() {
        int i = sVersion;
        return (i == -1 || i == 0 || !sManufacture.equals("oppo")) ? false : true;
    }

    @Override // com.wifi.adsdk.utils.LxAdIDevice
    public int getDeviceType() {
        return 3;
    }

    @Override // com.wifi.adsdk.utils.LxAdIDevice
    public Intent getPermissionActivity(int i) {
        Intent generalPermissionIntent = i != 3 ? i != 6 ? null : getGeneralPermissionIntent() : getBackroundProtectedIntent();
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
        return true;
    }
}
