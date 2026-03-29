package defpackage;

import android.text.TextUtils;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ka3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, b> f18607a = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends xg {
        public b(String str, String str2, String str3, List<String> list) {
            super(str, str2, str3, list);
        }
    }

    public b b(String str) {
        return this.f18607a.get(c(str));
    }

    public final String c(String str) {
        String host;
        if (TextUtils.isEmpty(str)) {
            host = null;
        } else {
            try {
                host = new URI(str).getHost();
            } catch (URISyntaxException e) {
                ma3.c(e);
                host = null;
            }
        }
        return TextUtils.isEmpty(host) ? str : host;
    }

    public void d(String str, String str2, e84 e84Var) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        new wg(new a(str, e84Var)).executeOnExecutor(ax2.a(), str2, str);
    }

    public boolean e(String str, String str2) {
        ma3.a("url:" + str + " apiName:" + str2, new Object[0]);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.f18607a.isEmpty()) {
                ma3.a("mGrantCache is empty!", new Object[0]);
                return false;
            }
            String strC = c(str);
            if (!TextUtils.isEmpty(strC) && this.f18607a.containsKey(strC)) {
                for (String str3 : this.f18607a.get(strC).e) {
                    ma3.a("api:" + str3 + " apiName:" + str2, new Object[0]);
                    if (str3.equals(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void f(String str, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("grantApi");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    ma3.a("grantApi " + jSONArrayOptJSONArray.getString(i), new Object[0]);
                    arrayList.add(jSONArrayOptJSONArray.getString(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        String strC = c(str);
        String strOptString = jSONObject.optString("appId");
        String strOptString2 = jSONObject.optString(WfConstant.EVENT_KEY_APP_NAME);
        String strOptString3 = jSONObject.optString("icon");
        int iOptInt = jSONObject.optInt("appType");
        b bVar = new b(strOptString, strOptString2, strOptString3, arrayList);
        bVar.d = iOptInt;
        this.f18607a.put(strC, bVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements pt5<qt5> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18608a;
        public final /* synthetic */ e84 b;

        public a(String str, e84 e84Var) {
            this.f18608a = str;
            this.b = e84Var;
        }

        @Override // defpackage.pt5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(qt5 qt5Var) {
            if (qt5Var.f20322a == 1) {
                ka3.this.f(this.f18608a, qt5Var.c.optJSONObject("data"));
            }
            this.b.onCallback(qt5Var.f20322a, qt5Var.b, qt5Var.c);
        }

        @Override // defpackage.pt5
        public void onPreExecute(String str) {
        }
    }
}
