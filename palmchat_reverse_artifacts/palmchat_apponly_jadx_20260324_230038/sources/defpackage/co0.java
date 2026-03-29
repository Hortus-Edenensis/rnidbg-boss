package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.amap.api.services.district.DistrictSearchQuery;
import com.baidu.location.LocationConst;
import com.google.gson.reflect.TypeToken;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.ContactAlbumBean;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import com.zenmen.palmchat.contacts.bean.ContactLoveBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.NearByBean;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class co0 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<List<ContactLoveBean>> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends TypeToken<List<String>> {
    }

    public static ContactInfoItem a(JSONObject jSONObject) {
        LogUtil.d("contact json", jSONObject.toString());
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        try {
            contactInfoItem.setUid(jSONObject.getString(DeviceInfoUtil.UID_TAG));
            contactInfoItem.setExid(jSONObject.optString(bd.h));
            contactInfoItem.setNickName(jSONObject.optString("nickname"));
            contactInfoItem.setRemarkName(jSONObject.optString("remarkName"));
            contactInfoItem.setIconURL(jSONObject.optString("headIconUrl"));
            contactInfoItem.setBigIconURL(jSONObject.optString("headImgUrl"));
            contactInfoItem.setSignature(jSONObject.optString(com.umeng.ccg.a.A));
            contactInfoItem.setBirthday(jSONObject.optString("birthday"));
            contactInfoItem.setHobby(jSONObject.optString("hobby"));
            contactInfoItem.setAge(jSONObject.optString("age"));
            contactInfoItem.setGender(jSONObject.optInt("sex", -1));
            contactInfoItem.setSourceType(jSONObject.optInt("sourceType", -1));
            contactInfoItem.setCountry(jSONObject.optString("country"));
            contactInfoItem.setProvince(jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE));
            contactInfoItem.setCity(jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY));
            contactInfoItem.setEmail(jSONObject.optString(NotificationCompat.CATEGORY_EMAIL));
            contactInfoItem.setMobile(jSONObject.optString("phone"));
            String strOptString = jSONObject.optString("ext");
            try {
                JSONObject jSONObject2 = TextUtils.isEmpty(strOptString) ? new JSONObject() : new JSONObject(strOptString);
                jSONObject2.put("initedTime", jSONObject.optLong("initedTime"));
                contactInfoItem.setExt((ContactExtBean) az2.a(jSONObject2.toString(), ContactExtBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String strOptString2 = jSONObject.optString(FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM);
            try {
                contactInfoItem.setAlbum((ContactAlbumBean) az2.a((TextUtils.isEmpty(strOptString2) ? new JSONObject() : new JSONObject(strOptString2)).toString(), ContactAlbumBean.class));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            contactInfoItem.setLoveView((List) az2.b(jSONObject.optString("loveView"), new a().getType()));
            contactInfoItem.setSessionConfig(jSONObject.optInt("sessionConfig"));
            contactInfoItem.setFirstPinyin(jSONObject.optString("pyInitial"));
            contactInfoItem.setAllPinyin(jSONObject.optString("pyQuanPin"));
            contactInfoItem.setRemarkFirstPinyin(jSONObject.optString("remarkPYInitial"));
            contactInfoItem.setRemarkAllPinyin(jSONObject.optString("remarkPYQuanPin"));
            contactInfoItem.setAccount(jSONObject.optString("account"));
            int iOptInt = jSONObject.optInt("riskLevel");
            if ("1".equals(jSONObject.optString(LocationConst.HDYawConst.KEY_HD_YAW_STATE))) {
                contactInfoItem.setAccountType(-1);
            } else if (iOptInt == 30) {
                contactInfoItem.setAccountType(-2);
            } else if (iOptInt == 40) {
                contactInfoItem.setAccountType(-3);
            } else if (iOptInt == 50) {
                contactInfoItem.setAccountType(-4);
            } else {
                contactInfoItem.setAccountType(0);
            }
            String strOptString3 = jSONObject.optString("remarkTel");
            if (TextUtils.isEmpty(strOptString3)) {
                contactInfoItem.setRemarkTel(null);
            } else {
                contactInfoItem.setRemarkTel(strOptString3.split("\\$"));
            }
            contactInfoItem.setDescription(jSONObject.optString("description"));
            contactInfoItem.setOnline(jSONObject.optLong("onlineStatusCode") == 1);
            contactInfoItem.setDistance(jSONObject.optLong("distance"));
            contactInfoItem.setCityName(jSONObject.optString("cityName"));
            contactInfoItem.setOnlineStatusDesc(jSONObject.optString("onlineStatusDesc"));
            contactInfoItem.setCharmLevel(jSONObject.optInt("charmLevel"));
            contactInfoItem.setRichLevel(jSONObject.optInt("richLevel"));
            contactInfoItem.setLikeCount(jSONObject.optString("likeCount"));
            contactInfoItem.setFid(jSONObject.optString("fid"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("userLabelImg");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                contactInfoItem.setUserLabelImg((List) az2.b(jSONArrayOptJSONArray.toString(), new b().getType()));
            }
            if (jSONObject.optBoolean("existDoppelganger")) {
                contactInfoItem.setFeedSeparation(NearByBean.TAG_TYPE_FEED_SEPARATION);
            }
            return contactInfoItem;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static ContentValues b(boolean z, JSONObject jSONObject, int i) {
        LogUtil.d("contact json", jSONObject.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact_operation", Integer.valueOf(i));
        try {
            contentValues.put(DeviceInfoUtil.UID_TAG, jSONObject.getString(DeviceInfoUtil.UID_TAG));
            contentValues.put("data4", jSONObject.optString(bd.h));
            if (i == 1) {
                String strOptString = jSONObject.optString("nickname");
                if (!TextUtils.isEmpty(strOptString)) {
                    contentValues.put("nick_name", strOptString);
                }
                contentValues.put("remark_name", jSONObject.optString("remarkName"));
                String strOptString2 = jSONObject.optString("pyInitial");
                if (!TextUtils.isEmpty(strOptString2)) {
                    contentValues.put("first_pinyin", strOptString2);
                }
                String strOptString3 = jSONObject.optString("pyQuanPin");
                if (!TextUtils.isEmpty(strOptString3)) {
                    contentValues.put("all_pinyin", strOptString3);
                }
                contentValues.put("remark_first_pinyin", jSONObject.optString("remarkPYInitial"));
                contentValues.put("remark_all_pinyin", jSONObject.optString("remarkPYQuanPin"));
                String strOptString4 = jSONObject.optString("headIconUrl");
                if (!TextUtils.isEmpty(strOptString4)) {
                    contentValues.put("head_img_url", strOptString4);
                }
                String strOptString5 = jSONObject.optString("headImgUrl");
                if (!TextUtils.isEmpty(strOptString5)) {
                    contentValues.put("big_head_img_url", strOptString5);
                }
                contentValues.put(com.umeng.ccg.a.A, jSONObject.optString(com.umeng.ccg.a.A));
                contentValues.put("birthday", jSONObject.optString("birthday"));
                contentValues.put("hobby", jSONObject.optString("hobby"));
                contentValues.put("age", jSONObject.optString("age"));
                contentValues.put("gender", String.valueOf(jSONObject.optInt("sex", -1)));
                String strOptString6 = jSONObject.optString("country");
                String strOptString7 = jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE);
                String strOptString8 = jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY);
                if (TextUtils.isEmpty(strOptString6)) {
                    strOptString6 = "";
                }
                contentValues.put("country", strOptString6);
                if (TextUtils.isEmpty(strOptString7)) {
                    strOptString7 = "";
                }
                contentValues.put(DistrictSearchQuery.KEYWORDS_PROVINCE, strOptString7);
                if (TextUtils.isEmpty(strOptString8)) {
                    strOptString8 = "";
                }
                contentValues.put(DistrictSearchQuery.KEYWORDS_CITY, strOptString8);
                contentValues.put("source_type", Integer.valueOf(jSONObject.optInt("sourceType", -1)));
                String strOptString9 = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
                if (!TextUtils.isEmpty(strOptString9)) {
                    contentValues.put(NotificationCompat.CATEGORY_EMAIL, strOptString9);
                }
                String strOptString10 = jSONObject.optString("phone");
                if (!TextUtils.isEmpty(strOptString10)) {
                    contentValues.put("mobile", yh4.b(strOptString10));
                }
                if (!z) {
                    contentValues.put("chat_config", Integer.valueOf(jSONObject.optInt("sessionConfig", 0)));
                }
                contentValues.put("act", jSONObject.optString("account"));
                contentValues.put("remark_tel", jSONObject.optString("remarkTel"));
                contentValues.put("description", jSONObject.optString("description"));
                contentValues.put("data2", Integer.valueOf(jSONObject.optInt("friendType", 0)));
                String strOptString11 = jSONObject.optString("ext");
                try {
                    JSONObject jSONObject2 = TextUtils.isEmpty(strOptString11) ? new JSONObject() : new JSONObject(strOptString11);
                    jSONObject2.put("initedTime", jSONObject.optLong("initedTime"));
                    contentValues.put("data5", jSONObject2.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            contentValues.put("resource_type", jSONObject.getString("syncKey"));
            contentValues.put("resource_version", Long.valueOf(jSONObject.getLong("version")));
            String strOptString12 = jSONObject.optString(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
            int iOptInt = jSONObject.optInt("riskLevel");
            if ("1".equals(strOptString12)) {
                contentValues.put("account_type", (Integer) (-1));
            } else if (iOptInt == 30) {
                contentValues.put("account_type", (Integer) (-2));
            } else if (iOptInt == 40) {
                contentValues.put("account_type", (Integer) (-3));
            } else if (iOptInt == 50) {
                contentValues.put("account_type", (Integer) (-4));
            } else {
                contentValues.put("account_type", (Integer) 0);
            }
            return contentValues;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ContentValues c(JSONObject jSONObject) {
        LogUtil.d("contact json", jSONObject.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact_operation", (Integer) 1);
        try {
            contentValues.put(DeviceInfoUtil.UID_TAG, jSONObject.getString(DeviceInfoUtil.UID_TAG));
            contentValues.put("data4", jSONObject.optString(bd.h));
            String strOptString = jSONObject.optString("name");
            if (!TextUtils.isEmpty(strOptString)) {
                contentValues.put("nick_name", strOptString);
            }
            String strOptString2 = jSONObject.optString("pyInitial");
            if (TextUtils.isEmpty(strOptString2)) {
                strOptString2 = li4.a(strOptString);
            }
            contentValues.put("first_pinyin", strOptString2);
            String strOptString3 = jSONObject.optString("pyQuanPin");
            if (TextUtils.isEmpty(strOptString3)) {
                strOptString3 = li4.b(strOptString);
            }
            contentValues.put("all_pinyin", strOptString3);
            jSONObject.optInt(com.igexin.push.core.b.Y, -1);
            int iOptInt = jSONObject.optInt("customConfig", -1);
            if (iOptInt != -1) {
                contentValues.put("chat_config", Integer.valueOf(iOptInt));
            }
            String strOptString4 = jSONObject.optString("zxid");
            if (!TextUtils.isEmpty(strOptString4)) {
                contentValues.put("act", strOptString4);
            }
            String strOptString5 = jSONObject.optString("headImg");
            if (!TextUtils.isEmpty(strOptString5)) {
                contentValues.put("head_img_url", strOptString5);
            }
            contentValues.put("description", jSONObject.optString("owner"));
            contentValues.put("data5", jSONObject.optString("ext"));
            contentValues.put("data2", (Integer) 0);
            contentValues.put("account_type", (Integer) 1);
            return contentValues;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ContentValues d(JSONObject jSONObject) {
        LogUtil.d("contact json", jSONObject.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact_operation", (Integer) 1);
        try {
            contentValues.put(DeviceInfoUtil.UID_TAG, jSONObject.getString(DeviceInfoUtil.UID_TAG));
            contentValues.put("data4", jSONObject.optString(bd.h));
            String strOptString = jSONObject.optString("name");
            if (!TextUtils.isEmpty(strOptString)) {
                contentValues.put("nick_name", strOptString);
            }
            String strOptString2 = jSONObject.optString("pyInitial");
            if (TextUtils.isEmpty(strOptString2)) {
                strOptString2 = li4.a(strOptString);
            }
            contentValues.put("first_pinyin", strOptString2);
            String strOptString3 = jSONObject.optString("pyQuanPin");
            if (TextUtils.isEmpty(strOptString3)) {
                strOptString3 = li4.b(strOptString);
            }
            contentValues.put("all_pinyin", strOptString3);
            int iOptInt = jSONObject.optInt(com.igexin.push.core.b.Y, -1);
            if (iOptInt != -1) {
                contentValues.put("chat_config", Integer.valueOf(iOptInt));
            }
            String strOptString4 = jSONObject.optString("zxid");
            if (!TextUtils.isEmpty(strOptString4)) {
                contentValues.put("act", strOptString4);
            }
            String strOptString5 = jSONObject.optString("headImg");
            if (!TextUtils.isEmpty(strOptString5)) {
                contentValues.put("head_img_url", strOptString5);
            }
            contentValues.put("description", jSONObject.optString("owner"));
            contentValues.put("data5", jSONObject.optString("ext"));
            contentValues.put("data2", (Integer) 0);
            contentValues.put("account_type", (Integer) 1);
            return contentValues;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void e(String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("data5", str2);
        contentValues.put("account_type", Integer.valueOf(i));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, ho0.f18003a, contentValues, "uid = ? ", new String[]{str});
    }
}
