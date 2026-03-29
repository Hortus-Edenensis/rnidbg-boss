package com.amap.api.maps2d.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class a implements Parcelable.Creator<BitmapDescriptor> {
    private static BitmapDescriptor a(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(null);
        bitmapDescriptor.d = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        bitmapDescriptor.b = parcel.readInt();
        bitmapDescriptor.c = parcel.readInt();
        return bitmapDescriptor;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BitmapDescriptor createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BitmapDescriptor[] newArray(int i) {
        return a(i);
    }

    private static BitmapDescriptor[] a(int i) {
        return new BitmapDescriptor[i];
    }
}
