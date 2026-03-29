package com.zenmen.palmchat.conversations.threadgroup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.conversations.threadgroup.ThreadFolderManager;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.ho3;
import defpackage.vh5;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static ThreadFolderManager.FolderType a(int i) {
        for (ThreadFolderManager.FolderType folderType : ThreadFolderManager.FolderType.values()) {
            for (Integer num : folderType.bizTypes) {
                if (num.intValue() == i) {
                    return folderType;
                }
            }
            Pair<Integer, Integer> pair = folderType.region;
            if (pair != null && ((Integer) pair.first).intValue() <= i && i <= ((Integer) folderType.region.second).intValue()) {
                return folderType;
            }
        }
        return null;
    }

    public static ThreadFolderManager.FolderType b(int i) {
        for (ThreadFolderManager.FolderType folderType : ThreadFolderManager.FolderType.values()) {
            if (folderType.groupBizType == i) {
                return folderType;
            }
        }
        return null;
    }

    public static int c(int i) {
        ThreadFolderManager.FolderType folderTypeA = a(i);
        if (folderTypeA == null) {
            return -1;
        }
        return folderTypeA.groupBizType;
    }

    public static boolean d() {
        return true;
    }

    public static boolean e(int i) {
        ThreadFolderManager.FolderType folderTypeA = a(i);
        return folderTypeA != null && folderTypeA.enable();
    }

    public static boolean f(int i) {
        ThreadFolderManager.FolderType folderTypeB = b(i);
        return folderTypeB != null && folderTypeB.enable();
    }

    public static void g(Context context, int i, vh5 vh5Var) throws Throwable {
        int iC = c(i);
        if (iC != -1) {
            h(context, vh5Var, iC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f8 A[PHI: r1 r2 r9 r43
      0x01f8: PHI (r1v24 java.lang.String) = (r1v23 java.lang.String), (r1v28 java.lang.String) binds: [B:55:0x01f6, B:44:0x01e3] A[DONT_GENERATE, DONT_INLINE]
      0x01f8: PHI (r2v16 android.database.Cursor) = (r2v15 android.database.Cursor), (r2v21 android.database.Cursor) binds: [B:55:0x01f6, B:44:0x01e3] A[DONT_GENERATE, DONT_INLINE]
      0x01f8: PHI (r9v6 org.json.JSONObject) = (r9v5 org.json.JSONObject), (r9v9 org.json.JSONObject) binds: [B:55:0x01f6, B:44:0x01e3] A[DONT_GENERATE, DONT_INLINE]
      0x01f8: PHI (r43v4 java.lang.String) = (r43v3 java.lang.String), (r43v7 java.lang.String) binds: [B:55:0x01f6, B:44:0x01e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02d0  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(Context context, vh5 vh5Var, int i) throws Throwable {
        String str;
        String str2;
        String str3;
        Cursor cursor;
        String str4;
        ContentValues contentValues;
        boolean z;
        int i2;
        String str5;
        String[] strArr;
        String str6;
        String str7;
        JSONObject jSONObject;
        Cursor cursorG;
        if (!f(i)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb.append("thread_active");
        sb.append("=? and ");
        arrayList.add(String.valueOf(1));
        sb.append("thread_blacklist");
        sb.append("=? and ");
        arrayList.add(String.valueOf(0));
        sb.append("thread_contact_ready");
        sb.append("=? and ");
        arrayList.add(String.valueOf(1));
        ThreadFolderManager.b(sb, arrayList, i, false);
        Cursor cursorG2 = vh5Var.g("tb_threads", null, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, null, "thread_priority DESC , thread_draft_time DESC , latest_message_time_stamp DESC");
        ContentValues contentValues2 = new ContentValues();
        while (cursorG2.moveToNext()) {
            String string = cursorG2.getString(cursorG2.getColumnIndex("latest_message"));
            cursorG2.getLong(cursorG2.getColumnIndex("latest_message_time_stamp"));
            ContentValues contentValues3 = contentValues2;
            String string2 = cursorG2.getString(cursorG2.getColumnIndex("thread_draft"));
            long j = cursorG2.getLong(cursorG2.getColumnIndex("thread_draft_time"));
            if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                long j2 = cursorG2.getLong(cursorG2.getColumnIndex("latest_message_time_stamp"));
                int i3 = cursorG2.getInt(cursorG2.getColumnIndex("latest_message_mime_type"));
                int i4 = cursorG2.getInt(cursorG2.getColumnIndex("thread_biz_type"));
                String string3 = cursorG2.getString(cursorG2.getColumnIndex("contact_relate"));
                ThreadChatItem cursor2 = ThreadChatItem.parseCursor(cursorG2);
                boolean zD = d();
                if (cursor2.getChatType() == 0) {
                    strArr = new String[]{string3};
                    str6 = "contact_relate=?";
                    str5 = string;
                } else {
                    str5 = string;
                    if (cursor2.getChatType() == 1) {
                        String str8 = "contact_relate" + com.zenmen.palmchat.database.a.b(zD);
                        StringBuilder sb2 = new StringBuilder();
                        str6 = str8;
                        sb2.append(DomainHelper.e(cursor2));
                        sb2.append(com.zenmen.palmchat.database.a.a(zD));
                        strArr = new String[]{sb2.toString()};
                    } else {
                        strArr = null;
                        str6 = null;
                    }
                }
                String str9 = str5;
                str2 = "latest_message";
                cursor = cursorG2;
                Cursor cursorG3 = vh5Var.g(DBUriManager.h(DBUriManager.b(ho3.class, cursor2)), null, str6, strArr, null, null, "_id DESC limit 1");
                ?? r2 = cursorG3.moveToFirst() ? cursorG3.getInt(cursorG3.getColumnIndex("type")) : 2;
                cursorG3.close();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    try {
                        try {
                            jSONObject2.put("thread_biz_type", i4);
                            if (r2 == 1) {
                                str7 = "thread_biz_type";
                                jSONObject = jSONObject2;
                                try {
                                    cursorG = vh5Var.g("tb_contacts", null, "uid=?", new String[]{string3}, null, null, null);
                                    try {
                                        if (cursorG.moveToFirst()) {
                                            String string4 = cursorG.getString(cursorG.getColumnIndex("remark_name"));
                                            if (TextUtils.isEmpty(string4)) {
                                                jSONObject.put("nick_name", cursorG.getString(cursorG.getColumnIndex("nick_name")));
                                            } else {
                                                jSONObject.put("nick_name", string4);
                                            }
                                        }
                                        str = "";
                                    } catch (JSONException e) {
                                        e = e;
                                        str = "";
                                        e.printStackTrace();
                                        if (cursorG != null) {
                                        }
                                    }
                                } catch (JSONException e2) {
                                    e = e2;
                                    str = "";
                                    cursorG = null;
                                    e.printStackTrace();
                                    if (cursorG != null) {
                                    }
                                    contentValues = contentValues3;
                                    contentValues.put(str7, Integer.valueOf(i));
                                    contentValues.put("contact_relate", Integer.valueOf(i));
                                    z = true;
                                    contentValues.put("thread_active", (Integer) 1);
                                    contentValues.put("thread_blacklist", (Integer) 0);
                                    contentValues.put("thread_contact_ready", (Integer) 1);
                                    contentValues.put("thread_nodisturb", (Integer) 1);
                                    contentValues.put(str2, str9);
                                    contentValues.put("latest_message_time_stamp", Long.valueOf(j2));
                                    contentValues.put("latest_message_mime_type", Integer.valueOf(i3));
                                    str3 = "thread_biz_extension";
                                    contentValues.put(str3, jSONObject.toString());
                                    contentValues.put("thread_draft_time", Long.valueOf(j2));
                                    str4 = "thread_draft";
                                    contentValues.put(str4, string2);
                                    contentValues.put("thread_draft_time", Long.valueOf(j));
                                    Cursor cursor3 = cursor;
                                    if (cursor.moveToFirst()) {
                                    }
                                    cursor3.close();
                                    if (!z) {
                                    }
                                }
                            } else {
                                str7 = "thread_biz_type";
                                jSONObject = jSONObject2;
                                str = "";
                                try {
                                    jSONObject.put("nick_name", str);
                                    cursorG = null;
                                } catch (JSONException e3) {
                                    e = e3;
                                    cursorG = null;
                                    e.printStackTrace();
                                    if (cursorG != null) {
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (r2 != 0) {
                                r2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r2 = 0;
                        if (r2 != 0) {
                        }
                        throw th;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    str7 = "thread_biz_type";
                    jSONObject = jSONObject2;
                }
                if (cursorG != null) {
                    cursorG.close();
                }
                contentValues = contentValues3;
                contentValues.put(str7, Integer.valueOf(i));
                contentValues.put("contact_relate", Integer.valueOf(i));
                z = true;
                contentValues.put("thread_active", (Integer) 1);
                contentValues.put("thread_blacklist", (Integer) 0);
                contentValues.put("thread_contact_ready", (Integer) 1);
                contentValues.put("thread_nodisturb", (Integer) 1);
                contentValues.put(str2, str9);
                contentValues.put("latest_message_time_stamp", Long.valueOf(j2));
                contentValues.put("latest_message_mime_type", Integer.valueOf(i3));
                str3 = "thread_biz_extension";
                contentValues.put(str3, jSONObject.toString());
                contentValues.put("thread_draft_time", Long.valueOf(j2));
                str4 = "thread_draft";
                contentValues.put(str4, string2);
                contentValues.put("thread_draft_time", Long.valueOf(j));
                Cursor cursor32 = cursor;
                if (cursor.moveToFirst()) {
                    i2 = cursor32.getInt(cursor32.getColumnIndex("unread_message_count"));
                    int i5 = 0;
                    while (true) {
                        i2 += i5;
                        if (!cursor32.moveToNext()) {
                            break;
                        } else {
                            i5 = cursor32.getInt(cursor32.getColumnIndex("unread_message_count"));
                        }
                    }
                } else {
                    i2 = 0;
                }
                cursor32.close();
                if (!z) {
                    contentValues.put(str2, str);
                    contentValues.put(str4, str);
                    contentValues.put(str3, str);
                    contentValues.put("unread_message_count", (Integer) 0);
                    contentValues.put("thread_active", (Integer) 0);
                    vh5Var.i("tb_threads", contentValues, "thread_biz_type=" + i, null);
                    return;
                }
                contentValues.put("unread_message_count", Integer.valueOf(i2));
                ContentValues contentValues4 = contentValues;
                Cursor cursorG4 = vh5Var.g("tb_threads", null, "thread_biz_type=" + i, null, null, null, null);
                if (cursorG4 != null) {
                    if (cursorG4.getCount() > 0) {
                        vh5Var.i("tb_threads", contentValues4, "thread_biz_type=" + i, null);
                    } else {
                        vh5Var.f("tb_threads", null, contentValues4);
                    }
                    cursorG4.close();
                    return;
                }
                return;
            }
            contentValues2 = contentValues3;
        }
        str = "";
        str2 = "latest_message";
        str3 = "thread_biz_extension";
        cursor = cursorG2;
        str4 = "thread_draft";
        contentValues = contentValues2;
        z = false;
        Cursor cursor322 = cursor;
        if (cursor.moveToFirst()) {
        }
        cursor322.close();
        if (!z) {
        }
    }
}
