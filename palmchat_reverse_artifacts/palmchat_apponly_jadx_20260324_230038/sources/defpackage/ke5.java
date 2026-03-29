package defpackage;

import android.text.TextUtils;
import cn.jiguang.sdk.impl.connect.IpPort;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ke5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18673a;
    public int b;
    public IpPort c;
    public long d;
    public long e;
    public long f;
    public int g;
    public double h;
    public double i;
    public long j;
    public int k;

    public static boolean a(double d, double d2) {
        return d > -90.0d && d < 90.0d && d2 > -180.0d && d2 < 180.0d;
    }

    public static ke5 b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                ke5 ke5Var = new ke5();
                ke5Var.f18673a = jSONObject.optString("appkey");
                ke5Var.b = jSONObject.getInt("type");
                ke5Var.c = IpPort.fromString(jSONObject.getString("addr"));
                ke5Var.e = jSONObject.getLong("rtime");
                ke5Var.f = jSONObject.getLong("interval");
                ke5Var.g = jSONObject.getInt(TKDownloadReason.KSAD_TK_NET);
                ke5Var.k = jSONObject.getInt("code");
                ke5Var.d = jSONObject.optLong(DeviceInfoUtil.UID_TAG);
                ke5Var.h = jSONObject.optDouble(f.C);
                ke5Var.i = jSONObject.optDouble(f.D);
                ke5Var.j = jSONObject.optLong("ltime");
                return ke5Var;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static LinkedList<ke5> c(String str) {
        LinkedList<ke5> linkedList = new LinkedList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(b(jSONArray.getJSONObject(i)));
                }
            } catch (JSONException unused) {
            }
        }
        return linkedList;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f18673a)) {
                jSONObject.put("appkey", this.f18673a);
            }
            jSONObject.put("type", this.b);
            jSONObject.put("addr", this.c.toString());
            jSONObject.put("rtime", this.e);
            jSONObject.put("interval", this.f);
            jSONObject.put(TKDownloadReason.KSAD_TK_NET, this.g);
            jSONObject.put("code", this.k);
            long j = this.d;
            if (j != 0) {
                jSONObject.put(DeviceInfoUtil.UID_TAG, j);
            }
            if (a(this.h, this.i)) {
                jSONObject.put(f.C, this.h);
                jSONObject.put(f.D, this.i);
                jSONObject.put("ltime", this.j);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
