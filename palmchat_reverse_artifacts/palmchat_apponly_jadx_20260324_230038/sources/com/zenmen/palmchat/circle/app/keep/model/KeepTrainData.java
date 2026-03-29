package com.zenmen.palmchat.circle.app.keep.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepTrainData implements Parcelable {
    public static final Parcelable.Creator<KeepTrainData> CREATOR = new a();
    public String actId;
    public String background;
    public int count;
    public String date;
    public String headUrl;
    public String lessonId;
    public String planId;
    public String repeat;
    public String shareName;
    public int source;
    public String time;
    public String unit;
    public String userName;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<KeepTrainData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KeepTrainData createFromParcel(Parcel parcel) {
            return new KeepTrainData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeepTrainData[] newArray(int i) {
            return new KeepTrainData[i];
        }
    }

    public KeepTrainData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.headUrl);
        parcel.writeString(this.userName);
        parcel.writeString(this.date);
        parcel.writeString(this.time);
        parcel.writeString(this.shareName);
        parcel.writeInt(this.count);
        parcel.writeString(this.background);
        parcel.writeString(this.lessonId);
        parcel.writeString(this.actId);
        parcel.writeInt(this.source);
        parcel.writeString(this.repeat);
        parcel.writeString(this.unit);
        parcel.writeString(this.planId);
    }

    public KeepTrainData(Parcel parcel) {
        this.headUrl = parcel.readString();
        this.userName = parcel.readString();
        this.date = parcel.readString();
        this.time = parcel.readString();
        this.shareName = parcel.readString();
        this.count = parcel.readInt();
        this.background = parcel.readString();
        this.lessonId = parcel.readString();
        this.actId = parcel.readString();
        this.source = parcel.readInt();
        this.repeat = parcel.readString();
        this.unit = parcel.readString();
        this.planId = parcel.readString();
    }
}
