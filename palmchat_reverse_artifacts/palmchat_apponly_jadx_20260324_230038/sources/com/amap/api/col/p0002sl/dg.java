package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.district.DistrictSearchQuery;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dg extends de<CloudSearch.Query, CloudResult> {
    private int g;

    public dg(Context context, CloudSearch.Query query) {
        super(context, query);
        this.g = 0;
    }

    private static String b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(entry.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public CloudResult a(String str) throws AMapException {
        ArrayList<CloudItem> arrayListD = null;
        if (str == null || str.equals("")) {
            T t = ((cz) this).b;
            return CloudResult.createPagedResult((CloudSearch.Query) t, this.g, ((CloudSearch.Query) t).getBound(), ((CloudSearch.Query) ((cz) this).b).getPageSize(), null);
        }
        try {
            arrayListD = d(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        T t2 = ((cz) this).b;
        return CloudResult.createPagedResult((CloudSearch.Query) t2, this.g, ((CloudSearch.Query) t2).getBound(), ((CloudSearch.Query) ((cz) this).b).getPageSize(), arrayListD);
    }

    private ArrayList<CloudItem> d(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONArray jSONArrayA = de.a(jSONObject);
        if (jSONArrayA == null) {
            return arrayList;
        }
        this.g = de.b(jSONObject);
        for (int i = 0; i < jSONArrayA.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayA.optJSONObject(i);
            CloudItemDetail cloudItemDetailC = de.c(jSONObjectOptJSONObject);
            de.a(cloudItemDetailC, jSONObjectOptJSONObject);
            arrayList.add(cloudItemDetailC);
        }
        return arrayList;
    }

    private static String g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            str = e(str);
            String[] strArrSplit = str.split(ContainerUtils.FIELD_DELIMITER);
            Arrays.sort(strArrSplit);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : strArrSplit) {
                stringBuffer.append(str2);
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            String strF = f(stringBuffer.toString());
            if (strF.length() > 1) {
                return (String) strF.subSequence(0, strF.length() - 1);
            }
        } catch (Throwable th) {
            ha.a(th, "ut", "sPa");
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String i() {
        return ((CloudSearch.Query) ((cz) this).b).getSortingrules() != null ? ((CloudSearch.Query) ((cz) this).b).getSortingrules().toString() : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String k() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) ((cz) this).b).getFilterString();
        String filterNumString = ((CloudSearch.Query) ((cz) this).b).getFilterNumString();
        stringBuffer.append(filterString);
        if (!di.a(filterString) && !di.a(filterNumString)) {
            stringBuffer.append("&&");
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
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
        hashtable.put("output", BodyData.TYPE_JSON);
        if (((CloudSearch.Query) ((cz) this).b).getBound() != null) {
            if (((CloudSearch.Query) ((cz) this).b).getBound().getShape().equals("Bound")) {
                hashtable.put("center", di.a(((CloudSearch.Query) ((cz) this).b).getBound().getCenter().getLongitude()) + "," + di.a(((CloudSearch.Query) ((cz) this).b).getBound().getCenter().getLatitude()));
                StringBuilder sb = new StringBuilder();
                sb.append(((CloudSearch.Query) ((cz) this).b).getBound().getRange());
                hashtable.put("radius", sb.toString());
            } else if (((CloudSearch.Query) ((cz) this).b).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) ((cz) this).b).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) ((cz) this).b).getBound().getUpperRight();
                double dA = di.a(lowerLeft.getLatitude());
                double dA2 = di.a(lowerLeft.getLongitude());
                double dA3 = di.a(upperRight.getLatitude());
                hashtable.put("polygon", dA2 + "," + dA + x.aQ + di.a(upperRight.getLongitude()) + "," + dA3);
            } else if (((CloudSearch.Query) ((cz) this).b).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) ((cz) this).b).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", di.a(polyGonList, x.aQ));
                }
            } else if (((CloudSearch.Query) ((cz) this).b).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                hashtable.put(DistrictSearchQuery.KEYWORDS_CITY, ((CloudSearch.Query) ((cz) this).b).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((CloudSearch.Query) ((cz) this).b).getTableID());
        if (!di.a(i())) {
            hashtable.put("sortrule", i());
        }
        String strK = k();
        if (!di.a(strK)) {
            hashtable.put("filter", strK);
        }
        String queryString = ((CloudSearch.Query) ((cz) this).b).getQueryString();
        if (queryString == null || "".equals(queryString)) {
            hashtable.put("keywords", "");
        } else {
            hashtable.put("keywords", queryString);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((CloudSearch.Query) ((cz) this).b).getPageSize());
        hashtable.put("pageSize", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((CloudSearch.Query) ((cz) this).b).getPageNum());
        hashtable.put("pageNum", sb3.toString());
        String strA = fu.a();
        String strA2 = fu.a(((cz) this).e, strA, a(hashtable));
        hashtable.put("ts", strA);
        hashtable.put("scode", strA2);
        return hashtable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        String str = dh.e() + "/datasearch";
        String shape = ((CloudSearch.Query) ((cz) this).b).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around";
        }
        if (shape.equals("Polygon") || shape.equals("Rectangle")) {
            return str + "/polygon";
        }
        if (!shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
            return str;
        }
        return str + "/local";
    }

    private static String a(Map<String, String> map) {
        return g(b(map));
    }

    private static String f(String str) {
        return str != null ? str.replace("%26%26", "&&") : str;
    }

    private static String e(String str) {
        return str != null ? str.replace("&&", "%26%26") : str;
    }
}
