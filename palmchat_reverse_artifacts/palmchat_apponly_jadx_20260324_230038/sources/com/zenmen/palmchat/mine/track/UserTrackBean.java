package com.zenmen.palmchat.mine.track;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class UserTrackBean {
    private String bottomTip;
    private List<UserTrackBeanList> resultList;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class UserTrackBeanList {
        private String avatar;
        private String desc;
        private Integer gender;
        private String nickname;
        private Long optTime;
        private int page;
        private int position;
        private Long uid;
        private Long version;

        public String getAvatar() {
            return this.avatar;
        }

        public String getDesc() {
            return this.desc;
        }

        public Integer getGender() {
            return this.gender;
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

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setGender(Integer num) {
            this.gender = num;
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

    public String getBottomTip() {
        return this.bottomTip;
    }

    public List<UserTrackBeanList> getResultList() {
        return this.resultList;
    }

    public void setBottomTip(String str) {
        this.bottomTip = str;
    }

    public void setResultList(List<UserTrackBeanList> list) {
        this.resultList = list;
    }
}
