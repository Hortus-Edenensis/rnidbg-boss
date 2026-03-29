package com.amap.api.maps2d.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0002sl.ct;
import com.amap.api.maps2d.AMapException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class e implements Parcelable.Creator<LatLngBounds> {
    private static LatLngBounds a(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        int i = parcel.readInt();
        try {
            latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            } catch (BadParcelableException e) {
                e = e;
                ct.a(e, "LatLngBoundsCreator", "createFromParcel");
                latLng2 = null;
            }
        } catch (BadParcelableException e2) {
            e = e2;
            latLng = null;
        }
        try {
            return new LatLngBounds(i, latLng, latLng2);
        } catch (AMapException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLngBounds createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLngBounds[] newArray(int i) {
        return a(i);
    }

    private static LatLngBounds[] a(int i) {
        return new LatLngBounds[i];
    }

    public static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i);
        parcel.writeParcelable(latLngBounds.northeast, i);
    }
}
