package com.bytedance.adsdk.nr;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n implements a {
    @Override // com.bytedance.adsdk.nr.a
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public Boolean u(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return Boolean.FALSE;
        }
        try {
            Double.parseDouble(String.valueOf(objArr[0]));
            return Boolean.TRUE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }
}
