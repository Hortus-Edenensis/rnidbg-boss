package com.zenmen.imageeditengine.views.cropimage;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class CropWindowMoveHandler {
    public static final Matrix g = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f11825a;
    public final float b;
    public final float c;
    public final float d;
    public final Type e;
    public final PointF f = new PointF();

    /* JADX INFO: compiled from: SearchBox */
    public enum Type {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11826a;

        static {
            int[] iArr = new int[Type.values().length];
            f11826a = iArr;
            try {
                iArr[Type.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11826a[Type.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11826a[Type.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11826a[Type.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11826a[Type.LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11826a[Type.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11826a[Type.RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11826a[Type.BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11826a[Type.CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public CropWindowMoveHandler(Type type, d dVar, float f, float f2) {
        this.e = type;
        this.f11825a = dVar.e();
        this.b = dVar.d();
        this.c = dVar.c();
        this.d = dVar.b();
        l(dVar.h(), f, f2);
    }

    public static float k(float f, float f2, float f3, float f4) {
        return (f3 - f) / (f4 - f2);
    }

    public final void a(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = i;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            this.f.y -= (f - f4) / 1.1f;
        }
        float f5 = rectF2.bottom;
        if (f > f5) {
            this.f.y -= (f - f5) / 2.0f;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        float f6 = rectF.top;
        float f7 = f - f6;
        float f8 = this.b;
        if (f7 < f8) {
            f = f6 + f8;
        }
        float f9 = f - f6;
        float f10 = this.d;
        if (f9 > f10) {
            f = f6 + f10;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        if (f3 > 0.0f) {
            float f11 = (f - f6) * f3;
            float f12 = this.f11825a;
            if (f11 < f12) {
                f = Math.min(f5, f6 + (f12 / f3));
                f11 = (f - rectF.top) * f3;
            }
            float f13 = this.c;
            if (f11 > f13) {
                f = Math.min(rectF2.bottom, rectF.top + (f13 / f3));
                f11 = (f - rectF.top) * f3;
            }
            if (z && z2) {
                f = Math.min(f, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f3)));
            } else {
                if (z) {
                    float f14 = rectF.right;
                    float f15 = f14 - f11;
                    float f16 = rectF2.left;
                    if (f15 < f16) {
                        f = Math.min(rectF2.bottom, rectF.top + ((f14 - f16) / f3));
                        f11 = (f - rectF.top) * f3;
                    }
                }
                if (z2) {
                    float f17 = rectF.left;
                    float f18 = f11 + f17;
                    float f19 = rectF2.right;
                    if (f18 > f19) {
                        f = Math.min(f, Math.min(rectF2.bottom, rectF.top + ((f19 - f17) / f3)));
                    }
                }
            }
        }
        rectF.bottom = f;
    }

    public final void b(RectF rectF, float f) {
        rectF.bottom = rectF.top + (rectF.width() / f);
    }

    public final void c(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            this.f.x -= f / 1.1f;
        }
        float f4 = rectF2.left;
        if (f < f4) {
            this.f.x -= (f - f4) / 2.0f;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        float f5 = rectF.right;
        float f6 = f5 - f;
        float f7 = this.f11825a;
        if (f6 < f7) {
            f = f5 - f7;
        }
        float f8 = f5 - f;
        float f9 = this.c;
        if (f8 > f9) {
            f = f5 - f9;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        if (f3 > 0.0f) {
            float f10 = (f5 - f) / f3;
            float f11 = this.b;
            if (f10 < f11) {
                f = Math.max(f4, f5 - (f11 * f3));
                f10 = (rectF.right - f) / f3;
            }
            float f12 = this.d;
            if (f10 > f12) {
                f = Math.max(rectF2.left, rectF.right - (f12 * f3));
                f10 = (rectF.right - f) / f3;
            }
            if (z && z2) {
                f = Math.max(f, Math.max(rectF2.left, rectF.right - (rectF2.height() * f3)));
            } else {
                if (z) {
                    float f13 = rectF.bottom;
                    float f14 = f13 - f10;
                    float f15 = rectF2.top;
                    if (f14 < f15) {
                        f = Math.max(rectF2.left, rectF.right - ((f13 - f15) * f3));
                        f10 = (rectF.right - f) / f3;
                    }
                }
                if (z2) {
                    float f16 = rectF.top;
                    float f17 = f10 + f16;
                    float f18 = rectF2.bottom;
                    if (f17 > f18) {
                        f = Math.max(f, Math.max(rectF2.left, rectF.right - ((f18 - f16) * f3)));
                    }
                }
            }
        }
        rectF.left = f;
    }

    public final void d(RectF rectF, float f) {
        rectF.left = rectF.right - (rectF.height() * f);
    }

    public final void e(RectF rectF, RectF rectF2, float f) {
        rectF.inset((rectF.width() - (rectF.height() * f)) / 2.0f, 0.0f);
        float f2 = rectF.left;
        float f3 = rectF2.left;
        if (f2 < f3) {
            rectF.offset(f3 - f2, 0.0f);
        }
        float f4 = rectF.right;
        float f5 = rectF2.right;
        if (f4 > f5) {
            rectF.offset(f5 - f4, 0.0f);
        }
    }

    public final void f(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = i;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            this.f.x -= (f - f4) / 1.1f;
        }
        float f5 = rectF2.right;
        if (f > f5) {
            this.f.x -= (f - f5) / 2.0f;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        float f6 = rectF.left;
        float f7 = f - f6;
        float f8 = this.f11825a;
        if (f7 < f8) {
            f = f6 + f8;
        }
        float f9 = f - f6;
        float f10 = this.c;
        if (f9 > f10) {
            f = f6 + f10;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        if (f3 > 0.0f) {
            float f11 = (f - f6) / f3;
            float f12 = this.b;
            if (f11 < f12) {
                f = Math.min(f5, f6 + (f12 * f3));
                f11 = (f - rectF.left) / f3;
            }
            float f13 = this.d;
            if (f11 > f13) {
                f = Math.min(rectF2.right, rectF.left + (f13 * f3));
                f11 = (f - rectF.left) / f3;
            }
            if (z && z2) {
                f = Math.min(f, Math.min(rectF2.right, rectF.left + (rectF2.height() * f3)));
            } else {
                if (z) {
                    float f14 = rectF.bottom;
                    float f15 = f14 - f11;
                    float f16 = rectF2.top;
                    if (f15 < f16) {
                        f = Math.min(rectF2.right, rectF.left + ((f14 - f16) * f3));
                        f11 = (f - rectF.left) / f3;
                    }
                }
                if (z2) {
                    float f17 = rectF.top;
                    float f18 = f11 + f17;
                    float f19 = rectF2.bottom;
                    if (f18 > f19) {
                        f = Math.min(f, Math.min(rectF2.right, rectF.left + ((f19 - f17) * f3)));
                    }
                }
            }
        }
        rectF.right = f;
    }

    public final void g(RectF rectF, float f) {
        rectF.right = rectF.left + (rectF.height() * f);
    }

    public final void h(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            this.f.y -= f / 1.1f;
        }
        float f4 = rectF2.top;
        if (f < f4) {
            this.f.y -= (f - f4) / 2.0f;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        float f5 = rectF.bottom;
        float f6 = f5 - f;
        float f7 = this.b;
        if (f6 < f7) {
            f = f5 - f7;
        }
        float f8 = f5 - f;
        float f9 = this.d;
        if (f8 > f9) {
            f = f5 - f9;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        if (f3 > 0.0f) {
            float f10 = (f5 - f) * f3;
            float f11 = this.f11825a;
            if (f10 < f11) {
                f = Math.max(f4, f5 - (f11 / f3));
                f10 = (rectF.bottom - f) * f3;
            }
            float f12 = this.c;
            if (f10 > f12) {
                f = Math.max(rectF2.top, rectF.bottom - (f12 / f3));
                f10 = (rectF.bottom - f) * f3;
            }
            if (z && z2) {
                f = Math.max(f, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f3)));
            } else {
                if (z) {
                    float f13 = rectF.right;
                    float f14 = f13 - f10;
                    float f15 = rectF2.left;
                    if (f14 < f15) {
                        f = Math.max(rectF2.top, rectF.bottom - ((f13 - f15) / f3));
                        f10 = (rectF.bottom - f) * f3;
                    }
                }
                if (z2) {
                    float f16 = rectF.left;
                    float f17 = f10 + f16;
                    float f18 = rectF2.right;
                    if (f17 > f18) {
                        f = Math.max(f, Math.max(rectF2.top, rectF.bottom - ((f18 - f16) / f3)));
                    }
                }
            }
        }
        rectF.top = f;
    }

    public final void i(RectF rectF, RectF rectF2, float f) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f)) / 2.0f);
        float f2 = rectF.top;
        float f3 = rectF2.top;
        if (f2 < f3) {
            rectF.offset(0.0f, f3 - f2);
        }
        float f4 = rectF.bottom;
        float f5 = rectF2.bottom;
        if (f4 > f5) {
            rectF.offset(0.0f, f5 - f4);
        }
    }

    public final void j(RectF rectF, float f) {
        rectF.top = rectF.bottom - (rectF.width() / f);
    }

    public final void l(RectF rectF, float f, float f2) {
        float fCenterY;
        float f3;
        float f4;
        float fCenterX = 0.0f;
        switch (a.f11826a[this.e.ordinal()]) {
            case 1:
                fCenterX = rectF.left - f;
                fCenterY = rectF.top;
                f4 = fCenterY - f2;
                break;
            case 2:
                fCenterX = rectF.right - f;
                fCenterY = rectF.top;
                f4 = fCenterY - f2;
                break;
            case 3:
                fCenterX = rectF.left - f;
                fCenterY = rectF.bottom;
                f4 = fCenterY - f2;
                break;
            case 4:
                fCenterX = rectF.right - f;
                fCenterY = rectF.bottom;
                f4 = fCenterY - f2;
                break;
            case 5:
                f3 = rectF.left;
                fCenterX = f3 - f;
                f4 = 0.0f;
                break;
            case 6:
                fCenterY = rectF.top;
                f4 = fCenterY - f2;
                break;
            case 7:
                f3 = rectF.right;
                fCenterX = f3 - f;
                f4 = 0.0f;
                break;
            case 8:
                fCenterY = rectF.bottom;
                f4 = fCenterY - f2;
                break;
            case 9:
                fCenterX = rectF.centerX() - f;
                fCenterY = rectF.centerY();
                f4 = fCenterY - f2;
                break;
            default:
                f4 = 0.0f;
                break;
        }
        PointF pointF = this.f;
        pointF.x = fCenterX;
        pointF.y = f4;
    }

    public Type m() {
        return this.e;
    }

    public void n(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, boolean z, float f4) {
        PointF pointF = this.f;
        float f5 = f + pointF.x;
        float f6 = f2 + pointF.y;
        if (this.e == Type.CENTER) {
            o(rectF, f5, f6, rectF2, i, i2, f3);
        } else if (z) {
            p(rectF, f5, f6, rectF2, i, i2, f3, f4);
        } else {
            q(rectF, f5, f6, rectF2, i, i2, f3);
        }
    }

    public final void o(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        float f4;
        float fCenterX = f - rectF.centerX();
        float fCenterY = f2 - rectF.centerY();
        float f5 = 0.0f;
        if (rectF.left >= rectF2.left + fCenterX) {
            f4 = fCenterX / 1.05f;
            this.f.x -= f4 / 2.0f;
        } else {
            f4 = 0.0f;
        }
        if (rectF.top >= rectF2.top + fCenterY) {
            f5 = fCenterY / 1.05f;
            this.f.y -= f5 / 2.0f;
        }
        rectF.offset(f4, f5);
    }

    public final void p(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, float f4) {
        switch (a.f11826a[this.e.ordinal()]) {
            case 1:
                if (k(f, f2, rectF.right, rectF.bottom) >= f4) {
                    c(rectF, f, rectF2, f3, f4, true, false);
                    j(rectF, f4);
                } else {
                    h(rectF, f2, rectF2, f3, f4, true, false);
                    d(rectF, f4);
                }
                break;
            case 2:
                if (k(rectF.left, f2, f, rectF.bottom) >= f4) {
                    f(rectF, f, rectF2, i, f3, f4, true, false);
                    j(rectF, f4);
                } else {
                    h(rectF, f2, rectF2, f3, f4, false, true);
                    g(rectF, f4);
                }
                break;
            case 3:
                if (k(f, rectF.top, rectF.right, f2) >= f4) {
                    c(rectF, f, rectF2, f3, f4, false, true);
                    b(rectF, f4);
                } else {
                    a(rectF, f2, rectF2, i2, f3, f4, true, false);
                    d(rectF, f4);
                }
                break;
            case 4:
                if (k(rectF.left, rectF.top, f, f2) >= f4) {
                    f(rectF, f, rectF2, i, f3, f4, false, true);
                    b(rectF, f4);
                } else {
                    a(rectF, f2, rectF2, i2, f3, f4, false, true);
                    g(rectF, f4);
                }
                break;
            case 5:
                c(rectF, f, rectF2, f3, f4, true, true);
                i(rectF, rectF2, f4);
                break;
            case 6:
                h(rectF, f2, rectF2, f3, f4, true, true);
                e(rectF, rectF2, f4);
                break;
            case 7:
                f(rectF, f, rectF2, i, f3, f4, true, true);
                i(rectF, rectF2, f4);
                break;
            case 8:
                a(rectF, f2, rectF2, i2, f3, f4, true, true);
                e(rectF, rectF2, f4);
                break;
        }
    }

    public final void q(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        switch (a.f11826a[this.e.ordinal()]) {
            case 1:
                h(rectF, f2, rectF2, f3, 0.0f, false, false);
                c(rectF, f, rectF2, f3, 0.0f, false, false);
                break;
            case 2:
                h(rectF, f2, rectF2, f3, 0.0f, false, false);
                f(rectF, f, rectF2, i, f3, 0.0f, false, false);
                break;
            case 3:
                a(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                c(rectF, f, rectF2, f3, 0.0f, false, false);
                break;
            case 4:
                a(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                f(rectF, f, rectF2, i, f3, 0.0f, false, false);
                break;
            case 5:
                c(rectF, f, rectF2, f3, 0.0f, false, false);
                break;
            case 6:
                h(rectF, f2, rectF2, f3, 0.0f, false, false);
                break;
            case 7:
                f(rectF, f, rectF2, i, f3, 0.0f, false, false);
                break;
            case 8:
                a(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                break;
        }
    }
}
