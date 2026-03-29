package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class b implements Parcelable.Creator<CameraPosition> {
    private static CameraPosition a(Parcel parcel) {
        float f = parcel.readFloat();
        float f2 = parcel.readFloat();
        float f3 = parcel.readFloat();
        return new CameraPosition(new LatLng(f2, f3), parcel.readFloat(), parcel.readFloat(), f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition[] newArray(int i) {
        return a(i);
    }

    private static CameraPosition[] a(int i) {
        return new CameraPosition[i];
    }
}
