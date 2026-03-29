package com.opos.mobad.template.cmn;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.widget.ImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f9399a;
    private float b;
    private Bitmap c;

    public l(Context context) {
        super(context);
        this.f9399a = 0.0f;
        this.b = 0.0f;
    }

    public void a(int i) {
        this.f9399a = i;
        invalidate();
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // android.widget.ImageView, android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        Bitmap bitmapCreateBitmap;
        Canvas canvas2;
        float f = this.f9399a;
        if (f <= 0.0f) {
            super.onDraw(canvas);
            return;
        }
        if (f * 2.0f >= getWidth() || this.f9399a * 2.0f >= getHeight()) {
            return;
        }
        Bitmap bitmap = this.c;
        if (bitmap != null && bitmap.getWidth() == getWidth() && this.c.getHeight() == getHeight()) {
            bitmapCreateBitmap = this.c;
            canvas2 = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            paint.setColor(0);
            canvas2.drawPaint(paint);
        } else {
            Bitmap bitmap2 = this.c;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.c = null;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.c = bitmapCreateBitmap;
            canvas2 = new Canvas(bitmapCreateBitmap);
        }
        super.onDraw(canvas2);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        float f2 = this.f9399a;
        float width = getWidth() - this.f9399a;
        float height = getHeight() - this.f9399a;
        float f3 = this.b;
        canvas.drawRoundRect(f2, f2, width, height, f3, f3, paint2);
    }
}
