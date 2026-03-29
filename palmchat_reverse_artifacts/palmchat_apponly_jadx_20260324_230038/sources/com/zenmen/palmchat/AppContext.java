package com.zenmen.palmchat;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.RemoteException;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.multidex.MultiDexApplication;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.openalliance.ad.constant.az;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.lantern.auth.openapi.BuildInfo;
import com.lantern.auth.openapi.OAuthApi;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.zenmen.find.ConditionHelper;
import com.zenmen.openapi.OpenApiManager;
import com.zenmen.openapi.config.LxApiProxy;
import com.zenmen.openapi.jssdk.service.JSSDKService;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.Vo.DaemonConfig;
import com.zenmen.palmchat.Vo.ParcelPair;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.chat.viewadapter.DefaultChatViewAdapter;
import com.zenmen.palmchat.contacts.ContactActivity;
import com.zenmen.palmchat.contacts.NewContactActivity;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.daemon.WakeActivity;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.login.InitActivity;
import com.zenmen.palmchat.messaging.MessagingService;
import com.zenmen.palmchat.modulemanager.InitExceptionHelper;
import com.zenmen.palmchat.modulemanager.LXModuleInitManager;
import com.zenmen.palmchat.modulemanager.lifecircle.AppLifeCircleManager;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.peoplenearby.PeopleNearbyActivity;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import com.zenmen.palmchat.route.PagerRouter;
import com.zenmen.palmchat.route.share.ExternalShareActivity;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.update.UpdateManager;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.videocall.c;
import com.zenmen.palmchat.zx.core.Application;
import com.zenmen.square.support.SquareSingleton;
import defpackage.ConfigInfo;
import defpackage.ac1;
import defpackage.aj0;
import defpackage.ar3;
import defpackage.au5;
import defpackage.bj5;
import defpackage.bo0;
import defpackage.bp4;
import defpackage.br3;
import defpackage.c13;
import defpackage.ch;
import defpackage.d20;
import defpackage.d40;
import defpackage.di5;
import defpackage.dn4;
import defpackage.do0;
import defpackage.e63;
import defpackage.eb4;
import defpackage.fc3;
import defpackage.fn2;
import defpackage.fw5;
import defpackage.gs2;
import defpackage.i50;
import defpackage.ia5;
import defpackage.ii5;
import defpackage.ir5;
import defpackage.is3;
import defpackage.it0;
import defpackage.it4;
import defpackage.iu4;
import defpackage.iw5;
import defpackage.j30;
import defpackage.jl2;
import defpackage.k30;
import defpackage.k86;
import defpackage.k94;
import defpackage.kc3;
import defpackage.kf5;
import defpackage.kt4;
import defpackage.l10;
import defpackage.l16;
import defpackage.lh6;
import defpackage.m10;
import defpackage.mj5;
import defpackage.mk6;
import defpackage.n10;
import defpackage.n52;
import defpackage.n96;
import defpackage.ni2;
import defpackage.ni5;
import defpackage.nl0;
import defpackage.nq3;
import defpackage.nu1;
import defpackage.o20;
import defpackage.o9;
import defpackage.oq5;
import defpackage.ot0;
import defpackage.p03;
import defpackage.p10;
import defpackage.p5;
import defpackage.pa6;
import defpackage.pk3;
import defpackage.pt0;
import defpackage.pu1;
import defpackage.q35;
import defpackage.qg6;
import defpackage.r20;
import defpackage.r75;
import defpackage.re1;
import defpackage.s10;
import defpackage.sa3;
import defpackage.sk5;
import defpackage.sp2;
import defpackage.ss0;
import defpackage.st3;
import defpackage.t30;
import defpackage.t5;
import defpackage.t66;
import defpackage.t8;
import defpackage.ta3;
import defpackage.tg4;
import defpackage.th6;
import defpackage.ti0;
import defpackage.tq3;
import defpackage.ts0;
import defpackage.u20;
import defpackage.u93;
import defpackage.us0;
import defpackage.ux3;
import defpackage.v4;
import defpackage.vt0;
import defpackage.wh;
import defpackage.ws2;
import defpackage.x03;
import defpackage.x92;
import defpackage.xi1;
import defpackage.xj5;
import defpackage.xp3;
import defpackage.y93;
import defpackage.yd2;
import defpackage.yn6;
import defpackage.z10;
import defpackage.z4;
import defpackage.zf2;
import defpackage.zh5;
import defpackage.zj6;
import defpackage.zn0;
import defpackage.zn6;
import defpackage.zo3;
import defpackage.zw4;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import org.apache.cordova.jssdk.GeneralPluginFactoryImpl;
import org.apache.cordovaNew.PermissionDialogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AppContext extends MultiDexApplication implements c.a {
    private static final long SD_STORAGE_FULL_WARNING_SIZE = 20971520;
    private static final long STORAGE_FULL_WARNING_SIZE = 5242880;
    private static final String TAG = "AppContext";
    public static final String TRAY_PREFERENCE_EXIT_APP = "tray_preference_exit";
    private static Pair<byte[], byte[]> mSecretKey;
    private static AppContext sInstance;
    private volatile l16 trayPreferences;
    private WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
    private Boolean mIsPrivacyAgreeBeforInit = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", "send_message");
            put("status", "logout");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("action", "getSK");
            put("status", "getSecretKey2");
            put("detail", "keys = null ");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("action", "getSK");
            put("status", "getSecretKey3");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("action", "getSK");
            put("status", "getSecretKey");
            put("detail", "messagingServiceInterface = null");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n52.a(AppContext.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements jl2 {
        public f() {
        }

        @Override // defpackage.jl2
        public void a(String str) {
            AppContext.this.initMessagingService("STASRT_REASON_DAEMON");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements sp2 {
        public g() {
        }

        @Override // defpackage.sp2
        public void a(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("packageName", str);
                jSONObject.put("brand", Build.BRAND);
                jSONObject.put(WkParams.MODEL, Build.MODEL);
                jSONObject.put(az.aQ, Build.VERSION.SDK_INT);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_ybao_2", null, jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("packageName", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("ar08", null, null, jSONObject2.toString());
        }

        @Override // defpackage.sp2
        public void b(String str, int i) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("packageName", str);
                jSONObject.put("type", i);
                jSONObject.put("brand", Build.BRAND);
                jSONObject.put(WkParams.MODEL, Build.MODEL);
                jSONObject.put(az.aQ, Build.VERSION.SDK_INT);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_ybao_2", null, jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("packageName", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("ar08", null, null, jSONObject2.toString());
        }

        @Override // defpackage.sp2
        public void c(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("packageName", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_ybao_3", null, jSONObject.toString());
            LogUtil.uploadInfoImmediate("ar09", null, null, jSONObject.toString());
        }

        @Override // defpackage.sp2
        public void d(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("packageName", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zn6.d("lx_client_ybao_1", null, jSONObject.toString());
            LogUtil.uploadInfoImmediate("ar07", null, null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Response.Listener<JSONObject> {
        public j() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject;
            try {
                LogUtil.i(AppContext.TAG, "signin " + jSONObject.toString());
                if (jSONObject.getInt("resultCode") == 0 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null && jSONObjectOptJSONObject.optInt("isShow") == 1) {
                    AppContext.getContext().sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_LOGIN_REWARD));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements AccountManagerCallback<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f12063a;
        public final /* synthetic */ boolean b;

        public l(boolean z, boolean z2) {
            this.f12063a = z;
            this.b = z2;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Boolean> accountManagerFuture) {
            AppContext.this.sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(AppContext.getContext(), (Class<?>) InitActivity.class));
            intent.putExtra("login.ispwd", this.f12063a);
            intent.putExtra("login.switch", this.b);
            intent.putExtra("self_logout", true);
            intent.addFlags(335544320);
            AppContext.getContext().startActivity(intent);
            com.zenmen.palmchat.utils.a.E().F0(AppContext.getContext(), null, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements AccountManagerCallback<Boolean> {
        public m() {
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Boolean> accountManagerFuture) {
            AppContext.this.sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
            r75.s(true);
            com.zenmen.palmchat.utils.a.E().F0(AppContext.getContext(), null, 0);
        }
    }

    public AppContext() {
        sInstance = this;
    }

    private void asyncLogout() {
        try {
            new e63(new h(), new i(), new HashMap()).n();
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    @TargetApi(19)
    public static boolean checkOp(Context context, int i2) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class.forName(appOpsManager.getClass().getName());
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            int iIntValue = ((Integer) cls.getDeclaredMethod("checkOp", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(i2), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue();
            Log.e("399", " property: " + iIntValue);
            return iIntValue == 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void clearApp() {
        ch.s().p0();
        com.zenmen.palmchat.contacts.d.j().f();
        setSecretKey(null, null);
        tq3.e().a();
        pa6.p().i();
        zn0.i().g();
        bp4.w();
        is3.b().a();
        iw5.m().i();
        fc3.l().i();
        TeenagersModeManager.a().e();
        fw5.a();
        d20.d();
        mj5.r().z();
        LXModuleInitManager.getInstance().onLogout();
    }

    private void clearWebStorage() {
        try {
            Intent intent = new Intent(this, (Class<?>) JSSDKService.class);
            intent.setAction("com.zenmen.openapi.ACTION_CLEAR_COOKIES");
            startService(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void disableAPIDialog() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static AppContext getContext() {
        return sInstance;
    }

    private static Pair<byte[], byte[]> getContextSecretKey() {
        return mSecretKey;
    }

    public static Pair<byte[], byte[]> getSecretKey() {
        return getSecretKey(true);
    }

    private void initActivityLifecycleCallbacks() {
        registerActivityLifecycleCallbacks(new p5());
        AppLifeCircleManager.getInstance().initActivityLifecycleCallbacks(this);
    }

    private void initDNSCache() {
        it0.k().m(this, nl0.a(), VolleyNetwork.buildUserAgent(this), ac1.h, AccountUtils.p(this), nl0.l, nl0.b(), nl0.k());
        it0.k().s("app start");
    }

    private void initDaemon() {
        initSyncAccV3();
        initYBao();
    }

    private void initDaemonHelper(Context context) {
        if (ot0.f().b("yaoshiSdk") && DaemonConfig.e()) {
            try {
                pt0.a(context, new f());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void initDeviceInfos(Context context) {
        ac1.B(context);
    }

    private void initFramework() {
        com.zenmen.palmchat.c.f(new com.zenmen.palmchat.b().H(new p03()).N(new bo0.d()).J(new t5.c()).K(this).R(new EncryptUtils.a()).U(new nu1.i()).e0(new PagerRouter()).n0(new CordovaWebActivity.o()).I(new UserDetailActivity.k0()).g0(new PeopleNearbyActivity.a0()).S(new ExternalShareActivity.j()).X(new MainTabsActivity.h0()).d0(new NewContactActivity.h()).f0(new ContactActivity.d()).b0(new br3.a()).V(new yd2()).i0("release").k0(true).T(false).L(oq5.a("20260309153514")).Y(new pk3()).c0(new c13()).P(new ss0()).Q(new xi1()).O(new us0()).Z(new zo3()).m0(new c.f()).W(new ta3()).M(new do0()).h0(new iu4()).j0(new kf5()).l0(new au5()).a0(new sa3.c()));
        st3.b(sInstance);
    }

    private void initGroupSDK(boolean z) {
        if (r75.l()) {
            if (z) {
                ac1.A(this);
            }
            o9.a(this);
            BuildInfo.setDebuggable(!nl0.k());
            BuildInfo.setLogEnable(true);
            OAuthApi.init(getContext(), eb4.b(), ac1.m, tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.PHONE_STATE.permissionList) ? 3 : 1, ac1.h);
            initDaemon();
            k94.a(this);
            u93.b(5000, new e());
        }
    }

    private void initStatsAgent() {
        sk5.a(this);
    }

    private void initSyncAccV3() {
        Boolean bool = Boolean.TRUE;
        if (!ot0.f().b("syncacc_v3") || !DaemonConfig.g(this)) {
            bool = Boolean.FALSE;
        }
        if (bool.booleanValue()) {
            Log.d("logdaemon", "sync account v3 init");
        } else {
            Log.d("logdaemon", "sync account v3 not init");
        }
        try {
            z4.c(this, bool.booleanValue());
            aj0.a(this, bool.booleanValue());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void initVolley() {
        zw4.c(sInstance, new th6());
    }

    private void initYBao() {
        if (ot0.f().b("yuanbao")) {
            Log.d("logdaemon", "ybao init");
            try {
                mk6.a(this, new g());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @TargetApi(19)
    public static boolean isFloatWindowOpAllowed(Context context) {
        return checkOp(context, 24);
    }

    private static boolean isServiceRunning(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(100);
        for (int i2 = 0; i2 < runningServices.size(); i2++) {
            if (str.equals(runningServices.get(i2).service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private boolean needInitForLxOpenPlatform(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(":payTest") || str.contains(":lxreader") || str.contains(":webapp");
    }

    private void processAttachBaseContext(Context context) {
        long jB = ir5.b();
        Application.INSTANCE.a(this, new ConfigInfo(false, "release", "com.zenmen.palmchat"));
        String strM = k86.m(this);
        if (TextUtils.isEmpty(strM) || strM.equals(getPackageName())) {
            ni2.a();
        }
        webViewCompat(strM);
        initDaemonHelper(context);
        yn6.c(context);
        LXModuleInitManager.getInstance().onApplicationAttach(this);
        Log.d(TAG, "attachBaseContext cost" + ir5.e(jB) + " pid=" + strM);
    }

    private void processOnCreate() {
        String strM;
        long jB = ir5.b();
        boolean z = true;
        try {
            strM = k86.m(this);
            try {
                if (!TextUtils.isEmpty(strM) && !strM.equals(getPackageName())) {
                    z = false;
                }
                if (z) {
                    PrivInfoManager.INSTANCE.init(this);
                    OAuthApi.onAppCreate();
                }
                startDaemonHelper();
                disableAPIDialog();
                startStrictMode();
                yn6.l(this);
                xp3.e(this);
                InitExceptionHelper.triggerCrash();
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                InitExceptionHelper.onException(InitExceptionHelper.TYPE_ONCREATE_1, th);
            }
        } catch (Throwable th2) {
            th = th2;
            strM = null;
        }
        if (z) {
            try {
                initFramework();
                initDeviceInfos(this);
                ts0.o().I(this);
                initVolley();
                initStatsAgent();
                initDNSCache();
                initActivityLifecycleCallbacks();
                x03.d().e();
                initContactsCache();
                initPhoneContactsCache();
                initStatusManager();
                initSquare();
                q35.b().g(this);
                InitExceptionHelper.triggerCrash();
            } catch (Throwable th3) {
                th3.printStackTrace();
                InitExceptionHelper.onException(InitExceptionHelper.TYPE_ONCREATE_2, th3);
            }
            initGroupSDK(false);
            qg6.a();
            WakeActivity.b();
            LxApiProxy.getInstance().setConfigImpl(new y93());
            LxApiProxy.getInstance().setPluginFactory(new GeneralPluginFactoryImpl());
            OpenApiManager.getInstance().init(this);
            vt0.d().m();
            vt0.d().f();
            registerChatViewAdapter();
        } else if (strM.contains(":messaging")) {
            initFramework();
            initDeviceInfos(this);
            initVolley();
            initStatsAgent();
        } else if (strM.contains(":pushservice")) {
            initFramework();
            o9.a(this);
        } else if (!strM.contains(":daemon") && needInitForLxOpenPlatform(strM)) {
            initFramework();
            initVolley();
            pu1.s();
            if (r75.l()) {
                o9.a(this);
            }
            OpenApiManager.getInstance().init(this);
        }
        LXModuleInitManager.getInstance().onApplicationCreate(this);
        Log.d(TAG, "onCreate cost" + ir5.e(jB) + " pid=" + strM);
    }

    private void registerChatViewAdapter() {
        i50 i50VarD = i50.d();
        i50VarD.e(com.zenmen.palmchat.chat.viewadapter.b.class.getName());
        i50VarD.e(wh.class.getName());
        i50VarD.e(x92.class.getName());
        i50VarD.e(l10.class.getName());
        i50VarD.e(ii5.class.getName());
        i50VarD.e(ni5.class.getName());
        i50VarD.e(n96.class.getName());
        i50VarD.e(com.zenmen.palmchat.chat.viewadapter.a.class.getName());
        i50VarD.e(o20.class.getName());
        i50VarD.e(n10.class.getName());
        i50VarD.e(k30.class.getName());
        i50VarD.e(j30.class.getName());
        i50VarD.e(it4.class.getName());
        i50VarD.e(kt4.class.getName());
        i50VarD.e(dn4.class.getName());
        i50VarD.e(r20.class.getName());
        i50VarD.e(p10.class.getName());
        i50VarD.e(u20.class.getName());
        i50VarD.e(t30.class.getName());
        i50VarD.e(m10.class.getName());
        i50VarD.e(s10.class.getName());
        i50VarD.e(t8.class.getName());
        i50VarD.e(z10.class.getName());
        i50VarD.e(d40.class.getName());
        i50VarD.e(DefaultChatViewAdapter.class.getName());
    }

    private static void setContextSecretKey(String str, String str2) {
        if (str == null || str2 == null) {
            mSecretKey = null;
        } else {
            mSecretKey = new Pair<>(str.getBytes(), str2.getBytes());
        }
    }

    public static void setSecretKey(String str, String str2) {
        fn2 fn2VarU = ch.s().u();
        if (fn2VarU != null) {
            try {
                fn2VarU.i(str, str2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        setContextSecretKey(str, str2);
    }

    private void startDaemonHelper() {
        if (ot0.f().b("yaoshiSdk") && DaemonConfig.e()) {
            try {
                pt0.c();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void stopMessageService() {
        if (isServiceRunning(getContext(), MessagingService.class.getName())) {
            getContext().stopService(new Intent(getContext(), (Class<?>) MessagingService.class));
        }
    }

    private void webViewCompat(String str) {
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT > 28 || (str2 = Build.MANUFACTURER) == null || !str2.equalsIgnoreCase("xiaomi") || (str3 = Build.MODEL) == null || !str3.equalsIgnoreCase("MI 9")) {
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            zj6.b(this, str);
        }
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        kc3.c().g();
        super.attachBaseContext(context);
        try {
            InitExceptionHelper.triggerCrash();
            processAttachBaseContext(context);
        } catch (Throwable th) {
            th.printStackTrace();
            InitExceptionHelper.onException(InitExceptionHelper.TYPE_ATTACH, th);
        }
        kc3.c().f();
    }

    public void checkNeedSignIn() {
        if (!nl0.g() || TextUtils.isEmpty(AccountUtils.p(getContext()))) {
            return;
        }
        try {
            new ia5(new j(), new k(), new HashMap()).p();
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void exitApp() {
        clearApp();
        sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
        r75.s(true);
    }

    public String getAppName() {
        return getResources().getString(R.string.app_name);
    }

    public long getBackgroundTime() {
        return AppLifeCircleManager.getInstance().getBackgroundTime();
    }

    public int getDialogPositiveColor() {
        return getResources().getColor(R.color.material_dialog_positive_color);
    }

    public WindowManager.LayoutParams getMywmParams() {
        return this.wmParams;
    }

    public String getPackageId() {
        return "com.zenmen.palmchat";
    }

    @Override // com.zenmen.palmchat.c.a
    public int getStatusBarColor() {
        return q35.b().f();
    }

    @Override // com.zenmen.palmchat.c.a
    @Deprecated
    public l16 getTrayPreferences() {
        if (this.trayPreferences == null) {
            synchronized (AppContext.class) {
                if (this.trayPreferences == null) {
                    this.trayPreferences = new l16(this);
                }
            }
        }
        return this.trayPreferences;
    }

    public void initContactsCache() {
        bo0.r().z();
    }

    public void initGroupSDKWithPrivacyCheck() {
        st3.c(this, true);
        initGroupSDK(true);
        LXModuleInitManager.getInstance().onPrivacyAgree(this);
        if (ws2.b()) {
            it0.k().s("app start");
            ts0.o().P(this);
            t66.h().m("privacy", false);
        }
        SharedPreferences sharedPreferences = com.zenmen.palmchat.c.b().getSharedPreferences(WifiNestConst.ThirdConst.SP_FILE_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(WifiNestConst.ThirdConst.SP_FILE_LAST_LOCATION_TIME, ir5.b()).apply();
            Long lValueOf = Long.valueOf(sharedPreferences.getLong(WifiNestConst.ThirdConst.SP_FILE_LAST_LOCATION_TIME, 0L));
            LogUtil.d(TAG, "handleAdPermissions location time  = " + lValueOf);
        }
    }

    @Override // com.zenmen.palmchat.c.a
    public void initMessagingService(String str) {
        initMessagingService(false, str);
    }

    public void initPhoneContactsCache() {
        com.zenmen.palmchat.contacts.d.j().r();
    }

    public void initSquare() {
        bj5.b().f(new di5());
        bj5.b().e(new zh5());
        nq3.a().d(ti0.c());
        nq3.a().e(new ar3());
    }

    public void initStatusManager() {
        ch.s();
    }

    @Override // com.zenmen.palmchat.c.a
    public boolean isBackground() {
        return AppLifeCircleManager.getInstance().isBackground();
    }

    @Override // com.zenmen.palmchat.c.a
    @TargetApi(18)
    public boolean isDataStorageFull() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() <= 5242880;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean isPrivacyAgreeBeforInit() {
        Boolean bool = this.mIsPrivacyAgreeBeforInit;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(PermissionDialogUtil.SP_NAME, 4);
            if (sharedPreferences != null) {
                z = sharedPreferences.getBoolean("sp_privacy_agree", false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Boolean boolValueOf = Boolean.valueOf(z);
        this.mIsPrivacyAgreeBeforInit = boolValueOf;
        return boolValueOf.booleanValue();
    }

    @Override // com.zenmen.palmchat.c.a
    @TargetApi(18)
    public boolean isSDCardStorageFull() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() <= SD_STORAGE_FULL_WARNING_SIZE;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public native boolean isSignatureVerified(boolean z);

    public boolean isUpgrade() {
        String strI = r75.i(getContext(), "sp_last_version_code");
        LogUtil.i(TAG, "last = " + strI + "; current = " + ac1.f);
        return (strI == null || strI.equals("0") || TextUtils.equals(strI, ac1.f)) ? false : true;
    }

    public void jumpToInitOnAccountIsNull() {
        clearApp();
        com.zenmen.palmchat.utils.a.E().s();
        sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getContext(), (Class<?>) InitActivity.class));
        intent.addFlags(335544320);
        getContext().startActivity(intent);
    }

    public void jumpToInitOnAccountIsNullFromSdk(Intent intent) {
        clearApp();
        com.zenmen.palmchat.utils.a.E().s();
        sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
        intent.setComponent(new ComponentName(getContext(), (Class<?>) InitActivity.class));
        intent.putExtra("key_is_from_opensdk", true);
        intent.addFlags(268435456);
        getContext().startActivity(intent);
    }

    public void jumpToInitOnAccountIsNullNeedShare(Intent intent) {
        clearApp();
        com.zenmen.palmchat.utils.a.E().s();
        sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
        intent.setComponent(new ComponentName(getContext(), (Class<?>) InitActivity.class));
        intent.putExtra("key_has_share", true);
        intent.addFlags(268435456);
        getContext().startActivity(intent);
    }

    public native void killSelf();

    public void logout() {
        logout(false, false);
    }

    @Override // com.zenmen.palmchat.c.a
    public void logoutAndExitApp() {
        clearApp();
        if (AccountUtils.r(this)) {
            com.zenmen.palmchat.utils.a.E().s();
            v4.i(getContext(), new m());
        } else {
            sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
            r75.s(true);
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        kc3.c().j();
        super.onCreate();
        re1.a(this);
        try {
            processOnCreate();
            InitExceptionHelper.triggerCrash();
        } catch (Throwable th) {
            th.printStackTrace();
            InitExceptionHelper.onException(InitExceptionHelper.TYPE_ONCREATE, th);
        }
        InitExceptionHelper.checkAndUploadException();
        kc3.c().i();
    }

    @Override // com.zenmen.palmchat.c.a
    public void onInitPermissionDenied() {
        sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getContext(), (Class<?>) InitActivity.class));
        intent.addFlags(335544320);
        startActivity(intent);
    }

    @Override // com.zenmen.palmchat.c.a
    public void onKickOutConfirmed() {
        try {
            fn2 fn2VarU = ch.s().u();
            if (fn2VarU != null && fn2VarU.isConnected() && fn2VarU.w()) {
                fn2VarU.E();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(TAG, 3, new a(), e2);
        }
        getContext().logout();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        try {
            KSImageLoader.clearMemory();
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.palmchat.c.a
    public void onNewVersionChecked(Activity activity) {
        UpdateManager.G().Y(activity);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        PrivInfoManager.INSTANCE.unInit();
    }

    public void sendLocalBroadcast(Intent intent) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void updateDNSOnLogin(String str) {
        it0.k().u(str);
        it0.k().e("user login");
    }

    public static Pair<byte[], byte[]> getSecretKey(boolean z) {
        fn2 fn2VarU = ch.s().u();
        Pair<byte[], byte[]> pairConvert = null;
        if (fn2VarU != null) {
            try {
                ParcelPair parcelPairH = fn2VarU.h();
                if (parcelPairH != null) {
                    pairConvert = parcelPairH.convert();
                } else {
                    LogUtil.i(TAG, 3, new b(), (Throwable) null);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
                LogUtil.i(TAG, 3, new c(), e2);
            }
        } else {
            LogUtil.i(TAG, 3, new d(), (Throwable) null);
        }
        if (!z) {
            return pairConvert;
        }
        if (pairConvert == null) {
            return getContextSecretKey();
        }
        setContextSecretKey(pairConvert);
        return pairConvert;
    }

    public void initMessagingService(boolean z, String str) {
        x03.d().g(z, str);
    }

    public void logout(boolean z) {
        logout(false, z);
    }

    public static void setContextSecretKey(Pair<byte[], byte[]> pair) {
        mSecretKey = pair;
    }

    public void logout(boolean z, boolean z2) {
        asyncLogout();
        clearApp();
        clearWebStorage();
        getTrayPreferences().i(k86.t(), false);
        com.zenmen.palmchat.utils.a.E().s();
        v4.i(getContext(), new l(z, z2));
        zf2.e().b();
        ux3.h().e();
        xj5.h().f();
        gs2.d();
        ConditionHelper.getInstance().resetCondition();
        SquareSingleton.getInstance().reset();
        lh6.V().l0();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.Listener<JSONObject> {
        public h() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.ErrorListener {
        public i() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.ErrorListener {
        public k() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }

    private void startStrictMode() {
    }

    @Override // com.zenmen.palmchat.c.a
    public android.app.Application getApplication() {
        return this;
    }
}
