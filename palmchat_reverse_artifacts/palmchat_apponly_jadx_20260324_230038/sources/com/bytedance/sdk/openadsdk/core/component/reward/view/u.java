package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bc f5250a;
    TTRatingBar b;
    TextView fx;
    TextView iz;
    private int jk;
    private final TTBaseVideoActivity n;
    TTRoundRectImageView nr;
    TextView pn;
    private boolean t;
    LinearLayout u;
    TextView x;

    public u(TTBaseVideoActivity tTBaseVideoActivity) {
        this.n = tTBaseVideoActivity;
    }

    private void iz() {
        TTRoundRectImageView tTRoundRectImageView;
        if (this.jk == 1 && (tTRoundRectImageView = this.nr) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, y.fx(this.n, 50.0f), 0, 0);
            this.nr.setLayoutParams(layoutParams);
        }
    }

    private void pn() {
        this.u = (LinearLayout) this.n.findViewById(2114387739);
        this.nr = (TTRoundRectImageView) this.n.findViewById(2114387773);
        this.fx = (TextView) this.n.findViewById(2114387645);
        this.b = (TTRatingBar) this.n.findViewById(2114387779);
        this.pn = (TextView) this.n.findViewById(2114387782);
        this.iz = (TextView) this.n.findViewById(2114387864);
        this.x = (TextView) this.n.findViewById(2114387709);
        TTRatingBar tTRatingBar = this.b;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.b.setStarFillNum(4);
            this.b.setStarImageWidth(y.fx(this.n, 16.0f));
            this.b.setStarImageHeight(y.fx(this.n, 16.0f));
            this.b.setStarImagePadding(y.fx(this.n, 4.0f));
            this.b.u();
        }
    }

    public String b() {
        bc bcVar = this.f5250a;
        return bcVar == null ? "立即下载" : TextUtils.isEmpty(bcVar.yb()) ? this.f5250a.qf() != 4 ? "查看详情" : "立即下载" : this.f5250a.yb();
    }

    public void fx() {
        y.u((View) this.u, 8);
    }

    public void nr() {
        String strValueOf;
        if (this.nr != null) {
            rh rhVarDd = this.f5250a.dd();
            if (rhVarDd == null || TextUtils.isEmpty(rhVarDd.u())) {
                q.u((Context) this.n, "tt_ad_logo_small", (ImageView) this.nr);
            } else {
                com.bytedance.sdk.openadsdk.n.nr.u(rhVarDd).to(this.nr);
            }
        }
        if (this.fx != null) {
            if (this.f5250a.pu() == null || TextUtils.isEmpty(this.f5250a.pu().fx())) {
                this.fx.setText(this.f5250a.wf());
            } else {
                this.fx.setText(this.f5250a.pu().fx());
            }
        }
        if (this.pn != null) {
            int iIz = this.f5250a.pu() != null ? this.f5250a.pu().iz() : 6870;
            String strU = q.u(this.n, "tt_comment_num_backup");
            if (iIz > 10000) {
                strValueOf = (iIz / 10000) + "万";
            } else {
                strValueOf = String.valueOf(iIz);
            }
            this.pn.setText(String.format(strU, strValueOf));
        }
        TextView textView = this.x;
        if (textView != null) {
            y.u(textView, this.f5250a);
        }
    }

    public void u(bc bcVar) {
        if (this.t) {
            return;
        }
        this.t = true;
        this.f5250a = bcVar;
        this.jk = bcVar.sv();
        pn();
        nr();
        u(b());
        iz();
    }

    public void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        y.u(this.u, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        TextView textView = this.iz;
        if (textView != null) {
            textView.setOnClickListener(nrVar);
            this.iz.setOnTouchListener(nrVar);
        }
    }

    public void u() {
        y.u((View) this.u, 0);
        bc bcVar = this.f5250a;
        if (bcVar == null || bcVar.ba() == 100.0f) {
            return;
        }
        y.u((View) this.b, 8);
        y.u((View) this.pn, 8);
    }

    public void u(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.iz) == null) {
            return;
        }
        textView.setText(str);
    }
}
