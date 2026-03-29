package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.u.fx.b;
import com.bytedance.sdk.component.widget.recycler.u.fx.fx;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.xg;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RewardJointBottomView extends FrameLayout implements fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5247a;
    private SSWebView b;
    private int[] fx;
    private int iz;
    private final SlideUpLoadMoreArrow jk;
    private boolean n;
    private int[] nr;
    private b pn;
    private float u;
    private View.OnClickListener x;

    public RewardJointBottomView(Context context, bc bcVar) {
        super(context);
        this.nr = new int[2];
        this.fx = new int[2];
        this.iz = 0;
        this.n = false;
        this.f5247a = false;
        SSWebView sSWebView = new SSWebView(context);
        this.b = sSWebView;
        sSWebView.setMaterialMeta(xg.u(bcVar));
        this.b.setWebViewClient(null);
        addView(this.b, new ViewGroup.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 23) {
            this.b.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (Math.abs((RewardJointBottomView.this.b.getWebView().getHeight() + RewardJointBottomView.this.b.getWebView().getScrollY()) - (RewardJointBottomView.this.b.getWebView().getContentHeight() * RewardJointBottomView.this.b.getWebView().getScale())) >= 10.0f) {
                        RewardJointBottomView.this.n = false;
                    } else {
                        if (RewardJointBottomView.this.n) {
                            return;
                        }
                        RewardJointBottomView.this.n = true;
                    }
                }
            });
        }
        getScrollingChildHelper().u(true);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = new SlideUpLoadMoreArrow(getContext(), 36, true);
        this.jk = slideUpLoadMoreArrow;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        addView(slideUpLoadMoreArrow, layoutParams);
        slideUpLoadMoreArrow.u();
    }

    private b getScrollingChildHelper() {
        if (this.pn == null) {
            this.pn = new b(this);
        }
        return this.pn;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return super.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return super.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.iz = 0;
            this.u = motionEvent.getY();
            u(2, 0);
            this.f5247a = this.n;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.u;
                if (y < 0.0f) {
                    u();
                    if (u(0, (int) y, this.nr, this.fx, 0)) {
                        y -= this.nr[1];
                    }
                    this.iz += u((int) ((Math.floor((double) Math.abs(y)) != 0.0d ? y : 0.0f) - this.iz));
                } else {
                    int i = (int) (y - this.iz);
                    int iU = u(i);
                    this.iz += iU;
                    u(0, i - iU, this.nr, this.fx, 0);
                }
            }
        } else if (this.f5247a && this.u - motionEvent.getY() > 100.0f && (onClickListener = this.x) != null) {
            onClickListener.onClick(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public SSWebView getWebView() {
        return this.b;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void nr() {
        u();
    }

    public void u(String str) {
        this.b.loadUrl(str);
    }

    public boolean u(int i, int i2) {
        return getScrollingChildHelper().nr(0);
    }

    public boolean u(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().u(i, i2, iArr, iArr2, i3);
    }

    public int u(int i) {
        if (i < 0) {
            return (int) (-Math.abs(Math.min(this.b.getWebView().getContentHeight() - (this.b.getWebView().getHeight() + this.b.getWebView().getScrollY()), -i)));
        }
        if (i > 0) {
            return Math.min(this.b.getWebView().getScrollY(), i);
        }
        return 0;
    }

    public void u() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.jk;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.setVisibility(8);
            this.jk.nr();
        }
    }
}
