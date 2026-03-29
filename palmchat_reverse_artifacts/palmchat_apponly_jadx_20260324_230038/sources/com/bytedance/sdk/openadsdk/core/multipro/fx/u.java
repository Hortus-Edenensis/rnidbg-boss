package com.bytedance.sdk.openadsdk.core.multipro.fx;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.bc.u.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.multipro.pn;
import com.huawei.hms.ads.ex;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements nr.u {
    private Context u;

    public static String b() {
        return b("maxAggRit");
    }

    public static boolean fx(String str) {
        if (dw.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverPn = pn();
            if (contentResolverPn != null) {
                return ex.Code.equals(contentResolverPn.getType(Uri.parse(iz() + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private Context getContext() {
        Context context = this.u;
        return context == null ? dw.getContext() : context;
    }

    private static String iz() {
        return pn.nr + "/t_frequent/";
    }

    public static boolean nr(String str) {
        return u(str, "checkAggFrequency");
    }

    private static ContentResolver pn() {
        try {
            if (dw.getContext() != null) {
                return dw.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean u(String str) {
        return u(str, "checkFrequency");
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public String getTableName() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public String getType(Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.my.pn.u().u(uri.getQueryParameter("rit")) ? ex.Code : ex.V;
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.my.pn.u().b() ? ex.Code : ex.V;
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.my.pn.u().pn();
        }
        if ("checkAggFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.my.u.u().u(uri.getQueryParameter("rit")) ? ex.Code : ex.V;
        }
        if ("isAggSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.my.u.u().b() ? ex.Code : ex.V;
        }
        if ("maxAggRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.my.u.u().pn();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public void injectContext(Context context) {
        this.u = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static String b(String str) {
        if (dw.getContext() == null) {
            return null;
        }
        try {
            ContentResolver contentResolverPn = pn();
            if (contentResolverPn != null) {
                return contentResolverPn.getType(Uri.parse(iz() + str));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean nr() {
        return fx("isAggSilent");
    }

    public static boolean u(String str, String str2) {
        if (dw.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverPn = pn();
            if (contentResolverPn != null) {
                return ex.Code.equals(contentResolverPn.getType(Uri.parse(iz() + str2 + "?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String fx() {
        return b("maxRit");
    }

    public static boolean u() {
        return fx("isSilent");
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public void init() {
    }
}
