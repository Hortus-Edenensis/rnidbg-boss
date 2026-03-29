package defpackage;

import android.content.ContentValues;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ae2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<ContentValues> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ContentValues contentValues, ContentValues contentValues2) {
            if (contentValues == null || contentValues2 == null) {
                return 0;
            }
            Object obj = contentValues.get("resource_version");
            Object obj2 = contentValues2.get("resource_version");
            long jLongValue = (obj != null ? ((Long) obj).longValue() : 0L) - (obj2 != null ? ((Long) obj2).longValue() : 0L);
            if (jLongValue > 0) {
                return 1;
            }
            return jLongValue == 0 ? 0 : -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements dv0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1215a;

        public b(String str) {
            this.f1215a = str;
        }

        @Override // defpackage.dv0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(BaseResponse baseResponse) {
            LogUtil.d("CircleHistoryMsgController", "syncing group history of " + this.f1215a + " finished.");
        }
    }

    public static ContentValues[] a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("delRooms");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
            String string = jSONObject2.getString("id");
            int i2 = jSONObject2.getInt("type");
            ContentValues contentValues = new ContentValues();
            contentValues.put("group_id", string);
            contentValues.put("resource_type", jSONObject2.getString("syncKey"));
            contentValues.put("resource_version", Long.valueOf(jSONObject2.getLong("version")));
            s90.a().d(string);
            if (i2 == 2) {
                contentValues.put("group_operation", (Integer) 2);
            } else {
                if (i2 != 3) {
                    return null;
                }
                contentValues.put("group_operation", (Integer) 3);
            }
            arrayList.add(contentValues);
        }
        return (ContentValues[]) arrayList.toArray(new ContentValues[1]);
    }

    public static ContentValues[] b(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("modRooms");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        ContentValues[] contentValuesArr = new ContentValues[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            ContentValues contentValues = new ContentValues();
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
            String string = jSONObject2.getString("id");
            contentValues.put("group_id", string);
            String strOptString = jSONObject2.optString("name");
            if (!TextUtils.isEmpty(strOptString)) {
                contentValues.put("name", strOptString);
            }
            contentValues.put("owner", jSONObject2.getString("owner"));
            String strOptString2 = jSONObject2.optString("headImgUrl");
            if (!TextUtils.isEmpty(strOptString2)) {
                contentValues.put("headImgUrl", strOptString2);
            }
            contentValues.put("type", Integer.valueOf(jSONObject2.getInt("type")));
            contentValues.put("group_config", Integer.valueOf(jSONObject2.optInt("status", 0)));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(x.cw, jSONObject2.optString(x.cw));
            jSONObject3.put("extType", jSONObject2.optInt("extType"));
            zd2.c(string, jSONObject2.optInt("extType"));
            contentValues.put("group_extra_info", jSONObject3.toString());
            String strOptString3 = jSONObject2.optString(x.cw);
            if (!TextUtils.isEmpty(strOptString3)) {
                jSONObject3.put(x.cw, strOptString3);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt = jSONObject2.optInt("roomType", -1);
            if (iOptInt != -1) {
                jSONObject3.put("roomType", iOptInt);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt2 = jSONObject2.optInt("diffuse", -1);
            if (iOptInt2 != -1) {
                jSONObject3.put("diffuse", iOptInt2);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt3 = jSONObject2.optInt("applyStatus", -1);
            if (iOptInt3 != -1) {
                jSONObject3.put("applyStatus", iOptInt3);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt4 = jSONObject2.optInt("updNamePermissionType", -1);
            if (iOptInt4 != -1) {
                jSONObject3.put("permissionType", iOptInt4);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt5 = jSONObject2.optInt("merchantType", -1);
            if (iOptInt5 != -1) {
                jSONObject3.put("merchantType", iOptInt5);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt6 = jSONObject2.optInt("merchantState", -1);
            if (iOptInt6 != -1) {
                jSONObject3.put("merchantState", iOptInt6);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt7 = jSONObject2.optInt("recmdSwitch", -1);
            if (iOptInt7 != -1) {
                jSONObject3.put("recmdSwitch", iOptInt7);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt8 = jSONObject2.optInt("addFriendSwitch", 1);
            if (iOptInt8 != -1) {
                jSONObject3.put("addFriendSwitch", iOptInt8);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt9 = jSONObject2.optInt("accessSwitch", -1);
            if (iOptInt9 != -1) {
                jSONObject3.put("accessSwitch", iOptInt9);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString4 = jSONObject2.optString("rnumber");
            if (!TextUtils.isEmpty(strOptString4)) {
                jSONObject3.put("rnumber", strOptString4);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString5 = jSONObject2.optString("cover");
            if (!TextUtils.isEmpty(strOptString5)) {
                jSONObject3.put("cover", strOptString5);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString6 = jSONObject2.optString("place");
            if (!TextUtils.isEmpty(strOptString6)) {
                jSONObject3.put("place", strOptString6);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString7 = jSONObject2.optString("cateName");
            if (!TextUtils.isEmpty(strOptString7)) {
                jSONObject3.put("cateName", strOptString7);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString8 = jSONObject2.optString("describe");
            if (!TextUtils.isEmpty(strOptString8)) {
                jSONObject3.put("describe", strOptString8);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString9 = jSONObject2.optString("remarkName");
            if (!TextUtils.isEmpty(strOptString9)) {
                jSONObject3.put("remarkName", strOptString9);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString10 = jSONObject2.optString("welContent");
            if (!TextUtils.isEmpty(strOptString10)) {
                jSONObject3.put(" welContent", strOptString10);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            jSONObject3.put("showHisSwitch", jSONObject2.optInt("showHisSwitch", 1));
            contentValues.put("group_extra_info", jSONObject3.toString());
            JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("tagNames");
            if (jSONArrayOptJSONArray2 != null) {
                jSONObject3.put("tagNames", jSONArrayOptJSONArray2);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("tags");
            if (jSONArrayOptJSONArray3 != null) {
                jSONObject3.put("tags", jSONArrayOptJSONArray3);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObject2.optJSONArray("tools");
            if (jSONArrayOptJSONArray4 != null) {
                jSONObject3.put("tools", jSONArrayOptJSONArray4);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            long jOptLong = jSONObject2.optLong("createTimestamp", -1L);
            if (jOptLong != -1) {
                jSONObject3.put("createTimestamp", jOptLong);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt10 = jSONObject2.optInt("addType", -1);
            if (iOptInt10 != -1) {
                jSONObject3.put("addType", iOptInt10);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt11 = jSONObject2.optInt("inviteSwitch", -1);
            if (iOptInt11 != -1) {
                jSONObject3.put("inviteSwitch", iOptInt11);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt12 = jSONObject2.optInt("inviteCheckSwitch", -1);
            if (iOptInt12 != -1) {
                jSONObject3.put("inviteCheckSwitch", iOptInt12);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            contentValues.put("group_operation", (Integer) 1);
            String strOptString11 = jSONObject2.optString("syncKey");
            if (!TextUtils.isEmpty(strOptString11)) {
                contentValues.put("resource_type", strOptString11);
            }
            long jOptLong2 = jSONObject2.optLong("version");
            if (jOptLong2 != 0) {
                contentValues.put("resource_version", Long.valueOf(jOptLong2));
            }
            JSONArray jSONArrayOptJSONArray5 = jSONObject2.optJSONArray("members");
            if (jSONArrayOptJSONArray5 != null) {
                contentValues.put("group_member", jSONArrayOptJSONArray5.toString());
                contentValues.put("group_member_change_count", Integer.valueOf(jSONArrayOptJSONArray5.length()));
                int i2 = 0;
                while (true) {
                    if (i2 >= jSONArrayOptJSONArray5.length()) {
                        break;
                    }
                    JSONObject jSONObject4 = jSONArrayOptJSONArray5.getJSONObject(i2);
                    String strOptString12 = jSONObject4.optString(DeviceInfoUtil.UID_TAG, "");
                    int iOptInt13 = jSONObject4.optInt("roleType", 3);
                    if (strOptString12.equals(v4.e(AppContext.getContext()))) {
                        jSONObject3.put("roleType", iOptInt13);
                        contentValues.put("group_extra_info", jSONObject3.toString());
                        break;
                    }
                    i2++;
                }
            }
            JSONArray jSONArrayOptJSONArray6 = jSONObject2.optJSONArray("delMembers");
            if (jSONArrayOptJSONArray6 != null) {
                contentValues.put("group_member_del", jSONArrayOptJSONArray6.toString());
            }
            contentValuesArr[i] = contentValues;
        }
        return contentValuesArr;
    }

    public static ContentValues[] c(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resetRooms");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        ContentValues[] contentValuesArr = new ContentValues[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            ContentValues contentValues = new ContentValues();
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
            String string = jSONObject2.getString("id");
            contentValues.put("group_id", string);
            String strOptString = jSONObject2.optString("name");
            if (!TextUtils.isEmpty(strOptString)) {
                contentValues.put("name", strOptString);
            }
            contentValues.put("owner", jSONObject2.getString("owner"));
            String strOptString2 = jSONObject2.optString("headImgUrl");
            if (!TextUtils.isEmpty(strOptString2)) {
                contentValues.put("headImgUrl", strOptString2);
            }
            contentValues.put("type", Integer.valueOf(jSONObject2.getInt("type")));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(x.cw, jSONObject2.optString(x.cw));
            jSONObject3.put("extType", jSONObject2.optInt("extType"));
            zd2.c(string, jSONObject2.optInt("extType"));
            contentValues.put("group_extra_info", jSONObject3.toString());
            String strOptString3 = jSONObject2.optString(x.cw);
            if (!TextUtils.isEmpty(strOptString3)) {
                jSONObject3.put(x.cw, strOptString3);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt = jSONObject2.optInt("roomType", -1);
            if (iOptInt != -1) {
                jSONObject3.put("roomType", iOptInt);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt2 = jSONObject2.optInt("diffuse", -1);
            if (iOptInt2 != -1) {
                jSONObject3.put("diffuse", iOptInt2);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt3 = jSONObject2.optInt("applyStatus", -1);
            if (iOptInt3 != -1) {
                jSONObject3.put("applyStatus", iOptInt3);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt4 = jSONObject2.optInt("updNamePermissionType", -1);
            if (iOptInt4 != -1) {
                jSONObject3.put("permissionType", iOptInt4);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt5 = jSONObject2.optInt("merchantType", -1);
            if (iOptInt5 != -1) {
                jSONObject3.put("merchantType", iOptInt5);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt6 = jSONObject2.optInt("merchantState", -1);
            if (iOptInt6 != -1) {
                jSONObject3.put("merchantState", iOptInt6);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt7 = jSONObject2.optInt("recmdSwitch", -1);
            if (iOptInt7 != -1) {
                jSONObject3.put("recmdSwitch", iOptInt7);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt8 = jSONObject2.optInt("addFriendSwitch", 1);
            if (iOptInt8 != -1) {
                jSONObject3.put("addFriendSwitch", iOptInt8);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt9 = jSONObject2.optInt("accessSwitch", -1);
            if (iOptInt9 != -1) {
                jSONObject3.put("accessSwitch", iOptInt9);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString4 = jSONObject2.optString("rnumber");
            if (!TextUtils.isEmpty(strOptString4)) {
                jSONObject3.put("rnumber", strOptString4);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString5 = jSONObject2.optString("cover");
            if (!TextUtils.isEmpty(strOptString5)) {
                jSONObject3.put("cover", strOptString5);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString6 = jSONObject2.optString("place");
            if (!TextUtils.isEmpty(strOptString6)) {
                jSONObject3.put("place", strOptString6);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString7 = jSONObject2.optString("cateName");
            if (!TextUtils.isEmpty(strOptString7)) {
                jSONObject3.put("cateName", strOptString7);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString8 = jSONObject2.optString("describe");
            if (!TextUtils.isEmpty(strOptString8)) {
                jSONObject3.put("describe", strOptString8);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString9 = jSONObject2.optString("remarkName");
            if (!TextUtils.isEmpty(strOptString9)) {
                jSONObject3.put("remarkName", strOptString9);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("tagNames");
            if (jSONArrayOptJSONArray2 != null) {
                jSONObject3.put("tagNames", jSONArrayOptJSONArray2);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("tags");
            if (jSONArrayOptJSONArray3 != null) {
                jSONObject3.put("tags", jSONArrayOptJSONArray3);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObject2.optJSONArray("tools");
            if (jSONArrayOptJSONArray4 != null) {
                jSONObject3.put("tools", jSONArrayOptJSONArray4);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            long jOptLong = jSONObject2.optLong("createTimestamp", -1L);
            if (jOptLong != -1) {
                jSONObject3.put("createTimestamp", jOptLong);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt10 = jSONObject2.optInt("addType", -1);
            if (iOptInt10 != -1) {
                jSONObject3.put("addType", iOptInt10);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt11 = jSONObject2.optInt("inviteSwitch", -1);
            if (iOptInt11 != -1) {
                jSONObject3.put("inviteSwitch", iOptInt11);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt12 = jSONObject2.optInt("inviteCheckSwitch", -1);
            if (iOptInt12 != -1) {
                jSONObject3.put("inviteCheckSwitch", iOptInt12);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            String strOptString10 = jSONObject2.optString("welContent", "");
            if (!TextUtils.isEmpty(strOptString10)) {
                jSONObject3.put(" welContent", strOptString10);
                contentValues.put("group_extra_info", jSONObject3.toString());
            }
            int iOptInt13 = jSONObject2.optInt("showHisSwitch", 1);
            jSONObject3.put("showHisSwitch", iOptInt13);
            contentValues.put("group_extra_info", jSONObject3.toString());
            contentValues.put("group_config", Integer.valueOf(jSONObject2.optInt("status", 0)));
            contentValues.put("resource_type", jSONObject2.getString("syncKey"));
            contentValues.put("resource_version", Long.valueOf(jSONObject2.getLong("version")));
            contentValues.put("group_operation", (Integer) 4);
            JSONArray jSONArrayOptJSONArray5 = jSONObject2.optJSONArray("members");
            if (jSONArrayOptJSONArray5 != null) {
                contentValues.put("group_member", jSONArrayOptJSONArray5.toString());
                contentValues.put("group_member_change_count", Integer.valueOf(jSONArrayOptJSONArray5.length()));
                int i2 = 0;
                while (true) {
                    if (i2 < jSONArrayOptJSONArray5.length()) {
                        JSONObject jSONObject4 = jSONArrayOptJSONArray5.getJSONObject(i2);
                        String strOptString11 = jSONObject4.optString(DeviceInfoUtil.UID_TAG, "");
                        int iOptInt14 = jSONObject4.optInt("roleType", 3);
                        if (strOptString11.equals(v4.e(AppContext.getContext()))) {
                            if (iOptInt13 == 1 && !s90.a().b(string)) {
                                s90.a().e(string, new b(string));
                            }
                            s90.a().c(string);
                            jSONObject3.put("roleType", iOptInt14);
                            contentValues.put("group_extra_info", jSONObject3.toString());
                        } else {
                            i2++;
                        }
                    }
                }
            }
            contentValuesArr[i] = contentValues;
        }
        return contentValuesArr;
    }

    public static ContentValues[] d(String str, String str2) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str2);
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            ContentValues contentValues = new ContentValues();
            contentValues.put("group_member_operation", (Integer) 2);
            contentValues.put("group_id", str);
            contentValues.put("name", string);
            arrayList.add(contentValues);
        }
        return (ContentValues[]) arrayList.toArray(new ContentValues[1]);
    }

    public static ContentValues[] e(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("group_member_operation", (Integer) 2);
                contentValues.put("group_id", arrayList.get(i));
                contentValues.put("name", AccountUtils.p(AppContext.getContext()));
                arrayList2.add(contentValues);
            }
        }
        return (ContentValues[]) arrayList2.toArray(new ContentValues[1]);
    }

    public static ContentValues[] f(String str, String str2, String str3) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str3);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            ContentValues contentValues = new ContentValues();
            contentValues.put("group_id", str);
            contentValues.put("group_member_operation", (Integer) 1);
            String string = jSONObject.getString(DeviceInfoUtil.UID_TAG);
            contentValues.put("name", string);
            String strOptString = jSONObject.optString("nickname");
            if (!TextUtils.isEmpty(strOptString)) {
                contentValues.put("nick_name", strOptString);
            }
            contentValues.put(bt.s, jSONObject.optString("displayName"));
            String strOptString2 = jSONObject.optString("headIconUrl");
            if (!TextUtils.isEmpty(strOptString2)) {
                contentValues.put("head_icon_url", strOptString2);
            }
            if (string.equals(str2)) {
                contentValues.put("is_owner", (Integer) 1);
            } else {
                contentValues.put("is_owner", (Integer) 0);
            }
            String strOptString3 = jSONObject.optString("nickPyQuanPin");
            if (!TextUtils.isEmpty(strOptString3)) {
                contentValues.put("nick_name_all_pinyin", strOptString3);
            }
            String strOptString4 = jSONObject.optString("nickPyInitial");
            if (!TextUtils.isEmpty(strOptString4)) {
                contentValues.put("nick_name_first_pinyin", strOptString4);
            }
            String strOptString5 = jSONObject.optString("account");
            if (!TextUtils.isEmpty(strOptString5)) {
                contentValues.put("extra_data1", strOptString5);
            }
            String strOptString6 = jSONObject.optString(bd.h);
            if (!TextUtils.isEmpty(strOptString6)) {
                contentValues.put("extra_data2", strOptString6);
            }
            JSONObject jSONObject2 = new JSONObject();
            int iOptInt = jSONObject.optInt("roleType", -1);
            if (iOptInt != -1) {
                jSONObject2.put("roleType", iOptInt);
                contentValues.put("extra_data3", jSONObject2.toString());
            }
            int iOptInt2 = jSONObject.optInt("muteStatus", -1);
            if (iOptInt2 != -1) {
                jSONObject2.put("muteStatus", iOptInt2);
                contentValues.put("extra_data3", jSONObject2.toString());
            }
            String strOptString7 = jSONObject.optString("roomRemark", "");
            if (!TextUtils.isEmpty(strOptString7)) {
                jSONObject2.put("roomRemark", strOptString7);
                contentValues.put("extra_data3", jSONObject2.toString());
            }
            contentValues.put("extra_json", jSONObject.optString("ext"));
            arrayList.add(contentValues);
        }
        return (ContentValues[]) arrayList.toArray(new ContentValues[1]);
    }

    public static void g(JSONObject jSONObject, Long l) throws JSONException {
        ContentValues contentValues;
        ArrayList arrayList = new ArrayList();
        ContentValues[] contentValuesArrB = b(jSONObject);
        ContentValues[] contentValuesArrA = a(jSONObject);
        ContentValues[] contentValuesArrC = c(jSONObject);
        if (contentValuesArrB != null) {
            arrayList.addAll(Arrays.asList(contentValuesArrB));
        }
        if (contentValuesArrA != null) {
            arrayList.addAll(Arrays.asList(contentValuesArrA));
        }
        if (contentValuesArrC != null) {
            arrayList.addAll(Arrays.asList(contentValuesArrC));
        }
        if (arrayList.size() > 0) {
            Collections.sort(arrayList, new a());
            contentValues = (ContentValues) arrayList.get(arrayList.size() - 1);
        } else {
            contentValues = null;
        }
        ContentValues contentValuesA = ap4.a(contentValues, l, "4");
        if (contentValuesA != null) {
            arrayList.add(contentValuesA);
        }
        if (arrayList.size() > 0) {
            dv.c("processGroupFromJson", DBUriManager.a(ye2.class, 0), (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]), true);
        }
    }
}
