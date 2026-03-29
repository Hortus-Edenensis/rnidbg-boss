package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.AppTools;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.mapapi.navi.TruckNaviOption;
import com.baidu.mapapi.utils.poi.DispathcPoiData;
import com.baidu.mapapi.utils.poi.PoiParaOption;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.a;
import com.baidu.mapframework.open.aidl.b;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.verify.SignUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    private static double A = 0.0d;
    private static double B = 0.0d;
    private static double C = 0.0d;
    private static double D = 0.0d;
    private static double E = 0.0d;
    private static int F = 0;
    private static boolean G = false;
    private static String H = null;
    private static int I = 0;
    private static int J = 0;
    private static int K = 0;
    private static int L = 0;
    private static int M = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3835a = "com.baidu.mapapi.utils.a";
    private static com.baidu.mapframework.open.aidl.a b = null;
    private static IComOpenClient c = null;
    public static int d = -1;
    private static int e;
    private static String f;
    private static String g;
    private static String h;
    private static String q;
    private static RouteParaOption.EBusStrategyType r;
    private static Thread y;
    private static int z;
    private static List<DispathcPoiData> i = new ArrayList();
    private static LatLng j = null;
    private static LatLng k = null;
    private static String l = null;
    private static String m = null;
    private static String n = null;
    private static String o = null;
    private static String p = null;
    private static String s = null;
    private static String t = null;
    private static LatLng u = null;
    private static int v = 0;
    private static boolean w = false;
    private static boolean x = false;
    static ServiceConnection N = new b();

    /* JADX INFO: renamed from: com.baidu.mapapi.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class BinderC0073a extends b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3836a;

        public BinderC0073a(int i) {
            this.f3836a = i;
        }

        @Override // com.baidu.mapframework.open.aidl.b
        public void a(IBinder iBinder) throws RemoteException {
            Log.d(a.f3835a, "onClientReady");
            if (a.c != null) {
                IComOpenClient unused = a.c = null;
            }
            IComOpenClient unused2 = a.c = IComOpenClient.a.b(iBinder);
            a.a(this.f3836a);
            boolean unused3 = a.w = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements ServiceConnection {

        /* JADX INFO: renamed from: com.baidu.mapapi.utils.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class BinderC0074a extends b.a {
            public BinderC0074a() {
            }

            @Override // com.baidu.mapframework.open.aidl.b
            public void a(IBinder iBinder) throws RemoteException {
                Log.d(a.f3835a, "onClientReady");
                if (a.c != null) {
                    IComOpenClient unused = a.c = null;
                }
                IComOpenClient unused2 = a.c = IComOpenClient.a.b(iBinder);
                if (!a.w) {
                    a.a(a.d);
                }
                boolean unused3 = a.w = true;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.y != null) {
                a.y.interrupt();
            }
            Log.d(a.f3835a, "onServiceConnected " + componentName);
            try {
                if (a.b != null) {
                    com.baidu.mapframework.open.aidl.a unused = a.b = null;
                }
                com.baidu.mapframework.open.aidl.a unused2 = a.b = a.AbstractBinderC0078a.b(iBinder);
                a.b.a(new BinderC0074a());
            } catch (RemoteException e) {
                Log.d(a.f3835a, "getComOpenClient ", e);
                if (a.b != null) {
                    com.baidu.mapframework.open.aidl.a unused3 = a.b = null;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(a.f3835a, "onServiceDisconnected " + componentName);
            if (a.b != null) {
                com.baidu.mapframework.open.aidl.a unused = a.b = null;
                boolean unused2 = a.x = false;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3838a;
        final /* synthetic */ int b;

        public c(Context context, int i) {
            this.f3838a = context;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            do {
                if (System.currentTimeMillis() - jCurrentTimeMillis > 3000) {
                    a.j(this.f3838a);
                    a.a(this.b, this.f3838a);
                }
            } while (!a.y.isInterrupted());
        }
    }

    private static void f(Context context) {
        Thread thread = y;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            j = CoordTrans.gcjToBaidu(j);
            k = CoordTrans.gcjToBaidu(k);
        }
        if (j == null || k == null) {
            return;
        }
        sb.append("origin=");
        sb.append(j.latitude);
        sb.append(",");
        sb.append(j.longitude);
        if (!TextUtils.isEmpty(l)) {
            sb.append("&origin_uid=");
            sb.append(l);
        }
        sb.append("&destination=");
        sb.append(k.latitude);
        sb.append(",");
        sb.append(k.longitude);
        if (!TextUtils.isEmpty(m)) {
            sb.append("&destination_uid=");
            sb.append(m);
        }
        sb.append("&src=");
        sb.append("sdk_[" + f + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void g(Context context) {
        Thread thread = y;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/walknavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            j = CoordTrans.gcjToBaidu(j);
            k = CoordTrans.gcjToBaidu(k);
        }
        if (j == null || k == null) {
            return;
        }
        sb.append("origin=");
        sb.append(j.latitude);
        sb.append(",");
        sb.append(j.longitude);
        if (!TextUtils.isEmpty(l)) {
            sb.append("&origin_uid=");
            sb.append(l);
        }
        sb.append("&destination=");
        sb.append(k.latitude);
        sb.append(",");
        sb.append(k.longitude);
        if (!TextUtils.isEmpty(m)) {
            sb.append("&destination_uid=");
            sb.append(m);
        }
        sb.append("&mode=");
        sb.append("walking_ar");
        sb.append("&src=");
        sb.append("sdk_[" + f + "]");
        Log.e("test", sb.toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void h(Context context) {
        Thread thread = y;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/place/detail?");
        sb.append("uid=");
        sb.append(s);
        sb.append("&show_type=");
        sb.append("detail_page");
        sb.append("&src=");
        sb.append("sdk_[" + f + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void i(Context context) {
        Thread thread = y;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/nearbysearch?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            u = CoordTrans.gcjToBaidu(u);
        }
        sb.append("center=");
        sb.append(u.latitude);
        sb.append(",");
        sb.append(u.longitude);
        sb.append("&query=");
        sb.append(t);
        sb.append("&radius=");
        sb.append(v);
        sb.append("&src=");
        sb.append("sdk_[" + f + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void j(Context context) {
        if (x) {
            context.unbindService(N);
            x = false;
        }
    }

    private static boolean k() {
        String str;
        String strA;
        try {
            str = f3835a;
            Log.d(str, "callDispatchTakeOutRouteRidingNavi");
            strA = c.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(f3835a, "callDispatchTakeOut exception", e2);
        }
        if (strA == null) {
            Log.d(str, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.umeng.ccg.a.F, "bikenavi_page");
        Bundle bundle2 = new Bundle();
        bundle2.putString("coord_type", "bd09ll");
        StringBuffer stringBuffer = new StringBuffer();
        if (n != null) {
            stringBuffer.append("name:" + n + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        CoordType coordType = SDKInitializer.getCoordType();
        CoordType coordType2 = CoordType.GCJ02;
        if (coordType == coordType2) {
            j = CoordTrans.gcjToBaidu(j);
        }
        stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(j.latitude), Double.valueOf(j.longitude)));
        if (!TextUtils.isEmpty(l)) {
            stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            stringBuffer.append("origin_uid:");
            stringBuffer.append(l);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        if (o != null) {
            stringBuffer2.append("name:" + o + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        if (SDKInitializer.getCoordType() == coordType2) {
            k = CoordTrans.gcjToBaidu(k);
        }
        stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(k.latitude), Double.valueOf(k.longitude)));
        if (!TextUtils.isEmpty(m)) {
            stringBuffer2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            stringBuffer2.append("destination_uid:");
            stringBuffer2.append(m);
        }
        bundle2.putString("origin", stringBuffer.toString());
        bundle2.putString(az.au, stringBuffer2.toString());
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + f + "]");
        bundle.putBundle("ext_params", bundle3);
        return c.a("map.android.baidu.mainmap", strA, bundle);
    }

    private static boolean l() {
        String str;
        String strA;
        try {
            str = f3835a;
            Log.d(str, "callDispatchTakeOutRouteNavi");
            strA = c.a("map.android.baidu.mainmap");
        } catch (Exception e2) {
            Log.d(f3835a, "callDispatchTakeOut exception", e2);
        }
        if (strA == null) {
            Log.d(str, "callDispatchTakeOut com not found");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.umeng.ccg.a.F, "walknavi_page");
        Bundle bundle2 = new Bundle();
        bundle2.putString("coord_type", "bd09ll");
        StringBuffer stringBuffer = new StringBuffer();
        if (n != null) {
            stringBuffer.append("name:" + n + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        CoordType coordType = SDKInitializer.getCoordType();
        CoordType coordType2 = CoordType.GCJ02;
        if (coordType == coordType2) {
            j = CoordTrans.gcjToBaidu(j);
        }
        stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(j.latitude), Double.valueOf(j.longitude)));
        if (!TextUtils.isEmpty(l)) {
            stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            stringBuffer.append("origin_uid:");
            stringBuffer.append(l);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        if (o != null) {
            stringBuffer2.append("name:" + o + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        if (SDKInitializer.getCoordType() == coordType2) {
            k = CoordTrans.gcjToBaidu(k);
        }
        stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(k.latitude), Double.valueOf(k.longitude)));
        if (!TextUtils.isEmpty(m)) {
            stringBuffer2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            stringBuffer2.append("destination_uid:");
            stringBuffer2.append(m);
        }
        bundle2.putString("origin", stringBuffer.toString());
        bundle2.putString(az.au, stringBuffer2.toString());
        bundle.putBundle("base_params", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("launch_from", "sdk_[" + f + "]");
        bundle.putBundle("ext_params", bundle3);
        return c.a("map.android.baidu.mainmap", strA, bundle);
    }

    public static String m() {
        return AppTools.getBaiduMapToken();
    }

    private static void c(Context context, int i2) {
        Thread thread = y;
        if (thread != null) {
            thread.interrupt();
        }
        if (i2 == 101) {
            i2 = 3;
        }
        if (i2 == 102) {
            i2 = 4;
        }
        String[] strArr = {"driving", "transit", "walking", "neweng", "truck"};
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/direction?");
        sb.append("origin=");
        if (j != null && SDKInitializer.getCoordType() == CoordType.GCJ02) {
            j = CoordTrans.gcjToBaidu(j);
        }
        if (!TextUtils.isEmpty(n) && j != null) {
            sb.append("name:");
            sb.append(n);
            sb.append("|latlng:");
            sb.append(j.latitude);
            sb.append(",");
            sb.append(j.longitude);
        } else if (TextUtils.isEmpty(n)) {
            LatLng latLng = j;
            if (latLng != null) {
                sb.append(latLng.latitude);
                sb.append(",");
                sb.append(j.longitude);
            }
        } else {
            sb.append(n);
        }
        if (!TextUtils.isEmpty(l)) {
            sb.append("&origin_uid=");
            sb.append(l);
        }
        sb.append("&destination=");
        if (k != null && SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
        }
        if (!TextUtils.isEmpty(o) && k != null) {
            sb.append("name:");
            sb.append(o);
            sb.append("|latlng:");
            sb.append(k.latitude);
            sb.append(",");
            sb.append(k.longitude);
        } else if (TextUtils.isEmpty(o)) {
            LatLng latLng2 = k;
            if (latLng2 != null) {
                sb.append(latLng2.latitude);
                sb.append(",");
                sb.append(k.longitude);
            }
        } else {
            sb.append(o);
        }
        if (!TextUtils.isEmpty(m)) {
            sb.append("&destination_uid=");
            sb.append(m);
        }
        sb.append("&mode=");
        sb.append(strArr[i2]);
        sb.append("&target=");
        sb.append("1");
        sb.append("&src=");
        sb.append("sdk_[" + f + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void d(Context context) {
        Thread thread = y;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/bikenavi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            j = CoordTrans.gcjToBaidu(j);
            k = CoordTrans.gcjToBaidu(k);
        }
        if (j == null || k == null) {
            return;
        }
        sb.append("origin=");
        sb.append(j.latitude);
        sb.append(",");
        sb.append(j.longitude);
        if (!TextUtils.isEmpty(l)) {
            sb.append("&origin_uid=");
            sb.append(l);
        }
        sb.append("&destination=");
        sb.append(k.latitude);
        sb.append(",");
        sb.append(k.longitude);
        if (!TextUtils.isEmpty(m)) {
            sb.append("&destination_uid=");
            sb.append(m);
        }
        sb.append("&src=");
        sb.append("sdk_[" + f + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void e(Context context) {
        Thread thread = y;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/navi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            j = CoordTrans.gcjToBaidu(j);
            k = CoordTrans.gcjToBaidu(k);
        }
        sb.append("origin=");
        sb.append(j.latitude);
        sb.append(",");
        sb.append(j.longitude);
        if (!TextUtils.isEmpty(l)) {
            sb.append("&origin_uid=");
            sb.append(l);
        }
        sb.append("&location=");
        sb.append(k.latitude);
        sb.append(",");
        sb.append(k.longitude);
        if (!TextUtils.isEmpty(m)) {
            sb.append("&destination_uid=");
            sb.append(m);
        }
        sb.append("&src=");
        sb.append("sdk_[" + f + "]");
        if (!TextUtils.isEmpty(p)) {
            sb.append("&viaPoints=");
            sb.append(p);
        }
        sb.append("&type=");
        sb.append(q);
        sb.append("&mode=");
        sb.append("driving");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static boolean b(Context context, int i2) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!SignUtils.verifySign(context)) {
            Log.d(f3835a, "package sign verify failed");
            return false;
        }
        w = false;
        switch (i2) {
            case 0:
                d = 0;
                break;
            case 1:
                d = 1;
                break;
            case 2:
                d = 2;
                break;
            case 3:
                d = 3;
                break;
            case 4:
                d = 4;
                break;
            case 5:
                d = 5;
                break;
            case 6:
                d = 6;
                break;
            case 7:
                d = 7;
                break;
            case 8:
                d = 8;
                break;
            case 9:
                d = 9;
                break;
            default:
                switch (i2) {
                    case 101:
                        d = 101;
                        break;
                    case 102:
                        d = 102;
                        break;
                    case 103:
                        d = 103;
                        break;
                    case 104:
                        d = 104;
                        break;
                }
                break;
        }
        if (i2 == 9) {
            x = false;
        }
        com.baidu.mapframework.open.aidl.a aVar = b;
        if (aVar != null && x) {
            if (c != null) {
                w = true;
                return a(i2);
            }
            aVar.a(new BinderC0073a(i2));
        } else {
            a(context, i2);
        }
        return true;
    }

    private static boolean j() {
        String str;
        String strA;
        try {
            str = f3835a;
            Log.d(str, "callDispatchTakeOutRouteNavi");
            strA = c.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(f3835a, "callDispatchTakeOut exception", e2);
        }
        if (strA != null) {
            Bundle bundle = new Bundle();
            bundle.putString(com.umeng.ccg.a.F, "navigation_page");
            Bundle bundle2 = new Bundle();
            bundle2.putString("coord_type", "bd09ll");
            StringBuffer stringBuffer = new StringBuffer();
            if (n != null) {
                stringBuffer.append("name:" + n + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            }
            CoordType coordType = SDKInitializer.getCoordType();
            CoordType coordType2 = CoordType.GCJ02;
            if (coordType == coordType2) {
                j = CoordTrans.gcjToBaidu(j);
            }
            stringBuffer.append(String.format("latlng:%f,%f", Double.valueOf(j.latitude), Double.valueOf(j.longitude)));
            if (!TextUtils.isEmpty(l)) {
                stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                stringBuffer.append("origin_uid:");
                stringBuffer.append(l);
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            if (o != null) {
                stringBuffer2.append("name:" + o + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            }
            if (SDKInitializer.getCoordType() == coordType2) {
                k = CoordTrans.gcjToBaidu(k);
            }
            stringBuffer2.append(String.format("latlng:%f,%f", Double.valueOf(k.latitude), Double.valueOf(k.longitude)));
            if (!TextUtils.isEmpty(m)) {
                stringBuffer2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                stringBuffer2.append("destination_uid:");
                stringBuffer2.append(m);
            }
            bundle2.putString("origin", stringBuffer.toString());
            bundle2.putString(az.au, stringBuffer2.toString());
            if (!TextUtils.isEmpty(p)) {
                bundle2.putString("viaPoints", p);
            }
            if (!TextUtils.isEmpty(q)) {
                bundle2.putString("type", q);
            }
            bundle.putBundle("base_params", bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("launch_from", "sdk_[" + f + "]");
            bundle.putBundle("ext_params", bundle3);
            return c.a("map.android.baidu.mainmap", strA, bundle);
        }
        Log.d(str, "callDispatchTakeOut com not found");
        return false;
    }

    public static boolean a(RouteParaOption routeParaOption, Context context, int i2) {
        b(routeParaOption, context, i2);
        return b(context, i2);
    }

    public static boolean a(PoiParaOption poiParaOption, Context context, int i2) {
        b(poiParaOption, context, i2);
        return b(context, i2);
    }

    public static boolean a(NaviParaOption naviParaOption, Context context, int i2) {
        b(naviParaOption, context, i2);
        return b(context, i2);
    }

    public static boolean a(List<DispathcPoiData> list, Context context, int i2) {
        a(list, context);
        return b(context, i2);
    }

    private static boolean h() {
        try {
            String str = f3835a;
            Log.d(str, "callDispatchTakeOutPoiNearbySearch");
            String strA = c.a("map.android.baidu.mainmap");
            if (strA != null) {
                Bundle bundle = new Bundle();
                bundle.putString(com.umeng.ccg.a.F, "poi_search_page");
                Bundle bundle2 = new Bundle();
                String str2 = t;
                if (str2 != null) {
                    bundle2.putString("search_key", str2);
                } else {
                    bundle2.putString("search_key", "");
                }
                LatLng latLng = u;
                if (latLng != null) {
                    bundle2.putInt("center_pt_x", (int) CoordUtil.ll2mc(latLng).getLongitudeE6());
                    bundle2.putInt("center_pt_y", (int) CoordUtil.ll2mc(u).getLatitudeE6());
                } else {
                    bundle2.putString("search_key", "");
                }
                int i2 = v;
                if (i2 != 0) {
                    bundle2.putInt("search_radius", i2);
                } else {
                    bundle2.putInt("search_radius", 1000);
                }
                bundle2.putBoolean("is_direct_search", true);
                bundle2.putBoolean("is_direct_area_search", true);
                bundle.putBundle("base_params", bundle2);
                Bundle bundle3 = new Bundle();
                bundle3.putString("launch_from", "sdk_[" + f + "]");
                bundle.putBundle("ext_params", bundle3);
                return c.a("map.android.baidu.mainmap", strA, bundle);
            }
            Log.d(str, "callDispatchTakeOut com not found");
            return false;
        } catch (RemoteException e2) {
            Log.d(f3835a, "callDispatchTakeOut exception", e2);
            return false;
        }
    }

    public static boolean a(int i2) {
        if (i2 != 101 && i2 != 102) {
            switch (i2) {
                case 0:
                case 1:
                case 2:
                    break;
                case 3:
                    return g();
                case 4:
                    return h();
                case 5:
                    return j();
                case 6:
                    return f();
                case 7:
                    return l();
                case 8:
                    return k();
                default:
                    return false;
            }
        }
        return i();
    }

    private static boolean i() {
        String str;
        String strA;
        try {
            str = f3835a;
            Log.d(str, "callDispatchTakeOutRoute");
            strA = c.a("map.android.baidu.mainmap");
        } catch (RemoteException e2) {
            Log.d(f3835a, "callDispatchTakeOut exception", e2);
        }
        if (strA != null) {
            Bundle bundle = new Bundle();
            bundle.putString(com.umeng.ccg.a.F, "route_search_page");
            Bundle bundle2 = new Bundle();
            if (e == 102) {
                e = 7;
            }
            bundle2.putInt("route_type", e);
            bundle2.putInt("bus_strategy", r.ordinal());
            bundle2.putInt("cross_city_bus_strategy", 5);
            if (j != null) {
                bundle2.putInt("start_type", 1);
                bundle2.putInt("start_longitude", (int) CoordUtil.ll2mc(j).getLongitudeE6());
                bundle2.putInt("start_latitude", (int) CoordUtil.ll2mc(j).getLatitudeE6());
            } else {
                bundle2.putInt("start_type", 2);
                bundle2.putInt("start_longitude", 0);
                bundle2.putInt("start_latitude", 0);
            }
            String str2 = n;
            if (str2 != null) {
                bundle2.putString("start_keyword", str2);
            } else {
                bundle2.putString("start_keyword", "地图上的点");
            }
            bundle2.putString("start_uid", l);
            if (k != null) {
                bundle2.putInt("end_type", 1);
                bundle2.putInt("end_longitude", (int) CoordUtil.ll2mc(k).getLongitudeE6());
                bundle2.putInt("end_latitude", (int) CoordUtil.ll2mc(k).getLatitudeE6());
            } else {
                bundle2.putInt("end_type", 2);
                bundle2.putInt("end_longitude", 0);
                bundle2.putInt("end_latitude", 0);
            }
            String str3 = o;
            if (str3 != null) {
                bundle2.putString("end_keyword", str3);
            } else {
                bundle2.putString("end_keyword", "地图上的点");
            }
            bundle2.putString("end_uid", m);
            bundle.putBundle("base_params", bundle2);
            Bundle bundle3 = new Bundle();
            bundle3.putString("launch_from", "sdk_[" + f + "]");
            bundle.putBundle("ext_params", bundle3);
            return c.a("map.android.baidu.mainmap", strA, bundle);
        }
        Log.d(str, "callDispatchTakeOut com not found");
        return false;
    }

    public static void a(int i2, Context context) {
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                h(context);
                return;
            }
            if (i2 == 4) {
                i(context);
                return;
            }
            if (i2 == 5) {
                e(context);
                return;
            }
            if (i2 == 7) {
                f(context);
                return;
            }
            if (i2 == 8) {
                d(context);
                return;
            }
            if (i2 != 9) {
                switch (i2) {
                    case 103:
                        b(context);
                        break;
                    case 104:
                        c(context);
                        break;
                }
            }
            g(context);
            return;
        }
        c(context, i2);
    }

    private static boolean f() {
        List<DispathcPoiData> list = i;
        if (list != null && list.size() > 0) {
            try {
                String str = f3835a;
                Log.d(str, "callDispatchPoiToBaiduMap");
                String strA = c.a("map.android.baidu.mainmap");
                if (strA != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(com.umeng.ccg.a.F, "favorite_page");
                    Bundle bundle2 = new Bundle();
                    JSONArray jSONArray = new JSONArray();
                    int i2 = 0;
                    for (int i3 = 0; i3 < i.size(); i3++) {
                        if (i.get(i3).name != null && !i.get(i3).name.equals("") && i.get(i3).pt != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("name", i.get(i3).name);
                                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(i.get(i3).pt);
                                jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, geoPointLl2mc.getLongitudeE6());
                                jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, geoPointLl2mc.getLatitudeE6());
                                jSONObject.put("addr", i.get(i3).addr);
                                jSONObject.put(DeviceInfoUtil.UID_TAG, i.get(i3).uid);
                                i2++;
                                jSONArray.put(jSONObject);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (i2 == 0) {
                        return false;
                    }
                    bundle2.putString("data", jSONArray.toString());
                    bundle2.putString("from", g);
                    bundle2.putString("pkg", f);
                    bundle2.putString("cls", h);
                    bundle2.putInt("count", i2);
                    bundle.putBundle("base_params", bundle2);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("launch_from", "sdk_[" + f + "]");
                    bundle.putBundle("ext_params", bundle3);
                    return c.a("map.android.baidu.mainmap", strA, bundle);
                }
                Log.d(str, "callDispatchPoiToBaiduMap com not found");
            } catch (RemoteException e3) {
                Log.d(f3835a, "callDispatchPoiToBaiduMap exception", e3);
            }
        }
        return false;
    }

    private static boolean g() {
        try {
            String str = f3835a;
            Log.d(str, "callDispatchTakeOutPoiDetials");
            String strA = c.a("map.android.baidu.mainmap");
            if (strA != null) {
                Bundle bundle = new Bundle();
                bundle.putString(com.umeng.ccg.a.F, "request_poi_detail_page");
                Bundle bundle2 = new Bundle();
                String str2 = s;
                if (str2 != null) {
                    bundle2.putString(DeviceInfoUtil.UID_TAG, str2);
                } else {
                    bundle2.putString(DeviceInfoUtil.UID_TAG, "");
                }
                bundle.putBundle("base_params", bundle2);
                Bundle bundle3 = new Bundle();
                bundle3.putString("launch_from", "sdk_[" + f + "]");
                bundle.putBundle("ext_params", bundle3);
                return c.a("map.android.baidu.mainmap", strA, bundle);
            }
            Log.d(str, "callDispatchTakeOut com not found");
            return false;
        } catch (RemoteException e2) {
            Log.d(f3835a, "callDispatchTakeOut exception", e2);
            return false;
        }
    }

    private static void b(Context context) {
        Thread thread = y;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/navi?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            j = CoordTrans.gcjToBaidu(j);
            k = CoordTrans.gcjToBaidu(k);
        }
        sb.append("origin=");
        sb.append(j.latitude);
        sb.append(",");
        sb.append(j.longitude);
        if (!TextUtils.isEmpty(l)) {
            sb.append("&origin_uid=");
            sb.append(l);
        }
        sb.append("&location=");
        sb.append(k.latitude);
        sb.append(",");
        sb.append(k.longitude);
        if (!TextUtils.isEmpty(m)) {
            sb.append("&destination_uid=");
            sb.append(m);
        }
        sb.append("&src=");
        sb.append("sdk_[" + f + "]");
        if (!TextUtils.isEmpty(p)) {
            sb.append("&viaPoints=");
            sb.append(p);
        }
        sb.append("&type=");
        sb.append(q);
        sb.append("&mode=");
        sb.append("neweng");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static void a(Context context, int i2) {
        Intent intent = new Intent();
        String strM = m();
        if (strM == null) {
            return;
        }
        intent.putExtra("api_token", strM);
        intent.setAction("com.baidu.map.action.OPEN_SERVICE");
        intent.setPackage("com.baidu.BaiduMap");
        if (i2 != 9) {
            x = context.bindService(intent, N, 1);
        }
        if (x) {
            Thread thread = new Thread(new c(context, i2));
            y = thread;
            thread.setDaemon(true);
            y.start();
            return;
        }
        Log.e("baidumapsdk", "bind service failed，call openapi");
        a(i2, context);
    }

    private static void a(TruckNaviOption truckNaviOption) {
        z = 0;
        A = 0.0d;
        B = 0.0d;
        C = 0.0d;
        D = 0.0d;
        E = 0.0d;
        F = 0;
        G = false;
        H = null;
        I = 0;
        J = 0;
        K = 0;
        L = 0;
        M = 0;
        if (truckNaviOption.getNaviRoutePolicy() != null) {
            q = truckNaviOption.getNaviRoutePolicy();
        }
        JSONArray wayPoint = truckNaviOption.getWayPoint();
        if (wayPoint != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("viaPoints", wayPoint);
                try {
                    p = URLEncoder.encode(jSONObject.toString(), "utf-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        z = truckNaviOption.getTruckType();
        A = truckNaviOption.getHeight();
        B = truckNaviOption.getWidth();
        C = truckNaviOption.getWeight();
        D = truckNaviOption.getLength();
        E = truckNaviOption.getAxleWeight();
        F = truckNaviOption.getAxleCount();
        G = truckNaviOption.getIsTrailer();
        H = truckNaviOption.getPlateNumber();
        I = truckNaviOption.getPlateColor();
        J = truckNaviOption.getDisplacement();
        K = truckNaviOption.getPowerType();
        L = truckNaviOption.getEmissionLimit();
        M = truckNaviOption.getLoadWeight();
    }

    private static void c(Context context) {
        Thread thread = y;
        if (thread != null) {
            thread.interrupt();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/truck/navigation?");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            k = CoordTrans.gcjToBaidu(k);
        }
        sb.append("location=");
        sb.append(k.latitude);
        sb.append(",");
        sb.append(k.longitude);
        if (!TextUtils.isEmpty(l)) {
            sb.append("&origin_uid=");
            sb.append(l);
        }
        if (!TextUtils.isEmpty(m)) {
            sb.append("&destination_uid=");
            sb.append(m);
        }
        sb.append("&src=");
        sb.append("sdk_[" + f + "]");
        if (!TextUtils.isEmpty(p)) {
            sb.append("&viaPoints=");
            sb.append(p);
        }
        sb.append("&type=");
        sb.append(q);
        int i2 = z;
        if (i2 > 0 && i2 <= 4) {
            sb.append("&truck_type=");
            sb.append(z);
            double d2 = A;
            if (d2 > 0.0d && d2 <= 10.0d) {
                sb.append("&height=");
                sb.append(A);
                double d3 = B;
                if (d3 > 0.0d && d3 <= 5.0d) {
                    sb.append("&width=");
                    sb.append(B);
                    double d4 = C;
                    if (d4 > 0.0d && d4 <= 100.0d) {
                        sb.append("&weight=");
                        sb.append(C);
                        double d5 = D;
                        if (d5 > 0.0d && d5 <= 25.0d) {
                            sb.append("&length=");
                            sb.append(D);
                            double d6 = E;
                            if (d6 >= 0.0d && d6 <= 100.0d) {
                                sb.append("&axle_weight=");
                                sb.append(E);
                            }
                            int i3 = F;
                            if (i3 > 1 && i3 <= 8) {
                                sb.append("&axle_count=");
                                sb.append(F);
                                if (G) {
                                    sb.append("&is_trailer=");
                                    sb.append(1);
                                } else {
                                    sb.append("&is_trailer=");
                                    sb.append(0);
                                }
                                if (!TextUtils.isEmpty(H)) {
                                    if (H.length() != 7 && H.length() != 8) {
                                        throw new IllegalArgumentException("BDMapSDKException: plateNumber error Please fill in the correct license plate");
                                    }
                                    sb.append("&plate_number=");
                                    sb.append(H);
                                    int i4 = I;
                                    if (i4 >= 0 && i4 <= 4) {
                                        sb.append("&plate_color=");
                                        sb.append(I);
                                    }
                                    if (J > 0) {
                                        sb.append("&displacement=");
                                        sb.append(J);
                                    }
                                    int i5 = K;
                                    if (i5 > 0 && i5 <= 4) {
                                        sb.append("&power_type=");
                                        sb.append(K);
                                        int i6 = L;
                                        if (i6 >= 0 && i6 <= 6) {
                                            sb.append("&emission_limit=");
                                            sb.append(L);
                                            int i7 = M;
                                            if (i7 > 0 && i7 <= 100) {
                                                sb.append("&load_weight=");
                                                sb.append(M);
                                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
                                                intent.setFlags(268435456);
                                                context.startActivity(intent);
                                                return;
                                            }
                                            throw new IllegalArgumentException("BDMapSDKException: loadWeight Must be between 1 and 100");
                                        }
                                        throw new IllegalArgumentException("BDMapSDKException: emissionLimit Must be between 0 and 6");
                                    }
                                    throw new IllegalArgumentException("BDMapSDKException: powerType Must be between 1 and 4");
                                }
                                throw new IllegalArgumentException("BDMapSDKException: plateNumber Can not be null");
                            }
                            throw new IllegalArgumentException("BDMapSDKException: axleCount Must be between 2 and 8");
                        }
                        throw new IllegalArgumentException("BDMapSDKException: length Must be between 1 and 25");
                    }
                    throw new IllegalArgumentException("BDMapSDKException: weight Must be between 1 and 100");
                }
                throw new IllegalArgumentException("BDMapSDKException: width Must be between 1 and 5");
            }
            throw new IllegalArgumentException("BDMapSDKException: height Must be between 1 and 10");
        }
        throw new IllegalArgumentException("BDMapSDKException: truckType Must be between 1 and 4");
    }

    private static void b(RouteParaOption routeParaOption, Context context, int i2) {
        n = null;
        j = null;
        o = null;
        k = null;
        l = null;
        m = null;
        f = context.getPackageName();
        if (routeParaOption.getStartPoint() != null) {
            j = routeParaOption.getStartPoint();
        }
        if (routeParaOption.getEndPoint() != null) {
            k = routeParaOption.getEndPoint();
        }
        if (routeParaOption.getStartName() != null) {
            n = routeParaOption.getStartName();
        }
        if (routeParaOption.getEndName() != null) {
            o = routeParaOption.getEndName();
        }
        if (!TextUtils.isEmpty(routeParaOption.getStartPoiId())) {
            l = routeParaOption.getStartPoiId();
        }
        if (!TextUtils.isEmpty(routeParaOption.getEndPoiId())) {
            m = routeParaOption.getEndPoiId();
        }
        if (routeParaOption.getBusStrategyType() != null) {
            r = routeParaOption.getBusStrategyType();
        }
        if (i2 == 0) {
            e = 0;
            return;
        }
        if (i2 == 1) {
            e = 1;
            return;
        }
        if (i2 == 2) {
            e = 2;
        } else if (i2 == 101) {
            e = 101;
        } else {
            if (i2 != 102) {
                return;
            }
            e = 102;
        }
    }

    private static void a(List<DispathcPoiData> list, Context context) {
        f = context.getPackageName();
        g = a(context);
        h = "";
        List<DispathcPoiData> list2 = i;
        if (list2 != null) {
            list2.clear();
        }
        Iterator<DispathcPoiData> it = list.iterator();
        while (it.hasNext()) {
            i.add(it.next());
        }
    }

    private static void b(PoiParaOption poiParaOption, Context context, int i2) {
        s = null;
        t = null;
        u = null;
        v = 0;
        f = context.getPackageName();
        if (poiParaOption.getUid() != null) {
            s = poiParaOption.getUid();
        }
        if (poiParaOption.getKey() != null) {
            t = poiParaOption.getKey();
        }
        if (poiParaOption.getCenter() != null) {
            u = poiParaOption.getCenter();
        }
        if (poiParaOption.getRadius() != 0) {
            v = poiParaOption.getRadius();
        }
    }

    public static String a(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    private static void b(NaviParaOption naviParaOption, Context context, int i2) {
        f = context.getPackageName();
        n = null;
        j = null;
        o = null;
        k = null;
        p = null;
        l = null;
        m = null;
        if (naviParaOption.getStartPoint() != null) {
            j = naviParaOption.getStartPoint();
        }
        if (naviParaOption.getEndPoint() != null) {
            k = naviParaOption.getEndPoint();
        }
        if (naviParaOption.getStartName() != null) {
            n = naviParaOption.getStartName();
        }
        if (naviParaOption.getEndName() != null) {
            o = naviParaOption.getEndName();
        }
        if (!TextUtils.isEmpty(naviParaOption.getStartUid())) {
            l = naviParaOption.getStartUid();
        }
        if (!TextUtils.isEmpty(naviParaOption.getEndUid())) {
            m = naviParaOption.getEndUid();
        }
        if (naviParaOption.getNaviRoutePolicy() != null) {
            q = naviParaOption.getNaviRoutePolicy();
        }
        JSONArray wayPoint = naviParaOption.getWayPoint();
        if (wayPoint != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("viaPoints", wayPoint);
                try {
                    p = URLEncoder.encode(jSONObject.toString(), "utf-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (naviParaOption instanceof TruckNaviOption) {
            a((TruckNaviOption) naviParaOption);
        }
    }
}
