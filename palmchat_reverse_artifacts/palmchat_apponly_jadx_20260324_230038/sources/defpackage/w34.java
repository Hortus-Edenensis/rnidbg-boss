package defpackage;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class w34 {
    @TargetApi(11)
    public static String a(Context context, String str, Uri uri) {
        try {
            String strH = rv2.h("cBEuCuv+AtdlTcgTe9OgSQ==");
            if (TextUtils.isEmpty(strH)) {
                return "";
            }
            int i = Build.VERSION.SDK_INT;
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
            Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call(strH, str, null);
            if (i >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            } else {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            if (bundleCall.getInt("code", -1) != 0) {
                return bundleCall.getString("message");
            }
            String string = bundleCall.getString("id");
            p63.a("NubiaIdManager", "succeed:" + string);
            return string;
        } catch (Throwable th) {
            p63.f("NubiaIdManager", "get ids-aa err:" + th.getMessage());
            return null;
        }
    }

    @TargetApi(11)
    public static String b(Context context, Uri uri) {
        try {
            String strH = rv2.h("Oi3ZFT8+schQHSyFZbsdUg==");
            if (TextUtils.isEmpty(strH)) {
                return "";
            }
            int i = Build.VERSION.SDK_INT;
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
            Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call(strH, null, null);
            if (i >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            } else {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            if (bundleCall.getInt("code", -1) != 0) {
                return bundleCall.getString("message");
            }
            String string = bundleCall.getString("id");
            p63.a("NubiaIdManager", "succeed:" + string);
            return string;
        } catch (Exception e) {
            p63.f("NubiaIdManager", "get ids-o err:" + e.getMessage());
            return null;
        }
    }

    @TargetApi(11)
    public static String c(Context context, String str, Uri uri) {
        try {
            String strH = rv2.h("fIdCW1auJ/CZh7w78TbJVQ==");
            if (TextUtils.isEmpty(strH)) {
                return "";
            }
            int i = Build.VERSION.SDK_INT;
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
            Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call(strH, str, null);
            if (i >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            } else {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
            if (bundleCall.getInt("code", -1) != 0) {
                return bundleCall.getString("message");
            }
            String string = bundleCall.getString("id");
            p63.a("NubiaIdManager", "succeed:" + string);
            return string;
        } catch (Throwable th) {
            p63.f("NubiaIdManager", "get ids-va err:" + th.getMessage());
            return null;
        }
    }
}
