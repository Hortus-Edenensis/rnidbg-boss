package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class NoticeBarExtStyle implements Parcelable {
    public static final Parcelable.Creator<NoticeBarExtStyle> CREATOR = new Parcelable.Creator<NoticeBarExtStyle>() { // from class: com.zenmen.palmchat.Vo.NoticeBarExtStyle.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NoticeBarExtStyle createFromParcel(Parcel parcel) {
            return new NoticeBarExtStyle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NoticeBarExtStyle[] newArray(int i) {
            return new NoticeBarExtStyle[i];
        }
    };
    public String background_color;
    public String digest;
    public String title;

    public NoticeBarExtStyle() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.digest);
        parcel.writeString(this.background_color);
    }

    public NoticeBarExtStyle(Parcel parcel) {
        this.title = parcel.readString();
        this.digest = parcel.readString();
        this.background_color = parcel.readString();
    }
}
