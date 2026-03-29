package com.zenmen.palmchat.circle.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleApplyListItem implements Parcelable {
    public static final Parcelable.Creator<CircleApplyListItem> CREATOR = new Parcelable.Creator<CircleApplyListItem>() { // from class: com.zenmen.palmchat.circle.bean.CircleApplyListItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CircleApplyListItem createFromParcel(Parcel parcel) {
            return new CircleApplyListItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CircleApplyListItem[] newArray(int i) {
            return new CircleApplyListItem[i];
        }
    };
    public int applyStatus;
    public String checkQuestion;
    public String headImgUrl;
    public long id;
    public String opNickName;
    public String opTime;
    public int sex;
    public String uid;
    public String userAnswer;
    public String userName;

    public CircleApplyListItem(Parcel parcel) {
        this.sex = -1;
        this.id = parcel.readLong();
        this.userName = parcel.readString();
        this.headImgUrl = parcel.readString();
        this.checkQuestion = parcel.readString();
        this.userAnswer = parcel.readString();
        this.opNickName = parcel.readString();
        this.opTime = parcel.readString();
        this.applyStatus = parcel.readInt();
        this.sex = parcel.readInt();
        this.uid = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.userName);
        parcel.writeString(this.headImgUrl);
        parcel.writeString(this.checkQuestion);
        parcel.writeString(this.userAnswer);
        parcel.writeString(this.opNickName);
        parcel.writeString(this.opTime);
        parcel.writeInt(this.applyStatus);
        parcel.writeInt(this.sex);
        parcel.writeString(this.uid);
    }
}
