package com.zenmen.palmchat.mine.track;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class DynamicTrackBean {
    private String bottomTip;
    private List<DynamicTrackBeanList> resultList;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class DynamicTrackBeanList {
        private String avatar;
        private String content;
        private Long feedId;
        private Integer feedType;
        private Integer gender;
        private String location;
        private List<TrackMediaList> mediaList;
        private String nickname;
        private Long optTime;
        private int page;
        private int position;
        private Long uid;
        private Long version;

        public String getAvatar() {
            return this.avatar;
        }

        public String getContent() {
            return this.content;
        }

        public Long getFeedId() {
            return this.feedId;
        }

        public Integer getFeedType() {
            return this.feedType;
        }

        public Integer getGender() {
            return this.gender;
        }

        public String getLocation() {
            return this.location;
        }

        public List<TrackMediaList> getMediaList() {
            return this.mediaList;
        }

        public String getNickname() {
            return this.nickname;
        }

        public Long getOptTime() {
            return this.optTime;
        }

        public int getPage() {
            return this.page;
        }

        public int getPosition() {
            return this.position;
        }

        public Long getUid() {
            return this.uid;
        }

        public Long getVersion() {
            return this.version;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setFeedId(Long l) {
            this.feedId = l;
        }

        public void setFeedType(Integer num) {
            this.feedType = num;
        }

        public void setGender(Integer num) {
            this.gender = num;
        }

        public void setLocation(String str) {
            this.location = str;
        }

        public void setMediaList(List<TrackMediaList> list) {
            this.mediaList = list;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setOptTime(Long l) {
            this.optTime = l;
        }

        public void setPage(int i) {
            this.page = i;
        }

        public void setPosition(int i) {
            this.position = i;
        }

        public void setUid(Long l) {
            this.uid = l;
        }

        public void setVersion(Long l) {
            this.version = l;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class TrackMediaList {
        private String height;
        private String thumbUrl;
        private String videoUrl;
        private String width;

        public String getHeight() {
            return this.height;
        }

        public String getThumbUrl() {
            return this.thumbUrl;
        }

        public String getVideoUrl() {
            return this.videoUrl;
        }

        public String getWidth() {
            return this.width;
        }

        public void setHeight(String str) {
            this.height = str;
        }

        public void setThumbUrl(String str) {
            this.thumbUrl = str;
        }

        public void setVideoUrl(String str) {
            this.videoUrl = str;
        }

        public void setWidth(String str) {
            this.width = str;
        }
    }

    public String getBottomTip() {
        return this.bottomTip;
    }

    public List<DynamicTrackBeanList> getResultList() {
        return this.resultList;
    }

    public void setBottomTip(String str) {
        this.bottomTip = str;
    }

    public void setResultList(List<DynamicTrackBeanList> list) {
        this.resultList = list;
    }
}
