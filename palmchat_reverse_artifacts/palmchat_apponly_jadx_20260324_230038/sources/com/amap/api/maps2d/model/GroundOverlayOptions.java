package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.col.p0002sl.ct;
import com.wifi.ad.core.config.EventParams;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class GroundOverlayOptions implements Parcelable {
    public static final d CREATOR = new d();
    public static final float NO_DIMENSION = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3097a;
    private BitmapDescriptor b;
    private LatLng c;
    private float d;
    private float e;
    private LatLngBounds f;
    private float g;
    private float h;
    private boolean i;
    private float j;
    private float k;
    private float l;

    public GroundOverlayOptions(int i, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.i = true;
        this.j = 0.0f;
        this.k = 0.5f;
        this.l = 0.5f;
        this.f3097a = i;
        this.b = BitmapDescriptorFactory.fromBitmap(null);
        this.c = latLng;
        this.d = f;
        this.e = f2;
        this.f = latLngBounds;
        this.g = f3;
        this.h = f4;
        this.i = z;
        this.j = f5;
        this.k = f6;
        this.l = f7;
    }

    private GroundOverlayOptions a(LatLng latLng, float f, float f2) {
        this.c = latLng;
        this.d = f;
        this.e = f2;
        return this;
    }

    public final GroundOverlayOptions anchor(float f, float f2) {
        this.k = f;
        this.l = f2;
        return this;
    }

    public final GroundOverlayOptions bearing(float f) {
        this.g = f;
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final float getAnchorU() {
        return this.k;
    }

    public final float getAnchorV() {
        return this.l;
    }

    public final float getBearing() {
        return this.g;
    }

    public final LatLngBounds getBounds() {
        return this.f;
    }

    public final float getHeight() {
        return this.e;
    }

    public final BitmapDescriptor getImage() {
        return this.b;
    }

    public final LatLng getLocation() {
        return this.c;
    }

    public final float getTransparency() {
        return this.j;
    }

    public final float getWidth() {
        return this.d;
    }

    public final float getZIndex() {
        return this.h;
    }

    public final GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.b = bitmapDescriptor;
        return this;
    }

    public final boolean isVisible() {
        return this.i;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f) {
        try {
            if (this.f != null) {
                Log.w("GroundOverlayOptions", "Position has already been set using positionFromBounds");
            }
            if (latLng == null) {
                Log.w("GroundOverlayOptions", "Location must be specified");
            }
            if (f <= 0.0f) {
                Log.w("GroundOverlayOptions", "Width must be non-negative");
            }
            return a(latLng, f, f);
        } catch (Exception e) {
            ct.a(e, "GroundOverlayOptions", EventParams.KEY_CT_SDK_POSITION);
            return null;
        }
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        try {
            if (this.c != null) {
                Log.w("GroundOverlayOptions", "Position has already been set using position: " + this.c);
            }
            this.f = latLngBounds;
            return this;
        } catch (Exception e) {
            ct.a(e, "GroundOverlayOptions", "positionFromBounds");
            return null;
        }
    }

    public final GroundOverlayOptions transparency(float f) {
        if (f < 0.0f) {
            try {
                Log.w("GroundOverlayOptions", "Transparency must be in the range [0..1]");
                f = 0.0f;
            } catch (Exception e) {
                ct.a(e, "GroundOverlayOptions", "transparency");
                return null;
            }
        }
        this.j = f;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z) {
        this.i = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3097a);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeParcelable(this.f, i);
        parcel.writeFloat(this.g);
        parcel.writeFloat(this.h);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.j);
        parcel.writeFloat(this.k);
        parcel.writeFloat(this.l);
    }

    public final GroundOverlayOptions zIndex(float f) {
        this.h = f;
        return this;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        try {
            if (this.f != null) {
                Log.w("GroundOverlayOptions", "Position has already been set using positionFromBounds");
            }
            if (latLng == null) {
                Log.w("GroundOverlayOptions", "Location must be specified");
            }
            if (f <= 0.0f || f2 <= 0.0f) {
                Log.w("GroundOverlayOptions", "Width and Height must be non-negative");
            }
            return a(latLng, f, f2);
        } catch (Exception e) {
            ct.a(e, "GroundOverlayOptions", EventParams.KEY_CT_SDK_POSITION);
            return null;
        }
    }

    public GroundOverlayOptions() {
        this.i = true;
        this.j = 0.0f;
        this.k = 0.5f;
        this.l = 0.5f;
        this.f3097a = 1;
    }
}
