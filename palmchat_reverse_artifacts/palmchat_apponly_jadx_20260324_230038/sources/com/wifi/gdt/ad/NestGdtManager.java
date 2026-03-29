package com.wifi.gdt.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.wifi.ad.core.SdkPrivilegeController;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.entity.AdProviderEntity;
import com.wifi.ad.core.utils.WifiLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u000bJ$\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u000bJ<\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u000b2\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/wifi/gdt/ad/NestGdtManager;", "", "()V", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "idMapGDT", "", "", "getIdMapGDT", "()Ljava/util/Map;", "setIdMapGDT", "(Ljava/util/Map;)V", "initDone", "getInitDone", "setInitDone", "getVersion", "init", "", "context", "Landroid/content/Context;", "adProviderType", "gdtAdAppId", "gdtIdMap", "updatePersonAd", "enablePersonal", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestGdtManager {
    private static boolean debug;
    private static boolean initDone;
    public static final NestGdtManager INSTANCE = new NestGdtManager();
    private static Map<String, String> idMapGDT = MapsKt__MapsKt.emptyMap();

    private NestGdtManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(NestGdtManager nestGdtManager, Context context, String str, String str2, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = null;
        }
        nestGdtManager.init(context, str, str2, map);
    }

    public final boolean getDebug() {
        return debug;
    }

    public final Map<String, String> getIdMapGDT() {
        return idMapGDT;
    }

    public final boolean getInitDone() {
        return initDone;
    }

    public final String getVersion() {
        return "4.660.1530";
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String gdtAdAppId) {
        init(context, adProviderType, gdtAdAppId, null);
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void setIdMapGDT(Map<String, String> map) {
        idMapGDT = map;
    }

    public final void setInitDone(boolean z) {
        initDone = z;
    }

    public final void updatePersonAd(boolean enablePersonal) {
        if (initDone) {
            WifiLog.d("gdtManager updateCSJSDKPersonAd enablePersonal " + enablePersonal);
            if (enablePersonal) {
                GlobalSetting.setPersonalizedState(0);
            } else {
                GlobalSetting.setPersonalizedState(1);
            }
        }
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String gdtAdAppId, Map<String, String> gdtIdMap) {
        boolean isCanUseDeviceId;
        boolean isCanUseNetworkState;
        boolean isCanUseInstalledPackages;
        boolean isCanUseAndroidId;
        boolean isCanUseMacAddress;
        boolean isCanUseWifiState;
        SdkPrivilegeController sdkPrivilegeController;
        TogetherAd togetherAd = TogetherAd.INSTANCE;
        String name = NestGdtProvider.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "NestGdtProvider::class.java.name");
        togetherAd.addProvider(new AdProviderEntity(adProviderType, name, null, 4, null));
        if (gdtIdMap != null) {
            idMapGDT = gdtIdMap;
        }
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        HashMap<String, SdkPrivilegeController> sdkPrivilegeControllerS = wifiNestAd.getSdkPrivilegeControllerS();
        SdkPrivilegeController.Companion companion = SdkPrivilegeController.INSTANCE;
        if (!sdkPrivilegeControllerS.containsKey(companion.getSDK_GDT()) || (sdkPrivilegeController = wifiNestAd.getSdkPrivilegeControllerS().get(companion.getSDK_GDT())) == null) {
            isCanUseDeviceId = false;
            isCanUseNetworkState = true;
            isCanUseInstalledPackages = true;
            isCanUseAndroidId = false;
            isCanUseMacAddress = true;
            isCanUseWifiState = true;
        } else {
            isCanUseDeviceId = sdkPrivilegeController.getIsCanUseDeviceId();
            isCanUseInstalledPackages = sdkPrivilegeController.getIsCanUseInstalledPackages();
            isCanUseAndroidId = sdkPrivilegeController.getIsCanUseAndroidId();
            isCanUseMacAddress = sdkPrivilegeController.getIsCanUseMacAddress();
            isCanUseWifiState = sdkPrivilegeController.getIsCanUseWifiState();
            isCanUseNetworkState = sdkPrivilegeController.getIsCanUseNetworkState();
        }
        WifiLog.d("WkInitManager thread " + Thread.currentThread() + " sdkPrivilegeController gdtMananger isCanUseDeviceId " + isCanUseDeviceId + " isCanUseAndroidId " + isCanUseAndroidId + " isCanUseInstalledPackages " + isCanUseInstalledPackages + " isCanUseMacAddress " + isCanUseMacAddress + " isCanUseWifi " + isCanUseWifiState + " isCanUseNetwork " + isCanUseNetworkState);
        GlobalSetting.setAgreeReadDeviceId(isCanUseDeviceId);
        GlobalSetting.setAgreeReadAndroidId(isCanUseAndroidId);
        GlobalSetting.setEnableCollectAppInstallStatus(isCanUseInstalledPackages);
        HashMap map = new HashMap();
        map.put("device_id", Boolean.valueOf(isCanUseDeviceId));
        map.put("android_id", Boolean.valueOf(isCanUseAndroidId));
        map.put("mac_address", Boolean.valueOf(isCanUseMacAddress));
        map.put("wipaddr", Boolean.valueOf(isCanUseWifiState));
        map.put("netop", Boolean.valueOf(isCanUseNetworkState));
        GlobalSetting.setAgreeReadPrivacyInfo(map);
        GDTAdSdk.init(context, gdtAdAppId);
        StringBuilder sb = new StringBuilder();
        sb.append("NestGdtManager init appId = ");
        sb.append(gdtAdAppId);
        WifiLog.d(sb.toString());
        initDone = true;
        wifiNestAd.setGdtInit(true);
    }
}
