package com.zenmen.square.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.zenmen.palmchat.location.LocationEx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareShareVenusRoomBean implements Parcelable {
    public static final Parcelable.Creator<SquareShareVenusRoomBean> CREATOR = new Parcelable.Creator<SquareShareVenusRoomBean>() { // from class: com.zenmen.square.bean.SquareShareVenusRoomBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareShareVenusRoomBean createFromParcel(Parcel parcel) {
            return new SquareShareVenusRoomBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareShareVenusRoomBean[] newArray(int i) {
            return new SquareShareVenusRoomBean[i];
        }
    };
    public String channelId;
    public int feedType;
    public LocationEx location;
    public String sceneId;
    public int shareTarget;

    public SquareShareVenusRoomBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.feedType);
        parcel.writeParcelable(this.location, i);
        parcel.writeInt(this.shareTarget);
        parcel.writeString(this.channelId);
        parcel.writeString(this.sceneId);
    }

    public SquareShareVenusRoomBean(Parcel parcel) {
        this.feedType = parcel.readInt();
        this.location = (LocationEx) parcel.readParcelable(getClass().getClassLoader());
        this.shareTarget = parcel.readInt();
        this.channelId = parcel.readString();
        this.sceneId = parcel.readString();
    }
}
