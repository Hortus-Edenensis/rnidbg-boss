package com.zenmen.square.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.zenmen.palmchat.framework.square.bean.ShareSmsBean;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.topic.bean.TopicListBean;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareShareFeedBean implements Parcelable {
    public static final Parcelable.Creator<SquareShareFeedBean> CREATOR = new Parcelable.Creator<SquareShareFeedBean>() { // from class: com.zenmen.square.bean.SquareShareFeedBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareShareFeedBean createFromParcel(Parcel parcel) {
            return new SquareShareFeedBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareShareFeedBean[] newArray(int i) {
            return new SquareShareFeedBean[i];
        }
    };
    public static final int MEDIA_SOURCE_ALBUM = 0;
    public static final int MEDIA_SOURCE_CAMERA = 1;
    public static final int PUBLIC_STATUS_NONE = 0;
    public static final int PUBLIC_STATUS_PUBLIC_ERROR = -1;
    public static final int PUBLIC_STATUS_SMS_FAIL = 5;
    public static final int PUBLIC_STATUS_SMS_RETRY = 3;
    public static final int PUBLIC_STATUS_SMS_SUCCESS = 4;
    public static final int PUBLIC_STATUS_UPLOADING = 1;
    public static final int PUBLIC_STATUS_UPLOAD_SUCCESS = 2;
    public static final int VISIBLE_TARGET_ALL = 0;
    public static final int VISIBLE_TARGET_FRIEND = 2;
    public static final int VISIBLE_TARGET_SELF = 1;
    public TopicListBean.Ae ae;
    public boolean clearMedia;
    public List<SquareContactBean> contactLists;
    public String content;
    public String errorMsg;
    public Integer feedCategory;
    public int feedType;
    public LocationEx location;
    public List<SquareFriendBean> lxFriendBeanList;
    public List<Media> mediaList;
    public int percent;
    public int picSource;
    public String publicProgressImage;
    public int publicStatus;
    public boolean sendContactsFriendFlag;
    public boolean sendLxFriendFlag;
    public ShareSmsBean shareSmsBean;
    public SquareFeed squareFeed;
    public int tagId;
    public TopicListBean.Topic topic;
    public int visibleType;
    public boolean isRecallImage = false;
    public boolean isPortrait = false;
    public boolean isSqureUserGuideChose = false;

    public SquareShareFeedBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isUploading() {
        return this.publicStatus == 1;
    }

    public void resetUploadStatus() {
        this.publicStatus = 0;
        this.percent = 0;
        this.squareFeed = null;
        this.errorMsg = null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.content);
        parcel.writeTypedList(this.mediaList);
        parcel.writeInt(this.feedType);
        parcel.writeInt(this.tagId);
        parcel.writeParcelable(this.location, i);
        parcel.writeParcelable(this.ae, i);
        parcel.writeInt(this.visibleType);
        parcel.writeInt(this.sendLxFriendFlag ? 1 : 0);
        parcel.writeInt(this.sendContactsFriendFlag ? 1 : 0);
        parcel.writeParcelable(this.topic, i);
        parcel.writeInt(this.picSource);
        parcel.writeInt(this.clearMedia ? 1 : 0);
    }

    public SquareShareFeedBean(Parcel parcel) {
        this.content = parcel.readString();
        this.mediaList = parcel.createTypedArrayList(Media.CREATOR);
        this.feedType = parcel.readInt();
        this.tagId = parcel.readInt();
        this.location = (LocationEx) parcel.readParcelable(LocationEx.class.getClassLoader());
        this.ae = (TopicListBean.Ae) parcel.readParcelable(TopicListBean.Ae.class.getClassLoader());
        this.visibleType = parcel.readInt();
        this.sendLxFriendFlag = parcel.readInt() == 1;
        this.sendContactsFriendFlag = parcel.readInt() == 1;
        this.topic = (TopicListBean.Topic) parcel.readParcelable(TopicListBean.Topic.class.getClassLoader());
        this.picSource = parcel.readInt();
        this.clearMedia = parcel.readInt() == 1;
    }
}
