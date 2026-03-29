package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.kj.su;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n extends nr {
    private TextView bg;
    private TextView bq;
    private RelativeLayout c;
    private RelativeLayout dw;
    private RelativeLayout k;
    private boolean kj;
    private TextView my;
    private TextView o;
    private TextView q;
    private TextView qq;
    private RoundImageView s;
    private ImageView sx;

    public n(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, boolean z) {
        super(tTBaseVideoActivity, bcVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void b(int i) {
        if (this.kj) {
            return;
        }
        y.u((View) this.t, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void fx(int i) {
        y.u((View) this.dw, i);
        y.u((View) this.c, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u() {
        String strValueOf;
        String strValueOf2;
        super.u();
        this.n = (RelativeLayout) this.nr.findViewById(2114387662);
        this.f5236a = (FrameLayout) this.nr.findViewById(2114387754);
        this.jk = (TextView) this.nr.findViewById(2114387658);
        this.s = (RoundImageView) this.nr.findViewById(2114387882);
        this.k = (RelativeLayout) this.nr.findViewById(2114387911);
        this.my = (TextView) this.nr.findViewById(2114387921);
        this.o = (TextView) this.nr.findViewById(2114387850);
        this.sx = (ImageView) this.nr.findViewById(2114387881);
        this.bg = (TextView) this.nr.findViewById(2114387781);
        this.bq = (TextView) this.nr.findViewById(2114387640);
        this.dw = (RelativeLayout) this.nr.findViewById(2114387663);
        this.c = (RelativeLayout) this.nr.findViewById(2114387835);
        this.t = (RelativeLayout) this.nr.findViewById(2114387717);
        this.q = (TextView) this.nr.findViewById(2114387752);
        this.qq = (TextView) this.nr.findViewById(2114387716);
        y.u(this.jk, this.fx);
        t();
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.fx)) {
            String strA = m.a(this.fx);
            if (TextUtils.isEmpty(strA) || this.s == null) {
                y.u((View) this.k, 8);
            } else {
                y.u((View) this.k, 0);
                com.bytedance.sdk.openadsdk.n.nr.u(strA).to(this.s);
            }
            if (this.my != null) {
                this.my.setText(m.fx(this.fx));
            }
            if (this.o != null) {
                int iB = m.b(this.fx);
                if (iB < 0) {
                    this.o.setVisibility(4);
                    y.u((View) this.sx, 4);
                } else {
                    String strU = q.u(this.nr, "tt_live_fans_text");
                    if (iB > 10000) {
                        strValueOf2 = (iB / 10000.0f) + RXScreenCaptureService.KEY_WIDTH;
                    } else {
                        strValueOf2 = String.valueOf(iB);
                    }
                    this.o.setText(String.format(strU, strValueOf2));
                }
            }
            if (this.bg != null) {
                int iPn = m.pn(this.fx);
                if (iPn < 0) {
                    this.bg.setVisibility(4);
                    y.u((View) this.sx, 4);
                } else {
                    String strU2 = q.u(this.nr, "tt_live_watch_text");
                    if (iPn > 10000) {
                        strValueOf = (iPn / 10000.0f) + RXScreenCaptureService.KEY_WIDTH;
                    } else {
                        strValueOf = String.valueOf(iPn);
                    }
                    this.bg.setText(String.format(strU2, strValueOf));
                }
            }
            if (this.bq != null) {
                this.bq.setText(m.iz(this.fx));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.nr
    public void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.nr.nr nrVar2) {
        y.u((View) this.q, (View.OnTouchListener) nrVar, "TTBaseVideoActivity#mLiveLoadingBtn");
        y.u((View) this.q, (View.OnClickListener) nrVar, "TTBaseVideoActivity#mLiveLoadingBtn");
        y.u((View) this.qq, (View.OnClickListener) nrVar, "TTBaseVideoActivity#mLiveVideoBtn");
        y.u((View) this.qq, (View.OnClickListener) nrVar, "TTBaseVideoActivity#mLiveVideoBtn");
        u(nrVar2);
        u((View.OnTouchListener) nrVar2);
    }

    private void u(View.OnTouchListener onTouchListener) {
        y.u(this.n, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        y.u(this.f5236a, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        y.u(this.bq, onTouchListener, "TTBaseVideoActivity#mLiveDesc");
        y.u(this.o, onTouchListener, "TTBaseVideoActivity#mLiveFans");
        y.u(this.bg, onTouchListener, "TTBaseVideoActivity#mLiveWatch");
        y.u(this.my, onTouchListener, "TTBaseVideoActivity#mLiveName");
        y.u(this.s, onTouchListener, "TTBaseVideoActivity#mLiveIcon");
        y.u(this.t, onTouchListener, "TTBaseVideoActivity#mLiveBtnLayout");
    }

    private void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        u(this.f5236a, nrVar, "click_live_feed");
        u(this.bq, nrVar, "click_live_author_description");
        u(this.o, nrVar, "click_live_author_follower_count");
        u(this.bg, nrVar, "click_live_author_following_count");
        u(this.my, nrVar, "click_live_author_nickname");
        u(this.s, nrVar, "click_live_avata");
        u(this.n, nrVar, "click_live_button");
        u(this.t, nrVar, "click_live_btn_layout");
    }

    private void u(View view, final com.bytedance.sdk.openadsdk.core.nr.nr nrVar, final String str) {
        if (view == null || nrVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.nr;
        bc bcVar = this.fx;
        boolean z = this.iz;
        view.setOnClickListener(new com.bytedance.sdk.openadsdk.core.nr.nr(tTBaseVideoActivity, bcVar, z ? "rewarded_video" : "fullscreen_interstitial_ad", z ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.n.1
            @Override // com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
            public void u(View view2, com.bytedance.sdk.openadsdk.core.kj.jk jkVar) {
                HashMap map = new HashMap();
                map.put("click_live_element", str);
                ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) nrVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(map);
                nrVar.u(view2, jkVar);
            }
        });
    }

    public void u(int i, int i2) {
        TextView textView;
        if (i != 0) {
            this.kj = true;
            y.u((View) this.t, 8);
            return;
        }
        y.u((View) this.t, 0);
        if (i2 >= 0 && com.bytedance.sdk.openadsdk.core.live.nr.u().nr(this.fx) && su.u(this.fx) && su.pn(this.fx) == 3 && (textView = (TextView) this.nr.findViewById(2114387716)) != null) {
            textView.setText(String.format(q.u(this.nr, "tt_reward_auto_jump_live"), i2 + "s"));
        }
    }
}
