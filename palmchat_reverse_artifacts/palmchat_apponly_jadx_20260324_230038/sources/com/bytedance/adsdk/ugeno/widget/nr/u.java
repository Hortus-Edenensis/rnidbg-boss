package com.bytedance.adsdk.ugeno.widget.nr;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.adsdk.ugeno.widget.image.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u extends nr {
    private int ti;

    public u(Context context) {
        super(context);
        this.ti = -16777216;
    }

    private String mv(String str) {
        String strT = t(str);
        return TextUtils.isEmpty(strT) ? "" : "local://".concat(String.valueOf(strT));
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.nr, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        ((nr) this).u = mv(((nr) this).u);
        super.nr();
        ((RoundImageView) this.pn).setColorFilter(this.ti);
        ((RoundImageView) this.pn).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public abstract String t(String str);

    @Override // com.bytedance.adsdk.ugeno.widget.image.nr, com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        if (str.equals("textColor")) {
            this.ti = com.bytedance.adsdk.ugeno.iz.u.u(str2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.nr
    public String x() {
        return "drawable";
    }
}
