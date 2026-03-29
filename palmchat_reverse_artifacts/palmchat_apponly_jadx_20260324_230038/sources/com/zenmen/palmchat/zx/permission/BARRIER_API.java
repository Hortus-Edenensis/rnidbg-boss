package com.zenmen.palmchat.zx.permission;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b0\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00064"}, d2 = {"Lcom/zenmen/palmchat/zx/permission/BARRIER_API;", "", "id", "", "Lcom/zenmen/palmchat/zx/permission/BarrierApiId;", "(Ljava/lang/String;II)V", "getId", "()I", "Activity_requestPermissions", "ActivityManager_getRunningTasks", "ActivityManager_getRecentTasks", "ActivityManager_getRunningAppProcesses", "BluetoothAdapter_getDefaultAdapter", "Build_getSerial", "ClipboardManager_getPrimaryClipDescription", "LocationManager_getBestProvider", "LocationManager_getLastKnownLocation", "LocationManager_requestLocationUpdates", "NetworkInterface_getNetworkInterfaces", "PackageManager_getInstalledApplications", "PackageManager_queryIntentActivities", "PackageManager_queryIntentActivityOptions", "SensorManager_getSensorList", "Settings_Secure_getString", "TelephonyManager_getDeviceId", "TelephonyManager_getDeviceId_slotIndex", "TelephonyManager_getAllCellInfo", "TelephonyManager_getMeid", "TelephonyManager_getImei", "TelephonyManager_getImei_slotIndex", "TelephonyManager_getSubscriberId", "TelephonyManager_getSimSerialNumber", "TelephonyManager_getLine1Number", "WifiInfo_getMacAddress", "WifiInfo_getSSID", "WifiInfo_getBSSID", "WifiManager_getScanResults", "WifiManager_getDhcpInfo", "WifiManager_getConfiguredNetworks", "LocationManager_getProviders", "LocationManager_getAllProviders", "ClipboardManager_getPrimaryClip", "ClipboardManager_getText", "PackageManager_getInstalledPackages", "PackageManager_getActivityInfo", "PackageManager_getPackageInfo", "TelephonyManager_getNetworkOperator", "TelephonyManager_getNetworkOperatorName", "Settings_Secure_getAndroidId", "TelephonyManager_getSimState", "TelephonyManager_getSimState_slotIndex", "SensorManager_getDefaultSensor", "zx-permission_release"}, k = 1, mv = {1, 1, 16})
public enum BARRIER_API {
    Activity_requestPermissions(1),
    ActivityManager_getRunningTasks(2),
    ActivityManager_getRecentTasks(3),
    ActivityManager_getRunningAppProcesses(4),
    BluetoothAdapter_getDefaultAdapter(5),
    Build_getSerial(6),
    ClipboardManager_getPrimaryClipDescription(9),
    LocationManager_getBestProvider(12),
    LocationManager_getLastKnownLocation(13),
    LocationManager_requestLocationUpdates(14),
    NetworkInterface_getNetworkInterfaces(15),
    PackageManager_getInstalledApplications(16),
    PackageManager_queryIntentActivities(17),
    PackageManager_queryIntentActivityOptions(18),
    SensorManager_getSensorList(19),
    Settings_Secure_getString(20),
    TelephonyManager_getDeviceId(21),
    TelephonyManager_getDeviceId_slotIndex(22),
    TelephonyManager_getAllCellInfo(23),
    TelephonyManager_getMeid(24),
    TelephonyManager_getImei(25),
    TelephonyManager_getImei_slotIndex(26),
    TelephonyManager_getSubscriberId(27),
    TelephonyManager_getSimSerialNumber(28),
    TelephonyManager_getLine1Number(29),
    WifiInfo_getMacAddress(30),
    WifiInfo_getSSID(31),
    WifiInfo_getBSSID(32),
    WifiManager_getScanResults(33),
    WifiManager_getDhcpInfo(34),
    WifiManager_getConfiguredNetworks(35),
    LocationManager_getProviders(36),
    LocationManager_getAllProviders(37),
    ClipboardManager_getPrimaryClip(38),
    ClipboardManager_getText(39),
    PackageManager_getInstalledPackages(40),
    PackageManager_getActivityInfo(41),
    PackageManager_getPackageInfo(42),
    TelephonyManager_getNetworkOperator(43),
    TelephonyManager_getNetworkOperatorName(44),
    Settings_Secure_getAndroidId(45),
    TelephonyManager_getSimState(46),
    TelephonyManager_getSimState_slotIndex(47),
    SensorManager_getDefaultSensor(48);

    private final int id;

    BARRIER_API(int i) {
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }
}
