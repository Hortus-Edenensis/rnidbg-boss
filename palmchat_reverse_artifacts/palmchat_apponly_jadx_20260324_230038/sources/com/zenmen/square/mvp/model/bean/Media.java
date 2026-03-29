package com.zenmen.square.mvp.model.bean;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.cy5;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Media implements Parcelable {
    public static final Parcelable.Creator<Media> CREATOR = new Parcelable.Creator<Media>() { // from class: com.zenmen.square.mvp.model.bean.Media.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Media createFromParcel(Parcel parcel) {
            return new Media(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Media[] newArray(int i) {
            return new Media[i];
        }
    };
    public String channelId;
    public String channelTitle;
    public int channelType;
    public List<String> headIconList;
    public String height;
    public double latitude;
    public String localPath;
    public String location;
    public double longitude;
    public String midUrl;
    public Integer picSource;
    public String sceneId;
    public long shootingTime;
    public String subTitle;
    public String thumbUrl;
    public String url;
    public String videoUrl;
    public String width;

    public Media() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getHeight() {
        try {
            String str = this.height;
            if (str != null) {
                return Integer.parseInt(str);
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getPicSource() {
        Integer num = this.picSource;
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public String getTimeShow() {
        return cy5.f(this.shootingTime);
    }

    public int getWidth() {
        try {
            String str = this.width;
            if (str != null) {
                return Integer.parseInt(str);
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
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
        if (this.picSource == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.picSource.intValue());
        }
        parcel.writeString(this.location);
        parcel.writeLong(this.shootingTime);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeString(this.channelId);
        parcel.writeString(this.sceneId);
        parcel.writeString(this.channelTitle);
        parcel.writeString(this.subTitle);
        parcel.writeStringList(this.headIconList);
        parcel.writeInt(this.channelType);
    }

    public Media(Parcel parcel) {
        this.url = parcel.readString();
        this.thumbUrl = parcel.readString();
        this.videoUrl = parcel.readString();
        this.height = parcel.readString();
        this.width = parcel.readString();
        this.midUrl = parcel.readString();
        this.localPath = parcel.readString();
        if (parcel.readByte() == 0) {
            this.picSource = null;
        } else {
            this.picSource = Integer.valueOf(parcel.readInt());
        }
        this.location = parcel.readString();
        this.shootingTime = parcel.readLong();
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
        this.channelId = parcel.readString();
        this.sceneId = parcel.readString();
        this.channelTitle = parcel.readString();
        this.subTitle = parcel.readString();
        this.headIconList = parcel.createStringArrayList();
        this.channelType = parcel.readInt();
    }
}
