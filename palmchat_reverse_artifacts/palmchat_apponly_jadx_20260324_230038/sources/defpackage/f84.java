package defpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class f84 {
    public static boolean a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.opt(next).toString());
            }
            Map<String, String> mapA = ah.c((String) map.get("tappid"), (String) map.get("scene")).a((String) map.get("code"));
            mapA.putAll(map);
            zn6.i("LX_APP_STATE", mapA);
            return true;
        } catch (JSONException e) {
            ma3.c(e);
            return false;
        }
    }

    public static void b(iw4 iw4Var, String str) {
        try {
            ma3.a(iw4Var.e + ":" + new JSONObject(iw4Var.a(str)), new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        zn6.i(iw4Var.e, iw4Var.a(str));
    }

    public static boolean c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            iw4 iw4Var = new iw4("LX_THIRD_EVENT");
            iw4Var.f18275a = str;
            iw4Var.f = jSONObject.optString("data");
            b(iw4Var, jSONObject.optString("code"));
            return true;
        } catch (JSONException e) {
            ma3.c(e);
            return false;
        }
    }

    public static void d(String str, String str2) {
        iw4 iw4Var = new iw4("LX_THIRD_EVENT");
        iw4Var.f18275a = str;
        b(iw4Var, str2);
    }

    public static void e(ah ahVar, String str) {
        ma3.a(ahVar.e + ":" + ahVar.a(str), new Object[0]);
        zn6.i(ahVar.e, ahVar.a(str));
    }
}
