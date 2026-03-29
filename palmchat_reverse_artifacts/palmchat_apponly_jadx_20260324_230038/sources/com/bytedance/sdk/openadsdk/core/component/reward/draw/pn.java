package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.b.fx;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.video.nr.u;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends RecyclerView.q implements rh.u {
    private boolean bf;
    public FrameLayout bg;
    public FrameLayout bq;
    public FrameLayout c;
    private boolean d;
    public FrameLayout dw;
    protected final AtomicBoolean gi;
    private boolean h;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.nr ja;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private final AnimatorSet f5230jp;
    public b kj;
    private LinearLayout m;
    public FullRewardExpressView o;
    private fx.u pb;
    public FrameLayout q;
    public TTProgressBar qq;
    private boolean rh;
    public ViewGroup sx;
    private int wq;
    private final rh xg;
    private int y;
    protected final AtomicBoolean z;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements Interpolator {
        private u() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }
    }

    public pn(View view) {
        super(view);
        this.xg = new rh(Looper.getMainLooper(), this);
        this.f5230jp = new AnimatorSet();
        this.z = new AtomicBoolean(false);
        this.gi = new AtomicBoolean(false);
        this.y = Integer.MAX_VALUE;
        this.sx = (ViewGroup) view.findViewById(2114387892);
        this.bg = (FrameLayout) view.findViewById(2114387778);
        this.bq = (FrameLayout) view.findViewById(2114387812);
        this.dw = (FrameLayout) view.findViewById(2114387670);
        this.c = (FrameLayout) view.findViewById(2114387821);
        this.q = (FrameLayout) view.findViewById(2114387679);
        this.qq = (TTProgressBar) view.findViewById(2114387767);
        u(view.getContext());
    }

    private void y() {
        FullRewardExpressView fullRewardExpressView = this.o;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.mv();
        }
        this.y = Integer.MAX_VALUE;
        this.rh = false;
        this.h = false;
        this.bf = false;
        this.bq.removeAllViews();
        this.dw.removeAllViews();
        this.c.removeAllViews();
        this.q.removeAllViews();
        this.z.set(false);
        this.gi.set(false);
        this.bg.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        b bVar = this.kj;
        if (bVar != null) {
            bVar.jk();
        }
    }

    public void bf() {
        b bVar = this.kj;
        if (bVar != null) {
            bVar.iz();
        }
    }

    public void d() {
        if (this.f5230jp.isStarted() && this.f5230jp.isPaused()) {
            this.f5230jp.resume();
        }
    }

    public void gi() {
        if (this.f5230jp.isStarted() && this.f5230jp.isRunning()) {
            this.f5230jp.pause();
        }
    }

    public void h() {
        if (this.f5230jp.isStarted() && this.f5230jp.isRunning()) {
            this.f5230jp.cancel();
        }
    }

    public long ja() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.nr nrVar = this.ja;
        if (nrVar == null) {
            return -1L;
        }
        return nrVar.t();
    }

    public boolean jp() {
        return this.gi.get();
    }

    public boolean m() {
        b bVar = this.kj;
        if (bVar == null) {
            return false;
        }
        return bVar.kj();
    }

    public void pb() {
        FullRewardExpressView fullRewardExpressView = this.o;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.mv();
        }
        b bVar = this.kj;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void rh() {
        if (this.kj != null && this.h && this.rh) {
            this.ja.a();
            this.o.my();
            if (this.bf && this.kj.qq()) {
                fx(this.ja.iz());
                wq();
            } else {
                this.bf = true;
                this.xg.sendEmptyMessageDelayed(101, 5000L);
                this.ja.u(this.o);
                this.kj.u(this.ja.jk());
            }
        }
    }

    public void wq() {
        b bVar = this.kj;
        if (bVar != null) {
            bVar.n();
        }
    }

    public com.bykv.vk.openvk.component.video.api.b.fx xg() {
        return this.kj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.h) {
            if (this.y > y.pn(this.u.getContext()) * 0.7f) {
                y.u((View) this.m, 0);
                this.f5230jp.start();
            }
            if (!z || this.z.get()) {
                return;
            }
            this.z.set(true);
        }
    }

    public void fx(boolean z) {
        b bVar = this.kj;
        if (bVar != null) {
            bVar.nr(z);
        }
    }

    public void nr(boolean z) {
        if (this.h == z) {
            return;
        }
        this.h = z;
        if (z) {
            rh();
            return;
        }
        bf();
        y.u((View) this.m, 8);
        this.f5230jp.cancel();
    }

    public void u(final com.bytedance.sdk.openadsdk.core.component.reward.draw.nr nrVar, float f, float f2) {
        this.ja = nrVar;
        this.qq.setVisibility(0);
        y();
        FullRewardExpressView fullRewardExpressViewNr = nrVar.nr(f, f2);
        this.o = fullRewardExpressViewNr;
        if (nrVar.pn) {
            if (fullRewardExpressViewNr.dw()) {
                this.c.setVisibility(8);
                this.q.addView(u(this.u.getContext(), nrVar));
                this.q.setVisibility(0);
            } else {
                this.o.u((ViewGroup) this.bg, false);
            }
            this.wq = this.o.getDynamicShowType();
            this.rh = true;
            rh();
            this.qq.setVisibility(8);
        } else {
            fullRewardExpressViewNr.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.pn.1
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
                public void u(View view, float f3, float f4) {
                    if (pn.this.o.dw()) {
                        pn.this.c.setVisibility(8);
                        pn pnVar = pn.this;
                        pnVar.q.addView(pnVar.u(view.getContext(), nrVar));
                        pn.this.q.setVisibility(0);
                    } else {
                        pn pnVar2 = pn.this;
                        pnVar2.o.u((ViewGroup) pnVar2.bg, false);
                    }
                    pn pnVar3 = pn.this;
                    pnVar3.wq = pnVar3.o.getDynamicShowType();
                    pn.this.rh = true;
                    pn.this.rh();
                    pn.this.qq.setVisibility(8);
                }
            });
        }
        this.o.setExpressVideoListenerProxy(new t() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.pn.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void b(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void fx(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public int nr() {
                if (pn.this.z.get()) {
                    return 4;
                }
                pn pnVar = pn.this;
                if (pnVar.kj == null || !pnVar.bf) {
                    return 2;
                }
                if (pn.this.kj.tk()) {
                    return 5;
                }
                if (pn.this.kj.c()) {
                    return 1;
                }
                if (pn.this.kj.wi()) {
                    return 2;
                }
                pn.this.kj.qq();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(float f3) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void b() {
                pn.this.gi.set(true);
                if (pn.this.h) {
                    pn.this.pb.u();
                    pn.this.ja.nr(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public int fx() {
                b bVar = pn.this.kj;
                if (bVar == null) {
                    return 0;
                }
                return (int) (bVar.t() / 1000);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(int i) {
                pn pnVar = pn.this;
                b bVar = pnVar.kj;
                if (bVar == null) {
                    return;
                }
                if (i == 2) {
                    bVar.x(true);
                    if (pn.this.h) {
                        pn.this.pb.u();
                        pn.this.bf();
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    return;
                }
                pnVar.gi.set(false);
                pn.this.kj.x(false);
                if (pn.this.h) {
                    pn.this.pb.nr();
                    pn.this.wq();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void nr(int i) {
                pn.this.pb.u(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public long u() {
                return pn.this.kj.t();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(float f3, float f4, float f5, float f6, int i) {
                pn.this.u(f3, f4, f5, f6, i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void iz() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void jk() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void n() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void pn() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void t() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void x() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void setPauseFromExpressView(boolean z) {
            }
        });
        this.o.setOnVideoSizeChangeListener(new FullRewardExpressView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.pn.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.u
            public void u(int i) {
                pn.this.y = i;
            }
        });
        this.c.addView(this.o);
        b bVar = new b(this.sx.getContext(), this.bq, nrVar.u());
        this.kj = bVar;
        this.o.setVideoController(bVar);
        nrVar.u(this.bq, this.dw, this.o);
        this.kj.u(new nr(nrVar.pn(), wi.fx(this.ja.u()), new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.pn.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.pn.nr.u
            public void u(boolean z) {
                pn.this.b(z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.pn.nr.u
            public void u() {
                pn.this.pb.b();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.pn.nr.u
            public void u(long j, long j2) {
                pn.this.pb.u(j, j2);
            }
        }, this.xg));
        this.kj.nr(this.ja.t());
        this.o.sx();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements u.InterfaceC0302u {
        private final int b;
        private boolean fx = false;
        private final u nr;
        private final rh pn;
        private final u.InterfaceC0302u u;

        /* JADX INFO: compiled from: SearchBox */
        public interface u {
            void u();

            void u(long j, long j2);

            void u(boolean z);
        }

        public nr(u.InterfaceC0302u interfaceC0302u, int i, u uVar, rh rhVar) {
            this.u = interfaceC0302u;
            this.nr = uVar;
            this.b = i;
            this.pn = rhVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
        public void fx() {
            u.InterfaceC0302u interfaceC0302u = this.u;
            if (interfaceC0302u != null) {
                interfaceC0302u.fx();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
        public void nr() {
            u(true);
            u.InterfaceC0302u interfaceC0302u = this.u;
            if (interfaceC0302u != null) {
                interfaceC0302u.nr();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
        public void u() {
            this.fx = false;
            u.InterfaceC0302u interfaceC0302u = this.u;
            if (interfaceC0302u != null) {
                interfaceC0302u.u();
            }
            u uVar = this.nr;
            if (uVar != null) {
                uVar.u();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
        public void u(int i, String str) {
            u(true);
            this.fx = false;
            u.InterfaceC0302u interfaceC0302u = this.u;
            if (interfaceC0302u != null) {
                interfaceC0302u.u(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
        public void u(long j, long j2) {
            this.pn.removeMessages(101);
            if (j2 > 20000 && j > Math.min(((long) this.b) * 1000, j2) * 0.75f) {
                u(false);
                this.fx = true;
            }
            u.InterfaceC0302u interfaceC0302u = this.u;
            if (interfaceC0302u != null) {
                interfaceC0302u.u(j, j2);
            }
            u uVar = this.nr;
            if (uVar != null) {
                uVar.u(j, j2);
            }
        }

        private void u(boolean z) {
            u uVar;
            if (this.fx || (uVar = this.nr) == null) {
                return;
            }
            uVar.u(z);
        }
    }

    public View u(Context context, com.bytedance.sdk.openadsdk.core.component.reward.draw.nr nrVar) {
        String strYb;
        String strValueOf;
        View viewS = com.bytedance.sdk.openadsdk.res.pn.s(context);
        RelativeLayout relativeLayout = (RelativeLayout) viewS.findViewById(2114387649);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) viewS.findViewById(2114387793);
        TextView textView = (TextView) viewS.findViewById(2114387875);
        TextView textView2 = (TextView) viewS.findViewById(2114387630);
        TextView textView3 = (TextView) viewS.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) viewS.findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(y.fx(context, 15.0f));
            tTRatingBar.setStarImageHeight(y.fx(context, 14.0f));
            tTRatingBar.setStarImagePadding(y.fx(context, 4.0f));
            tTRatingBar.u();
        }
        if (tTRoundRectImageView != null) {
            com.bytedance.sdk.openadsdk.core.kj.rh rhVarDd = nrVar.u().dd();
            if (rhVarDd != null && !TextUtils.isEmpty(rhVarDd.u())) {
                com.bytedance.sdk.openadsdk.n.nr.u(rhVarDd).to(tTRoundRectImageView);
            } else {
                q.u(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
            }
        }
        if (textView != null) {
            if (nrVar.u().pu() != null && !TextUtils.isEmpty(nrVar.u().pu().fx())) {
                textView.setText(nrVar.u().pu().fx());
            } else {
                textView.setText(nrVar.u().wf());
            }
        }
        if (textView2 != null) {
            int iIz = nrVar.u().pu() != null ? nrVar.u().pu().iz() : 6870;
            String strU = q.u(context, "tt_comment_num");
            if (iIz > 10000) {
                strValueOf = (iIz / 10000) + "万";
            } else {
                strValueOf = String.valueOf(iIz);
            }
            textView2.setText(String.format(strU, strValueOf));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(nrVar.u().yb())) {
                strYb = nrVar.u().qf() != 4 ? "查看详情" : "立即下载";
            } else {
                strYb = nrVar.u().yb();
            }
            textView3.setText(strYb);
        }
        y.u((View) relativeLayout, (View.OnClickListener) nrVar.fx(), "reward_draw_listener");
        return viewS;
    }

    private void u(Context context) {
        if (this.d) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.m = linearLayout;
            linearLayout.setClipChildren(false);
            this.m.setGravity(1);
            this.m.setOrientation(1);
            ImageView imageView = new ImageView(context);
            q.u(context, "tt_ic_back_light", imageView);
            this.m.addView(imageView, -1, -2);
            ImageView imageView2 = new ImageView(context);
            q.u(context, "tt_ic_back_light", imageView2);
            imageView2.setAlpha(0.7f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = y.fx(context, -8.0f);
            this.m.addView(imageView2, layoutParams);
            TextView textView = new TextView(context);
            textView.setGravity(1);
            textView.setTextColor(-1);
            textView.setText("上滑浏览更多内容");
            this.m.addView(textView);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 81;
            layoutParams2.bottomMargin = y.fx(context, 156.0f);
            this.sx.addView(this.m, layoutParams2);
            this.sx.setClipChildren(false);
            this.m.setVisibility(8);
            u(imageView, imageView2);
        }
    }

    private void u(View view, View view2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new u());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, y.fx(this.sx.getContext(), -5.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new u());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "translationY", y.fx(this.sx.getContext(), -6.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        this.f5230jp.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat2, objectAnimatorOfFloat4);
    }

    public void u(View view) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.nr nrVar = this.ja;
        if (nrVar == null || nrVar.fx() == null) {
            return;
        }
        this.ja.fx().onClick(view);
    }

    public void u(float f, float f2, float f3, float f4, int i) {
        FullRewardExpressView fullRewardExpressView = this.o;
        if (fullRewardExpressView == null || fullRewardExpressView.getVideoFrameLayout() == null) {
            return;
        }
        int measuredWidth = this.o.getVideoFrameLayout().getMeasuredWidth();
        int measuredHeight = this.o.getVideoFrameLayout().getMeasuredHeight();
        if (this.kj.cj()) {
            this.o.getVideoFrameLayout().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(i);
            this.o.getVideoFrameLayout().startAnimation(scaleAnimation);
        }
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what != 101) {
            return;
        }
        b(true);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.nr nrVar = this.ja;
        if (nrVar != null) {
            nrVar.x();
        }
    }

    public void u(fx.u uVar) {
        b bVar;
        this.pb = uVar;
        if (uVar == null || (bVar = this.kj) == null) {
            return;
        }
        bVar.nr(uVar.fx());
    }
}
