package com.zenmen.palmchat.greendao.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.kuaishou.weapon.p0.t;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.square.lxpager.BasePagerBean;
import defpackage.az2;
import defpackage.wt1;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.converter.PropertyConverter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class Feed implements BaseBean, BaseRecyclerViewAdapter.c, Comparable<Feed>, Parcelable, BasePagerBean {
    public static final Parcelable.Creator<Feed> CREATOR = new Parcelable.Creator<Feed>() { // from class: com.zenmen.palmchat.greendao.model.Feed.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Feed createFromParcel(Parcel parcel) {
            return new Feed(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Feed[] newArray(int i) {
            return new Feed[i];
        }
    };
    public long adTime;
    public String advId;
    private Long clientId;
    public int commentNum;
    private List<Comment> comments;
    private String content;
    private String cover;
    private Long createDt;
    private Long feedId;
    Integer feedSource;
    private int feedType;
    private String hobby;
    public boolean isFirstRefresh;
    public boolean isTargetPosition;
    public List<Comment> likes;
    private Location location;
    private List<Media> mediaList;
    private List<Comment> oneLevelComments;
    private int privateStatus;
    public String reqId;
    private List<Comment> showComments;
    private Source source;
    private int status;
    private String uid;
    public UnreadMsg unreadMsg;
    private Long version;

    /* JADX INFO: compiled from: SearchBox */
    public static class Location extends Source {
        public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() { // from class: com.zenmen.palmchat.greendao.model.Feed.Location.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Location createFromParcel(Parcel parcel) {
                return new Location(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Location[] newArray(int i) {
                return new Location[i];
            }
        };
        private String city;
        private String latitude;
        private String longitude;
        private String poiAddress;
        private String poiClassifyId;
        private String poiClassifyType;
        private String poiClickableStatus;
        private String poiName;
        private String poiScale;

        public Location() {
        }

        @Override // com.zenmen.palmchat.greendao.model.Feed.Source, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.zenmen.palmchat.greendao.model.Feed.Source, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.city);
            parcel.writeString(this.poiAddress);
            parcel.writeString(this.poiClassifyId);
            parcel.writeString(this.poiName);
            parcel.writeString(this.poiScale);
            parcel.writeString(this.latitude);
            parcel.writeString(this.longitude);
            parcel.writeString(this.poiClassifyType);
            parcel.writeString(this.poiClickableStatus);
        }

        public Location(Parcel parcel) {
            this.city = parcel.readString();
            this.poiAddress = parcel.readString();
            this.poiClassifyId = parcel.readString();
            this.poiName = parcel.readString();
            this.poiScale = parcel.readString();
            this.latitude = parcel.readString();
            this.longitude = parcel.readString();
            this.poiClassifyType = parcel.readString();
            this.poiClickableStatus = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class LocationConverter implements PropertyConverter<Location, String> {
        @Override // org.greenrobot.greendao.converter.PropertyConverter
        public String convertToDatabaseValue(Location location) {
            if (location == null) {
                return null;
            }
            return az2.c(location);
        }

        @Override // org.greenrobot.greendao.converter.PropertyConverter
        public Location convertToEntityProperty(String str) {
            return (Location) az2.a(str, Location.class);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class MediaListConverter implements PropertyConverter<List<Media>, String> {
        @Override // org.greenrobot.greendao.converter.PropertyConverter
        public String convertToDatabaseValue(List<Media> list) {
            if (list == null) {
                return null;
            }
            return az2.c(list);
        }

        @Override // org.greenrobot.greendao.converter.PropertyConverter
        public List<Media> convertToEntityProperty(String str) {
            return Media.convertToMediaList(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Source implements Parcelable {
        public static final Parcelable.Creator<Source> CREATOR = new Parcelable.Creator<Source>() { // from class: com.zenmen.palmchat.greendao.model.Feed.Source.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Source createFromParcel(Parcel parcel) {
                return new Source(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Source[] newArray(int i) {
                return new Source[i];
            }
        };
        private String appName;
        private String name;

        public Source() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAppName() {
            return this.appName;
        }

        public String getName() {
            return this.name;
        }

        public void setAppName(String str) {
            this.appName = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.appName);
        }

        public Source(Parcel parcel) {
            this.name = parcel.readString();
            this.appName = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class UnreadMsg {
        public int count;
        public String url;
    }

    public Feed(Parcel parcel) {
        this.likes = new ArrayList();
        this.comments = new ArrayList();
        this.showComments = new ArrayList();
        this.oneLevelComments = new ArrayList();
        this.isTargetPosition = false;
        this.isFirstRefresh = true;
        this.feedId = Long.valueOf(parcel.readLong());
        this.clientId = Long.valueOf(parcel.readLong());
        this.uid = parcel.readString();
        this.createDt = Long.valueOf(parcel.readLong());
        this.content = parcel.readString();
        this.feedType = parcel.readInt();
        this.privateStatus = parcel.readInt();
        this.status = parcel.readInt();
        this.cover = parcel.readString();
        this.version = Long.valueOf(parcel.readLong());
        this.feedSource = Integer.valueOf(parcel.readInt());
        this.location = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.source = (Source) parcel.readParcelable(Source.class.getClassLoader());
        this.mediaList = parcel.createTypedArrayList(Media.CREATOR);
        this.hobby = parcel.readString();
        this.advId = parcel.readString();
        this.adTime = parcel.readLong();
        Parcelable.Creator<Comment> creator = Comment.CREATOR;
        this.likes = parcel.createTypedArrayList(creator);
        this.comments = parcel.createTypedArrayList(creator);
        this.showComments = parcel.createTypedArrayList(creator);
        this.oneLevelComments = parcel.createTypedArrayList(creator);
        this.commentNum = parcel.readInt();
    }

    public static String getCommentCountShow(int i) {
        return getStringNumForShow(i, 2);
    }

    public static String getPraiseCountShow(int i) {
        return getStringNumForShow(i, 1);
    }

    public static String getStringNumForShow(int i, int i2) {
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

    private void parseComments() {
        this.oneLevelComments = new ArrayList();
        if (this.comments == null) {
            this.comments = new ArrayList();
        }
        HashMap map = new HashMap();
        for (Comment comment : this.comments) {
            if (comment.commentType == 1) {
                this.oneLevelComments.add(comment);
            } else {
                List arrayList = (List) map.get(Long.valueOf(comment.oneLevelCommentId));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(Long.valueOf(comment.oneLevelCommentId), arrayList);
                }
                arrayList.add(comment);
            }
        }
        Comment.ChildComparator childComparator = new Comment.ChildComparator();
        for (Comment comment2 : this.oneLevelComments) {
            List<Comment> list = (List) map.get(comment2.getId());
            if (list != null) {
                comment2.childComments = list;
                Collections.sort(list, childComparator);
            }
        }
        Collections.sort(this.oneLevelComments, new Comment.OneLevelComparator());
    }

    public void addComment(Comment comment) {
        this.commentNum++;
        this.comments.add(comment);
        parseComments();
        if (comment.commentType == 1) {
            if (this.showComments == null) {
                this.showComments = new ArrayList();
            }
            this.showComments.add(0, comment);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getAdTime() {
        return this.adTime;
    }

    public String getAdvId() {
        return this.advId;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public List<Comment> getCommentList() {
        return this.comments;
    }

    public int getCommentNum() {
        List<Comment> list = this.comments;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public String getContent() {
        return this.content;
    }

    public String getCover() {
        return this.cover;
    }

    public Long getCreateDt() {
        return this.createDt;
    }

    public Long getFeedId() {
        return this.feedId;
    }

    public int getFeedSource() {
        Integer num = this.feedSource;
        return num == null ? wt1.f21791a : num.intValue();
    }

    public int getFeedType() {
        return this.feedType;
    }

    public long getId() {
        return this.feedId.longValue();
    }

    public int getLikeNum() {
        List<Comment> list = this.likes;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<Comment> getLikesList() {
        return this.likes;
    }

    public Location getLocation() {
        return this.location;
    }

    public List<Media> getMediaList() {
        return this.mediaList;
    }

    public List<Comment> getOneLevelComments() {
        return this.oneLevelComments;
    }

    public int getPrivateStatus() {
        return this.privateStatus;
    }

    public List<Comment> getShowComments() {
        return this.showComments;
    }

    public Source getSource() {
        return this.source;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUid() {
        return this.uid;
    }

    public Long getVersion() {
        return this.version;
    }

    public boolean isEmptyFeed() {
        List<Media> list = this.mediaList;
        return list == null || list.isEmpty();
    }

    public void removeComment(long j) {
        List<Comment> list;
        List<Comment> list2 = this.comments;
        if (list2 == null) {
            return;
        }
        Iterator<Comment> it = list2.iterator();
        long j2 = -1;
        for (Comment comment : this.comments) {
            if (j == comment.getId().longValue() || j == comment.oneLevelCommentId) {
                j2 = comment.oneLevelCommentId;
            }
        }
        int i = 0;
        while (it.hasNext()) {
            Comment next = it.next();
            if (j != next.getId().longValue()) {
                long j3 = next.oneLevelCommentId;
                if (j != j3) {
                    if (j2 != -1 && j2 == j3 && (list = next.childComments) != null && !list.isEmpty()) {
                        Iterator<Comment> it2 = list.iterator();
                        while (it2.hasNext()) {
                            if (j == it2.next().getId().longValue()) {
                                it2.remove();
                            }
                        }
                    }
                }
            }
            List<Comment> list3 = next.childComments;
            if (list3 != null) {
                list3.clear();
            }
            it.remove();
            i++;
        }
        this.commentNum = Math.max(0, this.commentNum - i);
        List<Comment> list4 = this.showComments;
        if (list4 != null) {
            Iterator<Comment> it3 = list4.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Comment next2 = it3.next();
                if (j == next2.getId().longValue()) {
                    this.showComments.remove(next2);
                    break;
                }
            }
        }
        parseComments();
    }

    public void restoreSource() {
        if (this.location == null) {
            return;
        }
        Source source = new Source();
        this.source = source;
        source.setName(this.location.getName());
        this.source.setAppName(this.location.getAppName());
    }

    public void setAdTime(long j) {
        this.adTime = j;
    }

    public void setAdvId(String str) {
        this.advId = str;
    }

    public void setClientId(Long l) {
        this.clientId = l;
    }

    public void setCommentList(List<Comment> list) {
        this.comments = list;
    }

    public void setComments(List<Comment> list) {
        this.comments = list;
        parseComments();
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setCreateDt(Long l) {
        this.createDt = l;
    }

    public void setFeedId(Long l) {
        this.feedId = l;
    }

    public void setFeedSource(int i) {
        this.feedSource = Integer.valueOf(i);
    }

    public void setFeedType(int i) {
        this.feedType = i;
    }

    public void setId(long j) {
        this.feedId = Long.valueOf(j);
    }

    public void setLikesList(List<Comment> list) {
        this.likes = list;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setMediaList(List<Media> list) {
        this.mediaList = list;
    }

    public void setOneLevelComments(List<Comment> list) {
        this.oneLevelComments = list;
    }

    public void setPrivateStatus(int i) {
        this.privateStatus = i;
    }

    public void setShowComments(List<Comment> list) {
        this.showComments = list;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVersion(Long l) {
        this.version = l;
    }

    public void storeSource() {
        if (this.source == null) {
            return;
        }
        if (this.location == null) {
            this.location = new Location();
        }
        this.location.setName(this.source.name);
        this.location.setAppName(this.source.appName);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Long l = this.feedId;
        if (l == null) {
            parcel.writeLong(0L);
        } else {
            parcel.writeLong(l.longValue());
        }
        Long l2 = this.clientId;
        if (l2 == null) {
            parcel.writeLong(0L);
        } else {
            parcel.writeLong(l2.longValue());
        }
        parcel.writeString(this.uid);
        Long l3 = this.createDt;
        if (l3 == null) {
            parcel.writeLong(0L);
        } else {
            parcel.writeLong(l3.longValue());
        }
        parcel.writeString(this.content);
        parcel.writeInt(this.feedType);
        parcel.writeInt(this.privateStatus);
        parcel.writeInt(this.status);
        parcel.writeString(this.cover);
        Long l4 = this.version;
        if (l4 == null) {
            parcel.writeLong(0L);
        } else {
            parcel.writeLong(l4.longValue());
        }
        Integer num = this.feedSource;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(num.intValue());
        }
        parcel.writeParcelable(this.location, i);
        parcel.writeParcelable(this.source, i);
        parcel.writeTypedList(this.mediaList);
        parcel.writeString(this.hobby);
        parcel.writeString(this.advId);
        parcel.writeLong(this.adTime);
        parcel.writeTypedList(this.likes);
        parcel.writeTypedList(this.comments);
        parcel.writeTypedList(this.showComments);
        parcel.writeTypedList(this.oneLevelComments);
        parcel.writeInt(this.commentNum);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Feed feed) {
        if (this.version.longValue() > feed.version.longValue()) {
            return -1;
        }
        return this.version.longValue() < feed.version.longValue() ? 1 : 0;
    }

    public void setFeedSource(Integer num) {
        this.feedSource = num;
    }

    public Feed(Long l, Long l2, String str, Long l3, String str2, int i, int i2, int i3, String str3, Long l4, Integer num, Location location, List<Media> list) {
        this.likes = new ArrayList();
        this.comments = new ArrayList();
        this.showComments = new ArrayList();
        this.oneLevelComments = new ArrayList();
        this.isTargetPosition = false;
        this.isFirstRefresh = true;
        this.feedId = l;
        this.clientId = l2;
        this.uid = str;
        this.createDt = l3;
        this.content = str2;
        this.feedType = i;
        this.privateStatus = i2;
        this.status = i3;
        this.cover = str3;
        this.version = l4;
        this.feedSource = num;
        this.location = location;
        this.mediaList = list;
    }

    public Feed() {
        this.likes = new ArrayList();
        this.comments = new ArrayList();
        this.showComments = new ArrayList();
        this.oneLevelComments = new ArrayList();
        this.isTargetPosition = false;
        this.isFirstRefresh = true;
    }
}
