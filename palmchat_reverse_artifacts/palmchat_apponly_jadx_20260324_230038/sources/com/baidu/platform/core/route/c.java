package com.baidu.platform.core.route;

import com.amap.api.services.route.RouteSearch;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c extends l {
    private boolean b(String str, DrivingRouteResult drivingRouteResult) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        boolean z = false;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("result");
            if (jSONObjectOptJSONObject == null) {
                return false;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("error");
            if (iOptInt != 0) {
                if (iOptInt != 4) {
                    return false;
                }
                drivingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                return true;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("cars");
            if (jSONObjectOptJSONObject2 == null) {
                return false;
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("option");
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("content");
            if (jSONObjectOptJSONObject3 == null || jSONObjectOptJSONObject4 == null) {
                return false;
            }
            RouteNode routeNodeB = b(jSONObjectOptJSONObject3.optJSONObject("start"));
            ArrayList arrayList = new ArrayList();
            RouteNode routeNodeA = a(jSONObjectOptJSONObject3.optJSONArray("end"), arrayList);
            List<DrivingRouteLine.DrivingStep> listA = a(jSONObjectOptJSONObject4.optJSONArray("steps"), jSONObjectOptJSONObject4.optJSONArray("stepts"));
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject4.optJSONArray("routes");
            if (jSONArrayOptJSONArray == null) {
                return false;
            }
            int i = 0;
            while (i < jSONArrayOptJSONArray.length()) {
                DrivingRouteLine drivingRouteLine = new DrivingRouteLine();
                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject5 == null) {
                    jSONObject = jSONObjectOptJSONObject4;
                    jSONArray = jSONArrayOptJSONArray;
                } else {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject5.optJSONArray("legs");
                    if (jSONArrayOptJSONArray2 == null) {
                        return z;
                    }
                    int length = jSONArrayOptJSONArray2.length();
                    ArrayList arrayList3 = new ArrayList();
                    jSONObject = jSONObjectOptJSONObject4;
                    jSONArray = jSONArrayOptJSONArray;
                    int iOptInt2 = 0;
                    int i2 = 0;
                    int iOptInt3 = 0;
                    while (i2 < length) {
                        int i3 = length;
                        JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray2.optJSONObject(i2);
                        JSONArray jSONArray2 = jSONArrayOptJSONArray2;
                        if (jSONObjectOptJSONObject6 != null) {
                            iOptInt2 += jSONObjectOptJSONObject6.optInt("distance");
                            iOptInt3 += jSONObjectOptJSONObject6.optInt("duration");
                            List<DrivingRouteLine.DrivingStep> listB = b(jSONObjectOptJSONObject6.optJSONArray("stepis"), listA);
                            if (listB != null) {
                                arrayList3.addAll(listB);
                            }
                        }
                        i2++;
                        length = i3;
                        jSONArrayOptJSONArray2 = jSONArray2;
                    }
                    drivingRouteLine.setStarting(routeNodeB);
                    drivingRouteLine.setTerminal(routeNodeA);
                    if (arrayList.size() == 0) {
                        drivingRouteLine.setWayPoints(null);
                    } else {
                        drivingRouteLine.setWayPoints(arrayList);
                    }
                    drivingRouteLine.setDistance(iOptInt2);
                    drivingRouteLine.setDuration(iOptInt3);
                    drivingRouteLine.setCongestionDistance(jSONObjectOptJSONObject5.optInt("congestion_length"));
                    drivingRouteLine.setLightNum(jSONObjectOptJSONObject5.optInt("light_num"));
                    drivingRouteLine.setToll(jSONObjectOptJSONObject5.optInt(RouteSearch.DRIVING_EXCLUDE_TOLL));
                    if (arrayList3.size() == 0) {
                        drivingRouteLine.setSteps(null);
                    } else {
                        drivingRouteLine.setSteps(arrayList3);
                    }
                    arrayList2.add(drivingRouteLine);
                }
                i++;
                jSONArrayOptJSONArray = jSONArray;
                jSONObjectOptJSONObject4 = jSONObject;
                z = false;
            }
            drivingRouteResult.setRouteLines(arrayList2);
            drivingRouteResult.setTaxiInfos(c(jSONObjectOptJSONObject4.optString("taxis")));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<TaxiInfo> c(String str) {
        if (str != null && str.length() > 0) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        TaxiInfo taxiInfo = new TaxiInfo();
                        String strOptString = jSONObject.optString("total_price");
                        if (strOptString == null || strOptString.equals("")) {
                            taxiInfo.setTotalPrice(0.0f);
                        } else {
                            taxiInfo.setTotalPrice(Float.parseFloat(strOptString));
                        }
                        arrayList.add(taxiInfo);
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                if (Logger.debugEnable()) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void a(String str, DrivingRouteResult drivingRouteResult) {
        if (str == null || str.equals("")) {
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    drivingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        drivingRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        return;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        drivingRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        return;
                    } else {
                        drivingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return;
                    }
                }
            }
            if (a(str, drivingRouteResult, false) || b(str, drivingRouteResult)) {
                return;
            }
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } catch (Exception unused) {
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }

    private int[] c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("end");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("status");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        int length2 = jSONArrayOptJSONArray2.length();
        int i = 0;
        while (i < length) {
            int iOptInt = jSONArrayOptJSONArray.optInt(i);
            int iOptInt2 = i < length2 ? jSONArrayOptJSONArray2.optInt(i) : 0;
            for (int i2 = 0; i2 < iOptInt; i2++) {
                arrayList.add(Integer.valueOf(iOptInt2));
            }
            i++;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr;
    }

    private RouteNode a(JSONArray jSONArray, List<RouteNode> list) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    RouteNode routeNodeB = b(jSONObjectOptJSONObject);
                    if (i == length - 1) {
                        return routeNodeB;
                    }
                    list.add(routeNodeB);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<DrivingRouteLine.DrivingStep> a(JSONArray jSONArray, JSONArray jSONArray2) {
        int length;
        int length2;
        boolean z;
        int i;
        int i2;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        if (jSONArray2 != null) {
            length2 = jSONArray2.length();
            if (length2 > 0) {
                z = true;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    DrivingRouteLine.DrivingStep drivingStep = new DrivingRouteLine.DrivingStep();
                    drivingStep.setDistance(jSONObjectOptJSONObject.optInt("distance"));
                    drivingStep.setDirection(jSONObjectOptJSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION) * 30);
                    String strOptString = jSONObjectOptJSONObject.optString("instructions");
                    if (strOptString != null && strOptString.length() >= 4) {
                        strOptString = strOptString.replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
                    }
                    drivingStep.setInstructions(strOptString);
                    String strOptString2 = jSONObjectOptJSONObject.optString("start_instructions");
                    if (strOptString2 == null) {
                        int distance = drivingStep.getDistance();
                        if (distance < 1000) {
                            strOptString2 = " - " + distance + "米";
                            i2 = length2;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(" - ");
                            i2 = length2;
                            sb.append(((double) distance) / 1000.0d);
                            sb.append("公里");
                            strOptString2 = sb.toString();
                        }
                        if (i3 <= arrayList.size()) {
                            strOptString2 = ((DrivingRouteLine.DrivingStep) arrayList.get(i3 - 1)).getExitInstructions() + strOptString2;
                        }
                    } else {
                        i2 = length2;
                    }
                    drivingStep.setEntranceInstructions(strOptString2);
                    drivingStep.setExitInstructions(jSONObjectOptJSONObject.optString("end_instructions"));
                    drivingStep.setNumTurns(jSONObjectOptJSONObject.optInt("turn"));
                    drivingStep.setRoadLevel(jSONObjectOptJSONObject.optInt("road_level"));
                    drivingStep.setRoadName(jSONObjectOptJSONObject.optString("road_name"));
                    List<LatLng> listB = b(jSONObjectOptJSONObject.optJSONArray("spath"));
                    drivingStep.setPathList(listB);
                    if (listB != null) {
                        RouteNode routeNode = new RouteNode();
                        routeNode.setLocation(listB.get(0));
                        drivingStep.setEntrance(routeNode);
                        RouteNode routeNode2 = new RouteNode();
                        routeNode2.setLocation(listB.get(listB.size() - 1));
                        drivingStep.setExit(routeNode2);
                    }
                    length2 = i2;
                    if (z && i < length2) {
                        drivingStep.setTrafficList(c(jSONArray2.optJSONObject(i)));
                    }
                    i3++;
                    arrayList.add(drivingStep);
                }
            }
            return arrayList;
        }
        length2 = 0;
        z = false;
        ArrayList arrayList2 = new ArrayList();
        int i32 = 0;
        while (i < length) {
        }
        return arrayList2;
    }

    private RouteNode b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(jSONObject.optString("wd"));
        routeNode.setUid(jSONObject.optString(DeviceInfoUtil.UID_TAG));
        GeoPoint geoPoint = new GeoPoint(0, 0);
        if (jSONObject.optJSONArray("spt") != null) {
            geoPoint.setLongitudeE6(r5.optInt(0));
            geoPoint.setLatitudeE6(r5.optInt(1));
        }
        routeNode.setLocation(CoordUtil.mc2ll(geoPoint));
        return routeNode;
    }

    private List<LatLng> b(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) < 6) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        double dOptInt = 0.0d;
        double dOptInt2 = 0.0d;
        for (int i = 5; i < length; i++) {
            if (i % 2 != 0) {
                dOptInt2 += (double) jSONArray.optInt(i);
            } else {
                dOptInt += (double) jSONArray.optInt(i);
                arrayList.add(CoordUtil.mc2ll(new GeoPoint(dOptInt, dOptInt2)));
            }
        }
        return arrayList;
    }

    private List<DrivingRouteLine.DrivingStep> b(JSONArray jSONArray, List<DrivingRouteLine.DrivingStep> list) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0 || list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("n");
                int iOptInt2 = jSONObjectOptJSONObject.optInt("s");
                for (int i2 = 0; i2 < iOptInt; i2++) {
                    int i3 = iOptInt2 + i2;
                    if (i3 < list.size()) {
                        arrayList.add(list.get(i3));
                    }
                }
            }
        }
        return arrayList;
    }
}
