package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rt2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn2 f20566a;

    public final zn2 a(Activity activity, int i, int i2) {
        if (i2 > 0) {
            if (i2 == 1) {
                return new l9(activity);
            }
            if (i2 == 2) {
                return new kk6();
            }
            return null;
        }
        if (i == 7) {
            return new l9(activity);
        }
        if (i != 8) {
            return null;
        }
        return new kk6();
    }

    public void b(JSONObject jSONObject, za3 za3Var, Activity activity) {
        String strOptString;
        c();
        int iOptInt = jSONObject.optInt("payType");
        int iOptInt2 = jSONObject.optInt("osSdk");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("orderInfo");
        if (jSONObjectOptJSONObject != null) {
            try {
                strOptString = jSONObjectOptJSONObject.optJSONObject("extend").optString("orderString");
            } catch (Exception e) {
                e.printStackTrace();
                strOptString = null;
            }
        } else {
            strOptString = null;
        }
        zn2 zn2VarA = a(activity, iOptInt, iOptInt2);
        this.f20566a = zn2VarA;
        if (zn2VarA == null || TextUtils.isEmpty(strOptString)) {
            za3Var.onPayBack(-4, this.f20566a == null ? "支付失败" : "订单不能为空", null);
        } else {
            this.f20566a.a(strOptString, za3Var);
        }
    }

    public void c() {
        zn2 zn2Var = this.f20566a;
        if (zn2Var != null) {
            zn2Var.release();
        }
        this.f20566a = null;
    }
}
