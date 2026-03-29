package defpackage;

import android.content.Context;
import cn.jiguang.api.ReportCallBack;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ew4 extends xw2 implements ReportCallBack {
    public ew4() {
        this.f22065a = "ReportCrashLogDirect";
    }

    @Override // defpackage.xw2
    public void a() {
        try {
            Context contextA = tv2.a(null);
            if (contextA == null) {
                k63.l("ReportCrashLogDirect", "ReportDirect context is null");
                return;
            }
            JSONObject jSONObjectB = b(contextA);
            if (jSONObjectB != null) {
                nw4.v(contextA, jSONObjectB, this);
            }
        } catch (Throwable th) {
            k63.c("ReportCrashLogDirect", "run report crash e:" + th);
        }
    }

    public final JSONObject b(Context context) {
        JSONArray jSONArrayF = tw2.f(context);
        if (jSONArrayF == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashlogs", jSONArrayF);
            jSONObject.put("network_type", ad.k(context));
            fv2.b(context, jSONObject, "crash_log");
            Object objG = xv2.g(context);
            JSONObject jSONObject2 = objG instanceof JSONObject ? (JSONObject) objG : null;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                jSONObject.put("device_info", jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i) {
        k63.l("ReportCrashLogDirect", "ReportDirect finish : " + i);
        if (i == 0) {
            tw2.b(tv2.a(null));
        }
    }
}
