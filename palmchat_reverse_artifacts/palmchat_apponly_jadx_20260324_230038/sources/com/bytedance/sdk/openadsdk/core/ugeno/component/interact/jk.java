package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk extends com.bytedance.adsdk.ugeno.widget.frame.u {
    private final float[] hs;
    private String ki;

    public jk(Context context) {
        super(context);
        this.hs = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    private void t(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.length() <= 2 || (strArrSplit = strTrim.substring(1, strTrim.length() - 1).split(",")) == null || strArrSplit.length != 4) {
            return;
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            String str2 = strArrSplit[i];
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.hs[i] = Float.parseFloat(com.bytedance.sdk.openadsdk.upie.u.u.u(str2.trim(), this.b));
                } catch (NumberFormatException unused) {
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.frame.u, com.bytedance.adsdk.ugeno.nr.u, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        t(this.ki);
        super.nr();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.equals(str, "clickableInteract")) {
            this.ki = str2;
        } else {
            super.u(str, str2);
        }
    }

    public float[] v() {
        return this.hs;
    }
}
