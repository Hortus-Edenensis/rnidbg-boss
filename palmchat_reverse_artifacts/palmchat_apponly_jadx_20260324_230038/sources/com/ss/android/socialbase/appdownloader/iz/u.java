package com.ss.android.socialbase.appdownloader.iz;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    private static final HashMap<String, x.u> u = new HashMap<>();

    public static boolean fx(JSONObject jSONObject) {
        return jSONObject == null || iz.u() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean nr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        String strOptString = jSONObject.optString("allow_os_api_range");
        int iOptInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(strOptString)) {
            return iOptInt <= 0 || i >= iOptInt;
        }
        try {
            String[] strArrSplit = strOptString.split("[-,]");
            for (int i2 = 0; i2 < strArrSplit.length; i2 += 2) {
                int i3 = Integer.parseInt(strArrSplit[i2]);
                int i4 = Integer.parseInt(strArrSplit[i2 + 1]);
                if (i >= i3 && i <= i4) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean u(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("type")) && u(jSONObjectOptJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return nr(jSONObject) && u(jSONObject.optJSONArray("device_requirements")) && fx(jSONObject);
    }

    public static boolean u(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean zU = false;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("package_names");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("version_allow");
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("version_block");
                String strOptString2 = jSONObjectOptJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                for (String strJk : strOptString.split(",")) {
                    if (BaseConstants.SCHEME_MARKET.equals(strJk)) {
                        strJk = pn.jk();
                    }
                    x.u uVarNr = nr(strJk);
                    if (uVarNr != null && !(zU = u(jSONArrayOptJSONArray, jSONArrayOptJSONArray2, strOptString2, uVarNr))) {
                        return false;
                    }
                }
            }
        }
        return zU;
    }

    private static boolean nr(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static x.u nr(String str) {
        HashMap<String, x.u> map = u;
        if (map.containsKey(str)) {
            x.u uVar = map.get(str);
            if (uVar != null) {
                return uVar;
            }
            return null;
        }
        x.u uVarNr = x.nr(str);
        map.put(str, uVarNr);
        if (uVarNr != null) {
            return uVarNr;
        }
        return null;
    }

    private static boolean u(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull x.u uVar) {
        String strX = uVar.x();
        int iIz = uVar.iz();
        String str2 = iIz + "_" + strX;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("[-,]");
                for (int i = 0; i < strArrSplit.length; i += 2) {
                    int i2 = Integer.parseInt(strArrSplit[i]);
                    int i3 = Integer.parseInt(strArrSplit[i + 1]);
                    if (iIz >= i2 && iIz <= i3) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (nr(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !nr(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static x.u u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                x.u uVarNr = nr(str);
                if (uVarNr != null) {
                    return uVarNr;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean u(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("s");
            try {
                String strU = fx.u(jSONObject.optString("az"), strOptString);
                String strU2 = fx.u(jSONObject.optString("ba"), strOptString);
                Field declaredField = ContextWrapper.class.getDeclaredField(strU);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(strU2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
