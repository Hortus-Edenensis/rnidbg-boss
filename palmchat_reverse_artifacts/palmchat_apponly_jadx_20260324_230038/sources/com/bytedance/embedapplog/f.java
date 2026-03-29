package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class f extends w {
    private final Context pn;

    public f(Context context) {
        super(true, false);
        this.pn = context;
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) throws JSONException {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        String strNr = null;
        try {
            packageInfo = this.pn.getPackageManager().getPackageInfo(this.pn.getPackageName(), 64);
        } catch (Throwable th) {
            ti.nr(th);
            packageInfo = null;
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
            strNr = dj.nr(signature.toByteArray());
        }
        if (strNr == null) {
            return true;
        }
        jSONObject.put("sig_hash", strNr);
        return true;
    }
}
