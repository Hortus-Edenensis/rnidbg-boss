package com.amap.api.col.p0002sl;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.x.d;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.poisearch.SubPoiItemV2;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusPathV2;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.BusStepV2;
import com.amap.api.services.route.ChargeStationInfo;
import com.amap.api.services.route.Cost;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DrivePathV2;
import com.amap.api.services.route.DrivePlanPath;
import com.amap.api.services.route.DrivePlanStep;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.DriveStepV2;
import com.amap.api.services.route.ElecConsumeInfo;
import com.amap.api.services.route.Navi;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.TaxiItemV2;
import com.amap.api.services.route.TimeInfo;
import com.amap.api.services.route.TimeInfosElement;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import com.cdo.oaps.ad.OapsWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.x;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.EventParams;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class dq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f2693a = {"010", "021", "022", "023", "1852", "1853"};

    private static WalkStep A(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(a(jSONObject, "instruction"));
        walkStep.setOrientation(a(jSONObject, bq.f.V));
        walkStep.setRoad(a(jSONObject, "road"));
        walkStep.setDistance(t(a(jSONObject, "distance")));
        walkStep.setDuration(t(a(jSONObject, "duration")));
        walkStep.setPolyline(d(jSONObject, "polyline"));
        walkStep.setAction(a(jSONObject, "action"));
        walkStep.setAssistantAction(a(jSONObject, "assistant_action"));
        return walkStep;
    }

    private static WalkStep B(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(a(jSONObject, "instruction"));
        walkStep.setOrientation(a(jSONObject, bq.f.V));
        walkStep.setRoad(a(jSONObject, "road"));
        walkStep.setDistance(t(a(jSONObject, "distance")));
        walkStep.setDuration(t(a(jSONObject, "duration")));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("polyline");
        if (jSONObjectOptJSONObject != null) {
            walkStep.setPolyline(d(jSONObjectOptJSONObject, "polyline"));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("navi");
        if (jSONObjectOptJSONObject2 != null) {
            walkStep.setAction(a(jSONObjectOptJSONObject2, "action"));
            walkStep.setAssistantAction(a(jSONObjectOptJSONObject2, "assistant_action"));
            walkStep.setRoadType(s(a(jSONObjectOptJSONObject2, "walk_type")));
        }
        return walkStep;
    }

    private static RouteBusLineItem C(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(F(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(F(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(a(jSONObject, "name"));
        routeBusLineItem.setBusLineId(a(jSONObject, "id"));
        routeBusLineItem.setBusLineType(a(jSONObject, "type"));
        routeBusLineItem.setDistance(t(a(jSONObject, "distance")));
        routeBusLineItem.setDuration(t(a(jSONObject, "duration")));
        routeBusLineItem.setPolyline(d(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(di.d(a(jSONObject, f.p)));
        routeBusLineItem.setLastBusTime(di.d(a(jSONObject, f.q)));
        routeBusLineItem.setPassStationNum(s(a(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(E(jSONObject));
        return routeBusLineItem;
    }

    private static RouteBusLineItem D(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(F(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(F(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(a(jSONObject, "name"));
        routeBusLineItem.setBusLineId(a(jSONObject, "id"));
        routeBusLineItem.setBusLineType(a(jSONObject, "type"));
        routeBusLineItem.setDistance(t(a(jSONObject, "distance")));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(SharePluginInfo.ISSUE_COST);
        if (jSONObjectOptJSONObject != null) {
            routeBusLineItem.setDuration(t(a(jSONObjectOptJSONObject, "duration")));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("polyline");
        if (jSONObjectOptJSONObject2 != null) {
            routeBusLineItem.setPolyline(d(jSONObjectOptJSONObject2, "polyline"));
        }
        routeBusLineItem.setFirstBusTime(di.d(a(jSONObject, f.p)));
        routeBusLineItem.setLastBusTime(di.d(a(jSONObject, f.q)));
        routeBusLineItem.setPassStationNum(s(a(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(E(jSONObject));
        return routeBusLineItem;
    }

    private static List<BusStationItem> E(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(F(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    private static BusStationItem F(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(a(jSONObject, "name"));
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(c(jSONObject, "location"));
        return busStationItem;
    }

    private static RouteRailwayItem G(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("id") || !jSONObject.has("name")) {
            return null;
        }
        RouteRailwayItem routeRailwayItem = new RouteRailwayItem();
        routeRailwayItem.setID(a(jSONObject, "id"));
        routeRailwayItem.setName(a(jSONObject, "name"));
        routeRailwayItem.setTime(a(jSONObject, "time"));
        routeRailwayItem.setTrip(a(jSONObject, "trip"));
        routeRailwayItem.setDistance(t(a(jSONObject, "distance")));
        routeRailwayItem.setType(a(jSONObject, "type"));
        routeRailwayItem.setDeparturestop(H(jSONObject.optJSONObject("departure_stop")));
        routeRailwayItem.setArrivalstop(H(jSONObject.optJSONObject("arrival_stop")));
        routeRailwayItem.setViastops(I(jSONObject));
        routeRailwayItem.setAlters(J(jSONObject));
        routeRailwayItem.setSpaces(K(jSONObject));
        return routeRailwayItem;
    }

    private static RailwayStationItem H(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(a(jSONObject, "id"));
        railwayStationItem.setName(a(jSONObject, "name"));
        railwayStationItem.setLocation(c(jSONObject, "location"));
        railwayStationItem.setAdcode(a(jSONObject, "adcode"));
        railwayStationItem.setTime(a(jSONObject, "time"));
        railwayStationItem.setisStart(w(a(jSONObject, "start")));
        railwayStationItem.setisEnd(w(a(jSONObject, "end")));
        railwayStationItem.setWait(t(a(jSONObject, "wait")));
        return railwayStationItem;
    }

    private static List<RailwayStationItem> I(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(H(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    private static List<Railway> J(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("alters")) == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                Railway railway = new Railway();
                railway.setID(a(jSONObjectOptJSONObject, "id"));
                railway.setName(a(jSONObjectOptJSONObject, "name"));
                arrayList.add(railway);
            }
        }
        return arrayList;
    }

    private static List<RailwaySpace> K(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("spaces")) == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(L(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    private static RailwaySpace L(JSONObject jSONObject) throws JSONException {
        return new RailwaySpace(a(jSONObject, "code"), t(a(jSONObject, SharePluginInfo.ISSUE_COST)));
    }

    private static TaxiItem M(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItem taxiItem = new TaxiItem();
        taxiItem.setOrigin(c(jSONObject, "origin"));
        taxiItem.setDestination(c(jSONObject, az.au));
        taxiItem.setDistance(t(a(jSONObject, "distance")));
        taxiItem.setDuration(t(a(jSONObject, "duration")));
        taxiItem.setSname(a(jSONObject, "sname"));
        taxiItem.setTname(a(jSONObject, "tname"));
        return taxiItem;
    }

    private static TaxiItemV2 N(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItemV2 taxiItemV2 = new TaxiItemV2();
        taxiItemV2.setOrigin(c(jSONObject, "startpoint"));
        taxiItemV2.setDestination(c(jSONObject, "endpoint"));
        taxiItemV2.setDistance(t(a(jSONObject, "distance")));
        taxiItemV2.setDuration(t(a(jSONObject, "drivetime")));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("polyline");
        if (jSONObjectOptJSONObject != null) {
            taxiItemV2.setPolyline(d(jSONObjectOptJSONObject, "polyline"));
        }
        taxiItemV2.setSname(a(jSONObject, "startname"));
        taxiItemV2.setTname(a(jSONObject, "endname"));
        return taxiItemV2;
    }

    private static ElecConsumeInfo O(JSONObject jSONObject) throws AMapException {
        try {
            ElecConsumeInfo elecConsumeInfo = new ElecConsumeInfo();
            elecConsumeInfo.setRunOutPoint(c(jSONObject, "runout_point"));
            elecConsumeInfo.setRunOutStepIndex(b(jSONObject, "runout_step_index"));
            elecConsumeInfo.setConsumeEnergy(b(jSONObject, "consume_energy"));
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("left_energy");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
                }
            }
            elecConsumeInfo.setLeftEnergy(arrayList);
            return elecConsumeInfo;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseElecConsumeInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static Navi P(JSONObject jSONObject) throws AMapException {
        try {
            Navi navi = new Navi();
            navi.setAction(a(jSONObject, "action"));
            navi.setAssistantAction(a(jSONObject, "assistant_action"));
            return navi;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseNavi");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<Photo> Q(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || !jSONObject.has("photos")) {
            return arrayList;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("photos");
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            Photo photo = new Photo();
            photo.setTitle(a(jSONObjectOptJSONObject, "title"));
            photo.setUrl(a(jSONObjectOptJSONObject, "url"));
            arrayList.add(photo);
        }
        return arrayList;
    }

    private static RoutePOIItem R(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(a(jSONObject, "id"));
        routePOIItem.setTitle(a(jSONObject, "name"));
        routePOIItem.setPoint(c(jSONObject, "location"));
        routePOIItem.setDistance(t(a(jSONObject, "distance")));
        routePOIItem.setDuration(t(a(jSONObject, "duration")));
        routePOIItem.setCPID(a(jSONObject, "cpid"));
        return routePOIItem;
    }

    private static RidePath S(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(t(a(jSONObject, "distance")));
            ridePath.setDuration(v(a(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray == null) {
                    return null;
                }
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    RideStep rideStep = new RideStep();
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        rideStep.setInstruction(a(jSONObjectOptJSONObject, "instruction"));
                        rideStep.setOrientation(a(jSONObjectOptJSONObject, bq.f.V));
                        rideStep.setRoad(a(jSONObjectOptJSONObject, "road"));
                        rideStep.setDistance(t(a(jSONObjectOptJSONObject, "distance")));
                        rideStep.setDuration(t(a(jSONObjectOptJSONObject, "duration")));
                        rideStep.setPolyline(d(jSONObjectOptJSONObject, "polyline"));
                        rideStep.setAction(a(jSONObjectOptJSONObject, "action"));
                        rideStep.setAssistantAction(a(jSONObjectOptJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                d(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseRidePath");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static RidePath T(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(t(a(jSONObject, "distance")));
            ridePath.setDuration(v(a(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray == null) {
                    return null;
                }
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    RideStep rideStep = new RideStep();
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        rideStep.setInstruction(a(jSONObjectOptJSONObject, "instruction"));
                        rideStep.setOrientation(a(jSONObjectOptJSONObject, bq.f.V));
                        rideStep.setRoad(a(jSONObjectOptJSONObject, "road_name"));
                        rideStep.setDistance(t(a(jSONObjectOptJSONObject, "step_distance")));
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(SharePluginInfo.ISSUE_COST);
                        if (jSONObjectOptJSONObject2 != null) {
                            rideStep.setDuration(t(a(jSONObjectOptJSONObject2, "duration")));
                        }
                        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("navi");
                        if (jSONObjectOptJSONObject3 != null) {
                            rideStep.setAction(a(jSONObjectOptJSONObject3, "action"));
                            rideStep.setAssistantAction(a(jSONObjectOptJSONObject3, "assistant_action"));
                            rideStep.setRoadType(s(a(jSONObjectOptJSONObject3, "work_type")));
                        }
                        rideStep.setPolyline(d(jSONObjectOptJSONObject, "polyline"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                d(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseRidePathV2");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<NearbyInfo> a(JSONObject jSONObject, boolean z) throws JSONException {
        double dU;
        double dU2;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("datas");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<NearbyInfo> arrayList = new ArrayList<>();
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            String strA = a(jSONObjectOptJSONObject, "userid");
            String strA2 = a(jSONObjectOptJSONObject, "location");
            if (strA2 != null) {
                String[] strArrSplit = strA2.split(",");
                if (strArrSplit.length == 2) {
                    dU = u(strArrSplit[0]);
                    dU2 = u(strArrSplit[1]);
                } else {
                    dU = 0.0d;
                    dU2 = 0.0d;
                }
            }
            String strA3 = a(jSONObjectOptJSONObject, "distance");
            long jV = v(a(jSONObjectOptJSONObject, "updatetime"));
            int iS = s(strA3);
            LatLonPoint latLonPoint = new LatLonPoint(dU2, dU);
            NearbyInfo nearbyInfo = new NearbyInfo();
            nearbyInfo.setUserID(strA);
            nearbyInfo.setTimeStamp(jV);
            nearbyInfo.setPoint(latLonPoint);
            if (z) {
                nearbyInfo.setDrivingDistance(iS);
            } else {
                nearbyInfo.setDistance(iS);
            }
            arrayList.add(nearbyInfo);
        }
        return arrayList;
    }

    public static ArrayList<String> b(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keywords");
        if (jSONArrayOptJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(jSONArrayOptJSONArray.optString(i));
        }
        return arrayList;
    }

    public static ArrayList<PoiItem> c(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("pois")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(e(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<PoiItemV2> d(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItemV2> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pois");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(f(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static PoiItem e(JSONObject jSONObject) throws JSONException {
        PoiItem poiItem = new PoiItem(a(jSONObject, "id"), c(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        poiItem.setAdCode(a(jSONObject, "adcode"));
        poiItem.setProvinceName(a(jSONObject, "pname"));
        poiItem.setCityName(a(jSONObject, "cityname"));
        poiItem.setAdName(a(jSONObject, "adname"));
        poiItem.setCityCode(a(jSONObject, "citycode"));
        poiItem.setProvinceCode(a(jSONObject, "pcode"));
        poiItem.setDirection(a(jSONObject, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
        if (jSONObject.has("distance")) {
            String strA = a(jSONObject, "distance");
            if (!i(strA)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(strA));
                } catch (NumberFormatException e) {
                    di.a(e, "JSONHelper", "parseBasePoi");
                } catch (Exception e2) {
                    di.a(e2, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(a(jSONObject, "tel"));
        poiItem.setTypeDes(a(jSONObject, "type"));
        poiItem.setEnter(c(jSONObject, "entr_location"));
        poiItem.setExit(c(jSONObject, "exit_location"));
        poiItem.setWebsite(a(jSONObject, "website"));
        poiItem.setPostcode(a(jSONObject, "postcode"));
        String strA2 = a(jSONObject, "business_area");
        if (i(strA2)) {
            strA2 = a(jSONObject, "businessarea");
        }
        poiItem.setBusinessArea(strA2);
        poiItem.setEmail(a(jSONObject, NotificationCompat.CATEGORY_EMAIL));
        if (r(a(jSONObject, "indoor_map"))) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(a(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(l(jSONObjectOptJSONObject));
                    }
                }
            }
            poiItem.setSubPois(arrayList);
        }
        poiItem.setIndoorDate(e(jSONObject, "indoor_data"));
        poiItem.setPoiExtension(i(jSONObject, "biz_ext"));
        poiItem.setTypeCode(a(jSONObject, "typecode"));
        poiItem.setShopID(a(jSONObject, "shopid"));
        a(poiItem, jSONObject);
        return poiItem;
    }

    public static PoiItemV2 f(JSONObject jSONObject) throws JSONException {
        PoiItemV2 poiItemV2 = new PoiItemV2(a(jSONObject, "id"), c(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        poiItemV2.setTypeDes(a(jSONObject, "type"));
        poiItemV2.setTypeCode(a(jSONObject, "typecode"));
        poiItemV2.setProvinceName(a(jSONObject, "pname"));
        poiItemV2.setCityName(a(jSONObject, "cityname"));
        poiItemV2.setAdName(a(jSONObject, "adname"));
        poiItemV2.setProvinceCode(a(jSONObject, "pcode"));
        poiItemV2.setAdCode(a(jSONObject, "adcode"));
        poiItemV2.setCityCode(a(jSONObject, "citycode"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(m(jSONObjectOptJSONObject));
                    }
                }
            }
            poiItemV2.setSubPois(arrayList);
        }
        poiItemV2.setBusiness(g(jSONObject, "business"));
        poiItemV2.setIndoorData(f(jSONObject, "indoor"));
        poiItemV2.setPoiNavi(h(jSONObject, "navi"));
        a(poiItemV2, jSONObject);
        return poiItemV2;
    }

    public static ArrayList<BusStationItem> g(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("busstops");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(n(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<BusLineItem> h(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("buslines");
        if (jSONArrayOptJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(q(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    public static ArrayList<GeocodeAddress> i(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("geocodes");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    GeocodeAddress geocodeAddress = new GeocodeAddress();
                    geocodeAddress.setFormatAddress(a(jSONObjectOptJSONObject, "formatted_address"));
                    geocodeAddress.setProvince(a(jSONObjectOptJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    geocodeAddress.setCity(a(jSONObjectOptJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    geocodeAddress.setDistrict(a(jSONObjectOptJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                    geocodeAddress.setTownship(a(jSONObjectOptJSONObject, "township"));
                    geocodeAddress.setNeighborhood(a(jSONObjectOptJSONObject.optJSONObject("neighborhood"), "name"));
                    geocodeAddress.setBuilding(a(jSONObjectOptJSONObject.optJSONObject("building"), "name"));
                    geocodeAddress.setAdcode(a(jSONObjectOptJSONObject, "adcode"));
                    geocodeAddress.setLatLonPoint(c(jSONObjectOptJSONObject, "location"));
                    geocodeAddress.setLevel(a(jSONObjectOptJSONObject, "level"));
                    geocodeAddress.setCountry(a(jSONObjectOptJSONObject, "country"));
                    geocodeAddress.setPostcode(a(jSONObjectOptJSONObject, "postcode"));
                    arrayList.add(geocodeAddress);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<Tip> j(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tips");
        if (jSONArrayOptJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            Tip tip = new Tip();
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                tip.setName(a(jSONObjectOptJSONObject, "name"));
                tip.setDistrict(a(jSONObjectOptJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                tip.setAdcode(a(jSONObjectOptJSONObject, "adcode"));
                tip.setID(a(jSONObjectOptJSONObject, "id"));
                tip.setAddress(a(jSONObjectOptJSONObject, "address"));
                tip.setTypeCode(a(jSONObjectOptJSONObject, "typecode"));
                String strA = a(jSONObjectOptJSONObject, "location");
                if (!TextUtils.isEmpty(strA)) {
                    String[] strArrSplit = strA.split(",");
                    if (strArrSplit.length == 2) {
                        tip.setPostion(new LatLonPoint(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0])));
                    }
                }
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    public static ArrayList<RoutePOIItem> k(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        Object objOpt = jSONObject.opt("pois");
        if (objOpt instanceof JSONArray) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pois");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                return arrayList;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(R(jSONObjectOptJSONObject));
                }
            }
        } else if (objOpt instanceof JSONObject) {
            arrayList.add(R(((JSONObject) objOpt).optJSONObject("poi")));
        }
        return arrayList;
    }

    private static SubPoiItem l(JSONObject jSONObject) throws JSONException {
        SubPoiItem subPoiItem = new SubPoiItem(a(jSONObject, "id"), c(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        subPoiItem.setSubName(a(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(a(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String strA = a(jSONObject, "distance");
            if (!i(strA)) {
                try {
                    subPoiItem.setDistance((int) Float.parseFloat(strA));
                } catch (NumberFormatException e) {
                    di.a(e, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e2) {
                    di.a(e2, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return subPoiItem;
    }

    private static SubPoiItemV2 m(JSONObject jSONObject) throws JSONException {
        SubPoiItemV2 subPoiItemV2 = new SubPoiItemV2(a(jSONObject, "id"), c(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        subPoiItemV2.setSubTypeDes(a(jSONObject, "subtype"));
        subPoiItemV2.setTypeCode(a(jSONObject, "typecode"));
        return subPoiItemV2;
    }

    private static BusStationItem n(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItemO = o(jSONObject);
        busStationItemO.setAdCode(a(jSONObject, "adcode"));
        busStationItemO.setCityCode(a(jSONObject, "citycode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray == null) {
            busStationItemO.setBusLineItems(arrayList);
            return busStationItemO;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(p(jSONObjectOptJSONObject));
            }
        }
        busStationItemO.setBusLineItems(arrayList);
        return busStationItemO;
    }

    private static BusStationItem o(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(c(jSONObject, "location"));
        busStationItem.setBusStationName(a(jSONObject, "name"));
        return busStationItem;
    }

    private static BusLineItem p(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(a(jSONObject, "id"));
        busLineItem.setBusLineType(a(jSONObject, "type"));
        busLineItem.setBusLineName(a(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(d(jSONObject, "polyline"));
        busLineItem.setCityCode(a(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(a(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(a(jSONObject, "end_stop"));
        return busLineItem;
    }

    private static BusLineItem q(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItemP = p(jSONObject);
        busLineItemP.setFirstBusTime(di.d(a(jSONObject, f.p)));
        busLineItemP.setLastBusTime(di.d(a(jSONObject, f.q)));
        busLineItemP.setBusCompany(a(jSONObject, "company"));
        busLineItemP.setDistance(t(a(jSONObject, "distance")));
        busLineItemP.setBasicPrice(t(a(jSONObject, "basic_price")));
        busLineItemP.setTotalPrice(t(a(jSONObject, "total_price")));
        busLineItemP.setBounds(d(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("busstops");
        if (jSONArrayOptJSONArray == null) {
            busLineItemP.setBusStations(arrayList);
            return busLineItemP;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(o(jSONObjectOptJSONObject));
            }
        }
        busLineItemP.setBusStations(arrayList);
        return busLineItemP;
    }

    private static DistrictItem r(JSONObject jSONObject) throws JSONException {
        String strOptString;
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(a(jSONObject, "citycode"));
        districtItem.setAdcode(a(jSONObject, "adcode"));
        districtItem.setName(a(jSONObject, "name"));
        districtItem.setLevel(a(jSONObject, "level"));
        districtItem.setCenter(c(jSONObject, "center"));
        if (jSONObject.has("polyline") && (strOptString = jSONObject.optString("polyline")) != null && strOptString.length() > 0) {
            districtItem.setDistrictBoundary(strOptString.split("\\|"));
        }
        a(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    private static List<BusinessArea> s(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("businessAreas");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                BusinessArea businessArea = new BusinessArea();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    businessArea.setCenterPoint(c(jSONObjectOptJSONObject, "location"));
                    businessArea.setName(a(jSONObjectOptJSONObject, "name"));
                    arrayList.add(businessArea);
                }
            }
        }
        return arrayList;
    }

    private static BusStep t(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStep busStep = new BusStep();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("walking");
        if (jSONObjectOptJSONObject != null) {
            busStep.setWalk(v(jSONObjectOptJSONObject));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("bus");
        if (jSONObjectOptJSONObject2 != null) {
            busStep.setBusLines(x(jSONObjectOptJSONObject2));
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("entrance");
        if (jSONObjectOptJSONObject3 != null) {
            busStep.setEntrance(z(jSONObjectOptJSONObject3));
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(d.z);
        if (jSONObjectOptJSONObject4 != null) {
            busStep.setExit(z(jSONObjectOptJSONObject4));
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("railway");
        if (jSONObjectOptJSONObject5 != null) {
            busStep.setRailway(G(jSONObjectOptJSONObject5));
        }
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("taxi");
        if (jSONObjectOptJSONObject6 != null) {
            busStep.setTaxi(M(jSONObjectOptJSONObject6));
        }
        if ((busStep.getWalk() == null || busStep.getWalk().getSteps().size() == 0) && busStep.getBusLines().size() == 0 && busStep.getRailway() == null && busStep.getTaxi() == null) {
            return null;
        }
        return busStep;
    }

    private static BusStepV2 u(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStepV2 busStepV2 = new BusStepV2();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("walking");
        if (jSONObjectOptJSONObject != null) {
            busStepV2.setWalk(w(jSONObjectOptJSONObject));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("bus");
        if (jSONObjectOptJSONObject2 != null) {
            busStepV2.setBusLines(y(jSONObjectOptJSONObject2));
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("entrance");
        if (jSONObjectOptJSONObject3 != null) {
            busStepV2.setEntrance(z(jSONObjectOptJSONObject3));
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(d.z);
        if (jSONObjectOptJSONObject4 != null) {
            busStepV2.setExit(z(jSONObjectOptJSONObject4));
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("railway");
        if (jSONObjectOptJSONObject5 != null) {
            busStepV2.setRailway(G(jSONObjectOptJSONObject5));
        }
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("taxi");
        if (jSONObjectOptJSONObject6 != null) {
            busStepV2.setTaxi(N(jSONObjectOptJSONObject6));
        }
        if ((busStepV2.getWalk() == null || busStepV2.getWalk().getSteps().size() == 0) && busStepV2.getBusLines().size() == 0 && busStepV2.getRailway() == null && busStepV2.getTaxi() == null) {
            return null;
        }
        return busStepV2;
    }

    private static RouteBusWalkItem v(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(c(jSONObject, "origin"));
        routeBusWalkItem.setDestination(c(jSONObject, az.au));
        routeBusWalkItem.setDistance(t(a(jSONObject, "distance")));
        routeBusWalkItem.setDuration(v(a(jSONObject, "duration")));
        if (!jSONObject.has("steps") || (jSONArrayOptJSONArray = jSONObject.optJSONArray("steps")) == null) {
            return routeBusWalkItem;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(A(jSONObjectOptJSONObject));
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        a(routeBusWalkItem, arrayList);
        return routeBusWalkItem;
    }

    private static RouteBusWalkItem w(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(c(jSONObject, "origin"));
        routeBusWalkItem.setDestination(c(jSONObject, az.au));
        routeBusWalkItem.setDistance(t(a(jSONObject, "distance")));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(SharePluginInfo.ISSUE_COST);
        if (jSONObjectOptJSONObject != null) {
            routeBusWalkItem.setDuration(v(a(jSONObjectOptJSONObject, "duration")));
        }
        if (!jSONObject.has("steps") || (jSONArrayOptJSONArray = jSONObject.optJSONArray("steps")) == null) {
            return routeBusWalkItem;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject2 != null) {
                arrayList.add(B(jSONObjectOptJSONObject2));
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        a(routeBusWalkItem, arrayList);
        return routeBusWalkItem;
    }

    private static List<RouteBusLineItem> x(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(C(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    private static List<RouteBusLineItem> y(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(D(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    private static Doorway z(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(a(jSONObject, "name"));
        doorway.setLatLonPoint(c(jSONObject, "location"));
        return doorway;
    }

    public static void b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                regeocodeRoad.setId(a(jSONObjectOptJSONObject, "id"));
                regeocodeRoad.setName(a(jSONObjectOptJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(c(jSONObjectOptJSONObject, "location"));
                regeocodeRoad.setDirection(a(jSONObjectOptJSONObject, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
                regeocodeRoad.setDistance(t(a(jSONObjectOptJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    private static boolean o(String str) {
        if (str != null && str.length() > 0) {
            for (String str2 : f2693a) {
                if (str.trim().equals(str2.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static LocalWeatherForecast h(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("forecasts")) {
                return null;
            }
            LocalWeatherForecast localWeatherForecast = new LocalWeatherForecast();
            JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
                if (jSONObjectOptJSONObject == null) {
                    return localWeatherForecast;
                }
                localWeatherForecast.setCity(a(jSONObjectOptJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                localWeatherForecast.setAdCode(a(jSONObjectOptJSONObject, "adcode"));
                localWeatherForecast.setProvince(a(jSONObjectOptJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                localWeatherForecast.setReportTime(a(jSONObjectOptJSONObject, "reporttime"));
                if (!jSONObjectOptJSONObject.has("casts")) {
                    return localWeatherForecast;
                }
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("casts");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject2 != null) {
                            localDayWeatherForecast.setDate(a(jSONObjectOptJSONObject2, FFmpegMediaMetadataRetriever.METADATA_KEY_DATE));
                            localDayWeatherForecast.setWeek(a(jSONObjectOptJSONObject2, "week"));
                            localDayWeatherForecast.setDayWeather(a(jSONObjectOptJSONObject2, "dayweather"));
                            localDayWeatherForecast.setNightWeather(a(jSONObjectOptJSONObject2, "nightweather"));
                            localDayWeatherForecast.setDayTemp(a(jSONObjectOptJSONObject2, "daytemp"));
                            localDayWeatherForecast.setNightTemp(a(jSONObjectOptJSONObject2, "nighttemp"));
                            localDayWeatherForecast.setDayWindDirection(a(jSONObjectOptJSONObject2, "daywind"));
                            localDayWeatherForecast.setNightWindDirection(a(jSONObjectOptJSONObject2, "nightwind"));
                            localDayWeatherForecast.setDayWindPower(a(jSONObjectOptJSONObject2, "daypower"));
                            localDayWeatherForecast.setNightWindPower(a(jSONObjectOptJSONObject2, "nightpower"));
                            arrayList.add(localDayWeatherForecast);
                        }
                    }
                    localWeatherForecast.setWeatherForecast(arrayList);
                    return localWeatherForecast;
                }
                localWeatherForecast.setWeatherForecast(arrayList);
            }
            return localWeatherForecast;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherLive g(String str) throws AMapException {
        JSONObject jSONObjectOptJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("lives")) {
                return null;
            }
            LocalWeatherLive localWeatherLive = new LocalWeatherLive();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("lives");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
                return localWeatherLive;
            }
            localWeatherLive.setAdCode(a(jSONObjectOptJSONObject, "adcode"));
            localWeatherLive.setProvince(a(jSONObjectOptJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
            localWeatherLive.setCity(a(jSONObjectOptJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
            localWeatherLive.setWeather(a(jSONObjectOptJSONObject, "weather"));
            localWeatherLive.setTemperature(a(jSONObjectOptJSONObject, "temperature"));
            localWeatherLive.setWindDirection(a(jSONObjectOptJSONObject, "winddirection"));
            localWeatherLive.setWindPower(a(jSONObjectOptJSONObject, "windpower"));
            localWeatherLive.setHumidity(a(jSONObjectOptJSONObject, "humidity"));
            localWeatherLive.setReportTime(a(jSONObjectOptJSONObject, "reporttime"));
            return localWeatherLive;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DriveRouteResult c(String str) throws AMapException {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            DriveRouteResult driveRouteResult = new DriveRouteResult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("route");
            if (jSONObjectOptJSONObject == null) {
                return driveRouteResult;
            }
            driveRouteResult.setStartPos(c(jSONObjectOptJSONObject, "origin"));
            driveRouteResult.setTargetPos(c(jSONObjectOptJSONObject, az.au));
            driveRouteResult.setTaxiCost(t(a(jSONObjectOptJSONObject, "taxi_cost")));
            if (!jSONObjectOptJSONObject.has("paths") || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths")) == null) {
                return driveRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < jSONArrayOptJSONArray.length()) {
                DrivePath drivePath = new DrivePath();
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    drivePath.setDistance(t(a(jSONObjectOptJSONObject2, "distance")));
                    drivePath.setDuration(v(a(jSONObjectOptJSONObject2, "duration")));
                    drivePath.setStrategy(a(jSONObjectOptJSONObject2, WkAdConfigModel.TAG_STRATEGY));
                    drivePath.setTolls(t(a(jSONObjectOptJSONObject2, "tolls")));
                    drivePath.setTollDistance(t(a(jSONObjectOptJSONObject2, "toll_distance")));
                    drivePath.setTotalTrafficlights(s(a(jSONObjectOptJSONObject2, "traffic_lights")));
                    drivePath.setRestriction(s(a(jSONObjectOptJSONObject2, "restriction")));
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("steps");
                    if (jSONArrayOptJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int i2 = 0;
                        while (i2 < jSONArrayOptJSONArray2.length()) {
                            DriveStep driveStep = new DriveStep();
                            JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i2);
                            if (jSONObjectOptJSONObject3 != null) {
                                jSONArray2 = jSONArrayOptJSONArray;
                                driveStep.setInstruction(a(jSONObjectOptJSONObject3, "instruction"));
                                driveStep.setOrientation(a(jSONObjectOptJSONObject3, bq.f.V));
                                driveStep.setRoad(a(jSONObjectOptJSONObject3, "road"));
                                driveStep.setDistance(t(a(jSONObjectOptJSONObject3, "distance")));
                                driveStep.setTolls(t(a(jSONObjectOptJSONObject3, "tolls")));
                                driveStep.setTollDistance(t(a(jSONObjectOptJSONObject3, "toll_distance")));
                                driveStep.setTollRoad(a(jSONObjectOptJSONObject3, "toll_road"));
                                driveStep.setDuration(t(a(jSONObjectOptJSONObject3, "duration")));
                                driveStep.setPolyline(d(jSONObjectOptJSONObject3, "polyline"));
                                driveStep.setAction(a(jSONObjectOptJSONObject3, "action"));
                                driveStep.setAssistantAction(a(jSONObjectOptJSONObject3, "assistant_action"));
                                b(driveStep, jSONObjectOptJSONObject3);
                                a(driveStep, jSONObjectOptJSONObject3);
                                arrayList2.add(driveStep);
                            } else {
                                jSONArray2 = jSONArrayOptJSONArray;
                            }
                            i2++;
                            jSONArrayOptJSONArray = jSONArray2;
                        }
                        jSONArray = jSONArrayOptJSONArray;
                        drivePath.setSteps(arrayList2);
                        b(drivePath, arrayList2);
                        arrayList.add(drivePath);
                    } else {
                        jSONArray = jSONArrayOptJSONArray;
                    }
                }
                i++;
                jSONArrayOptJSONArray = jSONArray;
            }
            driveRouteResult.setPaths(arrayList);
            return driveRouteResult;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            di.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static DriveRouteResultV2 d(String str) throws AMapException {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            DriveRouteResultV2 driveRouteResultV2 = new DriveRouteResultV2();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("route");
            if (jSONObjectOptJSONObject == null) {
                return driveRouteResultV2;
            }
            driveRouteResultV2.setStartPos(c(jSONObjectOptJSONObject, "origin"));
            driveRouteResultV2.setTargetPos(c(jSONObjectOptJSONObject, az.au));
            driveRouteResultV2.setTaxiCost(t(a(jSONObjectOptJSONObject, "taxi_cost")));
            if (!jSONObjectOptJSONObject.has("paths") || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths")) == null) {
                return driveRouteResultV2;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                DrivePathV2 drivePathV2 = new DrivePathV2();
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    drivePathV2.setDistance(t(a(jSONObjectOptJSONObject2, "distance")));
                    drivePathV2.setStrategy(a(jSONObjectOptJSONObject2, WkAdConfigModel.TAG_STRATEGY));
                    drivePathV2.setRestriction(s(a(jSONObjectOptJSONObject2, "restriction")));
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(SharePluginInfo.ISSUE_COST);
                    if (jSONObjectOptJSONObject3 != null) {
                        Cost cost = new Cost();
                        a(cost, jSONObjectOptJSONObject3);
                        drivePathV2.setCost(cost);
                    }
                    JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("elec_consume_info");
                    if (jSONObjectOptJSONObject4 != null) {
                        drivePathV2.setElecConsumeInfo(O(jSONObjectOptJSONObject4));
                    }
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("charge_station_info");
                    if (jSONArrayOptJSONArray2 != null) {
                        drivePathV2.setChargeStationInfo(c(jSONArrayOptJSONArray2));
                    }
                    JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("steps");
                    if (jSONArrayOptJSONArray3 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray3.length(); i2++) {
                            DriveStepV2 driveStepV2 = new DriveStepV2();
                            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray3.optJSONObject(i2);
                            if (jSONObjectOptJSONObject5 != null) {
                                driveStepV2.setInstruction(a(jSONObjectOptJSONObject5, "instruction"));
                                driveStepV2.setOrientation(a(jSONObjectOptJSONObject5, bq.f.V));
                                driveStepV2.setStepDistance(s(a(jSONObjectOptJSONObject5, "step_distance")));
                                driveStepV2.setRoad(a(jSONObjectOptJSONObject5, "road_name"));
                                driveStepV2.setPolyline(d(jSONObjectOptJSONObject5, "polyline"));
                                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject(SharePluginInfo.ISSUE_COST);
                                if (jSONObjectOptJSONObject6 != null) {
                                    Cost cost2 = new Cost();
                                    a(cost2, jSONObjectOptJSONObject6);
                                    driveStepV2.setCostDetail(cost2);
                                }
                                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject5.optJSONObject("navi");
                                if (jSONObjectOptJSONObject7 != null) {
                                    driveStepV2.setNavi(P(jSONObjectOptJSONObject7));
                                }
                                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject5.optJSONArray("cities");
                                if (jSONArrayOptJSONArray4 != null) {
                                    driveStepV2.setRouteSearchCityList(e(jSONArrayOptJSONArray4));
                                }
                                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject5.optJSONArray("tmcs");
                                if (jSONArrayOptJSONArray5 != null) {
                                    driveStepV2.setTMCs(d(jSONArrayOptJSONArray5));
                                }
                                arrayList2.add(driveStepV2);
                            }
                        }
                        drivePathV2.setSteps(arrayList2);
                        c(drivePathV2, arrayList2);
                        arrayList.add(drivePathV2);
                    }
                }
            }
            driveRouteResultV2.setPaths(arrayList);
            return driveRouteResultV2;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            di.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static TruckRouteRestult m(String str) throws AMapException {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data").optJSONObject("route");
            truckRouteRestult.setStartPos(c(jSONObjectOptJSONObject, "origin"));
            truckRouteRestult.setTargetPos(c(jSONObjectOptJSONObject, az.au));
            if (!jSONObjectOptJSONObject.has("paths") || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths")) == null) {
                return truckRouteRestult;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                TruckPath truckPath = new TruckPath();
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                truckPath.setDistance(t(a(jSONObject2, "distance")));
                truckPath.setDuration(v(a(jSONObject2, "duration")));
                truckPath.setStrategy(a(jSONObject2, WkAdConfigModel.TAG_STRATEGY));
                truckPath.setTolls(t(a(jSONObject2, "tolls")));
                truckPath.setTollDistance(t(a(jSONObject2, "toll_distance")));
                truckPath.setTotalTrafficlights(s(a(jSONObject2, "traffic_lights")));
                truckPath.setRestriction(s(a(jSONObject2, "restriction")));
                JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("steps");
                if (jSONArrayOptJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        TruckStep truckStep = new TruckStep();
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i2);
                        if (jSONObjectOptJSONObject2 != null) {
                            truckStep.setInstruction(a(jSONObjectOptJSONObject2, "instruction"));
                            truckStep.setOrientation(a(jSONObjectOptJSONObject2, bq.f.V));
                            truckStep.setRoad(a(jSONObjectOptJSONObject2, "road"));
                            truckStep.setDistance(t(a(jSONObjectOptJSONObject2, "distance")));
                            truckStep.setTolls(t(a(jSONObjectOptJSONObject2, "tolls")));
                            truckStep.setTollDistance(t(a(jSONObjectOptJSONObject2, "toll_distance")));
                            truckStep.setTollRoad(a(jSONObjectOptJSONObject2, "toll_road"));
                            truckStep.setDuration(t(a(jSONObjectOptJSONObject2, "duration")));
                            truckStep.setPolyline(d(jSONObjectOptJSONObject2, "polyline"));
                            truckStep.setAction(a(jSONObjectOptJSONObject2, "action"));
                            truckStep.setAssistantAction(a(jSONObjectOptJSONObject2, "assistant_action"));
                            a(truckStep, jSONObjectOptJSONObject2);
                            b(truckStep, jSONObjectOptJSONObject2);
                            arrayList2.add(truckStep);
                        }
                    }
                    truckPath.setSteps(arrayList2);
                    arrayList.add(truckPath);
                }
            }
            truckRouteRestult.setPaths(arrayList);
            return truckRouteRestult;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseTruckRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static ArrayList<LatLonPoint> p(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        for (String str2 : str.split(x.aQ)) {
            arrayList.add(q(str2));
        }
        return arrayList;
    }

    private static int s(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            di.a(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    public static RideRouteResultV2 k(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            RideRouteResultV2 rideRouteResultV2 = new RideRouteResultV2();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("route");
            rideRouteResultV2.setStartPos(c(jSONObjectOptJSONObject, "origin"));
            rideRouteResultV2.setTargetPos(c(jSONObjectOptJSONObject, az.au));
            ArrayList arrayList = new ArrayList();
            Object objOpt = jSONObjectOptJSONObject.opt("paths");
            if (objOpt == null) {
                rideRouteResultV2.setPaths(arrayList);
                return rideRouteResultV2;
            }
            if (objOpt instanceof JSONArray) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths");
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    RidePath ridePathT = T(jSONArrayOptJSONArray.optJSONObject(i));
                    if (ridePathT != null) {
                        arrayList.add(ridePathT);
                    }
                }
            }
            rideRouteResultV2.setPaths(arrayList);
            return rideRouteResultV2;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseRideRouteV2");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x020a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DriveRoutePlanResult n(String str) throws AMapException {
        String str2;
        String str3;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        String str4;
        JSONArray jSONArray;
        String str5;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        String str6;
        JSONArray jSONArray5;
        String str7 = "starttime";
        String str8 = "协议解析错误 - ProtocolException";
        try {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("errcode")) {
                        jSONObject.optInt("errcode");
                        jSONObject.optString("errmsg");
                        jSONObject.optString("errdetail");
                    }
                    if (!jSONObject.has("data")) {
                        return null;
                    }
                    DriveRoutePlanResult driveRoutePlanResult = new DriveRoutePlanResult();
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                    if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("paths") || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths")) == null) {
                        return driveRoutePlanResult;
                    }
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (i < jSONArrayOptJSONArray.length()) {
                        DrivePlanPath drivePlanPath = new DrivePlanPath();
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject2 != null) {
                            drivePlanPath.setDistance(t(a(jSONObjectOptJSONObject2, "distance")));
                            drivePlanPath.setTrafficLights(s(a(jSONObjectOptJSONObject2, "traffic_lights")));
                            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("steps");
                            if (jSONArrayOptJSONArray3 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                int i2 = 0;
                                while (i2 < jSONArrayOptJSONArray3.length()) {
                                    DrivePlanStep drivePlanStep = new DrivePlanStep();
                                    JSONArray jSONArray6 = jSONArrayOptJSONArray;
                                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i2);
                                    if (jSONObjectOptJSONObject3 != null) {
                                        jSONArray5 = jSONArrayOptJSONArray3;
                                        drivePlanStep.setAdCode(a(jSONObjectOptJSONObject3, "adcode"));
                                        drivePlanStep.setRoad(a(jSONObjectOptJSONObject3, "road"));
                                        drivePlanStep.setDistance(t(a(jSONObjectOptJSONObject3, "distance")));
                                        str2 = str8;
                                        try {
                                            drivePlanStep.setToll(s(a(jSONObjectOptJSONObject3, RouteSearch.DRIVING_EXCLUDE_TOLL)) == 1);
                                            drivePlanStep.setPolyline(d(jSONObjectOptJSONObject3, "polyline"));
                                            arrayList2.add(drivePlanStep);
                                        } catch (JSONException e) {
                                            e = e;
                                        } catch (Throwable th) {
                                            th = th;
                                            di.a(th, "JSONHelper", "parseDriveRouteThrowable");
                                            throw new AMapException(str2);
                                        }
                                    } else {
                                        str2 = str8;
                                        jSONArray5 = jSONArrayOptJSONArray3;
                                    }
                                    i2++;
                                    jSONArrayOptJSONArray = jSONArray6;
                                    jSONArrayOptJSONArray3 = jSONArray5;
                                    str8 = str2;
                                }
                                jSONArray4 = jSONArrayOptJSONArray;
                                str6 = str8;
                                drivePlanPath.setSteps(arrayList2);
                                arrayList.add(drivePlanPath);
                            } else {
                                jSONArray4 = jSONArrayOptJSONArray;
                                str6 = str8;
                            }
                        }
                        i++;
                        jSONArrayOptJSONArray = jSONArray4;
                        str8 = str6;
                    }
                    str2 = str8;
                    driveRoutePlanResult.setPaths(arrayList);
                    if (!jSONObjectOptJSONObject.has("time_infos") || (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("time_infos")) == null) {
                        return driveRoutePlanResult;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    int i3 = 0;
                    while (i3 < jSONArrayOptJSONArray2.length()) {
                        TimeInfo timeInfo = new TimeInfo();
                        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i3);
                        if (jSONObjectOptJSONObject4 == null) {
                            str4 = str7;
                            jSONArray = jSONArrayOptJSONArray2;
                        } else {
                            if (!jSONObjectOptJSONObject4.has(str7)) {
                                return driveRoutePlanResult;
                            }
                            timeInfo.setStartTime(v(a(jSONObjectOptJSONObject4, str7)));
                            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject4.optJSONArray("elements");
                            if (jSONArrayOptJSONArray4 != null) {
                                ArrayList arrayList4 = new ArrayList();
                                int i4 = 0;
                                while (i4 < jSONArrayOptJSONArray4.length()) {
                                    TimeInfosElement timeInfosElement = new TimeInfosElement();
                                    JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray4.optJSONObject(i4);
                                    if (jSONObjectOptJSONObject5 != null) {
                                        timeInfosElement.setPathindex(s(a(jSONObjectOptJSONObject5, "pathindex")));
                                        timeInfosElement.setDuration(t(a(jSONObjectOptJSONObject5, "duration")));
                                        timeInfosElement.setTolls(t(a(jSONObjectOptJSONObject5, "tolls")));
                                        int iS = s(a(jSONObjectOptJSONObject5, "restriction"));
                                        timeInfosElement.setRestriction((iS == 2 || iS == -1) ? 0 : 1);
                                        JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject5.optJSONArray("tmcs");
                                        if (jSONArrayOptJSONArray5 != null) {
                                            ArrayList arrayList5 = new ArrayList();
                                            str5 = str7;
                                            int i5 = 0;
                                            while (i5 < jSONArrayOptJSONArray5.length()) {
                                                TMC tmc = new TMC();
                                                JSONArray jSONArray7 = jSONArrayOptJSONArray2;
                                                JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray5.optJSONObject(i5);
                                                if (jSONObjectOptJSONObject6 != null) {
                                                    jSONArray3 = jSONArrayOptJSONArray5;
                                                    tmc.setStatus(a(jSONObjectOptJSONObject6, "status"));
                                                    tmc.setDistance(s(a(jSONObjectOptJSONObject6, "distance")));
                                                    tmc.setPolyline(d(jSONObjectOptJSONObject6, "polyline"));
                                                    arrayList5.add(tmc);
                                                } else {
                                                    jSONArray3 = jSONArrayOptJSONArray5;
                                                }
                                                i5++;
                                                jSONArrayOptJSONArray2 = jSONArray7;
                                                jSONArrayOptJSONArray5 = jSONArray3;
                                            }
                                            jSONArray2 = jSONArrayOptJSONArray2;
                                            timeInfosElement.setTMCs(arrayList5);
                                            arrayList4.add(timeInfosElement);
                                        } else {
                                            str5 = str7;
                                            jSONArray2 = jSONArrayOptJSONArray2;
                                        }
                                    }
                                    i4++;
                                    str7 = str5;
                                    jSONArrayOptJSONArray2 = jSONArray2;
                                }
                                str4 = str7;
                                jSONArray = jSONArrayOptJSONArray2;
                                timeInfo.setElements(arrayList4);
                                arrayList3.add(timeInfo);
                            }
                        }
                        i3++;
                        str7 = str4;
                        jSONArrayOptJSONArray2 = jSONArray;
                    }
                    driveRoutePlanResult.setTimeInfos(arrayList3);
                    return driveRoutePlanResult;
                } catch (JSONException e2) {
                    e = e2;
                    str2 = str8;
                }
                str3 = str2;
            } catch (JSONException e3) {
                e = e3;
                str3 = "协议解析错误 - ProtocolException";
            }
            di.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException(str3);
        } catch (Throwable th2) {
            th = th2;
            str2 = str8;
        }
    }

    public static DistanceResult l(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("results")) {
                return null;
            }
            DistanceResult distanceResult = new DistanceResult();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("results");
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                DistanceItem distanceItem = new DistanceItem();
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                distanceItem.setOriginId(s(a(jSONObject2, "origin_id")));
                distanceItem.setDestId(s(a(jSONObject2, "dest_id")));
                distanceItem.setDistance(t(a(jSONObject2, "distance")));
                distanceItem.setDuration(t(a(jSONObject2, "duration")));
                String strA = a(jSONObject2, "info");
                if (!TextUtils.isEmpty(strA)) {
                    distanceItem.setErrorInfo(strA);
                    distanceItem.setErrorCode(s(a(jSONObject2, "code")));
                }
                arrayList.add(distanceItem);
            }
            distanceResult.setDistanceResults(arrayList);
            return distanceResult;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseRouteDistance");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static boolean r(String str) {
        return str == null || str.equals("") || str.equals("0");
    }

    private static long v(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            di.a(e, "JSONHelper", "str2long");
            return 0L;
        }
    }

    public static BusRouteResultV2 b(String str) throws AMapException {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            BusRouteResultV2 busRouteResultV2 = new BusRouteResultV2();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("route");
            if (jSONObjectOptJSONObject == null) {
                return busRouteResultV2;
            }
            busRouteResultV2.setStartPos(c(jSONObjectOptJSONObject, "origin"));
            busRouteResultV2.setTargetPos(c(jSONObjectOptJSONObject, az.au));
            busRouteResultV2.setDistance(t(a(jSONObjectOptJSONObject, "distance")));
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(SharePluginInfo.ISSUE_COST);
            if (jSONObjectOptJSONObject2 != null) {
                busRouteResultV2.setTaxiCost(t(a(jSONObjectOptJSONObject2, "taxi_fee")));
            }
            if (!jSONObjectOptJSONObject.has("transits") || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("transits")) == null) {
                return busRouteResultV2;
            }
            busRouteResultV2.setPaths(b(jSONArrayOptJSONArray));
            return busRouteResultV2;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static boolean w(String str) {
        return (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) || str.equals("0") || !str.equals("1")) ? false : true;
    }

    private static LatLonPoint q(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return null;
        }
        String[] strArrSplit = str.split(",| ");
        if (strArrSplit.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0]));
    }

    private static float t(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            di.a(e, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    private static double u(String str) {
        if (str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            di.a(e, "JSONHelper", "str2float");
            return 0.0d;
        }
    }

    public static RideRouteResult j(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            RideRouteResult rideRouteResult = new RideRouteResult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            rideRouteResult.setStartPos(c(jSONObjectOptJSONObject, "origin"));
            rideRouteResult.setTargetPos(c(jSONObjectOptJSONObject, az.au));
            ArrayList arrayList = new ArrayList();
            Object objOpt = jSONObjectOptJSONObject.opt("paths");
            if (objOpt == null) {
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            if (objOpt instanceof JSONArray) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths");
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    RidePath ridePathS = S(jSONArrayOptJSONArray.optJSONObject(i));
                    if (ridePathS != null) {
                        arrayList.add(ridePathS);
                    }
                }
            } else if (objOpt instanceof JSONObject) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("paths");
                if (!jSONObjectOptJSONObject2.has(OapsWrapper.KEY_PATH)) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                RidePath ridePathS2 = S(jSONObjectOptJSONObject2.optJSONObject(OapsWrapper.KEY_PATH));
                if (ridePathS2 != null) {
                    arrayList.add(ridePathS2);
                }
            }
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static boolean i(String str) {
        return str == null || str.equals("");
    }

    private static PoiItemExtension i(JSONObject jSONObject, String str) throws JSONException {
        String strA;
        String strA2;
        JSONObject jSONObjectOptJSONObject;
        if (!jSONObject.has(str) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            strA = "";
            strA2 = "";
        } else {
            strA = a(jSONObjectOptJSONObject, "open_time");
            strA2 = a(jSONObjectOptJSONObject, "rating");
        }
        return new PoiItemExtension(strA, strA2);
    }

    public static ArrayList<SuggestionCity> a(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray jSONArrayOptJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (!jSONObject.has("cities") || (jSONArrayOptJSONArray = jSONObject.optJSONArray("cities")) == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(new SuggestionCity(a(jSONObjectOptJSONObject, "name"), a(jSONObjectOptJSONObject, "citycode"), a(jSONObjectOptJSONObject, "adcode"), s(a(jSONObjectOptJSONObject, "num"))));
            }
        }
        return arrayList;
    }

    private static Business g(JSONObject jSONObject, String str) throws JSONException {
        String strA;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        JSONObject jSONObjectOptJSONObject;
        if (!jSONObject.has(str) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            strA = "";
            str2 = strA;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
            str9 = str8;
            str10 = str9;
        } else {
            String strA2 = a(jSONObjectOptJSONObject, "business_area");
            String strA3 = a(jSONObjectOptJSONObject, "opentime_today");
            String strA4 = a(jSONObjectOptJSONObject, "opentime_week");
            String strA5 = a(jSONObjectOptJSONObject, "tel");
            String strA6 = a(jSONObjectOptJSONObject, "tag");
            String strA7 = a(jSONObjectOptJSONObject, "rating");
            String strA8 = a(jSONObjectOptJSONObject, SharePluginInfo.ISSUE_COST);
            String strA9 = a(jSONObjectOptJSONObject, "parking_type");
            String strA10 = a(jSONObjectOptJSONObject, "alias");
            strA = a(jSONObjectOptJSONObject, "cpid");
            str9 = strA9;
            str10 = strA10;
            str7 = strA7;
            str8 = strA8;
            str5 = strA5;
            str6 = strA6;
            str3 = strA3;
            str4 = strA4;
            str2 = strA2;
        }
        Business business = new Business(str2, str3, str4, str5, str6, str7, str8, str9, str10);
        business.setCPID(strA);
        return business;
    }

    public static WalkRouteResultV2 f(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResultV2 walkRouteResultV2 = new WalkRouteResultV2();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("route");
            walkRouteResultV2.setStartPos(c(jSONObjectOptJSONObject, "origin"));
            walkRouteResultV2.setTargetPos(c(jSONObjectOptJSONObject, az.au));
            if (!jSONObjectOptJSONObject.has("paths")) {
                return walkRouteResultV2;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths");
            if (jSONArrayOptJSONArray == null) {
                walkRouteResultV2.setPaths(arrayList);
                return walkRouteResultV2;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                WalkPath walkPath = new WalkPath();
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    walkPath.setDistance(t(a(jSONObjectOptJSONObject2, "distance")));
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(SharePluginInfo.ISSUE_COST);
                    if (jSONObjectOptJSONObject3 != null) {
                        walkPath.setDuration(v(a(jSONObjectOptJSONObject3, "duration")));
                    }
                    if (jSONObjectOptJSONObject2.has("steps")) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                if (jSONObjectOptJSONObject4 != null) {
                                    walkStep.setInstruction(a(jSONObjectOptJSONObject4, "instruction"));
                                    walkStep.setOrientation(a(jSONObjectOptJSONObject4, bq.f.V));
                                    walkStep.setRoad(a(jSONObjectOptJSONObject4, "road_name"));
                                    walkStep.setDistance(t(a(jSONObjectOptJSONObject4, "step_distance")));
                                    JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject(SharePluginInfo.ISSUE_COST);
                                    if (jSONObjectOptJSONObject5 != null) {
                                        walkStep.setDuration(t(a(jSONObjectOptJSONObject5, "duration")));
                                    }
                                    JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("navi");
                                    if (jSONObjectOptJSONObject6 != null) {
                                        walkStep.setAction(a(jSONObjectOptJSONObject6, "action"));
                                        walkStep.setAssistantAction(a(jSONObjectOptJSONObject6, "assistant_action"));
                                        walkStep.setRoadType(s(a(jSONObjectOptJSONObject6, "work_type")));
                                    }
                                    walkStep.setPolyline(d(jSONObjectOptJSONObject4, "polyline"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            a(walkPath, arrayList2);
                            arrayList.add(walkPath);
                        }
                    } else {
                        arrayList.add(walkPath);
                    }
                }
            }
            walkRouteResultV2.setPaths(arrayList);
            return walkRouteResultV2;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<BusPathV2> b(JSONArray jSONArray) throws JSONException {
        BusStepV2 busStepV2U;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPathV2 busPathV2 = new BusPathV2();
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(SharePluginInfo.ISSUE_COST);
                if (jSONObjectOptJSONObject2 != null) {
                    busPathV2.setDuration(v(a(jSONObjectOptJSONObject2, "duration")));
                    busPathV2.setCost(t(a(jSONObjectOptJSONObject2, "transit_fee")));
                }
                busPathV2.setDistance(t(a(jSONObjectOptJSONObject, "distance")));
                busPathV2.setNightBus(w(a(jSONObjectOptJSONObject, "nightflag")));
                busPathV2.setWalkDistance(t(a(jSONObjectOptJSONObject, "walking_distance")));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("segments");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float distance = 0.0f;
                    float distance2 = 0.0f;
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject3 != null && (busStepV2U = u(jSONObjectOptJSONObject3)) != null) {
                            arrayList2.add(busStepV2U);
                            if (busStepV2U.getWalk() != null) {
                                distance2 += busStepV2U.getWalk().getDistance();
                            }
                            if (busStepV2U.getBusLines() != null && busStepV2U.getBusLines().size() > 0) {
                                distance += busStepV2U.getBusLines().get(0).getDistance();
                            }
                        }
                    }
                    busPathV2.setSteps(arrayList2);
                    busPathV2.setBusDistance(distance);
                    busPathV2.setWalkDistance(distance2);
                    arrayList.add(busPathV2);
                }
            }
        }
        return arrayList;
    }

    public static void a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(r(jSONObjectOptJSONObject));
            }
        }
        if (districtItem != null) {
            districtItem.setSubDistrict(arrayList);
        }
    }

    private static PoiNavi h(JSONObject jSONObject, String str) throws JSONException {
        String strA;
        LatLonPoint latLonPointC;
        String strA2;
        LatLonPoint latLonPointC2;
        JSONObject jSONObjectOptJSONObject;
        if (!jSONObject.has(str) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            strA = "";
            latLonPointC = null;
            strA2 = "";
            latLonPointC2 = null;
        } else {
            strA = a(jSONObjectOptJSONObject, "navi_poiid");
            latLonPointC = c(jSONObjectOptJSONObject, "entr_location");
            latLonPointC2 = c(jSONObjectOptJSONObject, "exit_location");
            strA2 = a(jSONObjectOptJSONObject, "gridcode");
        }
        return new PoiNavi(strA, latLonPointC, latLonPointC2, strA2);
    }

    public static void a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Crossroad crossroad = new Crossroad();
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                crossroad.setId(a(jSONObjectOptJSONObject, "id"));
                crossroad.setDirection(a(jSONObjectOptJSONObject, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
                crossroad.setDistance(t(a(jSONObjectOptJSONObject, "distance")));
                crossroad.setCenterPoint(c(jSONObjectOptJSONObject, "location"));
                crossroad.setFirstRoadId(a(jSONObjectOptJSONObject, "first_id"));
                crossroad.setFirstRoadName(a(jSONObjectOptJSONObject, "first_name"));
                crossroad.setSecondRoadId(a(jSONObjectOptJSONObject, "second_id"));
                crossroad.setSecondRoadName(a(jSONObjectOptJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    private static List<RouteSearchCity> e(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(jSONObjectOptJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(jSONObjectOptJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(jSONObjectOptJSONObject, "adcode"));
                    a(routeSearchCity, jSONObjectOptJSONObject);
                    arrayList.add(routeSearchCity);
                }
            } catch (JSONException e) {
                di.a(e, "JSONHelper", "parseCrossCity");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
        return arrayList;
    }

    private static void b(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cities");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(jSONObjectOptJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(jSONObjectOptJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(jSONObjectOptJSONObject, "adcode"));
                    a(routeSearchCity, jSONObjectOptJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            driveStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setCountry(a(jSONObject, "country"));
        regeocodeAddress.setCountryCode(a(jSONObject, "countrycode"));
        regeocodeAddress.setProvince(a(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(a(jSONObject, DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(a(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(a(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(a(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(a(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(a(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(a(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(a(jSONObjectOptJSONObject, "street"));
        streetNumber.setNumber(a(jSONObjectOptJSONObject, EventParams.KEY_PARAM_NUMBER));
        streetNumber.setLatLonPoint(c(jSONObjectOptJSONObject, "location"));
        streetNumber.setDirection(a(jSONObjectOptJSONObject, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
        streetNumber.setDistance(t(a(jSONObjectOptJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(s(jSONObject));
        regeocodeAddress.setTowncode(a(jSONObject, "towncode"));
        a(regeocodeAddress);
    }

    private static List<ChargeStationInfo> c(JSONArray jSONArray) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                ChargeStationInfo chargeStationInfo = new ChargeStationInfo();
                chargeStationInfo.setName(a(jSONObject, "name"));
                chargeStationInfo.setPoiId(a(jSONObject, "poiid"));
                chargeStationInfo.setBrandName(a(jSONObject, "brand_name"));
                chargeStationInfo.setShowPoint(c(jSONObject, "show_point"));
                chargeStationInfo.setProjectivePoint(c(jSONObject, "projective_point"));
                chargeStationInfo.setMaxPower(b(jSONObject, "max_power"));
                chargeStationInfo.setChargePercent(b(jSONObject, "charge_percent"));
                chargeStationInfo.setChargeTime(b(jSONObject, "charge_time"));
                chargeStationInfo.setRemainingCapacity(b(jSONObject, "remaining_capacity"));
                chargeStationInfo.setVoltage(b(jSONObject, "voltage"));
                chargeStationInfo.setAmperage(b(jSONObject, "amperage"));
                chargeStationInfo.setStepIndex(b(jSONObject, "step_index"));
                arrayList.add(chargeStationInfo);
            }
            return arrayList;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseChargeStationInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static WalkRouteResult e(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("route");
            walkRouteResult.setStartPos(c(jSONObjectOptJSONObject, "origin"));
            walkRouteResult.setTargetPos(c(jSONObjectOptJSONObject, az.au));
            if (!jSONObjectOptJSONObject.has("paths")) {
                return walkRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("paths");
            if (jSONArrayOptJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                WalkPath walkPath = new WalkPath();
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    walkPath.setDistance(t(a(jSONObjectOptJSONObject2, "distance")));
                    walkPath.setDuration(v(a(jSONObjectOptJSONObject2, "duration")));
                    if (jSONObjectOptJSONObject2.has("steps")) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                if (jSONObjectOptJSONObject3 != null) {
                                    walkStep.setInstruction(a(jSONObjectOptJSONObject3, "instruction"));
                                    walkStep.setOrientation(a(jSONObjectOptJSONObject3, bq.f.V));
                                    walkStep.setRoad(a(jSONObjectOptJSONObject3, "road"));
                                    walkStep.setDistance(t(a(jSONObjectOptJSONObject3, "distance")));
                                    walkStep.setDuration(t(a(jSONObjectOptJSONObject3, "duration")));
                                    walkStep.setPolyline(d(jSONObjectOptJSONObject3, "polyline"));
                                    walkStep.setAction(a(jSONObjectOptJSONObject3, "action"));
                                    walkStep.setAssistantAction(a(jSONObjectOptJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            a(walkPath, arrayList2);
                            arrayList.add(walkPath);
                        }
                    } else {
                        arrayList.add(walkPath);
                    }
                }
            }
            walkRouteResult.setPaths(arrayList);
            return walkRouteResult;
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<TMC> d(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                TMC tmc = new TMC();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    tmc.setDistance(s(a(jSONObjectOptJSONObject, "tmc_distance")));
                    tmc.setStatus(a(jSONObjectOptJSONObject, "tmc_status"));
                    tmc.setPolyline(d(jSONObjectOptJSONObject, "tmc_polyline"));
                    arrayList.add(tmc);
                }
            } catch (JSONException e) {
                di.a(e, "JSONHelper", "parseTMCsV5");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
        return arrayList;
    }

    private static IndoorDataV2 f(JSONObject jSONObject, String str) throws JSONException {
        String strA;
        String strA2;
        int iS;
        JSONObject jSONObjectOptJSONObject;
        if (!jSONObject.has(str) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) == null) {
            strA = "";
            strA2 = "";
            iS = 0;
        } else {
            z = s(a(jSONObjectOptJSONObject, "indoor_map")) == 1;
            strA = a(jSONObjectOptJSONObject, "cpid");
            iS = s(a(jSONObjectOptJSONObject, "floor"));
            strA2 = a(jSONObjectOptJSONObject, "truefloor");
        }
        return new IndoorDataV2(z, strA, iS, strA2);
    }

    private static int b(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.optInt(str);
        }
        return -1;
    }

    private static void b(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tmcs");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                TMC tmc = new TMC();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    tmc.setDistance(s(a(jSONObjectOptJSONObject, "distance")));
                    tmc.setStatus(a(jSONObjectOptJSONObject, "status"));
                    tmc.setPolyline(d(jSONObjectOptJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            truckStep.setTMCs(arrayList);
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static ArrayList<LatLonPoint> d(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return p(jSONObject.optString(str));
        }
        return null;
    }

    private static void d(Path path, List<RideStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (RideStep rideStep : list) {
            if (rideStep != null && rideStep.getPolyline() != null) {
                polyline.addAll(rideStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static LatLonPoint c(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return q(jSONObject.optString(str));
        }
        return null;
    }

    public static void c(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                aoiItem.setId(a(jSONObjectOptJSONObject, "id"));
                aoiItem.setName(a(jSONObjectOptJSONObject, "name"));
                aoiItem.setAdcode(a(jSONObjectOptJSONObject, "adcode"));
                aoiItem.setLocation(c(jSONObjectOptJSONObject, "location"));
                aoiItem.setArea(Float.valueOf(t(a(jSONObjectOptJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    private static void a(RegeocodeAddress regeocodeAddress) {
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() <= 0) && o(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    public static BusRouteResult a(String str) throws AMapException {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            BusRouteResult busRouteResult = new BusRouteResult();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("route");
            if (jSONObjectOptJSONObject == null) {
                return busRouteResult;
            }
            busRouteResult.setStartPos(c(jSONObjectOptJSONObject, "origin"));
            busRouteResult.setTargetPos(c(jSONObjectOptJSONObject, az.au));
            busRouteResult.setTaxiCost(t(a(jSONObjectOptJSONObject, "taxi_cost")));
            if (!jSONObjectOptJSONObject.has("transits") || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("transits")) == null) {
                return busRouteResult;
            }
            busRouteResult.setPaths(a(jSONArrayOptJSONArray));
            return busRouteResult;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(Path path, List<DriveStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStep driveStep : list) {
            if (driveStep != null && driveStep.getPolyline() != null) {
                polyline.addAll(driveStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static void c(Path path, List<DriveStepV2> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStepV2 driveStepV2 : list) {
            if (driveStepV2 != null && driveStepV2.getPolyline() != null) {
                polyline.addAll(driveStepV2.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static List<BusPath> a(JSONArray jSONArray) throws JSONException {
        BusStep busStepT;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPath busPath = new BusPath();
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                busPath.setCost(t(a(jSONObjectOptJSONObject, SharePluginInfo.ISSUE_COST)));
                busPath.setDuration(v(a(jSONObjectOptJSONObject, "duration")));
                busPath.setNightBus(w(a(jSONObjectOptJSONObject, "nightflag")));
                busPath.setWalkDistance(t(a(jSONObjectOptJSONObject, "walking_distance")));
                busPath.setDistance(t(a(jSONObjectOptJSONObject, "distance")));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("segments");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float distance = 0.0f;
                    float distance2 = 0.0f;
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject2 != null && (busStepT = t(jSONObjectOptJSONObject2)) != null) {
                            arrayList2.add(busStepT);
                            if (busStepT.getWalk() != null) {
                                distance2 += busStepT.getWalk().getDistance();
                            }
                            if (busStepT.getBusLines() != null && busStepT.getBusLines().size() > 0) {
                                distance += busStepT.getBusLines().get(0).getDistance();
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(distance);
                    busPath.setWalkDistance(distance2);
                    arrayList.add(busPath);
                }
            }
        }
        return arrayList;
    }

    private static IndoorData e(JSONObject jSONObject, String str) throws JSONException {
        String strA;
        int iS;
        String strA2;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject.has(str) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(str)) != null && jSONObjectOptJSONObject.has("cpid") && jSONObjectOptJSONObject.has("floor")) {
            strA = a(jSONObjectOptJSONObject, "cpid");
            iS = s(a(jSONObjectOptJSONObject, "floor"));
            strA2 = a(jSONObjectOptJSONObject, "truefloor");
        } else {
            strA = "";
            iS = 0;
            strA2 = "";
        }
        return new IndoorData(strA, iS, strA2);
    }

    private static void a(Cost cost, JSONObject jSONObject) throws AMapException {
        try {
            cost.setTolls(t(a(jSONObject, "tolls")));
            cost.setTollDistance(t(a(jSONObject, "toll_distance")));
            cost.setTollRoad(a(jSONObject, "toll_road"));
            cost.setDuration(t(a(jSONObject, "duration")));
            cost.setTrafficLights(s(a(jSONObject, "traffic_lights")));
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseCostDetail");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tmcs");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                TMC tmc = new TMC();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    tmc.setDistance(s(a(jSONObjectOptJSONObject, "distance")));
                    tmc.setStatus(a(jSONObjectOptJSONObject, "status"));
                    tmc.setPolyline(d(jSONObjectOptJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
            }
            driveStep.setTMCs(arrayList);
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("districts");
                if (jSONArrayOptJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    District district = new District();
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        district.setDistrictName(a(jSONObjectOptJSONObject, "name"));
                        district.setDistrictAdcode(a(jSONObjectOptJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e) {
                di.a(e, "JSONHelper", "parseCrossDistricts");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || jSONObject.optString(str).equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) ? "" : jSONObject.optString(str).trim();
    }

    private static void a(PoiItem poiItem, JSONObject jSONObject) throws JSONException {
        List<Photo> listQ = Q(jSONObject.optJSONObject("deep_info"));
        if (listQ.size() == 0) {
            listQ = Q(jSONObject);
        }
        poiItem.setPhotos(listQ);
    }

    private static void a(PoiItemV2 poiItemV2, JSONObject jSONObject) throws JSONException {
        poiItemV2.setPhotos(Q(jSONObject));
    }

    private static void a(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cities");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(jSONObjectOptJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(jSONObjectOptJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(jSONObjectOptJSONObject, "adcode"));
                    a(routeSearchCity, jSONObjectOptJSONObject);
                    arrayList.add(routeSearchCity);
                }
            }
            truckStep.setRouteSearchCityList(arrayList);
        } catch (JSONException e) {
            di.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(Path path, List<WalkStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (WalkStep walkStep : list) {
            if (walkStep != null && walkStep.getPolyline() != null) {
                polyline.addAll(walkStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }
}
