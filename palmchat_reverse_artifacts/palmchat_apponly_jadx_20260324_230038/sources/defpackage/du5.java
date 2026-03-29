package defpackage;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class du5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17140a;
    public int b;
    public String c;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.c;
            if (str != null) {
                jSONObject.put("networkName", str);
            }
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, this.f17140a);
            jSONObject.put("networkType", this.b);
        } catch (JSONException e) {
            v.d(e.getMessage());
        }
        return jSONObject.toString();
    }
}
