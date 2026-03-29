package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.heytap.mcssdk.constant.MessageConstant;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MapTextureView extends GLTextureView implements MapRenderModeChangeListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, MapViewInterface, u {
    private boolean A;
    private d B;
    private float C;
    private float D;
    private boolean E;
    protected com.baidu.mapsdkplatform.comapi.map.b o;
    protected MapController p;
    protected p q;
    protected h r;
    protected j s;
    int t;
    int u;
    private List<BmLayer> v;
    protected List<Overlay> w;
    protected n x;
    protected x y;
    protected GestureDetector z;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements GLSurfaceView.EGLContextFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4178a;

        private b() {
            this.f4178a = 12440;
        }

        public String a(String str, int i) {
            return str + " failed: " + a(i);
        }

        public void b(String str, int i) {
            throw new RuntimeException(a(str, i));
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.f4178a, 2, 12344});
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (eGLContext == null || eGLDisplay == null) {
                return;
            }
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                b("eglDestroyContex", egl10.eglGetError());
            }
            MapTextureView.this.onRecycle();
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

        private String b(int i) {
            return "0x" + Integer.toHexString(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends GestureDetector.SimpleOnGestureListener {
        private c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            GeoPoint geoPointFromPixels;
            super.onLongPress(motionEvent);
            MapController mapController = MapTextureView.this.p;
            if (mapController == null || mapController.getBaseMap() == null) {
                return;
            }
            MapController mapController2 = MapTextureView.this.p;
            if (mapController2.mIsMapLoadFinish) {
                String strGetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), MapTextureView.this.p.nearlyRadius);
                if (strGetNearlyObjID == null || strGetNearlyObjID.equals("")) {
                    MapTextureView mapTextureView = MapTextureView.this;
                    if (mapTextureView.p.mListeners != null) {
                        geoPointFromPixels = mapTextureView.getProjection() != null ? MapTextureView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                        if (geoPointFromPixels == null) {
                            return;
                        }
                        for (v vVar : MapTextureView.this.p.mListeners) {
                            if (vVar != null) {
                                vVar.d(geoPointFromPixels);
                            }
                        }
                        return;
                    }
                    return;
                }
                MapTextureView mapTextureView2 = MapTextureView.this;
                if (mapTextureView2.p.mListeners != null) {
                    geoPointFromPixels = mapTextureView2.getProjection() != null ? MapTextureView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                    for (v vVar2 : MapTextureView.this.p.mListeners) {
                        if (vVar2 != null) {
                            if (vVar2.a(strGetNearlyObjID)) {
                                MapTextureView.this.p.mHasMapObjDraging = true;
                            } else if (geoPointFromPixels != null) {
                                vVar2.d(geoPointFromPixels);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(int i);
    }

    public MapTextureView(Context context) {
        super(context);
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.A = true;
        this.E = false;
        a(context);
    }

    private void a(Context context) {
        setEGLContextClientVersion(3);
        this.y = new x();
        this.z = new GestureDetector(context, this.y);
        this.y.a(new c());
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap surfaceView initView");
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayer(BmLayer bmLayer) {
        return a(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayerBelow(Overlay overlay, BmLayer bmLayer) {
        return overlay != null ? a(overlay.mLayerID, bmLayer) : a(0L, bmLayer);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addOverlay(Overlay overlay) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || (mapController = this.p) == null || (baseMap = mapController.getBaseMap()) == null) {
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
            this.w.add(overlay);
            this.q.a(innerOverlay);
            return true;
        }
        if (overlay instanceof ItemizedOverlay) {
            ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
            long jAddLayer = baseMap.AddLayer(itemizedOverlay.getUpdateType(), 0, MapController.ITEM_LAYER_TAG);
            overlay.mLayerID = jAddLayer;
            if (jAddLayer == 0) {
                return false;
            }
            this.w.add(overlay);
            itemizedOverlay.c();
            baseMap.SetLayersClickable(overlay.mLayerID, true);
            baseMap.ShowLayers(overlay.mLayerID, true);
            baseMap.UpdateLayers(overlay.mLayerID);
            return true;
        }
        return false;
    }

    public void animateTo(MapStatus mapStatus, int i) {
        MapController mapController = this.p;
        if (mapController != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i);
        }
    }

    public void attachBaseMapController(MapController mapController) {
        j jVar = new j(this, this);
        this.s = jVar;
        this.p = mapController;
        jVar.a(mapController.getBaseMap());
        setEGLContextFactory(new b());
        setRenderer(this.s);
        setRenderMode(0);
        this.s.a(true);
        setPreserveEGLContextOnPause(true);
        p pVar = new p(this.p.getBaseMap());
        this.q = pVar;
        this.p.setOverlayMapCallBack(pVar);
        this.p.setMapViewInterface(this);
        e();
        this.p.setMapRenderModeChangeListener(this);
        this.r = new h(this.p);
        this.y.a(this.p);
    }

    public void d() {
        MapController mapController = this.p;
        if (mapController == null || mapController.getBaseMap() == null || this.q == null) {
            return;
        }
        this.w.clear();
        this.q.a();
    }

    public void destroyForMultiViews() {
        MapController mapController = this.p;
        if (mapController != null) {
            mapController.unInitForMultiTextureView();
            this.p = null;
        }
        p pVar = this.q;
        if (pVar != null) {
            pVar.a();
            this.q = null;
        }
        this.r = null;
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, int i, int i2, Bitmap.Config config) {
        this.s.a(captureMapViewListener, i, i2, config);
    }

    public void e() {
        MapController mapController = this.p;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        d();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        return false;
    }

    public com.baidu.mapsdkplatform.comapi.map.b getBaseMap() {
        return this.o;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<BmLayer> getBmlayers() {
        return this.v;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        return this.p;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        MapController mapController = this.p;
        if (mapController != null) {
            return mapController.getCurrentMapStatus();
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getCurrentZoomLevel() {
        MapController mapController = this.p;
        if (mapController != null) {
            return mapController.getCurrentZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        MapController mapController = this.p;
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
        MapController mapController = this.p;
        if (mapController == null) {
            return null;
        }
        MapStatus mapStatus = mapController.getMapStatus();
        return new GeoPoint(mapStatus.centerPtY, mapStatus.centerPtX);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getMapRotation() {
        MapController mapController = this.p;
        if (mapController == null) {
            return 0;
        }
        return mapController.getMapStatus().rotation;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getMapStatus() {
        MapController mapController = this.p;
        if (mapController != null) {
            return mapController.getMapStatus();
        }
        return null;
    }

    public synchronized Overlay getOverlay(int i) {
        for (Overlay overlay : this.w) {
            if (overlay.mType == i) {
                return overlay;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<Overlay> getOverlays() {
        return this.w;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public double getOverlooking() {
        MapController mapController = this.p;
        if (mapController == null) {
            return 0.0d;
        }
        return mapController.getMapStatus().overlooking;
    }

    public Overlay getPopupOverlay() {
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public Projection getProjection() {
        return this.r;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        MapController mapController = this.p;
        if (mapController == null) {
            return null;
        }
        return mapController.getMapStatus().winRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomLevel() {
        MapController mapController = this.p;
        if (mapController != null) {
            return mapController.getZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound) {
        return getZoomToBound(mapBound, this.t, this.u);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound, int i, int i2) {
        if (this.p == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt(Constant.MAP_KEY_TOP, mapBound.rightTopPt.getIntY());
        return this.p.getZoomToBoundF(bundle);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        return false;
    }

    public boolean isSetBackgroundDraw() {
        MapController mapController = this.p;
        if (mapController == null) {
            return false;
        }
        return mapController.isSetBackgroundDraw();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        return false;
    }

    public void listenMapRenderMessage(d dVar) {
        this.B = dVar;
    }

    public void onBackground() {
        onBackground(false);
    }

    public void onDestroy() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.o;
        if (bVar != null) {
            List<v> list = bVar.v;
            if (list != null) {
                for (v vVar : list) {
                    if (vVar != null) {
                        vVar.a();
                    }
                }
            }
            this.o.h();
            this.o = null;
        }
        this.p.unInit();
        this.p = null;
        this.q.a();
        this.q = null;
        this.r = null;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onForeground() {
        onForeground(false);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        GeoPoint geoPointFromPixels;
        MapController mapController = this.p;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        MapController mapController2 = this.p;
        if (mapController2.mIsMapLoadFinish) {
            String strGetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), this.p.nearlyRadius);
            if (strGetNearlyObjID == null || strGetNearlyObjID.equals("")) {
                if (this.p.mListeners != null) {
                    geoPointFromPixels = getProjection() != null ? getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                    if (geoPointFromPixels == null) {
                        return;
                    }
                    for (v vVar : this.p.mListeners) {
                        if (vVar != null) {
                            vVar.d(geoPointFromPixels);
                        }
                    }
                    return;
                }
                return;
            }
            if (this.p.mListeners != null) {
                geoPointFromPixels = getProjection() != null ? getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()) : null;
                for (v vVar2 : this.p.mListeners) {
                    if (vVar2 != null) {
                        if (vVar2.a(strGetNearlyObjID)) {
                            this.p.mHasMapObjDraging = true;
                        } else if (geoPointFromPixels != null) {
                            vVar2.d(geoPointFromPixels);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int i) {
        n nVar;
        d dVar = this.B;
        if (dVar != null) {
            dVar.a(i);
        }
        if (i == 1) {
            requestRender();
            return;
        }
        if (i == 0) {
            if (getRenderMode() != 0) {
                setRenderMode(0);
            }
        } else {
            if (i != 2 || (nVar = this.x) == null) {
                return;
            }
            nVar.a();
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onPause() {
        MapController mapController = this.p;
        if (mapController != null && mapController.getBaseMap() != null) {
            this.p.getBaseMap().OnPause();
        }
        super.onPause();
    }

    public void onRecycle() {
        MapController mapController = this.p;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        this.p.getBaseMap().ResetImageRes();
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onResume() {
        MapController mapController = this.p;
        if (mapController != null && mapController.getBaseMap() != null) {
            this.p.getBaseMap().OnResume();
        }
        super.onResume();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.C = i;
        this.D = i2;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        this.t = i;
        this.u = i2;
        MapController mapController = this.p;
        if (mapController != null) {
            if (mapController.getMapViewSurfaceListener() != null) {
                this.p.getMapViewSurfaceListener().onSurfaceChanged(i, i2);
            }
            MapStatus mapStatus = getMapStatus();
            MapStatus.WinRound winRound = mapStatus.winRound;
            this.t = Math.abs(winRound.right - winRound.left);
            MapStatus.WinRound winRound2 = mapStatus.winRound;
            this.u = Math.abs(winRound2.bottom - winRound2.top);
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.o;
        if (bVar != null) {
            bVar.b(this.t, this.u);
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureDestroyed(surfaceTexture);
        return true;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        this.t = i;
        this.u = i2;
        j jVar = this.s;
        jVar.v = i;
        jVar.w = i2;
        jVar.x = 0;
        if (this.p != null) {
            MapStatus mapStatus = getMapStatus();
            MapStatus.WinRound winRound = mapStatus.winRound;
            winRound.left = 0;
            winRound.top = 0;
            winRound.bottom = i2;
            winRound.right = i;
            this.p.setMapStatusWithAnimation(mapStatus, 4, 0);
            if (this.p.getMapViewSurfaceListener() != null) {
                this.p.getMapViewSurfaceListener().onSurfaceChanged(i, i2);
            }
            MapStatus mapStatus2 = getMapStatus();
            MapStatus.WinRound winRound2 = mapStatus2.winRound;
            int iAbs = Math.abs(winRound2.right - winRound2.left);
            MapStatus.WinRound winRound3 = mapStatus2.winRound;
            int iAbs2 = Math.abs(winRound3.bottom - winRound3.top);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("MapTextureView winRoundWidth = " + iAbs + ";winRoundHeight = " + iAbs2 + ";mWidth = " + this.t + ";mHeight = " + this.u);
            }
            if (iAbs > 0 && iAbs2 > 0) {
                this.t = iAbs;
                this.u = iAbs2;
            }
            this.p.setScreenSize(this.t, this.u);
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.o;
        if (bVar != null) {
            bVar.b(this.t, this.u);
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureUpdated(surfaceTexture);
    }

    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        List<v> list;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.E = false;
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (!(x >= 0.0f && x <= this.C && y >= 0.0f && y <= this.D) && !this.E && (bVar = this.o) != null && (list = bVar.v) != null) {
                for (v vVar : list) {
                    if (vVar != null) {
                        vVar.a(this.o.y());
                        this.E = true;
                    }
                }
            }
        }
        MapStatus mapStatus = getMapStatus();
        if (mapStatus == null) {
            return false;
        }
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int x2 = (int) motionEvent.getX(i);
            int y2 = (int) motionEvent.getY(i);
            MapStatus.WinRound winRound = mapStatus.winRound;
            if (x2 < winRound.left || x2 > winRound.right || y2 < winRound.top || y2 > winRound.bottom) {
                return false;
            }
        }
        try {
            GestureDetector gestureDetector = this.z;
            if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
            MapController mapController = this.p;
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

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void refresh(Overlay overlay) {
        if (overlay == null || this.p == null) {
            return;
        }
        if (overlay instanceof ItemizedOverlay) {
            ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
            if (itemizedOverlay.b()) {
                if (itemizedOverlay.getAllItem().size() <= 0) {
                    this.p.getBaseMap().ClearLayer(overlay.mLayerID);
                    this.p.getBaseMap().ShowLayers(overlay.mLayerID, false);
                    this.p.getBaseMap().UpdateLayers(overlay.mLayerID);
                } else {
                    this.p.getBaseMap().ShowLayers(overlay.mLayerID, true);
                    this.p.getBaseMap().UpdateLayers(overlay.mLayerID);
                }
                itemizedOverlay.b(false);
            }
        }
        MapController mapController = this.p;
        if (mapController == null || mapController.getBaseMap() == null) {
            return;
        }
        this.p.getBaseMap().UpdateLayers(overlay.mLayerID);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeBmLayer(BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.p;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                baseMap.removeBmLayer(bmLayer.getNativeInstance());
                synchronized (this) {
                    this.v.remove(bmLayer);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean removeOverlay(Overlay overlay) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || (mapController = this.p) == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        baseMap.ClearLayer(overlay.mLayerID);
        baseMap.ShowLayers(overlay.mLayerID, false);
        baseMap.UpdateLayers(overlay.mLayerID);
        baseMap.RemoveLayer(overlay.mLayerID);
        if (overlay instanceof ItemizedOverlay) {
            this.w.remove(overlay);
        } else if (overlay instanceof InnerOverlay) {
            this.w.remove(overlay);
            this.q.a(overlay);
        }
        overlay.mLayerID = 0L;
        return true;
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.b bVar) {
        this.o = bVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint geoPoint) {
        MapController mapController = this.p;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.p.setMapStatus(mapStatus);
        }
    }

    public void setMapRenderStableListener(n nVar) {
        this.x = nVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus mapStatus) {
        MapController mapController = this.p;
        if (mapController != null) {
            mapController.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int i) {
        MapController mapController = this.p;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.overlooking = i;
            this.p.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int i) {
        MapController mapController = this.p;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.rotation = i;
            this.p.setMapStatus(mapStatus);
        }
    }

    public void setSupBackgroundDraw(boolean z) {
        MapController mapController = this.p;
        if (mapController == null) {
            return;
        }
        mapController.setSupBackgroundDraw(z);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean z) {
        AppBaseMap baseMap;
        MapController mapController = this.p;
        if (mapController == null || (baseMap = mapController.getBaseMap()) == null) {
            return;
        }
        baseMap.ShowTrafficMap(z);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound winRound) {
        MapController mapController = this.p;
        if (mapController != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.winRound = winRound;
            this.p.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(float f) {
        if (this.p == null) {
            return;
        }
        getController().getFocusedBaseIndoorMapInfo();
        if (f < 4.0f) {
            f = 4.0f;
        } else if (f > 22) {
            f = 22.0f;
        }
        MapStatus mapStatus = getMapStatus();
        if (mapStatus != null) {
            mapStatus.level = f;
            animateTo(mapStatus, 300);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay overlay, Overlay overlay2) {
        MapController mapController;
        AppBaseMap baseMap;
        if (overlay == null || overlay2 == null || (mapController = this.p) == null || (baseMap = mapController.getBaseMap()) == null) {
            return false;
        }
        return baseMap.SwitchLayer(overlay.mLayerID, overlay2.mLayerID);
    }

    public void unListenMapRenderMessage() {
        this.B = null;
    }

    public void doCaptureMapView(CaptureMapViewListener captureMapViewListener, Rect rect, Bitmap.Config config) {
        if (rect != null) {
            int i = rect.left;
            int i2 = this.u;
            int i3 = rect.bottom;
            int i4 = i2 < i3 ? 0 : i2 - i3;
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (i < 0 || i4 < 0 || iWidth <= 0 || iHeight <= 0) {
                return;
            }
            if (iWidth > this.t) {
                iWidth = Math.abs(rect.width()) - (rect.right - this.t);
            }
            int i5 = iWidth;
            int iAbs = iHeight > this.u ? Math.abs(rect.height()) - (rect.bottom - this.u) : iHeight;
            if (i > SysOSUtil.getScreenSizeX() || i4 > SysOSUtil.getScreenSizeY()) {
                return;
            }
            this.s.a(captureMapViewListener, i, i4, i5, iAbs, config);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound, int i, int i2) {
        if (this.p == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
        bundle.putInt("right", mapBound.rightTopPt.getIntX());
        bundle.putInt(Constant.MAP_KEY_TOP, mapBound.rightTopPt.getIntY());
        return this.p.getZoomToBound(bundle, i, i2);
    }

    public void onBackground(boolean z) {
        if (z || !this.A) {
            MapController mapController = this.p;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.p.getBaseMap().OnBackground();
            }
            this.A = true;
        }
    }

    public void onForeground(boolean z) {
        if (z || this.A) {
            MapController mapController = this.p;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.p.getBaseMap().OnForeground();
            }
            this.A = false;
        }
    }

    public boolean addBmLayerBelow(long j, BmLayer bmLayer) {
        return a(j, bmLayer);
    }

    public synchronized Overlay getOverlay(Class<?> cls) {
        for (Overlay overlay : this.w) {
            if (overlay.getClass() == cls) {
                return overlay;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(int i) {
        setZoomLevel(i);
    }

    private synchronized boolean a(long j, BmLayer bmLayer) {
        if (bmLayer != null) {
            MapController mapController = this.p;
            if (mapController != null) {
                AppBaseMap baseMap = mapController.getBaseMap();
                if (baseMap == null) {
                    return false;
                }
                synchronized (this) {
                    if (this.v.contains(bmLayer)) {
                        return false;
                    }
                    this.v.add(bmLayer);
                    return baseMap.addBmLayerBelow(j, bmLayer.getNativeInstance(), 1, 0);
                }
            }
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound) {
        return getZoomToBoundF(mapBound, this.t, this.u);
    }

    public MapTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.A = true;
        this.E = false;
        a(context);
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
    }

    public MapTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.A = true;
        this.E = false;
        a(context);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String str) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound geoBound) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean z) {
    }
}
