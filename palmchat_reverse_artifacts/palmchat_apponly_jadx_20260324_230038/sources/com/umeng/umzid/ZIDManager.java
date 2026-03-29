package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import kotlin.UByte;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ZIDManager {
    public static ZIDManager d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11140a = false;
    public boolean b = false;
    public boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f11141a;
        public final /* synthetic */ IZIDCompletionCallback b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f11141a = context;
            this.b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = ZIDManager.a(ZIDManager.this, this.f11141a);
            if (TextUtils.isEmpty(strA)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(strA);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f11142a;

        public b(Context context) {
            this.f11142a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.b(this.f11142a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f11143a;

        public c(Context context) {
            this.f11143a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f11143a);
        }
    }

    public static void configureDomain(Context context, String str) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        String strB = d.b(str);
        if (context == null || strB == null || TextUtils.isEmpty(strB) || (sharedPreferencesA = com.umeng.umzid.a.a(context)) == null || (editorEdit = sharedPreferencesA.edit()) == null) {
            return;
        }
        editorEdit.putString("inputDomain", strB).commit();
    }

    public static synchronized ZIDManager getInstance() {
        if (d == null) {
            d = new ZIDManager();
        }
        return d;
    }

    public static String getSDKVersion() {
        return "1.8.7";
    }

    public final void a(Context context) {
        Object objInvoke;
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.uyumao.sdk.UYMManager");
            Method declaredMethod2 = cls.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (objInvoke = declaredMethod2.invoke(cls, new Object[0])) == null || (declaredMethod = cls.getDeclaredMethod("init", Context.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(objInvoke, context);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b(Context context) {
        String string;
        String string2;
        Throwable th;
        JSONObject jSONObject;
        SharedPreferences sharedPreferencesA;
        SharedPreferences sharedPreferencesA2;
        SharedPreferences sharedPreferencesA3;
        try {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        boolean z = new JSONObject(d.c(context)).optLong("ets") <= System.currentTimeMillis();
        String strOptString = null;
        if (!z || this.b) {
            return null;
        }
        this.b = true;
        JSONObject jSONObject2 = new JSONObject();
        String string3 = "";
        if (context != null) {
            try {
                SharedPreferences sharedPreferencesA4 = com.umeng.umzid.a.a(context);
                String string4 = sharedPreferencesA4 != null ? sharedPreferencesA4.getString("zdata", null) : "";
                String id = Spy.getID();
                jSONObject2.put("z", id);
                jSONObject2.put("o_z", string4);
                if (context == null || (sharedPreferencesA3 = com.umeng.umzid.a.a(context)) == null) {
                    string = "";
                } else {
                    string = sharedPreferencesA3.getString("oaid", "");
                    if (d.c(string)) {
                        string = d.a(string);
                    }
                }
                String strF = d.f(context);
                jSONObject2.put("o_o", string);
                jSONObject2.put("o", strF);
                if (context == null || (sharedPreferencesA2 = com.umeng.umzid.a.a(context)) == null) {
                    string2 = "";
                } else {
                    string2 = sharedPreferencesA2.getString("mac", "");
                    if (d.c(string2)) {
                        string2 = d.a(string2);
                    }
                }
                String strE = d.e(context);
                jSONObject2.put(bt.A, strE);
                jSONObject2.put("o_mc", string2);
                a(context, jSONObject2);
                jSONObject2.put("aaid", d.d(context));
                jSONObject2.put("uabc", d.c(context));
                if (context != null && (sharedPreferencesA = com.umeng.umzid.a.a(context)) != null) {
                    string3 = sharedPreferencesA.getString("resetToken", "");
                }
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject2.put("rt", string3);
                }
                try {
                    jSONObject = new JSONObject();
                } catch (Throwable th2) {
                    th = th2;
                    jSONObject = null;
                }
                try {
                    jSONObject.put("vpn_pxy", d.i(context));
                    jSONObject.put("wifi_pxy", d.j(context));
                    jSONObject.put("double", d.g(context));
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                }
                if (jSONObject != null) {
                    jSONObject2.put("anti", jSONObject);
                }
                String strB = d.b(context);
                if (strB.length() <= 0) {
                    strB = "https://utoken.umeng.com";
                }
                String strA = com.umeng.umzid.a.a(strB + "/anti/updateZdata", jSONObject2.toString());
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject3 = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject3.optBoolean("suc")).booleanValue()) {
                        d.f(context, id);
                        d.a(context, strE);
                        d.b(context, strF);
                        strOptString = jSONObject3.optString("aaid");
                        if (!TextUtils.isEmpty(strOptString)) {
                            d.e(context, strOptString);
                        }
                        String strOptString2 = jSONObject3.optString("uabc");
                        if (!TextUtils.isEmpty(strOptString2)) {
                            d.d(context, strOptString2);
                        }
                        String strOptString3 = jSONObject3.optString("resetToken");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            d.c(context, strOptString3);
                        }
                    }
                }
                a(context);
            } catch (Throwable unused) {
            }
        }
        this.b = false;
        return strOptString;
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String strD = d.d(applicationContext);
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        com.umeng.umzid.c.a(new c(applicationContext));
        return "";
    }

    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        boolean zH = d.h(context);
        this.c = zH;
        if (zH) {
            if (context == null) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1001", "传入参数Context为null");
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1003", "传入参数appkey为空");
                }
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null && str != null && !TextUtils.isEmpty(str) && (sharedPreferencesA = com.umeng.umzid.a.a(applicationContext)) != null && (editorEdit = sharedPreferencesA.edit()) != null) {
                editorEdit.putString("appkey", str).commit();
            }
            String strD = d.d(applicationContext);
            if (strD == null || TextUtils.isEmpty(strD)) {
                com.umeng.umzid.c.a(new a(applicationContext, iZIDCompletionCallback));
            } else {
                com.umeng.umzid.c.a(new b(applicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(strD);
                }
            }
            SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
            if (TextUtils.isEmpty(sharedPreferencesA2 != null ? sharedPreferencesA2.getString(Constant.MAP_KEY_UUID, "") : "")) {
                String string = "";
                SharedPreferences sharedPreferencesA3 = com.umeng.umzid.a.a(context);
                try {
                    string = UUID.randomUUID().toString();
                } catch (Throwable unused) {
                }
                if (sharedPreferencesA3 != null) {
                    sharedPreferencesA3.edit().putString(Constant.MAP_KEY_UUID, string).commit();
                }
            }
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        Throwable th;
        JSONObject jSONObject;
        String strOptString = null;
        if (!zIDManager.f11140a) {
            zIDManager.f11140a = true;
            JSONObject jSONObject2 = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject2.put("z", id);
                String strE = d.e(context);
                jSONObject2.put(bt.A, strE);
                String strF = d.f(context);
                jSONObject2.put("o", strF);
                try {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("vpn_pxy", d.i(context));
                        jSONObject.put("wifi_pxy", d.j(context));
                        jSONObject.put("double", d.g(context));
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    jSONObject2.put("anti", jSONObject);
                }
                zIDManager.a(context, jSONObject2);
                String strB = d.b(context);
                if (strB.length() <= 0) {
                    strB = "https://utoken.umeng.com";
                }
                String strA = com.umeng.umzid.a.a(strB + "/anti/postZdata", jSONObject2.toString());
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject3 = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject3.optBoolean("suc")).booleanValue()) {
                        d.f(context, id);
                        d.a(context, strE);
                        d.b(context, strF);
                        strOptString = jSONObject3.optString("aaid");
                        if (!TextUtils.isEmpty(strOptString)) {
                            d.e(context, strOptString);
                        }
                        String strOptString2 = jSONObject3.optString("uabc");
                        if (!TextUtils.isEmpty(strOptString2)) {
                            d.d(context, strOptString2);
                        }
                        String strOptString3 = jSONObject3.optString("resetToken");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            d.c(context, strOptString3);
                        }
                    }
                }
                zIDManager.a(context);
            } finally {
                try {
                } finally {
                }
            }
        }
        return strOptString;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject a(Context context, JSONObject jSONObject) throws JSONException {
        Locale locale;
        int rawOffset;
        Object obj;
        String string;
        Object obj2;
        Object objValueOf;
        Object country;
        SharedPreferences sharedPreferencesA;
        Method declaredMethod;
        Object obj3 = "";
        jSONObject.putOpt("z_v", Spy.getVersion());
        jSONObject.putOpt("a_id", d.a(context));
        jSONObject.putOpt("os_v", Build.VERSION.RELEASE);
        Object string2 = null;
        if (context == null) {
            rawOffset = 8;
        } else {
            try {
                Configuration configuration = new Configuration();
                configuration.setToDefaults();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (Throwable unused) {
                locale = null;
            }
            if (locale == null) {
                try {
                    locale = Locale.getDefault();
                } catch (Throwable unused2) {
                }
            }
            Calendar calendar = Calendar.getInstance(locale);
            if (calendar != null) {
                rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
            }
        }
        jSONObject.putOpt("tz", Integer.valueOf(rawOffset));
        jSONObject.putOpt("m", Build.MODEL);
        try {
            String str = DeviceConfig.UNKNOW;
            declaredMethod = DeviceConfig.class.getDeclaredMethod("getImeiNew", Context.class);
        } catch (Throwable unused3) {
        }
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(DeviceConfig.class, context);
            obj = (objInvoke == null || !(objInvoke instanceof String)) ? "" : (String) objInvoke;
        }
        jSONObject.putOpt("im", obj);
        try {
            Method declaredMethod2 = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod2.setAccessible(true);
            string = declaredMethod2.invoke(null, "net.hostname").toString();
            if (string != null) {
                try {
                    if (!string.equalsIgnoreCase("")) {
                        try {
                            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                            messageDigest.update(string.getBytes());
                            byte[] bArrDigest = messageDigest.digest();
                            StringBuffer stringBuffer = new StringBuffer();
                            for (byte b2 : bArrDigest) {
                                stringBuffer.append(Integer.toHexString(b2 & UByte.MAX_VALUE));
                            }
                            string = stringBuffer.toString();
                        } catch (Throwable unused4) {
                            string = "";
                        }
                    }
                } catch (Exception unused5) {
                }
            }
        } catch (Exception unused6) {
            string = null;
        }
        jSONObject.putOpt("hn", string);
        jSONObject.putOpt("s_v", "1.8.7");
        jSONObject.putOpt("pkg", context == null ? null : context.getPackageName());
        jSONObject.putOpt("s_t", AnalyticsConstants.SDK_TYPE);
        SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
        jSONObject.putOpt(DeviceInfoUtil.UID_TAG, sharedPreferencesA2 != null ? sharedPreferencesA2.getString(Constant.MAP_KEY_UUID, "") : "");
        jSONObject.putOpt("s_id", BaseConstants.CATEGORY_UMENG);
        try {
            obj2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            obj2 = null;
        }
        jSONObject.putOpt("a_v", obj2);
        try {
            objValueOf = String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
        } catch (Exception e2) {
            e2.printStackTrace();
            objValueOf = null;
        }
        jSONObject.putOpt("a_n", objValueOf);
        try {
            country = context.getResources().getConfiguration().locale.getCountry();
        } catch (Exception e3) {
            e3.printStackTrace();
            country = null;
        }
        jSONObject.putOpt("c", country);
        if (context != null && (sharedPreferencesA = com.umeng.umzid.a.a(context)) != null) {
            string2 = sharedPreferencesA.getString("appkey", null);
        }
        jSONObject.putOpt("ak", string2);
        try {
            String str2 = DeviceConfig.UNKNOW;
            Method declaredMethod3 = DeviceConfig.class.getDeclaredMethod("getIdfa", Context.class);
            if (declaredMethod3 != null) {
                declaredMethod3.setAccessible(true);
                Object objInvoke2 = declaredMethod3.invoke(DeviceConfig.class, context);
                if (objInvoke2 != null && (objInvoke2 instanceof String)) {
                    obj3 = (String) objInvoke2;
                }
            }
        } catch (Throwable unused7) {
        }
        jSONObject.putOpt("gd", obj3);
        return jSONObject;
    }
}
