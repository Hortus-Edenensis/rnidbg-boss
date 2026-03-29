package com.zenmen.palmchat.chat.gift;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.zenmen.palmchat.contacts.bean.Amulet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ChatAmuletMessageExtensionBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<ChatAmuletMessageExtensionBean> CREATOR = new a();
    public String iconUrl;
    public int itemId;
    public int ornamentId;
    public int ornamentType;
    public String subTitle;
    public String title;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<ChatAmuletMessageExtensionBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChatAmuletMessageExtensionBean createFromParcel(Parcel parcel) {
            return new ChatAmuletMessageExtensionBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChatAmuletMessageExtensionBean[] newArray(int i) {
            return new ChatAmuletMessageExtensionBean[i];
        }
    }

    public ChatAmuletMessageExtensionBean(Parcel parcel) {
        this.title = parcel.readString();
        this.subTitle = parcel.readString();
        this.iconUrl = parcel.readString();
        this.ornamentId = parcel.readInt();
        this.itemId = parcel.readInt();
        this.ornamentType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Amulet getAmulet() {
        return new Amulet(this.ornamentType, this.iconUrl);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.ornamentId);
        parcel.writeInt(this.itemId);
        parcel.writeInt(this.ornamentType);
    }
}
