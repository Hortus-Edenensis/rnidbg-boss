package com.zenmen.square.mvp.model.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.bean.SquareSimpleComment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.ISupperFeedBean;
import com.zenmen.square.lxpager.BasePagerBean;
import com.zenmen.square.superexposee.squaretab.SuperExposeSquareRequestInfo;
import com.zenmen.square.tag.bean.SquareTagBean;
import defpackage.dn0;
import defpackage.ma3;
import defpackage.nu3;
import defpackage.v4;
import defpackage.vs0;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareFeed extends SquareBean implements BasePagerBean, ISupperFeedBean<SquareFeed> {
    public static final Parcelable.Creator<SquareFeed> CREATOR = new Parcelable.Creator<SquareFeed>() { // from class: com.zenmen.square.mvp.model.bean.SquareFeed.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareFeed createFromParcel(Parcel parcel) {
            return new SquareFeed(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareFeed[] newArray(int i) {
            return new SquareFeed[i];
        }
    };
    public String actionUrl;
    public Integer adKey;
    public String aeIcon;

    @nu3
    public long aeId;
    public String aeName;
    public int businessFrom;
    public String channelId;
    public int channelType;
    public String city;
    public ContactInfoItem contactInfoItem;

    @nu3
    public String content;
    public String cover;

    @nu3
    public long createTime;
    public boolean custom;
    public String day;
    public int deleted;

    @nu3
    public int discussionNum;
    public List<SquareDiscussionTopicBean> discussionalTopics;
    public List<SquareSimpleComment> discussions;

    @nu3
    public double distance;

    @nu3
    public String exid;
    public String feedExt;

    @nu3
    public int feedType;
    public String firstToast;
    public String guideSayHiText;
    public String headImgUrl;
    public boolean hiddenDiscussion;
    public String hotCityIcon;
    public String hotCityTitle;
    public List<SquareHotCityBean> hotCitys;

    @nu3
    public long id;
    public boolean ifFriend;
    public boolean ifLike;

    @nu3
    public String imprId;
    public long initedTime;
    public boolean isFirstRefresh;
    public boolean isHeadTopic;
    public boolean isTargetPosition;
    public boolean isVipBanner;
    public long lastGuideTime;

    @nu3
    public double latitude;

    @nu3
    public int likeNums;
    public boolean liveFlag;

    @nu3
    public String location;

    @nu3
    public double longitude;
    public List<Media> mediaList;
    public Feed momentsFeed;
    public String month;
    public String nickname;
    public boolean official;

    @nu3
    public int page;

    @nu3
    public int pos;
    public int praiseGuideType;
    public String recommendTopicIcon;
    public String recommendTopicTitle;
    public long sayHiGuideTime;
    public String sceneId;
    public int sex;
    public boolean showBigDate;
    public boolean showPraiseGuide;
    public String sid;
    public SquareTagBean squareTagBean;
    public SuperExposeSquareRequestInfo superExposeSquareInfo;
    public int superShowType;

    @nu3
    public int tagId;
    public int targetMediaPosition;
    public String timeShow;

    @nu3
    public long topicId;
    public String topicName;
    public String uid;
    public long updateTime;
    public int urlType;
    public String userExt;
    public List<String> userLabelImg;
    public long version;
    public String vipBannerBg;
    public String vipBannerUrl;
    public int visibleType;
    public String year;

    public SquareFeed() {
        this.adKey = null;
        this.showPraiseGuide = false;
        this.lastGuideTime = 0L;
        this.praiseGuideType = 0;
        this.custom = false;
        this.isTargetPosition = false;
        this.isFirstRefresh = true;
    }

    public static SquareFeed convertToSquareFeed(Feed feed) {
        SquareFeed squareFeed = new SquareFeed();
        squareFeed.id = feed.getId();
        squareFeed.uid = feed.getUid();
        squareFeed.discussionNum = feed.getCommentNum();
        squareFeed.likeNums = feed.getLikeNum();
        ContactInfoItem contactInfoItemA = dn0.a(feed.getUid());
        if (contactInfoItemA != null) {
            squareFeed.nickname = contactInfoItemA.getNameForShow();
        }
        squareFeed.businessFrom = 1;
        squareFeed.momentsFeed = feed;
        return squareFeed;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public boolean canDelete() {
        if (TextUtils.equals(this.exid, v4.b(c.b()))) {
            return true;
        }
        return TextUtils.equals(this.uid, v4.e(c.b()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public String getAvatar() {
        return this.headImgUrl;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public String getCommentCountShow() {
        return getStringNumForShow(this.discussionNum, 2);
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public String getContent() {
        return this.content;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public long getCreateTime() {
        return this.createTime;
    }

    public Map<String, Object> getEventParams() {
        HashMap map = new HashMap();
        Field[] fields = getClass().getFields();
        if (fields != null) {
            for (Field field : fields) {
                field.setAccessible(true);
                if (((nu3) field.getAnnotation(nu3.class)) != null) {
                    try {
                        map.put(field.getName(), field.get(this));
                    } catch (IllegalAccessException e) {
                        ma3.c(e);
                    }
                }
            }
        }
        map.put("feedid", Long.valueOf(this.id));
        return map;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public String getExid() {
        return this.exid;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public long getFeedId() {
        return this.id;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public long getFeedType() {
        return this.feedType;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public int getGender() {
        return this.sex;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public boolean getIfLike() {
        return this.ifLike;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public String getNickname() {
        return this.nickname;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public SquareFeed getOriginData() {
        return this;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public String getPraiseCountShow() {
        return getStringNumForShow(this.likeNums, 1);
    }

    public String getStringNumForShow(int i, int i2) {
        if (i == 0) {
            return i2 == 1 ? "点赞" : "评论";
        }
        if (i >= 10000) {
            return new DecimalFormat("###.0").format(i / 10000.0f) + RXScreenCaptureService.KEY_WIDTH;
        }
        if (i < 1000) {
            return Integer.toString(i);
        }
        return new DecimalFormat("###.0").format(i / 1000.0f) + t.f7496a;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public String getUid() {
        return this.uid;
    }

    public boolean hasAe() {
        return this.aeId > 0 && !TextUtils.isEmpty(this.aeName);
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public boolean hideComment() {
        return this.hiddenDiscussion;
    }

    @Override // com.zenmen.palmchat.greendao.model.ISupperFeedBean
    public boolean isEmptyFeed() {
        int i = this.feedType;
        if (i != 3 && i != 2) {
            return TextUtils.isEmpty(this.content);
        }
        List<Media> list = this.mediaList;
        return list == null || list.isEmpty();
    }

    public boolean isFriend() {
        ContactInfoItem contactInfoItemB = dn0.b(this.exid);
        return (contactInfoItemB == null || contactInfoItemB.getIsStranger()) ? false : true;
    }

    public boolean isNewUser() {
        return this.initedTime > 0 && Math.abs(System.currentTimeMillis() - this.initedTime) < vs0.a().d("Newusersign", 72L) * 3600000;
    }

    public boolean isNormalFeed() {
        int i = this.feedType;
        return i == 2 || i == 3 || i == 1 || i == 8;
    }

    public boolean mergeByNewUpdate(SquareFeed squareFeed) {
        if (squareFeed == null || squareFeed.id != this.id) {
            return false;
        }
        this.likeNums = squareFeed.likeNums;
        this.discussionNum = squareFeed.discussionNum;
        this.ifLike = squareFeed.ifLike;
        this.discussions = squareFeed.discussions;
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeInt(this.feedType);
        parcel.writeInt(this.tagId);
        parcel.writeString(this.nickname);
        parcel.writeString(this.headImgUrl);
        parcel.writeString(this.cover);
        parcel.writeDouble(this.distance);
        parcel.writeString(this.content);
        parcel.writeString(this.location);
        parcel.writeString(this.city);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeString(this.exid);
        parcel.writeLong(this.initedTime);
        parcel.writeString(this.uid);
        parcel.writeLong(this.version);
        parcel.writeLong(this.createTime);
        parcel.writeLong(this.updateTime);
        parcel.writeByte(this.ifLike ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.likeNums);
        parcel.writeTypedList(this.mediaList);
        parcel.writeInt(this.sex);
        parcel.writeString(this.year);
        parcel.writeString(this.month);
        parcel.writeString(this.day);
        parcel.writeString(this.reqId);
        parcel.writeByte(this.showBigDate ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.contactInfoItem, i);
        parcel.writeParcelable(this.squareTagBean, i);
        parcel.writeString(this.bottomTips);
        parcel.writeString(this.aeIcon);
        parcel.writeString(this.aeName);
        parcel.writeString(this.topicName);
        parcel.writeLong(this.topicId);
        parcel.writeLong(this.aeId);
        parcel.writeByte(this.isHeadTopic ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVipBanner ? (byte) 1 : (byte) 0);
        parcel.writeString(this.vipBannerBg);
        parcel.writeString(this.vipBannerUrl);
        parcel.writeInt(this.discussionNum);
        parcel.writeString(this.imprId);
        parcel.writeInt(this.page);
        parcel.writeInt(this.pos);
        Integer num = this.adKey;
        parcel.writeInt(num == null ? -1 : num.intValue());
        parcel.writeByte(this.official ? (byte) 1 : (byte) 0);
        parcel.writeString(this.actionUrl);
        parcel.writeInt(this.deleted);
        parcel.writeString(this.timeShow);
        parcel.writeInt(this.businessFrom);
        parcel.writeString(this.userExt);
        parcel.writeStringList(this.userLabelImg);
        parcel.writeByte(this.ifFriend ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.targetMediaPosition);
        parcel.writeInt(this.visibleType);
        parcel.writeByte(this.hiddenDiscussion ? (byte) 1 : (byte) 0);
        parcel.writeString(this.feedExt);
        parcel.writeInt(this.superShowType);
    }

    public SquareFeed(Parcel parcel) {
        this.adKey = null;
        this.showPraiseGuide = false;
        this.lastGuideTime = 0L;
        this.praiseGuideType = 0;
        this.custom = false;
        this.isTargetPosition = false;
        this.isFirstRefresh = true;
        this.id = parcel.readLong();
        this.feedType = parcel.readInt();
        this.tagId = parcel.readInt();
        this.nickname = parcel.readString();
        this.headImgUrl = parcel.readString();
        this.cover = parcel.readString();
        this.distance = parcel.readDouble();
        this.content = parcel.readString();
        this.location = parcel.readString();
        this.city = parcel.readString();
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
        this.exid = parcel.readString();
        this.initedTime = parcel.readLong();
        this.uid = parcel.readString();
        this.version = parcel.readLong();
        this.createTime = parcel.readLong();
        this.updateTime = parcel.readLong();
        this.ifLike = parcel.readByte() != 0;
        this.likeNums = parcel.readInt();
        this.mediaList = parcel.createTypedArrayList(Media.CREATOR);
        this.sex = parcel.readInt();
        this.year = parcel.readString();
        this.month = parcel.readString();
        this.day = parcel.readString();
        this.reqId = parcel.readString();
        this.showBigDate = parcel.readByte() != 0;
        this.contactInfoItem = (ContactInfoItem) parcel.readParcelable(ContactInfoItem.class.getClassLoader());
        this.squareTagBean = (SquareTagBean) parcel.readParcelable(SquareTagBean.class.getClassLoader());
        this.bottomTips = parcel.readString();
        this.aeIcon = parcel.readString();
        this.aeName = parcel.readString();
        this.topicName = parcel.readString();
        this.topicId = parcel.readLong();
        this.aeId = parcel.readLong();
        this.isHeadTopic = parcel.readByte() != 0;
        this.isVipBanner = parcel.readByte() != 0;
        this.vipBannerBg = parcel.readString();
        this.vipBannerUrl = parcel.readString();
        this.discussionNum = parcel.readInt();
        this.imprId = parcel.readString();
        this.page = parcel.readInt();
        this.pos = parcel.readInt();
        int i = parcel.readInt();
        this.adKey = i != -1 ? Integer.valueOf(i) : null;
        this.official = parcel.readByte() != 0;
        this.actionUrl = parcel.readString();
        this.deleted = parcel.readInt();
        this.timeShow = parcel.readString();
        this.businessFrom = parcel.readInt();
        this.userExt = parcel.readString();
        this.userLabelImg = parcel.createStringArrayList();
        this.ifFriend = parcel.readByte() != 0;
        this.targetMediaPosition = parcel.readInt();
        this.visibleType = parcel.readInt();
        this.hiddenDiscussion = parcel.readByte() != 0;
        this.feedExt = parcel.readString();
        this.superShowType = parcel.readInt();
    }

    public static SquareFeed convertToSquareFeed(Feed feed, ContactInfoItem contactInfoItem) {
        SquareFeed squareFeed = new SquareFeed();
        squareFeed.id = feed.getId();
        squareFeed.uid = feed.getUid();
        squareFeed.discussionNum = feed.getCommentNum();
        squareFeed.likeNums = feed.getLikeNum();
        if (contactInfoItem != null) {
            squareFeed.nickname = contactInfoItem.getNameForShow();
        }
        squareFeed.businessFrom = 1;
        squareFeed.momentsFeed = feed;
        return squareFeed;
    }
}
