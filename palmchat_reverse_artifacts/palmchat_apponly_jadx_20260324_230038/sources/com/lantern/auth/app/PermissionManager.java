package com.lantern.auth.app;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PermissionManager {
    public static boolean hanAllPermissions() {
        return (WkSDKManager.getPermissions() & 3) == 3;
    }

    public static boolean hasNormalPermission() {
        return (WkSDKManager.getPermissions() & 1) == 1;
    }

    public static boolean hasPhonePermission() {
        return (WkSDKManager.getPermissions() & 2) == 2;
    }
}
