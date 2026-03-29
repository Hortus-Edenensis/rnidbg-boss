package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f9406a;
    private Bitmap b;
    private Bitmap c;
    private int d;

    public u(Context context, int i) {
        super(context);
        a();
        this.d = i;
    }

    private void a() {
        this.f9406a = new Paint();
        setLayerType(1, null);
    }

    private Bitmap b() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(Color.argb(255, 255, 255, 255));
        canvas.drawCircle(getWidth() / 2.0f, getWidth() / 2.0f, getWidth() / 2.0f, paint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() - (getWidth() / 2.0f), getWidth() / 2.0f, paint);
        return bitmapCreateBitmap;
    }

    private Bitmap c() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(Color.argb(255, 235, 73, 61));
        canvas.drawRect(0.0f, this.d, getWidth(), getHeight() - this.d, paint);
        return bitmapCreateBitmap;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b = c();
        this.c = b();
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawBitmap(this.b, 0.0f, 0.0f, this.f9406a);
        this.f9406a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawBitmap(this.c, 0.0f, 0.0f, this.f9406a);
        this.f9406a.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }
}
