package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class CycleCountDownView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f5375a;
    protected float b;
    private final Rect bf;
    private ValueAnimator bg;
    private ValueAnimator bq;
    private boolean c;
    private final RectF d;
    private boolean dw;
    protected int fx;
    private boolean gi;
    private final Rect h;
    protected int iz;
    private final Rect ja;
    protected int jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private String f5376jp;
    private Paint k;
    private Bitmap kj;
    private Paint l;
    private String m;
    private Paint mv;
    private float my;
    protected float n;
    protected int nr;
    private AnimatorSet o;
    private float pb;
    protected float pn;
    private Bitmap q;
    private Bitmap qq;
    private final Rect rh;
    private Paint s;
    private ValueAnimator sx;
    private boolean t;
    protected int u;
    private final Rect wq;
    protected boolean x;
    private String xg;
    private String y;
    private boolean z;

    public CycleCountDownView(Context context) {
        super(context);
        this.u = Color.parseColor("#FFDA7B");
        this.nr = Color.parseColor("#4D000000");
        this.fx = Color.parseColor("#ffffff");
        this.iz = 270;
        this.x = false;
        this.n = 5.0f;
        this.f5375a = 0.0f;
        this.jk = 0;
        this.t = false;
        this.my = 0.0f;
        this.dw = false;
        this.c = false;
        this.z = false;
        this.gi = false;
        this.d = new RectF();
        this.h = new Rect();
        this.rh = new Rect();
        this.ja = new Rect();
        this.bf = new Rect();
        this.wq = new Rect();
        this.pb = 1.0f;
        this.b = u(4.0f);
        this.pn = u(34.0f);
        this.iz %= 360;
        nr();
        fx();
        setBackgroundColor(-16711681);
    }

    private int b() {
        return (int) ((((this.b / 2.0f) + this.pn) * 2.0f) + u(4.0f));
    }

    private void fx() {
        this.q = q.b(getContext(), "tt_reward_chest_gift2");
        this.qq = q.b(getContext(), "tt_reward_chest_gift_open2");
        this.kj = u(getContext(), "tt_reward_chest_btn_bg");
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.bg;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.bg = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.my, this.pb);
        this.bg = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.bg.setDuration(1000L);
        this.bg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.CycleCountDownView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleCountDownView.this.my = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleCountDownView.this.postInvalidate();
            }
        });
        return this.bg;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.o;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.o = null;
            }
            ValueAnimator valueAnimator = this.bq;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.bq = null;
            }
            ValueAnimator valueAnimator2 = this.sx;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.sx = null;
            }
            ValueAnimator valueAnimator3 = this.bg;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.bg = null;
            }
            this.my = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        u(canvas);
        fx(canvas);
        nr(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = b();
        }
        if (mode2 != 1073741824) {
            size2 = b();
        }
        u(size, size2);
        setMeasuredDimension(size, size2);
        RectF rectF = this.d;
        float f = this.pn;
        rectF.left = -f;
        rectF.right = f;
        rectF.top = -f;
        rectF.bottom = f;
        Rect rect = this.h;
        rect.left = 0;
        rect.top = 0;
        Bitmap bitmap = this.q;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.h;
        Bitmap bitmap2 = this.q;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
        Rect rect3 = this.rh;
        rect3.left = 0;
        rect3.top = 0;
        Bitmap bitmap3 = this.qq;
        rect3.right = bitmap3 != null ? bitmap3.getWidth() : 0;
        Rect rect4 = this.rh;
        Bitmap bitmap4 = this.qq;
        rect4.bottom = bitmap4 != null ? bitmap4.getHeight() : 0;
        int minLine = getMinLine();
        Rect rect5 = this.ja;
        int i3 = -minLine;
        int i4 = i3 / 2;
        rect5.left = i4;
        rect5.top = i4;
        int i5 = minLine / 2;
        rect5.right = i5;
        rect5.bottom = i5;
        Rect rect6 = this.bf;
        rect6.left = 0;
        rect6.top = 0;
        rect6.right = this.kj.getWidth();
        this.bf.bottom = this.kj.getHeight();
        Rect rect7 = this.wq;
        rect7.left = i3 / 3;
        rect7.top = minLine / 8;
        int i6 = minLine / 3;
        rect7.right = i6;
        rect7.bottom = i6;
        this.s.setTextSize(((i6 - r0) / 2) - nr(2.0f));
    }

    public void setBoxFinish(Bitmap bitmap) {
        this.qq = bitmap;
        this.gi = true;
        Rect rect = this.rh;
        rect.left = 0;
        rect.top = 0;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.rh;
        Bitmap bitmap2 = this.qq;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
    }

    public void setBoxImage(Bitmap bitmap) {
        this.q = bitmap;
        this.z = true;
        Rect rect = this.h;
        rect.left = 0;
        rect.top = 0;
        rect.right = bitmap != null ? bitmap.getWidth() : 0;
        Rect rect2 = this.h;
        Bitmap bitmap2 = this.q;
        rect2.bottom = bitmap2 != null ? bitmap2.getHeight() : 0;
    }

    public void setCanSkip(boolean z) {
        this.t = z;
    }

    private void nr() {
        Paint paint = new Paint(1);
        this.l = paint;
        paint.setColor(this.u);
        this.l.setStrokeWidth(this.b);
        this.l.setAntiAlias(true);
        this.l.setStrokeCap(Paint.Cap.ROUND);
        this.l.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.mv = paint2;
        paint2.setColor(this.nr);
        this.mv.setAntiAlias(true);
        this.mv.setStrokeWidth(this.b);
        this.mv.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.s = paint3;
        paint3.setColor(this.fx);
        this.s.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint(1);
        this.k = paint4;
        paint4.setFilterBitmap(true);
        this.k.setDither(true);
    }

    private void fx(Canvas canvas) {
        float f;
        canvas.save();
        float f2 = this.my * 360.0f;
        if (this.x) {
            f = this.iz - f2;
        } else {
            f = this.iz;
        }
        canvas.drawCircle(0.0f, 0.0f, this.pn, this.mv);
        canvas.drawArc(this.d, f, f2, false, this.l);
        canvas.restore();
    }

    private void u(int i, int i2) {
        this.pn = (Math.min(i, i2) / 2.0f) - this.b;
    }

    private void u(Canvas canvas) {
        Bitmap bitmap;
        canvas.save();
        boolean z = false;
        if (this.jk <= 0 && (bitmap = this.qq) != null) {
            boolean z2 = this.z;
            if (!(z2 && this.gi) && (z2 || this.gi)) {
                bitmap = this.q;
            } else {
                z = true;
            }
        } else {
            bitmap = this.q;
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, z ? this.rh : this.h, this.ja, this.k);
        }
        canvas.restore();
    }

    private float u(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void u() {
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.o.cancel();
            this.o = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.o = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.o.setInterpolator(new LinearInterpolator());
        this.o.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.CycleCountDownView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleCountDownView.this.dw = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleCountDownView.this.dw) {
                    CycleCountDownView.this.dw = false;
                } else {
                    CycleCountDownView.this.c = true;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.o.start();
    }

    private void nr(Canvas canvas) {
        String str;
        canvas.save();
        canvas.drawBitmap(this.kj, this.bf, this.wq, this.k);
        Paint.FontMetrics fontMetrics = this.s.getFontMetrics();
        float f = (fontMetrics.bottom - fontMetrics.top) / 2.0f;
        if (TextUtils.isEmpty(this.y)) {
            str = this.xg + this.jk + this.m;
        } else if (this.jk <= 0) {
            str = this.y;
        } else {
            str = this.xg + this.jk + this.m;
        }
        if (this.t) {
            str = str + "｜" + this.f5376jp;
        }
        canvas.drawText(str, 0.0f, ((getMinLine() / 3.0f) - (getMinLine() / 9.0f)) + (f / 2.0f), this.s);
        canvas.restore();
    }

    public void u(int i, int i2, int i3) {
        float f = i;
        this.n = f;
        float f2 = i2;
        this.f5375a = f2;
        this.jk = i3;
        this.pb = f2 / f;
        u();
    }

    private Bitmap u(Context context, String str) {
        Drawable drawableFx = q.fx(context, str);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableFx.getIntrinsicWidth(), drawableFx.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableFx.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableFx.draw(canvas);
        return bitmapCreateBitmap;
    }

    private float nr(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public void u(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.xg = str;
        this.m = TextUtils.isEmpty(str2) ? "" : str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "跳过";
        }
        this.f5376jp = str3;
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        }
        this.y = str4;
    }
}
