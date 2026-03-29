package com.amap.api.col.p0002sl;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bo implements ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ah f2655a;
    private String h;
    private float b = 10.0f;
    private int c = -16777216;
    private float d = 0.0f;
    private boolean e = true;
    private boolean f = false;
    private boolean g = false;
    private List<an> i = new ArrayList();
    private List<LatLng> j = new ArrayList();
    private LatLngBounds k = null;

    public bo(ah ahVar) {
        this.f2655a = ahVar;
        try {
            this.h = getId();
        } catch (RemoteException e) {
            ct.a(e, "PolylineDelegateImp", "PolylineDelegateImp");
        }
    }

    private void a(List<LatLng> list) throws RemoteException {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                LatLngBounds.Builder builder = LatLngBounds.builder();
                this.i.clear();
                LatLng latLng = null;
                for (int i = 0; i < list.size(); i++) {
                    LatLng latLng2 = list.get(i);
                    if (latLng2 != null && !latLng2.equals(latLng)) {
                        if (!this.g) {
                            an anVar = new an();
                            this.f2655a.a(latLng2.latitude, latLng2.longitude, anVar);
                            this.i.add(anVar);
                            builder.include(latLng2);
                        } else if (latLng != null) {
                            if (Math.abs(latLng2.longitude - latLng.longitude) < 0.01d) {
                                an anVar2 = new an();
                                this.f2655a.a(latLng.latitude, latLng.longitude, anVar2);
                                this.i.add(anVar2);
                                builder.include(latLng);
                                an anVar3 = new an();
                                this.f2655a.a(latLng2.latitude, latLng2.longitude, anVar3);
                                this.i.add(anVar3);
                                builder.include(latLng2);
                            } else {
                                a(latLng, latLng2, this.i, builder);
                            }
                        }
                        latLng = latLng2;
                    }
                }
                if (this.i.size() > 0) {
                    this.k = builder.build();
                }
            } catch (Throwable th) {
                ct.a(th, "PolylineDelegateImp", "calLatLng2Geo");
            }
        }
    }

    private List<LatLng> b() throws RemoteException {
        if (this.i == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (an anVar : this.i) {
            if (anVar != null) {
                ab abVar = new ab();
                this.f2655a.b(anVar.f2618a, anVar.b, abVar);
                arrayList.add(new LatLng(abVar.b, abVar.f2610a));
            }
        }
        return arrayList;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.amap.api.interfaces.IPolyline
    public final int getColor() throws RemoteException {
        return this.c;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.h == null) {
            this.h = ae.a("Polyline");
        }
        return this.h;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public final List<LatLng> getPoints() throws RemoteException {
        return (this.g || this.f) ? this.j : b();
    }

    @Override // com.amap.api.interfaces.IPolyline
    public final float getWidth() throws RemoteException {
        return this.b;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.d;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    @Override // com.amap.api.interfaces.IPolyline
    public final boolean isDottedLine() {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public final boolean isGeodesic() {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final boolean isVisible() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void remove() throws RemoteException {
        this.f2655a.removeGLOverlay(getId());
    }

    @Override // com.amap.api.interfaces.IPolyline
    public final void setColor(int i) throws RemoteException {
        this.c = i;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public final void setDottedLine(boolean z) {
        this.f = z;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public final void setGeodesic(boolean z) throws RemoteException {
        if (this.g != z) {
            this.g = z;
        }
    }

    @Override // com.amap.api.interfaces.IPolyline
    public final void setPoints(List<LatLng> list) throws RemoteException {
        if (this.g || this.f) {
            this.j = list;
        }
        a(list);
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void setVisible(boolean z) throws RemoteException {
        this.e = z;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public final void setWidth(float f) throws RemoteException {
        this.b = f;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void setZIndex(float f) throws RemoteException {
        this.d = f;
        this.f2655a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void destroy() {
    }

    @Override // com.amap.api.col.p0002sl.am
    public final boolean a() {
        if (this.k == null) {
            return false;
        }
        LatLngBounds mapBounds = this.f2655a.getMapBounds();
        return mapBounds == null || mapBounds.contains(this.k) || this.k.intersects(mapBounds);
    }

    @Override // com.amap.api.col.p0002sl.am
    public final void a(Canvas canvas) throws RemoteException {
        List<an> list = this.i;
        if (list == null || list.size() == 0 || this.b <= 0.0f) {
            return;
        }
        try {
            Path path = new Path();
            Point pointA = this.f2655a.c().a(new af(this.i.get(0).b, this.i.get(0).f2618a), new Point());
            path.moveTo(pointA.x, pointA.y);
            for (int i = 1; i < this.i.size(); i++) {
                Point pointA2 = this.f2655a.c().a(new af(this.i.get(i).b, this.i.get(i).f2618a), new Point());
                path.lineTo(pointA2.x, pointA2.y);
            }
            Paint paint = new Paint();
            paint.setColor(getColor());
            paint.setAntiAlias(true);
            paint.setStrokeWidth(getWidth());
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            if (this.f) {
                int width = (int) getWidth();
                float f = width * 3;
                float f2 = width;
                paint.setPathEffect(new DashPathEffect(new float[]{f, f2, f, f2}, 1.0f));
            }
            canvas.drawPath(path, paint);
        } catch (Throwable th) {
            ct.a(th, "PolylineDelegateImp", MediationConstant.RIT_TYPE_DRAW);
        }
    }

    private static an a(an anVar, an anVar2, an anVar3, double d, int i) {
        an anVar4 = new an();
        double d2 = anVar2.f2618a - anVar.f2618a;
        double d3 = anVar2.b - anVar.b;
        int iSqrt = (int) (((((double) i) * d) / Math.sqrt(((d3 * d3) / (d2 * d2)) + 1.0d)) + ((double) anVar3.b));
        anVar4.b = iSqrt;
        anVar4.f2618a = (int) (((((double) (anVar3.b - iSqrt)) * d3) / d2) + ((double) anVar3.f2618a));
        return anVar4;
    }

    private static void a(List<an> list, List<an> list2, double d) {
        if (list.size() != 3) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (i2 <= 10) {
            float f = i2;
            float f2 = f / 10.0f;
            an anVar = new an();
            double d2 = 1.0d - ((double) f2);
            double d3 = d2 * d2;
            double d4 = ((double) (2.0f * f2)) * d2;
            float f3 = f2 * f2;
            double d5 = (((double) list.get(i).f2618a) * d3) + (((double) list.get(1).f2618a) * d4 * d) + ((double) (list.get(2).f2618a * f3));
            double d6 = (((double) list.get(i).b) * d3) + (((double) list.get(1).b) * d4 * d) + ((double) (list.get(2).b * f3));
            double d7 = d3 + (d4 * d) + ((double) f3);
            anVar.f2618a = (int) (d5 / d7);
            anVar.b = (int) (d6 / d7);
            list2.add(anVar);
            i2 = (int) (1.0f + f);
            i = 0;
        }
    }

    private void a(LatLng latLng, LatLng latLng2, List<an> list, LatLngBounds.Builder builder) {
        double dAbs = (Math.abs(latLng.longitude - latLng2.longitude) * 3.141592653589793d) / 180.0d;
        LatLng latLng3 = new LatLng((latLng2.latitude + latLng.latitude) / 2.0d, (latLng2.longitude + latLng.longitude) / 2.0d);
        builder.include(latLng).include(latLng3).include(latLng2);
        int i = latLng3.latitude > 0.0d ? 1 : -1;
        an anVar = new an();
        this.f2655a.a(latLng.latitude, latLng.longitude, anVar);
        an anVar2 = new an();
        this.f2655a.a(latLng2.latitude, latLng2.longitude, anVar2);
        an anVar3 = new an();
        this.f2655a.a(latLng3.latitude, latLng3.longitude, anVar3);
        double d = dAbs * 0.5d;
        double dCos = Math.cos(d);
        an anVarA = a(anVar, anVar2, anVar3, Math.hypot(anVar.f2618a - anVar2.f2618a, anVar.b - anVar2.b) * 0.5d * Math.tan(d), i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(anVar);
        arrayList.add(anVarA);
        arrayList.add(anVar2);
        a(arrayList, list, dCos);
    }
}
