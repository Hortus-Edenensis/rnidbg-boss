package com.baidu.platform.comapi.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.s;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.mcssdk.constant.MessageConstant;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MapSurfaceView extends t implements View.OnKeyListener, MapViewInterface, MapRenderModeChangeListener, u {
    private static int b;
    private static final ExecutorService c = Executors.newSingleThreadExecutor();
    protected com.baidu.mapsdkplatform.comapi.map.b A;
    private float B;
    private float C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private volatile boolean d;
    private volatile boolean e;
    private volatile boolean f;
    private volatile boolean g;
    private boolean h;
    private boolean i;
    protected MapController j;
    protected p k;
    protected h l;
    protected j m;
    private LocationOverlay n;
    protected volatile boolean o;
    private boolean p;
    private List<BmLayer> q;
    private List<Overlay> r;
    private int s;
    private int t;
    private HashSet<m> u;
    protected boolean v;
    protected x w;
    protected GestureDetector x;
    protected n y;
    private boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBaseMap baseMap;
            MapController mapController = MapSurfaceView.this.j;
            if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
                return;
            }
            baseMap.ShowSatelliteMap(MapSurfaceView.this.e);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBaseMap baseMap;
            MapController mapController = MapSurfaceView.this.j;
            if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
                return;
            }
            baseMap.ShowTrafficMap(MapSurfaceView.this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBaseMap baseMap;
            MapController mapController = MapSurfaceView.this.j;
            if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
                return;
            }
            baseMap.ShowTrafficMap(MapSurfaceView.this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBaseMap baseMap;
            MapController mapController = MapSurfaceView.this.j;
            if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
                return;
            }
            baseMap.ShowStreetRoadMap(MapSurfaceView.this.f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4175a;

        public e(boolean z) {
            this.f4175a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBaseMap baseMap;
            MapController mapController = MapSurfaceView.this.j;
            if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
                return;
            }
            baseMap.ShowBaseIndoorMap(this.f4175a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements e.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4176a;

        private f() {
            this.f4176a = 12440;
        }

        public String a(String str, int i) {
            return str + " failed: " + a(i);
        }

        public void b(String str, int i) {
            throw new RuntimeException(a(str, i));
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.f4176a, 2, 12344});
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (eGLContext != null && eGLDisplay != null) {
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
                if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                    Log.e("MapContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                    b("eglDestroyContex", egl10.eglGetError());
                }
            }
            MapSurfaceView.this.onRecycle();
        }

        private String a(int i) {
            switch (i) {
                case MessageConstant.CommandId.COMMAND_BASE /* 12288 */:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case MessageConstant.CommandId.COMMAND_UNREGISTER /* 12290 */:
                    return "EGL_BAD_ACCESS";
                case MessageConstant.CommandId.COMMAND_STATISTIC /* 12291 */:
                    return "EGL_BAD_ALLOC";
                case MessageConstant.CommandId.COMMAND_SET_ALIAS /* 12292 */:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case MessageConstant.CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case MessageConstant.CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                    return "EGL_BAD_NATIVE_WINDOW";
                case MessageConstant.CommandId.COMMAND_RESUME_PUSH /* 12300 */:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return b(i);
            }
        }

        public /* synthetic */ f(MapSurfaceView mapSurfaceView, a aVar) {
            this();
        }

        private String b(int i) {
            return "0x" + Integer.toHexString(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends GestureDetector.SimpleOnGestureListener {
        private g() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            GeoPoint geoPointFromPixels;
            BmDrawItem bmDrawItemA;
            List<v> list;
            super.onLongPress(motionEvent);
            MapController mapController = MapSurfaceView.this.j;
            if (mapController == null || mapController.getBaseMap() == null) {
                return;
            }
            MapController mapController2 = MapSurfaceView.this.j;
            if (mapController2.mIsMapLoadFinish) {
                String strGetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), MapSurfaceView.this.j.nearlyRadius);
                if (strGetNearlyObjID != null && !strGetNearlyObjID.equals("")) {
                    MapSurfaceView mapSurfaceView = MapSurfaceView.this;
                    if (mapSurfaceView.j.mListeners != null) {
                        geoPointFromPixels = mapSurfaceView.getProjection() != null ? MapSurfaceView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                        for (v vVar : MapSurfaceView.this.j.mListeners) {
                            if (vVar != null) {
                                if (vVar.a(strGetNearlyObjID)) {
                                    MapSurfaceView.this.j.mHasMapObjDraging = true;
                                } else if (geoPointFromPixels != null) {
                                    vVar.d(geoPointFromPixels);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                if (OverlayUtil.isOverlayUpgrade() && MapSurfaceView.this.q != null && !MapSurfaceView.this.q.isEmpty() && (bmDrawItemA = ((BmLayer) MapSurfaceView.this.q.get(0)).a((int) motionEvent.getX(), (int) motionEvent.getY(), MapSurfaceView.this.j.nearlyRadius)) != null && (list = MapSurfaceView.this.j.mListeners) != null) {
                    for (v vVar2 : list) {
                        if (vVar2 != null && vVar2.a(bmDrawItemA)) {
                            MapSurfaceView.this.j.mHasBmDrawItemDraging = true;
                        }
                    }
                }
                MapSurfaceView mapSurfaceView2 = MapSurfaceView.this;
                if (mapSurfaceView2.j.mListeners != null) {
                    geoPointFromPixels = mapSurfaceView2.getProjection() != null ? MapSurfaceView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                    if (geoPointFromPixels == null) {
                        return;
                    }
                    for (v vVar3 : MapSurfaceView.this.j.mListeners) {
                        if (vVar3 != null) {
                            vVar3.d(geoPointFromPixels);
                        }
                    }
                }
            }
        }

        public /* synthetic */ g(MapSurfaceView mapSurfaceView, a aVar) {
            this();
        }
    }

    public MapSurfaceView(Context context) {
        super(context);
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = false;
        this.p = true;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = 0;
        this.t = 0;
        this.u = new HashSet<>();
        this.v = true;
        this.z = true;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        b++;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayer(BmLayer bmLayer) {
        return addBmLayerBelow(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayerBelow(Overlay overlay, BmLayer bmLayer) {
        return overlay != null ? addBmLayerBelow(overlay.mLayerID, bmLayer) : addBmLayerBelow(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean addOverlay(Overlay overlay) {
        if (overlay != null) {
            MapController mapController = this.j;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                if (overlay instanceof InnerOverlay) {
                    InnerOverlay innerOverlay = (InnerOverlay) overlay;
                    if (innerOverlay.mBaseMap == null) {
                        innerOverlay.mBaseMap = getController().getBaseMap();
                    }
                    if (!innerOverlay.addedToMapView()) {
                        return false;
                    }
                    synchronized (this) {
                        this.r.add(overlay);
                        this.k.a((InnerOverlay) overlay);
                    }
                    return true;
                }
                if (!(overlay instanceof ItemizedOverlay)) {
                    return false;
                }
                ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
                long jAddLayer = baseMap.AddLayer(itemizedOverlay.getUpdateType(), 0, MapController.ITEM_LAYER_TAG);
                overlay.mLayerID = jAddLayer;
                if (jAddLayer == 0) {
                    return false;
                }
                synchronized (this) {
                    this.r.add(overlay);
                    itemizedOverlay.c();
                    baseMap.SetLayersClickable(overlay.mLayerID, true);
                    baseMap.ShowLayers(overlay.mLayerID, true);
                    baseMap.UpdateLayers(overlay.mLayerID);
                }
                return true;
            }
        }
        return false;
    }

    public void addSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.w.a(simpleOnGestureListener);
    }

    public void addStateListener(m mVar) {
        if (mVar != null) {
            this.u.add(mVar);
        }
    }

    public void animateTo(MapStatus mapStatus, int i) {
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i);
        }
    }

    public void beginLocationLayerAnimation() {
        LocationOverlay locationOverlay = this.n;
        if (locationOverlay != null) {
            locationOverlay.beginLocationLayerAnimation();
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ Bitmap captureImageFromSurface(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config) {
        return super.captureImageFromSurface(i, i2, i3, i4, obj, config);
    }

    public void clearDefaultLocationLayerData(Bundle bundle) {
        this.n.clearLocationLayerData(bundle);
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, int i, int i2) {
        this.m.a(captureMapViewListener, i, i2);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        return true;
    }

    public void forceSetTraffic(boolean z) {
        if (this.j != null) {
            this.d = z;
        }
        c.submit(new b());
    }

    public com.baidu.mapsdkplatform.comapi.map.b getBaseMap() {
        return this.A;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<BmLayer> getBmlayers() {
        return this.q;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        return this.j;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        MapController mapController = this.j;
        if (mapController != null) {
            return mapController.getCurrentMapStatus();
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getCurrentZoomLevel() {
        MapController mapController = this.j;
        if (mapController != null) {
            return mapController.getCurrentZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ int getDebugFlags() {
        return super.getDebugFlags();
    }

    public LocationOverlay getDefaultLocationLay() {
        return this.n;
    }

    public int getFPS() {
        return this.f4217a.getFPS();
    }

    public float getFZoomToBoundF(MapBound mapBound, MapBound mapBound2) {
        if (this.j == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt(Constant.MAP_KEY_TOP, mapBound.rightTopPt.getIntY());
        Bundle bundle2 = new Bundle();
        bundle2.putInt("left", mapBound2.leftBottomPt.getIntX());
        bundle2.putInt("bottom", mapBound2.leftBottomPt.getIntY());
        bundle2.putInt("right", mapBound2.rightTopPt.getIntX());
        bundle2.putInt(Constant.MAP_KEY_TOP, mapBound2.rightTopPt.getIntY());
        return this.j.GetFZoomToBoundF(bundle, bundle2);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        MapController mapController = this.j;
        if (mapController == null) {
            return null;
        }
        return mapController.getMapStatus().geoRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLatitudeSpan() {
        MapStatus mapStatus = getMapStatus();
        h hVar = (h) getProjection();
        MapStatus.WinRound winRound = mapStatus.winRound;
        GeoPoint geoPointFromPixels = hVar.fromPixels(winRound.left, winRound.top);
        MapStatus.WinRound winRound2 = mapStatus.winRound;
        return (int) Math.abs(geoPointFromPixels.getLatitude() - hVar.fromPixels(winRound2.right - 1, winRound2.bottom - 1).getLatitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLongitudeSpan() {
        MapStatus mapStatus = getMapStatus();
        h hVar = (h) getProjection();
        MapStatus.WinRound winRound = mapStatus.winRound;
        GeoPoint geoPointFromPixels = hVar.fromPixels(winRound.left, winRound.top);
        MapStatus.WinRound winRound2 = mapStatus.winRound;
        return (int) Math.abs(hVar.fromPixels(winRound2.right - 1, winRound2.bottom - 1).getLongitude() - geoPointFromPixels.getLongitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public GeoPoint getMapCenter() {
        MapController mapController = this.j;
        if (mapController == null) {
            return null;
        }
        MapStatus mapStatus = mapController.getMapStatus();
        return new GeoPoint(mapStatus.centerPtY, mapStatus.centerPtX);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getMapRotation() {
        MapController mapController = this.j;
        if (mapController == null) {
            return 0;
        }
        return mapController.getMapStatus().rotation;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getMapStatus() {
        MapController mapController = this.j;
        if (mapController != null) {
            return mapController.getMapStatus();
        }
        return null;
    }

    public MapViewListener getMapViewListener() {
        MapController mapController = this.j;
        if (mapController != null) {
            return mapController.getMapViewListener();
        }
        return null;
    }

    public OnLongPressListener getOnLongPressListener() {
        return this.w.a();
    }

    public synchronized Overlay getOverlay(int i) {
        if (i == 21) {
            return null;
        }
        for (Overlay overlay : this.r) {
            if (overlay.mType == i) {
                return overlay;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<Overlay> getOverlays() {
        return this.r;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public double getOverlooking() {
        MapController mapController = this.j;
        if (mapController == null) {
            return 0.0d;
        }
        return mapController.getMapStatus().overlooking;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public Projection getProjection() {
        return this.l;
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ r getRenderControl() {
        return super.getRenderControl();
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ int getRenderMode() {
        return super.getRenderMode();
    }

    public ExecutorService getSingleThreadPool() {
        return c;
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ s.a getViewType() {
        return super.getViewType();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        MapController mapController = this.j;
        if (mapController == null) {
            return null;
        }
        return mapController.getMapStatus().winRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomLevel() {
        MapController mapController = this.j;
        if (mapController != null) {
            return mapController.getZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound) {
        SysOSUtil sysOSUtil = SysOSUtil.getInstance();
        return getZoomToBound(mapBound, sysOSUtil.getScreenWidth(), sysOSUtil.getScreenHeight());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound, int i, int i2) {
        if (this.j == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt(Constant.MAP_KEY_TOP, mapBound.rightTopPt.getIntY());
        return this.j.getZoomToBoundF(bundle);
    }

    public double getZoomUnitsInMeter() {
        MapController mapController = this.j;
        if (mapController != null) {
            return mapController.getZoomUnitsInMeter();
        }
        return 0.0d;
    }

    public boolean inRangeOfView(float f2, float f3) {
        float f4 = 0;
        return f2 >= f4 && f2 <= ((float) (this.s + 0)) && f3 >= f4 && f3 <= ((float) (this.t + 0));
    }

    public synchronized boolean insertOverlay(Overlay overlay, int i) {
        MapController mapController;
        if ((overlay instanceof InnerOverlay) && (mapController = this.j) != null) {
            InnerOverlay innerOverlay = (InnerOverlay) overlay;
            if (innerOverlay.mBaseMap == null) {
                innerOverlay.mBaseMap = mapController.getBaseMap();
            }
            this.r.add(overlay);
            this.k.a(innerOverlay);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        return this.g;
    }

    public boolean isPredictTraffic() {
        return this.E > 0 || this.F > 0 || this.G > 0;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        return this.e;
    }

    public boolean isSetBackgroundDraw() {
        MapController mapController = this.j;
        if (mapController == null) {
            return false;
        }
        return mapController.isSetBackgroundDraw();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        return this.f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        return this.d;
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
    }

    public void onBackground() {
        onBackground(false);
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        super.onDetachedFromWindow();
    }

    public void onForeground() {
        onForeground(false);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this != view || keyEvent.getAction() != 0) {
            return false;
        }
        switch (i) {
            case 19:
                this.j.scrollBy(0, -50);
                break;
            case 20:
                this.j.scrollBy(0, 50);
                break;
            case 21:
                this.j.scrollBy(-50, 0);
                break;
            case 22:
                this.j.scrollBy(50, 0);
                break;
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int i) {
        n nVar;
        if (i == 1) {
            requestRender();
            return;
        }
        if (i == 0) {
            if (getRenderMode() != 0) {
                setRenderMode(0);
            }
        } else {
            if (i != 2 || (nVar = this.y) == null) {
                return;
            }
            nVar.a();
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public void onPause() {
        if (this.h) {
            return;
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onPause");
        }
        j jVar = this.m;
        if (jVar != null) {
            jVar.b();
        }
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.onPause();
        }
        Iterator<m> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
        super.onPause();
        this.h = true;
    }

    public void onRecycle() {
        MapController mapController = this.j;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        this.j.getBaseMap().ResetImageRes();
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
        requestRender();
    }

    @Override // com.baidu.platform.comapi.map.t
    public void onResume() {
        if (this.h) {
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onResume isInited = " + this.o);
            }
            if (this.o) {
                j jVar = this.m;
                if (jVar != null) {
                    jVar.c();
                }
                MapController mapController = this.j;
                if (mapController != null) {
                    mapController.onResume();
                }
                Iterator<m> it = this.u.iterator();
                while (it.hasNext()) {
                    it.next().a(this);
                }
                setRenderMode(1);
                super.onResume();
                this.h = false;
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.B = i;
        this.C = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0083  */
    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        List<v> list;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.D = false;
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (!(x >= 0.0f && x <= this.B && y >= 0.0f && y <= this.C) && !this.D && (bVar = this.A) != null && (list = bVar.v) != null) {
                for (v vVar : list) {
                    if (vVar != null) {
                        vVar.a(this.A.y());
                        this.D = true;
                    }
                }
            }
        }
        MapStatus mapStatus = getMapStatus();
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int x2 = (int) motionEvent.getX(i);
            int y2 = (int) motionEvent.getY(i);
            if (mapStatus != null) {
                MapStatus.WinRound winRound = mapStatus.winRound;
                if (x2 < winRound.left || x2 > winRound.right || y2 < winRound.top || y2 > winRound.bottom) {
                    if (motionEvent.getAction() != 262 && motionEvent.getAction() != 6) {
                        return false;
                    }
                }
            }
        }
        try {
            GestureDetector gestureDetector = this.x;
            if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
            MapController mapController = this.j;
            if (mapController != null) {
                if (mapController.handleTouchEvent(motionEvent)) {
                    return true;
                }
            }
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void queueEvent(Runnable runnable) {
        super.queueEvent(runnable);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void refresh(Overlay overlay) {
        if (overlay == null || this.j == null) {
            return;
        }
        if (overlay instanceof ItemizedOverlay) {
            ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
            if (itemizedOverlay.b()) {
                if (itemizedOverlay.getAllItem().size() <= 0) {
                    this.j.getBaseMap().ClearLayer(overlay.mLayerID);
                    this.j.getBaseMap().ShowLayers(overlay.mLayerID, false);
                    this.j.getBaseMap().UpdateLayers(overlay.mLayerID);
                } else {
                    this.j.getBaseMap().ShowLayers(overlay.mLayerID, true);
                    this.j.getBaseMap().UpdateLayers(overlay.mLayerID);
                }
                itemizedOverlay.b(false);
            }
        }
        MapController mapController = this.j;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        this.j.getBaseMap().UpdateLayers(overlay.mLayerID);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeBmLayer(BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.j;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                baseMap.removeBmLayer(bmLayer.getNativeInstance());
                synchronized (this) {
                    this.q.remove(bmLayer);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeOverlay(Overlay overlay) {
        if (overlay != null) {
            MapController mapController = this.j;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                baseMap.ClearLayer(overlay.mLayerID);
                baseMap.ShowLayers(overlay.mLayerID, false);
                baseMap.UpdateLayers(overlay.mLayerID);
                baseMap.RemoveLayer(overlay.mLayerID);
                synchronized (this) {
                    if (overlay instanceof ItemizedOverlay) {
                        this.r.remove(overlay);
                    } else if (overlay instanceof InnerOverlay) {
                        this.r.remove(overlay);
                        this.k.a(overlay);
                    }
                    overlay.mLayerID = 0L;
                }
                return true;
            }
        }
        return false;
    }

    public void removeSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.w.b(simpleOnGestureListener);
    }

    public void removeStateListener(m mVar) {
        if (mVar != null) {
            this.u.remove(mVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void requestRender() {
        super.requestRender();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String str) {
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.saveScreenToLocal(str);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean z) {
        if (this.j != null) {
            this.g = z;
        }
        c.submit(new e(z));
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.b bVar) {
        this.A = bVar;
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void setDebugFlags(int i) {
        super.setDebugFlags(i);
    }

    public void setDefaultLocationLayerData(List<OverlayLocationData> list) {
        this.n.setLocationLayerData(list);
    }

    public void setFPS(int i) {
        this.f4217a.setFPS(i);
    }

    public void setFirstFrameListener(com.baidu.platform.comapi.map.d dVar) {
        j jVar = this.m;
        if (jVar != null) {
            jVar.a(dVar);
        }
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.x = gestureDetector;
    }

    public boolean setItsPreTime(int i, int i2, int i3) {
        AppBaseMap baseMap;
        if (this.E == i && this.F == i2 && this.G == i3) {
            return true;
        }
        MapController mapController = this.j;
        if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        this.E = i;
        this.F = i2;
        this.G = i3;
        return baseMap.SetItsPreTime(i, i2, i3);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint geoPoint) {
        MapController mapController = this.j;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.j.setMapStatus(mapStatus);
        }
    }

    public void setMapController(MapController mapController) {
        if (this.j != null) {
            return;
        }
        this.j = mapController;
        this.m.a(mapController.getBaseMap());
        this.m.a(true);
        p pVar = new p(this.j.getBaseMap());
        this.k = pVar;
        this.j.setOverlayMapCallBack(pVar);
        this.j.setMapViewInterface(this);
        b();
        this.j.setMapRenderModeChangeListener(this);
        this.o = true;
        this.l = new h(this.j);
        this.w.a(this.j);
    }

    public void setMapRenderStableListener(n nVar) {
        this.y = nVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus mapStatus) {
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.setMapStatus(mapStatus);
        }
    }

    public void setOnLongPressListener(OnLongPressListener onLongPressListener) {
        this.w.a(onLongPressListener);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int i) {
        MapController mapController = this.j;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.overlooking = i;
            this.j.setMapStatus(mapStatus);
        }
    }

    public void setPixelFormatTransparent(boolean z) {
        if (z) {
            getHolder().setFormat(-3);
        } else {
            getHolder().setFormat(-1);
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void setRenderMode(int i) {
        super.setRenderMode(i);
    }

    @Override // com.baidu.platform.comapi.map.t
    public /* bridge */ /* synthetic */ void setRenderer(SurfaceRenderer surfaceRenderer) {
        super.setRenderer(surfaceRenderer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int i) {
        MapController mapController = this.j;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.rotation = i;
            this.j.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean z) {
        if (this.j != null) {
            this.e = z;
        }
        c.submit(new a());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean z) {
        if (this.j != null) {
            this.f = z;
        }
        c.submit(new d());
    }

    public void setSupBackgroundDraw(boolean z) {
        MapController mapController = this.j;
        if (mapController == null) {
            return;
        }
        mapController.setSupBackgroundDraw(z);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean z) {
        if (this.d == z) {
            return;
        }
        if (this.j != null) {
            this.d = z;
        }
        c.submit(new c());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound winRound) {
        MapController mapController = this.j;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.winRound = winRound;
            this.j.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(float f2) {
        if (this.j == null) {
            return;
        }
        getController().getFocusedBaseIndoorMapInfo();
        if (f2 < 4.0f) {
            f2 = 4.0f;
        } else {
            float f3 = 22;
            if (f2 > f3) {
                f2 = f3;
            }
        }
        MapStatus mapStatus = getMapStatus();
        if (mapStatus != null) {
            mapStatus.level = f2;
            animateTo(mapStatus, 300);
        }
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        j jVar = this.m;
        if (jVar != null) {
            jVar.v = i2;
            jVar.w = i3;
            jVar.x = 0;
        }
        this.s = i2;
        this.t = i3;
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        if (this.j != null) {
            MapStatus mapStatus = getMapStatus();
            if (mapStatus != null) {
                MapStatus.WinRound winRound = mapStatus.winRound;
                winRound.left = 0;
                winRound.top = 0;
                winRound.bottom = i3;
                winRound.right = i2;
                if (this.p) {
                    this.p = false;
                    this.j.setMapStatusWithAnimation(mapStatus, 4, 0);
                } else {
                    this.j.setMapStatus(mapStatus, false);
                }
                if (this.j.getMapViewSurfaceListener() != null) {
                    this.j.getMapViewSurfaceListener().onSurfaceChanged(i2, i3);
                }
            }
            MapStatus mapStatus2 = getMapStatus();
            MapStatus.WinRound winRound2 = mapStatus2.winRound;
            int iAbs = Math.abs(winRound2.right - winRound2.left);
            MapStatus.WinRound winRound3 = mapStatus2.winRound;
            int iAbs2 = Math.abs(winRound3.bottom - winRound3.top);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("MapSurfaceView winRoundWidth = " + iAbs + ";winRoundHeight = " + iAbs2 + ";mWidth = " + this.s + ";mHeight = " + this.t);
            }
            if (iAbs > 0 && iAbs2 > 0) {
                this.s = iAbs;
                this.t = iAbs2;
            }
            this.j.setScreenSize(this.s, this.t);
            if (this.j.isNaviMode() && this.j.getNaviMapViewListener() != null) {
                this.j.getNaviMapViewListener().resizeScreen(i2, i3);
            }
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.A;
        if (bVar != null) {
            bVar.b(this.s, this.t);
        }
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        super.surfaceCreated(surfaceHolder);
        if (surfaceHolder == null || surfaceHolder.getSurface().isValid()) {
            return;
        }
        surfaceDestroyed(surfaceHolder);
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.updateDrawFPS();
        }
        super.surfaceDestroyed(surfaceHolder);
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback2
    @Deprecated
    public /* bridge */ /* synthetic */ void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        super.surfaceRedrawNeeded(surfaceHolder);
    }

    @Override // com.baidu.platform.comapi.map.t, android.view.SurfaceHolder.Callback2
    @TargetApi(26)
    public /* bridge */ /* synthetic */ void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        super.surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay overlay, Overlay overlay2) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || overlay2 == null || (mapController = this.j) == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        return baseMap.SwitchLayer(overlay.mLayerID, overlay2.mLayerID);
    }

    public void unInit() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.A;
        if (bVar != null) {
            List<v> list = bVar.v;
            if (list != null) {
                for (v vVar : list) {
                    if (vVar != null) {
                        vVar.a();
                    }
                }
            }
            this.A.h();
            this.A = null;
        }
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.unInit();
        }
        this.j = null;
        p pVar = this.k;
        if (pVar != null) {
            pVar.a();
        }
        this.k = null;
        this.l = null;
        this.m = null;
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap surfaceView unInit");
        }
    }

    @Override // com.baidu.platform.comapi.map.t
    public r a(s.a aVar, boolean z, Context context) {
        r rVarA = super.a(aVar, z, context);
        if (rVarA instanceof com.baidu.platform.comapi.map.e) {
            com.baidu.platform.comapi.map.e eVar = (com.baidu.platform.comapi.map.e) rVarA;
            if (this.z) {
                eVar.a(new f(this, null));
            }
        }
        return rVarA;
    }

    public void b() {
        MapController mapController = this.j;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        a();
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, int i, int i2, Bitmap.Config config) {
        this.m.a(captureMapViewListener, i, i2, config);
    }

    public void onBackground(boolean z) {
        if (z || !this.i) {
            MapController mapController = this.j;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.j.getBaseMap().OnBackground();
            }
            this.i = true;
        }
    }

    public void onForeground(boolean z) {
        if (z || this.i) {
            MapController mapController = this.j;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.j.getBaseMap().OnForeground();
            }
            this.i = false;
            if (this.f4217a.getViewType() == s.a.VULKAN) {
                j jVar = this.m;
                if (jVar != null) {
                    jVar.c();
                }
                super.onResume();
            }
        }
    }

    public synchronized boolean addBmLayerBelow(long j, BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.j;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                synchronized (this) {
                    if (this.q.contains(bmLayer)) {
                        return false;
                    }
                    this.q.add(bmLayer);
                    return baseMap.addBmLayerBelow(j, bmLayer.getNativeInstance(), 1, 0);
                }
            }
        }
        return false;
    }

    public void animateTo(MapStatus mapStatus, int i, int i2) {
        MapController mapController = this.j;
        if (mapController != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i, i2);
        }
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, Rect rect, Bitmap.Config config) {
        if (rect != null) {
            int i = rect.left;
            int i2 = this.t;
            int i3 = rect.bottom;
            int i4 = i2 < i3 ? 0 : i2 - i3;
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (i < 0 || i4 < 0 || iWidth <= 0 || iHeight <= 0) {
                return;
            }
            if (iWidth > this.s) {
                iWidth = Math.abs(rect.width()) - (rect.right - this.s);
            }
            int i5 = iWidth;
            int iAbs = iHeight > this.t ? Math.abs(rect.height()) - (rect.bottom - this.t) : iHeight;
            if (i > com.baidu.mapapi.common.SysOSUtil.getScreenSizeX() || i4 > com.baidu.mapapi.common.SysOSUtil.getScreenSizeY()) {
                return;
            }
            this.m.a(captureMapViewListener, i, i4, i5, iAbs, config);
            requestRender();
        }
    }

    public synchronized Overlay getOverlay(Class<?> cls) {
        for (Overlay overlay : this.r) {
            if (overlay.getClass() == cls) {
                return overlay;
            }
        }
        return null;
    }

    public void saveScreenToLocal(String str, Rect rect) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.A;
        if (bVar == null || bVar.i() == null) {
            return;
        }
        String string = null;
        if (rect != null) {
            int i = rect.left;
            int i2 = this.t;
            int i3 = rect.bottom;
            int i4 = i2 < i3 ? 0 : i2 - i3;
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (i < 0 || i4 < 0 || iWidth <= 0 || iHeight <= 0) {
                return;
            }
            if (iWidth > this.s) {
                iWidth = Math.abs(rect.width()) - (rect.right - this.s);
            }
            if (iHeight > this.t) {
                iHeight = Math.abs(rect.height()) - (rect.bottom - this.t);
            }
            if (i <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeX() && i4 <= com.baidu.mapapi.common.SysOSUtil.getScreenSizeY()) {
                if (iWidth != 0 && iHeight != 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("x", i);
                        jSONObject.put("y", i4);
                        jSONObject.put("width", iWidth);
                        jSONObject.put("height", iHeight);
                        string = jSONObject.toString();
                    } catch (Exception unused) {
                    }
                }
                this.A.i().SaveScreenToLocal(str, string);
                return;
            }
            this.A.i().SaveScreenToLocal(str, null);
            return;
        }
        this.A.i().SaveScreenToLocal(str, null);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound, int i, int i2) {
        if (this.j == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt(Constant.MAP_KEY_TOP, mapBound.rightTopPt.getIntY());
        return this.j.getZoomToBound(bundle, i, i2);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(int i) {
        setZoomLevel(i);
    }

    @Override // com.baidu.platform.comapi.map.t
    public void a(Context context, s.a aVar, boolean z) {
        super.a(context, aVar, z);
        setBackgroundColor(Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 240));
        setPixelFormatTransparent(false);
        this.w = new x();
        this.x = new GestureDetector(context, this.w);
        j jVar = new j((WeakReference<MapSurfaceView>) new WeakReference(this), this);
        this.m = jVar;
        setRenderer(jVar);
        setRenderMode(1);
        this.w.a(new g(this, null));
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap surfaceView initView");
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound) {
        SysOSUtil sysOSUtil = SysOSUtil.getInstance();
        return getZoomToBoundF(mapBound, sysOSUtil.getScreenWidth(), sysOSUtil.getScreenHeight());
    }

    public void a() {
        MapController mapController = this.j;
        if (mapController == null || mapController.getBaseMap() == null || this.k == null) {
            return;
        }
        this.r.clear();
        this.k.a();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound geoBound) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean z) {
    }

    public MapSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = false;
        this.p = true;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = 0;
        this.t = 0;
        this.u = new HashSet<>();
        this.v = true;
        this.z = true;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        b++;
    }

    public MapSurfaceView(Context context, s.a aVar) {
        super(context, aVar);
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = false;
        this.p = true;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = 0;
        this.t = 0;
        this.u = new HashSet<>();
        this.v = true;
        this.z = true;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        b++;
    }

    public MapSurfaceView(Context context, s.a aVar, boolean z) {
        super(context, aVar, z);
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = false;
        this.p = true;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = 0;
        this.t = 0;
        this.u = new HashSet<>();
        this.v = true;
        this.z = true;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        b++;
    }

    public MapSurfaceView(Context context, boolean z) {
        super(context, z);
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = false;
        this.p = true;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = 0;
        this.t = 0;
        this.u = new HashSet<>();
        this.v = true;
        this.z = true;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        b++;
    }
}
