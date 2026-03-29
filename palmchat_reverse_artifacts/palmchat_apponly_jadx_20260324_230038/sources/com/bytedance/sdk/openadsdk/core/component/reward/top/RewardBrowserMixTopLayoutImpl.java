package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.y;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RewardBrowserMixTopLayoutImpl extends FrameLayout implements u<RewardBrowserMixTopLayoutImpl> {
    private bc b;
    private nr fx;
    private View nr;
    private Context pn;
    private View u;

    public RewardBrowserMixTopLayoutImpl(Context context) {
        this(context, null);
    }

    private void b() {
        y.u(this.u, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", RewardBrowserMixTopLayoutImpl.this.fx);
                    jSONObject.put("topImpl", 2);
                } catch (Throwable unused) {
                }
                s.u().u(RewardBrowserMixTopLayoutImpl.this.b, "stats_reward_full_click_native_close", jSONObject);
                if (RewardBrowserMixTopLayoutImpl.this.fx != null) {
                    RewardBrowserMixTopLayoutImpl.this.fx.u(view);
                }
            }
        }, "top_skip_border");
        y.u(this.nr, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RewardBrowserMixTopLayoutImpl.this.fx != null) {
                    RewardBrowserMixTopLayoutImpl.this.fx.fx(view);
                }
            }
        }, "top_dislike_button");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void fx() {
        View view = this.nr;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public View getCloseButton() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public boolean getSkipOrCloseVisible() {
        return y.b(this.u);
    }

    public nr getTopListener() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void nr() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setListener(nr nrVar) {
        this.fx = nrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void u(String str, String str2, boolean z) {
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void u(boolean z, String str, String str2, boolean z2, boolean z3) {
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pn = context;
    }

    public RewardBrowserMixTopLayoutImpl u(bc bcVar) {
        this.b = bcVar;
        addView(com.bytedance.sdk.openadsdk.res.pn.n(getContext()));
        this.u = findViewById(2114387869);
        View viewFindViewById = findViewById(2114387453);
        this.nr = findViewById(2114387454);
        if (bg.mv(bcVar)) {
            this.u = findViewById(2114387869);
            this.nr.setVisibility(8);
            viewFindViewById.setVisibility(8);
            q.u(this.pn, "tt_ad_skip_btn_bg", this.u);
        } else if (bg.s(bcVar)) {
            findViewById(2114387738).setVisibility(8);
            this.u = findViewById(2114387869);
        } else {
            this.u = findViewById(2114387713);
            this.nr.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        if (this.u != null) {
            if (bcVar.my()) {
                this.u.setVisibility(8);
            } else {
                this.u.setVisibility(0);
                this.u.setEnabled(true);
                this.u.setClickable(true);
            }
        }
        b();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setDislikeLeft(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setPlayAgainEntranceText(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setShowAgain(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setShowBack(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setShowDislike(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setShowSound(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void setSoundMute(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.u
    public void u() {
        View view = this.u;
        if (view != null) {
            view.performClick();
        }
    }
}
