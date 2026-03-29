package com.zenmen.square.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareChatCheckBean implements Parcelable {
    public static final Parcelable.Creator<SquareChatCheckBean> CREATOR = new Parcelable.Creator<SquareChatCheckBean>() { // from class: com.zenmen.square.bean.SquareChatCheckBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareChatCheckBean createFromParcel(Parcel parcel) {
            return new SquareChatCheckBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareChatCheckBean[] newArray(int i) {
            return new SquareChatCheckBean[i];
        }
    };
    public String alertMsg;
    public boolean allowSend;
    public boolean isVip;
    public boolean needAlert;
    public boolean needVipCounts;
    public int statusCode;
    public int vipCounts;

    public SquareChatCheckBean(Parcel parcel) {
        this.allowSend = parcel.readByte() != 0;
        this.isVip = parcel.readByte() != 0;
        this.needVipCounts = parcel.readByte() != 0;
        this.vipCounts = parcel.readInt();
        this.needAlert = parcel.readByte() != 0;
        this.alertMsg = parcel.readString();
        this.statusCode = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.allowSend ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVip ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needVipCounts ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.vipCounts);
        parcel.writeByte(this.needAlert ? (byte) 1 : (byte) 0);
        parcel.writeString(this.alertMsg);
        parcel.writeInt(this.statusCode);
    }
}
