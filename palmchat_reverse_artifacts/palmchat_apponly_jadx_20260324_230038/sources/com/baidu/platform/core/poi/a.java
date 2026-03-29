package com.baidu.platform.core.poi;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiIndoorInfo;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.cdo.oaps.ad.OapsKey;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.baidu.platform.base.b {
    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        PoiIndoorResult poiIndoorResult = new PoiIndoorResult();
        if (str == null || str.equals("")) {
            poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiIndoorResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    poiIndoorResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return poiIndoorResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        poiIndoorResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        poiIndoorResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        poiIndoorResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return poiIndoorResult;
                }
            }
            if (!a(str, poiIndoorResult, false) && !a(str, poiIndoorResult)) {
                poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return poiIndoorResult;
        } catch (Exception unused) {
            poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiIndoorResult;
        }
    }

    private boolean a(String str, PoiIndoorResult poiIndoorResult) {
        if (str != null && !"".equals(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("errNo");
                if (iOptInt != 0) {
                    if (iOptInt == 1) {
                        String strOptString = jSONObject.optString("Msg");
                        if (strOptString.contains(MapBundleKey.MapObjKey.OBJ_BID)) {
                            poiIndoorResult.error = SearchResult.ERRORNO.POIINDOOR_BID_ERROR;
                            return true;
                        }
                        if (strOptString.contains("floor")) {
                            poiIndoorResult.error = SearchResult.ERRORNO.POIINDOOR_FLOOR_ERROR;
                            return true;
                        }
                    } else if (iOptInt != 5) {
                        poiIndoorResult.error = SearchResult.ERRORNO.POIINDOOR_SERVER_ERROR;
                        return true;
                    }
                    return false;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject == null) {
                    return false;
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("poi_list");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i);
                        if (jSONObject2 != null) {
                            PoiIndoorInfo poiIndoorInfo = new PoiIndoorInfo();
                            poiIndoorInfo.address = jSONObject2.optString("address");
                            poiIndoorInfo.bid = jSONObject2.optString("bd_id");
                            poiIndoorInfo.cid = jSONObject2.optInt("cid");
                            poiIndoorInfo.discount = jSONObject2.optInt("discount");
                            poiIndoorInfo.floor = jSONObject2.optString("floor");
                            poiIndoorInfo.name = jSONObject2.optString("name");
                            poiIndoorInfo.phone = jSONObject2.optString("phone");
                            poiIndoorInfo.price = jSONObject2.optInt(OapsKey.KEY_PRICE);
                            poiIndoorInfo.starLevel = jSONObject2.optInt("star_level");
                            poiIndoorInfo.tag = jSONObject2.optString("tag");
                            poiIndoorInfo.uid = jSONObject2.optString(DeviceInfoUtil.UID_TAG);
                            poiIndoorInfo.groupNum = jSONObject2.optInt("tuan_nums");
                            int i2 = Integer.parseInt(jSONObject2.optString("twp"));
                            if ((i2 & 1) == 1) {
                                poiIndoorInfo.isGroup = true;
                            }
                            if ((i2 & 2) == 1) {
                                poiIndoorInfo.isTakeOut = true;
                            }
                            if ((i2 & 4) == 1) {
                                poiIndoorInfo.isWaited = true;
                            }
                            poiIndoorInfo.latLng = CoordUtil.mc2ll(new GeoPoint(jSONObject2.optDouble("pt_y"), jSONObject2.optDouble("pt_x")));
                            arrayList.add(poiIndoorInfo);
                        }
                    }
                    poiIndoorResult.error = SearchResult.ERRORNO.NO_ERROR;
                    poiIndoorResult.setmArrayPoiInfo(arrayList);
                } else {
                    poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
                poiIndoorResult.pageNum = jSONObjectOptJSONObject.optInt("page_num");
                poiIndoorResult.poiNum = jSONObjectOptJSONObject.optInt("poi_num");
                poiIndoorResult.error = SearchResult.ERRORNO.NO_ERROR;
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetPoiSearchResultListener)) {
            return;
        }
        ((OnGetPoiSearchResultListener) obj).onGetPoiIndoorResult((PoiIndoorResult) searchResult);
    }
}
