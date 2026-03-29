package com.apm.lite;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.apm.lite.runtime.ConfigManager;
import defpackage.ca7;
import defpackage.cg7;
import defpackage.ef7;
import defpackage.ih7;
import defpackage.kj7;
import defpackage.s07;
import defpackage.v07;
import defpackage.x97;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MonitorCrash {
    private static final String TAG = "MonitorCrash";
    com.apm.lite.a mAppLog;
    Config mConfig;
    AttachUserData mCustomData;
    HashMap<String, String> mTagMap = new HashMap<>();
    HashMap<String, String> mPageViewTagMap = new HashMap<>();
    private volatile boolean isAppLogInit = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class Config {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3285a;
        public String b;
        public String c;
        public long d;
        public String e;
        public String[] f;
        public String[] g;
        public AttachUserData h;
        public String i;
        public com.apm.lite.a j;
        public boolean k;
        public String l;
        public IDynamicParams m;
        public Map<String, String> n;

        /* JADX INFO: compiled from: SearchBox */
        public interface IDynamicParams {
            String getDid();

            String getUserId();
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class SdkBuilder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Config f3286a;

            public SdkBuilder(String str) {
                Config config = new Config(null);
                this.f3286a = config;
                config.f3285a = str;
            }

            public SdkBuilder acceptWithActivity(boolean z) {
                this.f3286a.k = z;
                return this;
            }

            public Config build() {
                return this.f3286a;
            }

            public SdkBuilder channel(String str) {
                this.f3286a.c = str;
                return this;
            }

            public SdkBuilder debugMode(boolean z) {
                Npth.getConfigManager().setDebugMode(z);
                return this;
            }

            public SdkBuilder dynamicParams(IDynamicParams iDynamicParams) {
                this.f3286a.m = iDynamicParams;
                return this;
            }

            public SdkBuilder enableAnrMonitor(boolean z) {
                Npth.getConfigManager().setAnrEnable(z);
                return this;
            }

            public SdkBuilder enableJavaCrash(boolean z) {
                Npth.getConfigManager().setJavaCrashEnable(z);
                return this;
            }

            public SdkBuilder enableNativeCrash(boolean z) {
                Npth.getConfigManager().setNativeCrashEnable(z);
                return this;
            }

            public SdkBuilder keyWords(String... strArr) {
                this.f3286a.f = strArr;
                return this;
            }

            public SdkBuilder pageViewTags(Map<String, String> map) {
                this.f3286a.n = map;
                return this;
            }

            public SdkBuilder soList(String... strArr) {
                this.f3286a.g = strArr;
                return this;
            }

            public SdkBuilder token(String str) {
                this.f3286a.b = str;
                return this;
            }

            public SdkBuilder url(String str) {
                this.f3286a.l = str;
                return this;
            }

            public SdkBuilder versionCode(long j) {
                this.f3286a.d = j;
                return this;
            }

            public SdkBuilder versionName(String str) {
                this.f3286a.e = str;
                return this;
            }

            public /* synthetic */ SdkBuilder(String str, a aVar) {
                this(str);
            }
        }

        public Config() {
            this.d = -1L;
            this.k = false;
            this.n = null;
        }

        public static SdkBuilder sdk(String str) {
            return new SdkBuilder(str, null);
        }

        public String getDeviceId() {
            IDynamicParams iDynamicParams = this.m;
            return iDynamicParams == null ? this.i : iDynamicParams.getDid();
        }

        public String getUID() {
            IDynamicParams iDynamicParams = this.m;
            return iDynamicParams == null ? "" : iDynamicParams.getUserId();
        }

        public Config setChannel(String str) {
            this.c = str;
            com.apm.lite.a aVar = this.j;
            if (aVar != null) {
                aVar.g(str);
            }
            v07.e();
            return this;
        }

        @Deprecated
        public Config setDeviceId(String str) {
            return setDeviceId(str, true);
        }

        public Config setPackageName(String str) {
            return setPackageName(str);
        }

        public Config setSoList(String[] strArr) {
            this.g = strArr;
            v07.e();
            return this;
        }

        public /* synthetic */ Config(a aVar) {
            this();
        }

        @Deprecated
        public Config setDeviceId(String str, boolean z) {
            this.i = str;
            com.apm.lite.a aVar = this.j;
            if (aVar != null) {
                aVar.e(str);
            }
            if (z) {
                v07.e();
            }
            return this;
        }

        public Config setPackageName(String... strArr) {
            this.f = strArr;
            v07.e();
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f3287a;
        public final /* synthetic */ Context b;

        public a(boolean z, Context context) {
            this.f3287a = z;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap map;
            if (MonitorCrash.this.isAppLogInit) {
                return;
            }
            if (!ef7.e()) {
                ef7.f();
            }
            if (ca7.n(MonitorCrash.this.mConfig.f3285a)) {
                MonitorCrash.this.isAppLogInit = true;
                MonitorCrash monitorCrash = MonitorCrash.this;
                if (monitorCrash.mAppLog == null) {
                    monitorCrash.mAppLog = new com.apm.lite.a();
                }
                if (this.f3287a) {
                    map = null;
                } else {
                    String strB = s07.b(com.apm.lite.b.b());
                    map = new HashMap();
                    map.put("host_app_id", strB);
                    map.put("sdk_version", MonitorCrash.this.mConfig.e);
                }
                MonitorCrash monitorCrash2 = MonitorCrash.this;
                monitorCrash2.mAppLog.d(this.b, monitorCrash2.mConfig, map);
                MonitorCrash monitorCrash3 = MonitorCrash.this;
                monitorCrash3.mConfig.j = monitorCrash3.mAppLog;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IUploadCallback f3288a;

        public b(IUploadCallback iUploadCallback) {
            this.f3288a = iUploadCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            MonitorCrash monitorCrash = MonitorCrash.this;
            com.apm.lite.a aVar = monitorCrash.mAppLog;
            if (aVar != null) {
                aVar.f(monitorCrash.mPageViewTagMap, this.f3288a);
                return;
            }
            IUploadCallback iUploadCallback = this.f3288a;
            if (iUploadCallback != null) {
                iUploadCallback.afterUpload(false);
            }
        }
    }

    private MonitorCrash(Config config) {
        this.mConfig = config;
        this.mCustomData = config.h;
    }

    private void initAppLog(Context context, boolean z) {
        initAppLogAsync(context, z);
    }

    private void initAppLogAsync(Context context, boolean z) {
        ih7.b().f(new a(z, context), 5L);
    }

    public static synchronized MonitorCrash initSDK(Context context, Config config) {
        if (TextUtils.isEmpty(config.b)) {
            Log.e(TAG, config.f3285a + " MonitorCrash init without token.");
        }
        MonitorCrash monitorCrashA = com.apm.lite.b.a(config.f3285a);
        if (monitorCrashA != null) {
            Log.e(TAG, "Duplicate init MonitorCrash with same aid.");
            return monitorCrashA;
        }
        MonitorCrash monitorCrash = new MonitorCrash(config);
        if (!TextUtils.isEmpty(config.l)) {
            monitorCrash.setReportUrl(config.l);
        }
        Map<String, String> map = config.n;
        if (map != null) {
            monitorCrash.mPageViewTagMap.putAll(map);
            monitorCrash.mTagMap.putAll(monitorCrash.mPageViewTagMap);
        }
        cg7.c(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable(), 0L);
        monitorCrash.initAppLog(context, false);
        com.apm.lite.b.i(monitorCrash);
        return monitorCrash;
    }

    private MonitorCrash setReportUrl(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        int iIndexOf = str.indexOf("://");
        if (iIndexOf < 0) {
            str = "https://" + str;
            i = 8;
        } else {
            i = iIndexOf + 3;
        }
        int iIndexOf2 = str.indexOf("/", i);
        if (iIndexOf2 >= 0) {
            str = str.substring(0, iIndexOf2);
        }
        kj7.a("set url " + str);
        x97.o().setLaunchCrashUrl(str + ConfigManager.EXCEPTION_URL_SUFFIX);
        x97.o().setJavaCrashUploadUrl(str + ConfigManager.JAVA_URL_SUFFIX);
        x97.o().setNativeCrashUrl(str + ConfigManager.NATIVE_URL_SUFFIX);
        x97.o().setConfigUrl(str + ConfigManager.CONFIG_URL_SUFFIX);
        x97.o().setAlogUploadUrl(str + ConfigManager.ALOG_URL_SUFFIX);
        x97.o().setFileUploadUrl(str + ConfigManager.FILE_UPLOAD_URL_SUFFIX);
        x97.o().setPageViewUrl(str + ConfigManager.PAGEVIEW_URL_SUFFIX);
        return this;
    }

    public MonitorCrash addPageViewTags(String str, String str2) {
        this.mPageViewTagMap.put(str, str2);
        this.mTagMap.put(str, str2);
        return this;
    }

    public MonitorCrash addTags(String str, String str2) {
        this.mTagMap.put(str, str2);
        return this;
    }

    public Config config() {
        return this.mConfig;
    }

    public void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        cg7.d(iCrashCallback, crashType);
    }

    public void registerOOMCallback(IOOMCallback iOOMCallback) {
        cg7.e(iOOMCallback);
    }

    public void reportPageView(IUploadCallback iUploadCallback) {
        ih7.b().f(new b(iUploadCallback), 10L);
    }

    public void unregisterCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        cg7.i(iCrashCallback, crashType);
    }

    public void unregisterOOMCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        cg7.f(iOOMCallback, crashType);
    }

    public static void reInitAppLog(String str) {
    }
}
