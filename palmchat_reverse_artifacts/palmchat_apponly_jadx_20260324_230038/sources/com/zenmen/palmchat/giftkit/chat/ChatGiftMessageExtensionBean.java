package com.zenmen.palmchat.giftkit.chat;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class ChatGiftMessageExtensionBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<ChatGiftMessageExtensionBean> CREATOR = new a();
    public String action;
    public long comboNumber;
    public String iconUrl;
    public long itemCount;
    public long itemId;
    public String itemName;
    public int itemType;
    public int priceLevel;
    public String relatedId;
    public String showIconUrl;
    public String subTitle;
    public String title;
    public GiftReceiverInfo toUser;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<ChatGiftMessageExtensionBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChatGiftMessageExtensionBean createFromParcel(Parcel parcel) {
            return new ChatGiftMessageExtensionBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChatGiftMessageExtensionBean[] newArray(int i) {
            return new ChatGiftMessageExtensionBean[i];
        }
    }

    public ChatGiftMessageExtensionBean(Parcel parcel) {
        this.title = parcel.readString();
        this.subTitle = parcel.readString();
        this.action = parcel.readString();
        this.itemId = parcel.readLong();
        this.itemName = parcel.readString();
        this.iconUrl = parcel.readString();
        this.showIconUrl = parcel.readString();
        this.itemCount = parcel.readLong();
        this.comboNumber = parcel.readLong();
        this.priceLevel = parcel.readInt();
        this.relatedId = parcel.readString();
        this.itemType = parcel.readInt();
        this.toUser = (GiftReceiverInfo) parcel.readParcelable(GiftReceiverInfo.class.getClassLoader());
    }

    @NonNull
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.action);
        parcel.writeLong(this.itemId);
        parcel.writeString(this.itemName);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.showIconUrl);
        parcel.writeLong(this.itemCount);
        parcel.writeLong(this.comboNumber);
        parcel.writeInt(this.priceLevel);
        parcel.writeString(this.relatedId);
        parcel.writeInt(this.itemType);
        parcel.writeParcelable(this.toUser, i);
    }
}
