package com.opos.mobad.provider.openId;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OpenIdData implements Parcelable {
    public static final Parcelable.Creator<OpenIdData> CREATOR = new Parcelable.Creator<OpenIdData>() { // from class: com.opos.mobad.provider.openId.OpenIdData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OpenIdData createFromParcel(Parcel parcel) {
            return new OpenIdData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OpenIdData[] newArray(int i) {
            return new OpenIdData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9166a;
    public String b;
    public String c;
    public int d;

    public OpenIdData(int i) {
        this.d = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "OpenIdData{ouId='" + this.f9166a + "', duId='" + this.b + "', guId='" + this.c + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(TextUtils.isEmpty(this.f9166a) ? "" : this.f9166a);
        parcel.writeString(TextUtils.isEmpty(this.b) ? "" : this.b);
        parcel.writeString(TextUtils.isEmpty(this.c) ? "" : this.c);
    }

    public OpenIdData(String str, String str2, String str3) {
        this.f9166a = str;
        this.b = str2;
        this.c = str3;
    }
}
