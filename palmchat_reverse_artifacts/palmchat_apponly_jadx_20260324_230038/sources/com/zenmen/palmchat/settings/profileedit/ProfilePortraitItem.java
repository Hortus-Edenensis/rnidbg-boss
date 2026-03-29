package com.zenmen.palmchat.settings.profileedit;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ProfilePortraitItem implements Parcelable {
    public static final Parcelable.Creator<ProfilePortraitItem> CREATOR = new a();
    public String thumbUrl;
    public int type;
    public String url;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<ProfilePortraitItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProfilePortraitItem createFromParcel(Parcel parcel) {
            return new ProfilePortraitItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ProfilePortraitItem[] newArray(int i) {
            return new ProfilePortraitItem[i];
        }
    }

    public ProfilePortraitItem(int i, String str, String str2) {
        this.type = i;
        this.url = str;
        this.thumbUrl = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.url);
        parcel.writeString(this.thumbUrl);
    }

    public ProfilePortraitItem(Parcel parcel) {
        this.type = parcel.readInt();
        this.url = parcel.readString();
        this.thumbUrl = parcel.readString();
    }
}
