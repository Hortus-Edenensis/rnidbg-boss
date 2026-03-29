package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserRiskVo implements Parcelable {
    public static final Parcelable.Creator<UserRiskVo> CREATOR = new Parcelable.Creator<UserRiskVo>() { // from class: com.zenmen.palmchat.Vo.UserRiskVo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserRiskVo createFromParcel(Parcel parcel) {
            return new UserRiskVo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UserRiskVo[] newArray(int i) {
            return new UserRiskVo[i];
        }
    };
    public String uid;

    public UserRiskVo(Parcel parcel) {
        this.uid = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
    }
}
