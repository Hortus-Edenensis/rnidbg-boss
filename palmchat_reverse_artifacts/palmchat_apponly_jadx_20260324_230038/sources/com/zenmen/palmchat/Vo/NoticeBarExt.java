package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NoticeBarExt implements Parcelable {
    public static final Parcelable.Creator<NoticeBarExt> CREATOR = new Parcelable.Creator<NoticeBarExt>() { // from class: com.zenmen.palmchat.Vo.NoticeBarExt.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NoticeBarExt createFromParcel(Parcel parcel) {
            return new NoticeBarExt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NoticeBarExt[] newArray(int i) {
            return new NoticeBarExt[i];
        }
    };
    public String appId;
    public String fromUid;
    public String mediaId;
    public String pushId;
    public String sceneFrom;
    public String sourceActSite;
    public String sourceDesc;
    public String sourceType;
    public String unionId;
    public String videoId;

    public NoticeBarExt(Parcel parcel) {
        this.appId = parcel.readString();
        this.pushId = parcel.readString();
        this.sourceActSite = parcel.readString();
        this.videoId = parcel.readString();
        this.mediaId = parcel.readString();
        this.unionId = parcel.readString();
        this.sceneFrom = parcel.readString();
        this.fromUid = parcel.readString();
        this.sourceType = parcel.readString();
        this.sourceDesc = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.pushId);
        parcel.writeString(this.sourceActSite);
        parcel.writeString(this.videoId);
        parcel.writeString(this.mediaId);
        parcel.writeString(this.unionId);
        parcel.writeString(this.sceneFrom);
        parcel.writeString(this.fromUid);
        parcel.writeString(this.sourceType);
        parcel.writeString(this.sourceDesc);
    }
}
