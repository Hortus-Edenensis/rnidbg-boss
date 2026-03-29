package com.baidu.platform.core.busline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.busline.BusLineResult;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.baidu.platform.base.b {
    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        BusLineResult busLineResult = new BusLineResult();
        if (str == null || str.equals("")) {
            busLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return busLineResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    busLineResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return busLineResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        busLineResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        busLineResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        busLineResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return busLineResult;
                }
            }
            if (!a(str, busLineResult, true) && !a(str, busLineResult)) {
                busLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return busLineResult;
        } catch (Exception unused) {
            busLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return busLineResult;
        }
    }

    public boolean a(String str, BusLineResult busLineResult) {
        if (str != null && !"".equals(str)) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("result");
                if (jSONObjectOptJSONObject == null) {
                    return false;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                try {
                    busLineResult.setStartTime(simpleDateFormat.parse(jSONObjectOptJSONObject.optString("startTime")));
                    busLineResult.setEndTime(simpleDateFormat.parse(jSONObjectOptJSONObject.optString(bq.f.h)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                busLineResult.setBusLineName(jSONObjectOptJSONObject.optString("name"));
                busLineResult.setMonthTicket(jSONObjectOptJSONObject.optInt("isMonTicket") == 1);
                busLineResult.setUid(jSONObjectOptJSONObject.optString(DeviceInfoUtil.UID_TAG));
                busLineResult.setBusCompany(jSONObjectOptJSONObject.optString("company"));
                busLineResult.setRawName(jSONObjectOptJSONObject.optString("raw_name"));
                busLineResult.setBasePrice(jSONObjectOptJSONObject.optInt("ticketPrice") / 100.0f);
                busLineResult.setLineDirection(jSONObjectOptJSONObject.optString("line_direction"));
                busLineResult.setMaxPrice(jSONObjectOptJSONObject.optInt("maxPrice") / 100.0f);
                ArrayList arrayList = new ArrayList();
                List<List<LatLng>> listDecodeLocationList2D = CoordUtil.decodeLocationList2D(jSONObjectOptJSONObject.optString(MapBundleKey.MapObjKey.OBJ_GEO));
                if (listDecodeLocationList2D != null) {
                    for (List<LatLng> list : listDecodeLocationList2D) {
                        BusLineResult.BusStep busStep = new BusLineResult.BusStep();
                        busStep.setWayPoints(list);
                        arrayList.add(busStep);
                    }
                }
                if (arrayList.size() > 0) {
                    busLineResult.setSteps(arrayList);
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("stations");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject2 != null) {
                            BusLineResult.BusStation busStation = new BusLineResult.BusStation();
                            busStation.setTitle(jSONObjectOptJSONObject2.optString("name"));
                            busStation.setLocation(CoordUtil.decodeLocation(jSONObjectOptJSONObject2.optString(MapBundleKey.MapObjKey.OBJ_GEO)));
                            busStation.setUid(jSONObjectOptJSONObject2.optString(DeviceInfoUtil.UID_TAG));
                            arrayList2.add(busStation);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        busLineResult.setStations(arrayList2);
                    }
                }
                busLineResult.error = SearchResult.ERRORNO.NO_ERROR;
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetBusLineSearchResultListener)) {
            return;
        }
        ((OnGetBusLineSearchResultListener) obj).onGetBusLineResult((BusLineResult) searchResult);
    }
}
