package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class p86 {
    public static String a(String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter(str2, str3);
        return builderBuildUpon.build().toString();
    }

    public static String b(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (map == null || map.isEmpty()) {
            return str;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("url");
        if (TextUtils.isEmpty(queryParameter)) {
            return str;
        }
        return a(e(str, "url"), "url", c(queryParameter, map));
    }

    public static String c(String str, Map<String, String> map) {
        if (str.startsWith("https%3") || !str.startsWith("http%3")) {
            str = URLDecoder.decode(str);
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builderBuildUpon.build().toString();
    }

    public static String d(Map<String, String> map, String str) {
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String e(String str, String str2) {
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("\\?");
        if (strArrSplit != null && strArrSplit.length > 0) {
            str3 = strArrSplit[0] + Constants.STRING_VALUE_UNSET;
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        Map<String, String> mapF = f(str);
        mapF.remove(str2);
        return d(mapF, str3);
    }

    public static Map<String, String> f(String str) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && str.split("\\?").length > 1 && (strArrSplit = str.split("\\?")[1].split(ContainerUtils.FIELD_DELIMITER)) != null && strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (strArrSplit2 != null) {
                    map.put(strArrSplit2.length > 0 ? strArrSplit2[0] : "", strArrSplit2.length > 1 ? strArrSplit2[1] : "");
                }
            }
        }
        return map;
    }
}
