package com.tencent.turingfd.sdk.ams.ad;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Codlin implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10682a;
    public byte[] b;
    public int c;

    public Codlin(Parcel parcel) {
        this.f10682a = parcel.readInt();
        this.b = parcel.createByteArray();
        this.c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10682a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
    }
}
