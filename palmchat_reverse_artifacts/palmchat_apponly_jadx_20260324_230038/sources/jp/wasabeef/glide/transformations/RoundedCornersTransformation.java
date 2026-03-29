package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import defpackage.wt;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RoundedCornersTransformation extends wt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18461a;
    public final int b;
    public final int c;
    public final CornerType d;

    /* JADX INFO: compiled from: SearchBox */
    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18462a;

        static {
            int[] iArr = new int[CornerType.values().length];
            f18462a = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18462a[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18462a[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18462a[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18462a[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18462a[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18462a[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f18462a[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f18462a[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f18462a[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f18462a[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f18462a[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f18462a[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f18462a[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f18462a[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public RoundedCornersTransformation(int i, int i2) {
        this(i, i2, CornerType.ALL);
    }

    @Override // defpackage.wt
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = bitmapPool.get(width, height, Bitmap.Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        a(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        n(canvas, paint, width, height);
        return bitmap2;
    }

    public final void c(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.c, f2 - this.b, r1 + r3, f2);
        int i = this.f18461a;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.c;
        canvas.drawRect(new RectF(i2, i2, i2 + this.b, f2 - this.f18461a), paint);
        canvas.drawRect(new RectF(this.f18461a + r1, this.c, f, f2), paint);
    }

    public final void d(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.b;
        RectF rectF = new RectF(f - i, f2 - i, f, f2);
        int i2 = this.f18461a;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.c;
        canvas.drawRect(new RectF(i3, i3, f - this.f18461a, f2), paint);
        int i4 = this.f18461a;
        canvas.drawRect(new RectF(f - i4, this.c, f, f2 - i4), paint);
    }

    public final void e(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.c, f2 - this.b, f, f2);
        int i = this.f18461a;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.c;
        canvas.drawRect(new RectF(i2, i2, f, f2 - this.f18461a), paint);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            if (roundedCornersTransformation.f18461a == this.f18461a && roundedCornersTransformation.b == this.b && roundedCornersTransformation.c == this.c && roundedCornersTransformation.d == this.d) {
                return true;
            }
        }
        return false;
    }

    public final void f(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        int i2 = this.b;
        RectF rectF = new RectF(i, i, i + i2, i + i2);
        int i3 = this.f18461a;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.b;
        RectF rectF2 = new RectF(f - i4, f2 - i4, f, f2);
        int i5 = this.f18461a;
        canvas.drawRoundRect(rectF2, i5, i5, paint);
        canvas.drawRect(new RectF(this.c, r1 + r3, f - this.f18461a, f2), paint);
        canvas.drawRect(new RectF(r1 + r2, this.c, f, f2 - this.f18461a), paint);
    }

    public final void g(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.b;
        RectF rectF = new RectF(f - i, this.c, f, r3 + i);
        int i2 = this.f18461a;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(this.c, f2 - this.b, r1 + r3, f2);
        int i3 = this.f18461a;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        int i4 = this.c;
        int i5 = this.f18461a;
        canvas.drawRect(new RectF(i4, i4, f - i5, f2 - i5), paint);
        int i6 = this.c;
        int i7 = this.f18461a;
        canvas.drawRect(new RectF(i6 + i7, i6 + i7, f, f2), paint);
    }

    public final void h(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        RectF rectF = new RectF(i, i, i + this.b, f2);
        int i2 = this.f18461a;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        canvas.drawRect(new RectF(this.f18461a + r1, this.c, f, f2), paint);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 425235636 + (this.f18461a * 10000) + (this.b * 1000) + (this.c * 100) + (this.d.ordinal() * 10);
    }

    public final void i(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        RectF rectF = new RectF(i, i, f, i + this.b);
        int i2 = this.f18461a;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(f - this.b, this.c, f, f2);
        int i3 = this.f18461a;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        canvas.drawRect(new RectF(this.c, r1 + r3, f - this.f18461a, f2), paint);
    }

    public final void j(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        RectF rectF = new RectF(i, i, f, i + this.b);
        int i2 = this.f18461a;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.c;
        RectF rectF2 = new RectF(i3, i3, i3 + this.b, f2);
        int i4 = this.f18461a;
        canvas.drawRoundRect(rectF2, i4, i4, paint);
        int i5 = this.c;
        int i6 = this.f18461a;
        canvas.drawRect(new RectF(i5 + i6, i5 + i6, f, f2), paint);
    }

    public final void k(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(this.c, f2 - this.b, f, f2);
        int i = this.f18461a;
        canvas.drawRoundRect(rectF, i, i, paint);
        RectF rectF2 = new RectF(f - this.b, this.c, f, f2);
        int i2 = this.f18461a;
        canvas.drawRoundRect(rectF2, i2, i2, paint);
        int i3 = this.c;
        int i4 = this.f18461a;
        canvas.drawRect(new RectF(i3, i3, f - i4, f2 - i4), paint);
    }

    public final void l(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        RectF rectF = new RectF(i, i, i + this.b, f2);
        int i2 = this.f18461a;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(this.c, f2 - this.b, f, f2);
        int i3 = this.f18461a;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        canvas.drawRect(new RectF(r1 + r2, this.c, f, f2 - this.f18461a), paint);
    }

    public final void m(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(f - this.b, this.c, f, f2);
        int i = this.f18461a;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.c;
        canvas.drawRect(new RectF(i2, i2, f - this.f18461a, f2), paint);
    }

    public final void n(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        float f3 = f - i;
        float f4 = f2 - i;
        switch (a.f18462a[this.d.ordinal()]) {
            case 1:
                int i2 = this.c;
                RectF rectF = new RectF(i2, i2, f3, f4);
                int i3 = this.f18461a;
                canvas.drawRoundRect(rectF, i3, i3, paint);
                break;
            case 2:
                o(canvas, paint, f3, f4);
                break;
            case 3:
                p(canvas, paint, f3, f4);
                break;
            case 4:
                c(canvas, paint, f3, f4);
                break;
            case 5:
                d(canvas, paint, f3, f4);
                break;
            case 6:
                q(canvas, paint, f3, f4);
                break;
            case 7:
                e(canvas, paint, f3, f4);
                break;
            case 8:
                h(canvas, paint, f3, f4);
                break;
            case 9:
                m(canvas, paint, f3, f4);
                break;
            case 10:
                k(canvas, paint, f3, f4);
                break;
            case 11:
                l(canvas, paint, f3, f4);
                break;
            case 12:
                i(canvas, paint, f3, f4);
                break;
            case 13:
                j(canvas, paint, f3, f4);
                break;
            case 14:
                f(canvas, paint, f3, f4);
                break;
            case 15:
                g(canvas, paint, f3, f4);
                break;
            default:
                int i4 = this.c;
                RectF rectF2 = new RectF(i4, i4, f3, f4);
                int i5 = this.f18461a;
                canvas.drawRoundRect(rectF2, i5, i5, paint);
                break;
        }
    }

    public final void o(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        int i2 = this.b;
        RectF rectF = new RectF(i, i, i + i2, i + i2);
        int i3 = this.f18461a;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.c;
        int i5 = this.f18461a;
        canvas.drawRect(new RectF(i4, i4 + i5, i4 + i5, f2), paint);
        canvas.drawRect(new RectF(this.f18461a + r1, this.c, f, f2), paint);
    }

    public final void p(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.b;
        RectF rectF = new RectF(f - i, this.c, f, r3 + i);
        int i2 = this.f18461a;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.c;
        canvas.drawRect(new RectF(i3, i3, f - this.f18461a, f2), paint);
        canvas.drawRect(new RectF(f - this.f18461a, this.c + r1, f, f2), paint);
    }

    public final void q(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.c;
        RectF rectF = new RectF(i, i, f, i + this.b);
        int i2 = this.f18461a;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        canvas.drawRect(new RectF(this.c, r1 + this.f18461a, f, f2), paint);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.f18461a + ", margin=" + this.c + ", diameter=" + this.b + ", cornerType=" + this.d.name() + ")";
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.RoundedCornersTransformation.1" + this.f18461a + this.b + this.c + this.d).getBytes(Key.CHARSET));
    }

    public RoundedCornersTransformation(int i, int i2, CornerType cornerType) {
        this.f18461a = i;
        this.b = i * 2;
        this.c = i2;
        this.d = cornerType;
    }
}
