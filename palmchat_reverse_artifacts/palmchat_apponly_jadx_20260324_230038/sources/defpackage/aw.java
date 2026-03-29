package defpackage;

import android.net.Uri;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1582a;
    public long b;
    public long c;
    public boolean d;
    public boolean e;

    public static aw a(String str) {
        aw awVarD = d();
        awVarD.f1582a = str;
        return awVarD;
    }

    public static aw b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            jSONObject2.remove("pageKey");
            jSONObject2.remove("reqId");
            jSONObject2.remove("longitude");
            jSONObject2.remove("latitude");
            jSONObject2.remove("localCityCode");
            jSONObject2.remove("cityCode");
            double dOptDouble = jSONObject2.optDouble("longitude", 0.0d);
            if (dOptDouble != 0.0d) {
                jSONObject2.put("longitude", k86.g(dOptDouble, 3));
            }
            double dOptDouble2 = jSONObject2.optDouble("latitude", 0.0d);
            if (dOptDouble2 != 0.0d) {
                jSONObject2.put("latitude", k86.g(dOptDouble2, 3));
            }
            aw awVarD = d();
            awVarD.f1582a = jSONObject2.toString();
            return awVarD;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static aw d() {
        aw awVar = new aw();
        awVar.b = 0L;
        awVar.c = 2147483647L;
        awVar.d = true;
        awVar.e = true;
        return awVar;
    }

    public String c(String str) {
        String queryParameter;
        try {
            Uri uri = Uri.parse(str);
            str = uri.getPath();
            queryParameter = uri.getQueryParameter(DeviceInfoUtil.UID_TAG);
        } catch (Exception e) {
            e.printStackTrace();
            queryParameter = "";
        }
        String str2 = queryParameter + "key_" + str + "_" + this.f1582a;
        LogUtil.i("NetCache", "getCacheKey key=" + str2);
        return str2;
    }

    public boolean e(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("resultCode", -1) == 0;
    }
}
