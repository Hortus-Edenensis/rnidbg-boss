package defpackage;

import android.content.Context;
import android.net.Uri;
import com.zenmen.openapi.OpenApiManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wa3 {
    public static void a(String str, String str2, e84 e84Var) {
        OpenApiManager.configNativeApp(str, str2, e84Var);
    }

    public static JSONObject b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", str);
            jSONObject.put("msg", str2);
        } catch (JSONException e) {
            ma3.c(e);
        }
        return jSONObject;
    }

    public static boolean c(Context context, String str, String str2, String str3, String str4) {
        return bu3.g().j(context, Uri.parse("zenxin://webapp").buildUpon().appendQueryParameter("url", str).appendQueryParameter("appId", str2).appendQueryParameter("scene", str3).appendQueryParameter("windowStyle", str4).toString());
    }

    public static boolean d(Context context, JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("appId");
            String string2 = jSONObject.getString("url");
            String strOptString = jSONObject.optString("scene", "video");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("windowStyle");
            return c(context, string2, string, strOptString, jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : "");
        } catch (JSONException e) {
            ma3.d("open webapp failed please check appId or url values");
            ma3.c(e);
            return false;
        }
    }
}
