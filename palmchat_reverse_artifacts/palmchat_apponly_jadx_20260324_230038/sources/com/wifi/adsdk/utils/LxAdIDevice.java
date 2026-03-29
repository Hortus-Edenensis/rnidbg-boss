package com.wifi.adsdk.utils;

import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface LxAdIDevice {
    public static final int DEVICE_TYPE_EMUI = 2;
    public static final int DEVICE_TYPE_MIUI = 1;
    public static final int DEVICE_TYPE_OPPO = 3;
    public static final int DEVICE_TYPE_UNKNOWN = 0;
    public static final int DEVICE_TYPE_VIVO = 4;
    public static final int EMPTY_VERSION = 0;
    public static final int INVALID_VERSION = -1;
    public static final int PC_BACKGROUND_AUTO_START = 2;
    public static final int PC_BACKGROUND_PROTECTED = 3;
    public static final int PC_BOOT_AUTO_START = 1;
    public static final int PC_FLOAT_WINDOW = 4;
    public static final int PC_GENERAL_PERMISSION = 6;
    public static final int PC_UNKNOWN = 0;
    public static final int PC_WHITE_LIST = 5;

    int getDeviceType();

    Intent getPermissionActivity(int i);

    int getVersion();

    boolean hasBackGround();
}
