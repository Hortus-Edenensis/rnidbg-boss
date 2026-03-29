package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jp;
import com.bytedance.sdk.openadsdk.core.n.fx;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.n.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SaasAuthRewardDialog extends RelativeLayout implements Runnable {
    private static boolean jk = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5249a;
    private RotateAnimation b;
    private ImageView fx;
    private boolean iz;
    private String n;
    private BaseSaasEnvelope nr;
    private ScaleAnimation pn;
    private SaasAuthEnvelope u;
    private bc x;

    public SaasAuthRewardDialog(@NonNull Context context) {
        super(context);
        this.iz = false;
        u(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ja.nr(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (getVisibility() == 0) {
            if (this.iz) {
                setVisibility(8);
                return;
            } else {
                jk.nr().postDelayed(this, 5000L);
                nr();
                return;
            }
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.pn = scaleAnimation;
        scaleAnimation.setDuration(600L);
        this.pn.setFillAfter(true);
        this.pn.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SaasAuthRewardDialog.this.b = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                SaasAuthRewardDialog.this.b.setDuration(5000L);
                SaasAuthRewardDialog.this.b.setRepeatCount(-1);
                SaasAuthRewardDialog.this.b.setFillAfter(true);
                SaasAuthRewardDialog.this.b.setInterpolator(new LinearInterpolator());
                SaasAuthRewardDialog.this.fx.startAnimation(SaasAuthRewardDialog.this.b);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.fx.startAnimation(this.pn);
        ja.nr(true);
        setVisibility(0);
        this.u.u();
        jk.nr().postDelayed(this, 2000L);
    }

    private void fx() {
        try {
            if (jk) {
                return;
            }
            u uVar = new u();
            nr.u(fx.u("saas_light_shine.webp")).to(uVar);
            nr.u(fx.u("saas_red_envelope.webp")).to(uVar);
            nr.u(fx.u("saas_reward_goods_bg.webp")).to(uVar);
            nr.u(fx.u("saas_reward_coupon_bg.webp")).to(uVar);
            nr.u(fx.u("saas_reward_title.webp")).to(uVar);
            jk = true;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr() {
        this.iz = true;
        jp jpVarVg = this.x.vg();
        if (jpVarVg.jk() != null) {
            this.nr = new SaasAuthCouponEnvelope(getContext(), jpVarVg.jk());
        } else if (jpVarVg.t() != null) {
            this.nr = new SaasAuthProductEnvelope(getContext(), jpVarVg.t());
        }
        BaseSaasEnvelope baseSaasEnvelope = this.nr;
        if (baseSaasEnvelope != null) {
            addView(baseSaasEnvelope, new RelativeLayout.LayoutParams(-1, -1));
            this.nr.u();
            com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(getContext(), this.x, this.n, this.f5249a);
            setTag(67108864, 2917);
            com.bytedance.sdk.component.t.pn.u.u().u(this.x.hashCode() + this.x.xx()).put("live_saas_interaction_type", 101);
            setOnClickListener(uVar);
            this.nr.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SaasAuthRewardDialog.this.u();
                }
            });
            this.nr.setOnButtonClickListener(uVar);
        }
        SaasAuthEnvelope saasAuthEnvelope = this.u;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.nr();
        }
        removeView(this.u);
    }

    public void u(bc bcVar, String str, int i) {
        if (bcVar != null && com.bytedance.sdk.openadsdk.core.live.nr.u().fx() == 2) {
            jp jpVarVg = bcVar.vg();
            if (jpVarVg != null && ((jpVarVg.t() != null || jpVarVg.jk() != null) && jpVarVg.a())) {
                this.x = bcVar;
                this.n = str;
                this.f5249a = i;
                setBackgroundColor(Color.parseColor("#aa000000"));
                jk.nr().postDelayed(this, 5000L);
                u(getContext());
                fx();
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    private void u(Context context) {
        this.fx = new ImageView(context);
        try {
            nr.u(fx.u("saas_light_shine.webp")).to(this.fx);
            this.fx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Error unused) {
        }
        int iB = y.b(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB, iB);
        layoutParams.addRule(13);
        addView(this.fx, layoutParams);
        SaasAuthEnvelope saasAuthEnvelope = new SaasAuthEnvelope(context);
        this.u = saasAuthEnvelope;
        saasAuthEnvelope.setId(2114387464);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.u, layoutParams2);
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.nr();
                jk.nr().removeCallbacks(SaasAuthRewardDialog.this);
            }
        });
        this.u.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.u();
            }
        });
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements qq {
        private u() {
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onSuccess(my myVar) {
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onFailed(int i, String str, Throwable th) {
        }
    }

    public void u() {
        SaasAuthEnvelope saasAuthEnvelope = this.u;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.nr();
        }
        BaseSaasEnvelope baseSaasEnvelope = this.nr;
        if (baseSaasEnvelope != null) {
            baseSaasEnvelope.nr();
        }
        RotateAnimation rotateAnimation = this.b;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.b = null;
        }
        ScaleAnimation scaleAnimation = this.pn;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.pn = null;
        }
        jk.nr().removeCallbacks(this);
        setVisibility(8);
        ja.nr(false);
    }
}
