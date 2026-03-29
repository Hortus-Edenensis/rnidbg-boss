package com.zenmen.palmchat.redpacket.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BaseResponse implements Parcelable {
    public static final Parcelable.Creator<BaseResponse> CREATOR = new Parcelable.Creator<BaseResponse>() { // from class: com.zenmen.palmchat.redpacket.data.BaseResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseResponse createFromParcel(Parcel parcel) {
            return new BaseResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseResponse[] newArray(int i) {
            return new BaseResponse[i];
        }
    };
    public String errorMsg;
    public int resultCode;

    public BaseResponse() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.resultCode);
        parcel.writeString(this.errorMsg);
    }

    public BaseResponse(Parcel parcel) {
        this.resultCode = parcel.readInt();
        this.errorMsg = parcel.readString();
    }
}
