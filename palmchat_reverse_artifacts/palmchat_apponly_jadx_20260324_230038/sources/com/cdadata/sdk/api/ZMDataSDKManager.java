package com.cdadata.sdk.api;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Message;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.c57;
import defpackage.d67;
import defpackage.e67;
import defpackage.f57;
import defpackage.g57;
import defpackage.h57;
import defpackage.j67;
import defpackage.n57;
import defpackage.n67;
import defpackage.o57;
import defpackage.o67;
import defpackage.q57;
import defpackage.q67;
import defpackage.r67;
import defpackage.t57;
import defpackage.w57;
import defpackage.x47;
import defpackage.x57;
import defpackage.y47;
import defpackage.z47;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ZMDataSDKManager {
    private static final String TAG = "CDADataSDKManager";
    private static volatile ZMDataSDKManager sInstance;
    private z47 mCallBack;
    private Context mContext;
    public h57 mEventTaskManager;
    public n57 mEventTaskManagerThread;
    public IAppParams mIAppParams;
    public x47.c stringCallback = new x47.c() { // from class: com.cdadata.sdk.api.ZMDataSDKManager.1
        @Override // defpackage.x47
        public void onFailure(int i, String str) {
            g57.b("远程配置", "获取失败==" + i + "==" + str);
        }

        @Override // defpackage.x47
        public void onResponse(String str) {
            JSONObject jSONObjectOptJSONObject;
            try {
                g57.b("远程配置", str);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                if (!"0".equals(jSONObject.optString("code")) || jSONObject.optJSONObject("result") == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("result").optJSONObject("configs")) == null) {
                    return;
                }
                c57.l().j(jSONObjectOptJSONObject.toString());
            } catch (JSONException | Exception e) {
                e.printStackTrace();
            }
        }

        @Override // defpackage.x47
        public void onAfter() {
        }
    };
    public ZMConfigOptions zmConfigOptions;
    private t57 zmEventWorker;

    private ZMDataSDKManager() {
    }

    public static ZMDataSDKManager getInstance() {
        if (sInstance == null) {
            synchronized (ZMDataSDKManager.class) {
                if (sInstance == null) {
                    sInstance = new ZMDataSDKManager();
                }
            }
        }
        return sInstance;
    }

    private void registerLifecycleCallbacks(Context context) {
        try {
            Application application = (Application) context.getApplicationContext();
            this.mCallBack = new z47(context);
            application.registerActivityLifecycleCallbacks(q67.a());
            application.registerActivityLifecycleCallbacks(this.mCallBack);
            z47 z47Var = this.mCallBack;
            f57 f57Var = f57.b;
            if (z47Var != null) {
                List<q57> list = f57.c;
                if (list.contains(z47Var)) {
                    return;
                }
                list.add(z47Var);
            }
        } catch (Exception e) {
            g57.a(e);
        }
    }

    public void enableUploadDataToServer(boolean z) {
        ZMConfigOptions zMConfigOptions = this.zmConfigOptions;
        if (zMConfigOptions != null) {
            zMConfigOptions.isUploadEnable = z;
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054 A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:4:0x0017, B:7:0x001e, B:8:0x0027, B:10:0x002d, B:18:0x0045, B:32:0x0071, B:33:0x0074, B:21:0x004b, B:22:0x0054, B:24:0x0059, B:29:0x0069, B:25:0x005f, B:28:0x0066, B:31:0x006f, B:34:0x0078), top: B:39:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        e67.s(this.mContext, jSONObject);
        e67.e(this.mContext, jSONObject);
        String string = jSONObject.toString();
        if (string == null) {
            return "";
        }
        try {
            if ("".equals(string)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            char c = 0;
            boolean z = false;
            int i2 = 0;
            while (i < string.length()) {
                char cCharAt = string.charAt(i);
                if (cCharAt != '\"') {
                    if (cCharAt == ',') {
                        sb.append(cCharAt);
                        if (c != '\\' && !z) {
                            sb.append('\n');
                            e67.f(sb, i2);
                        }
                    } else if (cCharAt == '{') {
                        sb.append(cCharAt);
                        if (!z) {
                            sb.append('\n');
                            i2++;
                            e67.f(sb, i2);
                        }
                    } else if (cCharAt != '}') {
                        switch (cCharAt) {
                            case ']':
                                if (!z) {
                                    sb.append('\n');
                                    i2--;
                                    e67.f(sb, i2);
                                }
                                break;
                        }
                    }
                    i++;
                    c = cCharAt;
                } else if (c != '\\') {
                    z = !z;
                }
                sb.append(cCharAt);
                i++;
                c = cCharAt;
            }
            return sb.toString();
        } catch (Exception e) {
            g57.a(e);
            return "";
        }
    }

    public z47 getZMDataActivityLifecycleCallbacks() {
        return this.mCallBack;
    }

    public t57 getZmUploadEvent() {
        return this.zmEventWorker;
    }

    public void init(Context context, ZMConfigOptions zMConfigOptions, IAppParams iAppParams) {
        t57 t57Var;
        String[] strArrE;
        this.mContext = context;
        r67 r67VarA = r67.a();
        r67VarA.getClass();
        r67VarA.f20404a = context.getSharedPreferences("ZM_CDA_SP_DATA", 0);
        if (TextUtils.isEmpty(r67.a().c("pid", ""))) {
            r67 r67VarA2 = r67.a();
            String strReplace = UUID.randomUUID().toString().replace("-", "");
            synchronized (r67VarA2) {
                r67VarA2.f20404a.edit().putString("pid", strReplace).apply();
            }
        }
        this.mIAppParams = iAppParams;
        y47.k().d = this.mIAppParams;
        this.zmConfigOptions = zMConfigOptions;
        try {
            c57 c57VarL = c57.l();
            c57VarL.getClass();
            try {
                strArrE = c57VarL.c.e(o57.a().v, 1, true);
            } catch (Exception e) {
                g57.a(e);
            }
            String str = (strArrE == null || strArrE.length <= 0) ? "" : strArrE[0];
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!TextUtils.isEmpty(jSONObject.optString("reportURL"))) {
                        zMConfigOptions.reportUrl = jSONObject.optString("reportURL");
                    }
                    if (!TextUtils.isEmpty(jSONObject.optString("flushEncryptType"))) {
                        zMConfigOptions.securityType = jSONObject.optString("flushEncryptType");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        Context context2 = this.mContext;
        Map<Context, t57> map = t57.f;
        synchronized (map) {
            Context applicationContext = context2.getApplicationContext();
            if (map.containsKey(applicationContext)) {
                t57Var = map.get(applicationContext);
            } else {
                t57Var = new t57(applicationContext, zMConfigOptions);
                map.put(applicationContext, t57Var);
            }
        }
        this.zmEventWorker = t57Var;
        this.mEventTaskManager = h57.a();
        startTrackThread();
        if (f57.b == null) {
            synchronized (f57.class) {
                if (f57.b == null) {
                    f57.b = new f57();
                }
            }
        }
        registerLifecycleCallbacks(context);
        registerNetworkListener(context);
        registerScreenListener(context);
        initGPS(context);
        startDelayUploadData();
        x47.c cVar = this.stringCallback;
        try {
            String str2 = getInstance().zmConfigOptions.configUrl;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("platform", AnalyticsConstants.SDK_TYPE);
            jSONObject2.put("appId", getInstance().zmConfigOptions.appId);
            jSONObject2.put("sdkVersion", "2.0.6");
            jSONObject2.put("channel", AnalyticsConstants.SDK_TYPE);
            new n67(str2, null, jSONObject2.toString(), null, 1, cVar);
        } catch (Exception e4) {
            g57.a(e4);
        }
    }

    public void initGPS(Context context) {
        d67.a(context, new x57() { // from class: com.cdadata.sdk.api.ZMDataSDKManager.2
            @Override // defpackage.x57
            public void callBackLocation(String str, String str2) {
                y47.k().b = str;
                y47.k().c = str2;
            }
        });
    }

    public void registerNetworkListener(final Context context) {
        this.mEventTaskManager.b(new Runnable() { // from class: com.cdadata.sdk.api.ZMDataSDKManager.5
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                try {
                    if (e67.d == null) {
                        e67.d = new j67();
                    }
                    NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
                    ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        connectivityManager.registerNetworkCallback(networkRequestBuild, e67.d);
                        g57.b("NetworkUtils", "Register ConnectivityManager");
                    }
                } catch (Exception e) {
                    g57.a(e);
                }
            }
        });
    }

    public void registerScreenListener(final Context context) {
        this.mEventTaskManager.b(new Runnable() { // from class: com.cdadata.sdk.api.ZMDataSDKManager.4
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                e67.e = new o67();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                context2.registerReceiver(e67.e, intentFilter);
            }
        });
    }

    public void startDelayUploadData() {
        this.mEventTaskManager.b(new Runnable() { // from class: com.cdadata.sdk.api.ZMDataSDKManager.3
            @Override // java.lang.Runnable
            public void run() {
                t57 zmUploadEvent = ZMDataSDKManager.getInstance().getZmUploadEvent();
                zmUploadEvent.getClass();
                try {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 5;
                    zmUploadEvent.f20908a.a(messageObtain, 0L);
                } catch (Exception e) {
                    g57.b("CDAEventWorker", "flushEventUpload error:" + e);
                }
            }
        });
    }

    public void startTrackThread() {
        n57 n57Var = this.mEventTaskManagerThread;
        if (n57Var == null || n57Var.c) {
            this.mEventTaskManagerThread = new n57();
            new Thread(this.mEventTaskManagerThread, "CDAEventTaskQueueThread").start();
        }
    }

    public void stopEventThread() {
        n57 n57Var = this.mEventTaskManagerThread;
        if (n57Var == null || n57Var.c) {
            return;
        }
        n57Var.c = true;
        if (n57Var.f19443a.f17875a.isEmpty()) {
            n57Var.f19443a.b(new w57(n57Var));
        }
    }

    public void unregisterNetworkListener(final Context context) {
        this.mEventTaskManager.b(new Runnable() { // from class: com.cdadata.sdk.api.ZMDataSDKManager.6
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                Context context2 = context;
                try {
                    if (e67.d == null || (connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity")) == null) {
                        return;
                    }
                    connectivityManager.unregisterNetworkCallback(e67.d);
                    g57.b("NetworkUtils", "unregister ConnectivityManager");
                } catch (Exception e) {
                    g57.a(e);
                }
            }
        });
    }
}
