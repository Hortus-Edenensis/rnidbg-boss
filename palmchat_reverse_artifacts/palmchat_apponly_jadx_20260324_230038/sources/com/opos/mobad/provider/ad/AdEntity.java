package com.opos.mobad.provider.ad;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AdEntity implements Parcelable {
    public static final Parcelable.Creator<AdEntity> CREATOR = new Parcelable.Creator<AdEntity>() { // from class: com.opos.mobad.provider.ad.AdEntity.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdEntity createFromParcel(Parcel parcel) {
            return new AdEntity(parcel.createByteArray(), parcel.createByteArray(), parcel.readLong(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdEntity[] newArray(int i) {
            return new AdEntity[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f9161a;
    public byte[] b;
    public long c;
    public int d;

    public AdEntity(byte[] bArr, byte[] bArr2, long j, int i) {
        this.f9161a = bArr;
        this.b = bArr2;
        this.c = j;
        this.d = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.f9161a);
        parcel.writeByteArray(this.b);
        parcel.writeLong(this.c);
        parcel.writeInt(this.d);
    }
}
