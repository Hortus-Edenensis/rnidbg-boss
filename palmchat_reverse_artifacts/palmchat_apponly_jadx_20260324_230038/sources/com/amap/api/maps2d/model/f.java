package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class f implements Parcelable.Creator<LatLng> {
    private static LatLng a(Parcel parcel) {
        return new LatLng(parcel.readDouble(), parcel.readDouble());
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLng createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLng[] newArray(int i) {
        return a(i);
    }

    private static LatLng[] a(int i) {
        return new LatLng[i];
    }
}
