package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class LabelItem implements Parcelable {
    public static final Parcelable.Creator<LabelItem> CREATOR = new Parcelable.Creator<LabelItem>() { // from class: com.zenmen.palmchat.Vo.LabelItem.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LabelItem createFromParcel(Parcel parcel) {
            return new LabelItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LabelItem[] newArray(int i) {
            return new LabelItem[i];
        }
    };
    public String label;
    public String text;

    public LabelItem(Parcel parcel) {
        this.label = parcel.readString();
        this.text = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.label);
        parcel.writeString(this.text);
    }
}
