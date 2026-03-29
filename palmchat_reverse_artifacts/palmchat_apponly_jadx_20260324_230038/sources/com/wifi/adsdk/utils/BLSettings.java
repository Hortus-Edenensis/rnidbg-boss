package com.wifi.adsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.framework.common.ContainerUtils;
import com.wifi.adsdk.LxAdManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BLSettings {
    public static String getParamByUrl(String str, String str2) {
        Matcher matcher = Pattern.compile("(\\?|&){1}#{0,1}" + str2 + "=[a-zA-Z0-9]*(&{1})").matcher(str + ContainerUtils.FIELD_DELIMITER);
        if (!matcher.find()) {
            return null;
        }
        System.out.println(matcher.group(0));
        return matcher.group(0).split(ContainerUtils.KEY_VALUE_DELIMITER)[1].replace(ContainerUtils.FIELD_DELIMITER, "");
    }

    public static String getStringValue(String str, String str2) {
        return getStringValue(LxAdManager.getAdManager().getContext().getPackageName(), str, str2);
    }

    public static boolean setStringValue(String str, String str2) {
        return setStringValue(LxAdManager.getAdManager().getContext().getPackageName(), str, str2);
    }

    public static String getStringValue(String str, String str2, String str3) {
        return getStringValue(LxAdManager.getAdManager().getContext(), str, str2, str3);
    }

    public static boolean setStringValue(String str, String str2, String str3) {
        return setStringValue(LxAdManager.getAdManager().getContext(), str, str2, str3);
    }

    public static String getStringValue(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public static boolean setStringValue(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        return editorEdit.commit();
    }
}
