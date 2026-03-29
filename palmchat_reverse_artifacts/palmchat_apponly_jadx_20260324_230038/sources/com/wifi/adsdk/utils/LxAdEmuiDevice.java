package com.wifi.adsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdEmuiDevice extends LxAdAbsDevice {
    public static final int EMUI_VERSION_15 = 150;
    public static final int EMUI_VERSION_16 = 160;
    public static final int EMUI_VERSION_20 = 200;
    public static final int EMUI_VERSION_30 = 300;
    public static final int EMUI_VERSION_31 = 310;
    public static final int EMUI_VERSION_40 = 400;
    public static final int EMUI_VERSION_41 = 410;
    public static final String PROP_VERSION = "ro.build.version.emui";
    private static final int sVersion = LxAdDeviceHelper.getVersion(PROP_VERSION, "EmotionUI");

    public LxAdEmuiDevice(Context context) {
        super(context);
    }

    private Intent getBackroundProtectedIntent() {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        if (Build.VERSION.SDK_INT > 23) {
            intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
            if (ensureIntent(intent)) {
                return intent;
            }
            intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
            if (ensureIntent(intent)) {
                return intent;
            }
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.android.hwpowermanager", "com.huawei.android.hwpowermanager.BootApplicationActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        return null;
    }

    private Intent getGeneralPermissionIntent() {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (ensureIntent(intent)) {
            return intent;
        }
        return null;
    }

    public static boolean isEmuiDevice() {
        if (sVersion < 150) {
            String str = Build.MANUFACTURER;
            if (!"huawei".equalsIgnoreCase(str) && !"honor".equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.wifi.adsdk.utils.LxAdIDevice
    public int getDeviceType() {
        return 2;
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
