package com.zenmen.square.mvp.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MediaForChatCard implements Parcelable {
    public static final Parcelable.Creator<MediaForChatCard> CREATOR = new Parcelable.Creator<MediaForChatCard>() { // from class: com.zenmen.square.mvp.model.bean.MediaForChatCard.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaForChatCard createFromParcel(Parcel parcel) {
            return new MediaForChatCard(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaForChatCard[] newArray(int i) {
            return new MediaForChatCard[i];
        }
    };
    public String height;
    public double latitude;
    public String localPath;
    public String location;
    public double longitude;
    public String midUrl;
    public Integer picSource;
    public long shootingTime;
    public String thumbUrl;
    public String url;
    public String videoUrl;
    public String width;

    public MediaForChatCard() {
    }

    public static MediaForChatCard parse(Media media) {
        if (media == null) {
            return null;
        }
        MediaForChatCard mediaForChatCard = new MediaForChatCard();
        mediaForChatCard.url = media.url;
        mediaForChatCard.thumbUrl = media.thumbUrl;
        mediaForChatCard.videoUrl = media.videoUrl;
        mediaForChatCard.height = media.height;
        mediaForChatCard.width = media.width;
        mediaForChatCard.midUrl = media.midUrl;
        mediaForChatCard.localPath = media.localPath;
        mediaForChatCard.latitude = media.latitude;
        mediaForChatCard.longitude = media.longitude;
        mediaForChatCard.picSource = media.picSource;
        mediaForChatCard.shootingTime = media.shootingTime;
        mediaForChatCard.location = media.location;
        return mediaForChatCard;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getHeight() {
        String str = this.height;
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    public int getWidth() {
        String str = this.width;
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.height);
        parcel.writeString(this.width);
        parcel.writeString(this.midUrl);
        parcel.writeString(this.localPath);
    }

    public MediaForChatCard(Parcel parcel) {
        this.url = parcel.readString();
        this.thumbUrl = parcel.readString();
        this.videoUrl = parcel.readString();
        this.height = parcel.readString();
        this.width = parcel.readString();
        this.midUrl = parcel.readString();
        this.localPath = parcel.readString();
    }
}
