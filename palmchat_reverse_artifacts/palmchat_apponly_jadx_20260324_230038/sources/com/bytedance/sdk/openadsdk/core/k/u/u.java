package com.bytedance.sdk.openadsdk.core.k.u;

import com.qq.gdt.action.ActionUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    public boolean b() {
        int iU = u();
        if (iU == 0 || nr() || fx()) {
            return false;
        }
        return u(iU);
    }

    public abstract boolean fx();

    public abstract JSONObject iz();

    public abstract void nr(int i);

    public abstract boolean nr();

    public void pn() {
        int iU = u();
        if (iU == 0 || nr() || fx()) {
            return;
        }
        nr(iU);
    }

    public int u() {
        JSONObject jSONObjectIz = iz();
        if (jSONObjectIz == null) {
            return 0;
        }
        double dOptDouble = jSONObjectIz.optDouble(ActionUtils.PAYMENT_AMOUNT, 0.0d);
        int iOptInt = jSONObjectIz.optInt("plan");
        return iOptInt == 1 ? dOptDouble == 0.0d ? 0 : 1 : iOptInt;
    }

    public abstract boolean u(int i);

    public static double u(double d, JSONObject jSONObject) {
        double dOptDouble = jSONObject.optDouble("min_value", -1.0d);
        double dOptDouble2 = jSONObject.optDouble("max_value", 1.0d);
        return d > dOptDouble2 ? dOptDouble2 : d < dOptDouble ? dOptDouble : d;
    }
}
