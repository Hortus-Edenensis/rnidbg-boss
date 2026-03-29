package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.pb.t;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected FrameLayout f5236a;
    protected final int b;
    protected final bc fx;
    protected final boolean iz;
    protected TextView jk;
    protected TextView l;
    protected int mv = 3;
    protected RelativeLayout n;
    protected final TTBaseVideoActivity nr;
    protected final float pn;
    protected RelativeLayout t;
    protected final String u;
    protected ViewGroup x;

    public nr(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, boolean z) {
        this.nr = tTBaseVideoActivity;
        this.fx = bcVar;
        this.b = bcVar.sv();
        this.pn = bcVar.ba();
        this.iz = z;
        this.u = z ? "rewarded_video" : "fullscreen_interstitial_ad";
    }

    public void fx(int i) {
    }

    public void iz(int i) {
        y.u((View) this.n, i);
    }

    public String k() {
        return jp.bq(this.fx);
    }

    public FrameLayout l() {
        return this.f5236a;
    }

    public RelativeLayout mv() {
        return this.n;
    }

    public void my() {
        bc bcVar = this.fx;
        String strUc = bcVar != null ? bcVar.uc() : null;
        if (this.jk == null || !TextUtils.isEmpty(strUc)) {
            return;
        }
        q.u(this.nr, "tt_ad_logo_backup", this.jk);
    }

    public void pn(int i) {
        y.u((View) this.jk, i);
    }

    public String s() {
        return jp.bg(this.fx);
    }

    public void t() {
        if (this.iz) {
            int iOb = this.fx.ob();
            this.mv = iOb;
            if (iOb == -200) {
                t tVarNr = dw.nr();
                StringBuilder sb = new StringBuilder();
                sb.append(jp.t(this.fx));
                this.mv = tVarNr.t(sb.toString());
            }
            if (this.mv == -1) {
                y.u((View) this.n, 0);
            }
        }
    }

    public void u(DownloadListener downloadListener) {
    }

    public void fx(boolean z) {
        this.nr.bf().getWidgetFrameContainer().setVisibility(z ? 0 : 8);
    }

    public void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.nr.nr nrVar2) {
    }

    public void u() {
        ViewGroup viewGroup = (ViewGroup) this.nr.findViewById(2114387959);
        this.x = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(-16777216);
        }
        com.bytedance.sdk.openadsdk.core.k.n.u(this.x);
    }

    public void u(ImageView imageView, UpieImageView upieImageView) {
        List<rh> listZu = this.fx.zu();
        if (listZu == null || listZu.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.n.nr.u(listZu.get(0)).to(imageView);
        if (com.bytedance.sdk.openadsdk.pn.u.b(this.fx)) {
            com.bytedance.sdk.openadsdk.pn.u.u(imageView, upieImageView);
        }
    }

    public void jk() {
    }

    public void b(int i) {
    }

    public void nr(int i) {
    }
}
