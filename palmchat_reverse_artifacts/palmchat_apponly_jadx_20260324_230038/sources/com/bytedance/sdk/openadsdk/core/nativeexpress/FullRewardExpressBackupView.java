package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class FullRewardExpressBackupView extends BackupView {
    private FrameLayout k;
    private View mv;
    private NativeExpressView s;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.u = context;
    }

    private void nr() {
        FrameLayout frameLayout = new FrameLayout(this.u);
        this.mv = frameLayout;
        frameLayout.setId(2114387734);
        addView(this.mv);
        FrameLayout frameLayout2 = (FrameLayout) this.mv.findViewById(2114387734);
        this.k = frameLayout2;
        frameLayout2.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.k;
    }

    public void u(bc bcVar, NativeExpressView nativeExpressView) {
        setBackgroundColor(-1);
        this.nr = bcVar;
        this.s = nativeExpressView;
        if (jp.jk(bcVar) == 7) {
            this.pn = "rewarded_video";
        } else {
            this.pn = "fullscreen_interstitial_ad";
        }
        u();
        this.s.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void u() {
        this.iz = y.fx(this.u, this.s.getExpectExpressWidth());
        this.x = y.fx(this.u, this.s.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.iz, this.x);
        }
        layoutParams.width = this.iz;
        layoutParams.height = this.x;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void u(View view, int i, com.bytedance.sdk.openadsdk.core.kj.q qVar) {
        NativeExpressView nativeExpressView = this.s;
        if (nativeExpressView != null) {
            nativeExpressView.u(view, i, qVar);
        }
    }
}
