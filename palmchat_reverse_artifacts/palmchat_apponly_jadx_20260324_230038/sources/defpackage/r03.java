package defpackage;

import android.database.Cursor;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.dating.bean.DatingGroupToolBeans;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class r03 implements ml2 {
    public static List<ContactInfoItem> f(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            ContactInfoItem contactInfoItemA = ie2.a(cursor);
            if (contactInfoItemA.getIsGroupOwner() == 1) {
                arrayList.add(0, contactInfoItemA);
            } else {
                arrayList.add(contactInfoItemA);
            }
        }
        return arrayList;
    }

    public static GroupInfoItem g(Cursor cursor) {
        GroupInfoItem groupInfoItem = new GroupInfoItem();
        groupInfoItem.setGroupId(cursor.getString(cursor.getColumnIndex("group_id")));
        groupInfoItem.setGroupOwner(cursor.getString(cursor.getColumnIndex("owner")));
        groupInfoItem.setGroupName(cursor.getString(cursor.getColumnIndex("name")));
        groupInfoItem.setGroupLocalName(cursor.getString(cursor.getColumnIndex("local_name")));
        groupInfoItem.setGroupHeadImgUrl(cursor.getString(cursor.getColumnIndex("headImgUrl")));
        groupInfoItem.setGroupType(cursor.getInt(cursor.getColumnIndex("type")));
        String string = cursor.getString(cursor.getColumnIndex("group_extra_info"));
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                groupInfoItem.setRoomType(jSONObject.optInt("roomType", 0));
                groupInfoItem.setCover(jSONObject.optString("cover", ""));
                groupInfoItem.setRecmdSwitch(jSONObject.optInt("recmdSwitch", 1));
                groupInfoItem.setAddFriendSwitch(jSONObject.optInt("addFriendSwitch", 1));
                groupInfoItem.setAccessSwitch(jSONObject.optInt("accessSwitch", 1));
                groupInfoItem.setDiffuse(jSONObject.optInt("diffuse", 0));
                groupInfoItem.setApplyStatus(jSONObject.optInt("applyStatus", 0));
                groupInfoItem.setShowHisSwitch(jSONObject.optInt("showHisSwitch", 1));
                groupInfoItem.setRoleType(jSONObject.optInt("roleType", 3));
                groupInfoItem.setPlace(jSONObject.optString("place", ""));
                groupInfoItem.setRnumber(jSONObject.optString("rnumber", ""));
                groupInfoItem.setCateName(jSONObject.optString("cateName", ""));
                groupInfoItem.setDescribe(jSONObject.optString("describe", ""));
                groupInfoItem.setRemarkName(jSONObject.optString("remarkName", ""));
                groupInfoItem.setWelContent(jSONObject.optString(" welContent", ""));
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tagNames");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    String[] strArr = new String[jSONArrayOptJSONArray.length()];
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        strArr[i] = jSONArrayOptJSONArray.optString(i);
                    }
                    groupInfoItem.setTagNames(strArr);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("tags");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    String[] strArr2 = new String[jSONArrayOptJSONArray2.length()];
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                        if (jSONObject2 == null || !jSONObject2.has("tagName")) {
                            strArr2[i2] = "";
                        } else {
                            strArr2[i2] = jSONObject2.optString("tagName");
                        }
                    }
                    groupInfoItem.setTags(strArr2);
                }
                groupInfoItem.setCreateTimestamp(jSONObject.optLong("createTimestamp", 0L));
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("tools");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    DatingGroupToolBeans datingGroupToolBeans = new DatingGroupToolBeans();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray3.getJSONObject(i3);
                        DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = new DatingGroupToolBeans.DatingGroupToolBean();
                        String strOptString = jSONObject3.optString("id");
                        String strOptString2 = jSONObject3.optString("toolName");
                        String strOptString3 = jSONObject3.optString("icon");
                        String strOptString4 = jSONObject3.optString("toolPage");
                        int iOptInt = jSONObject3.optInt("isSystem", 0);
                        int iOptInt2 = jSONObject3.optInt("systemToolClass", 0);
                        datingGroupToolBean.setId(strOptString);
                        datingGroupToolBean.setToolName(strOptString2);
                        datingGroupToolBean.setIcon(strOptString3);
                        datingGroupToolBean.setToolPage(strOptString4);
                        datingGroupToolBean.setIsSystem(iOptInt);
                        datingGroupToolBean.setSystemToolClass(iOptInt2);
                        datingGroupToolBeans.addToolsBean(datingGroupToolBean);
                    }
                    groupInfoItem.setTools(datingGroupToolBeans);
                }
            } catch (Exception unused) {
            }
        }
        groupInfoItem.setGroupExInfo(string);
        return groupInfoItem;
    }

    @Override // defpackage.ml2
    public List<ContactInfoItem> a(String str, int i) throws Throwable {
        Cursor cursorQuery;
        Throwable th;
        ArrayList arrayList;
        List<ContactInfoItem> listF;
        String[] strArr = {str, Integer.toString(0)};
        Cursor cursor = null;
        ArrayList arrayList2 = null;
        try {
            cursorQuery = AppContext.getContext().getContentResolver().query(je2.f18392a, null, "group_id=? and group_member_state=?", strArr, null);
            if (cursorQuery != null) {
                try {
                    try {
                        listF = f(cursorQuery);
                        arrayList = new ArrayList();
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } catch (Exception unused) {
                    arrayList = null;
                }
                try {
                    for (ContactInfoItem contactInfoItem : listF) {
                        if (contactInfoItem.getRoleType() == i) {
                            arrayList.add(contactInfoItem);
                        }
                    }
                    arrayList2 = arrayList;
                } catch (Exception unused2) {
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
            }
            if (cursorQuery == null) {
                return arrayList2;
            }
            cursorQuery.close();
            return arrayList2;
        } catch (Exception unused3) {
            arrayList = null;
        } catch (Throwable th3) {
            cursorQuery = null;
            th = th3;
        }
    }

    @Override // defpackage.ml2
    public List<ContactInfoItem> b(String str) throws Throwable {
        Cursor cursorQuery;
        Throwable th;
        String[] strArr = {str, Integer.toString(0)};
        List<ContactInfoItem> listF = null;
        try {
            cursorQuery = AppContext.getContext().getContentResolver().query(je2.f18392a, null, "group_id=? and group_member_state=?", strArr, null);
            if (cursorQuery != null) {
                try {
                    listF = f(cursorQuery);
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                    }
                    return listF;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        } catch (Throwable th3) {
            cursorQuery = null;
            th = th3;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return listF;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054 A[PHI: r9
      0x0054: PHI (r9v3 android.database.Cursor) = (r9v2 android.database.Cursor), (r9v6 android.database.Cursor) binds: [B:27:0x0052, B:20:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.ml2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ContactInfoItem c(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        String[] strArr = {str, Integer.toString(0), str2};
        Cursor cursor = null;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                cursorQuery = null;
            } else {
                cursorQuery = AppContext.getContext().getContentResolver().query(je2.f18392a, null, "group_id=? and group_member_state=? and name=?", strArr, null);
                if (cursorQuery != null) {
                    try {
                        List<ContactInfoItem> listF = f(cursorQuery);
                        if (listF != null && !listF.isEmpty()) {
                            ContactInfoItem contactInfoItem = listF.get(0);
                            cursorQuery.close();
                            return contactInfoItem;
                        }
                    } catch (Exception unused) {
                        if (cursorQuery != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    @Override // defpackage.ml2
    public GroupInfoItem d(String str) throws Throwable {
        Cursor cursorQuery;
        Throwable th;
        String[] strArr = {str};
        GroupInfoItem groupInfoItemG = null;
        try {
            cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ye2.class, 0), null, "group_id=?", strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        groupInfoItemG = g(cursorQuery);
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                    }
                    return groupInfoItemG;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        } catch (Throwable th3) {
            cursorQuery = null;
            th = th3;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return groupInfoItemG;
    }

    @Override // defpackage.ml2
    public List<ContactInfoItem> e(String str) throws Throwable {
        Cursor cursorQuery;
        Throwable th;
        ArrayList arrayList;
        List<ContactInfoItem> listF;
        String[] strArr = {str, Integer.toString(0)};
        Cursor cursor = null;
        ArrayList arrayList2 = null;
        try {
            cursorQuery = AppContext.getContext().getContentResolver().query(je2.f18392a, null, "group_id=? and group_member_state=?", strArr, null);
            if (cursorQuery != null) {
                try {
                    try {
                        listF = f(cursorQuery);
                        arrayList = new ArrayList();
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } catch (Exception unused) {
                    arrayList = null;
                }
                try {
                    for (ContactInfoItem contactInfoItem : listF) {
                        if (contactInfoItem.getMuteStatus() == 1) {
                            arrayList.add(contactInfoItem);
                        }
                    }
                    arrayList2 = arrayList;
                } catch (Exception unused2) {
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
            }
            if (cursorQuery == null) {
                return arrayList2;
            }
            cursorQuery.close();
            return arrayList2;
        } catch (Exception unused3) {
            arrayList = null;
        } catch (Throwable th3) {
            cursorQuery = null;
            th = th3;
        }
    }
}
