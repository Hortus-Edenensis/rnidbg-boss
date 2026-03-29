package com.amap.api.col.p0002sl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bn implements ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ah f2654a;
    private String d;
    private float e;
    private int f;
    private int g;
    private List<LatLng> h;
    private float b = 0.0f;
    private boolean c = true;
    private List<an> i = new ArrayList();
    private LatLngBounds j = null;

    public bn(ah ahVar) {
        this.f2654a = ahVar;
        try {
            this.d = getId();
        } catch (RemoteException e) {
            ct.a(e, "PolygonDelegateImp", "PolygonDelegateImp");
        }
    }

    private void a(List<LatLng> list) throws RemoteException {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        this.i.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (latLng != null && !latLng.equals(obj)) {
                    an anVar = new an();
                    this.f2654a.a(latLng.latitude, latLng.longitude, anVar);
                    this.i.add(anVar);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.i.size();
            if (size > 1) {
                an anVar2 = this.i.get(0);
                int i = size - 1;
                an anVar3 = this.i.get(i);
                if (anVar2.f2618a == anVar3.f2618a && anVar2.b == anVar3.b) {
                    this.i.remove(i);
                }
            }
        }
        this.j = builder.build();
    }

    private List<LatLng> b() throws RemoteException {
        if (this.i == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (an anVar : this.i) {
            if (anVar != null) {
                ab abVar = new ab();
                this.f2654a.b(anVar.f2618a, anVar.b, abVar);
                arrayList.add(new LatLng(abVar.b, abVar.f2610a));
            }
        }
        return arrayList;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public final boolean contains(LatLng latLng) throws RemoteException {
        return ct.a(latLng, getPoints());
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.amap.api.interfaces.IPolygon
    public final int getFillColor() throws RemoteException {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.d == null) {
            this.d = ae.a("Polygon");
        }
        return this.d;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public final List<LatLng> getPoints() throws RemoteException {
        return b();
    }

    @Override // com.amap.api.interfaces.IPolygon
    public final int getStrokeColor() throws RemoteException {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public final float getStrokeWidth() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.b;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final boolean isVisible() throws RemoteException {
        return this.c;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void remove() throws RemoteException {
        this.f2654a.removeGLOverlay(getId());
    }

    @Override // com.amap.api.interfaces.IPolygon
    public final void setFillColor(int i) throws RemoteException {
        this.f = i;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public final void setPoints(List<LatLng> list) throws RemoteException {
        this.h = list;
        a(list);
    }

    @Override // com.amap.api.interfaces.IPolygon
    public final void setStrokeColor(int i) throws RemoteException {
        this.g = i;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public final void setStrokeWidth(float f) throws RemoteException {
        this.e = f;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void setVisible(boolean z) throws RemoteException {
        this.c = z;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void setZIndex(float f) throws RemoteException {
        this.b = f;
        this.f2654a.postInvalidate();
    }

    @Override // com.amap.api.col.p0002sl.am
    public final boolean a() {
        if (this.j == null) {
            return false;
        }
        LatLngBounds mapBounds = this.f2654a.getMapBounds();
        return mapBounds == null || this.j.contains(mapBounds) || this.j.intersects(mapBounds);
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void destroy() {
    }

    @Override // com.amap.api.col.p0002sl.am
    public final void a(Canvas canvas) throws RemoteException {
        List<an> list = this.i;
        if (list == null || list.size() == 0) {
            return;
        }
        Path path = new Path();
        Point pointA = this.f2654a.c().a(new af(this.i.get(0).b, this.i.get(0).f2618a), new Point());
        path.moveTo(pointA.x, pointA.y);
        for (int i = 1; i < this.i.size(); i++) {
            Point pointA2 = this.f2654a.c().a(new af(this.i.get(i).b, this.i.get(i).f2618a), new Point());
            path.lineTo(pointA2.x, pointA2.y);
        }
        Paint paint = new Paint();
        paint.setColor(getFillColor());
        paint.setAntiAlias(true);
        path.close();
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getStrokeColor());
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawPath(path, paint);
    }
}
