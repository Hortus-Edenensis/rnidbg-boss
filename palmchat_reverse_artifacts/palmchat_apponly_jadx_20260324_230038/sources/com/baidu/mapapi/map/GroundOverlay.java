package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGround;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class GroundOverlay extends Overlay {
    int g;
    BitmapDescriptor h;
    LatLng i;
    double j;
    double k;
    float l;
    float m;
    LatLngBounds n;
    float o;
    private BmGround p;
    boolean q = false;

    public GroundOverlay() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.ground;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        bundle.putBundle("image_info", this.h.a());
        if (this.g == 1) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.n.southwest);
            double longitudeE6 = geoPointLl2mc.getLongitudeE6();
            double latitudeE6 = geoPointLl2mc.getLatitudeE6();
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.n.northeast);
            double longitudeE62 = geoPointLl2mc2.getLongitudeE6();
            double latitudeE62 = geoPointLl2mc2.getLatitudeE6();
            double d = longitudeE62 - longitudeE6;
            this.j = d;
            double d2 = latitudeE62 - latitudeE6;
            this.k = d2;
            this.i = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (d2 / 2.0d), longitudeE6 + (d / 2.0d)));
            this.l = 0.5f;
            this.m = 0.5f;
        }
        double d3 = this.j;
        if (d3 <= 0.0d || this.k <= 0.0d) {
            throw new IllegalStateException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
        }
        bundle.putDouble("x_distance", d3);
        if (this.k == 2.147483647E9d) {
            this.k = (int) ((this.j * ((double) this.h.f3610a.getHeight())) / ((double) this.h.f3610a.getWidth()));
        }
        bundle.putDouble("y_distance", this.k);
        GeoPoint geoPointLl2mc3 = CoordUtil.ll2mc(this.i);
        bundle.putDouble("location_x", geoPointLl2mc3.getLongitudeE6());
        bundle.putDouble("location_y", geoPointLl2mc3.getLatitudeE6());
        bundle.putFloat("anchor_x", this.l);
        bundle.putFloat("anchor_y", this.m);
        bundle.putFloat("transparency", this.o);
        bundle.putInt("isClickable", this.q ? 1 : 0);
        return bundle;
    }

    public float getAnchorX() {
        return this.l;
    }

    public float getAnchorY() {
        return this.m;
    }

    public LatLngBounds getBounds() {
        return this.n;
    }

    public double getHeight() {
        return this.k;
    }

    public BitmapDescriptor getImage() {
        return this.h;
    }

    public LatLng getPosition() {
        return this.i;
    }

    public float getTransparency() {
        return this.o;
    }

    public double getWidth() {
        return this.j;
    }

    public boolean isClickable() {
        return this.q;
    }

    public void setAnchor(float f, float f2) {
        if (f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.l = f;
        this.m = f2;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmGround bmGround = this.p;
        if (bmGround == null || this.f == null) {
            return;
        }
        bmGround.b(this.l);
        this.p.c(this.m);
        this.f.b();
    }

    public void setClickable(boolean z) {
        this.q = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmGround bmGround = this.p;
        if (bmGround == null || this.f == null) {
            return;
        }
        bmGround.a(this.q);
        this.f.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDimensions(int i) {
        Bitmap bitmap;
        int height;
        if (i > 0) {
            double d = i;
            this.j = d;
            this.k = 2.147483647E9d;
            BitmapDescriptor bitmapDescriptor = this.h;
            if (bitmapDescriptor != null && (bitmap = bitmapDescriptor.f3610a) != null) {
                height = (int) ((d * ((double) bitmap.getHeight())) / ((double) this.h.f3610a.getWidth()));
            }
            if (OverlayUtil.isOverlayUpgrade()) {
                this.listener.c(this);
                return;
            }
            BmGround bmGround = this.p;
            if (bmGround == null || this.f == null) {
                return;
            }
            bmGround.a(height);
            this.p.b(this.j);
            this.f.b();
            return;
        }
        this.j = 0.0d;
        this.k = 0.0d;
        height = 0;
        if (OverlayUtil.isOverlayUpgrade()) {
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: image can not be null");
        }
        this.h = bitmapDescriptor;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.p == null || this.f == null) {
            return;
        }
        this.p.a(this.h.f3610a != null ? (int) ((this.j * ((double) r5.getHeight())) / ((double) this.h.f3610a.getWidth())) : 0);
        this.p.a(new BmBitmapResource(this.h.getBitmap()));
        this.f.b();
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.g = 2;
        this.i = latLng;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.p == null || this.f == null) {
                return;
            }
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.i);
            this.p.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            this.f.b();
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
        }
        this.g = 1;
        this.n = latLngBounds;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.p == null || this.f == null) {
            return;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.n.southwest);
        double longitudeE6 = geoPointLl2mc.getLongitudeE6();
        double latitudeE6 = geoPointLl2mc.getLatitudeE6();
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.n.northeast);
        double longitudeE62 = geoPointLl2mc2.getLongitudeE6();
        double latitudeE62 = geoPointLl2mc2.getLatitudeE6();
        double d = longitudeE62 - longitudeE6;
        this.j = d;
        double d2 = latitudeE62 - latitudeE6;
        this.k = d2;
        GeoPoint geoPoint = new GeoPoint(latitudeE6 + (d2 / 2.0d), longitudeE6 + (d / 2.0d));
        this.i = CoordUtil.mc2ll(geoPoint);
        this.l = 0.5f;
        this.m = 0.5f;
        this.p.a(new com.baidu.platform.comapi.bmsdk.b(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6()));
        this.p.b(this.j);
        this.p.a(this.k);
        this.p.b(this.l);
        this.p.c(this.m);
    }

    public void setTransparency(float f) {
        if (f > 1.0f || f < 0.0f) {
            return;
        }
        this.o = f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmGround bmGround = this.p;
        if (bmGround == null || this.f == null) {
            return;
        }
        bmGround.a(this.o);
        this.f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        Bitmap bitmap;
        BmGround bmGround = new BmGround();
        this.p = bmGround;
        bmGround.a(this);
        setDrawItem(this.p);
        super.toDrawItem();
        if (this.h == null) {
            return this.p;
        }
        if (this.g == 1) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.n.southwest);
            double longitudeE6 = geoPointLl2mc.getLongitudeE6();
            double latitudeE6 = geoPointLl2mc.getLatitudeE6();
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.n.northeast);
            double longitudeE62 = geoPointLl2mc2.getLongitudeE6();
            double latitudeE62 = geoPointLl2mc2.getLatitudeE6();
            double d = longitudeE62 - longitudeE6;
            this.j = d;
            double d2 = latitudeE62 - latitudeE6;
            this.k = d2;
            this.i = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (d2 / 2.0d), longitudeE6 + (d / 2.0d)));
            this.l = 0.5f;
            this.m = 0.5f;
        }
        if (this.k == 2.147483647E9d && (bitmap = this.h.f3610a) != null) {
            this.k = (int) ((this.j * ((double) bitmap.getHeight())) / ((double) this.h.f3610a.getWidth()));
        }
        LatLng latLng = this.i;
        if (latLng != null) {
            GeoPoint geoPointLl2mc3 = CoordUtil.ll2mc(latLng);
            this.p.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc3.getLongitudeE6(), geoPointLl2mc3.getLatitudeE6()));
        }
        this.p.b(this.j);
        this.p.a(this.k);
        this.p.b(this.l);
        this.p.c(this.m);
        this.p.a(this.q);
        this.p.a(this.o);
        this.p.a(new BmBitmapResource(this.h.getBitmap()));
        return this.p;
    }

    public void setDimensions(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.j = i;
            this.k = i2;
        } else {
            this.j = 0.0d;
            this.k = 0.0d;
        }
        if (OverlayUtil.isOverlayUpgrade()) {
            BmGround bmGround = this.p;
            if (bmGround == null || this.f == null) {
                return;
            }
            bmGround.a(this.k);
            this.p.b(this.j);
            this.f.b();
            return;
        }
        this.listener.c(this);
    }
}
