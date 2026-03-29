package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class df extends de<ed, CloudItemDetail> {
    public df(Context context, ed edVar) {
        super(context, edVar);
    }

    private static CloudItemDetail c(String str) throws AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            return d(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static CloudItemDetail d(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayA = de.a(jSONObject);
        if (jSONArrayA == null || jSONArrayA.length() <= 0) {
            return null;
        }
        JSONObject jSONObject2 = jSONArrayA.getJSONObject(0);
        CloudItemDetail cloudItemDetailC = de.c(jSONObject2);
        de.a(cloudItemDetailC, jSONObject2);
        return cloudItemDetailC;
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz, com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", fr.f(((cz) this).e));
        hashtable.put("layerId", ((ed) ((cz) this).b).f2719a);
        hashtable.put("output", BodyData.TYPE_JSON);
        hashtable.put("id", ((ed) ((cz) this).b).b);
        String strA = fu.a();
        String strA2 = fu.a(((cz) this).e, strA, ge.b(hashtable));
        hashtable.put("ts", strA);
        hashtable.put("scode", strA2);
        return hashtable;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.e() + "/datasearch/id";
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }
}
