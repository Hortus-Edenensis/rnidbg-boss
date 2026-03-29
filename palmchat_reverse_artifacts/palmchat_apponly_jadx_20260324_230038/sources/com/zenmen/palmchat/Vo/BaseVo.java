package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BaseVo implements Parcelable {
    public static final Parcelable.Creator<BaseVo> CREATOR = new Parcelable.Creator<BaseVo>() { // from class: com.zenmen.palmchat.Vo.BaseVo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseVo createFromParcel(Parcel parcel) {
            return new BaseVo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BaseVo[] newArray(int i) {
            return new BaseVo[i];
        }
    };

    public BaseVo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BaseVo(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
