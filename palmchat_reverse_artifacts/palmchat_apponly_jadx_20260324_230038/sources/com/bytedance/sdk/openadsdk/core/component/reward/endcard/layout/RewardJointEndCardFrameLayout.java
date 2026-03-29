package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.u.fx.iz;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.n.nr;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"ViewConstructor"})
public class RewardJointEndCardFrameLayout extends AbstractEndCardFrameLayout implements iz {
    private View b;
    private FrameLayout fx;
    private FrameLayout iz;
    private RewardJointBottomView pn;

    public RewardJointEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        super(tTBaseVideoActivity, bcVar);
    }

    private boolean b() {
        if (this.nr.ol() == 15) {
            return true;
        }
        if (this.nr.ol() == 5) {
            return false;
        }
        if (this.nr.zu() == null || this.nr.zu().isEmpty()) {
            return true;
        }
        rh rhVar = this.nr.zu().get(0);
        return rhVar.fx() > rhVar.nr();
    }

    private void fx() {
        if (bc.nr(this.nr)) {
            nr.u(zx.nr(this.nr)).config(Bitmap.Config.ARGB_4444).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3
                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my<Bitmap> myVar) {
                    Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(RewardJointEndCardFrameLayout.this.getContext(), myVar.getResult(), 25);
                    if (bitmapU == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapU);
                    x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.iz != null) {
                                RewardJointEndCardFrameLayout.this.iz.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str, Throwable th) {
                }
            }, 4);
        } else {
            nr.u(this.nr.zu().get(0)).config(Bitmap.Config.ARGB_4444).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2
                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my<Bitmap> myVar) {
                    Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(RewardJointEndCardFrameLayout.this.getContext(), myVar.getResult(), 25);
                    if (bitmapU == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapU);
                    x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.fx != null) {
                                RewardJointEndCardFrameLayout.this.fx.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str, Throwable th) {
                }
            }, 4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.pn.getWebView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.iz;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.bytedance.sdk.component.widget.recycler.u.fx.pn
    public boolean onNestedPreFling(View view, float f, float f2) {
        return super.onNestedPreFling(view, f, f2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void setClickListener(com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        y.u(this.b, (View.OnClickListener) nrVar, "bar_view");
        this.pn.setClickListener(nrVar);
    }

    private void nr(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(y.fx(getContext(), 15.0f), 0, 0, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(getContext());
        tTRoundRectImageView.setBackgroundColor(0);
        linearLayout.addView(tTRoundRectImageView, new RelativeLayout.LayoutParams(y.fx(getContext(), 40.0f), y.fx(getContext(), 40.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setMaxWidth(y.fx(getContext(), 153.0f));
        textView.setSingleLine(true);
        textView.setTextColor(-16777216);
        textView.setTextSize(2, 17.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, y.fx(getContext(), 27.0f)));
        TextView textView2 = new TextView(getContext());
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine(true);
        textView2.setTextColor(Color.parseColor("#4A4A4A"));
        textView2.setTextSize(2, 11.0f);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMarginStart(y.fx(getContext(), 14.0f));
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(Color.parseColor("#1A73E8"));
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 13.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(y.fx(getContext(), 70.0f), y.fx(getContext(), 24.0f));
        layoutParams2.setMarginEnd(y.fx(getContext(), 15.0f));
        linearLayout.addView(textView3, layoutParams2);
        viewGroup.addView(linearLayout, new LinearLayout.LayoutParams(-1, y.fx(getContext(), 60.0f)));
        this.b = linearLayout;
        rh rhVarDd = this.nr.dd();
        if (rhVarDd == null || TextUtils.isEmpty(rhVarDd.u())) {
            q.u(getContext(), "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
        } else {
            nr.u(rhVarDd).to(tTRoundRectImageView);
        }
        if (this.nr.pu() == null || TextUtils.isEmpty(this.nr.pu().fx())) {
            textView.setText(this.nr.j());
        } else {
            textView.setText(this.nr.pu().fx());
        }
        textView2.setText(this.nr.wf());
        textView3.setText(this.nr.yb());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void u() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        u(linearLayout);
        nr(linearLayout);
        fx(linearLayout);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    private void fx(ViewGroup viewGroup) {
        RewardJointBottomView rewardJointBottomView = new RewardJointBottomView(getContext(), this.nr);
        this.pn = rewardJointBottomView;
        if (b()) {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, y.fx(getContext(), 160.0f)));
        } else {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        rewardJointBottomView.u(com.bytedance.sdk.openadsdk.core.y.q.u(this.nr));
    }

    private void u(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.fx = frameLayout;
        if (b()) {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        } else {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, y.fx(getContext(), 200.0f)));
        }
        fx();
        if (!bc.nr(this.nr)) {
            final ImageView imageView = new ImageView(getContext());
            frameLayout.addView(imageView, -1, -1);
            nr.u(this.nr.zu().get(0)).config(Bitmap.Config.ARGB_4444).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.1
                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my<Bitmap> myVar) {
                    imageView.setImageBitmap(myVar.getResult());
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str, Throwable th) {
                }
            });
        } else {
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            this.iz = frameLayout2;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.u.fx.iz
    public boolean u(View view, View view2, int i, int i2) {
        return b();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.u.fx.iz
    public void u(View view, int i, int i2, int[] iArr, int i3) {
        int iU = u(i2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.pn.getLayoutParams();
        layoutParams.height -= iU;
        this.pn.setLayoutParams(layoutParams);
        if (iU != 0) {
            this.u.su().bc();
        }
        iArr[1] = iArr[1] + iU;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int u(int i) {
        if (i > 0) {
            int height = this.pn.getHeight() - y.fx(getContext(), 200.0f);
            if (height <= 0) {
                i = 0;
            } else if (height < Math.abs(i)) {
                i = height;
            }
        } else {
            int height2 = this.fx.getHeight() - y.fx(getContext(), 160.0f);
            if (height2 > 0) {
                if (height2 < Math.abs(i)) {
                    i = -height2;
                }
            }
        }
        if (Math.abs(i) > 400) {
            return 0;
        }
        return i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void nr() {
        super.nr();
        RewardJointBottomView rewardJointBottomView = this.pn;
        if (rewardJointBottomView != null) {
            rewardJointBottomView.nr();
        }
    }
}
