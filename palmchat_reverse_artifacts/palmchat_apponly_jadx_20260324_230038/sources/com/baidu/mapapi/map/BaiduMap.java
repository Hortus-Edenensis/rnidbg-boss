package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mapapi.NetworkUpdate2MapListener;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.HexagonMap;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.bmsdk.ui.BaseUI;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.Bm3DModel;
import com.baidu.platform.comapi.bmsdk.BmArc;
import com.baidu.platform.comapi.bmsdk.BmBaseLine;
import com.baidu.platform.comapi.bmsdk.BmCircle;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGround;
import com.baidu.platform.comapi.bmsdk.BmIconMarker;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmMultiPoint;
import com.baidu.platform.comapi.bmsdk.BmPolygon;
import com.baidu.platform.comapi.bmsdk.BmPrism;
import com.baidu.platform.comapi.bmsdk.BmTextMarker;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.logstatistics.SDKLogFactory;
import com.baidu.platform.comapi.map.CaptureMapViewListener;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.map.v;
import com.baidu.platform.comapi.map.w;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BaiduMap {
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final float REAL_MAX_ZOOM_LEVEL = 22.0f;
    public static final float REAL_MIN_ZOOM_LEVEL = 4.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3591a = "BaiduMap";
    private static volatile boolean b = false;
    private static volatile boolean c = false;
    public static int mapStatusReason = 256;
    private OnMapLongClickListener A;
    private OnMarkerDragListener K;
    private OnMyLocationClickListener L;
    private SnapshotReadyCallback M;
    private Building3DListener N;
    private CopyOnWriteArrayList<Building> O;
    private OnMapDrawFrameCallback P;
    private OnBaseIndoorMapListener Q;
    private OnMapRenderValidDataListener R;
    private OnHeatMapDrawFrameCallBack S;
    private OnSynchronizationListener T;
    NetworkUpdate2MapListener U;
    private TileOverlay V;
    private HeatMap W;
    private HexagonMap X;
    private Map<String, InfoWindow> b0;
    private Map<InfoWindow, Marker> c0;
    private Projection d;
    private Marker d0;
    private UiSettings e;
    private MyLocationData e0;
    private MapSurfaceView f;
    private MyLocationConfiguration f0;
    private MapTextureView g;
    private OnLocationModeChangeListener g0;
    private com.baidu.mapsdkplatform.comapi.map.b h;
    MapView h0;
    private BmLayer i;
    TextureMapView i0;
    private List<Overlay> j;
    WearMapView j0;
    private List<Marker> k;
    r k0;
    private List<Marker> l;
    private boolean l0;
    private List<InfoWindow> m;
    private boolean m0;
    private Overlay.a n;
    private boolean n0;
    private BaseUI.onBaseUIListener o;
    private boolean o0;
    private HexagonMap.b p;
    private Point p0;
    private InfoWindow.a q;
    private InfoWindowAdapter r;
    private OnMapStatusChangeListener s;
    private com.baidu.mapsdkplatform.comapi.map.z.c s0;
    private OnMapTouchListener t;
    private onMapGestureListener u;
    private OnMapClickListener v;
    private OnMapLoadedCallback w;
    private OnMapTileLoadedCallback x;
    private OnMapRenderCallback y;
    private OnMapDoubleClickListener z;
    private CopyOnWriteArrayList<OnMarkerClickListener> B = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnMarkerWithBaseUIClickListener> C = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnPolylineClickListener> D = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnMultiPointClickListener> E = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnCircleClickListener> F = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnPolygonClickListener> G = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnGroundOverlayClickListener> H = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnTextClickListener> I = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnArcClickListener> J = new CopyOnWriteArrayList<>();
    private Lock Y = new ReentrantLock();
    private Lock Z = new ReentrantLock();
    private Lock a0 = new ReentrantLock();
    private volatile boolean q0 = false;
    private boolean r0 = false;
    private boolean t0 = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface OnArcClickListener {
        boolean onArcClick(Arc arc);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnCircleClickListener {
        boolean onCircleClick(Circle circle);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnGroundOverlayClickListener {
        boolean onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnHeatMapDrawFrameCallBack {
        void frameIndex(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnLocationModeChangeListener {
        void onLocationModeChange(MyLocationConfiguration.LocationMode locationMode);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);

        void onMapPoiClick(MapPoi mapPoi);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMapDoubleClickListener {
        void onMapDoubleClick(LatLng latLng);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMapDrawFrameCallback {
        void onMapDrawFrame(MapStatus mapStatus);

        @Deprecated
        void onMapDrawFrame(GL10 gl10, MapStatus mapStatus);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMapRenderCallback {
        void onMapRenderFinished();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMapRenderValidDataListener {
        void onMapRenderValidData(boolean z, int i, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMapTileLoadedCallback {
        void onFirstMapTileLoaded();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMarkerWithBaseUIClickListener {
        void onMarkerClick(Marker marker);

        void onMarkerClick(Marker marker, BaseUI baseUI);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMultiPointClickListener {
        boolean onMultiPointClick(MultiPoint multiPoint, MultiPointItem multiPointItem);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnMyLocationClickListener {
        boolean onMyLocationClick();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnPolygonClickListener {
        boolean onPolygonClick(Polygon polygon);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnPolylineClickListener {
        boolean onPolylineClick(Polyline polyline);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnSynchronizationListener {
        void onMapStatusChangeReason(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface OnTextClickListener {
        boolean onTextClick(Text text);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements BaseUI.onBaseUIListener {
        public a() {
        }

        @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI.onBaseUIListener
        public void onBaseUIRemove(BaseUI baseUI) {
            if (BaiduMap.this.i != null) {
                BaiduMap.this.i.b();
            }
        }

        @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI.onBaseUIListener
        public void onBaseUIUpdate(BaseUI baseUI) {
            if (BaiduMap.this.i != null) {
                BaiduMap.this.i.b();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements CaptureMapViewListener {
        public b() {
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap bitmap) {
            BaiduMap.this.M.onSnapshotReady(bitmap);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CaptureMapViewListener {
        public c() {
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap bitmap) {
            BaiduMap.this.M.onSnapshotReady(bitmap);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements CaptureMapViewListener {
        public d() {
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap bitmap) {
            BaiduMap.this.M.onSnapshotReady(bitmap);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements CaptureMapViewListener {
        public e() {
        }

        @Override // com.baidu.platform.comapi.map.CaptureMapViewListener
        public void onCompleted(Bitmap bitmap) {
            BaiduMap.this.M.onSnapshotReady(bitmap);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = g.b[BaiduMap.this.k0.ordinal()];
            if (i == 1) {
                if (BaiduMap.this.g != null) {
                    BaiduMap.this.g.requestRender();
                }
            } else if (i == 2 && BaiduMap.this.f != null) {
                BaiduMap.this.f.requestRender();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3598a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[r.values().length];
            b = iArr;
            try {
                iArr[r.TextureView.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[r.GLSurfaceView.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[MyLocationConfiguration.LocationMode.values().length];
            f3598a = iArr2;
            try {
                iArr2[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3598a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3598a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements NetworkUpdate2MapListener {
        public h() {
        }

        @Override // com.baidu.mapapi.NetworkUpdate2MapListener
        public void networkUpdate() {
            if (BaiduMap.this.h == null || !BaiduMap.this.h.L()) {
                return;
            }
            BaiduMap.this.h.Z();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Overlay.a {
        public j() {
        }

        @Override // com.baidu.mapapi.map.Overlay.a
        public void a(Overlay overlay) {
            if (BaiduMap.this.q0) {
                return;
            }
            if (overlay != null && BaiduMap.this.j.contains(overlay)) {
                Bundle bundleA = overlay.a();
                if (BaiduMap.this.h != null) {
                    BaiduMap.this.h.i(bundleA);
                }
                BaiduMap.this.j.remove(overlay);
            }
            if (overlay != null && BaiduMap.this.l.contains(overlay)) {
                BaiduMap.this.l.remove(overlay);
            }
            if (overlay != null && BaiduMap.this.O.contains(overlay)) {
                BaiduMap.this.O.remove(overlay);
            }
            if (overlay == null || !BaiduMap.this.k.contains(overlay)) {
                return;
            }
            Marker marker = (Marker) overlay;
            if (marker.G != null) {
                BaiduMap.this.k.remove(marker);
                if (BaiduMap.this.k.size() != 0 || BaiduMap.this.h == null) {
                    return;
                }
                BaiduMap.this.h.s(false);
            }
        }

        @Override // com.baidu.mapapi.map.Overlay.a
        public boolean b(Overlay overlay) {
            return (BaiduMap.this.j == null || BaiduMap.this.j.contains(overlay)) ? false : true;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d0  */
        @Override // com.baidu.mapapi.map.Overlay.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(Overlay overlay) {
            if (BaiduMap.this.q0) {
                return;
            }
            if (overlay != null && BaiduMap.this.j.contains(overlay)) {
                if (overlay instanceof Marker) {
                    Marker marker = (Marker) overlay;
                    boolean z = true;
                    if (marker.h != null) {
                        ArrayList<BitmapDescriptor> arrayList = marker.G;
                        if (arrayList != null && arrayList.size() > 1) {
                            Bundle bundle = new Bundle();
                            if (BaiduMap.this.h != null && !BaiduMap.this.q0) {
                                marker.remove();
                                marker.G.clear();
                                BaiduMap.this.h.d(overlay.a(bundle));
                                BaiduMap.this.j.add(overlay);
                            }
                            if (BaiduMap.this.h != null && !z && !BaiduMap.this.q0) {
                                if (OverlayUtil.isOverlayUpgrade()) {
                                    BaiduMap.this.h.l(overlay.a(new Bundle()));
                                } else if (overlay instanceof Polyline) {
                                    BaiduMap.this.c(overlay);
                                } else {
                                    BaiduMap.this.h.l(overlay.a(new Bundle()));
                                }
                            }
                        }
                    } else {
                        ArrayList<BitmapDescriptor> arrayList2 = marker.G;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            if (BaiduMap.this.k.contains(marker)) {
                                BaiduMap.this.k.remove(marker);
                            }
                            BaiduMap.this.k.add(marker);
                            if (BaiduMap.this.h != null) {
                                BaiduMap.this.h.s(true);
                            }
                        }
                    }
                    z = false;
                    if (BaiduMap.this.h != null) {
                        if (OverlayUtil.isOverlayUpgrade()) {
                        }
                    }
                } else {
                    z = false;
                    if (BaiduMap.this.h != null) {
                    }
                }
            }
            if (BaiduMap.this.l.contains(overlay)) {
                BaiduMap.this.l.remove(overlay);
            }
            if (BaiduMap.this.O.contains(overlay)) {
                BaiduMap.this.O.remove(overlay);
            }
            if (overlay instanceof Marker) {
                BaiduMap.this.l.add((Marker) overlay);
            }
            if (overlay instanceof Building) {
                BaiduMap.this.O.add((Building) overlay);
            }
        }

        @Override // com.baidu.mapapi.map.Overlay.a
        public LatLngBounds d(Overlay overlay) {
            if (BaiduMap.this.h == null || overlay == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            overlay.a(bundle);
            return BaiduMap.this.h.f(bundle);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements InfoWindow.a {
        public k() {
        }

        @Override // com.baidu.mapapi.map.InfoWindow.a
        public void a(InfoWindow infoWindow) {
            BaiduMap.this.hideInfoWindow(infoWindow);
        }

        @Override // com.baidu.mapapi.map.InfoWindow.a
        public void b(InfoWindow infoWindow) {
            BaiduMap.this.b(infoWindow);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements w {
        public l() {
        }

        @Override // com.baidu.platform.comapi.map.w
        public void a(int i) {
            for (int i2 = 0; i2 < BaiduMap.this.O.size(); i2++) {
                if (((Building) BaiduMap.this.O.get(i2)).getBuildingId() == i) {
                    BaiduMap.this.N.onBuildingFloorAnimationStop((Building) BaiduMap.this.O.get(i2));
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements v {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ InfoWindow f3605a;

            public a(InfoWindow infoWindow) {
                this.f3605a = infoWindow;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3605a.c.setLayoutParams(new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(this.f3605a.d).yOffset(this.f3605a.j).build());
            }
        }

        public m() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.s != null) {
                BaiduMap.this.s.onMapStatusChangeFinish(mapStatusA);
            }
            if (BaiduMap.this.u != null) {
                BaiduMap.this.u.onMapStatusChangeFinish(mapStatusA);
            }
            BaiduMap.mapStatusReason = 0;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(s sVar) {
            if (BaiduMap.this.s != null) {
                BaiduMap.this.s.onMapStatusChange(MapStatus.a(sVar));
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c() {
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean d(Point point, Point point2, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.u.onMapKneading(point, point2, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void e(GeoPoint geoPoint) {
            if (BaiduMap.this.d0 == null || !BaiduMap.this.d0.o) {
                return;
            }
            BaiduMap.this.d0.setPosition(BaiduMap.this.d.fromScreenLocation(new Point(BaiduMap.this.d.toScreenLocation(CoordUtil.mc2ll(geoPoint)).x, r3.y - 60)));
            if (BaiduMap.this.K != null && BaiduMap.this.d0.o) {
                BaiduMap.this.K.onMarkerDragEnd(BaiduMap.this.d0);
            }
            BaiduMap.this.d0 = null;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void f(GeoPoint geoPoint) {
            if (BaiduMap.this.d0 == null || !BaiduMap.this.d0.o) {
                return;
            }
            BaiduMap.this.d0.setPosition(BaiduMap.this.d.fromScreenLocation(new Point(BaiduMap.this.d.toScreenLocation(CoordUtil.mc2ll(geoPoint)).x, r3.y - 60)));
            if (BaiduMap.this.K != null && BaiduMap.this.d0.o) {
                BaiduMap.this.K.onMarkerDragEnd(BaiduMap.this.d0);
            }
            BaiduMap.this.d0 = null;
        }

        @Override // com.baidu.platform.comapi.map.v
        public void g(GeoPoint geoPoint) {
            if (BaiduMap.this.d0 == null || !BaiduMap.this.d0.o) {
                return;
            }
            BaiduMap.this.d0.setPosition(BaiduMap.this.d.fromScreenLocation(new Point(BaiduMap.this.d.toScreenLocation(CoordUtil.mc2ll(geoPoint)).x, r3.y - 60)));
            if (BaiduMap.this.K == null || !BaiduMap.this.d0.o) {
                return;
            }
            BaiduMap.this.K.onMarkerDrag(BaiduMap.this.d0);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void onFirstMapTileLoaded() {
            if (BaiduMap.this.x != null) {
                BaiduMap.this.x.onFirstMapTileLoaded();
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(s sVar) {
            int i = BaiduMap.mapStatusReason;
            int i2 = (i & 256) == 256 ? 3 : (i & 16) == 16 ? 2 : 1;
            if (BaiduMap.this.s != null) {
                MapStatus mapStatusA = MapStatus.a(sVar);
                BaiduMap.this.s.onMapStatusChangeStart(mapStatusA);
                BaiduMap.this.s.onMapStatusChangeStart(mapStatusA, i2);
            }
            if (BaiduMap.this.T != null) {
                BaiduMap.this.T.onMapStatusChangeReason(i2);
            }
            BaiduMap.mapStatusReason = 0;
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean b(Point point, Point point2, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.u.onMapOverLooking(point, point2, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d(GeoPoint geoPoint) {
            if (BaiduMap.this.A != null) {
                BaiduMap.this.A.onMapLongClick(CoordUtil.mc2ll(geoPoint));
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(MotionEvent motionEvent) {
            if (BaiduMap.this.t != null) {
                BaiduMap.this.t.onTouch(motionEvent);
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(GeoPoint geoPoint) {
            if (BaiduMap.this.v != null) {
                BaiduMap.this.v.onMapClick(CoordUtil.mc2ll(geoPoint));
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void d() {
            BaiduMap baiduMap = BaiduMap.this;
            baiduMap.d = new Projection(baiduMap.h);
            BaiduMap.this.o0 = true;
            if (BaiduMap.this.w != null) {
                BaiduMap.this.w.onMapLoaded();
            }
            BaiduMap.this.e();
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point point, Point point2, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.u.onMapTwoClick(point, point2, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean c(Point point, Point point2, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.u.onMapScroll(point, point2, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b() {
            if (BaiduMap.this.y != null) {
                BaiduMap.this.y.onMapRenderFinished();
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(MotionEvent motionEvent, float f, float f2, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.u.onMapFling(motionEvent, f, f2, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void b(String str) {
            JSONObject jSONObjectOptJSONObject;
            String strOptString;
            InfoWindow.OnInfoWindowClickListener onInfoWindowClickListener;
            s sVarY;
            try {
                JSONObject jSONObject = new JSONObject(str);
                GeoPoint geoPointA = BaiduMap.this.h.a(jSONObject.optInt("px"), jSONObject.optInt("py"));
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("dataset");
                int iOptInt = -1;
                if (jSONArrayOptJSONArray != null) {
                    jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
                    if (jSONObjectOptJSONObject != null) {
                        iOptInt = jSONObjectOptJSONObject.optInt(MapBundleKey.MapObjKey.OBJ_TYPE);
                    }
                } else {
                    jSONObjectOptJSONObject = null;
                }
                if (iOptInt == 17) {
                    if (BaiduMap.this.v != null) {
                        MapPoi mapPoi = new MapPoi();
                        mapPoi.a(jSONObjectOptJSONObject);
                        BaiduMap.this.v.onMapPoiClick(mapPoi);
                        return;
                    }
                    return;
                }
                if (iOptInt == 18) {
                    if (BaiduMap.this.L != null) {
                        BaiduMap.this.L.onMyLocationClick();
                        return;
                    } else {
                        b(geoPointA);
                        return;
                    }
                }
                if (iOptInt == 19) {
                    if (BaiduMap.this.h == null || (sVarY = BaiduMap.this.h.y()) == null) {
                        return;
                    }
                    sVarY.c = 0;
                    sVarY.b = 0;
                    BaiduMap.mapStatusReason |= 16;
                    BaiduMap.this.h.a(sVarY, 300);
                    return;
                }
                if (iOptInt == 6002) {
                    if (BaiduMap.this.v != null) {
                        MapPoi mapPoi2 = new MapPoi();
                        mapPoi2.a(jSONObjectOptJSONObject);
                        BaiduMap.this.v.onMapPoiClick(mapPoi2);
                        return;
                    }
                    return;
                }
                if (iOptInt == 90909) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("marker_id") : "";
                    Set<String> setKeySet = BaiduMap.this.b0.keySet();
                    if (setKeySet.isEmpty() || !setKeySet.contains(strOptString)) {
                        for (Overlay overlay : BaiduMap.this.j) {
                            if ((overlay instanceof Marker) && overlay.f3666a.equals(strOptString)) {
                                if (!BaiduMap.this.B.isEmpty()) {
                                    Iterator it = BaiduMap.this.B.iterator();
                                    while (it.hasNext()) {
                                        ((OnMarkerClickListener) it.next()).onMarkerClick((Marker) overlay);
                                    }
                                    return;
                                }
                                b(geoPointA);
                            }
                        }
                        return;
                    }
                    for (String str2 : setKeySet) {
                        if (str2 != null && str2.equals(strOptString)) {
                            InfoWindow infoWindow = (InfoWindow) BaiduMap.this.b0.get(str2);
                            if (infoWindow != null && (onInfoWindowClickListener = infoWindow.h) != null) {
                                onInfoWindowClickListener.onInfoWindowClick();
                                return;
                            } else {
                                b(geoPointA);
                                return;
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90910) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("polyline_id") : "";
                    for (Overlay overlay2 : BaiduMap.this.j) {
                        if ((overlay2 instanceof Polyline) && overlay2.f3666a.equals(strOptString)) {
                            if (!BaiduMap.this.D.isEmpty()) {
                                Iterator it2 = BaiduMap.this.D.iterator();
                                while (it2.hasNext()) {
                                    ((OnPolylineClickListener) it2.next()).onPolylineClick((Polyline) overlay2);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90911) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("multipoint_id") : "";
                    for (Overlay overlay3 : BaiduMap.this.j) {
                        if ((overlay3 instanceof MultiPoint) && overlay3.f3666a.equals(strOptString)) {
                            if (!BaiduMap.this.E.isEmpty()) {
                                for (OnMultiPointClickListener onMultiPointClickListener : BaiduMap.this.E) {
                                    MultiPoint multiPoint = (MultiPoint) overlay3;
                                    List<MultiPointItem> multiPointItems = multiPoint.getMultiPointItems();
                                    if (jSONObjectOptJSONObject != null) {
                                        int iOptInt2 = jSONObjectOptJSONObject.optInt("multipoint_index");
                                        if (multiPointItems != null && iOptInt2 >= 0 && multiPointItems.size() > iOptInt2) {
                                            onMultiPointClickListener.onMultiPointClick(multiPoint, multiPointItems.get(iOptInt2));
                                        }
                                    }
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90912) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("overlay_id") : "";
                    for (Overlay overlay4 : BaiduMap.this.j) {
                        if ((overlay4 instanceof Polygon) && overlay4.f3666a.equals(strOptString)) {
                            if (!BaiduMap.this.G.isEmpty()) {
                                for (OnPolygonClickListener onPolygonClickListener : BaiduMap.this.G) {
                                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("hole_clicked_index")) {
                                        ((Polygon) overlay4).w = jSONObjectOptJSONObject.optInt("hole_clicked_index");
                                    }
                                    onPolygonClickListener.onPolygonClick((Polygon) overlay4);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90914) {
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString2 = jSONObjectOptJSONObject.optString("overlay_id");
                        for (Overlay overlay5 : BaiduMap.this.j) {
                            if ((overlay5 instanceof Circle) && overlay5.f3666a.equals(strOptString2)) {
                                if (!BaiduMap.this.F.isEmpty()) {
                                    for (OnCircleClickListener onCircleClickListener : BaiduMap.this.F) {
                                        if (jSONObjectOptJSONObject.has("hole_clicked_index")) {
                                            ((Circle) overlay5).q = jSONObjectOptJSONObject.optInt("hole_clicked_index");
                                        }
                                        onCircleClickListener.onCircleClick((Circle) overlay5);
                                    }
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                        return;
                    }
                    return;
                }
                if (iOptInt == 90915) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("overlay_id") : "";
                    for (Overlay overlay6 : BaiduMap.this.j) {
                        if ((overlay6 instanceof GroundOverlay) && overlay6.f3666a.equals(strOptString)) {
                            if (!BaiduMap.this.H.isEmpty()) {
                                Iterator it3 = BaiduMap.this.H.iterator();
                                while (it3.hasNext()) {
                                    ((OnGroundOverlayClickListener) it3.next()).onGroundOverlayClick((GroundOverlay) overlay6);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90916) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("overlay_id") : "";
                    for (Overlay overlay7 : BaiduMap.this.j) {
                        if ((overlay7 instanceof Text) && overlay7.f3666a.equals(strOptString)) {
                            if (!BaiduMap.this.I.isEmpty()) {
                                Iterator it4 = BaiduMap.this.I.iterator();
                                while (it4.hasNext()) {
                                    ((OnTextClickListener) it4.next()).onTextClick((Text) overlay7);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90917) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("overlay_id") : "";
                    for (Overlay overlay8 : BaiduMap.this.j) {
                        if ((overlay8 instanceof Arc) && overlay8.f3666a.equals(strOptString)) {
                            if (!BaiduMap.this.J.isEmpty()) {
                                Iterator it5 = BaiduMap.this.J.iterator();
                                while (it5.hasNext()) {
                                    ((OnArcClickListener) it5.next()).onArcClick((Arc) overlay8);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                    return;
                }
                if (iOptInt == 90918) {
                    strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("overlay_id") : "";
                    for (Overlay overlay9 : BaiduMap.this.j) {
                        if ((overlay9 instanceof Polyline) && overlay9.f3666a.equals(strOptString)) {
                            if (!BaiduMap.this.D.isEmpty()) {
                                Iterator it6 = BaiduMap.this.D.iterator();
                                while (it6.hasNext()) {
                                    ((OnPolylineClickListener) it6.next()).onPolylineClick((Polyline) overlay9);
                                }
                            } else {
                                b(geoPointA);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void c(GeoPoint geoPoint) {
            if (BaiduMap.this.d0 == null || !BaiduMap.this.d0.o) {
                return;
            }
            BaiduMap.this.d0.setPosition(BaiduMap.this.d.fromScreenLocation(new Point(BaiduMap.this.d.toScreenLocation(CoordUtil.mc2ll(geoPoint)).x, r3.y - 60)));
            if (BaiduMap.this.K == null || !BaiduMap.this.d0.o) {
                return;
            }
            BaiduMap.this.K.onMarkerDrag(BaiduMap.this.d0);
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(Point point, s sVar) {
            MapStatus mapStatusA = MapStatus.a(sVar);
            if (BaiduMap.this.u == null) {
                return false;
            }
            BaiduMap.mapStatusReason = 1;
            return BaiduMap.this.u.onMapDoubleTouch(point, mapStatusA);
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GeoPoint geoPoint) {
            if (BaiduMap.this.z != null) {
                LatLng latLngMc2ll = CoordUtil.mc2ll(geoPoint);
                BaiduMap.mapStatusReason |= 1;
                BaiduMap.this.z.onMapDoubleClick(latLngMc2ll);
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(BmDrawItem bmDrawItem) {
            if (bmDrawItem == null) {
                return false;
            }
            Boolean bool = Boolean.FALSE;
            Iterator it = BaiduMap.this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Overlay overlay = (Overlay) it.next();
                if ((overlay instanceof Marker) && overlay.getName().equals(bmDrawItem.getName())) {
                    Marker marker = (Marker) overlay;
                    if (marker.o) {
                        BaiduMap.this.d0 = marker;
                        BaiduMap.this.d0.setAnimateType(0);
                        BaiduMap.this.d0.setPosition(BaiduMap.this.d.fromScreenLocation(new Point(BaiduMap.this.d.toScreenLocation(BaiduMap.this.d0.g).x, r7.y - 60)));
                        if (BaiduMap.this.K != null) {
                            BaiduMap.this.K.onMarkerDragStart(BaiduMap.this.d0);
                        }
                        bool = Boolean.TRUE;
                    }
                }
            }
            return bool.booleanValue();
        }

        @Override // com.baidu.platform.comapi.map.v
        public boolean a(String str) {
            JSONObject jSONObjectOptJSONObject;
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("dataset");
                if (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || jSONObjectOptJSONObject.optInt(MapBundleKey.MapObjKey.OBJ_TYPE) != 90909) {
                    return false;
                }
                String strOptString = jSONObjectOptJSONObject.optString("marker_id");
                Set setKeySet = BaiduMap.this.b0.keySet();
                if (!setKeySet.isEmpty() && setKeySet.contains(strOptString)) {
                    return false;
                }
                for (Overlay overlay : BaiduMap.this.j) {
                    if ((overlay instanceof Marker) && overlay.f3666a.equals(strOptString)) {
                        Marker marker = (Marker) overlay;
                        if (!marker.o) {
                            return false;
                        }
                        BaiduMap.this.d0 = marker;
                        BaiduMap.this.d0.setPosition(BaiduMap.this.d.fromScreenLocation(new Point(BaiduMap.this.d.toScreenLocation(BaiduMap.this.d0.g).x, r5.y - 60)));
                        if (BaiduMap.this.K != null) {
                            BaiduMap.this.K.onMarkerDragStart(BaiduMap.this.d0);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(GL10 gl10, s sVar) {
            View view;
            if (BaiduMap.this.b0 != null && !BaiduMap.this.b0.values().isEmpty()) {
                for (InfoWindow infoWindow : BaiduMap.this.b0.values()) {
                    if (infoWindow != null && (view = infoWindow.c) != null) {
                        view.post(new a(infoWindow));
                    }
                }
            }
            if (BaiduMap.this.P != null) {
                BaiduMap.this.P.onMapDrawFrame(MapStatus.a(sVar));
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean z) {
            if (BaiduMap.this.Q != null) {
                if (!z) {
                    if (BaiduMap.this.t0) {
                        BaiduMap.this.Q.onBaseIndoorMapMode(z, null);
                        BaiduMap.this.t0 = false;
                        return;
                    }
                    return;
                }
                BaiduMap.this.Q.onBaseIndoorMapMode(z, BaiduMap.this.getFocusedBaseIndoorMapInfo());
                BaiduMap.this.t0 = true;
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a() {
            if (BaiduMap.this.h != null) {
                BaiduMap.this.h.s(false);
            }
            BaiduMap.this.Y.lock();
            try {
                if (BaiduMap.this.W != null) {
                    BaiduMap baiduMap = BaiduMap.this;
                    baiduMap.a(baiduMap.W);
                }
            } finally {
                BaiduMap.this.Y.unlock();
            }
        }

        @Override // com.baidu.platform.comapi.map.v
        public void a(boolean z, int i) {
            if (BaiduMap.this.R != null) {
                BaiduMap.this.R.onMapRenderValidData(z, i, BaiduMap.this.a(i));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements com.baidu.mapsdkplatform.comapi.map.h {
        public n() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.h
        public Bundle a(int i, int i2) {
            BaiduMap.this.Y.lock();
            try {
                if (BaiduMap.this.W == null) {
                    return null;
                }
                if (BaiduMap.this.S != null) {
                    BaiduMap.this.S.frameIndex(i);
                }
                HeatMapData data = BaiduMap.this.W.getData(i, i2);
                if (data == null) {
                    return null;
                }
                return data.toBundle();
            } finally {
                BaiduMap.this.Y.unlock();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements com.baidu.mapsdkplatform.comapi.map.w {
        public o() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.map.w
        public Bundle a(int i, int i2, int i3, Context context) {
            BaiduMap.this.a0.lock();
            try {
                if (BaiduMap.this.V != null) {
                    Tile tileA = BaiduMap.this.V.a(i, i2, i3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("mapLayerDataReq tile t == null = ");
                    sb.append(tileA == null);
                    Log.e("SDKTileLayer", sb.toString());
                    if (tileA != null) {
                        return tileA.toBundle();
                    }
                }
                BaiduMap.this.a0.unlock();
                return null;
            } finally {
                BaiduMap.this.a0.unlock();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface onMapGestureListener {
        boolean onMapDoubleTouch(Point point, MapStatus mapStatus);

        boolean onMapFling(MotionEvent motionEvent, float f, float f2, MapStatus mapStatus);

        boolean onMapKneading(Point point, Point point2, MapStatus mapStatus);

        boolean onMapOverLooking(Point point, Point point2, MapStatus mapStatus);

        boolean onMapScroll(Point point, Point point2, MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        boolean onMapTwoClick(Point point, Point point2, MapStatus mapStatus);
    }

    public BaiduMap(Context context, MapTextureView mapTextureView, q qVar) {
        this.g = mapTextureView;
        com.baidu.mapsdkplatform.comapi.map.b bVar = new com.baidu.mapsdkplatform.comapi.map.b(context, mapTextureView, qVar, (String) null, 0);
        this.h = bVar;
        mapTextureView.setBaseMap(bVar);
        this.k0 = r.TextureView;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i2) {
        if (i2 == 0) {
            return "数据请求成功";
        }
        switch (i2) {
            case 1004:
                return "网络连接错误";
            case 1005:
                return "请求发送错误";
            case 1006:
                return "响应数据读取失败";
            case 1007:
                return "返回响应数据过大，数据溢出";
            case 1008:
                return "当前网络类型有问题";
            case 1009:
                return "数据不一致";
            case 1010:
                return "请求取消";
            case 1011:
                return "网络超时错误";
            case 1012:
                return "网络连接超时";
            case 1013:
                return "网络发送超时";
            case 1014:
                return "网络接收超时";
            case 1015:
                return "DNS解析错误";
            case 1016:
                return "DNS解析超时";
            case 1017:
                return "网络写错误";
            case 1018:
                return "SSL握手错误";
            case 1019:
                return "SSL握手超时";
            default:
                return "";
        }
    }

    public void addHeatMap(HeatMap heatMap) {
        if (heatMap == null || this.h == null) {
            return;
        }
        this.Y.lock();
        try {
            HeatMap heatMap2 = this.W;
            if (heatMap == heatMap2) {
                return;
            }
            if (heatMap2 != null) {
                heatMap2.a();
                this.W.c();
                this.W.C = null;
                this.h.e();
            }
            this.W = heatMap;
            heatMap.C = this;
            Bundle bundle = heatMap.toBundle();
            this.h.n(true);
            this.h.g(bundle);
            HashMap map = new HashMap();
            HeatMap heatMap3 = this.W;
            if (heatMap3 != null) {
                map.put("H", Integer.valueOf(heatMap3.getMaxHigh()));
                map.put("I", Integer.valueOf(this.W.isInitAnimation() ? 1 : 0));
                map.put("F", Integer.valueOf(this.W.isFrameAnimation() ? 1 : 0));
            }
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "H", "0", map);
        } finally {
            this.Y.unlock();
        }
    }

    public void addHexagonMap(HexagonMap hexagonMap) {
        if (hexagonMap == null || this.h == null) {
            return;
        }
        this.Z.lock();
        if (this.X != null) {
            this.h.f();
        }
        this.X = hexagonMap;
        hexagonMap.hexagonMapLayerListener = this.p;
        Bundle bundle = hexagonMap.toBundle();
        this.h.o(true);
        this.h.b(bundle);
        this.Z.unlock();
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        if (overlayOptions != null && !this.q0) {
            if (OverlayUtil.isOverlayUpgrade()) {
                c();
            }
            Overlay overlay = overlayOptions.getOverlay();
            if (overlay != null) {
                overlay.listener = this.n;
                if (OverlayUtil.isOverlayUpgrade() && !(overlay instanceof Dot)) {
                    a(overlay);
                    if (overlay instanceof Marker) {
                        Marker marker = (Marker) overlay;
                        marker.Q = this.q;
                        InfoWindowAdapter infoWindowAdapter = this.r;
                        if (infoWindowAdapter != null) {
                            marker.X = infoWindowAdapter;
                        }
                        ArrayList<BitmapDescriptor> arrayList = marker.G;
                        if (arrayList != null && arrayList.size() != 0) {
                            this.k.add(marker);
                            com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
                            if (bVar != null) {
                                bVar.s(true);
                            }
                        }
                        this.l.add(marker);
                        InfoWindow infoWindow = marker.P;
                        if (infoWindow != null) {
                            showInfoWindow(infoWindow, false);
                        }
                    }
                    if (overlay instanceof Building) {
                        this.O.add((Building) overlay);
                    }
                    return overlay;
                }
                if (overlay instanceof Marker) {
                    Marker marker2 = (Marker) overlay;
                    marker2.Q = this.q;
                    ArrayList<BitmapDescriptor> arrayList2 = marker2.G;
                    if (arrayList2 != null && arrayList2.size() != 0) {
                        this.k.add(marker2);
                        com.baidu.mapsdkplatform.comapi.map.b bVar2 = this.h;
                        if (bVar2 != null) {
                            bVar2.s(true);
                        }
                    }
                    this.l.add(marker2);
                    InfoWindow infoWindow2 = marker2.P;
                    if (infoWindow2 != null) {
                        showInfoWindow(infoWindow2, false);
                    }
                } else if (overlay instanceof Building) {
                    this.O.add((Building) overlay);
                }
                Bundle bundle = new Bundle();
                overlay.a(bundle);
                if (this.h != null && !this.q0) {
                    this.h.d(bundle);
                }
                this.j.add(overlay);
                return overlay;
            }
        }
        return null;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        if (list == null || this.q0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
            for (int i2 = 0; i2 < size; i2++) {
                OverlayOptions overlayOptions = list.get(i2);
                if (overlayOptions != null) {
                    Overlay overlay = overlayOptions.getOverlay();
                    overlay.listener = this.n;
                    if (!(overlay instanceof Dot)) {
                        if (overlay instanceof Marker) {
                            Marker marker = (Marker) overlay;
                            marker.Q = this.q;
                            InfoWindowAdapter infoWindowAdapter = this.r;
                            if (infoWindowAdapter != null) {
                                marker.X = infoWindowAdapter;
                            }
                            ArrayList<BitmapDescriptor> arrayList2 = marker.G;
                            if (arrayList2 != null && arrayList2.size() != 0) {
                                this.k.add(marker);
                                com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
                                if (bVar != null) {
                                    bVar.s(true);
                                }
                            }
                            this.l.add(marker);
                            InfoWindow infoWindow = marker.P;
                            if (infoWindow != null) {
                                showInfoWindow(infoWindow, false);
                            }
                        }
                        if (overlay instanceof Building) {
                            this.O.add((Building) overlay);
                        }
                        this.j.add(overlay);
                        arrayList.add(overlay);
                        overlay.setBmLayer(this.i);
                        BmDrawItem drawItem = overlay.toDrawItem();
                        this.i.a(drawItem, drawItem.b());
                    }
                }
            }
            this.i.b();
        } else {
            Bundle[] bundleArr = new Bundle[size];
            for (int i3 = 0; i3 < size; i3++) {
                OverlayOptions overlayOptions2 = list.get(i3);
                if (overlayOptions2 != null) {
                    Overlay overlay2 = overlayOptions2.getOverlay();
                    overlay2.listener = this.n;
                    if (overlay2 instanceof Marker) {
                        Marker marker2 = (Marker) overlay2;
                        marker2.Q = this.q;
                        InfoWindowAdapter infoWindowAdapter2 = this.r;
                        if (infoWindowAdapter2 != null) {
                            marker2.X = infoWindowAdapter2;
                        }
                        ArrayList<BitmapDescriptor> arrayList3 = marker2.G;
                        if (arrayList3 != null && arrayList3.size() != 0) {
                            this.k.add(marker2);
                            com.baidu.mapsdkplatform.comapi.map.b bVar2 = this.h;
                            if (bVar2 != null) {
                                bVar2.s(true);
                            }
                        }
                        this.l.add(marker2);
                        InfoWindow infoWindow2 = marker2.P;
                        if (infoWindow2 != null) {
                            showInfoWindow(infoWindow2, false);
                        }
                    }
                    if (overlay2 instanceof Building) {
                        this.O.add((Building) overlay2);
                    }
                    this.j.add(overlay2);
                    arrayList.add(overlay2);
                    Bundle bundle = new Bundle();
                    com.baidu.mapsdkplatform.comapi.map.b bVar3 = this.h;
                    if (bVar3 != null) {
                        bVar3.c(bundle);
                        this.h.a(bundle);
                    }
                    overlay2.a(bundle);
                    bundleArr[i3] = bundle;
                }
            }
            com.baidu.mapsdkplatform.comapi.map.b bVar4 = this.h;
            if (bVar4 != null) {
                bVar4.a(bundleArr);
            }
        }
        return arrayList;
    }

    public TileOverlay addTileLayer(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions == null) {
            return null;
        }
        TileOverlay tileOverlay = this.V;
        if (tileOverlay != null) {
            tileOverlay.c();
            this.V.c = null;
        }
        HashMap map = new HashMap();
        map.put(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(tileOverlayOptions.datasource));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, ExifInterface.GPS_DIRECTION_TRUE, "0", map);
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null || !bVar.e(tileOverlayOptions.a())) {
            return null;
        }
        TileOverlay tileOverlayA = tileOverlayOptions.a(this);
        this.V = tileOverlayA;
        return tileOverlayA;
    }

    public final TraceOverlay addTraceOverlay(TraceOptions traceOptions, TraceAnimationListener traceAnimationListener) {
        if (traceOptions == null) {
            return null;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "TO", "0", null);
        com.baidu.mapsdkplatform.comapi.map.z.c cVar = this.s0;
        if (cVar == null || cVar.d()) {
            r rVar = this.k0;
            if (rVar == r.GLSurfaceView) {
                this.s0 = new com.baidu.mapsdkplatform.comapi.map.z.c(this.f);
            } else {
                if (rVar != r.TextureView) {
                    return null;
                }
                this.s0 = new com.baidu.mapsdkplatform.comapi.map.z.c(this.g);
            }
            this.s0.c();
            this.h.a(this.s0.b());
        }
        this.s0.a(traceAnimationListener);
        return this.s0.a(traceOptions);
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i2) {
        if (mapStatusUpdate == null || i2 < 0) {
            return;
        }
        s sVarA = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        mapStatusReason |= 256;
        if (this.o0) {
            bVar.a(sVarA, i2);
        } else {
            bVar.a(sVarA);
        }
    }

    public void changeLocationLayerOrder(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.a(z);
    }

    public void cleanCache(int i2) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.a(i2);
    }

    public final void clear() {
        if (this.q0) {
            return;
        }
        BmLayer bmLayer = this.i;
        if (bmLayer != null) {
            bmLayer.a();
            this.i.b();
            Iterator<Overlay> it = this.j.iterator();
            while (it.hasNext()) {
                BmDrawItem bmDrawItem = it.next().mDrawItem;
                if ((bmDrawItem instanceof BmIconMarker) && ((BmIconMarker) bmDrawItem).d() != null) {
                    try {
                        ((BmIconMarker) bmDrawItem).d().close();
                    } catch (Exception unused) {
                        Log.e("BmBitmapResource", "BmBitmapResource close failied");
                    }
                }
                try {
                    bmDrawItem.close();
                } catch (Exception unused2) {
                    Log.e("DrawItem", "DrawItem close failied");
                }
            }
        }
        this.j.clear();
        this.k.clear();
        this.l.clear();
        this.O.clear();
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.s(false);
            this.h.d();
        }
        hideInfoWindow();
    }

    public void closeParticleEffectByType(ParticleEffectType particleEffectType) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.a(particleEffectType);
        }
    }

    public boolean customParticleEffectByType(ParticleEffectType particleEffectType, ParticleOptions particleOptions) {
        if (this.h == null) {
            return false;
        }
        if (particleEffectType == ParticleEffectType.Fireworks || particleEffectType == ParticleEffectType.Flower) {
            a(particleEffectType);
        }
        Bundle bundle = new Bundle();
        if (particleOptions != null) {
            if (particleOptions.getParticleImgs() != null) {
                int size = particleOptions.getParticleImgs().size();
                bundle.putInt("total", size);
                for (int i2 = 0; i2 < size; i2++) {
                    if (particleOptions.getParticleImgs().get(i2) != null) {
                        bundle.putBundle(String.format("texture_%d", Integer.valueOf(i2)), particleOptions.getParticleImgs().get(i2).a());
                    }
                }
            }
            if (particleOptions.getParticlePos() != null) {
                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(particleOptions.getParticlePos());
                bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
                bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
            }
        }
        return this.h.a(particleEffectType, bundle);
    }

    public List<InfoWindow> getAllInfoWindows() {
        return this.m;
    }

    public final Point getCompassPosition() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            return a(bVar.l());
        }
        return null;
    }

    public boolean getCustomTrafficColorEnable() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return false;
        }
        return bVar.m();
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return null;
        }
        return bVar.o();
    }

    public final int getFontSizeLevel() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            return bVar.p();
        }
        return 1;
    }

    public MapSurfaceView getGLMapView() {
        return this.f;
    }

    public OnHeatMapDrawFrameCallBack getHeatMapDrawFrameCallBack() {
        return this.S;
    }

    public boolean getIsSDKLayerBelowBmLayer() {
        return this.r0;
    }

    @Deprecated
    public final MyLocationConfiguration getLocationConfigeration() {
        return getLocationConfiguration();
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        return this.f0;
    }

    public final MyLocationData getLocationData() {
        return this.e0;
    }

    public final String getMapApprovalNumber() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        return bVar == null ? "" : bVar.t();
    }

    public final String getMapCopyrightInfo() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        return bVar == null ? "" : bVar.u();
    }

    public MapLanguage getMapLanguage() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return MapLanguage.CHINESE;
        }
        return MapLanguage.values()[bVar.w()];
    }

    public final String getMapMappingQualificationInfo() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        return bVar == null ? "" : bVar.x();
    }

    public final MapStatus getMapStatus() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return null;
        }
        return MapStatus.a(bVar.y());
    }

    public final LatLngBounds getMapStatusLimit() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return null;
        }
        return bVar.z();
    }

    public MapTextureView getMapTextureView() {
        return this.g;
    }

    public final int getMapType() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return 1;
        }
        if (bVar.L()) {
            return this.h.P() ? 2 : 1;
        }
        return 3;
    }

    public List<Marker> getMarkersInBounds(LatLngBounds latLngBounds) {
        if (getMapStatus() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.l.size() == 0) {
            return null;
        }
        for (Marker marker : this.l) {
            if (latLngBounds.contains(marker.getPosition())) {
                arrayList.add(marker);
            }
        }
        return arrayList;
    }

    public final float getMaxZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.A();
    }

    public final float getMinZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.e;
    }

    public LatLngBounds getOverlayLatLngBounds(OverlayOptions overlayOptions) {
        if (overlayOptions == null || this.h == null) {
            return null;
        }
        Overlay overlay = overlayOptions.getOverlay();
        Bundle bundle = new Bundle();
        overlay.a(bundle);
        return this.h.f(bundle);
    }

    public boolean getPoiTagEnable(PoiTagType poiTagType) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            return bVar.a(poiTagType);
        }
        return false;
    }

    public final Projection getProjection() {
        return this.d;
    }

    public float[] getProjectionMatrix() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return null;
        }
        return bVar.B();
    }

    public final UiSettings getUiSettings() {
        return this.e;
    }

    public float[] getViewMatrix() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return null;
        }
        return bVar.C();
    }

    public float getZoomToBound(int i2, int i3, int i4, int i5, int i6, int i7) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.a(i2, i3, i4, i5, i6, i7);
    }

    @Deprecated
    public MapSurfaceView getmGLMapView() {
        return this.f;
    }

    public void hideInfoWindow() {
        View view;
        MapView mapView;
        Collection<InfoWindow> collectionValues = this.b0.values();
        if (!collectionValues.isEmpty()) {
            for (InfoWindow infoWindow : collectionValues) {
                if (infoWindow != null && (view = infoWindow.c) != null) {
                    int i2 = g.b[this.k0.ordinal()];
                    if (i2 == 1) {
                        TextureMapView textureMapView = this.i0;
                        if (textureMapView != null) {
                            textureMapView.removeView(view);
                        }
                    } else if (i2 == 2 && (mapView = this.h0) != null) {
                        mapView.removeView(view);
                    }
                }
            }
        }
        for (Overlay overlay : this.j) {
            Set<String> setKeySet = this.b0.keySet();
            String str = overlay.f3666a;
            if ((overlay instanceof Marker) && !setKeySet.isEmpty() && setKeySet.contains(str)) {
                overlay.remove();
            }
        }
        this.b0.clear();
        this.c0.clear();
        this.m.clear();
    }

    public void hideSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.F();
    }

    public final boolean isBaiduHeatMapEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return false;
        }
        return bVar.J();
    }

    public boolean isBaseIndoorMapMode() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return false;
        }
        return bVar.K();
    }

    public final boolean isBuildingsEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return false;
        }
        return bVar.M();
    }

    public final boolean isMyLocationEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return false;
        }
        return bVar.s();
    }

    public final boolean isShowMapPoi() {
        return this.l0;
    }

    public final boolean isSupportBaiduHeatMap() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return false;
        }
        return bVar.j();
    }

    public final boolean isTrafficEnabled() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return false;
        }
        return bVar.R();
    }

    public final void mapRefresh() {
        MapTaskManager.postToMainThread(new f(), 300L);
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (this.B.contains(onMarkerClickListener)) {
            this.B.remove(onMarkerClickListener);
        }
    }

    public final void removeMarkerWithBaseUIClickListener(OnMarkerWithBaseUIClickListener onMarkerWithBaseUIClickListener) {
        if (this.C.contains(onMarkerWithBaseUIClickListener)) {
            this.C.remove(onMarkerWithBaseUIClickListener);
        }
    }

    public void removeOverLays(List<Overlay> list) {
        int i2;
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        if (list == null || this.q0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i3 = size / 400;
        for (int i4 = 0; i4 < i3 + 1; i4++) {
            for (int i5 = 0; i5 < 400 && (i2 = (i4 * 400) + i5) < size; i5++) {
                if (this.q0) {
                    return;
                }
                Overlay overlay = list.get(i2);
                if (overlay != null) {
                    if (OverlayUtil.isOverlayUpgrade()) {
                        b(overlay);
                    } else {
                        Bundle bundleA = overlay.a();
                        com.baidu.mapsdkplatform.comapi.map.b bVar2 = this.h;
                        if (bVar2 != null) {
                            bVar2.c(bundleA);
                        }
                        arrayList.add(bundleA);
                    }
                    List<Marker> list2 = this.l;
                    if (list2 != null && list2.contains(overlay)) {
                        this.l.remove(overlay);
                    }
                    CopyOnWriteArrayList<Building> copyOnWriteArrayList = this.O;
                    if (copyOnWriteArrayList != null && copyOnWriteArrayList.contains(overlay)) {
                        this.O.remove(overlay);
                    }
                    if (this.k.contains(overlay)) {
                        Marker marker = (Marker) overlay;
                        if (marker.G != null) {
                            this.k.remove(marker);
                            if (this.k.size() == 0 && (bVar = this.h) != null) {
                                bVar.s(false);
                            }
                        }
                    }
                }
            }
            if (this.h != null && !arrayList.isEmpty()) {
                int size2 = arrayList.size();
                Bundle[] bundleArr = new Bundle[size2];
                for (int i6 = 0; i6 < size2; i6++) {
                    bundleArr[i6] = (Bundle) arrayList.get(i6);
                }
                this.h.b(bundleArr);
            }
        }
        this.j.removeAll(list);
    }

    public final void setBaiduHeatMapEnabled(boolean z) {
        if (this.h != null) {
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "H", "0", null);
            this.h.d(z);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.b(z);
        }
    }

    public void setCompassEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.c(z);
    }

    public void setCompassIcon(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("BDMapSDKException: compass's icon can not be null");
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.a(bitmap);
    }

    public void setCompassPosition(Point point) {
        if (this.h == null) {
            return;
        }
        if (this.h.a(new Point(point.x, point.y))) {
            this.p0 = point;
        }
    }

    @Deprecated
    public boolean setCustomTrafficColor(String str, String str2, String str3, String str4) {
        if (this.h == null) {
            return false;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str4)) {
                return true;
            }
            this.h.a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), false);
            return true;
        }
        if (str.matches("^#[0-9a-fA-F]{8}$") && str2.matches("^#[0-9a-fA-F]{8}$") && str3.matches("^#[0-9a-fA-F]{8}$") && str4.matches("^#[0-9a-fA-F]{8}$")) {
            this.h.a(Color.parseColor(str), Color.parseColor(str2), Color.parseColor(str3), Color.parseColor(str4), true);
            return true;
        }
        Log.e(f3591a, "the string of the input customTrafficColor is error");
        return false;
    }

    public void setCustomTrafficColorEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.g(z);
    }

    public void setDEMEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.h(z);
        }
    }

    public final void setFontSizeLevel(int i2) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.c(i2);
        }
    }

    public void setHeatMapFrameAnimationIndex(int i2) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.d(i2);
    }

    public final void setIndoorEnable(boolean z) {
        if (this.h != null) {
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "3", null);
            this.n0 = z;
            this.h.D(z);
        }
        OnBaseIndoorMapListener onBaseIndoorMapListener = this.Q;
        if (onBaseIndoorMapListener == null || z) {
            return;
        }
        onBaseIndoorMapListener.onBaseIndoorMapMode(false, null);
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        this.r = infoWindowAdapter;
    }

    public void setLayerClickable(MapLayer mapLayer, boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.a(mapLayer, z);
    }

    public void setMapBackgroundColor(int i2) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.b(i2);
    }

    public void setMapBackgroundImage(BitmapDescriptor bitmapDescriptor) {
        if (this.h == null) {
            return;
        }
        if (bitmapDescriptor == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("reset", 1);
            this.h.j(bundle);
        } else {
            if (bitmapDescriptor.getBitmap().getByteCount() > 10240000) {
                return;
            }
            Bundle bundleA = bitmapDescriptor.a();
            bundleA.putInt("reset", 0);
            this.h.j(bundleA);
        }
    }

    public final void setMapLanguage(MapLanguage mapLanguage) {
        setMapLanguage(mapLanguage, com.baidu.platform.comapi.c.b.c().b() != mapLanguage);
    }

    public final void setMapStatus(MapStatusUpdate mapStatusUpdate) {
        if (mapStatusUpdate == null) {
            return;
        }
        s sVarA = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        mapStatusReason |= 256;
        bVar.a(sVarA);
        OnMapStatusChangeListener onMapStatusChangeListener = this.s;
        if (onMapStatusChangeListener != null) {
            onMapStatusChangeListener.onMapStatusChange(getMapStatus());
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.a(latLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
    }

    public final void setMapType(int i2) {
        if (this.h == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(i2));
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "M", "4", map);
        if (i2 == 1) {
            this.h.x(false);
            this.h.H(this.l0);
            this.h.E(this.m0);
            this.h.e(true);
            this.h.D(this.n0);
        } else if (i2 == 2) {
            this.h.x(true);
            this.h.H(this.l0);
            this.h.E(this.m0);
            this.h.e(true);
        } else if (i2 == 3) {
            if (this.h.U()) {
                this.h.H(false);
            }
            if (this.h.G()) {
                this.h.E(false);
            }
            this.h.e(false);
            this.h.D(false);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap setMapType type = " + i2);
        }
    }

    public final void setMaxAndMinZoomLevel(float f2, float f3) {
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        if (f2 <= 22.0f && f3 >= 4.0f && f2 >= f3 && (bVar = this.h) != null) {
            bVar.a(f2, f3);
        }
    }

    @Deprecated
    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) {
        setMyLocationConfiguration(myLocationConfiguration);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) {
        OnLocationModeChangeListener onLocationModeChangeListener;
        this.f0 = myLocationConfiguration;
        a(this.e0, myLocationConfiguration);
        a(this.f0);
        if (myLocationConfiguration == null || !isMyLocationEnabled() || (onLocationModeChangeListener = this.g0) == null) {
            return;
        }
        onLocationModeChangeListener.onLocationModeChange(myLocationConfiguration.locationMode);
    }

    public final void setMyLocationData(MyLocationData myLocationData) {
        this.e0 = myLocationData;
        if (this.f0 == null) {
            this.f0 = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
        }
        a(myLocationData, this.f0);
    }

    public final void setMyLocationEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.q(z);
        }
    }

    public final void setOn3DBuildingListener(Building3DListener building3DListener) {
        this.N = building3DListener;
    }

    public final void setOnArcClickListener(OnArcClickListener onArcClickListener) {
        if (onArcClickListener != null) {
            this.J.add(onArcClickListener);
        }
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener onBaseIndoorMapListener) {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "3.2", null);
        this.Q = onBaseIndoorMapListener;
    }

    public final void setOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        if (onCircleClickListener != null) {
            this.F.add(onCircleClickListener);
        }
    }

    public final void setOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        if (onGroundOverlayClickListener != null) {
            this.H.add(onGroundOverlayClickListener);
        }
    }

    public void setOnHeatMapDrawFrameCallBack(OnHeatMapDrawFrameCallBack onHeatMapDrawFrameCallBack) {
        this.S = onHeatMapDrawFrameCallBack;
    }

    public final void setOnLocationModeChangeListener(OnLocationModeChangeListener onLocationModeChangeListener) {
        this.g0 = onLocationModeChangeListener;
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.v = onMapClickListener;
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener onMapDoubleClickListener) {
        this.z = onMapDoubleClickListener;
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback onMapDrawFrameCallback) {
        this.P = onMapDrawFrameCallback;
    }

    public final void setOnMapGestureListener(onMapGestureListener onmapgesturelistener) {
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "GD", "0", null);
        this.u = onmapgesturelistener;
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        this.w = onMapLoadedCallback;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.A = onMapLongClickListener;
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback onMapRenderCallback) {
        this.y = onMapRenderCallback;
    }

    public final void setOnMapRenderValidDataListener(OnMapRenderValidDataListener onMapRenderValidDataListener) {
        this.R = onMapRenderValidDataListener;
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener onMapStatusChangeListener) {
        this.s = onMapStatusChangeListener;
    }

    public void setOnMapTileLoadedCallback(OnMapTileLoadedCallback onMapTileLoadedCallback) {
        this.x = onMapTileLoadedCallback;
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        this.t = onMapTouchListener;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null || this.B.contains(onMarkerClickListener)) {
            return;
        }
        this.B.add(onMarkerClickListener);
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        this.K = onMarkerDragListener;
    }

    public final void setOnMarkerWithBaseUIClickListener(OnMarkerWithBaseUIClickListener onMarkerWithBaseUIClickListener) {
        if (onMarkerWithBaseUIClickListener == null || this.C.contains(onMarkerWithBaseUIClickListener)) {
            return;
        }
        this.C.add(onMarkerWithBaseUIClickListener);
    }

    public final void setOnMultiPointClickListener(OnMultiPointClickListener onMultiPointClickListener) {
        if (onMultiPointClickListener != null) {
            this.E.add(onMultiPointClickListener);
        }
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        this.L = onMyLocationClickListener;
    }

    public final void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        if (onPolygonClickListener != null) {
            this.G.add(onPolygonClickListener);
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener != null) {
            this.D.add(onPolylineClickListener);
        }
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener onSynchronizationListener) {
        this.T = onSynchronizationListener;
    }

    public final void setOnTextClickListener(OnTextClickListener onTextClickListener) {
        if (onTextClickListener != null) {
            this.I.add(onTextClickListener);
        }
    }

    public void setOverlayUnderPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.t(z);
    }

    @Deprecated
    public final void setPadding(int i2, int i3, int i4, int i5) {
        setViewPadding(i2, i3, i4, i5);
    }

    public void setPixelFormatTransparent(boolean z) {
        MapSurfaceView mapSurfaceView = this.f;
        if (mapSurfaceView == null) {
            return;
        }
        if (z) {
            mapSurfaceView.setPixelFormatTransparent(true);
        } else {
            mapSurfaceView.setPixelFormatTransparent(false);
        }
    }

    public void setPoiTagEnable(PoiTagType poiTagType, boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.a(poiTagType, z);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        if (this.h != null) {
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "1", null);
            this.h.z(z);
        }
    }

    public final void setViewPadding(int i2, int i3, int i4, int i5) {
        MapView mapView;
        if (i2 < 0 || i3 < 0 || i4 < 0 || i5 < 0 || this.h == null) {
            return;
        }
        int i6 = g.b[this.k0.ordinal()];
        if (i6 != 1) {
            if (i6 == 2 && (mapView = this.h0) != null) {
                com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
                Point point = this.p0;
                bVar.a(new Point((int) (i2 + (point.x * (((mapView.getWidth() - i2) - i4) / this.h0.getWidth()))), (int) (i3 + (point.y * (((this.h0.getHeight() - i3) - i5) / this.h0.getHeight())))));
                this.h0.setPadding(i2, i3, i4, i5);
                this.h0.invalidate();
                return;
            }
            return;
        }
        if (this.i0 == null) {
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar2 = this.h;
        Point point2 = this.p0;
        bVar2.a(new Point((int) (i2 + (point2.x * (((r0.getWidth() - i2) - i4) / this.i0.getWidth()))), (int) (i3 + (point2.y * (((this.i0.getHeight() - i3) - i5) / this.i0.getHeight())))));
        this.i0.setPadding(i2, i3, i4, i5);
        this.i0.invalidate();
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        showInfoWindow(infoWindow, true);
    }

    public void showInfoWindows(List<InfoWindow> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<InfoWindow> it = list.iterator();
        while (it.hasNext()) {
            showInfoWindow(it.next(), false);
        }
    }

    public final void showMapIndoorPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.E(z);
            this.m0 = z;
        }
    }

    public final void showMapPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.H(z);
            this.l0 = z;
        }
    }

    public void showOperateLayer(boolean z) {
        if (this.h == null) {
            return;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "2", null);
        this.h.F(z);
    }

    public void showOperatePoiLayer(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.G(z);
    }

    public boolean showParticleEffectByType(ParticleEffectType particleEffectType) {
        if (this.h == null) {
            return false;
        }
        if (particleEffectType == ParticleEffectType.Fireworks || particleEffectType == ParticleEffectType.Flower) {
            a(particleEffectType);
        }
        return this.h.b(particleEffectType);
    }

    public void showSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.W();
    }

    public void showTrafficUGCMap(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.I(z);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        MapSurfaceView mapSurfaceView;
        this.M = snapshotReadyCallback;
        int i2 = g.b[this.k0.ordinal()];
        if (i2 != 1) {
            if (i2 != 2 || (mapSurfaceView = this.f) == null || mapSurfaceView.getController() == null) {
                return;
            }
            this.f.doCaptureMapView(new c(), new Rect(0, 0, this.f.getController().getScreenWidth(), this.f.getController().getScreenHeight()), Bitmap.Config.ARGB_8888);
            this.f.requestRender();
            return;
        }
        MapTextureView mapTextureView = this.g;
        if (mapTextureView == null || mapTextureView.getController() == null) {
            return;
        }
        this.g.doCaptureMapView(new b(), new Rect(0, 0, this.g.getController().getScreenWidth(), this.g.getController().getScreenHeight()), Bitmap.Config.ARGB_8888);
        this.g.requestRender();
    }

    public final void snapshotScope(Rect rect, SnapshotReadyCallback snapshotReadyCallback) {
        MapSurfaceView mapSurfaceView;
        if (this.h == null) {
            return;
        }
        this.M = snapshotReadyCallback;
        int i2 = g.b[this.k0.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 && (mapSurfaceView = this.f) != null) {
                mapSurfaceView.doCaptureMapView(new e(), rect, Bitmap.Config.ARGB_8888);
                this.f.requestRender();
                return;
            }
            return;
        }
        MapTextureView mapTextureView = this.g;
        if (mapTextureView != null) {
            mapTextureView.doCaptureMapView(new d(), rect, Bitmap.Config.ARGB_8888);
            this.g.requestRender();
        }
    }

    public void startHeatMapFrameAnimation() {
        if (this.h == null) {
            return;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, "H", "1", null);
        this.h.X();
    }

    public void stopHeatMapFrameAnimation() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return;
        }
        bVar.Y();
    }

    public MapBaseIndoorMapInfo.SwitchFloorError switchBaseIndoorMapFloor(String str, String str2) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError = MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_INFO_ERROR;
            map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "3.1", map);
            return switchFloorError;
        }
        MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = getFocusedBaseIndoorMapInfo();
        if (focusedBaseIndoorMapInfo == null) {
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError2 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
            map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError2.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "3.1", map);
            return switchFloorError2;
        }
        if (!str2.equals(focusedBaseIndoorMapInfo.f3638a)) {
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError3 = MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
            map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError3.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "3.1", map);
            return switchFloorError3;
        }
        ArrayList<String> floors = focusedBaseIndoorMapInfo.getFloors();
        if (floors == null || !floors.contains(str)) {
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError4 = MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW;
            map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError4.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "3.1", map);
            return switchFloorError4;
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null || !bVar.b(str, str2)) {
            MapBaseIndoorMapInfo.SwitchFloorError switchFloorError5 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
            map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError5.name());
            SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "3.1", map);
            return switchFloorError5;
        }
        MapBaseIndoorMapInfo.SwitchFloorError switchFloorError6 = MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK;
        map.put(ExifInterface.LATITUDE_SOUTH, switchFloorError6.name());
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "3.1", map);
        return switchFloorError6;
    }

    public void switchLayerOrder(MapLayer mapLayer, MapLayer mapLayer2) {
        if (this.h == null) {
            return;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "5", null);
        if ((this.h.a(mapLayer, mapLayer2) && mapLayer == MapLayer.BM_LAYER_OVERLAY && mapLayer2 == MapLayer.MAP_LAYER_OVERLAY) || (mapLayer == MapLayer.MAP_LAYER_OVERLAY && mapLayer2 == MapLayer.BM_LAYER_OVERLAY)) {
            boolean z = !this.r0;
            this.r0 = z;
            this.h.w(z);
        }
    }

    public boolean switchOverlayLayerAndNavigationLayer(boolean z) {
        if (this.h == null) {
            return false;
        }
        SDKLogFactory.getLogUsrActStatistics().addLogWithLowLevel(WkAdxAdConfigMg.DSP_NAME_BAIDU, WkAdxAdConfigMg.DSP_NAME_CSJ, "4", null);
        return this.h.J(z);
    }

    public void updateBaseLayers() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null || !bVar.L()) {
            return;
        }
        this.h.Z();
    }

    public void updateHeatMap(HeatMap heatMap) {
        if (heatMap == null || this.h == null) {
            return;
        }
        this.Y.lock();
        try {
            this.W = heatMap;
            heatMap.C = this;
            this.h.k(heatMap.toBundle());
        } finally {
            this.Y.unlock();
        }
    }

    private synchronized void c() {
        if (OverlayUtil.isOverlayUpgrade()) {
            if (this.i != null) {
                return;
            }
            r rVar = this.k0;
            r rVar2 = r.GLSurfaceView;
            if (rVar == rVar2 && this.f == null) {
                return;
            }
            r rVar3 = r.TextureView;
            if (rVar == rVar3 && this.g == null) {
                return;
            }
            if (this.h != null) {
                BmLayer bmLayer = new BmLayer(true);
                this.i = bmLayer;
                bmLayer.setLayerTag("DefaultBmLayer");
                r rVar4 = this.k0;
                if (rVar4 == rVar2) {
                    this.f.addBmLayer(this.i);
                } else if (rVar4 == rVar3) {
                    this.g.addBmLayer(this.i);
                }
                this.h.a(this.i);
                this.i.a(new p());
                this.o = new a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (getMapLanguage() != MapLanguage.ENGLISH) {
            com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
            if (bVar == null || bVar.v()) {
                return;
            }
            this.h.r(false);
            return;
        }
        Context cachedContext = JNIInitializer.getCachedContext();
        if (cachedContext == null || this.h == null) {
            return;
        }
        this.h.a(cachedContext.getFilesDir().getAbsolutePath() + "/cfg/a/mode_1/englishmap.sty", "");
        AppBaseMap appBaseMapI = this.h.i();
        if (appBaseMapI == null) {
            return;
        }
        appBaseMapI.setCustomStyleEnable(true);
    }

    public void d() {
        this.q0 = true;
        com.baidu.mapsdkplatform.comapi.map.z.c cVar = this.s0;
        if (cVar != null) {
            cVar.e();
            this.s0 = null;
        }
        NetworkUtil.unregisterNetworkCallback();
        hideInfoWindow();
    }

    public final void setMapLanguage(MapLanguage mapLanguage, boolean z) {
        TextureMapView textureMapView;
        MapTextureView mapTextureView;
        MapView mapView;
        MapSurfaceView mapSurfaceView;
        MapLanguage mapLanguage2 = MapLanguage.ENGLISH;
        if (mapLanguage == mapLanguage2 && !PermissionUtils.getInstance().isEnglishMapAuthorized()) {
            Log.e("baidumapsdk", " No advanced permission to set English map");
            if (com.baidu.platform.comapi.c.b.c().b() == mapLanguage2) {
                this.h.a(mapLanguage2.ordinal(), true);
                setMapLanguage(MapLanguage.CHINESE, true);
                com.baidu.platform.comapi.c.b.c().a();
                return;
            }
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.a(mapLanguage.ordinal(), z);
            showOperatePoiLayer(mapLanguage != mapLanguage2);
            r rVar = this.k0;
            if (rVar == r.GLSurfaceView && (mapView = this.h0) != null && (mapSurfaceView = this.f) != null) {
                mapView.updateScaleUI(mapSurfaceView.getZoomLevel());
            } else if (rVar == r.TextureView && (textureMapView = this.i0) != null && (mapTextureView = this.g) != null) {
                textureMapView.updateScaleUI(mapTextureView.getZoomLevel());
            }
            com.baidu.platform.comapi.c.b.c().a(mapLanguage);
        }
        e();
    }

    public void showInfoWindow(InfoWindow infoWindow, boolean z) {
        boolean z2;
        MapView mapView;
        Set<InfoWindow> setKeySet = this.c0.keySet();
        if (infoWindow == null || setKeySet.contains(infoWindow) || this.q0) {
            return;
        }
        if (z) {
            hideInfoWindow();
        }
        infoWindow.i = this.q;
        View view = infoWindow.c;
        if (view == null || !infoWindow.n) {
            z2 = true;
        } else {
            view.destroyDrawingCache();
            MapViewLayoutParams mapViewLayoutParamsBuild = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.d).yOffset(infoWindow.j).build();
            int i2 = g.b[this.k0.ordinal()];
            if (i2 == 1) {
                TextureMapView textureMapView = this.i0;
                if (textureMapView != null) {
                    textureMapView.addView(view, mapViewLayoutParamsBuild);
                }
            } else if (i2 == 2 && (mapView = this.h0) != null) {
                mapView.addView(view, mapViewLayoutParamsBuild);
            }
            z2 = false;
        }
        BitmapDescriptor bitmapDescriptorA = a(infoWindow);
        if (bitmapDescriptorA == null) {
            return;
        }
        Overlay overlay = (!infoWindow.e ? new MarkerOptions().perspective(false).icon(bitmapDescriptorA).position(infoWindow.d).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.j).infoWindow(infoWindow) : new MarkerOptions().perspective(false).icon(bitmapDescriptorA).position(infoWindow.d).fixedScreenPosition(new Point(infoWindow.f, infoWindow.g)).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.j).infoWindow(infoWindow)).getOverlay();
        overlay.listener = this.n;
        if (!infoWindow.e) {
            overlay.type = com.baidu.mapsdkplatform.comapi.map.d.popup;
        }
        overlay.c = 32767;
        Bundle bundle = new Bundle();
        overlay.a(bundle);
        if (infoWindow.c != null) {
            bundle.putInt("draw_with_view", 1);
        } else {
            bundle.putInt("draw_with_view", 0);
        }
        Marker marker = (Marker) overlay;
        if (this.h != null && z2 && !this.q0) {
            if (OverlayUtil.isOverlayUpgrade()) {
                a(marker);
            } else {
                this.h.d(bundle);
            }
            this.j.add(overlay);
        }
        marker.Q = this.q;
        this.b0.put(marker.f3666a, infoWindow);
        this.c0.put(infoWindow, marker);
        this.m.add(infoWindow);
    }

    private void b() {
        this.q0 = false;
        this.j = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
        this.O = new CopyOnWriteArrayList<>();
        this.b0 = new ConcurrentHashMap();
        this.c0 = new ConcurrentHashMap();
        this.m = new CopyOnWriteArrayList();
        this.p0 = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
        h hVar = new h();
        this.U = hVar;
        NetworkUtil.setNetworkUpdate2MapListener(hVar);
        this.e = new UiSettings(this.h);
        this.p = new i();
        this.n = new j();
        this.q = new k();
        this.h.a(new l());
        this.h.a(new m());
        this.h.a(new n());
        this.h.a(new o());
        this.l0 = this.h.U();
        this.m0 = this.h.G();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements HexagonMap.b {
        public i() {
        }

        @Override // com.baidu.mapapi.map.HexagonMap.b
        public void a(HexagonMap hexagonMap) {
            if (BaiduMap.this.h == null || hexagonMap == null) {
                return;
            }
            BaiduMap.this.Z.lock();
            if (BaiduMap.this.X != null && hexagonMap == BaiduMap.this.X) {
                BaiduMap.this.h.f();
                BaiduMap.this.X = null;
                BaiduMap.this.h.n(false);
            }
            BaiduMap.this.Z.unlock();
        }

        @Override // com.baidu.mapapi.map.HexagonMap.b
        public void a(HexagonMap hexagonMap, boolean z) {
            if (BaiduMap.this.h == null || hexagonMap == null) {
                return;
            }
            BaiduMap.this.Z.lock();
            BaiduMap.this.h.o(z);
            BaiduMap.this.Z.unlock();
        }
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        animateMapStatus(mapStatusUpdate, 300);
    }

    public void setCustomTrafficColor(int i2, int i3, int i4, int i5) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.a(i2, i3, i4, i5);
        }
    }

    private Overlay a(Overlay overlay) {
        if (overlay == null || this.q0 || this.i == null || this.h == null) {
            return null;
        }
        this.j.add(overlay);
        overlay.setBmLayer(this.i);
        BmDrawItem drawItem = overlay.toDrawItem();
        this.i.a(drawItem, drawItem.b());
        this.i.b();
        return overlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Overlay overlay) {
        BmLayer bmLayer;
        BmDrawItem bmDrawItemA;
        if (overlay == null || this.q0 || (bmLayer = this.i) == null || (bmDrawItemA = bmLayer.a(overlay.getName())) == null) {
            return;
        }
        this.i.a(bmDrawItemA);
        BmDrawItem drawItem = overlay.toDrawItem();
        this.i.a(drawItem, drawItem.b());
        this.i.b();
    }

    private s a(MapStatusUpdate mapStatusUpdate) {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return null;
        }
        s sVarY = bVar.y();
        MapStatus mapStatusA = mapStatusUpdate.a(this.h, getMapStatus());
        if (mapStatusA == null) {
            return null;
        }
        return mapStatusA.b(sVarY);
    }

    public void hideInfoWindow(InfoWindow infoWindow) {
        MapView mapView;
        Set<InfoWindow> setKeySet = this.c0.keySet();
        if (infoWindow == null || setKeySet.isEmpty() || !setKeySet.contains(infoWindow)) {
            return;
        }
        View view = infoWindow.c;
        if (view != null) {
            int i2 = g.b[this.k0.ordinal()];
            if (i2 == 1) {
                TextureMapView textureMapView = this.i0;
                if (textureMapView != null) {
                    textureMapView.removeView(view);
                }
            } else if (i2 == 2 && (mapView = this.h0) != null) {
                mapView.removeView(view);
            }
        }
        Marker marker = this.c0.get(infoWindow);
        if (marker != null) {
            marker.remove();
            this.b0.remove(marker.f3666a);
        }
        this.c0.remove(infoWindow);
        this.m.remove(infoWindow);
    }

    private final void a(MyLocationConfiguration myLocationConfiguration) {
        Bitmap bitmap;
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        Bitmap bitmap2;
        Bitmap bitmap3;
        com.baidu.mapsdkplatform.comapi.map.b bVar2 = this.h;
        if (bVar2 != null) {
            bVar2.g();
        }
        ArrayList arrayList = new ArrayList();
        if (myLocationConfiguration.isEnableCustom()) {
            if (myLocationConfiguration.getArrow() != null && (bitmap3 = myLocationConfiguration.getArrow().getBitmap()) != null && !bitmap3.isRecycled()) {
                OverlayLocationData overlayLocationData = new OverlayLocationData();
                overlayLocationData.setImage(bitmap3);
                overlayLocationData.setImgHeight(bitmap3.getHeight());
                overlayLocationData.setImgWidth(bitmap3.getWidth());
                overlayLocationData.setImgType("arrowicon");
                overlayLocationData.setImgName("arrowicon_" + bitmap3.hashCode());
                overlayLocationData.setArrowSize(myLocationConfiguration.getArrowSize());
                overlayLocationData.setRotation(1);
                arrayList.add(overlayLocationData);
            }
            if (myLocationConfiguration.getCustomMarker() != null && (bitmap2 = myLocationConfiguration.getCustomMarker().getBitmap()) != null && !bitmap2.isRecycled()) {
                OverlayLocationData overlayLocationData2 = new OverlayLocationData();
                overlayLocationData2.setImage(bitmap2);
                overlayLocationData2.setImgHeight(bitmap2.getHeight());
                overlayLocationData2.setImgWidth(bitmap2.getWidth());
                overlayLocationData2.setImgType("icon");
                overlayLocationData2.setImgName("icon_" + bitmap2.hashCode());
                overlayLocationData2.setMarkerSize(myLocationConfiguration.getMarkerSize());
                overlayLocationData2.setRotation(myLocationConfiguration.isEnableRotation() ? 1 : 0);
                overlayLocationData2.setAnimation(myLocationConfiguration.isNeedAnimation() ? 1 : 0);
                arrayList.add(overlayLocationData2);
            }
            if (myLocationConfiguration.getGifMarker() != null) {
                OverlayLocationData overlayLocationData3 = new OverlayLocationData();
                overlayLocationData3.setImgType("gificon");
                overlayLocationData3.setImgName("gificon");
                overlayLocationData3.setGIFImgPath(myLocationConfiguration.getGifMarker());
                overlayLocationData3.setMarkerSize(myLocationConfiguration.getMarkerSize());
                overlayLocationData3.setRotation(myLocationConfiguration.isEnableRotation() ? 1 : 0);
                overlayLocationData3.setAnimation(myLocationConfiguration.isNeedAnimation() ? 1 : 0);
                arrayList.add(overlayLocationData3);
            }
        } else if (myLocationConfiguration.getCustomMarker() != null && (bitmap = myLocationConfiguration.getCustomMarker().getBitmap()) != null && !bitmap.isRecycled()) {
            OverlayLocationData overlayLocationData4 = new OverlayLocationData();
            overlayLocationData4.setImage(bitmap);
            overlayLocationData4.setImgHeight(bitmap.getHeight());
            overlayLocationData4.setImgWidth(bitmap.getWidth());
            overlayLocationData4.setImgName("icon");
            overlayLocationData4.setRotation(myLocationConfiguration.enableDirection ? 1 : 0);
            arrayList.add(overlayLocationData4);
        }
        if (arrayList.size() <= 0 || (bVar = this.h) == null) {
            return;
        }
        bVar.a(arrayList);
    }

    public BaiduMap(Context context, MapSurfaceView mapSurfaceView, q qVar) {
        this.f = mapSurfaceView;
        com.baidu.mapsdkplatform.comapi.map.b bVar = new com.baidu.mapsdkplatform.comapi.map.b(context, mapSurfaceView, qVar, (String) null, 0);
        this.h = bVar;
        mapSurfaceView.setBaseMap(bVar);
        this.k0 = r.GLSurfaceView;
        b();
    }

    private void b(Overlay overlay) {
        BmLayer bmLayer;
        BmDrawItem bmDrawItem;
        if (overlay == null || this.q0 || (bmLayer = this.i) == null || (bmDrawItem = overlay.mDrawItem) == null) {
            return;
        }
        bmLayer.a(bmDrawItem);
        this.i.b();
        if ((bmDrawItem instanceof BmIconMarker) && ((BmIconMarker) bmDrawItem).d() != null) {
            try {
                ((BmIconMarker) bmDrawItem).d().close();
            } catch (Exception unused) {
                Log.e("BmBitmapResource", "BmBitmapResource close failied");
            }
        }
        try {
            bmDrawItem.close();
        } catch (Exception unused2) {
            Log.e("DrawItem", "DrawItem close failied");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(InfoWindow infoWindow) {
        boolean z;
        MapView mapView;
        if (infoWindow == null || this.q0) {
            return;
        }
        Set<InfoWindow> setKeySet = this.c0.keySet();
        if (!setKeySet.isEmpty() && setKeySet.contains(infoWindow)) {
            View view = infoWindow.c;
            if (view == null || !infoWindow.n) {
                z = true;
            } else {
                view.destroyDrawingCache();
                MapViewLayoutParams mapViewLayoutParamsBuild = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.d).yOffset(infoWindow.j).build();
                int i2 = g.b[this.k0.ordinal()];
                if (i2 == 1) {
                    TextureMapView textureMapView = this.i0;
                    if (textureMapView != null) {
                        textureMapView.addView(view, mapViewLayoutParamsBuild);
                        view.setLayoutParams(mapViewLayoutParamsBuild);
                    }
                } else if (i2 == 2 && (mapView = this.h0) != null) {
                    mapView.addView(view, mapViewLayoutParamsBuild);
                }
                if (infoWindow.m) {
                    z = false;
                }
            }
            BitmapDescriptor bitmapDescriptorA = a(infoWindow);
            Marker marker = this.c0.get(infoWindow);
            if (marker != null) {
                Bundle bundle = new Bundle();
                if (infoWindow.b != null) {
                    marker.type = com.baidu.mapsdkplatform.comapi.map.d.popup;
                    marker.h = bitmapDescriptorA;
                    if (infoWindow.c != null) {
                        bundle.putInt("draw_with_view", 1);
                    } else {
                        bundle.putInt("draw_with_view", 0);
                    }
                }
                marker.g = infoWindow.d;
                marker.t = infoWindow.j;
                marker.a(bundle);
                if (this.h == null || !z || this.q0) {
                    return;
                }
                if (OverlayUtil.isOverlayUpgrade()) {
                    a(marker);
                    return;
                } else {
                    this.h.l(bundle);
                    return;
                }
            }
            return;
        }
        showInfoWindow(infoWindow, false);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements com.baidu.platform.comapi.bmsdk.c {
        public p() {
        }

        @Override // com.baidu.platform.comapi.bmsdk.c
        public void a(BmDrawItem bmDrawItem) {
            InfoWindow.OnInfoWindowClickListener onInfoWindowClickListener;
            if (bmDrawItem instanceof BmArc) {
                BmArc bmArc = (BmArc) bmDrawItem;
                Iterator it = BaiduMap.this.J.iterator();
                while (it.hasNext()) {
                    ((OnArcClickListener) it.next()).onArcClick(bmArc.c());
                }
                return;
            }
            if (bmDrawItem instanceof BmBaseLine) {
                BmBaseLine bmBaseLine = (BmBaseLine) bmDrawItem;
                Iterator it2 = BaiduMap.this.D.iterator();
                while (it2.hasNext()) {
                    ((OnPolylineClickListener) it2.next()).onPolylineClick(bmBaseLine.c());
                }
                return;
            }
            if (bmDrawItem instanceof BmCircle) {
                BmCircle bmCircle = (BmCircle) bmDrawItem;
                bmCircle.e().q = (int) bmCircle.a();
                Iterator it3 = BaiduMap.this.F.iterator();
                while (it3.hasNext()) {
                    ((OnCircleClickListener) it3.next()).onCircleClick(bmCircle.e());
                }
                return;
            }
            if (bmDrawItem instanceof BmPolygon) {
                BmPolygon bmPolygon = (BmPolygon) bmDrawItem;
                bmPolygon.d().w = (int) bmPolygon.a();
                Iterator it4 = BaiduMap.this.G.iterator();
                while (it4.hasNext()) {
                    ((OnPolygonClickListener) it4.next()).onPolygonClick(bmPolygon.d());
                }
                return;
            }
            if (bmDrawItem instanceof BmIconMarker) {
                BmIconMarker bmIconMarker = (BmIconMarker) bmDrawItem;
                String name = bmIconMarker.getName();
                Set<String> setKeySet = BaiduMap.this.b0.keySet();
                if (setKeySet.isEmpty() || !setKeySet.contains(name)) {
                    Iterator it5 = BaiduMap.this.B.iterator();
                    while (it5.hasNext()) {
                        ((OnMarkerClickListener) it5.next()).onMarkerClick(bmIconMarker.e());
                    }
                    Iterator it6 = BaiduMap.this.C.iterator();
                    while (it6.hasNext()) {
                        ((OnMarkerWithBaseUIClickListener) it6.next()).onMarkerClick(bmIconMarker.e());
                    }
                    return;
                }
                for (String str : setKeySet) {
                    if (str != null && str.equals(name)) {
                        InfoWindow infoWindow = (InfoWindow) BaiduMap.this.b0.get(str);
                        if (infoWindow == null || (onInfoWindowClickListener = infoWindow.h) == null) {
                            return;
                        }
                        onInfoWindowClickListener.onInfoWindowClick();
                        return;
                    }
                }
                return;
            }
            if (bmDrawItem instanceof BmTextMarker) {
                BmTextMarker bmTextMarker = (BmTextMarker) bmDrawItem;
                Iterator it7 = BaiduMap.this.I.iterator();
                while (it7.hasNext()) {
                    ((OnTextClickListener) it7.next()).onTextClick(bmTextMarker.d());
                }
                return;
            }
            if (bmDrawItem instanceof BmGround) {
                BmGround bmGround = (BmGround) bmDrawItem;
                Iterator it8 = BaiduMap.this.H.iterator();
                while (it8.hasNext()) {
                    ((OnGroundOverlayClickListener) it8.next()).onGroundOverlayClick(bmGround.c());
                }
                return;
            }
            if (bmDrawItem instanceof BmPrism) {
                return;
            }
            if (bmDrawItem instanceof BmMultiPoint) {
                BmMultiPoint bmMultiPoint = (BmMultiPoint) bmDrawItem;
                int iD = bmMultiPoint.d();
                MultiPoint multiPointE = bmMultiPoint.e();
                if (multiPointE == null) {
                    return;
                }
                Iterator it9 = BaiduMap.this.E.iterator();
                while (it9.hasNext()) {
                    ((OnMultiPointClickListener) it9.next()).onMultiPointClick(bmMultiPoint.e(), multiPointE.getMultiPointItem(iD));
                }
            }
        }

        @Override // com.baidu.platform.comapi.bmsdk.c
        public void a(BmDrawItem bmDrawItem, BmBaseUI bmBaseUI) {
            if (bmDrawItem instanceof BmIconMarker) {
                BmIconMarker bmIconMarker = (BmIconMarker) bmDrawItem;
                for (OnMarkerWithBaseUIClickListener onMarkerWithBaseUIClickListener : BaiduMap.this.C) {
                    if (bmIconMarker.e() != null && bmBaseUI != null && bmBaseUI.a() != null) {
                        onMarkerWithBaseUIClickListener.onMarkerClick(bmIconMarker.e(), bmBaseUI.a());
                    }
                }
                return;
            }
            boolean z = bmDrawItem instanceof Bm3DModel;
        }
    }

    private final void a(MyLocationData myLocationData, MyLocationConfiguration myLocationConfiguration) {
        float f2;
        if (myLocationData == null || myLocationConfiguration == null || !isMyLocationEnabled()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(new LatLng(myLocationData.latitude, myLocationData.longitude));
        try {
            jSONObject.put("type", 0);
            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, geoPointLl2mc.getLongitudeE6());
            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, geoPointLl2mc.getLatitudeE6());
            jSONObject2.put("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(r14, (int) myLocationData.accuracy));
            float f3 = myLocationData.direction;
            if (myLocationConfiguration.enableDirection) {
                f2 = f3 % 360.0f;
                if (f2 > 180.0f) {
                    f2 -= 360.0f;
                } else if (f2 < -180.0f) {
                    f2 += 360.0f;
                }
            } else {
                f2 = -1001.0f;
            }
            jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, f2);
            jSONObject2.put("iconarrownor", "NormalLocArrow");
            if (!myLocationConfiguration.isEnableCustom()) {
                jSONObject2.put("iconarrownorid", 28);
                jSONObject2.put("iconarrowfocid", 29);
            }
            jSONObject2.put("iconarrowfoc", "FocusLocArrow");
            jSONObject2.put("lineid", myLocationConfiguration.accuracyCircleStrokeColor);
            jSONObject2.put("areaid", myLocationConfiguration.accuracyCircleFillColor);
            jSONObject2.put("width", myLocationConfiguration.width);
            jSONArray.put(jSONObject2);
            if (myLocationConfiguration.locationMode == MyLocationConfiguration.LocationMode.COMPASS) {
                jSONObject3.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, geoPointLl2mc.getLongitudeE6());
                jSONObject3.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, geoPointLl2mc.getLatitudeE6());
                jSONObject3.put("radius", 0);
                jSONObject3.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, 0);
                jSONObject3.put("iconarrownor", "direction_wheel");
                jSONObject3.put("iconarrowfoc", "direction_wheel");
                jSONObject3.put("iconarrownorid", 54);
                jSONObject3.put("iconarrowfocid", 54);
                jSONArray.put(jSONObject3);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar != null) {
            bVar.a(jSONObject.toString(), (Bundle) null);
        }
        int i2 = g.f3598a[myLocationConfiguration.locationMode.ordinal()];
        if (i2 == 1) {
            animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().rotate(myLocationData.direction).overlook(-45.0f).target(new LatLng(myLocationData.latitude, myLocationData.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom).build()));
        } else {
            if (i2 != 2) {
                return;
            }
            animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(new LatLng(myLocationData.latitude, myLocationData.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen).build()));
        }
    }

    public void a(HeatMap heatMap) {
        this.Y.lock();
        try {
            HeatMap heatMap2 = this.W;
            if (heatMap2 != null && this.h != null && heatMap == heatMap2) {
                heatMap2.a();
                this.W.c();
                this.W.C = null;
                this.h.e();
                this.W = null;
                this.h.n(false);
            }
        } finally {
            this.Y.unlock();
        }
    }

    private Point a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIntValue = 0;
        int iIntValue2 = 0;
        for (String str2 : str.replaceAll("^\\{", "").replaceAll("\\}$", "").split(",")) {
            String[] strArrSplit = str2.replaceAll("\"", "").split(":");
            if ("x".equals(strArrSplit[0])) {
                iIntValue = Integer.valueOf(strArrSplit[1]).intValue();
            }
            if ("y".equals(strArrSplit[0])) {
                iIntValue2 = Integer.valueOf(strArrSplit[1]).intValue();
            }
        }
        return new Point(iIntValue, iIntValue2);
    }

    private BitmapDescriptor a(InfoWindow infoWindow) {
        View view = infoWindow.c;
        if (view != null && infoWindow.n) {
            if (infoWindow.k) {
                if (infoWindow.l <= 0) {
                    infoWindow.l = SysOSUtil.getDensityDpi();
                }
                return BitmapDescriptorFactory.fromViewWithDpi(infoWindow.c, infoWindow.l);
            }
            return BitmapDescriptorFactory.fromView(view);
        }
        return infoWindow.b;
    }

    public boolean a() {
        com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
        if (bVar == null) {
            return false;
        }
        return bVar.c();
    }

    public void a(TileOverlay tileOverlay) {
        this.a0.lock();
        if (tileOverlay != null) {
            try {
                if (this.V == tileOverlay) {
                    tileOverlay.c();
                    tileOverlay.c = null;
                    com.baidu.mapsdkplatform.comapi.map.b bVar = this.h;
                    if (bVar != null) {
                        bVar.V();
                    }
                }
            } finally {
                this.V = null;
                this.a0.unlock();
            }
        }
    }

    private void a(ParticleEffectType particleEffectType) {
        BitmapDescriptor bitmapDescriptorFromAsset;
        if (ParticleEffectType.Flower == particleEffectType && !b && (bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset("flower.png")) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("total", 1);
            bundle.putBundle(String.format("texture_%d", 0), bitmapDescriptorFromAsset.a());
            if (this.h.a(particleEffectType, bundle)) {
                b = true;
            }
        }
        if (ParticleEffectType.Fireworks != particleEffectType || c) {
            return;
        }
        BitmapDescriptor bitmapDescriptorFromAsset2 = BitmapDescriptorFactory.fromAsset("firework_bullet.png");
        BitmapDescriptor bitmapDescriptorFromAsset3 = BitmapDescriptorFactory.fromAsset("firework_tail.png");
        if (bitmapDescriptorFromAsset2 == null || bitmapDescriptorFromAsset3 == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("total", 2);
        bundle2.putBundle(String.format("texture_%d", 0), bitmapDescriptorFromAsset2.a());
        bundle2.putBundle(String.format("texture_%d", 1), bitmapDescriptorFromAsset3.a());
        if (this.h.a(particleEffectType, bundle2)) {
            c = true;
        }
    }
}
