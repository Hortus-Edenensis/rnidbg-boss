package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.amap.api.services.district.DistrictSearchQuery;
import com.umeng.ccg.a;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class nn0 {
    public static ContentValues a(ContactInfoItem contactInfoItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact_operation", (Integer) 1);
        contentValues.put(DeviceInfoUtil.UID_TAG, contactInfoItem.getUid());
        contentValues.put("data4", contactInfoItem.getExid());
        contentValues.put("head_img_url", contactInfoItem.getIconURL());
        contentValues.put("big_head_img_url", contactInfoItem.getBigIconURL());
        contentValues.put("nick_name", contactInfoItem.getNickName());
        contentValues.put("first_pinyin", contactInfoItem.getFirstPinyin());
        contentValues.put("all_pinyin", contactInfoItem.getAllPinyin());
        contentValues.put("remark_name", contactInfoItem.getRemarkName());
        contentValues.put("remark_first_pinyin", contactInfoItem.getRemarkFirstPinyin());
        contentValues.put("remark_all_pinyin", contactInfoItem.getRemarkAllPinyin());
        contentValues.put("remark_tel", ContactInfoItem.getRemarkTelForDb(contactInfoItem.getRemarkTel()));
        contentValues.put("description", contactInfoItem.getDescription());
        contentValues.put(a.A, contactInfoItem.getSignature());
        contentValues.put("birthday", contactInfoItem.getBirthday());
        contentValues.put("hobby", contactInfoItem.getHobby());
        contentValues.put("age", contactInfoItem.getAge());
        if (!TextUtils.isEmpty(contactInfoItem.getMobile())) {
            contentValues.put("mobile", yh4.b(contactInfoItem.getMobile()));
        }
        contentValues.put(NotificationCompat.CATEGORY_EMAIL, contactInfoItem.getEmail());
        contentValues.put("gender", Integer.valueOf(contactInfoItem.getGender()));
        contentValues.put("country", contactInfoItem.getCountry());
        contentValues.put(DistrictSearchQuery.KEYWORDS_PROVINCE, contactInfoItem.getProvince());
        contentValues.put(DistrictSearchQuery.KEYWORDS_CITY, contactInfoItem.getCity());
        contentValues.put("act", contactInfoItem.getAccount());
        contentValues.put("data2", (Integer) 1);
        contentValues.put("account_type", Integer.valueOf(contactInfoItem.getAccountType()));
        contentValues.put("data5", contactInfoItem.getExt() == null ? "" : az2.c(contactInfoItem.getExt()));
        return contentValues;
    }

    public static ContentValues b(ContactInfoItem contactInfoItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data3", contactInfoItem.getAlbumInfo());
        return contentValues;
    }

    public static ContentValues c(ContactInfoItem contactInfoItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact_operation", (Integer) 1);
        contentValues.put(DeviceInfoUtil.UID_TAG, contactInfoItem.getUid());
        contentValues.put("data4", contactInfoItem.getExid());
        contentValues.put("head_img_url", contactInfoItem.getIconURL());
        contentValues.put("big_head_img_url", contactInfoItem.getBigIconURL());
        contentValues.put("nick_name", contactInfoItem.getNickName());
        contentValues.put("remark_name", contactInfoItem.getRemarkName());
        contentValues.put(a.A, contactInfoItem.getSignature());
        contentValues.put("birthday", contactInfoItem.getBirthday());
        contentValues.put("hobby", contactInfoItem.getHobby());
        contentValues.put("age", contactInfoItem.getAge());
        if (!TextUtils.isEmpty(contactInfoItem.getMobile())) {
            contentValues.put("mobile", yh4.b(contactInfoItem.getMobile()));
        }
        contentValues.put(NotificationCompat.CATEGORY_EMAIL, contactInfoItem.getEmail());
        contentValues.put("gender", Integer.valueOf(contactInfoItem.getGender()));
        contentValues.put("country", contactInfoItem.getCountry());
        contentValues.put(DistrictSearchQuery.KEYWORDS_PROVINCE, contactInfoItem.getProvince());
        contentValues.put(DistrictSearchQuery.KEYWORDS_CITY, contactInfoItem.getCity());
        contentValues.put("act", contactInfoItem.getAccount());
        contentValues.put("data2", (Integer) 1);
        contentValues.put("account_type", Integer.valueOf(contactInfoItem.getAccountType()));
        contentValues.put("data3", contactInfoItem.getAlbumInfo());
        contentValues.put("all_pinyin", contactInfoItem.getAllPinyin());
        contentValues.put("remark_name", contactInfoItem.getRemarkName());
        contentValues.put("remark_first_pinyin", contactInfoItem.getRemarkFirstPinyin());
        contentValues.put("remark_all_pinyin", contactInfoItem.getRemarkAllPinyin());
        contentValues.put("remark_tel", ContactInfoItem.getRemarkTelForDb(contactInfoItem.getRemarkTel()));
        contentValues.put("description", contactInfoItem.getDescription());
        contentValues.put("data5", contactInfoItem.getExt() == null ? "" : az2.c(contactInfoItem.getExt()));
        return contentValues;
    }

    public static ContactInfoItem d(JSONObject jSONObject) {
        return co0.a(jSONObject);
    }

    public static ContactInfoItem e(String str) {
        ContactInfoItem contactInfoItem = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContactInfoItem contactInfoItem2 = new ContactInfoItem();
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("userInfo");
                if (jSONObjectOptJSONObject != null) {
                    contactInfoItem2.setUid(jSONObjectOptJSONObject.getString(DeviceInfoUtil.UID_TAG));
                    contactInfoItem2.setAccount(jSONObjectOptJSONObject.optString("account"));
                    contactInfoItem2.setNickName(jSONObjectOptJSONObject.optString("nickname"));
                    contactInfoItem2.setIconURL(jSONObjectOptJSONObject.optString("headIconUrl"));
                    contactInfoItem2.setBigIconURL(jSONObjectOptJSONObject.optString("headImgUrl"));
                    contactInfoItem2.setCountry(jSONObjectOptJSONObject.optString("country"));
                    contactInfoItem2.setProvince(jSONObjectOptJSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE));
                    contactInfoItem2.setCity(jSONObjectOptJSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY));
                    contactInfoItem2.setGender(jSONObjectOptJSONObject.optInt("sex"));
                }
                return contactInfoItem2;
            } catch (JSONException e) {
                e = e;
                contactInfoItem = contactInfoItem2;
                e.printStackTrace();
                return contactInfoItem;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public static String f(ContactInfoItem contactInfoItem) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(DeviceInfoUtil.UID_TAG, contactInfoItem.getUid());
            jSONObject2.put("account", contactInfoItem.getAccount());
            jSONObject2.put("nickname", contactInfoItem.getNickName());
            jSONObject2.put("headIconUrl", contactInfoItem.getIconURL());
            jSONObject2.put("headImgUrl", contactInfoItem.getBigIconURL());
            jSONObject2.put("sex", contactInfoItem.getGender());
            jSONObject2.put("country", contactInfoItem.getCountry());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, contactInfoItem.getProvince());
            jSONObject2.put(DistrictSearchQuery.KEYWORDS_CITY, contactInfoItem.getCity());
            jSONObject.put("userInfo", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String g(GroupInfoItem groupInfoItem) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", groupInfoItem.getGroupId());
            jSONObject2.put("name", groupInfoItem.getGroupName());
            jSONObject2.put("headImgUrl", groupInfoItem.getGroupHeadImgUrl());
            jSONObject2.put("roomType", groupInfoItem.getRoomType());
            jSONObject2.put("memberCount", groupInfoItem.getMemberCount());
            jSONObject2.put("describe", groupInfoItem.getDescribe());
            jSONObject2.put("defaultName", groupInfoItem.getGroupLocalName());
            jSONObject2.put("owner", groupInfoItem.getGroupOwner());
            jSONObject2.put("createTimestamp", groupInfoItem.getCreateTimestamp());
            jSONObject2.put("place", groupInfoItem.getPlace());
            jSONObject2.put("cover", groupInfoItem.getCover());
            jSONObject.put("roomInfo", jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jSONObject.put("userInfo", new JSONObject());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
