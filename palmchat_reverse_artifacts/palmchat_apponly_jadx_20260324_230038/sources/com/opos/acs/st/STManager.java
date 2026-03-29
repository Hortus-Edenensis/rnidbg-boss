package com.opos.acs.st;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.az;
import com.opos.acs.st.InitParams;
import com.opos.acs.st.utils.b;
import com.opos.acs.st.utils.c;
import com.opos.acs.st.utils.d;
import com.opos.acs.st.utils.f;
import com.opos.acs.st.utils.g;
import com.opos.acs.st.utils.i;
import com.opos.acs.st.utils.k;
import com.opos.cmn.nt.crypt.EncryptUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class STManager {
    public static final String KEY_AD_ID = "adId";
    public static final String KEY_AD_POS_ID = "adposId";
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_CATEGORY_ID = "categoryId";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CHANNEL_ID = "channelId";
    public static final String KEY_DATA_TYPE = "dataType";
    public static final String KEY_DOWN_X = "downX";
    public static final String KEY_DOWN_Y = "downY";
    public static final String KEY_ENTER_ID = "enterId";
    public static final String KEY_EVT_TRACE_ID = "evtTraceId";
    public static final String KEY_EXPOSE_DURATION = "exposeDur";
    public static final String KEY_EXT_CHANNEL = "extChannel";
    public static final String KEY_INSTALL_PKG_NAME = "installPkgName";
    public static final String KEY_LATITUDE = "latitude";
    public static final String KEY_LONGITUDE = "longitude";
    public static final String KEY_MODULE_ID = "moduleId";
    public static final String KEY_PAR_MODULE_ID = "parModuleId";
    public static final String KEY_PAR_POS_ID = "parPosId";
    public static final String KEY_PAR_TAB_ID = "parTabId";
    public static final String KEY_SCAN_PKG_NAME = "scanPkgName";
    public static final String KEY_SDK_VERSION = "sdkVersion";
    public static final String KEY_SSO_ID = "ssoid";
    public static final String KEY_TAB_ID = "tabId";
    public static final String KEY_TRACE_ID = "traceId";
    public static final String KEY_UP_X = "upX";
    public static final String KEY_UP_Y = "upY";
    public static final int NO_NEED_UPLOAD = 3;
    public static final int PARAM_ERROR = 4;
    public static final String REGION_OF_CN = "CN";

    @Deprecated
    public static final String REGION_OF_ID = "ID";

    @Deprecated
    public static final String REGION_OF_IN = "IN";

    @Deprecated
    public static final String REGION_OF_MY = "MY";

    @Deprecated
    public static final String REGION_OF_PH = "PH";

    @Deprecated
    public static final String REGION_OF_TH = "TH";

    @Deprecated
    public static final String REGION_OF_TW = "TW";

    @Deprecated
    public static final String REGION_OF_VN = "VN";
    public static final int REPORT_FINISH = 7;
    public static final int REPORT_NO_STCONFIG = 6;
    private static final long REPORT_TIME_OUT = 1000;
    public static final int SAVED_ON_DB = 5;
    private static final String TAG = "STManager";
    public static final int UPLOAD_FAILURE = 2;
    public static final int UPLOAD_OK = 1;
    private static volatile STManager sInstance;
    private Context mContext = null;
    private static final byte[] LOCK = new byte[0];
    public static final String BRAND_OF_O = c.f7716a;
    public static final String BRAND_OF_P = c.b;
    public static final String BRAND_OF_R = c.c;

    /* JADX INFO: compiled from: SearchBox */
    public interface EventListener {
        void onEventReturn(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ExitListener {
        void onFinish(boolean z);
    }

    private void checkInit(Context context) throws Exception {
        if (k.j(context)) {
            throw new Exception("Please init st sdk at first!");
        }
    }

    private Context getContext(Context context) {
        Context context2 = this.mContext;
        if (context2 != null) {
            return context2;
        }
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    public static STManager getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new STManager();
                }
            }
        }
        return sInstance;
    }

    public static String getSdkVersion() {
        return "3.13.0";
    }

    public static boolean isReleaseServer() {
        return com.opos.acs.st.utils.a.f7715a;
    }

    public static Map<String, String> jsonObject2Map(JSONObject jSONObject) {
        if (jSONObject != null) {
            return b.a(jSONObject);
        }
        return null;
    }

    public static Map<String, String> jsonString2Map(String str) {
        if (k.a(str)) {
            return null;
        }
        return b.a(str.trim());
    }

    public static void setLogBuriedPointSwitch(boolean z) {
        f.b(TAG, "setLogBuriedPointSwitch:" + z);
        com.opos.cmn.an.f.a.a(z);
    }

    public static void setTouristModeSwitch(Context context, boolean z) {
        f.b(TAG, "setTouristModeSwitch:" + z);
        com.opos.cmn.an.f.a.a(context, z);
    }

    public void enableDebugLog() {
        f.a();
    }

    public int getSdkVerCode() {
        return 3013000;
    }

    public void init(Context context, String str, String str2) throws NullPointerException {
        init(context, str, str2, new InitParams.Builder().build());
    }

    public String onEvent(Context context, String str, Map<String, String> map) throws Exception {
        return onEvent(context, str, map, (EventListener) null);
    }

    public void onExit(Context context, final ExitListener exitListener) throws NullPointerException {
        f.b(TAG, "onExit,exitListener=" + exitListener);
        final Context context2 = getContext(context);
        if (context2 == null || exitListener == null) {
            throw new NullPointerException("context or exitListener is null.");
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.acs.st.STManager.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    STManager.this.reportDataOnExit(context2);
                } finally {
                    k.f();
                    exitListener.onFinish(true);
                }
            }
        });
    }

    public void pause(Context context) {
        f.b(TAG, "pause");
        k.a(true);
        final Context context2 = getContext(context);
        if (context2 != null) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.acs.st.STManager.6
                @Override // java.lang.Runnable
                public void run() {
                    STManager.this.reportDataOnExit(context2);
                    k.f();
                }
            });
        }
    }

    public void reportDataOnExit(Context context) {
        Context context2 = getContext(context);
        if (context2 != null) {
            if (!com.opos.cmn.an.h.c.a.d(context2)) {
                f.a(TAG, "has no net,do nothing and  application exit.");
            } else {
                f.a(TAG, "has net,report all data before application exit.");
                k.d(context2);
            }
        }
    }

    public void resume(Context context) {
        f.b(TAG, az.ag);
        k.a(false);
        final Context context2 = getContext(context);
        if (context2 != null) {
            com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.acs.st.STManager.5
                @Override // java.lang.Runnable
                public void run() {
                    k.e(context2);
                }
            });
        }
    }

    public void init(final Context context, String str, String str2, final InitParams initParams) throws NullPointerException {
        f.b(TAG, "init,brand=" + str + ",region=" + str2 + ",initParams=" + initParams);
        if (!d.b()) {
            d.a();
            if (initParams == null || context == null) {
                throw new NullPointerException("initParams or context is null.");
            }
            this.mContext = context.getApplicationContext();
            if (initParams.getIsLoganInit()) {
                f.a(this.mContext);
            }
            d.a(initParams.getIsTablet());
            d.b(this.mContext, str);
            d.a(this.mContext, str2);
            d.c(this.mContext);
            com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.acs.st.STManager.1
                @Override // java.lang.Runnable
                public void run() {
                    k.l(STManager.this.mContext);
                    g.a(STManager.this.mContext).a();
                    if (EncryptUtils.isSoEnabled()) {
                        return;
                    }
                    f.c(STManager.TAG, "Init failed,miss so lib！");
                    if (k.i(context)) {
                        throw new IllegalStateException("Init failed,miss so lib!");
                    }
                }
            });
        }
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.acs.st.STManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (!com.opos.cmn.an.h.c.a.d(STManager.this.mContext)) {
                    f.b(STManager.TAG, "init no net! no need update strategy");
                } else if (TextUtils.isEmpty(initParams.getPkgName())) {
                    i.b(STManager.this.mContext);
                } else {
                    i.a(STManager.this.mContext, initParams.getPkgName());
                }
            }
        });
    }

    public String onEvent(Context context, String str, Map<String, String> map, EventListener eventListener) throws Exception {
        return onEvent(context, str, map, eventListener, null, null);
    }

    public void init(Context context, String str, String str2, String str3) throws NullPointerException {
        init(context, str, str2, new InitParams.Builder().setPkgName(str3).build());
    }

    public String onEvent(Context context, String str, Map<String, String> map, EventListener eventListener, String str2, String str3) throws Exception {
        f.b(TAG, "jsonString=" + str + ",eventMap=" + map);
        checkInit(context);
        if (!k.a(str) && map != null) {
            f.a(TAG, str);
            Map<String, String> mapA = b.a(str.trim());
            if (mapA != null) {
                try {
                    map.putAll(mapA);
                } catch (Exception e) {
                    f.c(TAG, "onEvent", e);
                }
            }
        }
        return onEvent(context, map, eventListener, str2, str3);
    }

    public String onEvent(Context context, String str, Map<String, String> map, String str2, String str3) throws Exception {
        return onEvent(context, str, map, null, str2, str3);
    }

    public String onEvent(Context context, Map<String, String> map) throws Exception {
        return onEvent(context, map, (EventListener) null);
    }

    public String onEvent(Context context, Map<String, String> map, EventListener eventListener) throws Exception {
        return onEvent(context, map, eventListener, (String) null, (String) null);
    }

    public String onEvent(Context context, final Map<String, String> map, final EventListener eventListener, String str, String str2) throws Exception {
        String str3;
        f.b(TAG, "report data start======eventMap=" + map + ",biz=" + str + ",bizTrace=" + str2 + ",eventListener=" + eventListener);
        checkInit(context);
        final Context context2 = getContext(context);
        if (context2 == null || map == null) {
            if (eventListener == null) {
                return null;
            }
            eventListener.onEventReturn(4);
            return null;
        }
        if (k.j(context2)) {
            throw new Exception("Please init st sdk at first!");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (map.containsKey("traceId")) {
            str3 = map.get("traceId");
        } else {
            String str4 = k.a(map.get("adId")) ? "0" : map.get("adId");
            if (k.a(str)) {
                str = "0";
            }
            if (k.a(str2)) {
                str2 = "0";
            }
            str3 = "0-" + str4 + "-" + jCurrentTimeMillis + "-" + str + "-" + str2;
        }
        map.put("evtId", String.valueOf(jCurrentTimeMillis));
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.acs.st.STManager.3
            @Override // java.lang.Runnable
            public void run() {
                k.a(context2, (Map<String, String>) map, eventListener);
            }
        });
        f.b(TAG, "traceId=" + str3);
        return str3;
    }

    public String onEvent(Context context, Map<String, String> map, String str, String str2) throws Exception {
        return onEvent(context, map, (EventListener) null, str, str2);
    }
}
