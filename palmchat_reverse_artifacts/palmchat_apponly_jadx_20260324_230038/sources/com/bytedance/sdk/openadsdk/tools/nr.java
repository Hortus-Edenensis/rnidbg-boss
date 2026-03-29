package com.bytedance.sdk.openadsdk.tools;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.igexin.push.core.b;
import com.qq.gdt.action.ActionUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static long b = 0;
    private static Map<Integer, String> fx = null;
    private static boolean nr = false;
    private static String u = "SettingRitRepertoryImpl";

    private static Map<Integer, String> b() {
        HashMap map = new HashMap();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "setting_global_info", new String[]{"_id", ActionUtils.PAYMENT_AMOUNT}, null, null, null, null, null);
                if (cursorQuery == null) {
                    return map;
                }
                while (cursorQuery.moveToNext()) {
                    try {
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                        Integer numValueOf = Integer.valueOf(i);
                        if (string == null) {
                            string = "";
                        }
                        map.put(numValueOf, string);
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                if (0 != 0) {
                }
                return map;
            }
            cursorQuery.close();
            return map;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), "setting_rit", "rit=?", new String[]{str});
    }

    public static String fx() {
        return "CREATE TABLE IF NOT EXISTS setting_rit (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT UNIQUE,value TEXT,slot TEXT,config TEXT,preview_ads TEXT)";
    }

    public static void nr() {
        nr = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean pn(String str) {
        boolean z;
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                z = cursorQuery.getCount() > 0;
            } finally {
                cursorQuery.close();
            }
        }
        if (cursorQuery != null) {
        }
        return z;
    }

    public static boolean u() {
        return nr;
    }

    public static JSONObject fx(String str) throws JSONException {
        int columnIndex;
        if (!u()) {
            return null;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        try {
            String string = (!cursorQuery.moveToNext() || (columnIndex = cursorQuery.getColumnIndex("preview_ads")) < 0) ? "" : cursorQuery.getString(columnIndex);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.u.fx(string));
                try {
                    cursorQuery.close();
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
        try {
            cursorQuery.close();
        } catch (Throwable unused3) {
        }
        return null;
    }

    public static JSONObject nr(String str) throws JSONException {
        int columnIndex;
        if (!u()) {
            return null;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        try {
            String string = (!cursorQuery.moveToNext() || (columnIndex = cursorQuery.getColumnIndex(b.Y)) < 0) ? "" : cursorQuery.getString(columnIndex);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.u.fx(string));
                try {
                    cursorQuery.close();
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
        try {
            cursorQuery.close();
        } catch (Throwable unused3) {
        }
        return null;
    }

    public static String u(int i, String str) {
        if (fx == null || System.currentTimeMillis() - b > 2000) {
            b = System.currentTimeMillis();
            fx = b();
        }
        Map<Integer, String> map = fx;
        if (map != null && !map.containsKey(Integer.valueOf(i))) {
            return str;
        }
        try {
            String strFx = com.bytedance.sdk.component.utils.u.fx(map.get(Integer.valueOf(i)));
            return b.m.equals(strFx) ? "" : strFx;
        } catch (Exception unused) {
            return str;
        }
    }

    public static Map<String, String> u(String str) throws JSONException {
        JSONObject jSONObjectNr = nr(str);
        HashMap map = null;
        if (jSONObjectNr == null) {
            return null;
        }
        String strOptString = jSONObjectNr.optString("ext");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            HashMap map2 = new HashMap();
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject("headers");
                if (jSONObjectOptJSONObject == null) {
                    return null;
                }
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, jSONObjectOptJSONObject.optString(next));
                }
                return map2;
            } catch (Exception unused) {
                map = map2;
                return map;
            }
        } catch (Exception unused2) {
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("preview_ads", "");
            com.bytedance.sdk.openadsdk.core.multipro.u.u.update(dw.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public static void fx(int i, String str) {
        if (u()) {
            if (TextUtils.isEmpty(str)) {
                str = b.m;
            }
            Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "setting_global_info", null, "_id=?", new String[]{String.valueOf(i)}, null, null, null);
            boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused) {
                }
            }
            String strNr = com.bytedance.sdk.component.utils.u.nr(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(i));
            contentValues.put(ActionUtils.PAYMENT_AMOUNT, strNr);
            if (z) {
                com.bytedance.sdk.openadsdk.core.multipro.u.u.update(dw.getContext(), "setting_global_info", contentValues, "_id=?", new String[]{String.valueOf(i)});
            } else {
                com.bytedance.sdk.openadsdk.core.multipro.u.u.insert(dw.getContext(), "setting_global_info", contentValues);
            }
        }
    }

    public static void nr(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectFx;
        if ((jSONObject == null && TextUtils.isEmpty(str)) || (jSONObjectFx = fx(str)) == null) {
            return;
        }
        if (jSONObjectFx.has("preview_ads_save_time") && System.currentTimeMillis() - jSONObjectFx.optLong("preview_ads_save_time") > 3600000) {
            b(str);
            return;
        }
        if (jSONObjectFx.has("image_mode")) {
            jSONObject.put("image_mode", jSONObjectFx.optString("image_mode"));
        }
        if (jSONObjectFx.has("preview_extra")) {
            jSONObject.put("preview_extra", jSONObjectFx.optString("preview_extra"));
        }
        if (jSONObjectFx.has("preview_ads")) {
            jSONObject.put("preview_ads", jSONObjectFx.optJSONObject("preview_ads"));
        }
    }

    public static void u(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectNr = nr(str);
        if (jSONObjectNr == null) {
            return;
        }
        String strOptString = jSONObjectNr.optString("aid");
        String strOptString2 = jSONObjectNr.optString("cid");
        String strOptString3 = jSONObjectNr.optString("ext");
        if (!TextUtils.isEmpty(strOptString)) {
            jSONObject.put(MediationConstant.EXTRA_ADID, strOptString);
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            jSONObject.put("creative_id", strOptString2);
        }
        if (TextUtils.isEmpty(strOptString3)) {
            return;
        }
        jSONObject.put("ext", strOptString3);
    }

    public static void nr(int i, String str) {
        if (u()) {
            if (TextUtils.isEmpty(str)) {
                str = b.m;
            }
            try {
                com.bytedance.sdk.openadsdk.core.multipro.u.u.u(dw.getContext(), "INSERT OR REPLACE INTO setting_base_info (_id, value) VALUES (" + i + ", '" + com.bytedance.sdk.component.utils.u.nr(str) + "')", "setting_base_info");
            } catch (Exception unused) {
            }
        }
    }

    public static void u(String str, JSONObject jSONObject) {
        if (!u() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObjectU = com.bytedance.sdk.component.utils.u.u(jSONObject);
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put(ActionUtils.PAYMENT_AMOUNT, jSONObjectU.toString());
        if (z) {
            com.bytedance.sdk.openadsdk.core.multipro.u.u.update(dw.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.u.u.insert(dw.getContext(), "setting_rit", contentValues);
        }
    }

    public static void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (u()) {
            String strB = nrVar.b();
            if (pn(strB)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("img_width", nrVar.iz());
                    jSONObject.put("img_height", nrVar.x());
                    jSONObject.put("express_width", nrVar.n());
                    jSONObject.put("express_height", nrVar.a());
                    jSONObject.put("ad_count", nrVar.l());
                } catch (JSONException unused) {
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", strB);
                contentValues.put("slot", com.bytedance.sdk.component.utils.u.nr(jSONObject.toString()));
                com.bytedance.sdk.openadsdk.core.multipro.u.u.update(dw.getContext(), "setting_rit", contentValues, "rit=?", new String[]{strB});
            }
        }
    }
}
