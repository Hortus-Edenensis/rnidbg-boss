package com.lantern.auth.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.lantern.auth.android.BLPlatform;
import com.lantern.auth.android.BLUtils;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WkPlatform extends BLPlatform {
    public static String getAppId(Context context) {
        Bundle metaData = BLUtils.getMetaData(context);
        String string = metaData != null ? metaData.getString("WK_APP_ID") : null;
        return (string == null || string.length() == 0) ? "A0008" : string;
    }

    public static String getChannelName(Context context) {
        Bundle metaData = BLUtils.getMetaData(context);
        String string = metaData != null ? metaData.getString("DC_CHANNEL") : null;
        return (string == null || string.length() == 0) ? "APP_CHANNEL_NAME" : string;
    }

    public static String getLac(Context context) {
        try {
            CellLocation cellLocation = getTelephonyManager(context).getCellLocation();
            if (cellLocation != null && (cellLocation instanceof GsmCellLocation)) {
                return String.valueOf(((GsmCellLocation) cellLocation).getLac());
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String getLang() {
        String language = Locale.getDefault().getLanguage();
        return (TextUtils.isEmpty(language) || language.equalsIgnoreCase("zh")) ? "cn" : "en";
    }

    public static String getMetaDataString(Context context, String str) {
        Bundle metaData = BLUtils.getMetaData(context);
        String string = metaData != null ? metaData.getString(str) : null;
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getType() == 0 ? "g" : activeNetworkInfo.getType() == 1 ? RXScreenCaptureService.KEY_WIDTH : "" : "";
    }

    public static int getScreenHeightPixels(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidthPixels(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }
}
