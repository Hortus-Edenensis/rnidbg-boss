package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lu extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19076a;
    public int b;
    public int c;

    public lu(int i, int i2, int i3) {
        this.f19076a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Paint paint2 = new Paint();
        paint2.setColor(this.f19076a);
        canvas.drawRect(f, i5 - this.b, f + paint.measureText(charSequence, i, i2), i5, paint2);
        paint.setColor(this.c);
        canvas.drawText(charSequence, i, i2, f, i4, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return Math.round(paint.measureText(charSequence, i, i2));
    }
}
