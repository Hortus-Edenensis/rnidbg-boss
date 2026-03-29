package com.zenmen.palmchat.settings;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AddressInfo implements Parcelable {
    public static final Parcelable.Creator<AddressInfo> CREATOR = new a();
    public ArrayList<AddressInfo> childList;
    public String key;
    public String name;
    public int type = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<AddressInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AddressInfo createFromParcel(Parcel parcel) {
            AddressInfo addressInfo = new AddressInfo();
            addressInfo.type = parcel.readInt();
            addressInfo.key = parcel.readString();
            addressInfo.name = parcel.readString();
            addressInfo.childList = parcel.readArrayList(AddressInfo.class.getClassLoader());
            return addressInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AddressInfo[] newArray(int i) {
            return new AddressInfo[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.key);
        parcel.writeString(this.name);
        parcel.writeArray(this.childList.toArray());
    }
}
