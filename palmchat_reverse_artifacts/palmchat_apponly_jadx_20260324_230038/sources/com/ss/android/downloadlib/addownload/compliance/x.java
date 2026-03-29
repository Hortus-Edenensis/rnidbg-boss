package com.ss.android.downloadlib.addownload.compliance;

import com.baidu.mapapi.SDKInitializer;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class x {
    public static void nr(String str, long j) {
        u(str, null, j);
    }

    public static void u(String str, long j) {
        com.ss.android.downloadlib.addownload.nr.pn pnVarPn = com.ss.android.downloadlib.addownload.nr.iz.u().pn(j);
        if (pnVarPn.qq()) {
            return;
        }
        pnVarPn.fx.setRefer(str);
        com.ss.android.downloadlib.b.u.u().nr("lp_app_dialog_click", pnVarPn);
    }

    public static void u(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadlib.b.u.u().nr(str, jSONObject, com.ss.android.downloadlib.addownload.nr.iz.u().pn(j));
    }

    public static void u(String str, com.ss.android.downloadlib.addownload.nr.pn pnVar) {
        com.ss.android.downloadlib.b.u.u().nr(str, pnVar);
    }

    public static void u(int i, com.ss.android.downloadlib.addownload.nr.pn pnVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
        } catch (Exception unused) {
        }
        com.ss.android.downloadlib.b.u.u().nr("lp_compliance_error", jSONObject, pnVar);
    }

    public static void u(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
        } catch (Exception unused) {
        }
        com.ss.android.downloadlib.b.u.u().nr("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.nr.iz.u().pn(j));
    }
}
