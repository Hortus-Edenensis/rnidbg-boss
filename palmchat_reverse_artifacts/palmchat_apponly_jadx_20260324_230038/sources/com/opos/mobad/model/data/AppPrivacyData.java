package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AppPrivacyData extends a implements Parcelable {
    public static final Parcelable.Creator<AppPrivacyData> CREATOR = new Parcelable.Creator<AppPrivacyData>() { // from class: com.opos.mobad.model.data.AppPrivacyData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppPrivacyData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new AppPrivacyData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppPrivacyData[] newArray(int i) {
            return new AppPrivacyData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9081a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public AppPrivacyData(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f9081a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AppPrivacyData{permissionUrl=" + this.f9081a + ", privacyUrl='" + this.b + "', developerName=" + this.c + ", verName=" + this.d + ", companyName=" + this.e + ", funcDescUrl=" + this.f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9081a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }
}
