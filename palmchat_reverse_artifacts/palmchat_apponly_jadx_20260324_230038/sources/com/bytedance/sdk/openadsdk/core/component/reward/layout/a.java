package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.live.view.DoubleColorBallAnimationView;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends nr {
    private ImageView k;
    private DoubleColorBallAnimationView my;
    LinearLayout s;

    public a(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, boolean z) {
        super(tTBaseVideoActivity, bcVar, z);
    }

    public void fx() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.my;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.fx();
            this.s.setVisibility(8);
        }
    }

    public void nr() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.my;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.nr();
            this.s.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u() {
        super.u();
        this.k = new ImageView(this.nr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.k.setAdjustViewBounds(true);
        this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.k.setLayoutParams(layoutParams);
        this.x.addView(this.k);
        View view = new View(this.nr);
        view.setBackgroundColor(Color.parseColor("#A6000000"));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.x.addView(view);
        LinearLayout linearLayout = new LinearLayout(this.nr);
        this.s = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.nr);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setText(q.u(this.nr, "tt_reward_live_grant"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 24;
        textView.setLayoutParams(layoutParams2);
        this.my = new DoubleColorBallAnimationView(this.nr);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(y.fx(this.nr, 60.0f), y.fx(this.nr, 60.0f));
        layoutParams3.gravity = 17;
        this.my.setLayoutParams(layoutParams3);
        this.s.addView(this.my);
        this.s.addView(textView);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.s.setLayoutParams(layoutParams4);
        this.x.addView(this.s);
        this.s.setVisibility(8);
        String strNr = zx.nr(this.fx);
        if (TextUtils.isEmpty(strNr)) {
            return;
        }
        com.bytedance.sdk.openadsdk.n.nr.u(strNr).width(this.x.getWidth()).height(this.x.getHeight()).to(this.k);
    }
}
