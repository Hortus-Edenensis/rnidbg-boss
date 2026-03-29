package com.zenmen.imageeditengine.views.cropimage;

import android.graphics.RectF;
import com.zenmen.imageeditengine.views.cropimage.CropImageView;
import com.zenmen.imageeditengine.views.cropimage.CropWindowMoveHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class d {
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f11834a = new RectF();
    public final RectF b = new RectF();
    public float k = 1.0f;
    public float l = 1.0f;

    public static boolean j(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f5 && f2 > f4 && f2 < f6;
    }

    public static boolean k(float f, float f2, float f3, float f4, float f5) {
        return Math.abs(f - f3) <= f5 && Math.abs(f2 - f4) <= f5;
    }

    public static boolean l(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f4 && Math.abs(f2 - f5) <= f6;
    }

    public static boolean m(float f, float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f - f3) <= f6 && f2 > f4 && f2 < f5;
    }

    public final boolean a() {
        return !s();
    }

    public float b() {
        return Math.min(this.f, this.j / this.l);
    }

    public float c() {
        return Math.min(this.e, this.i / this.k);
    }

    public float d() {
        return Math.max(this.d, this.h / this.l);
    }

    public float e() {
        return Math.max(this.c, this.g / this.k);
    }

    public CropWindowMoveHandler f(float f, float f2, float f3, CropImageView.CropShape cropShape) {
        CropWindowMoveHandler.Type typeG = cropShape == CropImageView.CropShape.OVAL ? g(f, f2) : i(f, f2, f3);
        if (typeG != null) {
            return new CropWindowMoveHandler(typeG, this, f, f2);
        }
        return null;
    }

    public final CropWindowMoveHandler.Type g(float f, float f2) {
        float fWidth = this.f11834a.width() / 6.0f;
        RectF rectF = this.f11834a;
        float f3 = rectF.left;
        float f4 = f3 + fWidth;
        float f5 = f3 + (fWidth * 5.0f);
        float fHeight = rectF.height() / 6.0f;
        float f6 = this.f11834a.top;
        float f7 = f6 + fHeight;
        float f8 = f6 + (fHeight * 5.0f);
        return f < f4 ? f2 < f7 ? CropWindowMoveHandler.Type.TOP_LEFT : f2 < f8 ? CropWindowMoveHandler.Type.LEFT : CropWindowMoveHandler.Type.BOTTOM_LEFT : f < f5 ? f2 < f7 ? CropWindowMoveHandler.Type.TOP : f2 < f8 ? CropWindowMoveHandler.Type.CENTER : CropWindowMoveHandler.Type.BOTTOM : f2 < f7 ? CropWindowMoveHandler.Type.TOP_RIGHT : f2 < f8 ? CropWindowMoveHandler.Type.RIGHT : CropWindowMoveHandler.Type.BOTTOM_RIGHT;
    }

    public RectF h() {
        this.b.set(this.f11834a);
        return this.b;
    }

    public final CropWindowMoveHandler.Type i(float f, float f2, float f3) {
        RectF rectF = this.f11834a;
        if (k(f, f2, rectF.left, rectF.top, f3)) {
            return CropWindowMoveHandler.Type.TOP_LEFT;
        }
        RectF rectF2 = this.f11834a;
        if (k(f, f2, rectF2.right, rectF2.top, f3)) {
            return CropWindowMoveHandler.Type.TOP_RIGHT;
        }
        RectF rectF3 = this.f11834a;
        if (k(f, f2, rectF3.left, rectF3.bottom, f3)) {
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        }
        RectF rectF4 = this.f11834a;
        if (k(f, f2, rectF4.right, rectF4.bottom, f3)) {
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
        RectF rectF5 = this.f11834a;
        if (j(f, f2, rectF5.left, rectF5.top, rectF5.right, rectF5.bottom) && a()) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        RectF rectF6 = this.f11834a;
        if (l(f, f2, rectF6.left, rectF6.right, rectF6.top, f3)) {
            return CropWindowMoveHandler.Type.TOP;
        }
        RectF rectF7 = this.f11834a;
        if (l(f, f2, rectF7.left, rectF7.right, rectF7.bottom, f3)) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        RectF rectF8 = this.f11834a;
        if (m(f, f2, rectF8.left, rectF8.top, rectF8.bottom, f3)) {
            return CropWindowMoveHandler.Type.LEFT;
        }
        RectF rectF9 = this.f11834a;
        if (m(f, f2, rectF9.right, rectF9.top, rectF9.bottom, f3)) {
            return CropWindowMoveHandler.Type.RIGHT;
        }
        RectF rectF10 = this.f11834a;
        if (!j(f, f2, rectF10.left, rectF10.top, rectF10.right, rectF10.bottom) || a()) {
            return null;
        }
        return CropWindowMoveHandler.Type.CENTER;
    }

    public void n(float f, float f2, float f3, float f4) {
        this.e = f;
        this.f = f2;
        this.k = f3;
        this.l = f4;
    }

    public void o(CropImageOptions cropImageOptions) {
        this.c = cropImageOptions.minCropWindowWidth;
        this.d = cropImageOptions.minCropWindowHeight;
        this.g = cropImageOptions.minCropResultWidth;
        this.h = cropImageOptions.minCropResultHeight;
        this.i = cropImageOptions.maxCropResultWidth;
        this.j = cropImageOptions.maxCropResultHeight;
    }

    public void p(int i, int i2) {
        this.i = i;
        this.j = i2;
    }

    public void q(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    public void r(RectF rectF) {
        this.f11834a.set(rectF);
    }

    public boolean s() {
        return this.f11834a.width() >= 100.0f && this.f11834a.height() >= 100.0f;
    }
}
