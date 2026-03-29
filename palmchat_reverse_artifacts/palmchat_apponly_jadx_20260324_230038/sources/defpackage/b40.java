package defpackage;

import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1643a = nl0.z + "/userem.info";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yw4 f1644a;

        public a(yw4 yw4Var) {
            this.f1644a = yw4Var;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LogUtil.i("ChatProfileDao", "onFail");
            yw4 yw4Var = this.f1644a;
            if (yw4Var != null) {
                yw4Var.onFail(exc);
            }
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i("ChatProfileDao", "onSuccess" + jSONObject);
            yw4 yw4Var = this.f1644a;
            if (yw4Var != null) {
                yw4Var.onSuccess(jSONObject, yy2Var);
            }
        }
    }

    public static void a(String str, yw4 yw4Var) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fuid", str);
            jSONObject.put("reqId", xn3.a());
            LocationEx locationExI = d.g().i(86400000L);
            if (locationExI != null) {
                jSONObject.put("longitude", locationExI.getLongitude());
                jSONObject.put("latitude", locationExI.getLatitude());
                jSONObject.put("cityCode", locationExI.getCityCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        zw4.f(f1643a, 1, jSONObject, new a(yw4Var));
    }
}
