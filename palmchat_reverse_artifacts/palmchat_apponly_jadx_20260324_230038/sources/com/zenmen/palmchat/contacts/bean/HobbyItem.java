package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class HobbyItem implements Parcelable {
    public static final Parcelable.Creator<HobbyItem> CREATOR = new Parcelable.Creator<HobbyItem>() { // from class: com.zenmen.palmchat.contacts.bean.HobbyItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HobbyItem createFromParcel(Parcel parcel) {
            return new HobbyItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HobbyItem[] newArray(int i) {
            return new HobbyItem[i];
        }
    };
    public String[] items;
    public String key;

    public HobbyItem(Parcel parcel) {
        this.items = parcel.createStringArray();
        this.key = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(this.items);
        parcel.writeString(this.key);
    }
}
