package com.zenmen.palmchat.circle.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleMemberItem implements Parcelable {
    public static final Parcelable.Creator<CircleMemberItem> CREATOR = new Parcelable.Creator<CircleMemberItem>() { // from class: com.zenmen.palmchat.circle.bean.CircleMemberItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CircleMemberItem createFromParcel(Parcel parcel) {
            return new CircleMemberItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CircleMemberItem[] newArray(int i) {
            return new CircleMemberItem[i];
        }
    };
    private String avatarUrl;
    private String groupNickname;
    private String id;
    private String nickname;

    public CircleMemberItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getGroupNickname() {
        return this.groupNickname;
    }

    public String getId() {
        return this.id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setGroupNickname(String str) {
        this.groupNickname = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.avatarUrl);
        parcel.writeString(this.nickname);
        parcel.writeString(this.groupNickname);
    }

    public CircleMemberItem(Parcel parcel) {
        this.id = parcel.readString();
        this.avatarUrl = parcel.readString();
        this.nickname = parcel.readString();
        this.groupNickname = parcel.readString();
    }
}
