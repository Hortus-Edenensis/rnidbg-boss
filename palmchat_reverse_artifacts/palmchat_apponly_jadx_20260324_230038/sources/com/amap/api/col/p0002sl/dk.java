package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dk extends da<DistrictSearchQuery, DistrictResult> {
    public dk(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public DistrictResult a(String str) throws AMapException {
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) ((cz) this).b, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("districts");
            if (jSONArrayOptJSONArray == null) {
                return districtResult;
            }
            dq.a(jSONArrayOptJSONArray, arrayList, null);
        } catch (JSONException e) {
            di.a(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            di.a(e2, "DistrictServerHandler", "paseJSONException");
        }
        return districtResult;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return dh.a() + "/config/district?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) ((cz) this).b).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) ((cz) this).b).getPageSize());
        if (((DistrictSearchQuery) ((cz) this).b).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) ((cz) this).b).checkKeyWords()) {
            String strB = da.b(((DistrictSearchQuery) ((cz) this).b).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(strB);
        }
        stringBuffer.append("&key=" + fr.f(((cz) this).e));
        stringBuffer.append("&subdistrict=" + String.valueOf(((DistrictSearchQuery) ((cz) this).b).getSubDistrict()));
        return stringBuffer.toString();
    }
}
