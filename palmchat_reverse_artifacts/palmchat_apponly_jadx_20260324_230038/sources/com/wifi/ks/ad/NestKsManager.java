package com.wifi.ks.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.wifi.ad.core.SdkPrivilegeController;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.entity.AdProviderEntity;
import com.wifi.ad.core.utils.WifiLog;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u000bJ.\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000bJF\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000b2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/wifi/ks/ad/NestKsManager;", "", "()V", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "idMapKS", "", "", "getIdMapKS", "()Ljava/util/Map;", "setIdMapKS", "(Ljava/util/Map;)V", "initDone", "getInitDone", "setInitDone", "getVersion", "init", "", "context", "Landroid/content/Context;", "adProviderType", "appId", WfConstant.EVENT_KEY_APP_NAME, "ksIdMap", "updatePersonAd", "enablePersonal", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestKsManager {
    private static boolean debug;
    private static boolean initDone;
    public static final NestKsManager INSTANCE = new NestKsManager();
    private static Map<String, String> idMapKS = MapsKt__MapsKt.emptyMap();

    private NestKsManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(NestKsManager nestKsManager, Context context, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 16) != 0) {
            map = null;
        }
        nestKsManager.init(context, str, str2, str3, map);
    }

    public final boolean getDebug() {
        return debug;
    }

    public final Map<String, String> getIdMapKS() {
        return idMapKS;
    }

    public final boolean getInitDone() {
        return initDone;
    }

    public final String getVersion() {
        String sDKVersion = KsAdSDK.getSDKVersion();
        Intrinsics.checkExpressionValueIsNotNull(sDKVersion, "KsAdSDK.getSDKVersion()");
        return sDKVersion;
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String appId, @NonNull String appName) {
        init(context, adProviderType, appId, appName, null);
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void setIdMapKS(Map<String, String> map) {
        idMapKS = map;
    }

    public final void setInitDone(boolean z) {
        initDone = z;
    }

    public final void updatePersonAd(boolean enablePersonal) {
        if (initDone) {
            WifiLog.d("ksManager updateCSJSDKPersonAd enablePersonal " + enablePersonal);
            KsAdSDK.setPersonalRecommend(enablePersonal);
        }
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String appId, @NonNull String appName, Map<String, String> ksIdMap) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean isCanUseAndroidId;
        SdkPrivilegeController sdkPrivilegeController;
        TogetherAd togetherAd = TogetherAd.INSTANCE;
        String name = NestKsProvider.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "NestKsProvider::class.java.name");
        togetherAd.addProvider(new AdProviderEntity(adProviderType, name, null, 4, null));
        if (ksIdMap != null) {
            idMapKS = ksIdMap;
        }
        WifiLog.d("NestKsManager init debug = " + debug + " WkInitManager thread " + Thread.currentThread());
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        HashMap<String, SdkPrivilegeController> sdkPrivilegeControllerS = wifiNestAd.getSdkPrivilegeControllerS();
        SdkPrivilegeController.Companion companion = SdkPrivilegeController.INSTANCE;
        if (!sdkPrivilegeControllerS.containsKey(companion.getSDK_KS()) || (sdkPrivilegeController = wifiNestAd.getSdkPrivilegeControllerS().get(companion.getSDK_KS())) == null) {
            z = true;
            z2 = true;
            z3 = true;
            z4 = true;
            z5 = true;
            z6 = true;
            z7 = true;
            isCanUseAndroidId = true;
        } else {
            boolean isCanUseLocation = sdkPrivilegeController.getIsCanUseLocation();
            boolean isCanUseInstalledPackages = sdkPrivilegeController.getIsCanUseInstalledPackages();
            boolean isCanUsePhoneState = sdkPrivilegeController.getIsCanUsePhoneState();
            boolean isCanUseMacAddress = sdkPrivilegeController.getIsCanUseMacAddress();
            boolean isCanUseOaid = sdkPrivilegeController.getIsCanUseOaid();
            boolean isCanUseWifiState = sdkPrivilegeController.getIsCanUseWifiState();
            boolean isCanUseStoragePermission = sdkPrivilegeController.getIsCanUseStoragePermission();
            isCanUseAndroidId = sdkPrivilegeController.getIsCanUseAndroidId();
            z = isCanUseLocation;
            z2 = isCanUseInstalledPackages;
            z3 = isCanUsePhoneState;
            z4 = isCanUseMacAddress;
            z5 = isCanUseOaid;
            z6 = isCanUseWifiState;
            z7 = isCanUseStoragePermission;
        }
        KsAdSDK.init(context, new SdkConfig.Builder().appId(appId).appName(appName).showNotification(true).customController(new KsDefaultController(context, z, z2, z3, z4, z5, z6, z7, isCanUseAndroidId)).debug(debug).build());
        KsAdSDK.start();
        initDone = true;
        wifiNestAd.setKsInit(true);
    }
}
