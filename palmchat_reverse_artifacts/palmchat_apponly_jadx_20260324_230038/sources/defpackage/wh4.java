package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.bd;
import com.umeng.ccg.a;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.d;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wh4 {
    public static void a(JSONArray jSONArray, boolean z, ArrayList<ContactRequestsVO> arrayList, HashMap<String, PhoneContactVo> map) {
        HashMap map2;
        HashMap map3;
        JSONObject jSONObject;
        String strOptString;
        PhoneContactVo phoneContactVo;
        HashMap map4 = new HashMap();
        HashMap map5 = new HashMap();
        for (ContactRequestsVO contactRequestsVO : arrayList) {
            if (contactRequestsVO.requestType == 101) {
                map4.put(contactRequestsVO.fromUid, contactRequestsVO);
            } else {
                map5.put(contactRequestsVO.fromUid, contactRequestsVO);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            ContentValues contentValues = new ContentValues();
            try {
                jSONObject = jSONArray.getJSONObject(i);
                strOptString = jSONObject.optString(DeviceInfoUtil.UID_TAG);
                try {
                    phoneContactVo = map.get(jSONObject.optString("md5Phone"));
                } catch (JSONException e) {
                    e = e;
                    map2 = map4;
                    map3 = map5;
                    e.printStackTrace();
                    arrayList2.add(contentValues);
                    i++;
                    map4 = map2;
                    map5 = map3;
                }
            } catch (JSONException e2) {
                e = e2;
            }
            if (phoneContactVo == null) {
                map2 = map4;
                map3 = map5;
                i++;
                map4 = map2;
                map5 = map3;
            } else {
                ContactRequestsVO contactRequestsVO2 = (ContactRequestsVO) map5.get(strOptString);
                ContactRequestsVO contactRequestsVO3 = (ContactRequestsVO) map4.get(strOptString);
                if (contactRequestsVO2 != null) {
                    map2 = map4;
                    try {
                        if (TextUtils.isEmpty(contactRequestsVO2.realName)) {
                            map3 = map5;
                            try {
                                jSONObject.put("nickName", contactRequestsVO2.realName);
                            } catch (JSONException e3) {
                                e = e3;
                                e.printStackTrace();
                            }
                        } else {
                            map3 = map5;
                        }
                        contentValues.put("send_time", contactRequestsVO2.sendTime);
                        contentValues.put("read_status", Long.valueOf(contactRequestsVO2.readStatus));
                    } catch (JSONException e4) {
                        e = e4;
                        map3 = map5;
                        e.printStackTrace();
                        arrayList2.add(contentValues);
                        i++;
                        map4 = map2;
                        map5 = map3;
                    }
                } else {
                    map2 = map4;
                    map3 = map5;
                    if (contactRequestsVO3 != null) {
                        contentValues.put("read_status", Long.valueOf(contactRequestsVO3.readStatus));
                        contentValues.put("send_time", contactRequestsVO3.sendTime);
                        contentValues.put("applyFriendTime", contactRequestsVO3.applyFriendTime);
                        contentValues.put("disShowTime", Long.valueOf(contactRequestsVO3.disShowTime));
                    } else {
                        contentValues.put("read_status", Long.valueOf(z ? 1L : 0L));
                        contentValues.put("send_time", Long.valueOf(ir5.b()));
                    }
                }
                if (contactRequestsVO3 != null) {
                    contentValues.put("deleteTime", contactRequestsVO3.deleteTime);
                    contentValues.put("accept_status", Long.valueOf(contactRequestsVO3.acceptStatus));
                } else {
                    contentValues.put("accept_status", (Long) 0L);
                }
                contentValues.put("from_uid", strOptString);
                contentValues.put("from_nick_name", jSONObject.optString("nickname"));
                contentValues.put("from_head_img_url", jSONObject.optString("headImgUrl"));
                contentValues.put("from_signature", jSONObject.optString(a.A));
                contentValues.put("request_info", jSONObject.optString("recommendText"));
                jSONObject.put("localPhone", yh4.b(phoneContactVo.getLocalPhone()));
                jSONObject.put("localName", phoneContactVo.getLocalName());
                jSONObject.put("userType", jSONObject.optInt("userType"));
                jSONObject.put("activeTime", jSONObject.optLong("activeTime"));
                contentValues.put("user_info", jSONObject.toString());
                contentValues.put("request_type", (Integer) 101);
                arrayList2.add(contentValues);
                i++;
                map4 = map2;
                map5 = map3;
            }
        }
        int size = arrayList2.size();
        ContentValues[] contentValuesArr = new ContentValues[size];
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            contentValuesArr[i2] = (ContentValues) arrayList2.get(i2);
        }
        String[] strArr = {String.valueOf(101)};
        ContentResolver contentResolver = AppContext.getContext().getContentResolver();
        Uri uri = vn0.f21483a;
        contentResolver.delete(uri, "request_type = ?", strArr);
        if (size > 0) {
            dv.a("insertPhoneContact", uri, contentValuesArr, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0250  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<xh4> b(Cursor cursor) {
        String str;
        ArrayList<xh4> arrayList;
        ArrayList<xh4> arrayList2 = new ArrayList<>();
        HashMap map = new HashMap();
        HashMap<String, PhoneContactItem> mapM = d.j().m();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String string = cursor.getString(cursor.getColumnIndex("from_uid"));
                int i = cursor.getInt(cursor.getColumnIndex("request_type"));
                if (i >= 100) {
                    str = string + 100;
                } else {
                    str = string;
                }
                if (!map.containsKey(str)) {
                    ContactInfoItem contactInfoItem = new ContactInfoItem();
                    ContactRequestsVO contactRequestsVO = new ContactRequestsVO();
                    contactRequestsVO.fromUid = cursor.getString(cursor.getColumnIndex("from_uid"));
                    contactRequestsVO.mid = cursor.getString(cursor.getColumnIndex("mid"));
                    contactRequestsVO.fromNickName = cursor.getString(cursor.getColumnIndex("from_nick_name"));
                    contactRequestsVO.fromSignature = cursor.getString(cursor.getColumnIndex("from_signature"));
                    contactRequestsVO.fromHeadIcon = cursor.getString(cursor.getColumnIndex("from_head_img_url"));
                    contactRequestsVO.requestInfo = cursor.getString(cursor.getColumnIndex("request_info"));
                    contactRequestsVO.requestRid = cursor.getString(cursor.getColumnIndex("rid"));
                    String str2 = str;
                    contactRequestsVO.readStatus = cursor.getLong(cursor.getColumnIndex("read_status"));
                    contactRequestsVO.acceptStatus = cursor.getLong(cursor.getColumnIndex("accept_status"));
                    contactRequestsVO.type = cursor.getInt(cursor.getColumnIndex("request_type"));
                    contactRequestsVO.userInfo = cursor.getString(cursor.getColumnIndex("user_info"));
                    String string2 = cursor.getString(cursor.getColumnIndex("identify_code"));
                    if (TextUtils.isEmpty(contactRequestsVO.userInfo)) {
                        arrayList = arrayList2;
                    } else {
                        try {
                            arrayList = arrayList2;
                        } catch (Exception e) {
                            e = e;
                            arrayList = arrayList2;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(contactRequestsVO.userInfo);
                            contactRequestsVO.realName = jSONObject.optString("realName");
                            if (TextUtils.isEmpty(string2)) {
                                String strOptString = jSONObject.optString("md5Phone");
                                String strOptString2 = jSONObject.optString("phone");
                                if (!TextUtils.isEmpty(strOptString)) {
                                    string2 = strOptString;
                                } else if (!TextUtils.isEmpty(strOptString2)) {
                                    string2 = hs0.g().d(strOptString2);
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                    contactRequestsVO.identifyCode = string2;
                    contactRequestsVO.sourceType = cursor.getInt(cursor.getColumnIndex("source_type"));
                    contactRequestsVO.requestType = cursor.getInt(cursor.getColumnIndex("request_type"));
                    contactRequestsVO.sendTime = cursor.getString(cursor.getColumnIndex("send_time"));
                    contactRequestsVO.applyFriendTime = cursor.getString(cursor.getColumnIndex("applyFriendTime"));
                    contactRequestsVO.expireTime = cursor.getString(cursor.getColumnIndex("expireTime"));
                    contactRequestsVO.operateTime = cursor.getString(cursor.getColumnIndex("operateTime"));
                    contactRequestsVO.deleteTime = cursor.getString(cursor.getColumnIndex("deleteTime"));
                    contactRequestsVO.recommendTitle = cursor.getString(cursor.getColumnIndex("recommendTitle"));
                    contactRequestsVO.recommendText = cursor.getString(cursor.getColumnIndex("recommendText"));
                    contactInfoItem.setUid(cursor.getString(cursor.getColumnIndex("from_uid")));
                    contactInfoItem.setNickName(cursor.getString(cursor.getColumnIndex("from_nick_name")));
                    contactInfoItem.setIconURL(cursor.getString(cursor.getColumnIndex("from_head_img_url")));
                    contactInfoItem.setSourceType(cursor.getInt(cursor.getColumnIndex("source_type")));
                    contactInfoItem.setRequestType(i);
                    contactInfoItem.setIdentifyCode(string2);
                    if (i < 100) {
                        String string3 = cursor.getString(cursor.getColumnIndex("request_info"));
                        if (TextUtils.isEmpty(string3)) {
                            int i2 = contactRequestsVO.sourceType;
                            if (i2 == 2) {
                                string3 = AppContext.getContext().getResources().getString(R.string.notification_add_contact_request_group);
                            } else if (i2 == 3) {
                                string3 = AppContext.getContext().getResources().getString(R.string.notification_add_contact_request_contact);
                            } else if (i2 == 7) {
                                string3 = AppContext.getContext().getResources().getString(R.string.notification_add_contact_request_auto);
                            } else if (i2 == 14) {
                                string3 = AppContext.getContext().getResources().getString(R.string.notification_greeting_content);
                            } else if (i2 != 20) {
                                if (i2 != 28 && i2 != 34) {
                                    if (i2 != 17) {
                                        string3 = i2 != 18 ? AppContext.getContext().getResources().getString(R.string.notification_add_contact_request_content_new) : AppContext.getContext().getResources().getString(R.string.notification_add_contact_request_accurate);
                                    }
                                }
                            }
                        }
                        contactInfoItem.setDescription(string3);
                    } else if (i < 200 || i == 221) {
                        contactInfoItem.setDescription(AppContext.getContext().getString(R.string.contact_zx_nick_name, contactRequestsVO.fromNickName));
                        if (!TextUtils.isEmpty(contactRequestsVO.userInfo)) {
                            String strOptString3 = null;
                            try {
                                JSONObject jSONObject2 = new JSONObject(contactRequestsVO.userInfo);
                                strOptString3 = jSONObject2.optString("recommendText");
                                jSONObject2.optString("phone");
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                contactInfoItem.setDescription(strOptString3);
                            }
                        }
                        if (contactRequestsVO.sourceType == 20) {
                            String string4 = cursor.getString(cursor.getColumnIndex("request_info"));
                            if (!TextUtils.isEmpty(string4)) {
                                contactInfoItem.setDescription(string4);
                            }
                        }
                        PhoneContactItem phoneContactItem = mapM.get(string2);
                        if (phoneContactItem == null || TextUtils.isEmpty(phoneContactItem.m())) {
                            contactInfoItem.setNickName(contactRequestsVO.fromNickName);
                        } else {
                            contactInfoItem.setNickName(contactRequestsVO.fromNickName + "(" + phoneContactItem.m() + ")");
                        }
                    } else {
                        contactInfoItem.setNickName(cursor.getString(cursor.getColumnIndex("from_nick_name")));
                        contactInfoItem.setDescription(AppContext.getContext().getString(R.string.contact_others_phone));
                    }
                    map.put(str2, Boolean.TRUE);
                    xh4 xh4Var = new xh4();
                    xh4Var.h(string);
                    xh4Var.g(i);
                    xh4Var.e(contactInfoItem);
                    xh4Var.f(contactRequestsVO);
                    arrayList2 = arrayList;
                    arrayList2.add(xh4Var);
                }
            } while (cursor.moveToNext());
        }
        return arrayList2;
    }

    public static HashMap<String, PhoneContactVo> c(ArrayList<ContactRequestsVO> arrayList) {
        HashMap<String, PhoneContactVo> map = new HashMap<>();
        for (ContactRequestsVO contactRequestsVO : arrayList) {
            PhoneContactVo phoneContactVo = new PhoneContactVo();
            try {
                JSONObject jSONObject = new JSONObject(contactRequestsVO.userInfo);
                phoneContactVo.setUid(jSONObject.optString(DeviceInfoUtil.UID_TAG));
                phoneContactVo.setExid(jSONObject.optString(bd.h));
                phoneContactVo.setMd5Phone(jSONObject.optString("md5Phone"));
                phoneContactVo.setIsFriend(jSONObject.optInt("isFriend"));
                phoneContactVo.setNickName(contactRequestsVO.fromNickName);
                if (TextUtils.isEmpty(phoneContactVo.getNickName())) {
                    phoneContactVo.setNickName(jSONObject.optString("nickname"));
                }
                phoneContactVo.setIconURL(jSONObject.optString("headIconUrl"));
                phoneContactVo.setBigIconURL(jSONObject.optString("headImgUrl"));
                phoneContactVo.setSignature(jSONObject.optString(a.A));
                phoneContactVo.setGender(jSONObject.optInt("sex"));
                phoneContactVo.setCountry(jSONObject.optString("country"));
                phoneContactVo.setProvince(jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE));
                phoneContactVo.setCity(jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY));
                phoneContactVo.setEmail(jSONObject.optString(NotificationCompat.CATEGORY_EMAIL));
                phoneContactVo.setSourceType(contactRequestsVO.sourceType);
                phoneContactVo.setRequestType(contactRequestsVO.requestType);
                phoneContactVo.setFirstPinyin(jSONObject.optString("pyInitial"));
                phoneContactVo.setAllPinyin(jSONObject.optString("pyQuanPin"));
                phoneContactVo.setLocalNameAllPinyin(jSONObject.optString(PhoneContactVo.key_local_allPinyin));
                phoneContactVo.setLocalNameFirstPinyin(jSONObject.optString(PhoneContactVo.key_local_firstPinyin));
                phoneContactVo.setMobile(jSONObject.optString("phone"));
                phoneContactVo.setLocalName(jSONObject.optString("localName"));
                phoneContactVo.setLocalPhone(yh4.a(jSONObject.optString("localPhone")));
                phoneContactVo.setRecommendText(!TextUtils.isEmpty(contactRequestsVO.recommendText) ? contactRequestsVO.recommendText : jSONObject.optString("recommendText"));
                phoneContactVo.setApplyFriendTime(jSONObject.optLong("applyFriendTime"));
                phoneContactVo.setSendTime(jSONObject.optLong(RemoteMessageConst.SEND_TIME));
                phoneContactVo.setCycleShowTime(jSONObject.optLong("cycleTime"));
                int iOptInt = jSONObject.optInt("userType");
                if (iOptInt < 1) {
                    iOptInt = (TextUtils.isEmpty(phoneContactVo.getNickName()) || TextUtils.isEmpty(phoneContactVo.getIconURL())) ? 4 : 3;
                }
                phoneContactVo.setUserType(iOptInt);
                phoneContactVo.setActiveTime(jSONObject.optLong("activeTime"));
                phoneContactVo.setRealName(contactRequestsVO.realName);
                phoneContactVo.setReadStatus(contactRequestsVO.readStatus);
                if (phoneContactVo.getSendTime() == 0 && !TextUtils.isEmpty(contactRequestsVO.sendTime)) {
                    phoneContactVo.setSendTime(Long.valueOf(contactRequestsVO.sendTime).longValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!map.containsKey(contactRequestsVO.fromUid)) {
                map.put(contactRequestsVO.fromUid, phoneContactVo);
            }
        }
        return map;
    }

    public static void d(String str, int i) {
        gu4.d(false);
        String[] strArr = {String.valueOf(i), String.valueOf(str)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("applyFriendTime", String.valueOf(ir5.b()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "request_type = ? and from_uid = ?", strArr);
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setRequestType(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR);
        contactInfoItem.setUid(str);
        h(contactInfoItem);
    }

    public static boolean e(ContactInfoItem contactInfoItem) {
        String strA = rl0.h().c().a();
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String[] strArr = {String.valueOf(contactInfoItem.getRequestType()), String.valueOf(contactInfoItem.getUid())};
        ContentValues contentValues = new ContentValues();
        contentValues.put("expireTime", String.valueOf(by5.g(Integer.valueOf(strA).intValue())));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "request_type = ? and from_uid = ?", strArr);
        return true;
    }

    public static void f(xh4 xh4Var) {
        String[] strArr = {String.valueOf(xh4Var.c()), String.valueOf(xh4Var.d())};
        ContentValues contentValues = new ContentValues();
        contentValues.put("deleteTime", String.valueOf(ir5.b()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "request_type = ? and from_uid = ?", strArr);
    }

    public static boolean g(ContactInfoItem contactInfoItem) {
        String strC = rl0.h().c().c();
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        String[] strArr = {String.valueOf(contactInfoItem.getRequestType()), String.valueOf(contactInfoItem.getUid())};
        ContentValues contentValues = new ContentValues();
        contentValues.put("expireTime", String.valueOf(by5.f(Integer.valueOf(strC).intValue())));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "request_type = ? and from_uid = ?", strArr);
        return true;
    }

    public static void h(ContactInfoItem contactInfoItem) {
        if (contactInfoItem == null) {
            return;
        }
        gu4.d(false);
        String[] strArr = {String.valueOf(contactInfoItem.getRequestType()), String.valueOf(contactInfoItem.getUid())};
        ContentValues contentValues = new ContentValues();
        contentValues.put("operateTime", String.valueOf(ir5.b()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "request_type = ? and from_uid = ?", strArr);
        rn0.g(String.valueOf(contactInfoItem.getUid()));
    }

    public static void i(String str, int i) {
        gu4.d(false);
        String[] strArr = {String.valueOf(i), String.valueOf(str)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("operateTime", String.valueOf(ir5.b()));
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "request_type = ? and from_uid = ?", strArr);
        rn0.g(String.valueOf(str));
    }

    public static void j(xh4 xh4Var) {
        String[] strArr = {String.valueOf(xh4Var.c()), String.valueOf(xh4Var.d())};
        ContentValues contentValues = new ContentValues();
        contentValues.put("deleteTime", String.valueOf(ir5.b()));
        contentValues.put("read_status", (Long) 1L);
        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "request_type = ? and from_uid = ?", strArr);
    }
}
