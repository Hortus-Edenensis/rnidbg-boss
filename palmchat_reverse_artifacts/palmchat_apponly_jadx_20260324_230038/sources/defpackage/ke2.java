package defpackage;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ke2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18672a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public int g;

    public static ke2 a(JSONObject jSONObject) {
        ke2 ke2Var = new ke2();
        ke2Var.f18672a = jSONObject.optInt("resultCode");
        ke2Var.f = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject != null) {
            ke2Var.b = jSONObjectOptJSONObject.optString("roomIcon");
            ke2Var.c = jSONObjectOptJSONObject.optString("roomName");
            ke2Var.e = jSONObjectOptJSONObject.optString("defaultRoomName");
            ke2Var.d = jSONObjectOptJSONObject.optInt("memberNum");
            ke2Var.g = jSONObjectOptJSONObject.optInt("inRoom");
        }
        return ke2Var;
    }
}
