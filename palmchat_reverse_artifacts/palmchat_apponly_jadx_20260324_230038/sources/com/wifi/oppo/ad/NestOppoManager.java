package com.wifi.oppo.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.heytap.msp.mobad.api.InitParams;
import com.heytap.msp.mobad.api.MobAdManager;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u000bJ.\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000bJF\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000b2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/wifi/oppo/ad/NestOppoManager;", "", "()V", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "idMapOppo", "", "", "getIdMapOppo", "()Ljava/util/Map;", "setIdMapOppo", "(Ljava/util/Map;)V", "initDone", "getInitDone", "setInitDone", "getVersion", "init", "", "context", "Landroid/content/Context;", "adProviderType", "appId", WfConstant.EVENT_KEY_APP_NAME, "oppoIdMap", "updatePersonAd", "enablePersonal", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestOppoManager {
    private static boolean debug;
    private static boolean initDone;
    public static final NestOppoManager INSTANCE = new NestOppoManager();
    private static Map<String, String> idMapOppo = MapsKt__MapsKt.emptyMap();

    private NestOppoManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(NestOppoManager nestOppoManager, Context context, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 16) != 0) {
            map = null;
        }
        nestOppoManager.init(context, str, str2, str3, map);
    }

    public final boolean getDebug() {
        return debug;
    }

    public final Map<String, String> getIdMapOppo() {
        return idMapOppo;
    }

    public final boolean getInitDone() {
        return initDone;
    }

    public final String getVersion() {
        MobAdManager mobAdManager = MobAdManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(mobAdManager, "MobAdManager.getInstance()");
        return String.valueOf(mobAdManager.getSdkVerCode());
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String appId, @NonNull String appName) {
        init(context, adProviderType, appId, appName, null);
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void setIdMapOppo(Map<String, String> map) {
        idMapOppo = map;
    }

    public final void setInitDone(boolean z) {
        initDone = z;
    }

    public final void updatePersonAd(boolean enablePersonal) {
        if (initDone) {
            WifiLog.d("oppoManager updateCSJSDKPersonAd enablePersonal " + enablePersonal);
        }
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String appId, @NonNull String appName, Map<String, String> oppoIdMap) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean isCanUseMacAddress;
        SdkPrivilegeController sdkPrivilegeController;
        TogetherAd togetherAd = TogetherAd.INSTANCE;
        String name = NestOppoProvider.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "NestOppoProvider::class.java.name");
        togetherAd.addProvider(new AdProviderEntity(adProviderType, name, null, 4, null));
        if (oppoIdMap != null) {
            idMapOppo = oppoIdMap;
        }
        WifiLog.d("NestOppoManager oppoAd init debug = " + debug + " WkInitManager thread " + Thread.currentThread());
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        HashMap<String, SdkPrivilegeController> sdkPrivilegeControllerS = wifiNestAd.getSdkPrivilegeControllerS();
        SdkPrivilegeController.Companion companion = SdkPrivilegeController.INSTANCE;
        if (!sdkPrivilegeControllerS.containsKey(companion.getSDK_OPPO()) || (sdkPrivilegeController = wifiNestAd.getSdkPrivilegeControllerS().get(companion.getSDK_OPPO())) == null) {
            z = true;
            z2 = true;
            z3 = true;
            z4 = true;
            z5 = true;
            z6 = true;
            isCanUseMacAddress = true;
        } else {
            boolean isCanUseLocation = sdkPrivilegeController.getIsCanUseLocation();
            boolean isCanUseInstalledPackages = sdkPrivilegeController.getIsCanUseInstalledPackages();
            boolean isCanUsePhoneState = sdkPrivilegeController.getIsCanUsePhoneState();
            boolean isCanUseAndroidId = sdkPrivilegeController.getIsCanUseAndroidId();
            boolean isCanUseWriteExternal = sdkPrivilegeController.getIsCanUseWriteExternal();
            boolean isCanUseWifiState = sdkPrivilegeController.getIsCanUseWifiState();
            isCanUseMacAddress = sdkPrivilegeController.getIsCanUseMacAddress();
            z = isCanUseLocation;
            z2 = isCanUseInstalledPackages;
            z3 = isCanUsePhoneState;
            z4 = isCanUseAndroidId;
            z5 = isCanUseWriteExternal;
            z6 = isCanUseWifiState;
        }
        InitParams initParamsBuild = new InitParams.Builder().setDebug(debug).setMobCustomController(new OppoDefaultController(context, z, z2, z3, z4, z5, z6, isCanUseMacAddress)).setClassifyByAgeProvider(new OppoAgeProvider("ADULT")).build();
        Intrinsics.checkExpressionValueIsNotNull(initParamsBuild, "InitParams.Builder()\n   …ge))\n            .build()");
        MobAdManager.getInstance().init(context, appId, initParamsBuild);
        initDone = true;
        wifiNestAd.setOppoInit(true);
    }
}
