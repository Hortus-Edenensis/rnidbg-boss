package com.bytedance.sdk.openadsdk.core.ugeno.component.fx;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends fx<UpieImageView> {
    protected boolean ki;
    protected ImageView.ScaleType u;

    public u(Context context) {
        super(context);
        this.u = ImageView.ScaleType.FIT_XY;
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
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        bc bcVarU = com.bytedance.sdk.openadsdk.core.u.u(this.b);
        if (bcVarU != null) {
            ((UpieImageView) this.pn).u(com.bytedance.sdk.openadsdk.pn.u.u(bcVarU, this.b), com.bytedance.sdk.openadsdk.pn.u.jk(bcVarU));
            ((UpieImageView) this.pn).setScaleType(this.u);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UpieImageView u() {
        return new UpieImageView(this.nr, null, null);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.u = t(str2);
                break;
            case "isBgGaussianBlur":
                this.ki = com.bytedance.adsdk.ugeno.iz.fx.u(str2, false);
                break;
        }
    }
}
