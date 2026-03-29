package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MaterialFileData extends a implements Parcelable {
    public static final Parcelable.Creator<MaterialFileData> CREATOR = new Parcelable.Creator<MaterialFileData>() { // from class: com.opos.mobad.model.data.MaterialFileData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialFileData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            MaterialFileData materialFileData = new MaterialFileData();
            materialFileData.a(parcel.readString());
            materialFileData.b(parcel.readString());
            materialFileData.a(parcel.readInt());
            materialFileData.b(parcel.readInt());
            return materialFileData;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialFileData[] newArray(int i) {
            return new MaterialFileData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9090a;
    private String b;
    private int c;
    private int d;

    public String a() {
        return this.f9090a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MaterialFileData{url='" + this.f9090a + "', md5='" + this.b + "', height=" + this.c + ", width=" + this.d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9090a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public void a(String str) {
        this.f9090a = str;
    }

    public void b(String str) {
        this.b = str;
    }
}
