package com.amap.api.col.p0002sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps2d.CameraUpdate;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class cm extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f2674a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private ImageView g;
    private ImageView h;
    private az i;
    private ah j;
    private int k;

    public cm(Context context, az azVar, ah ahVar) {
        super(context);
        this.k = 0;
        setWillNotDraw(false);
        this.i = azVar;
        this.j = ahVar;
        try {
            Bitmap bitmapA = ct.a("zoomin_selected2d.png");
            this.f2674a = bitmapA;
            this.f2674a = ct.a(bitmapA, z.f3056a);
            Bitmap bitmapA2 = ct.a("zoomin_unselected2d.png");
            this.b = bitmapA2;
            this.b = ct.a(bitmapA2, z.f3056a);
            Bitmap bitmapA3 = ct.a("zoomout_selected2d.png");
            this.c = bitmapA3;
            this.c = ct.a(bitmapA3, z.f3056a);
            Bitmap bitmapA4 = ct.a("zoomout_unselected2d.png");
            this.d = bitmapA4;
            this.d = ct.a(bitmapA4, z.f3056a);
            this.e = ct.a("zoomin_pressed2d.png");
            this.f = ct.a("zoomout_pressed2d.png");
            this.e = ct.a(this.e, z.f3056a);
            this.f = ct.a(this.f, z.f3056a);
            ImageView imageView = new ImageView(context);
            this.g = imageView;
            imageView.setImageBitmap(this.f2674a);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.2sl.cm.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    cm.this.h.setImageBitmap(cm.this.c);
                    if (cm.this.j.getZoomLevel() > ((int) cm.this.j.getMaxZoomLevel()) - 2) {
                        cm.this.g.setImageBitmap(cm.this.b);
                    } else {
                        cm.this.g.setImageBitmap(cm.this.f2674a);
                    }
                    cm cmVar = cm.this;
                    cmVar.a(cmVar.j.getZoomLevel() + 1.0f);
                    cm.this.i.e();
                }
            });
            ImageView imageView2 = new ImageView(context);
            this.h = imageView2;
            imageView2.setImageBitmap(this.c);
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.2sl.cm.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    cm.this.g.setImageBitmap(cm.this.f2674a);
                    cm cmVar = cm.this;
                    cmVar.a(cmVar.j.getZoomLevel() - 1.0f);
                    if (cm.this.j.getZoomLevel() < ((int) cm.this.j.getMinZoomLevel()) + 2) {
                        cm.this.h.setImageBitmap(cm.this.d);
                    } else {
                        cm.this.h.setImageBitmap(cm.this.c);
                    }
                    cm.this.i.f();
                }
            });
            this.g.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.2sl.cm.3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (cm.this.j.getZoomLevel() >= cm.this.j.getMaxZoomLevel()) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        cm.this.g.setImageBitmap(cm.this.e);
                    } else if (motionEvent.getAction() == 1) {
                        cm.this.g.setImageBitmap(cm.this.f2674a);
                        try {
                            cm.this.j.animateCamera(new CameraUpdate(v.b()));
                        } catch (RemoteException e) {
                            ct.a(e, "ZoomControllerView", "ontouch");
                        }
                    }
                    return false;
                }
            });
            this.h.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.2sl.cm.4
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (cm.this.j.getZoomLevel() <= cm.this.j.getMinZoomLevel()) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        cm.this.h.setImageBitmap(cm.this.f);
                    } else if (motionEvent.getAction() == 1) {
                        cm.this.h.setImageBitmap(cm.this.c);
                        try {
                            cm.this.j.animateCamera(new CameraUpdate(v.c()));
                        } catch (RemoteException e) {
                            ct.a(e, "ZoomControllerView", "onTouch");
                        }
                    }
                    return false;
                }
            });
            this.g.setPadding(0, 0, 20, -2);
            this.h.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.g);
            addView(this.h);
        } catch (Throwable th) {
            ct.a(th, "ZoomControllerView", "ZoomControllerView");
        }
    }

    public final void a() {
        try {
            Bitmap bitmap = this.f2674a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            Bitmap bitmap3 = this.c;
            if (bitmap3 != null) {
                bitmap3.recycle();
            }
            Bitmap bitmap4 = this.d;
            if (bitmap4 != null) {
                bitmap4.recycle();
            }
            Bitmap bitmap5 = this.e;
            if (bitmap5 != null) {
                bitmap5.recycle();
            }
            Bitmap bitmap6 = this.f;
            if (bitmap6 != null) {
                bitmap6.recycle();
            }
            this.f2674a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
        } catch (Exception e) {
            ct.a(e, "ZoomControllerView", "destory");
        }
    }

    public final int b() {
        return this.k;
    }

    public final void a(int i) {
        this.k = i;
        removeView(this.g);
        removeView(this.h);
        addView(this.g);
        addView(this.h);
    }

    public final void a(float f) {
        if (f < this.j.getMaxZoomLevel() && f > this.j.getMinZoomLevel()) {
            this.g.setImageBitmap(this.f2674a);
            this.h.setImageBitmap(this.c);
        } else if (f <= this.j.getMinZoomLevel()) {
            this.h.setImageBitmap(this.d);
            this.g.setImageBitmap(this.f2674a);
        } else if (f >= this.j.getMaxZoomLevel()) {
            this.g.setImageBitmap(this.b);
            this.h.setImageBitmap(this.c);
        }
    }
}
