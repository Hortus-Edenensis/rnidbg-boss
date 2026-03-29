package com.zenmen.palmchat.modulemanager.lifecircle;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import com.umeng.analytics.pro.bt;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.login.InitActivity;
import com.zenmen.palmchat.modulemanager.AppStatusReporter;
import com.zenmen.palmchat.modulemanager.InitExceptionHelper;
import com.zenmen.palmchat.modulemanager.LXModuleInitManager;
import com.zenmen.palmchat.modulemanager.TaskExecutorHelper;
import com.zenmen.palmchat.pullwake.pulldialog.a;
import com.zenmen.palmchat.update.UpdateManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.bp4;
import defpackage.br3;
import defpackage.ch;
import defpackage.cn0;
import defpackage.dp4;
import defpackage.ec3;
import defpackage.fn2;
import defpackage.h05;
import defpackage.h65;
import defpackage.ir5;
import defpackage.j36;
import defpackage.jo6;
import defpackage.kc3;
import defpackage.me1;
import defpackage.mo3;
import defpackage.ob4;
import defpackage.oe;
import defpackage.r75;
import defpackage.s34;
import defpackage.sk5;
import defpackage.t5;
import defpackage.ts0;
import defpackage.v4;
import defpackage.vt0;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AppLifeCircleManager {
    public static final String TAG = "AppLifeCircleManager";
    private static AppLifeCircleManager self = new AppLifeCircleManager();
    private boolean isFirstOpen = true;
    private int mForegroundActivityCount = 0;
    private long mBackgroundTime = -1;
    private Activity currentResumedActivity = null;
    private ArrayList<LifeCircleCallback> callBacks = new ArrayList<>();
    private h65 mSessionStorageManager = new h65();

    /* JADX INFO: compiled from: SearchBox */
    public static class BaseLifeCircleCallback implements LifeCircleCallback {
        public static final String TAG = "LXINIT_BaseLifeCircleCallback";
        private LifeCircleCallback callback;

        public BaseLifeCircleCallback(LifeCircleCallback lifeCircleCallback) {
            this.callback = lifeCircleCallback;
        }

        @Override // com.zenmen.palmchat.modulemanager.lifecircle.LifeCircleCallback
        public boolean filter(Activity activity) {
            return this.callback.filter(activity);
        }

        @Override // com.zenmen.palmchat.modulemanager.lifecircle.LifeCircleCallback
        public void onStatusChange(Activity activity, Lifecycle.Event event) {
            long jB = ir5.b();
            try {
                this.callback.onStatusChange(activity, event);
            } catch (Throwable th) {
                th.printStackTrace();
                InitExceptionHelper.onException(InitExceptionHelper.TYPE_LIFE_CIRCLE + this.callback.getClass().getName() + event, th);
            }
            LogUtil.i(TAG, "LifeCircleCallback name=" + this.callback.getClass().getName() + " event=" + event + " init cost" + ir5.e(jB));
        }
    }

    private AppLifeCircleManager() {
        this.callBacks.add(new BaseLifeCircleCallback(new MainTabLifeCircleCallback()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LifeCircleCallback findCallBack(Activity activity) {
        for (LifeCircleCallback lifeCircleCallback : this.callBacks) {
            if (lifeCircleCallback.filter(activity)) {
                return lifeCircleCallback;
            }
        }
        return null;
    }

    public static AppLifeCircleManager getInstance() {
        return self;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logOnAppMoveToFrontOrBack(boolean z, Intent intent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", ac1.c);
            jSONObject.put("channelId", ac1.m);
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(c.b()));
            jSONObject.put("deviceName", ac1.b);
            jSONObject.put("versionName", ac1.g);
            jSONObject.put(az.aW, ac1.f);
            jSONObject.put(WkParams.IMEI, ac1.i);
            jSONObject.put("imsi", ac1.j);
            jSONObject.put("osVersion", ac1.e);
            jSONObject.put("resolution", me1.g() + "-" + me1.f());
            jSONObject.put(bt.P, ac1.l);
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("simulator", ac1.n ? 1 : 0);
            jSONObject.put("androidID", ac1.p);
            jSONObject.put("manufacturer", ac1.f1194a);
            if (intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                if (!TextUtils.isEmpty(data.getQueryParameter("channel"))) {
                    jSONObject.put("channel", data.getQueryParameter("channel"));
                }
                if (!TextUtils.isEmpty(data.getQueryParameter("agent"))) {
                    jSONObject.put("agent", data.getQueryParameter("agent"));
                }
                if (!TextUtils.isEmpty(data.getQueryParameter("referer"))) {
                    jSONObject.put("referer", data.getQueryParameter("referer"));
                }
                if (!TextUtils.isEmpty(data.getQueryParameter("pushid"))) {
                    jSONObject.put("pushid", data.getQueryParameter("pushid"));
                }
                if (!TextUtils.isEmpty(data.getQueryParameter("openURL"))) {
                    jSONObject.put("openURL", data.getQueryParameter("openURL"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String string = jSONObject.toString();
        if (z) {
            LogUtil.uploadInfoImmediate("1000001", "1", null, string);
            zn6.d("lx_client_app_1000001", null, string);
        } else {
            LogUtil.uploadInfoImmediate("1000000", "1", null, string);
            zn6.d("lx_client_app_1000000", null, string);
        }
    }

    private void notifyAppMoveToFrontChange(boolean z, Activity activity) {
        Intent intent = new Intent();
        if (z) {
            intent.setAction(mo3.o);
        } else {
            intent.setAction(mo3.p);
        }
        LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
        if (z) {
            return;
        }
        ec3.j().y(AppContext.getContext(), "update_type_move2back");
    }

    public long getBackgroundTime() {
        return this.mBackgroundTime;
    }

    public Activity getCurrentResumedActivity() {
        return this.currentResumedActivity;
    }

    public h65 getSessionStorageManager() {
        return this.mSessionStorageManager;
    }

    public void initActivityLifecycleCallbacks(final AppContext appContext) {
        appContext.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.zenmen.palmchat.modulemanager.lifecircle.AppLifeCircleManager.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                long jB = ir5.b();
                kc3.c().e(activity);
                t5.f().a(activity);
                dp4.a().c(activity);
                a.b().d(activity);
                if (activity instanceof InitActivity) {
                    if (ts0.o().P(appContext)) {
                        com.zenmen.palmchat.webplatform.a.e();
                    }
                    ec3.j().y(appContext, "update_type_initactivity_create");
                    if (activity.getIntent() != null && activity.getIntent().getData() != null) {
                        AppLifeCircleManager.this.logOnAppMoveToFrontOrBack(true, activity.getIntent());
                    }
                }
                LogUtil.i(AppLifeCircleManager.TAG, "onActivityCreated activity=" + activity + "  cost" + ir5.e(jB));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ob4.a(activity, AppLifeCircleManager.this.isBackground());
                t5.f().n(activity);
                LogUtil.i(AppLifeCircleManager.TAG, "onActivityDestroyed activity=" + activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                AppLifeCircleManager.this.currentResumedActivity = null;
                t5.f().p(activity);
                oe.i().p();
                LogUtil.i(AppLifeCircleManager.TAG, "onActivityPaused activity=" + activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                long jB = ir5.b();
                dp4.a().d(activity);
                AppLifeCircleManager.this.currentResumedActivity = activity;
                oe.i().n(activity);
                if (r75.k()) {
                    r75.s(false);
                }
                if (!(activity instanceof MainTabsActivity)) {
                    AppLifeCircleManager.this.mSessionStorageManager.e(activity.getClass().getName());
                }
                LogUtil.i(AppLifeCircleManager.TAG, "onActivityResumed activity=" + activity + "  cost" + ir5.e(jB));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                long jB = ir5.b();
                boolean zIsBackground = AppLifeCircleManager.this.isBackground();
                AppLifeCircleManager.this.mForegroundActivityCount++;
                if (AppLifeCircleManager.this.mForegroundActivityCount == 1) {
                    AppLifeCircleManager.this.mSessionStorageManager.g();
                }
                int iC = com.zenmen.palmchat.utils.a.E().C();
                if (zIsBackground) {
                    AppLifeCircleManager.this.onAppOpen(activity);
                }
                if (AppLifeCircleManager.this.mForegroundActivityCount == 1 && bp4.s()) {
                    bp4.D(0L);
                    bp4.g();
                    dp4.a().g(2);
                    vt0.d().j(4, new HashMap<String, String>() { // from class: com.zenmen.palmchat.modulemanager.lifecircle.AppLifeCircleManager.2.1
                        {
                            put("dm_wakeupType", bp4.j());
                        }
                    });
                } else if (zIsBackground && !(activity instanceof InitActivity)) {
                    vt0.d().j(2, new HashMap<String, String>(iC) { // from class: com.zenmen.palmchat.modulemanager.lifecircle.AppLifeCircleManager.2.2
                        final /* synthetic */ int val$currentNotificationCount;

                        {
                            this.val$currentNotificationCount = iC;
                            put("dm_notifyCount", String.valueOf(iC));
                        }
                    });
                }
                LogUtil.i(AppLifeCircleManager.TAG, "onActivityStarted activity=" + activity + "  cost" + ir5.e(jB));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                AppLifeCircleManager appLifeCircleManager = AppLifeCircleManager.this;
                appLifeCircleManager.mForegroundActivityCount--;
                ob4.b(activity, AppLifeCircleManager.this.isBackground());
                if (AppLifeCircleManager.this.isBackground()) {
                    AppLifeCircleManager.this.onAppMove2BackGround(activity);
                    AppLifeCircleManager.this.mSessionStorageManager.f();
                }
                LogUtil.i(AppLifeCircleManager.TAG, "onActivityStopped activity=" + activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }
        });
        appContext.registerActivityLifecycleCallbacks(new InnerActivityListener());
    }

    public boolean isBackground() {
        return this.mForegroundActivityCount == 0;
    }

    public void onAppMove2BackGround(Activity activity) {
        kc3.c().h();
        LogUtil.i("AppContext", "onAppMove2BackGroup");
        logOnAppMoveToFrontOrBack(false, null);
        j36.e().n();
        notifyAppMoveToFrontChange(false, activity);
        h05.f();
        s34.j();
        LXModuleInitManager.getInstance().onAppMove2BackGround();
        this.mBackgroundTime = ir5.b();
    }

    public void onAppOpen(Activity activity) {
        fn2 fn2VarU;
        kc3.c().k(activity);
        if (this.isFirstOpen) {
            this.isFirstOpen = false;
        }
        LogUtil.i("AppContext", "onAppOpen");
        logOnAppMoveToFrontOrBack(true, null);
        sk5.d(false);
        if (!this.isFirstOpen && (fn2VarU = ch.s().u()) != null) {
            try {
                fn2VarU.q();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        UpdateManager.G().w();
        j36.e().m();
        cn0.b().c();
        notifyAppMoveToFrontChange(true, activity);
        TaskExecutorHelper.safeRun("onAppOpen", new Runnable() { // from class: com.zenmen.palmchat.modulemanager.lifecircle.AppLifeCircleManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (!jo6.z() || !bp4.s()) {
                    com.zenmen.palmchat.utils.a.E().t(1);
                }
                br3.c();
                AppStatusReporter.onAppOpen();
            }
        });
        LXModuleInitManager.getInstance().onAppMove2Front();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class InnerActivityListener implements Application.ActivityLifecycleCallbacks {
        public InnerActivityListener() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            LifeCircleCallback lifeCircleCallbackFindCallBack = AppLifeCircleManager.this.findCallBack(activity);
            if (lifeCircleCallbackFindCallBack != null) {
                lifeCircleCallbackFindCallBack.onStatusChange(activity, Lifecycle.Event.ON_CREATE);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            LifeCircleCallback lifeCircleCallbackFindCallBack = AppLifeCircleManager.this.findCallBack(activity);
            if (lifeCircleCallbackFindCallBack != null) {
                lifeCircleCallbackFindCallBack.onStatusChange(activity, Lifecycle.Event.ON_DESTROY);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            LifeCircleCallback lifeCircleCallbackFindCallBack = AppLifeCircleManager.this.findCallBack(activity);
            if (lifeCircleCallbackFindCallBack != null) {
                lifeCircleCallbackFindCallBack.onStatusChange(activity, Lifecycle.Event.ON_PAUSE);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            LifeCircleCallback lifeCircleCallbackFindCallBack = AppLifeCircleManager.this.findCallBack(activity);
            if (lifeCircleCallbackFindCallBack != null) {
                lifeCircleCallbackFindCallBack.onStatusChange(activity, Lifecycle.Event.ON_RESUME);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            LifeCircleCallback lifeCircleCallbackFindCallBack = AppLifeCircleManager.this.findCallBack(activity);
            if (lifeCircleCallbackFindCallBack != null) {
                lifeCircleCallbackFindCallBack.onStatusChange(activity, Lifecycle.Event.ON_START);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            LifeCircleCallback lifeCircleCallbackFindCallBack = AppLifeCircleManager.this.findCallBack(activity);
            if (lifeCircleCallbackFindCallBack != null) {
                lifeCircleCallbackFindCallBack.onStatusChange(activity, Lifecycle.Event.ON_STOP);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }
}
