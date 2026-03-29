package com.amap.api.col.p0002sl;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bl {
    ValueAnimator b;
    private ah e;
    private Marker f;
    private Circle g;
    private MyLocationStyle h;
    private LatLng i;
    private double j;
    private Context k;
    private bu l;
    private int m = 1;
    private boolean n = false;
    private final String o = "location_map_gps_locked.png";
    private final String p = "location_map_gps_3d.png";
    private BitmapDescriptor q = null;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f2650a = null;
    Animator.AnimatorListener c = new Animator.AnimatorListener() { // from class: com.amap.api.col.2sl.bl.1
        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            bl.this.c();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    };
    ValueAnimator.AnimatorUpdateListener d = new ValueAnimator.AnimatorUpdateListener() { // from class: com.amap.api.col.2sl.bl.2
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        @TargetApi(11)
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (bl.this.g != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    bl.this.g.setCenter(latLng);
                    bl.this.f.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(11)
    public class a implements TypeEvaluator {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = latLng.latitude;
            double d2 = f;
            double d3 = d + ((latLng2.latitude - d) * d2);
            double d4 = latLng.longitude;
            return new LatLng(d3, d4 + (d2 * (latLng2.longitude - d4)));
        }
    }

    public bl(ah ahVar, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.k = applicationContext;
        this.e = ahVar;
        this.l = new bu(applicationContext, ahVar);
        a(1, true);
    }

    private void d() {
        MyLocationStyle myLocationStyle = this.h;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.h = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        } else if (myLocationStyle.getMyLocationIcon() == null || this.h.getMyLocationIcon().getBitmap() == null) {
            this.h.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        f();
    }

    private void e() {
        Circle circle = this.g;
        if (circle != null) {
            try {
                this.e.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                hd.c(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.g = null;
        }
        Marker marker = this.f;
        if (marker != null) {
            marker.remove();
            this.f.destroy();
            this.f = null;
            bu buVar = this.l;
            if (buVar != null) {
                buVar.a((Marker) null);
            }
        }
    }

    private void f() {
        try {
            if (this.g == null) {
                this.g = this.e.addCircle(new CircleOptions().zIndex(1.0f));
            }
            Circle circle = this.g;
            if (circle != null) {
                if (circle.getStrokeWidth() != this.h.getStrokeWidth()) {
                    this.g.setStrokeWidth(this.h.getStrokeWidth());
                }
                if (this.g.getFillColor() != this.h.getRadiusFillColor()) {
                    this.g.setFillColor(this.h.getRadiusFillColor());
                }
                if (this.g.getStrokeColor() != this.h.getStrokeColor()) {
                    this.g.setStrokeColor(this.h.getStrokeColor());
                }
                LatLng latLng = this.i;
                if (latLng != null) {
                    this.g.setCenter(latLng);
                }
                this.g.setRadius(this.j);
                this.g.setVisible(true);
            }
            if (this.f == null) {
                this.f = this.e.addMarker(new MarkerOptions().visible(false));
            }
            Marker marker = this.f;
            if (marker != null) {
                marker.setAnchor(this.h.getAnchorU(), this.h.getAnchorV());
                if (this.f.getIcons() == null || this.f.getIcons().size() == 0) {
                    this.f.setIcon(this.h.getMyLocationIcon());
                } else if (this.h.getMyLocationIcon() != null && !this.f.getIcons().get(0).equals(this.h.getMyLocationIcon())) {
                    this.f.setIcon(this.h.getMyLocationIcon());
                }
                LatLng latLng2 = this.i;
                if (latLng2 != null) {
                    this.f.setPosition(latLng2);
                    this.f.setVisible(true);
                }
            }
            c();
            bu buVar = this.l;
            if (buVar != null) {
                buVar.a(this.f);
            }
        } catch (Throwable th) {
            hd.c(th, "MyLocationOverlay", "myLocStyle");
            th.printStackTrace();
        }
    }

    private void b() {
        this.l.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.r) {
            if (this.s && this.n) {
                return;
            }
            this.n = true;
            try {
                this.e.animateCamera(CameraUpdateFactory.changeLatLng(this.i));
            } catch (Throwable th) {
                hd.c(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    public final void a(MyLocationStyle myLocationStyle) {
        try {
            this.h = myLocationStyle;
            a(myLocationStyle.isMyLocationShowing());
            if (!this.h.isMyLocationShowing()) {
                bu buVar = this.l;
                if (buVar != null) {
                    buVar.a(false);
                }
                this.m = this.h.getMyLocationType();
                return;
            }
            Marker marker = this.f;
            if (marker == null && this.g == null) {
                return;
            }
            bu buVar2 = this.l;
            if (buVar2 != null) {
                buVar2.a(marker);
            }
            d();
            a(this.h.getMyLocationType());
        } catch (Throwable th) {
            hd.c(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    private void b(float f) {
        if (this.t) {
            float f2 = f % 360.0f;
            if (f2 > 180.0f) {
                f2 -= 360.0f;
            } else if (f2 < -180.0f) {
                f2 += 360.0f;
            }
            Marker marker = this.f;
            if (marker != null) {
                marker.setRotateAngle(-f2);
            }
        }
    }

    public final void a(int i) {
        a(i, false);
    }

    private void a(int i, boolean z) {
        this.m = i;
        this.n = false;
        this.r = false;
        this.u = false;
        this.v = false;
        if (i == 1) {
            this.r = true;
            this.s = true;
            this.t = true;
        } else if (i == 2) {
            this.r = true;
            this.s = false;
            this.t = true;
        }
        if (this.l != null) {
            b();
        }
    }

    public final void a(Location location) {
        if (location == null) {
            return;
        }
        MyLocationStyle myLocationStyle = this.h;
        if (myLocationStyle != null) {
            a(myLocationStyle.isMyLocationShowing());
            if (!this.h.isMyLocationShowing()) {
                return;
            }
        }
        this.i = new LatLng(location.getLatitude(), location.getLongitude());
        this.j = location.getAccuracy();
        if (this.f == null && this.g == null) {
            d();
        }
        Circle circle = this.g;
        if (circle != null) {
            try {
                double d = this.j;
                if (d != -1.0d) {
                    circle.setRadius(d);
                }
            } catch (Throwable th) {
                hd.c(th, "MyLocationOverlay", "setCentAndRadius");
                th.printStackTrace();
            }
        }
        b(location.getBearing());
        if (!this.i.equals(this.f.getPosition())) {
            a(this.i);
        } else {
            c();
        }
    }

    public final void a() throws RemoteException {
        e();
        if (this.l != null) {
            b();
            this.l = null;
        }
    }

    private void a(boolean z) {
        Circle circle = this.g;
        if (circle != null && circle.isVisible() != z) {
            this.g.setVisible(z);
        }
        Marker marker = this.f;
        if (marker == null || marker.isVisible() == z) {
            return;
        }
        this.f.setVisible(z);
    }

    public final void a(float f) {
        Marker marker = this.f;
        if (marker != null) {
            marker.setRotateAngle(f);
        }
    }

    @TargetApi(11)
    private void a(LatLng latLng) {
        LatLng position = this.f.getPosition();
        if (position == null) {
            position = new LatLng(0.0d, 0.0d);
        }
        if (this.f2650a == null) {
            this.f2650a = new a();
        }
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator == null) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new a(), position, latLng);
            this.b = valueAnimatorOfObject;
            valueAnimatorOfObject.addListener(this.c);
            this.b.addUpdateListener(this.d);
            this.b.setDuration(1000L);
        } else {
            valueAnimator.setObjectValues(position, latLng);
            this.b.setEvaluator(this.f2650a);
        }
        if (position.latitude == 0.0d && position.longitude == 0.0d) {
            this.b.setDuration(1L);
        } else {
            this.b.setDuration(1000L);
        }
        this.b.start();
    }
}
