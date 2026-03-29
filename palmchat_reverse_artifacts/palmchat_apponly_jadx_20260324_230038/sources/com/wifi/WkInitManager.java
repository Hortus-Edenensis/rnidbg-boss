package com.wifi;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.ccg.a;
import com.wifi.ad.core.utils.WifiLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u00020\u0005H\u0002J\u0010\u0010N\u001a\u00020#2\u0006\u0010M\u001a\u00020\u0005H\u0002J\u0016\u0010O\u001a\u00020#2\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u0006\u0010R\u001a\u00020#J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0005H\u0002J\u0016\u0010(\u001a\u00020T2\u0006\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020#J\u000e\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020ZR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0012R\u001a\u00105\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0010\"\u0004\b7\u0010\u0012R\u0011\u00108\u001a\u000209¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0010\"\u0004\b>\u0010\u0012R\u001a\u0010?\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0012R\u000e\u0010B\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/wifi/WkInitManager;", "", "()V", "activitySdkNames", "", "", "getActivitySdkNames", "()Ljava/util/List;", "setActivitySdkNames", "(Ljava/util/List;)V", "appSdkNames", "getAppSdkNames", "setAppSdkNames", "bdDelayTime", "", "getBdDelayTime", "()J", "setBdDelayTime", "(J)V", "beiziDelayTime", "getBeiziDelayTime", "setBeiziDelayTime", "csjDelayTime", "getCsjDelayTime", "setCsjDelayTime", "fsDelayTime", "getFsDelayTime", "setFsDelayTime", "gdtDelayTime", "getGdtDelayTime", "setGdtDelayTime", "huaweiDelayTime", "getHuaweiDelayTime", "setHuaweiDelayTime", "initActivity", "", "getInitActivity", "()Z", "setInitActivity", "(Z)V", "initAllConfig", "getInitAllConfig", "()Ljava/lang/String;", "setInitAllConfig", "(Ljava/lang/String;)V", "initSdkTimeTaiValue", "getInitSdkTimeTaiValue", "setInitSdkTimeTaiValue", "key_initActivity", "key_initApp", "ksDelayTime", "getKsDelayTime", "setKsDelayTime", "lxadDelayTime", "getLxadDelayTime", "setLxadDelayTime", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "oppoDelayTime", "getOppoDelayTime", "setOppoDelayTime", "qumengDelayTime", "getQumengDelayTime", "setQumengDelayTime", "sdk_bd", "sdk_bz", "sdk_csj", "sdk_fs", "sdk_gdt", "sdk_huawei", "sdk_ks", "sdk_lxad", "sdk_oppo", "sdk_qm", "allowActivityInitSDK", "name", "allowAppInitSDK", "allowInitSDK", "fromName", "sdkName", "allowSdkTimeDelay", "dftConfig", "", "allConfig", "adAllConfig", "initActivityAll", "initSdkDelayTime", "initSdkTimeArray", "Lorg/json/JSONArray;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WkInitManager {
    private static long bdDelayTime = 0;
    private static long beiziDelayTime = 0;
    private static long csjDelayTime = 0;
    private static long fsDelayTime = 0;
    private static long gdtDelayTime = 0;
    private static long huaweiDelayTime = 0;
    private static boolean initActivity = false;
    public static final String key_initActivity = "activityInit";
    public static final String key_initApp = "appInit";
    private static long ksDelayTime = 0;
    private static long lxadDelayTime = 0;
    private static long oppoDelayTime = 0;
    private static long qumengDelayTime = 0;
    public static final String sdk_bd = "bd";
    public static final String sdk_bz = "beizi";
    public static final String sdk_csj = "csj";
    public static final String sdk_fs = "feisuo";
    public static final String sdk_gdt = "gdt";
    public static final String sdk_huawei = "huawei";
    public static final String sdk_ks = "ks";
    public static final String sdk_lxad = "lxad";
    public static final String sdk_oppo = "oppo";
    public static final String sdk_qm = "qumeng";
    public static final WkInitManager INSTANCE = new WkInitManager();
    private static String initAllConfig = "{\"appInit\":[\"csj\",\"gdt\",\"ks\",\"bd\",\"oppo\",\"huawei\"]}";
    private static List<String> appSdkNames = new ArrayList();
    private static List<String> activitySdkNames = new ArrayList();
    private static String initSdkTimeTaiValue = "A";
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    private WkInitManager() {
    }

    private final boolean allowActivityInitSDK(String name) {
        if (initActivity && activitySdkNames.size() > 0 && !TextUtils.isEmpty(name)) {
            return activitySdkNames.contains(name);
        }
        return false;
    }

    private final boolean allowAppInitSDK(String name) {
        if (initActivity && appSdkNames.size() > 0 && !TextUtils.isEmpty(name)) {
            return appSdkNames.contains(name);
        }
        return true;
    }

    private final void dftConfig(String allConfig) {
        try {
            JSONObject jSONObject = new JSONObject(allConfig);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(key_initApp);
            if (jSONArrayOptJSONArray != null) {
                appSdkNames.clear();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    List<String> list = appSdkNames;
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    Intrinsics.checkExpressionValueIsNotNull(strOptString, "appArray.optString(n)");
                    list.add(strOptString);
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(key_initActivity);
            if (jSONArrayOptJSONArray2 != null) {
                activitySdkNames.clear();
                int length2 = jSONArrayOptJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    List<String> list2 = activitySdkNames;
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                    Intrinsics.checkExpressionValueIsNotNull(strOptString2, "activityArray.optString(n)");
                    list2.add(strOptString2);
                }
            }
        } catch (Exception unused) {
            initActivity = false;
            appSdkNames.clear();
            activitySdkNames.clear();
        }
        Log.d("initAd", "initAd dftConfig appSdkNames " + appSdkNames + " activitySdkNames" + activitySdkNames);
    }

    public final boolean allowInitSDK(String fromName, String sdkName) {
        if (Intrinsics.areEqual(key_initActivity, fromName)) {
            return allowActivityInitSDK(sdkName);
        }
        if (Intrinsics.areEqual(key_initApp, fromName)) {
            return allowAppInitSDK(sdkName);
        }
        return true;
    }

    public final boolean allowSdkTimeDelay() {
        WifiLog.d("WkInitManager initSdkTimeTaiValue " + initSdkTimeTaiValue + ' ');
        return Intrinsics.areEqual("A", initSdkTimeTaiValue) ^ true;
    }

    public final List<String> getActivitySdkNames() {
        return activitySdkNames;
    }

    public final List<String> getAppSdkNames() {
        return appSdkNames;
    }

    public final long getBdDelayTime() {
        return bdDelayTime;
    }

    public final long getBeiziDelayTime() {
        return beiziDelayTime;
    }

    public final long getCsjDelayTime() {
        return csjDelayTime;
    }

    public final long getFsDelayTime() {
        return fsDelayTime;
    }

    public final long getGdtDelayTime() {
        return gdtDelayTime;
    }

    public final long getHuaweiDelayTime() {
        return huaweiDelayTime;
    }

    public final boolean getInitActivity() {
        return initActivity;
    }

    public final String getInitAllConfig() {
        return initAllConfig;
    }

    public final String getInitSdkTimeTaiValue() {
        return initSdkTimeTaiValue;
    }

    public final long getKsDelayTime() {
        return ksDelayTime;
    }

    public final long getLxadDelayTime() {
        return lxadDelayTime;
    }

    public final Handler getMainHandler() {
        return mainHandler;
    }

    public final long getOppoDelayTime() {
        return oppoDelayTime;
    }

    public final long getQumengDelayTime() {
        return qumengDelayTime;
    }

    public final void initAllConfig(String adAllConfig, boolean initActivityAll) {
        initActivity = initActivityAll;
        if (initActivityAll) {
            if (TextUtils.isEmpty(adAllConfig)) {
                dftConfig(initAllConfig);
            } else {
                dftConfig(adAllConfig);
            }
        }
    }

    public final void initSdkDelayTime(JSONArray initSdkTimeArray) {
        if (allowSdkTimeDelay()) {
            int length = initSdkTimeArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = initSdkTimeArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject.optString(a.x);
                long jOptLong = jSONObjectOptJSONObject.optLong("initTime");
                Log.d("", "WkInitManager initSdkDelayTime sdkName " + strOptString + "  delayTime " + jOptLong);
                if (Intrinsics.areEqual("csj", strOptString)) {
                    csjDelayTime = jOptLong;
                } else if (Intrinsics.areEqual("ks", strOptString)) {
                    ksDelayTime = jOptLong;
                } else if (Intrinsics.areEqual(sdk_bd, strOptString)) {
                    bdDelayTime = jOptLong;
                } else if (Intrinsics.areEqual("gdt", strOptString)) {
                    gdtDelayTime = jOptLong;
                } else if (Intrinsics.areEqual("oppo", strOptString)) {
                    oppoDelayTime = jOptLong;
                } else if (Intrinsics.areEqual("huawei", strOptString)) {
                    huaweiDelayTime = jOptLong;
                } else if (Intrinsics.areEqual("qumeng", strOptString)) {
                    qumengDelayTime = jOptLong;
                } else if (Intrinsics.areEqual("beizi", strOptString)) {
                    beiziDelayTime = jOptLong;
                } else if (Intrinsics.areEqual("feisuo", strOptString)) {
                    fsDelayTime = jOptLong;
                } else if (Intrinsics.areEqual("lxad", strOptString)) {
                    lxadDelayTime = jOptLong;
                }
            }
        }
    }

    public final void setActivitySdkNames(List<String> list) {
        activitySdkNames = list;
    }

    public final void setAppSdkNames(List<String> list) {
        appSdkNames = list;
    }

    public final void setBdDelayTime(long j) {
        bdDelayTime = j;
    }

    public final void setBeiziDelayTime(long j) {
        beiziDelayTime = j;
    }

    public final void setCsjDelayTime(long j) {
        csjDelayTime = j;
    }

    public final void setFsDelayTime(long j) {
        fsDelayTime = j;
    }

    public final void setGdtDelayTime(long j) {
        gdtDelayTime = j;
    }

    public final void setHuaweiDelayTime(long j) {
        huaweiDelayTime = j;
    }

    public final void setInitActivity(boolean z) {
        initActivity = z;
    }

    public final void setInitAllConfig(String str) {
        initAllConfig = str;
    }

    public final void setInitSdkTimeTaiValue(String str) {
        initSdkTimeTaiValue = str;
    }

    public final void setKsDelayTime(long j) {
        ksDelayTime = j;
    }

    public final void setLxadDelayTime(long j) {
        lxadDelayTime = j;
    }

    public final void setOppoDelayTime(long j) {
        oppoDelayTime = j;
    }

    public final void setQumengDelayTime(long j) {
        qumengDelayTime = j;
    }
}
