package com.beizi.fusion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.beizi.fusion.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class CircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f4766a;
    private Paint b;
    private Paint c;
    private Paint d;
    private int e;
    private int f;
    private int g;
    private int h;
    private float i;
    private float j;
    private float k;
    private int l;
    private int m;
    private float n;
    private float o;
    private int p;
    private int q;
    private float r;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BeiZiCircleProgressViewStyle, 0, 0);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float fApplyDimension = TypedValue.applyDimension(1, 18.0f, displayMetrics);
        float fApplyDimension2 = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        this.r = TypedValue.applyDimension(1, 50.0f, displayMetrics);
        this.i = typedArrayObtainStyledAttributes.getDimension(R.styleable.BeiZiCircleProgressViewStyle_adScopeRadius, fApplyDimension);
        this.k = typedArrayObtainStyledAttributes.getDimension(R.styleable.BeiZiCircleProgressViewStyle_adScopeStrokeWidth, fApplyDimension2);
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeCircleColor, 0);
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeRingColor, -41216);
        this.g = typedArrayObtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeTextColor, -1);
        this.h = typedArrayObtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeRingBgColor, 1589427388);
        this.j = this.i + (this.k / 2.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.l = getWidth() / 2;
        int height = getHeight() / 2;
        this.m = height;
        canvas.drawCircle(this.l, height, this.i, this.f4766a);
        RectF rectF = new RectF();
        int i = this.l;
        float f = this.j;
        rectF.left = i - f;
        int i2 = this.m;
        rectF.top = i2 - f;
        rectF.right = (f * 2.0f) + (i - f);
        rectF.bottom = (f * 2.0f) + (i2 - f);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.c);
        if (this.q > 0) {
            RectF rectF2 = new RectF();
            int i3 = this.l;
            float f2 = this.j;
            rectF2.left = i3 - f2;
            int i4 = this.m;
            rectF2.top = i4 - f2;
            rectF2.right = (f2 * 2.0f) + (i3 - f2);
            rectF2.bottom = (f2 * 2.0f) + (i4 - f2);
            canvas.drawArc(rectF2, -90.0f, (this.q / this.p) * 360.0f, false, this.b);
            float fMeasureText = this.d.measureText("跳过", 0, 2);
            this.n = fMeasureText;
            canvas.drawText("跳过", this.l - (fMeasureText / 2.0f), this.m + (this.o / 4.0f), this.d);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = (int) (getPaddingLeft() + this.r + getPaddingRight());
        }
        if (mode2 != 1073741824) {
            size2 = (int) (getPaddingTop() + this.r + getPaddingBottom());
        }
        setMeasuredDimension(size, size2);
    }

    public void setProgress(int i) {
        this.q = i;
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 100;
        a(context, attributeSet);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f4766a = paint;
        paint.setAntiAlias(true);
        this.f4766a.setColor(this.e);
        this.f4766a.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setAntiAlias(true);
        this.c.setColor(this.h);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.k);
        Paint paint3 = new Paint();
        this.b = paint3;
        paint3.setAntiAlias(true);
        this.b.setColor(this.f);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.k);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint4 = new Paint();
        this.d = paint4;
        paint4.setAntiAlias(true);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(this.g);
        this.d.setTextSize((this.i * 3.0f) / 5.0f);
        this.d.setShadowLayer(2.0f, 1.0f, 1.0f, Color.parseColor("#000000"));
        Paint.FontMetrics fontMetrics = this.d.getFontMetrics();
        this.o = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }
}
