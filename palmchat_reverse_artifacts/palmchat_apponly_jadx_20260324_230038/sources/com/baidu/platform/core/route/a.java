package com.baidu.platform.core.route;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.cdo.oaps.ad.OapsWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends com.baidu.platform.base.b {
    private SuggestAddrInfo b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("origin");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(az.au);
        if (jSONObjectOptJSONObject != null) {
            int iOptInt = jSONObjectOptJSONObject.optInt("listType");
            String strOptString = jSONObjectOptJSONObject.optString("cityName");
            if (iOptInt == 1) {
                suggestAddrInfo.setSuggestStartCity(a(jSONObjectOptJSONObject, "content"));
            } else if (iOptInt == 0) {
                suggestAddrInfo.setSuggestStartNode(a(jSONObjectOptJSONObject, "content", strOptString));
            }
        }
        if (jSONObjectOptJSONObject2 != null) {
            int iOptInt2 = jSONObjectOptJSONObject2.optInt("listType");
            String strOptString2 = jSONObjectOptJSONObject2.optString("cityName");
            if (iOptInt2 == 1) {
                suggestAddrInfo.setSuggestEndCity(a(jSONObjectOptJSONObject2, "content"));
            } else if (iOptInt2 == 0) {
                suggestAddrInfo.setSuggestEndNode(a(jSONObjectOptJSONObject2, "content", strOptString2));
            }
        }
        return suggestAddrInfo;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        BikingRouteResult bikingRouteResult = new BikingRouteResult();
        if (str == null || str.equals("")) {
            bikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return bikingRouteResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    bikingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return bikingRouteResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        bikingRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        bikingRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        bikingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return bikingRouteResult;
                }
            }
            if (!a(str, (SearchResult) bikingRouteResult, false) && !a(str, bikingRouteResult)) {
                bikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return bikingRouteResult;
        } catch (Exception unused) {
            bikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return bikingRouteResult;
        }
    }

    private RouteNode b(JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || str == null || "".equals(str) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(jSONObjectOptJSONObject.optString("wd"));
        routeNode.setUid(jSONObjectOptJSONObject.optString(DeviceInfoUtil.UID_TAG));
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2);
        if (jSONObjectOptJSONObject2 != null) {
            LatLng latLng = new LatLng(jSONObjectOptJSONObject2.optDouble(com.umeng.analytics.pro.f.C), jSONObjectOptJSONObject2.optDouble(com.umeng.analytics.pro.f.D));
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.baiduToGcj(latLng);
            }
            routeNode.setLocation(latLng);
        }
        return routeNode;
    }

    private boolean a(String str, BikingRouteResult bikingRouteResult) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("status_sdk");
                if (iOptInt != 0) {
                    if (iOptInt == 1) {
                        bikingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return true;
                    }
                    if (iOptInt == 2) {
                        bikingRouteResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                        bikingRouteResult.setMessage(jSONObject.optString("message"));
                    }
                    return false;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject2 == null) {
                    return false;
                }
                int iOptInt2 = jSONObject.optInt("type");
                if (iOptInt2 == 1) {
                    bikingRouteResult.setSuggestAddrInfo(b(jSONObjectOptJSONObject2));
                    bikingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                } else {
                    if (iOptInt2 != 2 || (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("routes")) == null || jSONArrayOptJSONArray.length() <= 0) {
                        return false;
                    }
                    RouteNode routeNodeB = b(jSONObjectOptJSONObject2, "origin", "originPt");
                    RouteNode routeNodeB2 = b(jSONObjectOptJSONObject2, az.au, "destinationPt");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        BikingRouteLine bikingRouteLine = new BikingRouteLine();
                        try {
                            jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        } catch (Exception unused) {
                        }
                        if (jSONObjectOptJSONObject == null) {
                            return false;
                        }
                        bikingRouteLine.setStarting(routeNodeB);
                        bikingRouteLine.setTerminal(routeNodeB2);
                        bikingRouteLine.setDistance(jSONObjectOptJSONObject.optInt("distance"));
                        bikingRouteLine.setDuration(jSONObjectOptJSONObject.optInt("duration"));
                        bikingRouteLine.setSteps(a(jSONObjectOptJSONObject.optJSONArray("steps")));
                        arrayList.add(bikingRouteLine);
                    }
                    bikingRouteResult.setRouteLines(arrayList);
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private List<BikingRouteLine.BikingStep> a(JSONArray jSONArray) {
        boolean z = jSONArray == null;
        int length = jSONArray.length();
        if ((length <= 0) || z) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                BikingRouteLine.BikingStep bikingStep = new BikingRouteLine.BikingStep();
                bikingStep.setDirection(jSONObjectOptJSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION) * 30);
                bikingStep.setDistance(jSONObjectOptJSONObject.optInt("distance"));
                bikingStep.setDuration(jSONObjectOptJSONObject.optInt("duration"));
                bikingStep.setName(jSONObjectOptJSONObject.optString("name"));
                bikingStep.setTurnType(jSONObjectOptJSONObject.optString("turn_type"));
                bikingStep.setRestrictionsInfo(jSONObjectOptJSONObject.optString("restrictions_info"));
                bikingStep.setRestrictionsStatus(jSONObjectOptJSONObject.optInt("restrictions_status"));
                bikingStep.setEntrance(RouteNode.location(a(jSONObjectOptJSONObject.optJSONObject("stepOriginLocation"))));
                bikingStep.setExit(RouteNode.location(a(jSONObjectOptJSONObject.optJSONObject("stepDestinationLocation"))));
                String strOptString = jSONObjectOptJSONObject.optString("instructions");
                if (strOptString != null && strOptString.length() >= 4) {
                    strOptString = strOptString.replaceAll("</?[a-z]>", "");
                }
                bikingStep.setInstructions(strOptString);
                bikingStep.setEntranceInstructions(jSONObjectOptJSONObject.optString("stepOriginInstruction"));
                bikingStep.setExitInstructions(jSONObjectOptJSONObject.optString("stepDestinationInstruction"));
                bikingStep.setPathString(jSONObjectOptJSONObject.optString(OapsWrapper.KEY_PATH));
                arrayList.add(bikingStep);
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LatLng latLng = new LatLng(jSONObject.optDouble(com.umeng.analytics.pro.f.C), jSONObject.optDouble(com.umeng.analytics.pro.f.D));
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(latLng) : latLng;
    }

    public List<CityInfo> a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || str == null || str.equals("") || (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i);
            if (jSONObject2 != null) {
                CityInfo cityInfo = new CityInfo();
                cityInfo.num = jSONObject2.optInt(EventParams.KEY_PARAM_NUMBER);
                cityInfo.city = jSONObject2.optString("name");
                arrayList.add(cityInfo);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }

    private List<PoiInfo> a(JSONObject jSONObject, String str, String str2) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && str != null && !"".equals(str) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(str)) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.opt(i);
                if (jSONObject2 != null) {
                    PoiInfo poiInfo = new PoiInfo();
                    if (jSONObject2.has("address")) {
                        poiInfo.address = jSONObject2.optString("address");
                    }
                    poiInfo.uid = jSONObject2.optString(DeviceInfoUtil.UID_TAG);
                    poiInfo.name = jSONObject2.optString("name");
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("location");
                    if (jSONObjectOptJSONObject != null) {
                        poiInfo.location = new LatLng(jSONObjectOptJSONObject.optDouble(com.umeng.analytics.pro.f.C), jSONObjectOptJSONObject.optDouble(com.umeng.analytics.pro.f.D));
                        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                            poiInfo.location = CoordTrans.baiduToGcj(poiInfo.location);
                        }
                    }
                    poiInfo.city = str2;
                    arrayList.add(poiInfo);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        ((OnGetRoutePlanResultListener) obj).onGetBikingRouteResult((BikingRouteResult) searchResult);
    }
}
