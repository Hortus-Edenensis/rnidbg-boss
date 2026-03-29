package com.zenmen.palmchat.paidservices.superexpose.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class LbsSquareSuperCityListResult implements Parcelable {
    public static final Parcelable.Creator<LbsSquareSuperCityListResult> CREATOR = new a();
    public int activeNum;
    public String cityCode;
    public String cityName;
    public boolean isSelected;
    public String tag;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<LbsSquareSuperCityListResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LbsSquareSuperCityListResult createFromParcel(Parcel parcel) {
            return new LbsSquareSuperCityListResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LbsSquareSuperCityListResult[] newArray(int i) {
            return new LbsSquareSuperCityListResult[i];
        }
    }

    public LbsSquareSuperCityListResult() {
        this.isSelected = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cityCode);
        parcel.writeString(this.cityName);
        parcel.writeString(this.tag);
        parcel.writeInt(this.activeNum);
        parcel.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
    }

    public LbsSquareSuperCityListResult(Parcel parcel) {
        this.isSelected = false;
        this.cityCode = parcel.readString();
        this.cityName = parcel.readString();
        this.tag = parcel.readString();
        this.activeNum = parcel.readInt();
        this.isSelected = parcel.readByte() != 0;
    }
}
