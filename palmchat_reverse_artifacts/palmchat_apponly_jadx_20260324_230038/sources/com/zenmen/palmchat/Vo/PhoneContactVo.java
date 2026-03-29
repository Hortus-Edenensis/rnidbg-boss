package com.zenmen.palmchat.Vo;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.bd;
import com.umeng.ccg.a;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.bo0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PhoneContactVo extends ContactInfoItem {
    public static final int SORT_BASE_ADDED = 200;
    public static final int SORT_BASE_NOT_ADD = 100;
    public static final String key_local_allPinyin = "allPinyin";
    public static final String key_local_firstPinyin = "firstPinyin";
    private long activeTime;
    private String encryptPhone;
    private boolean isClicked;
    private int isFriend;
    private String localId;
    private String localName;
    private String localNameAllPinyin;
    private String localNameFirstPinyin;
    private String localPhone;
    private String md5Phone;
    private long readStatus;
    private String realName;
    private String recommendText;
    private int userType;
    private boolean isSelected = true;
    int sortId = -1;

    public static ArrayList<PhoneContactVo> buildListFromJson(JSONArray jSONArray) {
        ArrayList<PhoneContactVo> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    if (jSONObject != null) {
                        PhoneContactVo phoneContactVo = new PhoneContactVo();
                        phoneContactVo.setUid(jSONObject.optString(DeviceInfoUtil.UID_TAG));
                        phoneContactVo.setExid(jSONObject.optString(bd.h));
                        phoneContactVo.setMd5Phone(jSONObject.optString("md5Phone"));
                        phoneContactVo.setIsFriend(jSONObject.optInt("isFriend"));
                        phoneContactVo.setNickName(jSONObject.optString("nickname"));
                        phoneContactVo.setIconURL(jSONObject.optString("headIconUrl"));
                        phoneContactVo.setBigIconURL(jSONObject.optString("headImgUrl"));
                        phoneContactVo.setSignature(jSONObject.optString(a.A));
                        phoneContactVo.setGender(jSONObject.optInt("sex"));
                        phoneContactVo.setCountry(jSONObject.optString("country"));
                        phoneContactVo.setProvince(jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE));
                        phoneContactVo.setCity(jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY));
                        phoneContactVo.setEmail(jSONObject.optString(NotificationCompat.CATEGORY_EMAIL));
                        phoneContactVo.setSourceType(3);
                        phoneContactVo.setFirstPinyin(jSONObject.optString("pyInitial"));
                        phoneContactVo.setAllPinyin(jSONObject.optString("pyQuanPin"));
                        phoneContactVo.setLocalNameAllPinyin(jSONObject.optString(key_local_allPinyin));
                        phoneContactVo.setLocalNameFirstPinyin(jSONObject.optString(key_local_firstPinyin));
                        phoneContactVo.setLocalName(jSONObject.optString("localName"));
                        phoneContactVo.setLocalPhone(jSONObject.optString("localPhone"));
                        phoneContactVo.setLocalId(jSONObject.optString("localId"));
                        phoneContactVo.setRecommendText(jSONObject.optString("recommendText"));
                        phoneContactVo.setApplyFriendTime(jSONObject.optLong("applyFriendTime"));
                        phoneContactVo.setSendTime(jSONObject.optLong(RemoteMessageConst.SEND_TIME));
                        phoneContactVo.setCycleShowTime(jSONObject.optLong("cycleTime"));
                        phoneContactVo.setSourceType(jSONObject.optInt("sourceType"));
                        phoneContactVo.setRealName(jSONObject.optString("realName"));
                        arrayList.add(phoneContactVo);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static String genJsonStringFromList(ArrayList<PhoneContactVo> arrayList) {
        if (arrayList == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (PhoneContactVo phoneContactVo : arrayList) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(DeviceInfoUtil.UID_TAG, phoneContactVo.getUid());
                jSONObject.put(bd.h, phoneContactVo.getExid());
                jSONObject.put("md5Phone", phoneContactVo.getMd5Phone());
                jSONObject.put("isFriend", phoneContactVo.getIsFriend());
                jSONObject.put("nickname", phoneContactVo.getNickName());
                jSONObject.put("headIconUrl", phoneContactVo.getIconURL());
                jSONObject.put("headImgUrl", phoneContactVo.getBigIconURL());
                jSONObject.put(a.A, phoneContactVo.getSignature());
                jSONObject.put("sex", phoneContactVo.getGender());
                jSONObject.put("country", phoneContactVo.getCountry());
                jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, phoneContactVo.getProvince());
                jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, phoneContactVo.getCity());
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, phoneContactVo.getEmail());
                jSONObject.put(key_local_firstPinyin, phoneContactVo.getLocalNameFirstPinyin());
                jSONObject.put(key_local_allPinyin, phoneContactVo.getLocalNameAllPinyin());
                jSONObject.put("pyInitial", phoneContactVo.getFirstPinyin());
                jSONObject.put("pyQuanPin", phoneContactVo.getAllPinyin());
                jSONObject.put("localName", phoneContactVo.getLocalName());
                jSONObject.put("localPhone", phoneContactVo.getLocalPhone());
                jSONObject.put("localId", phoneContactVo.getLocalId());
                jSONObject.put("recommendText", phoneContactVo.getRecommendText());
                jSONObject.put("applyFriendTime", phoneContactVo.getApplyFriendTime());
                jSONObject.put(RemoteMessageConst.SEND_TIME, phoneContactVo.getSendTime());
                jSONObject.put("cycleTime", phoneContactVo.getCycleShowTime());
                jSONObject.put("sourceType", phoneContactVo.getSourceType());
                jSONObject.put("realName", phoneContactVo.getRealName());
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    private int getSourceTypeIndex() {
        int sourceType = getSourceType();
        if (sourceType == 3 || sourceType == -1) {
            return 1;
        }
        if (sourceType == 20) {
            return 2;
        }
        return sourceType == 22 ? 3 : 4;
    }

    public int generateSortId() {
        if (bo0.r().w(getUid())) {
            this.sortId = getSourceTypeIndex() + 200;
        } else {
            this.sortId = getSourceTypeIndex() + 100;
        }
        return this.sortId;
    }

    public long getActiveTime() {
        return this.activeTime;
    }

    public String getEncryptPhone() {
        return this.encryptPhone;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public String getLocalId() {
        return this.localId;
    }

    public String getLocalName() {
        return this.localName;
    }

    public String getLocalNameAllPinyin() {
        return this.localNameAllPinyin;
    }

    public String getLocalNameFirstPinyin() {
        return this.localNameFirstPinyin;
    }

    public String getLocalOrRealName() {
        return (TextUtils.isEmpty(this.localName) || TextUtils.isEmpty(this.localName.trim())) ? !TextUtils.isEmpty(this.realName) ? this.realName : "" : this.localName.trim();
    }

    public String getLocalPhone() {
        return this.localPhone;
    }

    public String getMd5Phone() {
        return this.md5Phone;
    }

    public long getReadStatus() {
        return this.readStatus;
    }

    public String getRealName() {
        return this.realName;
    }

    public String getRecommendText() {
        return this.recommendText;
    }

    public int getSortId() {
        return this.sortId;
    }

    public int getUserType() {
        return this.userType;
    }

    public boolean isClicked() {
        return this.isClicked;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setActiveTime(long j) {
        this.activeTime = j;
    }

    public void setEncryptPhone(String str) {
        this.encryptPhone = str;
    }

    public void setIsClicked(boolean z) {
        this.isClicked = z;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public void setLocalId(String str) {
        this.localId = str;
    }

    public void setLocalName(String str) {
        this.localName = str;
    }

    public void setLocalNameAllPinyin(String str) {
        this.localNameAllPinyin = str;
    }

    public void setLocalNameFirstPinyin(String str) {
        if (str == null) {
            this.localNameFirstPinyin = "";
        } else {
            this.localNameFirstPinyin = str;
        }
    }

    public void setLocalPhone(String str) {
        this.localPhone = str;
    }

    public void setMd5Phone(String str) {
        this.md5Phone = str;
    }

    public void setReadStatus(long j) {
        this.readStatus = j;
    }

    public void setRealName(String str) {
        this.realName = str;
    }

    public void setRecommendText(String str) {
        this.recommendText = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setSortId(int i) {
        this.sortId = i;
    }

    public void setUserType(int i) {
        this.userType = i;
    }
}
