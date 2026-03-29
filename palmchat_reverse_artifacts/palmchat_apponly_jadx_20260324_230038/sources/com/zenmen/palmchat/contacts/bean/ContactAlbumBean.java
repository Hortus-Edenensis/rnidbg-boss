package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ContactAlbumBean implements Parcelable {
    public static final Parcelable.Creator<ContactAlbumBean> CREATOR = new Parcelable.Creator<ContactAlbumBean>() { // from class: com.zenmen.palmchat.contacts.bean.ContactAlbumBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactAlbumBean createFromParcel(Parcel parcel) {
            return new ContactAlbumBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactAlbumBean[] newArray(int i) {
            return new ContactAlbumBean[i];
        }
    };
    private String albumMsg;
    private int albumcode;
    private List<ContactInfoItem.Portrait> imgList;

    public ContactAlbumBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbumMsg() {
        return this.albumMsg;
    }

    public int getAlbumcode() {
        return this.albumcode;
    }

    public List<ContactInfoItem.Portrait> getImgList() {
        return this.imgList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.imgList);
        parcel.writeInt(this.albumcode);
        parcel.writeString(this.albumMsg);
    }

    public ContactAlbumBean(Parcel parcel) {
        this.imgList = parcel.createTypedArrayList(ContactInfoItem.Portrait.CREATOR);
        this.albumcode = parcel.readInt();
        this.albumMsg = parcel.readString();
    }
}
