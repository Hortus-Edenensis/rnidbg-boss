package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.IndoorRouteLine;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e extends com.baidu.platform.base.b {
    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        IndoorRouteResult indoorRouteResult = new IndoorRouteResult();
        if (str == null || str.equals("")) {
            indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return indoorRouteResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                    indoorRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return indoorRouteResult;
                }
                if (jSONObjectOptJSONObject.has("httpStateError")) {
                    String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                    if (strOptString.equals("NETWORK_ERROR")) {
                        indoorRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (strOptString.equals("REQUEST_ERROR")) {
                        indoorRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        indoorRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return indoorRouteResult;
                }
            }
            if (!a(str, indoorRouteResult)) {
                indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return indoorRouteResult;
        } catch (Exception unused) {
            indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return indoorRouteResult;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str, IndoorRouteResult indoorRouteResult) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        String str2;
        String str3;
        String str4;
        String str5;
        IndoorRouteResult indoorRouteResult2 = indoorRouteResult;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject jSONObjectOptJSONObject3 = new JSONObject(str).optJSONObject("indoor_navi");
            if (jSONObjectOptJSONObject3 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("option")) == null) {
                return false;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("error");
            if (iOptInt != 0) {
                if (iOptInt == 6) {
                    indoorRouteResult2.error = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_BUILDING;
                    return true;
                }
                if (iOptInt != 7) {
                    return false;
                }
                indoorRouteResult2.error = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_SAME_BUILDING;
                return true;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("routes");
            if (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("legs");
            if (jSONArrayOptJSONArray2 == null) {
                return false;
            }
            int i = 0;
            while (i < jSONArrayOptJSONArray2.length()) {
                IndoorRouteLine indoorRouteLine = new IndoorRouteLine();
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i);
                if (jSONObjectOptJSONObject4 == null) {
                    jSONArray = jSONArrayOptJSONArray2;
                } else {
                    String str6 = "distance";
                    indoorRouteLine.setDistance(jSONObjectOptJSONObject4.optInt("distance"));
                    String str7 = "duration";
                    indoorRouteLine.setDuration(jSONObjectOptJSONObject4.optInt("duration"));
                    String str8 = "sstart_location";
                    indoorRouteLine.setStarting(RouteNode.location(a(jSONObjectOptJSONObject4, "sstart_location")));
                    String str9 = "send_location";
                    indoorRouteLine.setTerminal(RouteNode.location(a(jSONObjectOptJSONObject4, "send_location")));
                    JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray("steps");
                    if (jSONArrayOptJSONArray3 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int i2 = 0;
                        while (i2 < jSONArrayOptJSONArray3.length()) {
                            IndoorRouteLine.IndoorRouteStep indoorRouteStep = new IndoorRouteLine.IndoorRouteStep();
                            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray3.optJSONObject(i2);
                            if (jSONObjectOptJSONObject5 == null) {
                                jSONArray2 = jSONArrayOptJSONArray2;
                                jSONArray3 = jSONArrayOptJSONArray3;
                                str2 = str6;
                                str3 = str7;
                                str4 = str8;
                                str5 = str9;
                            } else {
                                indoorRouteStep.setDistance(jSONObjectOptJSONObject5.optInt(str6));
                                indoorRouteStep.setDuration(jSONObjectOptJSONObject5.optInt(str7));
                                indoorRouteStep.setBuildingId(jSONObjectOptJSONObject5.optString("buildingid"));
                                indoorRouteStep.setFloorId(jSONObjectOptJSONObject5.optString("floorid"));
                                indoorRouteStep.setEntrace(RouteNode.location(a(jSONObjectOptJSONObject5, str8)));
                                indoorRouteStep.setExit(RouteNode.location(a(jSONObjectOptJSONObject5, str9)));
                                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject5.optJSONArray("spath");
                                if (jSONArrayOptJSONArray4 != null) {
                                    jSONArray2 = jSONArrayOptJSONArray2;
                                    ArrayList arrayList3 = new ArrayList();
                                    double d = 0.0d;
                                    jSONArray3 = jSONArrayOptJSONArray3;
                                    str2 = str6;
                                    double d2 = 0.0d;
                                    int i3 = 5;
                                    while (i3 < jSONArrayOptJSONArray4.length()) {
                                        double dOptDouble = d2 + jSONArrayOptJSONArray4.optDouble(i3 + 1);
                                        String str10 = str8;
                                        double dOptDouble2 = d + jSONArrayOptJSONArray4.optDouble(i3);
                                        JSONArray jSONArray4 = jSONArrayOptJSONArray4;
                                        GeoPoint geoPoint = new GeoPoint(0, 0);
                                        geoPoint.setLatitudeE6((int) dOptDouble);
                                        geoPoint.setLongitudeE6((int) dOptDouble2);
                                        LatLng latLngMc2ll = CoordUtil.mc2ll(geoPoint);
                                        arrayList3.add(Double.valueOf(latLngMc2ll.latitude));
                                        arrayList3.add(Double.valueOf(latLngMc2ll.longitude));
                                        i3 += 2;
                                        jSONArrayOptJSONArray4 = jSONArray4;
                                        d2 = dOptDouble;
                                        str7 = str7;
                                        d = dOptDouble2;
                                        str8 = str10;
                                        str9 = str9;
                                    }
                                    str3 = str7;
                                    str4 = str8;
                                    str5 = str9;
                                    indoorRouteStep.setPath(arrayList3);
                                    indoorRouteStep.setInstructions(jSONObjectOptJSONObject5.optString("instructions"));
                                    JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject5.optJSONArray("pois");
                                    if (jSONArrayOptJSONArray5 != null) {
                                        ArrayList arrayList4 = new ArrayList();
                                        for (int i4 = 0; i4 < jSONArrayOptJSONArray5.length(); i4++) {
                                            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray5.optJSONObject(i4);
                                            if (jSONObjectOptJSONObject6 != null) {
                                                IndoorRouteLine.IndoorRouteStep.IndoorStepNode indoorStepNode = new IndoorRouteLine.IndoorRouteStep.IndoorStepNode();
                                                indoorStepNode.setDetail(jSONObjectOptJSONObject6.optString("detail"));
                                                indoorStepNode.setName(jSONObjectOptJSONObject6.optString("name"));
                                                indoorStepNode.setType(jSONObjectOptJSONObject6.optInt("type"));
                                                indoorStepNode.setLocation(a(jSONObjectOptJSONObject6, "location"));
                                                arrayList4.add(indoorStepNode);
                                            }
                                        }
                                        indoorRouteStep.setStepNodes(arrayList4);
                                    }
                                    arrayList2.add(indoorRouteStep);
                                }
                            }
                            i2++;
                            jSONArrayOptJSONArray2 = jSONArray2;
                            jSONArrayOptJSONArray3 = jSONArray3;
                            str6 = str2;
                            str8 = str4;
                            str9 = str5;
                            str7 = str3;
                        }
                        jSONArray = jSONArrayOptJSONArray2;
                        if (arrayList2.size() > 0) {
                            indoorRouteLine.setSteps(arrayList2);
                        }
                    } else {
                        jSONArray = jSONArrayOptJSONArray2;
                    }
                    arrayList.add(indoorRouteLine);
                }
                i++;
                indoorRouteResult2 = indoorRouteResult;
                jSONArrayOptJSONArray2 = jSONArray;
            }
            indoorRouteResult2.setRouteLines(arrayList);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private LatLng a(JSONObject jSONObject, String str) {
        if (jSONObject.optJSONArray(str) == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint(0, 0);
        geoPoint.setLatitudeE6((int) r4.optDouble(1));
        geoPoint.setLongitudeE6((int) r4.optDouble(0));
        return CoordUtil.mc2ll(geoPoint);
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        ((OnGetRoutePlanResultListener) obj).onGetIndoorRouteResult((IndoorRouteResult) searchResult);
    }
}
