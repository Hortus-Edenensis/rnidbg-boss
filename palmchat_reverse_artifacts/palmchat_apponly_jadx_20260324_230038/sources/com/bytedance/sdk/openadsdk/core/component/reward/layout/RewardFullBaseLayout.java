package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RewardFullBaseLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FrameLayout f5235a;
    long b;
    float fx;
    private FrameLayout iz;
    private FrameLayout jk;
    private int k;
    private FrameLayout l;
    private FrameLayout mv;
    private int my;
    private FrameLayout n;
    protected TTProgressBar nr;
    private int o;
    u pn;
    private int s;
    private FrameLayout t;
    protected TTProgressBar u;
    private FrameLayout x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();
    }

    public RewardFullBaseLayout(Context context) {
        super(context);
    }

    private FrameLayout b() {
        FrameLayout frameLayoutPn = pn();
        this.jk = frameLayoutPn;
        return frameLayoutPn;
    }

    private FrameLayout fx() {
        FrameLayout frameLayoutPn = pn();
        this.f5235a = frameLayoutPn;
        return frameLayoutPn;
    }

    private FrameLayout nr() {
        this.mv = pn();
        FrameLayout frameLayoutPn = pn();
        this.l = frameLayoutPn;
        this.mv.addView(frameLayoutPn);
        FrameLayout frameLayoutPn2 = pn();
        this.x = frameLayoutPn2;
        frameLayoutPn2.setVisibility(8);
        this.l.addView(this.x);
        FrameLayout frameLayoutPn3 = pn();
        this.n = frameLayoutPn3;
        frameLayoutPn3.setVisibility(8);
        this.l.addView(this.n);
        this.t = pn();
        return this.mv;
    }

    private FrameLayout pn() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public FrameLayout getEasyPlayableContainer() {
        return this.t;
    }

    public FrameLayout getEndCardFrameContainer() {
        return this.f5235a;
    }

    public FrameLayout getExpressFrameContainer() {
        return this.n;
    }

    public FrameLayout getSceneFrame() {
        return this.l;
    }

    public FrameLayout getSceneFrameContainer() {
        return this.mv;
    }

    public FrameLayout getTopFrameContainer() {
        return this.jk;
    }

    public FrameLayout getWidgetFrameContainer() {
        return this.x;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.pn == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.fx = motionEvent.getY();
            this.b = System.currentTimeMillis();
        } else if (action == 1) {
            float y = motionEvent.getY();
            float f = this.fx;
            if (y < f && Math.abs(y - f) > y.fx(getContext(), 30.0f)) {
                this.pn.u();
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void u(com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar) {
        FrameLayout frameLayoutPn = pn();
        this.iz = frameLayoutPn;
        frameLayoutPn.setPadding(this.s, this.k, this.my, this.o);
        this.iz.setClipChildren(false);
        this.iz.addView(nr());
        this.iz.addView(fx());
        this.iz.addView(b());
        addView(this.iz);
        this.x.addView(uVar.a());
        this.f5235a.addView(uVar.jk());
        this.jk.addView(uVar.t());
    }

    public void u(int i) {
        if (this.u == null) {
            this.u = new TTProgressBar(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.u.setLayoutParams(layoutParams);
            try {
                this.u.setIndeterminateDrawable(q.fx(getContext(), "tt_video_loading_progress_bar"));
            } catch (Throwable unused) {
            }
            addView(this.u);
        }
        this.u.setVisibility(i);
    }

    public void u(int i, TTProgressBar tTProgressBar) {
        TTProgressBar tTProgressBar2 = this.nr;
        if (tTProgressBar2 != null) {
            tTProgressBar2.setVisibility(8);
            removeView(this.nr);
        }
        if (tTProgressBar == null) {
            return;
        }
        this.nr = tTProgressBar;
        addView(tTProgressBar);
        this.nr.setVisibility(i);
    }

    public void u(u uVar) {
        this.pn = uVar;
    }

    public void u() {
        this.pn = null;
    }

    public void u(int i, int i2, int i3, int i4) {
        this.s = i;
        this.k = i2;
        this.my = i3;
        this.o = i4;
    }
}
