package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class PolygonOptions implements Parcelable {
    public static final h CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3108a;
    private float c = 10.0f;
    private int d = -16777216;
    private int e = -16777216;
    private float f = 0.0f;
    private boolean g = true;
    private final List<LatLng> b = new ArrayList();

    public final PolygonOptions add(LatLng latLng) {
        this.b.add(latLng);
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable == null) {
            return this;
        }
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
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final PolygonOptions fillColor(int i) {
        this.e = i;
        return this;
    }

    public final int getFillColor() {
        return this.e;
    }

    public final List<LatLng> getPoints() {
        return this.b;
    }

    public final int getStrokeColor() {
        return this.d;
    }

    public final float getStrokeWidth() {
        return this.c;
    }

    public final float getZIndex() {
        return this.f;
    }

    public final boolean isVisible() {
        return this.g;
    }

    public final PolygonOptions strokeColor(int i) {
        this.d = i;
        return this;
    }

    public final PolygonOptions strokeWidth(float f) {
        this.c = f;
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.g = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f);
        parcel.writeByte((byte) (!this.g ? 1 : 0));
        parcel.writeString(this.f3108a);
    }

    public final PolygonOptions zIndex(float f) {
        this.f = f;
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        this.b.addAll(Arrays.asList(latLngArr));
        return this;
    }
}
