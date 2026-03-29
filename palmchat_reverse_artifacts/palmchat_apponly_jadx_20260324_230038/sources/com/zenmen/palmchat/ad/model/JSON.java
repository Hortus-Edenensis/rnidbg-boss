package com.zenmen.palmchat.ad.model;

import com.huawei.hms.ads.ex;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
class JSON {
    public static Boolean toBoolean(String str, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (ex.Code.equalsIgnoreCase(str2)) {
                return Boolean.TRUE;
            }
            if (ex.V.equalsIgnoreCase(str2)) {
                return Boolean.FALSE;
            }
            try {
                if (Integer.valueOf(str2).intValue() == 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (obj instanceof Integer) {
            return Boolean.valueOf(((Integer) obj).intValue() != 0);
        }
        throw typeMismatch(str, obj, "boolean");
    }

    public static Double toDouble(String str, Object obj) throws JSONException {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException unused) {
            }
        }
        throw typeMismatch(str, obj, "double");
    }

    public static Float toFloat(String str, Object obj) throws JSONException {
        if (obj instanceof Float) {
            return (Float) obj;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            try {
                return Float.valueOf((String) obj);
            } catch (NumberFormatException unused) {
            }
        }
        throw typeMismatch(str, obj, "float");
    }

    public static Integer toInteger(String str, Object obj) throws JSONException {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException unused) {
            }
        }
        throw typeMismatch(str, obj, "int");
    }

    public static Long toLong(String str, Object obj) throws JSONException {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf((String) obj);
            } catch (NumberFormatException unused) {
            }
        }
        throw typeMismatch(str, obj, "long");
    }

    public static String toString(String str, Object obj) throws JSONException {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        throw typeMismatch(str, obj, "string");
    }

    private static JSONException typeMismatch(Object obj, Object obj2, String str) throws JSONException {
        if (obj2 == null) {
            throw new JSONException("Value at " + obj + " is null.");
        }
        throw new JSONException("Value " + obj2 + " at " + obj + " of type " + obj2.getClass().getName() + " cannot be converted to " + str);
    }
}
