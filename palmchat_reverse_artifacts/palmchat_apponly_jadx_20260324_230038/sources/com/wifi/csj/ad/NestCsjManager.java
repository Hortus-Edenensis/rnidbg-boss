package com.wifi.csj.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.SdkPrivilegeController;
import com.wifi.ad.core.TogetherAd;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.callback.CsjInitCallBack;
import com.wifi.ad.core.entity.AdProviderEntity;
import com.wifi.ad.core.utils.WifiLog;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\u001a2\u0006\u0010,\u001a\u00020\u001aH\u0002J\u0006\u0010-\u001a\u00020\u001aJ8\u0010.\u001a\u00020/2\b\b\u0001\u00100\u001a\u0002012\b\b\u0001\u00102\u001a\u00020\u001a2\b\b\u0001\u00103\u001a\u00020\u001a2\b\b\u0001\u00104\u001a\u00020\u001a2\b\b\u0001\u00105\u001a\u000206JP\u0010.\u001a\u00020/2\b\b\u0001\u00100\u001a\u0002012\b\b\u0001\u00102\u001a\u00020\u001a2\b\b\u0001\u00103\u001a\u00020\u001a2\b\b\u0001\u00104\u001a\u00020\u001a2\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\b\b\u0001\u00105\u001a\u000206J\u0006\u00108\u001a\u00020\u0004J\u0010\u00109\u001a\u00020/2\u0006\u0010,\u001a\u00020\u001aH\u0002J\u000e\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\b¨\u0006<"}, d2 = {"Lcom/wifi/csj/ad/NestCsjManager;", "", "()V", "allowShowNotify", "", "getAllowShowNotify", "()Z", "setAllowShowNotify", "(Z)V", "allowShowPageWhenScreenLock", "getAllowShowPageWhenScreenLock", "setAllowShowPageWhenScreenLock", "asyncInit", "getAsyncInit", "setAsyncInit", "debug", "getDebug", "setDebug", "directDownloadNetworkType", "", "getDirectDownloadNetworkType", "()I", "setDirectDownloadNetworkType", "(I)V", "idMapCsj", "", "", "getIdMapCsj", "()Ljava/util/Map;", "setIdMapCsj", "(Ljava/util/Map;)V", "initDone", "getInitDone", "setInitDone", "supportMultiProcess", "getSupportMultiProcess", "setSupportMultiProcess", "titleBarTheme", "getTitleBarTheme", "setTitleBarTheme", "useTextureView", "getUseTextureView", "setUseTextureView", "getData", "personalTypeValue", "getVersion", "init", "", "context", "Landroid/content/Context;", "adProviderType", "csjAdAppId", WfConstant.EVENT_KEY_APP_NAME, "initCallBack", "Lcom/wifi/ad/core/callback/CsjInitCallBack;", "csjIdMap", "isLocationComplianceOpen", "updateData", "updatePersonAd", "enablePersonal", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class NestCsjManager {
    private static boolean asyncInit;
    private static boolean debug;
    private static boolean initDone;
    private static boolean supportMultiProcess;
    public static final NestCsjManager INSTANCE = new NestCsjManager();
    private static Map<String, String> idMapCsj = MapsKt__MapsKt.emptyMap();
    private static boolean useTextureView = true;
    private static int titleBarTheme = 1;
    private static boolean allowShowNotify = true;
    private static boolean allowShowPageWhenScreenLock = true;
    private static int directDownloadNetworkType = 5;

    private NestCsjManager() {
    }

    private final String getData(String personalTypeValue) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put(ActionUtils.PAYMENT_AMOUNT, personalTypeValue);
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(NestCsjManager nestCsjManager, Context context, String str, String str2, String str3, Map map, CsjInitCallBack csjInitCallBack, int i, Object obj) {
        if ((i & 16) != 0) {
            map = null;
        }
        nestCsjManager.init(context, str, str2, str3, map, csjInitCallBack);
    }

    private final void updateData(String personalTypeValue) {
        try {
            TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(getData(personalTypeValue)).build());
        } catch (Throwable unused) {
        }
    }

    public final boolean getAllowShowNotify() {
        return allowShowNotify;
    }

    public final boolean getAllowShowPageWhenScreenLock() {
        return allowShowPageWhenScreenLock;
    }

    public final boolean getAsyncInit() {
        return asyncInit;
    }

    public final boolean getDebug() {
        return debug;
    }

    public final int getDirectDownloadNetworkType() {
        return directDownloadNetworkType;
    }

    public final Map<String, String> getIdMapCsj() {
        return idMapCsj;
    }

    public final boolean getInitDone() {
        return initDone;
    }

    public final boolean getSupportMultiProcess() {
        return supportMultiProcess;
    }

    public final int getTitleBarTheme() {
        return titleBarTheme;
    }

    public final boolean getUseTextureView() {
        return useTextureView;
    }

    public final String getVersion() {
        TTAdManager adManager = TTAdSdk.getAdManager();
        Intrinsics.checkExpressionValueIsNotNull(adManager, "TTAdSdk.getAdManager()");
        String sDKVersion = adManager.getSDKVersion();
        Intrinsics.checkExpressionValueIsNotNull(sDKVersion, "TTAdSdk.getAdManager().sdkVersion");
        return sDKVersion;
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String csjAdAppId, @NonNull String appName, @NonNull CsjInitCallBack initCallBack) {
        init(context, adProviderType, csjAdAppId, appName, null, initCallBack);
    }

    public final boolean isLocationComplianceOpen() {
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        if (wifiNestAd.getTaiChikeys() == null) {
            return false;
        }
        String taiChikeys = wifiNestAd.getTaiChikeys();
        if (taiChikeys == null) {
            Intrinsics.throwNpe();
        }
        return StringsKt__StringsKt.contains$default((CharSequence) taiChikeys, (CharSequence) "LX-34227", false, 2, (Object) null);
    }

    public final void setAllowShowNotify(boolean z) {
        allowShowNotify = z;
    }

    public final void setAllowShowPageWhenScreenLock(boolean z) {
        allowShowPageWhenScreenLock = z;
    }

    public final void setAsyncInit(boolean z) {
        asyncInit = z;
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void setDirectDownloadNetworkType(int i) {
        directDownloadNetworkType = i;
    }

    public final void setIdMapCsj(Map<String, String> map) {
        idMapCsj = map;
    }

    public final void setInitDone(boolean z) {
        initDone = z;
    }

    public final void setSupportMultiProcess(boolean z) {
        supportMultiProcess = z;
    }

    public final void setTitleBarTheme(int i) {
        titleBarTheme = i;
    }

    public final void setUseTextureView(boolean z) {
        useTextureView = z;
    }

    public final void updatePersonAd(boolean enablePersonal) {
        if (initDone) {
            WifiLog.d("csjManager updateCSJSDKPersonAd enablePersonal " + enablePersonal);
            if (enablePersonal) {
                updateData("1");
            } else {
                updateData("0");
            }
        }
    }

    public final void init(@NonNull Context context, @NonNull String adProviderType, @NonNull String csjAdAppId, @NonNull String appName, Map<String, String> csjIdMap, @NonNull final CsjInitCallBack initCallBack) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean isCanUseMacAddress;
        SdkPrivilegeController sdkPrivilegeController;
        TogetherAd togetherAd = TogetherAd.INSTANCE;
        String name = NestCsjProvider.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "NestCsjProvider::class.java.name");
        togetherAd.addProvider(new AdProviderEntity(adProviderType, name, null, 4, null));
        if (csjIdMap != null) {
            idMapCsj = csjIdMap;
        }
        TTAdConfig.Builder builder = new TTAdConfig.Builder();
        builder.appId(csjAdAppId);
        builder.appName(appName);
        builder.titleBarTheme(titleBarTheme);
        builder.allowShowNotify(allowShowNotify);
        builder.debug(debug);
        builder.directDownloadNetworkType(directDownloadNetworkType);
        builder.supportMultiProcess(supportMultiProcess);
        WifiNestAd wifiNestAd = WifiNestAd.INSTANCE;
        HashMap<String, SdkPrivilegeController> sdkPrivilegeControllerS = wifiNestAd.getSdkPrivilegeControllerS();
        SdkPrivilegeController.Companion companion = SdkPrivilegeController.INSTANCE;
        if (!sdkPrivilegeControllerS.containsKey(companion.getSDK_CSJ()) || (sdkPrivilegeController = wifiNestAd.getSdkPrivilegeControllerS().get(companion.getSDK_CSJ())) == null) {
            z = true;
            z2 = true;
            z3 = true;
            z4 = true;
            z5 = true;
            z6 = true;
            z7 = true;
            z8 = true;
            isCanUseMacAddress = true;
        } else {
            boolean isCanUseLocation = sdkPrivilegeController.getIsCanUseLocation();
            boolean isCanUseInstalledPackages = sdkPrivilegeController.getIsCanUseInstalledPackages();
            boolean isCanUsePhoneState = sdkPrivilegeController.getIsCanUsePhoneState();
            boolean isCanUseAndroidId = sdkPrivilegeController.getIsCanUseAndroidId();
            boolean isCanUsePermissionRecordAudio = sdkPrivilegeController.getIsCanUsePermissionRecordAudio();
            boolean isCanUseWriteExternal = sdkPrivilegeController.getIsCanUseWriteExternal();
            boolean isCanUseWifiState = sdkPrivilegeController.getIsCanUseWifiState();
            boolean isCanUseOaid = sdkPrivilegeController.getIsCanUseOaid();
            isCanUseMacAddress = sdkPrivilegeController.getIsCanUseMacAddress();
            z = isCanUseLocation;
            z2 = isCanUseInstalledPackages;
            z3 = isCanUsePhoneState;
            z4 = isCanUseAndroidId;
            z5 = isCanUsePermissionRecordAudio;
            z6 = isCanUseWriteExternal;
            z7 = isCanUseWifiState;
            z8 = isCanUseOaid;
        }
        builder.customController(new CsjDefaultController(context, z, z2, z3, z4, z5, z6, z7, z8, isCanUseMacAddress));
        TTAdSdk.init(context, builder.build());
        TTAdSdk.start(new TTAdSdk.Callback() { // from class: com.wifi.csj.ad.NestCsjManager.init.2
            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int p0, String p1) {
                WifiLog.d("NestCsjManager init fail ");
                initCallBack.onInitFail(p0, p1);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                WifiLog.d("NestCsjManager init success ");
                initCallBack.onInitSuccess();
            }
        });
        initDone = true;
        wifiNestAd.setCsjInit(true);
        WifiLog.d("NestCsjManager init debug = " + debug + " asyncInit = " + asyncInit + " WkInitManager thread " + Thread.currentThread());
    }
}
