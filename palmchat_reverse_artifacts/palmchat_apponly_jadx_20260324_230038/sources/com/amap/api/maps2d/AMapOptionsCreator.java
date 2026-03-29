package com.amap.api.maps2d;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps2d.model.CameraPosition;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AMapOptionsCreator implements Parcelable.Creator<AMapOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AMapOptions createFromParcel(Parcel parcel) {
        AMapOptions aMapOptions = new AMapOptions();
        CameraPosition cameraPosition = (CameraPosition) parcel.readParcelable(CameraPosition.class.getClassLoader());
        aMapOptions.mapType(parcel.readInt());
        aMapOptions.camera(cameraPosition);
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        if (zArrCreateBooleanArray != null && zArrCreateBooleanArray.length >= 6) {
            aMapOptions.scrollGesturesEnabled(zArrCreateBooleanArray[0]);
            aMapOptions.zoomGesturesEnabled(zArrCreateBooleanArray[1]);
            aMapOptions.zoomControlsEnabled(zArrCreateBooleanArray[2]);
            aMapOptions.zOrderOnTop(zArrCreateBooleanArray[3]);
            aMapOptions.compassEnabled(zArrCreateBooleanArray[4]);
            aMapOptions.scaleControlsEnabled(zArrCreateBooleanArray[5]);
        }
        return aMapOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AMapOptions[] newArray(int i) {
        return new AMapOptions[i];
    }
}
