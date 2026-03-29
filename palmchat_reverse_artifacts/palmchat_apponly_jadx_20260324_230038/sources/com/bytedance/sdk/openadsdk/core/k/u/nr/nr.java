package com.bytedance.sdk.openadsdk.core.k.u.nr;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.k.u.fx;
import com.qq.gdt.action.ActionUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends com.bytedance.sdk.openadsdk.core.k.u.u {
    private String fx;
    private double nr;
    private final String b = "xgc_prop_volume";
    private volatile int pn = -2;
    private u u = new u(dw.getContext());

    public int a() {
        int iN = n();
        int iNr = this.u.nr() - this.u.u();
        if (iNr != 0) {
            return Math.round((iN * 100.0f) / iNr);
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.k.u.u
    public boolean fx() {
        int iA = a();
        return iA >= 94 || iA <= 6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.k.u.u
    public JSONObject iz() {
        return dw.nr().sf();
    }

    public int n() {
        return (int) fx.u().iz();
    }

    public void nr(double d) {
        int iNr = this.u.nr();
        int iU = this.u.u();
        int i = (int) d;
        if (d < iNr) {
            iNr = d <= ((double) iU) ? iU : i;
        }
        this.pn = iNr;
        this.u.u(iNr);
    }

    public void u(double d) {
        this.nr = d;
    }

    public int x() {
        return this.pn;
    }

    public void u(String str) {
        this.fx = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019 A[PHI: r7
      0x0019: PHI (r7v2 double) = (r7v0 double), (r7v1 double) binds: [B:8:0x0017, B:11:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bytedance.sdk.openadsdk.core.k.u.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean u(int i) {
        double dU;
        JSONObject jSONObjectIz = iz();
        if (jSONObjectIz == null) {
            return false;
        }
        if (i != 1) {
            if (i == 2) {
                dU = u(jSONObjectIz);
            }
            return false;
        }
        dU = jSONObjectIz.optDouble(ActionUtils.PAYMENT_AMOUNT, 0.0d);
        double d = -1.0d;
        if (dU <= -1.0d) {
            dU = d;
        } else {
            d = 1.0d;
            if (dU >= 1.0d) {
            }
        }
        return false;
        if (dU != 0.0d && dU != -2.0d) {
            nr(((double) n()) + (((double) (this.u.nr() - this.u.u())) * dU));
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.k.u.u
    public void nr(int i) {
        float fIz = fx.u().iz();
        if (fIz != -2.0f) {
            int iNr = this.u.nr();
            int iU = this.u.u();
            int i2 = (int) fIz;
            if (fIz < iNr) {
                iNr = fIz <= ((float) iU) ? iU : i2;
            }
            this.pn = iNr;
            this.u.u(iNr);
        }
    }

    private double u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -2.0d;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("applist");
        return com.bytedance.sdk.openadsdk.core.k.u.u.u(((((double) (jSONArrayOptJSONArray != null && !TextUtils.isEmpty(this.fx) && jSONArrayOptJSONArray.toString().contains(this.fx) ? 1 : -1)) * jSONObject.optDouble("content_factor", 0.0d)) + (((double) (this.nr >= 10.0d ? 1 : -1)) * jSONObject.optDouble("duration_factor", 0.0d)) + (((double) (com.bytedance.sdk.openadsdk.core.k.u.nr.nr() ? 1 : -1)) * jSONObject.optDouble("night_factor", 0.0d)) + (jSONObject.optDouble("week_factor", 0.0d) * ((double) (com.bytedance.sdk.openadsdk.core.k.u.nr.u() ? 1 : -1))) + (((double) (this.u.b() ? 1 : -1)) * jSONObject.optDouble("headset_factor", 0.0d))) * jSONObject.optDouble("factor", 0.0d), jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.k.u.u
    public boolean nr() {
        return fx.u().b();
    }
}
