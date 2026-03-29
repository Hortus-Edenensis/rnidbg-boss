package com.wifi.adsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdMiuiDevice extends LxAdAbsDevice {
    public static final int MINU_V9 = 7;
    public static final float MIN_VERSION = 6.7f;
    public static final int MIUI_V5 = 3;
    public static final int MIUI_V6 = 4;
    public static final int MIUI_V7 = 5;
    public static final int MIUI_V8 = 6;
    private static final String PROP_INCREMENTAL = "ro.build.version.incremental";
    public static final String PROP_VERSION = "ro.miui.ui.version.code";
    public static final String XIAOMI_MIX_3_VERSION = "10.0.12";
    private static final int sVersion;

    static {
        int i;
        try {
            i = Integer.parseInt(LxAdDeviceHelper.getProp(PROP_VERSION).trim());
        } catch (NumberFormatException unused) {
            i = -1;
        }
        sVersion = i;
    }

    public LxAdMiuiDevice(Context context) {
        super(context);
    }

    private Intent getBackroundProtectedIntent() {
        Intent intent = new Intent();
        intent.setClassName("com.miui.powerkeeper", "com.miui.poweroptimize.hidemode.PowerHideModeActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        return null;
    }

    private Intent getGeneralPermissionIntent() {
        PackageInfo packageInfo;
        Intent intent = new Intent();
        if (sVersion >= 4) {
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", this.mContext.getPackageName());
            return intent;
        }
        intent.setClassName("com.android.settings", "com.miui.securitycenter.permission.AppPermissionsEditor");
        try {
            packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        intent.putExtra("extra_package_uid", packageInfo.applicationInfo.uid);
        return intent;
    }

    private boolean getIncremental() {
        return Float.parseFloat(LxAdDeviceHelper.getProp(PROP_INCREMENTAL).substring(1, 4)) >= 6.7f;
    }

    public static boolean isMIUI() {
        String str = Build.MANUFACTURER;
        return "xiaomi".equalsIgnoreCase(str) || "redmi".equalsIgnoreCase(str);
    }

    public static boolean isMiuiDevice() {
        int i = sVersion;
        return i == 3 || i == 4 || i == 5 || i == 6 || i == 7;
    }

    public static boolean isXiaoMiMix3() {
        return LxAdDeviceHelper.getProp(PROP_INCREMENTAL).substring(1, 8).equals(XIAOMI_MIX_3_VERSION);
    }

    @Override // com.wifi.adsdk.utils.LxAdIDevice
    public int getDeviceType() {
        return 1;
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
        int i = sVersion;
        if (i > 4) {
            return true;
        }
        if (i == 4) {
            return getIncremental();
        }
        return false;
    }
}
