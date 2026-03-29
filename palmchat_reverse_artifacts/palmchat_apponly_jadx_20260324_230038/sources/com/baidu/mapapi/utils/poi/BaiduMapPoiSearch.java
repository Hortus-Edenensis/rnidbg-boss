package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.pano.PanoStateError;
import com.baidu.platform.comapi.pano.a;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BaiduMapPoiSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3839a = true;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements a.b<com.baidu.platform.comapi.pano.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3840a;

        public a(Context context) {
            this.f3840a = context;
        }

        @Override // com.baidu.platform.comapi.pano.a.b
        public void a(com.baidu.platform.comapi.pano.b bVar) {
            if (bVar == null) {
                Log.d("baidumapsdk", "pano info is null");
                return;
            }
            int i = b.f3841a[bVar.a().ordinal()];
            if (i == 1) {
                Log.d("baidumapsdk", "pano uid is error, please check param poi uid");
                return;
            }
            if (i == 2) {
                Log.d("baidumapsdk", "pano id not found for this poi point");
                return;
            }
            if (i == 3) {
                Log.d("baidumapsdk", "please check ak for permission");
                return;
            }
            if (i != 4) {
                return;
            }
            if (bVar.b() != 1) {
                Log.d("baidumapsdk", "this point do not support for pano show");
                return;
            }
            try {
                BaiduMapPoiSearch.b(bVar.c(), this.f3840a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.baidu.platform.comapi.pano.a.b
        public void a(HttpClient.HttpStateError httpStateError) {
            int i = b.b[httpStateError.ordinal()];
            if (i == 1) {
                Log.d("baidumapsdk", "current network is not available");
            } else {
                if (i != 2) {
                    return;
                }
                Log.d("baidumapsdk", "network inner error, please check network");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3841a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[HttpClient.HttpStateError.values().length];
            b = iArr;
            try {
                iArr[HttpClient.HttpStateError.NETWORK_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[HttpClient.HttpStateError.INNER_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PanoStateError.values().length];
            f3841a = iArr2;
            try {
                iArr2[PanoStateError.PANO_UID_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3841a[PanoStateError.PANO_NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3841a[PanoStateError.PANO_NO_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3841a[PanoStateError.PANO_NO_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, Context context) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("BDMapSDKException: pano id can not be null.");
        }
        if (context == null) {
            throw new RuntimeException("BDMapSDKException: context cannot be null.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("baidumap://map/streetscape?");
        sb.append("panoid=");
        sb.append(str);
        sb.append("&pid=");
        sb.append(str);
        sb.append("&panotype=");
        sb.append("street");
        sb.append("&src=");
        sb.append("sdk_[" + context.getPackageName() + "]");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(268435456);
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            throw new RuntimeException("BDMapSDKException: BaiduMap app is not installed.");
        }
        context.startActivity(intent);
    }

    public static boolean dispatchPoiToBaiduMap(List<DispathcPoiData> list, Context context) throws Exception {
        if (list.isEmpty() || list.size() <= 0) {
            throw new NullPointerException("BDMapSDKException: dispatch poidata is null");
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            return false;
        }
        if (baiduMapVersion >= 840) {
            return com.baidu.mapapi.utils.a.a(list, context, 6);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.4");
        return false;
    }

    public static void finish(Context context) {
        if (context != null) {
            com.baidu.mapapi.utils.a.j(context);
        }
    }

    public static void openBaiduMapPanoShow(String str, Context context) {
        new com.baidu.platform.comapi.pano.a().a(str, new a(context));
    }

    public static boolean openBaiduMapPoiDetialsPage(PoiParaOption poiParaOption, Context context) {
        if (poiParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        String str = poiParaOption.f3842a;
        if (str == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi uid can not be null.");
        }
        if (str.equals("")) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi uid can not be empty string.");
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (!f3839a) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            a(poiParaOption, context);
            return true;
        }
        if (baiduMapVersion >= 810) {
            return com.baidu.mapapi.utils.a.a(poiParaOption, context, 3);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (!f3839a) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
        a(poiParaOption, context);
        return true;
    }

    public static boolean openBaiduMapPoiNearbySearch(PoiParaOption poiParaOption, Context context) {
        if (poiParaOption == null || context == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
        }
        String str = poiParaOption.b;
        if (str == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search key can not be null.");
        }
        LatLng latLng = poiParaOption.c;
        if (latLng == null) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search center can not be null.");
        }
        if (latLng.longitude == 0.0d || latLng.latitude == 0.0d) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search center longitude or latitude can not be 0.");
        }
        if (poiParaOption.d == 0) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search radius larger than 0.");
        }
        if (str.equals("")) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi key can not be empty string");
        }
        int baiduMapVersion = OpenClientUtil.getBaiduMapVersion(context);
        if (baiduMapVersion == 0) {
            Log.e("baidumapsdk", "BaiduMap app is not installed.");
            if (!f3839a) {
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
            }
            b(poiParaOption, context);
            return true;
        }
        if (baiduMapVersion >= 810) {
            return com.baidu.mapapi.utils.a.a(poiParaOption, context, 4);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (!f3839a) {
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
        }
        b(poiParaOption, context);
        return true;
    }

    public static void setSupportWebPoi(boolean z) {
        f3839a = z;
    }

    private static void a(PoiParaOption poiParaOption, Context context) {
        Uri uri = Uri.parse("https://api.map.baidu.com/place/detail?uid=" + poiParaOption.f3842a + "&output=html&src=" + context.getPackageName());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(uri);
        context.startActivity(intent);
    }

    private static void b(PoiParaOption poiParaOption, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://api.map.baidu.com/place/search?");
        sb.append("query=");
        sb.append(poiParaOption.b);
        sb.append("&location=");
        LatLng latLngGcjToBaidu = poiParaOption.c;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            latLngGcjToBaidu = CoordTrans.gcjToBaidu(latLngGcjToBaidu);
        }
        sb.append(latLngGcjToBaidu.latitude);
        sb.append(",");
        sb.append(latLngGcjToBaidu.longitude);
        sb.append("&radius=");
        sb.append(poiParaOption.d);
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
}
