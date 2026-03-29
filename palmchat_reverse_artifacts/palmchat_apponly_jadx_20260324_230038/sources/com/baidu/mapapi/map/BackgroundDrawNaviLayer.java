package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer;
import com.baidu.mapapi.map.BackgroundDrawMapView;
import com.baidu.mapapi.map.entity.BackgroundNaviEntity;
import com.baidu.mapapi.map.entity.BackgroundNaviLocEntity;
import com.baidu.mapapi.map.entity.BackgroundNaviRealTimeInfoEntity;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BackgroundDrawNaviLayer extends AbsBackgroundDrawNaviLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f3587a;
    private Paint b;
    private Point c;
    private Path d;
    private Bitmap e;
    private final Object f;
    private Bitmap g;
    private final Object h;
    private Bitmap i;
    private final Object j;
    private volatile a k;
    private volatile a l;
    private volatile a m;
    private volatile double n;
    private volatile boolean o;
    private volatile int p;
    private volatile int q;
    private volatile boolean r;
    private volatile int s;
    private AbsBackgroundDrawNaviLayer.EraseEffect t;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BackgroundNaviRealTimeInfoEntity f3588a;
        private final BackgroundNaviLocEntity b;
        private final double c;
        private final double d;
        private int e = -1;
        private int f = -1;
        private final long g;

        public a(BackgroundNaviRealTimeInfoEntity backgroundNaviRealTimeInfoEntity, BackgroundNaviLocEntity backgroundNaviLocEntity, BackgroundNaviEntity backgroundNaviEntity) {
            ArrayList<LatLng> routeShapePoints;
            this.f3588a = backgroundNaviRealTimeInfoEntity;
            this.b = backgroundNaviLocEntity;
            LatLng latLng = (backgroundNaviEntity == null || (routeShapePoints = backgroundNaviEntity.getRouteShapePoints()) == null || routeShapePoints.isEmpty()) ? null : routeShapePoints.get(0);
            if (latLng != null) {
                this.c = latLng.longitude;
                this.d = latLng.latitude;
            } else {
                this.c = 0.0d;
                this.d = 0.0d;
            }
            this.g = System.currentTimeMillis();
        }

        public void a() {
            if (this.f3588a.isbIsNearOrFarawayStatus()) {
                BackgroundDrawNaviLayer.this.toScreenLocation((int) this.f3588a.getStPosX(), (int) this.f3588a.getStPosY(), BackgroundDrawNaviLayer.this.c);
            } else {
                BackgroundDrawNaviLayer.this.toScreenLocation((int) this.f3588a.getStCurStartPosX(), (int) this.f3588a.getStCurStartPosY(), BackgroundDrawNaviLayer.this.c);
            }
            this.e = BackgroundDrawNaviLayer.this.c.x;
            this.f = BackgroundDrawNaviLayer.this.c.y;
        }

        public boolean a(BackgroundNaviEntity backgroundNaviEntity) {
            ArrayList<LatLng> routeShapePoints;
            if (backgroundNaviEntity == null || (routeShapePoints = backgroundNaviEntity.getRouteShapePoints()) == null || routeShapePoints.isEmpty()) {
                return false;
            }
            LatLng latLng = routeShapePoints.get(0);
            return latLng.latitude == this.d && latLng.longitude == this.c;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3589a;
        private final float b;
        private final float c;

        public b(int i, float f, float f2) {
            this.f3589a = i;
            this.b = f;
            this.c = f2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Float> f3590a;
        private final a b;

        public c(List<Float> list, a aVar) {
            this.f3590a = list;
            this.b = aVar;
        }
    }

    public BackgroundDrawNaviLayer(Context context) {
        super(context, 1);
        this.f = new Object();
        this.h = new Object();
        this.j = new Object();
        this.o = true;
        this.r = false;
        this.p = Color.parseColor("#50D27D");
        this.s = Color.parseColor("#E7F1F6");
        this.q = 10;
        this.t = AbsBackgroundDrawNaviLayer.EraseEffect.NONE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(BackgroundDrawMapView.CanvasProxy canvasProxy, c cVar) {
        ArrayList<LatLng> routeShapePoints;
        int size;
        int i;
        BackgroundNaviEntity backgroundNaviEntity = (BackgroundNaviEntity) this.mEntity;
        if (backgroundNaviEntity == null || (routeShapePoints = backgroundNaviEntity.getRouteShapePoints()) == null || routeShapePoints.isEmpty() || (size = routeShapePoints.size()) < 2) {
            return;
        }
        this.f3587a.setStrokeWidth(this.q);
        b bVarA = a(cVar);
        Point point = null;
        if (this.t == AbsBackgroundDrawNaviLayer.EraseEffect.NONE) {
            bVarA = null;
        }
        if (bVarA != null) {
            i = bVarA.f3589a;
            point = new Point(bVarA.b, bVarA.c);
        } else {
            i = 0;
        }
        int iMin = Math.min(i, size);
        if (iMin > 0 && this.t == AbsBackgroundDrawNaviLayer.EraseEffect.ALREADY_PASSED_CHANGE_COLOR) {
            this.d.reset();
            toScreenLocation(routeShapePoints.get(0), this.c);
            Path path = this.d;
            Point point2 = this.c;
            path.moveTo(point2.x, point2.y);
            for (int i2 = 1; i2 < iMin; i2++) {
                toScreenLocation(routeShapePoints.get(i2), this.c);
                Path path2 = this.d;
                Point point3 = this.c;
                path2.lineTo(point3.x, point3.y);
            }
            if (point != null) {
                this.d.lineTo(point.x, point.y);
            }
            this.f3587a.setColor(this.s);
            canvasProxy.drawPath(this.d, this.f3587a);
        }
        int iMax = Math.max(0, iMin - 1);
        this.d.reset();
        if (point != null) {
            this.d.moveTo(point.x, point.y);
            iMax = Math.max(0, this.l.f3588a.getnCurRouteShapeIdx() - 1);
        } else {
            toScreenLocation(routeShapePoints.get(iMax), this.c);
            Path path3 = this.d;
            Point point4 = this.c;
            path3.moveTo(point4.x, point4.y);
        }
        for (int i3 = iMax + 1; i3 < size; i3++) {
            toScreenLocation(routeShapePoints.get(i3), this.c);
            Path path4 = this.d;
            Point point5 = this.c;
            path4.lineTo(point5.x, point5.y);
        }
        this.f3587a.setColor(this.p);
        canvasProxy.drawPath(this.d, this.f3587a);
        if (this.o) {
            synchronized (this.f) {
                Bitmap bitmap = this.e;
                if (bitmap != null && !bitmap.isRecycled()) {
                    toScreenLocation(routeShapePoints.get(0), this.c);
                    canvasProxy.drawBitmap(bitmap, this.c.x - (bitmap.getWidth() / 2.0f), this.c.y - bitmap.getHeight(), this.b);
                }
            }
            synchronized (this.h) {
                Bitmap bitmap2 = this.g;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    toScreenLocation(routeShapePoints.get(size - 1), this.c);
                    canvasProxy.drawBitmap(bitmap2, this.c.x - (bitmap2.getWidth() / 2.0f), this.c.y - bitmap2.getHeight(), this.b);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0085 A[EXC_TOP_SPLITTER, PHI: r1
      0x0085: PHI (r1v10 java.io.InputStream) = (r1v9 java.io.InputStream), (r1v21 java.io.InputStream) binds: [B:19:0x0083, B:11:0x0074] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.Paint] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.graphics.CornerPathEffect, android.graphics.PathEffect] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.InputStream] */
    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer, com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate() throws Throwable {
        Throwable th;
        InputStream inputStreamOpen;
        super.onCreate();
        Paint paint = new Paint();
        this.f3587a = paint;
        paint.setColor(this.p);
        this.f3587a.setStyle(Paint.Style.STROKE);
        this.f3587a.setStrokeWidth(this.q);
        ?? r0 = this.f3587a;
        ?? cornerPathEffect = new CornerPathEffect(2.5f);
        r0.setPathEffect(cornerPathEffect);
        this.b = new Paint();
        this.d = new Path();
        this.c = new Point();
        try {
            try {
                if (this.e == null) {
                    inputStreamOpen = this.mContext.getAssets().open("SDK_Default_Icon_Start.png");
                    try {
                        this.e = BitmapFactory.decodeStream(inputStreamOpen);
                        inputStreamOpen.close();
                    } catch (IOException unused) {
                        this.e = null;
                        this.g = null;
                        if (inputStreamOpen != null) {
                        }
                    }
                } else {
                    inputStreamOpen = null;
                }
                if (this.g == null) {
                    inputStreamOpen = this.mContext.getAssets().open("SDK_Default_Icon_End.png");
                    this.g = BitmapFactory.decodeStream(inputStreamOpen);
                    inputStreamOpen.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (cornerPathEffect != 0) {
                    try {
                        cornerPathEffect.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException unused3) {
            inputStreamOpen = null;
        } catch (Throwable th3) {
            cornerPathEffect = 0;
            th = th3;
            if (cornerPathEffect != 0) {
            }
            throw th;
        }
        if (inputStreamOpen != null) {
            try {
                inputStreamOpen.close();
            } catch (IOException unused4) {
            }
        }
        synchronized (this.j) {
            if (this.i == null) {
                try {
                    InputStream inputStreamOpen2 = this.mContext.getAssets().open("SDK_Default_Icon_Passenger.png");
                    try {
                        this.i = BitmapFactory.decodeStream(inputStreamOpen2);
                        if (inputStreamOpen2 != null) {
                            inputStreamOpen2.close();
                        }
                    } finally {
                    }
                } catch (IOException unused5) {
                }
            }
        }
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer, com.baidu.mapapi.map.BaseBackgroundDrawLayer, com.baidu.mapapi.map.IBackgroundDrawLayer
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.e;
        Bitmap bitmap2 = this.g;
        Bitmap bitmap3 = this.i;
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            bitmap2.recycle();
        }
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            bitmap3.recycle();
        }
        this.e = null;
        this.g = null;
        this.i = null;
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
        c cVarA = a();
        b(canvasProxy, cVarA);
        a(canvasProxy, cVarA);
        canvasProxy.restore();
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setEraseColor(int i) {
        this.s = this.mContext.getResources().getColor(i);
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setEraseEffect(AbsBackgroundDrawNaviLayer.EraseEffect eraseEffect) {
        this.t = eraseEffect;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setIsLocationDirectionFollowPhone(boolean z) {
        this.r = z;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setIsNeedShowStartAndEndMark(boolean z) {
        this.o = z;
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviEndMark(Bitmap bitmap) {
        synchronized (this.h) {
            Bitmap bitmap2 = this.g;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.g = bitmap;
        }
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviLocationMark(Bitmap bitmap) {
        synchronized (this.j) {
            Bitmap bitmap2 = this.i;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.i = bitmap;
        }
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviRouteColor(int i) {
        this.p = this.mContext.getResources().getColor(i);
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviRouteWidth(int i) {
        this.q = Math.min(30, Math.max(1, i));
    }

    @Override // com.baidu.mapapi.map.AbsBackgroundDrawNaviLayer
    public void setNaviStartMark(Bitmap bitmap) {
        synchronized (this.f) {
            Bitmap bitmap2 = this.e;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.e = bitmap;
        }
    }

    public void updateHeading(double d) {
        this.n = d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateNaviRealTimeInfo(BackgroundNaviRealTimeInfoEntity backgroundNaviRealTimeInfoEntity, BackgroundNaviLocEntity backgroundNaviLocEntity) {
        if (backgroundNaviRealTimeInfoEntity == null || backgroundNaviLocEntity == null) {
            return;
        }
        a aVar = this.l;
        if (aVar != null) {
            BackgroundNaviRealTimeInfoEntity backgroundNaviRealTimeInfoEntity2 = aVar.f3588a;
            BackgroundNaviLocEntity backgroundNaviLocEntity2 = aVar.b;
            if (backgroundNaviLocEntity2.getGpsLatitude() == backgroundNaviLocEntity.getGpsLatitude() && backgroundNaviLocEntity2.getGpsLongitude() == backgroundNaviLocEntity.getPostLongitude()) {
                return;
            }
            if (backgroundNaviRealTimeInfoEntity2.getStPosY() == backgroundNaviRealTimeInfoEntity.getStPosY() && backgroundNaviRealTimeInfoEntity2.getStPosX() == backgroundNaviRealTimeInfoEntity.getStPosX()) {
                return;
            }
        }
        this.k = aVar;
        this.l = new a(backgroundNaviRealTimeInfoEntity, backgroundNaviLocEntity, (BackgroundNaviEntity) this.mEntity);
    }

    private void a(BackgroundDrawMapView.CanvasProxy canvasProxy, c cVar) {
        Bitmap bitmap;
        MapController mapController;
        com.baidu.platform.comapi.map.MapStatus mapStatus;
        List list;
        a aVar = this.l;
        if (aVar == null || (bitmap = this.i) == null || bitmap.isRecycled() || (mapController = this.mController) == null || (mapStatus = mapController.getMapStatus()) == null || cVar == null || (list = cVar.f3590a) == null || list.size() != 2) {
            return;
        }
        float fFloatValue = ((Float) list.get(0)).floatValue();
        float fFloatValue2 = ((Float) list.get(1)).floatValue();
        float gpsDirection = !this.r ? aVar.b.getGpsDirection() - mapStatus.rotation : (float) (this.n - ((double) mapStatus.rotation));
        canvasProxy.save();
        canvasProxy.rotate(gpsDirection, fFloatValue, fFloatValue2);
        canvasProxy.drawBitmap(bitmap, fFloatValue - (bitmap.getWidth() / 2.0f), fFloatValue2 - (bitmap.getHeight() / 2.0f), this.b);
        canvasProxy.restore();
    }

    private c a() {
        a aVar = this.l;
        if (aVar == null) {
            return null;
        }
        aVar.a();
        ArrayList arrayList = new ArrayList(2);
        a aVar2 = this.k;
        if (aVar2 == null) {
            arrayList.add(Float.valueOf(aVar.e));
            arrayList.add(Float.valueOf(aVar.f));
            return new c(arrayList, aVar);
        }
        long j = aVar.g - aVar2.g;
        if (j <= 0) {
            arrayList.add(Float.valueOf(aVar.e));
            arrayList.add(Float.valueOf(aVar.f));
            return new c(arrayList, aVar);
        }
        if (System.currentTimeMillis() - aVar.g >= j) {
            arrayList.add(Float.valueOf(aVar.e));
            arrayList.add(Float.valueOf(aVar.f));
            return new c(arrayList, aVar);
        }
        aVar2.a();
        float f = j;
        arrayList.add(Float.valueOf(aVar2.e + ((((long) (aVar.e - aVar2.e)) * r5) / f)));
        arrayList.add(Float.valueOf(aVar2.f + ((((long) (aVar.f - aVar2.f)) * r5) / f)));
        return new c(arrayList, aVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private b a(c cVar) {
        if (cVar == null) {
            return null;
        }
        List arrayList = cVar.f3590a;
        a aVar = cVar.b;
        if (arrayList == null || aVar == null) {
            return null;
        }
        if ((aVar.f3588a.isbIsNearOrFarawayStatus() || (this.l != null && this.l.f3588a.isbIsNearOrFarawayStatus())) && (aVar = this.m) != null) {
            aVar.a();
            arrayList = new ArrayList(2);
            arrayList.add(Float.valueOf(aVar.e));
            arrayList.add(Float.valueOf(aVar.f));
        }
        if (aVar == null || !aVar.a((BackgroundNaviEntity) this.mEntity)) {
            return null;
        }
        this.m = aVar;
        return new b(aVar.f3588a.getnCurRouteShapeIdx(), ((Float) arrayList.get(0)).floatValue(), ((Float) arrayList.get(1)).floatValue());
    }
}
