package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.dynamic.fx.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ClickSlideUpShakeView extends SlideUpView {
    private ShakeClickView u;

    public ClickSlideUpShakeView(Context context, jk jkVar, boolean z, int i, boolean z2) {
        super(context);
        u(context, jkVar, z, i, z2);
    }

    private void u(Context context, jk jkVar, boolean z, int i, boolean z2) {
        ShakeClickView shakeClickView = new ShakeClickView(context, com.bytedance.sdk.component.adexpress.fx.u.fx(context), jkVar, z, i, z2);
        this.u = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.u.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.u;
    }

    public void setShakeText(String str) {
        if (this.u == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.u.setShakeText("");
        } else {
            this.u.setShakeText(str);
        }
    }
}
