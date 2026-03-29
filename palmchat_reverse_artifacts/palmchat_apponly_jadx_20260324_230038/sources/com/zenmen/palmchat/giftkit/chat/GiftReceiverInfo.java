package com.zenmen.palmchat.giftkit.chat;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class GiftReceiverInfo implements Parcelable, Cloneable {
    public static final Parcelable.Creator<GiftReceiverInfo> CREATOR = new a();
    public String headIconUrl;
    public String nickname;
    public String uid;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<GiftReceiverInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GiftReceiverInfo createFromParcel(Parcel parcel) {
            return new GiftReceiverInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GiftReceiverInfo[] newArray(int i) {
            return new GiftReceiverInfo[i];
        }
    }

    public GiftReceiverInfo(String str, String str2, String str3) {
        this.uid = str;
        this.nickname = str2;
        this.headIconUrl = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nickname);
        parcel.writeString(this.uid);
        parcel.writeString(this.headIconUrl);
    }

    public GiftReceiverInfo(Parcel parcel) {
        this.nickname = parcel.readString();
        this.uid = parcel.readString();
        this.headIconUrl = parcel.readString();
    }
}
