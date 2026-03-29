package com.amap.api.col.p0002sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class ay extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f2621a;
    private Bitmap b;
    private Bitmap c;
    private ImageView d;
    private ah e;
    private boolean f;

    public ay(Context context, ah ahVar) {
        super(context);
        this.f = false;
        this.e = ahVar;
        try {
            this.f2621a = ct.a("location_selected2d.png");
            this.b = ct.a("location_pressed2d.png");
            this.f2621a = ct.a(this.f2621a, z.f3056a);
            this.b = ct.a(this.b, z.f3056a);
            Bitmap bitmapA = ct.a("location_unselected2d.png");
            this.c = bitmapA;
            this.c = ct.a(bitmapA, z.f3056a);
        } catch (Throwable th) {
            ct.a(th, "LocationView", "LocationView");
        }
        ImageView imageView = new ImageView(context);
        this.d = imageView;
        imageView.setImageBitmap(this.f2621a);
        this.d.setPadding(0, 20, 20, 0);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.col.2sl.ay.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.2sl.ay.2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!ay.this.f) {
                    return false;
                }
                if (motionEvent.getAction() == 0) {
                    ay.this.d.setImageBitmap(ay.this.b);
                } else if (motionEvent.getAction() == 1) {
                    try {
                        ay.this.d.setImageBitmap(ay.this.f2621a);
                        ay.this.e.setMyLocationEnabled(true);
                        Location myLocation = ay.this.e.getMyLocation();
                        if (myLocation == null) {
                            return false;
                        }
                        LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                        ay.this.e.showMyLocationOverlay(myLocation);
                        ay.this.e.moveCamera(new CameraUpdate(v.a(latLng, ay.this.e.getZoomLevel())));
                    } catch (Exception e) {
                        ct.a(e, "LocationView", "onTouch");
                    }
                }
                return false;
            }
        });
        addView(this.d);
    }

    public final void a() {
        try {
            Bitmap bitmap = this.f2621a;
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
            this.f2621a = null;
            this.b = null;
            this.c = null;
        } catch (Exception e) {
            ct.a(e, "LocationView", "destory");
        }
    }

    public final void a(boolean z) {
        this.f = z;
        if (z) {
            this.d.setImageBitmap(this.f2621a);
        } else {
            this.d.setImageBitmap(this.c);
        }
        this.d.postInvalidate();
    }
}
