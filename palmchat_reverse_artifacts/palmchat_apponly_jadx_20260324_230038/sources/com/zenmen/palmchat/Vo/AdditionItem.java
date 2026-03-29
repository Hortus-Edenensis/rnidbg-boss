package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class AdditionItem implements Parcelable {
    public static final Parcelable.Creator<AdditionItem> CREATOR = new Parcelable.Creator<AdditionItem>() { // from class: com.zenmen.palmchat.Vo.AdditionItem.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdditionItem createFromParcel(Parcel parcel) {
            return new AdditionItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdditionItem[] newArray(int i) {
            return new AdditionItem[i];
        }
    };
    public String icon;
    public String id;
    public String name;

    public AdditionItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.icon);
    }

    public AdditionItem(Parcel parcel) {
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.icon = parcel.readString();
    }
}
