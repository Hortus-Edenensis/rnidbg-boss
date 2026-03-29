package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class IndoorDataV2 implements Parcelable {
    public static final Parcelable.Creator<IndoorDataV2> CREATOR = new Parcelable.Creator<IndoorDataV2>() { // from class: com.amap.api.services.poisearch.IndoorDataV2.1
        private static IndoorDataV2 a(Parcel parcel) {
            return new IndoorDataV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorDataV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorDataV2[] newArray(int i) {
            return a(i);
        }

        private static IndoorDataV2[] a(int i) {
            return new IndoorDataV2[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3173a;
    private String b;
    private int c;
    private String d;

    public IndoorDataV2(boolean z, String str, int i, String str2) {
        this.f3173a = z;
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.c;
    }

    public String getFloorName() {
        return this.d;
    }

    public String getPoiId() {
        return this.b;
    }

    public boolean isIndoorMap() {
        return this.f3173a;
    }

    public void setFloor(int i) {
        this.c = i;
    }

    public void setFloorName(String str) {
        this.d = str;
    }

    public void setIndoorMap(boolean z) {
        this.f3173a = z;
    }

    public void setPoiId(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.f3173a});
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
    }

    public IndoorDataV2(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f3173a = zArr[0];
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readString();
    }
}
