package com.zenmen.palmchat.giftkit.chat;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class GiftMessageExtensionBean implements Parcelable {
    public static final Parcelable.Creator<GiftMessageExtensionBean> CREATOR = new a();
    public String dynamicType;
    public String dynamicUrl;
    public int giftId;
    public String openDesc;
    public String openGiftName;
    public String openIcon;
    public String openSubTitle;
    public String unOpenDesc;
    public String unOpenGiftName;
    public String unOpenIcon;
    public String unOpenSubBtn;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<GiftMessageExtensionBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GiftMessageExtensionBean createFromParcel(Parcel parcel) {
            return new GiftMessageExtensionBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GiftMessageExtensionBean[] newArray(int i) {
            return new GiftMessageExtensionBean[i];
        }
    }

    public GiftMessageExtensionBean(Parcel parcel) {
        this.unOpenIcon = parcel.readString();
        this.openIcon = parcel.readString();
        this.giftId = parcel.readInt();
        this.unOpenGiftName = parcel.readString();
        this.openGiftName = parcel.readString();
        this.unOpenSubBtn = parcel.readString();
        this.openSubTitle = parcel.readString();
        this.unOpenDesc = parcel.readString();
        this.openDesc = parcel.readString();
        this.dynamicUrl = parcel.readString();
        this.dynamicType = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.unOpenIcon);
        parcel.writeString(this.openIcon);
        parcel.writeInt(this.giftId);
        parcel.writeString(this.unOpenGiftName);
        parcel.writeString(this.openGiftName);
        parcel.writeString(this.unOpenSubBtn);
        parcel.writeString(this.openSubTitle);
        parcel.writeString(this.unOpenDesc);
        parcel.writeString(this.openDesc);
        parcel.writeString(this.dynamicUrl);
        parcel.writeString(this.dynamicType);
    }
}
