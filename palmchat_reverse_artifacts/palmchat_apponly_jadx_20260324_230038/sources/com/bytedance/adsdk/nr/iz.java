package com.bytedance.adsdk.nr;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz implements a {
    @Override // com.bytedance.adsdk.nr.a
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public String u(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length < 2) {
            return null;
        }
        String strValueOf = String.valueOf(objArr[0]);
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(strValueOf);
            String strValueOf2 = String.valueOf(objArr[1]);
            if (TextUtils.isEmpty(strValueOf2)) {
                return null;
            }
            Object objU = com.bytedance.adsdk.nr.nr.u.u(strValueOf2).u(jSONObject2);
            if (!TextUtils.isEmpty(String.valueOf(objU))) {
                return String.valueOf(objU);
            }
            if (objArr.length >= 3) {
                return String.valueOf(objArr[2]);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }
}
