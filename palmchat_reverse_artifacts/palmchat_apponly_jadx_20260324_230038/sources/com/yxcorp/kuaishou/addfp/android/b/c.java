package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import com.qq.gdt.action.ActionUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f11810a;
    int b;
    boolean c;
    String d;

    public c(String str) {
        this.f11810a = true;
        if (TextUtils.isEmpty(str)) {
            this.f11810a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optInt("errorCode", 2);
            this.c = jSONObject.optBoolean("userSet", true);
            this.d = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT, "KWE_OTHER");
        } catch (JSONException e) {
            this.f11810a = false;
            e.printStackTrace();
        }
    }

    public String a(boolean z) {
        if (!this.f11810a) {
            return "KWE_OTHER";
        }
        if (z != this.c) {
            return "KWE_NPN";
        }
        int i = this.b;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.d) ? this.d : "KWE_N";
    }
}
