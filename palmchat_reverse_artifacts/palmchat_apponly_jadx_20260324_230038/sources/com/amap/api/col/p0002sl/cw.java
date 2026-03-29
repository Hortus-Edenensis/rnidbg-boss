package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class cw extends da<AutoTSearch.Query, AutoTChargeStationResult> {
    private cv g;

    public cw(Context context, AutoTSearch.Query query) {
        super(context, query);
        this.g = null;
        this.g = new cv(context);
    }

    private static AutoTChargeStationResult c(String str) throws AMapException {
        try {
            return cx.a(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        try {
            String strA = cy.a(new HashMap(), ((AutoTSearch.Query) ((cz) this).b).getAccessKey());
            return dh.f() + "/ws/mapapi/poi/infolite/auto?" + strA + "&Signature=" + cy.a("POST", strA, ((AutoTSearch.Query) ((cz) this).b).getSecretKey());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.da, com.amap.api.col.p0002sl.cz
    public final String a() {
        StringBuilder sb = new StringBuilder(this.g.a());
        String adCode = ((AutoTSearch.Query) ((cz) this).b).getAdCode();
        if (!TextUtils.isEmpty(adCode)) {
            sb.append("&adcode=");
            sb.append(da.b(adCode));
        }
        String city = ((AutoTSearch.Query) ((cz) this).b).getCity();
        if (!TextUtils.isEmpty(city)) {
            sb.append("&city=");
            sb.append(da.b(city));
        }
        String dataType = ((AutoTSearch.Query) ((cz) this).b).getDataType();
        if (!TextUtils.isEmpty(dataType)) {
            sb.append("&data_type=");
            sb.append(da.b(dataType));
        }
        String geoObj = ((AutoTSearch.Query) ((cz) this).b).getGeoObj();
        if (!TextUtils.isEmpty(geoObj)) {
            sb.append("&geoobj=");
            sb.append(da.b(geoObj));
        }
        String keywords = ((AutoTSearch.Query) ((cz) this).b).getKeywords();
        if (!TextUtils.isEmpty(keywords)) {
            sb.append("&keywords=");
            sb.append(da.b(keywords));
        }
        sb.append("&pagenum=");
        sb.append(((AutoTSearch.Query) ((cz) this).b).getPageNum());
        sb.append("&pagesize=");
        sb.append(((AutoTSearch.Query) ((cz) this).b).getPageSize());
        sb.append("&qii=");
        sb.append(((AutoTSearch.Query) ((cz) this).b).isQii());
        String queryType = ((AutoTSearch.Query) ((cz) this).b).getQueryType();
        if (!TextUtils.isEmpty(queryType)) {
            sb.append("&query_type=");
            sb.append(da.b(queryType));
        }
        sb.append("&range=");
        sb.append(((AutoTSearch.Query) ((cz) this).b).getRange());
        LatLonPoint latLonPoint = ((AutoTSearch.Query) ((cz) this).b).getLatLonPoint();
        if (latLonPoint != null) {
            sb.append("&longitude=");
            sb.append(latLonPoint.getLongitude());
            sb.append("&latitude=");
            sb.append(latLonPoint.getLatitude());
        }
        String userLoc = ((AutoTSearch.Query) ((cz) this).b).getUserLoc();
        if (!TextUtils.isEmpty(userLoc)) {
            sb.append("&user_loc=");
            sb.append(da.b(userLoc));
        }
        String userCity = ((AutoTSearch.Query) ((cz) this).b).getUserCity();
        if (!TextUtils.isEmpty(userCity)) {
            sb.append("&user_city=");
            sb.append(da.b(userCity));
        }
        AutoTSearch.FilterBox filterBox = ((AutoTSearch.Query) ((cz) this).b).getFilterBox();
        if (filterBox != null) {
            String retainState = filterBox.getRetainState();
            if (!TextUtils.isEmpty(retainState)) {
                sb.append("&retain_state=");
                sb.append(da.b(retainState));
            }
            String checkedLevel = filterBox.getCheckedLevel();
            if (!TextUtils.isEmpty(checkedLevel)) {
                sb.append("&checked_level=");
                sb.append(da.b(checkedLevel));
            }
            String classifyV2Data = filterBox.getClassifyV2Data();
            if (!TextUtils.isEmpty(classifyV2Data)) {
                sb.append("&classify_v2_data=");
                sb.append(da.b(classifyV2Data));
            }
            String classifyV2Level2Data = filterBox.getClassifyV2Level2Data();
            if (!TextUtils.isEmpty(classifyV2Level2Data)) {
                sb.append("&classify_v2_level2_data=");
                sb.append(da.b(classifyV2Level2Data));
            }
            String classifyV2Level3Data = filterBox.getClassifyV2Level3Data();
            if (!TextUtils.isEmpty(classifyV2Level3Data)) {
                sb.append("&classify_v2_level3_data=");
                sb.append(da.b(classifyV2Level3Data));
            }
        }
        return sb.toString();
    }
}
