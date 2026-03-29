package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends u {
    private int gb;
    private String te;
    private String ti;

    public b(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.u
    public void u(int i, int i2, int i3) {
        if (i3 <= 0 && !TextUtils.isEmpty(((u) this).hs)) {
            String str = ((u) this).hs;
            ((com.bytedance.adsdk.ugeno.widget.text.nr) this).u = str;
            l(str);
            return;
        }
        int i4 = this.gb;
        int i5 = i4 - i2;
        if (i4 <= 0 || i5 <= 0) {
            ((com.bytedance.adsdk.ugeno.widget.text.nr) this).u = this.ti;
        } else {
            ((com.bytedance.adsdk.ugeno.widget.text.nr) this).u = this.te;
        }
        String strReplace = ((com.bytedance.adsdk.ugeno.widget.text.nr) this).u.replace("${_countdownTime_}", String.valueOf(i5)).replace("${_remainTime_}", String.valueOf(i3));
        ((com.bytedance.adsdk.ugeno.widget.text.nr) this).u = strReplace;
        l(strReplace);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.u, com.bytedance.adsdk.ugeno.widget.text.nr, com.bytedance.adsdk.ugeno.nr.fx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "text1":
                this.te = str2;
                break;
            case "text2":
                this.ti = str2;
                break;
            case "startCountDown":
                this.gb = com.bytedance.adsdk.ugeno.iz.fx.u(str2, -1);
                break;
        }
    }
}
