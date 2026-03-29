package com.amap.api.col.p0002sl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.TextOptions;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class by implements as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f2664a;
    private bc b;
    private String c;
    private int d;
    private int e;
    private LatLng f;
    private float g;
    private int h;
    private Typeface i;
    private boolean j;
    private float k;
    private int l;
    private int m;
    private Object n;
    private int o;

    public by(ah ahVar, TextOptions textOptions, bc bcVar) {
        this.b = bcVar;
        this.c = textOptions.getText();
        this.d = textOptions.getFontSize();
        this.e = textOptions.getFontColor();
        this.f = textOptions.getPosition();
        this.g = textOptions.getRotate();
        this.h = textOptions.getBackgroundColor();
        this.i = textOptions.getTypeface();
        this.j = textOptions.isVisible();
        this.k = textOptions.getZIndex();
        this.l = textOptions.getAlignX();
        this.m = textOptions.getAlignY();
        this.n = textOptions.getObject();
        this.f2664a = (m) ahVar;
    }

    @Override // com.amap.api.interfaces.IText
    public final void draw(Canvas canvas) {
        int i;
        float f;
        float f2;
        if (TextUtils.isEmpty(this.c) || this.f == null) {
            return;
        }
        TextPaint textPaint = new TextPaint();
        if (this.i == null) {
            this.i = Typeface.DEFAULT;
        }
        textPaint.setTypeface(this.i);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(this.d);
        float fMeasureText = textPaint.measureText(this.c);
        float f3 = this.d;
        textPaint.setColor(this.h);
        LatLng latLng = this.f;
        af afVar = new af((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
        Point point = new Point();
        this.f2664a.c().a(afVar, point);
        canvas.save();
        canvas.rotate(-(this.g % 360.0f), point.x, point.y);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        int i2 = this.l;
        if (i2 <= 0 || i2 > 3) {
            this.l = 3;
        }
        int i3 = this.m;
        if (i3 < 4 || i3 > 6) {
            this.m = 6;
        }
        int i4 = this.l;
        int i5 = 0;
        if (i4 != 1) {
            if (i4 == 2) {
                f2 = point.x - fMeasureText;
            } else if (i4 != 3) {
                i = 0;
            } else {
                f2 = point.x - (fMeasureText / 2.0f);
            }
            i = (int) f2;
        } else {
            i = point.x;
        }
        int i6 = this.m;
        if (i6 != 4) {
            if (i6 == 5) {
                f = point.y - f3;
            } else if (i6 == 6) {
                f = point.y - (f3 / 2.0f);
            }
            i5 = (int) f;
        } else {
            i5 = point.y;
        }
        float f4 = i;
        float f5 = i5 + f3 + 2.0f;
        canvas.drawRect(i - 1, i5 - 1, f4 + fMeasureText + 2.0f, f5, textPaint);
        textPaint.setColor(this.e);
        canvas.drawText(this.c, f4, f5 - fontMetrics.bottom, textPaint);
        canvas.restore();
    }

    @Override // com.amap.api.col.p0002sl.al
    public final int getAddIndex() {
        return this.o;
    }

    @Override // com.amap.api.interfaces.IText
    public final int getAlignX() {
        return this.l;
    }

    @Override // com.amap.api.interfaces.IText
    public final int getAlignY() {
        return this.m;
    }

    @Override // com.amap.api.interfaces.IText
    public final int getBackgroundColor() {
        return this.h;
    }

    @Override // com.amap.api.interfaces.IText
    public final int getFonrColor() {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IText
    public final int getFontSize() {
        return this.d;
    }

    @Override // com.amap.api.interfaces.IText
    public final Object getObject() {
        return this.n;
    }

    @Override // com.amap.api.interfaces.IText
    public final LatLng getPosition() {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IText
    public final float getRotate() {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IText
    public final String getText() {
        return this.c;
    }

    @Override // com.amap.api.interfaces.IText
    public final Typeface getTypeface() {
        return this.i;
    }

    @Override // com.amap.api.col.p0002sl.al, com.amap.api.interfaces.IMarker
    public final float getZIndex() {
        return this.k;
    }

    @Override // com.amap.api.interfaces.IText
    public final boolean isVisible() {
        return this.j;
    }

    @Override // com.amap.api.interfaces.IText
    public final void remove() {
        bc bcVar = this.b;
        if (bcVar != null) {
            bcVar.b(this);
        }
    }

    @Override // com.amap.api.col.p0002sl.al
    public final void setAddIndex(int i) {
        this.o = i;
    }

    @Override // com.amap.api.interfaces.IText
    public final void setAlign(int i, int i2) {
        this.l = i;
        this.m = i2;
        this.f2664a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public final void setBackgroundColor(int i) {
        this.h = i;
        this.f2664a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public final void setFontColor(int i) {
        this.e = i;
        this.f2664a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public final void setFontSize(int i) {
        this.d = i;
        this.f2664a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public final void setObject(Object obj) {
        this.n = obj;
    }

    @Override // com.amap.api.interfaces.IText
    public final void setPosition(LatLng latLng) {
        this.f = latLng;
        this.f2664a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public final void setRotate(float f) {
        this.g = f;
        this.f2664a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public final void setText(String str) {
        this.c = str;
        this.f2664a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public final void setTypeface(Typeface typeface) {
        this.i = typeface;
        this.f2664a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public final void setVisible(boolean z) {
        this.j = z;
        this.f2664a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IText
    public final void setZIndex(float f) {
        this.k = f;
        this.b.d();
    }
}
