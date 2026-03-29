package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.ja;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5226a;
    private LinearLayout bg;
    private TranslateAnimation bq;
    private fx fx;
    private int iz;
    private int jk;
    private LinearLayout k;
    private TextView l;
    private TextView mv;
    private boolean my;
    private int n;
    private final u.InterfaceC0244u nr;
    private SmallSlideView o;
    private TextView pn;
    private int s;
    private LinearLayout sx;
    private int t;
    private int x;
    protected final AtomicBoolean u = new AtomicBoolean(false);
    private boolean b = true;
    private boolean dw = false;
    private boolean c = false;
    private boolean q = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.nr$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            nr.this.nr.u().u(new RewardFullBaseLayout.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.nr.1.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout.u
                public void u() {
                    b bVar = new b();
                    bVar.u = false;
                    bVar.fx = true;
                    bVar.b = true;
                    nr.this.nr.u().u();
                    nr.this.nr.getActivity().u(3, bVar);
                }
            });
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) nr.this.bg.getLayoutParams();
            layoutParams.bottomMargin = -nr.this.bg.getMeasuredHeight();
            nr.this.bg.setLayoutParams(layoutParams);
            nr.this.bg.setVisibility(0);
            nr.this.bq = new TranslateAnimation(0.0f, 0.0f, 0.0f, -nr.this.bg.getMeasuredHeight());
            nr.this.bq.setDuration(300L);
            nr.this.bq.setRepeatCount(3);
            nr.this.bq.setRepeatMode(2);
            nr.this.bq.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.nr.1.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (nr.this.dw) {
                        nr.this.bg.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.nr.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (nr.this.dw && nr.this.bq != null) {
                                    nr.this.nr.u().getSceneFrameContainer().startAnimation(nr.this.bq);
                                }
                            }
                        }, 2000L);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    nr.this.o.u();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (nr.this.bq != null) {
                nr.this.nr.u().getSceneFrameContainer().startAnimation(nr.this.bq);
            }
        }
    }

    public nr(u.InterfaceC0244u interfaceC0244u) {
        this.nr = interfaceC0244u;
    }

    private void jk() {
        String str;
        this.x = this.nr.pn() + (ja.a() / 1000);
        this.sx = new LinearLayout(this.nr.getActivity());
        int iFx = y.fx(this.nr.getActivity(), 10.0f);
        this.sx.setPadding(iFx, iFx, iFx, iFx);
        this.sx.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#242424"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.u.u.nr().u(this.nr.getActivity(), 12.0f));
        this.sx.setBackground(gradientDrawable);
        this.o = new SmallSlideView(this.nr.getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(y.fx(this.nr.getActivity(), 80.0f), y.fx(this.nr.getActivity(), 80.0f));
        layoutParams.gravity = 17;
        this.sx.addView(this.o, layoutParams);
        TextView textView = new TextView(this.nr.getActivity());
        if (ja.jk() > 0) {
            str = "上滑继续观看\n提前" + ja.jk() + "秒领奖";
        } else {
            str = "上滑继续观看\n才能领奖哦";
        }
        textView.setText(str);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        this.sx.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(y.fx(this.nr.getActivity(), 160.0f), y.fx(this.nr.getActivity(), 160.0f));
        layoutParams2.gravity = 17;
        this.nr.u().addView(this.sx, layoutParams2);
        this.bg = new LinearLayout(this.nr.getActivity());
        ImageView imageView = new ImageView(this.nr.getActivity());
        q.u((Context) this.nr.getActivity(), "tt_ic_back_light", imageView);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = y.fx(this.nr.getActivity(), 10.0f);
        layoutParams3.bottomMargin = y.fx(this.nr.getActivity(), 10.0f);
        this.bg.addView(imageView, layoutParams3);
        this.nr.u().getSceneFrameContainer().setClipChildren(false);
        this.bg.setVisibility(4);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 80;
        this.nr.u().getSceneFrameContainer().addView(this.bg, layoutParams4);
        this.dw = true;
        this.bg.post(new AnonymousClass1());
    }

    public void a() {
        TextView textView = this.pn;
        if (textView == null || textView.getParent() == null) {
            return;
        }
        ((ViewGroup) this.pn.getParent()).removeView(this.pn);
        this.pn = null;
    }

    public void n() {
        int iIz = this.nr.iz();
        String strConcat = "继续看" + iIz + "秒可领取奖励";
        fx fxVar = this.fx;
        if (fxVar != null) {
            if (fxVar.fx() > 0) {
                if (iIz <= 0) {
                    strConcat = "成功加速" + this.fx.fx() + "秒，奖励已下发";
                } else {
                    strConcat = "加速成功！".concat(String.valueOf(strConcat));
                }
            } else if (iIz <= 0) {
                a();
                return;
            }
        }
        TextView textView = this.pn;
        if (textView != null) {
            textView.setText(strConcat);
        }
        int i = this.iz;
        if (i <= 0) {
            a();
            return;
        }
        this.iz = i - 1;
        TextView textView2 = this.pn;
        if (textView2 != null) {
            textView2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.nr.3
                @Override // java.lang.Runnable
                public void run() {
                    nr.this.n();
                }
            }, 500L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public void x() {
        int i;
        int i2;
        if (u(3)) {
            return;
        }
        if (this.x > 0 && this.nr.pn() >= this.x) {
            this.x = 0;
            b bVar = new b();
            bVar.u = false;
            bVar.fx = false;
            bVar.b = true;
            this.nr.getActivity().u(3, bVar);
        }
        if (this.l != null && (i2 = this.n) > 0) {
            this.n = Math.max(0, i2 - 1);
            TextView textView = this.l;
            StringBuilder sb = new StringBuilder();
            sb.append(this.n);
            textView.setText(sb.toString());
            if (this.n == 0) {
                b bVar2 = new b();
                bVar2.u = false;
                bVar2.fx = false;
                bVar2.b = true;
                this.nr.getActivity().u(1, bVar2);
                iz();
            }
        }
        if (this.l != null) {
            if (ja.mv() == 1 && ja.u(this.nr.fx()) != 1 && !this.my && this.nr.a() && this.nr.n()) {
                b bVar3 = new b();
                bVar3.u = false;
                bVar3.fx = false;
                bVar3.b = true;
                this.nr.getActivity().u(2, bVar3);
            }
            if (this.f5226a > 0 || this.s > 0) {
                if (ja.mv() != 1) {
                    this.f5226a = Math.max(0, this.f5226a - 1);
                    TextView textView2 = this.l;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f5226a);
                    textView2.setText(sb2.toString());
                    if (this.f5226a == 0) {
                        b bVar4 = new b();
                        bVar4.u = false;
                        bVar4.fx = false;
                        bVar4.b = true;
                        this.nr.getActivity().u(2, bVar4);
                        iz();
                    }
                } else if (this.nr.a()) {
                    int iMax = Math.max(0, this.s - 1);
                    this.s = iMax;
                    if (iMax == 0) {
                        iz();
                    }
                } else {
                    this.f5226a = Math.max(0, this.f5226a - 1);
                    TextView textView3 = this.l;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.f5226a);
                    textView3.setText(sb3.toString());
                    if (this.f5226a == 0) {
                        b bVar5 = new b();
                        bVar5.u = false;
                        bVar5.fx = false;
                        bVar5.b = true;
                        this.nr.getActivity().u(2, bVar5);
                        iz();
                    }
                }
            }
        }
        int i3 = this.t;
        if (i3 > 0) {
            int iMax2 = Math.max(0, i3 - 1);
            this.t = iMax2;
            if (iMax2 == 0) {
                this.nr.u(-1, this.jk);
                return;
            }
            return;
        }
        if (this.l == null || (i = this.jk) <= 0) {
            return;
        }
        this.jk = Math.max(0, i - 1);
        TextView textView4 = this.l;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.jk);
        textView4.setText(sb4.toString());
        if (this.jk == 0) {
            iz();
            this.l = null;
            this.nr.t();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public void iz() {
        if (this.k != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.nr.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    nr.this.k.removeAllViews();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.k.startAnimation(alphaAnimation);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public boolean pn() {
        return this.u.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public boolean b() {
        return this.fx != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public void fx() {
        if (ja.mv() == 1 && this.q && this.l != null && this.mv != null && !TextUtils.isEmpty(ja.t())) {
            this.l.setText("");
            this.mv.setText(ja.t());
            int iL = ja.l();
            this.s = iL;
            if (iL == 0) {
                this.f5226a = 0;
                iz();
            }
        }
        if (this.dw && u(3)) {
            SmallSlideView smallSlideView = this.o;
            if (smallSlideView != null) {
                smallSlideView.nr();
            }
            TranslateAnimation translateAnimation = this.bq;
            if (translateAnimation != null) {
                translateAnimation.cancel();
            }
            LinearLayout linearLayout = this.sx;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                this.nr.u().removeView(this.sx);
            }
            LinearLayout linearLayout2 = this.bg;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                this.nr.u().getSceneFrameContainer().removeView(this.bg);
            }
            this.nr.u().u();
            this.nr.u(3);
            this.dw = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public int nr() {
        fx fxVar = this.fx;
        if (fxVar != null) {
            return fxVar.x();
        }
        return 0;
    }

    private void nr(final int i, int i2, int i3) {
        if (i == 1) {
            this.n = i2;
        } else if (i == 2) {
            i2++;
            this.f5226a = i2;
        } else if (i == -1) {
            this.jk = i2;
            if (i3 > 0) {
                this.t = i3;
                return;
            }
            this.t = 0;
        } else {
            i2 = 0;
        }
        LinearLayout linearLayout = this.k;
        if (linearLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(this.nr.getActivity());
            this.k = linearLayout2;
            linearLayout2.setBackgroundColor(Color.parseColor("#80161823"));
            this.k.setOrientation(0);
            this.k.setGravity(16);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            ((ViewGroup) this.nr.getActivity().getWindow().getDecorView()).addView(this.k, layoutParams);
        } else {
            linearLayout.removeAllViews();
        }
        TextView textView = new TextView(this.nr.getActivity());
        this.l = textView;
        textView.setTextColor(Color.parseColor("#FFBA33"));
        this.l.setText(String.valueOf(i2));
        this.l.setTypeface(Typeface.DEFAULT_BOLD);
        this.l.setTextSize(2, 14.0f);
        this.k.addView(this.l);
        TextView textView2 = new TextView(this.nr.getActivity());
        this.mv = textView2;
        textView2.setTextColor(-1);
        this.mv.setTypeface(Typeface.DEFAULT_BOLD);
        this.mv.setSingleLine();
        this.mv.setEllipsize(TextUtils.TruncateAt.END);
        this.mv.setText(ja.iz(this.nr.fx()));
        this.mv.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.setMargins(y.fx(this.nr.getActivity(), 4.0f), 0, 0, 0);
        layoutParams2.weight = 1.0f;
        this.k.addView(this.mv, layoutParams2);
        TextView textView3 = new TextView(this.nr.getActivity());
        textView3.setText("取消");
        textView3.setTypeface(Typeface.DEFAULT_BOLD);
        textView3.setTextSize(2, 13.0f);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.nr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = i;
                nr.this.my = true;
                int i5 = i;
                if (i5 == 1) {
                    nr.this.n = 0;
                } else if (i5 == 2) {
                    nr.this.f5226a = 0;
                    nr.this.s = 0;
                } else if (i5 == -1) {
                    nr.this.jk = 0;
                    i4 = 2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", i4);
                } catch (JSONException unused) {
                }
                s.u().u(nr.this.nr.fx(), "stats_switch_tip_cancel", jSONObject);
                nr.this.iz();
                nr.this.nr.jk();
            }
        });
        this.k.addView(textView3);
        this.k.setPadding(y.fx(this.nr.getActivity(), 20.0f), y.fx(this.nr.getActivity(), 16.0f), y.fx(this.nr.getActivity(), 20.0f), y.sx(this.nr.getActivity()));
        this.k.setClickable(false);
        if (i == 1) {
            this.c = true;
        } else if (i == 2) {
            this.q = true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, y.fx(this.nr.getActivity(), 100.0f), 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.k.startAnimation(translateAnimation);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public void u(fx fxVar, int i, b bVar) {
        bc bcVar = null;
        try {
            JSONArray jSONArray = new JSONArray(this.nr.fx().lg());
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArray.length()) {
                    break;
                }
                bc bcVarU = com.bytedance.sdk.openadsdk.core.u.u(jSONArray.getJSONObject(i2));
                if (u(bcVarU, i)) {
                    try {
                        jSONArray.remove(i2);
                        bcVarU.jp(jSONArray.toString());
                    } catch (JSONException unused) {
                    }
                    bcVar = bcVarU;
                    break;
                }
                i2++;
            }
        } catch (JSONException unused2) {
        }
        if (bcVar != null) {
            if (i == 1 && bVar != null && bVar.u) {
                if (this.c) {
                    return;
                }
                this.nr.u(i, bVar.nr);
                return;
            }
            if (i == 2 && bVar != null && bVar.u) {
                if (this.q) {
                    return;
                }
                this.nr.u(i, bVar.nr);
                return;
            }
            if (i == 3 && bVar != null && bVar.u) {
                if (this.dw) {
                    return;
                }
                this.nr.u(i, bVar.nr);
                return;
            }
            com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarU = com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.u().u(jp.u(bcVar, ""));
            if (this.nr.nr()) {
                com.bytedance.sdk.openadsdk.core.component.reward.fx fxVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.fx(dw.getContext(), bcVar, nrVarU);
                fxVar2.u(fxVar);
                fxVar2.u(this.nr.getActivity());
            } else {
                com.bytedance.sdk.openadsdk.core.component.reward.nr nrVar = new com.bytedance.sdk.openadsdk.core.component.reward.nr(dw.getContext(), bcVar, nrVarU);
                nrVar.u(fxVar);
                nrVar.u(this.nr.getActivity());
            }
            this.u.set(true);
        }
    }

    private boolean u(bc bcVar, int i) {
        if (i != 1) {
            return i != 2 ? i == 3 && ja.nr(bcVar, true) : ja.u(bcVar, true);
        }
        return ja.u(this.nr.nr(), bcVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public void u(fx fxVar) {
        this.fx = fxVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public int u() {
        fx fxVar = this.fx;
        if (fxVar != null) {
            return Math.max(0, fxVar.nr() - this.fx.fx());
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public void u(boolean z) {
        this.b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public int u(int i, boolean z) {
        if (!this.b || u(i)) {
            return 0;
        }
        if (i == 1) {
            if (ja.u(this.nr.fx()) != 1) {
                return 0;
            }
            if (!z) {
                if (!ja.u(this.nr.nr(), b() ? this.nr.b() : bc.nr(this.nr.fx()), this.nr.pn())) {
                    return 0;
                }
            }
            return i;
        }
        if (i == 2) {
            if (ja.nr(this.nr.fx()) != 1) {
                return 0;
            }
            if (!z && this.nr.x() && ja.mv() == 0) {
                return 0;
            }
            if (ja.mv() == 1) {
                if (this.my) {
                    return 0;
                }
                if (this.nr.a()) {
                    if (this.nr.n()) {
                        return i;
                    }
                    return 0;
                }
            }
            if (z || ja.u(this.nr.pn(), this.nr.fx(), this.nr.nr())) {
                return i;
            }
            return 0;
        }
        if (i != 3 || ja.fx(this.nr.fx()) != 1 || this.nr.n()) {
            return 0;
        }
        if (z || ja.u(this.nr.pn(), this.nr.fx())) {
            return i;
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public void nr(boolean z) {
        this.t = 0;
        if (z) {
            this.jk = 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public boolean u(int i) {
        if (this.nr.a()) {
            return yd.d(this.nr.fx()) == com.bytedance.sdk.openadsdk.core.n.b.pn || (yd.d(this.nr.fx()) == com.bytedance.sdk.openadsdk.core.n.b.iz && !this.nr.n());
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public void u(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        if (this.pn == null) {
            this.pn = y.o(this.nr.getActivity());
        }
        if (this.pn.getParent() != null) {
            ((ViewGroup) this.pn.getParent()).removeView(this.pn);
        }
        this.iz = ja.n() * 2;
        frameLayout.addView(this.pn);
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u
    public void u(int i, int i2, int i3) {
        if (i == -1 || i == 1 || i == 2) {
            nr(i, i2, i3);
        } else {
            if (i != 3) {
                return;
            }
            jk();
        }
    }
}
