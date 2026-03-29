package com.amap.api.maps2d.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0002sl.ct;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class l implements Parcelable.Creator<VisibleRegion> {
    private static VisibleRegion a(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        LatLng latLng5;
        LatLngBounds latLngBounds;
        int i = parcel.readInt();
        try {
            latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                    try {
                        latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                    } catch (BadParcelableException e) {
                        e = e;
                        latLng = null;
                    }
                } catch (BadParcelableException e2) {
                    e = e2;
                    latLng = null;
                    latLng4 = null;
                }
            } catch (BadParcelableException e3) {
                e = e3;
                latLng = null;
                latLng3 = null;
                latLng4 = latLng3;
                ct.a(e, "VisibleRegionCreator", "createFromParcel");
                latLng5 = latLng;
                latLngBounds = null;
                return new VisibleRegion(i, latLng2, latLng3, latLng4, latLng5, latLngBounds);
            }
            try {
                latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                latLng5 = latLng;
            } catch (BadParcelableException e4) {
                e = e4;
                ct.a(e, "VisibleRegionCreator", "createFromParcel");
                latLng5 = latLng;
                latLngBounds = null;
            }
        } catch (BadParcelableException e5) {
            e = e5;
            latLng = null;
            latLng2 = null;
            latLng3 = null;
        }
        return new VisibleRegion(i, latLng2, latLng3, latLng4, latLng5, latLngBounds);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisibleRegion createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisibleRegion[] newArray(int i) {
        return a(i);
    }

    private static VisibleRegion[] a(int i) {
        return new VisibleRegion[i];
    }

    public static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i);
        parcel.writeParcelable(visibleRegion.nearRight, i);
        parcel.writeParcelable(visibleRegion.farLeft, i);
        parcel.writeParcelable(visibleRegion.farRight, i);
        parcel.writeParcelable(visibleRegion.latLngBounds, i);
    }
}
