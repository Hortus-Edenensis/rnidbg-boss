package defpackage;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class s34 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f20656a = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i("NotificationUtils", "uploadNotificationStatusOnChange onResponse=" + jSONObject);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i("NotificationUtils", "uploadNotificationStatusOnChange onErrorResponse=" + volleyError);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("action", "get_notification_main");
            put("status", s34.d());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends yw4 {
        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            s34.f20656a = false;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", 0);
                LogUtil.uploadInfoImmediate("new_moveback", null, null, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            s34.f20656a = false;
            try {
                int i = jSONObject.getInt("resultCode");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", i == 0 ? 1 : 0);
                LogUtil.uploadInfoImmediate("new_moveback", null, null, jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static int c() {
        String strD = d();
        if ("YES".equals(strD)) {
            return 1;
        }
        return "NO".equals(strD) ? 0 : -1;
    }

    public static String d() {
        if (Build.VERSION.SDK_INT >= 24) {
            NotificationManager notificationManager = (NotificationManager) AppContext.getContext().getSystemService("notification");
            if (notificationManager == null) {
                return "UNKNOW";
            }
            try {
                return notificationManager.areNotificationsEnabled() ? "YES" : "NO";
            } catch (Exception unused) {
                return "UNKNOW";
            }
        }
        AppOpsManager appOpsManager = (AppOpsManager) AppContext.getContext().getSystemService("appops");
        if (appOpsManager == null) {
            return "UNKNOW";
        }
        ApplicationInfo applicationInfo = AppContext.getContext().getApplicationInfo();
        String packageName = AppContext.getContext().getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0 ? "YES" : "NO";
        } catch (Exception unused2) {
            return "UNKNOW";
        }
    }

    public static boolean e(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean f(String str, String str2) {
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            Long lValueOf = Long.valueOf(str);
            Long lValueOf2 = Long.valueOf(str2);
            String str3 = simpleDateFormat.format(lValueOf);
            String str4 = simpleDateFormat2.format(lValueOf2);
            Date date = simpleDateFormat.parse(str3);
            Date date2 = simpleDateFormat2.parse(str4);
            calendar.setTime(date);
            calendar2.setTime(date2);
            return g(calendar, calendar2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean g(Calendar calendar, Calendar calendar2) {
        return calendar != null && calendar2 != null && calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static void h() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        long jI = sPUtil.i(scene, "notify_per_last_upload_new", 0L);
        int iF = sPUtil.f(scene, "notify_per_last_status", -1);
        long jB = ir5.b();
        int iC = c();
        if (f(String.valueOf(jB), String.valueOf(jI)) && iF == iC) {
            return;
        }
        sPUtil.t(scene, "notify_per_last_upload_new", Long.valueOf(jB));
        if (iF != iC) {
            sPUtil.t(scene, "notify_per_last_status", Integer.valueOf(iC));
        }
        k(iC);
    }

    public static void i() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        int iF = sPUtil.f(scene, "notify_per_last_status", -1);
        int iC = c();
        sPUtil.t(scene, "notify_per_last_upload_new", Long.valueOf(ir5.b()));
        if (iF != iC) {
            sPUtil.t(scene, "notify_per_last_status", Integer.valueOf(iC));
        }
        k(iC);
    }

    public static void j() {
        if (TextUtils.isEmpty(v4.e(AppContext.getContext()))) {
            return;
        }
        Log.d("NotificationUtils", "notifyAppBackground");
        if (f20656a) {
            return;
        }
        d dVar = new d();
        f20656a = true;
        g00.a(dVar);
    }

    public static void k(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
            jSONObject.put("manufacturer", ac1.f1194a);
            jSONObject.put(WkParams.MODEL, ac1.b);
            jSONObject.put("osVersion", ac1.e);
            String strP = AccountUtils.p(AppContext.getContext());
            String strO = AccountUtils.o(AppContext.getContext());
            if (TextUtils.isEmpty(strP) || TextUtils.isEmpty(strO)) {
                jSONObject.put("type", -1);
            } else {
                jSONObject.put("type", by5.k(SPUtil.f14322a.i(SPUtil.SCENE.NOTIFY_GUIDE, k86.a("key_new_user_register_time"), -1L)) ? 1 : 0);
            }
            jSONObject.put("rom_name", wb1.b());
            jSONObject.put("rom_name_ver", wb1.d());
            jSONObject.put("isHarmony", wb1.h());
            jSONObject.put("arch64", wb1.g());
            jSONObject.put("isIgnoreBatteryOpt", e(AppContext.getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("np01", "1", null, jSONObject.toString());
    }

    public static void l() {
        m();
        String strI = r75.i(AppContext.getContext(), "sp_notification_log_data");
        String strValueOf = String.valueOf(System.currentTimeMillis());
        int iG = 0;
        if (f(strValueOf, strI)) {
            iG = r75.g(AppContext.getContext(), "sp_notification_log_count", 0);
        } else {
            LogUtil.d("NotificationUtils", "uploadNotificationLog not same day");
            r75.r(AppContext.getContext(), "sp_notification_log_data", strValueOf);
        }
        LogUtil.i("NotificationUtils", "uploadNotificationLog count = " + iG);
        if (iG > 2) {
            return;
        }
        r75.p(AppContext.getContext(), "sp_notification_log_count", iG + 1);
        LogUtil.i("NotificationUtils", LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new c(), (Throwable) null);
    }

    public static void m() {
        int iB = AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
        boolean z = !yg4.a(iB, 1024);
        boolean z2 = c() != 0;
        LogUtil.i("NotificationUtils", "uploadNotificationStatusOnChange1111 config=" + iB + "open=" + z + "current=" + z2);
        if (z != z2) {
            int iB2 = yg4.b(iB, !z2, 1024);
            LogUtil.i("NotificationUtils", "uploadNotificationStatusOnChange2222 config=" + iB + "open=" + z + "current=" + z2 + "mPrivacyConfig=" + iB2);
            AppContext.getContext().getTrayPreferences().f(k86.w(), iB2);
            try {
                HashMap map = new HashMap();
                map.put("privacyConfig", Integer.valueOf(iB2));
                new eq3(new a(), new b()).n(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
