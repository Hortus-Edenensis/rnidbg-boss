package com.bytedance.sdk.openadsdk.core.y;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bc {
    private static URL fx(String str) {
        if (str != null && str.length() != 0 && str.contains("://")) {
            try {
                return new URL(HttpHost.DEFAULT_SCHEME_NAME + str.substring(str.indexOf("://")));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String nr(String str) {
        return str.contains(Constants.STRING_VALUE_UNSET) ? str.substring(0, str.indexOf(Constants.STRING_VALUE_UNSET)) : str;
    }

    public static Map<String, String> u(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        URL urlFx = fx(str);
        if (urlFx == null) {
            return linkedHashMap;
        }
        try {
            String query = urlFx.getQuery();
            if (query == null) {
                return linkedHashMap;
            }
            if (query.contains("url=")) {
                int iIndexOf = query.indexOf("url=");
                linkedHashMap.put("url", URLDecoder.decode(query.substring(iIndexOf + 4), "UTF-8"));
                query = query.substring(0, iIndexOf);
            }
            if (query.length() > 0) {
                for (String str2 : query.split(ContainerUtils.FIELD_DELIMITER)) {
                    int iIndexOf2 = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (iIndexOf2 > 0 && iIndexOf2 < str2.length() - 1) {
                        String strSubstring = str2.substring(0, iIndexOf2);
                        int i = iIndexOf2 + 1;
                        String strSubstring2 = str2.substring(i);
                        if ("live_short_touch_params".equals(strSubstring) || "extra_pangle_scheme_params".equals(strSubstring)) {
                            linkedHashMap.put(URLDecoder.decode(str2.substring(0, iIndexOf2), "UTF-8"), URLDecoder.decode(str2.substring(i), "UTF-8"));
                        } else {
                            linkedHashMap.put(strSubstring, strSubstring2);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return linkedHashMap;
    }

    public static String u(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(nr(str));
        sb.append(Constants.STRING_VALUE_UNSET);
        try {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String value = next.getValue();
                if (it.hasNext()) {
                    if (!"live_short_touch_params".equals(key) && !"extra_pangle_scheme_params".equals(key)) {
                        sb.append(key + ContainerUtils.KEY_VALUE_DELIMITER + value + ContainerUtils.FIELD_DELIMITER);
                    } else {
                        sb.append(URLEncoder.encode(next.getKey(), "UTF-8") + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(next.getValue(), "UTF-8") + ContainerUtils.FIELD_DELIMITER);
                    }
                } else if (!"live_short_touch_params".equals(key) && !"extra_pangle_scheme_params".equals(key)) {
                    sb.append(key + ContainerUtils.KEY_VALUE_DELIMITER + value);
                } else {
                    sb.append(URLEncoder.encode(next.getKey(), "UTF-8") + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(next.getValue(), "UTF-8"));
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }
}
