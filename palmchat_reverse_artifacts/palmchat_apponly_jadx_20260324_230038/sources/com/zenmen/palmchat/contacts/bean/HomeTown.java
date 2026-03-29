package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class HomeTown implements Parcelable {
    public static final Parcelable.Creator<HomeTown> CREATOR = new Parcelable.Creator<HomeTown>() { // from class: com.zenmen.palmchat.contacts.bean.HomeTown.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HomeTown createFromParcel(Parcel parcel) {
            return new HomeTown(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HomeTown[] newArray(int i) {
            return new HomeTown[i];
        }
    };
    public String city;
    public String nation;
    public String province;

    public HomeTown(String str, String str2, String str3) {
        this.nation = str;
        this.province = str2;
        this.city = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nation);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
    }

    public HomeTown(Parcel parcel) {
        this.nation = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
    }
}
