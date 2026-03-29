package com.zenmen.palmchat.peoplematch.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class PeopleMatchPhotoBean implements BaseRecyclerViewAdapter.c, Parcelable {
    public static final int APPROVED = 2;
    public static final Parcelable.Creator<PeopleMatchPhotoBean> CREATOR = new Parcelable.Creator<PeopleMatchPhotoBean>() { // from class: com.zenmen.palmchat.peoplematch.bean.PeopleMatchPhotoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeopleMatchPhotoBean createFromParcel(Parcel parcel) {
            return new PeopleMatchPhotoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeopleMatchPhotoBean[] newArray(int i) {
            return new PeopleMatchPhotoBean[i];
        }
    };
    public static final int INVALID = 3;
    private boolean coverStatus;
    private boolean isAdd;
    private boolean isLastPhoto;
    private boolean isPerson;
    private String pictureId;
    private int realMatchStatus;
    private int status;
    private String url;

    public PeopleMatchPhotoBean() {
        this.status = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getId() {
        return 0L;
    }

    public String getPictureId() {
        return this.pictureId;
    }

    public int getRealMatchStatus() {
        return this.realMatchStatus;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isAdd() {
        return this.isAdd;
    }

    public boolean isCoverStatus() {
        return this.coverStatus;
    }

    public boolean isLastPhoto() {
        return this.isLastPhoto;
    }

    public boolean isPerson() {
        return this.isPerson;
    }

    public void setAdd(boolean z) {
        this.isAdd = z;
    }

    public void setCoverStatus(boolean z) {
        this.coverStatus = z;
    }

    public void setLastPhoto(boolean z) {
        this.isLastPhoto = z;
    }

    public void setPerson(boolean z) {
        this.isPerson = z;
    }

    public void setPictureId(String str) {
        this.pictureId = str;
    }

    public void setRealMatchStatus(int i) {
        this.realMatchStatus = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pictureId);
        parcel.writeString(this.url);
        parcel.writeByte(this.coverStatus ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.status);
        parcel.writeInt(this.realMatchStatus);
        parcel.writeByte(this.isPerson ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAdd ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isLastPhoto ? (byte) 1 : (byte) 0);
    }

    public PeopleMatchPhotoBean(Parcel parcel) {
        this.status = 0;
        this.pictureId = parcel.readString();
        this.url = parcel.readString();
        this.coverStatus = parcel.readByte() != 0;
        this.status = parcel.readInt();
        this.realMatchStatus = parcel.readInt();
        this.isPerson = parcel.readByte() != 0;
        this.isAdd = parcel.readByte() != 0;
        this.isLastPhoto = parcel.readByte() != 0;
    }
}
