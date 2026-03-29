package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ContactLocalExt implements Parcelable {
    public static final Parcelable.Creator<ContactLocalExt> CREATOR = new Parcelable.Creator<ContactLocalExt>() { // from class: com.zenmen.palmchat.contacts.bean.ContactLocalExt.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactLocalExt createFromParcel(Parcel parcel) {
            return new ContactLocalExt(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactLocalExt[] newArray(int i) {
            return new ContactLocalExt[i];
        }
    };
    public float intimacyScore;

    public ContactLocalExt() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.intimacyScore);
    }

    public ContactLocalExt(Parcel parcel) {
        this.intimacyScore = parcel.readFloat();
    }
}
