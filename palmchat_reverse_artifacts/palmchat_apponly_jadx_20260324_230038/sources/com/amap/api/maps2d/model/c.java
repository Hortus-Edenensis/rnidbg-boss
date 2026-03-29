package com.amap.api.maps2d.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class c implements Parcelable.Creator<CircleOptions> {
    private static CircleOptions a(Parcel parcel) {
        CircleOptions circleOptions = new CircleOptions();
        Bundle bundle = parcel.readBundle();
        circleOptions.center(new LatLng(bundle.getDouble(com.umeng.analytics.pro.f.C), bundle.getDouble(com.umeng.analytics.pro.f.D)));
        circleOptions.radius(parcel.readDouble());
        circleOptions.strokeWidth(parcel.readFloat());
        circleOptions.strokeColor(parcel.readInt());
        circleOptions.fillColor(parcel.readInt());
        circleOptions.zIndex(parcel.readInt());
        circleOptions.visible(parcel.readByte() == 1);
        circleOptions.f3095a = parcel.readString();
        return circleOptions;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CircleOptions createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CircleOptions[] newArray(int i) {
        return a(i);
    }

    private static CircleOptions[] a(int i) {
        return new CircleOptions[i];
    }
}
