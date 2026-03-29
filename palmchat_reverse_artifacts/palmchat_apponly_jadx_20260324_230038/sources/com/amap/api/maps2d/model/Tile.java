package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Tile implements Parcelable {
    public static final j CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3114a;
    private final int b;
    private final int c;
    public final byte[] data;

    public Tile(int i, int i2, int i3, byte[] bArr) {
        this.f3114a = i;
        this.b = i2;
        this.c = i3;
        this.data = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3114a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeByteArray(this.data);
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }
}
