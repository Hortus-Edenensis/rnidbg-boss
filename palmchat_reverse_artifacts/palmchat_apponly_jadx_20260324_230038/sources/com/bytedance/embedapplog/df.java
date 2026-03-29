package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class df {
    private static String nr(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            ti.nr(e);
            activeNetworkInfo = null;
        } catch (Throwable unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (1 == type) {
            return "wifi";
        }
        if (type != 0) {
            return null;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
        }
        return null;
    }

    public static String u(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesNr = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context, "applog_net_cache.dat", 0);
        if (System.currentTimeMillis() - sharedPreferencesNr.getLong("start_mills", 0L) < 900000) {
            String string = sharedPreferencesNr.getString(bt.Q, null);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        String strNr = nr(context);
        SharedPreferences.Editor editorEdit = sharedPreferencesNr.edit();
        if (!TextUtils.isEmpty(strNr)) {
            editorEdit.putString(bt.Q, strNr);
        }
        editorEdit.putLong("start_mills", System.currentTimeMillis());
        editorEdit.apply();
        return strNr;
    }
}
