package com.zenmen.palmchat.peoplenearby;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.bo0;
import defpackage.fg4;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PeopleNearbyVo extends ContactInfoItem {
    private String addr;
    private String carImageUrl;
    private String clientType;
    private int feedAdType;
    private String labels;
    private int momentsFlag;
    private fg4 peopleNearbyAdVoNew;
    private String sex;
    private String tags;
    private int timeDifference;
    public boolean isGap = false;
    private boolean isRewardAd = false;
    private boolean isUnlockAd = false;
    private boolean isShowUnlockBtn = false;
    private boolean isUnlockAdTip = false;
    private int distanceHintFlag = 0;
    private String distanceHint = null;

    public static JSONObject mockItem(int i) {
        JSONObject jSONObject = new JSONObject();
        Random random = new Random();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, "1");
            jSONObject.put("account", "account");
            jSONObject.put("distance", random.nextInt(10000));
            jSONObject.put("addr", "addr");
            jSONObject.put("isFriend", random.nextInt(2));
            jSONObject.put("nickname", "nickname" + i);
            jSONObject.put("headIconUrl", "headIconUrl");
            jSONObject.put("headImgUrl", "headImgUrl");
            jSONObject.put(com.umeng.ccg.a.A, com.umeng.ccg.a.A);
            jSONObject.put("sex", random.nextInt(2));
            jSONObject.put("country", "country");
            jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, DistrictSearchQuery.KEYWORDS_PROVINCE);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, DistrictSearchQuery.KEYWORDS_CITY);
            jSONObject.put("timeDifference", random.nextInt(3600));
            jSONObject.put("age", BaseWrapper.ENTER_ID_18);
            jSONObject.put("tags", "tags");
            jSONObject.put("labels", "labels");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static ArrayList<PeopleNearbyVo> nearbyListFromJson(JSONArray jSONArray) {
        ArrayList<PeopleNearbyVo> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    if (jSONObject != null) {
                        arrayList.add(parseItem(jSONObject));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static PeopleNearbyVo parseItem(JSONObject jSONObject) {
        PeopleNearbyVo peopleNearbyVo = new PeopleNearbyVo();
        String strOptString = jSONObject.optString(DeviceInfoUtil.UID_TAG);
        String strOptString2 = jSONObject.optString(bd.h);
        if (!TextUtils.isEmpty(strOptString2) && !ContactInfoItem.isUidAvailable(strOptString)) {
            String strU = bo0.r().u(strOptString2);
            if (!TextUtils.isEmpty(strU)) {
                strOptString = strU;
            }
        }
        peopleNearbyVo.setUid(strOptString);
        peopleNearbyVo.setExid(strOptString2);
        peopleNearbyVo.setAccount(jSONObject.optString("account"));
        peopleNearbyVo.setDistance(jSONObject.optInt("distance"));
        peopleNearbyVo.setAddr(jSONObject.optString("addr"));
        peopleNearbyVo.setFriendType(jSONObject.optInt("isFriend"));
        peopleNearbyVo.setClientType(jSONObject.optString("clientType"));
        peopleNearbyVo.setNickName(jSONObject.optString("nickname"));
        peopleNearbyVo.setIconURL(jSONObject.optString("headIconUrl"));
        peopleNearbyVo.setBigIconURL(jSONObject.optString("headImgUrl"));
        peopleNearbyVo.setSignature(jSONObject.optString(com.umeng.ccg.a.A));
        peopleNearbyVo.setSex(jSONObject.optString("sex"));
        peopleNearbyVo.setCountry(jSONObject.optString("country"));
        peopleNearbyVo.setProvince(jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE));
        peopleNearbyVo.setCity(jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY));
        peopleNearbyVo.setTimeDifference(jSONObject.optInt("timeDifference"));
        peopleNearbyVo.setAge(jSONObject.optString("age"));
        peopleNearbyVo.setTags(jSONObject.optString("tags"));
        peopleNearbyVo.setMomentsFlag(jSONObject.optInt("momentsFlag", 0));
        peopleNearbyVo.setLabels(jSONObject.optString("labels"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extension");
        if (jSONObjectOptJSONObject != null) {
            peopleNearbyVo.setCarImageUrl(jSONObjectOptJSONObject.optString("carImageUrl"));
        }
        return peopleNearbyVo;
    }

    public String getAddr() {
        return this.addr;
    }

    public String getCarImageUrl() {
        return this.carImageUrl;
    }

    public String getClientType() {
        return this.clientType;
    }

    public String getDistanceHint() {
        return this.distanceHint;
    }

    public int getDistanceHintFlag() {
        return this.distanceHintFlag;
    }

    public int getFeedAdType() {
        return this.feedAdType;
    }

    public String getLabels() {
        return this.labels;
    }

    public int getMomentsFlag() {
        return this.momentsFlag;
    }

    public fg4 getPeopleNearbyAdVoNew() {
        return null;
    }

    public String getSex() {
        return this.sex;
    }

    public String getTags() {
        return this.tags;
    }

    public int getTimeDifference() {
        return this.timeDifference;
    }

    public boolean isRewardAd() {
        return this.isRewardAd;
    }

    public boolean isShowUnlockBtn() {
        return this.isShowUnlockBtn;
    }

    public boolean isUnlockAd() {
        return this.isUnlockAd;
    }

    public boolean isUnlockAdTip() {
        return this.isUnlockAdTip;
    }

    public void setAddr(String str) {
        this.addr = str;
    }

    public void setCarImageUrl(String str) {
        this.carImageUrl = str;
    }

    public void setClientType(String str) {
        this.clientType = str;
    }

    public void setDistanceHint(String str) {
        this.distanceHint = str;
    }

    public void setDistanceHintFlag(int i) {
        this.distanceHintFlag = i;
    }

    public void setFeedAdType(int i) {
        this.feedAdType = i;
    }

    public void setLabels(String str) {
        this.labels = str;
    }

    public void setMomentsFlag(int i) {
        this.momentsFlag = i;
    }

    public void setRewardAd(boolean z) {
        this.isRewardAd = z;
    }

    public void setSex(String str) {
        this.sex = str;
    }

    public void setShowUnlockBtn(boolean z) {
        this.isShowUnlockBtn = z;
    }

    public void setTags(String str) {
        this.tags = str;
    }

    public void setTimeDifference(int i) {
        this.timeDifference = i;
    }

    public void setUnlockAd(boolean z) {
        this.isUnlockAd = z;
    }

    public void setUnlockAdTip(boolean z) {
        this.isUnlockAdTip = z;
    }

    public void setPeopleNearbyAdVoNew(fg4 fg4Var) {
    }
}
