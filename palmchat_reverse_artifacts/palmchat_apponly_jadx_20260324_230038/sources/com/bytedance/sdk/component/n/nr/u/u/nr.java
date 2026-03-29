package com.bytedance.sdk.component.n.nr.u.u;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.n.u.pn;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static int delete(Context context, String str, String str2, String[] strArr, pn pnVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return u.u(context).u().delete(pnVar, str, str2, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void insert(Context context, String str, ContentValues contentValues, pn pnVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            u.u(context).u().insert(pnVar, str, (String) null, contentValues);
        } catch (Throwable unused) {
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, pn pnVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return u.u(context).u().query(pnVar, str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String u(Context context, String str, pn pnVar) {
        if (TextUtils.isEmpty(str)) {
            return "sql is null";
        }
        try {
            u.u(context).u().u(pnVar, Uri.decode(str));
            return "execSql ok";
        } catch (Throwable th) {
            return "exec sql exception:" + th.getMessage();
        }
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr, pn pnVar) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return u.u(context).u().update(pnVar, str, contentValues, str2, strArr);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static void insert(Context context, String str, List<com.bytedance.sdk.component.n.u.nr> list, pn pnVar) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            u.u(context).u().insert(pnVar, str, (String) null, list);
        } catch (Throwable unused) {
        }
    }
}
