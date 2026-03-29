package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class MarkerOptions implements Parcelable {
    public static final g CREATOR = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3102a;
    private LatLng b;
    private String c;
    private String d;
    private float j;
    private float e = 0.5f;
    private float f = 1.0f;
    private boolean g = false;
    private boolean h = true;
    private boolean i = false;
    private ArrayList<BitmapDescriptor> k = new ArrayList<>();
    private int l = 20;

    private void a() {
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
    }

    public final MarkerOptions anchor(float f, float f2) {
        this.e = f;
        this.f = f2;
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final MarkerOptions draggable(boolean z) {
        this.g = z;
        return this;
    }

    public final float getAnchorU() {
        return this.e;
    }

    public final float getAnchorV() {
        return this.f;
    }

    public final BitmapDescriptor getIcon() {
        ArrayList<BitmapDescriptor> arrayList = this.k;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.k.get(0);
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        return this.k;
    }

    public final int getPeriod() {
        return this.l;
    }

    public final LatLng getPosition() {
        return this.b;
    }

    public final String getSnippet() {
        return this.d;
    }

    public final String getTitle() {
        return this.c;
    }

    public final float getZIndex() {
        return this.j;
    }

    public final MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        try {
            a();
            this.k.clear();
            this.k.add(bitmapDescriptor);
        } catch (Throwable unused) {
        }
        return this;
    }

    public final MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        this.k = arrayList;
        return this;
    }

    public final boolean isDraggable() {
        return this.g;
    }

    public final boolean isGps() {
        return this.i;
    }

    public final boolean isVisible() {
        return this.h;
    }

    public final MarkerOptions period(int i) {
        if (i <= 1) {
            this.l = 1;
        } else {
            this.l = i;
        }
        return this;
    }

    public final MarkerOptions position(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public final MarkerOptions setGps(boolean z) {
        this.i = z;
        return this;
    }

    public final MarkerOptions snippet(String str) {
        this.d = str;
        return this;
    }

    public final MarkerOptions title(String str) {
        this.c = str;
        return this;
    }

    public final MarkerOptions visible(boolean z) {
        this.h = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
        ArrayList<BitmapDescriptor> arrayList = this.k;
        if (arrayList != null && arrayList.size() != 0) {
            parcel.writeParcelable(this.k.get(0), i);
        }
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f3102a);
        parcel.writeFloat(this.j);
        parcel.writeList(this.k);
    }

    public final MarkerOptions zIndex(float f) {
        this.j = f;
        return this;
    }
}
