package defpackage;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.oplus.tblplayer.Constants;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class u56 {
    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return !URLUtil.isNetworkUrl(str) ? str : b(str);
        }
        h73.f("UriUtil", "whiteListUrl is null");
        return null;
    }

    @TargetApi(9)
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            h73.f("UriUtil", "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str)) {
                return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
            }
            h73.d("UriUtil", "url don't starts with http or https");
            return "";
        } catch (MalformedURLException e) {
            h73.d("UriUtil", "getHostByURI error  MalformedURLException : " + e.getMessage());
            return "";
        }
    }

    public static boolean c(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            h73.d("UriUtil", "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (d(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.contains("..") && !str.contains("@")) {
                if (!str2.equals(str)) {
                    if (!str.startsWith(str2 + Constants.STRING_VALUE_UNSET)) {
                        if (!str.startsWith(str2 + "#")) {
                            if (!str2.endsWith("/")) {
                                return false;
                            }
                            if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                                return false;
                            }
                            return str.startsWith(str2);
                        }
                    }
                }
                return true;
            }
            Log.e("UriUtil", "url contains unsafe char");
        }
        return false;
    }

    public static boolean e(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            h73.d("UriUtil", "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (f(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(String str, String str2) {
        String strB = b(str);
        if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(str2)) {
            h73.d("UriUtil", "url or whitelist is null");
            return false;
        }
        String strA = a(str2);
        if (TextUtils.isEmpty(strA)) {
            Log.e("UriUtil", "whitelist host is null");
            return false;
        }
        if (strA.equals(strB)) {
            return true;
        }
        if (strB.endsWith(strA)) {
            try {
                String strSubstring = strB.substring(0, strB.length() - strA.length());
                if (strSubstring.endsWith(".")) {
                    return strSubstring.matches("^[A-Za-z0-9.-]+$");
                }
                return false;
            } catch (IndexOutOfBoundsException e) {
                h73.d("UriUtil", "IndexOutOfBoundsException" + e.getMessage());
            } catch (Exception e2) {
                h73.d("UriUtil", "Exception : " + e2.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean g(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return TextUtils.equals(b(str), a(str2));
        }
        Log.e("UriUtil", "isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    public static boolean h(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            h73.d("UriUtil", "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (g(str, str2)) {
                return true;
            }
        }
        return false;
    }
}
