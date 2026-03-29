package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class h implements Parcelable.Creator<PolygonOptions> {
    private static PolygonOptions a(Parcel parcel) {
        PolygonOptions polygonOptions = new PolygonOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float f = parcel.readFloat();
        int i = parcel.readInt();
        int i2 = parcel.readInt();
        float f2 = parcel.readFloat();
        boolean z = parcel.readByte() == 0;
        polygonOptions.add((LatLng[]) arrayList.toArray(new LatLng[arrayList.size()]));
        polygonOptions.strokeWidth(f);
        polygonOptions.strokeColor(i);
        polygonOptions.fillColor(i2);
        polygonOptions.zIndex(f2);
        polygonOptions.visible(z);
        polygonOptions.f3108a = parcel.readString();
        return polygonOptions;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolygonOptions createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolygonOptions[] newArray(int i) {
        return a(i);
    }

    private static PolygonOptions[] a(int i) {
        return new PolygonOptions[i];
    }
}
