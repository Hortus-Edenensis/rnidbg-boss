package com.baidu.mapapi.utils.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.IllegalNaviArgumentException;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.a;
import com.baidu.mapapi.utils.poi.IllegalPoiSearchArgumentException;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BaiduMapRoutePlan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3843a = true;

    private static void a(RouteParaOption routeParaOption, Context context, int i) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("https://api.map.baidu.com/direction?");
        sb.append("origin=");
        LatLng latLngGcjToBaidu = routeParaOption.f3844a;
        CoordType coordType = SDKInitializer.getCoordType();
        CoordType coordType2 = CoordType.GCJ02;
        if (coordType == coordType2 && latLngGcjToBaidu != null) {
            latLngGcjToBaidu = CoordTrans.gcjToBaidu(latLngGcjToBaidu);
        }
        if (routeParaOption.f3844a != null && (str2 = routeParaOption.c) != null && !str2.equals("") && latLngGcjToBaidu != null) {
            sb.append("latlng:");
            sb.append(latLngGcjToBaidu.latitude);
            sb.append(",");
            sb.append(latLngGcjToBaidu.longitude);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append("name:");
            sb.append(routeParaOption.c);
        } else if (routeParaOption.f3844a == null || latLngGcjToBaidu == null) {
            sb.append(routeParaOption.c);
        } else {
            sb.append(latLngGcjToBaidu.latitude);
            sb.append(",");
            sb.append(latLngGcjToBaidu.longitude);
        }
        if (!TextUtils.isEmpty(routeParaOption.getStartPoiId())) {
            sb.append("&origin_uid=");
            sb.append(routeParaOption.getStartPoiId());
        }
        LatLng latLngGcjToBaidu2 = routeParaOption.b;
        if (SDKInitializer.getCoordType() == coordType2 && latLngGcjToBaidu2 != null) {
            latLngGcjToBaidu2 = CoordTrans.gcjToBaidu(latLngGcjToBaidu2);
        }
        sb.append("&destination=");
        if (routeParaOption.b != null && (str = routeParaOption.d) != null && !str.equals("") && latLngGcjToBaidu2 != null) {
            sb.append("latlng:");
            sb.append(latLngGcjToBaidu2.latitude);
            sb.append(",");
            sb.append(latLngGcjToBaidu2.longitude);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append("name:");
            sb.append(routeParaOption.d);
        } else if (routeParaOption.b == null || latLngGcjToBaidu2 == null) {
            sb.append(routeParaOption.d);
        } else {
            sb.append(latLngGcjToBaidu2.latitude);
            sb.append(",");
            sb.append(latLngGcjToBaidu2.longitude);
        }
        if (!TextUtils.isEmpty(routeParaOption.getEndPoiId())) {
            sb.append("&destination_uid=");
            sb.append(routeParaOption.getEndPoiId());
        }
        String str3 = i != 0 ? i != 1 ? i != 2 ? "" : "walking" : "transit" : "driving";
        sb.append("&mode=");
        sb.append(str3);
        sb.append("&region=");
        if (routeParaOption.getCityName() == null || routeParaOption.getCityName().equals("")) {
            sb.append("全国");
        } else {
            sb.append(routeParaOption.getCityName());
        }
        sb.append("&output=html");
        sb.append("&src=");
        sb.append(context.getPackageName());
        Uri uri = Uri.parse(sb.toString());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(uri);
        context.startActivity(intent);
    }

    public static void finish(Context context) {
        if (context != null) {
            a.j(context);
        }
    }

    public static boolean openBaiduMapDrivingRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        String str = routeParaOption.c;
        if (str == null && routeParaOption.f3844a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        if ((TextUtils.isEmpty(str) && routeParaOption.f3844a == null) || (TextUtils.isEmpty(routeParaOption.d) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.h == null) {
            routeParaOption.h = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (!f3843a) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            a(routeParaOption, context, 0);
            return true;
        }
        if (baiduMapVersion >= 810) {
            return a.a(routeParaOption, context, 0);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (!f3843a) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
        a(routeParaOption, context, 0);
        return true;
    }

    public static boolean openBaiduMapNewEnergyRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        String str = routeParaOption.c;
        if (str == null && routeParaOption.f3844a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        if ((TextUtils.isEmpty(str) && routeParaOption.f3844a == null) || (TextUtils.isEmpty(routeParaOption.d) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.h == null) {
            routeParaOption.h = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (!f3843a) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            a(routeParaOption, context, 101);
            return true;
        }
        if (baiduMapVersion >= 810) {
            return a.a(routeParaOption, context, 101);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (!f3843a) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
        a(routeParaOption, context, 101);
        return true;
    }

    public static boolean openBaiduMapTransitRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        String str = routeParaOption.c;
        if (str == null && routeParaOption.f3844a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        if ((TextUtils.isEmpty(str) && routeParaOption.f3844a == null) || (TextUtils.isEmpty(routeParaOption.d) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.h == null) {
            routeParaOption.h = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (!f3843a) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            a(routeParaOption, context, 1);
            return true;
        }
        if (baiduMapVersion >= 810) {
            return a.a(routeParaOption, context, 1);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (!f3843a) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
        a(routeParaOption, context, 1);
        return true;
    }

    public static boolean openBaiduMapTruckRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        String str = routeParaOption.c;
        if (str == null && routeParaOption.f3844a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        if ((TextUtils.isEmpty(str) && routeParaOption.f3844a == null) || (TextUtils.isEmpty(routeParaOption.d) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.h == null) {
            routeParaOption.h = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (!f3843a) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            a(routeParaOption, context, 7);
            return true;
        }
        if (baiduMapVersion >= 810) {
            return a.a(routeParaOption, context, 102);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (!f3843a) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
        a(routeParaOption, context, 7);
        return true;
    }

    public static boolean openBaiduMapWalkingRoute(RouteParaOption routeParaOption, Context context) {
        if (routeParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        String str = routeParaOption.c;
        if (str == null && routeParaOption.f3844a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
        }
        if (routeParaOption.d == null && routeParaOption.b == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
        }
        if ((TextUtils.isEmpty(str) && routeParaOption.f3844a == null) || (TextUtils.isEmpty(routeParaOption.d) && routeParaOption.b == null)) {
            Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
            return false;
        }
        if (routeParaOption.h == null) {
            routeParaOption.h = RouteParaOption.EBusStrategyType.bus_recommend_way;
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (!f3843a) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            a(routeParaOption, context, 2);
            return true;
        }
        if (baiduMapVersion >= 810) {
            return a.a(routeParaOption, context, 2);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (!f3843a) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
        a(routeParaOption, context, 2);
        return true;
    }

    public static void setSupportWebRoute(boolean z) {
        f3843a = z;
    }
}
