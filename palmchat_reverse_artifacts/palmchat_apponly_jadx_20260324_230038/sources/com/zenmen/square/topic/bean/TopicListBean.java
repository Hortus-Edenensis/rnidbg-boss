package com.zenmen.square.topic.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.zenmen.listui.list.BaseBean;
import defpackage.ir5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TopicListBean implements BaseBean {
    public ActivityInfo activityInfo;
    public List<Topic> topicList;
    public String topicListText;

    /* JADX INFO: compiled from: SearchBox */
    public static class ActivityInfo {
        public long activityEndTime;
        public String activityGreeting;
        public String activityGuide;
        public long activityId;
        public String activityParticipationText;
        public long activityStartTime;
        public String activityTitle;
        public List<Ae> aeList;
        public String aeMainTitle;
        public String aeSubTitle;
        public String bgImage;
        public long topicId;
        public String topicName;

        public boolean isValid() {
            long jC = ir5.c(true);
            return jC > this.activityStartTime && jC < this.activityEndTime;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Ae implements Parcelable {
        public static final Parcelable.Creator<Ae> CREATOR = new Parcelable.Creator<Ae>() { // from class: com.zenmen.square.topic.bean.TopicListBean.Ae.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Ae createFromParcel(Parcel parcel) {
                return new Ae(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Ae[] newArray(int i) {
                return new Ae[i];
            }
        };
        public String aeIcon;
        public long aeId;
        public String aeName;

        public Ae() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAeIcon() {
            return this.aeIcon;
        }

        public long getAeId() {
            return this.aeId;
        }

        public String getAeName() {
            return this.aeName;
        }

        public void setAeIcon(String str) {
            this.aeIcon = str;
        }

        public void setAeId(long j) {
            this.aeId = j;
        }

        public void setAeName(String str) {
            this.aeName = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.aeId);
            parcel.writeString(this.aeName);
            parcel.writeString(this.aeIcon);
        }

        public Ae(Parcel parcel) {
            this.aeId = parcel.readLong();
            this.aeName = parcel.readString();
            this.aeIcon = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Topic implements Parcelable {
        public static final int ACTIVITY_TYPE_DEFAULT = 0;
        public static final int ACTIVITY_TYPE_RED = 1;
        public static final Parcelable.Creator<Topic> CREATOR = new Parcelable.Creator<Topic>() { // from class: com.zenmen.square.topic.bean.TopicListBean.Topic.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Topic createFromParcel(Parcel parcel) {
                return new Topic(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Topic[] newArray(int i) {
                return new Topic[i];
            }
        };
        public static final int STATUS_OFF = 0;
        public static final int STATUS_ON = 1;
        public long activityId;
        public String bannerUrl;
        public int topicActivityType;
        private long topicEndTime;
        public long topicId;
        public String topicName;
        private int topicStatus;
        public String topicThumbnail;
        public int topicType;

        /* JADX INFO: compiled from: SearchBox */
        public enum TopicType {
            HEADER,
            PUBLIC
        }

        public Topic() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public long getActivityId() {
            return this.activityId;
        }

        public int getTopicActivityType() {
            return this.topicActivityType;
        }

        public long getTopicEndTime() {
            return this.topicEndTime;
        }

        public long getTopicId() {
            return this.topicId;
        }

        public String getTopicName() {
            return this.topicName;
        }

        public int getTopicStatus() {
            return this.topicStatus;
        }

        public String getTopicThumbnail() {
            return this.topicThumbnail;
        }

        public boolean isValid(TopicType topicType) {
            return topicType == TopicType.HEADER ? this.topicStatus == 1 : topicType == TopicType.PUBLIC && this.topicEndTime > ir5.c(true);
        }

        public void setActivityId(long j) {
            this.activityId = j;
        }

        public void setTopicActivityType(int i) {
            this.topicActivityType = i;
        }

        public void setTopicEndTime(long j) {
            this.topicEndTime = j;
        }

        public void setTopicId(long j) {
            this.topicId = j;
        }

        public void setTopicName(String str) {
            this.topicName = str;
        }

        public void setTopicStatus(int i) {
            this.topicStatus = i;
        }

        public void setTopicThumbnail(String str) {
            this.topicThumbnail = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.topicActivityType);
            parcel.writeLong(this.activityId);
            parcel.writeLong(this.topicId);
            parcel.writeString(this.topicName);
            parcel.writeString(this.topicThumbnail);
            parcel.writeString(this.bannerUrl);
            parcel.writeInt(this.topicType);
            parcel.writeInt(this.topicStatus);
            parcel.writeLong(this.topicEndTime);
        }

        public Topic(Parcel parcel) {
            this.topicActivityType = parcel.readInt();
            this.activityId = parcel.readLong();
            this.topicId = parcel.readLong();
            this.topicName = parcel.readString();
            this.topicThumbnail = parcel.readString();
            this.bannerUrl = parcel.readString();
            this.topicType = parcel.readInt();
            this.topicStatus = parcel.readInt();
            this.topicEndTime = parcel.readLong();
        }
    }

    public List<Topic> getTopicList(Topic.TopicType topicType) {
        ArrayList arrayList = new ArrayList();
        List<Topic> list = this.topicList;
        if (list != null && list.size() > 0) {
            for (Topic topic : this.topicList) {
                if (topic.isValid(topicType)) {
                    arrayList.add(topic);
                }
            }
        }
        return arrayList;
    }
}
