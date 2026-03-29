package com.wifi.ad.core.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.monitor.AesAdUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DeviceUtils {
    public static void callPhone(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getAesRes(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WkParams.IMEI, str);
            jSONObject.put("mac", str2);
            jSONObject.put("aid", str3);
            jSONObject.put("oaid", str4);
            DeviceInfoUtil.INSTANCE.addDeviceInfo(jSONObject);
            String string = jSONObject.toString();
            WifiLog.d("aesStart DeviceUtils " + string);
            return AesAdUtils.encryptAES(string);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getAppMetaDataString(Context context, String str, String str2) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str, str2);
            WifiLog.d(str + " = " + string);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int[] getCurrentNetworkInfo(Context context) {
        return new int[]{-1, -1};
    }

    public static String getPackageName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getScreenHeightPixels(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidthPixels(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String getVersionName(Context context) {
        Exception e;
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e = e2;
            str = "";
        }
        if (str != null) {
            try {
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
            }
            if (str.length() > 0) {
                return str;
            }
        }
        return "";
    }

    public static void startApp(Context context, String str) {
        try {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
