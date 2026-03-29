package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.c;
import defpackage.me1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RhythmView extends View {
    private int[] HEIGHT_CANDIDATE;
    public float MAX_VAL;
    public float MIN_VAL;
    private int PX_1DP;
    private int color;
    private long freq;
    private Paint mPaint;
    private List<a> rects;
    private float roundRadius;
    private float stripeDivider;
    private float stripeHeight;
    private float stripeWidth;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15993a;
        public float b;
        public float c;
        public float d;
        public float e;

        public float b() {
            if (this.f15993a == 0) {
                float f = this.b;
                if (f <= RhythmView.this.MIN_VAL) {
                    this.b = f + r1.PX_1DP;
                    this.f15993a = 1;
                } else {
                    this.b = f - r1.PX_1DP;
                }
                return this.b;
            }
            float f2 = this.b;
            if (f2 >= RhythmView.this.MAX_VAL) {
                this.b = f2 - r1.PX_1DP;
                this.f15993a = 0;
            } else {
                this.b = f2 + r1.PX_1DP;
            }
            return this.b;
        }

        public a() {
            this.f15993a = 1;
            this.b = RhythmView.this.MIN_VAL;
        }
    }

    public RhythmView(Context context) {
        this(context, null);
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.color);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.rects.clear();
        for (int i = 0; i < 3; i++) {
            a aVar = new a();
            float f = this.stripeDivider;
            float f2 = this.stripeWidth;
            float f3 = i * (f + f2);
            int i2 = this.PX_1DP;
            float f4 = (f3 * i2) + (i2 / 2);
            aVar.c = f4;
            aVar.d = f4 + (f2 * i2);
            aVar.e = this.stripeHeight * i2;
            aVar.b = this.HEIGHT_CANDIDATE[i] * i2;
            aVar.f15993a = new Random().nextInt() % 2;
            this.rects.add(aVar);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (a aVar : this.rects) {
            float f = aVar.c;
            float fB = aVar.b();
            float f2 = aVar.d;
            float f3 = aVar.e;
            float f4 = this.roundRadius;
            int i = this.PX_1DP;
            canvas.drawRoundRect(f, fB, f2, f3, i * f4, f4 * i, this.mPaint);
        }
        postInvalidateDelayed(this.freq);
    }

    public RhythmView setCandidate(int[] iArr) {
        this.HEIGHT_CANDIDATE = iArr;
        return this;
    }

    public RhythmView setColor(int i) {
        this.color = i;
        return this;
    }

    public RhythmView setFreq(long j) {
        this.freq = j;
        return this;
    }

    public RhythmView setMaxHeight(float f) {
        this.MAX_VAL = f * this.PX_1DP;
        return this;
    }

    public RhythmView setMinHeight(float f) {
        this.MIN_VAL = f * this.PX_1DP;
        return this;
    }

    public RhythmView setRoundRadius(float f) {
        this.roundRadius = f;
        return this;
    }

    public RhythmView setStripe(float f, float f2, float f3) {
        this.stripeWidth = f;
        this.stripeHeight = f2;
        this.stripeDivider = f3;
        return this;
    }

    public RhythmView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RhythmView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public RhythmView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int iB = me1.b(c.b(), 1);
        this.PX_1DP = iB;
        this.MAX_VAL = iB * 7;
        this.MIN_VAL = iB;
        this.HEIGHT_CANDIDATE = new int[]{9, 3, 6};
        this.rects = new ArrayList();
        this.stripeWidth = 1.0f;
        this.stripeHeight = 10.0f;
        this.stripeDivider = 4.0f;
        this.roundRadius = this.PX_1DP;
        this.color = -1;
        this.freq = 60L;
        init();
    }
}
