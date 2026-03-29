package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.RatioImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends nr {
    private TTRatingBar bg;
    private TextView bq;
    private UpieImageView dw;
    private TTRoundRectImageView k;
    private TextView my;
    private TextView o;
    private RatioImageView s;
    private TextView sx;

    public iz(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, boolean z) {
        super(tTBaseVideoActivity, bcVar, z);
    }

    private void b() {
        String strValueOf;
        if (this.sx == null) {
            return;
        }
        int iIz = this.fx.pu() != null ? this.fx.pu().iz() : 6870;
        String strU = q.u(this.nr, "tt_comment_num_backup");
        if (iIz > 10000) {
            strValueOf = (iIz / 10000) + "万";
        } else {
            strValueOf = String.valueOf(iIz);
        }
        this.sx.setText(String.format(strU, strValueOf));
    }

    private void fx() {
        TTRatingBar tTRatingBar = this.bg;
        if (tTRatingBar == null) {
            return;
        }
        tTRatingBar.setStarEmptyNum(1);
        this.bg.setStarFillNum(4);
        this.bg.setStarImageWidth(y.fx(this.nr, 16.0f));
        this.bg.setStarImageHeight(y.fx(this.nr, 16.0f));
        this.bg.setStarImagePadding(y.fx(this.nr, 4.0f));
        this.bg.u();
    }

    private void nr() {
        rh rhVarDd;
        y.u((TextView) this.nr.findViewById(2114387658), this.fx);
        if (this.s != null) {
            int iOl = this.fx.ol();
            if (iOl == 3) {
                this.s.setRatio(1.91f);
            } else if (iOl != 33) {
                this.s.setRatio(0.56f);
            } else {
                this.s.setRatio(1.0f);
            }
            u(this.s, this.dw);
        }
        if (this.k != null && (rhVarDd = this.fx.dd()) != null) {
            com.bytedance.sdk.openadsdk.n.nr.u(rhVarDd).to(this.k);
        }
        TextView textView = this.my;
        if (textView != null) {
            textView.setText(s());
        }
        TextView textView2 = this.o;
        if (textView2 != null) {
            textView2.setText(k());
        }
        fx();
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u() {
        super.u();
        this.f5236a = (FrameLayout) this.x.findViewById(2114387642);
        this.s = (RatioImageView) this.x.findViewById(2114387766);
        this.k = (TTRoundRectImageView) this.x.findViewById(2114387722);
        this.my = (TextView) this.x.findViewById(2114387702);
        this.o = (TextView) this.x.findViewById(2114387934);
        this.sx = (TextView) this.x.findViewById(2114387789);
        this.bq = (TextView) this.x.findViewById(2114387962);
        this.bg = (TTRatingBar) this.x.findViewById(2114387787);
        if (com.bytedance.sdk.openadsdk.pn.u.b(this.fx)) {
            UpieImageView upieImageView = new UpieImageView(this.s.getContext(), com.bytedance.sdk.openadsdk.pn.u.a(this.fx), com.bytedance.sdk.openadsdk.pn.u.jk(this.fx));
            this.dw = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.nr.nr nrVar2) {
        u(this.bq, nrVar, nrVar);
        u(this.s, nrVar2, nrVar2);
        u(this.k, nrVar2, nrVar2);
        u(this.my, nrVar2, nrVar2);
        u(this.o, nrVar2, nrVar2);
        u(this.sx, nrVar2, nrVar2);
        u(this.bg, nrVar2, nrVar2);
        u(this.dw, nrVar2, nrVar2);
    }

    public void u(View view, com.bytedance.sdk.openadsdk.core.nr.nr nrVar, View.OnTouchListener onTouchListener) {
        if (view == null || this.nr == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(nrVar);
    }
}
