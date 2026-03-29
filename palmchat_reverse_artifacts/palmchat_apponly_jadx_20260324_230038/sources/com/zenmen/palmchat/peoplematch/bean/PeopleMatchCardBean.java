package com.zenmen.palmchat.peoplematch.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.zenmen.palmchat.peoplematch.bean.TinderCardBean;
import defpackage.cg4;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class PeopleMatchCardBean implements Parcelable {
    public static final String ACTIVITY_GOODS_ID = "613b1986d34508224f59cc50";
    public static final int CERT_FAIL = 2;
    public static final int CERT_INVALID = -100;
    public static final int CERT_NONE = -1;
    public static final int CERT_ONGOING = 0;
    public static final int CERT_SUCCESS = 1;
    public static final Parcelable.Creator<PeopleMatchCardBean> CREATOR = new Parcelable.Creator<PeopleMatchCardBean>() { // from class: com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeopleMatchCardBean createFromParcel(Parcel parcel) {
            return new PeopleMatchCardBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeopleMatchCardBean[] newArray(int i) {
            return new PeopleMatchCardBean[i];
        }
    };
    public static final int RECOMMEND_SUB_TYPE_LIKED = 3;
    public static final int RECOMMEND_SUB_TYPE_QUALITY_HIGH = 5;
    public static final String RECOMMEND_TYPE_LIKED_RECOMMEND = "breakInSayHiPush";
    public static final String RECOMMEND_TYPE_LIKED_UNLOCK = "unLockSayHiPush";
    public static final String RECOMMEND_TYPE_NORMAL = "normal";
    public static final String RECOMMEND_TYPE_REGISTER = "masking";
    public static final int TYPE_PRIORITY_LIKED_RECOMMEND = 1;
    public static final int TYPE_PRIORITY_LIKED_UNLOCK = 2;
    public static final int TYPE_PRIORITY_NORMAL = 0;
    private String age;
    private String birthday;
    private boolean blur;
    public int charmValue;
    private String city;
    private String company;
    private double[] coordinate;
    private double distance;
    private String exid;
    public String ext;
    private double fakeDistance;
    private int fakerecommendSubType;
    private transient String headImg;
    private String headImgUrl;
    public String hobby;
    private boolean isFake;
    private boolean isNewLike;
    private boolean isSameCity;
    public boolean isShowBirthday;
    public boolean isShowCity;
    public boolean isShowLocation;
    private boolean isUnlock;
    private int livingPicCertStatus;
    public String m;
    private String nickname;
    public int onlineStatusCode;
    public String onlineStatusDesc;
    private List<PeopleMatchPhotoBean> pictures;
    private String position;
    private int recommendSubType;
    private String recommendType;
    private String residentialCity;
    private String residentialCountry;
    private String residentialProvince;
    public int richValue;
    public int sayHiState;
    public int sayHiType;
    private transient int selectedIndex;
    public int sendSuperHi;
    private int sex;
    private String signatureText;
    private long uid;
    public TinderCardBean.UserDailyLife userDailyLife;
    public TinderCardBean.UserGifts userGifts;
    private long waitingTime;
    public List<PeopleMatchCardBagbean> wearings;

    public PeopleMatchCardBean() {
        this.fakeDistance = 0.0d;
        this.recommendSubType = -1;
        this.fakerecommendSubType = -1;
        this.waitingTime = 5L;
        this.selectedIndex = -1;
        this.livingPicCertStatus = -1;
        this.isUnlock = false;
        this.m = "";
        this.isNewLike = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PeopleMatchCardBean) {
            PeopleMatchCardBean peopleMatchCardBean = (PeopleMatchCardBean) obj;
            if (cg4.c(getUid(), getExid(), peopleMatchCardBean.getUid(), peopleMatchCardBean.getExid())) {
                return true;
            }
        }
        return false;
    }

    public String getAge() {
        return this.age;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getCity() {
        String str = this.city;
        return str == null ? "" : str;
    }

    public String getCompany() {
        return this.company;
    }

    public double[] getCoordinate() {
        return this.coordinate;
    }

    public double getDistance() {
        return this.distance;
    }

    public String getExid() {
        return this.exid;
    }

    public double getFakeDistance() {
        return this.fakeDistance;
    }

    public int getFakerecommendSubType() {
        return this.fakerecommendSubType;
    }

    public String getHeadImg() {
        return this.headImg;
    }

    public String getHeadImgUrl() {
        return this.headImgUrl;
    }

    public int getLivingPicCertStatus() {
        return this.livingPicCertStatus;
    }

    public String getNickname() {
        return this.nickname;
    }

    public List<PeopleMatchPhotoBean> getPictures() {
        return this.pictures;
    }

    public String getPosition() {
        return this.position;
    }

    public int getRecommendSubType() {
        return this.recommendSubType;
    }

    public String getRecommendType() {
        return this.recommendType;
    }

    public String getResidentialCity() {
        return this.residentialCity;
    }

    public String getResidentialCountry() {
        return this.residentialCountry;
    }

    public String getResidentialProvince() {
        return this.residentialProvince;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public int getSex() {
        return this.sex;
    }

    public String getSignatureText() {
        return this.signatureText;
    }

    public long getUid() {
        return this.uid;
    }

    public long getWaitingTime() {
        return this.waitingTime;
    }

    public boolean isActivityGoods() {
        List<PeopleMatchCardBagbean> list = this.wearings;
        if (list == null) {
            return false;
        }
        Iterator<PeopleMatchCardBagbean> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().goodsId.equals(ACTIVITY_GOODS_ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBlur() {
        return this.blur;
    }

    public boolean isBoost() {
        return this.recommendSubType == 11;
    }

    public boolean isFake() {
        return this.isFake;
    }

    public boolean isLikeShow() {
        return this.isNewLike;
    }

    public boolean isSameCity() {
        return this.isSameCity;
    }

    public boolean isSuperLiked() {
        return this.sendSuperHi == 2 || this.sayHiState == 2;
    }

    public boolean isSuperLikedMatch() {
        return (this.sendSuperHi == 2 && this.sayHiState == 1) || this.sayHiState == 2;
    }

    public boolean isUnlock() {
        return this.isUnlock;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setBlur(boolean z) {
        this.blur = z;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCompany(String str) {
        this.company = str;
    }

    public void setCoordinate(double[] dArr) {
        this.coordinate = dArr;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public void setExid(String str) {
        this.exid = str;
    }

    public void setFake(boolean z) {
        this.isFake = z;
    }

    public void setFakeDistance(double d) {
        this.fakeDistance = d;
    }

    public void setFakerecommendSubType(int i) {
        this.fakerecommendSubType = i;
    }

    public void setHeadImg(String str) {
        this.headImg = str;
    }

    public void setHeadImgUrl(String str) {
        this.headImgUrl = str;
    }

    public void setLikeShow(boolean z) {
        this.isNewLike = z;
    }

    public void setLivingPicCertStatus(int i) {
        this.livingPicCertStatus = i;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPictures(List<PeopleMatchPhotoBean> list) {
        this.pictures = list;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setRecommendSubType(int i) {
        this.recommendSubType = i;
    }

    public void setRecommendType(String str) {
        this.recommendType = str;
    }

    public void setResidentialCity(String str) {
        this.residentialCity = str;
    }

    public void setResidentialCountry(String str) {
        this.residentialCountry = str;
    }

    public void setResidentialProvince(String str) {
        this.residentialProvince = str;
    }

    public void setSameCity(boolean z) {
        this.isSameCity = z;
    }

    public void setSelectedIndex(int i) {
        this.selectedIndex = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setSignatureText(String str) {
        this.signatureText = str;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void setUnlock(boolean z) {
        this.isUnlock = z;
    }

    public void setWaitingTime(long j) {
        this.waitingTime = j;
    }

    public String toString() {
        return "PeopleMatchCardBean{uid=" + this.uid + ", exid='" + this.exid + "', nickname='" + this.nickname + "', sex=" + this.sex + ", birthday='" + this.birthday + "', signatureText='" + this.signatureText + "', position='" + this.position + "', company='" + this.company + "', city='" + this.city + "', residentialCountry='" + this.residentialCountry + "', residentialProvince='" + this.residentialProvince + "', residentialCity='" + this.residentialCity + "', distance=" + this.distance + ", fakeDistance=" + this.fakeDistance + ", coordinate=" + Arrays.toString(this.coordinate) + ", pictures=" + this.pictures + ", recommendType='" + this.recommendType + "', recommendSubType=" + this.recommendSubType + ", fakerecommendSubType=" + this.fakerecommendSubType + ", waitingTime=" + this.waitingTime + ", selectedIndex=" + this.selectedIndex + ", headImg='" + this.headImg + "', livingPicCertStatus=" + this.livingPicCertStatus + ", isUnlock=" + this.isUnlock + ", sayHiState=" + this.sayHiState + ", sendSuperHi=" + this.sendSuperHi + ", headImgUrl=" + this.headImgUrl + ", blur=" + this.blur + ", isFake=" + this.isFake + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.uid);
        parcel.writeString(this.exid);
        parcel.writeString(this.nickname);
        parcel.writeInt(this.sex);
        parcel.writeString(this.birthday);
        parcel.writeString(this.signatureText);
        parcel.writeString(this.city);
        parcel.writeDouble(this.distance);
        parcel.writeInt(this.selectedIndex);
        parcel.writeTypedList(this.pictures);
        parcel.writeString(this.headImg);
        parcel.writeString(this.recommendType);
        parcel.writeLong(this.waitingTime);
        parcel.writeString(this.position);
        parcel.writeString(this.company);
        parcel.writeString(this.residentialCountry);
        parcel.writeString(this.residentialProvince);
        parcel.writeString(this.residentialCity);
        parcel.writeInt(this.recommendSubType);
        parcel.writeInt(this.fakerecommendSubType);
        parcel.writeInt(this.livingPicCertStatus);
        parcel.writeInt(this.isUnlock ? 1 : 0);
        parcel.writeInt(this.sayHiState);
        parcel.writeInt(this.sendSuperHi);
        parcel.writeString(this.headImgUrl);
        parcel.writeInt(this.blur ? 1 : 0);
        parcel.writeInt(this.isFake ? 1 : 0);
        parcel.writeInt(this.sayHiType);
    }

    public PeopleMatchCardBean(Parcel parcel) {
        this.fakeDistance = 0.0d;
        this.recommendSubType = -1;
        this.fakerecommendSubType = -1;
        this.waitingTime = 5L;
        this.selectedIndex = -1;
        this.livingPicCertStatus = -1;
        this.isUnlock = false;
        this.m = "";
        this.isNewLike = false;
        this.uid = parcel.readLong();
        this.exid = parcel.readString();
        this.nickname = parcel.readString();
        this.sex = parcel.readInt();
        this.birthday = parcel.readString();
        this.signatureText = parcel.readString();
        this.city = parcel.readString();
        this.distance = parcel.readDouble();
        this.selectedIndex = parcel.readInt();
        this.pictures = parcel.createTypedArrayList(PeopleMatchPhotoBean.CREATOR);
        this.headImg = parcel.readString();
        this.recommendType = parcel.readString();
        this.waitingTime = parcel.readLong();
        this.position = parcel.readString();
        this.company = parcel.readString();
        this.residentialCountry = parcel.readString();
        this.residentialProvince = parcel.readString();
        this.residentialCity = parcel.readString();
        this.recommendSubType = parcel.readInt();
        this.fakerecommendSubType = parcel.readInt();
        this.livingPicCertStatus = parcel.readInt();
        this.isUnlock = parcel.readInt() == 1;
        this.sayHiState = parcel.readInt();
        this.sendSuperHi = parcel.readInt();
        this.headImgUrl = parcel.readString();
        this.blur = parcel.readInt() == 1;
        this.isFake = parcel.readInt() == 1;
        this.sayHiType = parcel.readInt();
    }
}
