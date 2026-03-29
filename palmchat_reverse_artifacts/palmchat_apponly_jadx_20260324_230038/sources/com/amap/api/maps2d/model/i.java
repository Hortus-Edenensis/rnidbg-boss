package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class i implements Parcelable.Creator<PolylineOptions> {
    private static PolylineOptions a(Parcel parcel) {
        PolylineOptions polylineOptions = new PolylineOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float f = parcel.readFloat();
        int i = parcel.readInt();
        float f2 = parcel.readFloat();
        boolean z = parcel.readByte() == 1;
        polylineOptions.addAll(arrayList);
        polylineOptions.width(f);
        polylineOptions.color(i);
        polylineOptions.zIndex(f2);
        polylineOptions.visible(z);
        polylineOptions.f3110a = parcel.readString();
        boolean z2 = parcel.readByte() == 1;
        boolean z3 = parcel.readByte() == 1;
        polylineOptions.geodesic(z2);
        polylineOptions.setDottedLine(z3);
        return polylineOptions;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolylineOptions createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolylineOptions[] newArray(int i) {
        return a(i);
    }

    private static PolylineOptions[] a(int i) {
        return new PolylineOptions[i];
    }
}
