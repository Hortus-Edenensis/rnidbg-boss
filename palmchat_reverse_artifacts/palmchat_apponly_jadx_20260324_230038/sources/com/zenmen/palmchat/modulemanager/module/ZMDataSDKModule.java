package com.zenmen.palmchat.modulemanager.module;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.common.C;
import com.cdadata.sdk.api.IAppParams;
import com.cdadata.sdk.api.ZMConfigOptions;
import com.cdadata.sdk.api.ZMDataSDKManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.SmidHelper;
import defpackage.ac1;
import defpackage.hx3;
import defpackage.me1;
import defpackage.wb1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ZMDataSDKModule extends AbsModule {
    private static final String CONFIG_URL_RELEASE = "http://track-config.y5kfpt.com/openApi/trackShipmaster/v1/sdkConfigInfo/fetchConfig";
    private static final String REPORT_URL_RELEASE = "http://track-gateway.y5kfpt.com/api/oceantunnel/v1/trackData/collect";

    private static String exec(String str) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    String string = sb.toString();
                    try {
                        bufferedReader.close();
                    } catch (Throwable th) {
                        Log.d(AbsModule.TAG, th.getMessage());
                    }
                    try {
                        inputStreamReader.close();
                    } catch (IOException e) {
                        Log.d(AbsModule.TAG, e.getMessage());
                    }
                    return string;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        Log.d(AbsModule.TAG, th.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th3) {
                                Log.d(AbsModule.TAG, th3.getMessage());
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e2) {
                                Log.d(AbsModule.TAG, e2.getMessage());
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
        }
    }

    public static String getCPU_ABI() {
        try {
            String str = "";
            for (String str2 : Build.SUPPORTED_ABIS) {
                str = str + str2 + ",";
            }
            if (str != null) {
                return str.substring(0, str.length() - 1).trim().toLowerCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getHarmonyOSVersion() {
        if (!wb1.h()) {
            return null;
        }
        String prop = getProp("hw_sc.build.platform.version", "");
        return TextUtils.isEmpty(prop) ? exec("getprop hw_sc.build.platform.version") : prop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMemorySizeImp() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) AppContext.getContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem + "";
    }

    public static String getOSVersionImp() {
        String[] strArr = new String[2];
        try {
            String harmonyOSVersion = getHarmonyOSVersion();
            if (TextUtils.isEmpty(harmonyOSVersion)) {
                strArr[0] = AnalyticsConstants.SDK_TYPE;
                strArr[1] = Build.VERSION.RELEASE;
            } else {
                strArr[0] = "HarmonyOS";
                strArr[1] = harmonyOSVersion;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArr[1];
    }

    private static String getProp(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initZMDataSDK(Application application) {
        ZMConfigOptions.Builder builder = new ZMConfigOptions.Builder(application);
        builder.setReportUrl(REPORT_URL_RELEASE);
        builder.setConfigUrl(CONFIG_URL_RELEASE);
        builder.setAppId("HSFJKZ");
        builder.setChannelId(ac1.m);
        builder.setFlushTime(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        builder.enableDebug(Boolean.FALSE);
        builder.enableGPS(false);
        builder.enableAndroidid(false);
        builder.enableImei(false);
        builder.enableMac(false);
        builder.enableSn(false);
        builder.enableInstallApp(false);
        ZMDataSDKManager.getInstance().init(application, builder.build(), new IAppParams() { // from class: com.zenmen.palmchat.modulemanager.module.ZMDataSDKModule.2
            private String cpuAbi = null;
            private String oSVersion = null;
            private Locale locale = null;
            private TimeZone timeZone = null;
            private String memorySize = null;

            @Override // com.cdadata.sdk.api.IAppParams
            public String getAndroidId() {
                return ac1.p;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getBoard() {
                return Build.BOARD;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getBrand() {
                return Build.BRAND;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getCapBssid() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getCapSsid() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getCarrier() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getCpuAbi() {
                if (this.cpuAbi == null) {
                    this.cpuAbi = ZMDataSDKModule.getCPU_ABI();
                }
                return this.cpuAbi;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getCpuCore() {
                return String.valueOf(Runtime.getRuntime().availableProcessors());
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getDHID() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getDevice() {
                return Build.DEVICE;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getDid() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getDisplay() {
                return Build.DISPLAY;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getEpid() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getEsid() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getFingerPrint() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getHardware() {
                return Build.HARDWARE;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getHost() {
                return Build.HOST;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getICCID() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getIMEI() {
                return ac1.i;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getIMSI() {
                return ac1.j;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getId() {
                return Build.ID;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getIncremental() {
                return Build.VERSION.INCREMENTAL;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getInstallApp() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getLanguage() {
                if (this.locale == null) {
                    this.locale = Locale.getDefault();
                }
                Locale locale = this.locale;
                if (locale != null) {
                    return locale.toString();
                }
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getLatitude() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getLoginId() {
                return AccountUtils.p(AppContext.getContext());
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getLongitude() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getMAC() {
                return ac1.k;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getMEID() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getManufacturer() {
                return Build.MANUFACTURER;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getMapsp() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getMaxCpuHZ() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getMemorySize() {
                if (this.memorySize == null) {
                    this.memorySize = ZMDataSDKModule.this.getMemorySizeImp();
                }
                return this.memorySize;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getModel() {
                return Build.MODEL;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getNetWorkType() {
                return hx3.e();
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getOAID() {
                return MdidSdkConfigHelper.getInstance().getOAID();
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getOS() {
                return wb1.h() ? "harmony" : AnalyticsConstants.SDK_TYPE;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getOSVersion() {
                if (this.oSVersion == null) {
                    this.oSVersion = ZMDataSDKModule.getOSVersionImp();
                }
                return this.oSVersion;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getProduct() {
                return Build.PRODUCT;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getProductId() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getRadio() {
                return Build.getRadioVersion();
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getResolution() {
                return me1.e();
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getSN() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getTags() {
                return Build.TAGS;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getThirdID() {
                return SmidHelper.o();
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getTimeZone() {
                if (this.timeZone == null) {
                    this.timeZone = TimeZone.getDefault();
                }
                if (this.timeZone == null) {
                    return null;
                }
                return this.timeZone.getDisplayName(false, 0) + " " + this.timeZone.getID();
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getType() {
                return Build.TYPE;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getUid() {
                return null;
            }

            @Override // com.cdadata.sdk.api.IAppParams
            public String getUser() {
                return Build.USER;
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isNeedCheckPrivacyAgree() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isOnlyInitOnMainProcess() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationCreate(final Application application) {
        asyncExecute("ZMDataSDKModule", new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.ZMDataSDKModule.1
            @Override // java.lang.Runnable
            public void run() {
                ZMDataSDKModule.this.initZMDataSDK(application);
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }

    public static void updateEnable() {
    }
}
