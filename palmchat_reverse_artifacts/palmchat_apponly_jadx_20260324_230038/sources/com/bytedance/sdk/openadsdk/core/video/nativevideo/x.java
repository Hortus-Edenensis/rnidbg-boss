package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.widget.k;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private iz u;

    public x(iz izVar) {
        this.u = izVar;
    }

    public boolean nr() {
        View view;
        RoundImageView roundImageView;
        TextView textView;
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.u.kj)) {
            return true;
        }
        View view2 = this.u.n;
        return (view2 != null && view2.getVisibility() == 0) || ((view = this.u.jk) != null && view.getVisibility() == 0) || (((roundImageView = this.u.t) != null && roundImageView.getVisibility() == 0) || ((textView = this.u.l) != null && textView.getVisibility() == 0));
    }

    public boolean u() {
        k kVar = this.u.gi;
        boolean zU = kVar != null ? kVar.u() : false;
        this.u.fx.getVisibility();
        return zU || this.u.fx.getVisibility() == 0;
    }
}
