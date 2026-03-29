package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.adexpress.b.nr;
import com.bytedance.sdk.component.iz.jk;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.iz.s;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ImageFlipSlide extends View {
    private List<String> b;
    private Bitmap fx;
    private final Rect iz;
    private final boolean n;
    private float nr;
    private Path pn;
    Paint u;
    private final Rect x;

    public ImageFlipSlide(Context context, boolean z) {
        super(context);
        this.nr = 0.1f;
        this.iz = new Rect();
        this.x = new Rect();
        this.n = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBlurPx() {
        if (this.b == null) {
            return 0;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (this.b.get(i).contains("blur")) {
                return Integer.parseInt(this.b.get(i).split("\\(")[1].split("px")[0]);
            }
        }
        return 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fx == null) {
            return;
        }
        if (!this.n) {
            canvas.clipPath(this.pn);
            canvas.drawBitmap(this.fx, 0.0f, 0.0f, this.u);
            return;
        }
        this.iz.left = (int) (r0.getWidth() * (1.0f - this.nr));
        this.iz.right = this.fx.getWidth();
        Rect rect = this.iz;
        rect.top = 0;
        rect.bottom = this.fx.getHeight();
        this.x.left = (int) (getWidth() * (1.0f - this.nr));
        this.x.right = getWidth();
        Rect rect2 = this.x;
        rect2.top = 0;
        rect2.bottom = getHeight();
        canvas.drawBitmap(this.fx, this.iz, this.x, this.u);
    }

    public void u(String str, String str2, List<String> list) {
        final s sVarKey = com.bytedance.sdk.component.adexpress.u.u.u.u().pn().from(str).key(str2);
        this.b = list;
        sVarKey.config(Bitmap.Config.ARGB_4444).type(2);
        if (getBlurPx() != 0) {
            sVarKey.converter(new jk() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.1
                @Override // com.bytedance.sdk.component.iz.jk
                public Bitmap coverterTo(Bitmap bitmap) {
                    try {
                        return nr.u(ImageFlipSlide.this.getContext(), bitmap, ImageFlipSlide.this.getBlurPx());
                    } catch (Exception unused) {
                        return bitmap;
                    }
                }
            });
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2
            @Override // java.lang.Runnable
            public void run() {
                sVarKey.to(new qq<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2.1
                    @Override // com.bytedance.sdk.component.iz.qq
                    public void onSuccess(my<Bitmap> myVar) {
                        try {
                            ImageFlipSlide imageFlipSlide = ImageFlipSlide.this;
                            imageFlipSlide.fx = imageFlipSlide.u(myVar.getResult(), ImageFlipSlide.this.getWidth(), ImageFlipSlide.this.getHeight());
                        } catch (Exception unused) {
                        }
                        ImageFlipSlide.this.invalidate();
                    }

                    @Override // com.bytedance.sdk.component.iz.qq
                    public void onFailed(int i, String str3, Throwable th) {
                    }
                });
            }
        });
        Paint paint = new Paint();
        this.u = paint;
        paint.setAntiAlias(true);
        this.u.setDither(true);
        if (this.n) {
            this.u.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        List<String> list2 = this.b;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        for (int i = 0; i < this.b.size(); i++) {
            u(colorMatrix, this.b.get(i));
        }
        this.u.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    private void u(ColorMatrix colorMatrix, String str) {
        try {
            ColorMatrix colorMatrix2 = new ColorMatrix();
            if (str.startsWith("hue-rotate")) {
                colorMatrix2.setRotate(0, Integer.parseInt(str.split("\\(")[1].split("deg")[0]));
            } else if (!str.startsWith("grayscale") && !str.startsWith("contrast")) {
                if (str.startsWith("invert")) {
                    float f = (Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f) * 255.0f;
                    colorMatrix2.set(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, -1.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, -1.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                } else if (str.startsWith("sepia")) {
                    float f2 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                    colorMatrix2.setScale(f2, f2, 1.0f, 1.0f);
                } else if (str.startsWith("brightness")) {
                    float f3 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                    colorMatrix2.setScale(f3, f3, f3, 1.0f);
                }
            } else {
                colorMatrix2.setSaturation(Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f);
            }
            colorMatrix.postConcat(colorMatrix2);
        } catch (Exception unused) {
        }
    }

    public void u(float f) {
        this.nr = f;
        invalidate();
    }

    public void u(Path path) {
        this.pn = path;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap u(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i;
        float f2 = (width * 1.0f) / f;
        float f3 = i2;
        float f4 = (height * 1.0f) / f3;
        Matrix matrix = new Matrix();
        if (f4 > f2) {
            int i7 = (int) (f3 * f2);
            float f5 = 1.0f / f2;
            matrix.setScale(f5, f5);
            i5 = i7;
            i3 = width;
            i6 = (height / 2) - (i7 / 2);
            i4 = 0;
        } else {
            int i8 = (int) (f * f4);
            float f6 = 1.0f / f4;
            matrix.setScale(f6, f6);
            i3 = i8;
            i4 = (width / 2) - (i8 / 2);
            i5 = height;
            i6 = 0;
        }
        return Bitmap.createBitmap(bitmap, i4, i6, i3, i5, matrix, false);
    }
}
