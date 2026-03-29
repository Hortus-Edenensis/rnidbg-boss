package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.nr.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends fx<UGProgressBar> {
    private float gb;
    private String hs;
    private int ki;
    private int te;
    private float ti;
    private int u;

    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        ((UGProgressBar) this.pn).setBackgroundColor(this.ki);
        ((UGProgressBar) this.pn).setText(this.hs);
        ((UGProgressBar) this.pn).setProgressBgColor(this.ki);
        ((UGProgressBar) this.pn).setProgressColor(this.u);
        ((UGProgressBar) this.pn).setTextColor(this.te);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UGProgressBar u() {
        UGProgressBar uGProgressBar = new UGProgressBar(this.nr);
        uGProgressBar.u(this);
        return uGProgressBar;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "progressBgColor":
                this.ki = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
            case "textColor":
                this.te = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
            case "textSize":
                this.ti = n.u(this.nr, str2);
                break;
            case "progress":
                this.gb = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case "text":
                this.hs = str2;
                break;
            case "progressColor":
                this.u = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
        }
    }
}
