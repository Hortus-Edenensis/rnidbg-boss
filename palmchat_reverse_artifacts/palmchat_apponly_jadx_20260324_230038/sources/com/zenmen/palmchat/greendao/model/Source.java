package com.zenmen.palmchat.greendao.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
class Source implements Parcelable {
    public static final Parcelable.Creator<Source> CREATOR = new Parcelable.Creator<Source>() { // from class: com.zenmen.palmchat.greendao.model.Source.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Source createFromParcel(Parcel parcel) {
            return new Source(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Source[] newArray(int i) {
            return new Source[i];
        }
    };
    String icon;
    String name;

    public Source(Parcel parcel) {
        this.name = parcel.readString();
        this.icon = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.icon);
    }
}
