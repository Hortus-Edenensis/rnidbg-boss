package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class Vip implements Parcelable {
    public static final Parcelable.Creator<Vip> CREATOR = new Parcelable.Creator<Vip>() { // from class: com.zenmen.palmchat.contacts.bean.Vip.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Vip createFromParcel(Parcel parcel) {
            return new Vip(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Vip[] newArray(int i) {
            return new Vip[i];
        }
    };
    public static final boolean TEST = false;
    public int status;
    public int type;

    public Vip(Parcel parcel) {
        this.status = parcel.readInt();
        this.type = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.status);
        parcel.writeInt(this.type);
    }
}
