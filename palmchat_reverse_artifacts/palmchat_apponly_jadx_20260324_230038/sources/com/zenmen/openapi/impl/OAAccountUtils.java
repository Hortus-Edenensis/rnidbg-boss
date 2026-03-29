package com.zenmen.openapi.impl;

import android.database.Cursor;
import android.net.Uri;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.openapi.OpenApiManager;
import defpackage.o44;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class OAAccountUtils {
    public static final Uri CONTENT_URI = Uri.parse("content://com.zenmen.palmchat.social.provider/tb_contacts");
    public static String INFO_TYPE_SID = "getSid";
    public static String INFO_TYPE_TOKEN = "getToken";
    public static String INFO_TYPE_UID = "getUid";

    public static Map<String, String> getPublicParams(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(DeviceInfoUtil.UID_TAG, getUid());
        map.put("token", getToken());
        map.put(WkParams.SESSIONID, getSid());
        return map;
    }

    public static String getSid() {
        return getUserInfo(INFO_TYPE_SID);
    }

    public static String getToken() {
        return getUserInfo(INFO_TYPE_TOKEN);
    }

    public static String getUid() {
        return getUserInfo(INFO_TYPE_UID);
    }

    public static String getUserInfo(String str) {
        return OpenApiManager.getUserInfo(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060 A[PHI: r9
      0x0060: PHI (r9v7 android.database.Cursor) = (r9v6 android.database.Cursor), (r9v8 android.database.Cursor) binds: [B:19:0x005e, B:12:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static o44 getUserProfile(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        try {
            cursorQuery = OpenApiManager.getContext().getContentResolver().query(CONTENT_URI, null, "uid=?", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            o44 o44Var = new o44();
                            o44Var.d(cursorQuery.getString(cursorQuery.getColumnIndex("head_img_url")));
                            o44Var.e(cursorQuery.getString(cursorQuery.getColumnIndex("mobile")));
                            o44Var.f(cursorQuery.getString(cursorQuery.getColumnIndex("nick_name")));
                            cursorQuery.close();
                            return o44Var;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (cursorQuery != null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
            if (cursorQuery != null) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }
}
