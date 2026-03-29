package com.zenmen.palmchat.venus.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.zenmen.listui.list.BaseBean;
import defpackage.fg6;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class MemberBean implements Parcelable, BaseBean {
    public static final Parcelable.Creator<MemberBean> CREATOR = new Parcelable.Creator<MemberBean>() { // from class: com.zenmen.palmchat.venus.bean.MemberBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MemberBean createFromParcel(Parcel parcel) {
            return new MemberBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MemberBean[] newArray(int i) {
            return new MemberBean[i];
        }
    };
    public String age;
    public int anchorLevel;
    public String avatar;
    public String avatarBorder;
    public ArrayList<Badge> badgeList;
    public String birthday;
    public String bottomTips;
    public int charmLevel;
    public long charmValue;
    public long contributionVal;
    public String contributionValDesc;
    public long currentCharmLevelMinValue;
    public long currentRichLevelMinValue;
    public String ext;
    public boolean fansClubCardGray;
    public String fansClubCardName;
    public int fansClubLevel;
    public String fansClubLevelDesc;
    public long fansClubLevelMinScore;
    public long fansValue;
    public String fansValueDesc;
    private int followStatus;
    public int gender;
    public int identityType;
    public String imUid;
    public int lightCount;
    public String locationCityName;
    public boolean manageWhiteFlag;
    public int needImproveFanValueStatus;
    public long nextCharmLevelDis;
    public long nextFansLevelDis;
    public long nextRichLevelDis;
    public String nickname;
    public long pageVersion;
    public int recvAccruePrice;
    public String regTime;
    public int richLevel;
    public long richValue;
    public int roleType;
    public String signature;
    public int totalCount;
    public String uid;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Badge implements Parcelable {
        public static final Parcelable.Creator<Badge> CREATOR = new Parcelable.Creator<Badge>() { // from class: com.zenmen.palmchat.venus.bean.MemberBean.Badge.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Badge createFromParcel(Parcel parcel) {
                return new Badge(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Badge[] newArray(int i) {
                return new Badge[i];
            }
        };
        public int height;
        public String url;
        public int width;

        public Badge(Parcel parcel) {
            this.url = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.url);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
        }
    }

    public MemberBean(Parcel parcel) {
        this.followStatus = 0;
        this.manageWhiteFlag = parcel.readByte() != 0;
        this.anchorLevel = parcel.readInt();
        this.avatar = parcel.readString();
        this.birthday = parcel.readString();
        this.gender = parcel.readInt();
        this.identityType = parcel.readInt();
        this.imUid = parcel.readString();
        this.nickname = parcel.readString();
        this.regTime = parcel.readString();
        this.richLevel = parcel.readInt();
        this.richValue = parcel.readLong();
        this.nextRichLevelDis = parcel.readLong();
        this.currentRichLevelMinValue = parcel.readLong();
        this.charmLevel = parcel.readInt();
        this.charmValue = parcel.readLong();
        this.currentCharmLevelMinValue = parcel.readLong();
        this.nextCharmLevelDis = parcel.readLong();
        this.roleType = parcel.readInt();
        this.uid = parcel.readString();
        this.followStatus = parcel.readInt();
        this.age = parcel.readString();
        this.locationCityName = parcel.readString();
        this.recvAccruePrice = parcel.readInt();
        this.contributionVal = parcel.readLong();
        this.contributionValDesc = parcel.readString();
        this.fansValue = parcel.readLong();
        this.needImproveFanValueStatus = parcel.readInt();
        this.signature = parcel.readString();
        this.ext = parcel.readString();
        this.lightCount = parcel.readInt();
        this.totalCount = parcel.readInt();
        this.pageVersion = parcel.readLong();
        this.bottomTips = parcel.readString();
        this.avatarBorder = parcel.readString();
        this.badgeList = parcel.createTypedArrayList(Badge.CREATOR);
        this.fansClubCardName = parcel.readString();
        this.fansClubLevel = parcel.readInt();
        this.nextFansLevelDis = parcel.readLong();
        this.fansClubLevelMinScore = parcel.readLong();
        this.fansClubLevelDesc = parcel.readString();
        this.fansClubCardGray = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFollowStatus() {
        return this.followStatus;
    }

    public boolean isBottomTip() {
        return !TextUtils.isEmpty(this.bottomTips);
    }

    public boolean isFollow() {
        return this.followStatus == 1;
    }

    public boolean isVip() {
        return (TextUtils.isEmpty(this.ext) || fg6.h(this.ext) == 0) ? false : true;
    }

    public void setFollowStatus(int i) {
        this.followStatus = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.manageWhiteFlag ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.anchorLevel);
        parcel.writeString(this.avatar);
        parcel.writeString(this.birthday);
        parcel.writeInt(this.gender);
        parcel.writeInt(this.identityType);
        parcel.writeString(this.imUid);
        parcel.writeString(this.nickname);
        parcel.writeString(this.regTime);
        parcel.writeInt(this.richLevel);
        parcel.writeLong(this.richValue);
        parcel.writeLong(this.nextRichLevelDis);
        parcel.writeLong(this.currentRichLevelMinValue);
        parcel.writeInt(this.charmLevel);
        parcel.writeLong(this.charmValue);
        parcel.writeLong(this.currentCharmLevelMinValue);
        parcel.writeLong(this.nextCharmLevelDis);
        parcel.writeInt(this.roleType);
        parcel.writeString(this.uid);
        parcel.writeInt(this.followStatus);
        parcel.writeString(this.age);
        parcel.writeString(this.locationCityName);
        parcel.writeInt(this.recvAccruePrice);
        parcel.writeLong(this.contributionVal);
        parcel.writeString(this.contributionValDesc);
        parcel.writeLong(this.fansValue);
        parcel.writeInt(this.needImproveFanValueStatus);
        parcel.writeString(this.signature);
        parcel.writeString(this.ext);
        parcel.writeInt(this.lightCount);
        parcel.writeInt(this.totalCount);
        parcel.writeLong(this.pageVersion);
        parcel.writeString(this.bottomTips);
        parcel.writeString(this.avatarBorder);
        parcel.writeTypedList(this.badgeList);
        parcel.writeString(this.fansClubCardName);
        parcel.writeInt(this.fansClubLevel);
        parcel.writeLong(this.nextFansLevelDis);
        parcel.writeLong(this.fansClubLevelMinScore);
        parcel.writeString(this.fansClubLevelDesc);
        parcel.writeByte(this.fansClubCardGray ? (byte) 1 : (byte) 0);
    }

    public MemberBean() {
        this.followStatus = 0;
    }
}
