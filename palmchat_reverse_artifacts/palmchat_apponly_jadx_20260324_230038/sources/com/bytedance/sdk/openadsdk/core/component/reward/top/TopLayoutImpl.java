package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.gi;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TopLayoutImpl extends FrameLayout implements u<TopLayoutImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f5245a;
    private View b;
    private TextView bg;
    private boolean bq;
    private bc c;
    private nr dw;
    private View fx;
    private View iz;
    private View jk;
    private View k;
    private View l;
    private View mv;
    private TextView my;
    private View n;
    private ImageView nr;
    private View o;
    private TextView pn;
    private View s;
    private View sx;
    private TextView t;
    private View u;
    private View x;

    public TopLayoutImpl(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public View getCloseButton() {
        return this.jk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public boolean getSkipOrCloseVisible() {
        return y.b(this.jk) || (this.iz != null && y.b(this.t) && !TextUtils.isEmpty(this.t.getText()));
    }

    public nr getTopListener() {
        return this.dw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setDislikeLeft(boolean z) {
        if (this.u.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.u.getLayoutParams();
            layoutParams.gravity = z ? GravityCompat.START : GravityCompat.END;
            this.u.setLayoutParams(layoutParams);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setListener(nr nrVar) {
        this.dw = nrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setPlayAgainEntranceText(String str) {
        y.u(this.pn, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setShowAgain(boolean z) {
        y.u(this.b, z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setShowBack(boolean z) {
        View view = this.fx;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setShowDislike(boolean z) {
        View view = this.u;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setShowSound(boolean z) {
        ImageView imageView = this.nr;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setSoundMute(boolean z) {
        this.bq = z;
        q.u(getContext(), this.bq ? "tt_mute" : "tt_unmute", this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        y.u(this.u, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.dw != null) {
                    TopLayoutImpl.this.dw.fx(view);
                }
            }
        }, "top_dislike_button");
        y.u(this.nr, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopLayoutImpl.this.bq = !r0.bq;
                q.u(TopLayoutImpl.this.getContext(), TopLayoutImpl.this.bq ? "tt_mute" : "tt_unmute", TopLayoutImpl.this.nr);
                if (TopLayoutImpl.this.dw != null) {
                    TopLayoutImpl.this.dw.nr(view);
                }
            }
        }, "top_mute_button");
        y.u(this.x, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "top_before_button");
        y.u(this.jk, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", TopLayoutImpl.this.dw);
                    jSONObject.put("topImpl", 1);
                } catch (Throwable unused) {
                }
                if (!gi.u(TopLayoutImpl.this.c) || com.bytedance.sdk.openadsdk.core.my.b.u(String.valueOf(jp.t(TopLayoutImpl.this.c)))) {
                    s.u().u(TopLayoutImpl.this.c, "stats_reward_full_click_native_close", jSONObject);
                }
                if (TopLayoutImpl.this.dw != null) {
                    TopLayoutImpl.this.dw.u(view);
                }
            }
        }, "top_skip_button");
        y.u(this.fx, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.dw != null) {
                    TopLayoutImpl.this.dw.b(view);
                }
            }
        }, "top_back_button");
        y.u(this.b, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.dw != null) {
                    TopLayoutImpl.this.dw.pn(view);
                }
            }
        }, "top_again_button");
        y.u(this.iz, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.dw != null) {
                    TopLayoutImpl.this.dw.iz(view);
                }
            }
        }, "top_skip_border");
        y.u(this.sx, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.dw != null) {
                    TopLayoutImpl.this.dw.x(view);
                }
            }
        }, "top_next_video_cancel");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void fx() {
        View view = this.u;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void nr() {
        ImageView imageView = this.nr;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TopLayoutImpl u(bc bcVar) {
        this.c = bcVar;
        if (bg.t(bcVar)) {
            addView(com.bytedance.sdk.openadsdk.res.pn.n(getContext()));
        } else if (wi.n(this.c)) {
            addView(com.bytedance.sdk.openadsdk.res.pn.x(getContext()));
        } else {
            addView(com.bytedance.sdk.openadsdk.res.pn.iz(getContext()));
        }
        this.u = findViewById(2114387845);
        this.nr = (ImageView) findViewById(2114387758);
        this.fx = findViewById(2114387819);
        this.b = findViewById(2114387673);
        this.pn = (TextView) findViewById(2114387632);
        this.iz = findViewById(2114387713);
        this.x = findViewById(2114387951);
        this.n = findViewById(2114387725);
        this.f5245a = (TextView) findViewById(2114387606);
        this.jk = findViewById(2114387635);
        this.t = (TextView) findViewById(2114387785);
        this.l = findViewById(2114387738);
        this.mv = findViewById(2114387924);
        this.s = findViewById(2114387950);
        this.k = findViewById(2114387949);
        this.my = (TextView) findViewById(2114387948);
        this.o = findViewById(2114387947);
        this.sx = findViewById(2114387946);
        this.bg = (TextView) findViewById(2114387945);
        View view = this.jk;
        if (view != null) {
            view.setEnabled(false);
            this.jk.setClickable(false);
        }
        b();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void u(boolean z, String str, String str2, boolean z2, boolean z3) {
        y.u(this.iz, 0);
        boolean z4 = z || !TextUtils.isEmpty(str);
        boolean z5 = z2 || !TextUtils.isEmpty(str2);
        boolean z6 = z4 && z5;
        y.u(this.iz, (z4 || z5) ? 0 : 4);
        y.u(this.x, z4 ? 0 : 8);
        y.u(this.jk, z5 ? 0 : 8);
        y.u(this.mv, z6 ? 0 : 8);
        y.u(this.n, z ? 0 : 8);
        y.u((View) this.f5245a, !TextUtils.isEmpty(str) ? 0 : 8);
        y.u(this.l, z2 ? 0 : 8);
        y.u((View) this.t, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            y.u(this.f5245a, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            y.u(this.t, str2);
        }
        View view = this.jk;
        if (view != null) {
            view.setEnabled(z3);
            this.jk.setClickable(z3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void u(String str, String str2, boolean z) {
        boolean z2 = !TextUtils.isEmpty(str);
        boolean z3 = !TextUtils.isEmpty(str2);
        boolean z4 = z2 && z3;
        y.u(this.s, (z2 || z3) ? 0 : 4);
        y.u(this.k, z2 ? 0 : 8);
        y.u(this.sx, z3 ? 0 : 8);
        y.u(this.o, z4 ? 0 : 8);
        y.u((View) this.my, !TextUtils.isEmpty(str) ? 0 : 8);
        y.u((View) this.bg, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            y.u(this.my, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            y.u(this.bg, str2);
        }
        View view = this.jk;
        if (view != null) {
            view.setEnabled(z);
            this.jk.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void u() {
        View view = this.jk;
        if (view != null) {
            view.performClick();
        }
    }
}
