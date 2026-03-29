package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class Realestate implements Parcelable {
    public static final Parcelable.Creator<Realestate> CREATOR = new Parcelable.Creator<Realestate>() { // from class: com.zenmen.palmchat.contacts.bean.Realestate.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Realestate createFromParcel(Parcel parcel) {
            return new Realestate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Realestate[] newArray(int i) {
            return new Realestate[i];
        }
    };
    public String city;
    public String nation;
    public String province;
    public int realestate;

    public Realestate(Parcel parcel) {
        this.nation = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.realestate = parcel.readInt();
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
        parcel.writeInt(this.realestate);
    }
}
