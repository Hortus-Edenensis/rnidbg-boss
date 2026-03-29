package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatRiskVo implements Parcelable {
    public static final Parcelable.Creator<ChatRiskVo> CREATOR = new Parcelable.Creator<ChatRiskVo>() { // from class: com.zenmen.palmchat.Vo.ChatRiskVo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChatRiskVo createFromParcel(Parcel parcel) {
            return new ChatRiskVo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChatRiskVo[] newArray(int i) {
            return new ChatRiskVo[i];
        }
    };
    public String actionText;
    public String text;
    public String uid;
    public String url;

    public ChatRiskVo(Parcel parcel) {
        this.actionText = parcel.readString();
        this.uid = parcel.readString();
        this.url = parcel.readString();
        this.text = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.actionText);
        parcel.writeString(this.uid);
        parcel.writeString(this.url);
        parcel.writeString(this.text);
    }
}
