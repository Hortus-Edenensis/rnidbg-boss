package defpackage;

import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class le5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18965a;
    public String b;
    public String c;
    public long d;
    public String e;
    public double f;
    public double g;
    public long h;
    public int i = 0;
    public int j = 0;

    public le5(int i, String str, String str2, long j, String str3, double d, double d2, long j2) {
        this.f18965a = i;
        this.b = str;
        this.c = str2;
        this.d = j;
        this.e = str3;
        this.f = d;
        this.g = d2;
        this.h = j2;
    }

    public static boolean a(double d, double d2) {
        return d > -90.0d && d < 90.0d && d2 > -180.0d && d2 < 180.0d;
    }

    public JSONObject b(Set<String> set) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f18965a);
            jSONObject.put("appkey", this.b);
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, this.c);
            jSONObject.put("platform", 0);
            long j = this.d;
            if (j != 0) {
                jSONObject.put(DeviceInfoUtil.UID_TAG, j);
            }
            String str = this.e;
            if (str != null) {
                jSONObject.put("opera", str);
            }
            if (a(this.f, this.g)) {
                jSONObject.put(f.C, this.f);
                jSONObject.put(f.D, this.g);
                jSONObject.put("time", this.h);
            }
            if (set != null && !set.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("fail_ips", jSONArray);
            }
            int i = this.i;
            if (i != 0) {
                jSONObject.put("ips_flag", i);
            }
            int i2 = this.j;
            if (i2 != 0) {
                jSONObject.put("report_flag", i2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
