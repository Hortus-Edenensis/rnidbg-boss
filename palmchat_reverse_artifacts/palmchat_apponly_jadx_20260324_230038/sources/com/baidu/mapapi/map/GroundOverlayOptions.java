package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BitmapDescriptor f3623a;
    private LatLng b;
    private int c;
    private int d;
    private LatLngBounds g;
    int j;
    Bundle l;
    private float e = 0.5f;
    private float f = 0.5f;
    private float h = 1.0f;
    private boolean i = false;
    boolean k = true;

    public GroundOverlayOptions anchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.e = f;
            this.f = f2;
        }
        return this;
    }

    public GroundOverlayOptions dimensions(int i) {
        if (i <= 0) {
            this.c = 0;
            this.d = 0;
            return this;
        }
        this.c = i;
        this.d = Integer.MAX_VALUE;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        this.l = bundle;
        return this;
    }

    public float getAnchorX() {
        return this.e;
    }

    public float getAnchorY() {
        return this.f;
    }

    public LatLngBounds getBounds() {
        return this.g;
    }

    public Bundle getExtraInfo() {
        return this.l;
    }

    public int getHeight() {
        int i = this.d;
        return i == Integer.MAX_VALUE ? (int) ((this.c * this.f3623a.f3610a.getHeight()) / this.f3623a.f3610a.getWidth()) : i;
    }

    public BitmapDescriptor getImage() {
        return this.f3623a;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        LatLng latLng;
        int i;
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.d = this.k;
        groundOverlay.c = this.j;
        groundOverlay.e = this.l;
        BitmapDescriptor bitmapDescriptor = this.f3623a;
        if (bitmapDescriptor == null) {
            throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
        }
        groundOverlay.h = bitmapDescriptor;
        LatLngBounds latLngBounds = this.g;
        if (latLngBounds == null && (latLng = this.b) != null) {
            int i2 = this.c;
            if (i2 <= 0 || (i = this.d) <= 0) {
                throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
            }
            groundOverlay.i = latLng;
            groundOverlay.l = this.e;
            groundOverlay.m = this.f;
            groundOverlay.j = i2;
            groundOverlay.k = i;
            groundOverlay.g = 2;
        } else {
            if (this.b != null || latLngBounds == null) {
                throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
            }
            groundOverlay.n = latLngBounds;
            groundOverlay.g = 1;
        }
        groundOverlay.o = this.h;
        groundOverlay.q = this.i;
        return groundOverlay;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public float getTransparency() {
        return this.h;
    }

    public int getWidth() {
        return this.c;
    }

    public int getZIndex() {
        return this.j;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: image can not be null");
        }
        this.f3623a = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.k;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.b = latLng;
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
        }
        this.g = latLngBounds;
        return this;
    }

    public GroundOverlayOptions setClickable(boolean z) {
        this.i = z;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.h = f;
        }
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.k = z;
        return this;
    }

    public GroundOverlayOptions zIndex(int i) {
        this.j = i;
        return this;
    }

    public GroundOverlayOptions dimensions(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.c = i;
            this.d = i2;
            return this;
        }
        this.c = 0;
        this.d = 0;
        return this;
    }
}
