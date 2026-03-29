package com.wifi.adsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.widget.Toast;
import java.net.URISyntaxException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BLUtils {
    public static final int DEEP_CALL_ERROR = 3;
    public static final int DEEP_CALL_NOINSTALL = 2;
    public static final int DEEP_CALL_SUCCESS = 1;
    private static ConnectivityManager conn;
    public static float screenScale;

    public static int dp2px(Context context, float f) {
        if (screenScale == 0.0f) {
            screenScale = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((f * screenScale) + 0.5f);
    }

    private static Intent getHandleIntent(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Intent uri = Intent.parseUri(str, 1);
            if (!isHasAppByIntent(uri, context)) {
                return null;
            }
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.addFlags(268435456);
            uri.setComponent(null);
            uri.setSelector(null);
            return uri;
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static boolean isAppInstalled(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static synchronized boolean isHasAppByIntent(Intent intent, Context context) {
        if (intent == null) {
            return false;
        }
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }

    public static boolean isNetworkConnected(Context context) {
        if (conn == null) {
            conn = (ConnectivityManager) context.getSystemService("connectivity");
        }
        NetworkInfo activeNetworkInfo = conn.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static void show(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static int startDeepUrlActivity(String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent handleIntent = getHandleIntent(str, context);
                if (handleIntent == null) {
                    return 2;
                }
                if (!(context instanceof Activity)) {
                    handleIntent.addFlags(268435456);
                }
                context.startActivity(handleIntent);
                return 1;
            } catch (Exception unused) {
            }
        }
        return 3;
    }
}
