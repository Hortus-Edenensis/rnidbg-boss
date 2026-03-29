package defpackage;

import android.app.Activity;
import android.net.Uri;
import android.util.Base64;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.openapi.share.OpenShare;
import defpackage.ka3;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class p75 {
    public static String a(String str, String str2, String str3, wn6 wn6Var) {
        return Uri.parse("zenxin://webapp").buildUpon().appendQueryParameter("url", str3).appendQueryParameter("appId", str2).appendQueryParameter("scene", str).appendQueryParameter("windowStyle", wn6Var != null ? wn6Var.toString() : "").toString();
    }

    public static int b(JSONObject jSONObject) throws JSONException {
        return jSONObject.optInt("shareType") == 1 ? 1 : 0;
    }

    public static String c(ka3.b bVar, String str, Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("shareType", 0);
            int iB = b(jSONObject);
            u84 u84Var = new u84();
            u84Var.q(jSONObject.getString("subject"));
            u84Var.n(jSONObject.getString(LxAdDLManager.ITEM_DESC));
            u84Var.r(jSONObject.getString("linkUrl"));
            u84Var.p(jSONObject.getString("linkUrl"));
            u84Var.o(jSONObject.getString(LxAdDLManager.ITEM_ICONURL));
            u84Var.v(jSONObject.optString("authorIcon"));
            u84Var.w(jSONObject.optString("authorName"));
            u84Var.f(bVar.c);
            u84Var.g(bVar.b);
            new OpenShare.a().f(bVar.f21948a).g(activity).h(iB).j(u84Var).e().share();
            return "";
        } catch (JSONException e) {
            ma3.c(e);
            return "Data format error!";
        }
    }

    public static String d(ka3.b bVar, String str, Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iB = b(jSONObject);
            JSONArray jSONArray = jSONObject.getJSONArray("imgUrls");
            q84[] q84VarArr = new q84[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                q84 q84Var = new q84(jSONArray.getString(i));
                q84VarArr[i] = q84Var;
                q84Var.f(bVar.c);
                q84VarArr[i].g(bVar.b);
                q84VarArr[i].d(jSONObject.optString("authorIcon"));
                q84VarArr[i].e(jSONObject.optString("authorName"));
            }
            new OpenShare.a().g(activity).f(bVar.f21948a).h(iB).n(q84VarArr).e().share();
            return null;
        } catch (JSONException e) {
            ma3.c(e);
            return "Data format error!";
        }
    }

    public static String e(ka3.b bVar, String str, Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iB = b(jSONObject);
            s84 s84Var = new s84();
            s84Var.q(jSONObject.getString("subject"));
            s84Var.n(jSONObject.getString(LxAdDLManager.ITEM_DESC));
            String string = jSONObject.getString("linkUrl");
            s84Var.r(string);
            boolean zOptBoolean = jSONObject.optBoolean("fresh", false);
            s84Var.p(Uri.parse("zenxin://webapp").buildUpon().appendQueryParameter("url", string).appendQueryParameter("appId", bVar.f21948a).appendQueryParameter("scene", "share" + iB).appendQueryParameter("fresh", zOptBoolean + "").toString());
            s84Var.o(jSONObject.getString(LxAdDLManager.ITEM_ICONURL));
            s84Var.f(bVar.c);
            s84Var.g(bVar.b);
            s84Var.d(jSONObject.optString("authorIcon"));
            s84Var.e(jSONObject.optString("authorName"));
            new OpenShare.a().f(bVar.f21948a).g(activity).h(iB).i(s84Var).e().share();
            return null;
        } catch (JSONException e) {
            ma3.c(e);
            return "Data format error!";
        }
    }

    public static String f(ka3.b bVar, String str, Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iB = b(jSONObject);
            v84 v84Var = new v84();
            v84Var.p(jSONObject.optString("authorIcon"));
            v84Var.q(jSONObject.optString("authorName"));
            v84Var.r(jSONObject.getString("cover"));
            v84Var.t(jSONObject.getString("subject"));
            String string = jSONObject.getString("linkUrl");
            v84Var.u(string);
            v84Var.s(Uri.parse("zenxin://webapp").buildUpon().appendQueryParameter("url", string).appendQueryParameter("appId", bVar.f21948a).appendQueryParameter("scene", "share" + iB).toString());
            v84Var.f(bVar.c);
            v84Var.g(bVar.b);
            v84Var.d(jSONObject.optString("authorIcon"));
            v84Var.e(jSONObject.optString("authorName"));
            v84Var.v(jSONObject.getString("videoUrl"));
            new OpenShare.a().g(activity).f(bVar.f21948a).h(iB).k(v84Var).e().share();
            return null;
        } catch (JSONException e) {
            ma3.c(e);
            return "Data format error!";
        }
    }

    public static String g(ka3.b bVar, String str, Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iB = b(jSONObject);
            b94 b94Var = new b94();
            b94Var.r(jSONObject.getString("linkUrl"));
            b94Var.q(jSONObject.getString("subject"));
            b94Var.n(jSONObject.getString(LxAdDLManager.ITEM_DESC));
            b94Var.o(jSONObject.getString(LxAdDLManager.ITEM_ICONURL));
            b94Var.f(bVar.c);
            b94Var.g(bVar.b);
            b94Var.d(jSONObject.optString("authorIcon"));
            b94Var.e(jSONObject.optString("authorName"));
            new OpenShare.a().g(activity).f(bVar.f21948a).h(iB).m(b94Var).e().share();
            return null;
        } catch (JSONException e) {
            ma3.c(e);
            return "Data format error!";
        }
    }

    public static String h(ka3.b bVar, String str, Activity activity, wn6 wn6Var) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iB = b(jSONObject);
            u84 u84Var = new u84();
            boolean zOptBoolean = jSONObject.optBoolean("fresh", false);
            u84Var.q(jSONObject.getString("subject"));
            u84Var.n(jSONObject.getString(LxAdDLManager.ITEM_DESC));
            u84Var.r(jSONObject.getString("linkUrl"));
            String strEncodeToString = wn6Var != null ? Base64.encodeToString(wn6Var.toString().getBytes(), 0) : "";
            u84Var.p(Uri.parse("zenxin://webapp").buildUpon().appendQueryParameter("url", jSONObject.getString("linkUrl")).appendQueryParameter("appId", bVar.f21948a).appendQueryParameter("scene", "share" + iB).appendQueryParameter("windowStyle", strEncodeToString).appendQueryParameter("fresh", zOptBoolean + "").toString());
            u84Var.o(jSONObject.getString(LxAdDLManager.ITEM_ICONURL));
            u84Var.v(jSONObject.optString("authorIcon"));
            u84Var.w(jSONObject.optString("authorName"));
            u84Var.f(bVar.c);
            u84Var.g(bVar.b);
            new OpenShare.a().f(bVar.f21948a).g(activity).h(iB).j(u84Var).e().share();
            return "";
        } catch (JSONException e) {
            ma3.c(e);
            return "Data format error!";
        }
    }
}
