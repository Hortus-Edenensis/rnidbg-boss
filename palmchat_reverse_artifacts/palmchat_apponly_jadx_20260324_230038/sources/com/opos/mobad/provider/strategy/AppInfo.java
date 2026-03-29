package com.opos.mobad.provider.strategy;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new Parcelable.Creator<AppInfo>() { // from class: com.opos.mobad.provider.strategy.AppInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInfo createFromParcel(Parcel parcel) {
            long j = parcel.readLong();
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new AppInfo(j, bArr);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInfo[] newArray(int i) {
            return new AppInfo[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9176a;
    public final byte[] b;

    public AppInfo(long j, byte[] bArr) {
        this.f9176a = j;
        this.b = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f9176a);
        parcel.writeInt(this.b.length);
        parcel.writeByteArray(this.b);
    }
}
