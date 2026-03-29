package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RichMsgExVo implements Parcelable {
    public static final Parcelable.Creator<RichMsgExVo> CREATOR = new Parcelable.Creator<RichMsgExVo>() { // from class: com.zenmen.palmchat.Vo.RichMsgExVo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RichMsgExVo createFromParcel(Parcel parcel) {
            return new RichMsgExVo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RichMsgExVo[] newArray(int i) {
            return new RichMsgExVo[i];
        }
    };
    public int _exType;
    public AdditionItem footer;
    public int forwardable;
    public AdditionItem header;
    public ArrayList<RichMsgExItemVo> items;
    public NoticeBarStyle noticeBar;
    public AdditionItem source;

    public RichMsgExVo() {
        this._exType = 2;
        this.forwardable = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this._exType);
        parcel.writeInt(this.forwardable);
        parcel.writeParcelable(this.noticeBar, i);
        parcel.writeTypedList(this.items);
        parcel.writeParcelable(this.header, i);
        parcel.writeParcelable(this.footer, i);
        parcel.writeParcelable(this.source, i);
    }

    public RichMsgExVo(Parcel parcel) {
        this._exType = 2;
        this.forwardable = 0;
        this._exType = parcel.readInt();
        this.forwardable = parcel.readInt();
        this.noticeBar = (NoticeBarStyle) parcel.readParcelable(NoticeBarStyle.class.getClassLoader());
        this.items = parcel.createTypedArrayList(RichMsgExItemVo.CREATOR);
        this.header = (AdditionItem) parcel.readParcelable(AdditionItem.class.getClassLoader());
        this.footer = (AdditionItem) parcel.readParcelable(AdditionItem.class.getClassLoader());
        this.source = (AdditionItem) parcel.readParcelable(AdditionItem.class.getClassLoader());
    }
}
