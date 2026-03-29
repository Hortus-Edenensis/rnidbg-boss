package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.nr.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends fx<DislikeView> {
    private int hs;
    private int ki;
    private int u;

    public u(Context context) {
        super(context);
        this.u = 0;
        this.hs = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        ((DislikeView) this.pn).setRadius(this.w);
        ((DislikeView) this.pn).setStrokeWidth((int) this.eh);
        ((DislikeView) this.pn).setDislikeColor(this.u);
        ((DislikeView) this.pn).setStrokeColor(this.lf);
        ((DislikeView) this.pn).setDislikeWidth(this.ki);
        ((DislikeView) this.pn).setBgColor(this.hs);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public DislikeView u() {
        DislikeView dislikeView = new DislikeView(this.nr);
        dislikeView.u(this);
        return dislikeView;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "dislikeColor":
                this.u = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
            case "dislikeWidth":
                this.ki = (int) n.u(this.nr, Integer.parseInt(str2));
                break;
            case "dislikeFillColor":
                this.hs = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
        }
    }
}
