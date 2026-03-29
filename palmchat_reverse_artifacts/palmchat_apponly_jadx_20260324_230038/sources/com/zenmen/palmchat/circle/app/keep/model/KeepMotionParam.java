package com.zenmen.palmchat.circle.app.keep.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class KeepMotionParam implements Parcelable {
    public static final Parcelable.Creator<KeepMotionParam> CREATOR = new a();
    public int actionFlag;
    public String actionId;
    public String cover;
    public int day;
    public String guideUrl;
    public String lessonId;
    public String lessonName;
    public String name;
    public int nums;
    public String planId;
    public String restVideoUrl;
    public int source;
    public String type;
    public int unit;
    public String url;
    public int week;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<KeepMotionParam> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KeepMotionParam createFromParcel(Parcel parcel) {
            return new KeepMotionParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeepMotionParam[] newArray(int i) {
            return new KeepMotionParam[i];
        }
    }

    public KeepMotionParam() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "KeepMotionParam{url='" + this.url + "', name='" + this.name + "', actionFlag=" + this.actionFlag + ", nums=" + this.nums + ", unit=" + this.unit + ", cover='" + this.cover + "', actionId='" + this.actionId + "', planId='" + this.planId + "', lessonId='" + this.lessonId + "', week=" + this.week + ", day=" + this.day + ", guideUrl='" + this.guideUrl + "', type='" + this.type + "', source=" + this.source + ", lessonName='" + this.lessonName + "', restVideoUrl='" + this.restVideoUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.name);
        parcel.writeInt(this.actionFlag);
        parcel.writeInt(this.nums);
        parcel.writeInt(this.unit);
        parcel.writeString(this.cover);
        parcel.writeString(this.actionId);
        parcel.writeString(this.planId);
        parcel.writeString(this.lessonId);
        parcel.writeInt(this.week);
        parcel.writeInt(this.day);
        parcel.writeString(this.guideUrl);
        parcel.writeInt(this.source);
        parcel.writeString(this.lessonName);
        parcel.writeString(this.restVideoUrl);
    }

    public KeepMotionParam(Parcel parcel) {
        this.url = parcel.readString();
        this.name = parcel.readString();
        this.actionFlag = parcel.readInt();
        this.nums = parcel.readInt();
        this.unit = parcel.readInt();
        this.cover = parcel.readString();
        this.actionId = parcel.readString();
        this.planId = parcel.readString();
        this.lessonId = parcel.readString();
        this.week = parcel.readInt();
        this.day = parcel.readInt();
        this.guideUrl = parcel.readString();
        this.source = parcel.readInt();
        this.lessonName = parcel.readString();
        this.restVideoUrl = parcel.readString();
    }
}
