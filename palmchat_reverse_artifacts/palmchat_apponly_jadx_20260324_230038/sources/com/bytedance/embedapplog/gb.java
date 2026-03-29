package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.analytics.pro.bt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class gb {
    private static String u = ":push";

    public static boolean b() {
        x xVarBf;
        n nVarMv = u.mv();
        if (nVarMv == null || (xVarBf = nVarMv.bf()) == null) {
            return false;
        }
        return xVarBf.b();
    }

    public static String fx() {
        x xVarBf;
        n nVarMv = u.mv();
        return (nVarMv == null || (xVarBf = nVarMv.bf()) == null) ? "" : xVarBf.nr();
    }

    public static boolean iz() {
        n nVarMv = u.mv();
        if (nVarMv == null) {
            return false;
        }
        return nVarMv.sx();
    }

    public static Looper n() {
        x xVarBf;
        n nVarMv = u.mv();
        if (nVarMv == null || (xVarBf = nVarMv.bf()) == null) {
            return null;
        }
        return xVarBf.iz();
    }

    public static boolean nr() {
        x xVarBf;
        n nVarMv = u.mv();
        if (nVarMv == null || (xVarBf = nVarMv.bf()) == null) {
            return false;
        }
        return xVarBf.fx();
    }

    public static boolean pn() {
        n nVarMv = u.mv();
        if (nVarMv == null) {
            return false;
        }
        return nVarMv.kj();
    }

    public static boolean u(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static x x() {
        n nVarMv = u.mv();
        if (nVarMv == null) {
            return null;
        }
        return nVarMv.bf();
    }

    public static boolean u(JSONObject jSONObject, JSONObject jSONObject2) {
        return (jSONObject == null || jSONObject2 == null) ? u((Object) jSONObject, (Object) jSONObject2) : jSONObject.toString().equals(jSONObject2.toString());
    }

    public static boolean fx(Context context) {
        String strU = u(context);
        return strU != null && strU.endsWith(u);
    }

    public static String nr(JSONObject jSONObject) {
        try {
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            return bytes.length == 0 ? "" : TTEncryptUtils.clientPackedBase64(bytes, bytes.length);
        } catch (Exception e) {
            bg.nr("parseEncrypt#parse error: " + e.getMessage());
            return "";
        }
    }

    public static String u(Context context) {
        x xVarBf;
        n nVarMv = u.mv();
        return (nVarMv == null || (xVarBf = nVarMv.bf()) == null) ? "" : xVarBf.u(context);
    }

    public static JSONObject fx(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        nr(jSONObject2, jSONObject);
        try {
            String strU = ec.u(jSONObject2.optJSONObject("oaid"));
            if (TextUtils.isEmpty(strU)) {
                return jSONObject2;
            }
            jSONObject2.put("oaid", strU);
            return jSONObject2;
        } catch (Exception e) {
            ti.nr(e);
            return jSONObject2;
        }
    }

    public static boolean u() {
        n nVarMv = u.mv();
        if (nVarMv != null) {
            return nVarMv.d();
        }
        return true;
    }

    public static SharedPreferences nr(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context, mh.u(), 0);
    }

    public static JSONObject u(JSONObject jSONObject) {
        x xVarBf;
        n nVarMv = u.mv();
        return (nVarMv == null || (xVarBf = nVarMv.bf()) == null) ? jSONObject : xVarBf.u(jSONObject);
    }

    public static Looper nr(mh mhVar) {
        n nVarTk;
        x xVarBf;
        if (mhVar == null || (nVarTk = mhVar.tk()) == null || (xVarBf = nVarTk.bf()) == null) {
            return null;
        }
        return xVarBf.iz();
    }

    public static JSONObject u(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("aid", u.x());
            jSONObject2.putOpt("os", "android");
            jSONObject2.putOpt("os_version", Build.VERSION.RELEASE);
            jSONObject2.putOpt(bt.F, Build.BRAND);
            jSONObject2.putOpt(bt.ac, Build.MODEL);
            jSONObject2.putOpt("device_platform", "android");
            if (jSONObject != null) {
                jSONObject2.putOpt("app_version", jSONObject.optString("app_version"));
                if (TextUtils.isEmpty(str)) {
                    jSONObject2.putOpt("device_id", jSONObject.optString("device_id"));
                } else {
                    jSONObject2.putOpt("device_id", str);
                }
                jSONObject2.putOpt("device_model", jSONObject.optString("device_model"));
                jSONObject2.putOpt("os_api", Integer.valueOf(jSONObject.optInt("os_api")));
                jSONObject2.putOpt(bt.s, jSONObject.optString(bt.s));
                jSONObject2.putOpt("package", jSONObject.optString("package"));
                jSONObject2.putOpt("rom", jSONObject.optString("rom"));
                jSONObject2.putOpt("rom_version", a.nr());
                jSONObject2.putOpt("sdk_version", jSONObject.optString("sdk_version_name"));
                jSONObject2.putOpt("version_code", jSONObject.optString("version_code"));
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    public static JSONObject nr(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            ti.nr(e);
        }
        return jSONObject;
    }

    public static Looper u(mh mhVar) {
        n nVarTk;
        x xVarBf;
        if (mhVar == null || (nVarTk = mhVar.tk()) == null || (xVarBf = nVarTk.bf()) == null) {
            return null;
        }
        return xVarBf.pn();
    }

    public static String u(String str, HashMap<String, String> map, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : map.keySet()) {
            String strU = u(str3, str2);
            String str4 = map.get(str3);
            String strU2 = str4 != null ? u(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(strU);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(strU2);
        }
        return sb.toString();
    }

    private static String u(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void u(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                ti.u(th);
            }
        }
    }

    public static void u(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                ti.nr(th);
            }
        }
    }

    public static String u(String str) {
        x xVarBf;
        n nVarMv = u.mv();
        return (nVarMv == null || (xVarBf = nVarMv.bf()) == null) ? "" : xVarBf.u(str);
    }
}
