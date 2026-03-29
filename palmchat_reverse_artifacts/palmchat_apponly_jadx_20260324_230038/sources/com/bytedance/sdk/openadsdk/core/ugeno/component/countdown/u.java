package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.adsdk.ugeno.widget.text.nr {
    protected String hs;
    private String te;
    private String ti;

    public u(Context context) {
        super(context);
    }

    public void l(String str) {
        ((UGTextView) this.pn).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.pn).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                b((int) fMeasureText);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.nr, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        if (TextUtils.isEmpty(this.ti) || TextUtils.equals(this.ti, com.igexin.push.core.b.m)) {
            this.ti = "";
        }
        if (TextUtils.isEmpty(this.te) || TextUtils.equals(this.te, com.igexin.push.core.b.m)) {
            this.te = "";
        }
        String str = this.te + this.ti;
        ((com.bytedance.adsdk.ugeno.widget.text.nr) this).u = str;
        l(str);
        ((UGTextView) this.pn).setGravity(17);
    }

    public void u(int i, int i2, int i3) {
        if (i <= 0 && !TextUtils.isEmpty(this.hs)) {
            String str = this.hs;
            ((com.bytedance.adsdk.ugeno.widget.text.nr) this).u = str;
            l(str);
            return;
        }
        if (TextUtils.isEmpty(this.ti) || TextUtils.equals(this.ti, com.igexin.push.core.b.m)) {
            this.ti = "";
        }
        if (TextUtils.isEmpty(this.te) || TextUtils.equals(this.te, com.igexin.push.core.b.m)) {
            this.te = "";
        }
        String str2 = this.te + i + this.ti;
        ((com.bytedance.adsdk.ugeno.widget.text.nr) this).u = str2;
        l(str2);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.nr, com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "before":
                this.te = str2;
                break;
            case "finish":
                this.hs = str2;
                break;
            case "after":
                this.ti = str2;
                break;
        }
    }
}
