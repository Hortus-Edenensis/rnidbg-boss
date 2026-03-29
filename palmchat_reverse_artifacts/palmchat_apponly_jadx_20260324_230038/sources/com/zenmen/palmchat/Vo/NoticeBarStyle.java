package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import defpackage.az2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NoticeBarStyle implements Parcelable {
    public static final Parcelable.Creator<NoticeBarStyle> CREATOR = new Parcelable.Creator<NoticeBarStyle>() { // from class: com.zenmen.palmchat.Vo.NoticeBarStyle.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NoticeBarStyle createFromParcel(Parcel parcel) {
            return new NoticeBarStyle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NoticeBarStyle[] newArray(int i) {
            return new NoticeBarStyle[i];
        }
    };
    public String digest;
    public NoticeBarExt ext;
    public String icon;
    public String mid;
    public int openType;
    public String requestId;
    public NoticeBarExtStyle style;
    public String title;
    public int type;
    public boolean unnoticeable;
    public String url;

    public NoticeBarStyle() {
        this.type = -1;
    }

    public static NoticeBarStyle parseFromMsgExtension(String str) {
        RichMsgVo richMsgVo;
        if (TextUtils.isEmpty(str) || (richMsgVo = (RichMsgVo) az2.a(str, RichMsgVo.class)) == null) {
            return null;
        }
        return richMsgVo.noticeBar;
    }

    public static NoticeBarStyle parseFromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (NoticeBarStyle) az2.a(str, NoticeBarStyle.class);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.digest);
        parcel.writeString(this.icon);
        parcel.writeInt(this.openType);
        parcel.writeByte(this.unnoticeable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.url);
        parcel.writeParcelable(this.ext, i);
        parcel.writeInt(this.type);
        parcel.writeString(this.mid);
        parcel.writeString(this.requestId);
        parcel.writeParcelable(this.style, i);
    }

    public NoticeBarStyle(Parcel parcel) {
        this.type = -1;
        this.title = parcel.readString();
        this.digest = parcel.readString();
        this.icon = parcel.readString();
        this.openType = parcel.readInt();
        this.unnoticeable = parcel.readByte() != 0;
        this.url = parcel.readString();
        this.ext = (NoticeBarExt) parcel.readParcelable(NoticeBarExt.class.getClassLoader());
        this.type = parcel.readInt();
        this.mid = parcel.readString();
        this.requestId = parcel.readString();
        this.style = (NoticeBarExtStyle) parcel.readParcelable(NoticeBarExtStyle.class.getClassLoader());
    }
}
