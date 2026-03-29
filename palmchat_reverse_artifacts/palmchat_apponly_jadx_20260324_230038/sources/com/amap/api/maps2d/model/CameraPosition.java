package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.col.p0002sl.cs;
import com.amap.api.col.p0002sl.ct;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class CameraPosition implements Parcelable {
    public static final b CREATOR = new b();
    public final float bearing;
    public final boolean isAbroad;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLng f3093a;
        private float b;
        private float c;
        private float d;

        public Builder() {
        }

        public final Builder bearing(float f) {
            this.d = f;
            return this;
        }

        public final CameraPosition build() {
            try {
                if (this.f3093a != null) {
                    return new CameraPosition(this.f3093a, this.b, this.c, this.d);
                }
                Log.w("CameraPosition", "target is null");
                return null;
            } catch (Throwable th) {
                ct.a(th, "CameraPosition", "build");
                return null;
            }
        }

        public final Builder target(LatLng latLng) {
            this.f3093a = latLng;
            return this;
        }

        public final Builder tilt(float f) {
            this.c = f;
            return this;
        }

        public final Builder zoom(float f) {
            this.b = f;
            return this;
        }

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        if (latLng == null) {
            Log.w("CameraPosition", "构建CameraPosition时,位置(target)不能为null");
        }
        this.target = latLng;
        this.zoom = ct.b(f);
        this.tilt = ct.a(f2);
        this.bearing = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        if (latLng != null) {
            this.isAbroad = !cs.a(latLng.latitude, latLng.longitude);
        } else {
            this.isAbroad = false;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return ct.a(ct.a(com.umeng.ccg.a.F, this.target), ct.a("zoom", Float.valueOf(this.zoom)), ct.a("tilt", Float.valueOf(this.tilt)), ct.a("bearing", Float.valueOf(this.bearing)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.bearing);
        LatLng latLng = this.target;
        if (latLng != null) {
            parcel.writeFloat((float) latLng.latitude);
            parcel.writeFloat((float) this.target.longitude);
        }
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }
}
