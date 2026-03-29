package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.LruCache;
import com.baidu.mapapi.map.BackgroundDrawMapView;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class a extends com.baidu.mapapi.map.b<Bundle> implements IBackgroundDrawBaseRouteLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f3721a;
    private Path b;
    private Point c;
    private Paint d;
    private int e;
    private int f;
    private int g;
    private final LruCache<String, b> h;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f3722a;
        private final float b;

        public b(float f, float f2) {
            this.f3722a = f;
            this.b = f2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3722a == bVar.f3722a && this.b == bVar.b;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3722a) + Float.floatToIntBits(this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bundle f3723a;

        private c() {
        }

        public void a(Bundle bundle) {
            this.f3723a = bundle;
        }

        public int[] b() {
            Bundle bundle = this.f3723a;
            if (bundle == null) {
                return null;
            }
            return bundle.getIntArray("allPtX");
        }

        public int[] c() {
            Bundle bundle = this.f3723a;
            if (bundle == null) {
                return null;
            }
            return bundle.getIntArray("allPtY");
        }

        public boolean d() {
            Bundle bundle = this.f3723a;
            return bundle != null && bundle.getInt("bIsClosedRegion", 0) == 1;
        }

        public boolean e() {
            return this.f3723a != null;
        }

        public void f() {
            this.f3723a = null;
        }

        public double a() {
            Bundle bundle = this.f3723a;
            if (bundle == null) {
                return 0.0d;
            }
            return bundle.getDouble("ulWidth", 0.0d);
        }
    }

    public a(Context context) {
        super(context);
        this.e = Color.parseColor("#EFEEE9");
        this.f = Color.parseColor("#9B9B9B");
        this.g = Color.parseColor("#9B9B9B");
        this.h = new LruCache<>(2097152);
    }

    private void a(BackgroundDrawMapView.CanvasProxy canvasProxy) {
        canvasProxy.drawColor(this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(BackgroundDrawMapView.CanvasProxy canvasProxy) {
        int size;
        c cVar;
        MapController mapController;
        com.baidu.platform.comapi.map.MapStatus mapStatus;
        int length;
        Bundle bundle = (Bundle) this.mEntity;
        if (bundle == null || (size = bundle.size()) <= 0 || (cVar = this.f3721a) == null || (mapController = this.mController) == null || (mapStatus = mapController.getMapStatus()) == null) {
            return;
        }
        this.h.evictAll();
        char c2 = 0;
        int i = 0;
        while (i < size && getLife() != 2) {
            cVar.a(bundle.getBundle(String.valueOf(i)));
            if (cVar.e()) {
                float fA = (float) cVar.a();
                boolean zD = cVar.d();
                if (zD || fA > 0.0f) {
                    if (zD) {
                        fA = 0.0f;
                    }
                    int[] iArrB = cVar.b();
                    int[] iArrC = cVar.c();
                    if (iArrB != null && iArrC != null && (length = iArrB.length) >= 2 && length == iArrC.length) {
                        this.b.reset();
                        b bVarA = a(iArrB[c2], iArrC[c2], mapStatus);
                        this.b.moveTo(bVarA.f3722a, bVarA.b);
                        for (int i2 = 1; i2 < length; i2++) {
                            if (getLife() == 2) {
                                return;
                            }
                            b bVarA2 = a(iArrB[i2], iArrC[i2], mapStatus);
                            this.b.lineTo(bVarA2.f3722a, bVarA2.b);
                        }
                        this.d.setStrokeWidth(fA);
                        this.d.setColor(this.f);
                        this.d.setStyle(Paint.Style.STROKE);
                        if (zD) {
                            this.d.setColor(this.g);
                            this.d.setStyle(Paint.Style.FILL);
                        }
                        canvasProxy.drawPath(this.b, this.d);
                        cVar.f();
                    }
                }
            }
            i++;
            c2 = 0;
        }
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onCreate() {
        super.onCreate();
        this.f3721a = new c();
        this.c = new Point(-1, -1);
        this.b = new Path();
        this.d = new Paint();
    }

    @Override // com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDraw(BackgroundDrawMapView.CanvasProxy canvasProxy) {
        com.baidu.platform.comapi.map.MapStatus mapStatus;
        MapStatus.WinRound winRound;
        int i;
        float f;
        int iMin;
        MapController mapController = this.mController;
        if (mapController == null || (mapStatus = mapController.getMapStatus()) == null || (winRound = mapStatus.winRound) == null) {
            return;
        }
        int iAbs = Math.abs(winRound.right - winRound.left);
        int iAbs2 = Math.abs(winRound.bottom - winRound.top);
        if (iAbs2 <= 0 || iAbs <= 0 || this.mWidth <= 0 || this.mHeight <= 0) {
            return;
        }
        canvasProxy.save();
        canvasProxy.translate((this.mWidth - iAbs) / 2.0f, (this.mHeight - iAbs2) / 2.0f);
        int i2 = this.mWidth;
        if (i2 != iAbs && (i = this.mHeight) != iAbs2) {
            if (i2 >= iAbs && i >= iAbs2) {
                iMin = Math.min(i2 / iAbs, i / iAbs2);
            } else if (i2 > iAbs || i > iAbs2) {
                f = i2 <= iAbs ? i / iAbs2 : i2 / iAbs;
                canvasProxy.scale(f, f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            } else {
                iMin = Math.min(iAbs / i2, iAbs2 / i);
            }
            f = iMin;
            canvasProxy.scale(f, f, this.mWidth / 2.0f, this.mHeight / 2.0f);
        }
        a(canvasProxy);
        b(canvasProxy);
        canvasProxy.restore();
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setBackgroundColor(int i) {
        this.e = this.mContext.getResources().getColor(i);
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setRouteColor(int i) {
        setRouteLineColor(i);
        setRouteSurfaceColor(i);
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setRouteLineColor(int i) {
        this.f = this.mContext.getResources().getColor(i);
    }

    @Override // com.baidu.mapapi.map.IBackgroundDrawBaseRouteLayer
    public void setRouteSurfaceColor(int i) {
        this.g = this.mContext.getResources().getColor(i);
    }

    private b a(int i, int i2, com.baidu.platform.comapi.map.MapStatus mapStatus) {
        String str = i + "," + i2;
        LruCache<String, b> lruCache = this.h;
        b bVar = lruCache != null ? lruCache.get(str) : null;
        if (bVar == null) {
            toScreenLocation(i, i2, this.c);
            Point point = this.c;
            bVar = new b(point.x, point.y);
            if (lruCache != null) {
                lruCache.put(str, bVar);
            }
        }
        return bVar;
    }
}
