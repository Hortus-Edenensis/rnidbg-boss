package com.opos.mobad.provider.strategy;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PosInfo implements Parcelable {
    public static final Parcelable.Creator<PosInfo> CREATOR = new Parcelable.Creator<PosInfo>() { // from class: com.opos.mobad.provider.strategy.PosInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PosInfo createFromParcel(Parcel parcel) {
            long j = parcel.readLong();
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new PosInfo(bArr, j);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PosInfo[] newArray(int i) {
            return new PosInfo[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f9177a;
    public final long b;

    public PosInfo(byte[] bArr, long j) {
        this.f9177a = bArr;
        this.b = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b);
        parcel.writeInt(this.f9177a.length);
        parcel.writeByteArray(this.f9177a);
    }
}
