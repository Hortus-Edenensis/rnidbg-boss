package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ep extends cz<String, String> {
    private String g;

    public ep(Context context, String str) {
        super(context, str);
        this.g = str;
    }

    private static String b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strA = dq.a(jSONObject, "code");
            String strA2 = dq.a(jSONObject, "message");
            if ("1".equals(strA)) {
                return dq.a(jSONObject, "transfer_url");
            }
            if ("0".equals(strA)) {
                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, strA2);
            }
            if ("2".equals(strA)) {
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, strA2);
            }
            if ("3".equals(strA)) {
                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, strA2);
            }
            if ("4".equals(strA)) {
                throw new AMapException("用户签名未通过", 0, strA2);
            }
            if ("5".equals(strA)) {
                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, strA2);
            }
            return null;
        } catch (JSONException e) {
            di.a(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p0002sl.cz
    public final String a() {
        return null;
    }

    @Override // com.amap.api.col.p0002sl.cz, com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        byte[] bArrA;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.g));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.g);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String strA = fz.a(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(strA.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArrA = ez.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            di.a(e, "ShareUrlSearchHandler", "getParams");
            bArrA = null;
        }
        HashMap map = new HashMap();
        map.put("ent", "2");
        map.put("in", fw.b(bArrA));
        map.put("keyt", "openapi");
        return map;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.g();
    }

    @Override // com.amap.api.col.p0002sl.cz
    public final /* synthetic */ String a(String str) throws AMapException {
        return b(str);
    }
}
