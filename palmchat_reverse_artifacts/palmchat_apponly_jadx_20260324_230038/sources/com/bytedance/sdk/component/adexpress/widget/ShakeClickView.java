package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ShakeClickView extends ShakeAnimationView {
    private TextView nr;

    public ShakeClickView(Context context, View view, jk jkVar, boolean z, int i, boolean z2) {
        super(context, view, jkVar, z, i, z2);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.nr == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.nr.setText(str);
            return;
        }
        try {
            this.nr.setText(q.nr(this.nr.getContext(), "tt_splash_default_click_shake"));
        } catch (Exception e) {
            k.nr("shakeClickView", e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void u(Context context, View view) {
        addView(view);
        this.nr = (TextView) findViewById(2097610747);
    }
}
