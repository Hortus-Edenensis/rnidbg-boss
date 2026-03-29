package com.amap.api.maps2d.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class CircleOptions implements Parcelable {
    public static final c CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3095a;
    private LatLng b = null;
    private double c = 0.0d;
    private float d = 10.0f;
    private int e = -16777216;
    private int f = 0;
    private float g = 0.0f;
    private boolean h = true;

    public final CircleOptions center(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final CircleOptions fillColor(int i) {
        this.f = i;
        return this;
    }

    public final LatLng getCenter() {
        return this.b;
    }

    public final int getFillColor() {
        return this.f;
    }

    public final double getRadius() {
        return this.c;
    }

    public final int getStrokeColor() {
        return this.e;
    }

    public final float getStrokeWidth() {
        return this.d;
    }

    public final float getZIndex() {
        return this.g;
    }

    public final boolean isVisible() {
        return this.h;
    }

    public final CircleOptions radius(double d) {
        this.c = d;
        return this;
    }

    public final CircleOptions strokeColor(int i) {
        this.e = i;
        return this;
    }

    public final CircleOptions strokeWidth(float f) {
        this.d = f;
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.h = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.b;
        if (latLng != null) {
            bundle.putDouble(com.umeng.analytics.pro.f.C, latLng.latitude);
            bundle.putDouble(com.umeng.analytics.pro.f.D, this.b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.c);
        parcel.writeFloat(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeFloat(this.g);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f3095a);
    }

    public final CircleOptions zIndex(float f) {
        this.g = f;
        return this;
    }
}
