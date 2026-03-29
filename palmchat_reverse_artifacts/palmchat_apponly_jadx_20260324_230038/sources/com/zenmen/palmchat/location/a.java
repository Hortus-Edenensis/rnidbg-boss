package com.zenmen.palmchat.location;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.zenmen.palmchat.location.LocationClientOption;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ad3;
import defpackage.az2;
import defpackage.b92;
import defpackage.i53;
import defpackage.k9;
import defpackage.n53;
import defpackage.nl0;
import defpackage.r75;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.cordova.jssdk.general.Action;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a extends com.zenmen.palmchat.location.b implements AMapLocationListener, PoiSearch.OnPoiSearchListener, GeocodeSearch.OnGeocodeSearchListener {
    public boolean d;
    public LocationScene e;
    public boolean f;
    public Context g;
    public AMapLocationClient h;
    public k9 i;
    public String j;
    public String k;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AMapLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationScene f14357a;

        public b(LocationScene locationScene) {
            this.f14357a = locationScene;
        }

        @Override // com.amap.api.location.AMapLocationListener
        public void onLocationChanged(AMapLocation aMapLocation) {
            a.this.v(this.f14357a, LocationServiceType.LOCATION, aMapLocation != null && aMapLocation.getErrorCode() == 0);
            a.this.onLocationChanged(aMapLocation);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements PoiSearch.OnPoiSearchListener {
        public c() {
        }

        @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
        public void onPoiItemSearched(PoiItem poiItem, int i) {
            a.this.onPoiItemSearched(poiItem, i);
        }

        @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
        public void onPoiSearched(PoiResult poiResult, int i) {
            a.this.v(null, LocationServiceType.SEARCH_BY_POINT, poiResult != null && i == 1000);
            a.this.onPoiSearched(poiResult, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements PoiSearch.OnPoiSearchListener {
        public d() {
        }

        @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
        public void onPoiItemSearched(PoiItem poiItem, int i) {
            a.this.onPoiItemSearched(poiItem, i);
        }

        @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
        public void onPoiSearched(PoiResult poiResult, int i) {
            a.this.v(null, LocationServiceType.SEARCH_BY_KEYWORD, poiResult != null && i == 1000);
            a.this.onPoiSearched(poiResult, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements PoiSearch.OnPoiSearchListener {
        public e() {
        }

        @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
        public void onPoiItemSearched(PoiItem poiItem, int i) {
            a.this.onPoiItemSearched(poiItem, i);
        }

        @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
        public void onPoiSearched(PoiResult poiResult, int i) {
            a.this.v(null, LocationServiceType.SEARCH_BY_KEYWORD, poiResult != null && i == 1000);
            a.this.onPoiSearched(poiResult, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements GeocodeSearch.OnGeocodeSearchListener {
        public f() {
        }

        @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
        public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
            a.this.onGeocodeSearched(geocodeResult, i);
        }

        @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
        public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
            a.this.v(null, LocationServiceType.RE_GEO_CODE, i == 1000);
            a.this.onRegeocodeSearched(regeocodeResult, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14362a;

        static {
            int[] iArr = new int[LocationClientOption.LocationMode.values().length];
            f14362a = iArr;
            try {
                iArr[LocationClientOption.LocationMode.High_Accuracy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14362a[LocationClientOption.LocationMode.Battery_Saving.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(Context context, LocationClientOption locationClientOption, LocationScene locationScene) {
        super(locationClientOption);
        this.d = false;
        this.f = false;
        this.e = locationScene;
        this.g = context.getApplicationContext();
        if (r75.l()) {
            AMapLocationClient.updatePrivacyShow(context, true, true);
            AMapLocationClient.updatePrivacyAgree(context, true);
            this.d = true;
        }
        this.i = new k9();
        try {
            ApplicationInfo applicationInfo = this.g.getPackageManager().getApplicationInfo(this.g.getPackageName(), 128);
            this.j = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            this.k = applicationInfo.metaData.getString("com.amap.web.apikey");
            AMapLocationClient.setApiKey(this.j);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.location.b
    public void b(LocationEx locationEx, b92 b92Var) {
        LogUtil.i("AliLocationClient", "geocodeSearchAsync");
        w(LocationScene.LOCATION_FIX_CITYCODE, LocationServiceType.RE_GEO_CODE);
        try {
            GeocodeSearch geocodeSearch = new GeocodeSearch(this.g);
            geocodeSearch.setOnGeocodeSearchListener(new C1063a(locationEx, b92Var));
            geocodeSearch.getFromLocationAsyn(new RegeocodeQuery(new LatLonPoint(locationEx.getLatitude(), locationEx.getLongitude()), 100.0f, GeocodeSearch.AMAP));
        } catch (AMapException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.location.b
    public LocationEx c(long j) {
        AMapLocation lastKnownLocation;
        LogUtil.i("AliLocationClient", Action.ACTION_GET_LAST_LOCATION);
        if (this.h == null) {
            try {
                this.h = new AMapLocationClient(this.g);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        AMapLocationClient aMapLocationClient = this.h;
        if (aMapLocationClient == null || (lastKnownLocation = aMapLocationClient.getLastKnownLocation()) == null || Math.abs(System.currentTimeMillis() - lastKnownLocation.getTime()) > j) {
            return null;
        }
        return t(lastKnownLocation);
    }

    @Override // com.zenmen.palmchat.location.b
    public ad3 d() {
        return this.i;
    }

    @Override // com.zenmen.palmchat.location.b
    public String e(LocationEx locationEx) {
        LogUtil.i("AliLocationClient", "getStaticMapImageUrl");
        if (locationEx == null) {
            return null;
        }
        w(LocationScene.CHAT_SEND_LOCATION, LocationServiceType.STATIC_MAP);
        double latitude = locationEx.getLatitude();
        return String.format(nl0.f + "/mdc/cdn/staticmap?location=%f,%f&size=%d*%d&zoom=%d", Double.valueOf(locationEx.getLongitude()), Double.valueOf(latitude), 540, 360, 16);
    }

    @Override // com.zenmen.palmchat.location.b
    public boolean g() {
        return this.d;
    }

    @Override // com.zenmen.palmchat.location.b
    public void h(LocationEx locationEx) {
        LogUtil.i("AliLocationClient", "regeoCode");
        w(null, LocationServiceType.RE_GEO_CODE);
        try {
            GeocodeSearch geocodeSearch = new GeocodeSearch(this.g);
            geocodeSearch.setOnGeocodeSearchListener(new f());
            geocodeSearch.getFromLocationAsyn(new RegeocodeQuery(new LatLonPoint(locationEx.getLatitude(), locationEx.getLongitude()), 100.0f, GeocodeSearch.AMAP));
        } catch (AMapException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.location.b
    public void j(String str, LocationEx locationEx, int i, int i2, String str2) {
        LogUtil.i("AliLocationClient", "searchByKeywordSize 2");
        k(30, str, locationEx, i, i2, str2);
    }

    @Override // com.zenmen.palmchat.location.b
    public void k(int i, String str, LocationEx locationEx, int i2, int i3, String str2) {
        LogUtil.i("AliLocationClient", "searchByKeywordSize 1");
        if (str == null) {
            str = "";
        }
        w(null, LocationServiceType.SEARCH_BY_KEYWORD);
        LogUtil.d("logloc", "searchByKeyword: key = " + str + ", radius = " + i3);
        PoiSearch.Query query = new PoiSearch.Query(str, str2);
        query.setPageSize(i);
        query.setPageNum(i2 + 1);
        try {
            PoiSearch poiSearch = new PoiSearch(this.g, query);
            poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(locationEx.getLatitude(), locationEx.getLongitude()), i3));
            poiSearch.setOnPoiSearchListener(new e());
            poiSearch.searchPOIAsyn();
        } catch (AMapException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.location.b
    public void l(LocationEx locationEx, int i, int i2) {
        LogUtil.i("AliLocationClient", "searchByPoint 1");
        m(locationEx, i, i2, "汽车服务|汽车销售|汽车维修|摩托车服务|餐饮服务|购物服务|生活服务|体育休闲服务|医疗保健服务|住宿服务|风景名胜|商务住宅|政府机构及社会团体|科教文化服务|交通设施服务|金融保险服务|公司企业|道路附属设施|地名地址信息|公共设施");
    }

    @Override // com.zenmen.palmchat.location.b
    public void m(LocationEx locationEx, int i, int i2, String str) {
        LogUtil.i("AliLocationClient", "searchByPoint 2");
        if (locationEx == null) {
            return;
        }
        w(null, LocationServiceType.SEARCH_BY_POINT);
        PoiSearch.Query query = new PoiSearch.Query("", str);
        query.setPageSize(30);
        query.setPageNum(i + 1);
        try {
            PoiSearch poiSearch = new PoiSearch(this.g, query);
            poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(locationEx.getLatitude(), locationEx.getLongitude()), i2));
            poiSearch.setOnPoiSearchListener(new c());
            poiSearch.searchPOIAsyn();
        } catch (AMapException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.location.b
    public void n(String str, int i, String str2) {
        LogUtil.i("AliLocationClient", "searchByPoint 3");
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        w(null, LocationServiceType.SEARCH_BY_KEYWORD);
        LogUtil.d("logloc", "searchByPoint: key = " + str + ", city = " + str2);
        PoiSearch.Query query = new PoiSearch.Query(str, "", str2);
        query.setPageSize(30);
        query.setPageNum(i + 1);
        try {
            PoiSearch poiSearch = new PoiSearch(this.g, query);
            poiSearch.setOnPoiSearchListener(new d());
            poiSearch.searchPOIAsyn();
        } catch (AMapException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.location.b
    public void o() {
        LogUtil.i("AliLocationClient", "start 1");
        p(this.e);
    }

    @Override // com.amap.api.location.AMapLocationListener
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                LogUtil.i("AliLocationClient", String.format("latitude : %f, longitude : %f, citycode : %s, addr = %s", Double.valueOf(aMapLocation.getLatitude()), Double.valueOf(aMapLocation.getLongitude()), aMapLocation.getCityCode(), aMapLocation.getAddress()));
                LocationEx locationExT = t(aMapLocation);
                Iterator<i53> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().onLocationReceived(locationExT, aMapLocation.getErrorCode(), aMapLocation.getErrorInfo());
                }
                return;
            }
            LogUtil.e("AliLocationClient", "location Error, ErrCode:" + aMapLocation.getErrorCode() + ", errInfo:" + aMapLocation.getErrorInfo());
            Iterator<i53> it2 = this.b.iterator();
            while (it2.hasNext()) {
                it2.next().onLocationReceived(null, aMapLocation.getErrorCode(), aMapLocation.getErrorInfo());
            }
        }
    }

    @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
    public void onPoiSearched(PoiResult poiResult, int i) {
        n53 n53Var = null;
        if (i != 1000 || poiResult == null) {
            Iterator<i53> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onLocationSearchResultGot(0, null, null);
            }
            return;
        }
        if (poiResult.getQuery() != null) {
            n53Var = new n53();
            n53Var.g(poiResult.getQuery().getQueryString());
            n53Var.e(poiResult.getQuery().getCity());
            n53Var.f(poiResult.getQuery().getPageNum());
            if (poiResult.getSearchSuggestionCitys() != null && poiResult.getSearchSuggestionCitys().size() > 0) {
                n53Var.h(poiResult.getSearchSuggestionCitys().get(0).getCityName());
            }
        }
        ArrayList<PoiItem> pois = poiResult.getPois();
        ArrayList arrayList = new ArrayList();
        for (PoiItem poiItem : pois) {
            LatLonPoint latLonPoint = poiItem.getLatLonPoint();
            LocationEx locationEx = new LocationEx(latLonPoint.getLatitude(), latLonPoint.getLongitude(), u(), poiItem.getTitle(), poiItem.getCityName() + poiItem.getAdName() + poiItem.getSnippet());
            locationEx.setCityCode(poiItem.getCityCode());
            locationEx.setCity(poiItem.getCityName());
            locationEx.setProvince(poiItem.getProvinceName());
            locationEx.setAdName(poiItem.getAdName());
            arrayList.add(locationEx);
        }
        Iterator<i53> it2 = this.b.iterator();
        while (it2.hasNext()) {
            it2.next().onLocationSearchResultGot(poiResult.getPageCount(), arrayList, n53Var);
        }
    }

    @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        if (i == 1000) {
            Iterator<i53> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onRegeocodeSearched(regeocodeResult.getRegeocodeAddress().getFormatAddress());
            }
        } else {
            Iterator<i53> it2 = this.b.iterator();
            while (it2.hasNext()) {
                it2.next().onRegeocodeSearched(null);
            }
        }
    }

    @Override // com.zenmen.palmchat.location.b
    public void p(LocationScene locationScene) {
        LogUtil.i("AliLocationClient", "start 2");
        w(locationScene, LocationServiceType.LOCATION);
        if (this.h == null) {
            try {
                this.h = new AMapLocationClient(this.g);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        AMapLocationClient aMapLocationClient = this.h;
        if (aMapLocationClient != null) {
            if (aMapLocationClient.isStarted() || this.f14363a == null) {
                this.h.startLocation();
            } else {
                AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                int i = g.f14362a[this.f14363a.b().ordinal()];
                if (i == 1) {
                    aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                } else if (i == 2) {
                    aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
                }
                aMapLocationClientOption.setOnceLocation(this.f14363a.c());
                if (this.f14363a.a() > 0) {
                    aMapLocationClientOption.setHttpTimeOut(this.f14363a.a());
                }
                aMapLocationClientOption.setLocationCacheEnable(true);
                this.h.setLocationOption(aMapLocationClientOption);
                this.h.setLocationListener(new b(locationScene));
                this.h.startLocation();
            }
        }
        LogUtil.i("AliLocationClient", "startLocation");
    }

    @Override // com.zenmen.palmchat.location.b
    public void q() {
        LogUtil.i("AliLocationClient", "stopLocation");
        AMapLocationClient aMapLocationClient = this.h;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            this.h.unRegisterLocationListener(this);
            this.h.onDestroy();
            this.h = null;
        }
    }

    public final LocationEx t(AMapLocation aMapLocation) {
        LocationEx locationEx = new LocationEx(aMapLocation.getLatitude(), aMapLocation.getLongitude(), u(), aMapLocation.getPoiName(), aMapLocation.getCity() + aMapLocation.getDistrict() + aMapLocation.getStreet() + aMapLocation.getStreetNum(), aMapLocation.getCountry(), aMapLocation.getCityCode());
        locationEx.setTime(aMapLocation.getTime());
        locationEx.setProvince(aMapLocation.getProvince());
        locationEx.setAoiName(aMapLocation.getAoiName());
        if (TextUtils.isEmpty(aMapLocation.getDistrict()) || !aMapLocation.getProvince().equals(aMapLocation.getCity())) {
            locationEx.setCity(aMapLocation.getCity());
        } else {
            locationEx.setCity(aMapLocation.getDistrict());
        }
        locationEx.setAdName(aMapLocation.getDistrict());
        locationEx.setRealCityName(aMapLocation.getCity());
        locationEx.setCityCode(aMapLocation.getCityCode());
        return locationEx;
    }

    public String u() {
        return "gcj02";
    }

    public final void v(LocationScene locationScene, LocationServiceType locationServiceType, boolean z) {
        HashMap map = new HashMap();
        map.put("platform", String.valueOf(1));
        map.put("makeupfor", String.valueOf(this.f ? 1 : 0));
        map.put("success", z ? "1" : "0");
        if (locationServiceType != null) {
            map.put("Service", String.valueOf(locationServiceType.value));
        }
        if (locationScene != null) {
            map.put("scene", String.valueOf(locationScene.value));
        } else {
            LocationScene locationScene2 = this.e;
            if (locationScene2 != null) {
                map.put("scene", String.valueOf(locationScene2.value));
            }
        }
        zn6.i("gaodeservice_callback", map);
        LogUtil.i("AliLocationClient", "gaodeservice_callback " + az2.c(map));
    }

    public final void w(LocationScene locationScene, LocationServiceType locationServiceType) {
        HashMap map = new HashMap();
        map.put("platform", String.valueOf(1));
        map.put("makeupfor", String.valueOf(this.f ? 1 : 0));
        if (locationServiceType != null) {
            map.put("Service", String.valueOf(locationServiceType.value));
        }
        if (locationScene != null) {
            map.put("scene", String.valueOf(locationScene.value));
        } else {
            LocationScene locationScene2 = this.e;
            if (locationScene2 != null) {
                map.put("scene", String.valueOf(locationScene2.value));
            }
        }
        zn6.i("gaodeservice_request", map);
        if (locationScene == LocationScene.UNKNOWN_LOCATION_LIST) {
            LogUtil.i("AliLocationClient", "gaodeservice_request " + az2.c(map), new Throwable("test").fillInStackTrace());
            return;
        }
        LogUtil.i("AliLocationClient", "gaodeservice_request " + az2.c(map));
    }

    public a(Context context, LocationClientOption locationClientOption, LocationScene locationScene, boolean z) {
        this(context, locationClientOption, locationScene);
        this.f = z;
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.location.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1063a implements GeocodeSearch.OnGeocodeSearchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f14356a;
        public final /* synthetic */ b92 b;

        public C1063a(LocationEx locationEx, b92 b92Var) {
            this.f14356a = locationEx;
            this.b = b92Var;
        }

        @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
        public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
            LogUtil.i("AliLocationClient", "onRegeocodeSearched regeocodeResult=" + regeocodeResult + " code =" + i);
            a.this.v(LocationScene.LOCATION_FIX_CITYCODE, LocationServiceType.RE_GEO_CODE, i == 1000);
            if (i == 1000 && regeocodeResult != null && regeocodeResult.getRegeocodeAddress() != null) {
                RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
                if (TextUtils.isEmpty(this.f14356a.getCityCode())) {
                    this.f14356a.setCityCode(regeocodeResult.getRegeocodeAddress().getCityCode());
                }
                if (TextUtils.isEmpty(this.f14356a.getAddress())) {
                    this.f14356a.setAddress(regeocodeAddress.getCity() + regeocodeAddress.getDistrict());
                }
                if (TextUtils.isEmpty(this.f14356a.getName())) {
                    this.f14356a.setAddress(regeocodeResult.getRegeocodeAddress().getFormatAddress());
                }
                if (TextUtils.isEmpty(this.f14356a.getCity())) {
                    this.f14356a.setCity(regeocodeResult.getRegeocodeAddress().getCity());
                    this.f14356a.setRealCityName(regeocodeResult.getRegeocodeAddress().getCity());
                    this.f14356a.setProvince(regeocodeResult.getRegeocodeAddress().getProvince());
                    this.f14356a.setCountry(regeocodeResult.getRegeocodeAddress().getCountry());
                }
            }
            this.b.a(this.f14356a);
        }

        @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
        public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
        }
    }

    @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
    }

    @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
    public void onPoiItemSearched(PoiItem poiItem, int i) {
    }
}
