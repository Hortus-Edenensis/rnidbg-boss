package defpackage;

import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class mw2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19378a;
    public String b;
    public String c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = "";
            jSONObject.put(WkParams.IMEI, TextUtils.isEmpty(this.f19378a) ? "" : this.f19378a);
            jSONObject.put("iccid", TextUtils.isEmpty(this.c) ? "" : this.c);
            if (!TextUtils.isEmpty(this.b)) {
                str = this.b;
            }
            jSONObject.put("imsi", str);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean b() {
        return TextUtils.isEmpty(this.f19378a) && TextUtils.isEmpty(this.b);
    }

    public String toString() {
        return "JDeviceSimInfo{imei='" + this.f19378a + "', imsi='" + this.b + "', iccid='" + this.c + "'}";
    }
}
