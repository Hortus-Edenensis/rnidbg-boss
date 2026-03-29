package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends com.bytedance.adsdk.ugeno.widget.text.nr {
    public nr(Context context) {
        super(context);
    }

    public void b(boolean z) {
        if (z) {
            nr(0);
            u(true, true);
        } else {
            b(0);
            pn(0);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.nr, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        if (TextUtils.isEmpty(((com.bytedance.adsdk.ugeno.widget.text.nr) this).u)) {
            ((UGTextView) this.pn).setText("跳过");
        }
    }
}
