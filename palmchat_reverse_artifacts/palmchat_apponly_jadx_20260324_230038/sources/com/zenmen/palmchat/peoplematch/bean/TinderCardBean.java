package com.zenmen.palmchat.peoplematch.bean;

import androidx.annotation.Keep;
import defpackage.cg4;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class TinderCardBean implements Serializable {
    public int age;
    public String birthday;
    public int charmValue;
    public String city;
    public String company;
    public List<Double> coordinate;
    public int distance;
    public String exid;
    public String ext;
    public String headImgUrl;
    public String hobby;
    public boolean isShowBirthday;
    public boolean isShowCity;
    public boolean isShowLocation;
    public String nickname;
    public int onlineStatusCode;
    public String onlineStatusDesc;
    public List<Pictures> pictures;
    public String position;
    public int recommendSubType;
    public String recommendType;
    public int richValue;
    public int sayHiState;
    public int sex;
    public String signatureText;
    public long uid;
    public UserDailyLife userDailyLife;
    public UserGifts userGifts;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Pictures implements Serializable {
        public boolean isPerson;
        public String pictureId;
        public int status;
        public String url;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class UserDailyLife implements Serializable {
        public int errorCode;
        public boolean lastVersion;
        public boolean photoTaskShow;
        public int totalCount;
        public List<UserDailyLifeItem> userDailyLifeList;

        /* JADX INFO: compiled from: SearchBox */
        @Keep
        public static class UserDailyLifeItem {
            public String city = "";
            public String content = "";
            public long createTime = 0;
            public String exid = "";
            public int feedType = 0;
            public String height = "";
            public int id = 0;
            public double latitude = 0.0d;
            public double longitude = 0.0d;
            public int mediaSize = 0;
            public int picSource = 0;
            public long shootingTime = 0;
            public String thumbUrl = "";
            public long uid = 0;
            public long version = 0;
            public String width = "";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class UserGifts implements Serializable {
        public List<Gifts> gifts;
        public int totalCount;

        /* JADX INFO: compiled from: SearchBox */
        @Keep
        public static class Gifts implements Serializable {
            public String descr;
            public String iconUrl;
            public int itemCount;
            public int itemId;
            public String itemName;
            public int price;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof TinderCardBean) {
            TinderCardBean tinderCardBean = (TinderCardBean) obj;
            if (cg4.c(this.uid, this.exid, tinderCardBean.uid, tinderCardBean.exid)) {
                return true;
            }
        }
        return false;
    }
}
