package defpackage;

import com.wifi.ad.core.config.EventParams;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ec1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17267a;
    public int e;
    public int b = 24;
    public int c = 1;
    public int d = 200;
    public int f = 1;

    public ec1(JSONObject jSONObject) {
        a(jSONObject);
    }

    public final void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
                String strB = dc1.b();
                if (jSONObject.has(strB) && (jSONObject2 = jSONObject.getJSONObject(strB)) != null) {
                    this.f17267a = jSONObject2.optString(EventParams.KEY_STRATEGY_ID);
                    this.b = jSONObject2.optInt("frequency_time");
                    this.c = jSONObject2.optInt("frequency_pv");
                    this.d = jSONObject2.optInt("radom_max");
                    this.e = jSONObject2.optInt("reddot_style");
                    this.f = jSONObject2.optInt("refresh_time");
                }
            } catch (Exception e) {
                ma3.e("NestPopTypeModel init failed.", e);
            }
        }
    }
}
