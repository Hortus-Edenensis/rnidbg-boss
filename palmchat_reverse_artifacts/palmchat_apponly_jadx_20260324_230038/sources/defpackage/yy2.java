package defpackage;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yy2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22300a = false;
    public int b = -1;
    public String c;
    public JSONObject d;

    public static String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
    }

    public static yy2 b(JSONObject jSONObject) {
        yy2 yy2Var = new yy2();
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("resultCode");
            yy2Var.b = iOptInt;
            yy2Var.f22300a = iOptInt == 0;
            yy2Var.c = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            yy2Var.d = jSONObject.optJSONObject("data");
        }
        return yy2Var;
    }

    public String toString() {
        return "JsonResponse{isSuccess=" + this.f22300a + ", resultCode=" + this.b + ", errorMsg='" + this.c + "', data=" + this.d + '}';
    }
}
