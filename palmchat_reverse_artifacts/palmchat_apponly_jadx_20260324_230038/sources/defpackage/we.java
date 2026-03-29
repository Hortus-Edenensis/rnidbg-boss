package defpackage;

import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class we {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, xg> f21681a = new HashMap();

    public void b(String str, String str2, e84 e84Var) {
        ah ahVarC = ah.c(str, "empty");
        f84.e(ahVarC, "display");
        JSONObject jSONObject = new JSONObject();
        String str3 = System.currentTimeMillis() + "";
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        String strB = ja5.b(strReplace + str3 + str2);
        try {
            jSONObject.put("thirdAppId", str);
            jSONObject.put("timestamp", str3);
            jSONObject.put("nonceStr", strReplace);
            jSONObject.put(com.umeng.ccg.a.A, strB);
        } catch (JSONException e) {
            ma3.c(e);
        }
        new wg(new a(ahVarC, e84Var)).executeOnExecutor(jo1.b(), jSONObject.toString(), "", TurnInfo.TYPE_NATIVE);
    }

    public xg c(String str) {
        return this.f21681a.get(str);
    }

    public final void d(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("grantApi");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    ma3.a("grantApi " + jSONArrayOptJSONArray.getString(i), new Object[0]);
                    arrayList.add(jSONArrayOptJSONArray.getString(i));
                } catch (JSONException e) {
                    ma3.c(e);
                }
            }
        }
        String strOptString = jSONObject.optString("appId");
        this.f21681a.put(strOptString, new xg(strOptString, jSONObject.optString(WfConstant.EVENT_KEY_APP_NAME), jSONObject.optString("icon"), arrayList));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements pt5<qt5> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ah f21682a;
        public final /* synthetic */ e84 b;

        public a(ah ahVar, e84 e84Var) {
            this.f21682a = ahVar;
            this.b = e84Var;
        }

        @Override // defpackage.pt5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(qt5 qt5Var) {
            if (qt5Var.f20322a == 1) {
                we.this.d(qt5Var.c.optJSONObject("data"));
                qt5Var.c.optJSONObject("data").remove("grantApi");
                f84.e(this.f21682a, "confSuc");
            } else {
                f84.e(this.f21682a, "confFail");
            }
            this.b.onCallback(qt5Var.f20322a, qt5Var.b, qt5Var.c);
        }

        @Override // defpackage.pt5
        public void onPreExecute(String str) {
        }
    }
}
