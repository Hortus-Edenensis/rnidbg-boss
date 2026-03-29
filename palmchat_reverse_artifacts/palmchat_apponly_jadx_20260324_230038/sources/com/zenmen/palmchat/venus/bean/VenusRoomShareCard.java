package com.zenmen.palmchat.venus.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VenusRoomShareCard implements Parcelable {
    public static final Parcelable.Creator<VenusRoomShareCard> CREATOR = new Parcelable.Creator<VenusRoomShareCard>() { // from class: com.zenmen.palmchat.venus.bean.VenusRoomShareCard.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VenusRoomShareCard createFromParcel(Parcel parcel) {
            return new VenusRoomShareCard(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VenusRoomShareCard[] newArray(int i) {
            return new VenusRoomShareCard[i];
        }
    };
    public String avatar;
    public String channelCateText;
    public String channelId;
    public String channelTitle;
    public int channelType;
    public String content;
    public int gender;
    public String sceneId;
    public String uid;

    public VenusRoomShareCard() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.channelId);
        parcel.writeString(this.channelTitle);
        parcel.writeInt(this.channelType);
        parcel.writeString(this.avatar);
        parcel.writeString(this.sceneId);
        parcel.writeString(this.uid);
        parcel.writeInt(this.gender);
        parcel.writeString(this.content);
    }

    public VenusRoomShareCard(Parcel parcel) {
        this.channelId = parcel.readString();
        this.channelTitle = parcel.readString();
        this.channelType = parcel.readInt();
        this.avatar = parcel.readString();
        this.sceneId = parcel.readString();
        this.uid = parcel.readString();
        this.gender = parcel.readInt();
        this.content = parcel.readString();
    }
}
