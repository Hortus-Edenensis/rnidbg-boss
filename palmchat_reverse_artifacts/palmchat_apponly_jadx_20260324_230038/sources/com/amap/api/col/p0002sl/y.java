package com.amap.api.col.p0002sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.model.CameraPosition;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class y extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f3053a;
    private Bitmap b;
    private ImageView c;
    private bb d;
    private ah e;

    public y(Context context, bb bbVar, ah ahVar) {
        super(context);
        this.d = bbVar;
        this.e = ahVar;
        try {
            Bitmap bitmapA = ct.a("maps_dav_compass_needle_large2d.png");
            Bitmap bitmapA2 = ct.a(bitmapA, z.f3056a * 0.8f);
            this.b = bitmapA2;
            if (bitmapA2 != null) {
                Bitmap bitmapA3 = ct.a(bitmapA, z.f3056a * 0.7f);
                this.f3053a = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f3053a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(bitmapA3, (this.b.getWidth() - bitmapA3.getWidth()) / 2, (this.b.getHeight() - bitmapA3.getHeight()) / 2, paint);
            }
        } catch (Throwable th) {
            ct.a(th, "CompassView", "CompassView");
        }
        ImageView imageView = new ImageView(context);
        this.c = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        this.c.setImageBitmap(this.f3053a);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.2sl.y.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        this.c.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.2sl.y.2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    y.this.c.setImageBitmap(y.this.b);
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                try {
                    y.this.c.setImageBitmap(y.this.f3053a);
                    CameraPosition cameraPosition = y.this.e.getCameraPosition();
                    y.this.e.animateCamera(new CameraUpdate(v.a(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f))));
                    return false;
                } catch (Exception e) {
                    ct.a(e, "CompassView", "onTouch");
                    return false;
                }
            }
        });
        addView(this.c);
    }

    public final void a() {
        try {
            Bitmap bitmap = this.f3053a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.f3053a = null;
            this.b = null;
        } catch (Exception e) {
            ct.a(e, "CompassView", "destory");
        }
    }
}
