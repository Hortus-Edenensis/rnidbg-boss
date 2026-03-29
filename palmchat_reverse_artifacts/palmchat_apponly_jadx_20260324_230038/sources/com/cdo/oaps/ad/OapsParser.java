package com.cdo.oaps.ad;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class OapsParser {
    private static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return URLEncoder.encode(obj.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String b(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return URLDecoder.decode(obj.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Map<String, Object> decode(String str) {
        Uri uri;
        HashMap map = new HashMap();
        try {
            if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && !TextUtils.isEmpty(uri.getScheme()) && !TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
                OapsWrapper path = OapsWrapper.wrapper((Map<String, Object>) map).setScheme(uri.getScheme()).setHost(uri.getHost()).setPath(uri.getPath());
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                    for (String str2 : queryParameterNames) {
                        if (!TextUtils.isEmpty(str2)) {
                            path.set(str2, uri.getQueryParameter(str2));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return map;
    }

    public static String encode(Map<String, Object> map) {
        OapsWrapper oapsWrapperWrapper = OapsWrapper.wrapper(map);
        if (TextUtils.isEmpty(oapsWrapperWrapper.getScheme()) || TextUtils.isEmpty(oapsWrapperWrapper.getHost()) || TextUtils.isEmpty(oapsWrapperWrapper.getPath())) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(oapsWrapperWrapper.getScheme());
        sb.append("://");
        sb.append(oapsWrapperWrapper.getHost());
        sb.append(oapsWrapperWrapper.getPath());
        Map<String, Object> params = oapsWrapperWrapper.getParams();
        if (params != null && params.size() > 0) {
            sb.append(Constants.STRING_VALUE_UNSET);
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (sb.charAt(sb.length() - 1) != '?') {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb.append(entry.getKey());
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(a(entry.getValue()));
            }
        }
        return sb.toString();
    }
}
