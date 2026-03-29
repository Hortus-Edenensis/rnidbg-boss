package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.util.MapTaskManager;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class j implements SurfaceRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4209a = false;
    private u d;
    private WeakReference<MapSurfaceView> e;
    private WeakReference<MapTextureView> f;
    private CaptureMapViewListener g;
    private int i;
    private int j;
    private int k;
    private int l;
    private Bitmap.Config m;
    private d n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    public int v;
    public int w;
    private AppBaseMap b = null;
    private boolean c = false;
    private volatile boolean h = false;
    private long s = 0;
    private boolean t = false;
    private volatile boolean u = false;
    public int x = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MapSurfaceView f4210a;

        public a(MapSurfaceView mapSurfaceView) {
            this.f4210a = mapSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            MapSurfaceView mapSurfaceView = this.f4210a;
            if (mapSurfaceView != null) {
                mapSurfaceView.setBackgroundResource(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f4211a;

        public b(Bitmap bitmap) {
            this.f4211a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.g.onCompleted(this.f4211a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f4212a;

        public c(Bitmap bitmap) {
            this.f4212a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.g.onCompleted(this.f4212a);
        }
    }

    public j(WeakReference<MapSurfaceView> weakReference, u uVar) {
        this.d = uVar;
        this.e = weakReference;
    }

    public void b() {
        this.u = true;
    }

    public void c() {
        this.u = false;
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onDrawFrame(Object obj) {
        List<v> list;
        List<v> list2;
        d dVar;
        MapTextureView mapTextureView;
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        if (a()) {
            if (!this.t) {
                this.t = true;
                WeakReference<MapSurfaceView> weakReference = this.e;
                if (weakReference != null && (mapSurfaceView2 = weakReference.get()) != null) {
                    try {
                        mapSurfaceView2.post(new a(mapSurfaceView2));
                    } catch (Exception unused) {
                    }
                }
            }
            if (f4209a) {
                f4209a = false;
                return;
            }
            if (this.u) {
                return;
            }
            int iDraw = this.b.Draw();
            WeakReference<MapSurfaceView> weakReference2 = this.e;
            if (weakReference2 != null && (mapSurfaceView = weakReference2.get()) != null) {
                if (iDraw == 1) {
                    mapSurfaceView.requestRender();
                } else if (mapSurfaceView.getRenderMode() != 0) {
                    mapSurfaceView.setRenderMode(0);
                }
            }
            WeakReference<MapTextureView> weakReference3 = this.f;
            if (weakReference3 != null && (mapTextureView = weakReference3.get()) != null) {
                if (iDraw == 1) {
                    mapTextureView.requestRender();
                } else if (mapTextureView.getRenderMode() != 0) {
                    mapTextureView.setRenderMode(0);
                }
            }
            if (this.h) {
                this.h = false;
                if (this.g != null) {
                    a(obj);
                }
            }
            if (!this.o) {
                int i = this.p + 1;
                this.p = i;
                if (i == 2 && (dVar = this.n) != null) {
                    dVar.a();
                    if (OpenLogUtil.isMapLogEnable()) {
                        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onDrawFirstFrame");
                    }
                }
                this.o = this.p == 2;
            }
            WeakReference<MapSurfaceView> weakReference4 = this.e;
            com.baidu.mapsdkplatform.comapi.map.b baseMap = (weakReference4 == null || weakReference4.get() == null) ? null : this.e.get().getBaseMap();
            if (baseMap != null && (list2 = baseMap.v) != null) {
                for (v vVar : list2) {
                    com.baidu.mapsdkplatform.comapi.map.s sVarN = baseMap.n();
                    if (vVar != null) {
                        vVar.a((GL10) null, sVarN);
                    }
                }
            }
            WeakReference<MapTextureView> weakReference5 = this.f;
            com.baidu.mapsdkplatform.comapi.map.b baseMap2 = (weakReference5 == null || weakReference5.get() == null) ? null : this.f.get().getBaseMap();
            if (baseMap2 == null || (list = baseMap2.v) == null) {
                return;
            }
            for (v vVar2 : list) {
                com.baidu.mapsdkplatform.comapi.map.s sVarN2 = baseMap2.n();
                if (vVar2 != null) {
                    vVar2.a((GL10) null, sVarN2);
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceChanged(int i, int i2) {
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap != null) {
            appBaseMap.renderResize(i, i2);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onSurfaceChanged width = " + i + "; height = " + i2);
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceCreated(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.o = false;
        this.p = 0;
        this.r = 0;
        this.q = 0;
        if (a()) {
            this.b.renderInit(i, i2, surfaceHolder != null ? surfaceHolder.getSurface() : null, i3);
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onSurfaceCreated ok");
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.SurfaceRenderer
    public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
        Surface surface = surfaceHolder != null ? surfaceHolder.getSurface() : null;
        AppBaseMap appBaseMap = this.b;
        if (appBaseMap != null) {
            appBaseMap.surfaceDestroyed(surface);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap onSurfaceDestroyed");
        }
    }

    public void a(AppBaseMap appBaseMap) {
        this.b = appBaseMap;
    }

    public void a(boolean z) {
        this.c = z;
    }

    private boolean a() {
        return this.b != null && this.c;
    }

    private void a(Object obj) {
        MapTextureView mapTextureView;
        int i;
        int i2;
        MapSurfaceView mapSurfaceView;
        int i3;
        int i4;
        if (this.g == null) {
            return;
        }
        WeakReference<MapSurfaceView> weakReference = this.e;
        if (weakReference != null && (mapSurfaceView = weakReference.get()) != null && (i3 = this.i) > 0 && (i4 = this.j) > 0) {
            MapTaskManager.postToMainThread(new b(mapSurfaceView.captureImageFromSurface(this.k, this.l, i3, i4, obj, this.m)), 0L);
        }
        WeakReference<MapTextureView> weakReference2 = this.f;
        if (weakReference2 == null || (mapTextureView = weakReference2.get()) == null || (i = this.i) <= 0 || (i2 = this.j) <= 0) {
            return;
        }
        MapTaskManager.postToMainThread(new c(mapTextureView.captureImageFromSurface(this.k, this.l, i, i2, obj, this.m)), 0L);
    }

    public j(MapTextureView mapTextureView, u uVar) {
        this.f = new WeakReference<>(mapTextureView);
        this.d = uVar;
    }

    public void a(CaptureMapViewListener captureMapViewListener, int i, int i2) {
        this.h = true;
        this.g = captureMapViewListener;
        this.i = i;
        this.j = i2;
        this.m = null;
    }

    public void a(CaptureMapViewListener captureMapViewListener, int i, int i2, Bitmap.Config config) {
        this.h = true;
        this.g = captureMapViewListener;
        this.i = i;
        this.j = i2;
        this.m = config;
    }

    public void a(CaptureMapViewListener captureMapViewListener, int i, int i2, int i3, int i4, Bitmap.Config config) {
        this.h = true;
        this.g = captureMapViewListener;
        this.k = i;
        this.l = i2;
        this.i = i3;
        this.j = i4;
        this.m = config;
    }

    public void a(d dVar) {
        this.n = dVar;
    }
}
