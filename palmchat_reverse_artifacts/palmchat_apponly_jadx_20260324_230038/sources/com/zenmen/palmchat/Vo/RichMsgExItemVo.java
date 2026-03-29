package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RichMsgExItemVo implements Parcelable {
    public static final Parcelable.Creator<RichMsgExItemVo> CREATOR = new Parcelable.Creator<RichMsgExItemVo>() { // from class: com.zenmen.palmchat.Vo.RichMsgExItemVo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RichMsgExItemVo createFromParcel(Parcel parcel) {
            return new RichMsgExItemVo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RichMsgExItemVo[] newArray(int i) {
            return new RichMsgExItemVo[i];
        }
    };
    public static final int LINK_VIDEO_SUBTYPE_DEF = 0;
    public static final int LINK_VIDEO_SUBTYPE_LOCATION = 4;
    public static final int LINK_VIDEO_SUBTYPE_NAMECARD = 1;
    public static final int LINK_VIDEO_SUBTYPE_RANK = 3;
    public static final int LINK_VIDEO_SUBTYPE_TOPIC = 2;
    public String acode;
    public int activityId;
    public String amount;
    public String appIcon;
    public String appName;
    public String cover;
    public String digest;
    public FeedEx feedEx;
    public int height;
    public String icon;
    public String label;
    public boolean line;
    public ArrayList<LabelItem> list;
    public boolean matchParent;
    public String openLink;
    public long pubTime;
    public int readNum;
    public int shareType;
    public String showTag;
    public int showType;
    public int statusBarStyle;
    public int subType;
    public String title;
    public String topBarColor;
    public String topBarTextColor;
    public String url;
    public int width;
    public WinEx wineEx;

    /* JADX INFO: compiled from: SearchBox */
    public static class FeedEx implements Parcelable {
        public static final Parcelable.Creator<FeedEx> CREATOR = new Parcelable.Creator<FeedEx>() { // from class: com.zenmen.palmchat.Vo.RichMsgExItemVo.FeedEx.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FeedEx createFromParcel(Parcel parcel) {
                return new FeedEx(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public FeedEx[] newArray(int i) {
                return new FeedEx[i];
            }
        };
        public String headIconUrl;
        public String nickname;
        public int type;

        public FeedEx() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.type);
            parcel.writeString(this.nickname);
            parcel.writeString(this.headIconUrl);
        }

        public FeedEx(Parcel parcel) {
            this.type = parcel.readInt();
            this.nickname = parcel.readString();
            this.headIconUrl = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class WinEx implements Parcelable {
        public static final Parcelable.Creator<WinEx> CREATOR = new Parcelable.Creator<WinEx>() { // from class: com.zenmen.palmchat.Vo.RichMsgExItemVo.WinEx.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public WinEx createFromParcel(Parcel parcel) {
                return new WinEx(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public WinEx[] newArray(int i) {
                return new WinEx[i];
            }
        };
        public String adCode;
        public String cityCode;
        public String poiId;
        public String topicId;
        public String wid;
        public String wineFeedId;

        public WinEx() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.wid);
            parcel.writeString(this.wineFeedId);
            parcel.writeString(this.topicId);
            parcel.writeString(this.poiId);
            parcel.writeString(this.adCode);
            parcel.writeString(this.cityCode);
        }

        public WinEx(Parcel parcel) {
            this.wid = parcel.readString();
            this.wineFeedId = parcel.readString();
            this.topicId = parcel.readString();
            this.poiId = parcel.readString();
            this.adCode = parcel.readString();
            this.cityCode = parcel.readString();
        }
    }

    public RichMsgExItemVo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.showType);
        parcel.writeString(this.title);
        parcel.writeString(this.cover);
        parcel.writeString(this.acode);
        parcel.writeString(this.url);
        parcel.writeLong(this.pubTime);
        parcel.writeString(this.digest);
        parcel.writeInt(this.shareType);
        parcel.writeString(this.showTag);
        parcel.writeParcelable(this.feedEx, i);
        parcel.writeInt(this.readNum);
        parcel.writeString(this.appName);
        parcel.writeString(this.appIcon);
        parcel.writeString(this.icon);
        parcel.writeString(this.label);
        parcel.writeString(this.amount);
        parcel.writeByte(this.line ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.matchParent ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.list);
        parcel.writeString(this.topBarColor);
        parcel.writeString(this.topBarTextColor);
        parcel.writeInt(this.statusBarStyle);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.activityId);
        parcel.writeParcelable(this.wineEx, i);
    }

    public RichMsgExItemVo(Parcel parcel) {
        this.showType = parcel.readInt();
        this.title = parcel.readString();
        this.cover = parcel.readString();
        this.acode = parcel.readString();
        this.url = parcel.readString();
        this.pubTime = parcel.readLong();
        this.digest = parcel.readString();
        this.shareType = parcel.readInt();
        this.showTag = parcel.readString();
        this.feedEx = (FeedEx) parcel.readParcelable(FeedEx.class.getClassLoader());
        this.readNum = parcel.readInt();
        this.appName = parcel.readString();
        this.appIcon = parcel.readString();
        this.icon = parcel.readString();
        this.label = parcel.readString();
        this.amount = parcel.readString();
        this.line = parcel.readByte() != 0;
        this.matchParent = parcel.readByte() != 0;
        this.list = parcel.createTypedArrayList(LabelItem.CREATOR);
        this.topBarColor = parcel.readString();
        this.topBarTextColor = parcel.readString();
        this.statusBarStyle = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.activityId = parcel.readInt();
        this.wineEx = (WinEx) parcel.readParcelable(WinEx.class.getClassLoader());
    }
}
