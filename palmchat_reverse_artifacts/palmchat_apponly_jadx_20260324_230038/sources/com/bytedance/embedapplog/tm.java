package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.umeng.analytics.pro.bt;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class tm extends w {
    private final mh iz;
    private final Context pn;

    public tm(Context context, mh mhVar) {
        super(true, false);
        this.pn = context;
        this.iz = mhVar;
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.pn.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                yd.u(jSONObject, bt.P, telephonyManager.getNetworkOperatorName());
                yd.u(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                yd.u(jSONObject, "udid", this.iz.oa() ? zq.u(telephonyManager) : this.iz.bc());
                return true;
            } catch (Exception e) {
                ti.nr(e);
            }
        }
        return false;
    }
}
