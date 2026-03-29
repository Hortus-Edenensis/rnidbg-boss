package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class g implements Parcelable.Creator<MarkerOptions> {
    private static MarkerOptions a(Parcel parcel) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position((LatLng) parcel.readParcelable(LatLng.class.getClassLoader()));
        markerOptions.icon((BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
        markerOptions.title(parcel.readString());
        markerOptions.snippet(parcel.readString());
        markerOptions.anchor(parcel.readFloat(), parcel.readFloat());
        markerOptions.visible(parcel.readByte() == 1);
        markerOptions.draggable(parcel.readByte() == 1);
        markerOptions.setGps(parcel.readByte() == 1);
        markerOptions.f3102a = parcel.readString();
        markerOptions.zIndex(parcel.readFloat());
        markerOptions.icons(parcel.createTypedArrayList(BitmapDescriptor.f3092a));
        return markerOptions;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions[] newArray(int i) {
        return a(i);
    }

    private static MarkerOptions[] a(int i) {
        return new MarkerOptions[i];
    }
}
