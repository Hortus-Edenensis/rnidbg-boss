package com.bytedance.sdk.openadsdk.core.ugeno.component.gif;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.b;
import com.bytedance.adsdk.ugeno.nr.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends fx<UgenGif> {
    protected ImageView.ScaleType ki;
    protected String u;

    public u(Context context) {
        super(context);
        this.ki = ImageView.ScaleType.FIT_CENTER;
    }

    private void n() {
        if (TextUtils.isEmpty(this.u)) {
            return;
        }
        if (!this.u.startsWith("local://")) {
            b.u().nr().u(this.f5034a, this.u, (ImageView) this.pn, null);
        } else {
            ((UgenGif) this.pn).u(com.bytedance.adsdk.ugeno.iz.b.nr(this.nr, this.u.replace("local://", "")), false);
        }
    }

    private ImageView.ScaleType t(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        n();
        ((UgenGif) this.pn).setScaleType(this.ki);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx, com.bytedance.adsdk.ugeno.fx
    public void pn() {
        super.pn();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UgenGif u() {
        UgenGif ugenGif = new UgenGif(this.nr);
        this.pn = ugenGif;
        ugenGif.u(this);
        return (UgenGif) this.pn;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("scaleType")) {
            this.ki = t(str2);
        } else if (str.equals("src")) {
            this.u = str2;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx, com.bytedance.adsdk.ugeno.fx
    public void u(boolean z) {
        super.u(z);
        if (z) {
            nr();
        }
    }
}
