package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ie2 {
    public static ContactInfoItem a(Cursor cursor) {
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(cursor.getString(cursor.getColumnIndex("name")));
        contactInfoItem.setExid(cursor.getString(cursor.getColumnIndex("extra_data2")));
        contactInfoItem.setRemarkName(cursor.getString(cursor.getColumnIndex("remark_name")));
        contactInfoItem.setRemarkFirstPinyin(cursor.getString(cursor.getColumnIndex("remark_name_first_pinyin")));
        contactInfoItem.setRemarkAllPinyin(cursor.getString(cursor.getColumnIndex("remark_name_all_pinyin")));
        contactInfoItem.setGroupRemarkName(cursor.getString(cursor.getColumnIndex(bt.s)));
        contactInfoItem.setNickName(cursor.getString(cursor.getColumnIndex("nick_name")));
        contactInfoItem.setFirstPinyin(cursor.getString(cursor.getColumnIndex("nick_name_first_pinyin")));
        contactInfoItem.setAllPinyin(cursor.getString(cursor.getColumnIndex("nick_name_all_pinyin")));
        contactInfoItem.setIconURL(cursor.getString(cursor.getColumnIndex("head_icon_url")));
        contactInfoItem.setIsGroupOwner(cursor.getInt(cursor.getColumnIndex("is_owner")));
        String string = cursor.getString(cursor.getColumnIndex("extra_data3"));
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                contactInfoItem.setRoleType(jSONObject.optInt("roleType", 3));
                contactInfoItem.setMuteStatus(jSONObject.optInt("muteStatus", 0));
                contactInfoItem.setRoomRemark(jSONObject.optString("roomRemark", ""));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        contactInfoItem.setExt((ContactExtBean) az2.a(cursor.getString(cursor.getColumnIndex("extra_json")), ContactExtBean.class));
        return contactInfoItem;
    }

    public static void b(ContactInfoItem contactInfoItem) {
        String str;
        boolean z;
        String uid = contactInfoItem.getUid();
        String nickName = contactInfoItem.getNickName();
        String iconURL = contactInfoItem.getIconURL();
        String remarkName = contactInfoItem.getRemarkName();
        String remarkAllPinyin = contactInfoItem.getRemarkAllPinyin();
        String remarkFirstPinyin = contactInfoItem.getRemarkFirstPinyin();
        String allPinyin = contactInfoItem.getAllPinyin();
        String firstPinyin = contactInfoItem.getFirstPinyin();
        String groupRemarkName = contactInfoItem.getGroupRemarkName();
        String account = contactInfoItem.getAccount();
        String[] strArr = {uid};
        ContentResolver contentResolver = AppContext.getContext().getContentResolver();
        Uri uri = je2.f18392a;
        Cursor cursorQuery = contentResolver.query(uri, null, "name=?", strArr, null);
        ContentValues contentValues = new ContentValues();
        boolean z2 = false;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext()) {
                    str = "name=?";
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("nick_name"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("head_icon_url"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(bt.s));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("remark_name"));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("remark_name_all_pinyin"));
                    String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("remark_name_first_pinyin"));
                    String string7 = cursorQuery.getString(cursorQuery.getColumnIndex("nick_name_all_pinyin"));
                    String string8 = cursorQuery.getString(cursorQuery.getColumnIndex("nick_name_first_pinyin"));
                    String string9 = cursorQuery.getString(cursorQuery.getColumnIndex("extra_data1"));
                    if (TextUtils.isEmpty(nickName) || nickName.equals(string)) {
                        z = false;
                    } else {
                        contentValues.put("nick_name", nickName);
                        z = true;
                    }
                    if (!TextUtils.isEmpty(iconURL) && !iconURL.equals(string2)) {
                        contentValues.put("head_icon_url", iconURL);
                        z = true;
                    }
                    if (!TextUtils.isEmpty(groupRemarkName) && !groupRemarkName.equals(string3)) {
                        contentValues.put(bt.s, groupRemarkName);
                        z = true;
                    }
                    if (!TextUtils.isEmpty(remarkName) && !remarkName.equals(string4)) {
                        contentValues.put("remark_name", remarkName);
                        z = true;
                    }
                    if (!TextUtils.isEmpty(remarkAllPinyin) && !remarkAllPinyin.equals(string5)) {
                        contentValues.put("remark_name_all_pinyin", remarkAllPinyin);
                        z = true;
                    }
                    if (!TextUtils.isEmpty(remarkFirstPinyin) && !remarkFirstPinyin.equals(string6)) {
                        contentValues.put("remark_name_first_pinyin", remarkFirstPinyin);
                        z = true;
                    }
                    if (!TextUtils.isEmpty(allPinyin) && !allPinyin.equals(string7)) {
                        contentValues.put("nick_name_all_pinyin", allPinyin);
                        z = true;
                    }
                    if (!TextUtils.isEmpty(firstPinyin) && !firstPinyin.equals(string8)) {
                        contentValues.put("nick_name_first_pinyin", firstPinyin);
                        z = true;
                    }
                    if (!TextUtils.isEmpty(account) && !account.equals(string9)) {
                        contentValues.put("extra_data1", account);
                        z = true;
                    }
                } else {
                    str = "name=?";
                    z = false;
                }
            } finally {
                cursorQuery.close();
            }
        } else {
            str = "name=?";
            z = false;
        }
        if (z) {
            AppContext.getContext().getContentResolver().update(uri, contentValues, str, strArr);
        }
        String[] strArr2 = {contactInfoItem.getUid()};
        ContentResolver contentResolver2 = AppContext.getContext().getContentResolver();
        Uri uri2 = ho0.f18003a;
        Cursor cursorQuery2 = contentResolver2.query(uri2, null, "uid=?", strArr2, null);
        if (cursorQuery2 != null) {
            boolean z3 = cursorQuery2.getCount() > 0;
            cursorQuery2.close();
            z2 = z3;
        }
        if (z2) {
            return;
        }
        AppContext.getContext().getContentResolver().insert(uri2, nn0.a(contactInfoItem));
    }

    public static void c(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("remark_name", str2);
        AppContext.getContext().getContentResolver().update(je2.f18392a, contentValues, "name=?", new String[]{str});
    }
}
