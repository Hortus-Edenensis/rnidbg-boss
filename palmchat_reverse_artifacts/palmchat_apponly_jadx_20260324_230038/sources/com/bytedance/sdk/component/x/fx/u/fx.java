package com.bytedance.sdk.component.x.fx.u;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.b.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class fx {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> u;

    private static String b(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static SharedPreferences fx(String str) {
        return ((a) com.bytedance.sdk.openadsdk.ats.fx.u("kv_store_factory")).get(b(str));
    }

    private static void nr(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = u;
        if (softReference == null || softReference.get() == null) {
            u = new SoftReference<>(new ConcurrentHashMap());
        }
        String strB = b(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = u.get();
        if (concurrentHashMap.get(strB) == null) {
            concurrentHashMap.put(strB, new HashMap());
        }
        concurrentHashMap.get(strB).put(str2, obj);
    }

    private static void pn(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = u;
        if (softReference == null || softReference.get() == null || (map = u.get().get(b(str))) == null) {
            return;
        }
        map.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized <T> void u(String str, String str2, T t) {
        SharedPreferences sharedPreferencesFx = fx(str);
        if (sharedPreferencesFx == null) {
            return;
        }
        if (t.equals(fx(str, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesFx.edit();
        if (t instanceof Boolean) {
            editorEdit.putBoolean(str2, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            editorEdit.putString(str2, (String) t);
        }
        if (t instanceof Integer) {
            editorEdit.putInt(str2, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            editorEdit.putLong(str2, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            editorEdit.putFloat(str2, ((Float) t).floatValue());
        }
        editorEdit.apply();
        nr(str, str2, t);
    }

    private static Object fx(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = u;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(b(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static String fx(String str, String str2, String str3) {
        SharedPreferences sharedPreferencesFx = fx(str);
        return sharedPreferencesFx == null ? str3 : sharedPreferencesFx.getString(str2, str3);
    }

    private static Object nr(String str, String str2, String str3) {
        String strB = b(str);
        if (!u(strB, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return fx(strB, str2, null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(u(strB, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(u(strB, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(u(strB, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(u(strB, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return fx(strB, str2, null);
        }
        return null;
    }

    public static String u(String str, String str2, String str3) {
        Object objFx = fx(str, str2);
        if (objFx != null) {
            return String.valueOf(objFx);
        }
        Object objNr = nr(str, str2, str3);
        nr(str, str2, objNr);
        return String.valueOf(objNr);
    }

    public static void nr(String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences sharedPreferencesFx = fx(str);
            if (sharedPreferencesFx == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesFx.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = u;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            String strB = b(str);
            if (!TextUtils.isEmpty(strB) && (map = u.get().get(strB)) != null && map.size() != 0) {
                map.remove(str2);
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = u;
                if (softReference2 == null || softReference2.get() == null) {
                    return;
                }
                u.get().put(strB, map);
            }
        } catch (Throwable unused) {
        }
    }

    private static int u(String str, String str2, int i) {
        SharedPreferences sharedPreferencesFx = fx(str);
        return sharedPreferencesFx == null ? i : sharedPreferencesFx.getInt(str2, i);
    }

    private static float u(String str, String str2, float f) {
        SharedPreferences sharedPreferencesFx = fx(str);
        return sharedPreferencesFx == null ? f : sharedPreferencesFx.getFloat(str2, f);
    }

    private static boolean u(String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesFx = fx(str);
        return sharedPreferencesFx == null ? z : sharedPreferencesFx.getBoolean(str2, z);
    }

    private static long u(String str, String str2, long j) {
        SharedPreferences sharedPreferencesFx = fx(str);
        return sharedPreferencesFx == null ? j : sharedPreferencesFx.getLong(str2, j);
    }

    public static boolean u(String str, String str2) {
        SharedPreferences sharedPreferencesFx = fx(str);
        return sharedPreferencesFx != null && sharedPreferencesFx.contains(str2);
    }

    public static void u(String str) {
        SharedPreferences.Editor editorEdit = fx(str).edit();
        editorEdit.clear();
        editorEdit.apply();
        pn(str);
    }

    public static Map<String, ?> nr(String str) {
        return fx(str).getAll();
    }
}
