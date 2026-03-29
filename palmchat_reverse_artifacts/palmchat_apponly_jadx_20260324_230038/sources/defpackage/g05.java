package defpackage;

import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class g05 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17629a = nl0.b + "/feed/v1/robot/srobot/background";

    public static void a(yw4 yw4Var) {
        LogUtil.d("SRobotForgroundDao", "postAppForBackgroud");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("verCode", ac1.f);
            jSONObject.put("verName", ac1.g);
            jSONObject.put("dhid", ac1.h);
            jSONObject.put(WkParams.IMEI, ac1.i);
            jSONObject.put("androidId", ac1.p);
            jSONObject.put("chanId", ac1.m);
            zw4.f(f17629a, 1, jSONObject, yw4Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
