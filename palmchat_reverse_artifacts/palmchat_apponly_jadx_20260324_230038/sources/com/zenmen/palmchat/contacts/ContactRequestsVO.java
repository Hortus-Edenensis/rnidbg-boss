package com.zenmen.palmchat.contacts;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.ads.ld;
import com.huawei.openalliance.ad.constant.bq;
import com.umeng.analytics.pro.bd;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.bo0;
import defpackage.hs0;
import defpackage.io0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ContactRequestsVO implements Parcelable {
    public static final Parcelable.Creator<ContactRequestsVO> CREATOR = new a();
    public long acceptStatus;
    public int aiShowUi;
    public long applyExpireSec;
    public String applyFriendTime;
    public long applyTime;
    public String carImageUrl;
    public int commonFrds;
    public String deleteTime;
    private long disReadStatus;
    private long disReadTime;
    public long disShowTime;
    public int enhancedTag;
    public String expireTime;
    public String fromHeadIcon;
    public String fromNickName;
    public String fromSignature;
    public String fromUid;
    public int id;
    public String identifyCode;
    private int isFriend;
    public String mid;
    public String operateTime;
    public long readStatus;
    public long readTime;
    public String realName;
    public String recommendText;
    public String recommendTitle;
    public String requestInfo;
    public String requestRid;
    public int requestType;
    public String sendTime;
    private String showName;
    private int sortId;
    public int sourceType;
    public int type;
    public String userInfo;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<ContactRequestsVO> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactRequestsVO createFromParcel(Parcel parcel) {
            return new ContactRequestsVO(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ContactRequestsVO[] newArray(int i) {
            return new ContactRequestsVO[i];
        }
    }

    public ContactRequestsVO() {
        this.disReadStatus = -1L;
        this.disReadTime = -1L;
        this.sortId = -1;
    }

    public static ArrayList<ContactRequestsVO> buildFromCursorForEnhancedContact(Cursor cursor, boolean z, boolean z2) {
        ArrayList<ContactRequestsVO> arrayList = new ArrayList<>();
        ArrayList<ContactRequestsVO> arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("from_uid"));
                String string2 = cursor.getString(cursor.getColumnIndex("deleteTime"));
                if (!z2 || TextUtils.isEmpty(string2)) {
                    if (!z || !bo0.r().w(string)) {
                        ContactRequestsVO contactRequestsVOConvertContactRequestsVO = convertContactRequestsVO(cursor);
                        if (contactRequestsVOConvertContactRequestsVO.enhancedTag != 0) {
                            arrayList2.add(contactRequestsVOConvertContactRequestsVO);
                        } else if (!map.containsKey(string)) {
                            contactRequestsVOConvertContactRequestsVO.enhancedTag = 1;
                            arrayList.add(0, contactRequestsVOConvertContactRequestsVO);
                            map.put(string, Boolean.TRUE);
                        }
                    }
                }
            }
            if (arrayList2.size() > 0) {
                for (ContactRequestsVO contactRequestsVO : arrayList2) {
                    if (!map.containsKey(contactRequestsVO.fromUid)) {
                        arrayList.add(contactRequestsVO);
                        map.put(contactRequestsVO.fromUid, Boolean.TRUE);
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<ContactRequestsVO> it = arrayList.iterator();
        while (it.hasNext()) {
            ContactRequestsVO next = it.next();
            if (arrayList3.contains(next.identifyCode)) {
                it.remove();
            } else if (!TextUtils.isEmpty(next.identifyCode)) {
                arrayList3.add(next.identifyCode);
            }
        }
        return arrayList;
    }

    public static ArrayList<ContactRequestsVO> buildFromCursorForLX16234(Cursor cursor, boolean z) {
        ArrayList<ContactRequestsVO> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        long j = 0;
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    String string = cursor.getString(cursor.getColumnIndex("from_uid"));
                    String string2 = cursor.getString(cursor.getColumnIndex("deleteTime"));
                    if (cursor.getLong(cursor.getColumnIndex("read_status")) == j) {
                        map2.put(string, Boolean.TRUE);
                    }
                    if (!map.containsKey(string) && (!z || TextUtils.isEmpty(string2))) {
                        ContactRequestsVO contactRequestsVO = new ContactRequestsVO();
                        contactRequestsVO.fromUid = cursor.getString(cursor.getColumnIndex("from_uid"));
                        contactRequestsVO.mid = cursor.getString(cursor.getColumnIndex("mid"));
                        contactRequestsVO.fromNickName = cursor.getString(cursor.getColumnIndex("from_nick_name"));
                        contactRequestsVO.fromSignature = cursor.getString(cursor.getColumnIndex("from_signature"));
                        contactRequestsVO.fromHeadIcon = cursor.getString(cursor.getColumnIndex("from_head_img_url"));
                        contactRequestsVO.requestInfo = cursor.getString(cursor.getColumnIndex("request_info"));
                        contactRequestsVO.requestRid = cursor.getString(cursor.getColumnIndex("rid"));
                        contactRequestsVO.readStatus = cursor.getLong(cursor.getColumnIndex("read_status"));
                        contactRequestsVO.acceptStatus = cursor.getLong(cursor.getColumnIndex("accept_status"));
                        contactRequestsVO.type = cursor.getInt(cursor.getColumnIndex("request_type"));
                        contactRequestsVO.userInfo = cursor.getString(cursor.getColumnIndex("user_info"));
                        contactRequestsVO.id = cursor.getInt(cursor.getColumnIndex("_id"));
                        String string3 = cursor.getString(cursor.getColumnIndex("identify_code"));
                        contactRequestsVO.requestType = cursor.getInt(cursor.getColumnIndex("request_type"));
                        contactRequestsVO.recommendText = cursor.getString(cursor.getColumnIndex("recommendText"));
                        String strOptString = null;
                        if (!TextUtils.isEmpty(contactRequestsVO.userInfo)) {
                            try {
                                JSONObject jSONObject = new JSONObject(contactRequestsVO.userInfo);
                                strOptString = jSONObject.optString("realName");
                                if (contactRequestsVO.requestType == 220 && TextUtils.isEmpty(strOptString)) {
                                    String strOptString2 = jSONObject.optString("nickname");
                                    if (!TextUtils.isEmpty(strOptString2) && !strOptString2.equals(contactRequestsVO.fromNickName)) {
                                        strOptString = strOptString2;
                                    }
                                }
                                if (TextUtils.isEmpty(contactRequestsVO.recommendText)) {
                                    contactRequestsVO.recommendText = jSONObject.optString("recommendText");
                                }
                                if (TextUtils.isEmpty(string3)) {
                                    String strOptString3 = jSONObject.optString("md5Phone");
                                    String strOptString4 = jSONObject.optString("phone");
                                    if (!TextUtils.isEmpty(strOptString3)) {
                                        string3 = strOptString3;
                                    } else if (!TextUtils.isEmpty(strOptString4)) {
                                        strOptString3 = hs0.g().d(strOptString4);
                                        string3 = strOptString3;
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        contactRequestsVO.identifyCode = string3;
                        contactRequestsVO.sourceType = cursor.getInt(cursor.getColumnIndex("source_type"));
                        contactRequestsVO.sendTime = cursor.getString(cursor.getColumnIndex("send_time"));
                        contactRequestsVO.applyFriendTime = cursor.getString(cursor.getColumnIndex("applyFriendTime"));
                        contactRequestsVO.recommendTitle = cursor.getString(cursor.getColumnIndex("recommendTitle"));
                        contactRequestsVO.commonFrds = cursor.getInt(cursor.getColumnIndex("commonFrds"));
                        contactRequestsVO.applyTime = cursor.getLong(cursor.getColumnIndex("applyTime"));
                        contactRequestsVO.applyExpireSec = cursor.getLong(cursor.getColumnIndex("applyExpireSec"));
                        contactRequestsVO.readTime = cursor.getLong(cursor.getColumnIndex("readTime"));
                        contactRequestsVO.disShowTime = cursor.getLong(cursor.getColumnIndex("disShowTime"));
                        contactRequestsVO.deleteTime = cursor.getString(cursor.getColumnIndex("deleteTime"));
                        if (TextUtils.isEmpty(strOptString)) {
                            strOptString = "";
                        }
                        map.put(string, strOptString);
                        if (contactRequestsVO.readStatus == 0) {
                            map2.put(string, Boolean.TRUE);
                        }
                        if (TextUtils.isEmpty(contactRequestsVO.identifyCode)) {
                            arrayList.add(contactRequestsVO);
                        } else if (!arrayList2.contains(contactRequestsVO.identifyCode)) {
                            arrayList2.add(contactRequestsVO.identifyCode);
                            arrayList.add(contactRequestsVO);
                        }
                    } else if (TextUtils.isEmpty((CharSequence) map.get(string))) {
                        String string4 = cursor.getString(cursor.getColumnIndex("user_info"));
                        if (!TextUtils.isEmpty(string4)) {
                            try {
                                String strOptString5 = new JSONObject(string4).optString("realName");
                                if (!TextUtils.isEmpty(strOptString5)) {
                                    map.put(string, strOptString5);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    j = 0;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    LogUtil.log4ClientError("buildFromCursorForLX16234", e3);
                }
            }
        }
        if (arrayList.size() > 0) {
            for (ContactRequestsVO contactRequestsVO2 : arrayList) {
                String str = (String) map.get(contactRequestsVO2.fromUid);
                if (!TextUtils.isEmpty(str)) {
                    contactRequestsVO2.realName = str;
                }
                if (contactRequestsVO2.readStatus == 1 && map2.containsKey(contactRequestsVO2.fromUid)) {
                    contactRequestsVO2.readStatus = 0L;
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<ContactRequestsVO> buildFromCursorForShow(Cursor cursor) {
        ArrayList<ContactRequestsVO> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    String string = cursor.getString(cursor.getColumnIndex("from_uid"));
                    if (cursor.getInt(cursor.getColumnIndex("request_type")) >= 100) {
                        string = string + 100;
                    }
                    if (!map.containsKey(string)) {
                        ContactRequestsVO contactRequestsVO = new ContactRequestsVO();
                        contactRequestsVO.fromUid = cursor.getString(cursor.getColumnIndex("from_uid"));
                        contactRequestsVO.mid = cursor.getString(cursor.getColumnIndex("mid"));
                        contactRequestsVO.fromNickName = cursor.getString(cursor.getColumnIndex("from_nick_name"));
                        contactRequestsVO.fromSignature = cursor.getString(cursor.getColumnIndex("from_signature"));
                        contactRequestsVO.fromHeadIcon = cursor.getString(cursor.getColumnIndex("from_head_img_url"));
                        contactRequestsVO.requestInfo = cursor.getString(cursor.getColumnIndex("request_info"));
                        contactRequestsVO.requestRid = cursor.getString(cursor.getColumnIndex("rid"));
                        contactRequestsVO.readStatus = cursor.getLong(cursor.getColumnIndex("read_status"));
                        contactRequestsVO.acceptStatus = cursor.getLong(cursor.getColumnIndex("accept_status"));
                        contactRequestsVO.type = cursor.getInt(cursor.getColumnIndex("request_type"));
                        contactRequestsVO.userInfo = cursor.getString(cursor.getColumnIndex("user_info"));
                        contactRequestsVO.id = cursor.getInt(cursor.getColumnIndex("_id"));
                        String string2 = cursor.getString(cursor.getColumnIndex("identify_code"));
                        if (!TextUtils.isEmpty(contactRequestsVO.userInfo)) {
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
                                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("carData");
                                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean(bq.b.V, false)) {
                                    contactRequestsVO.carImageUrl = jSONObjectOptJSONObject.optString(ld.f6599a);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        contactRequestsVO.identifyCode = string2;
                        contactRequestsVO.sourceType = cursor.getInt(cursor.getColumnIndex("source_type"));
                        contactRequestsVO.requestType = cursor.getInt(cursor.getColumnIndex("request_type"));
                        contactRequestsVO.sendTime = cursor.getString(cursor.getColumnIndex("send_time"));
                        contactRequestsVO.applyFriendTime = cursor.getString(cursor.getColumnIndex("applyFriendTime"));
                        contactRequestsVO.recommendTitle = cursor.getString(cursor.getColumnIndex("recommendTitle"));
                        contactRequestsVO.recommendText = cursor.getString(cursor.getColumnIndex("recommendText"));
                        contactRequestsVO.commonFrds = cursor.getInt(cursor.getColumnIndex("commonFrds"));
                        contactRequestsVO.applyTime = cursor.getLong(cursor.getColumnIndex("applyTime"));
                        contactRequestsVO.applyExpireSec = cursor.getLong(cursor.getColumnIndex("applyExpireSec"));
                        contactRequestsVO.readTime = cursor.getLong(cursor.getColumnIndex("readTime"));
                        contactRequestsVO.disShowTime = cursor.getLong(cursor.getColumnIndex("disShowTime"));
                        map.put(string, Boolean.TRUE);
                        arrayList.add(contactRequestsVO);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static ContactRequestsVO convertContactRequestsVO(Cursor cursor) {
        ContactRequestsVO contactRequestsVO = new ContactRequestsVO();
        contactRequestsVO.fromUid = cursor.getString(cursor.getColumnIndex("from_uid"));
        contactRequestsVO.mid = cursor.getString(cursor.getColumnIndex("mid"));
        contactRequestsVO.fromNickName = cursor.getString(cursor.getColumnIndex("from_nick_name"));
        contactRequestsVO.fromSignature = cursor.getString(cursor.getColumnIndex("from_signature"));
        contactRequestsVO.fromHeadIcon = cursor.getString(cursor.getColumnIndex("from_head_img_url"));
        contactRequestsVO.requestInfo = cursor.getString(cursor.getColumnIndex("request_info"));
        contactRequestsVO.requestRid = cursor.getString(cursor.getColumnIndex("rid"));
        contactRequestsVO.readStatus = cursor.getLong(cursor.getColumnIndex("read_status"));
        contactRequestsVO.acceptStatus = cursor.getLong(cursor.getColumnIndex("accept_status"));
        contactRequestsVO.type = cursor.getInt(cursor.getColumnIndex("request_type"));
        contactRequestsVO.userInfo = cursor.getString(cursor.getColumnIndex("user_info"));
        contactRequestsVO.id = cursor.getInt(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("identify_code"));
        if (!TextUtils.isEmpty(contactRequestsVO.userInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(contactRequestsVO.userInfo);
                contactRequestsVO.realName = jSONObject.optString("realName");
                contactRequestsVO.enhancedTag = jSONObject.optInt("tag");
                if (TextUtils.isEmpty(string)) {
                    String strOptString = jSONObject.optString("md5Phone");
                    String strOptString2 = jSONObject.optString("phone");
                    if (!TextUtils.isEmpty(strOptString)) {
                        string = strOptString;
                    } else if (!TextUtils.isEmpty(strOptString2)) {
                        string = hs0.g().d(strOptString2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        contactRequestsVO.identifyCode = string;
        contactRequestsVO.sourceType = cursor.getInt(cursor.getColumnIndex("source_type"));
        contactRequestsVO.requestType = cursor.getInt(cursor.getColumnIndex("request_type"));
        contactRequestsVO.sendTime = cursor.getString(cursor.getColumnIndex("send_time"));
        contactRequestsVO.applyFriendTime = cursor.getString(cursor.getColumnIndex("applyFriendTime"));
        contactRequestsVO.recommendTitle = cursor.getString(cursor.getColumnIndex("recommendTitle"));
        contactRequestsVO.recommendText = cursor.getString(cursor.getColumnIndex("recommendText"));
        contactRequestsVO.commonFrds = cursor.getInt(cursor.getColumnIndex("commonFrds"));
        contactRequestsVO.applyTime = cursor.getLong(cursor.getColumnIndex("applyTime"));
        contactRequestsVO.applyExpireSec = cursor.getLong(cursor.getColumnIndex("applyExpireSec"));
        contactRequestsVO.readTime = cursor.getLong(cursor.getColumnIndex("readTime"));
        contactRequestsVO.disShowTime = cursor.getLong(cursor.getColumnIndex("disShowTime"));
        return contactRequestsVO;
    }

    public static boolean isRequestRid(String str) {
        int iIndexOf;
        if (!TextUtils.isEmpty(str) && (iIndexOf = str.indexOf("_")) > 0) {
            String strSubstring = str.substring(iIndexOf + 1);
            String strP = AccountUtils.p(AppContext.getContext());
            if (strP != null && strP.equals(strSubstring)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSenderParseFromRid(String str) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf("_")) <= 0) {
            return false;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strP = AccountUtils.p(AppContext.getContext());
        return strP != null && strP.equals(strSubstring);
    }

    public ContactInfoItem convert2ContactInfoItem() {
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(this.fromUid);
        contactInfoItem.setExid(getExidFromUserInfo());
        contactInfoItem.setNickName(this.fromNickName);
        contactInfoItem.setSignature(this.fromSignature);
        contactInfoItem.setIconURL(this.fromHeadIcon);
        contactInfoItem.setSourceType(this.sourceType);
        contactInfoItem.setRequestType(this.requestType);
        contactInfoItem.setIdentifyCode(this.identifyCode);
        if (!TextUtils.isEmpty(this.userInfo)) {
            try {
                String strOptString = new JSONObject(this.userInfo).optString("ext");
                if (!TextUtils.isEmpty(strOptString)) {
                    contactInfoItem.setExt((ContactExtBean) az2.a(strOptString, ContactExtBean.class));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LogUtil.i("ContactRequestsVO", "ContactRequestsVO sourceType: " + this.sourceType);
        return contactInfoItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int genSortId() {
        if (this.sortId == -1) {
            boolean z = this.applyTime > 0 && System.currentTimeMillis() > this.applyTime + (this.applyExpireSec * 1000);
            boolean zP = io0.p(this.sourceType);
            if (this.readStatus == 0) {
                if (this.requestType == 227) {
                    this.sortId = 0;
                } else if (zP) {
                    this.sortId = 1;
                } else {
                    this.sortId = 2;
                }
            } else if ((!isSenderParseFromRid(this.requestRid) && z) || bo0.r().w(this.fromUid)) {
                this.sortId = 7;
            } else if (this.requestType == 227) {
                this.sortId = 4;
            } else if (zP) {
                this.sortId = 6;
            } else {
                this.sortId = 5;
            }
        }
        return this.sortId;
    }

    public long getDisReadStatus() {
        if (this.disReadStatus == -1) {
            if (this.disShowTime != 0) {
                this.disReadStatus = 1L;
            } else {
                this.disReadStatus = this.readStatus;
            }
        }
        return this.disReadStatus;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getDisReadTime() {
        if (this.disReadTime == -1) {
            long j = this.readTime;
            if (j != 0) {
                long j2 = this.disShowTime;
                if (j2 != 0) {
                    if (j >= j2) {
                        j = j2;
                    }
                    this.disReadTime = j;
                } else if (j != 0) {
                    this.disReadTime = j;
                } else {
                    this.disReadTime = this.disShowTime;
                }
            }
        }
        return this.disReadTime;
    }

    public String getExidFromUserInfo() {
        if (this.userInfo != null) {
            try {
                return new JSONObject(this.userInfo).optString(bd.h);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getFormatShowName() {
        String localOrRealName = getLocalOrRealName();
        if (TextUtils.isEmpty(localOrRealName)) {
            this.showName = this.fromNickName;
        } else {
            this.showName = this.fromNickName + " (" + localOrRealName + ")";
        }
        return this.showName;
    }

    public int getIsFriend() {
        int i = this.isFriend;
        if (i == 0) {
            i = bo0.r().w(this.fromUid) ? 2 : 1;
            this.isFriend = i;
        }
        return i;
    }

    public String getLocalOrRealName() {
        PhoneContactItem phoneContactItemL = d.j().l(this.identifyCode);
        return (phoneContactItemL == null || TextUtils.isEmpty(phoneContactItemL.m())) ? !TextUtils.isEmpty(this.realName) ? this.realName : "" : phoneContactItemL.m();
    }

    public int getRequestType() {
        return this.requestType;
    }

    public String getSignFromUserInfo() {
        if (this.userInfo != null) {
            try {
                return new JSONObject(this.userInfo).optString("sign");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int getSortId() {
        return this.sortId;
    }

    public void setRequestType(int i) {
        this.requestType = i;
    }

    public void setSortId(int i) {
        this.sortId = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.mid);
        parcel.writeString(this.fromUid);
        parcel.writeString(this.fromNickName);
        parcel.writeString(this.fromSignature);
        parcel.writeString(this.fromHeadIcon);
        parcel.writeString(this.requestInfo);
        parcel.writeString(this.requestRid);
        parcel.writeLong(this.readStatus);
        parcel.writeLong(this.acceptStatus);
        parcel.writeInt(this.type);
        parcel.writeString(this.identifyCode);
        parcel.writeInt(this.requestType);
        parcel.writeString(this.realName);
        parcel.writeInt(this.sourceType);
        parcel.writeString(this.sendTime);
        parcel.writeString(this.applyFriendTime);
        parcel.writeString(this.userInfo);
        parcel.writeString(this.expireTime);
        parcel.writeString(this.operateTime);
        parcel.writeString(this.deleteTime);
        parcel.writeString(this.recommendTitle);
        parcel.writeString(this.recommendText);
        parcel.writeInt(this.commonFrds);
        parcel.writeLong(this.applyTime);
        parcel.writeLong(this.applyExpireSec);
        parcel.writeLong(this.readTime);
        parcel.writeLong(this.disShowTime);
        parcel.writeInt(this.enhancedTag);
        parcel.writeLong(this.disReadStatus);
        parcel.writeLong(this.disReadTime);
        parcel.writeInt(this.sortId);
        parcel.writeInt(this.isFriend);
        parcel.writeString(this.showName);
        parcel.writeInt(this.aiShowUi);
    }

    public ContactRequestsVO(Parcel parcel) {
        this.disReadStatus = -1L;
        this.disReadTime = -1L;
        this.sortId = -1;
        this.id = parcel.readInt();
        this.mid = parcel.readString();
        this.fromUid = parcel.readString();
        this.fromNickName = parcel.readString();
        this.fromSignature = parcel.readString();
        this.fromHeadIcon = parcel.readString();
        this.requestInfo = parcel.readString();
        this.requestRid = parcel.readString();
        this.readStatus = parcel.readLong();
        this.acceptStatus = parcel.readLong();
        this.type = parcel.readInt();
        this.identifyCode = parcel.readString();
        this.requestType = parcel.readInt();
        this.realName = parcel.readString();
        this.sourceType = parcel.readInt();
        this.sendTime = parcel.readString();
        this.applyFriendTime = parcel.readString();
        this.userInfo = parcel.readString();
        this.expireTime = parcel.readString();
        this.operateTime = parcel.readString();
        this.deleteTime = parcel.readString();
        this.recommendTitle = parcel.readString();
        this.recommendText = parcel.readString();
        this.commonFrds = parcel.readInt();
        this.applyTime = parcel.readLong();
        this.applyExpireSec = parcel.readLong();
        this.readTime = parcel.readLong();
        this.disShowTime = parcel.readLong();
        this.enhancedTag = parcel.readInt();
        this.disReadStatus = parcel.readLong();
        this.disReadTime = parcel.readLong();
        this.sortId = parcel.readInt();
        this.isFriend = parcel.readInt();
        this.showName = parcel.readString();
        this.aiShowUi = parcel.readInt();
    }

    public String getLocalOrRealName(HashMap<String, PhoneContactItem> map) {
        PhoneContactItem phoneContactItem;
        String strM = (map == null || TextUtils.isEmpty(this.identifyCode) || (phoneContactItem = map.get(this.identifyCode)) == null || TextUtils.isEmpty(phoneContactItem.m())) ? "" : phoneContactItem.m();
        return TextUtils.isEmpty(strM) ? this.realName : strM;
    }
}
