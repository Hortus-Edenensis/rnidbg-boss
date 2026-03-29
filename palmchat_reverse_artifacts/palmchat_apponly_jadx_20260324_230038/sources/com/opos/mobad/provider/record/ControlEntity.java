package com.opos.mobad.provider.record;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ControlEntity implements Parcelable {
    public static final Parcelable.Creator<ControlEntity> CREATOR = new Parcelable.Creator<ControlEntity>() { // from class: com.opos.mobad.provider.record.ControlEntity.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ControlEntity createFromParcel(Parcel parcel) {
            return new ControlEntity(parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readLong(), parcel.readInt() == 1, parcel.readInt() == 1);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ControlEntity[] newArray(int i) {
            return new ControlEntity[0];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9171a;
    public final boolean b;
    public final boolean c;
    public final long d;
    public final boolean e;
    public final boolean f;

    public ControlEntity(boolean z, boolean z2, boolean z3, long j, boolean z4, boolean z5) {
        this.f9171a = z;
        this.b = z2;
        this.c = z3;
        this.d = j;
        this.e = z4;
        this.f = z5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9171a ? 1 : 0);
        parcel.writeInt(this.b ? 1 : 0);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeLong(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeInt(this.f ? 1 : 0);
    }
}
