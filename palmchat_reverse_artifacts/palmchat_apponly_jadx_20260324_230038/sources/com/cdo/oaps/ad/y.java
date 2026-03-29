package com.cdo.oaps.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5467a = "Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI";
    public static final String b = "b3Bwby9sYXVuY2g=";
    public static final String c = "scheme";
    public static final String d = "host";
    public static final String e = "params";
    public static final String f = "gb";
    public static final String g = "gamecenter";

    private static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static float b(PackageManager packageManager, String str) {
        Bundle bundle;
        String str2 = b(str).get("scheme");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(a(a.b(f5467a), null, str2 + "://", a.b(b), null), 160);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                    return bundle.getFloat("gcsdk_launcher_version", -1.0f);
                }
            }
        }
        return -1.0f;
    }

    private static Intent a(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.addCategory(str2);
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(str3)) {
                intent.setData(Uri.parse(str3));
            }
            if (!TextUtils.isEmpty(str4)) {
                intent.setType(str4);
            }
        } else {
            intent.setDataAndType(Uri.parse(str3), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            intent.setPackage(str5);
        }
        return intent;
    }

    private static Map<String, String> b(String str) {
        int i;
        String strSubstring;
        String[] strArrSplit;
        int iIndexOf = str.indexOf(Constants.STRING_VALUE_UNSET);
        if (iIndexOf == -1) {
            return null;
        }
        String strSubstring2 = str.substring(iIndexOf + 1);
        HashMap map = new HashMap();
        if (strSubstring2 != null && strSubstring2.length() > 0) {
            int i2 = 0;
            while (true) {
                int iIndexOf2 = strSubstring2.indexOf(ContainerUtils.FIELD_DELIMITER, i2) + 1;
                if (iIndexOf2 > 0) {
                    strSubstring = strSubstring2.substring(i2, iIndexOf2 - 1);
                    i = iIndexOf2;
                } else {
                    i = i2;
                    strSubstring = strSubstring2.substring(i2);
                }
                if (strSubstring != null && (strArrSplit = strSubstring.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && strArrSplit.length >= 1) {
                    String strTrim = strArrSplit[0];
                    if (strTrim != null) {
                        strTrim = strTrim.trim();
                    }
                    String strTrim2 = strArrSplit.length == 1 ? "" : strArrSplit[1];
                    if (strTrim2 != null) {
                        strTrim2 = strTrim2.trim();
                    }
                    map.put(strTrim, strTrim2);
                }
                if (iIndexOf2 <= 0) {
                    break;
                }
                i2 = i;
            }
        }
        return map;
    }

    private static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        String str = map.get("scheme");
        String str2 = map.get("host");
        String str3 = map.get("params");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !map.containsKey("params")) {
            return null;
        }
        return str + "://" + str2 + Constants.STRING_VALUE_UNSET + "params" + ContainerUtils.KEY_VALUE_DELIMITER + str3 + ContainerUtils.FIELD_DELIMITER + f + ContainerUtils.KEY_VALUE_DELIMITER + (map.containsKey(f) ? a(map.get(f), 0) : 0);
    }

    private static boolean a(Context context, Intent intent) {
        try {
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str) || !a(str)) {
            return false;
        }
        String strA = a(b(str));
        PackageManager packageManager = context.getPackageManager();
        Intent intentA = a(a.b(f5467a), null, strA, a.b(b), null);
        if (TextUtils.isEmpty(strA) || packageManager == null || !a(packageManager, intentA)) {
            return false;
        }
        return a(context, intentA);
    }

    private static boolean a(PackageManager packageManager, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 32);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    public static boolean a(PackageManager packageManager, String str) {
        Bundle bundle;
        String str2 = b(str).get("scheme");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(a(a.b(f5467a), null, str2 + "://", a.b(b), null), 160);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                    if (bundle.getFloat("gcsdk_launcher_version", -1.0f) > 0.0f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean a(String str) {
        return str.contains("scheme") && str.contains("host") && str.contains("params");
    }
}
