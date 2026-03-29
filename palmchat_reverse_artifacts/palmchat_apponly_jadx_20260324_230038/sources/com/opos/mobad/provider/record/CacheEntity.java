package com.opos.mobad.provider.record;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class CacheEntity implements Parcelable {
    public static final Parcelable.Creator<CacheEntity> CREATOR = new Parcelable.Creator<CacheEntity>() { // from class: com.opos.mobad.provider.record.CacheEntity.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CacheEntity createFromParcel(Parcel parcel) {
            return new CacheEntity(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CacheEntity[] newArray(int i) {
            return new CacheEntity[0];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9170a;
    public final int b;

    public CacheEntity(int i, int i2) {
        this.f9170a = i;
        this.b = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9170a);
        parcel.writeInt(this.b);
    }
}
