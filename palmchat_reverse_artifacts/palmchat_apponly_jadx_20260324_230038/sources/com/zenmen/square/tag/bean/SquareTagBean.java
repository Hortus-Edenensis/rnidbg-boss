package com.zenmen.square.tag.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTagBean implements Parcelable {
    public static final Parcelable.Creator<SquareTagBean> CREATOR = new Parcelable.Creator<SquareTagBean>() { // from class: com.zenmen.square.tag.bean.SquareTagBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareTagBean createFromParcel(Parcel parcel) {
            return new SquareTagBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareTagBean[] newArray(int i) {
            return new SquareTagBean[i];
        }
    };
    public static final int RANK_HOT = 2;
    public static final int RANK_NEW = 1;
    public static final int SHOW_OFF = 2;
    public static final int SHOW_ON = 1;
    private boolean defaultTag;
    private int id;
    private String name;
    private String picUrl;
    private long publishCnt;
    private int rank;
    private int tagShow;

    public SquareTagBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public long getPublishCnt() {
        return this.publishCnt;
    }

    public int getRank() {
        return this.rank;
    }

    public int getTagShow() {
        return this.tagShow;
    }

    public boolean isDefaultTag() {
        return this.defaultTag;
    }

    public void setDefaultTag(boolean z) {
        this.defaultTag = z;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setPublishCnt(long j) {
        this.publishCnt = j;
    }

    public void setRank(int i) {
        this.rank = i;
    }

    public void setTagShow(int i) {
        this.tagShow = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.picUrl);
        parcel.writeLong(this.publishCnt);
        parcel.writeInt(this.rank);
        parcel.writeInt(this.tagShow);
        parcel.writeByte(this.defaultTag ? (byte) 1 : (byte) 0);
    }

    public SquareTagBean(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.picUrl = parcel.readString();
        this.publishCnt = parcel.readLong();
        this.rank = parcel.readInt();
        this.tagShow = parcel.readInt();
        this.defaultTag = parcel.readByte() != 0;
    }
}
