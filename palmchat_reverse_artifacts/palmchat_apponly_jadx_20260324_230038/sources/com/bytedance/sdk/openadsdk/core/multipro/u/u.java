package com.bytedance.sdk.openadsdk.core.multipro.u;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.multipro.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver contentResolverU = u(context);
            if (contentResolverU != null) {
                return contentResolverU.delete(Uri.parse(u(str) + str), str2, strArr);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverU = u(context);
            if (contentResolverU != null) {
                contentResolverU.insert(Uri.parse(u(str) + str), contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContentResolver contentResolverU = u(context);
            if (contentResolverU != null) {
                return contentResolverU.query(Uri.parse(u(str) + str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static ContentResolver u(Context context) {
        if (context == null) {
            try {
                context = dw.getContext();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                ContentResolver contentResolverU = u(context);
                if (contentResolverU != null) {
                    return contentResolverU.update(Uri.parse(u(str) + str), contentValues, str2, strArr);
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    private static String u(String str) {
        return pn.nr + "/t_db/" + (com.bytedance.sdk.openadsdk.core.jk.nr.u(str) ? "ttopensdk2.db" : "ttopensdk.db") + "/";
    }

    public static void u(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverU = u(context);
            if (contentResolverU != null) {
                contentResolverU.getType(Uri.parse(u(str2) + "unknown/execSQL?sql=" + Uri.encode(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
