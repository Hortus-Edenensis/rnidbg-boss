package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.push.core.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ru6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20580a;
    public String b;
    public Context c;
    public final String d;
    public final long e;
    public final int f;
    public final String g;
    public boolean h = false;
    public final ActivityInfo i;
    public final zz6 j;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<UUID, ru6> f20581a = new HashMap<>();
        public static final HashMap<String, ru6> b = new HashMap<>();

        public static ru6 a(Intent intent) {
            if (intent == null) {
                return null;
            }
            Serializable serializableExtra = intent.getSerializableExtra("i_uuid_b_c");
            if (serializableExtra instanceof UUID) {
                return f20581a.remove((UUID) serializableExtra);
            }
            return null;
        }

        public static ru6 b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return b.remove(str);
        }

        public static void c(ru6 ru6Var, Intent intent) {
            if (ru6Var == null || intent == null) {
                return;
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            f20581a.put(uuidRandomUUID, ru6Var);
            intent.putExtra("i_uuid_b_c", uuidRandomUUID);
        }

        public static void d(ru6 ru6Var, String str) {
            if (ru6Var == null || TextUtils.isEmpty(str)) {
                return;
            }
            b.put(str, ru6Var);
        }
    }

    public ru6(Context context, String str, String str2) {
        String str3;
        this.f20580a = "";
        this.b = "";
        this.c = null;
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        this.j = new zz6(context, zIsEmpty);
        String strJ = j(str, this.b);
        this.d = strJ;
        this.e = SystemClock.elapsedRealtime();
        this.f = qh7.V();
        ActivityInfo activityInfoD = qh7.d(context);
        this.i = activityInfoD;
        this.g = str2;
        if (!zIsEmpty) {
            xt6.b(this, "biz", "eptyp", str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + strJ);
            if (activityInfoD != null) {
                str3 = activityInfoD.name + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + activityInfoD.launchMode;
            } else {
                str3 = b.m;
            }
            xt6.b(this, "biz", "actInfo", str3);
            xt6.b(this, "biz", NotificationCompat.CATEGORY_SYSTEM, qh7.h(this));
            xt6.b(this, "biz", "sdkv", "ef70839-clean");
        }
        try {
            this.c = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f20580a = packageInfo.versionName;
            this.b = packageInfo.packageName;
        } catch (Exception e) {
            w97.d(e);
        }
        if (!zIsEmpty) {
            xt6.a(this, "biz", "u" + qh7.V());
            xt6.b(this, "biz", "PgApiInvoke", "" + SystemClock.elapsedRealtime());
            xt6.f(context, this, str, this.d);
        }
        if (zIsEmpty || !vt6.I().A()) {
            return;
        }
        vt6.I().f(this, this.c, true, 2);
    }

    public static HashMap<String, String> f(ru6 ru6Var) {
        HashMap<String, String> map = new HashMap<>();
        if (ru6Var != null) {
            map.put(HiAnalyticsConstant.BI_KEY_SDK_VER, "15.8.10");
            map.put("app_name", ru6Var.b);
            map.put("token", ru6Var.d);
            map.put("call_type", ru6Var.g);
            map.put("ts_api_invoke", String.valueOf(ru6Var.e));
            uu6.d(ru6Var, map);
        }
        return map;
    }

    public static String j(String str, String str2) {
        try {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            if (str2 == null) {
                str2 = "";
            }
            objArr[1] = str2;
            objArr[2] = Long.valueOf(System.currentTimeMillis());
            objArr[3] = UUID.randomUUID().toString();
            return String.format("EP%s%s_%s", "1", qh7.X(String.format(locale, "%s%s%d%s", objArr)), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return "-";
        }
    }

    public static ru6 r() {
        return null;
    }

    public Context a() {
        return this.c;
    }

    public String b(String str) {
        return TextUtils.isEmpty(str) ? str : str.startsWith("new_external_info==") ? n(str) : s(str) ? m(str) : p(str);
    }

    public final String c(String str, String str2) {
        return str + e(new JSONObject()) + str2;
    }

    public final String d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(str2);
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!TextUtils.isEmpty(strArrSplit[i]) && strArrSplit[i].startsWith(str3)) {
                return strArrSplit[i];
            }
        }
        return null;
    }

    public String e(JSONObject jSONObject) {
        String str;
        try {
            if (!jSONObject.has("appkey")) {
                jSONObject.put("appkey", "2014052600006128");
            }
            if (!jSONObject.has(MapBundleKey.MapObjKey.OBJ_TYPE)) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_TYPE, "and_lite");
            }
            if (!jSONObject.has("sv")) {
                jSONObject.put("sv", "h.a.3.8.10");
            }
            if (!jSONObject.has("an")) {
                jSONObject.put("an", this.b);
            }
            if (!jSONObject.has(CmcdData.OBJECT_TYPE_MUXED_AUDIO_AND_VIDEO)) {
                jSONObject.put(CmcdData.OBJECT_TYPE_MUXED_AUDIO_AND_VIDEO, this.f20580a);
            }
            if (!jSONObject.has("sdk_start_time")) {
                jSONObject.put("sdk_start_time", System.currentTimeMillis());
            }
            if (!jSONObject.has("extInfo")) {
                jSONObject.put("extInfo", q());
            }
            if (!jSONObject.has("act_info")) {
                if (this.i != null) {
                    str = this.i.name + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.i.launchMode;
                } else {
                    str = b.m;
                }
                jSONObject.put("act_info", str);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            xt6.d(this, "biz", "fmt3", th, String.valueOf(jSONObject));
            w97.d(th);
            return jSONObject != null ? jSONObject.toString() : "{}";
        }
    }

    public void g(boolean z) {
        this.h = z;
    }

    public String h() {
        return this.b;
    }

    public final String i(String str) throws JSONException {
        return e(new JSONObject(str));
    }

    public final String k(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject;
        String strSubstring = str.substring(str2.length());
        boolean z = false;
        String strSubstring2 = strSubstring.substring(0, strSubstring.length() - str3.length());
        if (strSubstring2.length() >= 2 && strSubstring2.startsWith("\"") && strSubstring2.endsWith("\"")) {
            jSONObject = new JSONObject(strSubstring2.substring(1, strSubstring2.length() - 1));
            z = true;
        } else {
            jSONObject = new JSONObject(strSubstring2);
        }
        String strE = e(jSONObject);
        if (z) {
            strE = "\"" + strE + "\"";
        }
        return str2 + strE + str3;
    }

    public String l() {
        return this.f20580a;
    }

    public final String m(String str) {
        try {
            String strD = d(str, ContainerUtils.FIELD_DELIMITER, "bizcontext=");
            if (TextUtils.isEmpty(strD)) {
                str = str + ContainerUtils.FIELD_DELIMITER + c("bizcontext=", "");
            } else {
                int iIndexOf = str.indexOf(strD);
                str = str.substring(0, iIndexOf) + k(strD, "bizcontext=", "") + str.substring(iIndexOf + strD.length());
            }
        } catch (Throwable th) {
            xt6.d(this, "biz", "fmt1", th, str);
        }
        return str;
    }

    public final String n(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str.substring(19));
            jSONObject.put("bizcontext", i(jSONObject.optString("bizcontext")));
            return "new_external_info==" + jSONObject.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public boolean o() {
        return this.h;
    }

    public final String p(String str) {
        try {
            String strD = d(str, "\"&", "bizcontext=\"");
            if (TextUtils.isEmpty(strD)) {
                return str + ContainerUtils.FIELD_DELIMITER + c("bizcontext=\"", "\"");
            }
            if (!strD.endsWith("\"")) {
                strD = strD + "\"";
            }
            int iIndexOf = str.indexOf(strD);
            return str.substring(0, iIndexOf) + k(strD, "bizcontext=\"", "\"") + str.substring(iIndexOf + strD.length());
        } catch (Throwable th) {
            xt6.d(this, "biz", "fmt2", th, str);
            return str;
        }
    }

    public final JSONObject q() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ap_link_token", this.d);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final boolean s(String str) {
        return !str.contains("\"&");
    }
}
