package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.nr.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends fx<UGRatingBar> {
    private static final int gb = Color.parseColor("#FFC642");
    private static final int gl = Color.parseColor("#e3e3e4");
    private float hs;
    private int ki;
    private float te;
    private float ti;
    private int u;

    public u(Context context) {
        super(context);
        this.u = gb;
        this.ki = gl;
        this.hs = 4.0f;
        this.te = 20.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        if (h()) {
            ((UGRatingBar) this.pn).u(this.hs, this.u, this.ki, this.te, (int) this.ti);
        } else {
            ((UGRatingBar) this.pn).u(this.hs, this.u, this.ki, this.te, 5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UGRatingBar u() {
        UGRatingBar uGRatingBar = new UGRatingBar(this.nr);
        uGRatingBar.u(this);
        return uGRatingBar;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.u = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.ki = com.bytedance.adsdk.ugeno.iz.u.u(str2, gl);
                break;
            case "gap":
                this.ti = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case "size":
                this.te = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 20.0f);
                break;
            case "score":
                this.hs = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 4.0f);
                break;
        }
    }
}
