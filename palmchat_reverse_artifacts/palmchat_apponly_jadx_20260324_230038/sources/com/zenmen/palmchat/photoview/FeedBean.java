package com.zenmen.palmchat.photoview;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import defpackage.j23;
import defpackage.v4;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FeedBean implements Parcelable {
    public static final Parcelable.Creator<FeedBean> CREATOR = new a();
    public int cmtSize;
    public String content;
    private long createDt;
    public int discussionNum;
    private long feedId;
    private String height;
    private boolean ifLike;
    public int likeNums;
    public int likeSize;
    private MediaItem mediaItem;
    public int sex;
    private String subTitle;
    private String uid;
    private String width;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<FeedBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedBean createFromParcel(Parcel parcel) {
            return new FeedBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FeedBean[] newArray(int i) {
            return new FeedBean[i];
        }
    }

    public FeedBean() {
    }

    public static ArrayList<FeedBean> generateFromFeed(Feed feed) {
        if (feed.getMediaList() == null || feed.getMediaList().isEmpty()) {
            return null;
        }
        ArrayList<FeedBean> arrayList = new ArrayList<>();
        if (feed.getMediaList() != null) {
            int size = feed.getMediaList().size();
            for (int i = 0; i < size; i++) {
                FeedBean feedBean = new FeedBean();
                MediaItem mediaItem = new MediaItem();
                feedBean.setFeedId(feed.getFeedId().longValue());
                int i2 = feed.getMediaList().get(i).type;
                mediaItem.mimeType = i2;
                if (i2 == 0) {
                    mediaItem.fileFullPath = feed.getMediaList().get(i).url;
                    if (feed.getMediaList().get(i).localPath != null && new File(feed.getMediaList().get(i).localPath).exists()) {
                        mediaItem.fileFullPath = feed.getMediaList().get(i).localPath;
                    }
                } else if (i2 == 1) {
                    Media media = feed.getMediaList().get(0);
                    mediaItem.fileFullPath = media.videoUrl;
                    mediaItem.thumbnailPath = media.thumbUrl;
                    mediaItem.localPath = media.localPath;
                    mediaItem.localThumbPath = media.localThumbPath;
                }
                feedBean.putFeed(feed);
                feedBean.setUid(feed.getUid());
                feedBean.setCreateDt(feed.getCreateDt().longValue());
                feedBean.setMediaItem(mediaItem);
                feedBean.setWidth(feed.getMediaList().get(i).width);
                feedBean.setHeight(feed.getMediaList().get(i).height);
                if (size > 1) {
                    feedBean.setSubTitle((i + 1) + " / " + size);
                }
                arrayList.add(feedBean);
            }
        }
        return arrayList;
    }

    public boolean canDelete() {
        return TextUtils.equals(this.uid, v4.e(c.b()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCommentCountShow() {
        return getStringNumForShow(this.discussionNum, 2);
    }

    public long getCreateDt() {
        return this.createDt;
    }

    public long getFeedId() {
        return this.feedId;
    }

    public String getHeight() {
        return this.height;
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

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

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getUid() {
        return this.uid;
    }

    public String getWidth() {
        return this.width;
    }

    public boolean isIfLike() {
        return this.ifLike;
    }

    public void putFeed(Feed feed) {
        this.uid = feed.getUid();
        this.content = feed.getContent();
        this.createDt = feed.getCreateDt().longValue();
        this.ifLike = j23.b(feed);
        if (feed.getLikesList() != null) {
            this.likeNums = feed.getLikesList().size();
        }
        if (feed.getCommentList() != null) {
            this.discussionNum = feed.getCommentList().size();
        }
    }

    public void setCreateDt(long j) {
        this.createDt = j;
    }

    public void setFeedId(long j) {
        this.feedId = j;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setIfLike(boolean z) {
        this.ifLike = z;
    }

    public void setMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setWidth(String str) {
        this.width = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.feedId);
        parcel.writeString(this.uid);
        parcel.writeLong(this.createDt);
        parcel.writeString(this.width);
        parcel.writeString(this.height);
        parcel.writeString(this.subTitle);
        parcel.writeParcelable(this.mediaItem, i);
        parcel.writeString(this.content);
        parcel.writeByte(this.ifLike ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.sex);
        parcel.writeInt(this.likeNums);
        parcel.writeInt(this.discussionNum);
    }

    public FeedBean(Parcel parcel) {
        this.feedId = parcel.readLong();
        this.uid = parcel.readString();
        this.createDt = parcel.readLong();
        this.width = parcel.readString();
        this.height = parcel.readString();
        this.subTitle = parcel.readString();
        this.mediaItem = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
        this.content = parcel.readString();
        this.ifLike = parcel.readByte() != 0;
        this.sex = parcel.readInt();
        this.likeNums = parcel.readInt();
        this.discussionNum = parcel.readInt();
    }
}
