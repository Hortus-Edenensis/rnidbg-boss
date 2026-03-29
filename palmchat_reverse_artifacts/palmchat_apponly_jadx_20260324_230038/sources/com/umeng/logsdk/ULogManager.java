package com.umeng.logsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.wifi.ad.core.config.DeviceInfoUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ULogManager {
    public static final String TAG = "CodeLogManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f11114a = null;
    private static ULogConfigManager b = null;
    private static EfsReporter c = null;
    private static boolean d = false;
    private static String e = "";
    private static String f = "";
    private static long h = 0;
    private static long i = 0;
    public static boolean isDebug = true;
    private static JSONArray g = new JSONArray();
    private static Handler j = new Handler(Looper.getMainLooper()) { // from class: com.umeng.logsdk.ULogManager.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 0) {
                ULogManager.a(message);
            } else {
                if (i2 != 1) {
                    return;
                }
                ULogManager.e();
            }
        }
    };
    private static int k = 0;

    public static /* synthetic */ int b() {
        int i2 = k;
        k = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int d() {
        int i2 = k;
        k = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        JSONObject jSONObject;
        Throwable th;
        if (g.length() > 0) {
            i = System.currentTimeMillis();
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("taskid", "");
                    jSONObject.put("status", 0);
                    jSONObject.put("time_start", h);
                    jSONObject.put("time_end", i);
                    jSONObject.put(DeviceInfoUtil.UID_TAG, c.b(getUserID().getBytes()));
                    jSONObject.put("did", getDeviceID());
                    jSONObject.put("body", g);
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                }
            } catch (Throwable th3) {
                jSONObject = null;
                th = th3;
            }
            if (jSONObject != null) {
                EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_CODELOGPERF);
                efsJSONLog.setLogBeginTime(h);
                efsJSONLog.setLogEndTime(i);
                efsJSONLog.put("codelog", jSONObject);
                EfsReporter reporter = getReporter();
                if (reporter != null) {
                    Log.i(TAG, "upload and send.");
                    reporter.send(efsJSONLog);
                    g = new JSONArray();
                }
            }
        }
    }

    public static String getDeviceID() {
        return e;
    }

    public static EfsReporter getReporter() {
        return c;
    }

    public static ULogConfigManager getULogConfigManager() {
        return b;
    }

    public static String getUserID() {
        return f;
    }

    public static void i(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 2;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString("message", str2);
        message.setData(bundle);
        j.sendMessage(message);
    }

    public static void init(Context context, EfsReporter efsReporter) {
        try {
            Log.i(TAG, "begin init code log.");
            if (context != null && efsReporter != null) {
                if (isInit()) {
                    if (isDebug) {
                        Log.e(TAG, "invalid init ！");
                        return;
                    }
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                f11114a = applicationContext;
                c = efsReporter;
                b = new ULogConfigManager(applicationContext, efsReporter);
                registerActivityCallback(context);
                d = true;
                if (isDebug) {
                    Log.i(TAG, "finish init code log.");
                    return;
                }
                return;
            }
            if (isDebug) {
                Log.e(TAG, "init code log manager error! parameter is null!");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean isInit() {
        return d;
    }

    public static void registerActivityCallback(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.logsdk.ULogManager.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStarted(Activity activity) {
                    ULogManager.b();
                    if (ULogManager.k == 1) {
                        Log.i(ULogManager.TAG, "code log. listener front.");
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStopped(Activity activity) {
                    ULogManager.d();
                    if (ULogManager.k == 0) {
                        Log.i(ULogManager.TAG, "code log. listener background.");
                        ULogManager.e();
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityResumed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }
            });
        }
    }

    public static void setDeviceID(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 128) {
            e = str;
        } else if (isDebug) {
            Log.e(TAG, "device id over length!");
        }
    }

    public static void setUserID(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 128) {
            f = c.a(str.getBytes());
        } else if (isDebug) {
            Log.e(TAG, "user id over length!");
        }
    }

    public static void v(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 0;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString("message", str2);
        message.setData(bundle);
        j.sendMessage(message);
    }

    public static void w(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 3;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString("message", str2);
        message.setData(bundle);
        j.sendMessage(message);
    }

    public static /* synthetic */ void a(Message message) {
        String str;
        String str2;
        JSONObject jSONObject;
        if (message == null || message.getData() == null) {
            str = "writeMemory msg or msg data is null!";
        } else {
            Bundle data = message.getData();
            if (data != null) {
                String string = data.getString("tag");
                String string2 = data.getString("message");
                boolean z = false;
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                    if (isDebug) {
                        str2 = "ULog parameter null!";
                        Log.e(TAG, str2);
                    }
                } else if (string.length() > a.f11116a || string2.length() > a.b) {
                    if (isDebug) {
                        str2 = "ULog tag or message over length!";
                        Log.e(TAG, str2);
                    }
                } else if (isInit()) {
                    if (!TextUtils.isEmpty(getDeviceID()) || !TextUtils.isEmpty(getUserID())) {
                        z = true;
                    } else if (isDebug) {
                        str2 = "ULog not set device id or user id!";
                        Log.e(TAG, str2);
                    }
                } else if (isDebug) {
                    str2 = "ULog not init!";
                    Log.e(TAG, str2);
                }
                if (z) {
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tag", string);
                            jSONObject.put("msg", string2);
                            jSONObject.put("level", message.arg1);
                            jSONObject.put("time", System.currentTimeMillis());
                            jSONObject.put("process", ProcessUtil.getCurrentProcessName());
                            jSONObject.put("thread", Thread.currentThread().getName());
                        } catch (Throwable th) {
                            th = th;
                            jSONObject2 = jSONObject;
                            th.printStackTrace();
                            jSONObject = jSONObject2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (jSONObject != null) {
                        if (g.length() == 0) {
                            h = System.currentTimeMillis();
                        }
                        g.put(jSONObject);
                        Log.i(TAG, "add mem is " + jSONObject.toString());
                    }
                    if (g.toString().getBytes().length >= 18432) {
                        Log.i(TAG, "over max size upload. size is " + g.toString().getBytes().length);
                        e();
                        return;
                    }
                    return;
                }
                return;
            }
            str = "writeMemory bundle is null!";
        }
        Log.e(TAG, str);
    }

    public static void d(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 1;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString("message", str2);
        message.setData(bundle);
        j.sendMessage(message);
    }

    public static void e(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 4;
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        bundle.putString("message", str2);
        message.setData(bundle);
        j.sendMessage(message);
    }
}
