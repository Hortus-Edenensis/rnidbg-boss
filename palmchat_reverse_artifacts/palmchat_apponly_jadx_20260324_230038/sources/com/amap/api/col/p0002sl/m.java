package com.amap.api.col.p0002sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.amap.api.col.p0002sl.bd;
import com.amap.api.col.p0002sl.bi;
import com.amap.api.col.p0002sl.bk;
import com.amap.api.col.p0002sl.bv;
import com.amap.api.col.p0002sl.u;
import com.amap.api.col.p0002sl.w;
import com.amap.api.interfaces.MapCameraMessage;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.Projection;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlay;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.Polygon;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.maps2d.model.Text;
import com.amap.api.maps2d.model.TextOptions;
import com.amap.api.maps2d.model.TileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.monitor.ErrorCode;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class m extends View implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ah, bk.b, bv.a, u.a, w.a {
    private static int aI = Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 214);
    private static Paint aJ = null;
    private static Bitmap aK = null;
    private o A;
    private AMap.OnMyLocationChangeListener B;
    private boolean C;
    private bl D;
    private cl E;
    private bt F;
    private LocationSource G;
    private y H;
    private l I;
    private boolean J;
    private boolean K;
    private AMap.OnCameraChangeListener L;
    private t M;
    private AMap.CancelableCallback N;
    private be O;
    private boolean P;
    private boolean Q;
    private View R;
    private AMap.OnInfoWindowClickListener S;
    private AMap.InfoWindowAdapter T;
    private bh U;
    private AMap.OnMarkerClickListener V;
    private Drawable W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    bi f2987a;
    private boolean aA;
    private float aB;
    private float aC;
    private int aD;
    private int aE;
    private long aF;
    private int aG;
    private int aH;
    private int aL;
    private boolean aM;
    private a aN;
    private aq aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private AMap.OnMarkerDragListener ae;
    private AMap.OnMapTouchListener af;
    private AMap.OnMapLongClickListener ag;
    private AMap.OnMapLoadedListener ah;
    private AMap.OnMapClickListener ai;
    private boolean aj;
    private AMap.OnMapScreenShotListener ak;
    private Timer al;
    private Thread am;
    private TimerTask an;
    private Handler ao;
    private Handler ap;
    private Point aq;
    private GestureDetector ar;
    private bk.a as;
    private ArrayList<GestureDetector.OnGestureListener> at;
    private ArrayList<bk.b> au;
    private Scroller av;
    private int aw;
    private int ax;
    private Matrix ay;
    private float az;
    public az b;
    float[] c;
    boolean d;
    bb e;
    cm f;
    public bd g;
    protected au h;
    public cd i;
    public bc j;
    final Handler k;
    int l;
    float m;
    private Context n;
    private boolean o;
    private boolean p;
    private Marker q;
    private ak r;
    private final int[] s;
    private boolean t;
    private int u;
    private CameraUpdate v;
    private long w;
    private AMap.CancelableCallback x;
    private ay y;
    private Location z;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        private Context b;
        private AMap.OnCacheRemoveListener c;

        public b(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.b = context;
            this.c = onCacheRemoveListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ct.a(new File(ct.b(this.b)));
            } catch (Throwable th) {
                try {
                    hd.c(th, "AMapDelegateImpGLSurfaceView", "RemoveCacheRunnable");
                    try {
                        AMap.OnCacheRemoveListener onCacheRemoveListener = this.c;
                        if (onCacheRemoveListener != null) {
                            onCacheRemoveListener.onRemoveCacheFinish(false);
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                } finally {
                    try {
                        AMap.OnCacheRemoveListener onCacheRemoveListener2 = this.c;
                        if (onCacheRemoveListener2 != null) {
                            onCacheRemoveListener2.onRemoveCacheFinish(true);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            }
        }
    }

    public m(Context context) {
        super(context);
        this.o = false;
        this.p = true;
        this.s = new int[]{10000000, 5000000, 2000000, 1000000, ErrorCode.REASON_RD_METADATA, ErrorCode.REASON_RD_AUDIO, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.t = true;
        this.u = 1;
        this.c = new float[2];
        this.d = false;
        this.e = new bb(this);
        this.C = false;
        this.I = null;
        this.J = false;
        this.K = false;
        this.N = null;
        this.P = false;
        this.Q = false;
        this.W = null;
        this.ab = false;
        this.ac = false;
        this.ad = false;
        this.aj = false;
        this.ak = null;
        this.al = null;
        this.am = null;
        this.an = new TimerTask() { // from class: com.amap.api.col.2sl.m.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                try {
                    m.this.k.sendEmptyMessage(19);
                } catch (Throwable th) {
                    ct.a(th, "AMapDelegateImpGLSurfaceView", "TimerTask run");
                }
            }
        };
        this.ao = new Handler();
        this.ap = new Handler() { // from class: com.amap.api.col.2sl.m.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f2989a = "onTouchHandler";

            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                try {
                    if (m.this.af != null) {
                        m.this.af.onTouch((MotionEvent) message.obj);
                    }
                } catch (Throwable th) {
                    ct.a(th, "AMapDelegateImpGLSurfaceView", this.f2989a);
                }
            }
        };
        this.k = new Handler() { // from class: com.amap.api.col.2sl.m.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f2990a = "handleMessage";

            /* JADX WARN: Removed duplicated region for block: B:33:0x006b A[Catch: all -> 0x0216, TryCatch #0 {all -> 0x0216, blocks: (B:9:0x0010, B:19:0x0026, B:21:0x002b, B:23:0x0037, B:24:0x003c, B:26:0x0041, B:34:0x0074, B:36:0x007c, B:37:0x008f, B:39:0x0097, B:41:0x009d, B:28:0x004b, B:30:0x0053, B:32:0x005f, B:33:0x006b, B:44:0x00a4, B:47:0x00af, B:52:0x00bd, B:54:0x00ca, B:55:0x00d3, B:57:0x00db, B:59:0x00e3, B:61:0x00ef, B:62:0x010d, B:64:0x0115, B:68:0x0130, B:65:0x011f, B:67:0x0127, B:50:0x00b5, B:70:0x013b, B:72:0x013f, B:74:0x0145, B:75:0x014e, B:77:0x0154, B:79:0x015a, B:82:0x0178, B:84:0x017c, B:85:0x0180, B:87:0x0186, B:89:0x0192, B:92:0x019f, B:94:0x01e6, B:95:0x01e8, B:97:0x01f0, B:99:0x01fe, B:101:0x0207, B:100:0x0202), top: B:106:0x0010, inners: #1 }] */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void handleMessage(Message message) {
                m mVar;
                bi biVar;
                int i;
                bi.b bVar;
                Bitmap bitmapCreateBitmap;
                Bitmap drawingCache;
                if (message == null || (biVar = (mVar = m.this).f2987a) == null || biVar.c == null) {
                    return;
                }
                try {
                    i = message.what;
                } catch (Throwable th) {
                    ct.a(th, "AMapDelegateImpGLSurfaceView", "handle_handleMessage");
                }
                if (i == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Key验证失败：[");
                    Object obj = message.obj;
                    if (obj != null) {
                        sb.append(obj);
                    } else {
                        sb.append(fs.b);
                    }
                    sb.append("]");
                    Log.w("amapsdk", sb.toString());
                    return;
                }
                if (i == 13) {
                    if (mVar.M != null && m.this.M.h() && m.this.M.i() == 2) {
                        v vVarA = v.a(new an(m.this.M.c(), m.this.M.d()), m.this.M.e(), m.this.M.f(), m.this.M.g());
                        if (m.this.M.a()) {
                            vVarA.isChangeFinished = true;
                        }
                        m.this.e.a(vVarA);
                        return;
                    }
                    return;
                }
                if (i == 19) {
                    if (biVar == null || (bVar = biVar.d) == null) {
                        return;
                    }
                    bVar.a();
                    return;
                }
                if (i == 10) {
                    if (mVar.L != null) {
                        m.this.L.onCameraChange(new CameraPosition(m.this.E(), m.this.getZoomLevel(), 0.0f, 0.0f));
                        return;
                    }
                    return;
                }
                if (i == 11) {
                    if (mVar.ah != null) {
                        m.this.ah.onMapLoaded();
                    }
                    m.this.q();
                    return;
                }
                switch (i) {
                    case 15:
                        mVar.D();
                        return;
                    case 16:
                        try {
                            Bitmap bitmap = (Bitmap) message.obj;
                            if (bitmap.isRecycled()) {
                                return;
                            } else {
                                bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
                            }
                            break;
                        } catch (Exception e) {
                            ct.a(e, "AMapDelegateImpGLSurfaceView", this.f2990a);
                            bitmapCreateBitmap = null;
                        }
                        if (bitmapCreateBitmap != null) {
                            Canvas canvas = new Canvas(bitmapCreateBitmap);
                            if (m.this.E != null) {
                                m.this.E.draw(canvas);
                            }
                            if (m.this.R != null && m.this.U != null && (drawingCache = m.this.R.getDrawingCache(true)) != null) {
                                canvas.drawBitmap(drawingCache, m.this.R.getLeft(), m.this.R.getTop(), new Paint());
                            }
                            if (m.this.ak != null) {
                                m.this.ak.onMapScreenShot(bitmapCreateBitmap);
                            }
                        } else if (m.this.ak != null) {
                            m.this.ak.onMapScreenShot(null);
                        }
                        m.this.destroyDrawingCache();
                        m.i(m.this);
                        return;
                    case 17:
                        CameraPosition cameraPositionC = mVar.C();
                        if (m.this.L != null) {
                            m.this.a(cameraPositionC);
                        }
                        String str = z.h;
                        if (str == null || str.trim().length() == 0) {
                            if (cameraPositionC.zoom >= 10.0f) {
                                LatLng latLng = cameraPositionC.target;
                                if (cs.a(latLng.latitude, latLng.longitude)) {
                                    m.this.E.setVisibility(0);
                                } else {
                                    m.this.E.setVisibility(8);
                                }
                            }
                        }
                        if (m.this.N != null) {
                            m.this.J = true;
                            m.this.N.onFinish();
                            m.this.J = false;
                        }
                        if (m.this.K) {
                            m.o(m.this);
                            return;
                        } else {
                            m.n(m.this);
                            return;
                        }
                    default:
                        return;
                }
                ct.a(th, "AMapDelegateImpGLSurfaceView", "handle_handleMessage");
            }
        };
        this.l = 0;
        this.at = new ArrayList<>();
        this.au = new ArrayList<>();
        this.aw = 0;
        this.ax = 0;
        this.ay = new Matrix();
        this.az = 1.0f;
        this.aA = false;
        this.aF = 0L;
        this.aG = 0;
        this.aH = 0;
        this.aL = 0;
        this.aM = false;
        this.aN = null;
        this.m = -1.0f;
        s();
        setClickable(true);
        a(context);
    }

    private static synchronized Paint A() {
        if (aJ == null) {
            Paint paint = new Paint();
            aJ = paint;
            paint.setColor(-7829368);
            aJ.setAlpha(90);
            aJ.setPathEffect(new DashPathEffect(new float[]{2.0f, 2.5f}, 1.0f));
        }
        return aJ;
    }

    private void B() {
        Point point = this.aq;
        if (point == null) {
            return;
        }
        int i = point.x;
        int i2 = this.aG;
        int i3 = point.y;
        int i4 = this.aH;
        point.x = i2;
        point.y = i4;
        this.b.b(i - i2, i3 - i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CameraPosition C() {
        af afVarT = t();
        if (afVarT == null) {
            return null;
        }
        return CameraPosition.fromLatLngZoom(new LatLng(((double) afVarT.b()) / 1000000.0d, ((double) afVarT.a()) / 1000000.0d), getZoomLevel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D() {
        if (this.F == null) {
            return;
        }
        if (this.m == -1.0f) {
            int width = getWidth();
            int height = getHeight();
            int i = this.n.getResources().getDisplayMetrics().densityDpi;
            int i2 = 120;
            if (i <= 120) {
                i2 = 100;
                this.m = i2 / 100.0f;
            } else {
                if (i <= 160) {
                    if (Math.max(width, height) > 480) {
                    }
                } else if (i <= 240) {
                    i2 = Math.min(width, height) >= 1000 ? 60 : 70;
                } else {
                    i2 = 50;
                    if (i > 320 && i > 480) {
                        i2 = 40;
                    }
                }
                this.m = i2 / 100.0f;
            }
        }
        LatLng latLngE = E();
        if (latLngE == null) {
            return;
        }
        float zoomLevel = getZoomLevel();
        float f = this.m;
        double dCos = (float) ((((Math.cos((latLngE.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, zoomLevel) * 256.0d));
        int i3 = this.s[(int) zoomLevel];
        int i4 = (int) (((double) i3) / (dCos * ((double) f)));
        String strA = ct.a(i3);
        this.F.a(i4);
        this.F.a(strA);
        this.F.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LatLng E() {
        if (t() == null) {
            return null;
        }
        return new LatLng(aa.a(r0.b()), aa.a(r0.a()));
    }

    private an F() {
        af afVarT = t();
        if (afVarT == null) {
            return null;
        }
        an anVar = new an();
        anVar.f2618a = (int) afVarT.e();
        anVar.b = (int) afVarT.f();
        return anVar;
    }

    public static /* synthetic */ AMap.OnMapScreenShotListener i(m mVar) {
        mVar.ak = null;
        return null;
    }

    public static /* synthetic */ AMap.CancelableCallback n(m mVar) {
        mVar.N = null;
        return null;
    }

    public static /* synthetic */ boolean o(m mVar) {
        mVar.K = false;
        return false;
    }

    private bl r() {
        return this.D;
    }

    private void s() {
        Method method;
        Method[] methods = View.class.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                method = null;
                break;
            }
            method = methods[i];
            if (method != null && method.getName().equals("setLayerType")) {
                break;
            } else {
                i++;
            }
        }
        if (method != null) {
            try {
                method.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(null)), null);
            } catch (Exception e) {
                ct.a(e, "AMapDelegateImpGLSurfaceView", "setLayerType");
            }
        }
    }

    private af t() {
        bi.c cVar;
        bi biVar = this.f2987a;
        if (biVar == null || (cVar = biVar.c) == null) {
            return null;
        }
        return cVar.f();
    }

    private void u() {
        b(this.n);
        this.g.addView(this, 0, new ViewGroup.LayoutParams(-1, -1));
    }

    private boolean v() {
        aw awVarB;
        bi biVar = this.f2987a;
        if (biVar == null || biVar.e == null || (awVarB = a().e.b(a().e.h)) == null) {
            return false;
        }
        return awVarB.a();
    }

    private boolean w() {
        if (a() == null) {
            return false;
        }
        aw awVarB = a().e.b(a().e.i);
        if (awVarB != null) {
            return awVarB.a();
        }
        return false;
    }

    private void x() {
        this.f2987a.a();
        az azVar = this.b;
        if (azVar != null) {
            azVar.g();
            this.b.h();
        }
        this.b = null;
        this.f2987a = null;
    }

    private void y() {
        if (this.P) {
            this.P = false;
        }
        if (this.ad) {
            this.ad = false;
            v vVarA = v.a();
            vVarA.isChangeFinished = true;
            this.e.a(vVarA);
        }
        if (this.Q) {
            this.Q = false;
            v vVarA2 = v.a();
            vVarA2.isChangeFinished = true;
            this.e.a(vVarA2);
        }
        this.ac = false;
        Marker marker = this.q;
        if (marker != null) {
            AMap.OnMarkerDragListener onMarkerDragListener = this.ae;
            if (onMarkerDragListener != null) {
                onMarkerDragListener.onMarkerDragEnd(marker);
            }
            this.q = null;
            this.r = null;
        }
    }

    private static int z() {
        return aI;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void AMapInvalidate() {
        postInvalidate();
        this.g.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        try {
            bi biVar = this.f2987a;
            if (biVar == null) {
                return null;
            }
            ai aiVarA = biVar.f.a(circleOptions);
            postInvalidate();
            if (aiVarA != null) {
                return new Circle(aiVarA);
            }
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "addCircle");
        }
        return null;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        try {
            bi biVar = this.f2987a;
            if (biVar == null) {
                return null;
            }
            aj ajVarA = biVar.f.a(groundOverlayOptions);
            postInvalidate();
            if (ajVarA != null) {
                return new GroundOverlay(ajVarA);
            }
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "addGroundOverlay");
        }
        return null;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        if (markerOptions == null) {
            return null;
        }
        try {
            bh bhVar = new bh(markerOptions, this.j);
            this.j.a(bhVar);
            postInvalidate();
            return new Marker(bhVar);
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "addMarker");
            return null;
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        bi biVar;
        ae aeVar;
        try {
            biVar = this.f2987a;
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "addPolygon");
        }
        if (biVar != null && (aeVar = biVar.f) != null) {
            ao aoVarA = aeVar.a(polygonOptions);
            postInvalidate();
            if (aoVarA != null) {
                return new Polygon(aoVarA);
            }
            return null;
        }
        return null;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        try {
            if (this.f2987a == null) {
                return null;
            }
            ap apVarA = a().f.a(polylineOptions);
            postInvalidate();
            if (apVarA != null) {
                return new Polyline(apVarA);
            }
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "addPolyline");
        }
        return null;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final Text addText(TextOptions textOptions) throws RemoteException {
        by byVar = new by(this, textOptions, this.j);
        this.j.a(byVar);
        postInvalidate();
        return new Text(byVar);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        if (this.f2987a == null) {
            return null;
        }
        cd cdVar = this.i;
        bi biVar = this.f2987a;
        cc ccVar = new cc(tileOverlayOptions, cdVar, biVar.h, biVar);
        this.i.a(ccVar);
        postInvalidate();
        return new TileOverlay(ccVar);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithCallback(cameraUpdate, null);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        try {
            animateCameraWithDurationAndCallback(cameraUpdate, 250L, cancelableCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        MapCameraMessage cameraUpdateFactoryDelegate = cameraUpdate.getCameraUpdateFactoryDelegate();
        MapCameraMessage.Type type = cameraUpdateFactoryDelegate.nowType;
        MapCameraMessage.Type type2 = MapCameraMessage.Type.newLatLngBounds;
        if (type == type2 && !ct.a(getWidth(), getHeight())) {
            this.v = cameraUpdate;
            this.w = j;
            this.x = cancelableCallback;
            return;
        }
        az azVar = this.b;
        if (azVar == null) {
            return;
        }
        if (cancelableCallback != null) {
            try {
                this.N = cancelableCallback;
            } catch (Throwable th) {
                ct.a(th, "AMapDelegateImpGLSurfaceView", "animateCameraWithDurationAndCallback");
                return;
            }
        }
        if (azVar.i()) {
            this.b.j();
        }
        if (cancelableCallback != null) {
            this.N = cancelableCallback;
        }
        if (this.J) {
            this.K = true;
        }
        MapCameraMessage.Type type3 = cameraUpdateFactoryDelegate.nowType;
        if (type3 == MapCameraMessage.Type.scrollBy) {
            m();
            if (this.f2987a != null && this.o) {
                this.b.a((int) cameraUpdateFactoryDelegate.xPixel, (int) cameraUpdateFactoryDelegate.yPixel, (int) j);
                postInvalidate();
                return;
            }
            return;
        }
        if (type3 == MapCameraMessage.Type.zoomIn) {
            this.b.a((int) j);
            return;
        }
        if (type3 == MapCameraMessage.Type.zoomOut) {
            this.b.b((int) j);
            return;
        }
        if (type3 == MapCameraMessage.Type.zoomTo) {
            this.b.a(cameraUpdateFactoryDelegate.zoom, (int) j);
            return;
        }
        if (type3 == MapCameraMessage.Type.zoomBy) {
            float f = cameraUpdateFactoryDelegate.amount;
            Point point = cameraUpdateFactoryDelegate.focus;
            if (point == null) {
                point = new Point(bi.c.c() / 2, bi.c.d() / 2);
            }
            a(f, point, true, j);
            return;
        }
        if (type3 == MapCameraMessage.Type.newCameraPosition) {
            CameraPosition cameraPosition = cameraUpdateFactoryDelegate.cameraPosition;
            this.b.a(cameraPosition.zoom);
            LatLng latLng = cameraPosition.target;
            this.b.a(new af((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d)), (int) j);
            return;
        }
        if (type3 == MapCameraMessage.Type.changeCenter) {
            LatLng latLng2 = cameraUpdateFactoryDelegate.cameraPosition.target;
            this.b.a(new af((int) (latLng2.latitude * 1000000.0d), (int) (latLng2.longitude * 1000000.0d)), (int) j);
            return;
        }
        if (type3 != type2 && type3 != MapCameraMessage.Type.newLatLngBoundsWithSize) {
            cameraUpdateFactoryDelegate.isChangeFinished = true;
            this.e.a((v) cameraUpdateFactoryDelegate);
            return;
        }
        m();
        a(cameraUpdateFactoryDelegate, true, j);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void clear() throws RemoteException {
        try {
            d();
            bi biVar = this.f2987a;
            if (biVar == null) {
                return;
            }
            biVar.f.a();
            this.j.c();
            this.i.b();
            bl blVar = this.D;
            if (blVar != null) {
                blVar.a();
            }
            postInvalidate();
        } catch (Exception e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "clear");
            Log.d("amapApi", "AMapDelegateImpGLSurfaceView clear erro" + e.getMessage());
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "clear");
        }
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (!this.av.computeScrollOffset() || !this.av.isFinished()) {
            super.computeScroll();
            return;
        }
        int currX = this.av.getCurrX() - this.aw;
        int currY = this.av.getCurrY() - this.ax;
        this.aw = this.av.getCurrX();
        this.ax = this.av.getCurrY();
        bi biVar = this.f2987a;
        bi.d dVar = biVar.b;
        Point point = biVar.h.n;
        af afVarA = dVar.a(point.x + currX, point.y + currY);
        if (!this.av.isFinished()) {
            this.f2987a.c.b(afVarA);
            return;
        }
        u.a().b();
        if (this.L != null) {
            a(C());
        }
        this.f2987a.c.a(false);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void destroy() {
        try {
            Timer timer = this.al;
            if (timer != null) {
                timer.cancel();
                this.al = null;
            }
            TimerTask timerTask = this.an;
            if (timerTask != null) {
                timerTask.cancel();
                this.an = null;
            }
            Handler handler = this.ap;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.k;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            Thread thread = this.am;
            if (thread != null) {
                thread.interrupt();
                this.am = null;
            }
            LocationSource locationSource = this.G;
            if (locationSource != null) {
                locationSource.deactivate();
                this.G = null;
            }
            w.a().b(this);
            bv.a().a(this);
            u.a().b(this);
            this.f.a();
            this.F.a();
            this.E.b();
            this.y.a();
            this.H.a();
            this.f2987a.f.b();
            this.j.f();
            Drawable drawable = this.W;
            if (drawable != null) {
                drawable.setCallback(null);
            }
            this.g.removeAllViews();
            d();
            cd cdVar = this.i;
            if (cdVar != null) {
                cdVar.f();
            }
            bi biVar = this.f2987a;
            if (biVar != null) {
                biVar.d.b();
                x();
            }
            this.G = null;
            this.ai = null;
            z.h = null;
            z.g = null;
            hd.b();
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "destroy");
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final Projection getAMapProjection() throws RemoteException {
        return new Projection(this.aa);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final UiSettings getAMapUiSettings() throws RemoteException {
        return new UiSettings(this.h);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final CameraPosition getCameraPosition() throws RemoteException {
        LatLng latLngE = E();
        if (latLngE == null) {
            return null;
        }
        return CameraPosition.builder().target(latLngE).zoom(getZoomLevel()).build();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final int getLogoPosition() {
        return this.E.a();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final Handler getMainHandler() {
        return this.k;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final LatLngBounds getMapBounds() {
        return null;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final int getMapHeight() {
        bi biVar = this.f2987a;
        if (biVar == null || biVar.c == null) {
            return 0;
        }
        return bi.c.d();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final List<Marker> getMapScreenMarkers() {
        return !ct.a(getWidth(), getHeight()) ? new ArrayList() : this.j.g();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener) {
        this.ak = onMapScreenShotListener;
        this.ab = true;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final int getMapType() throws RemoteException {
        return this.u;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final int getMapWidth() {
        bi biVar = this.f2987a;
        if (biVar == null || biVar.c == null) {
            return 0;
        }
        return bi.c.c();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final float getMaxZoomLevel() {
        bi.c cVar;
        bi biVar = this.f2987a;
        return (biVar == null || (cVar = biVar.c) == null) ? z.c : cVar.a();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final float getMinZoomLevel() {
        bi.c cVar;
        bi biVar = this.f2987a;
        return (biVar == null || (cVar = biVar.c) == null) ? z.d : cVar.b();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final Location getMyLocation() throws RemoteException {
        o oVar;
        if (this.G == null || (oVar = this.A) == null) {
            return null;
        }
        return oVar.f3040a;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        return this.L;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final float getScalePerPixel() {
        int width = getWidth();
        ab abVar = new ab();
        ab abVar2 = new ab();
        a(0, 0, abVar);
        a(width, 0, abVar2);
        return (float) (ct.a(new LatLng(abVar.b, abVar.f2610a), new LatLng(abVar2.b, abVar2.f2610a)) / ((double) width));
    }

    @Override // com.amap.api.interfaces.IAMap
    public final View getView() throws RemoteException {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final float getZoomLevel() {
        bi.c cVar;
        bi biVar = this.f2987a;
        if (biVar == null || (cVar = biVar.c) == null) {
            return 0.0f;
        }
        try {
            return cVar.e();
        } catch (Exception e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "getZoomLevel");
            return 0.0f;
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final boolean isMyLocationEnabled() throws RemoteException {
        return this.C;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final boolean isTrafficEnabled() throws RemoteException {
        return w();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        this.I.a(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        bi.c cVar;
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return true;
            }
        } catch (RemoteException e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "onDoubleTap");
        }
        if (this.t) {
            if (this.h.isZoomInByScreenCenter()) {
                this.b.e();
            } else {
                this.b.a((int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
        if (this.aL > 1) {
            return true;
        }
        this.aM = true;
        bi biVar = this.f2987a;
        if (biVar != null && (cVar = biVar.c) != null) {
            this.f.a(cVar.e() + 1.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.ad = false;
        if (!this.aM && !this.M.a()) {
            this.M.b();
            AMap.CancelableCallback cancelableCallback = this.N;
            if (cancelableCallback != null) {
                cancelableCallback.onCancel();
            }
            this.N = null;
        }
        this.aM = false;
        this.aL = 0;
        Point point = this.aq;
        if (point == null) {
            this.aq = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            return true;
        }
        point.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        bi.a aVar;
        bi.c cVar;
        try {
            Paint paintA = A();
            canvas.drawColor(z());
            int width = getWidth();
            int height = getHeight();
            int i = width > height ? width : height;
            float left = getLeft();
            float top = getTop();
            for (int i2 = 0; i2 < i; i2 += 256) {
                float f = i2;
                canvas.drawLine(left, f, left + getWidth(), f, paintA);
                canvas.drawLine(f, top, f, top + getHeight(), paintA);
            }
            if (this.ab) {
                setDrawingCacheEnabled(true);
                buildDrawingCache();
                Bitmap drawingCache = getDrawingCache();
                Message messageObtainMessage = this.k.obtainMessage();
                messageObtainMessage.what = 16;
                messageObtainMessage.obj = drawingCache;
                this.k.sendMessage(messageObtainMessage);
                this.ab = false;
            }
            bi biVar = this.f2987a;
            if (biVar != null && (cVar = biVar.c) != null) {
                cVar.a(getWidth(), getHeight());
            }
            bi biVar2 = this.f2987a;
            if (biVar2 != null && (aVar = biVar2.e) != null) {
                aVar.a(canvas, this.ay, this.aB, this.aC);
            }
            if (!this.M.a()) {
                this.k.sendEmptyMessage(13);
            }
            if (this.aj) {
                return;
            }
            this.k.sendEmptyMessage(11);
            this.aj = true;
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "onDraw");
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.as.k && motionEvent.getEventTime() - this.as.o >= 30) {
            postInvalidate();
            this.ad = false;
            try {
                if (!this.h.isScrollGesturesEnabled()) {
                    return true;
                }
            } catch (RemoteException e) {
                ct.a(e, "AMapDelegateImpGLSurfaceView", "onFling");
            }
            this.N = null;
            int i = this.aD;
            int i2 = this.aE;
            this.av.fling(this.aw, this.ax, (((int) (-f)) * 3) / 5, (((int) (-f2)) * 3) / 5, -i, i, -i2, i2);
        }
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f2987a == null) {
            return true;
        }
        return this.o && this.b.onKey(this, i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f2987a == null) {
            return true;
        }
        return this.o && this.b.onKey(this, i, keyEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        try {
            this.ad = false;
            if (this.ag != null) {
                ab abVar = new ab();
                a((int) motionEvent.getX(), (int) motionEvent.getY(), abVar);
                this.ag.onMapLongClick(new LatLng(abVar.b, abVar.f2610a));
                this.P = true;
            }
            ak akVarA = this.j.a(motionEvent);
            this.r = akVarA;
            if (akVarA == null) {
                return;
            }
            this.q = new Marker(akVarA);
            ak akVar = this.r;
            if (akVar == null || !akVar.isDraggable()) {
                return;
            }
            this.r.a(a(this.r.getRealPosition()));
            this.j.c(this.r);
            AMap.OnMarkerDragListener onMarkerDragListener = this.ae;
            if (onMarkerDragListener != null) {
                onMarkerDragListener.onMarkerDragStart(this.q);
            }
            this.ac = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void onPause() {
        bi.b bVar;
        bi biVar = this.f2987a;
        if (biVar != null && (bVar = biVar.d) != null) {
            bVar.d();
        }
        cd cdVar = this.i;
        if (cdVar != null) {
            cdVar.d();
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void onResume() {
        bi.b bVar;
        bi biVar = this.f2987a;
        if (biVar != null && (bVar = biVar.d) != null) {
            bVar.c();
        }
        cd cdVar = this.i;
        if (cdVar != null) {
            cdVar.e();
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.as.k && motionEvent2.getEventTime() - this.as.o >= 30) {
            try {
                if (!this.h.isScrollGesturesEnabled()) {
                    this.ad = false;
                    return true;
                }
            } catch (RemoteException e) {
                ct.a(e, "AMapDelegateImpGLSurfaceView", "onScroll");
            }
            if (this.aL > 1) {
                this.ad = false;
                return true;
            }
            this.ad = true;
            b((int) motionEvent2.getX(), (int) motionEvent2.getY());
            postInvalidate();
            m();
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        LatLng realPosition;
        if (this.b == null || this.f2987a == null) {
            return false;
        }
        Iterator<GestureDetector.OnGestureListener> it = this.at.iterator();
        while (it.hasNext()) {
            it.next().onSingleTapUp(motionEvent);
        }
        this.ad = false;
        if (this.P) {
            this.P = false;
            return true;
        }
        try {
            if (this.R != null && bc.a(new Rect(this.R.getLeft(), this.R.getTop(), this.R.getRight(), this.R.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY()) && this.S != null) {
                ak akVarE = this.j.e();
                if (!akVarE.isVisible()) {
                    return true;
                }
                this.S.onInfoWindowClick(new Marker(akVarE));
                return true;
            }
            if (!this.j.b(motionEvent)) {
                if (this.ai != null) {
                    ab abVar = new ab();
                    a((int) motionEvent.getX(), (int) motionEvent.getY(), abVar);
                    this.ai.onMapClick(new LatLng(abVar.b, abVar.f2610a));
                }
                return true;
            }
            ak akVarE2 = this.j.e();
            if (akVarE2 != null && akVarE2.isVisible()) {
                Marker marker = new Marker(akVarE2);
                AMap.OnMarkerClickListener onMarkerClickListener = this.V;
                if (onMarkerClickListener != null) {
                    if (onMarkerClickListener.onMarkerClick(marker) || this.j.b() <= 0) {
                        this.j.c(akVarE2);
                        return true;
                    }
                    try {
                        if (this.j.e() != null && !akVarE2.isViewMode() && (realPosition = akVarE2.getRealPosition()) != null) {
                            this.b.a(ct.a(realPosition));
                            u.a().b();
                        }
                    } catch (Throwable th) {
                        ct.a(th, "AMapDelegateImpGLSurfaceView", "onSingleTapConfirmed");
                    }
                }
                a(akVarE2);
                this.j.c(akVarE2);
            }
            return true;
        } catch (Throwable th2) {
            ct.a(th2, "AMapDelegateImpGLSurfaceView", "onSingleTapConfirmed");
            return true;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2987a.h.a(new Point(i / 2, i2 / 2));
        this.f2987a.c.a(i, i2);
        if (this.b.a() != 0.0f && this.b.b() != 0.0f) {
            az azVar = this.b;
            azVar.a(azVar.a(), this.b.b());
            this.b.c();
            this.b.d();
        }
        redrawInfoWindow();
        try {
            postDelayed(new Runnable() { // from class: com.amap.api.col.2sl.m.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (m.this.E != null) {
                        m.this.E.d();
                    }
                }
            }, 20L);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!z.r || this.f2987a == null) {
            return true;
        }
        if (!this.o) {
            return false;
        }
        if (this.af != null) {
            this.ap.removeMessages(1);
            Message messageObtainMessage = this.ap.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.obj = MotionEvent.obtain(motionEvent);
            messageObtainMessage.sendToTarget();
        }
        b(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void redrawInfoWindow() {
        View view = this.R;
        if (view == null || this.U == null) {
            return;
        }
        bd.a aVar = (bd.a) view.getLayoutParams();
        if (aVar != null) {
            aVar.b = this.U.getRealPosition();
        }
        this.g.a();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final boolean removeGLOverlay(String str) throws RemoteException {
        bi biVar = this.f2987a;
        if (biVar == null) {
            return false;
        }
        try {
            return biVar.f.b(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final boolean removeMarker(String str) {
        ak akVarA;
        try {
            akVarA = this.j.a(str);
        } catch (RemoteException e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "removeMarker");
            akVarA = null;
        }
        if (akVarA != null) {
            return this.j.b(akVarA);
        }
        return false;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void removecache() {
        removecache(null);
    }

    @Override // android.view.View
    public final void setClickable(boolean z) {
        this.o = z;
        super.setClickable(z);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        this.T = infoWindowAdapter;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setLocationSource(LocationSource locationSource) throws RemoteException {
        if (this.y == null) {
            return;
        }
        LocationSource locationSource2 = this.G;
        if (locationSource2 != null && (locationSource2 instanceof n)) {
            locationSource2.deactivate();
        }
        this.G = locationSource;
        if (locationSource != null) {
            this.y.a(true);
        } else {
            this.y.a(false);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setLogoPosition(int i) {
        cl clVar = this.E;
        if (clVar != null) {
            clVar.a(i);
            this.E.postInvalidate();
            if (this.F.getVisibility() == 0) {
                this.F.postInvalidate();
            }
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setMapLanguage(String str) throws RemoteException {
        bi biVar = this.f2987a;
        if (biVar == null || biVar.e == null || v()) {
            return;
        }
        this.f2987a.e.a(str);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setMapType(int i) throws RemoteException {
        if (i == 2) {
            this.u = 2;
            a(true);
            this.E.a(true);
        } else {
            this.u = 1;
            a(false);
            this.E.a(false);
        }
        postInvalidate();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setMyLocationEnabled(boolean z) throws RemoteException {
        try {
            LocationSource locationSource = this.G;
            if (locationSource == null) {
                this.y.a(false);
            } else if (z) {
                locationSource.activate(this.A);
                this.y.a(true);
                if (this.D == null) {
                    this.D = new bl(this, this.n);
                }
            } else {
                bl blVar = this.D;
                if (blVar != null) {
                    blVar.a();
                    this.D = null;
                }
                this.G.deactivate();
                this.y.a(false);
            }
            if (!z) {
                this.h.setMyLocationButtonEnabled(z);
            }
            this.C = z;
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImpGLSurfaceView", "setMyLocationEnabled");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setMyLocationRotateAngle(float f) throws RemoteException {
        bl blVar = this.D;
        if (blVar != null) {
            blVar.a(f);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (r() == null) {
            this.D = new bl(this, this.n);
        }
        if (this.D != null) {
            if (myLocationStyle.getInterval() < 1000) {
                myLocationStyle.interval(1000L);
            }
            LocationSource locationSource = this.G;
            if (locationSource != null && (locationSource instanceof n)) {
                ((n) locationSource).a(myLocationStyle.getInterval());
                ((n) this.G).a(myLocationStyle.getMyLocationType());
            }
            this.D.a(myLocationStyle);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setMyLocationType(int i) {
        bl blVar = this.D;
        if (blVar != null) {
            blVar.a(i);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        this.L = onCameraChangeListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        this.S = onInfoWindowClickListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        this.ai = onMapClickListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        this.ag = onMapLongClickListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        this.af = onMapTouchListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        this.ah = onMapLoadedListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        this.V = onMarkerClickListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        this.ae = onMarkerDragListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        this.B = onMyLocationChangeListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setTrafficEnabled(boolean z) throws RemoteException {
        b(z);
        postInvalidate();
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setZoomPosition(int i) {
        cm cmVar = this.f;
        if (cmVar != null) {
            cmVar.a(i);
            this.f.postInvalidate();
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void showCompassEnabled(boolean z) {
        if (z) {
            this.H.setVisibility(0);
        } else {
            this.H.setVisibility(8);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void showMyLocationButtonEnabled(boolean z) {
        if (z) {
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(8);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void showMyLocationOverlay(Location location) {
        if (location == null) {
            return;
        }
        try {
            if (isMyLocationEnabled() && this.G != null) {
                if (this.D == null) {
                    this.D = new bl(this, this.n);
                }
                if (this.D != null && location.getLongitude() != 0.0d && location.getLatitude() != 0.0d) {
                    this.D.a(location);
                }
                AMap.OnMyLocationChangeListener onMyLocationChangeListener = this.B;
                if (onMyLocationChangeListener != null) {
                    onMyLocationChangeListener.onMyLocationChange(location);
                }
                this.z = new Location(location);
                return;
            }
            bl blVar = this.D;
            if (blVar != null) {
                blVar.a();
            }
            this.D = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void showScaleEnabled(boolean z) {
        if (z) {
            this.F.setVisibility(0);
            n();
        } else {
            this.F.a("");
            this.F.a(0);
            this.F.setVisibility(8);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void showZoomControlsEnabled(boolean z) {
        if (z) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void stopAnimation() throws RemoteException {
        if (this.b == null) {
            return;
        }
        if (!this.M.a()) {
            this.M.b();
            u.a().b();
            AMap.CancelableCallback cancelableCallback = this.N;
            if (cancelableCallback != null) {
                cancelableCallback.onCancel();
            }
            this.N = null;
        }
        this.b.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            CameraUpdate cameraUpdate = this.v;
            if (cameraUpdate != null) {
                animateCameraWithDurationAndCallback(cameraUpdate, this.w, this.x);
                this.v = null;
                this.w = 0L;
                this.x = null;
            }
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "handleUnHandleMessage");
        }
    }

    public final au b() throws RemoteException {
        return this.h;
    }

    @Override // com.amap.api.col.p0002sl.ah
    public final bq c() {
        bi biVar = this.f2987a;
        if (biVar == null) {
            return null;
        }
        return biVar.b;
    }

    public final void d() {
        View view = this.R;
        if (view != null) {
            view.clearFocus();
            this.R.destroyDrawingCache();
            bd bdVar = this.g;
            if (bdVar != null) {
                bdVar.removeView(this.R);
            }
            Drawable background = this.R.getBackground();
            if (background != null) {
                background.setCallback(null);
            }
            this.R = null;
        }
        this.U = null;
    }

    public final Point e() {
        return this.E.c();
    }

    public final boolean f() {
        return this.p;
    }

    public final az g() {
        return this.b;
    }

    public final bk h() {
        return this.as;
    }

    public final float i() {
        return this.az;
    }

    public final void j() {
        this.aB = 0.0f;
        this.aC = 0.0f;
    }

    @Override // com.amap.api.col.2sl.bk.b
    public final boolean k() {
        this.aA = false;
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "endScale");
        }
        u.a().b();
        return true;
    }

    @Override // com.amap.api.col.2sl.bk.b
    public final boolean l() {
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "startScale");
        }
        try {
            if (!b().isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e2) {
            ct.a(e2, "AMapDelegateImpGLSurfaceView", "startScale");
        }
        bi biVar = this.f2987a;
        if (biVar != null && biVar.e != null) {
            biVar.a(this.p);
            this.f2987a.e.a(true);
            this.f2987a.e.c = true;
        }
        this.aA = true;
        return true;
    }

    public final void m() {
        this.k.sendEmptyMessage(10);
    }

    public final void n() {
        this.k.sendEmptyMessage(15);
    }

    @Override // com.amap.api.col.2sl.w.a
    public final void o() {
        AMap.CancelableCallback cancelableCallback = this.N;
        if (cancelableCallback != null) {
            cancelableCallback.onCancel();
            this.N = null;
        }
    }

    @Override // com.amap.api.col.2sl.u.a
    public final void p() {
        this.k.sendEmptyMessage(17);
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) {
        if (this.ao != null) {
            try {
                b bVar = new b(this.n, onCacheRemoveListener);
                this.ao.removeCallbacks(bVar);
                this.ao.post(bVar);
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImpGLSurfaceView", "removecache");
                th.printStackTrace();
            }
        }
    }

    private void e(float f) {
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return;
            }
        } catch (RemoteException e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "doScale");
        }
        bi biVar = this.f2987a;
        if (biVar == null || biVar.c == null) {
            return;
        }
        this.aL = 2;
        int iC = bi.c.c() / 2;
        int iD = bi.c.d() / 2;
        float fA = a((float) (((double) this.f2987a.c.e()) + (Math.log(f) / Math.log(2.0d))));
        if (fA != this.f2987a.c.e()) {
            float[] fArr = this.c;
            float f2 = fArr[1];
            fArr[0] = f2;
            fArr[1] = fA;
            if (f2 != fA) {
                af afVarA = this.f2987a.b.a(iC, iD);
                this.f2987a.c.a(fA);
                this.f2987a.c.a(afVarA);
                D();
            }
        }
    }

    public final boolean b(ak akVar) {
        bh bhVar = this.U;
        if (bhVar == null || this.R == null || akVar == null) {
            return false;
        }
        return bhVar.getId().equals(akVar.getId());
    }

    @Override // com.amap.api.col.p0002sl.ah
    public final bi a() {
        return this.f2987a;
    }

    @Override // com.amap.api.col.2sl.bk.b
    public final boolean c(float f) {
        bi.a aVar;
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "onScale");
        }
        bi biVar = this.f2987a;
        if (biVar != null && (aVar = biVar.e) != null) {
            aVar.c = false;
        }
        m();
        e(f);
        this.aA = false;
        postInvalidateDelayed(8L);
        this.f2987a.a(true);
        return true;
    }

    private void b(boolean z) {
        if (z == w() || this.f2987a == null) {
            return;
        }
        String str = a().e.i;
        if (!z) {
            a().e.a(str, false);
            a().c.a(false);
            return;
        }
        if (a().e.b(str) != null) {
            a().e.a(str, true);
            a().c.a(false);
            return;
        }
        aw awVar = new aw(this.O);
        awVar.q = new ce(this.f2987a, awVar);
        awVar.g = true;
        awVar.i = 120000L;
        awVar.j = new cj() { // from class: com.amap.api.col.2sl.m.5
            @Override // com.amap.api.col.p0002sl.cj
            public final String a(int i, int i2, int i3) {
                return bg.a().c() + "/trafficengine/mapabc/traffictile?v=w2.61&zoom=" + (17 - i3) + "&x=" + i + "&y=" + i2;
            }
        };
        awVar.b = str;
        awVar.e = false;
        awVar.a(true);
        awVar.f = false;
        awVar.c = 18;
        awVar.d = 9;
        a().e.a(awVar, getContext());
        a().e.a(str, true);
        a().c.a(false);
    }

    public final float a(float f) {
        bi.c cVar;
        bi biVar = this.f2987a;
        if (biVar == null || (cVar = biVar.c) == null) {
            return f;
        }
        if (f < cVar.b()) {
            f = this.f2987a.c.b();
        }
        return f > ((float) this.f2987a.c.a()) ? this.f2987a.c.a() : f;
    }

    public final void a(float f, Point point, boolean z, long j) {
        if (this.b == null || this.f2987a == null) {
            return;
        }
        float zoomLevel = getZoomLevel();
        float fB = ct.b(zoomLevel + f);
        if (fB - zoomLevel <= 0.0f) {
            return;
        }
        new an();
        an anVarF = F();
        if (point == null || anVarF == null) {
            return;
        }
        an anVar = new an();
        a(point.x, point.y, anVar);
        int i = anVarF.f2618a - anVar.f2618a;
        int i2 = anVarF.b - anVar.b;
        double d = i;
        double d2 = f;
        int iPow = (int) ((d / Math.pow(2.0d, d2)) - d);
        double d3 = i2;
        int iPow2 = (int) ((d3 / Math.pow(2.0d, d2)) - d3);
        int i3 = anVar.f2618a + iPow;
        anVarF.f2618a = i3;
        int i4 = anVar.b + iPow2;
        anVarF.b = i4;
        af afVarB = be.b(new af(i4, i3, false));
        if (z) {
            this.b.a(fB, point.x, point.y, (int) j);
        } else {
            this.b.a(afVarB);
            u.a().b();
        }
    }

    private void d(float f) {
        this.az = f;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // com.amap.api.interfaces.IAMap
    public final void setZOrderOnTop(boolean z) throws RemoteException {
    }

    private void b(Context context) {
        this.aq = null;
        this.ar = new GestureDetector(context, this);
        this.as = bk.a(this);
        this.av = new Scroller(context);
        new DisplayMetrics();
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        this.aD = i;
        int i2 = displayMetrics.heightPixels;
        this.aE = i2;
        this.aw = i / 2;
        this.ax = i2 / 2;
    }

    public final void a(ak akVar) throws RemoteException {
        int i;
        int i2;
        AMap.InfoWindowAdapter infoWindowAdapter;
        if (akVar == null) {
            return;
        }
        if (akVar.getTitle() == null && akVar.getSnippet() == null) {
            return;
        }
        d();
        Marker marker = new Marker(akVar);
        AMap.InfoWindowAdapter infoWindowAdapter2 = this.T;
        if (infoWindowAdapter2 != null) {
            this.R = infoWindowAdapter2.getInfoWindow(marker);
        }
        try {
            if (this.W == null) {
                this.W = bm.a(this.n, "infowindow_bg2d.9.png");
            }
        } catch (Exception e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "showInfoWindow");
        }
        if (this.R == null && (infoWindowAdapter = this.T) != null) {
            this.R = infoWindowAdapter.getInfoContents(marker);
        }
        View view = this.R;
        if (view != null) {
            if (view.getBackground() == null) {
                this.R.setBackgroundDrawable(this.W);
            }
        } else {
            LinearLayout linearLayout = new LinearLayout(this.n);
            linearLayout.setBackgroundDrawable(this.W);
            TextView textView = new TextView(this.n);
            textView.setText(akVar.getTitle());
            textView.setTextColor(-16777216);
            TextView textView2 = new TextView(this.n);
            textView2.setTextColor(-16777216);
            textView2.setText(akVar.getSnippet());
            linearLayout.setOrientation(1);
            linearLayout.addView(textView);
            linearLayout.addView(textView2);
            this.R = linearLayout;
        }
        ViewGroup.LayoutParams layoutParams = this.R.getLayoutParams();
        this.R.setDrawingCacheEnabled(true);
        this.R.setDrawingCacheQuality(0);
        ab abVarB = akVar.b();
        if (layoutParams != null) {
            int i3 = layoutParams.width;
            i2 = layoutParams.height;
            i = i3;
        } else {
            i = -2;
            i2 = -2;
        }
        bd.a aVar = new bd.a(i, i2, akVar.getRealPosition(), (-((int) abVarB.f2610a)) + (akVar.getWidth() / 2), (-((int) abVarB.b)) + 2, 81);
        this.U = (bh) akVar;
        bd bdVar = this.g;
        if (bdVar != null) {
            bdVar.addView(this.R, aVar);
        }
    }

    private void b(int i, int i2) {
        if (this.aq == null) {
            return;
        }
        this.aG = i;
        this.aH = i2;
        B();
    }

    private boolean b(MotionEvent motionEvent) {
        boolean zA = false;
        try {
            zA = this.as.a(motionEvent, getWidth(), getHeight());
            if (!zA) {
                zA = this.ar.onTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 1 && this.ad) {
                u.a().b();
            }
            if (motionEvent.getAction() == 2) {
                a(motionEvent);
            }
            if (motionEvent.getAction() == 1) {
                y();
            }
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "handleTouch");
        }
        return zA;
    }

    public final boolean b(float f) {
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "onScale");
        }
        d(f);
        return false;
    }

    public final PointF b(PointF pointF) {
        PointF pointF2 = new PointF();
        int width = getWidth();
        int height = getHeight();
        int i = width >> 1;
        float f = pointF.x - i;
        int i2 = height >> 1;
        double d = pointF.y - i2;
        double d2 = f;
        double dAtan2 = Math.atan2(d, d2);
        double dSqrt = Math.sqrt(Math.pow(d2, 2.0d) + Math.pow(d, 2.0d));
        double d3 = dAtan2 + 0.0d;
        pointF2.x = (float) ((Math.cos(d3) * dSqrt) + ((double) i));
        pointF2.y = (float) ((dSqrt * Math.sin(d3)) + ((double) i2));
        return pointF2;
    }

    @Override // com.amap.api.col.p0002sl.ah
    public final void b(int i, int i2, ab abVar) {
        abVar.f2610a = aa.a(i);
        abVar.b = aa.a(i2);
    }

    @Override // com.amap.api.col.p0002sl.ah
    public final void b(double d, double d2, an anVar) {
        if (this.O == null) {
            return;
        }
        getZoomLevel();
        af afVar = new af((int) aa.a(d), (int) aa.a(d2));
        be beVar = this.O;
        PointF pointFA = beVar.a(afVar, beVar.l, beVar.n, beVar.k);
        if (anVar != null) {
            anVar.f2618a = (int) pointFA.x;
            anVar.b = (int) pointFA.y;
        }
    }

    @Override // com.amap.api.col.p0002sl.ah
    public final void a(int i, int i2) {
        cl clVar = this.E;
        if (clVar != null) {
            clVar.a(i, i2, getMapWidth(), getMapHeight());
            this.E.postInvalidate();
            if (this.F.getVisibility() == 0) {
                this.F.postInvalidate();
            }
        }
    }

    private void a(Context context) {
        z.b = fr.c(context);
        this.n = context;
        try {
            this.am = new r(this.n, this);
            this.aa = new br(this);
            setBackgroundColor(Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 214));
            w.a().a(this);
            u.a().a(this);
            this.I = new l(this);
            this.A = new o(this);
            this.M = new t(context);
            this.i = new cd(this.n, this);
            this.f2987a = new bi(this.n, this, z.j);
            this.i.c();
            bi biVar = this.f2987a;
            this.O = biVar.h;
            this.b = new az(biVar);
            this.h = new ci(this);
            this.f = new cm(this.n, this.b, this);
            this.g = new bd(this.n, this);
            this.y = new ay(this.n, this);
            this.E = new cl(this.n);
            this.F = new bt(this.n, this);
            this.H = new y(this.n, this.e, this);
            this.j = new bc(this.n, this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            u();
            this.g.addView(this.i, layoutParams);
            this.g.addView(this.E, layoutParams);
            this.g.addView(this.F, layoutParams);
            this.g.addView(this.j, new bd.a(layoutParams));
            this.g.addView(this.f, new bd.a(-2, -2, new LatLng(0.0d, 0.0d), 0, 0, 83));
            this.g.addView(this.y, new bd.a(-2, -2, new LatLng(0.0d, 0.0d), 0, 0, 83));
            try {
                if (!b().isMyLocationButtonEnabled()) {
                    this.y.setVisibility(8);
                }
            } catch (RemoteException e) {
                ct.a(e, "AMapDelegateImpGLSurfaceView", "initEnviornment");
            }
            this.H.setVisibility(8);
            this.g.addView(this.H, new bd.a(-2, -2, new LatLng(0.0d, 0.0d), 0, 0, 51));
            this.D = new bl(this, this.n);
            this.f.setId(s.f3047a);
            this.am.setName("AuthThread");
            this.am.start();
            if (this.al == null) {
                Timer timer = new Timer();
                this.al = timer;
                timer.schedule(this.an, 10000L, 1000L);
            }
            this.G = new n(this.n);
        } catch (Throwable th) {
            ct.a(th, "AMapDelegateImpGLSurfaceView", "initEnviornment");
        }
    }

    private void a(boolean z) {
        if (v() == z || this.f2987a == null) {
            return;
        }
        if (!z) {
            a().e.a(a().e.h, false);
            a().e.a(a().e.g, true);
            a().c.a(false);
            return;
        }
        if (a().e.b(a().e.h) != null) {
            a().e.a(a().e.h, true);
            a().c.a(false);
            return;
        }
        aw awVar = new aw(this.O);
        awVar.q = new ce(this.f2987a, awVar);
        awVar.j = new cj() { // from class: com.amap.api.col.2sl.m.4
            @Override // com.amap.api.col.p0002sl.cj
            public final String a(int i, int i2, int i3) {
                StringBuilder sb = new StringBuilder();
                bg.a();
                sb.append(bg.e());
                sb.append("/appmaptile?z=");
                sb.append(i3);
                sb.append("&x=");
                sb.append(i);
                sb.append("&y=");
                sb.append(i2);
                sb.append("&lang=zh_cn&size=1&scale=1&style=6");
                return sb.toString();
            }
        };
        awVar.b = a().e.h;
        awVar.e = true;
        awVar.a(true);
        awVar.f = true;
        awVar.c = z.c;
        awVar.d = z.d;
        a().e.a(awVar, this.n);
        a().e.a(a().e.h, true);
        a().c.a(false);
    }

    private void a(MotionEvent motionEvent) {
        if (!this.ac || this.r == null || this.q == null) {
            return;
        }
        int x = (int) motionEvent.getX();
        int y = (int) (motionEvent.getY() - 60.0f);
        ab abVar = new ab();
        a(x, y, abVar);
        LatLng latLng = new LatLng(abVar.b, abVar.f2610a);
        ak akVar = this.r;
        if (akVar == null || !akVar.isDraggable()) {
            return;
        }
        this.r.a(latLng);
        AMap.OnMarkerDragListener onMarkerDragListener = this.ae;
        if (onMarkerDragListener != null) {
            onMarkerDragListener.onMarkerDrag(this.q);
        }
    }

    private LatLng a(LatLng latLng) {
        an anVar = new an();
        b(latLng.latitude, latLng.longitude, anVar);
        anVar.b -= 60;
        ab abVar = new ab();
        a(anVar.f2618a, anVar.b, abVar);
        return new LatLng(abVar.b, abVar.f2610a);
    }

    @Override // com.amap.api.col.2sl.bk.b
    public final boolean a(float f, float f2) {
        az azVar = this.b;
        if (azVar != null) {
            azVar.g();
        }
        if (this.aA) {
            this.aB += f;
            this.aC += f2;
        }
        postInvalidate();
        return this.aA;
    }

    public final boolean a(Matrix matrix) {
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "onScale");
        }
        this.ay.set(matrix);
        postInvalidate();
        return true;
    }

    public final PointF a(PointF pointF) {
        PointF pointF2 = new PointF();
        int width = getWidth();
        int height = getHeight();
        int i = width >> 1;
        float f = pointF.x - i;
        int i2 = height >> 1;
        double d = pointF.y - i2;
        double d2 = f;
        double dAtan2 = Math.atan2(d, d2);
        double dSqrt = Math.sqrt(Math.pow(d2, 2.0d) + Math.pow(d, 2.0d));
        double d3 = dAtan2 - 0.0d;
        pointF2.x = (float) ((Math.cos(d3) * dSqrt) + ((double) i));
        pointF2.y = (float) ((dSqrt * Math.sin(d3)) + ((double) i2));
        return pointF2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CameraPosition cameraPosition) {
        if (this.L != null && this.M.a() && isEnabled()) {
            if (cameraPosition == null) {
                try {
                    cameraPosition = getCameraPosition();
                } catch (RemoteException e) {
                    ct.a(e, "AMapDelegateImpGLSurfaceView", "cameraChangeFinish");
                }
            }
            try {
                this.L.onCameraChangeFinish(cameraPosition);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.col.p0002sl.ah
    public final void a(int i, int i2, ab abVar) {
        PointF pointF = new PointF(i, i2);
        be beVar = this.O;
        af afVarA = beVar.a(pointF, beVar.l, beVar.n, beVar.k, beVar.o);
        double dA = aa.a(afVarA.b());
        double dA2 = aa.a(afVarA.a());
        abVar.b = dA;
        abVar.f2610a = dA2;
    }

    private void a(int i, int i2, an anVar) {
        getZoomLevel();
        PointF pointF = new PointF(i, i2);
        be beVar = this.O;
        af afVarA = beVar.a(pointF, beVar.l, beVar.n, beVar.k, beVar.o);
        anVar.f2618a = (int) afVarA.e();
        anVar.b = (int) afVarA.f();
    }

    @Override // com.amap.api.col.p0002sl.ah
    public final void a(double d, double d2, ab abVar) {
        getZoomLevel();
        af afVar = new af((int) aa.a(d), (int) aa.a(d2));
        be beVar = this.O;
        PointF pointFA = beVar.a(afVar, beVar.l, beVar.n, beVar.k);
        abVar.f2610a = pointFA.x;
        abVar.b = pointFA.y;
    }

    @Override // com.amap.api.col.p0002sl.ah
    public final void a(double d, double d2, an anVar) {
        if (this.O == null) {
            return;
        }
        af afVarB = be.b(new af((int) (d * 1000000.0d), (int) (d2 * 1000000.0d)));
        anVar.f2618a = afVarB.a();
        anVar.b = afVarB.b();
    }

    public final void a(MapCameraMessage mapCameraMessage, boolean z, long j) {
        int i;
        int i2;
        float fFloatValue;
        if (this.b == null) {
            return;
        }
        try {
            LatLngBounds latLngBounds = mapCameraMessage.bounds;
            if (latLngBounds != null && latLngBounds.northeast != null && latLngBounds.southwest != null) {
                if (mapCameraMessage.width == 0) {
                    mapCameraMessage.width = bi.c.c();
                }
                if (mapCameraMessage.height == 0) {
                    mapCameraMessage.height = bi.c.d();
                }
                LatLng latLng = latLngBounds.northeast;
                double d = latLng.latitude * 1000000.0d;
                LatLng latLng2 = latLngBounds.southwest;
                float f = (float) (d - (latLng2.latitude * 1000000.0d));
                float f2 = (float) ((latLng.longitude * 1000000.0d) - (latLng2.longitude * 1000000.0d));
                float f3 = f == 0.0f ? 1.0f : f;
                float f4 = f2 == 0.0f ? 1.0f : f2;
                Pair<Float, Boolean> pairA = this.b.a(f3, f4, mapCameraMessage.width, mapCameraMessage.height, mapCameraMessage.paddingLeft + mapCameraMessage.paddingRight, mapCameraMessage.paddingTop + mapCameraMessage.paddingBottom);
                if (pairA != null) {
                    fFloatValue = ((Float) pairA.first).floatValue();
                    ((Boolean) pairA.second).booleanValue();
                    an anVar = new an();
                    LatLng latLng3 = latLngBounds.northeast;
                    b(latLng3.latitude, latLng3.longitude, anVar);
                    an anVar2 = new an();
                    LatLng latLng4 = latLngBounds.southwest;
                    b(latLng4.latitude, latLng4.longitude, anVar2);
                    int iAbs = Math.abs(anVar.f2618a - anVar2.f2618a);
                    int iAbs2 = Math.abs(anVar2.b - anVar.b);
                    if (iAbs2 == 0) {
                        iAbs2 = 1;
                    }
                    if (iAbs == 0) {
                        iAbs = 1;
                    }
                    int iA = (int) a(getZoomLevel(), fFloatValue, iAbs);
                    int iA2 = (int) a(getZoomLevel(), fFloatValue, iAbs2);
                    LatLng latLng5 = latLngBounds.southwest;
                    i = (int) ((latLng5.latitude * 1000000.0d) + ((double) ((((mapCameraMessage.paddingTop - mapCameraMessage.paddingBottom) + iA2) * f3) / (iA2 * 2))));
                    i2 = (int) ((latLng5.longitude * 1000000.0d) + ((double) ((((mapCameraMessage.paddingRight - mapCameraMessage.paddingLeft) + iA) * f4) / (iA * 2))));
                } else {
                    LatLng latLng6 = latLngBounds.northeast;
                    double d2 = latLng6.latitude * 1000000.0d;
                    LatLng latLng7 = latLngBounds.southwest;
                    i = (int) ((d2 + (latLng7.latitude * 1000000.0d)) / 2.0d);
                    i2 = (int) (((latLng6.longitude * 1000000.0d) + (latLng7.longitude * 1000000.0d)) / 2.0d);
                    fFloatValue = -1.0f;
                }
                af afVar = new af(i, i2);
                if (z) {
                    this.b.a(afVar, (int) j);
                } else {
                    this.b.a(afVar);
                }
                if (fFloatValue != -1.0f) {
                    this.b.a(fFloatValue);
                }
            }
        } catch (Exception e) {
            ct.a(e, "AMapDelegateImpGLSurfaceView", "newLatLngBoundsWithSize");
        }
    }

    private static float a(float f, float f2, double d) {
        return (float) (d / Math.pow(2.0d, f - f2));
    }
}
