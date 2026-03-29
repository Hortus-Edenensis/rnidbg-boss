package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.efs.sdk.base.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.HttpUrl;
import org.apache.http.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class de<T, V> extends da<T, V> {
    public de(Context context, T t) {
        super(context, t);
        ((cz) this).f2684a = false;
    }

    public static JSONArray a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.optJSONArray("list");
        }
        return null;
    }

    public static int b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("info")) == null) {
            return 0;
        }
        return jSONObjectOptJSONObject.optInt("count");
    }

    public static CloudItemDetail c(JSONObject jSONObject) throws JSONException {
        CloudItemDetail cloudItemDetail = new CloudItemDetail(dq.a(jSONObject, "id"), new LatLonPoint(jSONObject.optDouble("point_y"), jSONObject.optDouble("point_x")), dq.a(jSONObject, "title"), dq.a(jSONObject, "address"));
        cloudItemDetail.setCreatetime(dq.a(jSONObject, "gmt_create"));
        cloudItemDetail.setUpdatetime(dq.a(jSONObject, "gmt_modified"));
        if (jSONObject.has("_distance")) {
            String strOptString = jSONObject.optString("_distance");
            if (!c(strOptString)) {
                cloudItemDetail.setDistance(Integer.parseInt(strOptString));
            }
        }
        return cloudItemDetail;
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz, com.amap.api.col.p0002sl.id
    public final Map<String, String> d() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
        map.put("User-Agent", "AMAP SDK Android Search 9.7.2");
        map.put("X-INFO", fu.b(((cz) this).e));
        map.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.7.2", "cloud"));
        map.put("logversion", "2.1");
        return map;
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.id
    public final byte[] h() {
        return null;
    }

    public static void a(CloudItem cloudItem, JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        HashMap<String, String> map = new HashMap<>();
        if (itKeys == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (next != null) {
                map.put(next.toString(), jSONObject.optString(next.toString()));
            }
        }
        cloudItem.setCustomfield(map);
    }

    @Override // com.amap.api.col.p0002sl.cz
    public final V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            di.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        di.c(str);
        return a(str);
    }

    private static boolean c(String str) {
        return str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }
}
