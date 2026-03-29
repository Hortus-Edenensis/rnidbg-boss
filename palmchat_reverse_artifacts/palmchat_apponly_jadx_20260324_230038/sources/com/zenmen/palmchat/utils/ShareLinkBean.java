package com.zenmen.palmchat.utils;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ShareLinkBean implements Parcelable {
    public static final Parcelable.Creator<ShareLinkBean> CREATOR = new a();
    private String content;
    private String icon;
    private String originUrl;
    private String subTitle;
    private String title;
    private String url;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<ShareLinkBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareLinkBean createFromParcel(Parcel parcel) {
            return new ShareLinkBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ShareLinkBean[] newArray(int i) {
            return new ShareLinkBean[i];
        }
    }

    public ShareLinkBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getOriginUrl() {
        return this.originUrl;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setOriginUrl(String str) {
        this.originUrl = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "ShareLinkBean title=" + this.title + " subtitle=" + this.subTitle + " content=" + this.content + " originUrl=" + this.originUrl + " url=" + this.url + " icon=" + this.icon;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.content);
        parcel.writeString(this.originUrl);
        parcel.writeString(this.url);
        parcel.writeString(this.icon);
    }

    public ShareLinkBean(Parcel parcel) {
        this.title = parcel.readString();
        this.subTitle = parcel.readString();
        this.content = parcel.readString();
        this.originUrl = parcel.readString();
        this.url = parcel.readString();
        this.icon = parcel.readString();
    }
}
