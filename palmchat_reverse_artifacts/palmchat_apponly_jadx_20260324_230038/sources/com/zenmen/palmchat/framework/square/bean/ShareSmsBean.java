package com.zenmen.palmchat.framework.square.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ShareSmsBean implements Parcelable {
    public static final Parcelable.Creator<ShareSmsBean> CREATOR = new a();
    public String msgContent;
    public List<String> numbers;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<ShareSmsBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareSmsBean createFromParcel(Parcel parcel) {
            return new ShareSmsBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ShareSmsBean[] newArray(int i) {
            return new ShareSmsBean[i];
        }
    }

    public ShareSmsBean(Parcel parcel) {
        this.msgContent = parcel.readString();
        this.numbers = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.msgContent);
        parcel.writeStringList(this.numbers);
    }
}
