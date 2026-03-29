package com.wifi.ad.core;

import com.wifi.WkInitManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0005\"\u0004\b\u0015\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007R\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u0007R\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0005\"\u0004\b\u001d\u0010\u0007R\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007¨\u0006#"}, d2 = {"Lcom/wifi/ad/core/SdkPrivilegeController;", "", "()V", "isCanUseAndroidId", "", "()Z", "setCanUseAndroidId", "(Z)V", "isCanUseDeviceId", "setCanUseDeviceId", "isCanUseGaid", "setCanUseGaid", "isCanUseInstalledPackages", "setCanUseInstalledPackages", "isCanUseLocation", "setCanUseLocation", "isCanUseMacAddress", "setCanUseMacAddress", "isCanUseNetworkState", "setCanUseNetworkState", "isCanUseOaid", "setCanUseOaid", "isCanUsePermissionRecordAudio", "setCanUsePermissionRecordAudio", "isCanUsePhoneState", "setCanUsePhoneState", "isCanUseStoragePermission", "setCanUseStoragePermission", "isCanUseWifiState", "setCanUseWifiState", "isCanUseWriteExternal", "setCanUseWriteExternal", "toString", "", "Companion", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SdkPrivilegeController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SDK_OPPO = "oppo";
    private static final String SDK_KS = "ks";
    private static final String SDK_BD = WkInitManager.sdk_bd;
    private static final String SDK_CSJ = "csj";
    private static final String SDK_GDT = "gdt";
    private static final String SDK_HUAWEI = "huawei";
    private static final String SDK_BEIZI = "beizi";
    private static final String SDK_QUMENG = "qumeng";
    private static final String SDK_FEISUO = "feisuo";
    private static final String SDK_LXAD = "lxad";
    private static final String TAG_LOCATION = "isCanUseLocation";
    private static final String TAG_PHONESTATE = "isCanUsePhoneState";
    private static final String TAG_WIFISTATAE = "isCanUseWifiState";
    private static final String TAG_WRITEEXTERNAL = "isCanUseWriteExternal";
    private static final String TAG_NETWORKSTATE = "isCanUseNetworkState";
    private static final String TAG_INSTALLPACKAGES = "isCanUseInstalledPackages";
    private static final String TAG_ANDROIDID = "isCanUseAndroidId";
    private static final String TAG_RECORDAUDIO = "isCanUsePermissionRecordAudio";
    private static final String TAG_MACADDRESS = "isCanUseMacAddress";
    private static final String TAG_DEVICEID = "isCanUseDeviceId";
    private static final String TAG_GAID = "isCanUseGaid";
    private static final String TAG_OAID = "isCanUseOaid";
    private static final String TAG_SRTORAGEPERMISSION = "isCanUseStoragePermission";
    private boolean isCanUseLocation = true;
    private boolean isCanUsePhoneState = true;
    private boolean isCanUseWifiState = true;
    private boolean isCanUseWriteExternal = true;
    private boolean isCanUseNetworkState = true;
    private boolean isCanUseInstalledPackages = true;
    private boolean isCanUseAndroidId = true;
    private boolean isCanUsePermissionRecordAudio = true;
    private boolean isCanUseMacAddress = true;
    private boolean isCanUseDeviceId = true;
    private boolean isCanUseOaid = true;
    private boolean isCanUseGaid = true;
    private boolean isCanUseStoragePermission = true;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b/\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0014\u0010#\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0014\u0010%\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0014\u0010'\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0014\u0010)\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0014\u0010+\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0014\u0010-\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0014\u0010/\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0014\u00101\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006¨\u00063"}, d2 = {"Lcom/wifi/ad/core/SdkPrivilegeController$Companion;", "", "()V", "SDK_BD", "", "getSDK_BD", "()Ljava/lang/String;", "SDK_BEIZI", "getSDK_BEIZI", "SDK_CSJ", "getSDK_CSJ", "SDK_FEISUO", "getSDK_FEISUO", "SDK_GDT", "getSDK_GDT", "SDK_HUAWEI", "getSDK_HUAWEI", "SDK_KS", "getSDK_KS", "SDK_LXAD", "getSDK_LXAD", "SDK_OPPO", "getSDK_OPPO", "SDK_QUMENG", "getSDK_QUMENG", "TAG_ANDROIDID", "getTAG_ANDROIDID", "TAG_DEVICEID", "getTAG_DEVICEID", "TAG_GAID", "getTAG_GAID", "TAG_INSTALLPACKAGES", "getTAG_INSTALLPACKAGES", "TAG_LOCATION", "getTAG_LOCATION", "TAG_MACADDRESS", "getTAG_MACADDRESS", "TAG_NETWORKSTATE", "getTAG_NETWORKSTATE", "TAG_OAID", "getTAG_OAID", "TAG_PHONESTATE", "getTAG_PHONESTATE", "TAG_RECORDAUDIO", "getTAG_RECORDAUDIO", "TAG_SRTORAGEPERMISSION", "getTAG_SRTORAGEPERMISSION", "TAG_WIFISTATAE", "getTAG_WIFISTATAE", "TAG_WRITEEXTERNAL", "getTAG_WRITEEXTERNAL", "core_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final String getSDK_BD() {
            return SdkPrivilegeController.SDK_BD;
        }

        public final String getSDK_BEIZI() {
            return SdkPrivilegeController.SDK_BEIZI;
        }

        public final String getSDK_CSJ() {
            return SdkPrivilegeController.SDK_CSJ;
        }

        public final String getSDK_FEISUO() {
            return SdkPrivilegeController.SDK_FEISUO;
        }

        public final String getSDK_GDT() {
            return SdkPrivilegeController.SDK_GDT;
        }

        public final String getSDK_HUAWEI() {
            return SdkPrivilegeController.SDK_HUAWEI;
        }

        public final String getSDK_KS() {
            return SdkPrivilegeController.SDK_KS;
        }

        public final String getSDK_LXAD() {
            return SdkPrivilegeController.SDK_LXAD;
        }

        public final String getSDK_OPPO() {
            return SdkPrivilegeController.SDK_OPPO;
        }

        public final String getSDK_QUMENG() {
            return SdkPrivilegeController.SDK_QUMENG;
        }

        public final String getTAG_ANDROIDID() {
            return SdkPrivilegeController.TAG_ANDROIDID;
        }

        public final String getTAG_DEVICEID() {
            return SdkPrivilegeController.TAG_DEVICEID;
        }

        public final String getTAG_GAID() {
            return SdkPrivilegeController.TAG_GAID;
        }

        public final String getTAG_INSTALLPACKAGES() {
            return SdkPrivilegeController.TAG_INSTALLPACKAGES;
        }

        public final String getTAG_LOCATION() {
            return SdkPrivilegeController.TAG_LOCATION;
        }

        public final String getTAG_MACADDRESS() {
            return SdkPrivilegeController.TAG_MACADDRESS;
        }

        public final String getTAG_NETWORKSTATE() {
            return SdkPrivilegeController.TAG_NETWORKSTATE;
        }

        public final String getTAG_OAID() {
            return SdkPrivilegeController.TAG_OAID;
        }

        public final String getTAG_PHONESTATE() {
            return SdkPrivilegeController.TAG_PHONESTATE;
        }

        public final String getTAG_RECORDAUDIO() {
            return SdkPrivilegeController.TAG_RECORDAUDIO;
        }

        public final String getTAG_SRTORAGEPERMISSION() {
            return SdkPrivilegeController.TAG_SRTORAGEPERMISSION;
        }

        public final String getTAG_WIFISTATAE() {
            return SdkPrivilegeController.TAG_WIFISTATAE;
        }

        public final String getTAG_WRITEEXTERNAL() {
            return SdkPrivilegeController.TAG_WRITEEXTERNAL;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: isCanUseAndroidId, reason: from getter */
    public final boolean getIsCanUseAndroidId() {
        return this.isCanUseAndroidId;
    }

    /* JADX INFO: renamed from: isCanUseDeviceId, reason: from getter */
    public final boolean getIsCanUseDeviceId() {
        return this.isCanUseDeviceId;
    }

    /* JADX INFO: renamed from: isCanUseGaid, reason: from getter */
    public final boolean getIsCanUseGaid() {
        return this.isCanUseGaid;
    }

    /* JADX INFO: renamed from: isCanUseInstalledPackages, reason: from getter */
    public final boolean getIsCanUseInstalledPackages() {
        return this.isCanUseInstalledPackages;
    }

    /* JADX INFO: renamed from: isCanUseLocation, reason: from getter */
    public final boolean getIsCanUseLocation() {
        return this.isCanUseLocation;
    }

    /* JADX INFO: renamed from: isCanUseMacAddress, reason: from getter */
    public final boolean getIsCanUseMacAddress() {
        return this.isCanUseMacAddress;
    }

    /* JADX INFO: renamed from: isCanUseNetworkState, reason: from getter */
    public final boolean getIsCanUseNetworkState() {
        return this.isCanUseNetworkState;
    }

    /* JADX INFO: renamed from: isCanUseOaid, reason: from getter */
    public final boolean getIsCanUseOaid() {
        return this.isCanUseOaid;
    }

    /* JADX INFO: renamed from: isCanUsePermissionRecordAudio, reason: from getter */
    public final boolean getIsCanUsePermissionRecordAudio() {
        return this.isCanUsePermissionRecordAudio;
    }

    /* JADX INFO: renamed from: isCanUsePhoneState, reason: from getter */
    public final boolean getIsCanUsePhoneState() {
        return this.isCanUsePhoneState;
    }

    /* JADX INFO: renamed from: isCanUseStoragePermission, reason: from getter */
    public final boolean getIsCanUseStoragePermission() {
        return this.isCanUseStoragePermission;
    }

    /* JADX INFO: renamed from: isCanUseWifiState, reason: from getter */
    public final boolean getIsCanUseWifiState() {
        return this.isCanUseWifiState;
    }

    /* JADX INFO: renamed from: isCanUseWriteExternal, reason: from getter */
    public final boolean getIsCanUseWriteExternal() {
        return this.isCanUseWriteExternal;
    }

    public final void setCanUseAndroidId(boolean z) {
        this.isCanUseAndroidId = z;
    }

    public final void setCanUseDeviceId(boolean z) {
        this.isCanUseDeviceId = z;
    }

    public final void setCanUseGaid(boolean z) {
        this.isCanUseGaid = z;
    }

    public final void setCanUseInstalledPackages(boolean z) {
        this.isCanUseInstalledPackages = z;
    }

    public final void setCanUseLocation(boolean z) {
        this.isCanUseLocation = z;
    }

    public final void setCanUseMacAddress(boolean z) {
        this.isCanUseMacAddress = z;
    }

    public final void setCanUseNetworkState(boolean z) {
        this.isCanUseNetworkState = z;
    }

    public final void setCanUseOaid(boolean z) {
        this.isCanUseOaid = z;
    }

    public final void setCanUsePermissionRecordAudio(boolean z) {
        this.isCanUsePermissionRecordAudio = z;
    }

    public final void setCanUsePhoneState(boolean z) {
        this.isCanUsePhoneState = z;
    }

    public final void setCanUseStoragePermission(boolean z) {
        this.isCanUseStoragePermission = z;
    }

    public final void setCanUseWifiState(boolean z) {
        this.isCanUseWifiState = z;
    }

    public final void setCanUseWriteExternal(boolean z) {
        this.isCanUseWriteExternal = z;
    }

    public String toString() {
        return "isCanUseLocation:" + this.isCanUseLocation + "; isCanUsePhoneState:" + this.isCanUsePhoneState + "; isCanUseWifiState:" + this.isCanUseWifiState + "; isCanUseWriteExternal:" + this.isCanUseWriteExternal + "; isCanUseNetworkState:" + this.isCanUseNetworkState + "; isCanUseInstalledPackages:" + this.isCanUseInstalledPackages + "; isCanUseAndroidId:" + this.isCanUseAndroidId + "; isCanUsePermissionRecordAudio:" + this.isCanUsePermissionRecordAudio + "; isCanUseMacAddress:" + this.isCanUseMacAddress + "; isCanUseDeviceId:" + this.isCanUseDeviceId + "; isCanUseOaid:" + this.isCanUseOaid + "; isCanUseGaid:" + this.isCanUseGaid + "; isCanUseGaid:" + this.isCanUseStoragePermission + "; ";
    }
}
