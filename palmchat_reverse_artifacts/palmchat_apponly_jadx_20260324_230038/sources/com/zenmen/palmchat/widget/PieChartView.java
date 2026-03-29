package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PieChartView extends View {
    public static final int NO_HIGHLIGHT_BLOCK = -1;
    public static final float START_ANGLE_OFFSET = -90.0f;
    private a[] mBlocks;
    private int mHighlightBlockIndex;
    private int mSteps;
    private float mTotalSweepAngle;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15988a;
        public long b;
        public float c;
        public float d;

        public a(int i, long j) {
            this.f15988a = i;
            this.b = j;
        }
    }

    public PieChartView(Context context) {
        super(context);
        this.mHighlightBlockIndex = -1;
        this.mTotalSweepAngle = 1.0f;
        this.mSteps = 1;
    }

    private RectF createRect(Canvas canvas, boolean z) {
        int i = (int) (getContext().getResources().getDisplayMetrics().density * (z ? 2.0f : 6.0f));
        int i2 = i * 2;
        int width = canvas.getWidth() - i2;
        int height = canvas.getHeight() - i2;
        if (width < height) {
            int i3 = width / 2;
            int i4 = height / 2;
            return new RectF(i, (i4 - i3) + i, width + i, i4 + i3 + i);
        }
        int i5 = height / 2;
        int i6 = width / 2;
        return new RectF((i6 - i5) + i, i, i6 + i5 + i, height + i);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF;
        float f;
        float f2;
        a[] aVarArr = this.mBlocks;
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        int i = 0;
        int i2 = 0;
        while (true) {
            a[] aVarArr2 = this.mBlocks;
            if (i2 >= aVarArr2.length) {
                rectF = null;
                f = 0.0f;
                f2 = 0.0f;
                break;
            } else if (this.mTotalSweepAngle <= (aVarArr2[i2].c + this.mBlocks[i2].d) - (-90.0f)) {
                RectF rectFCreateRect = createRect(canvas, i2 == this.mHighlightBlockIndex);
                i = this.mBlocks[i2].f15988a;
                float f3 = this.mBlocks[i2].c;
                f2 = this.mTotalSweepAngle - (this.mBlocks[i2].c - (-90.0f));
                f = f3;
                rectF = rectFCreateRect;
            } else {
                paint.setColor(this.mBlocks[i2].f15988a);
                canvas.drawArc(createRect(canvas, i2 == this.mHighlightBlockIndex), this.mBlocks[i2].c, this.mBlocks[i2].d, true, paint);
                i2++;
            }
        }
        if (rectF != null) {
            paint.setColor(i);
            canvas.drawArc(rectF, f, f2, true, paint);
        }
        float f4 = this.mTotalSweepAngle;
        if (f4 < 360.0f) {
            this.mTotalSweepAngle = f4 + this.mSteps;
            invalidate();
        }
    }

    public void reset() {
        this.mTotalSweepAngle = 1.0f;
        invalidate();
    }

    public void setBlocks(a[] aVarArr, int i) {
        this.mBlocks = aVarArr;
        this.mHighlightBlockIndex = i;
        this.mTotalSweepAngle = 1.0f;
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        int i2 = 0;
        long j = 0;
        int i3 = 0;
        while (true) {
            a[] aVarArr2 = this.mBlocks;
            if (i3 >= aVarArr2.length) {
                break;
            }
            j += aVarArr2[i3].b;
            i3++;
        }
        float f = -90.0f;
        while (true) {
            a[] aVarArr3 = this.mBlocks;
            if (i2 >= aVarArr3.length) {
                return;
            }
            aVarArr3[i2].c = f;
            this.mBlocks[i2].d = (float) ((r2.b * 360) / j);
            f += this.mBlocks[i2].d;
            i2++;
        }
    }

    public void setSteps(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.mSteps = i;
    }

    public PieChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHighlightBlockIndex = -1;
        this.mTotalSweepAngle = 1.0f;
        this.mSteps = 1;
    }

    public PieChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHighlightBlockIndex = -1;
        this.mTotalSweepAngle = 1.0f;
        this.mSteps = 1;
    }
}
