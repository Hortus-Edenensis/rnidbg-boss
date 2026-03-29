package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new Parcelable.Creator<LatLonPoint>() { // from class: com.amap.api.services.core.LatLonPoint.1
        private static LatLonPoint a(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint[] newArray(int i) {
            return a(i);
        }

        private static LatLonPoint[] a(int i) {
            return new LatLonPoint[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f3139a;
    private double b;

    public LatLonPoint(double d, double d2) {
        this.f3139a = d;
        this.b = d2;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f3139a, this.b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        return Double.doubleToLongBits(this.f3139a) == Double.doubleToLongBits(latLonPoint.f3139a) && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(latLonPoint.b);
    }

    public double getLatitude() {
        return this.f3139a;
    }

    public double getLongitude() {
        return this.b;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f3139a);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.b);
        return (i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public void setLatitude(double d) {
        this.f3139a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public String toString() {
        return this.f3139a + "," + this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f3139a);
        parcel.writeDouble(this.b);
    }

    public LatLonPoint(Parcel parcel) {
        this.f3139a = parcel.readDouble();
        this.b = parcel.readDouble();
    }
}
