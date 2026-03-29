package com.zenmen.palmchat.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GiftPanelConfigBean implements Parcelable {
    public static final Parcelable.Creator<GiftPanelConfigBean> CREATOR = new a();
    public String id;
    public String url;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<GiftPanelConfigBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GiftPanelConfigBean createFromParcel(Parcel parcel) {
            return new GiftPanelConfigBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GiftPanelConfigBean[] newArray(int i) {
            return new GiftPanelConfigBean[i];
        }
    }

    public GiftPanelConfigBean(Parcel parcel) {
        this.id = parcel.readString();
        this.url = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.url);
    }
}
