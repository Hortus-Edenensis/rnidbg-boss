package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GroupRedPacketVo implements Parcelable {
    public static final Parcelable.Creator<GroupRedPacketVo> CREATOR = new Parcelable.Creator<GroupRedPacketVo>() { // from class: com.zenmen.palmchat.Vo.GroupRedPacketVo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupRedPacketVo createFromParcel(Parcel parcel) {
            return new GroupRedPacketVo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupRedPacketVo[] newArray(int i) {
            return new GroupRedPacketVo[i];
        }
    };
    public String amount;
    public long countdown;
    public String countdownText;
    public String dest;
    public boolean display;
    public String iconUrl;
    public String issueAmount;
    public String issueAmountText;
    public String redDetailsLink;
    public String roomId;
    public String text;
    public String title;

    public GroupRedPacketVo(Parcel parcel) {
        this.roomId = parcel.readString();
        this.dest = parcel.readString();
        this.iconUrl = parcel.readString();
        this.title = parcel.readString();
        this.amount = parcel.readString();
        this.text = parcel.readString();
        this.display = parcel.readByte() != 0;
        this.countdownText = parcel.readString();
        this.countdown = parcel.readLong();
        this.issueAmountText = parcel.readString();
        this.issueAmount = parcel.readString();
        this.redDetailsLink = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.roomId);
        parcel.writeString(this.dest);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.amount);
        parcel.writeString(this.text);
        parcel.writeByte(this.display ? (byte) 1 : (byte) 0);
        parcel.writeString(this.countdownText);
        parcel.writeLong(this.countdown);
        parcel.writeString(this.issueAmountText);
        parcel.writeString(this.issueAmount);
        parcel.writeString(this.redDetailsLink);
    }
}
