package cn.jiguang.api;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import defpackage.fy4;
import defpackage.l63;
import defpackage.ow2;
import defpackage.uw2;
import defpackage.yd1;
import defpackage.zv2;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class JCoreInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f2447a = null;
    public static String b = "cn.jpush.android.intent.DaemonService";

    static {
        JCoreManager.addDispatchAction("JPUSH", uw2.class.getName());
    }

    public static void a(Context context, String str, int i, byte[] bArr, int i2, boolean z) {
        if (bArr != null) {
            try {
                if (bArr.length > 24) {
                    byte[] bArr2 = new byte[24];
                    byte[] bArr3 = new byte[bArr.length - 24];
                    System.arraycopy(bArr, 0, bArr2, 0, 24);
                    System.arraycopy(bArr, 24, bArr3, 0, bArr.length - 24);
                    ow2 ow2Var = new ow2(true, bArr2);
                    Bundle bundle = new Bundle();
                    bundle.putInt("cmd", ow2Var.a());
                    bundle.putInt("ver", ow2Var.e());
                    bundle.putLong("rid", ow2Var.c().longValue());
                    bundle.putLong(WkAdConfigModel.TAG_TIMEOUT, i2);
                    bundle.putByteArray("body", bArr3);
                    JCoreManager.onEvent(context, str, z ? 17 : 50, null, bundle, new Object[0]);
                }
            } catch (Throwable th) {
                l63.b("JCoreInterface", "send failed:" + th.getMessage());
            }
        }
    }

    public static void asyncExecute(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 12, null, null, runnable);
    }

    public static boolean canCallDirect() {
        return false;
    }

    public static void execute(String str, Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 11, str, null, runnable);
    }

    public static JSONObject fillBaseReport(JSONObject jSONObject, String str) {
        Object objOnEvent = JCoreManager.onEvent(null, null, 26, null, null, jSONObject, str);
        if (objOnEvent instanceof JSONObject) {
            return (JSONObject) objOnEvent;
        }
        return null;
    }

    public static String getAccountId() {
        Object objOnEvent = JCoreManager.onEvent(null, null, 5, null, null, new Object[0]);
        return objOnEvent instanceof String ? (String) objOnEvent : "";
    }

    public static String getAppKey() {
        Object objOnEvent = JCoreManager.onEvent(f2447a, null, 7, null, null, new Object[0]);
        return objOnEvent instanceof String ? (String) objOnEvent : "";
    }

    public static String getChannel() {
        Object objOnEvent = JCoreManager.onEvent(f2447a, null, 6, null, null, new Object[0]);
        return objOnEvent instanceof String ? (String) objOnEvent : "";
    }

    public static String getCommonConfigAppkey() {
        Object objOnEvent = JCoreManager.onEvent(f2447a, null, 7, null, null, new Object[0]);
        return objOnEvent instanceof String ? (String) objOnEvent : "";
    }

    public static boolean getConnectionState(Context context) {
        return JCoreManager.getConnectionState(f2447a);
    }

    public static String getDaemonAction() {
        return b;
    }

    public static boolean getDebugMode() {
        return JCoreManager.getDebugMode();
    }

    public static String getDeviceId(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, null, 8, null, null, new Object[0]);
        return objOnEvent instanceof String ? (String) objOnEvent : "";
    }

    public static String getHttpConfig(Context context, String str) {
        return "";
    }

    public static int getJCoreSDKVersionInt() {
        Object objOnEvent = JCoreManager.onEvent(null, null, 25, null, null, new Object[0]);
        if (objOnEvent instanceof Integer) {
            return ((Integer) objOnEvent).intValue();
        }
        return 0;
    }

    public static long getNextRid() {
        return fy4.e(f2447a);
    }

    public static String getRegistrationID(Context context) {
        Object objOnEvent = JCoreManager.onEvent(context, null, 4, null, null, new Object[0]);
        return objOnEvent instanceof String ? (String) objOnEvent : "";
    }

    public static long getReportTime() {
        Object objOnEvent = JCoreManager.onEvent(f2447a, null, 19, null, null, new Object[0]);
        return objOnEvent instanceof Long ? ((Long) objOnEvent).longValue() : System.currentTimeMillis() / 1000;
    }

    public static boolean getRuningFlag() {
        try {
            return Build.BRAND.equals("nubia");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int getSid() {
        return 0;
    }

    public static long getUid() {
        Object objOnEvent = JCoreManager.onEvent(f2447a, null, 20, null, null, new Object[0]);
        if (objOnEvent instanceof Long) {
            return ((Long) objOnEvent).longValue();
        }
        return 0L;
    }

    public static boolean init(Context context) {
        if (context != null) {
            f2447a = context;
        }
        JCoreManager.init(context);
        return true;
    }

    public static void initAction(String str, Class<? extends JAction> cls) {
        yd1.c().a(str, cls.getName());
    }

    public static void initActionExtra(String str, Class<? extends JActionExtra> cls) {
        yd1.c().b(str, cls.getName());
    }

    public static void initCrashHandler(Context context) {
        JCoreManager.initCrashHandler(context);
    }

    public static boolean isTcpConnected() {
        return JCoreManager.getConnectionState(f2447a);
    }

    public static boolean isValidRegistered() {
        Object objOnEvent = JCoreManager.onEvent(f2447a, null, 21, null, null, new Object[0]);
        if (objOnEvent instanceof Boolean) {
            return ((Boolean) objOnEvent).booleanValue();
        }
        return false;
    }

    public static void onFragmentPause(Context context, String str) {
        JCoreManager.onEvent(context, SdkType.JPUSH.name(), 56, "f_pause", null, str);
    }

    public static void onFragmentResume(Context context, String str) {
        JCoreManager.onEvent(context, SdkType.JPUSH.name(), 56, "f_resume", null, str);
    }

    public static void onKillProcess(Context context) {
        JCoreManager.onEvent(context, SdkType.JPUSH.name(), 56, "kill", null, new Object[0]);
    }

    public static void onPause(Context context) {
        JCoreManager.onEvent(context, SdkType.JPUSH.name(), 56, "pause", null, new Object[0]);
    }

    public static void onResume(Context context) {
        JCoreManager.onEvent(context, SdkType.JPUSH.name(), 56, az.ag, null, new Object[0]);
    }

    public static void processCtrlReport(int i) {
        JCoreManager.onEvent(null, null, 24, null, null, Integer.valueOf(i));
    }

    public static void putSingleExecutor(String str) {
        JCoreManager.onEvent(null, null, 13, str, null, new Object[0]);
    }

    public static void register(Context context) {
        l63.a("JCoreInterface", "Action - init registerOnly:");
        if (context != null) {
            f2447a = context;
        }
        JCoreManager.init(context);
    }

    public static void report(Context context, JSONObject jSONObject, boolean z) {
        JCoreManager.onEvent(context, "JSupport", 14, null, null, jSONObject);
    }

    public static boolean reportHttpData(Context context, Object obj, String str) {
        JCoreManager.onEvent(context, str, 14, null, null, obj);
        return true;
    }

    public static void requestPermission(Context context) {
        JCoreManager.requestPermission(context);
    }

    public static void restart(Context context, String str, Bundle bundle, boolean z) {
        JCoreManager.onEvent(context, str, 1, null, null, new Object[0]);
    }

    public static void sendAction(Context context, String str, Bundle bundle) {
        if (bundle != null) {
            try {
                JCoreManager.onEvent(context, str, 3, bundle.getString("action"), bundle, new Object[0]);
            } catch (Throwable th) {
                l63.b("JCoreInterface", "sendAction failed:" + th);
            }
        }
    }

    public static void sendData(Context context, String str, int i, byte[] bArr) {
        a(context, str, i, bArr, 0, false);
    }

    public static void sendRequestData(Context context, String str, int i, byte[] bArr) {
        a(context, str, 0, bArr, i, true);
    }

    public static void setAccountId(String str) {
        JCoreManager.onEvent(null, null, 22, str, null, new Object[0]);
    }

    public static void setAnalysisAction(JAnalyticsAction jAnalyticsAction) {
        if (jAnalyticsAction != null) {
            JCoreManager.setAnalysisAction(jAnalyticsAction);
        }
    }

    public static void setDaemonAction(String str) {
        b = str;
    }

    public static void setDebugMode(boolean z) {
        JCoreManager.setDebugMode(z);
    }

    public static void setTestConnIPPort(String str, int i) {
        l63.a("JCoreInterface", "Action - setTestConnIPPort ip:" + str + " port:" + i);
    }

    public static void setWakeEnable(Context context, boolean z) {
        JCoreManager.onEvent(context, null, 73, null, null, Boolean.valueOf(z));
    }

    public static Bundle si(Context context, int i, Bundle bundle) {
        if (context != null) {
            f2447a = context.getApplicationContext();
        }
        return zv2.a(context, i, bundle);
    }

    public static void stop(Context context, String str, Bundle bundle) {
        JCoreManager.onEvent(context, str, 0, null, null, new Object[0]);
    }

    public static void stopCrashHandler(Context context) {
        JCoreManager.stopCrashHandler(context);
    }

    public static void testCountryCode(String str) {
        JCoreManager.onEvent(null, null, 23, str, null, new Object[0]);
    }

    public static void triggerSceneCheck(Context context, int i) {
        JCoreManager.onEvent(context, null, 29, null, null, Integer.valueOf(i));
    }

    public static void setCanLaunchedStoppedService(boolean z) {
    }

    public static void setTestConn(boolean z) {
    }

    public static void setPowerSaveMode(Context context, boolean z) {
    }
}
