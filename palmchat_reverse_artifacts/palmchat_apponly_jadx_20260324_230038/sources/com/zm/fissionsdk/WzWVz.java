package com.zm.fissionsdk;

import android.content.Context;
import android.util.Log;
import com.zm.adxsdk.protocol.api.WfConfig;
import com.zm.adxsdk.protocol.api.WfSensitivityController;
import com.zm.adxsdk.protocol.api.WfUnityConfig;
import com.zm.adxsdk.protocol.api.interfaces.ILoginListener;
import com.zm.adxsdk.protocol.api.interfaces.IUnityCallback;
import com.zm.adxsdk.protocol.api.interfaces.IWfRuntime;
import com.zm.adxsdk.protocol.api.interfaces.IWfWechatMiniPListener;
import com.zm.fissionsdk.VZV2Z;
import com.zm.fissionsdk.api.FissionConfig;
import com.zm.fissionsdk.api.FissionSdk;
import com.zm.fissionsdk.api.FissionSensitivityController;
import com.zm.fissionsdk.api.FissionUnityConfig;
import com.zm.fissionsdk.api.interfaces.IFissionLoginListener;
import com.zm.fissionsdk.api.interfaces.IFissionRuntime;
import com.zm.fissionsdk.api.interfaces.IFissionUnityCallback;
import com.zm.fissionsdk.api.interfaces.IFissionWxMiniProgramListener;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WzWVz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f16740a;
    public static String b;

    /* JADX INFO: compiled from: SearchBox */
    public class Z2WzW implements IWfWechatMiniPListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionWxMiniProgramListener f16741a;

        public Z2WzW(IFissionWxMiniProgramListener iFissionWxMiniProgramListener) {
            this.f16741a = iFissionWxMiniProgramListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfWechatMiniPListener
        public void onLaunchWechatMinProgram(String str, String str2) {
            onLaunchWechatMinProgram(str, str2, "");
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfWechatMiniPListener
        public void onLaunchWxOpenBusinessView(String str, String str2) {
            this.f16741a.onLaunchWxOpenBusinessView(str, str2);
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfWechatMiniPListener
        public void onLaunchWechatMinProgram(String str, String str2, String str3) {
            this.f16741a.onLaunchWechatMinProgram(str, str2, str3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class Z2ZWz implements IUnityCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionUnityCallback f16742a;

        public Z2ZWz(IFissionUnityCallback iFissionUnityCallback) {
            this.f16742a = iFissionUnityCallback;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IUnityCallback
        public void onInitFailed(String str) {
            IFissionUnityCallback iFissionUnityCallback = this.f16742a;
            if (iFissionUnityCallback != null) {
                iFissionUnityCallback.onInitFailed(str);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IUnityCallback
        public void onInitSuccess() {
            IFissionUnityCallback iFissionUnityCallback = this.f16742a;
            if (iFissionUnityCallback != null) {
                iFissionUnityCallback.onInitSuccess();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ZV2Zz implements IWfRuntime {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionRuntime f16743a;
        public final /* synthetic */ FissionConfig b;

        /* JADX INFO: compiled from: SearchBox */
        public class zZZ2W implements IFissionLoginListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f16744a;

            public zZZ2W(Object obj) {
                this.f16744a = obj;
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoginListener
            public void onLoginFail() {
                Object obj = this.f16744a;
                if (obj instanceof ILoginListener) {
                    ((ILoginListener) obj).onLoginFail();
                }
            }

            @Override // com.zm.fissionsdk.api.interfaces.IFissionLoginListener
            public void onLoginSuccess(String str) {
                Object obj = this.f16744a;
                if (obj instanceof ILoginListener) {
                    ((ILoginListener) obj).onLoginSuccess(str);
                }
            }
        }

        public ZV2Zz(IFissionRuntime iFissionRuntime, FissionConfig fissionConfig) {
            this.f16743a = iFissionRuntime;
            this.b = fissionConfig;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getAndroidId() {
            return this.f16743a.getAndroidId();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public List<String> getAppList() {
            return null;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getBssid() {
            return "";
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public int getCarrier() {
            return this.f16743a.getCarrier();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getDHid() {
            return "";
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public int getDeviceType() {
            return this.f16743a.getDeviceType();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public int getGeoType() {
            return 0;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getImei() {
            return this.f16743a.getImei();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getIp() {
            return "";
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public double getLatitude() {
            return this.f16743a.getLatitude();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public double getLongitude() {
            return this.f16743a.getLongitude();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getMac() {
            return this.f16743a.getMac();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public int getNetworkType() {
            return this.f16743a.getNetworkType();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getOAid() {
            return this.f16743a.getOAid();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getSSid() {
            return "";
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getUhid() {
            return "";
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getUid() {
            return this.f16743a.getUid();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public String getUserAgent() {
            try {
                Object globalConfig = this.b.getGlobalConfig("userAgent");
                if (!(globalConfig instanceof String)) {
                    return null;
                }
                Log.d("FissionSdkManager", "ua:" + globalConfig);
                return (String) globalConfig;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public boolean isHttps() {
            return false;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public boolean isLogin() {
            return this.f16743a.isLogin();
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IWfRuntime
        public void toLogin(Object obj) {
            this.f16743a.toLogin(new zZZ2W(obj));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class zZZ2W implements VZV2Z.zZZ2W {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FissionSdk.InitCallback f16745a;

        public zZZ2W(FissionSdk.InitCallback initCallback) {
            this.f16745a = initCallback;
        }

        @Override // com.zm.fissionsdk.VZV2Z.zZZ2W
        public void onFailed(int i, String str) {
            FissionSdk.InitCallback initCallback = this.f16745a;
            if (initCallback != null) {
                initCallback.onFailed(i, str);
            }
        }

        @Override // com.zm.fissionsdk.VZV2Z.zZZ2W
        public void onSuccess() {
            FissionSdk.InitCallback initCallback = this.f16745a;
            if (initCallback != null) {
                initCallback.onSuccess();
            }
        }
    }

    public static boolean a() {
        return VZV2Z.g();
    }

    public static String a(String str) {
        String strA = Wzzz2.a(f16740a + b + str + UUID.randomUUID() + System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append("requestId:");
        sb.append(strA);
        Log.d("FissionSdkManager", sb.toString());
        return strA;
    }

    public static void a(Context context, FissionConfig fissionConfig, FissionSdk.InitCallback initCallback) {
        VZV2Z.a(context, a(fissionConfig), new zZZ2W(initCallback));
    }

    public static WfConfig a(FissionConfig fissionConfig) {
        boolean zBooleanValue;
        Object globalConfig;
        WfConfig.Builder builder = new WfConfig.Builder();
        if (fissionConfig != null) {
            f16740a = fissionConfig.getToken();
            b = fissionConfig.getAppId();
            try {
                globalConfig = fissionConfig.getGlobalConfig("personalRecommend");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (globalConfig instanceof Boolean) {
                Log.d("FissionSdkManager", "recommend:" + globalConfig);
                zBooleanValue = ((Boolean) globalConfig).booleanValue();
            } else {
                zBooleanValue = false;
            }
            builder.setToken(f16740a).setAppId(b).setAppName(fissionConfig.getAppName()).setChannel(fissionConfig.getChannel()).setAllowShowNotification(fissionConfig.allowShowNotification()).setWxApiVer(fissionConfig.getWxApiVer()).setWxOpensdkVer(fissionConfig.getWxOpensdkVer()).setShowDownloadToast(fissionConfig.isShowDownloadToast()).setDebug(fissionConfig.isDebug()).setUseFdaCrash(true).setUseFda(true).setRecommend(zBooleanValue).setGlobalConfig(fissionConfig.getAllGlobalConfig()).setSupportMultiProcess(fissionConfig.isSupportMultiProcess());
            FissionSensitivityController sensitivityController = fissionConfig.getSensitivityController();
            if (sensitivityController != null) {
                builder.setSensitivityController(new WfSensitivityController.Builder().setCanGetAppList(sensitivityController.canGetAppList()).setCanGetAndroidId(sensitivityController.canGetAndroidId()).setCanGetOaid(sensitivityController.canGetOaid()).setCanReadPhoneState(sensitivityController.canReadPhoneState()).setCanGetNetworkState(sensitivityController.canGetNetworkState()).setCanGetLocation(sensitivityController.canGetLocation()).build());
            }
            IFissionRuntime fissionRuntime = fissionConfig.getFissionRuntime();
            if (fissionRuntime != null) {
                builder.setWfRuntime(new ZV2Zz(fissionRuntime, fissionConfig));
            }
            IFissionWxMiniProgramListener wxMiniProgramListener = fissionConfig.getWxMiniProgramListener();
            if (wxMiniProgramListener != null) {
                builder.setWechatMiniPListener(new Z2WzW(wxMiniProgramListener));
            }
            WfUnityConfig wfUnityConfigA = a(fissionConfig.getUnityConfig());
            if (wfUnityConfigA != null) {
                builder.setUnityConfig(wfUnityConfigA);
            }
        }
        return builder.build();
    }

    public static WfUnityConfig a(FissionUnityConfig fissionUnityConfig) {
        if (fissionUnityConfig == null) {
            return null;
        }
        WfUnityConfig.Builder preloadGameCenter = new WfUnityConfig.Builder().setAppKey(fissionUnityConfig.getAppKey()).setAppSecret(fissionUnityConfig.getAppSecret()).setPreloadGameCenter(fissionUnityConfig.isPreloadGameCenter());
        IFissionUnityCallback callback = fissionUnityConfig.getCallback();
        if (callback != null) {
            preloadGameCenter.setCallback(new Z2ZWz(callback));
        }
        return preloadGameCenter.build();
    }
}
