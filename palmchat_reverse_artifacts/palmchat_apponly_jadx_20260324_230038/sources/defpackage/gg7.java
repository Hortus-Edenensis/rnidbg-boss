package defpackage;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class gg7 {
    public static int a(JSONObject jSONObject, int i, String... strArr) {
        JSONObject jSONObjectJ = j(jSONObject, strArr);
        if (jSONObjectJ == null) {
            return i;
        }
        int iOptInt = jSONObjectJ.optInt(strArr[strArr.length - 1], i);
        kj7.c("JSONUtil", "normal get jsonInt: " + strArr[strArr.length - 1] + " : " + iOptInt);
        return iOptInt;
    }

    public static JSONArray b(int i, int i2, JSONArray jSONArray) {
        int i3 = i2 + i;
        if (jSONArray.length() <= i3) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i4 = 0; i4 < i; i4++) {
            jSONArray2.put(jSONArray.opt(i4));
        }
        while (i < i3) {
            jSONArray2.put(jSONArray.opt(jSONArray.length() - (i3 - i)));
            i++;
        }
        return jSONArray2;
    }

    public static JSONArray c(JSONObject jSONObject, String... strArr) {
        JSONObject jSONObjectJ = j(jSONObject, strArr);
        if (jSONObjectJ == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectJ.optJSONArray(strArr[strArr.length - 1]);
        kj7.c("ApmConfig", "normal get configArray: " + strArr[strArr.length - 1] + " : " + jSONArrayOptJSONArray);
        return jSONArrayOptJSONArray;
    }

    public static JSONArray d(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : strArr) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    public static void e(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                if (!jSONObject.has(next)) {
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (Throwable unused) {
                return;
            }
        }
    }

    public static boolean f(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static boolean g(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static boolean h(JSONObject jSONObject, String str) {
        return g(jSONObject) || f(jSONObject.optJSONArray(str));
    }

    public static String i(JSONObject jSONObject, String... strArr) {
        JSONObject jSONObjectJ = j(jSONObject, strArr);
        if (jSONObjectJ == null) {
            return null;
        }
        String strOptString = jSONObjectJ.optString(strArr[strArr.length - 1]);
        kj7.c("ApmConfig", "normal get configArray: " + strArr[strArr.length - 1] + " : " + strOptString);
        return strOptString;
    }

    public static JSONObject j(JSONObject jSONObject, String... strArr) {
        if (jSONObject == null) {
            kj7.d("JSONUtil", "err get JsonFromParent: null json", new RuntimeException());
            return null;
        }
        for (int i = 0; i < strArr.length - 1; i++) {
            jSONObject = jSONObject.optJSONObject(strArr[i]);
            if (jSONObject == null) {
                kj7.c("JSONUtil", "err get json: not found node:" + strArr[i]);
                return null;
            }
        }
        return jSONObject;
    }
}
