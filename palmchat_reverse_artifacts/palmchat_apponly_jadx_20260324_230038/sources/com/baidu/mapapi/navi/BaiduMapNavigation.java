package com.baidu.mapapi.navi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.a;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BaiduMapNavigation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3742a = true;

    private static void a(NaviParaOption naviParaOption, Context context) throws IllegalNaviArgumentException {
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
        }
        LatLng latLng = naviParaOption.f3743a;
        if (latLng == null || naviParaOption.d == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: you must set start and end point.");
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(naviParaOption.d);
        StringBuilder sb = new StringBuilder();
        sb.append("https://app.navi.baidu.com/mobile/#navi/naving/");
        sb.append("&sy=0");
        sb.append("&endp=");
        sb.append("&start=");
        sb.append("&startwd=");
        sb.append("&endwd=");
        sb.append("&fromprod=map_sdk");
        sb.append("&app_version=");
        sb.append(VersionInfo.VERSION_INFO);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", "1");
            String str = naviParaOption.b;
            if (str == null || str.equals("")) {
                jSONObject.put("keyword", "");
            } else {
                jSONObject.put("keyword", naviParaOption.b);
            }
            jSONObject.put("xy", String.valueOf(geoPointLl2mc.getLongitudeE6()) + "," + String.valueOf(geoPointLl2mc.getLatitudeE6()));
            jSONArray.put(jSONObject);
            jSONObject2.put("type", "1");
            String str2 = naviParaOption.e;
            if (str2 == null || str2.equals("")) {
                jSONObject.put("keyword", "");
            } else {
                jSONObject.put("keyword", naviParaOption.e);
            }
            jSONObject2.put("xy", String.valueOf(geoPointLl2mc2.getLongitudeE6()) + "," + String.valueOf(geoPointLl2mc2.getLatitudeE6()));
            jSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONArray.length() > 0) {
            sb.append("&positions=");
            sb.append(jSONArray.toString());
        }
        sb.append("&ctrl_type=");
        sb.append("&mrsl=");
        sb.append("/vt=map&state=entry");
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

    public static boolean openBaiduMapBikeNavi(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
        }
        if (naviParaOption.d == null || naviParaOption.f3743a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            return false;
        }
        if (baiduMapVersion >= 869) {
            return a.a(naviParaOption, context, 8);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.6.6");
        return false;
    }

    public static boolean openBaiduMapNavi(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
        }
        if (naviParaOption.d == null || naviParaOption.f3743a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (!f3742a) {
                throw new BaiduMapAppNotSupportNaviException("BDMapSDKException: BaiduMap app is not installed.");
            }
            a(naviParaOption, context);
            return true;
        }
        if (baiduMapVersion >= 830) {
            return a.a(naviParaOption, context, 5);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.2");
        if (!f3742a) {
            throw new BaiduMapAppNotSupportNaviException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.2");
        }
        a(naviParaOption, context);
        return true;
    }

    public static boolean openBaiduMapWalkNavi(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
        }
        if (naviParaOption.d == null || naviParaOption.f3743a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            return false;
        }
        if (baiduMapVersion >= 869) {
            return a.a(naviParaOption, context, 7);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.6.6");
        return false;
    }

    public static boolean openBaiduMapWalkNaviAR(NaviParaOption naviParaOption, Context context) {
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
        }
        if (naviParaOption.d == null || naviParaOption.f3743a == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            return false;
        }
        if (baiduMapVersion >= 869) {
            return a.a(naviParaOption, context, 9);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.6.6");
        return false;
    }

    @Deprecated
    public static void openWebBaiduMapNavi(NaviParaOption naviParaOption, Context context) throws IllegalNaviArgumentException {
        String str;
        if (naviParaOption == null || context == null) {
            throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
        }
        LatLng latLng = naviParaOption.f3743a;
        if (latLng == null || naviParaOption.d == null) {
            String str2 = naviParaOption.b;
            if (str2 == null || str2.equals("") || (str = naviParaOption.e) == null || str.equals("")) {
                throw new IllegalNaviArgumentException("BDMapSDKException: you must set start and end point or set the start and end name.");
            }
            Uri uri = Uri.parse("https://daohang.map.baidu.com/mobile/#search/search/qt=nav&sn=2$$$$$$" + naviParaOption.b + "$$$$$$&en=2$$$$$$" + naviParaOption.e + "$$$$$$&fromprod=" + a(context));
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            context.startActivity(intent);
            return;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(naviParaOption.d);
        Uri uri2 = Uri.parse("https://daohang.map.baidu.com/mobile/#navi/naving/start=" + geoPointLl2mc.getLongitudeE6() + "," + geoPointLl2mc.getLatitudeE6() + "&endp=" + geoPointLl2mc2.getLongitudeE6() + "," + geoPointLl2mc2.getLatitudeE6() + "&fromprod=" + a(context) + "/vt=map&state=entry");
        Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.VIEW");
        intent2.setFlags(268435456);
        intent2.setData(uri2);
        context.startActivity(intent2);
    }

    public static void setSupportWebNavi(boolean z) {
        f3742a = z;
    }

    private static String a(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }
}
