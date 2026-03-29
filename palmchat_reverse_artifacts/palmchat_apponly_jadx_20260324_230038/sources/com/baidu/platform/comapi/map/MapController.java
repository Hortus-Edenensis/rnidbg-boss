package com.baidu.platform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MapController {
    public static final String ANDROID_SDK_LAYER_TAG = "android_sdk";
    public static final String CITY_AREA_TAG = "cityarea";
    public static final String COMPASS_LAYER_TAG = "compass";
    public static final String DEFAULT_LAYER_TAG = "default";
    public static final String DYNAMIC_MAP_LAYER_TAG = "dynamicmap";
    public static final String FOOTSURFACE_LAYER_TAG = "footsurface";
    public static final String HEATMAP_LAYER_TAG = "heatmap";
    public static final String ITEM_LAYER_TAG = "item";
    public static final String ITSROUTE_LAYER_TAG = "itsroute";
    public static final String LOCAL_LIMIT_MAP_LAYER_TAG = "dynamiclimit";
    public static final String LOCATION_LAYER_TAG = "location";
    public static final int MSG_LONGLINK_CONNECT = 1;
    public static final int MSG_LONGLINK_DISCONNECT = 2;
    public static final String POISON_LAYER_TAG = "poison";
    public static final String POPUP_LAYER_TAG = "popup";
    public static final String RTPOPUP_LAYER_TAG = "rtpopup";
    public static final String RT_POPUP_LAYER_TAG = "rtpopup";
    public static final String SHARELOCATION_BUBBLE = "smshare";
    public static final String STREETPOPUP_LAYER_TAG = "streetpopup";
    public static final String STREETROUTE_LAYER_TAG = "streetroute";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4159a = "MapController";
    private static boolean b = true;
    private static float c = 0.0f;
    private static float d = 0.0f;
    private static boolean e = false;
    private static long f = 0;
    private static List<AppBaseMap> g = new ArrayList();
    public static boolean isCompass = false;
    public static boolean mLocIconOnScreen = true;
    public static boolean m_registered_SENSOR_ORIENTATION;
    private long N;
    SoftReference<MapViewInterface> d0;
    NaviMapViewListener e0;
    private long f0;
    private com.baidu.platform.comapi.map.c0.c h;
    public boolean mHasBmDrawItemDraging;
    public boolean mHasMapObjDraging;
    public boolean mIsMapLoadFinish;
    public boolean mIsMapLoadStart;
    public w mOverlayListener;
    private MapFirstFrameCallback o;
    private Point q;
    private LatLng r;
    private Handler x;
    private boolean i = true;
    private boolean j = true;
    int k = 0;
    private int l = 1;
    private int m = 1;
    private boolean n = false;
    private boolean p = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private AppBaseMap v = null;
    private long w = 0;
    public int nearlyRadius = 20;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private a E = new a();
    private boolean F = true;
    private boolean G = false;
    private boolean H = true;
    private boolean I = true;
    private boolean J = false;
    private float K = -1.0f;
    private float L = -1.0f;
    private float M = 0.0f;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = true;
    private boolean S = true;
    private boolean T = true;
    private boolean U = true;
    public boolean mIsInertialAnimation = true;
    private boolean V = false;
    MapViewListener W = null;
    CaptureMapListener X = null;
    g Y = null;
    y Z = null;
    MapRenderModeChangeListener a0 = null;
    EngineMsgListener b0 = null;
    MapViewSurfaceListener c0 = null;
    public float mMaxZoomLevel = 22.0f;
    public float mMinZoomLevel = 4.0f;
    public boolean mIsMoving = false;
    public boolean mIsAnimating = false;
    private boolean g0 = false;
    private boolean h0 = false;
    private com.baidu.platform.comapi.map.c0.b i0 = new com.baidu.platform.comapi.map.c0.b(this);
    private MapControlMode j0 = MapControlMode.DEFAULT;
    public List<v> mListeners = new CopyOnWriteArrayList();
    private int y = SysOSUtil.getInstance().getScreenWidth();
    private int z = SysOSUtil.getInstance().getScreenHeight();

    /* JADX INFO: compiled from: SearchBox */
    public enum HeatMapType {
        CITY(0),
        SCENERY(1),
        CEMETERY(2);

        private final int b;

        HeatMapType(int i) {
            this.b = i;
        }

        public int getId() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum MapControlMode {
        DEFAULT(1),
        INDOOR(2),
        STREET(3),
        STREET_WAITING(4);

        private final int b;

        MapControlMode(int i) {
            this.b = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface MapFirstFrameCallback {
        void onFirstFrameDrawing(MapController mapController);
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum MapLayerType {
        DEFAULT(1),
        SATELLITE(2),
        INDOOR(3),
        STREET(5);

        private final int b;

        MapLayerType(int i) {
            this.b = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum MapSceneMode {
        DEFAULT(0),
        POI(1),
        ROUTE(2),
        INTERNAL(3),
        INDOOR(7);

        private final int b;

        MapSceneMode(int i) {
            this.b = i;
        }

        public int getMode() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum MapStyleMode {
        DEFAULT(1),
        SEARCH_POI(2),
        SEARCH_ROUTE(3),
        NAV_DAY(4),
        NAV_NIGHT(5),
        WALK_DAY(6),
        INTERNAL(7),
        INTERNAL_SPECIAL(8),
        FOOT_PRINT(9);

        private final int b;

        MapStyleMode(int i) {
            this.b = i;
        }

        public int getMode() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum RecommendPoiScene {
        BASE(0),
        INTERNATIONAL(1);

        public int value;

        RecommendPoiScene(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum RecycleMemoryLevel {
        NORMAL(0),
        FULL(1);

        private final int b;

        RecycleMemoryLevel(int i) {
            this.b = i;
        }

        public int getLevel() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4167a = false;
        float b = 0.0f;
        GeoPoint c;
        com.baidu.platform.comapi.basestruct.Point d;

        public a() {
        }

        public void a() {
            this.f4167a = false;
            this.b = 0.0f;
            this.c = null;
            this.d = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public class b extends com.baidu.platform.comapi.util.i {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MapStatus f4169a;

            public a(MapStatus mapStatus) {
                this.f4169a = mapStatus;
            }

            @Override // java.lang.Runnable
            public void run() {
                GeoPoint geoPointFromPixels = (MapController.this.getMapView() == null || MapController.this.getMapView().getProjection() == null) ? null : MapController.this.d0.get().getProjection().fromPixels(this.f4169a.winRound.left + (MapController.this.getScreenWidth() / 2), this.f4169a.winRound.top + (MapController.this.getScreenHeight() / 2));
                if (geoPointFromPixels != null) {
                    MapController.CleanAfterDBClick(MapController.this.w, (float) geoPointFromPixels.getLongitudeE6(), (float) geoPointFromPixels.getLatitudeE6());
                }
                MapController.this.P = false;
            }
        }

        /* JADX INFO: renamed from: com.baidu.platform.comapi.map.MapController$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC0103b implements Runnable {
            public RunnableC0103b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = MapController.this.getMapStatusInner();
                if (MapController.this.mListeners != null) {
                    for (int i = 0; i < MapController.this.mListeners.size(); i++) {
                        v vVar = MapController.this.mListeners.get(i);
                        if (vVar != null) {
                            vVar.d();
                            MapController.this.O = true;
                            vVar.a(mapStatusInner);
                        }
                    }
                }
            }
        }

        public b() {
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            boolean z;
            NaviMapViewListener naviMapViewListener;
            NaviMapViewListener naviMapViewListener2;
            w wVar;
            g gVar;
            CaptureMapListener captureMapListener;
            if (message.what == 4000 && (captureMapListener = MapController.this.X) != null) {
                captureMapListener.onGetCaptureMap(message.arg2 == 1);
            }
            if (message.what == 519 && (gVar = MapController.this.Y) != null) {
                gVar.a();
            }
            if (message.what == 65304 && (wVar = MapController.this.mOverlayListener) != null) {
                wVar.a(message.arg2);
            }
            int i = message.what;
            if (i == 39) {
                if (((Long) message.obj).longValue() != MapController.this.w) {
                    return;
                }
                int i2 = message.arg1;
                if (i2 == 2) {
                    if (MapController.this.mListeners == null) {
                        return;
                    }
                    for (int i3 = 0; i3 < MapController.this.mListeners.size(); i3++) {
                        v vVar = MapController.this.mListeners.get(i3);
                        if (vVar != null) {
                            vVar.b();
                        }
                    }
                    MapController mapController = MapController.this;
                    mapController.mIsMoving = false;
                    mapController.mIsAnimating = false;
                } else if (i2 == 100) {
                    if (MapController.this.P) {
                        SoftReference<MapViewInterface> softReference = MapController.this.d0;
                        if (softReference == null || softReference.get() == null) {
                            return;
                        } else {
                            MapTaskManager.getDefaultThreadPool().execute(new a(MapController.this.getMapStatus()));
                        }
                    }
                    if (MapController.this.Q) {
                        MapController.this.Q = false;
                    }
                    MapController.this.B = false;
                    MapController mapController2 = MapController.this;
                    mapController2.mIsMoving = false;
                    mapController2.mIsAnimating = false;
                    if (mapController2.getMapViewListener() != null) {
                        MapController.this.getMapViewListener().onMapAnimationFinish();
                    }
                    if (MapController.this.isNaviMode() && (naviMapViewListener = MapController.this.e0) != null) {
                        naviMapViewListener.onMapAnimationFinish();
                    }
                    MapController mapController3 = MapController.this;
                    if (mapController3.mListeners != null && mapController3.O) {
                        com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = MapController.this.getMapStatusInner();
                        for (int i4 = 0; i4 < MapController.this.mListeners.size(); i4++) {
                            v vVar2 = MapController.this.mListeners.get(i4);
                            if (vVar2 != null) {
                                vVar2.a(mapStatusInner);
                            }
                        }
                    }
                } else if (i2 == 200) {
                    MapController.this.mIsMoving = false;
                } else if (i2 != 300) {
                    if (i2 != 400) {
                        MapRenderModeChangeListener mapRenderModeChangeListener = MapController.this.a0;
                        if (mapRenderModeChangeListener != null) {
                            mapRenderModeChangeListener.onMapRenderModeChange(i2);
                        }
                        if (MapController.this.isNaviMode() && (naviMapViewListener2 = MapController.this.e0) != null) {
                            naviMapViewListener2.onMapRenderModeChange(message.arg1);
                        }
                    } else {
                        for (int i5 = 0; i5 < MapController.this.mListeners.size(); i5++) {
                            v vVar3 = MapController.this.mListeners.get(i5);
                            if (vVar3 != null) {
                                vVar3.onFirstMapTileLoaded();
                            }
                        }
                    }
                } else if (MapController.this.o != null) {
                    MapController.this.o.onFirstFrameDrawing(MapController.this);
                }
                MapController mapController4 = MapController.this;
                if (!mapController4.mIsMapLoadFinish && mapController4.z > 0 && MapController.this.y > 0 && MapController.this.getMapView() != null && MapController.this.getMapView().getProjection() != null && MapController.this.getMapView().getProjection().fromPixels(0, 0) != null) {
                    MapController.this.mIsMapLoadFinish = true;
                    MapTaskManager.postToMainThread(new RunnableC0103b(), 0L);
                }
                if (MapController.this.mListeners != null) {
                    for (int i6 = 0; i6 < MapController.this.mListeners.size(); i6++) {
                        v vVar4 = MapController.this.mListeners.get(i6);
                        if (vVar4 != null) {
                            vVar4.c();
                        }
                    }
                }
            } else if (i == 41) {
                if (((Long) message.obj).longValue() != MapController.this.w) {
                    return;
                }
                MapController mapController5 = MapController.this;
                if (mapController5.mListeners == null) {
                    return;
                }
                if (mapController5.mIsMoving || mapController5.mIsAnimating) {
                    com.baidu.mapsdkplatform.comapi.map.s mapStatusInner2 = mapController5.getMapStatusInner();
                    for (int i7 = 0; i7 < MapController.this.mListeners.size(); i7++) {
                        v vVar5 = MapController.this.mListeners.get(i7);
                        if (vVar5 != null) {
                            vVar5.b(mapStatusInner2);
                        }
                    }
                }
            } else if (i == 2082) {
                int i8 = message.arg1;
                if (i8 == 1003) {
                    i8 = 0;
                    z = true;
                } else {
                    z = false;
                }
                if (OpenLogUtil.isMapLogEnable()) {
                    com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("onMapRenderValidFrame isValid = " + z + "; errorCode = " + i8);
                }
                if (MapController.this.mListeners != null) {
                    for (int i9 = 0; i9 < MapController.this.mListeners.size(); i9++) {
                        v vVar6 = MapController.this.mListeners.get(i9);
                        if (vVar6 != null) {
                            vVar6.a(z, i8);
                        }
                    }
                }
            }
            if (message.what == 512) {
                int i10 = message.arg1;
                if (MapController.this.getMapViewListener() != null) {
                    MapController.this.getMapViewListener().onClickedPopup(i10);
                }
            }
            if (message.what == 50) {
                if (OpenLogUtil.isMapLogEnable()) {
                    com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("EngineMeassage IndoorMap msg.what = " + message.what + "; msg.arg1 = " + message.arg1);
                }
                MapController mapController6 = MapController.this;
                EngineMsgListener engineMsgListener = mapController6.b0;
                if (engineMsgListener != null) {
                    int i11 = message.arg1;
                    if (i11 == 1) {
                        MapController.this.b0.onEnterIndoorMapMode(mapController6.getFocusedBaseIndoorMapInfo());
                    } else if (i11 == 0) {
                        engineMsgListener.onExitIndoorMapMode();
                    }
                }
                MapController mapController7 = MapController.this;
                if (mapController7.mListeners == null) {
                    return;
                }
                IndoorMapInfo focusedBaseIndoorMapInfo = mapController7.getFocusedBaseIndoorMapInfo();
                for (int i12 = 0; i12 < MapController.this.mListeners.size(); i12++) {
                    v vVar7 = MapController.this.mListeners.get(i12);
                    if (vVar7 != null) {
                        int i13 = message.arg1;
                        if (i13 == 0) {
                            vVar7.a(false);
                            MapController.this.mMaxZoomLevel = 22.0f;
                        } else if (i13 == 1) {
                            if (MapController.this.getMapStatus().level < 18.0f || focusedBaseIndoorMapInfo == null) {
                                vVar7.a(false);
                                MapController.this.mMaxZoomLevel = 22.0f;
                            } else {
                                vVar7.a(true);
                                MapController.this.mMaxZoomLevel = 22.0f;
                            }
                        }
                    }
                }
            }
            if (message.what == 51) {
                MapController.this.setNetStatus(message.arg1);
            }
            if (message.what == 65301) {
                MapController mapController8 = MapController.this;
                if (mapController8.b0 != null) {
                    int i14 = message.arg1;
                    if (i14 == 1) {
                        mapController8.getMapBarData();
                    } else if (i14 == 0) {
                        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a());
                    }
                }
            }
        }
    }

    public MapController() {
        this.x = null;
        this.x = new b();
        b();
    }

    public static native int CleanAfterDBClick(long j, float f2, float f3);

    public static int GetAdaptKeyCode(int i) {
        switch (i) {
            case 19:
                return 17;
            case 20:
                return 19;
            case 21:
                return 16;
            case 22:
                return 18;
            default:
                return 0;
        }
    }

    public static native int MapProc(long j, int i, int i2, int i3, int i4, int i5, double d2, double d3, double d4, double d5);

    public static int getScaleDis(int i) {
        switch (i) {
            case 1:
                return 10000000;
            case 2:
                return 5000000;
            case 3:
                return 2000000;
            case 4:
                return 1000000;
            case 5:
                return ErrorCode.REASON_RD_METADATA;
            case 6:
                return ErrorCode.REASON_RD_AUDIO;
            case 7:
                return 100000;
            case 8:
                return 50000;
            case 9:
                return 25000;
            case 10:
                return 20000;
            case 11:
                return 10000;
            case 12:
                return 5000;
            case 13:
                return 2000;
            case 14:
                return 1000;
            case 15:
                return 500;
            case 16:
                return 200;
            case 17:
                return 100;
            case 18:
                return 50;
            case 19:
                return 20;
            case 20:
                return 10;
            case 21:
                return 5;
            case 22:
                return 2;
            default:
                return 0;
        }
    }

    public float GetFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        if (a()) {
            return this.v.GetFZoomToBoundF(bundle, bundle2);
        }
        return 0.0f;
    }

    public int MapMsgProc(int i, int i2, int i3) {
        return MapMsgProc(i, i2, i3, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d);
    }

    public void SetStyleMode(int i) {
        setMapScene(i);
    }

    public void addOneOverlayItem(Bundle bundle) {
        this.v.addOneOverlayItem(bundle);
    }

    public void addStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        if (a()) {
            this.v.AddStreetCustomMarker(bundle, bitmap);
        }
    }

    public void animateTo(GeoPoint geoPoint, int i) {
        if (a()) {
            MapStatus mapStatus = getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            setMapStatusWithAnimation(mapStatus, i);
        }
    }

    public boolean cleanCache(MapLayerType mapLayerType) {
        AppBaseMap appBaseMap = this.v;
        return appBaseMap != null && appBaseMap.cleanCache(mapLayerType.b, false);
    }

    public void clearUniversalLayer() {
        if (a()) {
            this.v.clearUniversalLayer();
        }
    }

    public boolean createByDuplicateAppBaseMap(long j) {
        AppBaseMap appBaseMap = new AppBaseMap();
        this.v = appBaseMap;
        if (!appBaseMap.CreateByDuplicate(j)) {
            this.v = null;
            this.w = 0L;
            return false;
        }
        this.h0 = true;
        this.w = this.v.GetId();
        List<AppBaseMap> list = g;
        if (list != null) {
            list.add(this.v);
        }
        return true;
    }

    public void enablePOIAnimation(boolean z) {
        if (a()) {
            this.v.enablePOIAnimation(z);
        }
    }

    public void forceSetMapScene(int i) {
        this.l = i;
        if (a()) {
            this.v.setMapScene(this.l);
        }
    }

    public boolean forceSetMapThemeScene(int i, int i2, Bundle bundle) {
        this.m = i;
        this.l = i2;
        if (a()) {
            return this.v.setMapThemeScene(i, i2, bundle);
        }
        return false;
    }

    public float getAdapterZoomUnitsEx() {
        if (a()) {
            return this.v.GetAdapterZoomUnitsEx();
        }
        return 0.0f;
    }

    public AppBaseMap getBaseMap() {
        return this.v;
    }

    public int getCacheSize(MapLayerType mapLayerType) {
        AppBaseMap appBaseMap = this.v;
        if (appBaseMap == null) {
            return 0;
        }
        return appBaseMap.GetCacheSize(mapLayerType.b);
    }

    public CaptureMapListener getCaptureMapListener() {
        return this.X;
    }

    public String getCityInfoByID(int i) {
        AppBaseMap appBaseMap = this.v;
        if (appBaseMap != null) {
            return appBaseMap.GetCityInfoByID(i);
        }
        return null;
    }

    public MapStatus getCurrentMapStatus() {
        return a(false);
    }

    public float getCurrentZoomLevel() {
        Bundle bundleGetMapStatus;
        AppBaseMap appBaseMap = this.v;
        if (appBaseMap == null || (bundleGetMapStatus = appBaseMap.GetMapStatus(false)) == null) {
            return 4.0f;
        }
        return (float) bundleGetMapStatus.getDouble("level");
    }

    public IndoorMapInfo getFocusedBaseIndoorMapInfo() {
        String[] strArr;
        int[] iArr;
        if (!a()) {
            return null;
        }
        String strGetFocusedBaseIndoorMapInfo = this.v.GetFocusedBaseIndoorMapInfo();
        if (!TextUtils.isEmpty(strGetFocusedBaseIndoorMapInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(strGetFocusedBaseIndoorMapInfo);
                String strOptString = jSONObject.optString("focusindoorid");
                String strOptString2 = jSONObject.optString("curfloor");
                int iOptInt = jSONObject.optInt("idrtype");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("floorlist");
                if (jSONArrayOptJSONArray != null) {
                    strArr = new String[jSONArrayOptJSONArray.length()];
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        arrayList.add(jSONArrayOptJSONArray.getString(i));
                    }
                    arrayList.toArray(strArr);
                } else {
                    strArr = null;
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("floorattribute");
                if (jSONArrayOptJSONArray2 != null) {
                    iArr = new int[jSONArrayOptJSONArray2.length()];
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        iArr[i2] = jSONArrayOptJSONArray2.optInt(i2);
                    }
                } else {
                    iArr = null;
                }
                return new IndoorMapInfo(strOptString, strOptString2, strArr, iArr, iOptInt, jSONObject.optInt("idrguide"), jSONObject.optString("idrsearch"));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public com.baidu.platform.comapi.map.c0.c getGestureMonitor() {
        if (this.h == null) {
            this.h = new com.baidu.platform.comapi.map.c0.c(this);
        }
        return this.h;
    }

    public Bundle getGestureOptInfoForLog() {
        Bundle bundle = null;
        if (!this.E.f4167a) {
            return null;
        }
        MapStatus mapStatus = getMapStatus();
        int intX = this.E.d.getIntX();
        int intY = this.E.d.getIntY();
        boolean z = Math.sqrt((double) ((intX * intX) + (intY * intY))) > 100.0d;
        float f2 = this.E.b;
        boolean z2 = f2 > 0.0f && ((double) Math.abs(mapStatus.level - f2)) >= 0.5d;
        if (z || z2) {
            bundle = new Bundle();
            bundle.putDouble("pre_x", this.E.c.getLongitude());
            bundle.putDouble("pre_y", this.E.c.getLatitude());
            bundle.putFloat("pre_level", this.E.b);
        }
        this.E.a();
        return bundle;
    }

    public g getHideIndoorPopupListener() {
        return this.Y;
    }

    public EngineMsgListener getIndoorMapListener() {
        return this.b0;
    }

    public LatLng getLatLngGesturesCenter() {
        return this.r;
    }

    public List<v> getListeners() {
        return this.mListeners;
    }

    public boolean getMapBarData() {
        if (!a()) {
            return false;
        }
        Bundle bundle = new Bundle();
        this.v.getMapBarData(bundle);
        byte[] byteArray = new byte[0];
        String string = bundle.containsKey(DeviceInfoUtil.UID_TAG) ? bundle.getString(DeviceInfoUtil.UID_TAG) : null;
        String string2 = bundle.containsKey("searchbound") ? bundle.getString("searchbound") : null;
        String string3 = bundle.containsKey("curfloor") ? bundle.getString("curfloor") : null;
        if (bundle.containsKey("barinfo")) {
            byteArray = bundle.getByteArray("barinfo");
        }
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b(string, string2, string3, byteArray));
        return true;
    }

    public boolean getMapBarShowData() {
        if (!a()) {
            return false;
        }
        return this.v.getMapBarData(new Bundle());
    }

    public boolean getMapClickEnable() {
        return this.A;
    }

    public MapControlMode getMapControlMode() {
        return this.j0;
    }

    public long getMapId() {
        return this.w;
    }

    public MapRenderModeChangeListener getMapRenderModeChangeListener() {
        return this.a0;
    }

    public int getMapScene() {
        if (a()) {
            return this.v.getMapScene();
        }
        return 0;
    }

    public MapStatus getMapStatus() {
        return a(true);
    }

    public com.baidu.mapsdkplatform.comapi.map.s getMapStatusInner() {
        if (!a()) {
            return null;
        }
        Bundle bundleGetMapStatus = this.v.GetMapStatus();
        com.baidu.mapsdkplatform.comapi.map.s sVar = new com.baidu.mapsdkplatform.comapi.map.s();
        sVar.a(bundleGetMapStatus);
        return sVar;
    }

    public int getMapTheme() {
        if (a()) {
            return this.v.getMapTheme();
        }
        return 0;
    }

    public MapViewInterface getMapView() {
        SoftReference<MapViewInterface> softReference = this.d0;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public MapViewListener getMapViewListener() {
        return this.W;
    }

    public MapViewSurfaceListener getMapViewSurfaceListener() {
        return this.c0;
    }

    public NaviMapViewListener getNaviMapViewListener() {
        return this.e0;
    }

    public Point getPointGesturesCenter() {
        return this.q;
    }

    public String getProjectionPt(String str) {
        if (a()) {
            return this.v.getProjectionPt(str);
        }
        return null;
    }

    public int getScaleLevel(int i, int i2) {
        if (a()) {
            return this.v.getScaleLevel(i, i2);
        }
        return 0;
    }

    public int getSceneLayerScene() {
        return this.l;
    }

    public int getSceneLayerTheme() {
        return this.m;
    }

    public int getScreenHeight() {
        MapStatus.WinRound winRound = getMapStatus().winRound;
        int i = winRound.bottom - winRound.top;
        this.z = i;
        return i;
    }

    public int getScreenWidth() {
        MapStatus.WinRound winRound = getMapStatus().winRound;
        int i = winRound.right - winRound.left;
        this.y = i;
        return i;
    }

    public y getStreetArrowClickListener() {
        return this.Z;
    }

    public int getVMPMapCityCode() {
        if (this.v == null) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString("querytype", "map");
        this.v.GetVMPMapCityInfo(bundle);
        return bundle.getInt("code");
    }

    public int getVMPMapCityItsInfo() {
        if (this.v == null) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString("querytype", "its");
        this.v.GetVMPMapCityInfo(bundle);
        return bundle.getInt("rst");
    }

    public int getVMPMapCityLevel() {
        if (this.v == null) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString("querytype", "map");
        this.v.GetVMPMapCityInfo(bundle);
        return bundle.getInt("level");
    }

    public int getVMPMapCitySatInfo() {
        if (this.v == null) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString("querytype", OapsKey.KEY_SEARCH_AD_TYPE);
        this.v.GetVMPMapCityInfo(bundle);
        return bundle.getInt("rst");
    }

    public float getZoomLevel() {
        Bundle bundleGetMapStatus;
        AppBaseMap appBaseMap = this.v;
        if (appBaseMap == null || (bundleGetMapStatus = appBaseMap.GetMapStatus()) == null) {
            return 4.0f;
        }
        return (float) bundleGetMapStatus.getDouble("level");
    }

    public float getZoomToBound(Bundle bundle, int i, int i2) {
        if (a()) {
            return this.v.GetZoomToBound(bundle, i, i2);
        }
        return 0.0f;
    }

    public float getZoomToBoundF(Bundle bundle) {
        if (a()) {
            return this.v.GetZoomToBoundF(bundle);
        }
        return 0.0f;
    }

    public double getZoomUnitsInMeter() {
        Bundle bundleGetMapStatus;
        AppBaseMap baseMap = getBaseMap();
        if (baseMap != null && (bundleGetMapStatus = baseMap.GetMapStatus()) != null) {
            double d2 = bundleGetMapStatus.getFloat("adapterZoomUnits");
            if (d2 > 1.0E-4d) {
                return d2;
            }
        }
        return Math.pow(2.0d, 18.0f - getZoomLevel());
    }

    public void handleClick(MotionEvent motionEvent) {
        MapMsgProc(UIMsg.KEvent.V_WM_LBUTTONCLICK, 0, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16));
    }

    public void handleDoubleClickZoom(MotionEvent motionEvent) {
        if (this.H && System.currentTimeMillis() - this.N >= 100) {
            mapStatusChangeStart();
            this.mIsAnimating = true;
            float y = motionEvent.getY();
            float f2 = this.L - y;
            MapMsgProc(8193, 3, (int) ((f2 / (getScreenHeight() / 9.0f)) * 10000.0f));
            this.M = f2;
            this.L = y;
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.d());
            if (!isNaviMode() || getNaviMapViewListener() == null) {
                return;
            }
            getNaviMapViewListener().onAction(521, null);
        }
    }

    public void handleDoubleDownClick(MotionEvent motionEvent) {
        this.G = true;
        this.K = motionEvent.getX();
        this.L = motionEvent.getY();
        this.N = System.currentTimeMillis();
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.d());
    }

    public void handleDoubleTouch(MotionEvent motionEvent) {
        SoftReference<MapViewInterface> softReference;
        GeoPoint geoPointFromPixels;
        float latitudeE6;
        NaviMapViewListener naviMapViewListener;
        if (System.currentTimeMillis() - this.N > 150) {
            return;
        }
        if (isNaviMode() && (naviMapViewListener = this.e0) != null) {
            naviMapViewListener.onAction(513, motionEvent);
            return;
        }
        if (!this.F || (softReference = this.d0) == null || softReference.get() == null || this.d0.get().getProjection() == null) {
            return;
        }
        MapStatus mapStatus = getMapStatus();
        float x = motionEvent.getX() - (mapStatus.winRound.left + (getScreenWidth() / 2));
        float y = (motionEvent.getY() - (mapStatus.winRound.top + (getScreenHeight() / 2))) * (-1.0f);
        float longitudeE6 = 0.0f;
        if (isCompass || this.J) {
            geoPointFromPixels = this.d0.get().getProjection().fromPixels(mapStatus.winRound.left + (getScreenWidth() / 2), mapStatus.winRound.top + (getScreenHeight() / 2));
            x = 0.0f;
            y = 0.0f;
        } else if (this.q == null || !this.s) {
            LatLng latLng = this.r;
            geoPointFromPixels = (latLng == null || !this.s) ? this.d0.get().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : CoordUtil.ll2mc(latLng);
        } else {
            Projection projection = this.d0.get().getProjection();
            Point point = this.q;
            geoPointFromPixels = projection.fromPixels(point.x, point.y);
        }
        if (geoPointFromPixels != null) {
            longitudeE6 = (float) geoPointFromPixels.getLongitudeE6();
            latitudeE6 = (float) geoPointFromPixels.getLatitudeE6();
        } else {
            latitudeE6 = 0.0f;
        }
        this.P = true;
        Point point2 = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        if (geoPointFromPixels != null && this.mListeners != null) {
            for (int i = 0; i < this.mListeners.size(); i++) {
                v vVar = this.mListeners.get(i);
                if (vVar != null) {
                    vVar.a(geoPointFromPixels);
                    if (vVar.a(point2, getMapStatusInner())) {
                        return;
                    }
                }
            }
        }
        getGestureMonitor().a(this.d0.get().getZoomLevel() + 1.0f);
        mapStatusChangeStart();
        MapMsgProc(8195, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16), (this.y / 2) | ((this.z / 2) << 16), 0, 0, longitudeE6, latitudeE6, x, y);
        f = System.currentTimeMillis();
        procGestureForLog(false, null);
    }

    @SuppressLint({"FloatMath"})
    public boolean handleFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (!b || !this.U || !this.j) {
            return false;
        }
        float fSqrt = (float) (((double) (((float) Math.sqrt((f2 * f2) + (f3 * f3))) / (SysOSUtil.getInstance().getDensityDPI() / 310.0f))) * 1.3d);
        if (getMapControlMode() != MapControlMode.STREET && fSqrt < 300.0f) {
            this.B = false;
            return false;
        }
        this.B = true;
        if (this.mListeners != null) {
            com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = getMapStatusInner();
            for (int i = 0; i < this.mListeners.size(); i++) {
                v vVar = this.mListeners.get(i);
                if (vVar != null && vVar.a(motionEvent2, f2, f3, mapStatusInner)) {
                    this.g0 = false;
                    return false;
                }
            }
        }
        getGestureMonitor().a();
        mapStatusChangeStart();
        MapMsgProc(34, (int) fSqrt, (((int) motionEvent2.getY()) << 16) | ((int) motionEvent2.getX()));
        if (getMapViewListener() != null) {
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.c());
        }
        this.g0 = false;
        if (this.mListeners != null) {
            for (int i2 = 0; i2 < this.mListeners.size(); i2++) {
                v vVar2 = this.mListeners.get(i2);
                if (vVar2 != null) {
                    vVar2.a(motionEvent2);
                }
            }
        }
        return true;
    }

    public boolean handleKeyEvent(int i, KeyEvent keyEvent) {
        int iGetAdaptKeyCode = GetAdaptKeyCode(i);
        if (iGetAdaptKeyCode == 0) {
            return false;
        }
        MapMsgProc(1, iGetAdaptKeyCode, 0);
        return true;
    }

    public void handleLongClick(MotionEvent motionEvent) {
        MapMsgProc(UIMsg.KEvent.V_WM_LBUTTONLONGCLICK, 0, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16));
    }

    public int handleMapModeGet() {
        return MapMsgProc(4113, 0, 0);
    }

    public boolean handlePopupClick(int i, int i2) {
        return false;
    }

    public void handleRightClick() {
        MapMsgProc(UIMsg.KEvent.V_WM_RBUTTONCLICK, 0, 0);
    }

    public void handleStreetscapeDoubleTouch(MotionEvent motionEvent) {
        float longitudeE6;
        float latitudeE6;
        SoftReference<MapViewInterface> softReference = this.d0;
        if (softReference == null || softReference.get() == null || this.d0.get().getProjection() == null) {
            return;
        }
        MapStatus mapStatus = getMapStatus();
        Projection projection = this.d0.get().getProjection();
        MapStatus.WinRound winRound = mapStatus.winRound;
        GeoPoint geoPointFromPixels = projection.fromPixels(winRound.left + (this.y / 2), winRound.top + (this.z / 2));
        if (geoPointFromPixels != null) {
            longitudeE6 = (float) geoPointFromPixels.getLongitudeE6();
            latitudeE6 = (float) geoPointFromPixels.getLatitudeE6();
        } else {
            longitudeE6 = 0.0f;
            latitudeE6 = 0.0f;
        }
        MapMsgProc(8195, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()), ((this.z / 2) << 16) | (this.y / 2), 0, 0, longitudeE6, latitudeE6, 0.0d, 0.0d);
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        if (!a()) {
            return false;
        }
        if (!this.B) {
            this.i0.a(motionEvent);
        }
        if (motionEvent.getPointerCount() == 2) {
            this.i = true;
            b = false;
            c();
            procGestureForLog(false, null);
        }
        if (motionEvent.getAction() != 2 && this.G) {
            this.i = true;
            c();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.i = true;
            a(motionEvent);
        } else if (action == 1) {
            b = true;
            this.i = true;
            handleTouchUp(motionEvent);
        } else {
            if (action != 2) {
                return false;
            }
            if (this.G) {
                handleDoubleClickZoom(motionEvent);
            } else if (this.U) {
                handleTouchMove(motionEvent);
            }
        }
        if (this.mListeners != null) {
            for (int i = 0; i < this.mListeners.size(); i++) {
                v vVar = this.mListeners.get(i);
                if (vVar != null) {
                    vVar.a(motionEvent);
                }
            }
        }
        return true;
    }

    public boolean handleTouchMove(MotionEvent motionEvent) {
        if (!b || System.currentTimeMillis() - f < 300) {
            return true;
        }
        int i = 0;
        if (this.mHasMapObjDraging) {
            if (getMapView() != null && getMapView().getProjection() != null) {
                GeoPoint geoPointFromPixels = getMapView().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.mListeners != null) {
                    while (i < this.mListeners.size()) {
                        v vVar = this.mListeners.get(i);
                        if (vVar != null && geoPointFromPixels != null) {
                            vVar.g(geoPointFromPixels);
                        }
                        i++;
                    }
                }
            }
            return true;
        }
        if (this.mHasBmDrawItemDraging) {
            if (getMapView() != null && getMapView().getProjection() != null) {
                GeoPoint geoPointFromPixels2 = getMapView().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                if (this.mListeners != null) {
                    while (i < this.mListeners.size()) {
                        v vVar2 = this.mListeners.get(i);
                        if (vVar2 != null && geoPointFromPixels2 != null) {
                            vVar2.c(geoPointFromPixels2);
                        }
                        i++;
                    }
                }
            }
            return true;
        }
        float fAbs = Math.abs(motionEvent.getX() - c);
        float fAbs2 = Math.abs(motionEvent.getY() - d);
        double density = SysOSUtil.getInstance().getDensity();
        if (density > 1.5d) {
            density *= 1.5d;
        }
        float f2 = (float) density;
        if (e && fAbs / f2 <= 3.0f && fAbs2 / f2 <= 3.0f) {
            return true;
        }
        e = false;
        if (isCompass) {
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.a());
        }
        procGestureForLog(true, new com.baidu.platform.comapi.basestruct.Point(fAbs, fAbs2));
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        float x2 = c - motionEvent.getX();
        float y2 = d - motionEvent.getY();
        Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        Point point2 = new Point((int) (motionEvent.getRawX() + x2), (int) (motionEvent.getRawY() + y2));
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (this.mListeners != null) {
            com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = getMapStatusInner();
            for (int i2 = 0; i2 < this.mListeners.size(); i2++) {
                v vVar3 = this.mListeners.get(i2);
                if (vVar3 != null && vVar3.c(point2, point, mapStatusInner)) {
                    this.B = false;
                    this.p = true;
                    this.g0 = true;
                    return false;
                }
            }
        }
        if (this.i) {
            getGestureMonitor().d();
            this.i = false;
        }
        mapStatusChangeStart();
        MapMsgProc(3, 0, (y << 16) | x);
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.b(false, true));
        this.B = false;
        this.p = true;
        this.g0 = true;
        return false;
    }

    public boolean handleTouchSingleClick(MotionEvent motionEvent) {
        NaviMapViewListener naviMapViewListener;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (b(x, y) || handlePopupClick(x, y)) {
            return true;
        }
        if (OverlayUtil.isOverlayUpgrade() && a(x, y, this.u)) {
            return true;
        }
        this.u = c(x, y);
        if (a(1, x, y)) {
            return true;
        }
        if (this.A && a(x, y)) {
            return true;
        }
        if (isNaviMode() && (naviMapViewListener = this.e0) != null) {
            naviMapViewListener.onAction(514, motionEvent);
        }
        if (getMapViewListener() == null) {
            return false;
        }
        getMapViewListener().onClickedBackground((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleTouchUp(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (this.mHasMapObjDraging) {
            if (this.mListeners != null && getMapView() != null && getMapView().getProjection() != null) {
                GeoPoint geoPointFromPixels = getMapView().getProjection().fromPixels(x, y);
                for (int i = 0; i < this.mListeners.size(); i++) {
                    v vVar = this.mListeners.get(i);
                    if (vVar != null && geoPointFromPixels != null) {
                        vVar.e(geoPointFromPixels);
                    }
                }
            }
            this.mHasMapObjDraging = false;
            return true;
        }
        if (this.mHasBmDrawItemDraging) {
            if (this.mListeners != null && getMapView() != null && getMapView().getProjection() != null) {
                GeoPoint geoPointFromPixels2 = getMapView().getProjection().fromPixels(x, y);
                for (int i2 = 0; i2 < this.mListeners.size(); i2++) {
                    v vVar2 = this.mListeners.get(i2);
                    if (vVar2 != null && geoPointFromPixels2 != null) {
                        vVar2.f(geoPointFromPixels2);
                    }
                }
            }
            this.mHasBmDrawItemDraging = false;
            return true;
        }
        if (b) {
            MapMsgProc(5, 0, x | (y << 16));
        }
        if (!this.B && getMapViewListener() != null) {
            getMapViewListener().onMapAnimationFinish();
        }
        if (!this.B && isNaviMode() && getNaviMapViewListener() != null) {
            getNaviMapViewListener().onMapAnimationFinish();
        }
        boolean z = motionEvent.getEventTime() - this.f0 < 300 && Math.abs(motionEvent.getX() - c) < 10.0f && Math.abs(motionEvent.getY() - d) < 10.0f;
        com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = getMapStatusInner();
        if (!this.B) {
            if (!z) {
                float f2 = mapStatusInner.f3992a;
                if (f2 >= this.mMaxZoomLevel || f2 < this.mMinZoomLevel) {
                    if (this.g0) {
                        if (!this.P && !this.Q && !this.mIsAnimating && this.mListeners != null) {
                            for (int i3 = 0; i3 < this.mListeners.size(); i3++) {
                                v vVar3 = this.mListeners.get(i3);
                                if (vVar3 != null) {
                                    vVar3.a(mapStatusInner);
                                }
                            }
                            this.mIsMoving = false;
                        }
                    }
                }
            }
        }
        this.g0 = false;
        this.B = false;
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.b(true, false));
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.b0.c());
        return true;
    }

    public boolean handleTrackballEvent(MotionEvent motionEvent) {
        if (!a()) {
            return false;
        }
        if (motionEvent.getAction() == 2) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int i = rawX > 0.0f ? 18 : rawX < 0.0f ? 16 : 0;
            if (rawY > 0.0f) {
                i = 19;
            } else if (rawY < 0.0f) {
                i = 17;
            }
            if (i == 0) {
                return false;
            }
            MapMsgProc(1, i, 0);
        }
        return true;
    }

    public boolean handleZoomTo(int i) {
        if (i == 0) {
            MapMsgProc(4097, -1, 0);
        } else if (i == 1) {
            MapMsgProc(4096, -1, 0);
        }
        return false;
    }

    public boolean importMapTheme(int i) {
        if (a()) {
            return this.v.importMapTheme(i);
        }
        return false;
    }

    public void initAppBaseMap() {
        if (g.size() == 0) {
            initBaseMap();
        } else {
            createByDuplicateAppBaseMap(g.get(0).GetId());
        }
    }

    public void initBaseMap() {
        AppBaseMap appBaseMap = new AppBaseMap();
        this.v = appBaseMap;
        appBaseMap.Create();
        this.w = this.v.GetId();
        List<AppBaseMap> list = g;
        if (list != null) {
            list.add(this.v);
        }
    }

    public void initMapResources(Bundle bundle) {
        if (this.C || bundle == null || this.v == null) {
            return;
        }
        boolean z = SysOSUtil.getInstance().getDensityDPI() >= 180;
        this.nearlyRadius = (SysOSUtil.getInstance().getDensityDPI() * 25) / 240;
        String string = bundle.getString("modulePath");
        String string2 = bundle.getString("appSdcardPath");
        String string3 = bundle.getString("appCachePath");
        String string4 = bundle.getString("appSecondCachePath");
        String string5 = bundle.getString("engineErrorPath");
        int i = bundle.getInt("mapTmpMax");
        int i2 = bundle.getInt("domTmpMax");
        int i3 = bundle.getInt("itsTmpMax");
        int i4 = bundle.getInt("ssgTmpMax");
        String str = z ? "/h/" : "/l/";
        String str2 = string + "/cfg";
        String str3 = string2 + "/vmp";
        String str4 = str2 + "/a/";
        String str5 = str3 + str;
        String str6 = str3 + str;
        String str7 = string3 + "/tmp/";
        String str8 = string4 + "/tmp/";
        Bundle bundle2 = new Bundle();
        bundle2.putString("cfgdataroot", str4);
        bundle2.putString("vmpdataroot", str5);
        bundle2.putString("tmpdataroot", str7);
        bundle2.putString("tmpdatapast", str8);
        bundle2.putString("importroot", str6);
        bundle2.putString("stylerespath", str2 + "/a/");
        if (string5 != null && string5.length() > 0) {
            bundle2.putString("engineerrorpath", string5);
        }
        if (this.y <= 0 || this.z <= 0) {
            this.y = SysOSUtil.getInstance().getScreenWidth();
            this.z = SysOSUtil.getInstance().getScreenWidth();
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("MapControl init screenWidth: " + this.y + "; screenHeight: " + this.z);
        }
        bundle2.putInt("cx", this.y);
        bundle2.putInt("cy", this.z);
        bundle2.putInt("ndpi", SysOSUtil.getInstance().getDensityDPI());
        bundle2.putFloat("fdpi", SysOSUtil.getInstance().getDensityDPI());
        bundle2.putInt("maptmpmax", i);
        bundle2.putInt("domtmpmax", i2);
        bundle2.putInt("itstmpmax", i3);
        bundle2.putInt("ssgtmpmax", i4);
        bundle2.putInt("pathchange", 0);
        if (bundle.containsKey("maptheme")) {
            bundle2.putInt("maptheme", bundle.getInt("maptheme"));
        }
        if (bundle.containsKey("mapscene")) {
            bundle2.putInt("mapscene", bundle.getInt("mapscene"));
        }
        if (bundle.containsKey("fontsizelevel")) {
            bundle2.putInt("fontsizelevel", bundle.getInt("fontsizelevel"));
        }
        if (!JNIInitializer.isUserTest()) {
            JNIInitializer.isDebug();
        }
        if (this.v.initWithOptions(bundle2, false)) {
            this.v.SetMapStatus(bundle);
            this.C = true;
            return;
        }
        Log.e(f4159a, "MapControl init fail!");
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("MapControl init fail");
        }
        HashMap map = new HashMap();
        map.put(ExifInterface.LONGITUDE_EAST, "0");
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "M", "0.2", map);
    }

    public boolean is3DGestureEnable() {
        return this.R;
    }

    public boolean isBaseIndoorMapMode() {
        if (a()) {
            return this.v.IsBaseIndoorMapMode();
        }
        return false;
    }

    public boolean isCanTouchMove() {
        return this.U;
    }

    public boolean isDoubleClickMoveZoom() {
        return this.H;
    }

    public boolean isDoubleClickZoom() {
        return this.F;
    }

    public boolean isDuplicate() {
        return this.h0;
    }

    public boolean isEnableDMoveZoom() {
        return this.G;
    }

    public boolean isEnableIndoor3D() {
        if (a()) {
            return this.v.isEnableIndoor3D();
        }
        return true;
    }

    public boolean isEnableZoom() {
        return this.T;
    }

    public boolean isEnlargeCenterWithDoubleClickEnabled() {
        return this.J;
    }

    public boolean isFlingEnabled() {
        return this.j;
    }

    public boolean isInFocusBarBorder(GeoPoint geoPoint, double d2) {
        return a() && geoPoint != null && this.v.IsPointInFocusBarBorder(geoPoint.getLongitude(), geoPoint.getLatitude(), d2);
    }

    public boolean isInFocusIndoorBuilding(GeoPoint geoPoint) {
        return a() && geoPoint != null && this.v.IsPointInFocusIDRBorder(geoPoint.getLongitude(), geoPoint.getLatitude());
    }

    public boolean isMapAnimationRunning() {
        if (a()) {
            return this.v.isAnimationRunning();
        }
        return false;
    }

    public boolean isMovedMap() {
        return this.p;
    }

    public boolean isNaviMode() {
        if (a()) {
            return this.v.isNaviMode();
        }
        return false;
    }

    public boolean isOverlookGestureEnable() {
        return this.S;
    }

    public boolean isPressedOnPopup(int i, int i2) {
        return false;
    }

    public boolean isSetBackgroundDraw() {
        AppBaseMap appBaseMap = this.v;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.isSupBackgroundDraw();
    }

    public boolean isStreetArrowShown() {
        if (a()) {
            return this.v.IsStreetArrowShown();
        }
        return false;
    }

    public boolean isStreetCustomMarkerShown() {
        if (a()) {
            return this.v.IsStreetCustomMarkerShown();
        }
        return false;
    }

    public boolean isStreetPOIMarkerShown() {
        if (a()) {
            return this.v.IsStreetPOIMarkerShown();
        }
        return false;
    }

    public boolean isStreetRoadClickable() {
        if (a()) {
            return this.v.IsStreetRoadClickable();
        }
        return false;
    }

    public boolean isTwoTouchClickZoomEnabled() {
        return this.I;
    }

    public void mapStatusChangeStart() {
        if (this.mIsMoving) {
            return;
        }
        this.mIsMoving = true;
        this.mIsAnimating = false;
        if (this.mListeners != null) {
            com.baidu.mapsdkplatform.comapi.map.s mapStatusInner = getMapStatusInner();
            for (int i = 0; i < this.mListeners.size(); i++) {
                v vVar = this.mListeners.get(i);
                if (vVar != null) {
                    vVar.c(mapStatusInner);
                }
            }
        }
    }

    public void onPause() {
        if (a()) {
            this.v.OnPause();
        }
    }

    public void onResume() {
        if (a()) {
            this.v.OnResume();
        }
    }

    public void procGestureForLog(boolean z, com.baidu.platform.comapi.basestruct.Point point) {
        if (!this.E.f4167a) {
            MapStatus mapStatus = getMapStatus();
            a aVar = this.E;
            aVar.f4167a = true;
            aVar.b = mapStatus.level;
            aVar.c = new GeoPoint(mapStatus.centerPtX, mapStatus.centerPtY);
            this.E.d = new com.baidu.platform.comapi.basestruct.Point(0, 0);
        }
        if (z) {
            int iAbs = Math.abs(point.getIntX());
            int iAbs2 = Math.abs(point.getIntY());
            com.baidu.platform.comapi.basestruct.Point point2 = this.E.d;
            point2.setIntX(point2.getIntX() + iAbs);
            com.baidu.platform.comapi.basestruct.Point point3 = this.E.d;
            point3.setIntY(point3.getIntY() + iAbs2);
        }
    }

    public void recycleMemory(RecycleMemoryLevel recycleMemoryLevel) {
        if (a()) {
            this.v.recycleMemory(recycleMemoryLevel.getLevel());
        }
    }

    public void registMapViewListener(v vVar) {
        List<v> list;
        if (vVar == null || (list = this.mListeners) == null) {
            return;
        }
        list.add(vVar);
    }

    public void removeOneOverlayItem(Bundle bundle) {
        this.v.removeOneOverlayItem(bundle);
    }

    public void removeStreetAllCustomMarker() {
        if (a()) {
            this.v.RemoveStreetAllCustomMarker();
        }
    }

    public void removeStreetCustomMarker(String str) {
        if (a()) {
            this.v.RemoveStreetCustomMaker(str);
        }
    }

    public void saveScreenToLocal(String str, int i, int i2, int i3, int i4) {
        if (!a() || TextUtils.isEmpty(str)) {
            return;
        }
        String string = null;
        if (i3 != 0 && i4 != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", i);
                jSONObject.put("y", i2);
                jSONObject.put("width", i3);
                jSONObject.put("height", i4);
                string = jSONObject.toString();
            } catch (Exception unused) {
            }
        }
        this.v.SaveScreenToLocal(str, string);
    }

    public void scrollBy(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        MapStatus.WinRound winRound = getMapStatus().winRound;
        d(winRound.left + (this.y / 2) + i, winRound.top + (this.z / 2) + i2);
    }

    public void set3DGestureEnable(boolean z) {
        this.R = z;
    }

    public void setActingTwoClickZoom(boolean z) {
        this.Q = z;
    }

    public void setAllStreetCustomMarkerVisibility(boolean z) {
        if (a()) {
            this.v.SetAllStreetCustomMarkerVisibility(z);
        }
    }

    public void setCanTouchMove(boolean z) {
        this.U = z;
    }

    public void setCaptureMapListener(CaptureMapListener captureMapListener) {
        this.X = captureMapListener;
    }

    public void setDoubleClickGesturesCenter(boolean z) {
        this.s = z;
    }

    public void setDoubleClickMoveZoomEnable(boolean z) {
        this.H = z;
    }

    public void setDoubleClickZoom(boolean z) {
        this.F = z;
    }

    public void setEnableIndoor3D(boolean z) {
        if (a()) {
            this.v.setEnableIndoor3D(z);
        }
    }

    public void setEnableZoom(boolean z) {
        this.T = z;
    }

    public void setEngineMsgListener(EngineMsgListener engineMsgListener) {
        this.b0 = engineMsgListener;
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.J = z;
    }

    public void setFlingEnable(boolean z) {
        this.j = z;
    }

    public void setHideIndoorPopupListener(g gVar) {
        this.Y = gVar;
    }

    public void setInertialAnimation(boolean z) {
        this.mIsInertialAnimation = z;
        this.P = z;
        this.Q = z;
    }

    public void setLatLngGesturesCenter(LatLng latLng) {
        this.r = latLng;
    }

    public boolean setLayerSceneMode(long j, MapSceneMode mapSceneMode) {
        if (a()) {
            return this.v.SetLayerSceneMode(j, mapSceneMode.getMode());
        }
        return false;
    }

    public void setMapClickEnable(boolean z) {
        this.A = z;
    }

    public int setMapControlMode(MapControlMode mapControlMode) {
        if (!a()) {
            return -1;
        }
        this.j0 = mapControlMode;
        return this.v.SetMapControlMode(mapControlMode.b);
    }

    public void setMapFirstFrameCallback(MapFirstFrameCallback mapFirstFrameCallback) {
        this.o = mapFirstFrameCallback;
    }

    public void setMapRenderModeChangeListener(MapRenderModeChangeListener mapRenderModeChangeListener) {
        this.a0 = mapRenderModeChangeListener;
    }

    public void setMapScene(int i) {
        if (i == getMapScene()) {
            return;
        }
        this.l = i;
        if (a()) {
            this.v.setMapScene(this.l);
        }
    }

    public void setMapStatus(MapStatus mapStatus, boolean z) {
        if (!a() || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt(Constant.MAP_KEY_TOP, mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putInt("animation", 0);
        bundle.putInt("animatime", 0);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", z ? 1 : 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("adapterZoomUnits", mapStatus.adapterZoomUnits);
        this.v.SetMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i, boolean z) {
        if (!a() || this.v == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt(Constant.MAP_KEY_TOP, mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", i);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", z ? 1 : 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        bundle.putFloat("adapterZoomUnits", mapStatus.adapterZoomUnits);
        this.v.SetMapStatus(bundle);
    }

    public boolean setMapTheme(int i, Bundle bundle) {
        if (!a()) {
            return false;
        }
        if (this.v.getMapTheme() == i) {
            return true;
        }
        this.m = i;
        return this.v.setMapTheme(i, bundle);
    }

    public boolean setMapThemeScene(int i, int i2, Bundle bundle) {
        if (!a()) {
            return false;
        }
        if (this.v.getMapTheme() == i && this.v.getMapScene() == i2) {
            return true;
        }
        this.m = i;
        this.l = i2;
        return this.v.setMapThemeScene(i, i2, bundle);
    }

    public void setMapViewInterface(MapViewInterface mapViewInterface) {
        this.d0 = new SoftReference<>(mapViewInterface);
    }

    public void setMapViewListener(MapViewListener mapViewListener) {
        this.W = mapViewListener;
    }

    public void setMapViewSurfaceListener(MapViewSurfaceListener mapViewSurfaceListener) {
        this.c0 = mapViewSurfaceListener;
    }

    public void setMaxAndMinZoomLevel(float f2, float f3) {
        this.mMaxZoomLevel = f2;
        this.mMinZoomLevel = f3;
    }

    public void setNaviMapViewListener(NaviMapViewListener naviMapViewListener) {
        this.e0 = naviMapViewListener;
    }

    public void setNetStatus(int i) {
        EngineMsgListener engineMsgListener = this.b0;
        if (engineMsgListener == null) {
            return;
        }
        if (i == 1) {
            engineMsgListener.onLongLinkConnect();
        } else if (i == 2 && this.k != i) {
            engineMsgListener.onLongLinkDisConnect();
        }
        this.k = i;
    }

    public void setOverlayListener(w wVar) {
        this.mOverlayListener = wVar;
    }

    public void setOverlayMapCallBack(p pVar) {
        AppBaseMap appBaseMap;
        if (pVar == null || (appBaseMap = this.v) == null) {
            return;
        }
        appBaseMap.SetCallback(pVar);
    }

    public void setOverlookGestureEnable(boolean z) {
        this.S = z;
    }

    public void setPointGesturesCenter(Point point) {
        this.q = point;
    }

    public void setRecommendPOIScene(RecommendPoiScene recommendPoiScene) {
        if (a()) {
            this.v.setRecommendPOIScene(recommendPoiScene.value);
        }
    }

    public void setSDKLayerBelowBmLayer(boolean z) {
        this.V = z;
    }

    public void setScreenSize(int i, int i2) {
        this.y = i;
        this.z = i2;
    }

    public void setStreetArrowClickListener(y yVar) {
        this.Z = yVar;
    }

    public void setStreetArrowShow(boolean z) {
        if (a()) {
            this.v.SetStreetArrowShow(z);
        }
    }

    public void setStreetMarkerClickable(String str, boolean z) {
        if (a()) {
            this.v.SetStreetMarkerClickable(str, z);
        }
    }

    public void setStreetRoadClickable(boolean z) {
        if (a()) {
            this.v.SetStreetRoadClickable(z);
        }
    }

    public void setStyleMode(MapStyleMode mapStyleMode) {
        if (a()) {
            this.v.SetStyleMode(mapStyleMode.getMode());
        }
    }

    public void setSupBackgroundDraw(boolean z) {
        AppBaseMap appBaseMap = this.v;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setSupBackgroundDraw(z);
    }

    public void setTargetStreetCustomMarkerVisibility(boolean z, String str) {
        if (a()) {
            this.v.SetTargetStreetCustomMarkerVisibility(z, str);
        }
    }

    public void setTravelMode(boolean z) {
        this.n = z;
    }

    public void setTwoTouchClickZoomEnabled(boolean z) {
        this.I = z;
    }

    public void setUniversalFilter(String str) {
        if (a()) {
            this.v.setUniversalFilter(str);
        }
    }

    public void showBaseIndoorMap(boolean z) {
        if (a()) {
            this.v.ShowBaseIndoorMap(z);
        }
    }

    public void showStreetPOIMarker(boolean z) {
        if (a()) {
            this.v.ShowStreetPOIMarker(z);
        }
    }

    public void showUniversalLayer(Bundle bundle) {
        if (a()) {
            this.v.showUniversalLayer(bundle);
        }
    }

    public void startIndoorAnimation() {
        if (a()) {
            this.v.StartIndoorAnimation();
        }
    }

    public boolean switchBaseIndoorMapFloor(String str, String str2) {
        if (a()) {
            return this.v.SwitchBaseIndoorMapFloor(str, str2);
        }
        return false;
    }

    public void unInit() {
        AppBaseMap appBaseMap;
        d();
        Handler handler = this.x;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.x = null;
        }
        List<AppBaseMap> list = g;
        if (list != null) {
            list.remove(this.v);
        }
        List<v> list2 = this.mListeners;
        if (list2 != null) {
            list2.clear();
        }
        if (this.C && (appBaseMap = this.v) != null) {
            appBaseMap.Release();
            this.v = null;
            this.C = false;
        }
        if (this.a0 != null) {
            this.a0 = null;
        }
    }

    public void unInitForMultiTextureView() {
        AppBaseMap appBaseMap;
        if (!this.C || (appBaseMap = this.v) == null) {
            return;
        }
        appBaseMap.Release();
        this.v = null;
        this.C = false;
    }

    public void updateDrawFPS() {
        if (a()) {
            this.v.updateDrawFPS();
        }
    }

    public void updateOneOverlayItem(Bundle bundle) {
        this.v.updateOneOverlayItem(bundle);
    }

    public int MapMsgProc(int i, int i2, int i3, int i4, int i5, double d2, double d3, double d4, double d5) {
        if (a()) {
            return MapProc(this.w, i, i2, i3, i4, i5, d2, d3, d4, d5);
        }
        return -1;
    }

    private boolean a() {
        return this.C && this.v != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x025a A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0263 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x026d A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0276 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0280 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0289 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0293 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x029e A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02aa A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02b3 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02bd A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02c6 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02d0 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02d9 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02e3 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02ec A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017a A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0186 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0192 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a0 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ac A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ba A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c8 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d6 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e4 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01fb A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0212 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0220 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0239 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0249 A[Catch: JSONException -> 0x0318, TryCatch #0 {JSONException -> 0x0318, blocks: (B:13:0x0060, B:15:0x007a, B:16:0x0080, B:133:0x02f3, B:25:0x00ae, B:28:0x00cb, B:32:0x00dc, B:34:0x00e7, B:36:0x00f5, B:41:0x010c, B:43:0x0112, B:50:0x0146, B:57:0x0174, B:59:0x017a, B:60:0x0180, B:62:0x0186, B:63:0x018c, B:65:0x0192, B:66:0x0198, B:68:0x01a0, B:69:0x01a6, B:71:0x01ac, B:72:0x01b2, B:74:0x01ba, B:75:0x01c0, B:77:0x01c8, B:78:0x01ce, B:80:0x01d6, B:81:0x01dc, B:83:0x01e4, B:84:0x01f3, B:86:0x01fb, B:87:0x020a, B:89:0x0212, B:90:0x0218, B:92:0x0220, B:94:0x0231, B:96:0x0239, B:97:0x0241, B:99:0x0249, B:100:0x0251, B:102:0x025a, B:104:0x0265, B:106:0x026d, B:108:0x0278, B:110:0x0280, B:112:0x028b, B:114:0x0293, B:116:0x02a2, B:118:0x02aa, B:120:0x02b5, B:122:0x02bd, B:124:0x02c8, B:126:0x02d0, B:128:0x02db, B:130:0x02e3, B:132:0x02ee, B:131:0x02ec, B:127:0x02d9, B:123:0x02c6, B:119:0x02b3, B:115:0x029e, B:111:0x0289, B:107:0x0276, B:103:0x0263, B:49:0x013d, B:46:0x0129, B:51:0x014a, B:53:0x015a, B:55:0x0160, B:37:0x00fc, B:39:0x0102, B:40:0x0109, B:33:0x00e3, B:134:0x030e, B:21:0x008e, B:18:0x0086), top: B:140:0x0060, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(int i, int i2) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        String str;
        int i3;
        ArrayList arrayList;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        ArrayList arrayList2;
        double intX;
        double intY;
        String str16 = MapBundleKey.MapObjKey.OBJ_SS_POINAME;
        String str17 = MapBundleKey.MapObjKey.OBJ_GEO;
        String str18 = "index";
        String str19 = "in";
        String str20 = MapBundleKey.MapObjKey.OBJ_TYPE;
        String str21 = "z";
        String str22 = "y";
        String str23 = "x";
        String str24 = "ud";
        boolean zA = a();
        String str25 = MapBundleKey.MapObjKey.OBJ_DIS;
        if (!zA || getMapViewListener() == null) {
            return false;
        }
        int i4 = this.nearlyRadius;
        String str26 = MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID;
        String strGetNearlyObjID = this.v.GetNearlyObjID(-1L, i, i2, (int) (((double) i4) * getZoomUnitsInMeter()));
        if (strGetNearlyObjID == null) {
            return false;
        }
        new ArrayList();
        try {
            JSONArray jSONArray2 = new JSONObject(strGetNearlyObjID).getJSONArray("dataset");
            if (((JSONObject) jSONArray2.get(0)).getInt(MapBundleKey.MapObjKey.OBJ_TYPE) != 7000) {
                return false;
            }
            ArrayList arrayList3 = new ArrayList();
            int i5 = 0;
            while (i5 < jSONArray2.length()) {
                try {
                    jSONObject = (JSONObject) jSONArray2.get(i5);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    i3 = i5;
                    jSONArray = jSONArray2;
                    arrayList2 = arrayList3;
                    str4 = str17;
                    str5 = str18;
                    str6 = str19;
                    str = str20;
                    str13 = str21;
                    str12 = str22;
                    str10 = str25;
                    str9 = str24;
                } else {
                    jSONArray = jSONArray2;
                    int i6 = jSONObject.getInt(str20);
                    str = str20;
                    if (i6 == 26) {
                        i3 = i5;
                        str9 = str24;
                        arrayList2 = arrayList3;
                        str4 = str17;
                        str5 = str18;
                        str6 = str19;
                        str13 = str21;
                        str12 = str22;
                        str10 = str25;
                    } else {
                        MapObj mapObj = new MapObj();
                        i3 = i5;
                        if (jSONObject.has(str24)) {
                            arrayList = arrayList3;
                            mapObj.strUid = jSONObject.getString(str24);
                        } else {
                            arrayList = arrayList3;
                            mapObj.strUid = "";
                        }
                        mapObj.strText = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
                        if (jSONObject.has(str19)) {
                            mapObj.nIndex = jSONObject.getInt(str19);
                        } else if (jSONObject.has(str18)) {
                            mapObj.nIndex = jSONObject.getInt(str18);
                        } else {
                            mapObj.nIndex = 0;
                        }
                        if (jSONObject.has(str17)) {
                            com.baidu.platform.comapi.basestruct.Point pointComplexPtToPoint = CoordinateUtil.complexPtToPoint(jSONObject.getString(str17));
                            str4 = str17;
                            com.baidu.platform.comapi.basestruct.Point point = mapObj.geoPt;
                            if (pointComplexPtToPoint == null) {
                                str5 = str18;
                                str6 = str19;
                                intX = 0.0d;
                            } else {
                                str5 = str18;
                                str6 = str19;
                                intX = pointComplexPtToPoint.getIntX();
                            }
                            if (pointComplexPtToPoint == null) {
                                str2 = "";
                                str3 = str24;
                                intY = 0.0d;
                            } else {
                                str2 = "";
                                str3 = str24;
                                intY = pointComplexPtToPoint.getIntY();
                            }
                            point.setTo(intX, intY);
                        } else {
                            str2 = "";
                            str3 = str24;
                            str4 = str17;
                            str5 = str18;
                            str6 = str19;
                            if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_PTX) && jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_PTY)) {
                                str7 = str16;
                                mapObj.geoPt.setTo((int) jSONObject.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) jSONObject.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
                            }
                            if (jSONObject.has("ts")) {
                                mapObj.sltime = jSONObject.getInt("ts");
                            }
                            if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_OBJ)) {
                                mapObj.slobj = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                            }
                            if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                                mapObj.slvisi = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_SL_VISI);
                            }
                            mapObj.nType = i6;
                            if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                                mapObj.offset = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_OFFSET);
                            }
                            if (jSONObject.has(str7)) {
                                mapObj.ssName = jSONObject.getString(str7);
                            }
                            str8 = str26;
                            if (jSONObject.has(str8)) {
                                mapObj.ssIndoorId = jSONObject.getString(str8);
                            }
                            str9 = str3;
                            if (jSONObject.has(str9)) {
                                mapObj.ssPoiUid = jSONObject.getString(str9);
                            }
                            str10 = str25;
                            if (jSONObject.has(str10)) {
                                mapObj.offset = jSONObject.getInt(str10);
                            }
                            str11 = str23;
                            if (jSONObject.has(str11)) {
                                mapObj.geoPt.setIntX(jSONObject.getInt(str11));
                                mapObj.streetArrowCenterX = jSONObject.getDouble(str11);
                            }
                            str12 = str22;
                            if (jSONObject.has(str12)) {
                                mapObj.geoPt.setIntY(jSONObject.getInt(str12));
                                mapObj.streetArrowCenterY = jSONObject.getDouble(str12);
                            }
                            str13 = str21;
                            if (jSONObject.has(str13)) {
                                mapObj.ssZ = jSONObject.getInt(str13);
                            }
                            if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION)) {
                                str26 = str8;
                                str14 = str7;
                            } else {
                                str26 = str8;
                                str14 = str7;
                                mapObj.ssRotation = jSONObject.getDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION);
                            }
                            if (jSONObject.has("pid")) {
                                mapObj.ssPanoId = jSONObject.getString("pid");
                            }
                            if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_DATA)) {
                                mapObj.ssData = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_SS_DATA);
                            }
                            if (!jSONObject.has("src")) {
                                mapObj.dynamicSrc = jSONObject.getInt("src");
                            } else {
                                mapObj.dynamicSrc = -1;
                            }
                            if (!jSONObject.has("ad")) {
                                mapObj.ad = jSONObject.getInt("ad");
                            } else {
                                mapObj.ad = -1;
                            }
                            if (!jSONObject.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE)) {
                                mapObj.adstyle = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_AD_STYLE);
                            } else {
                                mapObj.adstyle = -1;
                            }
                            if (!jSONObject.has(MapBundleKey.MapObjKey.OBJ_QID)) {
                                mapObj.qid = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_QID);
                                str15 = str2;
                            } else {
                                str15 = str2;
                                mapObj.qid = str15;
                            }
                            if (!jSONObject.has("puid")) {
                                mapObj.puid = jSONObject.getString("puid");
                            } else {
                                mapObj.puid = str15;
                            }
                            if (!jSONObject.has(MapBundleKey.MapObjKey.AD_LOG)) {
                                mapObj.adLog = jSONObject.getString(MapBundleKey.MapObjKey.AD_LOG);
                            } else {
                                mapObj.adLog = str15;
                            }
                            if (!jSONObject.has("url")) {
                                mapObj.url = jSONObject.getString("url");
                            } else {
                                mapObj.url = str15;
                            }
                            if (!jSONObject.has("level")) {
                                mapObj.level = jSONObject.getInt("level");
                            } else {
                                mapObj.level = -1;
                            }
                            arrayList2 = arrayList;
                            arrayList2.add(mapObj);
                            str24 = str9;
                            str25 = str10;
                            str23 = str11;
                            str22 = str12;
                            str16 = str14;
                            str20 = str;
                            str17 = str4;
                            str19 = str6;
                            jSONArray2 = jSONArray;
                            arrayList3 = arrayList2;
                            str21 = str13;
                            str18 = str5;
                            i5 = i3 + 1;
                        }
                        str7 = str16;
                        if (jSONObject.has("ts")) {
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_OBJ)) {
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                        }
                        mapObj.nType = i6;
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                        }
                        if (jSONObject.has(str7)) {
                        }
                        str8 = str26;
                        if (jSONObject.has(str8)) {
                        }
                        str9 = str3;
                        if (jSONObject.has(str9)) {
                        }
                        str10 = str25;
                        if (jSONObject.has(str10)) {
                        }
                        str11 = str23;
                        if (jSONObject.has(str11)) {
                        }
                        str12 = str22;
                        if (jSONObject.has(str12)) {
                        }
                        str13 = str21;
                        if (jSONObject.has(str13)) {
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION)) {
                        }
                        if (jSONObject.has("pid")) {
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_DATA)) {
                        }
                        if (!jSONObject.has("src")) {
                        }
                        if (!jSONObject.has("ad")) {
                        }
                        if (!jSONObject.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE)) {
                        }
                        if (!jSONObject.has(MapBundleKey.MapObjKey.OBJ_QID)) {
                        }
                        if (!jSONObject.has("puid")) {
                        }
                        if (!jSONObject.has(MapBundleKey.MapObjKey.AD_LOG)) {
                        }
                        if (!jSONObject.has("url")) {
                        }
                        if (!jSONObject.has("level")) {
                        }
                        arrayList2 = arrayList;
                        arrayList2.add(mapObj);
                        str24 = str9;
                        str25 = str10;
                        str23 = str11;
                        str22 = str12;
                        str16 = str14;
                        str20 = str;
                        str17 = str4;
                        str19 = str6;
                        jSONArray2 = jSONArray;
                        arrayList3 = arrayList2;
                        str21 = str13;
                        str18 = str5;
                        i5 = i3 + 1;
                    }
                }
                str14 = str16;
                str11 = str23;
                str24 = str9;
                str25 = str10;
                str23 = str11;
                str22 = str12;
                str16 = str14;
                str20 = str;
                str17 = str4;
                str19 = str6;
                jSONArray2 = jSONArray;
                arrayList3 = arrayList2;
                str21 = str13;
                str18 = str5;
                i5 = i3 + 1;
            }
            getMapViewListener().onClickedParticleEventMapObj(arrayList3);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private void c() {
        this.G = false;
        this.M = 0.0f;
        this.K = -1.0f;
        this.L = -1.0f;
    }

    public void d(int i, int i2) {
        if (a()) {
            this.v.MoveToScrPoint(i, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x018f A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0270 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0281 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0291 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02a1 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02b1 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c1 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02d1 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02e5 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02f5 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0305 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0313 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0321 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0331 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0341 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x035c A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0377 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0387 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0397 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03a7 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03b7 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03c2 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03cd A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03d6 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03e1 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03ea A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03f5 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03fe A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0408 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0411 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x041b A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0424 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x042f A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0438 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0443 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0453 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x045c A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0466 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x046f A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0479 A[Catch: JSONException -> 0x0768, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x048d A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0497 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x04a2 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04ab A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x04b5 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04be A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x04c8 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04d4 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0759 A[Catch: JSONException -> 0x0768, TryCatch #0 {JSONException -> 0x0768, blocks: (B:29:0x0067, B:32:0x0079, B:34:0x007f, B:36:0x0093, B:37:0x009b, B:39:0x00a3, B:40:0x00ab, B:42:0x00b1, B:43:0x00b7, B:45:0x00c0, B:47:0x00c8, B:49:0x00ec, B:98:0x0189, B:100:0x018f, B:376:0x065f, B:103:0x01ae, B:105:0x01bb, B:107:0x01cc, B:110:0x01d4, B:112:0x01dd, B:114:0x01eb, B:119:0x0206, B:121:0x020e, B:128:0x0234, B:135:0x0268, B:137:0x0270, B:138:0x0279, B:140:0x0281, B:141:0x0289, B:143:0x0291, B:144:0x0299, B:146:0x02a1, B:147:0x02a9, B:149:0x02b1, B:150:0x02b9, B:152:0x02c1, B:153:0x02c9, B:155:0x02d1, B:156:0x02d9, B:158:0x02e5, B:159:0x02ed, B:161:0x02f5, B:162:0x02fd, B:164:0x0305, B:165:0x030d, B:167:0x0313, B:168:0x0319, B:170:0x0321, B:171:0x0329, B:173:0x0331, B:174:0x0339, B:176:0x0341, B:177:0x0354, B:179:0x035c, B:180:0x036f, B:182:0x0377, B:183:0x037f, B:185:0x0387, B:186:0x038f, B:188:0x0397, B:189:0x039f, B:191:0x03a7, B:192:0x03af, B:194:0x03b7, B:196:0x03c5, B:198:0x03cd, B:200:0x03d9, B:202:0x03e1, B:204:0x03ed, B:206:0x03f5, B:208:0x0400, B:210:0x0408, B:212:0x0413, B:214:0x041b, B:216:0x0427, B:218:0x042f, B:220:0x043b, B:222:0x0443, B:223:0x044b, B:225:0x0453, B:227:0x045e, B:229:0x0466, B:231:0x0471, B:233:0x0479, B:237:0x0485, B:239:0x048d, B:241:0x049a, B:243:0x04a2, B:245:0x04ad, B:247:0x04b5, B:249:0x04c0, B:251:0x04c8, B:254:0x04d4, B:256:0x04f5, B:375:0x065c, B:298:0x0555, B:304:0x0567, B:317:0x0587, B:319:0x058d, B:414:0x06c7, B:416:0x06cc, B:418:0x06d2, B:419:0x06db, B:421:0x06e1, B:422:0x06ea, B:424:0x06f0, B:425:0x06f9, B:427:0x06ff, B:428:0x0707, B:430:0x070d, B:431:0x0715, B:433:0x071b, B:434:0x0723, B:438:0x072d, B:439:0x0735, B:440:0x073d, B:442:0x0743, B:443:0x074b, B:445:0x0751, B:446:0x0759, B:448:0x075f, B:324:0x059e, B:326:0x05a4, B:331:0x05b4, B:332:0x05b7, B:334:0x05bd, B:337:0x05cb, B:339:0x05d1, B:344:0x05e2, B:347:0x05ed, B:349:0x05f3, B:363:0x0620, B:364:0x0624, B:366:0x062a, B:367:0x0632, B:371:0x064a, B:248:0x04be, B:244:0x04ab, B:240:0x0497, B:230:0x046f, B:226:0x045c, B:219:0x0438, B:215:0x0424, B:211:0x0411, B:207:0x03fe, B:203:0x03ea, B:199:0x03d6, B:195:0x03c2, B:127:0x022f, B:124:0x0223, B:129:0x0238, B:131:0x0242, B:133:0x024a, B:115:0x01f2, B:117:0x01fa, B:118:0x0203, B:111:0x01db, B:106:0x01c7, B:79:0x012a, B:82:0x013b, B:85:0x014e, B:88:0x0158, B:90:0x016b, B:92:0x0176), top: B:454:0x0067 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i, int i2) {
        int intY;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        int i3;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        ArrayList arrayList11;
        int i4;
        MapObj mapObj;
        MapObj mapObj2;
        JSONArray jSONArray;
        ArrayList arrayList12;
        ArrayList arrayList13;
        ArrayList arrayList14;
        double intX;
        JSONObject jSONObject;
        NaviMapViewListener naviMapViewListener;
        NaviMapViewListener naviMapViewListener2;
        if (!a()) {
            return false;
        }
        if (getMapViewListener() == null && this.e0 == null) {
            return false;
        }
        int zoomUnitsInMeter = (int) (((double) this.nearlyRadius) * getZoomUnitsInMeter());
        int intX2 = i;
        com.baidu.platform.comapi.basestruct.Point pointOnTapInterception = (!isNaviMode() || (naviMapViewListener2 = this.e0) == null) ? null : naviMapViewListener2.onTapInterception(new com.baidu.platform.comapi.basestruct.Point(intX2, i2));
        if (pointOnTapInterception != null) {
            intX2 = pointOnTapInterception.getIntX();
            intY = pointOnTapInterception.getIntY();
        } else {
            intY = i2;
        }
        String strGetNearlyObjID = this.v.GetNearlyObjID(-1L, intX2, intY, zoomUnitsInMeter);
        if (strGetNearlyObjID == null) {
            return false;
        }
        if (isNaviMode() && (naviMapViewListener = this.e0) != null && naviMapViewListener.onItemClick(strGetNearlyObjID, intX2, intY)) {
            return true;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(strGetNearlyObjID);
            ArrayList arrayList15 = new ArrayList();
            if (jSONObject2.has(MapBundleKey.MapObjKey.OBJ_MCAR) && (jSONObject = jSONObject2.getJSONObject(MapBundleKey.MapObjKey.OBJ_MCAR)) != null) {
                ArrayList arrayList16 = new ArrayList();
                MapObj mapObj3 = new MapObj();
                mapObj3.routeType = MapBundleKey.MapObjKey.OBJ_MCAR;
                if (jSONObject.has("id")) {
                    mapObj3.routeId = jSONObject.getInt("id");
                }
                if (jSONObject.has("status")) {
                    mapObj3.status = jSONObject.getInt("status");
                }
                if (jSONObject.has("in")) {
                    mapObj3.index = jSONObject.getInt("in");
                }
                arrayList16.add(mapObj3);
                if (getMapViewListener() != null) {
                    getMapViewListener().onClickedRouteObj(arrayList16);
                }
                return true;
            }
            JSONArray jSONArray2 = jSONObject2.getJSONArray("dataset");
            int i5 = ((JSONObject) jSONArray2.get(0)).getInt(MapBundleKey.MapObjKey.OBJ_TYPE);
            if (i5 == 22) {
                arrayList2 = new ArrayList();
            } else {
                if (i5 != 3 && i5 != 13 && i5 != 14 && i5 != 16 && i5 != 15 && i5 != 4 && i5 != 103 && i5 != 25 && i5 != 31 && i5 != 104 && i5 != 5000 && i5 != 6018 && i5 != 6019) {
                    if (i5 == 8 || i5 == 1 || i5 == 2) {
                        arrayList3 = new ArrayList();
                    } else {
                        if (i5 == 6) {
                            arrayList6 = new ArrayList();
                            arrayList2 = null;
                            arrayList = null;
                            arrayList4 = null;
                            arrayList7 = null;
                            arrayList5 = null;
                            i3 = 0;
                            int i6 = -1;
                            while (i3 < jSONArray2.length()) {
                                JSONObject jSONObject3 = (JSONObject) jSONArray2.get(i3);
                                int i7 = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_TYPE);
                                if (i7 == 26) {
                                    jSONArray = jSONArray2;
                                    arrayList14 = arrayList;
                                    arrayList9 = arrayList4;
                                    arrayList10 = arrayList6;
                                    arrayList12 = arrayList7;
                                    arrayList13 = arrayList5;
                                } else {
                                    MapObj mapObj4 = new MapObj();
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_LAYER_ID)) {
                                        i4 = i7;
                                        mapObj4.layer_id = (int) jSONObject3.getLong(MapBundleKey.MapObjKey.OBJ_LAYER_ID);
                                    } else {
                                        i4 = i7;
                                        mapObj4.layer_id = 0;
                                    }
                                    if (jSONObject3.has("ud")) {
                                        mapObj4.strUid = jSONObject3.getString("ud");
                                    } else {
                                        mapObj4.strUid = "";
                                    }
                                    mapObj4.strText = jSONObject3.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
                                    if (jSONObject3.has("in")) {
                                        mapObj4.nIndex = jSONObject3.getInt("in");
                                    } else if (jSONObject3.has("index")) {
                                        mapObj4.nIndex = jSONObject3.getInt("index");
                                    } else {
                                        mapObj4.nIndex = 0;
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_GEO)) {
                                        com.baidu.platform.comapi.basestruct.Point pointComplexPtToPoint = CoordinateUtil.complexPtToPoint(jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_GEO));
                                        com.baidu.platform.comapi.basestruct.Point point = mapObj4.geoPt;
                                        if (pointComplexPtToPoint == null) {
                                            mapObj = mapObj4;
                                            intX = 0.0d;
                                        } else {
                                            mapObj = mapObj4;
                                            intX = pointComplexPtToPoint.getIntX();
                                        }
                                        point.setTo(intX, pointComplexPtToPoint == null ? 0.0d : pointComplexPtToPoint.getIntY());
                                    } else {
                                        mapObj = mapObj4;
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_PTX) && jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_PTY)) {
                                            mapObj2 = mapObj;
                                            jSONArray = jSONArray2;
                                            mapObj2.geoPt.setTo((int) jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_GEO_Z)) {
                                            mapObj2.geoZ = (float) jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_GEO_Z);
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_INDOOR_POI)) {
                                            mapObj2.indoorpoi = jSONObject3.getBoolean(MapBundleKey.MapObjKey.OBJ_INDOOR_POI);
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE)) {
                                            mapObj2.poiOnlineType = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE);
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_BID)) {
                                            mapObj2.bid = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_BID);
                                        }
                                        if (jSONObject3.has("ts")) {
                                            mapObj2.sltime = jSONObject3.getInt("ts");
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_OBJ)) {
                                            mapObj2.slobj = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                                            mapObj2.slvisi = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_SL_VISI);
                                        }
                                        mapObj2.nType = i4;
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                                            mapObj2.offset = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_OFFSET);
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_POINAME)) {
                                            mapObj2.ssName = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_SS_POINAME);
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID)) {
                                            mapObj2.ssIndoorId = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID);
                                        }
                                        if (jSONObject3.has("ud")) {
                                            mapObj2.ssPoiUid = jSONObject3.getString("ud");
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.STREET_TYPE)) {
                                            mapObj2.ssType = jSONObject3.getString(MapBundleKey.MapObjKey.STREET_TYPE);
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DIS)) {
                                            mapObj2.offset = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_DIS);
                                        }
                                        if (jSONObject3.has("x")) {
                                            mapObj2.geoPt.setIntX(jSONObject3.getInt("x"));
                                            mapObj2.streetArrowCenterX = jSONObject3.getDouble("x");
                                        }
                                        if (jSONObject3.has("y")) {
                                            mapObj2.geoPt.setIntY(jSONObject3.getInt("y"));
                                            mapObj2.streetArrowCenterY = jSONObject3.getDouble("y");
                                        }
                                        if (jSONObject3.has("z")) {
                                            mapObj2.ssZ = jSONObject3.getInt("z");
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION)) {
                                            mapObj2.ssRotation = jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION);
                                        }
                                        if (jSONObject3.has("pid")) {
                                            mapObj2.ssPanoId = jSONObject3.getString("pid");
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_DATA)) {
                                            mapObj2.ssData = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_SS_DATA);
                                        }
                                        if (!jSONObject3.has("src")) {
                                            int i8 = jSONObject3.getInt("src");
                                            mapObj2.dynamicSrc = i8;
                                            i6 = i8;
                                        } else {
                                            mapObj2.dynamicSrc = -1;
                                        }
                                        if (!jSONObject3.has("ad")) {
                                            mapObj2.ad = jSONObject3.getInt("ad");
                                        } else {
                                            mapObj2.ad = -1;
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE)) {
                                            mapObj2.adstyle = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_AD_STYLE);
                                        } else {
                                            mapObj2.adstyle = -1;
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_QID)) {
                                            mapObj2.qid = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_QID);
                                        } else {
                                            mapObj2.qid = "";
                                        }
                                        if (!jSONObject3.has("puid")) {
                                            mapObj2.puid = jSONObject3.getString("puid");
                                        } else {
                                            mapObj2.puid = "";
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_SRC)) {
                                            mapObj2.dysrc = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_DY_SRC);
                                        } else {
                                            mapObj2.dysrc = -1;
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_STGE)) {
                                            mapObj2.dystge = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_DY_STGE);
                                        } else {
                                            mapObj2.dystge = -1;
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_ISAGG)) {
                                            mapObj2.isAgg = jSONObject3.getBoolean(MapBundleKey.MapObjKey.OBJ_DY_ISAGG);
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.AD_LOG)) {
                                            mapObj2.adLog = jSONObject3.getString(MapBundleKey.MapObjKey.AD_LOG);
                                        } else {
                                            mapObj2.adLog = "";
                                        }
                                        if (!jSONObject3.has("url")) {
                                            mapObj2.url = jSONObject3.getString("url");
                                        } else {
                                            mapObj2.url = "";
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_STYLE_ID)) {
                                            mapObj2.style_id = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_STYLE_ID);
                                        } else {
                                            try {
                                                mapObj2.style_id = 0;
                                            } catch (JSONException unused) {
                                                return false;
                                            }
                                        }
                                        if (!jSONObject3.has("level")) {
                                            mapObj2.level = jSONObject3.getInt("level");
                                        } else {
                                            mapObj2.level = -1;
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.CLICK_ACTION)) {
                                            mapObj2.clickAction = jSONObject3.getString(MapBundleKey.MapObjKey.CLICK_ACTION);
                                        } else {
                                            mapObj2.clickAction = "";
                                        }
                                        if (!jSONObject3.has(MapBundleKey.MapObjKey.EX_JSON)) {
                                            mapObj2.exJson = jSONObject3.getString(MapBundleKey.MapObjKey.EX_JSON);
                                        } else {
                                            mapObj2.exJson = "";
                                        }
                                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE)) {
                                            mapObj2.statisticValue = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE);
                                        }
                                        if (i5 != 22) {
                                            ItsMapObj itsMapObj = new ItsMapObj();
                                            itsMapObj.baseMapObj = mapObj2;
                                            itsMapObj.tTrafficStart = jSONObject3.getLong(MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_START);
                                            itsMapObj.tTrafficEnd = jSONObject3.getLong(MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_END);
                                            itsMapObj.strTrafficDetail = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_DETAIL);
                                            if (arrayList2 != null) {
                                                arrayList2.add(itsMapObj);
                                            }
                                            arrayList14 = arrayList;
                                            arrayList9 = arrayList4;
                                            arrayList10 = arrayList6;
                                        } else {
                                            if (i5 == 3 || i5 == 13 || i5 == 14 || i5 == 16 || i5 == 15 || i5 == 4 || i5 == 103 || i5 == 25 || i5 == 31 || i5 == 104 || i5 == 5000 || i5 == 6018) {
                                                arrayList9 = arrayList4;
                                                arrayList10 = arrayList6;
                                                arrayList12 = arrayList7;
                                                arrayList13 = arrayList5;
                                                arrayList14 = arrayList;
                                            } else if (i5 == 6019) {
                                                arrayList14 = arrayList;
                                                arrayList9 = arrayList4;
                                                arrayList10 = arrayList6;
                                                arrayList12 = arrayList7;
                                                arrayList13 = arrayList5;
                                            } else {
                                                if (i5 == 8 || i5 == 1 || i5 == 2) {
                                                    arrayList9 = arrayList4;
                                                    arrayList10 = arrayList6;
                                                    arrayList12 = arrayList7;
                                                    arrayList13 = arrayList5;
                                                    if (arrayList9 != null) {
                                                        arrayList9.add(mapObj2);
                                                    }
                                                } else if (i5 != 6) {
                                                    arrayList10 = arrayList6;
                                                    if (i5 != 24) {
                                                        arrayList12 = arrayList7;
                                                        if (i5 == 1234 || i5 == 1236 || i5 == 2000 || i5 == 2001) {
                                                            arrayList9 = arrayList4;
                                                            arrayList11 = arrayList5;
                                                            getMapViewListener().onClickedStreetIndoorPoi(mapObj2);
                                                        } else {
                                                            if (i5 == 1235) {
                                                                if (getMapViewListener() != null) {
                                                                    getMapViewListener().onClickStreetArrow(mapObj2);
                                                                }
                                                            } else if (i5 != 2002) {
                                                                if (i5 == 1239) {
                                                                    arrayList9 = arrayList4;
                                                                    if (arrayList9 != null) {
                                                                        arrayList9.add(mapObj2);
                                                                    }
                                                                    if (getMapViewListener() != null) {
                                                                        getMapViewListener().onClickedRouteLabelObj(arrayList9);
                                                                    }
                                                                } else {
                                                                    arrayList9 = arrayList4;
                                                                    if (i5 == 6000) {
                                                                        if (getMapViewListener() != null) {
                                                                            getMapViewListener().onClickedTrafficUgcEventMapObj(mapObj2, true);
                                                                        }
                                                                    } else if (i5 == 7000) {
                                                                        arrayList13 = arrayList5;
                                                                        if (arrayList13 != null) {
                                                                            arrayList13.add(mapObj2);
                                                                        }
                                                                    } else {
                                                                        arrayList13 = arrayList5;
                                                                        if (i5 == 6002) {
                                                                            if (getMapViewListener() != null) {
                                                                                getMapViewListener().onClickedTrafficUgcEventMapObj(mapObj2, jSONObject3.optBoolean("bchecked"));
                                                                            }
                                                                        } else if (i5 != 90909 && i5 != 90910 && i5 != 90914 && i5 != 90912 && i5 != 90915 && i5 != 90916) {
                                                                            arrayList15.add(mapObj2);
                                                                        } else if (getMapViewListener() != null) {
                                                                            getMapViewListener().onClickSdkMapObj(i5, jSONObject3);
                                                                        }
                                                                    }
                                                                }
                                                                arrayList11 = arrayList5;
                                                            } else if (getMapViewListener() != null) {
                                                                getMapViewListener().onClickStreetSurface(mapObj2);
                                                            }
                                                            arrayList9 = arrayList4;
                                                            arrayList11 = arrayList5;
                                                        }
                                                        arrayList8 = arrayList;
                                                        break;
                                                    }
                                                    arrayList12 = arrayList7;
                                                    if (arrayList12 != null) {
                                                        arrayList12.add(mapObj2);
                                                    }
                                                    arrayList14 = arrayList;
                                                    arrayList9 = arrayList4;
                                                    arrayList13 = arrayList5;
                                                } else {
                                                    arrayList10 = arrayList6;
                                                    if (arrayList10 != null) {
                                                        arrayList10.add(mapObj2);
                                                    }
                                                    arrayList14 = arrayList;
                                                    arrayList9 = arrayList4;
                                                }
                                                arrayList14 = arrayList;
                                            }
                                            if (arrayList14 != null) {
                                                arrayList14.add(mapObj2);
                                            }
                                        }
                                        arrayList12 = arrayList7;
                                        arrayList13 = arrayList5;
                                    }
                                    mapObj2 = mapObj;
                                    jSONArray = jSONArray2;
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_GEO_Z)) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_INDOOR_POI)) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE)) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_BID)) {
                                    }
                                    if (jSONObject3.has("ts")) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_OBJ)) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                                    }
                                    mapObj2.nType = i4;
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_POINAME)) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID)) {
                                    }
                                    if (jSONObject3.has("ud")) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.STREET_TYPE)) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DIS)) {
                                    }
                                    if (jSONObject3.has("x")) {
                                    }
                                    if (jSONObject3.has("y")) {
                                    }
                                    if (jSONObject3.has("z")) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION)) {
                                    }
                                    if (jSONObject3.has("pid")) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_DATA)) {
                                    }
                                    if (!jSONObject3.has("src")) {
                                    }
                                    if (!jSONObject3.has("ad")) {
                                    }
                                    if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE)) {
                                    }
                                    if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_QID)) {
                                    }
                                    if (!jSONObject3.has("puid")) {
                                    }
                                    if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_SRC)) {
                                    }
                                    if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_STGE)) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_ISAGG)) {
                                    }
                                    if (!jSONObject3.has(MapBundleKey.MapObjKey.AD_LOG)) {
                                    }
                                    if (!jSONObject3.has("url")) {
                                    }
                                    if (!jSONObject3.has(MapBundleKey.MapObjKey.OBJ_STYLE_ID)) {
                                    }
                                    if (!jSONObject3.has("level")) {
                                    }
                                    if (!jSONObject3.has(MapBundleKey.MapObjKey.CLICK_ACTION)) {
                                    }
                                    if (!jSONObject3.has(MapBundleKey.MapObjKey.EX_JSON)) {
                                    }
                                    if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE)) {
                                    }
                                    if (i5 != 22) {
                                    }
                                    arrayList12 = arrayList7;
                                    arrayList13 = arrayList5;
                                }
                                i3++;
                                arrayList6 = arrayList10;
                                arrayList7 = arrayList12;
                                arrayList4 = arrayList9;
                                arrayList5 = arrayList13;
                                arrayList = arrayList14;
                                jSONArray2 = jSONArray;
                            }
                            arrayList8 = arrayList;
                            arrayList9 = arrayList4;
                            arrayList10 = arrayList6;
                            arrayList11 = arrayList5;
                            int i9 = i6;
                            if (i5 == 6) {
                                if (i5 != 8) {
                                    if (i5 != 25 && i5 != 31) {
                                        if (i5 == 5000) {
                                            if (getMapViewListener() == null) {
                                                return true;
                                            }
                                            if (i9 == 27) {
                                                getMapViewListener().onClickPolymericMapObj(arrayList8);
                                                return true;
                                            }
                                            getMapViewListener().onClickedPoiObj(arrayList8);
                                            return true;
                                        }
                                        if (i5 == 7000) {
                                            if (getMapViewListener() == null) {
                                                return true;
                                            }
                                            getMapViewListener().onClickedParticleEventMapObj(arrayList11);
                                            return true;
                                        }
                                        if (i5 == 22) {
                                            if (getMapViewListener() == null) {
                                                return true;
                                            }
                                            getMapViewListener().onClickedItsMapObj(arrayList2);
                                            return true;
                                        }
                                        if (i5 == 23) {
                                            if (getMapViewListener() == null) {
                                                return true;
                                            }
                                            getMapViewListener().onClickedMapObj(arrayList15);
                                            return true;
                                        }
                                        if (i5 != 103 && i5 != 104) {
                                            if (i5 != 6018 && i5 != 6019) {
                                                if (i5 != 6060 && i5 != 6061) {
                                                    if (i5 != 1 && i5 != 2) {
                                                        if (i5 != 3 && i5 != 4) {
                                                            switch (i5) {
                                                                case 20:
                                                                    if (getMapViewListener() != null) {
                                                                        getMapViewListener().onClickedStreetPopup(strGetNearlyObjID);
                                                                    }
                                                                    break;
                                                            }
                                                            return false;
                                                        }
                                                    }
                                                }
                                                if (getMapViewListener() == null) {
                                                    return true;
                                                }
                                                getMapViewListener().onClickedMapObj(arrayList15);
                                                return true;
                                            }
                                            if (getMapViewListener() == null) {
                                                return true;
                                            }
                                            getMapViewListener().onClickedUniversalLayerPoiEventMapObj(arrayList8);
                                            return true;
                                        }
                                    }
                                    if (getMapViewListener() == null) {
                                        return true;
                                    }
                                    getMapViewListener().onClickedPoiObj(arrayList8);
                                    return true;
                                }
                                if (getMapViewListener() == null) {
                                    return true;
                                }
                                getMapViewListener().onClickedRouteObj(arrayList9);
                                return true;
                            }
                            if (getMapViewListener() == null) {
                                return true;
                            }
                            getMapViewListener().onClickedMapObj(arrayList10);
                            return true;
                        }
                        if (i5 == 24) {
                            arrayList7 = new ArrayList();
                            arrayList2 = null;
                            arrayList = null;
                            arrayList4 = null;
                            arrayList6 = null;
                            arrayList5 = null;
                            i3 = 0;
                            int i62 = -1;
                            while (i3 < jSONArray2.length()) {
                            }
                            arrayList8 = arrayList;
                            arrayList9 = arrayList4;
                            arrayList10 = arrayList6;
                            arrayList11 = arrayList5;
                            int i92 = i62;
                            if (i5 == 6) {
                            }
                        } else if (i5 == 1239) {
                            arrayList3 = new ArrayList();
                        } else if (i5 == 7000) {
                            arrayList5 = new ArrayList();
                            arrayList2 = null;
                            arrayList = null;
                            arrayList4 = null;
                            arrayList6 = null;
                            arrayList7 = null;
                            i3 = 0;
                            int i622 = -1;
                            while (i3 < jSONArray2.length()) {
                            }
                            arrayList8 = arrayList;
                            arrayList9 = arrayList4;
                            arrayList10 = arrayList6;
                            arrayList11 = arrayList5;
                            int i922 = i622;
                            if (i5 == 6) {
                            }
                        } else {
                            arrayList2 = null;
                        }
                    }
                    arrayList4 = arrayList3;
                    arrayList2 = null;
                    arrayList = null;
                    arrayList6 = null;
                    arrayList7 = null;
                    arrayList5 = null;
                    i3 = 0;
                    int i6222 = -1;
                    while (i3 < jSONArray2.length()) {
                    }
                    arrayList8 = arrayList;
                    arrayList9 = arrayList4;
                    arrayList10 = arrayList6;
                    arrayList11 = arrayList5;
                    int i9222 = i6222;
                    if (i5 == 6) {
                    }
                }
                arrayList = new ArrayList();
                arrayList2 = null;
                arrayList4 = null;
                arrayList6 = null;
                arrayList7 = null;
                arrayList5 = null;
                i3 = 0;
                int i62222 = -1;
                while (i3 < jSONArray2.length()) {
                }
                arrayList8 = arrayList;
                arrayList9 = arrayList4;
                arrayList10 = arrayList6;
                arrayList11 = arrayList5;
                int i92222 = i62222;
                if (i5 == 6) {
                }
            }
            arrayList = null;
            arrayList4 = null;
            arrayList6 = null;
            arrayList7 = null;
            arrayList5 = null;
            i3 = 0;
            int i622222 = -1;
            while (i3 < jSONArray2.length()) {
            }
            arrayList8 = arrayList;
            arrayList9 = arrayList4;
            arrayList10 = arrayList6;
            arrayList11 = arrayList5;
            int i922222 = i622222;
            if (i5 == 6) {
            }
        }
    }

    private void d() {
        MessageProxy.unRegisterMessageHandler(4000, this.x);
        MessageProxy.unRegisterMessageHandler(519, this.x);
        MessageProxy.unRegisterMessageHandler(39, this.x);
        MessageProxy.unRegisterMessageHandler(512, this.x);
        MessageProxy.unRegisterMessageHandler(65297, this.x);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, this.x);
        MessageProxy.unRegisterMessageHandler(50, this.x);
        MessageProxy.unRegisterMessageHandler(51, this.x);
        MessageProxy.unRegisterMessageHandler(65301, this.x);
        MessageProxy.unRegisterMessageHandler(41, this.x);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.MSG_MAP_DATA_NET_RESPONSE, this.x);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_PRISM_FLOOR_ANIMATE_STOP, this.x);
    }

    private boolean c(int i, int i2) {
        SoftReference<MapViewInterface> softReference;
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        if (!a() || (softReference = this.d0) == null || softReference.get() == null) {
            return false;
        }
        String strGetNearlyObjID = this.v.GetNearlyObjID(-1L, i, i2, this.nearlyRadius);
        if (strGetNearlyObjID != null && !strGetNearlyObjID.equals("")) {
            try {
                jSONObject = new JSONObject(strGetNearlyObjID);
                try {
                    jSONObject.put("px", i);
                    jSONObject.put("py", i2);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = null;
            }
            if (this.mListeners == null) {
                return false;
            }
            boolean z = false;
            for (int i3 = 0; i3 < this.mListeners.size(); i3++) {
                v vVar = this.mListeners.get(i3);
                if (jSONObject != null && vVar != null) {
                    vVar.b(jSONObject.toString());
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("dataset");
                    if (jSONArrayOptJSONArray != null && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) != null && jSONObjectOptJSONObject.optInt(MapBundleKey.MapObjKey.OBJ_TYPE) >= 90909) {
                        z = true;
                    }
                }
            }
            return z;
        }
        if (this.t || this.mListeners == null || getMapView() == null || getMapView().getProjection() == null) {
            return false;
        }
        GeoPoint geoPointFromPixels = getMapView().getProjection().fromPixels(i, i2);
        for (int i4 = 0; i4 < this.mListeners.size(); i4++) {
            v vVar2 = this.mListeners.get(i4);
            if (vVar2 != null) {
                vVar2.b(geoPointFromPixels);
            }
        }
        return false;
    }

    public void saveScreenToLocal(String str) {
        saveScreenToLocal(str, 0, 0, 0, 0);
    }

    public void setMapStatus(Bundle bundle) {
        if (a()) {
            this.v.SetMapStatus(bundle);
        }
    }

    public void setMapStatus(MapStatus mapStatus) {
        if (!a() || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt(Constant.MAP_KEY_TOP, mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putInt("animatime", mapStatus.animationTime);
        bundle.putInt("animation", mapStatus.hasAnimation);
        bundle.putInt("animationType", mapStatus.animationType);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        bundle.putFloat("adapterZoomUnits", mapStatus.adapterZoomUnits);
        mapStatusChangeStart();
        this.v.SetMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i) {
        if (!a() || this.v == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        if (!isCompass && !this.J) {
            if (this.q != null && this.s) {
                Projection projection = this.d0.get().getProjection();
                Point point = this.q;
                GeoPoint geoPointFromPixels = projection.fromPixels(point.x, point.y);
                bundle.putDouble("centerptx", geoPointFromPixels.getLongitudeE6());
                bundle.putDouble("centerpty", geoPointFromPixels.getLatitudeE6());
            } else {
                LatLng latLng = this.r;
                if (latLng != null && this.s) {
                    GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
                    bundle.putDouble("centerptx", geoPointLl2mc.getLongitudeE6());
                    bundle.putDouble("centerpty", geoPointLl2mc.getLatitudeE6());
                } else {
                    bundle.putDouble("centerptx", mapStatus.centerPtX);
                    bundle.putDouble("centerpty", mapStatus.centerPtY);
                }
            }
        } else {
            bundle.putDouble("centerptx", mapStatus.centerPtX);
            bundle.putDouble("centerpty", mapStatus.centerPtY);
        }
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt(Constant.MAP_KEY_TOP, mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", i);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        bundle.putFloat("adapterZoomUnits", mapStatus.adapterZoomUnits);
        mapStatusChangeStart();
        this.mIsAnimating = true;
        this.v.SetMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i, int i2) {
        if (!a() || this.v == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("animationType", i);
        bundle.putInt("animatime", i2);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt("right", mapStatus.winRound.right);
        bundle.putInt(Constant.MAP_KEY_TOP, mapStatus.winRound.top);
        bundle.putInt("bottom", mapStatus.winRound.bottom);
        if (i != 4) {
            bundle.putDouble("level", mapStatus.level);
            bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, mapStatus.rotation);
            bundle.putDouble("overlooking", mapStatus.overlooking);
            bundle.putDouble("centerptx", mapStatus.centerPtX);
            bundle.putDouble("centerpty", mapStatus.centerPtY);
            bundle.putDouble("centerptz", mapStatus.centerPtZ);
            bundle.putLong("gleft", mapStatus.geoRound.left);
            bundle.putLong("gright", mapStatus.geoRound.right);
            bundle.putLong("gbottom", mapStatus.geoRound.bottom);
            bundle.putLong("gtop", mapStatus.geoRound.top);
            bundle.putFloat("xoffset", mapStatus.xOffset);
            bundle.putFloat("yoffset", mapStatus.yOffset);
            bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
            bundle.putString("panoid", mapStatus.panoId);
            bundle.putInt("autolink", 0);
            bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
            bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
            bundle.putInt("ssext", mapStatus.streetExt);
            bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
            bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
            bundle.putFloat("adapterZoomUnits", mapStatus.adapterZoomUnits);
        }
        this.v.SetNewMapStatus(bundle);
    }

    private void b() {
        MessageProxy.registerMessageHandler(4000, this.x);
        MessageProxy.registerMessageHandler(519, this.x);
        MessageProxy.registerMessageHandler(39, this.x);
        MessageProxy.registerMessageHandler(512, this.x);
        MessageProxy.registerMessageHandler(65297, this.x);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, this.x);
        MessageProxy.registerMessageHandler(50, this.x);
        MessageProxy.registerMessageHandler(51, this.x);
        MessageProxy.registerMessageHandler(65301, this.x);
        MessageProxy.registerMessageHandler(41, this.x);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.MSG_MAP_DATA_NET_RESPONSE, this.x);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_PRISM_FLOOR_ANIMATE_STOP, this.x);
    }

    private void a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        c = x;
        d = y;
        MapMsgProc(4, 0, x | (y << 16));
        e = true;
        this.f0 = motionEvent.getDownTime();
    }

    private boolean a(int i, int i2, boolean z) {
        SoftReference<MapViewInterface> softReference = this.d0;
        if (softReference != null && softReference.get() != null) {
            int zoomUnitsInMeter = (int) (((double) this.nearlyRadius) * getZoomUnitsInMeter());
            MapViewInterface mapViewInterface = this.d0.get();
            for (int size = mapViewInterface.getBmlayers().size() - 1; size >= 0; size--) {
                if (mapViewInterface.getBmlayers().get(size).a(i, i2, zoomUnitsInMeter, z, this.V)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(int i, int i2, int i3) {
        int i4;
        long j;
        int i5;
        int iOptInt;
        int size;
        String strGetNearlyObjID;
        boolean z = false;
        if (!a()) {
            return false;
        }
        SoftReference<MapViewInterface> softReference = this.d0;
        if (softReference != null && softReference.get() != null) {
            MapViewInterface mapViewInterface = this.d0.get();
            long j2 = 0;
            try {
            } catch (JSONException unused) {
                i4 = -1;
            }
            for (size = mapViewInterface.getOverlays().size() - 1; size >= 0; size--) {
                Overlay overlay = mapViewInterface.getOverlays().get(size);
                if (overlay.mType == 27) {
                    j2 = overlay.mLayerID;
                    int zoomUnitsInMeter = (int) (((double) this.nearlyRadius) * getZoomUnitsInMeter());
                    AppBaseMap appBaseMap = this.v;
                    if (appBaseMap != null && (strGetNearlyObjID = appBaseMap.GetNearlyObjID(j2, i2, i3, zoomUnitsInMeter)) != null && !strGetNearlyObjID.equals("")) {
                        JSONObject jSONObject = (JSONObject) new JSONObject(strGetNearlyObjID).getJSONArray("dataset").get(0);
                        i4 = jSONObject.getInt("itemindex");
                        try {
                            iOptInt = jSONObject.optInt("clickindex", -1);
                            j = j2;
                            i5 = i4;
                            z = true;
                            break;
                        } catch (JSONException unused2) {
                            j = j2;
                            i5 = i4;
                            iOptInt = -1;
                        }
                    }
                    j = j2;
                    i5 = i4;
                    iOptInt = -1;
                }
            }
            j = j2;
            i5 = -1;
            iOptInt = -1;
            if (i == 1 && getMapViewListener() != null && getMapView() != null && getMapView().getProjection() != null) {
                GeoPoint geoPointFromPixels = mapViewInterface.getProjection().fromPixels(i2, i3);
                if (iOptInt != -1) {
                    getMapViewListener().onClickedItem(i5, iOptInt, geoPointFromPixels, j);
                } else {
                    getMapViewListener().onClickedItem(i5, geoPointFromPixels, j);
                }
            }
        }
        return z;
    }

    private MapStatus a(boolean z) {
        if (!a()) {
            return new MapStatus();
        }
        Bundle bundleGetMapStatus = this.v.GetMapStatus(z);
        if (bundleGetMapStatus == null) {
            return new MapStatus();
        }
        MapStatus mapStatus = new MapStatus();
        mapStatus.level = (float) bundleGetMapStatus.getDouble("level");
        mapStatus.rotation = (int) bundleGetMapStatus.getDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION);
        mapStatus.overlooking = (int) bundleGetMapStatus.getDouble("overlooking");
        mapStatus.centerPtX = bundleGetMapStatus.getDouble("centerptx");
        mapStatus.centerPtY = bundleGetMapStatus.getDouble("centerpty");
        mapStatus.centerPtZ = bundleGetMapStatus.getDouble("centerptz");
        mapStatus.winRound.left = bundleGetMapStatus.getInt("left");
        mapStatus.winRound.right = bundleGetMapStatus.getInt("right");
        mapStatus.winRound.top = bundleGetMapStatus.getInt(Constant.MAP_KEY_TOP);
        mapStatus.winRound.bottom = bundleGetMapStatus.getInt("bottom");
        mapStatus.geoRound.left = bundleGetMapStatus.getLong("gleft");
        mapStatus.geoRound.right = bundleGetMapStatus.getLong("gright");
        mapStatus.geoRound.top = bundleGetMapStatus.getLong("gtop");
        mapStatus.geoRound.bottom = bundleGetMapStatus.getLong("gbottom");
        mapStatus.xOffset = bundleGetMapStatus.getFloat("xoffset");
        mapStatus.yOffset = bundleGetMapStatus.getFloat("yoffset");
        mapStatus.bfpp = bundleGetMapStatus.getInt("bfpp") == 1;
        mapStatus.panoId = bundleGetMapStatus.getString("panoid");
        mapStatus.streetIndicateAngle = bundleGetMapStatus.getFloat("siangle");
        mapStatus.isBirdEye = bundleGetMapStatus.getInt("isbirdeye") == 1;
        mapStatus.streetExt = bundleGetMapStatus.getInt("ssext");
        mapStatus.roadOffsetX = bundleGetMapStatus.getFloat("roadOffsetX");
        mapStatus.roadOffsetY = bundleGetMapStatus.getFloat("roadOffsetY");
        mapStatus.bOverlookSpringback = bundleGetMapStatus.getInt("boverlookback") == 1;
        mapStatus.minOverlooking = (int) bundleGetMapStatus.getFloat("minoverlook");
        mapStatus.xScreenOffset = bundleGetMapStatus.getFloat("xScreenOffset");
        mapStatus.yScreenOffset = bundleGetMapStatus.getFloat("yScreenOffset");
        mapStatus.adapterZoomUnits = bundleGetMapStatus.getFloat("adapterZoomUnits");
        MapStatus.GeoBound geoBound = mapStatus.geoRound;
        if (geoBound.left <= -20037508) {
            geoBound.left = -20037508L;
        }
        if (geoBound.right >= 20037508) {
            geoBound.right = 20037508L;
        }
        if (geoBound.top >= 20037508) {
            geoBound.top = 20037508L;
        }
        if (geoBound.bottom <= -20037508) {
            geoBound.bottom = -20037508L;
        }
        return mapStatus;
    }
}
