package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ApkSignerData extends a implements Parcelable {
    public static final Parcelable.Creator<ApkSignerData> CREATOR = new Parcelable.Creator<ApkSignerData>() { // from class: com.opos.mobad.model.data.ApkSignerData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkSignerData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            return new ApkSignerData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkSignerData[] newArray(int i) {
            return new ApkSignerData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9079a;
    public final String b;
    public final String c;

    public ApkSignerData(String str, String str2, String str3) {
        this.f9079a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ApkSignerData{md5=" + this.f9079a + ", sha1='" + this.b + "', sha256=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9079a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
