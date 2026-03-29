package com.amap.api.col.p0002sl;

import android.content.Context;
import com.efs.sdk.base.Constants;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class hf extends fy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f2864a = null;
    public Context b = null;

    @Override // com.amap.api.col.p0002sl.id
    public final String c() {
        return "core";
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> d() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
        map.put("User-Agent", "AMAP SDK Android core 4.3.13");
        map.put("X-INFO", fu.b(this.b));
        map.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.13", "core"));
        map.put("logversion", "2.1");
        return map;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return fx.a().b() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }

    @Override // com.amap.api.col.p0002sl.id
    public final byte[] h() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f2864a;
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    stringBuffer.append(next + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(this.f2864a.get(next).toString(), "utf-8") + ContainerUtils.FIELD_DELIMITER);
                }
            }
            stringBuffer.append("output=json");
            String strF = fr.f(this.b);
            stringBuffer.append("&key=".concat(String.valueOf(strF)));
            String strA = fu.a();
            stringBuffer.append("&ts=".concat(String.valueOf(strA)));
            stringBuffer.append("&scode=" + fu.a(this.b, strA, "key=".concat(String.valueOf(strF))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
