package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class vv6 {
    public static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return URLEncoder.encode(obj.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            h87.d("OapsParser", e);
            return obj.toString();
        }
    }

    public static String b(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        if (!map2.containsKey("scheme") || !map2.containsKey("host") || !map2.containsKey(OapsWrapper.KEY_PATH)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(map2.remove("scheme"));
        sb.append("://");
        sb.append(map2.remove("host"));
        sb.append(map2.remove(OapsWrapper.KEY_PATH));
        if (map2.size() > 0) {
            sb.append(Constants.STRING_VALUE_UNSET);
            for (String str : map2.keySet()) {
                if (sb.charAt(sb.length() - 1) != '?') {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb.append(str);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(a(map2.get(str)));
            }
        }
        return sb.toString();
    }

    public static Map<String, Object> c(String str) {
        Uri uri;
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && !TextUtils.isEmpty(uri.getScheme()) && !TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            map.put("scheme", uri.getScheme());
            map.put("host", uri.getHost());
            map.put(OapsWrapper.KEY_PATH, uri.getPath());
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                for (String str2 : queryParameterNames) {
                    if (!TextUtils.isEmpty(str2)) {
                        map.put(str2, uri.getQueryParameter(str2));
                    }
                }
            }
        }
        return map;
    }
}
