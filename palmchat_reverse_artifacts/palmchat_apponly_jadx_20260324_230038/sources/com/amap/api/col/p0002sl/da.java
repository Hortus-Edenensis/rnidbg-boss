package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.efs.sdk.base.Constants;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class da<T, V> extends cz<T, V> {
    public da(Context context, T t) {
        super(context, t);
    }

    public static String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            di.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e2) {
            di.a(e2, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    private static String c(String str) {
        String[] strArrSplit = str.split(ContainerUtils.FIELD_DELIMITER);
        Arrays.sort(strArrSplit);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : strArrSplit) {
            stringBuffer.append(e(str2));
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        }
        String string = stringBuffer.toString();
        return string.length() > 1 ? (String) string.subSequence(0, string.length() - 1) : str;
    }

    @Override // com.amap.api.col.p0002sl.cz
    public abstract V a(String str) throws AMapException;

    @Override // com.amap.api.col.p0002sl.cz
    public abstract String a();

    @Override // com.amap.api.col.p0002sl.cz, com.amap.api.col.p0002sl.id
    public Map<String, String> d() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
        map.put("User-Agent", "AMAP SDK Android Search 9.7.2");
        map.put("X-INFO", fu.b(((cz) this).e));
        map.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.7.2", "sea"));
        map.put("logversion", "2.1");
        return map;
    }

    @Override // com.amap.api.col.p0002sl.cz, com.amap.api.col.p0002sl.id
    public Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.p0002sl.id
    public byte[] h() {
        try {
            String strA = a();
            StringBuffer stringBuffer = new StringBuffer();
            if (strA != null) {
                stringBuffer.append(strA);
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String string = stringBuffer.toString();
            String strC = c(string);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(string);
            String strA2 = fu.a();
            stringBuffer2.append("&ts=".concat(String.valueOf(strA2)));
            stringBuffer2.append("&scode=" + fu.a(((cz) this).e, strA2, strC));
            return stringBuffer2.toString().getBytes("utf-8");
        } catch (Throwable th) {
            di.a(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }

    private static String e(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            di.a(e, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            di.a(e2, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }
}
