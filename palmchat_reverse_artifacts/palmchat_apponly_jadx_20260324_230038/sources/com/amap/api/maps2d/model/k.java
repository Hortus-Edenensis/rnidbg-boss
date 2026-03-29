package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class k implements Parcelable.Creator<TileOverlayOptions> {
    private static TileOverlayOptions a(Parcel parcel) {
        int i = parcel.readInt();
        TileProvider tileProvider = (TileProvider) parcel.readValue(TileProvider.class.getClassLoader());
        boolean z = parcel.readByte() != 0;
        float f = parcel.readFloat();
        int i2 = parcel.readInt();
        int i3 = parcel.readInt();
        String string = parcel.readString();
        boolean z2 = parcel.readByte() != 0;
        boolean z3 = parcel.readByte() != 0;
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions(i, z, f);
        if (tileProvider != null) {
            tileOverlayOptions.tileProvider(tileProvider);
        }
        tileOverlayOptions.memCacheSize(i2);
        tileOverlayOptions.diskCacheSize(i3);
        tileOverlayOptions.diskCacheDir(string);
        tileOverlayOptions.memoryCacheEnabled(z2);
        tileOverlayOptions.diskCacheEnabled(z3);
        return tileOverlayOptions;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TileOverlayOptions createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TileOverlayOptions[] newArray(int i) {
        return a(i);
    }

    private static TileOverlayOptions[] a(int i) {
        return new TileOverlayOptions[i];
    }
}
