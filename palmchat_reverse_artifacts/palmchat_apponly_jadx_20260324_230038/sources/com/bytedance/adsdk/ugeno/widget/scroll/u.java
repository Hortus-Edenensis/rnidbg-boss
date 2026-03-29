package com.bytedance.adsdk.ugeno.widget.scroll;

import android.content.Context;
import android.widget.ScrollView;
import com.bytedance.adsdk.ugeno.nr.u;
import com.bytedance.adsdk.ugeno.widget.frame.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends com.bytedance.adsdk.ugeno.nr.u<ScrollView> {
    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: ay, reason: merged with bridge method [inline-methods] */
    public ScrollView u() {
        UGScrollView uGScrollView = new UGScrollView(this.nr);
        uGScrollView.u(this);
        return uGScrollView;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u
    public u.C0171u n() {
        return new u.C0175u(this);
    }
}
