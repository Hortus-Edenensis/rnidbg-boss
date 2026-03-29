package com.wifi.lxad.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.wifi.ad.core.SdkPrivilegeController;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.WxMiniProgramListener;
import com.wifi.ad.core.callback.RealLocationCallBack;
import com.wifi.ad.core.entity.AdProviderEntity;
import com.wifi.ad.core.reporter.AbstractReporter;
import com.wifi.ad.core.utils.WifiLog;
import com.wifi.adsdk.LxAdConfig;
import com.wifi.adsdk.LxAdSdk;
import com.wifi.adsdk.listener.ILxAdWxMiniProgramListener;
import com.wifi.adsdk.params.ILxAdGetLocation;
import com.wifi.adsdk.params.ILxAdReporter;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.cordova.jssdk.general.Action;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ.\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\u001c2\b\b\u0001\u0010\"\u001a\u00020\u001c2\b\b\u0001\u0010#\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001cJ\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/wifi/lxad/ad/NestLxAdManager;", "", "()V", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "debugUrl", "getDebugUrl", "setDebugUrl", Action.ACTION_GET_LOCATION, "Lcom/wifi/ad/core/callback/RealLocationCallBack;", "getGetLocation", "()Lcom/wifi/ad/core/callback/RealLocationCallBack;", "setGetLocation", "(Lcom/wifi/ad/core/callback/RealLocationCallBack;)V", "initDone", "getInitDone", "setInitDone", "reporter", "Lcom/wifi/ad/core/reporter/AbstractReporter;", "getReporter", "()Lcom/wifi/ad/core/reporter/AbstractReporter;", "setReporter", "(Lcom/wifi/ad/core/reporter/AbstractReporter;)V", "getVersion", "", "init", "", "context", "Landroid/content/Context;", "adProviderType", "appId", WfConstant.EVENT_KEY_APP_NAME, "onDestroyAll", "result", "updatePersonAd", "enablePersonal", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestLxAdManager {
    public static final NestLxAdManager INSTANCE = new NestLxAdManager();
    private static boolean debug;
    private static boolean debugUrl;
    private static RealLocationCallBack getLocation;
    private static boolean initDone;
    private static AbstractReporter reporter;

    private NestLxAdManager() {
    }

    public final boolean getDebug() {
        return debug;
    }

    public final boolean getDebugUrl() {
        return debugUrl;
    }

    public final RealLocationCallBack getGetLocation() {
        return getLocation;
    }

    public final boolean getInitDone() {
        return initDone;
    }

    public final AbstractReporter getReporter() {
        return reporter;
    }

    public final String getVersion() {
        String version = LxAdSdk.getVersion();
        Intrinsics.checkExpressionValueIsNotNull(version, "LxAdSdk.getVersion()");
        return version;
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String appId, @NonNull String appName) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean isCanUseMacAddress;
        SdkPrivilegeController sdkPrivilegeController;
        TogetherAd togetherAd = TogetherAd.INSTANCE;
        String name = NestLxAdProvider.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "NestLxAdProvider::class.java.name");
        togetherAd.addProvider(new AdProviderEntity(adProviderType, name, null, 4, null));
        WifiLog.d("NestLxAdManager WkInitManager Ad init debug = " + debug + " thread " + Thread.currentThread() + " reporter " + reporter + " getLocation " + getLocation + " debugUrl " + debugUrl);
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        HashMap<String, SdkPrivilegeController> sdkPrivilegeControllerS = wifiNestAd.getSdkPrivilegeControllerS();
        SdkPrivilegeController.Companion companion = SdkPrivilegeController.INSTANCE;
        if (!sdkPrivilegeControllerS.containsKey(companion.getSDK_LXAD()) || (sdkPrivilegeController = wifiNestAd.getSdkPrivilegeControllerS().get(companion.getSDK_LXAD())) == null) {
            z = true;
            z2 = true;
            z3 = true;
            z4 = true;
            z5 = true;
            isCanUseMacAddress = true;
        } else {
            boolean isCanUseInstalledPackages = sdkPrivilegeController.getIsCanUseInstalledPackages();
            boolean isCanUsePhoneState = sdkPrivilegeController.getIsCanUsePhoneState();
            boolean isCanUseAndroidId = sdkPrivilegeController.getIsCanUseAndroidId();
            boolean isCanUseWriteExternal = sdkPrivilegeController.getIsCanUseWriteExternal();
            boolean isCanUseWifiState = sdkPrivilegeController.getIsCanUseWifiState();
            isCanUseMacAddress = sdkPrivilegeController.getIsCanUseMacAddress();
            z5 = isCanUseWifiState;
            z4 = isCanUseWriteExternal;
            z3 = isCanUseAndroidId;
            z2 = isCanUsePhoneState;
            z = isCanUseInstalledPackages;
        }
        LxAdSdk.init(context, new LxAdConfig.Builder(context).setDebugMode(debug).setDebugUrl(debugUrl).setAppId(appId).setAppName(appName).setToken(wifiNestAd.getLxadtoken()).setWxMiniProgramListener(new ILxAdWxMiniProgramListener() { // from class: com.wifi.lxad.ad.NestLxAdManager$init$adConfig$1
            @Override // com.wifi.adsdk.listener.ILxAdWxMiniProgramListener
            public boolean onLaunchWechatMinProgram(String userName, String path, String result) {
                WxMiniProgramListener wxMiniProgramListener = WifiNestAd.INSTANCE.getWxMiniProgramListener();
                Boolean boolValueOf = wxMiniProgramListener != null ? Boolean.valueOf(wxMiniProgramListener.onLaunchWechatMinProgram(userName, path)) : null;
                WifiLog.d("NestLxAdManager onLaunchWechatMinProgram result " + boolValueOf);
                if (boolValueOf instanceof Boolean) {
                    return boolValueOf.booleanValue();
                }
                return true;
            }

            @Override // com.wifi.adsdk.listener.ILxAdWxMiniProgramListener
            public void onLaunchWxOpenBusinessView(String var1, String var2) {
            }
        }).setGetLocation(new ILxAdGetLocation() { // from class: com.wifi.lxad.ad.NestLxAdManager$init$adConfig$2
            @Override // com.wifi.adsdk.params.ILxAdGetLocation
            public String getLatitude() {
                NestLxAdManager nestLxAdManager = NestLxAdManager.INSTANCE;
                if (nestLxAdManager.getGetLocation() == null) {
                    return "0.0";
                }
                RealLocationCallBack getLocation2 = nestLxAdManager.getGetLocation();
                if (getLocation2 == null) {
                    Intrinsics.throwNpe();
                }
                return getLocation2.getLatitude();
            }

            @Override // com.wifi.adsdk.params.ILxAdGetLocation
            public String getLongitude() {
                NestLxAdManager nestLxAdManager = NestLxAdManager.INSTANCE;
                if (nestLxAdManager.getGetLocation() == null) {
                    return "0.0";
                }
                RealLocationCallBack getLocation2 = nestLxAdManager.getGetLocation();
                if (getLocation2 == null) {
                    Intrinsics.throwNpe();
                }
                return getLocation2.getLongitude();
            }
        }).setReporter(new ILxAdReporter() { // from class: com.wifi.lxad.ad.NestLxAdManager$init$adConfig$3
            @Override // com.wifi.adsdk.params.ILxAdReporter
            public final void onEvent(String str, String str2) {
                if (str != null) {
                    NestLxAdManager nestLxAdManager = NestLxAdManager.INSTANCE;
                    if (nestLxAdManager.getReporter() != null) {
                        if (str2 == null) {
                            str2 = "";
                        }
                        AbstractReporter reporter2 = nestLxAdManager.getReporter();
                        if (reporter2 != null) {
                            reporter2.onEvent(str, str2);
                        }
                    }
                }
            }
        }).setLxAppRunTime(new LxAdRealControl(context, z, z2, z3, z4, z5, isCanUseMacAddress)).build());
        initDone = true;
        wifiNestAd.setLxAdInit(true);
        WifiLog.d("NestLxAdManager WkInitManager Ad init success");
    }

    public final void onDestroyAll(String result) {
        if (initDone) {
            WifiLog.d("NestLxAdManager onDestroyAll result " + result);
            LxAdSdk.onDestroy();
        }
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void setDebugUrl(boolean z) {
        debugUrl = z;
    }

    public final void setGetLocation(RealLocationCallBack realLocationCallBack) {
        getLocation = realLocationCallBack;
    }

    public final void setInitDone(boolean z) {
        initDone = z;
    }

    public final void setReporter(AbstractReporter abstractReporter) {
        reporter = abstractReporter;
    }

    public final void updatePersonAd(boolean enablePersonal) {
        if (initDone) {
            WifiLog.d("NestLxAdManager updatePersonAd enablePersonal " + enablePersonal);
        }
    }
}
