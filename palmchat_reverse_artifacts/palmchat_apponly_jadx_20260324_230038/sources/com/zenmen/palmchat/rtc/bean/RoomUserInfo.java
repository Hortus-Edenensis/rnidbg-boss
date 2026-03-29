package com.zenmen.palmchat.rtc.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.v4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class RoomUserInfo implements Parcelable {
    public static final Parcelable.Creator<RoomUserInfo> CREATOR = new a();
    public long entryTime;
    public String headImg;
    public String incomeTip;
    public int[] intention;
    public int level;
    public String nickName;
    public String openIDTip;
    public int sex;
    public int status;
    public String uid;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<RoomUserInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RoomUserInfo createFromParcel(Parcel parcel) {
            return new RoomUserInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RoomUserInfo[] newArray(int i) {
            return new RoomUserInfo[i];
        }
    }

    public RoomUserInfo() {
    }

    public static RoomUserInfo buildFromSelf() {
        RoomUserInfo roomUserInfo = new RoomUserInfo();
        ContactInfoItem contactInfoItemF = v4.f();
        if (contactInfoItemF != null) {
            roomUserInfo.headImg = contactInfoItemF.getIconURL();
            roomUserInfo.nickName = contactInfoItemF.getChatName();
            roomUserInfo.uid = contactInfoItemF.getUid();
        }
        return roomUserInfo;
    }

    public ContactInfoItem convert2ContactInfoItem() {
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(this.uid);
        contactInfoItem.setNickName(this.nickName);
        contactInfoItem.setIconURL(this.headImg);
        contactInfoItem.setGender(this.sex);
        return contactInfoItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeString(this.headImg);
        parcel.writeString(this.nickName);
        parcel.writeInt(this.status);
        parcel.writeLong(this.entryTime);
        parcel.writeInt(this.sex);
        parcel.writeIntArray(this.intention);
        parcel.writeString(this.incomeTip);
        parcel.writeString(this.openIDTip);
    }

    public RoomUserInfo(Parcel parcel) {
        this.uid = parcel.readString();
        this.headImg = parcel.readString();
        this.nickName = parcel.readString();
        this.status = parcel.readInt();
        this.entryTime = parcel.readLong();
        this.sex = parcel.readInt();
        this.intention = parcel.createIntArray();
        this.incomeTip = parcel.readString();
        this.openIDTip = parcel.readString();
    }
}
