package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.map.EncodePointType;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapLanguage;
import com.baidu.mapapi.map.MapLayer;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.ParticleEffectType;
import com.baidu.mapapi.map.PoiTagType;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"NewApi"})
public class b implements MapSDKLayerDataInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f3974a = 1096.0f;
    private static int b;
    private static int c;
    private BmLayer A;
    private com.baidu.mapsdkplatform.comapi.map.z.a B;
    private g D;
    private i E;
    private h F;
    private int G;
    private int H;
    private MapController S;
    private LocationOverlay T;
    private com.baidu.platform.comapi.map.c U;
    public Point W;
    public Point X;
    private boolean g;
    private boolean h;
    private x t;
    private w u;
    AppBaseMap w;
    private List<com.baidu.mapsdkplatform.comapi.map.a> x;
    private HashMap<MapLayer, com.baidu.mapsdkplatform.comapi.map.a> y;
    private v z;
    public float d = 22.0f;
    public float e = 4.0f;
    public float f = 22.0f;
    private boolean i = true;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = true;
    boolean o = true;
    boolean p = true;
    boolean q = false;
    private boolean r = true;
    private boolean s = false;
    private boolean C = false;
    private boolean I = false;
    private boolean J = false;
    private long K = 0;
    private long L = 0;
    private boolean M = false;
    private Queue<C0086b> N = new LinkedList();
    public MapStatusUpdate O = null;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = false;
    private boolean V = false;
    private boolean Y = false;
    public List<com.baidu.platform.comapi.map.v> v = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3975a;

        static {
            int[] iArr = new int[MapLayer.values().length];
            f3975a = iArr;
            try {
                iArr[MapLayer.MAP_LAYER_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3975a[MapLayer.MAP_LAYER_OVERLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3975a[MapLayer.BM_LAYER_OVERLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3975a[MapLayer.MAP_LAYER_HEATMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3975a[MapLayer.MAP_LAYER_HEXAGONMAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3975a[MapLayer.MAP_LAYER_TRACE_OVERLAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.map.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0086b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bundle f3976a;

        public C0086b(Bundle bundle) {
            this.f3976a = bundle;
        }
    }

    public b(Context context, MapTextureView mapTextureView, q qVar, String str, int i) {
        MapController mapController = new MapController();
        this.S = mapController;
        mapController.initAppBaseMap();
        a(this.S);
        mapTextureView.attachBaseMapController(this.S);
        this.w = this.S.getBaseMap();
        I();
        a(qVar);
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.SetSDKLayerCallback(this);
        }
        this.S.onResume();
    }

    private void H() {
        try {
            b = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);
            c = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("x", b);
            jSONObject2.put("y", b);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("dataset", jSONArray);
            com.baidu.platform.comapi.map.c cVar = this.U;
            if (cVar != null) {
                cVar.setData(jSONObject.toString());
                this.U.UpdateOverlay();
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void I() {
        this.x = new CopyOnWriteArrayList();
        this.y = new HashMap<>();
        v vVar = new v();
        this.z = vVar;
        a(vVar);
        this.y.put(MapLayer.MAP_LAYER_OVERLAY, this.z);
        D(false);
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.setDEMEnable(false);
        }
    }

    private void T() {
        MapController mapController = this.S;
        if (mapController == null || mapController.mIsMoving) {
            return;
        }
        mapController.mIsMoving = true;
        mapController.mIsAnimating = false;
        if (this.v != null) {
            s sVarY = y();
            for (int i = 0; i < this.v.size(); i++) {
                com.baidu.platform.comapi.map.v vVar = this.v.get(i);
                if (vVar != null) {
                    vVar.c(sVarY);
                }
            }
        }
    }

    public float A() {
        MapController mapController = this.S;
        return mapController != null ? mapController.mMaxZoomLevel : this.d;
    }

    public void B(boolean z) {
        MapController mapController = this.S;
        if (mapController == null) {
            return;
        }
        mapController.setEnableZoom(z);
        this.p = z;
    }

    public void C(boolean z) {
        x xVar;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (xVar = this.t) == null) {
            return;
        }
        appBaseMap.ShowLayers(xVar.f3973a, z);
    }

    public void D(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        if (z) {
            this.d = 22.0f;
            this.f = 22.0f;
            MapController mapController = this.S;
            if (mapController != null) {
                mapController.mMaxZoomLevel = 22.0f;
            }
        } else {
            this.d = 22.0f;
            this.f = 22.0f;
            MapController mapController2 = this.S;
            if (mapController2 != null) {
                mapController2.mMaxZoomLevel = 22.0f;
            }
        }
        appBaseMap.ShowBaseIndoorMap(z);
    }

    public void E(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("poiindoormarklayer"), z);
        }
    }

    public void F() {
        if (this.w == null) {
            return;
        }
        synchronized (this.x) {
            Iterator<com.baidu.mapsdkplatform.comapi.map.a> it = this.x.iterator();
            while (it.hasNext()) {
                this.w.ShowLayers(it.next().f3973a, false);
            }
        }
    }

    public void G(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.ShowLayers(6L, z);
    }

    public boolean J(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return false;
        }
        long layerIDByTag = appBaseMap.getLayerIDByTag("carnavinode");
        long layerIDByTag2 = this.w.getLayerIDByTag(MapController.ANDROID_SDK_LAYER_TAG);
        if (layerIDByTag == 0 || layerIDByTag2 == 0) {
            return false;
        }
        if (z) {
            if (this.R) {
                return false;
            }
            boolean zSwitchLayer = this.w.SwitchLayer(layerIDByTag, layerIDByTag2);
            this.R = true;
            return zSwitchLayer;
        }
        if (!this.R) {
            return false;
        }
        boolean zSwitchLayer2 = this.w.SwitchLayer(layerIDByTag2, layerIDByTag);
        this.R = false;
        return zSwitchLayer2;
    }

    public boolean K() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.IsBaseIndoorMapMode();
    }

    public boolean L() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("basemap"));
    }

    public boolean M() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.getDrawHouseHeightEnable();
    }

    public boolean N() {
        return this.n;
    }

    public boolean O() {
        return this.r;
    }

    public boolean P() {
        return this.h;
    }

    public boolean Q() {
        return this.o;
    }

    public boolean R() {
        return this.g;
    }

    public boolean S() {
        return this.p;
    }

    public boolean U() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("basepoi"));
        }
        return false;
    }

    public void V() {
        x xVar;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (xVar = this.t) == null) {
            return;
        }
        appBaseMap.RemoveLayer(xVar.f3973a);
        this.x.remove(this.t);
    }

    public void W() {
        if (this.w == null) {
            return;
        }
        synchronized (this.x) {
            for (com.baidu.mapsdkplatform.comapi.map.a aVar : this.x) {
                if (aVar instanceof g) {
                    this.w.ShowLayers(aVar.f3973a, false);
                } else {
                    this.w.ShowLayers(aVar.f3973a, true);
                }
            }
        }
        this.w.ShowTrafficMap(false);
    }

    public void X() {
        g gVar;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (gVar = this.D) == null) {
            return;
        }
        appBaseMap.startHeatMapFrameAnimation(gVar.f3973a);
    }

    public void Y() {
        g gVar;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (gVar = this.D) == null) {
            return;
        }
        appBaseMap.stopHeatMapFrameAnimation(gVar.f3973a);
    }

    public void Z() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.updateBaseLayers();
        }
    }

    public void a(BmLayer bmLayer) {
        this.A = bmLayer;
    }

    public void b(int i, int i2) {
        this.G = i;
        this.H = i2;
    }

    public void c(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        if (this.U == null) {
            this.U = new com.baidu.platform.comapi.map.c(appBaseMap);
            MapViewInterface mapView = this.S.getMapView();
            if (mapView != null) {
                mapView.addOverlay(this.U);
                H();
            }
        }
        this.w.ShowLayers(this.U.mLayerID, z);
    }

    public void d(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        this.m = z;
        appBaseMap.ShowHotMap(z, 0);
    }

    public boolean e(Bundle bundle) {
        if (this.w == null) {
            return false;
        }
        x xVar = new x();
        this.t = xVar;
        long jAddLayer = this.w.AddLayer(xVar.c, xVar.d, xVar.b);
        if (jAddLayer != 0) {
            this.t.f3973a = jAddLayer;
            synchronized (this.x) {
                this.x.add(this.t);
            }
            bundle.putLong("sdktileaddr", jAddLayer);
            if (h(bundle) && m(bundle)) {
                return true;
            }
        }
        return false;
    }

    public void f(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        this.i = z;
        if (this.U == null) {
            this.U = new com.baidu.platform.comapi.map.c(appBaseMap);
            MapViewInterface mapView = this.S.getMapView();
            if (mapView != null) {
                mapView.addOverlay(this.U);
                H();
            }
        }
        this.w.ShowLayers(this.U.mLayerID, z);
    }

    public void g(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.setCustomTrafficColorEnable(z);
        }
    }

    public void h(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.setDEMEnable(z);
        }
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface, com.baidu.platform.comjni.map.basemap.a
    public boolean hasLayer(long j) {
        synchronized (this.x) {
            Iterator<com.baidu.mapsdkplatform.comapi.map.a> it = this.x.iterator();
            while (it.hasNext()) {
                if (it.next().f3973a == j) {
                    return true;
                }
            }
            return false;
        }
    }

    public AppBaseMap i() {
        return this.w;
    }

    public boolean j() {
        return false;
    }

    public void k(Bundle bundle) {
        g gVar;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (gVar = this.D) == null) {
            return;
        }
        appBaseMap.updateHeatMapData(gVar.f3973a, bundle);
    }

    public String l() {
        return null;
    }

    public boolean m() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            return appBaseMap.getCustomTrafficColorEnable();
        }
        return false;
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.MapSDKLayerDataInterface, com.baidu.platform.comjni.map.basemap.a
    public int mapLayerDataReq(Bundle bundle, long j, int i) {
        g gVar = this.D;
        if (gVar != null && j == gVar.f3973a && this.F != null) {
            int i2 = bundle.getInt("zoom");
            bundle.putBundle(RemoteMessageConst.MessageBody.PARAM, this.F.a(bundle.getInt("index"), i2));
            return this.D.e;
        }
        x xVar = this.t;
        if (xVar == null || j != xVar.f3973a) {
            return 0;
        }
        bundle.putBundle(RemoteMessageConst.MessageBody.PARAM, this.u.a(bundle.getInt("x"), bundle.getInt("y"), bundle.getInt("zoom"), null));
        return this.t.e;
    }

    public void n(boolean z) {
        if (this.w == null) {
            return;
        }
        if (this.D == null) {
            g gVar = new g();
            this.D = gVar;
            a(gVar);
        }
        this.k = z;
        this.w.ShowLayers(this.D.f3973a, z);
    }

    public MapBaseIndoorMapInfo o() {
        String strGetFocusedBaseIndoorMapInfo;
        String str;
        String strOptString;
        String strOptString2 = "";
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (strGetFocusedBaseIndoorMapInfo = appBaseMap.GetFocusedBaseIndoorMapInfo()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        try {
            JSONObject jSONObject = new JSONObject(strGetFocusedBaseIndoorMapInfo);
            strOptString = jSONObject.optString("focusindoorid");
            try {
                strOptString2 = jSONObject.optString("curfloor");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("floorlist");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        arrayList.add(jSONArrayOptJSONArray.get(i).toString());
                    }
                }
            } catch (JSONException e) {
                e = e;
                str = strOptString2;
                strOptString2 = strOptString;
                e.printStackTrace();
                String str2 = str;
                strOptString = strOptString2;
                strOptString2 = str2;
            }
        } catch (JSONException e2) {
            e = e2;
            str = "";
        }
        return new MapBaseIndoorMapInfo(strOptString, strOptString2, arrayList);
    }

    public void p(boolean z) {
        this.S.setInertialAnimation(z);
    }

    public void q(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        this.j = z;
        LocationOverlay locationOverlay = this.T;
        if (locationOverlay != null) {
            appBaseMap.ShowLayers(locationOverlay.mLayerID, z);
            return;
        }
        MapViewInterface mapView = this.S.getMapView();
        if (mapView != null) {
            LocationOverlay locationOverlay2 = new LocationOverlay(this.w);
            this.T = locationOverlay2;
            mapView.addOverlay(locationOverlay2);
        }
    }

    public synchronized void r(boolean z) {
        if (this.w != null && w() != MapLanguage.ENGLISH.ordinal() && !this.Y) {
            this.V = z;
            this.w.setCustomStyleEnable(z);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("CustomMap setMapCustomEnable enable = " + z);
            }
            return;
        }
        Log.e("baidumapsdk", "Opening custom map is not support after setting English map , or map has been destroyed");
    }

    public void s(boolean z) {
        this.s = z;
    }

    public void t(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        if (z) {
            if (this.P) {
                return;
            }
            appBaseMap.SwitchLayer(appBaseMap.getLayerIDByTag(com.umeng.analytics.pro.f.F), this.z.f3973a);
            this.P = true;
            return;
        }
        if (this.P) {
            appBaseMap.SwitchLayer(this.z.f3973a, appBaseMap.getLayerIDByTag("indoorlayer"));
            this.P = false;
        }
    }

    public void u(boolean z) {
        MapController mapController = this.S;
        if (mapController == null) {
            return;
        }
        mapController.setOverlookGestureEnable(z);
        this.n = z;
    }

    public boolean v() {
        return this.V;
    }

    public void w(boolean z) {
        MapController mapController = this.S;
        if (mapController != null) {
            mapController.setSDKLayerBelowBmLayer(z);
        }
    }

    public void x(boolean z) {
        if (this.w == null) {
            return;
        }
        this.h = z;
        a();
        this.w.ShowSatelliteMap(this.h);
        MapController mapController = this.S;
        if (mapController != null) {
            if (z) {
                mapController.setMapTheme(2, new Bundle());
            } else {
                mapController.setMapTheme(1, new Bundle());
            }
        }
    }

    public void y(boolean z) {
        MapController mapController = this.S;
        if (mapController == null) {
            return;
        }
        mapController.setCanTouchMove(z);
        this.o = z;
    }

    public void z(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        this.g = z;
        appBaseMap.ShowTrafficMap(z);
    }

    public void a(com.baidu.mapsdkplatform.comapi.map.z.a aVar) {
        this.B = aVar;
    }

    public void i(Bundle bundle) {
        if (this.w == null) {
            return;
        }
        c(bundle);
        this.w.removeOneOverlayItem(bundle);
    }

    public void j(Bundle bundle) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setMapBackgroundImage(bundle);
    }

    public void l(Bundle bundle) {
        if (this.w == null || bundle == null) {
            return;
        }
        c(bundle);
        a(bundle);
        this.w.updateOneOverlayItem(bundle);
    }

    public int p() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return 1;
        }
        appBaseMap.getFontSizeLevel();
        return 1;
    }

    public boolean s() {
        return this.j;
    }

    public void v(boolean z) {
        MapController mapController = this.S;
        if (mapController == null) {
            return;
        }
        mapController.set3DGestureEnable(z);
        this.r = z;
    }

    private void a(MapController mapController) {
        if (!JNIInitializer.isResourceInited()) {
            synchronized (JNIInitializer.class) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("animation", 1);
        bundle.putDouble("level", 12.0d);
        bundle.putDouble("centerptx", 1.295815798E7d);
        bundle.putDouble("centerpty", 4825999.74d);
        bundle.putDouble("centerptz", 0.0d);
        bundle.putInt("left", 0);
        bundle.putInt(Constant.MAP_KEY_TOP, 0);
        int screenHeight = SysOSUtil.getInstance().getScreenHeight();
        bundle.putInt("right", SysOSUtil.getInstance().getScreenWidth());
        bundle.putInt("bottom", screenHeight);
        bundle.putString("modulePath", SysOSUtil.getInstance().getOutputDirPath());
        bundle.putString("appSdcardPath", SysOSUtil.getInstance().getExternalFilesDir());
        bundle.putString("appCachePath", SysOSUtil.getInstance().getOutputCache());
        bundle.putString("appSecondCachePath", SysOSUtil.getInstance().getOutputCache());
        bundle.putInt("mapTmpMax", EnvironmentUtilities.getMapTmpStgMax());
        bundle.putInt("domTmpMax", EnvironmentUtilities.getDomTmpStgMax());
        bundle.putInt("itsTmpMax", EnvironmentUtilities.getItsTmpStgMax());
        bundle.putInt("ssgTmpMax", EnvironmentUtilities.getSsgTmpStgMax());
        mapController.initMapResources(bundle);
    }

    private boolean h(Bundle bundle) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.addSDKTileData(bundle);
    }

    private boolean m(Bundle bundle) {
        AppBaseMap appBaseMap;
        if (bundle == null || (appBaseMap = this.w) == null) {
            return false;
        }
        boolean zUpdateSDKTile = appBaseMap.updateSDKTile(bundle);
        if (zUpdateSDKTile) {
            C(zUpdateSDKTile);
            this.w.UpdateLayers(this.t.f3973a);
        }
        return zUpdateSDKTile;
    }

    public float[] C() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return null;
        }
        return appBaseMap.getViewMatrix();
    }

    public double E() {
        return y().m;
    }

    public boolean G() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            return appBaseMap.LayersIsShow(appBaseMap.getLayerIDByTag("poiindoormarklayer"));
        }
        return false;
    }

    public boolean b(ParticleEffectType particleEffectType) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            return appBaseMap.showParticleEffectByType(particleEffectType.getType());
        }
        return false;
    }

    public void g(Bundle bundle) {
        g gVar;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (gVar = this.D) == null) {
            return;
        }
        appBaseMap.initHeatMapData(gVar.f3973a, bundle);
    }

    public boolean k() {
        return this.i;
    }

    public int w() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return 0;
        }
        return appBaseMap.getMapLanguage();
    }

    public void A(boolean z) {
        MapController mapController = this.S;
        if (mapController == null) {
            return;
        }
        mapController.setTwoTouchClickZoomEnabled(z);
    }

    public float[] B() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return null;
        }
        return appBaseMap.getProjectionMatrix();
    }

    public void d() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.ClearSDKLayer(this.z.f3973a);
    }

    public void j(boolean z) {
        MapController mapController = this.S;
        if (mapController == null) {
            return;
        }
        mapController.setDoubleClickMoveZoomEnable(z);
    }

    public void k(boolean z) {
        MapController mapController = this.S;
        if (mapController == null) {
            return;
        }
        mapController.setDoubleClickZoom(z);
    }

    public String u() {
        return this.V ? "" : "长地万方\nMapbox\nMapKin\n樂客LocalKing PalmCit\nESO DigitalGlobal spaceview\nOSRM Copyright ©2017, Project OSRMcontributors, all rights reserved\nHERE© 2019 HERE, all rights reserved\nOpenStreetMap© OpenStreetMapContributor;(OSMF)";
    }

    public s y() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return null;
        }
        Bundle bundleGetMapStatus = appBaseMap.GetMapStatus();
        s sVar = new s();
        sVar.a(bundleGetMapStatus);
        return sVar;
    }

    public LatLngBounds z() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return null;
        }
        Bundle mapStatusLimits = appBaseMap.getMapStatusLimits();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        int i = mapStatusLimits.getInt("maxCoorx");
        int i2 = mapStatusLimits.getInt("minCoorx");
        builder.include(CoordUtil.mc2ll(new GeoPoint(mapStatusLimits.getInt("minCoory"), i))).include(CoordUtil.mc2ll(new GeoPoint(mapStatusLimits.getInt("maxCoory"), i2)));
        return builder.build();
    }

    public void b(int i) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setBackgroundColor(i);
    }

    public void g() {
        LocationOverlay locationOverlay = this.T;
        if (locationOverlay != null) {
            locationOverlay.clearLocationLayerData(null);
        }
    }

    public synchronized void h() {
        this.Y = true;
    }

    public void i(boolean z) {
        MapController mapController = this.S;
        if (mapController == null) {
            return;
        }
        mapController.setDoubleClickGesturesCenter(z);
    }

    public void F(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.ShowLayers(10L, z);
    }

    public void d(Bundle bundle) {
        if (this.w == null) {
            return;
        }
        c(bundle);
        a(bundle);
        this.w.addOneOverlayItem(bundle);
    }

    public void l(boolean z) {
        MapController mapController = this.S;
        if (mapController == null) {
            return;
        }
        mapController.setEnlargeCenterWithDoubleClickEnable(z);
    }

    public void b(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setDrawHouseHeightEnable(z);
    }

    public void m(boolean z) {
        MapController mapController = this.S;
        if (mapController == null) {
            return;
        }
        mapController.setFlingEnable(z);
    }

    public s n() {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return null;
        }
        Bundle bundleGetMapStatus = appBaseMap.GetMapStatus(false);
        s sVar = new s();
        sVar.a(bundleGetMapStatus);
        return sVar;
    }

    public boolean c() {
        AppBaseMap appBaseMap;
        x xVar = this.t;
        if (xVar == null || (appBaseMap = this.w) == null) {
            return false;
        }
        return appBaseMap.cleanSDKTileDataCache(xVar.f3973a);
    }

    public int q() {
        return this.H;
    }

    public MapStatusUpdate r() {
        return this.O;
    }

    public String t() {
        return this.V ? "" : "GS(2022)460号";
    }

    public String x() {
        return this.V ? "" : "甲测资字11111342";
    }

    public void I(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.showTrafficUGCMap(z);
        }
    }

    public void b(Bundle[] bundleArr) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.removeOverlayItems(bundleArr);
    }

    public LatLngBounds f(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i = bundle.getInt("type");
        String string = bundle.getString("encodedPoints");
        LatLngBounds latLngBoundsBuild = new LatLngBounds.Builder().build();
        int i2 = bundle.getInt("encodePointType");
        if (string == null || string.length() <= 0) {
            return latLngBoundsBuild;
        }
        if (i != d.prism.ordinal() && i != d.polygon.ordinal()) {
            return latLngBoundsBuild;
        }
        ArrayList<LatLng> arrayListA = com.baidu.platform.comapi.util.g.a().a(string, i2);
        if (arrayListA == null || arrayListA.size() <= 0) {
            return null;
        }
        int size = arrayListA.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i3 = 0; i3 < size; i3++) {
            GeoPoint geoPointLl2mcDirect = CoordUtil.ll2mcDirect(arrayListA.get(i3));
            dArr[i3] = geoPointLl2mcDirect.getLongitudeE6();
            dArr2[i3] = geoPointLl2mcDirect.getLatitudeE6();
        }
        Point point = new Point();
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(arrayListA.get(0));
        Rect rect = new Rect((int) geoPointLl2mc.getLongitudeE6(), (int) geoPointLl2mc.getLatitudeE6(), (int) geoPointLl2mc.getLongitudeE6(), (int) geoPointLl2mc.getLatitudeE6());
        for (int i4 = 1; i4 < size; i4++) {
            int i5 = (int) dArr[i4];
            point.x = i5;
            point.y = (int) dArr2[i4];
            rect.set(Math.min(rect.left, i5), Math.max(rect.top, point.y), Math.max(rect.right, point.x), Math.min(rect.bottom, point.y));
        }
        GeoPoint geoPoint = new GeoPoint(rect.bottom, rect.left);
        GeoPoint geoPoint2 = new GeoPoint(rect.top, rect.right);
        LatLng latLngMc2ll = CoordUtil.mc2ll(geoPoint);
        return new LatLngBounds.Builder().include(latLngMc2ll).include(CoordUtil.mc2ll(geoPoint2)).build();
    }

    public boolean J() {
        return this.m;
    }

    public void c(Bundle bundle) {
        if (bundle.get(RemoteMessageConst.MessageBody.PARAM) != null) {
            Bundle bundle2 = (Bundle) bundle.get(RemoteMessageConst.MessageBody.PARAM);
            int i = bundle2.getInt("type");
            if (i == d.ground.ordinal()) {
                bundle2.putLong("layer_addr", this.z.f3973a);
                return;
            }
            if (i >= d.arc.ordinal()) {
                bundle2.putLong("layer_addr", this.z.f3973a);
                return;
            } else if (i == d.popup.ordinal()) {
                bundle2.putLong("layer_addr", this.z.f3973a);
                return;
            } else {
                bundle2.putLong("layer_addr", this.z.f3973a);
                return;
            }
        }
        int i2 = bundle.getInt("type");
        if (i2 == d.ground.ordinal()) {
            bundle.putLong("layer_addr", this.z.f3973a);
            return;
        }
        if (i2 >= d.arc.ordinal()) {
            bundle.putLong("layer_addr", this.z.f3973a);
        } else if (i2 == d.popup.ordinal()) {
            bundle.putLong("layer_addr", this.z.f3973a);
        } else {
            bundle.putLong("layer_addr", this.z.f3973a);
        }
    }

    public void d(int i) {
        g gVar;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (gVar = this.D) == null) {
            return;
        }
        appBaseMap.setHeatMapFrameAnimationIndex(gVar.f3973a, i);
    }

    public int D() {
        return this.G;
    }

    public boolean b(String str, String str2) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return false;
        }
        return appBaseMap.SwitchBaseIndoorMapFloor(str, str2);
    }

    public void e(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("basemap"), z);
    }

    public void b(Bundle bundle) {
        i iVar;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (iVar = this.E) == null) {
            return;
        }
        appBaseMap.addHexagonMapData(iVar.f3973a, bundle);
    }

    public void o(boolean z) {
        if (this.w == null) {
            return;
        }
        if (this.E == null) {
            i iVar = new i();
            this.E = iVar;
            a(iVar);
        }
        this.l = z;
        this.w.ShowLayers(this.E.f3973a, z);
    }

    public void e() {
        g gVar;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (gVar = this.D) == null) {
            return;
        }
        appBaseMap.clearHeatMapLayerCache(gVar.f3973a);
        this.w.UpdateLayers(this.D.f3973a);
    }

    public void H(boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.ShowLayers(appBaseMap.getLayerIDByTag("basepoi"), z);
        }
    }

    public void b(Point point) {
        MapController mapController = this.S;
        if (mapController == null || point == null) {
            return;
        }
        mapController.setPointGesturesCenter(point);
    }

    public void b() {
        MapController mapController = this.S;
        if (mapController == null || mapController.mIsMoving || mapController.mIsAnimating) {
            return;
        }
        mapController.mIsAnimating = true;
        if (this.v == null) {
            return;
        }
        s sVarY = y();
        for (int i = 0; i < this.v.size(); i++) {
            com.baidu.platform.comapi.map.v vVar = this.v.get(i);
            if (vVar != null) {
                vVar.c(sVarY);
            }
        }
    }

    private void a(String str, String str2, long j) {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j));
        } catch (Exception unused) {
        }
    }

    public void c(int i) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.setFontSizeLevel(i);
        }
    }

    private void a(q qVar) {
        if (qVar == null) {
            qVar = new q();
        }
        boolean z = qVar.f;
        this.n = z;
        this.r = qVar.d;
        this.o = qVar.e;
        this.p = qVar.g;
        u(z);
        v(this.r);
        y(this.o);
        B(this.p);
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.SetMapControlMode(p.DEFAULT.ordinal());
        boolean z2 = qVar.b;
        this.i = z2;
        if (z2) {
            if (this.U == null) {
                this.U = new com.baidu.platform.comapi.map.c(this.w);
                MapViewInterface mapView = this.S.getMapView();
                if (mapView != null) {
                    mapView.addOverlay(this.U);
                    H();
                }
            }
            this.w.ShowLayers(this.U.mLayerID, true);
            this.w.ResetImageRes();
        }
        int i = qVar.c;
        if (i == 2) {
            x(true);
        }
        if (i == 3) {
            if (U()) {
                H(false);
            }
            if (G()) {
                E(false);
            }
            e(false);
            D(false);
        }
    }

    public b(Context context, MapSurfaceView mapSurfaceView, q qVar, String str, int i) {
        MapController mapController = new MapController();
        this.S = mapController;
        mapController.initAppBaseMap();
        a(this.S);
        mapSurfaceView.setMapController(this.S);
        this.w = this.S.getBaseMap();
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.S.getMapId());
        I();
        a(qVar);
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.SetSDKLayerCallback(this);
        }
        this.S.onResume();
    }

    public void f() {
        i iVar;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || (iVar = this.E) == null) {
            return;
        }
        appBaseMap.clearHexagonLayerCache(iVar.f3973a);
        this.w.UpdateLayers(this.E.f3973a);
    }

    public boolean a(Point point) {
        int i;
        int i2;
        if (point != null && this.w != null && (i = point.x) >= 0 && (i2 = point.y) >= 0) {
            b = i;
            c = i2;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("x", b);
                jSONObject2.put("y", c);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("dataset", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.U != null) {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    this.U.setData(jSONObject.toString());
                }
                this.U.UpdateOverlay();
                return true;
            }
        }
        return false;
    }

    public void a(Bitmap bitmap) {
        Bundle bundle;
        if (this.w == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put("x", b);
            jSONObject2.put("y", c);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("dataset", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (bitmap == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = new Bundle();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(byteBufferAllocate);
            bundle3.putByteArray("imgData", byteBufferAllocate.array());
            bundle3.putString("imgKey", bitmap.hashCode() + "_" + System.currentTimeMillis());
            bundle3.putInt("imgH", bitmap.getHeight());
            bundle3.putInt("imgW", bitmap.getWidth());
            bundle3.putInt("hasIcon", 1);
            bundle2.putBundle("iconData", bundle3);
            bundle = bundle2;
        }
        if (this.U != null) {
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                this.U.setData(jSONObject.toString());
            }
            if (bundle != null) {
                this.U.setParam(bundle);
            }
            this.U.UpdateOverlay();
        }
    }

    public void a(float f, float f2) {
        this.d = f;
        this.f = f;
        this.e = f2;
        MapController mapController = this.S;
        if (mapController != null) {
            mapController.setMaxAndMinZoomLevel(f, f2);
        }
        if (this.w != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("maxLevel", (int) f);
            bundle.putInt("minLevel", (int) f2);
            this.w.setMaxAndMinZoomLevel(bundle);
        }
    }

    private void a() {
        if (!this.k && !this.h && !this.g && !this.m) {
            float f = this.f;
            this.d = f;
            MapController mapController = this.S;
            if (mapController != null) {
                mapController.mMaxZoomLevel = f;
                return;
            }
            return;
        }
        if (this.d > 20.0f) {
            this.d = 20.0f;
            MapController mapController2 = this.S;
            if (mapController2 != null) {
                mapController2.mMaxZoomLevel = 20.0f;
            }
        }
        if (y().f3992a > 20.0f) {
            s sVarY = y();
            sVarY.f3992a = 20.0f;
            a(sVarY);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.setCustomTrafficColor(i, i2, i3, i4);
        }
    }

    public void a(PoiTagType poiTagType, boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.setPoiTagEnable(poiTagType.ordinal(), z);
        }
    }

    public boolean a(PoiTagType poiTagType) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            return appBaseMap.getPoiTagEnable(poiTagType.ordinal());
        }
        return false;
    }

    public void a(ParticleEffectType particleEffectType) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            appBaseMap.closeParticleEffectByType(particleEffectType.getType());
        }
    }

    public boolean a(ParticleEffectType particleEffectType, Bundle bundle) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null) {
            return appBaseMap.customParticleEffectByType(particleEffectType.getType(), bundle);
        }
        return false;
    }

    private void a(com.baidu.mapsdkplatform.comapi.map.a aVar) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        aVar.f3973a = appBaseMap.AddLayer(aVar.c, aVar.d, aVar.b);
        synchronized (this.x) {
            this.x.add(aVar);
        }
    }

    public void a(boolean z) {
        LocationOverlay locationOverlay;
        LocationOverlay locationOverlay2;
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        if (z) {
            if (this.Q || (locationOverlay2 = this.T) == null) {
                return;
            }
            appBaseMap.SwitchLayer(this.z.f3973a, locationOverlay2.mLayerID);
            this.Q = true;
            return;
        }
        if (!this.Q || (locationOverlay = this.T) == null) {
            return;
        }
        appBaseMap.SwitchLayer(locationOverlay.mLayerID, this.z.f3973a);
        this.Q = false;
    }

    public boolean a(MapLayer mapLayer, MapLayer mapLayer2) {
        if (this.w == null) {
            return false;
        }
        long jA = a(mapLayer);
        long jA2 = a(mapLayer2);
        if (jA == -1 || jA2 == -1) {
            return false;
        }
        boolean zSwitchLayer = this.w.SwitchLayer(jA, jA2);
        this.w.UpdateLayers(jA2);
        return zSwitchLayer;
    }

    public void a(MapLayer mapLayer, boolean z) {
        if (this.w == null) {
            return;
        }
        long jA = a(mapLayer);
        if (jA == -1) {
            return;
        }
        this.w.SetLayersClickable(jA, z);
    }

    private long a(MapLayer mapLayer) {
        if (this.w == null) {
            return -1L;
        }
        switch (a.f3975a[mapLayer.ordinal()]) {
            case 1:
                LocationOverlay locationOverlay = this.T;
                if (locationOverlay != null) {
                    return locationOverlay.mLayerID;
                }
                return -1L;
            case 2:
                v vVar = this.z;
                if (vVar != null) {
                    return vVar.f3973a;
                }
                return -1L;
            case 3:
                BmLayer bmLayer = this.A;
                if (bmLayer != null) {
                    return bmLayer.c();
                }
                return -1L;
            case 4:
                if (this.z != null) {
                    return this.D.f3973a;
                }
                return -1L;
            case 5:
                if (this.z != null) {
                    return this.E.f3973a;
                }
                return -1L;
            case 6:
                com.baidu.mapsdkplatform.comapi.map.z.a aVar = this.B;
                if (aVar != null) {
                    return aVar.mLayerID;
                }
                return -1L;
            default:
                return -1L;
        }
    }

    public void a(int i) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.cleanCache(i, true);
    }

    public void a(w wVar) {
        this.u = wVar;
    }

    public GeoPoint a(int i, int i2) {
        return this.S.getMapView().getProjection().fromPixels(i, i2);
    }

    public Point a(GeoPoint geoPoint) {
        com.baidu.platform.comapi.basestruct.Point pixels = this.S.getMapView().getProjection().toPixels(geoPoint, null);
        if (pixels != null) {
            return new Point(pixels.getIntX(), pixels.getIntY());
        }
        return new Point();
    }

    public Point a(GeoPoint geoPoint, int i) {
        com.baidu.platform.comapi.basestruct.Point pixels = this.S.getMapView().getProjection().toPixels(geoPoint, i, null);
        if (pixels != null) {
            return new Point(pixels.getIntX(), pixels.getIntY());
        }
        return new Point();
    }

    public void a(Bundle bundle) {
        if (bundle != null && bundle.containsKey("encodedPoints") && bundle.containsKey("encodePointType")) {
            int i = bundle.getInt("encodePointType");
            if (i == EncodePointType.BUILDINGINFO.ordinal() || i == EncodePointType.AOI.ordinal() || i == EncodePointType.RECOGNIZE_AOI.ordinal()) {
                a(bundle, bundle.getString("encodedPoints"));
            }
        }
    }

    public void a(Bundle bundle, String str) {
        if (bundle == null || str == null || str.length() <= 0) {
            return;
        }
        ArrayList<LatLng> arrayListA = com.baidu.platform.comapi.util.g.a().a(str, bundle.getInt("encodePointType"));
        if (arrayListA == null || arrayListA.size() <= 0) {
            return;
        }
        int size = arrayListA.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            GeoPoint geoPointLl2mcDirect = CoordUtil.ll2mcDirect(arrayListA.get(i));
            dArr[i] = geoPointLl2mcDirect.getLongitudeE6();
            dArr2[i] = geoPointLl2mcDirect.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
        GeoPoint geoPointLl2mcDirect2 = CoordUtil.ll2mcDirect(arrayListA.get(0));
        bundle.putDouble("location_x", geoPointLl2mcDirect2.getLongitudeE6());
        bundle.putDouble("location_y", geoPointLl2mcDirect2.getLatitudeE6());
        if (bundle.getInt("has_dotted_stroke") == 1) {
            bundle.putDouble("dotted_stroke_location_x", geoPointLl2mcDirect2.getLongitudeE6());
            bundle.putDouble("dotted_stroke_location_y", geoPointLl2mcDirect2.getLatitudeE6());
        }
    }

    public void a(Bundle[] bundleArr) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null || bundleArr == null) {
            return;
        }
        appBaseMap.addOverlayItems(bundleArr, bundleArr.length);
    }

    public synchronized void a(String str, String str2) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap != null && !this.Y) {
            appBaseMap.initCustomStyle(str, str2);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        AppBaseMap appBaseMap = this.w;
        if (appBaseMap == null) {
            return;
        }
        appBaseMap.setCustomTrafficColor(i, i2, i3, i4, z);
    }

    public float a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (!this.S.mIsMapLoadFinish) {
            return 12.0f;
        }
        if (this.w == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", i);
        bundle.putInt("right", i3);
        bundle.putInt("bottom", i4);
        bundle.putInt(Constant.MAP_KEY_TOP, i2);
        bundle.putInt("hasHW", 1);
        bundle.putInt("width", i5);
        bundle.putInt("height", i6);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("left", 0);
        bundle2.putInt("bottom", i6);
        bundle2.putInt("right", i5);
        bundle2.putInt(Constant.MAP_KEY_TOP, 0);
        return this.w.GetFZoomToBoundF(bundle, bundle2);
    }

    public void a(List<OverlayLocationData> list) {
        LocationOverlay locationOverlay = this.T;
        if (locationOverlay == null) {
            return;
        }
        locationOverlay.setLocationLayerData(list);
        this.T.UpdateOverlay();
    }

    public void a(String str, Bundle bundle) {
        LocationOverlay locationOverlay = this.T;
        if (locationOverlay == null) {
            return;
        }
        locationOverlay.setData(str);
        this.T.setParam(bundle);
        this.T.UpdateOverlay();
    }

    public void a(LatLng latLng) {
        MapController mapController = this.S;
        if (mapController == null || latLng == null) {
            return;
        }
        mapController.setLatLngGesturesCenter(latLng);
    }

    public void a(com.baidu.platform.comapi.map.v vVar) {
        if (vVar == null || this.v == null) {
            return;
        }
        this.S.registMapViewListener(vVar);
        this.v.add(vVar);
    }

    public void a(com.baidu.platform.comapi.map.w wVar) {
        if (wVar == null) {
            return;
        }
        this.S.setOverlayListener(wVar);
    }

    public void a(h hVar) {
        this.F = hVar;
    }

    public void a(s sVar) {
        if (this.w == null || sVar == null) {
            return;
        }
        Bundle bundleA = sVar.a(this);
        bundleA.putInt("animation", 0);
        bundleA.putInt("animatime", 0);
        T();
        this.w.SetMapStatus(bundleA);
    }

    public void a(s sVar, int i) {
        if (this.w == null || sVar == null) {
            return;
        }
        Bundle bundleA = sVar.a(this);
        bundleA.putInt("animation", 1);
        bundleA.putInt("animatime", i);
        if (this.M) {
            this.N.add(new C0086b(bundleA));
        } else {
            b();
            this.w.SetMapStatus(bundleA);
        }
    }

    public void a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.w == null) {
            return;
        }
        LatLng latLng = latLngBounds.northeast;
        LatLng latLng2 = latLngBounds.southwest;
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(latLng2);
        int longitudeE6 = (int) geoPointLl2mc.getLongitudeE6();
        int latitudeE6 = (int) geoPointLl2mc2.getLatitudeE6();
        int longitudeE62 = (int) geoPointLl2mc2.getLongitudeE6();
        int latitudeE62 = (int) geoPointLl2mc.getLatitudeE6();
        Bundle bundle = new Bundle();
        bundle.putInt("maxCoorx", longitudeE6);
        bundle.putInt("minCoory", latitudeE6);
        bundle.putInt("minCoorx", longitudeE62);
        bundle.putInt("maxCoory", latitudeE62);
        this.w.setMapStatusLimits(bundle);
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.O = mapStatusUpdate;
    }

    public void a(int i, boolean z) {
        if (this.w != null && (!this.V || i != MapLanguage.ENGLISH.ordinal())) {
            this.w.setMapLanguage(i, z);
        } else {
            Log.e("baidumapsdk", "Opening English map is not supported after setting custom map");
        }
    }
}
