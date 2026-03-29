package com.wifi.feisuo.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.WxMiniProgramListener;
import com.wifi.ad.core.entity.AdProviderEntity;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.WifiLog;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import com.zm.fissionsdk.api.FissionConfig;
import com.zm.fissionsdk.api.FissionSdk;
import com.zm.fissionsdk.api.FissionSensitivityController;
import com.zm.fissionsdk.api.interfaces.IFissionWxMiniProgramListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000bJ.\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u000b2\b\b\u0001\u0010\u001b\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u000bJF\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u000b2\b\b\u0001\u0010\u001b\u001a\u00020\u000b2\b\b\u0001\u0010\u001c\u001a\u00020\u000b2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006 "}, d2 = {"Lcom/wifi/feisuo/ad/NestFeiSuoManager;", "", "()V", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "idMapFeiSuo", "", "", "getIdMapFeiSuo", "()Ljava/util/Map;", "setIdMapFeiSuo", "(Ljava/util/Map;)V", "initDone", "getInitDone", "setInitDone", "getSensitivityController", "Lcom/zm/fissionsdk/api/FissionSensitivityController;", "getVersion", "init", "", "context", "Landroid/content/Context;", "adProviderType", "appId", WfConstant.EVENT_KEY_APP_NAME, "qumengIdMap", "updatePersonAd", "enablePersonal", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestFeiSuoManager {
    private static boolean debug;
    private static boolean initDone;
    public static final NestFeiSuoManager INSTANCE = new NestFeiSuoManager();
    private static Map<String, String> idMapFeiSuo = MapsKt__MapsKt.emptyMap();

    private NestFeiSuoManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(NestFeiSuoManager nestFeiSuoManager, Context context, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 16) != 0) {
            map = null;
        }
        nestFeiSuoManager.init(context, str, str2, str3, map);
    }

    public final boolean getDebug() {
        return debug;
    }

    public final Map<String, String> getIdMapFeiSuo() {
        return idMapFeiSuo;
    }

    public final boolean getInitDone() {
        return initDone;
    }

    public final FissionSensitivityController getSensitivityController() {
        FissionSensitivityController fissionSensitivityControllerBuild = new FissionSensitivityController.Builder().setCanGetAndroidId(false).setCanGetLocation(false).setCanGetNetworkState(false).setCanGetAppList(false).setCanGetOaid(false).setCanReadPhoneState(false).build();
        Intrinsics.checkExpressionValueIsNotNull(fissionSensitivityControllerBuild, "FissionSensitivityContro…PhoneState(false).build()");
        return fissionSensitivityControllerBuild;
    }

    public final String getVersion() {
        String sdkVersionName = FissionSdk.getSdkVersionName();
        Intrinsics.checkExpressionValueIsNotNull(sdkVersionName, "FissionSdk.getSdkVersionName()");
        return sdkVersionName;
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String appId, @NonNull String appName) {
        init(context, adProviderType, appId, appName, null);
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void setIdMapFeiSuo(Map<String, String> map) {
        idMapFeiSuo = map;
    }

    public final void setInitDone(boolean z) {
        initDone = z;
    }

    public final void updatePersonAd(boolean enablePersonal) {
        if (initDone) {
            WifiLog.d("NestFeiSuoManager updatePersonAd enablePersonal " + enablePersonal);
        }
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String appId, @NonNull String appName, Map<String, String> qumengIdMap) {
        TogetherAd togetherAd = TogetherAd.INSTANCE;
        String name = NestFeiSuoProvider.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "NestFeiSuoProvider::class.java.name");
        togetherAd.addProvider(new AdProviderEntity(adProviderType, name, null, 4, null));
        if (qumengIdMap != null) {
            idMapFeiSuo = qumengIdMap;
        }
        WifiLog.d("NestFeiSuoManager WkInitManager Ad init debug = " + debug + " thread " + Thread.currentThread());
        FissionConfig.Builder builder = new FissionConfig.Builder();
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        FissionSdk.init(context, builder.setToken(wifiNestAd.getFeisuotoken()).setAppId(appId).setAppName("连信").setChannel(wifiNestAd.getFeisuochannel()).setAllowShowNotification(true).setShowDownloadToast(true).setFissionRuntime(new FSRealControl(context)).addGlobalConfig("userAgent", NestInfoTaker.INSTANCE.getUA()).setWxMiniProgramListener(new IFissionWxMiniProgramListener() { // from class: com.wifi.feisuo.ad.NestFeiSuoManager$init$config$1
            @Override // com.zm.fissionsdk.api.interfaces.IFissionWxMiniProgramListener
            public void onLaunchWechatMinProgram(String userName, String path, String result) {
                WxMiniProgramListener wxMiniProgramListener = WifiNestAd.INSTANCE.getWxMiniProgramListener();
                if (wxMiniProgramListener != null) {
                    wxMiniProgramListener.onLaunchWechatMinProgram(userName, path);
                }
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionWxMiniProgramListener
            public void onLaunchWxOpenBusinessView(String p0, String p1) {
            }
        }).setSensitivityController(getSensitivityController()).build(), new FissionSdk.InitCallback() { // from class: com.wifi.feisuo.ad.NestFeiSuoManager.init.2
            @Override // com.zm.fissionsdk.api.FissionSdk.InitCallback
            public void onSuccess() {
            }

            @Override // com.zm.fissionsdk.api.FissionSdk.InitCallback
            public void onFailed(int p0, String p1) {
            }
        });
        initDone = true;
        wifiNestAd.setFeisuoInit(true);
        WifiLog.d("NestFeiSuoManager WkInitManager Ad init success");
    }
}
