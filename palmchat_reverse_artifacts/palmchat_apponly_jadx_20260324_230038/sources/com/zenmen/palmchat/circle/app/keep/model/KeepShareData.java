package com.zenmen.palmchat.circle.app.keep.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepShareData implements Parcelable {
    public static final Parcelable.Creator<KeepShareData> CREATOR = new a();
    public String appInfo;
    public String shareMessage;
    public KeepTrainData trainData;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<KeepShareData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KeepShareData createFromParcel(Parcel parcel) {
            return new KeepShareData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeepShareData[] newArray(int i) {
            return new KeepShareData[i];
        }
    }

    public KeepShareData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.trainData, i);
        parcel.writeString(this.appInfo);
        parcel.writeString(this.shareMessage);
    }

    public KeepShareData(Parcel parcel) {
        this.trainData = (KeepTrainData) parcel.readParcelable(KeepTrainData.class.getClassLoader());
        this.appInfo = parcel.readString();
        this.shareMessage = parcel.readString();
    }
}
