package com.bytedance.adsdk.nr;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn implements a {
    @Override // com.bytedance.adsdk.nr.a
    public Object u(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                String strValueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(strValueOf) && !TextUtils.equals(strValueOf, com.igexin.push.core.b.m)) {
                    return strValueOf;
                }
            }
        }
        return null;
    }
}
