package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GiftCardConfig implements Parcelable {
    public static final Parcelable.Creator<GiftCardConfig> CREATOR = new Parcelable.Creator<GiftCardConfig>() { // from class: com.zenmen.palmchat.Vo.GiftCardConfig.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GiftCardConfig createFromParcel(Parcel parcel) {
            return new GiftCardConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GiftCardConfig[] newArray(int i) {
            return new GiftCardConfig[i];
        }
    };
    public GiftCardBean giftMsg;

    /* JADX INFO: compiled from: SearchBox */
    public static class GiftCardBean implements Parcelable {
        public static final Parcelable.Creator<GiftCardBean> CREATOR = new Parcelable.Creator<GiftCardBean>() { // from class: com.zenmen.palmchat.Vo.GiftCardConfig.GiftCardBean.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public GiftCardBean createFromParcel(Parcel parcel) {
                return new GiftCardBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public GiftCardBean[] newArray(int i) {
                return new GiftCardBean[i];
            }
        };
        public int count;
        public String forwardable;
        public String giftId;
        public String giftName;
        public String icon;
        public String price;
        public String showType;

        public GiftCardBean(Parcel parcel) {
            this.showType = parcel.readString();
            this.icon = parcel.readString();
            this.giftId = parcel.readString();
            this.giftName = parcel.readString();
            this.count = parcel.readInt();
            this.price = parcel.readString();
            this.forwardable = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String formatTotalPrice() {
            return "价值" + new BigDecimal(this.count).multiply(new BigDecimal(this.price)).intValue() + "连信豆";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.showType);
            parcel.writeString(this.icon);
            parcel.writeString(this.giftId);
            parcel.writeString(this.giftName);
            parcel.writeInt(this.count);
            parcel.writeString(this.price);
            parcel.writeString(this.forwardable);
        }
    }

    public GiftCardConfig(Parcel parcel) {
        this.giftMsg = (GiftCardBean) parcel.readParcelable(GiftCardBean.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.giftMsg, i);
    }
}
