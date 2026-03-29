package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class PolylineOptions implements Parcelable {
    public static final i CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3110a;
    private float c = 10.0f;
    private int d = -16777216;
    private float e = 0.0f;
    private boolean f = true;
    private boolean g = false;
    private boolean h = false;
    private final List<LatLng> b = new ArrayList();

    public final PolylineOptions add(LatLng latLng) {
        this.b.add(latLng);
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<LatLng> it = iterable.iterator();
                while (it != null && it.hasNext()) {
                    arrayList.add(it.next());
                }
                this.b.addAll(arrayList);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final PolylineOptions color(int i) {
        this.d = i;
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final PolylineOptions geodesic(boolean z) {
        this.g = z;
        return this;
    }

    public final int getColor() {
        return this.d;
    }

    public final List<LatLng> getPoints() {
        return this.b;
    }

    public final float getWidth() {
        return this.c;
    }

    public final float getZIndex() {
        return this.e;
    }

    public final boolean isDottedLine() {
        return this.h;
    }

    public final boolean isGeodesic() {
        return this.g;
    }

    public final boolean isVisible() {
        return this.f;
    }

    public final PolylineOptions setDottedLine(boolean z) {
        this.h = z;
        return this;
    }

    public final PolylineOptions visible(boolean z) {
        this.f = z;
        return this;
    }

    public final PolylineOptions width(float f) {
        this.c = f;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(getPoints());
        parcel.writeFloat(getWidth());
        parcel.writeInt(getColor());
        parcel.writeFloat(getZIndex());
        parcel.writeByte(isVisible() ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f3110a);
        parcel.writeByte(isGeodesic() ? (byte) 1 : (byte) 0);
        parcel.writeByte(isDottedLine() ? (byte) 1 : (byte) 0);
    }

    public final PolylineOptions zIndex(float f) {
        this.e = f;
        return this;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        this.b.addAll(Arrays.asList(latLngArr));
        return this;
    }
}
