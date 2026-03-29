package com.zenmen.palmchat.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.bean.Amulet;
import com.zenmen.palmchat.contacts.bean.ContactAlbumBean;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import com.zenmen.palmchat.contacts.bean.ContactLocalExt;
import com.zenmen.palmchat.contacts.bean.ContactLoveBean;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import defpackage.az2;
import defpackage.r54;
import defpackage.v4;
import defpackage.vs0;
import defpackage.y66;
import defpackage.yh4;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ContactInfoItem implements ChatItem, Cloneable {
    public static final int ACCOUNT_TYPE_BLANK = -4;
    public static final int ACCOUNT_TYPE_CANCELLATION = -1;
    public static final int ACCOUNT_TYPE_SUSPECTED = -2;
    public static final int ACCOUNT_TYPE_VIOLATION = -3;
    public static final Parcelable.Creator<ContactInfoItem> CREATOR = new a();
    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_MALE = 0;
    public static final int GENDER_NULL = -1;
    public static final int SOURCE_TYPE_ACCURATE_RECOMMEND = 18;
    public static final int SOURCE_TYPE_ACTIVE_FRIENDS = 10;
    public static final int SOURCE_TYPE_AGREESUBTYPE_CONTACT_ALERT = 4;
    public static final int SOURCE_TYPE_AGREESUBTYPE_THREAD_AGREE = 1;
    public static final int SOURCE_TYPE_AUTO_ADD_CONTACT = 4;
    public static final int SOURCE_TYPE_AUTO_RECOMMEND = 17;
    public static final int SOURCE_TYPE_BIS = 23;
    public static final int SOURCE_TYPE_BIS_SUBTYPE_NATIVE = 2;
    public static final int SOURCE_TYPE_BIS_SUBTYPE_POP = 1;
    public static final int SOURCE_TYPE_CHATROOM = 16;
    public static final int SOURCE_TYPE_CONTACT_NAME_CARD = 6;
    public static final int SOURCE_TYPE_CONTACT_RECOMMEND = 3;
    public static final int SOURCE_TYPE_CONTACT_RECOMMEND_NEW = 20;
    public static final int SOURCE_TYPE_COUPLE = 43;
    public static final int SOURCE_TYPE_FIND_FRIEND = 46;
    public static final int SOURCE_TYPE_FIND_FRIEND_SUBTYPE_NEARBY = 2;
    public static final int SOURCE_TYPE_FIND_FRIEND_SUBTYPE_PZJY = 3;
    public static final int SOURCE_TYPE_FIND_FRIEND_SUBTYPE_RECOMMEND = 1;
    public static final int SOURCE_TYPE_GROUP = 2;
    public static final int SOURCE_TYPE_GROUP_CHAT = 12;
    public static final int SOURCE_TYPE_GROUP_CHAT_SUBTYPE_CLICK_MSG = 1;
    public static final int SOURCE_TYPE_GROUP_CHAT_SUBTYPE_MULTI_APPLY_DIALOG = 2;
    public static final int SOURCE_TYPE_KDY = -1;
    public static final int SOURCE_TYPE_MARRIAGE_MATCH = 45;
    public static final int SOURCE_TYPE_MATCH = 28;
    public static final int SOURCE_TYPE_NEARBY = 14;
    public static final int SOURCE_TYPE_PEOPLE_NEARBY = 34;
    public static final int SOURCE_TYPE_PEOPLE_YOU_MAY_KNOW = 22;
    public static final int SOURCE_TYPE_PRIVATE_CHAT = 60;
    public static final int SOURCE_TYPE_PRIVATE_CHAT_SUBTYPE_JRYF = 4;
    public static final int SOURCE_TYPE_PRIVATE_CHAT_SUBTYPE_MY_TAB_PYTJ = 2;
    public static final int SOURCE_TYPE_PRIVATE_CHAT_SUBTYPE_OTHER = 0;
    public static final int SOURCE_TYPE_PRIVATE_CHAT_SUBTYPE_SQUARE_PYTJ = 6;
    public static final int SOURCE_TYPE_PRIVATE_CHAT_SUBTYPE_VENUS = 1;
    public static final int SOURCE_TYPE_PRIVATE_CHAT_SUBTYPE_XDPP = 3;
    public static final int SOURCE_TYPE_PROFILE = 47;
    public static final int SOURCE_TYPE_PULL_CONTACT = 23;
    public static final int SOURCE_TYPE_PUSH_CONTACT = 21;
    public static final int SOURCE_TYPE_PUSH_CONTACT_REQUEST = 200;
    public static final int SOURCE_TYPE_RECOMMEND = 7;
    public static final int SOURCE_TYPE_SCAN = 1;
    public static final int SOURCE_TYPE_SEARCH = 0;
    public static final int SOURCE_TYPE_SECRETARY_RECOMMEND = 18;
    public static final int SOURCE_TYPE_SINGLE_CHAT = 11;
    public static final int SOURCE_TYPE_SMALLVIDEO = 38;
    public static final int SOURCE_TYPE_SMALLVIDEO_SUBTYPE_COMMENT = 1;
    public static final int SOURCE_TYPE_SMALLVIDEO_SUBTYPE_FANS = 3;
    public static final int SOURCE_TYPE_SMALLVIDEO_SUBTYPE_LIKE = 2;
    public static final int SOURCE_TYPE_SQUARE = 44;
    public static final int SOURCE_TYPE_SQUARE_SUBTYPE_DISCUSSION = 3;
    public static final int SOURCE_TYPE_SQUARE_SUBTYPE_NEARBY = 2;
    public static final int SOURCE_TYPE_SQUARE_SUBTYPE_OTHER = 1;
    public static final int SOURCE_TYPE_SQUARE_SUBTYPE_WSEEM = 4;
    public static final int SOURCE_TYPE_SUBTYPE_CONTACT_ALERT = 92;
    public static final int SOURCE_TYPE_SUBTYPE_ENHANCED_CARD = 93;
    public static final int SOURCE_TYPE_SUBTYPE_ENHANCED_LANDING_PAGE = 95;
    public static final int SOURCE_TYPE_SUBTYPE_ENHANCED_NEW_CONTACT = 94;
    public static final int SOURCE_TYPE_SUBTYPE_THREAD_ADD = 19;
    public static final int SOURCE_TYPE_UNKNOWN = -1;
    public static final int SOURCE_TYPE_VOICE_ROOM = -1;
    public static final int TYPE_ROLE_ADMIN = 2;
    public static final int TYPE_ROLE_MEMBER = 3;
    public static final int TYPE_ROLE_OWNER = 1;
    public static final String UNRECONIZED_INDEX_STRING = "#";
    private String account;
    private int accountType;
    private String age;
    private ContactAlbumBean album;
    private String albumInfo;
    private String album_cover;
    private ArrayList<MediaItem> album_shortcuts;
    private String allPinyin;
    private long applyFriendTime;
    private String bigIconURL;
    private String birthday;
    private int charmLevel;
    private String city;
    private String cityName;
    public ContactLocalExt contactLocalExt;
    private String country;
    private long cycleShowTime;
    private String description;
    private long distance;
    private String email;
    private String exid;

    @SerializedName("ext_inner")
    private ContactExtBean ext;
    private String fid;
    private String firstPinyin;
    private int friendType;
    private String groupRemarkName;
    private boolean hideRegisterMobile;
    private String himg;
    private String hobby;
    private String iconURL;
    private String introduction;
    private int isGroupOwner;
    private boolean isOnline;
    private boolean isRunOff;
    private long joinTime;
    private String likeCount;
    private List<ContactLoveBean> loveView;
    private String mobile;
    private int muteStatus;
    private String nickId;
    private String nickName;
    private String nickname;
    private String onlineStatusDesc;

    @SerializedName("ext")
    private String originExt;
    private String province;
    private int rank;
    private String remarkAllPinyin;
    private String remarkFirstPinyin;
    private String remarkName;
    private String[] remarkTel;
    private int requestType;
    private int richLevel;
    private String roomRemark;
    private long sendTime;
    private int sessionConfig;
    private String signature;
    private int supportConfig;
    private String uid;
    private long updateTime;
    private List<String> userLabelImg;
    private int feedSeparation = 0;
    private int gender = -1;
    private int genderReal = -1;
    private int sex = -1;
    private int sourceType = -1;
    private int bizType = 0;
    private String identifyCode = "";
    private boolean isLiked = false;
    private int roleType = 3;
    private boolean showAsSpecialAttention = false;
    private String mobileForShow = null;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Portrait implements Parcelable {
        public static final Parcelable.Creator<Portrait> CREATOR = new a();
        public String headIcon;
        public String headImg;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Parcelable.Creator<Portrait> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Portrait createFromParcel(Parcel parcel) {
                return new Portrait(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Portrait[] newArray(int i) {
                return new Portrait[i];
            }
        }

        public Portrait() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.headImg);
            parcel.writeString(this.headIcon);
        }

        public Portrait(Parcel parcel) {
            this.headImg = parcel.readString();
            this.headIcon = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<ContactInfoItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactInfoItem createFromParcel(Parcel parcel) {
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setNickName(parcel.readString());
            contactInfoItem.setNickname(parcel.readString());
            contactInfoItem.setHimg(parcel.readString());
            contactInfoItem.setRemarkName(parcel.readString());
            contactInfoItem.setSignature(parcel.readString());
            contactInfoItem.setBirthday(parcel.readString());
            contactInfoItem.setHobby(parcel.readString());
            contactInfoItem.setAge(parcel.readString());
            contactInfoItem.setIconURL(parcel.readString());
            contactInfoItem.setBigIconURL(parcel.readString());
            contactInfoItem.setMobile(parcel.readString());
            contactInfoItem.setEmail(parcel.readString());
            contactInfoItem.setUpdateTime(parcel.readLong());
            contactInfoItem.setNickId(parcel.readString());
            contactInfoItem.setRank(parcel.readInt());
            contactInfoItem.setFirstPinyin(parcel.readString());
            contactInfoItem.setAllPinyin(parcel.readString());
            contactInfoItem.setRemarkFirstPinyin(parcel.readString());
            contactInfoItem.setRemarkAllPinyin(parcel.readString());
            contactInfoItem.setUid(parcel.readString());
            contactInfoItem.setExid(parcel.readString());
            contactInfoItem.setGender(parcel.readInt());
            contactInfoItem.setGenderReal(parcel.readInt());
            contactInfoItem.setCountry(parcel.readString());
            contactInfoItem.setProvince(parcel.readString());
            contactInfoItem.setCity(parcel.readString());
            contactInfoItem.setIsGroupOwner(parcel.readInt());
            contactInfoItem.setSourceType(parcel.readInt());
            contactInfoItem.setSessionConfig(parcel.readInt());
            contactInfoItem.setAccount(parcel.readString());
            contactInfoItem.setRemarkTel(parcel.createStringArray());
            contactInfoItem.setDescription(parcel.readString());
            contactInfoItem.setGroupRemarkName(parcel.readString());
            contactInfoItem.setHideRegisterMobile(parcel.readInt() == 1);
            contactInfoItem.setFriendType(parcel.readInt());
            contactInfoItem.setBizType(parcel.readInt());
            contactInfoItem.setAccountType(parcel.readInt());
            contactInfoItem.setRequestType(parcel.readInt());
            contactInfoItem.setSendTime(parcel.readLong());
            contactInfoItem.setIdentifyCode(parcel.readString());
            contactInfoItem.setRoleType(parcel.readInt());
            contactInfoItem.setMuteStatus(parcel.readInt());
            contactInfoItem.setRoomRemark(parcel.readString());
            contactInfoItem.setIntroduction(parcel.readString());
            contactInfoItem.setSupportConfig(parcel.readInt());
            contactInfoItem.setDistance(parcel.readLong());
            contactInfoItem.setOnline(parcel.readInt() == 1);
            contactInfoItem.setCityName(parcel.readString());
            contactInfoItem.setOnlineStatusDesc(parcel.readString());
            contactInfoItem.setAlbum((ContactAlbumBean) parcel.readParcelable(ContactAlbumBean.class.getClassLoader()));
            contactInfoItem.setExt((ContactExtBean) parcel.readParcelable(ContactExtBean.class.getClassLoader()));
            return contactInfoItem;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ContactInfoItem[] newArray(int i) {
            return new ContactInfoItem[i];
        }
    }

    public static ContactInfoItem buildFromJson(String str) {
        ContactInfoItem contactInfoItem = (ContactInfoItem) az2.a(str, ContactInfoItem.class);
        if (contactInfoItem != null) {
            contactInfoItem.setExt((ContactExtBean) az2.a(contactInfoItem.originExt, ContactExtBean.class));
        }
        return contactInfoItem;
    }

    private String getMobileForShow() {
        if (this.mobileForShow == null) {
            this.mobileForShow = yh4.a(this.mobile);
        }
        return this.mobileForShow;
    }

    public static String getRemarkTelForDb(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i != strArr.length - 1) {
                sb.append("$");
            }
        }
        return sb.toString();
    }

    public static boolean isUidAvailable(String str) {
        return (str == null || "0".equals(str) || TextUtils.isEmpty(str)) ? false : true;
    }

    public String covert2OriData() {
        String strC = az2.c(this);
        try {
            JSONObject jSONObject = new JSONObject(strC);
            jSONObject.put("ext", az2.c(this.ext));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return strC;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccount() {
        return this.account;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public String getAge() {
        return this.age;
    }

    public int getAgeInt() {
        if (TextUtils.isEmpty(this.age)) {
            return 0;
        }
        try {
            return Integer.parseInt(this.age);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ContactAlbumBean getAlbum() {
        return this.album;
    }

    public String getAlbumInfo() {
        return this.albumInfo;
    }

    public String getAlbum_cover() {
        return this.album_cover;
    }

    public ArrayList<MediaItem> getAlbum_shortcuts() {
        return this.album_shortcuts;
    }

    public String getAllPinyin() {
        return this.allPinyin;
    }

    public Amulet getAmulet() {
        if (getExt() != null) {
            return getExt().getAmulet();
        }
        return null;
    }

    public long getApplyFriendTime() {
        return this.applyFriendTime;
    }

    public String getBigIconURL() {
        return this.bigIconURL;
    }

    public String getBirthday() {
        return this.birthday;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getBizType() {
        return this.bizType;
    }

    public int getCharmLevel() {
        return this.charmLevel;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getChatId() {
        return this.uid;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getChatName() {
        return getNameForShow();
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getChatType() {
        return 0;
    }

    public String getCity() {
        return this.city;
    }

    public String getCityName() {
        return this.cityName;
    }

    public ContactLocalExt getContactLocalExt() {
        return this.contactLocalExt;
    }

    public String getCountry() {
        return this.country;
    }

    public long getCycleShowTime() {
        return this.cycleShowTime;
    }

    public String getDescription() {
        return this.description;
    }

    public long getDistance() {
        return this.distance;
    }

    public String getEmail() {
        return this.email;
    }

    public String getExid() {
        return this.exid;
    }

    public ContactExtBean getExt() {
        return this.ext;
    }

    public int getFeedSeparation() {
        return this.feedSeparation;
    }

    public String getFid() {
        return this.fid;
    }

    public String getFirstPinyin() {
        return this.firstPinyin;
    }

    public String[] getFondForShow() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getFondForShow();
        }
        return null;
    }

    public int getFriendType() {
        return this.friendType;
    }

    public int getGender() {
        int i = this.gender;
        return i != -1 ? i : this.sex;
    }

    public int getGenderReal() {
        return this.genderReal;
    }

    public String getGroupRemarkName() {
        return this.groupRemarkName;
    }

    public boolean getHideRegisterMobile() {
        return this.hideRegisterMobile;
    }

    public String getHimg() {
        return this.himg;
    }

    public String getHobby() {
        return this.hobby;
    }

    public String getHomeTownForShow() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getHomeTownForShow();
        }
        return null;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getIconURL() {
        return this.iconURL;
    }

    public String getIdentifyCode() {
        return this.identifyCode;
    }

    public List<Portrait> getImgList() {
        ContactAlbumBean contactAlbumBean = this.album;
        if (contactAlbumBean == null) {
            return null;
        }
        return contactAlbumBean.getImgList();
    }

    public int getIncome() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getIncome();
        }
        return 0;
    }

    public String getIncomeForShow() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getIncomeForShow();
        }
        return null;
    }

    public String getIndexPinyin(boolean z) {
        String upperCase = (!z || TextUtils.isEmpty(getRemarkFirstPinyin())) ? !TextUtils.isEmpty(getFirstPinyin()) ? getFirstPinyin().toUpperCase() : null : getRemarkFirstPinyin().toUpperCase();
        return upperCase == null ? "#" : upperCase;
    }

    public int[] getIntention() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getIntention();
        }
        return null;
    }

    public String[] getIntentionForShow() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getIntentionForShow();
        }
        return null;
    }

    public float getIntimacyScore() {
        if (getContactLocalExt() != null) {
            return getContactLocalExt().intimacyScore;
        }
        return 0.0f;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public int getIsGroupOwner() {
        return this.isGroupOwner;
    }

    public boolean getIsStranger() {
        return this.friendType != 0;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public String getLikeCount() {
        return this.likeCount;
    }

    public String[] getLikePersonalityForShow() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getLikePersonalityForShow(getGender() == 1);
        }
        return null;
    }

    public List<ContactLoveBean> getLoveView() {
        return this.loveView;
    }

    public String getMobile() {
        return getMobileForShow();
    }

    public int getMuteStatus() {
        return this.muteStatus;
    }

    public String getNameForShow() {
        return !TextUtils.isEmpty(this.remarkName) ? this.remarkName : !TextUtils.isEmpty(this.groupRemarkName) ? this.groupRemarkName : !TextUtils.isEmpty(this.nickName) ? this.nickName : !TextUtils.isEmpty(this.nickname) ? this.nickname : this.uid;
    }

    public String getNamenomarkName() {
        return !TextUtils.isEmpty(this.groupRemarkName) ? this.groupRemarkName : this.nickName;
    }

    public String getNickId() {
        return this.nickId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getOccupation() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getOccupation();
        }
        return 0;
    }

    public String getOccupationForShow() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getOccupationForShow();
        }
        return null;
    }

    public String getOnlineStatusDesc() {
        return this.onlineStatusDesc;
    }

    public String[] getPersonalityForShow() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getPersonalityForShow(getGender() == 1);
        }
        return null;
    }

    public String getProvince() {
        return this.province;
    }

    public int getRank() {
        return this.rank;
    }

    public String getRealestateForShow() {
        ContactExtBean contactExtBean = this.ext;
        if (contactExtBean != null) {
            return contactExtBean.getRealestateForShow();
        }
        return null;
    }

    public String getRemarkAllPinyin() {
        return this.remarkAllPinyin;
    }

    public String getRemarkFirstPinyin() {
        return this.remarkFirstPinyin;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public String[] getRemarkTel() {
        return this.remarkTel;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public int getRichLevel() {
        return this.richLevel;
    }

    public int getRiskLevel() {
        int i = this.accountType;
        if (i == -2) {
            return 30;
        }
        if (i == -3) {
            return 40;
        }
        return i == -4 ? 50 : 0;
    }

    public int getRoleType() {
        return this.roleType;
    }

    public String getRoomRemark() {
        return this.roomRemark;
    }

    public long getSendTime() {
        return this.sendTime;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getSessionConfig() {
        return this.sessionConfig;
    }

    public String getSignature() {
        return this.signature;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public String getStringHasCar() {
        ContactExtBean contactExtBean = this.ext;
        return (contactExtBean == null || contactExtBean.getCar() == null) ? "" : this.ext.getCar().car == 1 ? "已购车" : "未购车";
    }

    public int getSupportConfig() {
        return this.supportConfig;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public List<String> getUserLabelImg() {
        return this.userLabelImg;
    }

    public boolean hasAmulet() {
        return (getExt() == null || getExt().getAmulet() == null || !getExt().getAmulet().isOk()) ? false : true;
    }

    public boolean hasCar() {
        ContactExtBean contactExtBean = this.ext;
        return (contactExtBean == null || contactExtBean.getCar() == null || this.ext.getCar().car != 1) ? false : true;
    }

    public boolean hasPortrait() {
        return TextUtils.isEmpty(this.iconURL) || !((this.iconURL.contains("default/default") || this.iconURL.contains("system/system")) && !TextUtils.isEmpty(this.bigIconURL) && (this.bigIconURL.contains("default/default") || this.bigIconURL.contains("system/system")));
    }

    public boolean isCancellation() {
        return this.accountType == -1;
    }

    public boolean isLiked() {
        return this.isLiked;
    }

    public boolean isNewUser() {
        ContactExtBean ext = getExt();
        return ext != null && Math.abs(System.currentTimeMillis() - ext.getInitedTime()) < vs0.a().d("Newusersign", 72L) * 3600000;
    }

    public boolean isOfficialAccount() {
        ContactExtBean ext = getExt();
        boolean z = false;
        if (ext != null && ext.getOfficial() == 1) {
            z = true;
        }
        return !z ? r54.b(getUid()) : z;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public boolean isPortraitPermission() {
        ContactAlbumBean contactAlbumBean = this.album;
        return contactAlbumBean != null && contactAlbumBean.getAlbumcode() == 1;
    }

    public boolean isRiskClosure() {
        return y66.b().f(this);
    }

    public boolean isRunOff() {
        return this.isRunOff;
    }

    public boolean isSelf() {
        String str = this.uid;
        return str != null && str.equals(v4.e(com.zenmen.palmchat.c.b()));
    }

    public boolean needCompleteProfile() {
        String[] intentionForShow;
        return getExt() == null || (intentionForShow = getIntentionForShow()) == null || intentionForShow.length == 0 || TextUtils.isEmpty(getOccupationForShow()) || TextUtils.isEmpty(getIncomeForShow()) || TextUtils.isEmpty(getHomeTownForShow()) || getExt().getPersonality() == null || getExt().getPersonality().length == 0 || getExt().getLikepersonality() == null || getExt().getLikepersonality().length == 0 || getExt().getFond() == null || getExt().getFond().size() == 0 || getExt().getRealestate() == null || getExt().getCar() == null;
    }

    public boolean needHideProfile() {
        String str;
        return ((!isCancellation() && !isRiskClosure()) || (str = this.uid) == null || str.equals(v4.e(com.zenmen.palmchat.c.b()))) ? false : true;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAccountType(int i) {
        this.accountType = i;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public void setAlbum(ContactAlbumBean contactAlbumBean) {
        this.album = contactAlbumBean;
    }

    public void setAlbumInfo(String str) {
        JSONObject jSONObjectOptJSONObject;
        String str2 = this.album_cover;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cover");
            String strOptString = "";
            if (jSONArrayOptJSONArray != null && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) != null) {
                strOptString = jSONObjectOptJSONObject.optString("url");
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strOptString) && !str2.equals(strOptString)) {
                this.isLiked = false;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("like", this.isLiked);
            jSONObject.put("like", jSONObject2);
            this.album_cover = strOptString;
            JSONArray jSONArray = jSONObject.getJSONArray("imgList");
            if (jSONArray != null) {
                ArrayList<MediaItem> arrayList = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    MediaItem mediaItem = new MediaItem();
                    mediaItem.fileFullPath = jSONObject3.optString("thumbUrl");
                    mediaItem.mimeType = jSONObject3.optInt("type", 0);
                    arrayList.add(mediaItem);
                }
                setAlbum_shortcuts(arrayList);
            }
            this.albumInfo = jSONObject.toString();
        } catch (Exception unused) {
        }
    }

    public void setAlbumInfoUpdateLike(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONArray("cover").optJSONObject(0);
            String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("url") : "";
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("like");
            if (jSONObjectOptJSONObject2 != null) {
                setLiked(jSONObjectOptJSONObject2.optBoolean("like"));
            }
            this.album_cover = strOptString;
            JSONArray jSONArray = jSONObject.getJSONArray("imgList");
            if (jSONArray != null) {
                ArrayList<MediaItem> arrayList = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    MediaItem mediaItem = new MediaItem();
                    mediaItem.fileFullPath = jSONObject2.optString("thumbUrl");
                    mediaItem.mimeType = jSONObject2.optInt("type", 0);
                    arrayList.add(mediaItem);
                }
                setAlbum_shortcuts(arrayList);
            }
            this.albumInfo = str;
        } catch (Exception unused) {
        }
    }

    public void setAlbum_cover(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                String str = this.albumInfo;
                JSONObject jSONObject3 = !TextUtils.isEmpty(str) ? new JSONObject(str) : new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                String strOptString = jSONObject.optString("url");
                this.album_cover = strOptString;
                jSONObject4.put("url", strOptString);
                jSONObject4.put("height", jSONObject.optString("height"));
                jSONObject4.put("width", jSONObject.optString("width"));
                jSONObject4.put("thumbUrl", jSONObject.optString("thumbUrl"));
                JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("imgList");
                JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject("like");
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(0, jSONObject4);
                jSONObject2.put("cover", jSONArray);
                jSONObject2.put("imgList", jSONObjectOptJSONObject);
                jSONObject2.put("like", jSONObjectOptJSONObject2);
                this.albumInfo = jSONObject2.toString();
            }
        } catch (Exception unused) {
        }
    }

    public void setAlbum_shortcuts(ArrayList<MediaItem> arrayList) {
        this.album_shortcuts = arrayList;
    }

    public void setAllPinyin(String str) {
        this.allPinyin = str;
    }

    public void setApplyFriendTime(long j) {
        this.applyFriendTime = j;
    }

    public void setBigIconURL(String str) {
        this.bigIconURL = str;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setBizType(int i) {
        this.bizType = i;
    }

    public void setCharmLevel(int i) {
        this.charmLevel = i;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setContactLocalExt(ContactLocalExt contactLocalExt) {
        this.contactLocalExt = contactLocalExt;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCycleShowTime(long j) {
        this.cycleShowTime = j;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDistance(long j) {
        this.distance = j;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setExid(String str) {
        this.exid = str;
    }

    public void setExt(ContactExtBean contactExtBean) {
        this.ext = contactExtBean;
    }

    public void setFeedSeparation(int i) {
        this.feedSeparation = i;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public void setFirstPinyin(String str) {
        this.firstPinyin = str;
    }

    public void setFriendType(int i) {
        this.friendType = i;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setGenderReal(int i) {
        this.genderReal = i;
    }

    public void setGroupRemarkName(String str) {
        this.groupRemarkName = str;
    }

    public void setHideRegisterMobile(boolean z) {
        this.hideRegisterMobile = z;
    }

    public void setHimg(String str) {
        this.himg = str;
    }

    public void setHobby(String str) {
        this.hobby = str;
    }

    public void setIconURL(String str) {
        this.iconURL = str;
    }

    public void setIdentifyCode(String str) {
        this.identifyCode = str;
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public void setIsGroupOwner(int i) {
        this.isGroupOwner = i;
    }

    public void setJoinTime(long j) {
        this.joinTime = j;
    }

    public void setLikeCount(String str) {
        this.likeCount = str;
    }

    public void setLiked(boolean z) {
        this.isLiked = z;
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.albumInfo;
            JSONObject jSONObject2 = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("cover");
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("imgList");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("like", z);
            jSONObject.put("cover", jSONArrayOptJSONArray);
            jSONObject.put("imgList", jSONObjectOptJSONObject);
            jSONObject.put("like", jSONObject3);
            this.albumInfo = jSONObject.toString();
        } catch (Exception unused) {
        }
    }

    public void setLoveView(List<ContactLoveBean> list) {
        this.loveView = list;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setMuteStatus(int i) {
        this.muteStatus = i;
    }

    public void setNickId(String str) {
        this.nickId = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOnline(boolean z) {
        this.isOnline = z;
    }

    public void setOnlineStatusDesc(String str) {
        this.onlineStatusDesc = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setRank(int i) {
        this.rank = i;
    }

    public void setRemarkAllPinyin(String str) {
        this.remarkAllPinyin = str;
    }

    public void setRemarkFirstPinyin(String str) {
        this.remarkFirstPinyin = str;
    }

    public void setRemarkName(String str) {
        this.remarkName = str;
    }

    public void setRemarkTel(String[] strArr) {
        this.remarkTel = strArr;
    }

    public void setRequestType(int i) {
        this.requestType = i;
    }

    public void setRichLevel(int i) {
        this.richLevel = i;
    }

    public void setRoleType(int i) {
        this.roleType = i;
    }

    public void setRoomRemark(String str) {
        this.roomRemark = str;
    }

    public void setRunOff(boolean z) {
        this.isRunOff = z;
    }

    public void setSendTime(long j) {
        this.sendTime = j;
    }

    public void setSessionConfig(int i) {
        this.sessionConfig = i;
    }

    public void setShowAsSpecialAttention(boolean z) {
        this.showAsSpecialAttention = z;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setSourceType(int i) {
        this.sourceType = i;
    }

    public void setSupportConfig(int i) {
        this.supportConfig = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public void setUserLabelImg(List<String> list) {
        this.userLabelImg = list;
    }

    public boolean showAsSpecialAttention() {
        return this.showAsSpecialAttention;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nickName);
        parcel.writeString(this.nickname);
        parcel.writeString(this.himg);
        parcel.writeString(this.remarkName);
        parcel.writeString(this.signature);
        parcel.writeString(this.birthday);
        parcel.writeString(this.hobby);
        parcel.writeString(this.age);
        parcel.writeString(this.iconURL);
        parcel.writeString(this.bigIconURL);
        parcel.writeString(this.mobile);
        parcel.writeString(this.email);
        parcel.writeLong(this.updateTime);
        parcel.writeString(this.nickId);
        parcel.writeInt(this.rank);
        parcel.writeString(this.firstPinyin);
        parcel.writeString(this.allPinyin);
        parcel.writeString(this.remarkFirstPinyin);
        parcel.writeString(this.remarkAllPinyin);
        parcel.writeString(this.uid);
        parcel.writeString(this.exid);
        parcel.writeInt(this.gender);
        parcel.writeInt(this.genderReal);
        parcel.writeString(this.country);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeInt(this.isGroupOwner);
        parcel.writeInt(this.sourceType);
        parcel.writeInt(this.sessionConfig);
        parcel.writeString(this.account);
        parcel.writeStringArray(this.remarkTel);
        parcel.writeString(this.description);
        parcel.writeString(this.groupRemarkName);
        parcel.writeInt(this.hideRegisterMobile ? 1 : 0);
        parcel.writeInt(this.friendType);
        parcel.writeInt(this.bizType);
        parcel.writeInt(this.accountType);
        parcel.writeInt(this.requestType);
        parcel.writeLong(this.sendTime);
        parcel.writeString(this.identifyCode);
        parcel.writeInt(this.roleType);
        parcel.writeInt(this.muteStatus);
        parcel.writeString(this.roomRemark);
        parcel.writeString(this.introduction);
        parcel.writeInt(this.supportConfig);
        parcel.writeLong(this.distance);
        parcel.writeInt(this.isOnline ? 1 : 0);
        parcel.writeString(this.cityName);
        parcel.writeString(this.onlineStatusDesc);
        parcel.writeParcelable(this.album, 0);
        parcel.writeParcelable(this.ext, 0);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ContactInfoItem m792clone() {
        ContactInfoItem contactInfoItem;
        CloneNotSupportedException e;
        try {
            contactInfoItem = (ContactInfoItem) super.clone();
            try {
                String[] strArr = this.remarkTel;
                if (strArr != null) {
                    contactInfoItem.remarkTel = (String[]) strArr.clone();
                }
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (CloneNotSupportedException e3) {
            contactInfoItem = null;
            e = e3;
        }
        return contactInfoItem;
    }
}
