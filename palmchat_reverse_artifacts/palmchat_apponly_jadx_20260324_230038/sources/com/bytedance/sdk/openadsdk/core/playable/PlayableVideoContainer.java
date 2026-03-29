package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class PlayableVideoContainer extends FrameLayout {
    private FrameLayout b;
    private float fx;
    private View iz;
    private View.OnClickListener n;
    private float nr;
    private View pn;
    private final Paint u;
    private long x;

    public PlayableVideoContainer(Context context) {
        super(context);
        this.u = new Paint();
        this.x = 0L;
        nr();
    }

    private View b() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387593);
        textView.setText("视频异常\n无法播放");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private View fx() {
        int iFx = y.fx(getContext(), 8.0f);
        int iFx2 = y.fx(getContext(), 7.0f);
        int iFx3 = y.fx(getContext(), 5.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387593);
        textView.setText("可以\n拖动");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(getContext());
        q.u(getContext(), "tt_arrow_up", imageView);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iFx2, iFx3);
        layoutParams2.setMargins(iFx, iFx, iFx, iFx);
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, textView.getId());
        relativeLayout.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        q.u(getContext(), "tt_arrow_down", imageView2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iFx2, iFx3);
        layoutParams3.setMargins(iFx, iFx, iFx, iFx);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(imageView2, layoutParams3);
        ImageView imageView3 = new ImageView(getContext());
        q.u(getContext(), "tt_arrow_left", imageView3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iFx3, iFx2);
        layoutParams4.setMargins(iFx, iFx, iFx, iFx);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, textView.getId());
        relativeLayout.addView(imageView3, layoutParams4);
        ImageView imageView4 = new ImageView(getContext());
        q.u(getContext(), "tt_arrow_right", imageView4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iFx3, iFx2);
        layoutParams5.setMargins(iFx, iFx, iFx, iFx);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, textView.getId());
        relativeLayout.addView(imageView4, layoutParams5);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private void iz() {
        int height;
        final int height2;
        final int width;
        int width2;
        int iB = y.b(getContext());
        int iPn = y.pn(getContext());
        final int left = getLeft();
        final int top = getTop();
        int left2 = getLeft();
        int right = iB - getRight();
        int top2 = getTop();
        int bottom = iPn - getBottom();
        int iFx = y.fx(getContext(), 20.0f);
        int iMin = Math.min(Math.min(left2, right), Math.min(top2, bottom));
        if (left2 == iMin) {
            getWidth();
            int top3 = getTop();
            int bottom2 = getBottom();
            if (top3 < 0) {
                bottom2 = iFx + getHeight();
                top3 = iFx;
            }
            height2 = bottom2 > iPn ? (iPn - iFx) - getHeight() : top3;
            width = iFx;
        } else if (right == iMin) {
            width2 = (iB - iFx) - getWidth();
            int top4 = getTop();
            int bottom3 = getBottom();
            if (top4 < 0) {
                bottom3 = iFx + getHeight();
                top4 = iFx;
            }
            if (bottom3 > iPn) {
                height = (iPn - iFx) - getHeight();
                width = width2;
                height2 = height;
            } else {
                width = width2;
                height2 = top4;
            }
        } else if (top2 == iMin) {
            int left3 = getLeft();
            int right2 = getRight();
            getHeight();
            if (left3 < 0) {
                right2 = iFx + getWidth();
                left3 = iFx;
            }
            width = right2 > iB ? (iB - iFx) - getWidth() : left3;
            height2 = iFx;
        } else {
            int left4 = getLeft();
            int right3 = getRight();
            height = (iPn - iFx) - getHeight();
            if (left4 < 0) {
                right3 = iFx + getWidth();
                left4 = iFx;
            }
            if (right3 > iB) {
                width2 = (iB - iFx) - getWidth();
                width = width2;
                height2 = height;
            } else {
                height2 = height;
                width = left4;
            }
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = (int) (left + ((width - r0) * animatedFraction));
                int i2 = (int) (top + ((height2 - r1) * animatedFraction));
                PlayableVideoContainer.this.u(i, i2, PlayableVideoContainer.this.getWidth() + i, PlayableVideoContainer.this.getHeight() + i2);
            }
        });
        duration.start();
    }

    private void nr() {
        int iFx = y.fx(getContext(), 2.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setPadding(iFx, iFx, iFx, iFx);
        addView(frameLayout, -1, -1);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.b = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.pn = fx();
        frameLayout.addView(this.pn, new ViewGroup.MarginLayoutParams(-1, -1));
        this.iz = b();
        frameLayout.addView(this.iz, new ViewGroup.MarginLayoutParams(-1, -1));
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), y.fx(dw.getContext(), 12.0f));
            }
        });
        setClipToOutline(true);
    }

    private void pn() {
        View.OnClickListener onClickListener = this.n;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        this.u.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), new int[]{Color.parseColor("#FFDD42"), Color.parseColor("#FFB744") * 1}, (float[]) null, Shader.TileMode.CLAMP));
        this.u.setColor(SupportMenu.CATEGORY_MASK);
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setAntiAlias(true);
        this.u.setStrokeWidth(y.fx(getContext(), 4.0f));
        canvas.drawRoundRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), y.fx(getContext(), 12.0f), y.fx(getContext(), 12.0f), this.u);
        return zDrawChild;
    }

    public FrameLayout getVideoContainer() {
        return this.b;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                float fAbs = Math.abs(motionEvent.getX() - this.nr);
                float fAbs2 = Math.abs(motionEvent.getY() - this.fx);
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.x;
                if (fAbs < 10.0f && fAbs2 < 10.0f && jElapsedRealtime < 200) {
                    pn();
                    return true;
                }
            } else if (action == 2) {
                float x = motionEvent.getX() - this.nr;
                float y = motionEvent.getY() - this.fx;
                if (x != 0.0f && y != 0.0f) {
                    int left = (int) (getLeft() + x);
                    int top = (int) (getTop() + y);
                    u(left, top, getWidth() + left, getHeight() + top);
                }
            } else if (action == 3) {
            }
            iz();
            setPressed(false);
        } else {
            this.nr = motionEvent.getX();
            this.fx = motionEvent.getY();
            this.x = SystemClock.elapsedRealtime();
        }
        return true;
    }

    public void setCustomClickListener(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }

    public void u() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = PlayableVideoContainer.this.getLayoutParams();
                layoutParams.width = y.fx(PlayableVideoContainer.this.getContext(), 94.0f);
                layoutParams.height = y.fx(PlayableVideoContainer.this.getContext(), 167.0f);
                PlayableVideoContainer.this.setLayoutParams(layoutParams);
            }
        });
    }

    public void u(boolean z) {
        if (!z) {
            y.u(this.iz, 8);
        } else {
            y.u(this.iz, 0);
            y.u(this.pn, 8);
        }
    }

    public void u(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.gravity = 0;
        layout(i, i2, i3, i4);
    }

    public void nr(boolean z) {
        if (z) {
            y.u(this.pn, 0);
            y.u(this.iz, 8);
        } else {
            y.u(this.pn, 8);
        }
    }
}
