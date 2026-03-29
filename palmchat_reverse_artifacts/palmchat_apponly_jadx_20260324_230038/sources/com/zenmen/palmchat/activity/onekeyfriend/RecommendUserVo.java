package com.zenmen.palmchat.activity.onekeyfriend;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RecommendUserVo implements Parcelable {
    public static final Parcelable.Creator<RecommendUserVo> CREATOR = new a();
    private String account;
    private String age;
    private String city;
    private String country;
    private String headIconUrl;
    private String headImgUrl;
    private String nickname;
    private String province;
    private String pyInitial;
    private String pyQuanPin;
    private int sex;
    private String signature;
    private String uid;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<RecommendUserVo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendUserVo createFromParcel(Parcel parcel) {
            return new RecommendUserVo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecommendUserVo[] newArray(int i) {
            return new RecommendUserVo[i];
        }
    }

    public RecommendUserVo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccount() {
        return this.account;
    }

    public String getAge() {
        return this.age;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getHeadIconUrl() {
        return this.headIconUrl;
    }

    public String getHeadImgUrl() {
        return this.headImgUrl;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getProvince() {
        return this.province;
    }

    public String getPyInitial() {
        return this.pyInitial;
    }

    public String getPyQuanPin() {
        return this.pyQuanPin;
    }

    public int getSex() {
        return this.sex;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setHeadIconUrl(String str) {
        this.headIconUrl = str;
    }

    public void setHeadImgUrl(String str) {
        this.headImgUrl = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setPyInitial(String str) {
        this.pyInitial = str;
    }

    public void setPyQuanPin(String str) {
        this.pyQuanPin = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeString(this.account);
        parcel.writeString(this.nickname);
        parcel.writeString(this.pyInitial);
        parcel.writeString(this.pyQuanPin);
        parcel.writeString(this.headImgUrl);
        parcel.writeString(this.headIconUrl);
        parcel.writeString(this.signature);
        parcel.writeInt(this.sex);
        parcel.writeString(this.country);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.age);
    }

    public RecommendUserVo(Parcel parcel) {
        this.uid = parcel.readString();
        this.account = parcel.readString();
        this.nickname = parcel.readString();
        this.pyInitial = parcel.readString();
        this.pyQuanPin = parcel.readString();
        this.headImgUrl = parcel.readString();
        this.headIconUrl = parcel.readString();
        this.signature = parcel.readString();
        this.sex = parcel.readInt();
        this.country = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.age = parcel.readString();
    }
}
