package com.baidu.platform.core.recommendstop;

import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RecommendStationStopInfo;
import com.baidu.mapapi.search.core.RecommendStopInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends com.baidu.platform.base.b {
    private static final String b = "b";

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        RecommendStopResult recommendStopResult = new RecommendStopResult();
        if (str == null || str.isEmpty()) {
            recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return recommendStopResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return recommendStopResult;
            }
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    recommendStopResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return recommendStopResult;
                }
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    strOptString.hashCode();
                    if (strOptString.equals("NETWORK_ERROR")) {
                        recommendStopResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        recommendStopResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        recommendStopResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return recommendStopResult;
                }
            }
            if (!a(str, recommendStopResult, true)) {
                a(str, recommendStopResult);
            }
            return recommendStopResult;
        } catch (JSONException e) {
            Log.e(b, "Parse RecommendStopResult result error", e);
            recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return recommendStopResult;
        }
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj instanceof OnGetRecommendStopResultListener) {
            ((OnGetRecommendStopResultListener) obj).onGetRecommendStopResult((RecommendStopResult) searchResult);
        }
    }

    private boolean a(String str, RecommendStopResult recommendStopResult) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
            int iOptInt = jSONObject.optInt("status");
            if (iOptInt == 0) {
                return a(jSONObject, recommendStopResult);
            }
            if (iOptInt == 1) {
                recommendStopResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            } else if (iOptInt != 2) {
                recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            } else {
                recommendStopResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
            }
            return false;
        } catch (JSONException e) {
            Log.e(b, "Parse RecommendStop error", e);
            recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
    }

    private List<RecommendStopInfo> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null && jSONObject.length() != 0) {
                RecommendStopInfo recommendStopInfo = new RecommendStopInfo();
                recommendStopInfo.setName(jSONObject.optString("name"));
                recommendStopInfo.setDistance(jSONObject.optDouble("distance"));
                recommendStopInfo.setAddress(jSONObject.optString("address"));
                recommendStopInfo.setId(jSONObject.optString("id"));
                recommendStopInfo.setLocation(a(jSONObject));
                arrayList.add(recommendStopInfo);
            }
        }
        return arrayList;
    }

    private boolean a(JSONObject jSONObject, RecommendStopResult recommendStopResult) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        recommendStopResult.error = SearchResult.ERRORNO.NO_ERROR;
        if (jSONObject.has("recommendStops")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("recommendStops");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                recommendStopResult.setRecommendStopInfoList(a(jSONArrayOptJSONArray));
                return true;
            }
            recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
        if (!jSONObject.has("station_info")) {
            return true;
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("station_info");
        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray2.opt(i);
                if (jSONObject2 != null && jSONObject2.length() != 0) {
                    RecommendStationStopInfo recommendStationStopInfo = new RecommendStationStopInfo();
                    recommendStationStopInfo.setStationName(jSONObject2.optString("station_name"));
                    recommendStationStopInfo.setRecommendStopInfoList(a(jSONObject2.optJSONArray("recommendstops")));
                    arrayList.add(recommendStationStopInfo);
                }
            }
            recommendStopResult.setStationInfoList(arrayList);
            return true;
        }
        recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return false;
    }

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double dOptDouble = jSONObject.optDouble("bd09ll_y");
        double dOptDouble2 = jSONObject.optDouble("bd09ll_x");
        double dOptDouble3 = jSONObject.optDouble("gcj02ll_y");
        double dOptDouble4 = jSONObject.optDouble("gcj02ll_x");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            if (Double.compare(dOptDouble3, 0.0d) == 0 && Double.compare(dOptDouble4, 0.0d) == 0) {
                return null;
            }
            return new LatLng(dOptDouble3, dOptDouble4);
        }
        if (Double.compare(dOptDouble, 0.0d) == 0 && Double.compare(dOptDouble2, 0.0d) == 0) {
            return null;
        }
        return new LatLng(dOptDouble, dOptDouble2);
    }
}
