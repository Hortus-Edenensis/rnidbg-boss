package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.col.p0002sl.ct;
import com.amap.api.maps2d.AMapException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class LatLngBounds implements Parcelable {
    public static final e CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3099a;
    public final LatLng northeast;
    public final LatLng southwest;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double f3100a = Double.POSITIVE_INFINITY;
        private double b = Double.NEGATIVE_INFINITY;
        private double c = Double.NaN;
        private double d = Double.NaN;

        private boolean a(double d) {
            double d2 = this.c;
            double d3 = this.d;
            return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
        }

        public final LatLngBounds build() {
            try {
                if (Double.isNaN(this.c)) {
                    Log.w("LatLngBounds", "no included points");
                    return null;
                }
                double d = this.c;
                double d2 = this.d;
                if (d > d2) {
                    this.c = d2;
                    this.d = d;
                }
                double d3 = this.f3100a;
                double d4 = this.b;
                if (d3 > d4) {
                    this.f3100a = d4;
                    this.b = d3;
                }
                return new LatLngBounds(new LatLng(this.f3100a, this.c), new LatLng(this.b, this.d));
            } catch (Throwable th) {
                ct.a(th, "LatLngBounds", "build");
                return null;
            }
        }

        public final Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.f3100a = Math.min(this.f3100a, latLng.latitude);
            this.b = Math.max(this.b, latLng.latitude);
            double d = latLng.longitude;
            if (!Double.isNaN(this.c)) {
                if (!a(d)) {
                    if (LatLngBounds.c(this.c, d) < LatLngBounds.d(this.d, d)) {
                        this.c = d;
                    }
                }
                return this;
            }
            this.c = d;
            this.d = d;
            return this;
        }
    }

    public LatLngBounds(int i, LatLng latLng, LatLng latLng2) throws AMapException {
        if (latLng == null) {
            throw new AMapException("null southwest");
        }
        if (latLng2 == null) {
            throw new AMapException("null northeast");
        }
        if (latLng2.latitude >= latLng.latitude) {
            this.f3099a = i;
            this.southwest = latLng;
            this.northeast = latLng2;
        } else {
            throw new AMapException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public final boolean contains(LatLng latLng) {
        return latLng != null && a(latLng.latitude) && b(latLng.longitude);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final int hashCode() {
        return ct.a(new Object[]{this.southwest, this.northeast});
    }

    public final LatLngBounds including(LatLng latLng) {
        if (latLng == null) {
            return this;
        }
        double dMin = Math.min(this.southwest.latitude, latLng.latitude);
        double dMax = Math.max(this.northeast.latitude, latLng.latitude);
        double d = latLng.longitude;
        try {
            return new LatLngBounds(new LatLng(dMin, d), new LatLng(dMax, d));
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public final boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        return a(latLngBounds) || latLngBounds.a(this);
    }

    public final String toString() {
        return ct.a(ct.a("southwest", this.southwest), ct.a("northeast", this.northeast));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel, i);
    }

    private boolean b(double d) {
        double d2 = this.southwest.longitude;
        double d3 = this.northeast.longitude;
        return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
    }

    public final int a() {
        return this.f3099a;
    }

    private boolean a(LatLngBounds latLngBounds) {
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        if (latLngBounds != null && (latLng = latLngBounds.northeast) != null && (latLng2 = latLngBounds.southwest) != null && (latLng3 = this.northeast) != null && (latLng4 = this.southwest) != null) {
            double d = latLng.longitude;
            double d2 = latLng2.longitude + d;
            double d3 = latLng3.longitude;
            double d4 = latLng4.longitude;
            double d5 = (d2 - d3) - d4;
            double d6 = ((d3 - d4) + d) - d4;
            double d7 = latLng.latitude;
            double d8 = latLng2.latitude;
            double d9 = latLng3.latitude;
            double d10 = latLng4.latitude;
            double d11 = ((d7 + d8) - d9) - d10;
            double d12 = ((d9 - d10) + d7) - d8;
            if (Math.abs(d5) < d6 && Math.abs(d11) < d12) {
                return true;
            }
        }
        return false;
    }

    public final boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    private boolean a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) throws AMapException {
        this(1, latLng, latLng2);
    }
}
