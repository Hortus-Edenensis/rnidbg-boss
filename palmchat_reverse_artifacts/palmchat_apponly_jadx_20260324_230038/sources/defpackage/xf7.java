package defpackage;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lantern.core.configuration.ConfigConstant;
import java.io.File;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class xf7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f21947a = new JSONObject();

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            String strC = nv6.c(jSONObject);
            File file = new File(wi7.E(x97.m()), "apmlite/configCrash/configNative");
            if (strC != null) {
                JSONObject jSONObject2 = new JSONObject(strC);
                f21947a = jSONObject2;
                re7.m(file, g(jSONObject2), false);
            } else {
                f21947a = new JSONObject();
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
    }

    public static boolean b(String str, wb7 wb7Var) {
        if (f21947a == null) {
            return false;
        }
        if (wb7Var == null) {
            wb7Var = new wb7();
        }
        JSONObject jSONObjectOptJSONObject = f21947a.optJSONObject(str);
        if (jSONObjectOptJSONObject == null || c(jSONObjectOptJSONObject.optJSONArray("disable"), wb7Var)) {
            return false;
        }
        return c(jSONObjectOptJSONObject.optJSONArray("enable"), wb7Var);
    }

    public static boolean c(JSONArray jSONArray, wb7 wb7Var) {
        if (gg7.f(jSONArray)) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                n37.a();
                n37.b("NPTH_CATCH", new IllegalArgumentException("err config: " + jSONArray));
            } else if (d(jSONObjectOptJSONObject, wb7Var)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(JSONObject jSONObject, wb7 wb7Var) {
        StringBuilder sb;
        Iterator<String> itKeys = jSONObject.keys();
        boolean z = false;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                if (next.startsWith("header_")) {
                    if (!e(jSONObject.optJSONObject(next), wb7Var.b(next.substring(7)))) {
                        sb = new StringBuilder();
                        sb.append("not match ");
                        sb.append(next);
                        kj7.a(sb.toString());
                        return false;
                    }
                    z = true;
                } else {
                    if (!next.startsWith("java_")) {
                        kj7.a("no rules match " + next);
                    } else if (!e(jSONObject.optJSONObject(next), wb7Var.a(next.substring(5)))) {
                        sb = new StringBuilder();
                        sb.append("not match ");
                        sb.append(next);
                        kj7.a(sb.toString());
                        return false;
                    }
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean e(JSONObject jSONObject, Object obj) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
        if (jSONArrayOptJSONArray.length() == 0) {
            return false;
        }
        String strOptString = jSONObject.optString(ConfigConstant.COLUMN_OP);
        String strValueOf = String.valueOf(obj);
        if (strOptString.equals(ContainerUtils.KEY_VALUE_DELIMITER)) {
            return strValueOf.equals(String.valueOf(jSONArrayOptJSONArray.opt(0)));
        }
        if (strOptString.equals("in")) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (String.valueOf(jSONArrayOptJSONArray.opt(i)).equals(strValueOf)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONArray f(JSONArray jSONArray, wb7 wb7Var) {
        JSONArray jSONArray2 = new JSONArray();
        if (gg7.f(jSONArray)) {
            return jSONArray2;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                n37.a();
                n37.b("NPTH_CATCH", new IllegalArgumentException("err config: " + jSONArray));
            } else if (d(jSONObjectOptJSONObject, wb7Var)) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    public static JSONObject g(JSONObject jSONObject) {
        StringBuilder sb;
        String str;
        Iterator<String> itKeys = jSONObject.keys();
        wb7 wb7Var = new wb7();
        JSONObject jSONObject2 = new JSONObject();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!"configType".equals(next)) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject == null) {
                    n37.a();
                    n37.b("NPTH_CATCH", new IllegalArgumentException("err config with key: " + next));
                } else {
                    if (c(jSONObjectOptJSONObject.optJSONArray("disable"), wb7Var)) {
                        sb = new StringBuilder();
                        str = "match diable ";
                    } else {
                        JSONArray jSONArrayF = f(jSONObjectOptJSONObject.optJSONArray("enable"), wb7Var);
                        if (gg7.f(jSONArrayF)) {
                            sb = new StringBuilder();
                            str = "not match ";
                        } else {
                            try {
                                jSONObject2.put(next, new JSONObject().put("enable", jSONArrayF));
                            } catch (JSONException unused) {
                            }
                        }
                    }
                    sb.append(str);
                    sb.append(next);
                    kj7.a(sb.toString());
                }
            }
        }
        return jSONObject2;
    }
}
